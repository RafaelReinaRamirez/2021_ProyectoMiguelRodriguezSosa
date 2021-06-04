package MKStudio.GestionChat.controller;

import MKStudio.GestionChat.ui.VentanaChatVista;
import MKStudio.GestionUsuarios.model.Conversor;
import MKStudio.GestionUsuarios.model.dto.UsuarioDTO;
import MKStudio.GestionUsuarios.repository.ListaUsuario;
import MKStudio.Shared.DataBase.MKStudioJDBC;
import MKStudio.Shared.view.VentanaHomeVista;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.time.LocalTime;

/**
 * Clase controlador del chat con en MultiChatUDP.
 */
public class MultiChatUDP implements Runnable {

    private static final long serialVersionUID = 1L;

    static MulticastSocket ms;
    static byte[] buf = new byte[1000];
    static InetAddress grupo = null;
    boolean repetir = true;
    private int puerto = 12345;
    private VentanaHomeVista ventanaHome;
    private ListaUsuario listaUsuario;
    private MKStudioJDBC mkstudiojdbc = new MKStudioJDBC();
    private Stage dialogStage;
    private UsuarioDTO currentUsuario;
    Conversor conver;
    private VentanaChatVista vista;

    @FXML
    private TextArea areaChat;

    @FXML
    private TextField msgBar;

    @FXML
    private Button botonVolver;


    public MultiChatUDP() throws IOException {
        ms = new MulticastSocket(this.puerto);
        grupo = InetAddress.getByName("225.0.0.1");
        ms.joinGroup(grupo);
        areaChat = new TextArea();
        areaChat.setText("\n");
    }

    public void setListaUsuario() {
        listaUsuario = new ListaUsuario(mkstudiojdbc);
    }

    public void setVentanahome(VentanaHomeVista ventanaHome) {
        setListaUsuario();
        listaUsuario.recuperarUsuarios();
        ventanaHome = new VentanaHomeVista(dialogStage, conver.dtoToVo(currentUsuario), listaUsuario);
        this.ventanaHome = ventanaHome;
    }

    public void setChat() {
        msgBar.setEditable(true);
        try {
            new Thread(this).start();
            areaChat.setText("\n");
            this.Usuariologeado(currentUsuario.getNombre());
        } catch (IOException er) {
            er.printStackTrace();
        }
    }

    /**
     * @throws IOException
     */
    @FXML
    public void volver() throws IOException {
        Usuariosalido(currentUsuario.getNombre());
        setVentanahome(ventanaHome);
        ventanaHome.LaunchHomeView();
        dialogStage.close();
    }

    @Override
    public void run() {
        while (repetir) {
            try {
                DatagramPacket p = new DatagramPacket(buf, buf.length);
                ms.receive(p);
                String texto = new String(p.getData(), 0, p.getLength());
                areaChat.appendText(texto + "\n");
            } catch (SocketException s) {
                System.out.println(s.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMsg(String user, String msg) throws IOException {
        String message = user + " a las (" + LocalTime.now() + "): " + msg + "                    " + "";
        // ENVIANDO mensaje al grupo
        DatagramPacket paquete = new DatagramPacket(message.getBytes(),
                message.length(), grupo, this.puerto);
        ms.send(paquete);
    }

    public void Usuariologeado(String user) throws IOException {
        String message = user + " ha entrado en el chat a las (" + LocalTime.now() + ")" + "\n";
        // ENVIANDO mensaje al grupo
        DatagramPacket paquete = new DatagramPacket(message.getBytes(),
                message.length(), grupo, this.puerto);
        ms.send(paquete);
    }

    public void Usuariosalido(String user) throws IOException {
        String message = user + " ha salido del chat a las (" + LocalTime.now() + ")" + "\n";
        // ENVIANDO mensaje al grupo
        DatagramPacket paquete = new DatagramPacket(message.getBytes(),
                message.length(), grupo, this.puerto);
        ms.send(paquete);
    }

    public void terminarhilo() {
        this.repetir = false;
    }

    public void setVista(VentanaChatVista vista, Stage dialog, UsuarioDTO currentUsuario) {
        this.dialogStage = dialog;
        this.vista = vista;
        this.currentUsuario = currentUsuario;
    }

    @FXML
    public void handlemensaje(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            try {
                this.sendMsg(currentUsuario.getNombre(), msgBar.getText());
                msgBar.setText("");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

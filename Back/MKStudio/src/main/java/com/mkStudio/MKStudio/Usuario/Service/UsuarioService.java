package com.mkStudio.MKStudio.Usuario.Service;

import com.mkStudio.MKStudio.Usuario.Dominio.DTO.UsuarioDTO;
import com.mkStudio.MKStudio.Usuario.Dominio.Mapper.UsuarioMapper;
import com.mkStudio.MKStudio.Usuario.Dominio.Repository.UsuarioRepository;
import com.mkStudio.MKStudio.Usuario.Dominio.UsuarioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Casos de uso de la entidad usuario
 */
@Service
public class UsuarioService {

    /**
     * usuarioRepo tipo UsuarioRepository
     */
    @Autowired
    UsuarioRepository usuarioRepo;

    /**
     * Método para dar de alta un nuevo usuario. Tambien se convierte un UsuarioDTO a UsuarioVO
     *
     * @param usuariodto
     * @return usuarioRepo.save(user)
     */
    @Transactional
    public UsuarioVO Registro_De_Usuario(UsuarioDTO usuariodto) {

        Optional<UsuarioVO> nbd = usuarioRepo.findById(usuariodto.getId());
        if (nbd.isPresent())
            throw new EntityExist(UsuarioVO.class.toString(), usuariodto.getId());

        UsuarioVO user = UsuarioMapper.fromDTO(usuariodto);
        return usuarioRepo.save(user);
    }

    /**
     * Método para devolver la lista de usuarios.
     *
     * @return ArrayList<UsuarioVO>
     */
    @Transactional
    public ArrayList<UsuarioDTO> Consultar_Usuarios() {
        List<UsuarioVO> nbd = usuarioRepo.findAll();
        ArrayList<UsuarioDTO> nbdA = new ArrayList<>();
        for (int i = 0; i < nbd.size(); i++) {
            UsuarioDTO user = UsuarioMapper.toDTO(nbd.get(i));
            nbdA.add(user);
        }
        return nbdA;
    }

    /**
     * Método para consultar un usuario en función a la id que se le pase
     *
     * @param id
     * @return usuarioRepo.findOne(id)
     */
    public Optional<UsuarioVO> ConsultarPerfilUsuario(int id) {
        Optional<UsuarioVO> nbd = usuarioRepo.findById(id);
        if (!nbd.isPresent()) {
            throw new EntityNotExist(UsuarioVO.class.toString(), id);
        }
        return nbd;
    }

    /**
     * Método para modificar un usuario en función a la id que se le pase. Si no existe se genera una excepción. Tambien se convierte un UsuarioDTO a UsuarioVO
     *
     * @param usuariodto
     */
    @Transactional
    public UsuarioVO Modificar_Usuario(UsuarioDTO usuariodto) {
        Optional<UsuarioVO> nbd = usuarioRepo.findById(usuariodto.getId());
        if (!nbd.isPresent()) {
            throw new EntityNotExist(UsuarioVO.class.toString(), usuariodto.getId());
        }
        UsuarioVO udpusuario = UsuarioMapper.fromDTO(usuariodto);
        return usuarioRepo.save(udpusuario);
    }

    /**
     * Método para eliminar un usuario
     *
     * @param id
     */
    @Transactional
    public boolean Eliminar_Usuario(int id) {
        Optional<UsuarioVO> nbd = usuarioRepo.findById(id);
        if (!nbd.isPresent()) {
            throw new EntityNotExist(UsuarioVO.class.toString(), id);
        }
        usuarioRepo.deleteById(id);
        return true;
    }
}

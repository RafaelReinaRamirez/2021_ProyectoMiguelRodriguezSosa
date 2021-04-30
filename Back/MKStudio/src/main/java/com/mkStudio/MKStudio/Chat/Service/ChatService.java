package com.mkStudio.MKStudio.Chat.Service;

import com.mkStudio.MKStudio.Chat.Dominio.ChatVO;
import com.mkStudio.MKStudio.Chat.Dominio.DTO.ChatDTO;
import com.mkStudio.MKStudio.Chat.Dominio.Mapper.ChatMapper;
import com.mkStudio.MKStudio.Chat.Dominio.Repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Casos de uso de la entidad chat
 */
@Service
public class ChatService {
    /**
     * chatRepo tipo ChatRepository
     */
    @Autowired
    ChatRepository chatRepo;


    /**
     * Método para dar de alta un nuevo chat. Tambien se convierte un ChatDTO a ChatVO
     *
     * @param chatdto
     * @return chatRepo.save(chat)
     */
    @Transactional
    public ChatVO darDeAltaUnChat(ChatDTO chatdto) {
        Optional<ChatVO> nbd = chatRepo.findById(chatdto.getId());
        if (nbd.isPresent())
            throw new EntityExist(ChatVO.class.toString(), chatdto.getId());

        ChatVO chat = ChatMapper.fromDTO(chatdto);
        return chatRepo.save(chat);
    }

    /**
     * Método para eliminar un chat
     *
     * @param id
     */
    @Transactional
    public boolean eliminarUnChat(int id) {
        Optional<ChatVO> nbd = chatRepo.findById(id);
        if (!nbd.isPresent())
            throw new EntityNotExist(ChatVO.class.toString(), id);

        //Borra el chat si está en la base de datos
        chatRepo.deleteById(id);
        return true;
    }

    /**
     * Método para consultar un chat en función a la id que se le pase
     *
     * @param id
     * @return chatRepo.findOne(id)
     */
    @Transactional
    public ChatVO consultarChats(int id) {
        Optional<ChatVO> nbd = chatRepo.findById(id);
        if (!nbd.isPresent())
            throw new EntityNotExist(ChatVO.class.toString(), id);
        return chatRepo.findById(id).get();
    }

    /**
     * Método para consultar toda la lista de chats
     *
     * @return ArrayList de ChatDTO
     */
    @Transactional
    public ArrayList<ChatDTO> Consultar_todoslosChats() {
        List<ChatVO> nbd = chatRepo.findAll();
        ArrayList<ChatDTO> nbdA = new ArrayList<>();
        for (int i = 0; i < nbd.size(); i++) {
            ChatDTO user = ChatMapper.toDTO(nbd.get(i));
            nbdA.add(user);
        }
        return nbdA;
    }

    /**
     * * Método para modificar un chat en función a la id que se le pase. Si no existe se genera una excepción. Tambien se convierte un ChatDTO a ChatVO
     *
     * @param chatdto
     * @return chatRepo.save(udpchat)
     */
    @Transactional
    public ChatVO modificarChat(ChatDTO chatdto) {

        Optional<ChatVO> nbd = chatRepo.findById(chatdto.getId());
        if (!nbd.isPresent()) {
            throw new EntityNotExist(ChatVO.class.toString(), chatdto.getId());
        }
        ChatVO udpchat = ChatMapper.fromDTO(chatdto);
        return chatRepo.save(udpchat);
    }
}
package com.mkStudio.MKStudio.Chat.Dominio.Repository;

import com.mkStudio.MKStudio.Chat.Dominio.ChatVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Clase interfaz ChatRepository la cual extiende de GenericRepository
 */
@Repository
public interface ChatRepository extends JpaRepository<ChatVO, Integer> {

}
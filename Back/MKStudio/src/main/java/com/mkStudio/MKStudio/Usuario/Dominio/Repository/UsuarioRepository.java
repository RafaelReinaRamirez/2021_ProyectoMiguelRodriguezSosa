package com.mkStudio.MKStudio.Usuario.Dominio.Repository;

import com.mkStudio.MKStudio.Usuario.Dominio.UsuarioVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Clase interfaz UsuarioRepository la cual extiende de GenericRepository
 */
@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioVO, Integer> {
}

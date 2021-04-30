package com.mkStudio.MKStudio.Espacio.Dominio.Repository;

import com.mkStudio.MKStudio.Espacio.Dominio.EspacioVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Clase interfaz EspacioRepository la cual extiende de GenericRepository
 */
@Repository
public interface EspacioRepository extends JpaRepository<EspacioVO, Integer> {

}


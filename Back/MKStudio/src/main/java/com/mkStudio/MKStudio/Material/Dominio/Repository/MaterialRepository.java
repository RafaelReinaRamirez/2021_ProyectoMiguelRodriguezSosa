package com.mkStudio.MKStudio.Material.Dominio.Repository;

import com.mkStudio.MKStudio.Material.Dominio.MaterialVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Clase interfaz MaterialRepository la cual extiende de GenericRepository
 */
@Repository
public interface MaterialRepository extends JpaRepository<MaterialVO, Integer> {

}


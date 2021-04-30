package com.mkStudio.MKStudio.Reserva.Dominio.Repository;

import com.mkStudio.MKStudio.Reserva.Dominio.ReservaVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Clase interfaz EventoRepository la cual extiende de GenericRepository
 */
@Repository
public interface ReservaRepository extends JpaRepository<ReservaVO, Integer> {

}


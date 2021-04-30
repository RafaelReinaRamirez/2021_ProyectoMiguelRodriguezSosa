package com.mkStudio.MKStudio.Reserva.Service;

import com.mkStudio.MKStudio.Reserva.Dominio.DTO.ReservaDTO;
import com.mkStudio.MKStudio.Reserva.Dominio.Mapper.ReservaMapper;
import com.mkStudio.MKStudio.Reserva.Dominio.Repository.ReservaRepository;
import com.mkStudio.MKStudio.Reserva.Dominio.ReservaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Casos de uso de la entidad reserva
 */
@Service
public class ReservaService {

    /**
     * reservaRepo tipo ReservaRepository
     */
    @Autowired
    ReservaRepository reservaRepo;


    /**
     * Método para dar de alta una nueva reserva. Tambien se convierte un ReservaDTO a ReservaVO
     *
     * @param reservadto
     * @return reservaRepo.save(reserva)
     */
    @Transactional
    public ReservaVO darDeAltaUnaReserva(ReservaDTO reservadto) {

        Optional<ReservaVO> nbd = reservaRepo.findById(reservadto.getId());
        if (nbd.isPresent())
            throw new EntityExist(ReservaVO.class.toString(), reservadto.getId());

        ReservaVO reserva = ReservaMapper.fromDTO(reservadto);
        return reservaRepo.save(reserva);
    }

    /**
     * Método para eliminar una reserva
     *
     * @param id
     */
    @Transactional
    public boolean eliminarUnaReserva(int id) {
        Optional<ReservaVO> nbd = reservaRepo.findById(id);
        if (!nbd.isPresent())
            throw new EntityNotExist(ReservaVO.class.toString(), id);

        //Borra la reserva si está en la base de datos
        reservaRepo.deleteById(id);
        return true;
    }

    /**
     * Método para consultar una reserva en función a la id que se le pase
     *
     * @param id
     * @return reservaRepo.findOne(id)
     */
    @Transactional
    public Optional<ReservaVO> consultarReservas(int id) {
        Optional<ReservaVO> nbd = reservaRepo.findById(id);
        if (!nbd.isPresent()) {
            throw new EntityNotExist(ReservaVO.class.toString(), id);
        }
        return nbd;
    }

    /**
     * * Método para modificar una reserva en función a la id que se le pase. Si no existe se genera una excepción. Tambien se convierte un ReservaDTO a ReservaVO
     *
     * @param reservadto
     * @return
     */
    @Transactional
    public ReservaVO modificarReserva(ReservaDTO reservadto) {

        Optional<ReservaVO> nbd = reservaRepo.findById(reservadto.getId());
        if (!nbd.isPresent()) {
            throw new EntityNotExist(ReservaVO.class.toString(), reservadto.getId());
        }
        ReservaVO udpreserva = ReservaMapper.fromDTO(reservadto);
        return reservaRepo.save(udpreserva);
    }
}

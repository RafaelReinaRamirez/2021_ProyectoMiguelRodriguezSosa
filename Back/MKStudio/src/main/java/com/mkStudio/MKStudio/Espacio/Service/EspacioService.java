package com.mkStudio.MKStudio.Espacio.Service;

import com.mkStudio.MKStudio.Espacio.Dominio.DTO.EspacioDTO;
import com.mkStudio.MKStudio.Espacio.Dominio.EspacioVO;
import com.mkStudio.MKStudio.Espacio.Dominio.Mapper.EspacioMapper;
import com.mkStudio.MKStudio.Espacio.Dominio.Repository.EspacioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Casos de uso de la entidad espacio
 */
@Service
public class EspacioService {

    /**
     * eventoRepo tipo EspacioRepository
     */
    @Autowired
    EspacioRepository espacioRepo;


    /**
     * Método para dar de alta un nuevo espacio. Tambien se convierte un EspacioDTO a EspacioVO
     *
     * @param espaciodto
     * @return espacioRepo.save(espacio)
     */
    @Transactional
    public EspacioVO darDeAltaUnEspacio(EspacioDTO espaciodto) {

        Optional<EspacioVO> nbd = espacioRepo.findById(espaciodto.getId());
        if (nbd.isPresent())
            throw new EntityExist(EspacioVO.class.toString(), espaciodto.getId());

        EspacioVO espacio = EspacioMapper.fromDTO(espaciodto);
        return espacioRepo.save(espacio);
    }

    /**
     * Método para eliminar un espacio
     *
     * @param id
     */
    @Transactional
    public boolean eliminarUnEspacio(int id) {
        Optional<EspacioVO> nbd = espacioRepo.findById(id);
        if (!nbd.isPresent())
            throw new EntityNotExist(EspacioVO.class.toString(), id);

        //Borra el espacio si está en la base de datos
        espacioRepo.deleteById(id);
        return true;
    }

    /**
     * Método para consultar un espacio en función a la id que se le pase
     *
     * @param id
     * @return espacioRepo.findOne(id)
     */
    @Transactional
    public Optional<EspacioVO> consultarEspacio(int id) {
        Optional<EspacioVO> nbd = espacioRepo.findById(id);
        if (!nbd.isPresent()) {
            throw new EntityNotExist(EspacioVO.class.toString(), id);
        }
        return nbd;
    }

    /**
     * * Método para modificar un espacio en función a la id que se le pase. Si no existe se genera una excepción. Tambien se convierte un EspacioDTO a EspacioVO
     *
     * @param espaciodto
     * @return
     */
    @Transactional
    public EspacioVO modificarEspacio(EspacioDTO espaciodto) {

        Optional<EspacioVO> nbd = espacioRepo.findById(espaciodto.getId());
        if (!nbd.isPresent()) {
            throw new EntityNotExist(EspacioVO.class.toString(), espaciodto.getId());
        }
        EspacioVO udpespacio = EspacioMapper.fromDTO(espaciodto);
        return espacioRepo.save(udpespacio);
    }
}

package com.mkStudio.MKStudio.Material.Service;

import com.mkStudio.MKStudio.Material.Dominio.DTO.MaterialDTO;
import com.mkStudio.MKStudio.Material.Dominio.Mapper.MaterialMapper;
import com.mkStudio.MKStudio.Material.Dominio.MaterialVO;
import com.mkStudio.MKStudio.Material.Dominio.Repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Casos de uso de la entidad material
 */
@Service
public class MaterialService {

    /**
     * eventoRepo tipo MaterialRepository
     */
    @Autowired
    MaterialRepository materialRepo;


    /**
     * Método para dar de alta un nuevo material. Tambien se convierte un MaterialDTO a MaterialVO
     *
     * @param materialdto
     * @return materialRepo.save(material)
     */
    @Transactional
    public MaterialVO darDeAltaUnMaterial(MaterialDTO materialdto) {

        Optional<MaterialVO> nbd = materialRepo.findById(materialdto.getId());
        if (nbd.isPresent())
            throw new EntityExist(MaterialVO.class.toString(), materialdto.getId());

        MaterialVO material = MaterialMapper.fromDTO(materialdto);
        return materialRepo.save(material);
    }

    /**
     * Método para eliminar un material
     *
     * @param id
     */
    @Transactional
    public boolean eliminarUnMaterial(int id) {
        Optional<MaterialVO> nbd = materialRepo.findById(id);
        if (!nbd.isPresent())
            throw new EntityNotExist(MaterialVO.class.toString(), id);

        //Borra el materail si está en la base de datos
        materialRepo.deleteById(id);
        return true;
    }

    /**
     * Método para consultar un material en función a la id que se le pase
     *
     * @param id
     * @return materialRepo.findOne(id)
     */
    @Transactional
    public Optional<MaterialVO> consultarMateriales(int id) {
        Optional<MaterialVO> nbd = materialRepo.findById(id);
        if (!nbd.isPresent()) {
            throw new EntityNotExist(MaterialVO.class.toString(), id);
        }
        return nbd;
    }

    /**
     * * Método para modificar un material en función a la id que se le pase. Si no existe se genera una excepción. Tambien se convierte un MaterialDTO a MaterialVO
     *
     * @param materialdto
     * @return
     */
    @Transactional
    public MaterialVO modificarMaterial(MaterialDTO materialdto) {

        Optional<MaterialVO> nbd = materialRepo.findById(materialdto.getId());
        if (!nbd.isPresent()) {
            throw new EntityNotExist(MaterialVO.class.toString(), materialdto.getId());
        }
        MaterialVO udpmaterial = MaterialMapper.fromDTO(materialdto);
        return materialRepo.save(udpmaterial);
    }
}

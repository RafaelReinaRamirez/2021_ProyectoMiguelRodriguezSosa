package com.mkStudio.MKStudio.Material.controller;

import com.mkStudio.MKStudio.Material.Dominio.DTO.MaterialDTO;
import com.mkStudio.MKStudio.Material.Dominio.Mapper.MaterialMapper;
import com.mkStudio.MKStudio.Material.Service.MaterialService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Clase controlador de Material para la Api Rest
 */
@RestController
@RequestMapping(EndpointUrls.V1 + MaterialRestController.MATERIAL_RESOURCE)
@AllArgsConstructor
public class MaterialRestController {

    @Autowired
    private final MaterialService materialService;

    public static final String MATERIAL_RESOURCE = "/material";

    /**
     * Método que registra un material
     * @param dto
     * @return
     */
    @PostMapping
    public ResponseEntity<MaterialDTO> register(@RequestBody MaterialDTO dto) {
        materialService.darDeAltaUnMaterial(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Método que obtiene un material por su id
     * @param id
     * @return
     */
    @GetMapping(EndpointUrls.GetById)
    public ResponseEntity getById(@PathVariable final int id) {
        try {
            return materialService.consultarMateriales(id)
                    .map(material -> MaterialMapper.toDTO(material))
                    .map(materialdto -> new ResponseEntity(materialdto, HttpStatus.OK))
                    .orElse(new ResponseEntity(null, HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Método que actualiza los datos de un material
     * @param materialDTO
     * @return
     */
    @PutMapping(EndpointUrls.Update)
    public ResponseEntity<MaterialDTO> update(@RequestBody MaterialDTO materialDTO) {
        return new ResponseEntity(materialService.modificarMaterial(materialDTO), HttpStatus.CREATED);
    }

    /**
     * Método que elimina un material el cual se obtiene por su id
     * @param id
     * @return
     */
    @DeleteMapping(EndpointUrls.DeleteById)
    public ResponseEntity<Boolean> delete(@PathVariable final int id) {
        return materialService.eliminarUnMaterial(id)
                ? ResponseEntity.ok(true)
                : new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}

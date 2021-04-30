package com.mkStudio.MKStudio.Espacio.controller;

import com.mkStudio.MKStudio.Espacio.Dominio.DTO.EspacioDTO;
import com.mkStudio.MKStudio.Espacio.Dominio.Mapper.EspacioMapper;
import com.mkStudio.MKStudio.Espacio.Service.EspacioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Clase controlador de Espacio para la Api Rest
 */
@RestController
@RequestMapping(EndpointUrls.V1 + EspacioRestController.ESPACIO_RESOURCE)
@AllArgsConstructor
public class EspacioRestController {

    @Autowired
    private final EspacioService espacioService;

    public static final String ESPACIO_RESOURCE = "/espacio";

    /**
     * Método que registra un espacio
     * @param dto
     * @return
     */
    @PostMapping
    public ResponseEntity<EspacioDTO> register(@RequestBody EspacioDTO dto) {
        espacioService.darDeAltaUnEspacio(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Método que obtiene un espacio por su id
     * @param id
     * @return
     */
    @GetMapping(EndpointUrls.GetById)
    public ResponseEntity getById(@PathVariable final int id) {
        try {
            return espacioService.consultarEspacio(id)
                    .map(espacio -> EspacioMapper.toDTO(espacio))
                    .map(espaciodto -> new ResponseEntity(espaciodto, HttpStatus.OK))
                    .orElse(new ResponseEntity(null, HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Método que actualiza los datos de un espacio
     * @param espacioDTO
     * @return
     */
    @PutMapping(EndpointUrls.Update)
    public ResponseEntity<EspacioDTO> update(@RequestBody EspacioDTO espacioDTO) {
        return new ResponseEntity(espacioService.modificarEspacio(espacioDTO), HttpStatus.CREATED);
    }

    /**
     * Método que elimina un espacio el cual se obtiene por su id
     * @param id
     * @return
     */
    @DeleteMapping(EndpointUrls.DeleteById)
    public ResponseEntity<Boolean> delete(@PathVariable final int id) {
        return espacioService.eliminarUnEspacio(id)
                ? ResponseEntity.ok(true)
                : new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}

package com.mkStudio.MKStudio.Reserva.controller;

import com.mkStudio.MKStudio.Reserva.Dominio.DTO.ReservaDTO;
import com.mkStudio.MKStudio.Reserva.Dominio.Mapper.ReservaMapper;
import com.mkStudio.MKStudio.Reserva.Service.ReservaService;
import com.mkStudio.MKStudio.Shared.Infraestructura.EndpointUrls;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Clase controlador de Reserva para la Api Rest
 */
@RestController
@RequestMapping(EndpointUrls.V1 + ReservaRestController.RESERVA_RESOURCE)
@AllArgsConstructor
public class ReservaRestController {

    @Autowired
    private final ReservaService reservaService;

    public static final String RESERVA_RESOURCE = "/reserva";

    /**
     * Método que registra una reserva
     * @param dto
     * @return
     */
    @PostMapping
    public ResponseEntity<ReservaDTO> register(@RequestBody ReservaDTO dto) {
        reservaService.darDeAltaUnaReserva(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Método que obtiene una reserva por su id
     * @param id
     * @return
     */
    @GetMapping(EndpointUrls.GetById)
    public ResponseEntity getById(@PathVariable final int id) {
        try {
            return reservaService.consultarReservas(id)
                    .map(reserva -> ReservaMapper.toDTO(reserva))
                    .map(reservadto -> new ResponseEntity(reservadto, HttpStatus.OK))
                    .orElse(new ResponseEntity(null, HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Método que actualiza los datos de una reserva
     * @param reservaDTO
     * @return
     */
    @PutMapping(EndpointUrls.Update)
    public ResponseEntity<ReservaDTO> update(@RequestBody ReservaDTO reservaDTO) {
        return new ResponseEntity(reservaService.modificarReserva(reservaDTO), HttpStatus.CREATED);
    }

    /**
     * Método que elimina una reserva el cual se obtiene por su id
     * @param id
     * @return
     */
    @DeleteMapping(EndpointUrls.DeleteById)
    public ResponseEntity<Boolean> delete(@PathVariable final int id) {
        return reservaService.eliminarUnaReserva(id)
                ? ResponseEntity.ok(true)
                : new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}

package com.mkStudio.MKStudio.Usuario.controller;

import com.mkStudio.MKStudio.Shared.Infraestructura.EndpointUrls;
import com.mkStudio.MKStudio.Usuario.Dominio.DTO.UsuarioDTO;
import com.mkStudio.MKStudio.Usuario.Dominio.Mapper.UsuarioMapper;
import com.mkStudio.MKStudio.Usuario.Service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase controlador de Usuario para la Api Rest
 */
@RestController
@RequestMapping(EndpointUrls.V1 + UsuarioRestController.USUARIO_RESOURCE)
@AllArgsConstructor
public class UsuarioRestController {

    @Autowired
    private final UsuarioService userService;

    public static final String USUARIO_RESOURCE = "/user";

    /**
     * Método que registra un usuario
     * @param dto
     * @return
     */
    @PostMapping
    public ResponseEntity<UsuarioDTO> register(@RequestBody UsuarioDTO dto) {
        dto = UsuarioMapper.toDTO(userService.Registro_De_Usuario(dto));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    /**
     * Método que obtiene una lista de todos los usuarios
     * @return
     */
    @GetMapping(EndpointUrls.GetAll)
    public ResponseEntity<List<UsuarioDTO>> getAll() {
        return ResponseEntity.ok(userService.Consultar_Usuarios());
    }

    /**
     * Método que obtiene un usuario por su id
     * @param id
     * @return
     */
    @GetMapping(EndpointUrls.GetById)
    public ResponseEntity getById(@PathVariable final int id) {
        try {
            return userService.ConsultarPerfilUsuario(id)
                    .map(user -> UsuarioMapper.toDTO(user))
                    .map(userdto -> new ResponseEntity(userdto, HttpStatus.OK))
                    .orElse(new ResponseEntity(null, HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Método que actualiza los datos de un usuario
     * @param usuarioDTO
     * @return
     */
    @PutMapping(EndpointUrls.Update)
    public ResponseEntity<UsuarioDTO> update(@RequestBody UsuarioDTO usuarioDTO) {
        return new ResponseEntity(userService.Modificar_Usuario(usuarioDTO), HttpStatus.CREATED);
    }

    /**
     * Método que elimina un usuario el cual se obtiene por su id
     * @param id
     * @return
     */
    @DeleteMapping(EndpointUrls.DeleteById)
    public ResponseEntity<Boolean> delete(@PathVariable final int id) {
        return userService.Eliminar_Usuario(id)
                ? ResponseEntity.ok(true)
                : new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}

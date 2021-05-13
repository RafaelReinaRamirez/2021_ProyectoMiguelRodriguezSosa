package com.mkStudio.MKStudio.Usuario.Err;

import com.mkStudio.MKStudio.Shared.Err.DomainError;

/**
 * Clase Persona
 */
public class PersonaErr extends DomainError {
    public PersonaErr(String errcode, String errtext) {
        super(errcode, errtext);
    }
}
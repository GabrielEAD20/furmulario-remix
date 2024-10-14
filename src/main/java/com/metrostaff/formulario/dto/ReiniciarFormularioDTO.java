package com.metrostaff.formulario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReiniciarFormularioDTO {

    @JsonProperty("success")
    private boolean success;

    @JsonProperty("message")
    private String message;

    // Getters y Setters
}

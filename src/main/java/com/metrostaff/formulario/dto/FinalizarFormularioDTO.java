package com.metrostaff.formulario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FinalizarFormularioDTO {

    @JsonProperty("success")
    private boolean success;

    @JsonProperty("message")
    private String message;

    // Getters y Setters
}

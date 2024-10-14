package com.metrostaff.formulario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoFormularioDTO {

    @JsonProperty("form_id")
    private String formId;

    @JsonProperty("status")
    private String status; // completed | in_progress | not_started

    // Getters y Setters
}

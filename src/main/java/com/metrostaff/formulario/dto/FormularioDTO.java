package com.metrostaff.formulario.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FormularioDTO {

    @NotNull(message = "El ID del formulario es obligatorio")
    private Integer formId;

    @NotNull(message = "El ID de la pregunta es obligatorio")
    private Integer questionId;

    @NotNull(message = "El tipo de pregunta es obligatorio")
    private String questionType; // Tipo de pregunta (Option, Boolean, Written)

    // Campo para preguntas de opción múltiple (se usa solo si es de tipo Option)
    private List<Integer> opciones;

    // Campo para preguntas booleanas (se usa solo si es de tipo Boolean)
    private Boolean respuestaBoolean;

    // Campo para preguntas escritas (se usa solo si es de tipo Written)
    @Size(max = 500, message = "La respuesta no puede tener más de 500 caracteres")
    private String respuestaEscrita;

}

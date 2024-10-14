package com.metrostaff.formulario.controller;

import com.metrostaff.formulario.constant.ApiVersion;
import com.metrostaff.formulario.dto.IniciarFormularioDTO;
import com.metrostaff.formulario.usecase.IniciarFormulario;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiVersion.API_VERSION_V1 + "/form")
@AllArgsConstructor

public class FormularioController {
    private final IniciarFormulario iniciarFormulario;
    @GetMapping("/{formId}/start")
    public IniciarFormularioDTO iniciarFormulario(@PathVariable Integer formId) {
        return iniciarFormulario.ejecutar(formId);
    }
}

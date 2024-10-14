package com.metrostaff.formulario.controller;

import com.metrostaff.formulario.constant.ApiVersion;
import com.metrostaff.formulario.dto.FormularioDTO;
import com.metrostaff.formulario.dto.IniciarFormularioDTO;
import com.metrostaff.formulario.dto.SiguientePreguntaDTO;
import com.metrostaff.formulario.usecase.IniciarFormulario;
import com.metrostaff.formulario.usecase.ObtenerSiguientePregunta;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiVersion.API_VERSION_V1 + "/form")
@AllArgsConstructor
public class FormularioController {
    private final IniciarFormulario iniciarFormulario;
    private final ObtenerSiguientePregunta obtenerSiguientePregunta;
    @GetMapping("/{formId}/start")
    public ResponseEntity<IniciarFormularioDTO> iniciarFormulario(@PathVariable Integer formId) {
        return ResponseEntity.ok(iniciarFormulario.ejecutar(formId));
    }
    @GetMapping("/forms/{optionId}/next")
    public ResponseEntity<SiguientePreguntaDTO> obtenerSiguientePregunta(
            @PathVariable Integer optionId,
            @RequestBody FormularioDTO formularioDto ) {
        return ResponseEntity.ok(obtenerSiguientePregunta.ejecutar(optionId,formularioDto));
    }
}

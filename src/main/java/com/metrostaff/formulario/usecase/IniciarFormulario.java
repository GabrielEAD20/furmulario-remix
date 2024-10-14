package com.metrostaff.formulario.usecase;

import com.metrostaff.formulario.constant.IniciarFormularioConstant;
import com.metrostaff.formulario.dto.IniciarFormularioDTO;
import com.metrostaff.formulario.models.PreguntaCuestionario;
import com.metrostaff.formulario.service.CuestionarioService;
import com.metrostaff.formulario.service.OpcionPreguntaService;
import com.metrostaff.formulario.service.PreguntaCuestionarioService;
import com.metrostaff.formulario.service.PreguntaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class IniciarFormulario {
    private final PreguntaService preguntaService;

    private final CuestionarioService cuestionarioService;

    private final PreguntaCuestionarioService preguntaCuestionarioService;

    private final OpcionPreguntaService opcionPreguntaService;

    public IniciarFormularioDTO ejecutar(Integer formId) {
        // 1 Definir el primer dato a traer el cual es el numero 1
        var nroPregunta = IniciarFormularioConstant.PRIMER_NUMERO;
        // 2 Obtener el cuestionario la data
        var preguntaCuestionario = preguntaCuestionarioService.getPreguntaCuestionarioByIdCuestionarioAndByNroPregunta(formId , nroPregunta);
        // 3 Definir el id que se buscara
        var idPregunta = preguntaCuestionario.getIdPregunta();
        // 4 Obtener Informacion de la pregunta
        var preguntaInformacion = preguntaService.getById(idPregunta);
        // 5 Obtener el id de la pregunta
        idPregunta = preguntaInformacion.getId();
        // 6 Obtener el tipo de pregunta de la pregunta
        var informacionPregunta = preguntaInformacion.getDescripcionMostrar();
        // 7 Verificar si tiene opciones
        var tipoDePregunta = preguntaInformacion.getTipoPregunta();
        if (preguntaInformacion.isTieneOpciones())
            //8  Obtener las opciones
        {
            var listaOpciones = opcionPreguntaService.getAllOpcionesByPreguntaId (idPregunta);
            // Usar Streams para mapear la lista de OpcionPregunta a OpcionDTO
            List<IniciarFormularioDTO.OpcionDTO> opcionesDTO = listaOpciones.stream()
                    .map(opcionPregunta -> {
                        IniciarFormularioDTO.OpcionDTO opcionDTO = new IniciarFormularioDTO.OpcionDTO();
                        opcionDTO.setOptionId(String.valueOf(opcionPregunta.getId()));         // Asignar el ID de la opción
                        opcionDTO.setOptionText(opcionPregunta.getDescripcionMostrar());        // Asignar el texto a mostrar de la opción
                        return opcionDTO;
                    })
                    .toList();

            IniciarFormularioDTO iniciarFormularioDTO = new IniciarFormularioDTO();
            iniciarFormularioDTO.setQuestionId(idPregunta);
            iniciarFormularioDTO.setQuestionText(informacionPregunta);
            iniciarFormularioDTO.setQuestionType(tipoDePregunta);
            iniciarFormularioDTO.setOptions(opcionesDTO);
            return iniciarFormularioDTO;
        }
        IniciarFormularioDTO iniciarFormularioDTO = new IniciarFormularioDTO();
        iniciarFormularioDTO.setQuestionId(idPregunta);
        iniciarFormularioDTO.setQuestionText(informacionPregunta);
        iniciarFormularioDTO.setQuestionType(tipoDePregunta);
        iniciarFormularioDTO.setOptions(List.of());
        return iniciarFormularioDTO;

    }
}

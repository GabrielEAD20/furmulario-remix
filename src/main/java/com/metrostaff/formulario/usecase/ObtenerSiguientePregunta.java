package com.metrostaff.formulario.usecase;

import com.metrostaff.formulario.constant.SiguientePreguntaConstant;
import com.metrostaff.formulario.constant.TipoPreguntaConstant;
import com.metrostaff.formulario.dto.FormularioDTO;
import com.metrostaff.formulario.dto.SiguientePreguntaDTO;
import com.metrostaff.formulario.models.RespuestaPregunta;
import com.metrostaff.formulario.service.OpcionPreguntaService;
import com.metrostaff.formulario.service.RespuestaPreguntaService;
import com.metrostaff.formulario.service.SecuenciaPreguntaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ObtenerSiguientePregunta {

    private final SecuenciaPreguntaService secuenciaPreguntaService;
    private final OpcionPreguntaService opcionPreguntaService;
    private final RespuestaPreguntaService respuestaPreguntaService;

    public SiguientePreguntaDTO ejecutar(Integer idOpcionPregunta, FormularioDTO formularioDTO) {
        // 1. Obtener la siguiente pregunta basada en la opción seleccionada
        var preguntaSiguiente = secuenciaPreguntaService.getNextPregunta(idOpcionPregunta);

        // 2. Obtener los detalles de la siguiente pregunta
        var idPreguntaSiguiente = preguntaSiguiente.getId();
        var informacionPregunta = preguntaSiguiente.getDescripcionMostrar();
        var tipoPregunta = preguntaSiguiente.getTipoPregunta();

        // Crear un DTO para la siguiente pregunta
        SiguientePreguntaDTO siguientePreguntaDTO = new SiguientePreguntaDTO();

        // 3. Obtener los campos del formulario DTO
        var idFormulario = formularioDTO.getFormId();
        var idPregunta = formularioDTO.getQuestionId();
        var tipoPreguntaFormulario = formularioDTO.getQuestionType();

        // Lista para almacenar los IDs de las respuestas guardadas
        List<Integer> respuestasIds = new ArrayList<>();

        // 4. Verificar el tipo de pregunta y procesar las respuestas correspondientes
        if (TipoPreguntaConstant.MULTIPLE_CHOOSE.equals(tipoPreguntaFormulario)) {
            var listaDeMultiplesRespuestas = formularioDTO.getOpciones();

            // Recorrer las opciones seleccionadas y crear una respuesta para cada opción
            for (Integer respuesta : listaDeMultiplesRespuestas) {
                var respuestaGuardada = respuestaPreguntaService.crearRespuesta(idFormulario, idPregunta, tipoPreguntaFormulario, respuesta.toString());
                respuestasIds.add(respuestaGuardada.getId()); // Agregar el ID de la respuesta a la lista
            }

        } else if (TipoPreguntaConstant.BOOLEAN.equals(tipoPreguntaFormulario)) {
            var boleano = formularioDTO.getRespuestaBoolean();
            var respuestaGuardada = respuestaPreguntaService.crearRespuesta(idFormulario, idPregunta, tipoPreguntaFormulario, boleano.toString());
            respuestasIds.add(respuestaGuardada.getId()); // Agregar el ID de la respuesta

        } else if (TipoPreguntaConstant.OPEN_ENDED.equals(tipoPreguntaFormulario)) {
            var respuestaEscrita = formularioDTO.getRespuestaEscrita();
            var respuestaGuardada = respuestaPreguntaService.crearRespuesta(idFormulario, idPregunta, tipoPreguntaFormulario, respuestaEscrita);
            respuestasIds.add(respuestaGuardada.getId()); // Agregar el ID de la respuesta

        } else if (TipoPreguntaConstant.SINGLE_CHOOSE.equals(tipoPreguntaFormulario)) {
            var unicaRespuestaDeMultiplesRespuestas = formularioDTO.getOpciones().get(0);
            var respuestaGuardada = respuestaPreguntaService.crearRespuesta(idFormulario, idPregunta, tipoPreguntaFormulario, unicaRespuestaDeMultiplesRespuestas.toString());
            respuestasIds.add(respuestaGuardada.getId()); // Agregar el ID de la respuesta
        }

        // 5. Verificar si la siguiente pregunta tiene opciones
        if (preguntaSiguiente.isTieneOpciones()) {
            var listaOpciones = opcionPreguntaService.getAllOpcionesByPreguntaId(idPreguntaSiguiente);

            // Usar Streams para mapear la lista de OpcionPregunta a OpcionDTO
            List<SiguientePreguntaDTO.OpcionDTO> opcionesDTO = listaOpciones.stream()
                    .map(opcionPregunta -> {
                        SiguientePreguntaDTO.OpcionDTO opcionDTO = new SiguientePreguntaDTO.OpcionDTO();
                        opcionDTO.setOptionId(opcionPregunta.getId());
                        opcionDTO.setOptionText(opcionPregunta.getDescripcionMostrar());
                        return opcionDTO;
                    })
                    .toList();

            // Asignar los valores al DTO
            siguientePreguntaDTO.setNextQuestionId(idPreguntaSiguiente);
            siguientePreguntaDTO.setQuestionText(informacionPregunta);
            siguientePreguntaDTO.setQuestionType(tipoPregunta);
            siguientePreguntaDTO.setOptions(opcionesDTO);
            siguientePreguntaDTO.setRespuestasId(respuestasIds); // Agregar la lista de IDs de respuestas

            return siguientePreguntaDTO;
        }

        // Si no tiene opciones, simplemente devolver la siguiente pregunta
        siguientePreguntaDTO.setNextQuestionId(idPreguntaSiguiente);
        siguientePreguntaDTO.setQuestionText(informacionPregunta);
        siguientePreguntaDTO.setQuestionType(tipoPregunta);
        siguientePreguntaDTO.setOptions(List.of());
        siguientePreguntaDTO.setRespuestasId(respuestasIds); // Agregar la lista de IDs de respuestas

        return siguientePreguntaDTO;
    }
}

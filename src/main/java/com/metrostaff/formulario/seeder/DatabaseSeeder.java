package com.metrostaff.formulario.seeder;
import com.metrostaff.formulario.models.*;
import com.metrostaff.formulario.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private CategoriaPreguntaRepository categoriaPreguntaRepository;

    @Autowired
    private CuestionarioRepository cuestionarioRepository;

    @Autowired
    private EtapaPostulacionRepository etapaPostulacionRepository;

    @Autowired
    private OpcionPreguntaRepository opcionPreguntaRepository;

    @Autowired
    private PostulanteRepository postulanteRepository;

    @Autowired
    private PostulantePostulacionRepository postulantePostulacionRepository;

    @Autowired
    private PreguntaRepository preguntaRepository;

    @Autowired
    private PreguntaCuestionarioRepository preguntaCuestionarioRepository;

    @Autowired
    private PuestoTrabajoRepository puestoTrabajoRepository;

    @Autowired
    private RespuestaPreguntaRepository respuestaPreguntaRepository;

    @Autowired
    private SecuenciaPreguntaRepository secuenciaPreguntaRepository;

    @Override
    public void run(String... args) throws Exception {
        // Crear objetos y guardarlos en la base de datos

        // 1. Crear CategoriaPregunta
        CategoriaPregunta categoria = new CategoriaPregunta();
        categoria.setNombre("Categoría de Prueba");
        categoria.setDescripcionMostrar("Descripción de Categoría de Prueba");
        categoria.setIdEtapaPostulacion(1);
        categoriaPreguntaRepository.save(categoria);

        // 2. Crear Cuestionario
        Cuestionario cuestionario = new Cuestionario();
        cuestionario.setFecha(new Date());
        cuestionario.setNombreCuestionario("Cuestionario de Ejemplo");
        cuestionario.setIdEtapa(1);
        cuestionarioRepository.save(cuestionario);

        // 3. Crear EtapaPostulacion
        EtapaPostulacion etapa = new EtapaPostulacion();
        etapa.setIdPuestoTrabajo(1);
        etapaPostulacionRepository.save(etapa);

        // 4. Crear OpcionPregunta
        OpcionPregunta opcion = new OpcionPregunta();
        opcion.setDescripcion("Opción A");
        opcion.setDescripcionMostrar("Opción A - Mostrar");
        opcion.setIdPregunta(1);
        opcionPreguntaRepository.save(opcion);

        // 5. Crear Postulante
        Postulante postulante = new Postulante();
        postulante.setNombre("Juan");
        postulante.setApellidos("Pérez");
        postulanteRepository.save(postulante);

        // 6. Crear PostulantePostulacion
        PostulantePostulacion postulacion = new PostulantePostulacion();
        postulacion.setPostulante(postulante);
        postulacion.setFecha(new Date());
        postulacion.setObservacion("Observación de prueba");
        postulacion.setIdEtapa(1);
        postulantePostulacionRepository.save(postulacion);

        // 7. Crear Pregunta
        Pregunta pregunta = new Pregunta();
        pregunta.setTipoPregunta("BOOLEAN");
        pregunta.setDescripcion("¿Te gusta el café?");
        pregunta.setDescripcionMostrar("¿Te gusta el café?");
        pregunta.setIdGrupoPregunta(1);
        pregunta.setNroOrden(1);
        pregunta.setTieneOpciones(true);
        pregunta.setTextoRespuesta(null);
        preguntaRepository.save(pregunta);

        // 8. Crear PreguntaCuestionario
        PreguntaCuestionario preguntaCuestionario = new PreguntaCuestionario();
        preguntaCuestionario.setIdCuestionario(cuestionario.getId());
        preguntaCuestionario.setIdPregunta(pregunta.getId());
        preguntaCuestionario.setNroPregunta(1);
        preguntaCuestionario.setIdOpcionPreg(1);
        preguntaCuestionario.setObservaciones("Pregunta dentro de cuestionario");
        preguntaCuestionarioRepository.save(preguntaCuestionario);

        // 9. Crear PuestoTrabajo
        PuestoTrabajo puesto = new PuestoTrabajo();
        puesto.setNombre("Desarrollador Backend");
        puesto.setNroVacantes(3);
        puestoTrabajoRepository.save(puesto);

        // 10. Crear RespuestaPregunta
        RespuestaPregunta respuesta = new RespuestaPregunta();
        respuesta.setIdFormulario(1);
        respuesta.setIdPregunta(1);
        respuesta.setIdTypoPregunta("BOOLEAN");
        respuesta.setValorRespuesta("Sí");
        respuestaPreguntaRepository.save(respuesta);

        // 11. Crear SecuenciaPregunta
        SecuenciaPregunta secuenciaPregunta = new SecuenciaPregunta();
        secuenciaPregunta.setIdOpcionPregunta(opcion.getId());
        secuenciaPregunta.setIdPreguntaSiguiente(2); // ID de la siguiente pregunta
        secuenciaPreguntaRepository.save(secuenciaPregunta);

        // Puedes seguir agregando más datos si es necesario
        // 1. Crear más CategoriaPregunta
        CategoriaPregunta categoria2 = new CategoriaPregunta();
        categoria2.setNombre("Categoría de Prueba 2");
        categoria2.setDescripcionMostrar("Descripción de Categoría de Prueba 2");
        categoria2.setIdEtapaPostulacion(2);
        categoriaPreguntaRepository.save(categoria2);

        // 2. Crear más Cuestionarios
        Cuestionario cuestionario2 = new Cuestionario();
        cuestionario2.setFecha(new Date());
        cuestionario2.setNombreCuestionario("Cuestionario de Ejemplo 2");
        cuestionario2.setIdEtapa(2);
        cuestionarioRepository.save(cuestionario2);

        // 3. Crear más Etapas de Postulación
        EtapaPostulacion etapa2 = new EtapaPostulacion();
        etapa2.setIdPuestoTrabajo(2);
        etapaPostulacionRepository.save(etapa2);

        // 4. Crear más OpcionPregunta para diferentes preguntas
        OpcionPregunta opcion2 = new OpcionPregunta();
        opcion2.setDescripcion("Opción B");
        opcion2.setDescripcionMostrar("Opción B - Mostrar");
        opcion2.setIdPregunta(2);
        opcionPreguntaRepository.save(opcion2);

        OpcionPregunta opcion3 = new OpcionPregunta();
        opcion3.setDescripcion("Opción C");
        opcion3.setDescripcionMostrar("Opción C - Mostrar");
        opcion3.setIdPregunta(3);
        opcionPreguntaRepository.save(opcion3);

        // 5. Crear más Postulantes
        Postulante postulante2 = new Postulante();
        postulante2.setNombre("María");
        postulante2.setApellidos("García");
        postulanteRepository.save(postulante2);

        Postulante postulante3 = new Postulante();
        postulante3.setNombre("Carlos");
        postulante3.setApellidos("Sánchez");
        postulanteRepository.save(postulante3);

        // 6. Crear más PostulantePostulacion
        PostulantePostulacion postulacion2 = new PostulantePostulacion();
        postulacion2.setPostulante(postulante2);
        postulacion2.setFecha(new Date());
        postulacion2.setObservacion("Observación de prueba para postulante 2");
        postulacion2.setIdEtapa(2);
        postulantePostulacionRepository.save(postulacion2);

        // 7. Crear más Preguntas
        Pregunta pregunta2 = new Pregunta();
        pregunta2.setTipoPregunta("OPTION");
        pregunta2.setDescripcion("¿Cuál es tu comida favorita?");
        pregunta2.setDescripcionMostrar("¿Cuál es tu comida favorita?");
        pregunta2.setIdGrupoPregunta(2);
        pregunta2.setNroOrden(2);
        pregunta2.setTieneOpciones(true);
        pregunta2.setTextoRespuesta(null);
        preguntaRepository.save(pregunta2);

        Pregunta pregunta3 = new Pregunta();
        pregunta3.setTipoPregunta("WRITTEN");
        pregunta3.setDescripcion("Escribe tus comentarios sobre el servicio");
        pregunta3.setDescripcionMostrar("Escribe tus comentarios sobre el servicio");
        pregunta3.setIdGrupoPregunta(3);
        pregunta3.setNroOrden(3);
        pregunta3.setTieneOpciones(false);
        pregunta3.setTextoRespuesta(null);
        preguntaRepository.save(pregunta3);

        // 8. Crear más PreguntaCuestionario
        PreguntaCuestionario preguntaCuestionario2 = new PreguntaCuestionario();
        preguntaCuestionario2.setIdCuestionario(cuestionario2.getId());
        preguntaCuestionario2.setIdPregunta(pregunta2.getId());
        preguntaCuestionario2.setNroPregunta(2);
        preguntaCuestionario2.setIdOpcionPreg(2);
        preguntaCuestionario2.setObservaciones("Pregunta dentro de cuestionario 2");
        preguntaCuestionarioRepository.save(preguntaCuestionario2);

        // 9. Crear más Puestos de Trabajo
        PuestoTrabajo puesto2 = new PuestoTrabajo();
        puesto2.setNombre("Desarrollador Frontend");
        puesto2.setNroVacantes(2);
        puestoTrabajoRepository.save(puesto2);

        // 10. Crear más RespuestaPregunta
        RespuestaPregunta respuesta2 = new RespuestaPregunta();
        respuesta2.setIdFormulario(2);
        respuesta2.setIdPregunta(pregunta2.getId());
        respuesta2.setIdTypoPregunta("OPTION");
        respuesta2.setValorRespuesta("Opción B");
        respuestaPreguntaRepository.save(respuesta2);

        // 11. Crear más SecuenciaPregunta
        SecuenciaPregunta secuenciaPregunta2 = new SecuenciaPregunta();
        secuenciaPregunta2.setIdOpcionPregunta(opcion2.getId());
        secuenciaPregunta2.setIdPreguntaSiguiente(pregunta3.getId()); // ID de la siguiente pregunta
        secuenciaPreguntaRepository.save(secuenciaPregunta2);
    }
}

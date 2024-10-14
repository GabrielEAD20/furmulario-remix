package com.metrostaff.formulario.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tipoPregunta;

    private String descripcion;

    @Column(name = "descripcion_mostrar")
    private String descripcionMostrar;

    @Column(name = "id_grupo_pregunta")
    private int idGrupoPregunta;

    @Column(name = "nro_orden")
    private int nroOrden;

    @Column(name = "tiene_opciones")
    private boolean tieneOpciones;

    @Column(name = "texto_respuesta", length = 2500)
    private String textoRespuesta;

}
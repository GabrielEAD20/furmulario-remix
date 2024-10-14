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
public class CategoriaPregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    @Column(name = "descripcion_mostrar")
    private String descripcionMostrar;

    @Column(name = "id_etapa_postulacion")
    private int idEtapaPostulacion;

}
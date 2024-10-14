package com.metrostaff.formulario.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostulantePostulacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_postulante")
    private Postulante postulante;

    @Column(name = "fecha")
    private Date fecha;

    private String observacion;

    @Column(name = "id_etapa")
    private int idEtapa;

    // Getters y Setters
}
package com.example.ApiVeterinaria.Modelos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Mascota")
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int idmas;

    private String nameMas;

    private  String razaMas;
    private String especie;
    private String colorMas;
    private String pesoMas;
    private int edad;
    private String fecha;
    private  String hora;
    private String servicio;
    private  String sintomas;
    private String diagnostico;
}


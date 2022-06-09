package com.calculadora.SAMIR.Modelo;

import javax.persistence.*;

@Entity
@Table(name = "beneficioAcumulado")
public class BeneficioAcumulado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomeBeneficio;
    private String dataDeInicio;
    private String dataFinal;
    private String rmi;


}

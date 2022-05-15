package com.calculadora.SAMIR.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calculadora.SAMIR.Modelo.Beneficios;

public interface BenefecioRepository extends JpaRepository<Beneficios, Integer>{
	Beneficios findByName(String name);
}


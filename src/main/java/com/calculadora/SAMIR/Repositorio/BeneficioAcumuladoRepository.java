package com.calculadora.SAMIR.Repositorio;

import com.calculadora.SAMIR.Modelo.BeneficioAcumulado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficioAcumuladoRepository extends JpaRepository<BeneficioAcumulado, Integer> {

    BeneficioAcumuladoRepository findByCodigo(int codigo);



}

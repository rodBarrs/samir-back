package com.calculadora.SAMIR.Repositorio;

import com.calculadora.SAMIR.Modelo.CalculoEmLote;
import com.calculadora.SAMIR.Modelo.TaxaDeCorrecao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalculoEmLoteRepository extends JpaRepository <CalculoEmLote, Integer> {

    CalculoEmLote findByName(String name);

    CalculoEmLote findByCodigo(int codigo);

}

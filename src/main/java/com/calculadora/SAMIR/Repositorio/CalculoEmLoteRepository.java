package com.calculadora.SAMIR.Repositorio;

import com.calculadora.SAMIR.Modelo.CalculoEmLote;
import com.calculadora.SAMIR.Modelo.TaxaDeCorrecao;
import com.calculadora.SAMIR.Modelo.UsuarioModelo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalculoEmLoteRepository extends JpaRepository <CalculoEmLote, Integer> {

    CalculoEmLote findByNome(String name);


    CalculoEmLote findByNumeroDoProcesso(String numeroDoProcesso);

    //List<CalculoEmLote> findByUsuario(UsuarioModelo usuario);

    //CalculoEmLote findByUsuarioAndName(UsuarioModelo usuario, String name);
}

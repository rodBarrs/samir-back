package com.calculadora.SAMIR.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calculadora.SAMIR.Modelo.TaxaReajuste;

public interface ReajusteRepositorio extends JpaRepository<TaxaReajuste, Integer> {

	/* pesquisar por tipo de taxa De Correcao */
	List<TaxaReajuste> findByTipo(int tipo);

	/* pesquisa por taxa De Correcao */
	TaxaReajuste findByCodigo(int codigo);

	/* cadastrar taxa De Correcao */
	//<taxaSalvar extends TaxaReajuste> taxaSalvar save(taxaSalvar salvar);

}
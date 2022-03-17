package com.calculadora.SAMIR.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calculadora.SAMIR.Modelo.TaxaDeCorrecao;

public interface CorrecaoRepository extends JpaRepository<TaxaDeCorrecao, Integer> {

	/* pesquisar por tipo de taxa De Correcao */
	List<TaxaDeCorrecao> findByTipo(int tipo);

	/* pesquisa por taxa De Correcao */
	TaxaDeCorrecao findByCodigo(int codigo);

	
	
	List<TaxaDeCorrecao> findByTipoOrderByCodigoAsc(int tipo);
	
	List<TaxaDeCorrecao> findByTipoOrderByDataAsc(int tipo);

	/* cadastrar taxa De Correcao */
//	<taxaSalvar extends taxaDeCorrecao> taxaSalvar save (taxaSalvar salvar);

}
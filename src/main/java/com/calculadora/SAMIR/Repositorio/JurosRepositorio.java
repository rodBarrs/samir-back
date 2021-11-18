package com.calculadora.SAMIR.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calculadora.SAMIR.Modelo.Juros;

public interface JurosRepositorio extends JpaRepository<Juros, Integer> {

	/* pesquisar por tipo de juros */
	List<Juros> findByTipo(Integer tipo);

	/* pesquisa por codigo */
	Juros findByCodigo(Integer codigo);
	
	List<Juros> findByTipoOrderByCodigoAsc(Integer tipo);

	/* cadastrar juros */
	//<JurosSalvar extends Juros> JurosSalvar save(JurosSalvar salvar);

}

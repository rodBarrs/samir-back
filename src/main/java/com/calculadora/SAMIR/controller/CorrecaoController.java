package com.calculadora.SAMIR.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.calculadora.SAMIR.Modelo.Juros;
import com.calculadora.SAMIR.Modelo.Mensagem;
import com.calculadora.SAMIR.Modelo.TaxaDeCorrecao;
import com.calculadora.SAMIR.Repositorio.CorrecaoRepository;

@Controller
@CrossOrigin
@RequestMapping("/correcao")
public class CorrecaoController {

	/* objetos de açao */
	@Autowired
	private CorrecaoRepository repository;

	@GetMapping("/listar")
	public @ResponseBody List<TaxaDeCorrecao> listarTaxaDeCorrecao() {
		return repository.findAll();
	}

	@GetMapping("/procurarPorCodigo/{codigo}")
	public @ResponseBody TaxaDeCorrecao filtrarCorrecaoCodigo(@PathVariable Integer codigo) {
		return repository.findByCodigo(codigo);
	}

	@GetMapping("/procurarPorTipo/{tipo}")
	public @ResponseBody List<TaxaDeCorrecao> filtrarCorrecao(@PathVariable Integer tipo) {
		return repository.findByTipo(tipo);
	}

	@PostMapping("/salvar")
	public @ResponseBody TaxaDeCorrecao savarTaxaDeCorrecao(@RequestBody TaxaDeCorrecao taxa) {
		return repository.save(taxa);
	}

	@DeleteMapping("/deletar/{codigo}")
	public @ResponseBody Mensagem removerTaxaDeCorrecao(@PathVariable Integer codigo) {
		Mensagem respostar = new Mensagem();
		try {
			TaxaDeCorrecao j = filtrarCorrecaoCodigo(codigo);
		this.repository.delete(j);
		respostar.setMensagem("TAXA removido");
		}catch (Exception erro) {
			respostar.setMensagem("Falha na remoçao da TAXA" +erro.getMessage() );
		}
		
		return respostar;
	}

}

package com.calculadora.SAMIR.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.calculadora.SAMIR.Modelo.TaxaDeCorrecao;
import com.calculadora.SAMIR.Repositorio.CorrecaoRepository;

@RestController
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
		return repository.findByTipoOrderByCodigoAsc(tipo);
	}

	@PostMapping("/salvar")
	public @ResponseBody TaxaDeCorrecao savarTaxaDeCorrecao(@RequestBody TaxaDeCorrecao taxa) {
		return repository.save(taxa);
	}

	@DeleteMapping("/deletar/{codigo}")
	public @ResponseBody String removerTaxaDeCorrecao(@PathVariable Integer codigo) {
		try {
			TaxaDeCorrecao j = filtrarCorrecaoCodigo(codigo);
		this.repository.delete(j);
		return"TAXA removido";
		}catch (Exception erro) {
			return"Falha na remoçao da TAXA" +erro.getMessage();
		}
		
	}
	
	@PutMapping("calcular/{valor}/{tipo}/{operacao}")
	public String CalcularParada (@PathVariable("valor") Double valor, @PathVariable("tipo") int tipo, @PathVariable("operacao") String operacao) {
		List<TaxaDeCorrecao> taxasNovas = repository.findByTipo(tipo);

		if (operacao.equals("adicionar")) {
			for (int i = 0; i < taxasNovas.size(); i++) {
				taxasNovas.get(i).setTaxaAcumulada(taxasNovas.get(i).getTaxaAcumulada() * valor);
				repository.save(taxasNovas.get(i));
			}
			return "Multiplicaçao executada";
		} else if (operacao.equals("excluir")) {
			for (int i = 0; i < taxasNovas.size(); i++) {
				taxasNovas.get(i).setTaxaAcumulada(taxasNovas.get(i).getTaxaAcumulada() / valor);
				repository.save(taxasNovas.get(i));
				
			}
			return"Divisao executada";

		}
		
		else {
			return "ERRO falha na execucao";

		}


	}

	
}

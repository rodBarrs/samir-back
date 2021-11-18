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

import com.calculadora.SAMIR.Modelo.Mensagem;
import com.calculadora.SAMIR.Modelo.TaxaReajuste;
import com.calculadora.SAMIR.Repositorio.ReajusteRepositorio;

@RestController
@CrossOrigin
@RequestMapping("/reajuste")
public class ReajusteController {

	@Autowired
	private ReajusteRepositorio repository;

	@GetMapping("/listar")
	public @ResponseBody List<TaxaReajuste> listarTaxaDeReajuste() {
		return repository.findAll();
	}

	@GetMapping("/procurarPorCodigo/{codigo}")
	public @ResponseBody TaxaReajuste filtrarReajusteCodigo(@PathVariable Integer codigo) {
		return repository.findByCodigo(codigo);
	}

	@GetMapping("/procurarPorTipo/{tipo}")
	public @ResponseBody List<TaxaReajuste> filtrarReajuste(@PathVariable Integer tipo) {
		return repository.findByTipoOrderByCodigoAsc (tipo);
	}

	@PostMapping("/salvar")
	public @ResponseBody TaxaReajuste savarTaxaDeResajuste(@RequestBody TaxaReajuste taxa) {

		return repository.save(taxa);
	}

	@DeleteMapping("/deletar/{codigo}")
	public @ResponseBody Mensagem removerTaxaDeReajuste(@PathVariable Integer codigo) {

		Mensagem respostar = new Mensagem();
		try {
			TaxaReajuste j = filtrarReajusteCodigo(codigo);
			this.repository.delete(j);
			respostar.setMensagem("TAXA removido");
		} catch (Exception erro) {
			respostar.setMensagem("Falha na remoçao da TAXA" + erro.getMessage());
		}

		return respostar;
	}

	@PutMapping("calcular/{valor}/{tipo}/{operacao}")
	public Mensagem CalcularParada (@PathVariable("valor") Double valor, @PathVariable("tipo") int tipo, @PathVariable("operacao") String operacao) {
		List<TaxaReajuste> taxasNovas = repository.findByTipo(tipo);
		Mensagem reposta = new Mensagem();

		if (operacao.equals("multiplicacao")) {
			for (int i = 1; i < taxasNovas.size(); i++) {
				taxasNovas.get(i).setTaxaAcumulado(taxasNovas.get(i).getTaxaAcumulado() * valor);
				repository.save(taxasNovas.get(i));
			}
			reposta.setMensagem("Multiplicaçao executada");
			return reposta;
		} else if (operacao.equals("divisao")) {
			for (int i = 0; i < taxasNovas.size(); i++) {
				taxasNovas.get(i).setTaxaAcumulado(taxasNovas.get(i).getTaxaAcumulado() / valor);
				repository.save(taxasNovas.get(i));
				
			}
			reposta.setMensagem("Divisao executada");
			return reposta;

		}
		
		else {
			reposta.setMensagem("ERRO falha na execucao");
			return reposta;

		}


	}
}
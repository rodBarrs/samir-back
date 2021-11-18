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

import com.calculadora.SAMIR.Modelo.Juros;
import com.calculadora.SAMIR.Modelo.Mensagem;
import com.calculadora.SAMIR.Modelo.TaxaDeCorrecao;
import com.calculadora.SAMIR.Repositorio.JurosRepositorio;

@RestController
@CrossOrigin
@RequestMapping("/juros")
public class JurosController {

	@Autowired
	private JurosRepositorio repository;
	@GetMapping("/listar")
	public @ResponseBody List<Juros> listarJuros() {
		return repository.findAll();
	}

	@GetMapping("/procurarPorCodigo/{codigo}")
	public @ResponseBody Juros filtrarJurosPorCodigo(@PathVariable Integer codigo) {
		return repository.findByCodigo(codigo);
	}

	@GetMapping("/procurarPorTipo/{tipo}")
	public @ResponseBody List<Juros> filtrarJurosPorTipo(@PathVariable Integer tipo) {
		return repository.findByTipoOrderByCodigoAsc(tipo);
	}

	@PostMapping("/salvar")
	public @ResponseBody Juros savarJuros(@RequestBody Juros taxa) {
		return repository.save(taxa);
	}

	@DeleteMapping("/deletar/{codigo}")
	public @ResponseBody Mensagem removerJuros(@PathVariable Integer codigo) {
		Mensagem respostar = new Mensagem();
		try {
		Juros j = filtrarJurosPorCodigo(codigo);
		this.repository.delete(j);
		respostar.setMensagem("Juros removido");
		}catch (Exception erro) {
			respostar.setMensagem("Falha na remoçao do Juros" +erro.getMessage() );
		}
		
		return respostar;
	}
	@PutMapping("calcular/{valor}/{tipo}/{operacao}")
	public Mensagem CalcularParada (@PathVariable("valor") Double valor, @PathVariable("tipo") int tipo, @PathVariable("operacao") String operacao) {
		List<Juros> taxasNovas = repository.findByTipo(tipo);
		Mensagem reposta = new Mensagem();

		if (operacao.equals("soma")) {
			for (int i = 0; i < taxasNovas.size(); i++) {
				taxasNovas.get(i).setJurosAcumulados(taxasNovas.get(i).getJurosAcumulados() + valor);
				repository.save(taxasNovas.get(i));
			}
			reposta.setMensagem("Soma executada");
			return reposta;
		} else if (operacao.equals("subtracao")) {
			for (int i = 0; i < taxasNovas.size(); i++) {
				taxasNovas.get(i).setJurosAcumulados(taxasNovas.get(i).getJurosAcumulados() - valor);
				repository.save(taxasNovas.get(i));
				
			}
			reposta.setMensagem("subtracao executada");
			return reposta;

		}
		
		else {
			reposta.setMensagem("ERRO falha na execucao");
			return reposta;

		}


	}

	
}

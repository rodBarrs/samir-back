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
	public @ResponseBody String removerJuros(@PathVariable Integer codigo) {
		try {
		Juros j = filtrarJurosPorCodigo(codigo);
		this.repository.delete(j);
		return "Juros removido";
		}catch (Exception erro) {
			return "Falha na remoçao do Juros" +erro.getMessage();
		}
		
	}
	@PutMapping("calcular/{valor}/{tipo}/{operacao}")
	public String CalcularParada (@PathVariable("valor") Double valor, @PathVariable("tipo") int tipo, @PathVariable("operacao") String operacao) {
		List<Juros> taxasNovas = repository.findByTipo(tipo);

		if (operacao.equals("adicionar")) {
			for (int i = 0; i < taxasNovas.size(); i++) {
				taxasNovas.get(i).setJurosAcumulados(taxasNovas.get(i).getJurosAcumulados() + valor);
				repository.save(taxasNovas.get(i));
			}
			return "Soma executada";
		} else if (operacao.equals("excluir")) {
			for (int i = 0; i < taxasNovas.size(); i++) {
				taxasNovas.get(i).setJurosAcumulados(taxasNovas.get(i).getJurosAcumulados() - valor);
				repository.save(taxasNovas.get(i));
				
			}
			return "subtracao executada";

		}
		
		else {
			return "ERRO falha na execucao";

		}


	}

	
}

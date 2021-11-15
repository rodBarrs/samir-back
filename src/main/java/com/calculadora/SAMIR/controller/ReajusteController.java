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

import com.calculadora.SAMIR.Modelo.TaxaReajuste;
import com.calculadora.SAMIR.Repositorio.ReajusteRepositorio;

@Controller
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
		return repository.findByTipo(tipo);
	}

	@PostMapping("/salvar/{tipo}")
	public @ResponseBody TaxaReajuste savarTaxaDeResajuste(@RequestBody TaxaReajuste taxa) {
		return repository.save(taxa);
	}

	@DeleteMapping("/deletar/{codigo}")
	public @ResponseBody void removerTaxaDeReajuste(@PathVariable Integer codigo) {
		TaxaReajuste j = filtrarReajusteCodigo(codigo);
		this.repository.delete(j);
	}

}

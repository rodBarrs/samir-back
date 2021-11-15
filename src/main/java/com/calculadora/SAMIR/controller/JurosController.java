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
import com.calculadora.SAMIR.Repositorio.JurosRepositorio;

@Controller
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
		return repository.findByTipo(tipo);
	}

	@PostMapping("/salvar/{taxa}")
	public @ResponseBody Juros savarJuros(@RequestBody Juros taxa) {
		return repository.save(taxa);
	}

	@DeleteMapping("/deletar/{codigo}")
	public @ResponseBody void removerJuros(@PathVariable Integer codigo) {
		Juros j = filtrarJurosPorCodigo(codigo);
		this.repository.delete(j);
	}

}

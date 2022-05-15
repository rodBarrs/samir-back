package com.calculadora.SAMIR.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.calculadora.SAMIR.Modelo.Beneficios;
import com.calculadora.SAMIR.Repositorio.BenefecioRepository;

@RestController
@CrossOrigin
@RequestMapping("/beneficio")
public class BeneficioController {

	@Autowired
	private BenefecioRepository repository;
	
	@GetMapping("/listar")
	public @ResponseBody List<Beneficios> listarBEneficios() {
		return repository.findAll();
	}
	
	@PostMapping("/ProcurarPorName")
	public @ResponseBody Beneficios procurarPorName(@RequestBody String name) {
		return repository.findByName(name);
		
	}
	@PostMapping("/salvar")
	public @ResponseBody Beneficios salvarBeneficio(@RequestBody Beneficios beneficio) {
		return repository.save(beneficio);
	}
	@PostMapping("/salvarLista")
	public @ResponseBody List<Beneficios> salvarLista(@RequestBody List<Beneficios> list){
		return repository.saveAll(list);
	}
}

package com.calculadora.SAMIR.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.calculadora.SAMIR.Modelo.SalarioMinimo;
import com.calculadora.SAMIR.Repositorio.SalarioMinimoRepository;

@RestController
@CrossOrigin
@RequestMapping("/salarioMinimo")
public class SalarioMinimoController {
	@Autowired
	private SalarioMinimoRepository repository;
	
	@GetMapping("/listar")
	public @ResponseBody List<SalarioMinimo> listarSalarioMinimo() {
		return repository.findAll();
	};	
	@GetMapping("/procuraPorAno/{data}")
	public @ResponseBody List<SalarioMinimo> listarSalrioAno(@PathVariable Integer data){
		List<SalarioMinimo>listaTudo = repository.findAll();
		List<SalarioMinimo> lista = new ArrayList<SalarioMinimo>();
		for(int i = 0; i < listaTudo.size(); i++) {
			if(listaTudo.get(i).getData().getYear() == data) {
				lista.add(listaTudo.get(i));
			}
		}
		return lista;
	}
}

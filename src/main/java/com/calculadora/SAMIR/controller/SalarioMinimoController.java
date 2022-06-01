package com.calculadora.SAMIR.controller;

import java.security.PublicKey;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
			String strDate = dateFormat.format(listaTudo.get(i).getData());
			int ano = Integer.parseInt(strDate.split("T")[0].split("-")[0]);
			System.out.println("ano: " + ano);
			if(ano == data) {
				lista.add(listaTudo.get(i));
			}
		}
		return lista;
	}
	@PostMapping("/salvarall")
	public @ResponseBody List<SalarioMinimo> salvarLista(@RequestBody List<SalarioMinimo> lista){
		return repository.saveAll(lista);
		
	}
	@PostMapping("/salvar")
	public @ResponseBody SalarioMinimo salvar ( @RequestBody SalarioMinimo salario) {
		return repository.save(salario);
	}
}

package com.calculadora.SAMIR.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.calculadora.SAMIR.Modelo.UsuarioModelo;
import com.calculadora.SAMIR.Repositorio.UsuarioRepository;

@RestController
@CrossOrigin
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping("/listar")
	public @ResponseBody List<UsuarioModelo> listar(){
		return repository.findAll();
	}
	
	@GetMapping("/nome/{nome}")
	public @ResponseBody UsuarioModelo nome(@PathVariable("nome") String nome) {
		return repository.findByNome(nome);
	}
	
	@GetMapping("/cpf/{cpf}")
	public @ResponseBody UsuarioModelo cpf(@PathVariable("cpf") String cpf) {
		return repository.findByCpf(cpf);
	}
	
	@PostMapping("/salvar")
	public @ResponseBody UsuarioModelo salvar(@RequestBody UsuarioModelo usuario) {
		return repository.save(usuario);
	}
	
	@PutMapping("/salvar")
	public @ResponseBody UsuarioModelo alterar(@RequestBody UsuarioModelo usuario) {
		return repository.save(usuario);
	}
}

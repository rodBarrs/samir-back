package com.calculadora.SAMIR.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.calculadora.SAMIR.Modelo.LoginModelo;
import com.calculadora.SAMIR.Repositorio.SeleniumRepositorio;

@RestController
@CrossOrigin
@RequestMapping("/procurar")
public class TesteController {
	
		@Autowired
		private SeleniumRepositorio repository;
		
		@PostMapping("/open")
		public @ResponseBody void open(@RequestBody LoginModelo login) throws InterruptedException {
			repository.open(login);	
			
		}
		
		@PostMapping("/procurar")
		public @ResponseBody String procurar (@RequestBody LoginModelo login){
			return repository.teste(login);
		}
		@PostMapping("/procurar1")
		public @ResponseBody String procurar1(@RequestBody LoginModelo login){
			 return repository.teste1(login);
			
		}


		
		@GetMapping("/quit")
		public @ResponseBody void quit() {
			 repository.quit();
		}
		
	
}

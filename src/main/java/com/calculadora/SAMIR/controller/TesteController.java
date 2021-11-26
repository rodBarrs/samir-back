package com.calculadora.SAMIR.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.calculadora.SAMIR.Repositorio.SeleniumRepositorio;

@RestController
@CrossOrigin
@RequestMapping("/procurar")
public class TesteController {
	
		@Autowired
		private SeleniumRepositorio repository;
		
		@GetMapping("/open")
		public @ResponseBody String soma() throws InterruptedException {
			String url;
			url =  "https://marcelodebittencourt.com/demopages/demosimplesearch/";
			return repository.open(url);
			
			
			
		}
		/*@GetMapping("/inserir")
		public @ResponseBody void subtracao() {
			
			 repository.pesquisa();
		}*/
		
		@GetMapping("/quit")
		public @ResponseBody void quit() {
			 repository.quit();
		}
		
	
}

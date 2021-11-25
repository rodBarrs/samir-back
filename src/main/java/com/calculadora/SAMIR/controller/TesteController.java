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
		public @ResponseBody void open() {
			String url;
			url =  "https://pt-br.facebook.com/";
			 repository.open(url);
		}
		
		@GetMapping("/quit")
		public @ResponseBody void quit() {
			 repository.quit();
		}
		
	
}

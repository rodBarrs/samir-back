package com.calculadora.SAMIR.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.calculadora.SAMIR.Modelo.InfomacoesDosPrev;
import com.calculadora.SAMIR.Modelo.LoginModelo;
import com.calculadora.SAMIR.Repositorio.SeleniumRepositorio;

@RestController
@CrossOrigin
@RequestMapping("/procurar")
public class TesteController {
	
		@Autowired
		private SeleniumRepositorio repository;
		
		@PostMapping("/open")
		public @ResponseBody String open(@RequestBody LoginModelo login) throws InterruptedException {
			return repository.open(login);	
			
		}
		@GetMapping("/colocarFiltro")
		public @ResponseBody String colocarFiltro() {
			 return repository.colocarFiltro();
		}
		

		@GetMapping("/entrarNosProcessos")
		public @ResponseBody String entrarNosProcessos() {
			 return repository.entrarNoProcessoAutomatico();
		}
		
		@PostMapping("/procurarProcesso")
		public @ResponseBody String procurarProcesso (@RequestBody LoginModelo login){
			return repository.procurarProcesso(login);
		}
		@GetMapping("/procurarDosPrev")
		public @ResponseBody InfomacoesDosPrev ProcurarDosPrev(){
			 return repository.procurarDosPrev();
			
		}
		
		
		@PostMapping("/executarTarefa")
		public @ResponseBody String executarTarefa (@RequestBody LoginModelo login){
			return repository.procurarProcesso(login);
		}
		
		


		
		@GetMapping("/quit")
		public @ResponseBody void quit() {
			 repository.quit();
		}
		
	
}

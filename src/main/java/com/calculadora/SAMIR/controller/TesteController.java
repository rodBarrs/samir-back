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
		public @ResponseBody String colocarFiltro() throws InterruptedException {
			 return repository.colocarFiltro();
		}
		

		@GetMapping("/entrarNosProcessos")
		public @ResponseBody String entrarNosProcessos() throws InterruptedException {
			 return repository.entrarNoProcessoAutomatico();
		}
		
		@PostMapping("/procurarProcesso")
		public @ResponseBody String procurarProcesso (@RequestBody LoginModelo login){
			return repository.procurarProcesso(login);
		}
		@GetMapping("/validarDosPrev")
		public @ResponseBody Boolean validarDosPrev() throws InterruptedException {
			 return repository.dataDeValidacaoDosPrev();
			
		}
		
		@PostMapping("/teste")
		public @ResponseBody InfomacoesDosPrev[] teste(@RequestBody LoginModelo login) throws InterruptedException{
			repository.open(login);
			repository.colocarFiltro();
			InfomacoesDosPrev[] lista = new InfomacoesDosPrev[100];
			int x = 0;
			boolean validacao;
			while("Sem registros para exibir" != repository.entrarNoProcessoAutomatico()) {
				validacao = repository.dataDeValidacaoDosPrev();
				if ( validacao == true) {
					lista[x] = repository.procurarDosPrev();
					repository.etiquetar(validacao);
					x++;
				}
				else {
					repository.etiquetar(validacao);
				}
			}
			
			 return lista;
			
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

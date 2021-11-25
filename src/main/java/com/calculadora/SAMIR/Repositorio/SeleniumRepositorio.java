package com.calculadora.SAMIR.Repositorio;

import org.springframework.stereotype.Service;

import com.calculadora.SAMIR.Modelo.SeleniumTeste;

@Service
public class SeleniumRepositorio {
	
	SeleniumTeste web = new SeleniumTeste();
	
	public void open(String url) {
		 web.driver.get(url);
	}
	
	public void quit() {
		 web.driver.quit();
	}

}

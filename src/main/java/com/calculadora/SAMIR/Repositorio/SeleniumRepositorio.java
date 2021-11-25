package com.calculadora.SAMIR.Repositorio;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import com.calculadora.SAMIR.Modelo.SeleniumTeste;

@Service
public class SeleniumRepositorio {
	
	SeleniumTeste web = new SeleniumTeste();
	
	WebDriver driver = null;
	
	public void open(String url) {
	 driver = new ChromeDriver();
		driver.get(url);
	}
	
	public void quit() {
		 driver.quit();
	}

}

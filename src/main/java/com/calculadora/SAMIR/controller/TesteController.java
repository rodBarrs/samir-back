package com.calculadora.SAMIR.controller;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/procurar")
public class TesteController {
	/*public WebDriver driver; 
	public TesteController() {
		this.driver = new ChromeDriver();
	}
	
	@PostMapping("/teste1/{ativador}")
	public @ResponseBody String teste1(@PathVariable Integer ativador) {
		while(ativador == 1) {
		String url = "https://www.facebook.com";
		driver.get(url);
		driver.quit();
		}
		
		return("funciona");
	}
*/
}

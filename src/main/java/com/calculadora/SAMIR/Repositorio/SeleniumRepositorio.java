package com.calculadora.SAMIR.Repositorio;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

@Service
public class SeleniumRepositorio {
	
	
	WebDriver driver = null;
	
	public void open(String url) {
	 driver = new ChromeDriver();
		driver.get(url);
	}
	
	public void quit() {
		 driver.quit();
	}

}

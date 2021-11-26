package com.calculadora.SAMIR.Repositorio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

@Service
public class SeleniumRepositorio {
	
	
	WebDriver driver = null;
	
	public void open(String url) throws InterruptedException {
	 driver = new ChromeDriver();
		driver.get(url);
		
		Thread.sleep(3000); 
	}
	
	public void quit() {
		 driver.quit();
	}

}

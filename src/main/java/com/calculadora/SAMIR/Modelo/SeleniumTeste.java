package com.calculadora.SAMIR.Modelo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class SeleniumTeste {
	
	public static WebDriver driver = new ChromeDriver();
	
	public static void HelloWord() {
		
		
		
		driver.navigate().to("https://www.facebook.com");
		driver.quit();
	}

}

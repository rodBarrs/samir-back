package com.calculadora.testes;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTeste {
	@Test
	public void HelloWord() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AGU\\Downloads\\heroku\\SAMIR\\drivers\\chromedriver.exe" );
		WebDriver driver = new ChromeDriver();
		
		
		driver.navigate().to("https://www.facebook.com");
		driver.quit();
	}


}
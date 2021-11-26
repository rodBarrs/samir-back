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
		String emailPath = "#email";
		
		WebElement emailElemt =   driver.findElement(By.cssSelector(emailPath));
		
		emailElemt.sendKeys("moisesjt@r7.com");
		String senhaPath = "pass";
		WebElement senhaElemt =   driver.findElement(By.id(senhaPath));
		senhaElemt.sendKeys("93034554jt");
		String butonPath = "/html/body/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/button";
		WebElement butonElem =   driver.findElement(By.xpath(butonPath));
		butonElem.click();
		Thread.sleep(3000); 
	}
	
	public void quit() {
		 driver.quit();
	}

}

package com.calculadora.SAMIR.Repositorio;





import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

@Service
public class SeleniumRepositorio {
	
	
	WebDriver driver;
	
	

	public String open(String url) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get(url);
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS).pageLoadTimeout(10,TimeUnit.SECONDS );
		
		
		String campoUserPath = "/html/body/div[1]/div[1]/div/div/div[2]/div/div/div/table[1]/tbody/tr/td[2]/input";
		WebElement campoUserElemt = driver.findElement(By.xpath(campoUserPath));
		String user = "039.669.222-23";
		campoUserElemt.sendKeys(user);
		
		
		String campoPassPath = "/html/body/div[1]/div[1]/div/div/div[2]/div/div/div/table[2]/tbody/tr/td[2]/input";
		WebElement campoPassElemt = driver.findElement(By.xpath(campoPassPath));
		String pass = "AfonsoSoVacuo1";
		campoPassElemt.sendKeys(pass);

		String sendLoginPath = "button-1019-btnIconEl";
        WebElement sendLoginElem = driver.findElement(By.id(sendLoginPath));
		sendLoginElem.click();
		
		WebElement resultado = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div/div[1]/div[1]/div[2]/div/a[2]/span/span/span[1]"));

		Thread.sleep(5000);
		return resultado.getText();
	}
	
	public void quit() {
		 driver.quit();
	}

}

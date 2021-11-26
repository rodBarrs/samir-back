package com.calculadora.SAMIR.Repositorio;





import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

@Service
public class SeleniumRepositorio {
	
	
	WebDriver driver = null;
	
	public String open(String url) throws InterruptedException {
	 driver = new ChromeDriver();
		driver.get(url);
		String campoPath = "textbox";
		
		WebElement campoElemt =   driver.findElement(By.id(campoPath));
		String  verificar = "selenium";
		campoElemt.sendKeys(verificar);
	
		String butonPath = "button1";
		WebElement butonElem =   driver.findElement(By.id(butonPath));
		butonElem.click();
		WebElement resultado = driver.findElement(By.id("result"));
		
		Thread.sleep(3000); 
		return resultado.getText();
	}
	
	public void quit() {
		 driver.quit();
	}

}

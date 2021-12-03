package com.calculadora.SAMIR.Repositorio;








import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import com.calculadora.SAMIR.Modelo.LoginModelo;

@Service
public class SeleniumRepositorio {
	
	
	WebDriver driver;
	//LoginModelo usuario = new LoginModelo();
	
	

	public void open(LoginModelo usuario) throws InterruptedException {
		String url = "https://sapiens.agu.gov.br/login";
		driver = new ChromeDriver();
		driver.get(url);
		this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS).pageLoadTimeout(15,TimeUnit.SECONDS );
		
		
		String campoUserPath = "/html/body/div[1]/div[1]/div/div/div[2]/div/div/div/table[1]/tbody/tr/td[2]/input";
		WebElement campoUserElemt = driver.findElement(By.xpath(campoUserPath));
		//String user = "039.669.222-23";
		campoUserElemt.sendKeys(usuario.getUser());
		
		
		String campoPassPath = "/html/body/div[1]/div[1]/div/div/div[2]/div/div/div/table[2]/tbody/tr/td[2]/input";
		WebElement campoPassElemt = driver.findElement(By.xpath(campoPassPath));
		//String pass = "AfonsoSoVacuo1";
		campoPassElemt.sendKeys(usuario.getPass());

		String sendLoginPath = "button-1019-btnIconEl";
        WebElement sendLoginElem = driver.findElement(By.id(sendLoginPath));
		sendLoginElem.click();
		
		
		
	
		
		
	}
	
	public  String teste(LoginModelo usuario) {
		this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS).pageLoadTimeout(15,TimeUnit.SECONDS );
		WebElement seta1 = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div/div[2]/div/div[3]/div/div/div[3]/div"));
		seta1.click();
		WebElement seta = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div/div[2]/div/div[3]/div/div/div[3]/div/div"));
		seta.click();
		
		WebElement filtro = driver.findElement(By.xpath("/html/body/div[11]/div/div[2]/div/div[6]/a"));
		filtro.click();
		WebElement filtroEs = driver.findElement(By.xpath("/html/body/div[13]/div/div[2]/div/table/tbody/tr/td[2]/input"));
		// /html/body/div[13]/div/div[2]/div/table/tbody/tr/td[2]/input                                                /html/body/div[13]/div/div[2]/div/table/tbody/tr/td[2]/input
		filtroEs.click();
		filtroEs.sendKeys(usuario.getProcesso());
		WebElement preocessoElement = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div/div[2]/div/div[4]/div/table/tbody/tr/td[3]/div/a[1]"));
		preocessoElement.click();
		
		//WebElement dosPrev = this.driver.findElement(By.cssSelector(" span[id*=DOSSIÊ PREVIDENCIÁRIO]"));
		//dosPrev.click();
				//WebElement colunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
		
		
		return "deu certo";
		
		
		
	}
	public  String teste1(LoginModelo usuario) throws UnsupportedEncodingException {
	
	    return "deu certo";
		
	}
	
	
	
	public void quit() {
		 driver.quit();
	}

}

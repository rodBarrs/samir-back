package com.calculadora.SAMIR.Repositorio;





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
		this.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS).pageLoadTimeout(60,TimeUnit.SECONDS );
		
		
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
		String resultadoPath ="/html/body/div[4]/div[1]/div[2]/div/div[2]/div/div[4]/div/table/tbody/tr[1]/td[3]/div/a[1]";
		WebElement resultado = driver.findElement(By.xpath(resultadoPath));
		
		String processo = new String(resultado.getText());
		String usuarioProcesso = new String(usuario.getProcesso());
		if(processo == usuarioProcesso ) {
			return "deu certo";
		}
		else {
			return "usario: " + usuario.getProcesso() + "processo: " + processo;
		}
		
	}
	public void quit() {
		 driver.quit();
	}

}

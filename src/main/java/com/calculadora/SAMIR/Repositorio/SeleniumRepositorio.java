package com.calculadora.SAMIR.Repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.stereotype.Service;

import com.calculadora.SAMIR.Modelo.LoginModelo;

@Service
public class SeleniumRepositorio {

	WebDriver driver;

	public String open(LoginModelo usuario) throws InterruptedException {

		String url = "https://sapiens.agu.gov.br/login";
		System.setProperty("webdriver.gecko.driver", "GeckoDriver.exe");
		driver = new FirefoxDriver();
		driver.get(url);
		this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS).pageLoadTimeout(15, TimeUnit.SECONDS);

		String campoUserPath = "/html/body/div[1]/div[1]/div/div/div[2]/div/div/div/table[1]/tbody/tr/td[2]/input";
		WebElement campoUserElemt = driver.findElement(By.xpath(campoUserPath));
		// String user = "039.669.222-23";
		campoUserElemt.sendKeys(usuario.getUser());

		String campoPassPath = "/html/body/div[1]/div[1]/div/div/div[2]/div/div/div/table[2]/tbody/tr/td[2]/input";
		WebElement campoPassElemt = driver.findElement(By.xpath(campoPassPath));
		// String pass = "AfonsoSoVacuo1";
		campoPassElemt.sendKeys(usuario.getPass());

		String sendLoginPath = "button-1019-btnIconEl";
		WebElement sendLoginElem = driver.findElement(By.id(sendLoginPath));
		sendLoginElem.click();

		boolean confirmacaoDeLogin1 = driver
				.findElement(
						By.xpath("/html/body/div[4]/div[1]/div[2]/div/div[1]/div[1]/div[2]/div/a[2]/span/span/span[1]"))
				.getText().toUpperCase().contains("Tramitações");
		boolean confirmacaoDeLogin2 = driver
				.findElement(
						By.xpath("/html/body/div[4]/div[1]/div[2]/div/div[1]/div[1]/div[2]/div/a[3]/span/span/span[1]"))
				.getText().toUpperCase().contains("Comunicações");

		if (confirmacaoDeLogin1 == true && confirmacaoDeLogin2 == true) {
			return driver
					.findElement(By.xpath(
							"/html/body/div[4]/div[1]/div[2]/div/div[1]/div[1]/div[2]/div/a[2]/span/span/span[1]"))
					.getText();
		} else {
			return "ACESSO NEGADO";
		}

	}

	public String colocarFiltro() {
		WebElement setaAparecer = driver.findElement(
				By.xpath("/html/body/div[4]/div[1]/div[2]/div/div[2]/div[1]/div[3]/div/div/div[33]/div/span"));
		setaAparecer.click();
		WebElement seta = driver.findElement(
				By.xpath("/html/body/div[4]/div[1]/div[2]/div/div[2]/div[1]/div[3]/div/div/div[33]/div/div"));
		seta.click();

		WebElement filtro = driver.findElement(By.xpath("/html/body/div[11]/div/div[2]/div/div[6]/a/div[1]"));
		filtro.click();
		WebElement filtroEs = driver.findElement(By.xpath("/html/body/div[13]/div/div[2]"));
		filtroEs.click();
		WebElement filtroSpace = driver
				.findElement(By.xpath("/html/body/div[13]/div/div[2]/div/table/tbody/tr/td[2]/input"));
		filtroSpace.click();
		filtroSpace.sendKeys("SAMIR");

		return "fitro colocado";

	}

	public String entrarNoProcessoAutomatico() {

		boolean confirmacaoDeExistencia = driver
				.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div/div[2]/div[1]/div[2]/div/div/div[7]"))
				.getText().toUpperCase().contains("Sem registros para exibir");
		if (confirmacaoDeExistencia == true) {
			return "Sem registros para exibir";
		}

		boolean confirmacaoDeAtivacao = driver
				.findElement(By.xpath(
						"/html/body/div[4]/div[1]/div[2]/div/div[2]/div[1]/div[4]/div/table/tbody/tr[1]/td[9]/div"))
				.getText().toUpperCase().contains("SAMIR");
		if (confirmacaoDeAtivacao == false) {
			return "Codigo das eiquetas estao errados";
		}

		WebElement processo = driver.findElement(By.xpath(
				"/html/body/div[4]/div[1]/div[2]/div/div[2]/div[1]/div[4]/div/table/tbody/tr[1]/td[3]/div/a[1]"));
		processo.click();
		return "pronto para procurar";

	}

	public String procurarProcesso(LoginModelo usuario) {
		this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS).pageLoadTimeout(15, TimeUnit.SECONDS);
		WebElement seta1 = driver
				.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div/div[2]/div/div[3]/div/div/div[3]/div"));
		seta1.click();
		WebElement seta = driver
				.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div/div[2]/div/div[3]/div/div/div[3]/div/div"));
		seta.click();

		WebElement filtro = driver.findElement(By.xpath("/html/body/div[11]/div/div[2]/div/div[6]/a"));
		filtro.click();
		WebElement filtroEs = driver
				.findElement(By.xpath("/html/body/div[13]/div/div[2]/div/table/tbody/tr/td[2]/input"));
		// /html/body/div[13]/div/div[2]/div/table/tbody/tr/td[2]/input
		// /html/body/div[13]/div/div[2]/div/table/tbody/tr/td[2]/input
		filtroEs.click();
		filtroEs.sendKeys(usuario.getProcesso());

		WebElement preocessoElement = driver.findElement(
				By.xpath("/html/body/div[4]/div[1]/div[2]/div/div[2]/div/div[4]/div/table/tbody/tr/td[3]/div/a[1]"));
		preocessoElement.click();

		// WebElement dosPrev = this.driver.findElement(By.cssSelector(" span[id*=DOSSIÊ
		// PREVIDENCIÁRIO]"));
		// dosPrev.click();
		// WebElement colunaNome =
		// linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));

		return "pronto para fazer a leitura";

	}

	public String procurarDosPrev() {
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS).pageLoadTimeout(30, TimeUnit.SECONDS);
		List<String> janela = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(janela.get(1));
		WebElement TabelaTref = driver.findElement(By.id("treeview-1015"));
		List<WebElement> listaMovimentacao = new ArrayList<WebElement>(TabelaTref.findElements(By.cssSelector("tr")));
		for (int i = 2; i < listaMovimentacao.size(); i++) {

			// Providência Jurídica é o título da movimentação
			Boolean existeDosPrev = driver.findElement(By.xpath("//tr[" + i + "]/td[2]/div/span")).getText()
					.toUpperCase().contains("DOSSIÊ PREVIDENCIÁRIO");
			if (existeDosPrev == true) {
				driver.switchTo().window(janela.get(1)).close();
				driver.switchTo().window(janela.get(0));
				return "dados colhidos";
			}
		}
		return "erro grave analise";
		// driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL.TAB);

		/*
		 * WebElement TabelaTref = driver.findElement(By.id("treeview-1015"));
		 * List<WebElement> listaMovimentacao = new
		 * ArrayList<WebElement>(TabelaTref.findElements(By.cssSelector("tr"))); for
		 * (int i = 2; i < listaMovimentacao.size(); i++) {
		 * 
		 * // Providência Jurídica é o título da movimentação Boolean
		 * existeDossiePrevidenciario = driver.findElement(By.xpath("//tr[" + i +
		 * "]/td[2]/div/span")).getText()
		 * .toUpperCase().contains("DOSSIÊ PREVIDENCIÁRIO");
		 * 
		 * if(existeDossiePrevidenciario == true) {
		 * 
		 * WebElement dosPrev = driver.findElement(By.xpath("//tr[" + i +
		 * "]/td[2]/div/span")); dosPrev.click(); WebElement TabelaDosPrev =
		 * driver.findElement(By.id("iframe-myiframe")); List<WebElement> listaDosPrev =
		 * new ArrayList<WebElement>(TabelaDosPrev.findElements(By.cssSelector("tr")));
		 * WebElement data =
		 * driver.findElement(By.xpath("html/body/div/div[1]/table/tbody/tr[2]/td"));
		 * return data.getText(); for (int y = 2; y < listaDosPrev.size(); y++) {
		 * 
		 * // Providência Jurídica é o título da movimentação Boolean existeData =
		 * driver.findElement(By.xpath("//tr[" + y + "]/th")).getText()
		 * .toUpperCase().contains("DATA AJUIZAMENTO"); System.out.println("//tr[" + y +
		 * "]");
		 * 
		 * WebElement data =
		 * driver.findElement(By.xpath("html/body/div/div[1]/table/tbody/tr[2]/td"));
		 * return data.getText(); if(existeData == true) {
		 * 
		 * WebElement data = driver.findElement(By.xpath("//tr[" + y + "]/td"));
		 * System.out.println(data.getText()); data.click();
		 * ///html/body/div[2]/div[2]/div/div[2]/div/div[3]/div/table/tbody/tr[13]/td[2]
		 * /div/span/span[1] ////html/body/div/div[1]/table/tbody/tr[2]/td
		 * ///html/body/div/div[1]/table/tbody/tr[3]/td
		 * ///html/body/div/div[1]/table/tbody/tr[2]/td
		 * ///html/body/div/div[1]/table/tbody/tr[2]/th
		 * ///html/body/div/div[1]/table/tbody/tr[2]/td
		 * 
		 * return data.getText(); } else if(y == listaDosPrev.size() -1 ) { return
		 * "fodeu"; } }
		 * 
		 * //return "deu certo"; } }
		 */

	}

	public void quit() {
		driver.quit();
	}

}

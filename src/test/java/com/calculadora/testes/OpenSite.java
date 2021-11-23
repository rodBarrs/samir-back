package com.calculadora.testes;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenSite {
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AGU\\Downloads\\heroku\\SAMIR\\drivers\\chromedriver.exe" );
		driver = new ChromeDriver();
		driver.navigate().to("https://www.google.com/search?q=selenium+java+abrir+o+google&sxsrf=AOaemvIxFrbhY87TLZVHjW7kblmsCynedw:1637602517424&source=lnms&tbm=vid&sa=X&ved=2ahUKEwis0NXiwKz0AhU8lJUCHSlAA64Q_AUoAXoECAEQAw&biw=1536&bih=754&dpr=1.25");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}

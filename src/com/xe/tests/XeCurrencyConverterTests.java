package com.xe.tests;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.xe.webpages.XeCurrencyConverter;


public class XeCurrencyConverterTests {

	static WebDriver driver;
	XeCurrencyConverter currencyConverterPage;
	static String driver_url = "C:\\geckodriver.exe";
	private static String PAGE_URL = "https://www.xe.com/currencyconverter/convert/?Amount=1&From=EUR&To=PLN";
	
	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.gecko.driver", driver_url);
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(PAGE_URL);
	}

	@Test
	public void setMoneyToBeConverted() {
		currencyConverterPage = new XeCurrencyConverter(driver);

		//Check if the page is open
		AssertJUnit.assertTrue(currencyConverterPage.isPageOpen());

		//Set the money to be exchanged
		currencyConverterPage.setMoneyToBeExchanged("10");

	}
	
//	@AfterClass
//	public void close() {
//		driver.close();
//	}

}

package com.xe.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class XeCurrencyConverter {
	
	private WebDriver driver;

	// Find text box to inform the amount of money to be exchanged
	@FindBy(xpath = "//*[@id=\"amount\"]")
	private WebElement textBoxCurrency;

	// Main head to check if the page was opened in a right way
	@FindBy(id = "main-heading")
	private WebElement maingHeading;

	//Find the value after conversion
	@FindBy(xpath = "//*[@id=\"converterResult\"]/div/div/div[2]/span[1]")
	private WebElement convertedAmount;

	public XeCurrencyConverter(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Check if the right page is open
	public boolean isPageOpen() {
		return maingHeading.getText().toString().toLowerCase().contains("xe currency converter");
	}
	
	// Set the money to be converted
	public void setMoneyToBeExchanged(String money) {
		textBoxCurrency.clear();
		textBoxCurrency.sendKeys(money);
	}
	

}

package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
	
	WebDriver driver;
	
	@FindBy(linkText="HP LP3065")
	private WebElement validProduct;
	
	@FindBy(xpath="//input[@id='button-search']/following-sibling::p")
	private WebElement noProductMessage;
	
	
	public String retreiveNoProductMessageText() {
		String noProductMessageText=noProductMessage.getText();
		return noProductMessageText;
	}
	
	
	
	public boolean displayStatusOfValidProduct() {
		boolean displayStatus=validProduct.isDisplayed();
		return displayStatus;
	}
	
	
	public SearchResultsPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

}

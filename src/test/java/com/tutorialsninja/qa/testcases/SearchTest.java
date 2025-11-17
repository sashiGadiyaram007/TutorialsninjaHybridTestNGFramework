package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchResultsPage;

public class SearchTest extends Base {
	
	public WebDriver driver;
	HomePage homePage;
	SearchResultsPage searchResultsPage;
	
	public SearchTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		driver=initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
		homePage=new HomePage(driver);
		
	}
	
	
	
	@Test(priority=1)
	public void verifySearchWithValidProduct() {
		
		searchResultsPage=homePage.searchForAProduct(dataProp.getProperty("validProduct"));
		Assert.assertTrue(searchResultsPage.displayStatusOfValidProduct(),"Valid Product is not displayed");
	}
	
	@Test(priority=2)
	public void verifySearchWithInvalidProduct() {
		
		searchResultsPage=homePage.searchForAProduct(dataProp.getProperty("inValidProduct"));
		Assert.assertEquals(searchResultsPage.retreiveNoProductMessageText(),"abcd", "No Search Results are Displayed");
		
	}
	
	@Test(priority=3,dependsOnMethods= {"verifySearchWithValidProduct","verifySearchWithInvalidProduct"})
	public void verifySearchWithoutEnteringAnyProduct() {
		
		searchResultsPage=homePage.clickOnSearchButton();
		Assert.assertEquals(searchResultsPage.retreiveNoProductMessageText(),dataProp.getProperty("noProductTextInSearchResult"), "No Search Results are Displayed");
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;

public class LoginTest extends Base {
	public WebDriver driver;
	LoginPage loginPage;
	AccountPage accountPage;

	public LoginTest() {
		super();
		
		
	}

    @BeforeMethod
	public void setup() {
    	
    	driver=initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
    	
    	HomePage homePage=new HomePage(driver);
    	loginPage=homePage.navigateToLoginPage();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1,dataProvider="valueSupplierData")
	public void verifyLoginWithValidCredentials(String email, String password) {
		
		accountPage = loginPage.login(email, password);
		Assert.assertTrue(accountPage.getDisplayStatusOfAccountInformationOption(),"Account page is not displayed");
			
		
	}
	
	@DataProvider(name="valueSupplierData")
	public static Object[][] supplyTestData() {
		
		Object [][]data= Utilities.getTestDataFromExcel("Login");
		return data;
		
		
	}
	
	
	
	
	
	@Test(priority=2)
	public void verifyLoginWithInvalidCredentials()  {
		
		accountPage = loginPage.login(Utilities.generateTimeStamp(), dataProp.getProperty("invalidPassword"));
		Assert.assertTrue(loginPage.retreiveWarningMessageText().contains(dataProp.getProperty("emailPasswordNoMatchWarning")),"Expected Warning Message is Displayed");
			
	}
	
	@Test(priority=3)
	public void verifyLoginWithInvalidEmailAndValidPassword() {
		
		accountPage=loginPage.login(Utilities.generateTimeStamp(), prop.getProperty("validPassword"));
		Assert.assertTrue(loginPage.retreiveWarningMessageText().contains(dataProp.getProperty("emailPasswordNoMatchWarning")),"Expected Warning Message is Displayed");
		
	}
	
	@Test(priority=4)
	public void verifyLoginWithValidEmailAndInvalidPassword() {
		
		accountPage=loginPage.login(prop.getProperty("validEmail"), dataProp.getProperty("invalidPassword"));
		Assert.assertTrue(loginPage.retreiveWarningMessageText().contains(dataProp.getProperty("emailPasswordNoMatchWarning")),"Expected Warning Message is Displayed");
	
	}
	
	@Test(priority=5)
	public void verifyLoginWithoutProvidingAnyDetails() {
		
		loginPage.clickOnLoginButton();
		Assert.assertTrue(loginPage.retreiveWarningMessageText().contains(dataProp.getProperty("emailPasswordNoMatchWarning")),"Expected Warning Message is Displayed");
		
	}
	
	
	
	
	
	

}

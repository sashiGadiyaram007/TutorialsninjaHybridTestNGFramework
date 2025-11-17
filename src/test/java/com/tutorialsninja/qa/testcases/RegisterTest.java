package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountSuccessPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterTest extends Base {
	public WebDriver driver;
	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;
	
	public RegisterTest() {
		
		super();
	}
	
	
	@BeforeMethod
	public void setup() {
		
		driver=initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
		
		HomePage homePage=new HomePage(driver);
		registerPage=homePage.navigateToRegisterPage();
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifyRegisteringAnAccountWithMandatoryFields() {
		
		accountSuccessPage=registerPage.registerWithMandatoryFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), Utilities.generateTimeStamp(), dataProp.getProperty("telephoneNumber"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));
	
		Assert.assertEquals(accountSuccessPage.retreiveAccountSuccessPageHeading(), dataProp.getProperty("accountSuccessfullyCreatedHeading"),"Account Sucess Page is not  displayed");
		
		 
	}
	
	@Test(priority=2)
	public void verifyRegisteringAccountByProvidingAllFields() {
		
		accountSuccessPage=registerPage.registerWithEnteringAllFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), Utilities.generateTimeStamp(), dataProp.getProperty("telephoneNumber"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		Assert.assertEquals(accountSuccessPage.retreiveAccountSuccessPageHeading(), dataProp.getProperty("accountSuccessfullyCreatedHeading"),"Account Sucess Page is not  displayed");
		
	}
	
	@Test(priority=3)
	public void verifyRegsiteringAccountWithExistingEmailAddress()  {
		
		accountSuccessPage=registerPage.registerWithEnteringAllFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), prop.getProperty("validEmail"), dataProp.getProperty("telephoneNumber"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		Assert.assertTrue(registerPage.retreiveDuplicateEmailAddressWarning().contains(dataProp.getProperty("duplicateEmailWarning")),"Warning Message is not  displayed");
		
		
	}
	
	@Test(priority=4)
	public void verifyRegsiteringAccountWithoutEnteringAnyFields() throws InterruptedException {
		
		
		
		registerPage.clickOnContinueButton();
		Assert.assertTrue(registerPage.retreivePrivacyPolicyWarning().contains(dataProp.getProperty("privacyPolicyWarning")),"Privacy Policy Warning Message is not Displayed");
		Assert.assertTrue(registerPage.retreiveFirstNameWarning().contains(dataProp.getProperty("firstNameWarning")),"First Name Warning Message is not Displayed");
		Assert.assertTrue(registerPage.retreiveLastNameWarning().contains(dataProp.getProperty("lastNameWarning")),"Last Name Warning Message is not Displayed");
		Assert.assertTrue(registerPage.retreiveEmailWarning().contains(dataProp.getProperty("emailWarning")),"Email Address Warning Message is not Displayed");
		Assert.assertTrue(registerPage.retreiveTelephoneWarning().contains(dataProp.getProperty("telephoneWarning")),"Telephone Warning Message is not displayed");
		Assert.assertTrue(registerPage.retreivePasswordWarning().contains(dataProp.getProperty("passwordWarning")),"Password Warning Message is not Displayed");
		
	}

}

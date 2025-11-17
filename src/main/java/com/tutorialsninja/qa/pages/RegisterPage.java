package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	
	//Constructor
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//Locators
	
	
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement passwordConfirmField;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement privacyPolicyField;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement newsLetterOption;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicateEmailAddressWarning;
	
	
	@FindBy(xpath="//div[contains(@class,'alert alert')]")
	private WebElement privacyPolicyWarning;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	
	
	
	
	
	//Action Methods
	
	public String retreiveEmailWarning() {
		String emailWarningText=emailWarning.getText();
		return emailWarningText;
	}
	
	
	public String retreiveTelephoneWarning() {
		String telephoneWarningText=telephoneWarning.getText();
		return telephoneWarningText;
	}
	
	public String retreivePasswordWarning() {
		String passwordWarningText=passwordWarning.getText();
		return passwordWarningText;
	}
	
	
	public String retreiveLastNameWarning() {
		String lastNameWarningText=lastNameWarning.getText();
		return lastNameWarningText;
	}
	
	public String retreiveFirstNameWarning() {
		String firstNameWarningText=firstNameWarning.getText();
		return firstNameWarningText;
	}
	
	
	
	
	public String retreivePrivacyPolicyWarning() {
		String privacyPolicyWarningText=privacyPolicyWarning.getText();
		return privacyPolicyWarningText;
	}
	
	
	
	
	public void enterFirstName(String firstNameText) {
		firstNameField.sendKeys(firstNameText);
		
	}
	
	public void enterLastName(String lastNameText) {
		lastNameField.sendKeys(lastNameText);
	}
	
	public void enterEmailAddress(String emailText) {
		emailField.sendKeys(emailText);
	}
	
	
	public void enterTelephoneNumber(String telephoneText) {
		
		telephoneField.sendKeys(telephoneText);
	}
	
	public void enterPassword(String passwordText) {
		
		passwordField.sendKeys(passwordText);
		
	}
	
	public void enterConfirmPassword(String confirmPasswordText) {
		passwordConfirmField.sendKeys(confirmPasswordText);
	}
	
	public void selectPrivacyPolicyCheckBox() {
		privacyPolicyField.click();
	}
	
	public AccountSuccessPage clickOnContinueButton() {
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	public void selectNewsLetterCheckBox() {
		newsLetterOption.click();
	}
	
	public String retreiveDuplicateEmailAddressWarning() {
		String duplicateEmailTextWarning= duplicateEmailAddressWarning.getText();
		return duplicateEmailTextWarning;
	}
		
	public AccountSuccessPage registerWithMandatoryFields(String firstNameText,String lastNameText,String emailText,String telephoneText,String passwordText,String confirmPasswordText) {
		firstNameField.sendKeys(firstNameText);
		lastNameField.sendKeys(lastNameText);
		emailField.sendKeys(emailText);
		telephoneField.sendKeys(telephoneText);
		passwordField.sendKeys(passwordText);
		passwordConfirmField.sendKeys(confirmPasswordText);
		privacyPolicyField.click();
		continueButton.click();
		return new AccountSuccessPage(driver);
		
	}
	
	public AccountSuccessPage registerWithEnteringAllFields(String firstNameText,String lastNameText,String emailText,String telephoneText,String passwordText,String confirmPasswordText) {
		firstNameField.sendKeys(firstNameText);
		lastNameField.sendKeys(lastNameText);
		emailField.sendKeys(emailText);
		telephoneField.sendKeys(telephoneText);
		passwordField.sendKeys(passwordText);
		passwordConfirmField.sendKeys(confirmPasswordText);
		newsLetterOption.click();
		privacyPolicyField.click();
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
}

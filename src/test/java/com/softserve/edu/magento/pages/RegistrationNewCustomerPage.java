package com.softserve.edu.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.magento.data.ICustomerNewRegistration;

public class RegistrationNewCustomerPage extends VerticalMenu {

	// header and vertical labels/buttons

	private WebElement newCustomerLabel;
	private WebElement accountInformationButton;
	private WebElement addressesButton;
	private WebElement backButton;
	private WebElement resetButton;
	private WebElement saveAndContinueButton;
	private WebElement saveCustomerButton;

	// fields
	private WebElement groupSelectField;
	private WebElement groupChangeBasedOnVatCheck;
	private WebElement prefixInput;
	private WebElement firstnameInput;
	private WebElement middlenameInput;
	private WebElement lastnameInput;
	private WebElement sufixInput;
	private WebElement emailInput;
	private WebElement dateOfBirfthInput;
	private WebElement taxVatInput;
	private WebElement genderButton;

	public RegistrationNewCustomerPage(WebDriver driver) {
		super(driver);
		this.newCustomerLabel = driver.findElement(By.id(".//header/div[1]/div/h1"));
		this.accountInformationButton = driver.findElement(By.id("tab_customer"));
		this.addressesButton = driver.findElement(By.id("tab_address"));
		this.backButton = driver.findElement(By.id("back"));
		this.resetButton = driver.findElement(By.id("reset"));
		this.saveAndContinueButton = driver.findElement(By.id("save_and_continue"));
		this.saveCustomerButton = driver.findElement(By.id("save"));
		this.groupSelectField = driver.findElement(By.id("TWR23U9"));
		this.groupChangeBasedOnVatCheck = driver.findElement(By.id("ILI2GN1"));
		this.prefixInput = driver.findElement(By.id("ADF8UIK"));
		this.firstnameInput = driver.findElement(By.id("QDPN37B"));
		this.middlenameInput = driver.findElement(By.id("BW710O7"));
		this.lastnameInput = driver.findElement(By.id("U5SLE3W"));
		this.sufixInput = driver.findElement(By.id("RWVQ34M"));
		this.emailInput = driver.findElement(By.id("F9CYV8D"));
		this.dateOfBirfthInput = driver.findElement(By.id("dp1468928262763"));
		this.taxVatInput = driver.findElement(By.id("FM83BFQ"));
		this.genderButton = driver.findElement(By.id("VNVFMC2"));
	}

	// PageObject

	// get Data PageObject

	public WebElement getNewCustomerLabel() {
		return this.newCustomerLabel;
	}

	public WebElement getAccountInformationButton() {
		return this.accountInformationButton;
	}

	public WebElement getAddressesButton() {
		return this.addressesButton;
	}

	public WebElement getBackButton() {
		return this.backButton;
	}

	public WebElement getResetButton() {
		return this.resetButton;
	}

	public WebElement getSaveAndContinueButton() {
		return this.saveAndContinueButton;
	}

	public WebElement getSaveCustomerButton() {
		return this.saveCustomerButton;
	}

	public WebElement getGroupSelectField() {
		return this.groupSelectField;
	}

	public WebElement getGroupChangeBasedOnVatCheck() {
		return this.groupChangeBasedOnVatCheck;
	}

	public WebElement getPrefixInput() {
		return this.prefixInput;
	}

	public WebElement getFirstnameInput() {
		return this.firstnameInput;
	}

	public WebElement getMiddlenameInput() {
		return this.middlenameInput;
	}

	public WebElement getLastnameInput() {
		return this.lastnameInput;
	}

	public WebElement getSufixInput() {
		return this.sufixInput;
	}

	public WebElement getEmailInput() {
		return this.emailInput;
	}

	public WebElement getDateOfBirfthInput() {
		return this.dateOfBirfthInput;
	}

	public WebElement getTaxVatInput() {
		return this.taxVatInput;
	}

	public WebElement getGenderButton() {
		return this.genderButton;
	}

	// get Data Business Logic

	public String getFromNewCustomerLabelText() {
		return getNewCustomerLabel().getText().trim();
	}

	public String getFromAccountInformationButtonText() {
		return getAccountInformationButton().getText();
	}

	public String getAddressesButtonText() {
		return getAddressesButton().getText();
	}

	public String getBackButtonText() {
		return getBackButton().getText();
	}

	public String getSaveCustomerButtonText() {
		return getSaveCustomerButton().getText();
	}

	// clearing fields

	public void prefixInputClear() {
		getPrefixInput().clear();
	}

	public void firstnameInputClear() {
		getFirstnameInput().clear();
	}

	public void middlenameInputClear() {
		getMiddlenameInput().clear();
	}

	public void lastnameInputClear() {
		getLastnameInput().clear();
	}

	public void sufixInputClear() {
		getSufixInput().clear();
	}

	public void emailInputClear() {
		getEmailInput().clear();
	}

	public void dateOfBirfthInputClear() {
		getDateOfBirfthInput().clear();
	}

	public void taxVatInputClear() {
		getTaxVatInput().clear();
	}

	// input data

	public void setDataInPrefixField(String prefix) {
		prefixInputClear();
		getPrefixInput().sendKeys(prefix);
	}

	public void setDataInFirstnameField(String firstname) {
		firstnameInputClear();
		getFirstnameInput().sendKeys(firstname);
	}

	public void setDataInMiddleField(String middlename) {
		middlenameInputClear();
		getMiddlenameInput().sendKeys(middlename);
	}

	public void setDataInLastnameField(String lastname) {
		lastnameInputClear();
		getLastnameInput().sendKeys(lastname);
	}

	public void setDataInSufixField(String sufix) {
		sufixInputClear();
		getSufixInput().sendKeys(sufix);
	}

	public void setDataInEmailField(String email) {
		emailInputClear();
		getEmailInput().sendKeys(email);
	}

	public void setDataInDateOfBirdthField(String dateOfBirdth) {
		dateOfBirfthInputClear();
		getDateOfBirfthInput().sendKeys(dateOfBirdth);
	}

	public void setDataInTaxValueField(String taxValue) {
		taxVatInputClear();
		getTaxVatInput().sendKeys(taxValue);
	}
	
	public void accountInformationButtonClick(){
		getAccountInformationButton().click();
	}
	
	public void addressesButtonClick(){
		getAddressesButton().click();
	}
	
	public void backButtonClick(){
		getBackButton().click();
	}
	
	public void resetButtonClick(){
		getResetButton().click();
	}

	public void saveAndContinueButtonClick(){
		getSaveAndContinueButton().click();
	}
	
	public void saveCustomerButtonClick(){
		getSaveCustomerButton().click();
	}
	
	public void groupSelectFieldClick(){
		getGroupSelectField().click();
	}
	
	public void groupChangeBasedOnVatCheckClick(){
		getGroupChangeBasedOnVatCheck().click();
	}
	
	public void genderButtonClick(){
		getGenderButton().click();
	}
	
	//functional createNewCustomer
	
	public void setCustomerDataInLoginForm(ICustomerNewRegistration customer){
		setDataInPrefixField(customer.getPrefix());
		setDataInFirstnameField(customer.getFirstname());
		setDataInMiddleField(customer.getMiddlename());
		setDataInLastnameField(customer.getLastname());
		setDataInSufixField(customer.getSufix());
		setDataInEmailField(customer.getEmail());
		setDataInDateOfBirdthField(customer.getDateOfBirdth());
		setDataInTaxValueField(customer.getTaxNumber());
		saveCustomerButtonClick();
	}
	
//	public InvalidValidatorNewCustomerPage invalidCustomer(ICustomerNewRegistration invalidCustomer){
//		setCustomerDataInLoginForm(invalidCustomer);
//		return new InvalidValidatorNewCustomerPage(driver);
//	}
//	
//	public InvalidValidatorNewCustomerPage validCustomer(ICustomerNewRegistration validCustomer){
//		setCustomerDataInLoginForm(validCustomer);
//		return new validNewCustomerPage(driver);
//	}
//	
	
	
}

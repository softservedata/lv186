package com.softserve.edu.magento.pages.admin.menu.customers;

import com.softserve.edu.magento.data.customer.user.CustomerAccountInfo;
import com.softserve.edu.magento.pages.admin.menu.customers.editCustomer.Calendar;
import com.softserve.edu.magento.pages.admin.menu.customers.editCustomer.ICalendar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.softserve.edu.magento.data.customer.user.ICustomerUser;
import com.softserve.edu.magento.pages.admin.VerticalMenu;
import com.softserve.edu.magento.tools.Search;
import ss.af.reporting.annotations.ServiceReport;

public class RegistrationNewCustomerPage extends VerticalMenu {
	public final static String PAGE_TITLE = "New Customer";
	private Addresses addresses;
	private Countries countries;

	// header and vertical labels/buttons

	private WebElement newCustomerLabel;
	private WebElement accountInformationButton;
	private WebElement addressesButton;
	private WebElement backButton;
	private WebElement resetButton;
	private WebElement saveAndContinueButton;
	private WebElement saveCustomerButton;

	// fields
	private WebElement validLabelAboutSavedUser;
	private WebElement groupSelectField;
	private WebElement groupChangeBasedOnVatCheck;
//	private WebElement prefixInput;
//	private WebElement firstnameInput;
//	private WebElement middlenameInput;
//	private WebElement lastnameInput;
//	private WebElement sufixInput;
//	private WebElement emailInput;
//	private WebElement dateOfBirfthInput;
//	private WebElement taxVatInput;
//	private WebElement genderButton;
	private WebElement addNewAddressesButton;
	private CustomerAccountInfo accountInfo;


	public RegistrationNewCustomerPage() {
		this.accountInfo=new CustomerAccountInfo();
		this.newCustomerLabel = Search.cssSelector(".page-title");
		this.accountInformationButton = Search.id("tab_customer");
		this.addressesButton = Search.id("tab_address");
		this.backButton = Search.id("back");
		this.resetButton = Search.id("reset");
		this.saveAndContinueButton = Search.id("save_and_continue");
		this.saveCustomerButton = Search.id("save");
		this.groupSelectField = Search.cssSelector("[name='customer[group_id]']");
		this.groupChangeBasedOnVatCheck = Search.cssSelector("[name='customer[disable_auto_group_change]']");
//		this.prefixInput = Search.cssSelector("[name='customer[prefix]']");
//		this.firstnameInput = Search.cssSelector("[name='customer[firstname]']");
//		this.middlenameInput = Search.cssSelector("[name='customer[middlename]']");
//		this.lastnameInput = Search.cssSelector("[name='customer[lastname]']");
//		this.sufixInput = Search.cssSelector("[name='customer[suffix]']");
//		this.emailInput = Search.cssSelector("[name='customer[email]']");
//		this.dateOfBirfthInput = Search.cssSelector("[name='customer[dob]']");
//		this.taxVatInput = Search.cssSelector("[name='customer[taxvat]']");
//		this.genderButton = Search.cssSelector("[name='customer[gender]']");
	}

	public class Addresses {
		private WebElement defaultBillingAddressCheckAddresses;
		private WebElement defaultdShippingAddressCheckAddresses;
		private WebElement stateInputAddresses;
		private WebElement prefixInputAddresses;
		private WebElement firstnameInputAddresses;
		private WebElement middlenameInputAddresses;
		private WebElement lastnameInputAddresses;
		private WebElement sufixInputAddresses;
		private WebElement companyInputAddresses;
		private WebElement streetAddressInputAddresses;
		private WebElement cityInputAddresses;
		private WebElement countryMenuDropdownAddresses;
		private WebElement postalInputAddresses;
		private WebElement phoneNumberInputAddresses;
		private WebElement vatNumberInputAddresses;
		private WebElement addNewAddressesButton;

		public Addresses() {
			this.defaultBillingAddressCheckAddresses = Search.id("QGJJ96Q");
			this.defaultdShippingAddressCheckAddresses = Search.id("BC0QRXU");
			this.stateInputAddresses = Search.id("NQ2Y2XL");
			this.prefixInputAddresses = Search.id("J76217E");
			this.firstnameInputAddresses = Search.id("IRRX7TE");
			this.middlenameInputAddresses = Search.id("DRA2VHQ");
			this.lastnameInputAddresses = Search.id("HUQDFEG");
			this.sufixInputAddresses = Search.id("FFLEL5N");
			this.companyInputAddresses = Search.id("FA1FJFS");
			this.streetAddressInputAddresses = Search.id("G01M6M3");
			this.cityInputAddresses = Search.id("R4N42X6");
			this.countryMenuDropdownAddresses = Search.id("TEQ7LB5");
			this.postalInputAddresses = Search.id("SLB27G5");
			this.phoneNumberInputAddresses = Search.id("XST3GE3");
			this.vatNumberInputAddresses = Search.id("K8LDS6P");
			this.addNewAddressesButton = Search.xpath("//span[text()='Add New Addresses']");
		}

	}

	

	private class AddNewAddress {
		private WebElement addNewAddressesButton;

		public AddNewAddress() {
			this.addNewAddressesButton = Search.xpath("//span[text()='Add New Addresses']");
		}

	}

	private class Countries {
		private WebElement country;
		private WebElement ukrainian;

		public Countries() {
			this.country = Search.id("TEQ7LB5");
			this.ukrainian = Search.xpath(".//*[@id='TEQ7LB5']/option[230]");
		}
	}

	// getters to Countries class
	public WebElement getCountry() {
		return countries.country;
	}

	public WebElement getUkrainian() {
		return countries.ukrainian;
	}

	// logic to Countries class
	public void ukrainianLanguageSelect() {
		getUkrainian().click();
	}

	// getters to Addresses class
	public WebElement getDefaultBillingAddressCheckAddresses() {
		return addresses.defaultBillingAddressCheckAddresses;
	}

	public WebElement getDefaultdShippingAddressCheckAddresses() {
		return addresses.defaultdShippingAddressCheckAddresses;
	}

	public WebElement getStateInputAddresses() {
		return addresses.stateInputAddresses;
	}

	public WebElement getPrefixInputAddresses() {
		return addresses.prefixInputAddresses;
	}

	public WebElement getFirstnameInputAddresses() {
		return addresses.firstnameInputAddresses;
	}

	public WebElement getMiddlenameInputAddresses() {
		return addresses.middlenameInputAddresses;
	}

	public WebElement getLastnameInputAddresses() {
		return addresses.lastnameInputAddresses;
	}

	public WebElement getSufixInputAddresses() {
		return addresses.sufixInputAddresses;
	}

	public WebElement getCompanyInputAddresses() {
		return addresses.companyInputAddresses;
	}

	public WebElement getStreetAddressInputAddresses() {
		return addresses.streetAddressInputAddresses;
	}

	public WebElement getCityInputAddresses() {
		return addresses.cityInputAddresses;
	}

	public WebElement getCountryMenuDropdownAddresses() {
		return addresses.countryMenuDropdownAddresses;
	}

	public WebElement getPostalInputAddresses() {
		return addresses.postalInputAddresses;
	}

	public WebElement getPhoneNumberInputAddresses() {
		return addresses.phoneNumberInputAddresses;
	}

	public WebElement getVatNumberInputAddresses() {
		return addresses.vatNumberInputAddresses;
	}

	public WebElement getAddNewAddressesButton() {
		return addresses.addNewAddressesButton;
	}

	// PageObject

	// get Data PageObject

	public WebElement getValidLabelAboutSavedUser() {
		return this.getValidLabelAboutSavedUser();
	}

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
		return accountInfo.getPrefix();
	}

	public WebElement getFirstnameInput() {
		return accountInfo.getFirstname();
	}

	public WebElement getMiddlenameInput() {
		return accountInfo.getMiddlename();
	}

	public WebElement getLastnameInput() {
		return accountInfo.getLastname();
	}

	public WebElement getSufixInput() {
		return accountInfo.getSuffix();
	}

	public WebElement getEmailInput() {
		return accountInfo.getEmail();
	}

	public WebElement getDateOfBirfthInput() {
		return accountInfo.getDateOfBirth();
	}

	public WebElement getTaxVatInput() {
		return accountInfo.getTax();
	}

//	public WebElement getGenderButton() {
//		return accountInfo.getGender();
//	}

	// get Data Business Logic
	public String getFromValidLabelAboutSavedUserText() {
		return getValidLabelAboutSavedUser().getText().trim();
	}

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

	// clearing fields main class

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

	// setters Addresses class

	public void setDataInStateFieldAddresses(String state) {
		getStateInputAddresses().clear();
		getStateInputAddresses().sendKeys(state);
	}

	public void setDataInprefixInputFieldAddresses(String prefix) {
		getPrefixInputAddresses().clear();
		getPrefixInputAddresses().sendKeys(prefix);
	}

	public void setDataInfirstnameInputAddresses(String firstname) {
		getFirstnameInputAddresses().clear();
		getFirstnameInputAddresses().sendKeys(firstname);
	}

	public void setDataInMiddlenameInputAddresses(String middlename) {
		getMiddlenameInputAddresses().clear();
		getMiddlenameInputAddresses().sendKeys(middlename);
	}

	public void setDataInLastnameInputAddresses(String lastname) {
		getLastnameInputAddresses().clear();
		getLastnameInputAddresses().sendKeys(lastname);
	}

	public void setDataInSufixInputAddresses(String sufix) {
		getSufixInputAddresses().clear();
		getSufixInputAddresses().sendKeys(sufix);
	}

	public void setDataInCompanyInputAddresses(String company) {
		getCompanyInputAddresses().clear();
		getCompanyInputAddresses().sendKeys(company);
	}

	public void setDataInStreetAddressInputAddresses(String street) {
		getStreetAddressInputAddresses().clear();
		getStreetAddressInputAddresses().sendKeys(street);
	}

	public void setDataInCityInputAddresses(String city) {
		getCityInputAddresses().clear();
		getCityInputAddresses().sendKeys(city);
	}

	public void setDataInCountryMenuDropdownAddresses(String country) {
		getCountryMenuDropdownAddresses().clear();
		getCountryMenuDropdownAddresses().sendKeys(country);
	}

	public void setDataInPostalInputAddresses(String postal) {
		getPostalInputAddresses().clear();
		getPostalInputAddresses().sendKeys(postal);
	}

	public void setDataInPhoneNumberInputAddresses(String phone) {
		getPhoneNumberInputAddresses().clear();
		getPhoneNumberInputAddresses().sendKeys(phone);
	}

	public void setDataInVatNumberInputAddresses(String vat) {
		getVatNumberInputAddresses().clear();
		getVatNumberInputAddresses().sendKeys(vat);
	}

	// setters main

	public void setDataInPrefixField(String prefix) {
		accountInfo.getPrefix().clear();
		accountInfo.getPrefix().sendKeys(prefix);
	}

	public void setDataInFirstnameField(String firstname) {
		accountInfo.getFirstname().clear();
		accountInfo.getFirstname().sendKeys(firstname);
	}

	public void setDataInMiddleField(String middlename) {
		accountInfo.getMiddlename().clear();
		accountInfo.getMiddlename().sendKeys(middlename);
	}

	public void setDataInLastnameField(String lastname) {
		accountInfo.getLastname().clear();
		accountInfo.getLastname().sendKeys(lastname);
	}

	public void setDataInSufixField(String sufix) {
		accountInfo.getSuffix().clear();
		accountInfo.getSuffix().sendKeys(sufix);
	}

	public void setDataInEmailField(String email) {
		accountInfo.getEmail().clear();
		accountInfo.getEmail().sendKeys(email);
	}

	public void setDataInDateOfBirdthField(String dateOfBirdth) {
		dateOfBirfthInputClear();
		getDateOfBirfthInput().sendKeys(dateOfBirdth);
	}

	public void setDataInTaxValueField(String taxValue) {
		accountInfo.getTax().clear();
		accountInfo.getTax().sendKeys(taxValue);
	}

	public void accountInformationButtonClick() {
		getAccountInformationButton().click();
	}

	public void addressesButtonClick() {
		getAddressesButton().click();
	}

	public void backButtonClick() {
		getBackButton().click();
	}

	public void resetButtonClick() {
		getResetButton().click();
	}

	public void saveAndContinueButtonClick() {
		getSaveAndContinueButton().click();
	}

	public void saveCustomerButtonClick() {
		getSaveCustomerButton().click();
	}

	public void groupSelectFieldClick() {
		getGroupSelectField().click();
	}

	public void groupChangeBasedOnVatCheckClick() {
		getGroupChangeBasedOnVatCheck().click();
	}

//	public void genderButtonClick() {
//		getGenderButton().click();
//	}

	public void defaultBillingAddressCheckAddressesClick() {
		getDefaultBillingAddressCheckAddresses().click();
	}

	public void defaultdShippingAddressCheckAddressesClick() {
		getDefaultdShippingAddressCheckAddresses().click();
	}

	public void addNewAddressesButtonClick() {
		getAddNewAddressesButton().click();
	}

	public void addNewAddressButtonClick() {
		addNewAddressesButton.click();

	}

	// functional createNewCustomer
	@ServiceReport
	public AllCustomersPageAfterSuccesRegistration setCustomerDataInLoginForm(Calendar calendar) {
		setDataInPrefixField("Pre");
		setDataInFirstnameField("Vasyl");
		setDataInMiddleField("Ivanov");
		setDataInLastnameField("Vasyltsiv");
		setDataInSufixField("Iva");
		setDataInEmailField("vasyltsiv@ukr.net");
		calendar.setData("11", ICalendar.Months.OCTOBER, "1961");
		setDataInTaxValueField("456123");
		saveCustomerButtonClick();
		return new AllCustomersPageAfterSuccesRegistration();
	}

	public void setRingerDataInLoginFormAndClickResetButton(ICustomerUser customer){
		setDataInPrefixField(customer.getPersonalInfo().getPrefix());
		setDataInFirstnameField(customer.getPersonalInfo().getFirstname());
		setDataInMiddleField(customer.getPersonalInfo().getMiddlename());
		setDataInLastnameField(customer.getPersonalInfo().getLastname());
		setDataInSufixField(customer.getPersonalInfo().getSuffix());
		setDataInEmailField(customer.getSigninInfo().getEmail());
		// setDataInDateOfBirdthField(customer.getPersonalInfo().getBirthdayDate().);
		setDataInTaxValueField(customer.getContactInfo().getVatNumber());
		resetButtonClick();

	}

	public RegistrationNewCustomerErrorPage setRingerDataInLoginForm(ICustomerUser customer){
		setDataInPrefixField(customer.getPersonalInfo().getPrefix());
		setDataInFirstnameField(customer.getPersonalInfo().getFirstname());
		setDataInMiddleField(customer.getPersonalInfo().getMiddlename());
		setDataInLastnameField(customer.getPersonalInfo().getLastname());
		setDataInSufixField(customer.getPersonalInfo().getSuffix());
		setDataInEmailField(customer.getSigninInfo().getEmail());
		// setDataInDateOfBirdthField(customer.getPersonalInfo().getBirthdayDate().);
		setDataInTaxValueField(customer.getContactInfo().getVatNumber());
		saveCustomerButtonClick();
		return new RegistrationNewCustomerErrorPage();
	}

	public RegistrationNewCustomerErrorFieldsPage setInvalidFirstnameLastNameEmailDataInLoginForm(ICustomerUser customer){
		setDataInPrefixField(customer.getPersonalInfo().getPrefix());
		setDataInFirstnameField(customer.getPersonalInfo().getFirstname());
		setDataInMiddleField(customer.getPersonalInfo().getMiddlename());
		setDataInLastnameField(customer.getPersonalInfo().getLastname());
		setDataInSufixField(customer.getPersonalInfo().getSuffix());
		setDataInEmailField(customer.getSigninInfo().getEmail());
		// setDataInDateOfBirdthField(customer.getPersonalInfo().getBirthdayDate().);
		setDataInTaxValueField(customer.getContactInfo().getVatNumber());
		saveCustomerButtonClick();
		return new RegistrationNewCustomerErrorFieldsPage();
	}

	public void setCustomerDataInAddressesForm(ICustomerUser customer) {
		setDataInStateFieldAddresses(customer.getContactInfo().getState());
		setDataInprefixInputFieldAddresses(customer.getPersonalInfo().getPrefix());
		setDataInfirstnameInputAddresses(customer.getPersonalInfo().getFirstname());
		setDataInMiddlenameInputAddresses(customer.getPersonalInfo().getMiddlename());
		setDataInLastnameInputAddresses(customer.getPersonalInfo().getLastname());
		setDataInSufixInputAddresses(customer.getPersonalInfo().getSuffix());
		setDataInCompanyInputAddresses(customer.getContactInfo().getCompanyName());
		setDataInStreetAddressInputAddresses(customer.getContactInfo().getStreetAddress());
		setDataInCityInputAddresses(customer.getContactInfo().getCity());
		setDataInPostalInputAddresses(customer.getContactInfo().getPostalCode());
		setDataInPhoneNumberInputAddresses(customer.getContactInfo().getPhoneNumber());
		setDataInVatNumberInputAddresses(customer.getContactInfo().getVatNumber());
	}


	


	public Countries countriesFieldAddressesClick() {
		getCountry().click();
		return new Countries();
	}

	public AddNewAddress goToaddNewAddressesButton() {
		getAddressesButton().click();
		return new AddNewAddress();
	}

	public Addresses goToAddressesPage() {
		addressesButtonClick();
		addNewAddressesButtonClick();
		return new Addresses();
	}

}

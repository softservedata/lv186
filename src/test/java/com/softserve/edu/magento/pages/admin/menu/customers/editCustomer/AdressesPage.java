package com.softserve.edu.magento.pages.admin.menu.customers.editCustomer;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.softserve.edu.magento.tools.Search;

public class AdressesPage extends ACustomPageSideMenu {
	private WebElement addNewAddresses;
	private WebElement address;
	private WebElement deleteButton;
	private WebElement defaultBillingCHK;
	private WebElement defaultShippingCHK;
	private WebElement prefix;
	private WebElement firstname;
	private WebElement middlename;
	private WebElement lastname;
	private WebElement suffix;
	private WebElement company;
	private WebElement streetAdressFirst;
	private WebElement streetAdressSecond;
	private WebElement city;
	private Select country;
	private WebElement state;
	private WebElement zip;
	private WebElement phone;
	private WebElement vat;
	
	public AdressesPage () {
		this.addNewAddresses = Search.xpath("//span[contains(text(),'Add New Addresses')]");
		this.address = Search.cssSelector("address");
		this.deleteButton = Search.cssSelector(".action-delete");
		this.defaultBillingCHK = Search.cssSelector("input[name='address[3][default_billing]']"); 
		this.defaultShippingCHK = Search.cssSelector("input[name='address[3][default_shipping]']"); 
		this.prefix = Search.cssSelector("input[name='address[3][prefix]']");
		this.firstname = Search.cssSelector("input[name='address[3][firstname]']");
		this.middlename = Search.cssSelector("input[name='address[3][middlename]']");
		this.lastname = Search.cssSelector("input[name='address[3][lastname]']");
		this.suffix = Search.cssSelector("input[name='address[3][suffix]']");
		this.company = Search.cssSelector("input[name='address[3][company]']"); 
		this.streetAdressFirst = Search.cssSelector("input[name='address[3][street][0]']"); 
		this.streetAdressSecond = Search.cssSelector("input[name='address[3][street][1]']"); 
		this.city = Search.cssSelector("input[name='address[3][city]']"); 
		this.country = new Select(Search.cssSelector("input[name='address[3][country_id]']"));  
		this.state = Search.cssSelector("input[name='address[3][region]']"); 
		this.zip = Search.cssSelector("input[name='address[3][postcode]']");  
		this.phone = Search.cssSelector("input[name='address[3][telephone]']");  
		this.vat = Search.cssSelector("input[name='address[3][vat_id]']"); 
	}

	public WebElement getAddNewAddresses() {
		return addNewAddresses;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getDeleteButton() {
		return deleteButton;
	}

	public WebElement getDefaultBillingCHK() {
		return defaultBillingCHK;
	}

	public WebElement getDefaultShippingCHK() {
		return defaultShippingCHK;
	}

	public WebElement getPrefix() {
		return prefix;
	}

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getMiddlename() {
		return middlename;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getSuffix() {
		return suffix;
	}

	public WebElement getCompany() {
		return company;
	}

	public WebElement getStreetAdressFirst() {
		return streetAdressFirst;
	}

	public WebElement getStreetAdressSecond() {
		return streetAdressSecond;
	}

	public WebElement getCity() {
		return city;
	}

	public Select getCountry() {
		return country;
	}

	public WebElement getState() {
		return state;
	}

	public WebElement getZip() {
		return zip;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getVat() {
		return vat;
	}
	
	
}

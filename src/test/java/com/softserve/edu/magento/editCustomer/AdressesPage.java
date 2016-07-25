package com.softserve.edu.magento.editCustomer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
	
	public AdressesPage (WebDriver driver) {
		super(driver);
		this.addNewAddresses = driver.findElement(By.xpath("//span[contains(text(),'Add New Addresses')]"));
		this.address = driver.findElement(By.cssSelector("address"));
		this.deleteButton = driver.findElement(By.cssSelector(".action-delete"));
		this.defaultBillingCHK = driver.findElement(By.cssSelector("input[name='address[3][default_billing]']")); 
		this.defaultShippingCHK = driver.findElement(By.cssSelector("input[name='address[3][default_shipping]']")); 
		this.prefix = driver.findElement(By.cssSelector("input[name='address[3][prefix]']"));
		this.firstname = driver.findElement(By.cssSelector("input[name='address[3][firstname]']"));
		this.middlename = driver.findElement(By.cssSelector("input[name='address[3][middlename]']"));
		this.lastname = driver.findElement(By.cssSelector("input[name='address[3][lastname]']"));
		this.suffix = driver.findElement(By.cssSelector("input[name='address[3][suffix]']"));
		this.company = driver.findElement(By.cssSelector("input[name='address[3][company]']")); 
		this.streetAdressFirst = driver.findElement(By.cssSelector("input[name='address[3][street][0]']")); 
		this.streetAdressSecond = driver.findElement(By.cssSelector("input[name='address[3][street][1]']")); 
		this.city = driver.findElement(By.cssSelector("input[name='address[3][city]']")); 
		this.country = new Select(driver.findElement(By.cssSelector("input[name='address[3][country_id]']")));  
		this.state = driver.findElement(By.cssSelector("input[name='address[3][region]']")); 
		this.zip = driver.findElement(By.cssSelector("input[name='address[3][postcode]']"));  
		this.phone = driver.findElement(By.cssSelector("input[name='address[3][telephone]']"));  
		this.vat = driver.findElement(By.cssSelector("input[name='address[3][vat_id]']")); 
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

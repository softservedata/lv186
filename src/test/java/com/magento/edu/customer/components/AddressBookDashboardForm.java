package com.magento.edu.customer.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressBookDashboardForm {
	protected WebDriver driver;
	public WebElement manageAddressLink;
	
	public WebElement inform_billingAddress;
	public WebElement editLink_billingAddress;
	public WebElement inform_shippingAddress;
	public WebElement editLink_shippingAddress;
	
	 public AddressBookDashboardForm(WebDriver driver) {
		 this.driver = driver;
		 WebElement address_box = driver.findElement(By.className("block block-dashboard-addresses"));
		 this.manageAddressLink = driver.findElement(By.className("block-title"))
				 .findElement(By.className("action edit"));
		 
		 WebElement billingAddress_box = address_box.findElement(By.className("box box-billing-address"));
		 this.inform_billingAddress = billingAddress_box.findElement(By.tagName("address"));
		 this.editLink_billingAddress = billingAddress_box.findElement(By.className("action edit"));
		 
		 WebElement shippingAddress_box = address_box.findElement(By.className("box box-shipping-address"));
		 this.inform_shippingAddress = shippingAddress_box.findElement(By.tagName("address"));
		 this.editLink_shippingAddress = shippingAddress_box.findElement(By.className("action edit"));
	 }
//getters
	public WebElement getManageAddressLink() {
		return manageAddressLink;
	}

	public WebElement getInform_billingAddress() {
		return inform_billingAddress;
	}

	public WebElement getEditLink_billingAddress() {
		return editLink_billingAddress;
	}

	public WebElement getInform_shippingAddress() {
		return inform_shippingAddress;
	}

	public WebElement getEditLink_shippingAddress() {
		return editLink_shippingAddress;
	}
//get business logic
	public String getBillingAddressText() {
		return this.getInform_billingAddress().getText();
	}
	public String getShippingAddressText() {
		return this.getInform_shippingAddress().getText();
	}
//click edit link
	public void clickManageAddressLink() {
		this.getManageAddressLink().click();
	}
	public void clickEditLink_billingAddress() {
		this.getEditLink_billingAddress().click();
	}
	public void clickEditLink_shippingAddress() {
		this.getEditLink_shippingAddress().click();
	}
}

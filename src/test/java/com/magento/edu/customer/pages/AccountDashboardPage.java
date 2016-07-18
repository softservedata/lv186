package com.magento.edu.customer.pages;

import org.openqa.selenium.WebDriver;

import com.magento.edu.customer.components.AddressBookDashboardForm;
import com.magento.edu.customer.components.ContactInformationForm;
import com.magento.edu.customer.components.HeaderPanelCustomerAccount;


public class AccountDashboardPage extends HeaderPanelCustomerAccount {
	
	public ContactInformationForm contactInformationForm;
	public AddressBookDashboardForm addressBookDashboardForm;
	public AccountDashboardPage(WebDriver driver) {
		super(driver);
		this.contactInformationForm = new ContactInformationForm(driver);
		this.addressBookDashboardForm = new AddressBookDashboardForm(driver);

	}
	public ContactInformationForm getContactInformationForm() {
		return contactInformationForm;
	}
	public AddressBookDashboardForm getAddressBookDashboardForm() {
		return addressBookDashboardForm;
	}
	
}

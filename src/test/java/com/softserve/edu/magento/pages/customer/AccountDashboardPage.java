package com.softserve.edu.magento.pages.customer;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.magento.pages.customer.components.HeaderPanelCustomerAccount;


public class AccountDashboardPage extends HeaderPanelCustomerAccount {
	
	private ContactInformationForm contactInformationForm;
	private AddressBookDashboardForm addressBookDashboardForm;
	
	//----------------------ContactInformationForm---------------------------------
	private class ContactInformationForm {
		
		private WebElement nameEmail_contactInf;
		private WebElement editLink_contactInf;
		private WebElement changePass_contactInf;
		
		private WebElement inform_Newsletters;
		private WebElement editLink_Newsletters;
		
		public ContactInformationForm() { 
			WebElement box_information =  driver.findElement(By.cssSelector("div.box.box-information"));
			this.nameEmail_contactInf = box_information.findElement(By.className("box-content"));
			this.editLink_contactInf = box_information.findElement(By.cssSelector("div.box-actions a.action.edit"));
			this.changePass_contactInf = box_information.findElement(By.cssSelector("a.action.change-password"));
			
			WebElement box_newsletters =  driver.findElement(By.cssSelector("div.box.box-newsletter"));
			this.inform_Newsletters = box_newsletters.findElement(By.className("box-content"));
			this.editLink_Newsletters = box_newsletters.findElement(By.cssSelector("div.box-actions a.action.edit"));
		}
	//getters
		public WebElement getNameEmail_contactInf() {
			return nameEmail_contactInf;
		}

		public WebElement getEditLink_contactInf() {
			return editLink_contactInf;
		}

		public WebElement getChangePass_contactInf() {
			return changePass_contactInf;
		}

		public WebElement getInform_Newsletters() {
			return inform_Newsletters;
		}

		public WebElement getEditLink_Newsletters() {
			return editLink_Newsletters;
		}

	}
	//-------------------AddressBookDashboardForm------------------------------------
	private class AddressBookDashboardForm {
		private WebElement manageAddressLink;
		
		private WebElement inform_billingAddress;
		private WebElement editLink_billingAddress;
		private WebElement inform_shippingAddress;
		private WebElement editLink_shippingAddress;
		
		 public AddressBookDashboardForm() {
			 WebElement address_box = driver.findElement(By.cssSelector("div.block.block-dashboard-addresses"));
			 this.manageAddressLink = driver.findElement(By.cssSelector("div.block-title a.action.edit"));
			 
			 WebElement billingAddress_box = address_box.findElement(By.cssSelector("div.box.box-billing-address"));
			 this.inform_billingAddress = billingAddress_box.findElement(By.tagName("address"));
			 this.editLink_billingAddress = billingAddress_box.findElement(By.cssSelector("div.box-actions a.action.edit"));
			 
			 WebElement shippingAddress_box = address_box.findElement(By.cssSelector("div.box.box-shipping-address"));
			 this.inform_shippingAddress = shippingAddress_box.findElement(By.tagName("address"));
			 this.editLink_shippingAddress = shippingAddress_box.findElement(By.cssSelector("div.box-actions a.action.edit"));
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

	}
	//-------------------------------------------------------
	public AccountDashboardPage(WebDriver driver) {
		super(driver);
		this.contactInformationForm = new ContactInformationForm();
		this.addressBookDashboardForm = new AddressBookDashboardForm();

	}
	public ContactInformationForm getContactInformationForm() {
		return contactInformationForm;
	}
	public AddressBookDashboardForm getAddressBookDashboardForm() {
		return addressBookDashboardForm;
	}
	//business logic ContactInformationForm
	//getters
			public WebElement getNameEmail_contactInf() {
				return this.getContactInformationForm().getNameEmail_contactInf();
			}

			public WebElement getEditLink_contactInf() {
				return getContactInformationForm().getEditLink_contactInf();
			}

			public WebElement getChangePass_contactInf() {
				return getContactInformationForm().getChangePass_contactInf();
			}

			public WebElement getInform_Newsletters() {
				return getContactInformationForm().getInform_Newsletters();
			}

			public WebElement getEditLink_Newsletters() {
				return getContactInformationForm().getEditLink_Newsletters();
			}
		//get text	
		public String getNameEmaiText() {
			return getNameEmail_contactInf().getText();
		}
		public String getInform_NewslettersText() {
			return getInform_Newsletters().getText();
		}
	//click linksContactInformationForm
		public void clickEditLink_contactInf() {
			getEditLink_contactInf().click();
		}
		public void clickChangePass_contactInf() {
			getChangePass_contactInf().click();
		}
		public void clickEditLink_Newsletters() {
			getEditLink_Newsletters().click();
		}
		//-----------getAddressBookDashboardForm----------
		//getters
		public WebElement getManageAddressLink() {
			return this.getAddressBookDashboardForm().getManageAddressLink();
		}

		public WebElement getInform_billingAddress() {
			return getAddressBookDashboardForm().getInform_billingAddress();
		}
		public WebElement getEditLink_billingAddress() {
			return getAddressBookDashboardForm().getEditLink_billingAddress();
		}
		public WebElement getInform_shippingAddress() {
			return getAddressBookDashboardForm().getInform_shippingAddress();
		}
		public WebElement getEditLink_shippingAddress() {
			return getAddressBookDashboardForm().getEditLink_shippingAddress();
		}
	//get business logic AddressBookDashboardForm
		public String getBillingAddressText() {
			return getInform_billingAddress().getText();
		}
		public String getShippingAddressText() {
			return getInform_shippingAddress().getText();
		}
		//click edit link AddressBookDashboardForm
		public void clickManageAddressLink() {
			getManageAddressLink().click();
		}
		public void clickEditLink_billingAddress() {
			getEditLink_billingAddress().click();
		}
		public void clickEditLink_shippingAddress() {
			getEditLink_shippingAddress().click();
		}
	
}

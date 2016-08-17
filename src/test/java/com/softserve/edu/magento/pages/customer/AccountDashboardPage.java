package com.softserve.edu.magento.pages.customer;

import com.softserve.edu.magento.data.customer.user.ICustomerUser;
import org.openqa.selenium.WebElement;

import com.softserve.edu.magento.pages.customer.components.HeaderPanelCustomerAccount;
import com.softserve.edu.magento.tools.Search;


public class AccountDashboardPage extends HeaderPanelCustomerAccount {
	
	private ContactInformationForm contactInformationForm;
	private AddressBookDashboardForm addressBookDashboardForm;

	public static enum InformNewslettersList {
		//TODO
		SUBSCRIBE("email"),
		NO_SUBSCRIBE("pass");

		//
		private String field;

		private InformNewslettersList(String field) {
			this.field = field;
		}

		@Override
		public String toString() {
			return this.field;
		}
	}
	
	//----------------------ContactInformationForm---------------------------------
	private class ContactInformationForm {
		
		private WebElement nameEmail_contactInf;
		private WebElement editLink_contactInf;
		private WebElement changePass_contactInf;
		
		private WebElement inform_Newsletters;
		private WebElement editLink_Newsletters;
		
		public ContactInformationForm() { 
			WebElement box_information =  Search.cssSelector("div.box.box-information");
			this.nameEmail_contactInf = Search.className("box-content",box_information);
			this.editLink_contactInf = Search.cssSelector("div.box-actions a.action.edit",box_information);
			this.changePass_contactInf = Search.cssSelector("a.action.change-password",box_information);
			
			WebElement box_newsletters =  Search.cssSelector("div.box.box-newsletter");
			this.inform_Newsletters = Search.className("box-content",box_newsletters);
			this.editLink_Newsletters = Search.cssSelector("div.box-actions a.action.edit",box_newsletters);
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
			 WebElement address_box = Search.cssSelector("div.block.block-dashboard-addresses");
			 this.manageAddressLink = Search.cssSelector("div.block-title a.action.edit");
			 
			 WebElement billingAddress_box = Search.cssSelector("div.box.box-billing-address",address_box);
			 this.inform_billingAddress = Search.tagName("address",billingAddress_box);
			 this.editLink_billingAddress = Search.cssSelector("div.box-actions a.action.edit",billingAddress_box);
			 
			 WebElement shippingAddress_box = Search.cssSelector("div.box.box-shipping-address",address_box);
			 this.inform_shippingAddress = Search.tagName("address",shippingAddress_box);
			 this.editLink_shippingAddress = Search.cssSelector("div.box-actions a.action.edit",shippingAddress_box);
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
	public AccountDashboardPage() {
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

		public boolean confirmAccountInfCorrect (ICustomerUser customerUser) {
			boolean isAccountInfCorrect = false;
			String contInformAccount = customerUser.getPersonalInfo().getFullName()+" " +
					customerUser.getSigninInfo().getEmail();

			if( this.getNameEmaiText().trim().equals(contInformAccount)) {
				if ( customerUser.getPersonalInfo().getSignUpNewsletter() == true ) {
					if ( this.getInform_NewslettersText().equals(InformNewslettersList.SUBSCRIBE.toString()) ) {
						isAccountInfCorrect = true;
					}
				} else if ( customerUser.getPersonalInfo().getSignUpNewsletter() == false ) {
					if ( this.getInform_NewslettersText().equals(InformNewslettersList.NO_SUBSCRIBE.toString()) ) {
						isAccountInfCorrect = true;
					}
				}
			}
			return isAccountInfCorrect;
		}
	
}

package com.softserve.edu.magento.pages.admin.menu.customers.editCustomer;

import java.util.List;

import com.softserve.edu.magento.data.customer.user.IAccountInformation;
import com.softserve.edu.magento.data.customer.user.IAdresses;
import com.softserve.edu.magento.pages.admin.menu.sales.OrdersPage;
import org.openqa.selenium.WebElement;

import com.softserve.edu.magento.pages.admin.menu.customers.AllCustomersPage;

import com.softserve.edu.magento.pages.admin.menu.customers.editCustomer.EditCustomerPage.ICustommerView;
import com.softserve.edu.magento.pages.admin.menu.customers.editCustomer.EditCustomerPage.IOrders;

public interface IEditCustomer {

	/**
	 * Set of possible selections for
	 * AssosieteWebsites selector.
	 */
	enum AssosieteWebsites {
		MAIN_WEBSITE("Main Website"),
		MAIN_WEBSITE_STORE("Main Website Store"),
		DEFAULT_STORE_VIEW("Default Store View");
		private String websiteId;

		AssosieteWebsites(String websiteId) {
			this.websiteId = websiteId;
		}

		@Override
		public String toString() {
			return this.websiteId;
		}
	}

	/**
	 * Set of possible selections for
	 * Group selector.
	 */
	enum Groups {
		GENERAL("General"),
		WHOLESALE("Wholesale"),
		RETAILER("Retailer");
		private String groupName;

		Groups(String groupName) {
			this.groupName = groupName;
		}

		@Override
		public String toString() {
			return this.groupName;
		}
	}

	/**
	 * Set of possible selections for
	 * Gender selector.
	 */
	enum Gender {
		MALE("Male"),
		FEMALE("Female"),
		NOT_SPECIFIED("Not Specified");
		private String genderName;

		Gender(String genderName) {
			this.genderName = genderName;
		}

		@Override
		public String toString() {
			return this.genderName;
		}
	}

	 enum DateOfBirth {
		// TODO
	}

	 enum Country {
		// TODO
	}

	public ICustommerView getCustommerView();

	public IAccountInformation getAccountInformation();

	public IAdresses getAdressesAjax();

	public WebElement getSuccessMessage();

	public IOrders getOrdersAjax();
		
	public void setSuccessMessage();
		
	public AllCustomersPage back();

	public AllCustomersPage deleteCustomer();
	
	public EditCustomerPage reset();

	public OrdersPage createOrder();
		
	public void resetPassword();

	public void forceSignIn();
		
	public EditCustomerPage saveAndContinueEdit();
		
	public AllCustomersPage saveCustomer();
		
	public IAccountInformation navToAccountInfo();

	public IAdresses navToadresses();

	public IOrders navToorders();

	public boolean compareChangesMadetoCity();

	public String getSelectedWebsiteText();

	public void setAssocietedWebsite(AssosieteWebsites website);

	public String getSelectedGroupText();

	public void setGroup(Groups group);

	public void setGender(Gender gender);

	public void setSendWelcomeEmailFrom(AssosieteWebsites website);
		
	public List<WebElement> getCustomerAllData();

	public boolean compareFields(WebElement customerCurrentField);
}

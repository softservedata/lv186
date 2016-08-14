package com.softserve.edu.magento.pages.admin.menu.customers.editCustomer;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.softserve.edu.magento.pages.admin.menu.customers.AllCustomersPage;
import com.softserve.edu.magento.pages.admin.menu.customers.editCustomer.EditCustomerPage.IAccountInformation;
import com.softserve.edu.magento.pages.admin.menu.customers.editCustomer.EditCustomerPage.IAdresses;
import com.softserve.edu.magento.pages.admin.menu.customers.editCustomer.EditCustomerPage.ICustommerView;
import com.softserve.edu.magento.pages.admin.menu.customers.editCustomer.EditCustomerPage.IOrders;

public interface IEditCustomer {

	/**
	 * Enum for AssosieteWebsites selector.
	 */
	static enum AssosieteWebsites {
		MAIN_WEBSITE("Main Website"),
		MAIN_WEBSITE_STORE("Main Website Store"),
		DEFAULT_STORE_VIEW("Default Store View");
		private String websiteId;

		private AssosieteWebsites(String websiteId) {
			this.websiteId = websiteId;
		}

		@Override
		public String toString() {
			return this.websiteId;
		}
	}

	enum Groups {
		// TODO
	}

	enum Gender {
		// TODO
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

	public void deleteCustomer();
	
	public EditCustomerPage reset();

	// TODO CreateOrder PAge
	public void createOrder();
		
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

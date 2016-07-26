package com.softserve.edu.magento.pages.admin.menu.customers.editCustomer;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.magento.pages.admin.menu.customers.AllCustomersPage;
import com.softserve.edu.magento.pages.admin.menu.customers.editCustomer.EditCustomerPage.AccountInformation;
import com.softserve.edu.magento.pages.admin.menu.customers.editCustomer.EditCustomerPage.Adresses;
import com.softserve.edu.magento.pages.admin.menu.customers.editCustomer.EditCustomerPage.CustommerView;
import com.softserve.edu.magento.pages.admin.menu.customers.editCustomer.EditCustomerPage.Orders;

public interface IEditCustomer {
	static enum AssosieteWebsites {
		MAIN_WEBSITE("Main Website"), MAIN_WEBSITE_STORE("Main Website Store"), DEFAULT_STORE_VIEW(
				"Default Store View");
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
	 
	 public WebDriver getDriver();

		public CustommerView getCustommerView();

		public AccountInformation getAccountInformation();

		public Orders getOrders();
		
		public WebElement getSuccessMessage();
		
		public CustommerView getCustommerViewAjax();

		public AccountInformation getAccountInformationAjax();

		public Adresses getAdressesAjax();

		public Orders getOrdersAjax();
		

		public void setDriver(WebDriver driver);

		public void setCustommerView(CustommerView custommerView);

		public void setAccountInformation(AccountInformation accountInformation);

		public void setOrders(EditCustomerPage.Orders orders);
		
		
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
		
		public EditCustomerPage.AccountInformation navToAccountInfo();

		public EditCustomerPage.Adresses navToadresses();

		public EditCustomerPage.Orders navToorders();

		public boolean compareChangesMadetoCity();

		public String getSelectedWebsiteText();

		public void setAssocietedWebsite(AssosieteWebsites website);

		public String getElectedGroupText();

		public void setGroup(Groups group);

		public void setGender(Gender gender);

		public void setSendWelcomeEmailFrom(AssosieteWebsites website);
		
		public List<WebElement> getCustomerAllData();

		public boolean compareFields(WebElement customerCurrentField);

}

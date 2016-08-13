package com.softserve.edu.magento.pages.admin.menu.customers.editCustomer;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.softserve.edu.magento.pages.admin.menu.customers.AllCustomersPage;
import com.softserve.edu.magento.tools.Search;

/**
 * Class that represents the EditCustomerPage with all the AJAX components in
 * it.
 * 
 * @author Andrew
 */
public class EditCustomerPage extends ACustomPageSideMenu implements IEditCustomer {

	private CustommerView custommerViewAjax;
	private AccountInformation accountInformationAjax;
	private Adresses adressesAjax;
	private Orders ordersAjax;
	private WebElement successMessage;

	/**
	 * Enum for AssosieteWebsites selector.
	 */
	
	/**
	 * Constructor
	 * Initializes the one component, visible on page load.
	 */
	public EditCustomerPage() {
		this.custommerViewAjax = new CustommerView();
	}
	
	/*
	 * Getters for the Page components.
	 */
	public CustommerView getCustommerView() {
		return this.custommerViewAjax;
	}

	public AccountInformation getAccountInformation() {
		return this.accountInformationAjax;
	}

	public Orders getOrders() {
		return this.ordersAjax;
	}
	
	public WebElement getSuccessMessage() {
		return successMessage;
	}
	
	public CustommerView getCustommerViewAjax() {
		return this.custommerViewAjax;
	}

	public AccountInformation getAccountInformationAjax() {
		return this.accountInformationAjax;
	}

	public Adresses getAdressesAjax() {
		return this.adressesAjax;
	}

	public Orders getOrdersAjax() {
		return this.ordersAjax;
	}
	
	/**
	 * Locates the message and inits it.
	 */
	public void setSuccessMessage() {
		this.successMessage = Search
				.xpath("//div[contains(text(), 'You saved the customer.')]");
	}
	
	/**
	 * Navigates to AllCustomerPage.
	 * @return
	 * 		new AllCustomerPage.
	 */
	public AllCustomersPage back() {
		back.click();
		return new AllCustomersPage();
	}

	public void deleteCustomer() {
		// TODO stub
	}
	
	/**
	 * resets all the changes made 
	 * to Customer data.
	 * @return
	 * 		new EditCustomerPage
	 */
	public EditCustomerPage reset() {
		reset.click();
		areChangesMade = false;
		return new EditCustomerPage();
	}

	// TODO CreateOrder PAge
	public void createOrder() {
		// stub
	}
	
	public void resetPassword() {
		resetPassword.click();
		// TODO
	}

	public void forceSignIn() {
		forceSignIn.click();
		// TODO
	}
	
	/**
	 * Saves all changes made to Customer
	 * data.
	 * @return
	 * 		new EditCustomerPage.
	 */
	public EditCustomerPage saveAndContinueEdit() {
		saveAndContinueEdit.click();
		return new EditCustomerPage();
	}
	
	/**
	 * Saves Customer and goes bacl to 
	 * AllCustomersPage.
	 * @return
	 * 		new AllCustomersPage.
	 */
	public AllCustomersPage saveCustomer() {
		saveCustomer.click();
		return new AllCustomersPage();
	}

	/**
	 * Component for CustommerView.
	 * 
	 * @author Andrew
	 */
	public class CustommerView {

		private WebElement LastLoggedInfo;
		private WebElement AccountLockedInInfo;
		private WebElement ConfirmedEmailInfo;
		private WebElement AccountCreatedInfo;
		private WebElement AccountCreatedInInfo;
		private WebElement CustomerGroupInfo;
		private WebElement DefaultBillingAddress;

		/**
		 * Constructor for CustommerView component.
		 */
		private CustommerView() {
			this.LastLoggedInfo = Search
							.xpath("//th[contains(text(), 'Last Logged')]//following-sibling::td");
			this.AccountLockedInInfo = Search
							.xpath("//th[contains(text(), 'Account Lock')]//following-sibling::td");
			this.ConfirmedEmailInfo = Search
							.xpath("//th[contains(text(), 'Confirmed email')]//following-sibling::td");
			this.AccountCreatedInfo = Search
							.xpath("//th[contains(text(), 'Account Created')]//following-sibling::td");
			this.AccountCreatedInInfo = Search
							.xpath("//th[contains(text(), 'Account Created in')]//following-sibling::td");
			this.CustomerGroupInfo = Search
							.xpath("//th[contains(text(), 'Customer Group')]//following-sibling::td");
			this.DefaultBillingAddress = Search.cssSelector("address");
		}

		public WebElement getLastLoggedInfo() {
			return this.LastLoggedInfo;
		}

		public WebElement getAccountLockedInInfo() {
			return this.AccountLockedInInfo;
		}

		public WebElement getConfirmedEmailInfo() {
			return this.ConfirmedEmailInfo;
		}

		public WebElement getAccountCreatedInfo() {
			return this.AccountCreatedInfo;
		}

		public WebElement getAccountCreatedInInfo() {
			return this.AccountCreatedInInfo;
		}

		public WebElement getCustomerGroupInfo() {
			return this.CustomerGroupInfo;
		}

		public WebElement getDefaultBillingAddress() {
			return this.DefaultBillingAddress;
		}
	}
	
	/**
	 *Inner class that represents the AccountInformation component.
	 */
	public class AccountInformation {
		private Select associateToWebsite;
		private Select group;
		private WebElement chekboxForGroup;
		private WebElement prefix;
		private WebElement firstname;
		private WebElement middlename;
		private WebElement lastname;
		private WebElement suffix;
		private WebElement email;
		private WebElement dateOfBirth;
		private WebElement tax;
		private Select gender;
		private Select sendWelcomeEmailFrom;

		/**
		 * Constructor - inits the elements for component
		 * on wake up.
		 */
		public AccountInformation() {
			this.associateToWebsite = new Select(Search
					.cssSelector("select[name='customer[website_id]']"));
			this.group = new Select(Search
					.cssSelector("select[name='customer[group_id]']"));
			this.chekboxForGroup = Search
					.xpath("//label[contains(text(),'Disable Automatic ')]");
			this.prefix =Search
					.cssSelector("input[name='customer[prefix]']");
			this.firstname = Search
					.cssSelector("input[name='customer[firstname]']");
			this.middlename = Search
					.cssSelector("input[name='customer[middlename]']");
			this.lastname = Search
					.cssSelector("input[name='customer[lastname]']");
			this.suffix = Search
					.cssSelector("input[name='customer[suffix]']");
			this.email = Search
					.cssSelector("input[name='customer[email]']");
			this.dateOfBirth = Search
					.cssSelector("input[name='customer[dob]']");
			this.tax = Search
					.cssSelector("input[name='customer[taxvat]']");
			this.gender = new Select(Search
					.cssSelector("select[name='customer[gender]']"));
			this.sendWelcomeEmailFrom = new Select(
					Search
							.cssSelector("select[name='customer[sendemail_store_id]']"));
		}

		/*
		 * Getters for AccountInformation component
		 */
		public Select getAssociateToWebsite() {
			return associateToWebsite;
		}

		public Select getGroup() {
			return group;
		}

		public WebElement getChekboxForGroup() {
			return chekboxForGroup;
		}

		public WebElement getLastname() {
			return lastname;
		}

		public WebElement getSelectedWebsite() {
			return this.associateToWebsite.getFirstSelectedOption();
		}

		public WebElement getSelectGroup() {
			return this.group.getFirstSelectedOption();
		}

		public WebElement getPrefix() {
			return this.prefix;
		}

		public WebElement getFirstname() {
			return this.firstname;
		}

		public WebElement getMiddlename() {
			return this.middlename;
		}

		public WebElement geLastname() {
			return this.lastname;
		}

		public WebElement getSuffix() {
			return this.suffix;
		}

		public WebElement getEmail() {
			return this.email;
		}

		public WebElement getDateOfBirth() {
			return this.dateOfBirth;
		}

		public WebElement getGender() {
			return this.gender.getFirstSelectedOption();
		}

		public WebElement getSendWelcomeEmailFrom() {
			return this.sendWelcomeEmailFrom.getFirstSelectedOption();
		}

		public WebElement getTax() {
			return this.tax;
		}

		public void lastnameSendValue(String value) {
			getLastname().sendKeys(value);
			areChangesMade = true;
		}

		/**
		 * Cheks if changes in AccountInformation fields are made.
		 * The supesrclass ACustomPageSideMenu field.
		 * @return true if some info was transfered to component inputs.
		 */
		public boolean isAreChangesMade() {
			return areChangesMade;
		}
		
		/**
		 * Cheks if checkbox for groups is
		 * checked.
		 * @return
		 * 			true if checkbox is checked.
		 */
		public boolean isGroupcheckboxchecked() {
			return this.chekboxForGroup.isSelected();
		}
		
		/**
		 * Cheks/unchecks the checkbox in AccountInformation
		 * Component.
		 */
		public void checkGroupcheckbox() {
			this.chekboxForGroup.click();
			areChangesMade = true;
		}

	}
	
	/**
	 * Inner class that represents the Addresses component.
	 */
	public class Adresses {
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

		/*
		 * Constructor
		 * Initializes the only button at first, but only,
		 * when no AJAX component that represents the addresses is
		 * present.
		 */
		public Adresses() {
			this.addNewAddresses = Search
							.xpath("//span[contains(text(),'Add New Addresses')]/parent::button");
			/*
			 * Initialization depends on customer information.
			 */
			if (!Search.cssSelector("address").isDisplayed()) {
				addNewAddresses.click();
			}
			this.address = Search.cssSelector("address");
			this.deleteButton = Search
					.cssSelector(".action-delete");
			this.defaultBillingCHK = Search
							.xpath("//input[@class='admin__control-checkbox']/following::label[contains(text(), 'Default Billing Address')]");
			this.defaultShippingCHK = Search
							.xpath("//input[@class='admin__control-checkbox']/following::label[contains(text(), 'Default Shipping Address')]");
			this.prefix = Search
							.xpath("//span[contains(text(), 'Prefix')]/parent::label/following-sibling::div/input[1]");
			this.firstname = Search
							.xpath("//span[contains(text(), 'First Name')]/parent::label/following-sibling::div/input[1]");
			this.middlename = Search
							.xpath("//span[contains(text(), 'Initial')]/parent::label/following-sibling::div/input[1]");
			this.lastname = Search
							.xpath("//span[contains(text(), 'Last Name')]/parent::label/following-sibling::div/input[1]");
			this.suffix = Search
							.xpath("//span[contains(text(), 'Suffix')]/parent::label/following-sibling::div/input[1]");
			this.company = Search
							.xpath("//span[contains(text(), 'Company')]/parent::label/following-sibling::div/input");
			this.streetAdressFirst = Search
							.xpath("//span[contains(text(), 'Street Address')]/parent::legend/following-sibling::div/div/div/input");
			this.streetAdressSecond = Search
							.xpath("//span[contains(text(), 'Street Address')]/parent::legend/following-sibling::div/div/div/input[1]");
			this.city = Search
							.xpath("//span[contains(text(), 'City')]/parent::label/following-sibling::div/input");
			this.country = new Select(Search
							.xpath("//span[contains(text(), 'Country')]/parent::label/following-sibling::div/select"));
			this.state = Search
							.xpath("//span[contains(text(), 'State')]/parent::label/following-sibling::div/select");
			this.zip = Search
							.xpath("//span[contains(text(), 'Zip')]/parent::label/following-sibling::div/input");
			this.phone = Search
							.xpath("//span[contains(text(), 'Phone')]/parent::label/following-sibling::div/input");
			this.vat = Search
							.xpath("//span[contains(text(), 'VAT')]/parent::label/following-sibling::div/input");
		}
		
		/*
		 * Getters for the component.
		 */
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

		public void citySendValue(String city) {
			this.city.sendKeys("city");
			areChangesMade = true;
		}
	}
	
	/**
	 * Inner class that represents the Addresses component.
	 */
	public class Orders extends ACustomerEditFilter {
		private WebElement orderSort;
		private WebElement purchasedSort;
		private WebElement bill_toSort;
		private WebElement ship_toSort;
		private WebElement totalSort;
		private WebElement storeSort;
		private WebElement orderFilter;
		private WebElement purchaseDateFilterFrom;
		private WebElement purchaseDateFilterTo;
		private WebElement bill_toFilter;
		private WebElement ship_toFilter;
		private WebElement totalFilterFrom;
		private WebElement totalFilterTo;
		private Select storeSelect;
		private WebElement result;

		/**
		 * Constructor
		 */
		private Orders() {
			/*
			 * Inits the super class elements.
			 */
			super.search = Search
					.cssSelector("button[title='Search']");
			super.resetFilter = Search
					.cssSelector("button[data-ui-id='widget-button-3']");
			super.recordsFound = Search
					.id("customer_orders_grid_page-limit");
			super.pagination = Search.cssSelectors(".admin__data-grid-pager");
			/*
			 * Inits the components elements
			 */
			this.orderSort = Search.cssSelector("th[data-sort='increment_id']");
			this.purchasedSort = Search.cssSelector("th[data-sort='created_at']");
			this.bill_toSort = Search.cssSelector("th[data-sort='billing_name']");
			this.ship_toSort = Search.cssSelector("th[data-sort='shipping_name']");
			this.totalSort = Search.cssSelector("th[data-sort='grand_total']");
			this.storeSort = Search.cssSelector("th[data-sort='store_id']");
			this.orderFilter = Search.cssSelector("input[name='increment_id']");
			this.purchaseDateFilterFrom = Search
					.cssSelector("input[data-ui-id='widget-grid-column-filter-datetime-0-filter-created-at-from']");
			this.purchaseDateFilterTo = Search
					.cssSelector("input[data-ui-id='widget-grid-column-filter-datetime-0-filter-created-at-to']");
			this.bill_toFilter = Search.cssSelector("input[name='billing_name']");
			this.ship_toFilter = Search.cssSelector("input[name='shipping_name']");
			this.totalFilterFrom = Search
							.cssSelector("td[data-column='grand_total'] input[name='grand_total[from]']");
			this.totalFilterTo = Search
							.cssSelector("td[data-column='grand_total'] input[name='grand_total[to]']");
			this.storeSelect = new Select(Search.cssSelector("select[name='store_id']"));
			if (Search.className("empty-text").isDisplayed()) {
				this.result = Search.className("empty-text");
			} else {
				// TODO
			}
		}
	}
	
	/**
	 * Navigates to AccountInformation component
	 * and loads it.
	 */
	public AccountInformation navToAccountInfo() {
		accountInfo.click();
		if (this.accountInformationAjax == null) {
			return this.accountInformationAjax = new AccountInformation();
		}
		return accountInformationAjax;
	}
	
	/**
	 * Navigates to Adresses component
	 * and loads it.
	 */
	public Adresses navToadresses() {
		adresses.click();
		if (this.adressesAjax == null) {
			return this.adressesAjax = new Adresses();
		}
		return adressesAjax;
	}
	
	/**
	 * Navigates to Orders component
	 * and loads it.
	 */
	public Orders navToorders() {
		orders.click();
		if (this.ordersAjax == null) {
			return this.ordersAjax = new Orders();
		}
		return getOrdersAjax();
	}
	
	/*
	 * Getters and Setters with bussiness logick.
	 * @see com.softserve.edu.magento.pages.admin.menu.customers.editCustomer.IEditCustomer#getSelectedWebsiteText()
	 */
	public String getSelectedWebsiteText() {
		navToAccountInfo();
		return accountInformationAjax.getSelectedWebsite().getText();
	}
	
	
	public void setAssocietedWebsite(AssosieteWebsites website) {
		navToAccountInfo();
		accountInformationAjax.associateToWebsite.selectByValue(website
				.toString());
	}

	public String getElectedGroupText() {
		navToAccountInfo();
		return this.accountInformationAjax.getSelectGroup().getText();
	}

	public void setGroup(Groups group) {
		navToAccountInfo();
		accountInformationAjax.group.selectByValue(group.toString());
	}

	public void setGender(Gender gender) {
		navToAccountInfo();
		accountInformationAjax.gender.selectByValue(gender.toString());
	}

	public void setSendWelcomeEmailFrom(AssosieteWebsites website) {
		navToAccountInfo();
		accountInformationAjax.sendWelcomeEmailFrom.selectByValue(website
				.toString());
	}
	
	/**
	 * Saves the state of "City" input,
	 * send a text to it, resets the changes and compares 
	 * the state of inpur before and after typing.
	 */
	public boolean compareChangesMadetoCity() {
		String pre = this.adressesAjax.getCity().getText();
		this.adressesAjax.citySendValue("New City");
		reset();
		String aft = this.adressesAjax.getCity().getText();
		return pre.toLowerCase().equals(aft);
	}
	
	/**
	 * Saves the state of all the inputs of AccountInfo
	 * component.
	 */
	public List<WebElement> getCustomerAllData() {
		if (this.accountInformationAjax == null) {
			navToAccountInfo();
		}
		return Search
				.cssSelectors("div[data-index='customer'] input");
	}

	/**
	 * Compares the text of some AccountInfo field 
	 * before and after some changes made to it.
	 * @param
	 * 		customerCurrentField - some input from	AccountInfo
	 * component.
	 */
	public boolean compareFields(WebElement customerCurrentField) {
		Integer index = getCustomerAllData().indexOf(customerCurrentField);
		String changed = null;
		if (index != null) {
			WebElement temp = getCustomerAllData().get(index);
			temp.sendKeys("blah-blah-blah");
			changed = temp.getText();
		}
		AllCustomersPage custPage = saveCustomer();
		custPage.getEditCustomerPage().navToAccountInfo();
		String saved = getCustomerAllData().get(index).getText();
		return saved.equals(changed);
	}
}

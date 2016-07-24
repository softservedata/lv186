package com.softserve.edu.magento.editCustomer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.softserve.edu.magento.pages.menu.customers.AllCustomersPage;

/**
 * Class that represents the EditCustomerPage with all the AJAX components in
 * it.
 * 
 * @author Andrew
 */
public class EditCustomerPage extends ACustomPageSideMenu {

	private WebDriver driver;
	private CustommerView custommerViewAjax;
	private AccountInformation accountInformationAjax;
	private Adresses adressesAjax;
	private Orders ordersAjax;

	/**
	 * Enum for AssosieteWebsites selector.
	 */
	private enum AssosieteWebsites {
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

	private enum Groups {
		// TODO
	}
	
	private enum Gender {
		// TODO
	}
	
	private enum DateOfBirth {
		// TODO
	}

	/**
	 * Constructor
	 * 
	 * @param driver
	 *            Webdriver that runs through test.
	 */
	public EditCustomerPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Component for CustommerView.
	 * 
	 * @author Andrew
	 */
	private class CustommerView {

		private WebElement LastLoggedInfo;
		private WebElement AccountLockedInInfo;
		private WebElement ConfirmedEmailInfo;
		private WebElement AccountCreatedInfo;
		private WebElement AccountCreatedInInfo;
		private WebElement CustomerGroupInfo;
		private WebElement DefaultBillingAddress;

		/**
		 * Constructor
		 */
		public CustommerView() {
			this.LastLoggedInfo = driver
					.findElement(By.xpath("//th[contains(text(), 'Last Logged')]//following-sibling::td"));
			this.AccountLockedInInfo = driver
					.findElement(By.xpath("//th[contains(text(), 'Account Lock')]//following-sibling::td"));
			this.ConfirmedEmailInfo = driver
					.findElement(By.xpath("//th[contains(text(), 'Confirmed email')]//following-sibling::td"));
			this.AccountCreatedInfo = driver
					.findElement(By.xpath("//th[contains(text(), 'Account Created')]//following-sibling::td"));
			this.AccountCreatedInInfo = driver
					.findElement(By.xpath("//th[contains(text(), 'Account Created in')]//following-sibling::td"));
			this.CustomerGroupInfo = driver
					.findElement(By.xpath("//th[contains(text(), 'Customer Group')]//following-sibling::td"));
			this.DefaultBillingAddress = driver.findElement(By.cssSelector("address"));
		}
	}

	private class AccountInformation {
		private Select associateToWebsite;
		private Select group;
		private WebElement chekboxForGroup;
		private WebElement prefix;
		private WebElement firstname;
		private WebElement middlename;
		private WebElement lastname;
		private WebElement suffix;
		private WebElement email;
		private Select dateOfBirth;
		private WebElement tax;
		private Select gender;
		private Select sendWelcomeEmailFrom;

		private boolean areChangesMade = false;

		/**
		 * Constructor
		 */
		public AccountInformation() {
			this.associateToWebsite = new Select(
					driver.findElement(By.cssSelector("select[name='customer[website_id]']")));
			this.group = new Select(driver.findElement(By.cssSelector("select[name='customer[group_id]']")));
			this.chekboxForGroup = driver.findElement(By.xpath("//label[contains(text(),'Disable Automatic ')]"));
			this.prefix = driver.findElement(By.cssSelector("input[name='customer[prefix]']"));
			this.firstname = driver.findElement(By.cssSelector("input[name='customer[firstname]']"));
			this.middlename = driver.findElement(By.cssSelector("input[name='customer[middlename]']"));
			this.lastname = driver.findElement(By.cssSelector("input[name='customer[lastname]']"));
			this.suffix = driver.findElement(By.cssSelector("input[name='customer[suffix]']"));
			this.email = driver.findElement(By.cssSelector("input[name='customer[email]']"));
			this.dateOfBirth = new Select(driver.findElement(By.cssSelector("input[name='customer[dob]']")));
			this.tax = driver.findElement(By.cssSelector("input[name='customer[taxvat]']"));
			this.gender = new Select(driver.findElement(By.cssSelector("select[name='customer[gender]']")));
			this.sendWelcomeEmailFrom = new Select(
					driver.findElement(By.cssSelector("select[name='customer[sendemail_store_id]']")));
		}
		

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


		public boolean isAreChangesMade() {
			return areChangesMade;
		}


		public WebElement getSelectedWebsite() {
			return this.associateToWebsite.getFirstSelectedOption();
		}

		public WebElement getSelectGroup() {
			return this.group.getFirstSelectedOption();
		}

		public boolean isGroupcheckboxchecked() {
			return this.chekboxForGroup.isSelected();
		}

		public void checkGroupcheckbox() {
			this.chekboxForGroup.click();
			areChangesMade = true;
		}

		public WebElement getPrefix() {
			return this.prefix;
		}

		public void setPrefix(String value) {
			this.prefix.sendKeys(value);
			areChangesMade = true;
		}

		public WebElement getFirstname() {
			return this.firstname;
		}
		
		public void setFirstname(String value) {
			this.firstname.sendKeys(value);
			areChangesMade = true;
		}

		public WebElement getMiddlename() {
			return this.middlename;
		}

		public void setMiddlename(String value) {
			this.middlename.sendKeys(value);
			areChangesMade = true;
		}
		
		public WebElement geLastname() {
			return this.middlename;
		}

		public void setLastname(String value) {
			this.middlename.sendKeys(value);
			areChangesMade = true;
		}
		
		public WebElement getSuffix() {
			return this.suffix;
		}

		public void setSuffix(String value) {
			this.suffix.sendKeys(value);
			areChangesMade = true;
		}
		
		public WebElement getEmail() {
			return this.email;
		}

		public void setEmail(String value) {
			this.email.sendKeys(value);
			areChangesMade = true;
		}
		
		public WebElement getDateOfBirth() {
			return this.dateOfBirth.getFirstSelectedOption();
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

		public void setTax(String value) {
			this.tax.sendKeys(value);
			areChangesMade = true;
		}
		
	}

	private class Adresses {

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
		 */
		private Adresses() {
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
	}

	private class Orders extends ACustomerEditFilter {
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
			super.search = driver.findElement(By.cssSelector("button[title='Search']"));
			super.resetFilter = driver.findElement(By.cssSelector("button[data-ui-id='widget-button-3']"));
			super.recordsFound = driver.findElement(By.id("customer_orders_grid-total-count"));
			super.perPage = new Select(driver.findElement(By.id("customer_orders_grid_page-limit")));
			super.pagination = driver.findElements(By.className("admin__data-grid-pager"));

			this.orderSort = driver.findElement(By.cssSelector("th[data-sort='increment_id']"));
			this.purchasedSort = driver.findElement(By.cssSelector("th[data-sort='created_at']"));
			this.bill_toSort = driver.findElement(By.cssSelector("th[data-sort='billing_name']"));
			this.ship_toSort = driver.findElement(By.cssSelector("th[data-sort='shipping_name']"));
			this.totalSort = driver.findElement(By.cssSelector("th[data-sort='grand_total']"));
			this.storeSort = driver.findElement(By.cssSelector("th[data-sort='store_id']"));
			this.orderFilter = driver.findElement(By.cssSelector("input[name='increment_id']"));
			this.purchaseDateFilterFrom = driver.findElement(
					By.cssSelector("input[data-ui-id='widget-grid-column-filter-datetime-0-filter-created-at-from']"));
			this.purchaseDateFilterTo = driver.findElement(
					By.cssSelector("input[data-ui-id='widget-grid-column-filter-datetime-0-filter-created-at-to']"));
			this.bill_toFilter = driver.findElement(By.cssSelector("input[name='billing_name']"));
			this.ship_toFilter = driver.findElement(By.cssSelector("input[name='shipping_name']"));
			this.totalFilterFrom = driver
					.findElement(By.cssSelector("td[data-column='grand_total'] input[name='grand_total[from]']"));
			this.totalFilterTo = driver
					.findElement(By.cssSelector("td[data-column='grand_total'] input[name='grand_total[to]']"));
			this.storeSelect = new Select(driver.findElement(By.cssSelector("select[name='store_id']")));
			if (driver.findElement(By.className("empty-text")).isDisplayed()) {
				this.result = driver.findElement(By.className("empty-text"));
			} else {

			}
		}
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	public CustommerView getCustommerView() {
		return this.custommerViewAjax;
	}

	public AccountInformation getAccountInformation() {
		return this.accountInformationAjax;
	}

	public Orders getOrders() {
		return this.ordersAjax;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void setCustommerView(CustommerView custommerView) {
		this.custommerViewAjax = custommerView;
	}

	public void setAccountInformation(AccountInformation accountInformation) {
		this.accountInformationAjax = accountInformation;
	}

	public void setOrders(Orders orders) {
		this.ordersAjax = orders;
	}

	// ---------------------System Logick-------------------------
	// TODO Customer PAge
	public void back() {
		back.click();
		// return
	}

	public void deleteCustomer() {
		// TODO stub
	}

	public void reset() {
		reset.click();
		changesMade = null;
		new EditCustomerPage(driver).accountInfo.click();
	}

	// TODO CreateOrder PAge
	public void createOrder() {
		// stub
	}

	public void resetPassword() {
		resetPassword.click();
		// stub
	}

	public void forceSignIn() {
		forceSignIn.click();
	}

	public void saveAndContinueEdit() {
		saveAndContinueEdit.click();
	}

	public AllCustomersPage saveCustomer() {
		saveCustomer.click();
		return new AllCustomersPage(getDriver());
	}

	public void navToAccountInfo() {
		accountInfo.click();
		if (this.accountInformationAjax == null) {
			this.accountInformationAjax = new AccountInformation();
		}
	}

	public void navToadresses() {
		adresses.click();
		if (this.adressesAjax == null) {
			this.adressesAjax = new Adresses();
		}
	}

	public void navToorders() {
		orders.click();
		if (this.ordersAjax == null) {
			this.ordersAjax = new Orders();
		}
	}

	// ---------------------Bussiness Logick-------------------------
	public String getSelectedWebsiteText() {
		navToAccountInfo();
		return accountInformationAjax.getSelectedWebsite().getText();
	}

	public void setAssocietedWebsite(AssosieteWebsites website) {
		navToAccountInfo();
		accountInformationAjax.associateToWebsite.selectByValue(website.toString());
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
	
	public void setDateOfBirth(DateOfBirth dateOfBirth) {
		navToAccountInfo();
		accountInformationAjax.dateOfBirth.selectByValue(dateOfBirth.toString());
	}
	
	public void setSendWelcomeEmailFrom (AssosieteWebsites website) {
		navToAccountInfo();
		accountInformationAjax.sendWelcomeEmailFrom.selectByValue(website.toString());
	}

	public List<WebElement> getCustomerAllData () {
		navToAccountInfo();
		List <WebElement> result = null;
		result = driver.findElements(By.cssSelector("div[data-index='customer']"));
		return result;
	}
	
	public boolean compareFields (WebElement customerCurrentField) {
		Integer index = getCustomerAllData().indexOf(customerCurrentField);
		WebElement temp = null;
		if(index != null) {
			temp =  getCustomerAllData().get(index);
			temp.sendKeys("blah-blah-blah");
		}
		WebElement changed = saveCustomer().getEditCustomerPage()
				.getCustomerAllData().get(index);
		
		return temp == changed;
	}
	
	public void checkGroupcheckbox() {
		navToAccountInfo();
		accountInformationAjax.checkGroupcheckbox();
	}

	public boolean isGroupcheckboxchecked() {

		return accountInformationAjax.isGroupcheckboxchecked();
	}

}

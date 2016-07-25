package com.softserve.edu.magento.editCustomer;

import java.util.ArrayList;
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

	private CustommerView custommerViewAjax;
	private AccountInformation accountInformationAjax;
	private Adresses adressesAjax;
	private Orders ordersAjax;
	private WebElement successMessage;

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
	
	private enum Country {
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
		this.custommerViewAjax = new CustommerView();	
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
		 * Constructor
		 */
		private AccountInformation() {
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
			this.dateOfBirth = driver.findElement(By.cssSelector("input[name='customer[dob]']"));
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
			EditCustomerPage.this.accountInformationAjax.firstname.sendKeys(value);
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
			return this.lastname;
		}

		public void setLastname(String value) {
			this.lastname.sendKeys(value);
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
		
	/*	public WebElement getDateOfBirth() {
			return this.dateOfBirth.getFirstSelectedOption();
		}
	*/
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
		private List <WebElement> messageIcon;
		
		/*
		 * Constructor
		 */
		private Adresses() {
			this.addNewAddresses = driver.findElement(By.xpath("//span[contains(text(),'Add New Addresses')]/parent::button"));
			if(!driver.findElement(By.cssSelector("address")).isDisplayed()){
				addNewAddresses.click();
			}
			this.address = driver.findElement(By.cssSelector("address"));
			this.deleteButton = driver.findElement(By.cssSelector(".action-delete"));
			this.defaultBillingCHK = driver.findElement(By
					.xpath("//input[@class='admin__control-checkbox']/following::label[contains(text(), 'Default Billing Address')]"));
			this.defaultShippingCHK = driver.findElement(By
					.xpath("//input[@class='admin__control-checkbox']/following::label[contains(text(), 'Default Shipping Address')]"));
			this.prefix = driver.findElement(By
					.xpath("//span[contains(text(), 'Prefix')]/parent::label/following-sibling::div/input[1]"));
			this.firstname = driver.findElement(By
					.xpath("//span[contains(text(), 'First Name')]/parent::label/following-sibling::div/input[1]"));
			this.middlename = driver.findElement(By
					.xpath("//span[contains(text(), 'Initial')]/parent::label/following-sibling::div/input[1]"));
			this.lastname = driver.findElement(By
					.xpath("//span[contains(text(), 'Last Name')]/parent::label/following-sibling::div/input[1]"));
			this.suffix = driver.findElement(By
					.xpath("//span[contains(text(), 'Suffix')]/parent::label/following-sibling::div/input[1]"));
			this.company = driver.findElement(By
					.xpath("//span[contains(text(), 'Company')]/parent::label/following-sibling::div/input"));
			this.streetAdressFirst = driver.findElement(By
					.xpath("//span[contains(text(), 'Street Address')]/parent::legend/following-sibling::div/div/div/input"));
			this.streetAdressSecond = driver.findElement(By
					.xpath("//span[contains(text(), 'Street Address')]/parent::legend/following-sibling::div/div/div/input[1]"));
			this.city = driver.findElement(By
					.xpath("//span[contains(text(), 'City')]/parent::label/following-sibling::div/input"));
			this.country = new Select(driver.findElement(By
					.xpath("//span[contains(text(), 'Country')]/parent::label/following-sibling::div/select")));
			this.state = driver.findElement(By
					.xpath("//span[contains(text(), 'State')]/parent::label/following-sibling::div/select"));
			this.zip = driver.findElement(By
					.xpath("//span[contains(text(), 'Zip')]/parent::label/following-sibling::div/input"));
			this.phone = driver.findElement(By
					.xpath("//span[contains(text(), 'Phone')]/parent::label/following-sibling::div/input"));
			this.vat = driver.findElement(By
					.xpath("//span[contains(text(), 'VAT')]/parent::label/following-sibling::div/input"));
		}
		
		public void clickAddNewAddresses () {
			addNewAddresses.click();
			this.address = driver.findElement(By.cssSelector("address"));
			this.deleteButton = driver.findElement(By.cssSelector(".action-delete"));
			this.defaultBillingCHK = driver.findElement(By
					.xpath("//input[@class='admin__control-checkbox']/following::label[contains(text(), 'Default Billing Address')]"));
			this.defaultShippingCHK = driver.findElement(By
					.xpath("//input[@class='admin__control-checkbox']/following::label[contains(text(), 'Default Shipping Address')]"));
			this.prefix = driver.findElement(By
					.xpath("//span[contains(text(), 'Prefix')]/parent::label/following-sibling::div/input[1]"));
			this.firstname = driver.findElement(By
					.xpath("//span[contains(text(), 'First Name')]/parent::label/following-sibling::div/input[1]"));
			this.middlename = driver.findElement(By
					.xpath("//span[contains(text(), 'Initial')]/parent::label/following-sibling::div/input[1]"));
			this.lastname = driver.findElement(By
					.xpath("//span[contains(text(), 'Last Name')]/parent::label/following-sibling::div/input[1]"));
			this.suffix = driver.findElement(By
					.xpath("//span[contains(text(), 'Suffix')]/parent::label/following-sibling::div/input[1]"));
			this.company = driver.findElement(By
					.xpath("//span[contains(text(), 'Company')]/parent::label/following-sibling::div/input"));
			this.streetAdressFirst = driver.findElement(By
					.xpath("//span[contains(text(), 'Street Address')]/parent::legend/following-sibling::div/div/div/input"));
			this.streetAdressSecond = driver.findElement(By
					.xpath("//span[contains(text(), 'Street Address')]/parent::legend/following-sibling::div/div/div/input[1]"));
			this.city = driver.findElement(By
					.xpath("//span[contains(text(), 'City')]/parent::label/following-sibling::div/input"));
			this.country = new Select(driver.findElement(By
					.xpath("//span[contains(text(), 'Country')]/parent::label/following-sibling::div/select")));
			this.state = driver.findElement(By
					.xpath("//span[contains(text(), 'State')]/parent::label/following-sibling::div/select"));
			this.zip = driver.findElement(By
					.xpath("//span[contains(text(), 'Zip')]/parent::label/following-sibling::div/input"));
			this.phone = driver.findElement(By
					.xpath("//span[contains(text(), 'Phone')]/parent::label/following-sibling::div/input"));
			this.vat = driver.findElement(By
					.xpath("//span[contains(text(), 'VAT')]/parent::label/following-sibling::div/input"));
		}

		public WebElement getAddNewAddresses() {
			return addNewAddresses;
		}

		public void setAddNewAddresses(String addNewAddresses) {
			this.addNewAddresses.sendKeys("addNewAddresses");
			areChangesMade = true;
		}

		public WebElement getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address.sendKeys("address");
			areChangesMade = true;
		}

		public WebElement getDeleteButton() {
			return deleteButton;
		}

		public void setDeleteButton(String deleteButton) {
			this.deleteButton.sendKeys("deleteButton");
			areChangesMade = true;
		}

		public WebElement getDefaultBillingCHK() {
			return defaultBillingCHK;
		}

		public void setDefaultBillingCHK() {
			this.defaultBillingCHK.click();
		}

		public WebElement getDefaultShippingCHK() {
			return defaultShippingCHK;
		}

		public void setDefaultShippingCHK() {
			this.defaultShippingCHK.click();
		}

		public WebElement getPrefix() {
			return prefix;
		}

		public void setPrefix(String prefix) {
			this.prefix.sendKeys("prefix");
			areChangesMade = true;
		}

		public WebElement getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname.sendKeys("firstname");
			areChangesMade = true;
		}

		public WebElement getMiddlename() {
			return middlename;
		}

		public void setMiddlename(String middlename) {
			this.middlename.sendKeys("middlename");
			areChangesMade = true;
		}

		public WebElement getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname.sendKeys("lastname");
			areChangesMade = true;
		}

		public WebElement getSuffix() {
			return suffix;
		}

		public void setSuffix(String suffix) {
			this.suffix.sendKeys("suffix");
			areChangesMade = true;
		}

		public WebElement getCompany() {
			return company;
		}

		public void setCompany(String company) {
			this.company.sendKeys("company");
			areChangesMade = true;
		}

		public WebElement getStreetAdressFirst() {
			return streetAdressFirst;
		}

		public void setStreetAdressFirst(String streetAdressFirst) {
			this.streetAdressFirst.sendKeys("streetAdressFirst");
			areChangesMade = true;
		}

		public WebElement getStreetAdressSecond() {
			return streetAdressSecond;
		}

		public void setStreetAdressSecond(String streetAdressSecond) {
			this.streetAdressSecond.sendKeys("streetAdressSecond");
			areChangesMade = true;
		}

		public WebElement getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city.sendKeys("city");
			areChangesMade = true;
		}

		public Select getCountry() {
			return country;
		}

		public void setCountry(Country country) {
			this.country.selectByValue(country.toString());
			areChangesMade = true;
		}

		public WebElement getState() {
			return state;
		}

		public void setState(String state) {
			this.state.sendKeys("state");
			areChangesMade = true;
		}

		public WebElement getZip() {
			return zip;
		}

		public void setZip(String zip) {
			this.zip.sendKeys("zip");
			areChangesMade = true;
		}

		public WebElement getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone.sendKeys("phone");
			areChangesMade = true;
		}

		public WebElement getVat() {
			return vat;
		}

		public void setVat(String vat) {
			this.vat.sendKeys("vat");
			areChangesMade = true;
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
	
	public WebElement getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage() {
		this.successMessage = driver.findElement(By
				.xpath("//div[contains(text(), 'You saved the customer.')]"));;
	}

	public CustommerView getCustommerViewAjax() {
		return custommerViewAjax;
	}

	public AccountInformation getAccountInformationAjax() {
		return this.accountInformationAjax;
	}

	public Adresses getAdressesAjax() {
		return adressesAjax;
	}

	public Orders getOrdersAjax() {
		return ordersAjax;
	}

	// ---------------------System Logick-------------------------
	public AllCustomersPage back() {
		back.click();
		return new AllCustomersPage(getDriver());
	}

	public void deleteCustomer() {
		// TODO stub
	}

	public EditCustomerPage reset() {
		reset.click();
		areChangesMade = false;
		return new EditCustomerPage(driver);
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
	
	public EditCustomerPage saveAndContinueEdit() {
		saveAndContinueEdit.click();
		return new EditCustomerPage(driver);
	}

	public AllCustomersPage saveCustomer() {
		saveCustomer.click();
		return new AllCustomersPage(getDriver());
	}

	public EditCustomerPage.AccountInformation navToAccountInfo() {
		accountInfo.click();
		if (this.accountInformationAjax == null) {
			return this.accountInformationAjax = new AccountInformation();
		}
		return accountInformationAjax;
	}

	public EditCustomerPage.Adresses navToadresses() {
		adresses.click();
		if (this.adressesAjax == null) {
			return this.adressesAjax = new Adresses();
		}
		return adressesAjax;
	}

	public EditCustomerPage.Orders navToorders() {
		orders.click();
		if (this.ordersAjax == null) {
			return this.ordersAjax = new Orders();
		}
		return ordersAjax;
	}
	
	public List<WebElement> getMessageIcon() {
		return changesMade;
	}

	public void setMessageIcon(List<WebElement> messageIcon) {
		changesMade = messageIcon;
	}

	// ---------------------Bussiness Logick-------------------------
	
	public boolean compareChangesMadetoCity () {
		String pre = this.adressesAjax.getCity().getText();
		this.adressesAjax.setCity("New City");
		reset();
		String aft = this.adressesAjax.getCity().getText();
		return pre.toLowerCase().equals(aft);
	}
	
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
	
	public void setSendWelcomeEmailFrom (AssosieteWebsites website) {
		navToAccountInfo();
		accountInformationAjax.sendWelcomeEmailFrom.selectByValue(website.toString());
	}

	public List<WebElement> getCustomerAllData () {
		if (this.accountInformationAjax == null){
			navToAccountInfo();
		}
		return driver.findElements(By.cssSelector("div[data-index='customer'] input"));
	}
	
	public boolean compareFields (WebElement customerCurrentField) {
		Integer index = getCustomerAllData().indexOf(customerCurrentField);
		String changed = null;
		if(index != null) {
			WebElement temp = getCustomerAllData().get(index);
			temp.sendKeys("blah-blah-blah");
			changed = temp.getText();
		}
		AllCustomersPage custPage = saveCustomer();
		custPage.getEditCustomerPage().navToAccountInfo();
		String saved = getCustomerAllData().get(index).getText();
		return saved.equals(changed);	
	}
	
	public void checkGroupcheckbox() {
		navToAccountInfo();
		accountInformationAjax.checkGroupcheckbox();
	}

	public boolean isGroupcheckboxchecked() {
		return accountInformationAjax.isGroupcheckboxchecked();
	}

}

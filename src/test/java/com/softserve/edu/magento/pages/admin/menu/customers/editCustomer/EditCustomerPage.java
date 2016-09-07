package com.softserve.edu.magento.pages.admin.menu.customers.editCustomer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.magento.pages.admin.menu.sales.OrdersPage;
import com.softserve.edu.magento.tools.ASearch;
import com.softserve.edu.magento.tools.Search;
import com.softserve.edu.magento.tools.SearchExplicitPresent;
import com.softserve.edu.magento.tools.SearchExplicitVisible;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.Select;

import com.softserve.edu.magento.pages.admin.menu.customers.AllCustomersPage;
import com.softserve.edu.magento.tools.Search.SearchStrategyList;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;


/**
 * Class that represents the EditCustomerPage with all the AJAX components in
 * it.
 * @author Andrew
 */
public class EditCustomerPage extends ACustomPageSideMenu implements IEditCustomer {

	private static volatile ICustommerView custommerViewAjax;
	private static volatile IAccountInformation accountInformationAjax;
	private static volatile IAdresses adressesAjax;
	private static volatile IOrders ordersAjax;
	private WebElement successMessage;
	private WebElement errorLabel;




	/*
	Constants
	 */
	public enum Constants {
        PREFIX (""),
        FIRSTNAME("Yaroslav"),
        LASTNAME ("Harasym"),
        PAGE_TITLE (null),
        DEFAULT_BILLING_ADDRESS("");
        String value;

        Constants(String value){
            this.value = value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }
    }

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
	public ICustommerView getCustommerView() {
		return this.custommerViewAjax;
	}

	public IAccountInformation getAccountInformation() {return this.accountInformationAjax; }

	public IAdresses getAdressesAjax() {
		return this.adressesAjax;
	}

	public IOrders getOrdersAjax() {
		return this.ordersAjax;
	}

	public WebElement getSuccessMessage() {
		return this.successMessage;
	}

	public EditCustomerPage getEditCustomerPage () {
        return  new EditCustomerPage();
    }

    public WebElement locateErrorLabel() {
        try{
            this.errorLabel = Search.cssSelector("label.admin__field-error");
        } catch (NoSuchElementException e){
            this.errorLabel = null;
        }
        return  this.errorLabel;
    }

    public WebElement getErrorLabel() {
        return  this.errorLabel;
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
	 * @return new AllCustomerPage.
	 */
	public AllCustomersPage back() {
		back.click();
		return new AllCustomersPage();
	}

	/**
	 * Deletes the current customer from DB.
	 * @return new AllCustomerPage
	 */
	public AllCustomersPage deleteCustomer() {
		deleteCustomer.click();
		return new AllCustomersPage();
	}
	
	/**
	 * Resets all the changes made
	 * to Customer data.
	 * @return new EditCustomerPage
	 */
	public EditCustomerPage reset() {
		reset.click();
		areChangesMade = false;
		return new EditCustomerPage();
	}

	/**
	 * Navigates to Orders page.
	 * @return new OrdersPage.
	 */
	public OrdersPage createOrder() {
		createOrder.click();
		return new OrdersPage();
	}

    /**
     * Sends email to customer with
     * link to reset the password.
     */
	public void resetPassword() {
		resetPassword.click();
	}

    /**
     * Force login customer with tokens.
     */
	public void forceSignIn() {
		forceSignIn.click();
	}
	
	/**
	 * Saves all changes made to Customer data.
	 * @return new EditCustomerPage.
	 */
	public EditCustomerPage saveAndContinueEdit() {
		saveAndContinueEdit.click();
		return new EditCustomerPage();
	}
	
	/**
	 * Saves Customer and goes back to
	 * AllCustomersPage.
	 * @return new AllCustomersPage.
	 */
	public AllCustomersPage saveCustomer() {
		saveCustomer.click();
		return new AllCustomersPage();
	}

	interface ICustommerView {
		public WebElement getLastLoggedInfo();
		public WebElement getAccountLockedInInfo();
		public WebElement getConfirmedEmailInfo();
		public WebElement getAccountCreatedInfo();
		public WebElement getAccountCreatedInInfo();
		public WebElement getCustomerGroupInfo();
		public WebElement getDefaultBillingAddress();
	}

	/**
	 * Component for CustommerView.
	 * @author Andrew
	 */
	private class CustommerView implements ICustommerView {
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
			this.DefaultBillingAddress = Search.cssSelector("div.fieldset-wrapper.customer-information address");
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
	interface IAccountInformation {
		public Select getAssociateToWebsite();
		public Select getGroup();
		public WebElement getChekboxForGroup();
		public WebElement getLastname();
		public WebElement getSelectedWebsite();
		public WebElement getSelectGroup();
		public WebElement getPrefix();
		public WebElement getFirstname();
		public WebElement getMiddlename();
		public WebElement geLastname();
		public WebElement getSuffix();
		public WebElement getEmail();
		public WebElement getDateOfBirth();
		public Select getGender();
		public Select getSendWelcomeEmailFrom();
		public WebElement getTax();
	}

	private class AccountInformation implements IAccountInformation {
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
		private AccountInformation() {
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

		public Select getGender() {
			return this.gender;
		}

		public Select getSendWelcomeEmailFrom() {
			return this.sendWelcomeEmailFrom;
		}

		public WebElement getTax() {
			return this.tax;
		}
	}

	interface IAdresses {
		public WebElement getAddNewAddresses();
		public WebElement getAddress();
		public WebElement getDeleteButton();
		public WebElement getDefaultBillingCHK();
		public WebElement getDefaultShippingCHK();
		public WebElement getPrefix();
		public WebElement getFirstname();
		public WebElement getMiddlename();
		public WebElement getLastname();
		public WebElement getSuffix();
		public WebElement getCompany();
		public WebElement getStreetAdressFirst();
		public WebElement getStreetAdressSecond();
		public WebElement getCity();
		public Select getCountry();
		public Select getState();
		public WebElement getZip();
		public WebElement getPhone();
		public WebElement getVat();
	}

	/**
	 * Inner class that represents the Addresses component.
	 */
	private class Adresses implements IAdresses {
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
		private Select state;
		private WebElement zip;
		private WebElement phone;
		private WebElement vat;

		/*
		 * Constructor
		 * Initializes the only button at first, but only,
		 * when no AJAX component that represents the addresses is
		 * present.
		 */
		private Adresses() {
			this.addNewAddresses = Search
							.xpath("//span[contains(text(),'Add New Addresses')]/parent::button");
			/*
			 * Initialization depends on customer information.
			 */
			if (!Search.cssSelectors("address").get(0).isDisplayed()) {
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
			this.state = new Select(Search
							.xpath("//span[contains(text(), 'State')]/parent::label/following-sibling::div/select"));
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

		public Select getState() {
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

		public void setDefaultBillingCHK(WebElement element) {
		  this.defaultBillingCHK = element;
        }
	}

	interface IOrders {

	}
	/**
	 * Inner class that represents the Addresses component.
	 */
	private class Orders extends ACustomerEditFilter implements IOrders{
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
					.cssSelector("button[title='SearchRecords']");
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

	/*
	 *Singleton initializers.
	 */
	public static IAccountInformation initAccountInfo() {
		if (accountInformationAjax == null) {
			synchronized (IAccountInformation.class) {
				accountInformationAjax = new EditCustomerPage().new AccountInformation();
			}
		}
		return accountInformationAjax;
	}

	public static IAdresses initAdresses() {
		if (adressesAjax == null) {
			synchronized (IAccountInformation.class) {
				adressesAjax = new EditCustomerPage().new Adresses();
			}
		}
		return adressesAjax;
	}

	public static IOrders initOrders() {
		if (ordersAjax == null) {
			synchronized (IAccountInformation.class) {
				ordersAjax = new EditCustomerPage().new Orders();
			}
		}
		return ordersAjax;
	}

	
	/**
	 * Navigates to AccountInformation component
	 * and loads it.
	 */
	public IAccountInformation navToAccountInfo() {
		accountInfo.click();
        accountInformationAjax = null;
		return accountInformationAjax = initAccountInfo();
	}
	
	/**
	 * Navigates to Adresses component
	 * and loads it.
	 */
	public IAdresses navToadresses() {
		adresses.click();
        adressesAjax = null;
		return this.adressesAjax = initAdresses();
	}
	
	/**
	 * Navigates to Orders component
	 * and loads it.
	 */
	public IOrders navToorders() {
		orders.click();
		return this.ordersAjax = initOrders();
	}
	
	/*
	 * Getters and Setters with bussiness logick.
	 * @see com.softserve.edu.magento.pages.admin.menu.customers.editCustomer.IEditCustomer#getSelectedWebsiteText()
	 */
	public void citySendValue(String city) {
		getAdressesAjax().getCity().sendKeys("city");
		areChangesMade = true;
	}

	public void lastnameSendValue(String value) {
		getAccountInformation().getLastname().sendKeys(value);
		areChangesMade = true;
	}

	public String getSelectedWebsiteText() {
		navToAccountInfo();
		return accountInformationAjax.getSelectedWebsite().getText();
	}

	public String getEditCustomerTitle() {
		String result;
		result = Search.cssSelector(".page-title-wrapper h1").getText();
		return  result;
	}

	public void setAssocietedWebsite(AssosieteWebsites website) {
		navToAccountInfo();
		accountInformationAjax.getAssociateToWebsite().selectByValue(website
				.toString());
	}

	public String getSelectedGroupText() {
		navToAccountInfo();
		return this.accountInformationAjax.getSelectGroup().getText();
	}

	public void setGroup(Groups group) {
		navToAccountInfo();
		accountInformationAjax.getGroup().selectByValue(group.toString());
	}

	public void setGender(Gender gender) {
		navToAccountInfo();
		accountInformationAjax.getGender().selectByValue(gender.toString());
	}

	public void setSendWelcomeEmailFrom(AssosieteWebsites website) {
		navToAccountInfo();
		accountInformationAjax.getSendWelcomeEmailFrom().selectByValue(website
				.toString());
	}
    //Account Information business logic.
	public void enterValueIntoPrefix (String value){
	    getAccountInformation().getPrefix().sendKeys(value);
    }

    public void enterValueIntoFirstname (String value){
        getAccountInformation().getFirstname().sendKeys(value);
    }

    public void enterValueIntoLastname (String value){
        getAccountInformation().getLastname().sendKeys(value);
    }

	public void enterValuesIntoFields (String value) {
        enterValueIntoPrefix(value);
        enterValueIntoFirstname(value);
        enterValueIntoLastname(value);
    }
    //Addresses business logic.
	public void createNewAddress(String values) {
		String[] result = values.split(";");
		Actions action = new Actions(ASearch.getWebDriver());
		getAdressesAjax().getAddNewAddresses().click();
		action.moveToElement(Search.cssSelector("input[name='address[new_0][street][0]']")).click().sendKeys(result[0]).perform();
		action.moveToElement(Search.cssSelector("input[name='address[new_0][city]']")).click().sendKeys(result[1]).perform();
		action.moveToElement(Search.cssSelector("input[name='address[new_0][postcode]']")).click().sendKeys(result[2]).perform();
//        ((JavascriptExecutor)ASearch.getWebDriver()).executeScript
//                ("document.querySelector('[name=\"address[new_0][country_id]\"], [value=\"' + \"US\" + '\"])').selected = true;", Search.cssSelector("select[name='address[new_0][country_id]']"));
		action.moveToElement(Search.cssSelector("input[name='address[new_0][telephone]']")).click().sendKeys(result[3]).perform();
		Search.cssSelector("select[name='address[new_0][country_id]']").click();
		ASearch.getWebDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		ASearch.getWebDriver().switchTo().activeElement().click();
		action.moveToElement(Search.cssSelector("input[name='address[new_0][prefix]']"));
	}

    public void checkNewDefaultBillingAddress() {
        Search
                .xpaths("//input[@class='admin__control-checkbox']/following::label[contains(text(), 'Default Billing Address')]").get(1).click();
    }

    public String getAddressValues () {
        return new String(getCustommerView().getDefaultBillingAddress().getText());
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
		return getAccountInformation().getChekboxForGroup().isSelected();
	}

	/**
	 * Cheks/unchecks the checkbox in AccountInformation
	 * Component.
	 */
	public void checkGroupcheckbox() {
		getAccountInformation().getChekboxForGroup().click();
		areChangesMade = true;
	}
	
	/**
	 * Saves the state of "City" input,
	 * send a text to it, resets the changes and compares 
	 * the state of inpur before and after typing.
	 */
	public boolean compareChangesMadetoCity() {
		String pre = this.adressesAjax.getCity().getText();
		citySendValue("New City");
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

	public WebElement getPrefix(){
	    return getAccountInformation().getPrefix();
    }

    public WebElement getFirstname(){
        return getAccountInformation().getFirstname();
    }

    public WebElement getLastname(){
        return getAccountInformation().getLastname();
    }

    public String saveFieldText(WebElement field) {
    	String result = field.getText();
    	return result;
	}

	public String stringFromFile(String file) {
        String result = null;
        try {
            result = new String(readAllBytes(get(file)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void clickAccountInfo() {
        this.accountInfo.click();
    }
}

package com.softserve.edu.magento.pages.admin.menu.customers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.softserve.edu.magento.data.customer.user.ICustomerUser;
import com.softserve.edu.magento.pages.admin.VerticalMenu;
import com.softserve.edu.magento.pages.admin.menu.customers.editCustomer.EditCustomerPage;
import com.softserve.edu.magento.tools.Search;

public class AllCustomersPage extends VerticalMenu {
	public final static String PAGE_TITLE = "Customers";
	private boolean isWebElementFound = false;

	// components
	private ColumnsMenuDropdown columnsmenudropdown;
	private ActionsDropDownMenu actionsdropdownmenu;
	private DefaultViewDropdownMenu defaultdropdownmenu;
	private FiltersDropDownMenu filtersdropdownmenu;
	private GroupsButton groupsButton;

	// Elements
	private WebElement customersLabel;
	private WebElement addNewCustomerButton;
	private WebElement searchField;
	private WebElement filtersButton;
	private WebElement defaultViewButton;
	private WebElement columnsButton;
	private WebElement exportButton;
	private WebElement actionsButton;
	private WebElement perPageButton;
	private WebElement goToPageLeftButton;
	private WebElement goToPageRightButton;
	private WebElement howManyCustomersInListArePresentedField;
	private WebElement selectAllButton;
	private WebElement selectAllCustomersInListButton;
	private WebElement selectFirstCustomer;
	private WebElement howManyPagesAreInList;
	private WebElement idFielsInList;
	private WebElement nameFieldInList;
	private WebElement emailFieldInList;
	private WebElement groupFieldInList;
	private WebElement phoneFieldInList;
	private WebElement zipFieldInList;
	private WebElement countryFieldInList;
	private WebElement stateFieldInList;
	private WebElement customerSinceFieldInList;
	private WebElement webSiteFieldInList;
	private WebElement confirmedEmailFieldInList;
	private WebElement accountCreatedInFieldInList;
	private WebElement dateOfBirdthFieldInList;
	private WebElement taxVatNumberFieldInList;
	private WebElement genderFieldInList;
	private WebElement clearAll;
	// written by Andrii
	private List<WebElement> editList;

	// -----------------ColumnsMenuDropdown-------------------
	private class ColumnsMenuDropdown {
		private WebElement idCheck;
		private WebElement nameCheck;
		private WebElement emailCheck;
		private WebElement groupCheck;
		private WebElement phoneCheck;
		private WebElement zipCheck;
		private WebElement countryCheck;
		private WebElement stateCheck;
		private WebElement customerSinceCheck;
		private WebElement websiteCheck;
		private WebElement confirmedEmailCheck;
		private WebElement accauntCreatedInCheck;
		private WebElement dateOfBirdthCheck;
		private WebElement taxVatNumberCheck;
		private WebElement genderCheck;
		private WebElement cityCheck;
		private WebElement resetButton;

		public ColumnsMenuDropdown() {
			this.idCheck = Search.cssSelector("input[id='1']");
			this.nameCheck = Search.cssSelector("input[id='2']");
			this.emailCheck = Search.cssSelector("input[id='3']");
			this.groupCheck = Search.cssSelector("input[id='4']");
			this.phoneCheck = Search.cssSelector("input[id='5']");
			this.zipCheck = Search.cssSelector("input[id='6']");
			this.countryCheck = Search.cssSelector("input[id='7']");
			this.stateCheck = Search.cssSelector("input[id='8']");
			this.customerSinceCheck = Search.cssSelector("input[id='9']");
			this.websiteCheck = Search.cssSelector("input[id='10']");
			this.confirmedEmailCheck = Search.cssSelector("input[id='11']");
			this.accauntCreatedInCheck = Search.cssSelector("input[id='12']");
			this.dateOfBirdthCheck = Search.cssSelector("input[id='15']");
			this.taxVatNumberCheck = Search.cssSelector("input[id='16']");
			this.genderCheck = Search.cssSelector("input[id='17']");
			this.cityCheck = Search.cssSelector("input[id='19']");
			this.resetButton = Search.xpath("(.//*[@class='action-tertiary'])[1]");
		}

		// getters to ColumnsMenuPage
		public WebElement getIdCheck() {
			return idCheck;
		}

		public WebElement getNameCheck() {
			return nameCheck;
		}

		public WebElement getEmailCheck() {
			return emailCheck;
		}

		public WebElement getGroupCheck() {
			return groupCheck;
		}

		public WebElement getPhoneCheck() {
			return phoneCheck;
		}

		public WebElement getZipCheck() {
			return zipCheck;
		}

		public WebElement getCountryCheck() {
			return countryCheck;
		}

		public WebElement getStateCheck() {
			return stateCheck;
		}

		public WebElement getCustomerSinceCheck() {
			return customerSinceCheck;
		}

		public WebElement getWebsiteCheck() {
			return websiteCheck;
		}

		public WebElement getConfirmedEmailCheck() {
			return confirmedEmailCheck;
		}

		public WebElement getAccauntCreatedInCheck() {
			return accauntCreatedInCheck;
		}

		public WebElement getDateOfBirdthCheck() {
			return dateOfBirdthCheck;
		}

		public WebElement getTaxVatNumberCheck() {
			return taxVatNumberCheck;
		}

		public WebElement getGenderCheck() {
			return genderCheck;
		}

		public WebElement getCityCheck() {
			return cityCheck;
		}

		public WebElement getResetButton() {
			return resetButton;
		}

	}

	// -----------------ActionsDropDownMenu-------------------

	private class ActionsDropDownMenu {
		private WebElement delete;
		private WebElement subscribe;
		private WebElement unSubscribe;
		private WebElement assignCustomerGroup;
		private WebElement edit;

		public ActionsDropDownMenu() {
			this.delete = Search.xpath("//span[text()='Delete']");
			this.subscribe = Search.xpath("(//span[text()='Subscribe to Newsletter'])[2]");
			this.unSubscribe = Search.xpath("(//span[text()='Unsubscribe from Newsletter'])[2]");
			this.assignCustomerGroup = Search.xpath("(//span[text()='Assign a Customer Group'])[2]");
			this.edit = Search.xpath("(//span[text()='Edit'])[2]");
		}

		// getters to ActionsDropDownMenu
		public WebElement getDelete() {
			return delete;
		}

		public WebElement getSubscribe() {
			return subscribe;
		}

		public WebElement getUnSubscribe() {
			return unSubscribe;
		}

		public WebElement getAssignCustomerGroup() {
			return assignCustomerGroup;
		}

		public WebElement getEdit() {
			return edit;
		}

	}

	// -----------------DefaultViewDropdownMenu-------------------
	private class DefaultViewDropdownMenu {
		private WebElement defaultView;
		private WebElement myNewView;
		private WebElement myNewViewEdit;
		private WebElement saveViewAs;

		public DefaultViewDropdownMenu() {
			this.defaultView = Search.xpath("(.//*[@class='action-dropdown-menu-link'])[1]");
			this.myNewView = Search.xpath("(.//*[@class='action-dropdown-menu-link'])[2]");
			// this.myNewViewEdit =
			// driver.findElement(By.xpath("//*[@class='action-edit']"));
			// this.saveViewAs =
			// driver.findElement(By.xpath(".//*[@id='container']//div[1]/div[1]/ul/li[3]/a"));
		}

		public WebElement getDefaultView() {
			return defaultView;
		}

		public WebElement getMyNewView() {
			return myNewView;
		}

		public WebElement getMyNewViewEdit() {
			return myNewViewEdit;
		}

		public WebElement getSaveViewAs() {
			return saveViewAs;
		}

	}

	// -----------------FiltersDropDownMenu-----------------------
	private class FiltersDropDownMenu {
		private WebElement filtersIdFrom;
		private WebElement filtersIdTo;
		private WebElement filtersCustomerSinceFrom;
		private WebElement filtersCustomerSinceTo;
		private WebElement filtersDateOfBirthFrom;
		private WebElement filtersDateOfBirthTo;
		private WebElement filtersName;
		private WebElement filtersEmail;
		private WebElement filtersGroup;
		private WebElement filtersPhone;
		private WebElement filtersZip;
		private WebElement filtersCountry;
		private WebElement filtersProvince;
		private WebElement filtersWebSite;
		private WebElement filtersTaxVat;
		private WebElement filtersGender;

		public FiltersDropDownMenu() {
			this.filtersIdFrom = Search.cssSelector("input[name='entity_id[from]']");
			this.filtersIdTo = Search.cssSelector("input[name='entity_id[to]']");
			this.filtersCustomerSinceFrom = Search.cssSelector("input[name='created_at[from]']");
			this.filtersCustomerSinceTo = Search.cssSelector("input[name='created_at[to]']");
			this.filtersDateOfBirthFrom = Search.cssSelector("input[name='dob[from]']");
			this.filtersDateOfBirthTo = Search.cssSelector("input[name='dob[to]']");
			this.filtersName = Search.cssSelector("input[name='name']");
			this.filtersEmail = Search.cssSelector("input[name='email']");
			this.filtersGroup = Search.cssSelector("select[name='group_id']");
			this.filtersPhone = Search.cssSelector("input[name='billing_telephone']");
			this.filtersZip = Search.cssSelector("input[name='billing_postcode']");
			this.filtersCountry = Search.cssSelector("select[name='billing_country_id']");
			this.filtersProvince = Search.cssSelector("input[name='billing_region']");
			this.filtersWebSite = Search.cssSelector("select[name='website_id']");
			this.filtersTaxVat = Search.cssSelector("input[name='taxvat']");
			this.filtersGender = Search.cssSelector("select[name='gender']");

		}
		// getters to FiltersDropDownMenu

		public WebElement getFiltersIdFrom() {
			return filtersIdFrom;
		}

		public WebElement getFiltersIdTo() {
			return filtersIdTo;
		}

		public WebElement getFiltersCustomerSinceFrom() {
			return filtersCustomerSinceFrom;
		}

		public WebElement getFiltersCustomerSinceTo() {
			return filtersCustomerSinceTo;
		}

		public WebElement getFiltersDateOfBirthFrom() {
			return filtersDateOfBirthFrom;
		}

		public WebElement getFiltersDateOfBirthTo() {
			return filtersDateOfBirthTo;
		}

		public WebElement getFiltersName() {
			return filtersName;
		}

		public WebElement getFiltersEmail() {
			return filtersEmail;
		}

		public WebElement getFiltersGroup() {
			return filtersGroup;
		}

		public WebElement getFiltersPhone() {
			return filtersPhone;
		}

		public WebElement getFiltersZip() {
			return filtersZip;
		}

		public WebElement getFiltersCountry() {
			return filtersCountry;
		}

		public WebElement getFiltersProvince() {
			return filtersProvince;
		}

		public WebElement getFiltersWebSite() {
			return filtersWebSite;
		}

		public WebElement getFiltersTaxVat() {
			return filtersTaxVat;
		}

		public WebElement getFiltersGender() {
			return filtersGender;
		}

	}

	// -----------------Groups class-----------------------
	private class GroupsButton {
		private WebElement general;
		private WebElement wholesale;
		private WebElement retailer;

		public GroupsButton() {
			this.general = Search.xpath(".//*[@id='A1HMI49']/option[2]");
			this.wholesale = Search.xpath(".//*[@id='A1HMI49']/option[3]");
			this.retailer = Search.xpath(".//*[@id='A1HMI49']/option[4]");
		}
	}

	// main page constructor
	public AllCustomersPage() {
		System.out.println("AllCustomersPage");
		this.customersLabel = Search.xpath(".//*[@class='page-title-wrapper']");
		this.addNewCustomerButton = Search.id("add");
		this.searchField = Search.xpath("(.//*[@id='fulltext'])[1]");
		// this.filtersButton = driver.findElement(By.xpath("");
		this.defaultViewButton = Search.xpath("(//span[text()='Default View'])[1]");
		this.columnsButton = Search.xpath("(//span[text()='Columns'])[1]");
		this.exportButton = Search.xpath("(//span[text()='Export'])[2]");
		this.actionsButton = Search.xpath("(//span[text()='Actions'])[1]");
		this.perPageButton = Search.xpath("(.//*[@id='customer_listing.customer_listing.listing_top.listing_paging_sizes'])[1]");
		this.goToPageLeftButton = Search.xpath("(.//*[@class='action-previous'])[1]");
		this.goToPageRightButton = Search.xpath(".//*[@class='action-next'][1]");
		this.howManyCustomersInListArePresentedField = Search.xpath("(//span[text()='records found'])[1]");
		this.selectAllButton = Search.xpath("//*[@for='60']");
		this.selectAllCustomersInListButton = Search.xpath("//*[@for='60']");
		this.howManyPagesAreInList = Search.id("29");
		this.idFielsInList = Search.xpath("(//span[text()='ID'])[2]");
		this.nameFieldInList = Search.xpath("(//span[text()='Name'])[3]");
		this.emailFieldInList = Search.xpath("(//span[text()='Email'])[2]");
		this.groupFieldInList = Search.xpath("(//span[text()='Group'])[2]");
		this.phoneFieldInList = Search.xpath("(//span[text()='Phone'])[2]");
		this.zipFieldInList = Search.xpath("(//span[text()='ZIP'])[2]");
		this.countryFieldInList = Search.xpath("(//span[text()='Country'])[2]");
		this.stateFieldInList = Search.xpath("(//span[text()='State/Province'])[2]");
		this.customerSinceFieldInList = Search.xpath("(//span[text()='Customer Since'])[2]");
		this.webSiteFieldInList = Search.xpath("(//span[text()='Web Site'])[2]");
		this.confirmedEmailFieldInList = Search.xpath("(//span[text()='Confirmed email'])[1]");
		this.accountCreatedInFieldInList = Search.xpath("(//span[text()='Account Created in'])[1]");
		this.dateOfBirdthFieldInList = Search.xpath("(//span[text()='Date of Birth'])[2]");
		this.taxVatNumberFieldInList = Search.xpath("(//span[text()='Tax VAT Number'])[2]");
		this.genderFieldInList = Search.xpath("(//span[text()='Gender'])[2]");
		// written by Andrii
		this.editList = Search.cssSelectors("a[data-repeat-index='0'");
		this.columnsmenudropdown = new ColumnsMenuDropdown();
		this.actionsdropdownmenu = new ActionsDropDownMenu();
		this.defaultdropdownmenu = new DefaultViewDropdownMenu();
		this.filtersdropdownmenu = new FiltersDropDownMenu();
		System.out.println("AllCustomersPage done");
	}

	// ------------System logic get page components--------------------//

	public ColumnsMenuDropdown getColumnsMenuDropdown() {
		return columnsmenudropdown;
	}

	public ActionsDropDownMenu getActionsDropDownMenu() {
		return actionsdropdownmenu;
	}

	public FiltersDropDownMenu getFiltersDropDownMenu() {
		return filtersdropdownmenu;
	}

	public DefaultViewDropdownMenu getDefaultViewDropdownMenu() {
		return defaultdropdownmenu;
	}

	// getters to main class
	// get Data PageObject

	public WebElement getClearAllButton() {
		return this.clearAll;
	}

	public WebElement getCustomersLabel() {
		return this.customersLabel;
	}

	public WebElement getAddNewCustomerButton() {
		return this.addNewCustomerButton;
	}

	public WebElement getSearchField() {
		return this.searchField;
	}

	public WebElement getFiltersButton() {
		return this.filtersButton;
	}

	public WebElement getDefaultViewButton() {
		return this.defaultViewButton;
	}

	public WebElement getColumnsButton() {
		return this.columnsButton;
	}

	public WebElement getExportButton() {
		return this.exportButton;
	}

	public WebElement getActionsButton() {
		return this.actionsButton;
	}

	public WebElement getPerPageButton() {
		return this.perPageButton;
	}

	public WebElement getGoToPageLeftButton() {
		return this.goToPageLeftButton;
	}

	public WebElement getGoToPageRightButton() {
		return this.goToPageRightButton;
	}

	public WebElement getHowManyCustomersInListArePresentedField() {
		return this.howManyCustomersInListArePresentedField;
	}

	public WebElement getSelectAllButton() {
		return this.selectAllButton;
	}

	public WebElement getSelectAllCustomersInListButton() {
		return this.selectAllCustomersInListButton;
	}

	public WebElement getIdFielsInList() {
		return this.idFielsInList;
	}

	public WebElement getNameFieldInList() {
		return this.nameFieldInList;
	}

	public WebElement getEmailFieldInList() {
		return this.emailFieldInList;
	}

	public WebElement getGroupFieldInList() {
		return this.groupFieldInList;
	}

	public WebElement getPhoneFieldInList() {
		return this.phoneFieldInList;
	}

	public WebElement getZipFieldInList() {
		return this.zipFieldInList;
	}

	public WebElement getCountryFieldInList() {
		return this.countryFieldInList;
	}

	public WebElement getStateFieldInList() {
		return this.stateFieldInList;
	}

	public WebElement getCustomerSinceFieldInList() {
		return this.customerSinceFieldInList;
	}

	public WebElement getWebSiteFieldInList() {
		return this.webSiteFieldInList;
	}

	public WebElement getConfirmedEmailFieldInList() {
		return this.confirmedEmailFieldInList;
	}

	public WebElement getAccountCreatedInFieldInList() {
		return this.accountCreatedInFieldInList;
	}

	public WebElement getDateOfBirdthFieldInList() {
		return this.dateOfBirdthFieldInList;
	}

	public WebElement getTaxVatNumberFieldInList() {
		return this.taxVatNumberFieldInList;
	}

	public WebElement getGenderFieldInList() {
		return this.genderFieldInList;
	}

	// written by Andrii
	public WebElement getEditLink(int index) {
		return editList.get(index);
	}

	// written by Andrii
	public EditCustomerPage getEditCustomerPage() {
		getEditLink(0).click();
		return new EditCustomerPage();
	}

	// get Data Business Logic

	public String getCustomersLabelText() {
		return customersLabel.getText().trim();
	}

	public String getHowManyCustomersInListArePresentedFieldText() {
		return howManyCustomersInListArePresentedField.getText().trim();
	}

	public String getsearchFieldText() {
		return searchField.getText().trim();
	}

	// click for FiltersDropDownMenu

	public void filtersdropdownmenuIdGroupClick() {
		filtersdropdownmenu.filtersGroup.click();
	}

	// click for DefaultViewDropdownMenu

	public void defaultdropdownmenuDefaultViewClick() {
		getDefaultViewDropdownMenu().getDefaultView().click();
	}

	public void defaultdropdownmenuMyNewView() {
		getDefaultViewDropdownMenu().getMyNewView().click();
	}

	public void defaultdropdownmenuMyNewViewEdit() {
		getDefaultViewDropdownMenu().getMyNewViewEdit().click();
	}

	public void defaultdropdownmenuMyNewViewSaveViewAs() {
		getDefaultViewDropdownMenu().getSaveViewAs().click();
	}

	// click for ActionsDropDownMenu class

	public void actionsdropdownmenuDeleteClick() {
		getActionsDropDownMenu().getDelete().click();
	}

	public void actionsdropdownmenusubscribeClick() {
		getActionsDropDownMenu().getSubscribe().click();
	}

	public void actionsdropdownmenuUnSubscribeClick() {
		getActionsDropDownMenu().getUnSubscribe().click();
	}

	public void actionsdropdownmenuasSignCustomerGroupClick() {
		getActionsDropDownMenu().getAssignCustomerGroup().click();
	}

	public void actionsdropdownmenuEditClick() {
		getActionsDropDownMenu().getEdit().click();
	}

	// click for ColumnsMenuDropdown class
	public void columnsmenudropdownIdClick() {
		getColumnsMenuDropdown().getIdCheck().click();
	}

	public void columnsmenudropdownNameClick() {
		getColumnsMenuDropdown().getNameCheck().click();
	}

	public void columnsmenudropdownEmailClick() {
		getColumnsMenuDropdown().getEmailCheck().click();
	}

	public void columnsmenudropdownGoupClick() {
		getColumnsMenuDropdown().getGroupCheck().click();
	}

	public void columnsmenudropdownPhoneClick() {
		getColumnsMenuDropdown().getPhoneCheck().click();
	}

	public void columnsmenudropdownZipClick() {
		getColumnsMenuDropdown().getZipCheck().click();
	}

	public void columnsmenudropdownCountryClick() {
		getColumnsMenuDropdown().getCountryCheck().click();
	}

	public void columnsmenudropdownStateClick() {
		getColumnsMenuDropdown().getStateCheck().click();
	}

	public void columnsmenudropdownCustomerSinceClick() {
		getColumnsMenuDropdown().getCustomerSinceCheck().click();
	}

	public void columnsmenudropdownWebSiteClick() {
		getColumnsMenuDropdown().getWebsiteCheck().click();
	}

	public void columnsmenudropdownConfirmedEmailClick() {
		getColumnsMenuDropdown().getConfirmedEmailCheck().click();
	}

	public void columnsmenudropdownAccountCreatedClick() {
		getColumnsMenuDropdown().getAccauntCreatedInCheck().click();
	}

	public void columnsmenudropdownDateOfBirdthClick() {
		getColumnsMenuDropdown().getDateOfBirdthCheck().click();
	}

	public void columnsmenudropdownTaxVatClick() {
		getColumnsMenuDropdown().getTaxVatNumberCheck().click();
	}

	public void columnsmenudropdownGenderClick() {
		getColumnsMenuDropdown().getGenderCheck().click();
	}

	public void columnsmenudropdownCityClick() {
		getColumnsMenuDropdown().getCityCheck().click();
	}

	public void columnsmenudropdownResetButtonClick() {
		getColumnsMenuDropdown().getResetButton().click();
	}

	// click for main class

	public void clearAllButtonClick() {
		getClearAllButton().click();
	}

	public void allCustomersLabelClick() {
		getCustomersLabel().click();
	}

	public void searchFieldClear() {
		getSearchField().clear();
	}

	public void nameFieldInListClick() {
		//Actions actions = new Actions(driver);

	//	actions.moveToElement(nameFieldInList).click().perform();
		// getNameFieldInList().click();
	}

	// input data

	public void enterDataInSearchField(String text) {
		searchField.clear();
		searchField.sendKeys(text, Keys.ENTER);
		// refreshAllCustomersPage();
		// clearAllButtonClick();
	}

	// functional Business Logic

	public RegistrationNewCustomerPage goToRegistrationNewCustomerPage() {
		getAddNewCustomerButton().click();
		return new RegistrationNewCustomerPage();
	}

	public ColumnsMenuDropdown goToColumnsMenuDropdown() {
		getColumnsButton().click();
		return new ColumnsMenuDropdown();
	}

	public ActionsDropDownMenu goToActionsDropDownMenu() {
		getActionsButton().click();
		return new ActionsDropDownMenu();
	}

	public DefaultViewDropdownMenu goToDefaultViewDropdownMenu() {
		getDefaultViewButton().click();
		return new DefaultViewDropdownMenu();
	}

	// Business Logic
	public AllCustomersPage refreshAllCustomersPage() {
		AllCustomersPage page = new AllCustomersPage();
		page.clearAll = Search.xpath("//button[contains(text(), 'Clear all')]");
		return page;
	}

	// ------------------Mykhaylo Holovanov update--------------------------

	public boolean findCustomerInTheList(ICustomerUser customerUser) {
		String userName = customerUser.getPersonalInfo().getPrefix() + " "
				+ customerUser.getPersonalInfo().getFirstname() + " " + customerUser.getPersonalInfo().getMiddlename()
				+ " " + customerUser.getPersonalInfo().getLastname() + " " + customerUser.getPersonalInfo().getSuffix();
		List<WebElement> customers = null;
		WebElement customer = null;
		while (!isWebElementFound) {
			customers = Search.xpaths("//div[contains(text(),'" + userName + "')]");
			if (customers.size() > 0) {
				isWebElementFound = true;
				customer = customers.get(0);
				System.out.println("++++++++++  FOUNDED !!!!!!!!");
			} else {
				List<WebElement> next = Search.xpaths(".//*[@class='action-next'][1]");
				if (next.size() > 0) {
					next.get(0).click();
				} else {
					break;
				}
			}
		}
		return isWebElementFound;
	}

	public boolean findCustomerInTheListAfterSearch(ICustomerUser customerUser) {
		String userName = customerUser.getPersonalInfo().getPrefix() + " "
				+ customerUser.getPersonalInfo().getFirstname() + " " + customerUser.getPersonalInfo().getMiddlename()
				+ " " + customerUser.getPersonalInfo().getLastname() + " " + customerUser.getPersonalInfo().getSuffix();
		enterDataInSearchField(userName);
		List<WebElement> customers = null;
		WebElement customer = null;
		while (!isWebElementFound) {
			customers = Search.xpaths("//div[contains(text(),'" + userName + "')]");
			if (customers.size() > 0) {
				isWebElementFound = true;
				customer = customers.get(0);
				System.out.println("++++++++++  FOUNDED !!!!!!!!");
			} else {
				List<WebElement> next = Search.xpaths(".//*[@class='action-next'][1]");
				if (next.size() > 0) {
					next.get(0).click();
				} else {
					break;
				}
			}
		}
		return isWebElementFound;
	}

	public boolean findDeletedColumn() {

		List<WebElement> customers = null;
		WebElement customer = null;
		while (!isWebElementFound) {
			customers = Search.xpaths("(//span[contains(text(),'Name')])[3]");
			if (customers.size() > 0) {
				isWebElementFound = true;
				customer = customers.get(0);
				System.out.println("++++++++++  FOUNDED !!!!!!!!");
			} else {
				List<WebElement> next = Search.xpaths(".//*[@class='action-next'][1]");
				if (next.size() > 0) {
					next.get(0).click();
				} else {
					break;
				}
			}
		}
		return isWebElementFound;
	}

	public List<String> getColumnsNameFromTable() {
		List<RowCustomerUser> rowsCustomerUserTable = getTableCustomerUser();
		List<String> usernames = new ArrayList<String>();
		for (int i = 0; i < rowsCustomerUserTable.size(); i++) {
			usernames.add(rowsCustomerUserTable.get(i).getNameText());
			System.out.println(rowsCustomerUserTable.get(i).getNameText());
		}
		return usernames;
	}

	public Boolean sortedNameField() {
		boolean isNameFieldSorted = true;
		List<RowCustomerUser> rowsCustomerUserTable = getTableCustomerUser();
		List<String> usernames = new ArrayList<String>();
		for (int i = 0; i < rowsCustomerUserTable.size(); i++) {
			usernames.add(rowsCustomerUserTable.get(i).getNameText());
		}

		List<String> sortedNames = new ArrayList<>(usernames);
		Collections.sort(sortedNames);

		for (int i = 0; i < usernames.size(); i++) {
			if (!usernames.get(i).equals(sortedNames.get(i))) {
				isNameFieldSorted = false;
				break;
			}

		}
		if (isNameFieldSorted == false) {
			nameFieldInListClick();
			isNameFieldSorted = true;
		}
		return isNameFieldSorted;
	}

	// ------------------Yaryna Kharko update
	// 23.07.2016--------------------------
	public List<RowCustomerUser> getTableCustomerUser() {
		// TODO when there are more that 1 pagetable
		List<WebElement> rows = Search.classNames("data-row");
		List<RowCustomerUser> rowsCustomerUserTable = new ArrayList<RowCustomerUser>();
		for (int i = 0; i < rows.size(); i++) {
			rowsCustomerUserTable.add(new RowCustomerUser(rows.get(i)));
		}
		return rowsCustomerUserTable;
	}

	public List<String> getNameColumn() {
		List<RowCustomerUser> rowsCustomerUserTable = getTableCustomerUser();
		List<String> usernames = new ArrayList<String>();
		for (int i = 0; i < rowsCustomerUserTable.size(); i++) {
			usernames.add(rowsCustomerUserTable.get(i).getNameText());
			System.out.println(rowsCustomerUserTable.get(i).getNameText());
		}
		return usernames;
	}

	public void checkCustomerUser(RowCustomerUser rowCustomerUser) {
		rowCustomerUser.getName().click();
	}

	public void checkCustomerUser(List<RowCustomerUser> rowsCustomerUser) {
		for (int i = 0; i < rowsCustomerUser.size(); i++) {
			checkCustomerUser(rowsCustomerUser.get(i));
		}
	}

	public List<RowCustomerUser> findCustomerUsersByName(List<RowCustomerUser> rowsCustomerUser,
			ICustomerUser customerUser) {
		List<RowCustomerUser> foundRowCustomerUser = new ArrayList<RowCustomerUser>();
		String username = customerUser.getPersonalInfo().getFullName();
		String email = customerUser.getSigninInfo().getEmail();
		for (int i = 0; i < rowsCustomerUser.size(); i++) {
			if (rowsCustomerUser.get(i).getNameText().equals(username)
					&& rowsCustomerUser.get(i).getEmailText().equals(email)) {
				foundRowCustomerUser.add(rowsCustomerUser.get(i));
			}
		}
		return foundRowCustomerUser;

	}

	public void sendKeysSearchCustomerField(String search) {
		this.getSearchField().sendKeys(search);
	}

	public void clearSendKeysSearchCustomerField(String search) {
		this.getSearchField().clear();
		this.sendKeysSearchCustomerField(search);
	}

	public AllCustomersPage doCustomerSearch(String search) {
		this.clearSendKeysSearchCustomerField(search);
		this.getSearchField().sendKeys(Keys.ENTER);
		return new AllCustomersPage();
	}

	public void clickDeleteActions() {
		goToActionsDropDownMenu().delete.click();
	}

	public AllCustomersPage deleteCustomerUser(ICustomerUser customerUser) {
		AllCustomersPage CustomersPage = doCustomerSearch(customerUser.getPersonalInfo().getFullName());

		List<RowCustomerUser> foundCustomerUsersByName = findCustomerUsersByName(CustomersPage.getTableCustomerUser(),
				customerUser);
		if (foundCustomerUsersByName.size() > 0) {
			checkCustomerUser(foundCustomerUsersByName);
			CustomersPage.clickDeleteActions();

			this.getConfirmDeleteWindow().clickButtonOk();

		}
		return new AllCustomersPage();
	}

	public List<RowCustomerUser> findCustomersUser(ICustomerUser customerUser) {
		AllCustomersPage CustomersPage = doCustomerSearch(customerUser.getPersonalInfo().getFullName());
		List<RowCustomerUser> foundCustomerUsersByName = findCustomerUsersByName(CustomersPage.getTableCustomerUser(),
				customerUser);
		return foundCustomerUsersByName;
	}

	public Boolean confirmCustomerUserIsCreated(ICustomerUser customerUser) {
		if (this.findCustomersUser(customerUser).size() > 0) {
			return true;
		} else
			return false;
	}

	public Boolean confirmAlreadyExistCustomerUserIsCreated(ICustomerUser customerUser) {
		if (this.findCustomersUser(customerUser).size() >= 2) {
			return true;
		} else
			return false;
	}

	public ConfirmDeleteWindow getConfirmDeleteWindow() {
		return new ConfirmDeleteWindow();
	}

	// --------------------ConfirmDeleteWindow----------------------------
	private class ConfirmDeleteWindow {
		private WebElement window;
		private WebElement buttonCancel;
		private WebElement buttonOk;
		private WebElement exit;

		public ConfirmDeleteWindow() {
			Search.setStrategy(Search.SearchStrategyList.EXPLICIT_STRATEGY_PRESENT.getSearchStrategy());
			this.window = Search.className("modal-inner-wrap");
			Search.setStrategy(Search.SearchStrategyList.IMPLICIT_STRATEGY.getSearchStrategy());
			this.buttonOk = Search.cssSelector("footer.modal-footer button.action-primary.action-accept");
			this.buttonCancel = Search.cssSelector("button.action-secondary.action-dismiss");
			this.exit = Search.cssSelector("header.modal-header button.action-close");

		}

		public WebElement getWindow() {
			return window;
		}

		public WebElement getButtonCancel() {
			return buttonCancel;
		}

		public WebElement getButtonOk() {
			return buttonOk;
		}

		public WebElement getExit() {
			return exit;
		}

		// click
		public void clickButtonCancel() {
			this.getButtonCancel().click();
		}

		public AllCustomersPage clickButtonOk() {
			this.getButtonOk().click();
			return new AllCustomersPage();
		}

		public void clickExit() {
			this.getExit().click();
		}

	}

	// --------------------RowCustomerUser----------------------------
	private class RowCustomerUser {
		WebElement check;
		WebElement name;
		WebElement email;

		RowCustomerUser(WebElement row) {
			this.check = Search.className("data-grid-checkbox-cell",row);
			this.name = Search.cssSelector("td:nth-child(3)",row);
			this.email = Search.cssSelector("td:nth-child(4)",row);
		}

		public WebElement getCheck() {
			return check;
		}

		public WebElement getName() {
			return name;
		}

		public WebElement getEmail() {
			return email;
		}

		public String getNameText() {
			String nameText = Search.className("data-grid-cell-content",getName()).getText();
			return nameText;
		}

		public String getEmailText() {
			String emailText = Search.className("data-grid-cell-content",getEmail()).getText();
			return emailText;
		}
	}

}

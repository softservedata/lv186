package com.softserve.edu.magento.pages.menu.customers;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.magento.data.customer.user.ICustomerUser;
import com.softserve.edu.magento.pages.VerticalMenu;

public class AllCustomersPage extends VerticalMenu {
	public final static String PAGE_TITLE = "Customers";
	// protected WebDriver driver;

	private ColumnsMenuDropdown columnsmenudropdown;
	private ActionsDropDownMenu actionsdropdownmenu;
	private DefaultViewDropdownMenu defaultdropdownmenu;
	private FiltersDropDownMenu filtersdropdownmenu;
	private GroupsButton groupsButton;
//	private CountryButton countryButton;
//	private WebsiteButton webSiteButton;
//	private GenderButton genderButton;
	
	
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

		public ColumnsMenuDropdown(WebDriver driver) {
			super();
			this.idCheck = driver.findElement(By.id("1"));
			this.nameCheck = driver.findElement(By.id("2"));
			this.emailCheck = driver.findElement(By.id("3"));
			this.groupCheck = driver.findElement(By.id("4"));
			this.phoneCheck = driver.findElement(By.id("5"));
			this.zipCheck = driver.findElement(By.id("6"));
			this.countryCheck = driver.findElement(By.id("7"));
			this.stateCheck = driver.findElement(By.id("8"));
			this.customerSinceCheck = driver.findElement(By.id("9"));
			this.websiteCheck = driver.findElement(By.id("10"));
			this.confirmedEmailCheck = driver.findElement(By.id("11"));
			this.accauntCreatedInCheck = driver.findElement(By.id("12"));
			this.dateOfBirdthCheck = driver.findElement(By.id("15"));
			this.taxVatNumberCheck = driver.findElement(By.id("16"));
			this.genderCheck = driver.findElement(By.id("17"));
			this.cityCheck = driver.findElement(By.id("19"));
			this.resetButton = driver.findElement(By.id("(.//*[@class='action-tertiary'])[1]"));
		}
	}

	// -----------------ActionsDropDownMenu-------------------

	private class ActionsDropDownMenu {
		private WebElement delete;
		private WebElement subscribe;
		private WebElement unSubscribe;
		private WebElement assignCustomerGroup;
		private WebElement edit;

		public ActionsDropDownMenu(WebDriver driver) {
			this.delete = driver.findElement(By.xpath("(//span[text()='Delete'])[3]"));
			this.subscribe = driver.findElement(By.xpath("(//span[text()='Subscribe to Newsletter'])[2]"));
			this.unSubscribe = driver.findElement(By.xpath("(//span[text()='Unsubscribe from Newsletter'])[2]"));
			this.assignCustomerGroup = driver.findElement(By.xpath("(//span[text()='Assign a Customer Group'])[2]"));
			this.edit = driver.findElement(By.xpath("(//span[text()='Edit'])[2]"));
		}
	}

	// -----------------DefaultViewDropdownMenu-------------------
	private class DefaultViewDropdownMenu {
		private WebElement defaultView;
		private WebElement myNewView;
		private WebElement myNewViewEdit;
		private WebElement saveViewAs;

		public DefaultViewDropdownMenu(WebDriver driver) {
			super();
			this.defaultView = driver.findElement(By.xpath("(.//*[@class='action-dropdown-menu-link'])[1]"));
			this.myNewView = driver.findElement(By.xpath("(.//*[@class='action-dropdown-menu-link'])[2]"));
			this.myNewViewEdit = driver.findElement(By.xpath("(.//*[@class='action-edit'])[1]"));
			this.saveViewAs = driver.findElement(By.xpath(".//*[@id='container']//div[1]/div[1]/ul/li[3]/a"));
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

		public FiltersDropDownMenu(WebDriver driver) {
			this.filtersIdFrom = driver.findElement(By.id("LFLEVPX"));
			this.filtersIdTo = driver.findElement(By.id("PMYVOQ9"));
			this.filtersCustomerSinceFrom = driver.findElement(By.id("dp1469101028421"));
			this.filtersCustomerSinceTo = driver.findElement(By.id("dp1469101028422"));
			this.filtersDateOfBirthFrom = driver.findElement(By.id("dp1469101028423"));
			this.filtersDateOfBirthTo = driver.findElement(By.id("dp1469101028424"));
			this.filtersName = driver.findElement(By.id("WTB30AT"));
			this.filtersEmail = driver.findElement(By.id("XQQRSNG"));
			this.filtersGroup = driver.findElement(By.id("USWLJ0M"));
			this.filtersPhone = driver.findElement(By.id("PP9FDT4"));
			this.filtersZip = driver.findElement(By.id("PC3ANRA"));
			this.filtersCountry = driver.findElement(By.id("R3WE272"));
			this.filtersProvince = driver.findElement(By.id("PBLR8MK"));
			this.filtersWebSite = driver.findElement(By.id("LSX9L81"));
			this.filtersTaxVat = driver.findElement(By.id("NENVWND"));
			this.filtersGender = driver.findElement(By.id("BK2MJ87"));

		}
		
	}
	// -----------------Groups class-----------------------
	private class GroupsButton{
		private WebElement general;
		private WebElement wholesale;
		private WebElement retailer;
		public GroupsButton(WebElement general, WebElement wholesale) {
			super();
			this.general = driver.findElement(By.xpath(".//*[@id='A1HMI49']/option[2]"));
			this.wholesale = driver.findElement(By.xpath(".//*[@id='A1HMI49']/option[3]"));
			this.retailer = driver.findElement(By.xpath(".//*[@id='A1HMI49']/option[4]"));
		}
	}
	
	// -----------------Country class-----------------------
	
	// -----------------Website class-----------------------
	
	// -----------------Gender class-----------------------

	// main page constructor
	public AllCustomersPage(WebDriver driver) {
		super(driver);
		this.customersLabel = driver.findElement(By.xpath(".//*[@class='page-title-wrapper']"));
		this.addNewCustomerButton = driver.findElement(By.id("add"));
		this.searchField = driver.findElement(By.xpath("(.//*[@id='fulltext'])[1]"));
	//	this.filtersButton = driver.findElement(By.xpath(""));
		this.defaultViewButton = driver.findElement(By.xpath("(//span[text()='Default View'])[1]"));
		this.columnsButton = driver.findElement(By.xpath("(//span[text()='Columns'])[1]"));
		this.exportButton = driver.findElement(By.xpath("(//span[text()='Export'])[2]"));
		this.actionsButton = driver.findElement(By.xpath("(//span[text()='Actions'])[1]"));
		this.perPageButton = driver.findElement(By.xpath("(.//*[@id='customer_listing.customer_listing.listing_top.listing_paging_sizes'])[1]"));
		this.goToPageLeftButton = driver.findElement(By.xpath("(.//*[@class='action-previous'])[1]"));
		this.goToPageRightButton = driver.findElement(By.xpath(".//*[@class='action-next'][1]"));
		this.howManyCustomersInListArePresentedField = driver.findElement(By.xpath("(//span[text()='records found'])[1]"));
		this.selectAllButton = driver.findElement(By.xpath("//*[@for='60']"));
		this.selectAllCustomersInListButton = driver.findElement(By.xpath("//*[@for='60']"));
	//	this.selectFirstCustomer = driver.findElement(By.xpath(".//*[@id='idscheck20']")); //////////////////////////////////////////////////////////////////// CHANGE!!!!!!!!
		this.howManyPagesAreInList = driver.findElement(By.id("29"));
		this.idFielsInList = driver.findElement(By.xpath("(//span[text()='ID'])[2]"));
		this.nameFieldInList = driver.findElement(By.xpath("(//span[text()='Name'])[2]"));
		this.emailFieldInList = driver.findElement(By.xpath("(//span[text()='Email'])[2]"));
		this.groupFieldInList = driver.findElement(By.xpath("(//span[text()='Group'])[2]"));
		this.phoneFieldInList = driver.findElement(By.xpath("(//span[text()='Phone'])[2]"));
		this.zipFieldInList = driver.findElement(By.xpath("(//span[text()='ZIP'])[2]"));
		this.countryFieldInList = driver.findElement(By.xpath("(//span[text()='Country'])[2]"));
		this.stateFieldInList = driver.findElement(By.xpath("(//span[text()='State/Province'])[2]"));
		this.customerSinceFieldInList = driver.findElement(By.xpath("(//span[text()='Customer Since'])[2]"));
		this.webSiteFieldInList = driver.findElement(By.xpath("(//span[text()='Web Site'])[2]"));
		this.confirmedEmailFieldInList = driver.findElement(By.xpath("(//span[text()='Confirmed email'])[1]"));
		this.accountCreatedInFieldInList = driver.findElement(By.xpath("(//span[text()='Account Created in'])[1]"));
		this.dateOfBirdthFieldInList = driver.findElement(By.xpath("(//span[text()='Date of Birth'])[2]"));
		this.taxVatNumberFieldInList = driver.findElement(By.xpath("(//span[text()='Tax VAT Number'])[2]"));
		this.genderFieldInList = driver.findElement(By.xpath("(//span[text()='Gender'])[2]"));
	}

	//// getters to DefaultViewDropdownMenu
	public WebElement getDefaultView() {
		return defaultdropdownmenu.defaultView;
	}

	public WebElement getMyNewView() {
		return defaultdropdownmenu.myNewView;
	}

	public WebElement getMyNewViewEdit() {
		return defaultdropdownmenu.myNewViewEdit;
	}

	public WebElement getSaveViewAs() {
		return defaultdropdownmenu.saveViewAs;
	}

	// getters to ActionsDropDownMenu
	public WebElement getDelete() {
		return actionsdropdownmenu.delete;
	}

	public WebElement getSubscribe() {
		return actionsdropdownmenu.subscribe;
	}

	public WebElement getUnSubscribe() {
		return actionsdropdownmenu.unSubscribe;
	}

	public WebElement getAssignCustomerGroup() {
		return actionsdropdownmenu.assignCustomerGroup;
	}

	public WebElement getEdit() {
		return actionsdropdownmenu.edit;
	}

	// getters to CustomersMenuPage
	public WebElement getIdCheck() {
		return columnsmenudropdown.idCheck;
	}

	public WebElement getNameCheck() {
		return columnsmenudropdown.nameCheck;
	}

	public WebElement getEmailCheck() {
		return columnsmenudropdown.emailCheck;
	}

	public WebElement getGroupCheck() {
		return columnsmenudropdown.groupCheck;
	}

	public WebElement getPhoneCheck() {
		return columnsmenudropdown.phoneCheck;
	}

	public WebElement getZipCheck() {
		return columnsmenudropdown.zipCheck;
	}

	public WebElement getCountryCheck() {
		return columnsmenudropdown.countryCheck;
	}

	public WebElement getStateCheck() {
		return columnsmenudropdown.stateCheck;
	}

	public WebElement getCustomerSinceCheck() {
		return columnsmenudropdown.customerSinceCheck;
	}

	public WebElement getWebsiteCheck() {
		return columnsmenudropdown.websiteCheck;
	}

	public WebElement getConfirmedEmailCheck() {
		return columnsmenudropdown.confirmedEmailCheck;
	}

	public WebElement getAccauntCreatedInCheck() {
		return columnsmenudropdown.accauntCreatedInCheck;
	}

	public WebElement getDateOfBirdthCheck() {
		return columnsmenudropdown.dateOfBirdthCheck;
	}

	public WebElement getTaxVatNumberCheck() {
		return columnsmenudropdown.taxVatNumberCheck;
	}

	public WebElement getGenderCheck() {
		return columnsmenudropdown.genderCheck;
	}

	public WebElement getCityCheck() {
		return columnsmenudropdown.cityCheck;
	}

	public WebElement getResetButton() {
		return columnsmenudropdown.resetButton;
	}

	// getters to FiltersDropDownMenu
	
	public WebElement getFiltersIdFrom() {
		return filtersdropdownmenu.filtersIdFrom;
	}

	public WebElement getFiltersIdTo() {
		return filtersdropdownmenu.filtersIdTo;
	}

	public WebElement getFiltersCustomerSinceFrom() {
		return filtersdropdownmenu.filtersCustomerSinceFrom;
	}

	public WebElement getFiltersCustomerSinceTo() {
		return filtersdropdownmenu.filtersCustomerSinceTo;
	}

	public WebElement getFiltersDateOfBirthFrom() {
		return filtersdropdownmenu.filtersDateOfBirthFrom;
	}

	public WebElement getFiltersDateOfBirthTo() {
		return filtersdropdownmenu.filtersDateOfBirthTo;
	}

	public WebElement getFiltersName() {
		return filtersdropdownmenu.filtersName;
	}

	public WebElement getFiltersEmail() {
		return filtersdropdownmenu.filtersEmail;
	}

	public WebElement getFiltersGroup() {
		return filtersdropdownmenu.filtersGroup;
	}

	public WebElement getFiltersPhone() {
		return filtersdropdownmenu.filtersPhone;
	}

	public WebElement getFiltersZip() {
		return filtersdropdownmenu.filtersZip;
	}

	public WebElement getFiltersCountry() {
		return filtersdropdownmenu.filtersCountry;
	}

	public WebElement getFiltersProvince() {
		return filtersdropdownmenu.filtersProvince;
	}

	public WebElement getFiltersWebSite() {
		return filtersdropdownmenu.filtersWebSite;
	}

	public WebElement getFiltersTaxVat() {
		return filtersdropdownmenu.filtersTaxVat;
	}

	public WebElement getFiltersGender() {
		return filtersdropdownmenu.filtersGender;
	}

	// getters to main class
	// Data PageObject

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
	
	public void filtersdropdownmenuIdGroupClick(){
		filtersdropdownmenu.filtersGroup.click();
	}
	
	
	
	// click for DefaultViewDropdownMenu 
	

	public void defaultdropdownmenuDefaultViewClick() {
		defaultdropdownmenu.defaultView.click();
	}

	public void defaultdropdownmenuMyNewView() {
		defaultdropdownmenu.myNewView.click();
	}

	public void defaultdropdownmenuMyNewViewEdit() {
		defaultdropdownmenu.myNewViewEdit.click();
	}

	public void defaultdropdownmenuMyNewViewSaveViewAs() {
		defaultdropdownmenu.saveViewAs.click();
	}

	// click for ActionsDropDownMenu class

	public void actionsdropdownmenuDeleteClick() {
		actionsdropdownmenu.delete.click();
	}

	public void actionsdropdownmenusubscribeClick() {
		actionsdropdownmenu.subscribe.click();
	}

	public void actionsdropdownmenuUnSubscribeClick() {
		actionsdropdownmenu.unSubscribe.click();
	}

	public void actionsdropdownmenuasSignCustomerGroupClick() {
		actionsdropdownmenu.assignCustomerGroup.click();
	}

	public void actionsdropdownmenuEditClick() {
		actionsdropdownmenu.edit.click();
	}

	// click for ColumnsMenuDropdown class
	public void columnsmenudropdownIdClick() {
		columnsmenudropdown.idCheck.click();
	}

	public void columnsmenudropdownNameClick() {
		columnsmenudropdown.nameCheck.click();
	}

	public void columnsmenudropdownEmailClick() {
		columnsmenudropdown.emailCheck.click();
	}

	public void columnsmenudropdownGoupClick() {
		columnsmenudropdown.groupCheck.click();
	}

	public void columnsmenudropdownPhoneClick() {
		columnsmenudropdown.phoneCheck.click();
	}

	public void columnsmenudropdownZipClick() {
		columnsmenudropdown.zipCheck.click();
	}

	public void columnsmenudropdownCountryClick() {
		columnsmenudropdown.countryCheck.click();
	}

	public void columnsmenudropdownStateClick() {
		columnsmenudropdown.stateCheck.click();
	}

	public void columnsmenudropdownCustomerSinceClick() {
		columnsmenudropdown.customerSinceCheck.click();
	}

	public void columnsmenudropdownWebSiteClick() {
		columnsmenudropdown.websiteCheck.click();
	}

	public void columnsmenudropdownConfirmedEmailClick() {
		columnsmenudropdown.confirmedEmailCheck.click();
	}

	public void columnsmenudropdownAccountCreatedClick() {
		columnsmenudropdown.accauntCreatedInCheck.click();
	}

	public void columnsmenudropdownDateOfBirdthClick() {
		columnsmenudropdown.dateOfBirdthCheck.click();
	}

	public void columnsmenudropdownTaxVatClick() {
		columnsmenudropdown.taxVatNumberCheck.click();
	}

	public void columnsmenudropdownGenderClick() {
		columnsmenudropdown.genderCheck.click();
	}

	public void columnsmenudropdownCityClick() {
		columnsmenudropdown.cityCheck.click();
	}

	public void columnsmenudropdownResetButtonClick() {
		columnsmenudropdown.resetButton.click();
	}

	// click for main class

	// input data

	public void enterDataInSearchField(String text) {
		searchField.clear();
		searchField.sendKeys(text);
	}

	// functional

	public RegistrationNewCustomerPage goToRegistrationNewCustomerPage(){
		getAddNewCustomerButton().click();
		return new RegistrationNewCustomerPage(driver);
	}
	public ColumnsMenuDropdown goToColumnsMenuDropdown() {
		getColumnsButton().click();
		return new ColumnsMenuDropdown(driver);
	}

	public ActionsDropDownMenu goToActionsDropDownMenu() {
		getActionsButton().click();
		return new ActionsDropDownMenu(driver);
	}

	public DefaultViewDropdownMenu goToDefaultViewDropdownMenu() {
		getDefaultViewButton().click();
		return new DefaultViewDropdownMenu(driver);
	}
	//--------------------------------------------
	public List<RowCustomerUser> getTableCustomerUser() {
		List<WebElement> rows = driver.findElements(By.className("data-row"));
		List<RowCustomerUser> rowsCustomerUserTable = new ArrayList<RowCustomerUser>();
		for(int i=0;i<rows.size();i++) {
		rowsCustomerUserTable.add(new RowCustomerUser(rows.get(i)));
		}
		return rowsCustomerUserTable;
	}
	public void checkCustomerUser (RowCustomerUser rowCustomerUser) {
		rowCustomerUser.getName().click();
		System.out.println("checked USER"+ rowCustomerUser.getNameText());
	}
	public void checkCustomerUser (List<RowCustomerUser> rowsCustomerUser) {
		for(int i=0;i<rowsCustomerUser.size();i++) {
			checkCustomerUser(rowsCustomerUser.get(i));			
		}
	}
	public List<RowCustomerUser> findCustomerUsersByName(List<RowCustomerUser> rowsCustomerUser,ICustomerUser customerUser) {
		List<RowCustomerUser> foundRowCustomerUser = new ArrayList<RowCustomerUser>();
		String username = customerUser.getPersonalInfo().getFullName();
		for(int i=0;i<rowsCustomerUser.size();i++) {
			if(rowsCustomerUser.get(i).getNameText().equals(username)) {
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
		return new  AllCustomersPage(driver);
	}
	public void deleteCustomerUser (ICustomerUser customerUser) throws InterruptedException {	
		AllCustomersPage CustomersPage = doCustomerSearch(customerUser.getPersonalInfo().getFullName());
		
		List<RowCustomerUser> foundCustomerUsersByName = 
				findCustomerUsersByName(CustomersPage.getTableCustomerUser(),customerUser);
		checkCustomerUser(foundCustomerUsersByName);
			Thread.sleep(3000);
		CustomersPage.getActionsButton().click();
		CustomersPage.getDelete().click();
		System.out.println("DELETE USER");
	}
	private class RowCustomerUser{
		//private static final String data_grid_cell_content = "By.className('data-grid-cell-content')";
		WebElement check;
		WebElement name;
		WebElement email;
		RowCustomerUser(WebElement row) {
			this.check = row.findElement(By.className("data-grid-checkbox-cell"));
			this.name = row.findElement(By.cssSelector("td:nth-child(3)"));
			this.email = row.findElement(By.cssSelector("td:nth-child(4)"));
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
			String nameText = getName().findElement(By.className("data-grid-cell-content")).getText();
			return nameText;
		}
		public String getEmailText() {
			String emailText = getName().findElement(By.className("data-grid-cell-content")).getText();
			return emailText;
		}
	}

}

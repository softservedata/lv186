package com.softserve.edu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class ATopPage {

	// Fields

	protected WebDriver driver;

	private WebElement search;
	private WebElement notifications;
	private WebElement menuAccount;

	//------------------------------------
	private class MenuControlsComponent {
		public final WebElement accountSetting;
		public final WebElement customerView;
		public final WebElement signOut;

		public MenuControlsComponent() {
			this.accountSetting = driver.findElement(By
					.xpath("//*[@data-ui-id='user-user-account-settings']"));
			this.customerView = driver.findElement(By
					.className("store-front"));
			this.signOut = driver.findElement(By
					.className("account-signout"));
		}
	}
	//------------------------------------
	
	// Element
	private MenuControlsComponent menuControls;

	protected ATopPage(WebDriver driver) {
		this.driver = driver;
		this.search = driver.findElement(By
				.className("seatch-global-label"));
		this.notifications = driver.findElement(By
				.className("notifications-action admin__action-dropdown"));
		this.menuAccount = driver.findElement(By
				.xpath("//*[@class='admin-user admin__action-dropdown-wrap']/a"));

	}

	// PageObject

	// get Data PageObject
	public WebElement getSearch() {
		return this.search;
	}

	public WebElement getNotifications() {
		return this.notifications;
	}

	public WebElement getMenuAccount() {
		return this.menuAccount;
	}

	public WebElement getAccountSetting() {
		return this.menuControls.accountSetting;
	}

	public WebElement getCustomerView() {
		return this.menuControls.customerView;
	}

	public WebElement getSignOut() {
		return this.menuControls.signOut;
	}

	// get Data Business Logic
	public String getMenuAccountText() {
		return getMenuAccount().getText();
	}

	public String getAccountSettingText() {
		return getAccountSetting().getText();
	}

	public String getCustomerViewText() {
		return getCustomerView().getText();
	}

	public String getSignOutText() {
		return getSignOut().getText();
	}
	
	// set Data PageObject

	public void clickSearch() {
		getSearch().click();
	}

	public void clickNotifications() {
		getNotifications().click();
	}

	public void clickMenuAccount() {
		getMenuAccount().click();
		this.menuControls = new MenuControlsComponent();
	}

	public void clickAccountSetting() {
		getAccountSetting().click();
	}

	public void clickCustomerView() {
		getCustomerView().click();
	}

	public void clickSignOut() {
		getSignOut().click();
	}

	public void setSearch(String text) {
		clickSearch();
		getSearch().sendKeys(text);
	}

	public void clearSearch() {
		getSearch().clear();
	}
}
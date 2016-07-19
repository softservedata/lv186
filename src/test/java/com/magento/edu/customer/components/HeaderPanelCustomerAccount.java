package com.magento.edu.customer.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.magento.edu.customer.pages.AccountDashboardPage;
import com.magento.edu.customer.pages.HomePage;

public abstract class HeaderPanelCustomerAccount extends Header{
	
	private WebElement customer_welcome;
	private WebElement dropdown_account_menu_button;
	private AccountMenuDropDown accountMenuDropDown;
	private RightAccountMenu rightAccountMenu;
	//-----------------AccountMenuDropDown-------------------
	private class AccountMenuDropDown {
		private WebElement myAccountButton;
		private WebElement myWishListButton;
		private WebElement signOutButton;
		
		public AccountMenuDropDown(WebDriver driver) {
			this.myAccountButton = driver.findElement(By.linkText("My Account"));
			this.myWishListButton = driver.findElement(By.cssSelector("li.link.wishlist")).
					findElement(By.partialLinkText("My Wish List"));
			this.signOutButton = driver.findElement(By.partialLinkText("Sign Out"));
		}
		public WebElement getMyAccountButton() {
			return myAccountButton;
		}
		public WebElement getMyWishListButton() {
			return myWishListButton;
		}
		public WebElement getSignOutButton() {
			return signOutButton;
		}
		/*public AccountDashboardPage clickMyAccountButton() {
			this.getMyAccountButton().click();
			return new AccountDashboardPage(driver);
		}
		public void clickMyWishListButton() {
			this.getMyWishListButton().click();
		}
		public HomePage clickSignOutButton() {
			this.getSignOutButton().click();
			return new HomePage(driver);
			
		}*/
	}
	//--------------------------------
	protected HeaderPanelCustomerAccount(WebDriver driver) {
		super(driver);
		this.customer_welcome = driver.findElement(By.className("customer-welcome")); 
		this.dropdown_account_menu_button = driver.findElement(By.cssSelector("button.action.switch"));
		
		this.rightAccountMenu = new RightAccountMenu(driver);
	}
	//getters
	public WebElement getCustomer_welcome() {
		return customer_welcome;
	}
	public WebElement getDropdown_account_menu_button() {
		return dropdown_account_menu_button;
	}
	
	public RightAccountMenu getRightAccountMenu() {
		return rightAccountMenu;
	}
	//business logic
	public String getCustomer_welcomeText() {
		return this.getCustomer_welcome().getText();
	}
	public void clickCustomer_welcome() {
		this.getCustomer_welcome().click();
	}
	public void clickDropdown_account_menu_button() {
		this.getDropdown_account_menu_button().click();
		this.accountMenuDropDown = new AccountMenuDropDown(driver);
	}
	public AccountMenuDropDown getAccountMenuDropDown() {
		clickDropdown_account_menu_button();
		return this.accountMenuDropDown;
	}
	//drop down menu click
	public WebElement getMyAccountButton() {
		return this.getAccountMenuDropDown().getMyAccountButton();
	}
	public WebElement getMyWishListButton() {
		return this.getAccountMenuDropDown().getMyWishListButton();
	}
	public WebElement getSignOutButton() {
		return this.getAccountMenuDropDown().getSignOutButton();
	}
	public AccountDashboardPage clickMyAccountButton() {
		this.getMyAccountButton().click();
		return new AccountDashboardPage(driver);
	}
	public void clickMyWishListButton() {
		this.getMyWishListButton().click();
	}
	public HomePage clickSignOutButton() {
		this.getSignOutButton().click();
		return new HomePage(driver);
		
	}
	
	
	
}

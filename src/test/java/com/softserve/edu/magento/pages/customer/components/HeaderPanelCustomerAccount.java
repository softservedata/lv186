package com.softserve.edu.magento.pages.customer.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.magento.pages.customer.AccountDashboardPage;
import com.softserve.edu.magento.pages.customer.HomePageCustomer;
import com.softserve.edu.magento.pages.customer.HomePageLogout;
import com.softserve.edu.magento.tools.Search;


public abstract class HeaderPanelCustomerAccount extends Header{
	
	private WebElement customer_welcome;
	private WebElement dropdown_account_menu_button;
	private AccountMenuDropDown accountMenuDropDown;
	private VerticalAccountMenu verticalAccountMenu;
	//-----------------AccountMenuDropDown-------------------
	private class AccountMenuDropDown {
		private WebElement myAccountButton;
		private WebElement myWishListButton;
		private WebElement signOutButton;
		
		public AccountMenuDropDown() {
			this.myAccountButton = Search.linkText("My Account");
			this.myWishListButton = Search.cssSelector("li.link.wishlist").
					findElement(By.partialLinkText("My Wish List"));
			this.signOutButton = Search.partialLinkText("Sign Out");
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
	}
	//--------------VerticalAccountMenu------------------
	private class VerticalAccountMenu {

		public WebElement accountDashboardLink;
		public WebElement accountInformationLink;
		public WebElement adressBookLink;
		public WebElement myDownloadableProductsLink;
		public WebElement myOrderLink;
		public WebElement newsletterSubscriptionsLink;
		public WebElement myCreditCardsLink;
		public WebElement myProductReviewsLink;
		public WebElement billingAgreementsLink;
		public WebElement myWishListLink;
		
		public VerticalAccountMenu() {
			WebElement verticalBlock = Search.id("block-collapsible-nav");
			//this.accountDashboardLink = driver.findElement(By.linkText("Account Dashboard"));
			
			this.accountDashboardLink = verticalBlock.findElement(By.xpath("//*[contains(text(),'Account Dashboard')]"));
			this.accountInformationLink = verticalBlock.findElement(By.xpath("//*[contains(text(),'Account Information')]"));
			this.adressBookLink = verticalBlock.findElement(By.xpath("//*[contains(text(),'Address Book')]"));
			this.myDownloadableProductsLink = verticalBlock.findElement(By.xpath("//*[contains(text(),'My Downloadable Products')]"));
			this.myOrderLink = verticalBlock.findElement(By.xpath("//*[contains(text(),'My Orders')]"));
			this.newsletterSubscriptionsLink = verticalBlock.findElement(By.xpath("//*[contains(text(),'Newsletter Subscriptions')]"));
			this.myCreditCardsLink = verticalBlock.findElement(By.xpath("//*[contains(text(),'My Credit Cards')]"));
			this.myProductReviewsLink = verticalBlock.findElement(By.xpath("//*[contains(text(),'My Product Reviews')]"));
			this.billingAgreementsLink = verticalBlock.findElement(By.xpath("//*[contains(text(),'Billing Agreements')]"));
			this.myWishListLink = verticalBlock.findElement(By.xpath("//*[contains(text(),'My Wish List')]"));
					
		}

		public WebElement getAccountDashboardLink() {
			return accountDashboardLink;
		}

		public WebElement getAccountInformationLink() {
			return accountInformationLink;
		}

		public WebElement getAdressBookLink() {
			return adressBookLink;
		}

		public WebElement getMyDownloadableProductsLink() {
			return myDownloadableProductsLink;
		}

		public WebElement getMyOrderLink() {
			return myOrderLink;
		}

		public WebElement getNewsletterSubscriptionsLink() {
			return newsletterSubscriptionsLink;
		}

		public WebElement getMyCreditCardsLink() {
			return myCreditCardsLink;
		}

		public WebElement getMyProductReviewsLink() {
			return myProductReviewsLink;
		}

		public WebElement getBillingAgreementsLink() {
			return billingAgreementsLink;
		}

		public WebElement getMyWishListLink() {
			return myWishListLink;
		}

		
	}

	//---------------------------------
	protected HeaderPanelCustomerAccount() {
		//super(driver);
		this.customer_welcome = Search.className("customer-welcome"); 
		this.dropdown_account_menu_button = Search.cssSelector("button.action.switch");
		this.verticalAccountMenu = new VerticalAccountMenu();
	}
	//getters
	public WebElement getCustomer_welcome() {
		return customer_welcome;
	}
	public WebElement getDropdown_account_menu_button() {
		return dropdown_account_menu_button;
	}
	
	public VerticalAccountMenu getVerticalAccountMenu() {
		return verticalAccountMenu;
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
		this.accountMenuDropDown = new AccountMenuDropDown();
	}
	public AccountMenuDropDown getAccountMenuDropDown() {
		clickDropdown_account_menu_button();
		return this.accountMenuDropDown;
	}
	//logo click
	public HomePageCustomer clickLogo() {
		this.getLogo().click();
		return new HomePageCustomer();
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
		return new AccountDashboardPage();
	}
	public void clickMyWishListButton() {
		this.getMyWishListButton().click();
	}
	public HomePageLogout clickSignOutButton() {
		this.getSignOutButton().click();
		return new HomePageLogout();
		
	}
//------------------------VerticalAccountMenu---------------------------
	public WebElement getAccountDashboardLink() {
		return getVerticalAccountMenu().getAccountDashboardLink();
	}

	public WebElement getAccountInformationLink() {
		return getVerticalAccountMenu().getAccountInformationLink();
	}

	public WebElement getAdressBookLink() {
		return getVerticalAccountMenu().getAdressBookLink();
	}

	public WebElement getMyDownloadableProductsLink() {
		return getVerticalAccountMenu().getMyDownloadableProductsLink();
	}

	public WebElement getMyOrderLink() {
		return getVerticalAccountMenu().getMyOrderLink();
	}

	public WebElement getNewsletterSubscriptionsLink() {
		return getVerticalAccountMenu().getNewsletterSubscriptionsLink();
	}

	public WebElement getMyCreditCardsLink() {
		return getVerticalAccountMenu().getMyCreditCardsLink();
	}

	public WebElement getMyProductReviewsLink() {
		return getVerticalAccountMenu().getMyProductReviewsLink();
	}

	public WebElement getBillingAgreementsLink() {
		return getVerticalAccountMenu().getBillingAgreementsLink();
	}

	public WebElement getMyWishListLink() {
		return getVerticalAccountMenu().getMyWishListLink();
	}
	//click links
	public AccountDashboardPage clickAccountDashboardLink() {
		this.getAccountDashboardLink().click();
		return new AccountDashboardPage();
	}
	public void clickAccountInformationLink() {
		this.getAccountInformationLink().click();
	}
	public void clickAdressBookLink() {
		this.getAdressBookLink().click();
	}
	public void clickMyDownloadableProductsLink() {
		this.getMyDownloadableProductsLink().click();
	}
	public void clickMyOrderLink() {
		this.getMyOrderLink().click();
	}
	public void clickNewsletterSubscriptionsLink() {
		this.getNewsletterSubscriptionsLink().click();
	}
	public void clickMyCreditCardsLink() {
		this.getMyCreditCardsLink().click();
	}
	public void clickMyProductReviewsLink() {
		this.getMyProductReviewsLink().click();
	}
	public void clickBillingAgreementsLink() {
		this.getBillingAgreementsLink().click();
	}
	public void clickMyWishListLink() {
		this.getMyWishListLink().click();
	}
	
	
}

package com.magento.edu.customer.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.magento.edu.customer.pages.AccountDashboardPage;

public class RightAccountMenu {
	public WebDriver driver;
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
	
	public RightAccountMenu(WebDriver driver) {
		this.driver = driver;
		
		this.accountDashboardLink = driver.findElement(By.linkText("Account Dashboard"));
		//=driver.findElement(By.id("block-collapsible-nav"))
		//		.findElement(By.xpath("//*[contains(text(),'Account Dashboard')]"));
		this.accountInformationLink = driver.findElement(By.linkText("Account Information"));
		this.adressBookLink = driver.findElement(By.linkText("Address Book"));
		this.myDownloadableProductsLink = driver.findElement(By.linkText("My Downloadable Products"));
		this.myOrderLink = driver.findElement(By.linkText("My Orders"));
		this.newsletterSubscriptionsLink = driver.findElement(By.linkText("Newsletter Subscriptions"));
		this.myCreditCardsLink = driver.findElement(By.linkText("My Credit Cards"));
		this.myProductReviewsLink = driver.findElement(By.linkText("My Product Reviews"));
		this.billingAgreementsLink = driver.findElement(By.linkText("Billing Agreements"));
		this.myWishListLink = driver.findElement(By.id("block-collapsible-nav")).
				findElement(By.linkText("My Wish List"));
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
	//click links
	public AccountDashboardPage clickAccountDashboardLink() {
		this.getAccountDashboardLink().click();
		return new AccountDashboardPage(driver);
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

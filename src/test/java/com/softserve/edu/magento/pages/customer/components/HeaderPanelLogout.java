package com.softserve.edu.magento.pages.customer.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.magento.pages.customer.CreateAccountPage;
import com.softserve.edu.magento.pages.customer.HomePageLogout;
import com.softserve.edu.magento.pages.customer.SignInPage;


public abstract class HeaderPanelLogout extends Header{
	
	private WebElement welcomeMessage;
	private WebElement signInLink;
	private WebElement createAccountLink;
	
	protected HeaderPanelLogout(WebDriver driver) {
		super(driver);
		this.welcomeMessage = driver.findElement(By.cssSelector("li.greet.welcome")); 
		this.signInLink = driver.findElement(By.partialLinkText("Sign In"));
		this.createAccountLink = driver.findElement(By.partialLinkText("Create an Account"));
	}
//setters
	public void setSignIn(WebElement signInLink) {
		this.signInLink = signInLink;
	}

	public void setCreateAccount(WebElement createAccountLink) {
		this.createAccountLink = createAccountLink;
	}
//getters
	public WebElement getWelcomeMessage() {
		return welcomeMessage;
	}
	public WebElement getSignInLink() {
		return signInLink;
	}

	public WebElement getCreateAccountLink() {
		return createAccountLink;
	}
// business logic
	public String getWelcomeText() {
		return getWelcomeMessage().getText();
	}
	public SignInPage clickSignInLink() {
		this.getSignInLink().click();
		return new SignInPage(driver);
	}
	public CreateAccountPage clickCreateAccountLink() {
		this.getCreateAccountLink().click();
		return new CreateAccountPage(driver);
	}
	public HomePageLogout clickLogo() {
		this.getLogo().click();
		return new HomePageLogout(driver);
	}
}

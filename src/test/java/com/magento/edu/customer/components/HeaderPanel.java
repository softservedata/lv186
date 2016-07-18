package com.magento.edu.customer.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.magento.edu.customer.pages.CreateAccountPage;
import com.magento.edu.customer.pages.SignInPage;

public abstract class HeaderPanel extends Header{
	
	public WebElement signInLink;
	public WebElement createAccountLink;
	
	protected HeaderPanel(WebDriver driver) {
		super(driver);
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
	public WebElement getSignInLink() {
		return signInLink;
	}

	public WebElement getCreateAccountLink() {
		return createAccountLink;
	}
// business logic
	public SignInPage clickSignInLink() {
		this.getSignInLink().click();
		return new SignInPage(driver);
	}
	public CreateAccountPage clickCreateAccountLink() {
		this.getCreateAccountLink().click();
		return new CreateAccountPage(driver);
	}
}

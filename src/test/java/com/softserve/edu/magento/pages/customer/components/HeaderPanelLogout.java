package com.softserve.edu.magento.pages.customer.components;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.softserve.edu.magento.pages.customer.CreateAccountPage;
import com.softserve.edu.magento.pages.customer.HomePageLogout;
import com.softserve.edu.magento.pages.customer.SignInPage;
import com.softserve.edu.magento.tools.Search;


public abstract class HeaderPanelLogout extends Header{
	
	private WebElement welcomeMessage;
	private WebElement signInLink;
	private WebElement createAccountLink;
	
	protected HeaderPanelLogout() {
		this.welcomeMessage = Search.cssSelector("li.greet.welcome");
		//System.out.println("*****Finding partialLinkText(Sign In)");
		//Search.takeScreenShort("screen12.png");
		this.signInLink = Search.partialLinkText("Sign In");
		this.createAccountLink = Search.partialLinkText("Create an Account");
        //System.out.println("*****HeaderPanelLogout() DONE");
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
		return new SignInPage();
	}
	public CreateAccountPage clickCreateAccountLink() {
		this.getCreateAccountLink().click();
		return new CreateAccountPage();
	}
	public HomePageLogout clickLogo() {
		this.getLogo().click();
		return new HomePageLogout();
	}
}

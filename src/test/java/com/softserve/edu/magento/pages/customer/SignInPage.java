package com.softserve.edu.magento.pages.customer;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.softserve.edu.magento.data.customer.user.ICustomerUser;
import com.softserve.edu.magento.pages.customer.components.HeaderPanelLogout;
import com.softserve.edu.magento.tools.Search;


public class SignInPage extends HeaderPanelLogout{

	private WebElement emailField;
	private WebElement passwordField;
	private WebElement signInButton;
	private WebElement forgotPassword;
	private WebElement createAccountButton;
	
 public SignInPage() {
	 this.emailField = Search.id("email");
	 this.passwordField = Search.id("pass");
	 this.signInButton = Search.id("send2");
	 this.forgotPassword = Search.cssSelector("a.action.remind");
	 this.createAccountButton = Search.cssSelector("a.action.create.primary");
 }
//getters
	public WebElement getEmailField() {
		return emailField;
	}
	
	public WebElement getPasswordField() {
		return passwordField;
	}
	
	public WebElement getSignInButton() {
		return signInButton;
	}
	
	public WebElement getForgotPassword() {
		return forgotPassword;
	}
	
	public WebElement getCreateAccountButton() {
		return createAccountButton;
	}
//business logic
	//email field
	public String getEmailFieldText() {
		return getEmailField().getText();
	}
	public void clearEmailField() {
		getEmailField().clear();
	}
	public void SendKeysEmail(String email) {
		getEmailField().sendKeys(email);
	}
	public void clearSendKeysEmail(String email) {
		clearEmailField();
		SendKeysEmail(email);
	}
	//password field
	public String getPasswordFieldText() {
		return getPasswordField().getText();
	}
	public void clearPasswordField() {
		getPasswordField().clear();
	}
	public void SendKeysPassword(String password) {
		getPasswordField().sendKeys(password);
	}
	public void clearSendKeysPassword(String password) {
		clearPasswordField();
		SendKeysPassword(password);
	}
	// button click
	public void clickSignInButton() {
		this.getSignInButton().click();
	}
	public void clickForgotPassword() {
		this.getForgotPassword().click();
	}
	public CreateAccountPage clickCreateAccountButton() {
		this.getCreateAccountButton().click();
		return new CreateAccountPage();
	}
	// functional sign in
	public AccountDashboardPage SignIn(ICustomerUser user) {
		clearSendKeysEmail(user.getSigninInfo().getEmail());
		clearSendKeysPassword(user.getSigninInfo().getPassword());
		clickSignInButton();
		return new AccountDashboardPage();
	}
	public AccountDashboardPage SignIn_Enter(ICustomerUser user) {
		clearSendKeysEmail(user.getSigninInfo().getEmail());
		clearSendKeysPassword(user.getSigninInfo().getPassword());
		getPasswordField().sendKeys(Keys.ENTER);
		return new AccountDashboardPage();
	}
	public UnsuccessfulSignInPage unsuccessfulSignIn(ICustomerUser invalidUser) {
		clearSendKeysEmail(invalidUser.getSigninInfo().getEmail());
		clearSendKeysPassword(invalidUser.getSigninInfo().getPassword());
		clickSignInButton();
		return new UnsuccessfulSignInPage();
	}
	public UnsuccessfulSignInPage unsuccessfulSignIn_Enter(ICustomerUser invalidUser) {
		clearSendKeysEmail(invalidUser.getSigninInfo().getEmail());
		clearSendKeysPassword(invalidUser.getSigninInfo().getPassword());
		getPasswordField().sendKeys(Keys.ENTER);
		return new UnsuccessfulSignInPage();
	}
 
}

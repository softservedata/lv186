package com.magento.edu.customer.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.magento.edu.customer.components.HeaderPanel;
import com.magento.edu.customer.data.user.ICustomerUser;


public class SignInPage extends HeaderPanel{

	public WebElement emailField;
	public WebElement passwordField;
	public WebElement signInButton;
	public WebElement forgotPassword;
	public WebElement createAccountButton;
	
 public SignInPage(WebDriver driver) {
	 super(driver);
	 this.emailField = driver.findElement(By.id("email"));
	 this.passwordField = driver.findElement(By.id("pass"));
	 this.signInButton = driver.findElement(By.id("send2"));
	 this.forgotPassword = driver.findElement(By.cssSelector("a.action.remind"));
	 this.createAccountButton = driver.findElement(By.cssSelector("a.action.create.primary"));
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
	public void typeEmail(String email) {
		getEmailField().sendKeys(email);
	}
	public void clearTypeEmail(String email) {
		clearEmailField();
		typeEmail(email);
	}
	//password field
	public String getPasswordFieldText() {
		return getPasswordField().getText();
	}
	public void clearPasswordField() {
		getPasswordField().clear();
	}
	public void typePassword(String password) {
		getPasswordField().sendKeys(password);
	}
	public void clearTypePassword(String password) {
		clearPasswordField();
		typePassword(password);
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
		return new CreateAccountPage(driver);
	}
	// functional sign in
	public AccountDashboardPage SignIn(ICustomerUser user) {
		clearTypeEmail(user.getSigninInfo().getEmail());
		clearTypePassword(user.getSigninInfo().getPassword());
		clickSignInButton();
		return new AccountDashboardPage(driver);
	}
	public AccountDashboardPage SignIn_Enter(ICustomerUser user) {
		clearTypeEmail(user.getSigninInfo().getEmail());
		clearTypePassword(user.getSigninInfo().getPassword());
		getPasswordField().sendKeys(Keys.ENTER);
		return new AccountDashboardPage(driver);
	}
	public UnsuccessfulSignInPage unsuccessfulSignIn(ICustomerUser invalidUser) {
		clearTypeEmail(invalidUser.getSigninInfo().getEmail());
		clearTypePassword(invalidUser.getSigninInfo().getPassword());
		clickSignInButton();
		return new UnsuccessfulSignInPage(driver);
	}
	public UnsuccessfulSignInPage unsuccessfulSignIn_Enter(ICustomerUser invalidUser) {
		clearTypeEmail(invalidUser.getSigninInfo().getEmail());
		clearTypePassword(invalidUser.getSigninInfo().getPassword());
		getPasswordField().sendKeys(Keys.ENTER);
		return new UnsuccessfulSignInPage(driver);
	}
 
}
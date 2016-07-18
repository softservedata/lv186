package com.magento.edu.customer.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.magento.edu.customer.data.user.ISigninInfo_User;

public class SigninInfCreateAccount {
	
	public WebElement emailField;
	public WebElement passwordField;
	public WebElement confirmPasswordField;
	
	public SigninInfCreateAccount(WebDriver driver) {
		this.emailField = driver.findElement(By.id("email_address"));
		this.passwordField = driver.findElement(By.id("password"));
		this.confirmPasswordField = driver.findElement(By.id("password-confirmation"));
	}

	public WebElement getEmailField() {
		return emailField;
	}

	public WebElement getPasswordField() {
		return passwordField;
	}

	public WebElement getConfirmPasswordField() {
		return confirmPasswordField;
	}
	//business logic
	public String getEmailText() {
		return getEmailField().getText();
	}
	public String getPasswordText() {
		return getPasswordField().getText();
	}
	public String getConfirmPasswordText() {
		return getConfirmPasswordField().getText();
	}
	//clear field
	public void clearEmailField() {
		this.getEmailField().clear();
	}
	public void clearPasswordField() {
		this.getPasswordField().clear();
	}
	public void clearConfirmPasswordField() {
		this.getConfirmPasswordField().clear();
	}
	//input data
	public void typeEmail(String email) {
		this.getEmailField().sendKeys(email);
	}
	public void typePassword(String password) {
		this.getPasswordField().sendKeys(password);;
	}
	public void typeConfirmPassword(String confirmPassword) {
		this.getConfirmPasswordField().sendKeys(confirmPassword);
	}
	public void clearTypeEmail(String email) {
		this.clearEmailField();
		this.typeEmail(email);
	}
	public void clearTypePassword(String password) {
		this.clearPasswordField();
		this.typePassword(password);
	}
	public void clearTypeConfirmPassword(String confirmPassword) {
		this.clearConfirmPasswordField();
		this.typeConfirmPassword(confirmPassword);
	}
	//input form sign in inform
	public void input_SignIn_inform(ISigninInfo_User signinInfo_User) {
		this.clearTypeEmail(signinInfo_User.getEmail());
		this.clearTypePassword(signinInfo_User.getPassword());
		this.clearTypeConfirmPassword(signinInfo_User.getConfirmPassword());
	}
}

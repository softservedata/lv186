package com.magento.edu.customer.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.magento.edu.customer.components.HeaderPanel;
import com.magento.edu.customer.components.PersonalInfCreateAccount;
import com.magento.edu.customer.components.SigninInfCreateAccount;
import com.magento.edu.customer.data.user.IPersonalInfo_User;
import com.magento.edu.customer.data.user.ISigninInfo_User;
import com.magento.edu.customer.data.user.IUser;

public class CreateAccountPage extends HeaderPanel{
	
	public PersonalInfCreateAccount personalInf;
	public SigninInfCreateAccount signinInf;
	public WebElement createAccountButton;
	
	public CreateAccountPage(WebDriver driver) {
		super(driver);
		this.personalInf = new PersonalInfCreateAccount(driver);
		this.signinInf = new SigninInfCreateAccount(driver);
		this.createAccountButton = driver.findElement(By.cssSelector("button.action.submit.primary"));
	}
//getters
	public PersonalInfCreateAccount getPersonalInf() {
		return personalInf;
	}

	public SigninInfCreateAccount getSigninInf() {
		return signinInf;
	}

	public WebElement getCreateAccountButton() {
		return createAccountButton;
	} 
//business logic
	public void input_Personal_inform(IPersonalInfo_User personalInfo_User) {
		this.getPersonalInf().input_Personal_inform(personalInfo_User);
	}
	public void input_SignIn_inform(ISigninInfo_User signinInfo_User) {
		this.getSigninInf().input_SignIn_inform(signinInfo_User);
	}
	public void inputData(IUser user) {
		this.input_Personal_inform(user.getPersonalInfo());
		this.input_SignIn_inform(user.getSigninInfo());
		
	}
	public void clickCreateAccountButton() {
		this.getCreateAccountButton().click();
	}
//functional
	public AccountDashboardPage createNewAccount(IUser user) {
		this.inputData(user);
		this.clickCreateAccountButton();
		return new AccountDashboardPage(driver);
	}
	public AccountDashboardPage createNewAccount_Enter(IUser user) {
		this.inputData(user);
		this.getSigninInf().getConfirmPasswordField().sendKeys(Keys.ENTER);
		return new AccountDashboardPage(driver);
	}
	public Unsuccessful_CreateAccountPage unsuccessful_createNewAccount(IUser invalidUser) {
		this.inputData(invalidUser);
		this.clickCreateAccountButton();
		return new Unsuccessful_CreateAccountPage(driver);
	}
	public Unsuccessful_CreateAccountPage unsuccessful_createNewAccount_Enter(IUser invalidUser) {
		this.inputData(invalidUser);
		this.getSigninInf().getConfirmPasswordField().sendKeys(Keys.ENTER);
		return new Unsuccessful_CreateAccountPage(driver);
	}
}

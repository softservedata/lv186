package com.magento.edu.customer.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.magento.edu.customer.components.HeaderPanel;
import com.magento.edu.customer.data.user.ICustomerUser;
import com.magento.edu.customer.data.user.IPersonalInfo_User;
import com.magento.edu.customer.data.user.ISigninInfo_User;



public class CreateAccountPage extends HeaderPanel{
	
	public PersonalInfCreateAccount personalInf;
	public SigninInfCreateAccount signinInf;
	public WebElement createAccountButton;
	//------------------PersonalInfCreateAccount----------------------------
	private class PersonalInfCreateAccount {
		
		public WebElement firstnameField;
		public WebElement labelFirstnameField;
		public WebElement lastnameField;
		public WebElement labelLastnameField;
		public WebElement signUpNewsletterCheckBox;
		public WebElement labelSignUpNewsletterCheckBox;
		
		public PersonalInfCreateAccount() {
			this.firstnameField = driver.findElement(By.id("firstname"));
			this.labelFirstnameField = driver.findElement(By.xpath("//label[@for='firstname']"));
			this.lastnameField = driver.findElement(By.id("lastname"));
			this.labelLastnameField = driver.findElement(By.xpath("//label[@for='lastname']"));
			this.signUpNewsletterCheckBox = driver.findElement(By.id("is_subscribed"));
			this.labelSignUpNewsletterCheckBox = driver.findElement(By.xpath("//label[@for='is_subscribed']"));
		}

		
		public WebElement getFirstnameField() {
			return firstnameField;
		}


		public WebElement getLabelFirstnameField() {
			return labelFirstnameField;
		}


		public WebElement getLastnameField() {
			return lastnameField;
		}


		public WebElement getLabelLastnameField() {
			return labelLastnameField;
		}


		public WebElement getSignUpNewsletterCheckBox() {
			return signUpNewsletterCheckBox;
		}


		public WebElement getLabelSignUpNewsletterCheckBox() {
			return labelSignUpNewsletterCheckBox;
		}


		//business logic
		
		public String getFirstnameText() {
			return getFirstnameField().getText();
		}
		public String getLastnameText() {
			return getLastnameField().getText();
		}
		public void clickLabelSignUpNewsletter() {
			getLabelSignUpNewsletterCheckBox().click();
		}
		public void clickSignUpNewsletterCheckBox() {
			this.getSignUpNewsletterCheckBox().click();
		}
		//clear fields
		public void clearFirstnameField() {
			getFirstnameField().clear();
		}
		public void clearLastnameField() {
			getLastnameField().clear();
		}
		//input data
		public void typeFirstname(String firstname) {
			getFirstnameField().sendKeys(firstname);
		}
		public void typeLastname(String lastname) {
			getLastnameField().sendKeys(lastname);
		}
		public void clearTypeFirstname(String firstname) {
			clearFirstnameField();
			typeFirstname(firstname);
		}
		public void clearTypeLastName(String lastname) {
			clearLastnameField();
			typeLastname(lastname);
		}
		//input form personal inform
		public void input_Personal_inform(IPersonalInfo_User personalInfo_User) {
			clearTypeFirstname(personalInfo_User.getFirstname());
			clearTypeLastName(personalInfo_User.getLastname());
			if ( personalInfo_User.getSignUpNewsletter() == true ) {
				clickSignUpNewsletterCheckBox();
			}
		}
		
	}
	//------------------SigninInfCreateAccount-----------------------
	private class SigninInfCreateAccount {
		
		public WebElement emailField;
		public WebElement passwordField;
		public WebElement confirmPasswordField;
		
		public SigninInfCreateAccount() {
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

	//----------------------------------------------
	public CreateAccountPage(WebDriver driver) {
		super(driver);
		this.personalInf = new PersonalInfCreateAccount();
		this.signinInf = new SigninInfCreateAccount();
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
	public void inputData(ICustomerUser user) {
		this.input_Personal_inform(user.getPersonalInfo());
		this.input_SignIn_inform(user.getSigninInfo());
		
	}
	public void clickCreateAccountButton() {
		this.getCreateAccountButton().click();
	}
//functional
	public AccountDashboardPage createNewAccount(ICustomerUser user) {
		this.inputData(user);
		this.clickCreateAccountButton();
		return new AccountDashboardPage(driver);
	}
	public AccountDashboardPage createNewAccount_Enter(ICustomerUser user) {
		this.inputData(user);
		this.getSigninInf().getConfirmPasswordField().sendKeys(Keys.ENTER);
		return new AccountDashboardPage(driver);
	}
	public Unsuccessful_CreateAccountPage unsuccessful_createNewAccount(ICustomerUser invalidUser) {
		this.inputData(invalidUser);
		this.clickCreateAccountButton();
		return new Unsuccessful_CreateAccountPage(driver);
	}
	public Unsuccessful_CreateAccountPage unsuccessful_createNewAccount_Enter(ICustomerUser invalidUser) {
		this.inputData(invalidUser);
		this.getSigninInf().getConfirmPasswordField().sendKeys(Keys.ENTER);
		return new Unsuccessful_CreateAccountPage(driver);
	}
}
package com.softserve.edu.magento.pages.customer;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.softserve.edu.magento.data.customer.user.ICustomerUser;
import com.softserve.edu.magento.data.customer.user.IPersonalInfo_User;
import com.softserve.edu.magento.data.customer.user.ISigninInfo_User;
import com.softserve.edu.magento.pages.customer.components.HeaderPanelLogout;
import com.softserve.edu.magento.tools.Search;


public class CreateAccountPage extends HeaderPanelLogout{
	
	private PersonalInfCreateAccount personalInf;
	private SigninInfCreateAccount signinInf;
	private WebElement createAccountButton;
	//------------------PersonalInfCreateAccount----------------------------
	private class PersonalInfCreateAccount {
		
		private WebElement firstnameField;
		private WebElement labelFirstnameField;
		private WebElement lastnameField;
		private WebElement labelLastnameField;
		private WebElement signUpNewsletterCheckBox;
		private WebElement labelSignUpNewsletterCheckBox;
		
		public PersonalInfCreateAccount() {
			this.firstnameField = Search.id("firstname");
			this.lastnameField = Search.id("lastname");
			this.signUpNewsletterCheckBox = Search.id("is_subscribed");
			this.labelSignUpNewsletterCheckBox = Search.xpath("//label[@for='is_subscribed']");
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
		
	}
	//------------------SigninInfCreateAccount-----------------------
	private class SigninInfCreateAccount {
		
		private WebElement emailField;
		private WebElement passwordField;
		private WebElement confirmPasswordField;
		
		public SigninInfCreateAccount() {
			this.emailField = Search.id("email_address");
			this.passwordField = Search.id("password");
			this.confirmPasswordField = Search.id("password-confirmation");
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
	}

	//----------------------------------------------
	public CreateAccountPage() {
		this.personalInf = new PersonalInfCreateAccount();
		this.signinInf = new SigninInfCreateAccount();
		this.createAccountButton = Search.cssSelector("button.action.submit.primary");
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
//------------------Personal_inform---------------------------
	public WebElement getFirstnameField() {
		return this.getPersonalInf().getFirstnameField();
	}
	public WebElement getLabelFirstnameField() {
		return this.getPersonalInf().getLabelFirstnameField();
	}
	public WebElement getLastnameField() {
		return this.getPersonalInf().getLastnameField();
	}
	public WebElement getLabelLastnameField() {
		return this.getPersonalInf().getLabelLastnameField();
	}
	public WebElement getSignUpNewsletterCheckBox() {
		return this.getPersonalInf().getSignUpNewsletterCheckBox();
	}

	public WebElement getLabelSignUpNewsletterCheckBox() {
		return this.getPersonalInf().getLabelSignUpNewsletterCheckBox();
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
	public void SendKeysFirstname(String firstname) {
		getFirstnameField().sendKeys(firstname);
	}
	public void SendKeysLastname(String lastname) {
		getLastnameField().sendKeys(lastname);
	}
	public void clearSendKeysFirstname(String firstname) {
		clearFirstnameField();
		SendKeysFirstname(firstname);
	}
	public void clearSendKeysLastName(String lastname) {
		clearLastnameField();
		SendKeysLastname(lastname);
	}
	//input form personal inform
	public void input_Personal_inform(IPersonalInfo_User personalInfo_User) {
		clearSendKeysFirstname(personalInfo_User.getFirstname());
		clearSendKeysLastName(personalInfo_User.getLastname());
		if ( personalInfo_User.getSignUpNewsletter() == true ) {
			clickSignUpNewsletterCheckBox();
		}
	}
//--------------------Sign in Information-----------------------------
	public WebElement getEmailField() {
		return this.getSigninInf().getEmailField();
	}

	public WebElement getPasswordField() {
		return getSigninInf().getPasswordField();
	}

	public WebElement getConfirmPasswordField() {
		return getSigninInf().getConfirmPasswordField();
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
	public void SendKeysEmail(String email) {
		this.getEmailField().sendKeys(email);
	}
	public void SendKeysPassword(String password) {
		this.getPasswordField().sendKeys(password);;
	}
	public void SendKeysConfirmPassword(String confirmPassword) {
		this.getConfirmPasswordField().sendKeys(confirmPassword);
	}
	public void clearSendKeysEmail(String email) {
		this.clearEmailField();
		this.SendKeysEmail(email);
	}
	public void clearSendKeysPassword(String password) {
		this.clearPasswordField();
		this.SendKeysPassword(password);
	}
	public void clearSendKeysConfirmPassword(String confirmPassword) {
		this.clearConfirmPasswordField();
		this.SendKeysConfirmPassword(confirmPassword);
	}
	//input form sign in inform
	public void input_SignIn_inform(ISigninInfo_User signinInfo_User) {
		this.clearSendKeysEmail(signinInfo_User.getEmail());
		this.clearSendKeysPassword(signinInfo_User.getPassword());
		this.clearSendKeysConfirmPassword(signinInfo_User.getConfirmPassword());
	}

//------------------------CreateAccountButton------------------------------		
//business logic input data 
	public void inputData(ICustomerUser user) {
		this.input_Personal_inform(user.getPersonalInfo());
		this.input_SignIn_inform(user.getSigninInfo());
		
	}
	public void clickCreateAccountButton() {
		this.getCreateAccountButton().click();
	}
//functional createNewAccount
	public AccountDashboardPage createNewAccount(ICustomerUser user) {
		this.inputData(user);
		this.clickCreateAccountButton();
		return new AccountDashboardPage();
	}
	public AccountDashboardPage createNewAccount_Enter(ICustomerUser user) {
		this.inputData(user);
		this.getSigninInf().getConfirmPasswordField().sendKeys(Keys.ENTER);
		return new AccountDashboardPage();
	}
	public Unsuccessful_CreateAccountPage unsuccessful_createNewAccount(ICustomerUser invalidUser) {
		this.inputData(invalidUser);
		this.clickCreateAccountButton();
		return new Unsuccessful_CreateAccountPage();
	}
	public Unsuccessful_CreateAccountPage unsuccessful_createNewAccount_Enter(ICustomerUser invalidUser) {
		this.inputData(invalidUser);
		this.getSigninInf().getConfirmPasswordField().sendKeys(Keys.ENTER);
		return new Unsuccessful_CreateAccountPage();
	}
}

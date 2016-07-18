package com.softserve.edu.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.data.IUser;

public class LoginPage  {
       
    // Fields
	protected WebDriver driver;
    private WebElement userNameLabel;
    private WebElement userNameInput;
    private WebElement passwordLabel;
    private WebElement passwordInput;
    private WebElement signin;
    public LoginPage(WebDriver driver) {
		this.driver = driver;
		
        this.userNameLabel = driver.findElement(By
        		.xpath("//*[@for='username']/span"));
        
        this.userNameInput = driver.findElement(By
        		.id("username"));
        
        this.passwordLabel = driver.findElement(By
        		.xpath("//*[@for='login']/span"));
        
        this.passwordInput = driver.findElement(By
        		.id("login"));
        
        this.signin = driver.findElement(By
        		.cssSelector("button.action-login.action-primary"));
    }

    // PageObject

    // get Data PageObject

    public WebElement getUserNameLabel() {
        return this.userNameLabel;
    }

    public WebElement getUserNameInput() {
        return this.userNameInput;
    }

    public WebElement getPasswordLabel() {
        return this.passwordLabel;
    }

    public WebElement getPasswordInput() {
        return this.passwordInput;
	}

	public WebElement getSignin() {
		return this.signin;
	}

	// get Data Business Logic

	public String getLoginLabelText() {
		return getUserNameLabel().getText().trim();
    }

    public String getLoginInputText() {
        return getUserNameInput().getText();
    }

    public String getPasswordLabelText() {
        return getPasswordLabel().getText().trim();
    }

    public String getPasswordInputText() {
        return getPasswordInput().getText();
    }

    public String getSignintText() {
        return getSignin().getText().trim();
    }

    // set Data PageObject

    public void setLoginInput(String login) {
        getUserNameInput().sendKeys(login);
    }

    public void setPasswordInput(String password) {
        getPasswordInput().sendKeys(password);
    }

    public void clearLoginInput() {
        getUserNameInput().clear();
    }

    public void clearPasswordInput() {
        getPasswordInput().clear();
    }

    public void clickLoginInput() {
        getUserNameInput().click();
    }

    public void clickPasswordInput() {
        getPasswordInput().click();
    }

    public void clickSignin() {
        getSignin().click();
    }

    // set Data Business Logic

    public void setLoginInputClear(String login) {
        clearLoginInput();
        setLoginInput(login);
    }

    public void setPasswordInputClear(String password) {
        clearPasswordInput();
        setPasswordInput(password);
    }

    // Functional Business Logic

	private void setLoginData(IUser user) {
		setLoginInputClear(user.getUserName());
		setPasswordInputClear(user.getPassword());
		clickSignin();
	}

	public DashboardPage successAdminLogin(IUser admin) {

		setLoginData(admin);
		// Return a new page object representing the destination.
		return new DashboardPage(driver);
	}

	public LoginValidatorPage unsuccessfulLogin(IUser invalidUser) {

		setLoginData(invalidUser);
		return new LoginValidatorPage(driver); // return this;
	}
}

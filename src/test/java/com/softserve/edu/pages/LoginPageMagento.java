package com.softserve.edu.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.data.IUser;

public class LoginPageMagento  {
       
    // Fields
	protected WebDriver driver;
    private WebElement userNameLabel;
    private WebElement userNameInput;
    private WebElement passwordLabel;
    private WebElement passwordInput;
    private WebElement signin;
    private WebElement forgotPassword;
    public LoginPageMagento(WebDriver driver) {
    	this.driver=driver;
        this.userNameLabel = driver.findElement(By.xpath("//*[@for='username']/span"));
        this.userNameInput = driver.findElement(By.id("username"));
        this.passwordLabel = driver.findElement(By.xpath("//*[@for='login']/span"));
        this.passwordInput = driver.findElement(By.id("login"));
        this.signin = driver.findElement(By.cssSelector("button.action-login.action-primary"));
        this.forgotPassword = driver.findElement(By.cssSelector("a.action-forgotpassword)"));
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
    public WebElement getForgotPassword() {
        return this.forgotPassword;
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

   

    // TODO Develop User class
    private void setLoginData(IUser user) {
    //private void setLoginData(String login, String password) {
        //setLoginInputClear(login);
        //setPasswordInputClear(password);
        setLoginInputClear(user.getLogin());
        setPasswordInputClear(user.getPassword());
        clickSignin();
    }

    // public HomePage successUserLogin(IUser user) {
    // setLoginData(user);
    // // Return a new page object representing the destination.
    // return new HomePage();
    // }

    public AdminHomePage successAdminLogin(IUser admin) {
    //public AdminHomePage successAdminLogin(String login, String password) {
        //setLoginData(login, password);
        setLoginData(admin);
        // Return a new page object representing the destination.
        return new AdminHomePage(driver);
    }

    // public RegistratorHomePage successRegistratorLogin(IUser registrator) {
    // setLoginData(registrator);
    // // Return a new page object representing the destination.
    // return new RegistratorHomePage();
    // }

    // TODO Develop User class
    public LoginValidatorPage unsuccessfulLogin(IUser invalidUser) {
    //public LoginValidatorPage unsuccessfulLogin(String login, String password) {
        //setLoginData(login, password);
        setLoginData(invalidUser);
        return new LoginValidatorPage(driver); // return this;
    }
}

package com.softserve.edu.magento.pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.magento.data.admin.IAdminUser;
import com.softserve.edu.magento.pages.admin.menu.customers.editCustomer.EditCustomerPage;
import com.softserve.edu.magento.pages.admin.menu.dashboard.DashboardPage;
import com.softserve.edu.magento.tools.Search;

public class AdminLoginSearchPage {

    // Fields

    //
    private WebElement usernameLabel;
    private WebElement usernameInput;
    private WebElement passwordLabel;
    private WebElement passwordInput;
    private WebElement signin;



    public AdminLoginSearchPage() {
        this.usernameLabel = Search.xpath("//*[@for='username']/span");
        this.usernameInput = Search.id("username");
        this.passwordLabel = Search.xpath("//*[@for='login']/span");
        this.passwordInput = Search.id("login");
        this.signin = Search.cssSelector("button.action-login.action-primary");
    }

    // PageObject

    // get Data PageObject

    public WebElement getUsernameLabel() {
        return this.usernameLabel;
    }

    public WebElement getUsernameInput() {
        return this.usernameInput;
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
        return getUsernameLabel().getText().trim();
    }

    public String getLoginInputText() {
        return getUsernameInput().getText();
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
        getUsernameInput().sendKeys(login);
    }

    public void setPasswordInput(String password) {
        getPasswordInput().sendKeys(password);
    }

    public void clearLoginInput() {
        getUsernameInput().clear();
    }

    public void clearPasswordInput() {
        getPasswordInput().clear();
    }

    public void clickLoginInput() {
        getUsernameInput().click();
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

    private void setLoginData(IAdminUser user) {
        setLoginInputClear(user.getUsername());
        setPasswordInputClear(user.getPassword());
        clickSignin();
    }

    public DashboardPage successAdminLogin(IAdminUser admin) {
        setLoginData(admin);
        // Return a new page object representing the destination.
        return new DashboardPage();
    }
    public EditCustomerPage successEditCustomer(IAdminUser admin) {
        setLoginData(admin);
        // Return a new page object representing the destination.
        return new EditCustomerPage();
    }

    public AdminLoginValidatorPage unsuccessfulLogin(IAdminUser invalidUser) {
        setLoginData(invalidUser);
        return new AdminLoginValidatorPage(); // return this;
    }

}

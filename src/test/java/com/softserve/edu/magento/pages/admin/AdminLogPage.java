package com.softserve.edu.magento.pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.softserve.edu.magento.data.admin.IAdminUser;
import com.softserve.edu.magento.pages.admin.menu.customers.editCustomer.EditCustomerPage;
import com.softserve.edu.magento.pages.admin.menu.dashboard.DashboardPage;

public class AdminLogPage {

    // Fields
    protected WebDriver driver;
    //
    @FindBy(xpath = "//*[@for='username']/span")
    private WebElement usernameLabel;
    //
    @FindBy(id = "username")
    //@CacheLookup
    private WebElement usernameInput;
    //
    @FindBy(xpath = "//*[@for='login']/span")
    private WebElement passwordLabel;
    //
    @FindBy(id = "login")
    private WebElement passwordInput;
    //
    @FindBy(css = "button.action-login.action-primary")
    private WebElement signin;

    public AdminLogPage(WebDriver driver) {
        this.driver = driver;
        //PageFactory.initElements(driver, this);
//        this.usernameLabel = driver.findElement(By.xpath("//*[@for='username']/span"));
//        this.usernameInput = driver.findElement(By.id("username"));
//        this.passwordLabel = driver.findElement(By.xpath("//*[@for='login']/span"));
//        this.passwordInput = driver.findElement(By.id("login"));
//        this.signin = driver.findElement(By.cssSelector("button.action-login.action-primary"));
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
        return new DashboardPage(driver);
    }
    public EditCustomerPage successEditCustomer(IAdminUser admin) {
        setLoginData(admin);
        // Return a new page object representing the destination.
        return new EditCustomerPage(driver);
    }

    public AdminLoginValidatorPage unsuccessfulLogin(IAdminUser invalidUser) {
        setLoginData(invalidUser);
        return new AdminLoginValidatorPage(driver); // return this;
    }

}

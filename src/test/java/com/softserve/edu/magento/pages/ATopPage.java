package com.softserve.edu.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class ATopPage {

    private class ControlsMenuComponent {
        public final WebElement accountSetting;
        public final WebElement customerView;
        public final WebElement signOut;

        public ControlsMenuComponent() {
            this.accountSetting = driver.findElement(By.xpath("//*[@data-ui-id='user-user-account-settings']"));
            this.customerView = driver.findElement(By.className("store-front"));
            this.signOut = driver.findElement(By.className("account-signout"));
        }
    }

    // Fields
    protected WebDriver driver;
    // Elements
    private WebElement pageTitle;
    private WebElement searchLabel;
    private WebElement searchInput;
    private WebElement notifications;
    private WebElement accountMenu;
    // Components
    private ControlsMenuComponent menuControls;

    protected ATopPage(WebDriver driver) {
        this.driver = driver;
        //
        this.pageTitle = driver.findElement(By.cssSelector("h1.page-title"));
        this.searchLabel = driver.findElement(By.className("search-global-label"));
        //this.searchInput = driver.findElement(By.className("div.autocomplete-results"));
        //this.notifications = driver.findElement(By.className("notifications-action admin__action-dropdown"));
        this.notifications = driver.findElement(By.cssSelector("a.notifications-action.admin__action-dropdown"));
        //this.menuAccount = driver.findElement(By.xpath("//*[@class='admin-user admin__action-dropdown-wrap']/a"));
        this.accountMenu = driver.findElement(By.cssSelector("span.admin-user-account-text"));
    }

    // PageObject

    // get Data PageObject
    
    public WebElement getPageTitle() {
        return this.pageTitle;
    }

    public WebElement getSearchLabel() {
        return this.searchLabel;
    }

    public WebElement getMenuSystemNotifications() {
        return this.notifications;
    }

    public WebElement getAccountMenu() {
        return this.accountMenu;
    }

    public WebElement getAccountSetting() {
        clickAccountMenu();
        return this.menuControls.accountSetting;
    }

    public WebElement getCustomerView() {
        clickAccountMenu();
        return this.menuControls.customerView;
    }

    public WebElement getSignOut() {
        clickAccountMenu();
        return this.menuControls.signOut;
    }

    public WebElement getSearchInput() {
        clickSearchLabel();
        return this.searchInput;
    }

    // get Data Business Logic
    
    public String getPageTitleText() {
        return getPageTitle().getText();
    }

    public String getAccountMenuText() {
        return getAccountMenu().getText();
    }

//    public String getAccountSettingText() {
//        return getAccountSetting().getText();
//    }

//    public String getCustomerViewText() {
//        return getCustomerView().getText();
//    }

//    public String getSignOutText() {
//        return getSignOut().getText();
//    }

    // set Data PageObject

    public void clickSearchLabel() {
        getPageTitle().click();
        getSearchLabel().click();
        searchInput = driver.findElement(By.id("search-global"));
        // TODO Create Components
    }

    public void clickNotifications() {
        getMenuSystemNotifications().click();
    }

    public void clickAccountMenu() {
        getPageTitle().click();
        getAccountMenu().click();
        this.menuControls = new ControlsMenuComponent();
    }

    public void clickAccountSetting() {
        getAccountSetting().click();
    }

    public void clickCustomerView() {
        getCustomerView().click();
    }

    public void clickSignOut() {
        getSignOut().click();
    }

    public void setSearchInput(String text) {
        clickSearchLabel();
        getSearchInput().sendKeys(text);
    }

    public void clearSearch() {
        clickSearchLabel();
        getSearchInput().clear();
    }

    // Business Logic
    
    public AdminLoginPage logout() {
        clickSignOut();
        // Return a new page object representing the destination.
        return new AdminLoginPage(driver);
    }

}

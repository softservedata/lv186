package com.softserve.edu.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class ATopPage {

    private class MenuControlsComponent {
        public final WebElement accountSetting;
        public final WebElement customerView;
        public final WebElement signOut;

        public MenuControlsComponent() {
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
    //private WebElement searchInput;
    private WebElement notifications;
    private WebElement menuAccount;
    // Components
    private MenuControlsComponent menuControls;

    protected ATopPage(WebDriver driver) {
        this.driver = driver;
        //
        this.pageTitle = driver.findElement(By.className("h1.page-title"));
        this.searchLabel = driver.findElement(By.className("search-global-label"));
        //this.searchInput = driver.findElement(By.className("div.autocomplete-results"));
        //this.notifications = driver.findElement(By.className("notifications-action admin__action-dropdown"));
        this.notifications = driver.findElement(By.cssSelector("a.notifications-action.admin__action-dropdown"));
        //this.menuAccount = driver.findElement(By.xpath("//*[@class='admin-user admin__action-dropdown-wrap']/a"));
        this.menuAccount = driver.findElement(By.cssSelector("span.admin-user-account-text"));
    }

    // PageObject

    // get Data PageObject
    
    public WebElement getPageTitle() {
        return this.pageTitle;
    }

    public WebElement getSearchLabel() {
        return this.searchLabel;
    }

    public WebElement getNotifications() {
        return this.notifications;
    }

    public WebElement getMenuAccount() {
        return this.menuAccount;
    }

//    public WebElement getAccountSetting() {
//        return this.menuControls.accountSetting;
//    }

//    public WebElement getCustomerView() {
//        return this.menuControls.customerView;
//    }

//    public WebElement getSignOut() {
//        return this.menuControls.signOut;
//    }

    // get Data Business Logic
    public String getPageTitleText() {
        return getPageTitle().getText();
    }

    public String getMenuAccountText() {
        return getMenuAccount().getText();
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
        // TODO Create Components
        getSearchLabel().click();
    }

    public void clickNotifications() {
        getNotifications().click();
    }

    public void clickMenuAccount() {
        getPageTitle().click();
        getMenuAccount().click();
        this.menuControls = new MenuControlsComponent();
    }

    //////////////////////////////
    
    public void clickAccountSetting() {
        getAccountSetting().click();
    }

    public void clickCustomerView() {
        getCustomerView().click();
    }

    public void clickSignOut() {
        getSignOut().click();
    }

    public void setSearch(String text) {
        clickSearch();
        getSearch().sendKeys(text);
    }

    public void clearSearch() {
        getSearch().clear();
    }

}

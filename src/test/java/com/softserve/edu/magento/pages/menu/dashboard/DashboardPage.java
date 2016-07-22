package com.softserve.edu.magento.pages.menu.dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.magento.pages.ApplicationAdmin;
import com.softserve.edu.magento.pages.VerticalMenu;

public class DashboardPage extends VerticalMenu {
    
    // Fields
    public final static String PAGE_TITLE = "Dashboard";
    public final static String HREF_ATTRIBUTE = "href";
    //
    // Elements
    private WebElement lifeTimeSales;
    private WebElement lifeTimeSalesValue;
    private WebElement averageOrder;
    private WebElement averageOrderValue;
    private WebElement lastOrdersTitle;
    private WebElement lastOrders;
    // private StoreViewComponent storeView;

    public DashboardPage(WebDriver driver) {
        super(driver);
        lifeTimeSalesValue = driver.findElement(By.xpath("//div[contains(text(),'Lifetime Sales')]/following-sibling::div//span[@class='price']"));
        //
        saveLogoutUrl();
    }

    private void saveLogoutUrl() {
        if ((ApplicationAdmin.getCurrentApplicationSources() != null) 
                && ((ApplicationAdmin.getCurrentApplicationSources().getLogoutUrl() == null)
                        || (ApplicationAdmin.getCurrentApplicationSources().getLogoutUrl().isEmpty()))) {
            System.out.println("+++saveLogoutUrl() DONE");
            ApplicationAdmin.getCurrentApplicationSources()
                .setLogoutUrl(getSignOut().getAttribute(HREF_ATTRIBUTE));
            getPageTitle().click();
        }
    }
    
    // Page Object
    // Get Data PageObject

    public WebElement getLifeTimeSalesValue() {
        return this.lifeTimeSalesValue;
    }
    
    // get Data Business Logic
    
    public String getLifeTimeSalesValueText() {
        return getLifeTimeSalesValue().getText();
    }

}

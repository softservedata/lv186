package com.softserve.edu.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends VerticalMenu {
    
    // Fields
    public final static String PAGE_TITLE = "Dashboard";
    //
    // Elements
    private WebElement lifeTimeSales;
    private WebElement lifeTimeSalesValue;
    private WebElement averageOrder;
    private WebElement averageOrderValue;
    private WebElement lastOrdersTitle;
    private WebElement lastOrders;
    // private StoreViewComponent storeView;

    protected DashboardPage(WebDriver driver) {
        super(driver);
        lifeTimeSalesValue = driver.findElement(By.xpath("//div[contains(text(),'Lifetime Sales')]/following-sibling::div//span[@class='price']"));
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

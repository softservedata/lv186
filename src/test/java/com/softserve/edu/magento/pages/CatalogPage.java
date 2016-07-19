package com.softserve.edu.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CatalogPage extends VerticalMenu {

    // Fields
    public final static String PAGE_TITLE = "Catalog";
    //
    // Elements
    private WebElement firstProductName;

    // Components

    protected CatalogPage(WebDriver driver) {
        super(driver);
        firstProductName = driver.findElement(By.xpath("//tbody/tr[1]/td[4]"));
    }

    // Page Object
    // Get Data PageObject

    public WebElement getFirstProductName() {
        return this.firstProductName;
    }
    
    // get Data Business Logic

    public String getFirstProductNameText() {
        return getFirstProductName().getText();
    }

}

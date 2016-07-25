package com.softserve.edu.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminLoginValidatorPage extends AdminLoginPage {

    // Fields

    private WebElement invalidLoginValidator;

    public AdminLoginValidatorPage(WebDriver driver) {
        super(driver);
        //this.invalidLoginValidator = driver.findElement(By.cssSelector("div.message.message-error.error div"));
        this.invalidLoginValidator = driver.findElement(By.xpath("//*[@data-ui-id]"));
    }

    // PageObject

    // get Data PageObject

    public WebElement getInvalidLoginValidator() {
        return this.invalidLoginValidator;
    }

    // get Data Business Logic

    public String getInvalidLoginValidatorText() {
        return getInvalidLoginValidator().getText().trim();
    }

}

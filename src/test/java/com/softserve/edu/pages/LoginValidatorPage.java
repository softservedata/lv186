package com.softserve.edu.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginValidatorPage extends LoginPage {

    // Fields

    private WebElement invalidLoginValidator;

    public LoginValidatorPage(WebDriver driver) {
        super(driver);
        this.invalidLoginValidator = driver.findElement(By.xpath("//div[contains(@style,'color: red;')]"));
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

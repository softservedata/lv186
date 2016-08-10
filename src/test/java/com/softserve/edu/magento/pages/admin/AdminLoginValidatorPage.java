package com.softserve.edu.magento.pages.admin;


import org.openqa.selenium.WebElement;

import com.softserve.edu.magento.tools.Search;

public class AdminLoginValidatorPage extends AdminLoginPage {

    // Fields

    private WebElement invalidLoginValidator;

    public AdminLoginValidatorPage() {

        //this.invalidLoginValidator = driver.findElement(By.cssSelector("div.message.message-error.error div"));
        this.invalidLoginValidator = Search.xpath("//*[@data-ui-id]");
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

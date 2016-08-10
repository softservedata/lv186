package com.softserve.edu.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginValidatorPage extends LoginPage {

    public static enum LoginValidatorPageL10n {
        INVALID_LOGINVALIDATOR_LABEL("Неправильний логін або пароль",
                "Неправильный логин или пароль", "Invalid Login or Password");
        //
        private HashMap<ChangeLanguageFields, String> field;

        private LoginValidatorPageL10n(String... localization) {
            this.field = new HashMap<ChangeLanguageFields, String>();
            int i = 0;
            for (ChangeLanguageFields language : ChangeLanguageFields.values()) {
                this.field.put(language, localization[i]);
                i++;
            }
        }

        public String getLocalization(ChangeLanguageFields language) {
            return this.field.get(language).trim();
        }
    }

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

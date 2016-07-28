package com.softserve.edu.magento.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class ASearch {

    private Application<?> application;

    public ASearch(Application<?> application) {
        this.application = application;
    }

    Application<?> getApplication() {
        return application;
    }

    WebDriver getWebDriver() {
        return application.getWebDriver();
    }

    public abstract WebElement id(String id);

    public abstract WebElement name(String name);

    public abstract WebElement xpath(String xpath);

    public abstract WebElement cssSelector(String cssSelector);

    public abstract WebElement className(String className);
    
    public abstract WebElement partialLinkText(String partialLinkText);
    
    public abstract WebElement linkText(String linkText);

}

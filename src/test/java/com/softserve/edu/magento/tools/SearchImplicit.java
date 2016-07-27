package com.softserve.edu.magento.tools;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchImplicit extends ASearch {

    public SearchImplicit(Application<?> application) {
        super(application);
        getWebDriver().manage().timeouts().implicitlyWait(getApplication().getApplicationSources().getImplicitTimeOut(), TimeUnit.SECONDS);
        // TODO setup waits
        getWebDriver().manage().timeouts().pageLoadTimeout(30L, TimeUnit.SECONDS);
        getWebDriver().manage().timeouts().setScriptTimeout(30L, TimeUnit.SECONDS);
        //System.out.println("***SearchImplicit");
    }

    private WebElement getWebElement(By by) {
        return this.getWebDriver().findElement(by);
    }
    
    @Override
    public WebElement id(String id) {
        return getWebElement(By.id(id));
    }

    @Override
    public WebElement name(String name) {
        return getWebElement(By.name(name));
    }

    @Override
    public WebElement xpath(String xpath) {
        return getWebElement(By.xpath(xpath));
    }

    @Override
    public WebElement cssSelector(String cssSelector) {
        return getWebElement(By.cssSelector(cssSelector));
    }

    @Override
    public WebElement className(String className) {
        return getWebElement(By.className(className));
    }

}

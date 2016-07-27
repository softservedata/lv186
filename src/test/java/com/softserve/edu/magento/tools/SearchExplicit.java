package com.softserve.edu.magento.tools;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchExplicit extends ASearch {

    public SearchExplicit(Application<?> application) {
        super(application);
        getWebDriver().manage().timeouts().implicitlyWait(0L, TimeUnit.SECONDS);
        //getWebDriver().manage().timeouts().pageLoadTimeout(0L, TimeUnit.SECONDS);
        //getWebDriver().manage().timeouts().setScriptTimeout(0L, TimeUnit.SECONDS);
        //System.out.println("***SearchExplicit");
    }
    
    private WebElement getVisibleWebElement(By by) {
        return new WebDriverWait(this.getWebDriver(),
                getApplication().getApplicationSources().getExplicitTimeOut())
            .until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    
    @Override
    public WebElement id(String id) {
        return getVisibleWebElement(By.id(id));
    }

    @Override
    public WebElement name(String name) {
        return getVisibleWebElement(By.name(name));
    }

    @Override
    public WebElement xpath(String xpath) {
        return getVisibleWebElement(By.xpath(xpath));
    }

    @Override
    public WebElement cssSelector(String cssSelector) {
        return getVisibleWebElement(By.cssSelector(cssSelector));
    }

    @Override
    public WebElement className(String className) {
        return getVisibleWebElement(By.className(className));
    }

}

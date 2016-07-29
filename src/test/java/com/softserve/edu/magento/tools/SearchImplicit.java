package com.softserve.edu.magento.tools;

import java.util.List;
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

    private WebElement getWebElement(By by, WebElement fromWebElement) {
        return fromWebElement.findElement(by);
    }

    private List<WebElement> getWebElements(By by) {
        return this.getWebDriver().findElements(by);
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
    
    @Override
    public  WebElement partialLinkText(String partialLinkText) {
    	return getWebElement(By.partialLinkText(partialLinkText));
    }
    
    @Override
    public  WebElement linkText(String linkText) {
    	return getWebElement(By.linkText(linkText));
    }
    
    @Override
    public  WebElement id(String id, WebElement fromWebElement) {
        return getWebElement(By.id(id), fromWebElement);
    }

    @Override
    public List<WebElement> names(String name) {
        return getWebElements(By.name(name));
    }

}

package com.softserve.edu.magento.tools;

import java.util.List;
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
    
    // Must be Selenium version 2.53.1
//    private WebElement getVisibleWebElement(By by, WebElement fromWebElement) {
//        return new WebDriverWait(this.getWebDriver(),
//                getApplication().getApplicationSources().getExplicitTimeOut())
//            .until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(fromWebElement, by)).get(0);
//    }

      // TODO
      private WebElement getVisibleWebElement(By by, WebElement fromWebElement) {
          WebElement result;
          getWebDriver().manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
          result = fromWebElement.findElement(by); 
          getWebDriver().manage().timeouts().implicitlyWait(0L, TimeUnit.SECONDS);
          return result;
    }

    private List<WebElement> getVisibleWebElements(By by) {
        return new WebDriverWait(this.getWebDriver(),
                getApplication().getApplicationSources().getExplicitTimeOut())
            .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
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
    
    @Override
    public  WebElement partialLinkText(String partialLinkText) {
    	return getVisibleWebElement(By.partialLinkText(partialLinkText));
    }
    
    @Override
    public  WebElement linkText(String linkText) {
    	return getVisibleWebElement(By.linkText(linkText));
    }

    @Override
    public  WebElement id(String id, WebElement fromWebElement) {
        return getVisibleWebElement(By.id(id), fromWebElement);
    }

    @Override
    public List<WebElement> names(String name) {
        return getVisibleWebElements(By.name(name));
    }

}

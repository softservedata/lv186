package com.softserve.edu.magento.tools;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.google.common.base.Predicate;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class ASearch {

    private static final String TAKES_SCREENSHOT_ERROR = "TakesScreenshot Save File Error";
    //added timeouts.
    protected static final long IMPLICIT_WAIT_TIMEOUT = 5L;
    protected static final long EXPLICIT_WAIT_TIMEOUT = 10L;

    //removed Application from constructor params.
    public ASearch() {
    }
    //remove Application from method params
    WebDriver getWebDriver() {
        return Application.getWebDriver();
    }

    public void takeScreenShort(String fileName) {
        File scrFile = ((TakesScreenshot)getWebDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(fileName));
        } catch (IOException e) {
            // TODO Develop Custom Exception
            //e.printStackTrace();
            throw new RuntimeException(TAKES_SCREENSHOT_ERROR);
        }
    }
    
    public abstract WebElement id(String id);

    public abstract WebElement name(String name);

    public abstract WebElement xpath(String xpath);

    public abstract WebElement cssSelector(String cssSelector);

    public abstract WebElement className(String className);
    
    public abstract WebElement partialLinkText(String partialLinkText);
    
    public abstract WebElement linkText(String linkText);
    
    public abstract WebElement tagName(String tagName);

    // From Elements
    
    public abstract WebElement id(String id, WebElement fromWebElement);
    
    public abstract WebElement name(String name, WebElement fromWebElement);

    public abstract WebElement xpath(String xpath, WebElement fromWebElement);

    public abstract WebElement cssSelector(String cssSelector, WebElement fromWebElement);

    public abstract WebElement className(String className, WebElement fromWebElement);
    
    public abstract WebElement partialLinkText(String partialLinkText, WebElement fromWebElement);
    
    public abstract WebElement linkText(String linkText, WebElement fromWebElement);
    
    public abstract WebElement tagName(String tagName, WebElement fromWebElement);
    
    // List
    
    public abstract List<WebElement> ids(String id);
    
    public abstract List<WebElement> names(String name);

    public abstract List<WebElement> xpaths(String xpath);

    public abstract List<WebElement> xpaths(String xpath, WebElement fromWebElement);

    public abstract List<WebElement> cssSelectors(String cssSelector);

    public abstract List<WebElement> classNames(String className);
    
    public abstract List<WebElement> partialLinkTexts(String partialLinkText);
    
    public abstract List<WebElement> linkTexts(String linkText);
    
    public abstract List<WebElement> tagNames(String tagName);

    public void waitUntil(Predicate<WebDriver> predicate) {
        new WebDriverWait(getWebDriver(), 10).until(predicate);
    }

    public  boolean stalenessOf(WebElement webElement){
        return new WebDriverWait(this.getWebDriver(), DISAPPEAR_WAIT_TIMEOUT)
                .until(ExpectedConditions.stalenessOf(webElement));
    }

    public  WebElement elementClickable(WebElement webElement){
        return new WebDriverWait(this.getWebDriver(), DISAPPEAR_WAIT_TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

}

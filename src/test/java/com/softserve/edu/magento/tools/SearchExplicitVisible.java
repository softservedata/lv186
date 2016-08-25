package com.softserve.edu.magento.tools;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class for searching present elements with
 * explicit timeout.
 */
public class SearchExplicitVisible extends ASearch {

    public SearchExplicitVisible() {
        getWebDriver().manage().timeouts().implicitlyWait(0L, TimeUnit.SECONDS);
    }

    /**
     * Method to explicitly wait for visibility of
     * specific element.
     * @param by locator for element.
     * @return
     *       present webelement.
     */
    private WebElement getVisibleWebElement(By by) {
        return new WebDriverWait(this.getWebDriver(), EXPLICIT_WAIT_TIMEOUT)
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
          getWebDriver().manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
          result = fromWebElement.findElement(by); 
          getWebDriver().manage().timeouts().implicitlyWait(0L, TimeUnit.SECONDS);
          return result;
    }

    /**
     * Method to explicitly wait for visibility of
     * specific elements.
     * @param by locator for elements.
     * @return
     *       present webelements.
     */
    private List<WebElement> getVisibleWebElements(By by) {
        return new WebDriverWait(this.getWebDriver(), EXPLICIT_WAIT_TIMEOUT)
            .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    /*
   Methods, used by Search entity.
    */
    //Element
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
    public  WebElement tagName(String tagName) {
    	return getVisibleWebElement(By.tagName(tagName));
    }

// From Elements

    @Override
    public  WebElement id(String id, WebElement fromWebElement) {
    	return getVisibleWebElement(By.id(id), fromWebElement);
    }

    @Override
    public  WebElement name(String name, WebElement fromWebElement) {
    	return getVisibleWebElement(By.name(name), fromWebElement);
    }

    @Override
    public  WebElement xpath(String xpath, WebElement fromWebElement) {
    	return getVisibleWebElement(By.xpath(xpath), fromWebElement);
    }
    @Override
    public  WebElement cssSelector(String cssSelector, WebElement fromWebElement) {
    	return getVisibleWebElement(By.cssSelector(cssSelector), fromWebElement);
    }
    @Override
    public  WebElement className(String className, WebElement fromWebElement) {
    	return getVisibleWebElement(By.className(className), fromWebElement);
    }
    @Override
    public  WebElement partialLinkText(String partialLinkText, WebElement fromWebElement) {
    	return getVisibleWebElement(By.partialLinkText(partialLinkText), fromWebElement);
    }
    @Override
    public  WebElement linkText(String linkText, WebElement fromWebElement) {
    	return getVisibleWebElement(By.linkText(linkText), fromWebElement);
    }

    @Override
    public  WebElement tagName(String tagName, WebElement fromWebElement) {
    	return getVisibleWebElement(By.tagName(tagName),fromWebElement);
    }

 // List

    @Override
    public  List<WebElement> ids(String id) {
    	 return getVisibleWebElements(By.id(id));
    }

    @Override
    public List<WebElement> names(String name) {
    	 return getVisibleWebElements(By.name(name));
    }

    @Override
    public  List<WebElement> xpaths(String xpath) {
    	 return getVisibleWebElements(By.xpath(xpath));
    }

    @Override
    public List<WebElement> xpaths(String xpath, WebElement fromWebElement) {
        return null;
    }

    @Override
    public  List<WebElement> cssSelectors(String cssSelector) {
    	 return getVisibleWebElements(By.cssSelector(cssSelector));
    }

    @Override
    public  List<WebElement> classNames(String className) {
    	 return getVisibleWebElements(By.className(className));
    }

    @Override
    public  List<WebElement> partialLinkTexts(String partialLinkText) {
    	 return getVisibleWebElements(By.partialLinkText(partialLinkText));
    }

    @Override
    public  List<WebElement> linkTexts(String linkText) {
    	 return getVisibleWebElements(By.linkText(linkText));
    }

    @Override
    public  List<WebElement> tagNames(String tagName) {
    	return getVisibleWebElements(By.tagName(tagName));
    }

}

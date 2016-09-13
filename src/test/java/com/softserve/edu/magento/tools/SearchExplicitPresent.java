package com.softserve.edu.magento.tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Class for searching present elements with
 * explicit timeout.
 */
public class SearchExplicitPresent extends ASearch {

    public SearchExplicitPresent() {
        getWebDriver().manage().timeouts().implicitlyWait(0L, TimeUnit.SECONDS);
    }

    /**
     * Method to explicitly wait for presence of
     * specific element.
     *
     * @param by locator for element.
     * @return present webelement.
     */
    private WebElement getPresentWebElement(By by) {
        return new WebDriverWait(this.getWebDriver(), EXPLICIT_WAIT_TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    // Must be Selenium version 2.53.1
//    private WebElement getVisibleWebElement(By by, WebElement fromWebElement) {
//        return new WebDriverWait(this.getWebDriver(),
//                getApplication().getApplicationSources().getExplicitTimeOut())
//            .until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(fromWebElement, by)).get(0);
//    }

    // TODO
    private WebElement getPresentWebElement(By by, WebElement fromWebElement) {
        WebElement result;
        getWebDriver().manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        result = fromWebElement.findElement(by);
        getWebDriver().manage().timeouts().implicitlyWait(0L, TimeUnit.SECONDS);
        return result;
    }

    /**
     * Method to explicitly wait for presence of
     * specific elements.
     *
     * @param by locator for elements.
     * @return present webelements.
     */
    private List<WebElement> getPresentWebElements(By by) {
        return new WebDriverWait(this.getWebDriver(), EXPLICIT_WAIT_TIMEOUT)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    /*
    Methods, used by Search entity.
     */
    //Element
    @Override
    public WebElement id(String id) {
        return getPresentWebElement(By.id(id));
    }

    @Override
    public WebElement name(String name) {
        return getPresentWebElement(By.name(name));
    }

    @Override
    public WebElement xpath(String xpath) {
        return getPresentWebElement(By.xpath(xpath));
    }

    @Override
    public WebElement cssSelector(String cssSelector) {
        return getPresentWebElement(By.cssSelector(cssSelector));
    }


    @Override
    public WebElement className(String className) {
        return getPresentWebElement(By.className(className));
    }

    @Override
    public WebElement partialLinkText(String partialLinkText) {
        return getPresentWebElement(By.partialLinkText(partialLinkText));
    }

    @Override
    public WebElement linkText(String linkText) {
        return getPresentWebElement(By.linkText(linkText));
    }

    @Override
    public WebElement tagName(String tagName) {
        return getPresentWebElement(By.tagName(tagName));
    }

// From Elements

    @Override
    public WebElement id(String id, WebElement fromWebElement) {
        return getPresentWebElement(By.id(id), fromWebElement);
    }

    @Override
    public WebElement name(String name, WebElement fromWebElement) {
        return getPresentWebElement(By.name(name), fromWebElement);
    }

    @Override
    public WebElement xpath(String xpath, WebElement fromWebElement) {
        return getPresentWebElement(By.xpath(xpath), fromWebElement);
    }

    @Override
    public WebElement cssSelector(String cssSelector, WebElement fromWebElement) {
        return getPresentWebElement(By.cssSelector(cssSelector), fromWebElement);
    }

    @Override
    public WebElement className(String className, WebElement fromWebElement) {
        return getPresentWebElement(By.className(className), fromWebElement);
    }

    @Override
    public WebElement partialLinkText(String partialLinkText, WebElement fromWebElement) {
        return getPresentWebElement(By.partialLinkText(partialLinkText), fromWebElement);
    }

    @Override
    public WebElement linkText(String linkText, WebElement fromWebElement) {
        return getPresentWebElement(By.linkText(linkText), fromWebElement);
    }

    @Override
    public WebElement tagName(String tagName, WebElement fromWebElement) {
        return getPresentWebElement(By.tagName(tagName), fromWebElement);
    }

    // List

    @Override
    public List<WebElement> ids(String id) {
        return getPresentWebElements(By.id(id));
    }

    @Override
    public List<WebElement> names(String name) {
        return getPresentWebElements(By.name(name));
    }

    @Override
    public List<WebElement> xpaths(String xpath) {
        return getPresentWebElements(By.xpath(xpath));
    }

    @Override
    public List<WebElement> cssSelectors(String cssSelector) {
        return getPresentWebElements(By.cssSelector(cssSelector));
    }

    @Override
    public List<WebElement> classNames(String className) {
        return getPresentWebElements(By.className(className));
    }

    @Override
    public List<WebElement> partialLinkTexts(String partialLinkText) {
        return getPresentWebElements(By.partialLinkText(partialLinkText));
    }

    @Override
    public List<WebElement> linkTexts(String linkText) {
        return getPresentWebElements(By.linkText(linkText));
    }

    @Override
    public List<WebElement> tagNames(String tagName) {
        return getPresentWebElements(By.tagName(tagName));
    }

    @Override
    public List<WebElement> xpaths(String xpath, WebElement fromWebElement) {
        return null;
    }

    @Override
    public List<WebElement> tagNames(String tagName, WebElement fromWebElement) {
        return null;
    }

}

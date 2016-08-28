package com.softserve.edu.magento.tools;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class for searching visible elements with
 * implicit timeout.
 */
public class SearchImplicit extends ASearch {

    public SearchImplicit() {
        getWebDriver().manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        // TODO setup waits
        getWebDriver().manage().timeouts().pageLoadTimeout(30L, TimeUnit.SECONDS);
        getWebDriver().manage().timeouts().setScriptTimeout(30L, TimeUnit.SECONDS);
        //System.out.println("***SearchImplicit");
    }

    /**
     * Method to implicitly wait for visibility of
     * specific element.
     *
     * @param by locator for element.
     * @return visible webelement.
     */
    private WebElement getWebElement(By by) {

        return this.getWebDriver().findElement(by);
    }

    /**
     * Method to implicitly wait for visibility of
     * specific element, located from already
     * located webelement.
     *
     * @param by             locator for element.
     * @param fromWebElement located webelement to start
     *                       searching from.
     * @return visible webelement.
     */
    private WebElement getWebElement(By by, WebElement fromWebElement) {
        return fromWebElement.findElement(by);
    }

    /**
     * Method to implicitly wait for visibility of
     * specific elements.
     *
     * @param by locator for elements.
     * @return visible webelements.
     */
    private List<WebElement> getWebElements(By by) {
        return this.getWebDriver().findElements(by);
    }

    /*
   Methods, used by Search entity.
    */
    //Element
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
    public boolean stalenessOf(WebElement webElement) {
        return new WebDriverWait(this.getWebDriver(), EXPLICIT_WAIT_TIMEOUT)
                .until(ExpectedConditions.stalenessOf(webElement));
    }

    @Override
    public WebElement className(String className) {
        return getWebElement(By.className(className));
    }

    @Override
    public WebElement partialLinkText(String partialLinkText) {
        return getWebElement(By.partialLinkText(partialLinkText));
    }

    @Override
    public WebElement linkText(String linkText) {
        return getWebElement(By.linkText(linkText));
    }

    @Override
    public WebElement tagName(String tagName) {
        return getWebElement(By.tagName(tagName));
    }

    // From Elements

    @Override
    public WebElement id(String id, WebElement fromWebElement) {
        return getWebElement(By.id(id), fromWebElement);
    }

    @Override
    public WebElement name(String name, WebElement fromWebElement) {
        return getWebElement(By.name(name), fromWebElement);
    }

    @Override
    public WebElement xpath(String xpath, WebElement fromWebElement) {
        return getWebElement(By.xpath(xpath), fromWebElement);
    }

    @Override
    public WebElement cssSelector(String cssSelector, WebElement fromWebElement) {
        return getWebElement(By.cssSelector(cssSelector), fromWebElement);
    }

    @Override
    public WebElement className(String className, WebElement fromWebElement) {
        return getWebElement(By.className(className), fromWebElement);
    }

    @Override
    public WebElement partialLinkText(String partialLinkText, WebElement fromWebElement) {
        return getWebElement(By.partialLinkText(partialLinkText), fromWebElement);
    }

    @Override
    public WebElement linkText(String linkText, WebElement fromWebElement) {
        return getWebElement(By.linkText(linkText), fromWebElement);
    }

    @Override
    public WebElement tagName(String tagName, WebElement fromWebElement) {
        return getWebElement(By.tagName(tagName), fromWebElement);
    }

    // List

    @Override
    public List<WebElement> ids(String id) {
        return getWebElements(By.id(id));
    }

    @Override
    public List<WebElement> names(String name) {
        return getWebElements(By.name(name));
    }

    @Override
    public List<WebElement> xpaths(String xpath) {
        return getWebElements(By.xpath(xpath));
    }

    @Override
    public List<WebElement> xpaths(String xpath, WebElement fromWebElement) {
        return null;
    }

    @Override
    public List<WebElement> cssSelectors(String cssSelector) {
        return getWebElements(By.cssSelector(cssSelector));
    }

    @Override
    public List<WebElement> classNames(String className) {
        return getWebElements(By.className(className));
    }

    @Override
    public List<WebElement> partialLinkTexts(String partialLinkText) {
        return getWebElements(By.partialLinkText(partialLinkText));
    }

    @Override
    public List<WebElement> linkTexts(String linkText) {
        return getWebElements(By.linkText(linkText));
    }

    @Override
    public List<WebElement> tagNames(String tagName) {
        return getWebElements(By.tagName(tagName));
    }

}

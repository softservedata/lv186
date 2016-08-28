package com.softserve.edu.magento.tools;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

interface ISearchStrategy {
    ASearch getStrategy();
}

public class Search {

    static class ImplicitStrategy implements ISearchStrategy {
        public ASearch getStrategy() {
            return new SearchImplicit();
        }
    }

    static class ExplicitStrategyVisible implements ISearchStrategy {
        public ASearch getStrategy() {
            return new SearchExplicitVisible();
        }
    }

    static class ExplicitStrategyPresent implements ISearchStrategy {
        public ASearch getStrategy() {
            return new SearchExplicitPresent();
        }
    }

    static class ExplicitStrategyClickable implements ISearchStrategy {
        public ASearch getStrategy() {
            return new SearchExplicitClickable();
        }
    }

    public static enum SearchStrategyList {
        IMPLICIT_STRATEGY(new ImplicitStrategy(), "SearchImplicitStrategy"),
        EXPLICIT_STRATEGY_VISIBLE(new ExplicitStrategyVisible(), "SearchExplicitStrategyVisible"),
        EXPLICIT_STRATEGY_PRESENT(new ExplicitStrategyPresent(), "SearchExplicitStrategyPresent"),
        EXPLICIT_STRATEGY_CLICKABLE(new ExplicitStrategyClickable(), "SearchExplicitStrategyClickable");
        private ISearchStrategy searchStrategy;
        private String searchStrategyName;

        private SearchStrategyList(ISearchStrategy searchStrategy, String searchStrategyName) {
            this.searchStrategy = searchStrategy;
            this.searchStrategyName = searchStrategyName;
        }

        public ASearch getSearchStrategy() {
            return searchStrategy.getStrategy();
        }

        @Override
        public String toString() {
            return searchStrategyName;
        }
    }

    // Fields

    private static final String STRATEGY_NOT_FOUND = "SearchRecords Strategy not Found";
    private static Search instance;
    private ASearch search;

//    public SearchRecords() {
//        search = new SearchImplicit();
//    }

    private Search(ASearch search) {
        this.search = search;
    }

    // Static Factory
    public static void setStrategy(ASearch search) {
        instance = new Search(search);
    }

    private static Search getinstance() {
        if (instance == null) {
            throw new RuntimeException(STRATEGY_NOT_FOUND);
        }
        return instance;
    }

    private ASearch getSearch() {
        return this.search;
    }

    public static void takeScreenShort(String fileName) {
        getinstance().getSearch().takeScreenShort(fileName);
    }

    public static WebElement id(String id) {
        return getinstance().getSearch().id(id);
    }

    public static WebElement name(String name) {
        return getinstance().getSearch().name(name);
    }

    public static WebElement xpath(String xpath) {
        return getinstance().getSearch().xpath(xpath);
    }

    public static WebElement cssSelector(String cssSelector) {
        return getinstance().getSearch().cssSelector(cssSelector);
    }

    public static boolean stalenessOf(WebElement webElement) {
        return getinstance().getSearch().stalenessOf(webElement);
    }

    public static WebElement className(String className) {
        return getinstance().getSearch().className(className);
    }

    public static WebElement partialLinkText(String partialLinkText) {
        return getinstance().getSearch().partialLinkText(partialLinkText);
    }

    public static WebElement linkText(String linkText) {
        return getinstance().getSearch().linkText(linkText);
    }

    public static WebElement tagName(String tagName) {
        return getinstance().getSearch().tagName(tagName);
    }

    // From Elements

    public static WebElement id(String id, WebElement fromWebElement) {
        return getinstance().getSearch().id(id, fromWebElement);
    }

    public static WebElement name(String name, WebElement fromWebElement) {
        return getinstance().getSearch().name(name, fromWebElement);
    }

    public static WebElement xpath(String xpath, WebElement fromWebElement) {
        return getinstance().getSearch().xpath(xpath, fromWebElement);
    }

    public static WebElement cssSelector(String cssSelector, WebElement fromWebElement) {
        return getinstance().getSearch().cssSelector(cssSelector, fromWebElement);
    }

    public static WebElement className(String className, WebElement fromWebElement) {
        return getinstance().getSearch().className(className, fromWebElement);
    }

    public static WebElement partialLinkText(String partialLinkText, WebElement fromWebElement) {
        return getinstance().getSearch().partialLinkText(partialLinkText, fromWebElement);
    }

    public static WebElement linkText(String linkText, WebElement fromWebElement) {
        return getinstance().getSearch().linkText(linkText, fromWebElement);
    }

    public static WebElement tagName(String tagName, WebElement fromWebElement) {
        return getinstance().getSearch().tagName(tagName, fromWebElement);
    }

    // List

    public static List<WebElement> ids(String id) {
        return getinstance().getSearch().ids(id);
    }

    public static List<WebElement> names(String name) {
        return getinstance().getSearch().names(name);
    }

    public static List<WebElement> xpaths(String xpath) {
        return getinstance().getSearch().xpaths(xpath);
    }

    public static List<WebElement> xpaths(String xpath, WebElement fromWebElement) {
        return getinstance().getSearch().xpaths(xpath, fromWebElement);
    }

    public static List<WebElement> cssSelectors(String cssSelector) {
        return getinstance().getSearch().cssSelectors(cssSelector);
    }

    public static List<WebElement> classNames(String className) {
        return getinstance().getSearch().classNames(className);
    }

    public static List<WebElement> partialLinkTexts(String partialLinkText) {
        return getinstance().getSearch().partialLinkTexts(partialLinkText);
    }

    public static List<WebElement> linkTexts(String linkText) {
        return getinstance().getSearch().linkTexts(linkText);
    }

    public static List<WebElement> tagNames(String tagName) {
        return getinstance().getSearch().tagNames(tagName);
    }

    public static void waitUntil(Predicate<WebDriver> predicate) {
        getinstance().getSearch().waitUntil(predicate);
    }

    public static boolean checkDOMForText(String text) {
        return getinstance().getSearch().checkDOMForText(text);
    }

    public static void moveToElement(WebElement webElement) {
        getinstance().getSearch().moveToElement(webElement);
    }

    public static void clickElement(WebElement webElement) {
        getinstance().getSearch().clickElement(webElement);
    }
}

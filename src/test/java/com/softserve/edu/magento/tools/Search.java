package com.softserve.edu.magento.tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

interface ISearchStrategy {
    ASearch getStrategy(Application<?> application);
}

public class Search {

    static class ImplicitStrategy implements ISearchStrategy {
        public ASearch getStrategy(Application<?> application) {
            return new SearchImplicit(application);
        }
    }

    static class ExplicitStrategy implements ISearchStrategy {
        public ASearch getStrategy(Application<?> application) {
            return new SearchExplicit(application);
        }
    }

    public static enum SearchStrategyList {
        IMPLICIT_STRATEGY(new ImplicitStrategy(), "SearchImplicitStrategy"),
        EXPLICIT_STRATEGY(new ExplicitStrategy(), "SearchExplicitStrategy");
        private ISearchStrategy searchStrategy;
        private String searchStrategyName;

        private SearchStrategyList(ISearchStrategy searchStrategy, String searchStrategyName) {
            this.searchStrategy = searchStrategy;
            this.searchStrategyName = searchStrategyName;
        }

        public ASearch getSearchStrategy(Application<?> application) {
            return searchStrategy.getStrategy(application);
        }

        @Override
        public String toString() {
            return searchStrategyName;
        }
    }

    // Fields

    private static final String STRATEGY_NOT_FOUND = "Search Strategy not Found";
    private static Search instance;
    private ASearch search;

//    public Search() {
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

    public static WebElement className(String className) {
        return getinstance().getSearch().className(className);
    }
    
    public static WebElement partialLinkText(String partialLinkText) {
    	return getinstance().getSearch().partialLinkText(partialLinkText);
    }
    
    public  static WebElement linkText(String linkText) {
    	return getinstance().getSearch().linkText(linkText);
    }

}

package com.softserve.edu.magento.tools;

import org.openqa.selenium.WebElement;

public class Search {

    private static ASearch search;

//    public Search() {
//        search = new SearchImplicit();
//    }
    
//    public Search(ASearch search) {
//        this.search = search;
//    }
    
    public static void setStrategy(ASearch search) {
        Search.search = search;
    }
    
    public static WebElement id(String id) {
        return search.id(id);
    } 
    
    public static WebElement name(String name) {
        return search.name(name);
    } 

    public static WebElement xpath(String xpath) {
        return search.xpath(xpath);
    } 

    public static WebElement cssSelector(String cssSelector) {
        return search.cssSelector(cssSelector);
    } 

    public static WebElement className(String className) {
        return search.className(className);
    } 

}

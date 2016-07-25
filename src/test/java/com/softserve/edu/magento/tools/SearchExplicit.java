package com.softserve.edu.magento.tools;

import org.openqa.selenium.WebElement;

public class SearchExplicit extends ASearch {

    public SearchExplicit(Application<?> application) {
        super(application);
    }
    
    @Override
    public WebElement id(String id) {
        return null;
    }

    @Override
    public WebElement name(String id) {
        return null;
    }

    @Override
    public WebElement xpath(String id) {
        return null;
    }

    @Override
    public WebElement cssSelector(String id) {
        return null;
    }

    @Override
    public WebElement className(String id) {
        return null;
    }

}

package com.softserve.edu.magento.tools;

import org.openqa.selenium.WebElement;

public class SearchImplicit extends ASearch {

    public SearchImplicit(Application<?> application) {
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

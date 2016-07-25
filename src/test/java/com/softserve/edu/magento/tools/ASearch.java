package com.softserve.edu.magento.tools;

import org.openqa.selenium.WebElement;

public abstract class ASearch {

    Application<?> application;

    public ASearch(Application<?> application) {
        this.application = application;
    }

    public abstract WebElement id(String id);

    public abstract WebElement name(String id);

    public abstract WebElement xpath(String id);

    public abstract WebElement cssSelector(String id);

    public abstract WebElement className(String id);

}

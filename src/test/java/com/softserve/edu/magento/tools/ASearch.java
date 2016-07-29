package com.softserve.edu.magento.tools;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class ASearch {

    private static final String TAKES_SCREENSHOT_ERROR = "TakesScreenshot Save File Error";
    private Application<?> application;

    public ASearch(Application<?> application) {
        this.application = application;
    }

    Application<?> getApplication() {
        return application;
    }

    WebDriver getWebDriver() {
        return application.getWebDriver();
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

    // From Elements
    
    public abstract WebElement id(String id, WebElement fromWebElement);
    
    // List
    
    public abstract List<WebElement> names(String name);

    //public abstract List<WebElement> xpaths(String xpath);

}

package com.softserve.edu.magento.tools;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.softserve.edu.magento.data.ApplicationSources;
import com.softserve.edu.magento.tools.BrowserRepository.BrowsersList;

public abstract class Application<TStartPage> {
    protected static final HashMap<Long, WebDriver> drivers = new HashMap<Long, WebDriver>();
    //
    private ApplicationSources applicationSources;

    protected Application(ApplicationSources applicationSources) {
        this.applicationSources = applicationSources;
        this.startBrowser();
    }
   
//    public static Application get(ApplicationSources applicationSources) {
//        Application instance = new Application(applicationSources);
//        return instance;
//    }

    protected abstract TStartPage getStartPage(WebDriver driver);

    private void startBrowser(){
        if (getWebDriver() == null) {
            WebDriver driver = null;
            for (BrowsersList browser : BrowsersList.values()) {
                if (browser.toString().toLowerCase()
                        .contains(applicationSources.getBrowserName().toLowerCase())) {
                    driver = browser.getWebDriver(applicationSources.getDriverPath());
                    break;
                }
            }
            if (driver == null) {
                driver = BrowsersList.FIREFOX_DEFAULT.getWebDriver(null);
            }
            driver.manage().timeouts().implicitlyWait(applicationSources.getImplicitTimeOut(), TimeUnit.SECONDS);
            // TODO setup waits
            //driver.manage().timeouts().pageLoadTimeout(30L, TimeUnit.SECONDS);
            //driver.manage().timeouts().setScriptTimeout(30L, TimeUnit.SECONDS);
            drivers.put(Thread.currentThread().getId(), driver);
        }
    }
    
    protected WebDriver getWebDriver() {
        return drivers.get(Thread.currentThread().getId());
    }

    public ApplicationSources getApplicationSources() {
        return this.applicationSources;
    }

    public TStartPage load() {
        //System.out.println("+++applicationSources.getLoadUrl() = "+applicationSources.getLoadUrl());
        getWebDriver().get(applicationSources.getLoadUrl());
        return getStartPage(getWebDriver());
    }

    public TStartPage logout() {
        TStartPage result = null;
        if ((getWebDriver() != null) 
                && (applicationSources.getLogoutUrl() != null)
                && (!applicationSources.getLogoutUrl().isEmpty())) {
            getWebDriver().get(applicationSources.getLogoutUrl());
            result = getStartPage(getWebDriver());
        }
        return result;
    }

    public void close() {
        if (getWebDriver() != null) {
            getWebDriver().close();
            drivers.put(Thread.currentThread().getId(), null);
        }
    }

    public void quit() {
        if (getWebDriver() != null) {
            getWebDriver().quit();
            drivers.put(Thread.currentThread().getId(), null);
        }
    }

    public static void quitAll() {
        for (Long threadId : drivers.keySet()) {
            if (drivers.get(threadId) != null) {
                drivers.get(threadId).quit();
                drivers.put(threadId, null);
            }
        }
    }

}
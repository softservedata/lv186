package com.softserve.edu.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.ITestContext;

import com.softserve.edu.tools.IBrowser.BrowsersList;

public class BrowserManager {
    private static final String SUREFIRE_WEBDRIVER_NAME = "surefire.webdriver.name";
    //
    private static volatile BrowserManager instance = null;

    private BrowserManager() {
    }

    public static BrowserManager get() {
        if (instance == null) {
            synchronized (BrowserManager.class) {
                if (instance == null) {
                    instance = new BrowserManager();
                }
            }
        }
        return instance;
    }
    
    private BrowsersList getBrowserByString(String name) {
        BrowsersList result = null;
        for (BrowsersList browser : BrowsersList.values()) {
            if (browser.toString().toLowerCase().contains(name.toLowerCase())) {
                result = browser;
                System.out.println("getBrowserByString resultname = "+ result.toString());
                break;
            }
        }
        return result;
    }
    
    public BrowsersList prepareBrowserFromPOM() {
        BrowsersList result = null;
        if (System.getProperty(SUREFIRE_WEBDRIVER_NAME) != null) {
            result = getBrowserByString(System.getProperty(SUREFIRE_WEBDRIVER_NAME));
        }
        return result;
    }
    
    public List<BrowsersList> prepareBrowserFromTestNGAll(ITestContext context) {
        BrowsersList browser;
        List<BrowsersList> browsers = new ArrayList<BrowsersList>();
        HashMap<String, String> allParameters = new HashMap<String, String>(
                context.getCurrentXmlTest().getAllParameters());
        for (String key : allParameters.keySet()) {
            //System.out.println("*** parameter: key=" + key + " value=" + allParameters.get(key));
            browser = getBrowserByString(allParameters.get(key));
            if (browser != null) {
                browsers.add(browser);
            }
        }
        return browsers;
    }

    public List<BrowsersList> prepareBrowser(ITestContext context) {
        BrowsersList browser;
        List<BrowsersList> browsers = new ArrayList<BrowsersList>();
        browser = prepareBrowserFromPOM();
        if (browser != null) {
            browsers.add(browser);
            if (browser == BrowsersList.HTMLUNIT_TEMPORARY) {
                return browsers;
            }
        }
        browsers.addAll(prepareBrowserFromTestNGAll(context));
        if (browsers.size() == 0) {
            System.out.println("Adding BrowsersList.FIREFOX_TEMPORARY");
            browsers.add(BrowsersList.FIREFOX_TEMPORARY);
        }
        return browsers;
    }
    
}

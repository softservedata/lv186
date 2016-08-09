package com.softserve.edu.magento.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

interface IBrowser {
    WebDriver getBrowser(String driverPath);
}
    
public class BrowserRepository {

    static class FirefoxTemporary implements IBrowser {
        public WebDriver getBrowser(String driverPath) {
            return new FirefoxDriver();
        }
    }

    static class ChromeTemporary implements IBrowser {
        public WebDriver getBrowser(String driverPath) {
            System.setProperty("webdriver.chrome.driver", driverPath);
            return new ChromeDriver();
        }
    }

    static class IETemporary implements IBrowser {
        public WebDriver getBrowser(String driverPath) {
            System.setProperty("webdriver.ie.driver", driverPath);
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            return new InternetExplorerDriver(capabilities);
        }
    }

    static class HtmlUnitTemporary implements IBrowser {
        public WebDriver getBrowser(String driverPath) {
            WebDriver driver = new HtmlUnitDriver(true);
            driver.manage().window().maximize();
            // TODO detele
            System.out.println("HtmlUnitDriver = " + driver);
            ((HtmlUnitDriver) driver).setJavascriptEnabled(true);
            // TODO set CSS Enables
            return driver;
        }
    }

    static class PhantomJSTemporary implements IBrowser {
        public WebDriver getBrowser(String driverPath) {
            // TODO detele
            System.out.println("\t+++PhantomJSTemporary START");
            System.setProperty("phantomjs.binary.path", driverPath);
            // TODO Develop Modules
            WebDriver driver =new PhantomJSDriver();
            driver.manage().window().maximize();
            //return new PhantomJSDriver();
//            WebDriver driver = new HtmlUnitDriver(true);
//            ((HtmlUnitDriver) driver).setJavascriptEnabled(true);
//            // TODO set CSS Enables
            return driver;
        }
    }

    public static enum BrowsersList {
        FIREFOX_TEMPORARY(new FirefoxTemporary(), "FirefoxDriverTemporary"),
        FIREFOX_DEFAULT(new FirefoxTemporary(), "FirefoxDriverDefault"),
        IE_TEMPORARY(new IETemporary(), "InternetExplorerDriver"),
        CHROME_TEMPORARY(new ChromeTemporary(), "ChromeDriverTemporary"),
        HTMLUNIT_TEMPORARY(new HtmlUnitTemporary(), "HtmlUnitDriver"),
        PHANTOMJS_TEMPORARY(new PhantomJSTemporary(), "PhantomJSTemporary");
        private IBrowser browser;
        private String browserName;

        private BrowsersList(IBrowser browser, String browserName) {
            this.browser = browser;
            this.browserName = browserName;
        }

        public WebDriver getWebDriver(String driverPath) {
            return browser.getBrowser(driverPath);
        }

        @Override
        public String toString() {
            return browserName;
        }
    }
   
}

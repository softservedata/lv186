package com.softserve.edu.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface IBrowser {
    
    class FirefoxTemporary implements IBrowser {
        public WebDriver getBrowser() {
            return new FirefoxDriver();
        }
    }

    class ChromeTemporary implements IBrowser {
        public WebDriver getBrowser() {
            System.setProperty("webdriver.chrome.driver",
                    "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
            return new ChromeDriver();
        }
    }

    class IETemporary implements IBrowser {
        public WebDriver getBrowser() {
            System.setProperty("webdriver.ie.driver",
                    "C:\\Program Files\\Internet Explorer\\IEDriverServer.exe");
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            return new InternetExplorerDriver(capabilities);
        }
    }

    class HtmlUnitTemporary implements IBrowser {
        public WebDriver getBrowser() {
            WebDriver driver = new HtmlUnitDriver(true);
            if (driver == null) {
                System.out.println("HtmlUnitDriver == null");
            } else {
                System.out.println("HtmlUnitDriver Ok");
            }
            System.out.println("HtmlUnitDriver = "+driver);
            ((HtmlUnitDriver) driver).setJavascriptEnabled(true);
            System.out.println("HtmlUnitDriver setJavascriptEnabled(true) DONE");
            // TODO set CSS Enables
            return driver;
        }
    }

    public static enum BrowsersList {
        FIREFOX_TEMPORARY(new FirefoxTemporary(), "FirefoxDriverTemporary"),
        FIREFOX_DEFAULT(new FirefoxTemporary(), "FirefoxDriverDefault"),
        IE_TEMPORARY(new IETemporary(), "InternetExplorerDriver"),
        CHROME_TEMPORARY(new ChromeTemporary(), "ChromeDriverTemporary"),
        HTMLUNIT_TEMPORARY(new HtmlUnitTemporary(), "HtmlUnitDriver");
        private IBrowser browser;
        private String browserName;

        private BrowsersList(IBrowser browser, String browserName) {
            this.browser = browser;
            this.browserName = browserName;
        }

        public WebDriver getWebDriver() {
            return browser.getBrowser();
        }

        @Override
        public String toString() {
            return browserName;
        }
    }

    WebDriver getBrowser();
    
}

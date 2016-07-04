package edu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface IBrowser {
    
    class FirefoxTemporary implements IBrowser {
        public WebDriver getBrowser() {
            return new FirefoxDriver();
        }
    }

    class ChromeTemporary implements IBrowser {
        public WebDriver getBrowser() {
            
        	System.setProperty("webdriver.chrome.driver" , 
        			"/Applications/Google Chrome.app/Contents/chromedriver");
        	//System.setProperty("webdriver.chrome.driver",
					//"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        	
            return new ChromeDriver();
        }
    }

    public static enum BrowsersList {
        FIREFOX_TEMPORARY(new FirefoxTemporary(), "firefox_Temporary"),
        FIREFOX_DEFAULT(new FirefoxTemporary(), "firefox_Default"),
        SAFARI_TEMPORARY(new FirefoxTemporary(), "IE_Temporary"),
        CHROME_TEMPORARY(new ChromeTemporary(), "Chrome_Temporary");
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

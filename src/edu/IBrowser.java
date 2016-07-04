package edu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface IBrowser {
    
    class FirefoxTemporary implements IBrowser {
        public WebDriver getBrowser() {
        	WebDriver driver = new FirefoxDriver();
        	
        	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
      	  	driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
      	  	
            return driver;
        }
    }

    class ChromeTemporary implements IBrowser {
        public WebDriver getBrowser() {
            
        	System.setProperty("webdriver.chrome.driver" , 
        			"/Applications/Google Chrome.app/Contents/chromedriver");
        	//System.setProperty("webdriver.chrome.driver",
					//"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        	WebDriver driver = new ChromeDriver();
        	
        	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
      	    driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
      	    
            return driver;
        }
    }

    public static enum BrowsersList {
        FIREFOX_TEMPORARY(new FirefoxTemporary(), "firefox_Temporary"),
        FIREFOX_DEFAULT(new FirefoxTemporary(), "firefox_Default"),
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

package com.softserve.edu.TestFieldsInApp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

public interface IBrowser {

	WebDriver getBrowser();

	class FirefoxTemporary implements IBrowser {
		public WebDriver getBrowser() {
			// return new FirefoxDriver();
			WebDriver driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
			return driver;
		}
	}

	class ChromeTemporary implements IBrowser {
		public WebDriver getBrowser() {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
			// return new ChromeDriver();
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
			return driver;
		}
	}

	class IExplorerTemporary implements IBrowser {
		public WebDriver getBrowser() {
			System.setProperty("webdriver.ie.driver", "C:\\Program Files (x86)\\Internet Explorer\\IEDriverServer.exe");
			// return new InternetExplorerDriver();
			WebDriver driver = new InternetExplorerDriver();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
			return driver;
		}

	}

	public static enum BrowsersList {
		FIREFOX_TEMPORARY(new FirefoxTemporary(), "firefox_Temporary"), FIREFOX_DEFAULT(new FirefoxTemporary(),
				"firefox_Default"), IE_TEMPORARY(new IExplorerTemporary(),
						"IE_Temporary"), CHROME_TEMPORARY(new ChromeTemporary(), "Chrome_Temporary");
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

}

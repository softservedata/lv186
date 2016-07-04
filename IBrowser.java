package gmail.com.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface IBrowser {

	class FirefoxTemporary implements IBrowser {
		public WebDriver getBrowser() {
			WebDriver driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
			return driver;
		}
	}

	class ChromeTemporary implements IBrowser {
		public WebDriver getBrowser() {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
			return driver;
		}
	}

	class IETemporary implements IBrowser {
		public WebDriver getBrowser() {
			System.setProperty("webdriver.ie.driver",
					"C:\\Program Files\\Internet Explorer\\IEDriverServer.exe");
			DesiredCapabilities capabilities = DesiredCapabilities
					.internetExplorer();
			capabilities
					.setCapability(
							InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
			capabilities.setJavascriptEnabled(true); 
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true); 
			capabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
			capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
			capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);

			WebDriver driver = new InternetExplorerDriver(capabilities);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
			return driver;
		}
	}

	public static enum BrowsersList {
		FIREFOX_TEMPORARY(new FirefoxTemporary(), "firefox_Temporary"), FIREFOX_DEFAULT(
				new FirefoxTemporary(), "firefox_Default"), IE_TEMPORARY(
				new IETemporary(), "IE_Temporary"), CHROME_TEMPORARY(
				new ChromeTemporary(), "Chrome_Temporary");
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

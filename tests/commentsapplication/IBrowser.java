package commentsapplication;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Olia on 02.07.2016.
 */

interface IBrowser {

	class FireFoxBrowser implements IBrowser {
		public WebDriver getBrowser() {

			WebDriver driver = new FirefoxDriver();

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);

			return driver;
		}
	}

	class ChromeBrowser implements IBrowser {
		public WebDriver getBrowser() {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);

			return driver;
		}
	}

	public static enum BrowserList {

		FIRE_FOX(new FireFoxBrowser()), CHROME(new ChromeBrowser());

		private IBrowser browser;

		private BrowserList(IBrowser browser) {
			this.browser = browser;
		}

		public WebDriver getWebDriver() {
			return browser.getBrowser();
		}

	}

	abstract WebDriver getBrowser();

}

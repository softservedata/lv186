package commentsapplication;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commentsapplication.IBrowser.BrowserList;
import commentsapplication.IVersion.VersionList;

public class InactivateCommentTest {

	@DataProvider(name = "data")
	public static Object[][] dataProvider() {
		return new Object[][] { { BrowserList.CHROME, VersionList.VERSION1_0 },
				{ BrowserList.CHROME, VersionList.VERSION1_1 }, { BrowserList.FIRE_FOX, VersionList.VERSION1_0 },
				{ BrowserList.FIRE_FOX, VersionList.VERSION1_1 } };
	}

	@Test(dataProvider = "data", priority = 1)
	public void noCommentSelected(BrowserList browser, VersionList version) throws InterruptedException {
		WebDriver driver = browser.getWebDriver();
		driver.get(version.getUrl());

		new Select(driver.findElement(By.id("commandSelect"))).selectByVisibleText("Inactivate");
		Thread.sleep(1000);
		version.handleNotification(driver);
		Thread.sleep(1000);
		driver.close();
	}

	@Test(dataProvider = "data", priority = 2)
	public void inactiveCommentSelected(BrowserList browser, VersionList version) throws InterruptedException {
		WebDriver driver = browser.getWebDriver();
		driver.get(version.getUrl());

		String commentText = version.searchInactiveComment(driver).findElement(By.className("textcolumn")).getText();
		version.searchInactiveComment(driver).findElement(By.name("SelectedId")).click();
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("commandSelect"))).selectByVisibleText("Inactivate");
		String actualValue = driver
				.findElement(By
						.xpath("//*[text()='" + commentText + "']/" + "following-sibling::*[@class='inactivecolumn']"))
				.getText();
		Thread.sleep(1000);
		version.assertInactiveStatus(actualValue);
		Thread.sleep(1000);
		driver.close();
	}

	@Test(dataProvider = "data", priority = 3)
	public void activeCommentSelected(BrowserList browser, VersionList version) throws InterruptedException {
		WebDriver driver = browser.getWebDriver();
		driver.get(version.getUrl());

		String commentText = version.searchActiveComment(driver).findElement(By.className("textcolumn")).getText();
		version.searchActiveComment(driver).findElement(By.name("SelectedId")).click();
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("commandSelect"))).selectByVisibleText("Inactivate");
		Thread.sleep(1000);
		String actualValue = driver
				.findElement(By
						.xpath("//*[text()='" + commentText + "']/" + "following-sibling::*[@class='inactivecolumn']"))
				.getText();
		Thread.sleep(1000);
		version.assertInactiveStatus(actualValue);
		Thread.sleep(1000);
		driver.close();
	}

	@Test(dataProvider = "data", priority = 4)
	public void selectTwoComment(BrowserList browser, VersionList version) throws InterruptedException {
		WebDriver driver = browser.getWebDriver();
		driver.get(version.getUrl());

		String commentText1 = version.searchActiveComment(driver).findElement(By.className("textcolumn")).getText();
		version.searchActiveComment(driver).findElement(By.name("SelectedId")).click();
		Thread.sleep(1000);
		String commentText2 = version.searchInactiveComment(driver).findElement(By.className("textcolumn")).getText();
		version.searchInactiveComment(driver).findElement(By.name("SelectedId")).click();
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("commandSelect"))).selectByVisibleText("Inactivate");
		Thread.sleep(1000);
		String actualValue1 = driver
				.findElement(By
						.xpath("//*[text()='" + commentText1 + "']/" + "following-sibling::*[@class='inactivecolumn']"))
				.getText();
		String actualValue2 = driver
				.findElement(By
						.xpath("//*[text()='" + commentText2 + "']/" + "following-sibling::*[@class='inactivecolumn']"))
				.getText();
		Thread.sleep(1000);
		version.assertInactiveStatus(actualValue1);
		version.assertInactiveStatus(actualValue2);

		Thread.sleep(1000);
		driver.close();
	}

}

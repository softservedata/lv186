package commentsapplication;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commentsapplication.IBrowser.BrowserList;
import commentsapplication.IVersion.VersionList;

public class RemoveFromCategoryTest {
	@DataProvider(name = "data")
	public static Object[][] dataProvider() {
		return new Object[][] { { BrowserList.CHROME, VersionList.VERSION1_0 },
								{ BrowserList.CHROME, VersionList.VERSION1_1 },
								{ BrowserList.FIRE_FOX, VersionList.VERSION1_0 },
								{ BrowserList.FIRE_FOX, VersionList.VERSION1_1 }
		};
	}

	@Test(dataProvider = "data", priority = 1)
	public void noCategorySelected(BrowserList browser, VersionList version) throws InterruptedException {

		WebDriver driver = browser.getWebDriver();
		driver.get(version.getUrl());

		new Select(driver.findElement(By.id("commandSelect"))).selectByVisibleText("RemoveFromCategory");
		Thread.sleep(1000);
		version.handleNotification(driver);
		Thread.sleep(1000);
		driver.close();
	}

	@Test(dataProvider = "data", priority = 2)
	public void noCommentSelected(BrowserList browser, VersionList version) throws InterruptedException {

		WebDriver driver = browser.getWebDriver();
		driver.get(version.getUrl());


		new Select(driver.findElement(By.id("SelectedCateg"))).selectByVisibleText("Cat1");
		driver.findElement(By.id("applybutton")).click();
		new Select(driver.findElement(By.id("commandSelect"))).selectByVisibleText("RemoveFromCategory");
		Thread.sleep(1000);
		version.handleNotification(driver);
		Thread.sleep(1000);
		driver.close();
	}

	@Test(dataProvider = "data", priority = 3)
	public void averageCommentSelected(BrowserList browser, VersionList version) throws InterruptedException {

		WebDriver driver = browser.getWebDriver();
		driver.get(version.getUrl());


		new Select(driver.findElement(By.id("SelectedCateg"))).selectByVisibleText("Cat1");
		driver.findElement(By.id("applybutton")).click();
		String commentText = driver.findElement(By.xpath("//*[@class='textcolumn']")).getText();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		new Select(driver.findElement(By.id("commandSelect"))).selectByVisibleText("RemoveFromCategory");
		driver.findElement(By.xpath("//button[@type='button']")).click();
		new Select(driver.findElement(By.id("SelectedCateg"))).selectByVisibleText("All");
		driver.findElement(By.id("applybutton")).click();
		String actualValue = driver.findElement(By.xpath("//*[text()='" + commentText + "']/"
				+ "following-sibling::*[@class='categorycolumn']")).getText();
		Assert.assertFalse(actualValue.contains("Cat1"));
		driver.close();
	}

	@Test(dataProvider = "data", priority = 4)
	public void twoCommentsSelected(BrowserList browser, VersionList version) throws InterruptedException {

		WebDriver driver = browser.getWebDriver();
		driver.get(version.getUrl());


		new Select(driver.findElement(By.id("SelectedCateg"))).selectByVisibleText("Cat1");
		driver.findElement(By.id("applybutton")).click();
		String commentText1 = driver.findElement(By.xpath("//table//tbody//tr[1]/td[@class='textcolumn']")).getText();
		driver.findElement(By.xpath("//table//tbody//tr[1]//input[@type='checkbox']")).click();
		String commentText2 = driver.findElement(By.xpath("//table//tbody//tr[2]/td[@class='textcolumn']")).getText();
		driver.findElement(By.xpath("//table//tbody//tr[2]//input[@type='checkbox']")).click();
		new Select(driver.findElement(By.id("commandSelect"))).selectByVisibleText("RemoveFromCategory");
		driver.findElement(By.xpath("//button[@type='button']")).click();
		new Select(driver.findElement(By.id("SelectedCateg"))).selectByVisibleText("All");
		driver.findElement(By.id("applybutton")).click();
		String actualValue1 = driver.findElement(By.xpath("//*[text()='" + commentText1 + "']/"
				+ "following-sibling::*[@class='categorycolumn']")).getText();
		String actualValue2 = driver.findElement(By.xpath("//*[text()='" + commentText2 + "']/"
				+ "following-sibling::*[@class='categorycolumn']")).getText();
		Assert.assertFalse(actualValue1.contains("Cat1"));
		Assert.assertFalse(actualValue2.contains("Cat1"));
		driver.close();
	}

	@Test(dataProvider = "data", priority = 5)
	public void removeLastCategory(BrowserList browser, VersionList version) throws InterruptedException {

		WebDriver driver = browser.getWebDriver();
		driver.get(version.getUrl());


		new Select(driver.findElement(By.id("SelectedCateg"))).selectByVisibleText("Cat0");
		driver.findElement(By.id("applybutton")).click();
		String commentText = driver.findElement(By.xpath("//table//tbody//tr[1]/td[@class='textcolumn']")).getText();
		driver.findElement(By.xpath("//table//tbody//tr[1]//input[@type='checkbox']")).click();
		new Select(driver.findElement(By.id("commandSelect"))).selectByVisibleText("RemoveFromCategory");
		driver.findElement(By.xpath("//button[@type='button']")).click();
		driver.findElement(By.xpath("//button[@type='button']")).click();
		String actualCategory = driver.findElement(By.xpath("//*[text()='" + commentText + "']/"
				+ "following-sibling::*[@class='categorycolumn']")).getText();
		String actualStatus = driver.findElement(By.xpath("//*[text()='" + commentText + "']/"
				+ "following-sibling::*[@class='inactivecolumn']")).getText();
		Assert.assertTrue(actualCategory.contains("Cat0"));
		version.assertInactiveStatus(actualStatus);
		driver.close();
	}


}

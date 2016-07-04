package commentsapplication;

import org.testng.annotations.Test;
import commentsapplication.IBrowser.BrowserList;
import commentsapplication.IVersion.Version1_0;
import commentsapplication.IVersion.Version1_1;
import commentsapplication.IVersion.VersionList;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ActivatingCommentTest {
  	 
  @DataProvider (name = "data")
  public static Object[][] dataProvider (){
      return new Object[][]{ {BrowserList.CHROME, VersionList.VERSION1_0},
    	  					 {BrowserList.CHROME, VersionList.VERSION1_1},
    	  					 {BrowserList.FIRE_FOX, VersionList.VERSION1_0},
    	  					 {BrowserList.FIRE_FOX, VersionList.VERSION1_1} 
      };
  }
  
  
  @Test (dataProvider = "data", priority=1)
  public void noCommentSelected (BrowserList browser, VersionList version) throws InterruptedException {
	  
	  WebDriver driver = browser.getWebDriver();
	  driver.get(version.getUrl());	  
	  
	  new Select(driver.findElement(By.id("commandSelect"))).selectByVisibleText("Activate");
	  Thread.sleep(1000);
	  version.handleNotification(driver);
	  Thread.sleep(1000);
	  driver.close();
  }
    
  @Test (dataProvider = "data", priority=2)
  public void inactiveCommentSelected (BrowserList browser, VersionList version) throws InterruptedException {
	  WebDriver driver = browser.getWebDriver();
	  driver.get(version.getUrl());
	  
	  String commentText = version.searchInactiveComment(driver).findElement(By.className("textcolumn")).getText();
	  version.searchInactiveComment(driver).findElement(By.name("SelectedId")).click();
	  Thread.sleep(1000);
	  new Select(driver.findElement(By.id("commandSelect"))).selectByVisibleText("Activate");
	  String actualValue = driver.findElement(By.xpath("//*[text()='" + commentText + "']/"
	  			+ "following-sibling::*[@class='inactivecolumn']")).getText();
	  Thread.sleep(1000);
	  version.assertActiveStatus(actualValue);
	  Thread.sleep(1000);
	  driver.close();
  }
  
  @Test (dataProvider = "data", priority=3)
  public void activeCommentSelected (BrowserList browser, VersionList version) throws InterruptedException {
	  WebDriver driver = browser.getWebDriver();
	  driver.get(version.getUrl());
	  
	  String commentText = version.searchActiveComment(driver).findElement(By.className("textcolumn")).getText();
	  version.searchActiveComment(driver).findElement(By.name("SelectedId")).click();
	  Thread.sleep(1000);
	  new Select(driver.findElement(By.id("commandSelect"))).selectByVisibleText("Activate");
	  Thread.sleep(1000);
	  String actualValue = driver.findElement(By.xpath("//*[text()='" + commentText + "']/"
	  			+ "following-sibling::*[@class='inactivecolumn']")).getText();
	  Thread.sleep(1000);
	  version.assertActiveStatus(actualValue);
	  Thread.sleep(1000);
	  driver.close();
  }
  
  @Test (dataProvider = "data", priority=4)
  public void selectTwoComment (BrowserList browser, VersionList version) throws InterruptedException {
	  WebDriver driver = browser.getWebDriver();
	  driver.get(version.getUrl());
	  
	  String commentText1 = version.searchActiveComment(driver).findElement(By.className("textcolumn")).getText();
	  version.searchActiveComment(driver).findElement(By.name("SelectedId")).click();
	  Thread.sleep(1000);
	  String commentText2 = version.searchInactiveComment(driver).findElement(By.className("textcolumn")).getText();
	  version.searchInactiveComment(driver).findElement(By.name("SelectedId")).click();
	  Thread.sleep(1000);
	  new Select(driver.findElement(By.id("commandSelect"))).selectByVisibleText("Activate");
	  Thread.sleep(1000);
	  String actualValue1 = driver.findElement(By.xpath("//*[text()='" + commentText1 + "']/"
	  			+ "following-sibling::*[@class='inactivecolumn']")).getText();
	  String actualValue2 = driver.findElement(By.xpath("//*[text()='" + commentText2 + "']/"
	  			+ "following-sibling::*[@class='inactivecolumn']")).getText();
	  Thread.sleep(1000);
	  version.assertActiveStatus(actualValue1);
	  version.assertActiveStatus(actualValue2);
	  
	  Thread.sleep(1000);
	  driver.close(); 
  }
  


  @AfterTest
  public void afterTest() {
	  
  }


}


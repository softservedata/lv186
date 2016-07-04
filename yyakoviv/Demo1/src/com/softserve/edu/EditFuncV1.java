package com.softserve.edu;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.IBrowser.BrowsersList;

public class EditFuncV1 {
    
	@BeforeClass
    public void beforeClass() {

    }
    
    
  @DataProvider
  public Object[][] driverParameters() {
       return new Object[][] {
          { BrowsersList.FIREFOX_TEMPORARY },
          { BrowsersList.CHROME_TEMPORARY },
       };
  }
     	
  @Test (dataProvider = "driverParameters")
  public void EditWithoutChecking(BrowsersList browser) throws Exception {
	  
	  WebDriver driver = browser.getWebDriver();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	  driver.get("http://commentssprintone.azurewebsites.net/");
 
      driver.findElement(By.xpath("//div[@id='command-navigation']/*[3]")).click(); 
      (new WebDriverWait(driver, 5)).until(ExpectedConditions.alertIsPresent());
      Assert.assertEquals(driver.switchTo().alert().getText(), "Please, select one category");
      driver.switchTo().alert().accept(); 
      
      driver.quit();
  }
  
  @Test (dataProvider = "driverParameters")
  public void EditManyChecking(BrowsersList browser) throws Exception {
	  
	  WebDriver driver = browser.getWebDriver();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	  driver.get("http://commentssprintone.azurewebsites.net/");
	  
      driver.findElement(By.xpath("//td[text()='Comment Text 1']/preceding-sibling::td[2]")).click();
      driver.findElement(By.xpath("//td[text()='Comment Text 2']/preceding-sibling::td[2]")).click();
      driver.findElement(By.xpath("//div[@id='command-navigation']/*[3]")).click();   

      (new WebDriverWait(driver, 5)).until(ExpectedConditions.alertIsPresent());
      Assert.assertEquals(driver.switchTo().alert().getText(), "Please, select one category");
      driver.switchTo().alert().accept(); 
     
      driver.quit();
  }
  
  @Test (dataProvider = "driverParameters")
  public void EditOneChecking(BrowsersList browser) throws Exception {
	  
	  WebDriver driver = browser.getWebDriver();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	  boolean isWebElementFound = false;

	  driver.get("http://commentssprintone.azurewebsites.net/");
	  
      driver.findElement(By.xpath("//td[text()='Comment Text 1']/preceding-sibling::td[2]")).click();
      driver.findElement(By.xpath("//div[@id='command-navigation']/*[3]")).click(); 
      driver.findElement(By.id("Text")).sendKeys("2345");
      driver.findElement(By.id("Number")).clear();
      driver.findElement(By.id("Number")).sendKeys("987");
      driver.findElement(By.id("Active")).click(); 
      driver.findElement(By.xpath("//span[contains(text(),'Cat5')]/preceding-sibling::input[@id='Categories']")).click();
      driver.findElement(By.name("CurSelect")).click();
      driver.findElement(By.xpath("//input[@value='Save & Return']")).click();
      
      List<WebElement> comments = null;
      WebElement comment = null;
      while (!isWebElementFound) {
          comments = driver.findElements(By.xpath("//td[contains(text(),'Comment Text 12345')]"));
          if (comments.size() > 0) {
              isWebElementFound = true;
              comment =comments.get(0); 
          } else {
              List<WebElement> next = driver.findElements(By.linkText(">"));
              if (next.size() > 0) {
                  System.out.println("Next Page");
                  next.get(0).click();
              } else {
                  break;
              }
          }
      }
      Assert.assertTrue(isWebElementFound);
      Assert.assertNotNull(comment);
      Assert.assertEquals(comment.getText(), "Comment Text 12345");
      //
      Assert.assertEquals(driver.findElement(By.xpath("//td[text()='987']")).getText(), "987");
      Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Comment Text 12345']/following-sibling::td[contains(text(),'V')]")).getText(), "V");
      Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Comment Text 12345']/following-sibling::td[contains(text(),'Cat0; Cat1; Cat5')]")).getText(), "Cat0, Cat1, Cat5");
      
      driver.quit();
      
  }
  
  
  @Test (dataProvider = "driverParameters")
  public void EditAndReturn(BrowsersList browser) throws Exception {
	  
	  WebDriver driver = browser.getWebDriver();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	  driver.get("http://commentssprintone.azurewebsites.net/");
	  
	  boolean isWebElementFound = false;
	  
      driver.findElement(By.xpath("//td[text()='Comment Text 1']/preceding-sibling::td[2]")).click();
      driver.findElement(By.xpath("//div[@id='command-navigation']/*[3]")).click(); 
      driver.findElement(By.id("Text")).sendKeys("2345");
      driver.findElement(By.id("Number")).clear();
      driver.findElement(By.id("Number")).sendKeys("987");
      driver.findElement(By.id("Active")).click(); 
      driver.findElement(By.xpath("//span[contains(text(),'Cat5')]/preceding-sibling::input[@id='Categories']")).click();
      driver.findElement(By.name("CurSelect")).click();
      driver.findElement(By.partialLinkText("Return")).click();
      
      List<WebElement> comments = null;
      WebElement comment = null;
      while (!isWebElementFound) {
          comments = driver.findElements(By.xpath("//td[contains(text(),'Comment Text 1')]"));
          if (comments.size() > 0) {
              isWebElementFound = true;
              comment =comments.get(0); 
          } else {
              List<WebElement> next = driver.findElements(By.linkText(">"));
              if (next.size() > 0) {
                  System.out.println("Next Page");
                  next.get(0).click();
              } else {
                  break;
              }
          }
      }
      Assert.assertTrue(isWebElementFound);
      Assert.assertNotNull(comment);
      Assert.assertEquals(comment.getText(), "Comment Text 1");
      //
      Assert.assertEquals(driver.findElement(By.xpath("//td[text()='1']")).getText(), "1");
      Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Comment Text 1']/following-sibling::td[contains(text(),'Cat0; Cat1')]")).getText(), "Cat0, Cat1");
    
      driver.quit();
  }
  
  @Test (dataProvider = "driverParameters")
  public void EditAndRefresh(BrowsersList browser) throws Exception {
	  
	  WebDriver driver = browser.getWebDriver();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	  driver.get("http://commentssprintone.azurewebsites.net/");
	  
      driver.findElement(By.xpath("//td[text()='Comment Text 1']/preceding-sibling::td[2]")).click();
      driver.findElement(By.xpath("//div[@id='command-navigation']/*[3]")).click(); 
      driver.findElement(By.id("Text")).sendKeys("2345");
      driver.findElement(By.id("Number")).clear();
      driver.findElement(By.id("Number")).sendKeys("987");
      driver.findElement(By.id("Active")).click(); 
      driver.findElement(By.xpath("//span[contains(text(),'Cat5')]/preceding-sibling::input[@id='Categories']")).click();
      driver.findElement(By.name("CurSelect")).click();
      driver.findElement(By.partialLinkText("Refresh")).click();
      
      Assert.assertEquals(driver.findElement(By.id("Text")).getAttribute("value"), "Comment Text 1");
      Assert.assertEquals(driver.findElement(By.id("Number")).getAttribute("value"), "1");
      Assert.assertEquals(driver.findElement(By.id("Active")).getAttribute("value"), "true");
      Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Cat0')]")).getText(), "Cat0");
      Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Cat1')]")).getText(), "Cat1");

      driver.quit();
  }
  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() throws Exception {

  }

 

  @AfterClass
  public void afterClass() throws Exception {

  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}

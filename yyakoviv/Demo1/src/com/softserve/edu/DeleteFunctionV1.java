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

public class DeleteFunctionV1 {

    
    @DataProvider
    public Object[][] driverParameters() {
         return new Object[][] {
            { BrowsersList.FIREFOX_TEMPORARY },
            { BrowsersList.CHROME_TEMPORARY },
         };
    }
	
  @Test (dataProvider = "driverParameters")
  public void DeleteWithoutCheking(BrowsersList browser) {
	  
	  WebDriver driver = browser.getWebDriver();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	  driver.get("http://commentssprintone.azurewebsites.net/");
	  
      driver.findElement(By.xpath("//div[@id='command-navigation']/*[4]")).click();   
  
      (new WebDriverWait(driver, 5)).until(ExpectedConditions.alertIsPresent());
      Assert.assertEquals(driver.switchTo().alert().getText(), "Please, select one category");
      driver.switchTo().alert().accept(); 
      
      driver.quit();
           
  }
  
  @Test (dataProvider = "driverParameters")
  public void DeleteDismiss(BrowsersList browser) {
	  
	  WebDriver driver = browser.getWebDriver();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	  driver.get("http://commentssprintone.azurewebsites.net/");
	  
      driver.findElement(By.xpath("//td[text()='Comment Text 1']/preceding-sibling::td[2]")).click();
      driver.findElement(By.xpath("//div[@id='command-navigation']/*[4]")).click();
      Assert.assertEquals(driver.findElement(By.xpath("//p[@id='msgText']")).getText(), "Delete?");
      driver.findElement(By.xpath("//span[contains(text(),'No')]")).click();
      
      driver.quit();
          
  }
  
  @Test (dataProvider = "driverParameters")
  public void DeleteAccept(BrowsersList browser) {
	  
	  boolean isWebElementFound = false;
	  WebDriver driver = browser.getWebDriver();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	  driver.get("http://commentssprintone.azurewebsites.net/");
	  
      driver.findElement(By.xpath("//td[text()='Comment Text 1']/preceding-sibling::td[2]")).click();
      driver.findElement(By.xpath("//div[@id='command-navigation']/*[4]")).click();
      Assert.assertEquals(driver.findElement(By.xpath("//p[@id='msgText']")).getText(), "Delete?");
      driver.findElement(By.xpath("//span[contains(text(),'Yes')]")).click();
      Assert.assertEquals(driver.findElement(By.xpath("//div[@id='infoField']")).getText(), "Selected comments deleted successfull");
      
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
      Assert.assertNotEquals(comment.getText(), "Comment Text 1", "+++");
     
      driver.quit();
          
  }
  
  @Test (dataProvider = "driverParameters")
  public void DeleteSomeAccept(BrowsersList browser) {
	  
	  boolean isWebElementFound = false;
	  boolean isWebElementFound2 = false;
	  
	  WebDriver driver = browser.getWebDriver();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	  driver.get("http://commentssprintone.azurewebsites.net/");
	  
      driver.findElement(By.xpath("//td[text()='Comment Text 1']/preceding-sibling::td[2]")).click();
      driver.findElement(By.xpath("//td[text()='Comment Text 2']/preceding-sibling::td[2]")).click();
      
      driver.findElement(By.xpath("//div[@id='command-navigation']/*[4]")).click();
      Assert.assertEquals(driver.findElement(By.xpath("//p[@id='msgText']")).getText(), "Delete?");

      driver.findElement(By.xpath("//span[contains(text(),'Yes')]")).click();
      Assert.assertEquals(driver.findElement(By.xpath("//div[@id='infoField']")).getText(), "Selected comments deleted successfull");

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
      Assert.assertNotEquals(comment.getText(), "Comment Text 1", "+++");
      
      List<WebElement> comments2 = null;
      WebElement comment2 = null;
      while (!isWebElementFound2) {
          comments2 = driver.findElements(By.xpath("//td[contains(text(),'Comment Text 2')]"));
          if (comments2.size() > 0) {
              isWebElementFound2 = true;
              comment2 =comments2.get(0); 
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
      Assert.assertTrue(isWebElementFound2);
      Assert.assertNotNull(comment2);
      Assert.assertNotEquals(comment2.getText(), "Comment Text 2", "+++");
      
      driver.quit();
           
  }
 
  
  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
	  
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

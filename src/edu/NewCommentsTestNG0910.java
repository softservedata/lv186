package edu;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import edu.IBrowser.BrowsersList;

public class NewCommentsTestNG0910 {

	WebDriver driver;
	
	@DataProvider
    public Object[][] driverParameters() {
        return new Object[][] {
            { BrowsersList.FIREFOX_TEMPORARY,"http://commentssprintone.azurewebsites.net" },
            { BrowsersList.CHROME_TEMPORARY,"http://commentssprintone.azurewebsites.net" },
            { BrowsersList.FIREFOX_TEMPORARY,"http://comments.azurewebsites.net" },
            { BrowsersList.CHROME_TEMPORARY,"http://comments.azurewebsites.net" }
            };
    }
	
    @AfterMethod
    public void afterMethod() throws IOException {
        if ( driver != null) {
        	driver.quit();
        }  
    }
    @Test(dataProvider = "driverParameters")
    public void test9(BrowsersList browser,String url)  {
    	
    	driver = browser.getWebDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
  	    driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
    	
    	driver.get(url);
        //
        //check comment with text 'Comment Text 1' and click button Edit
        //
        driver.findElement(By.xpath("//td[text()='Comment Text 1']/preceding-sibling::td[2]")).click();
        driver.findElement(By.xpath("//input[@onclick=\"EditCmd('Edit')\"]")).click();
        
        //copy value from field Number to variable number
        String number = driver.findElement(By.id("Number")).getAttribute("value");
       
        driver.get(url);
        
        //click button New
        driver.findElement(By.xpath("//div[@id='command-navigation']/*[1]")).click();
        
        // write down valid comment text and number from variable number
        // click button Save
        driver.findElement(By.id("Text")).clear();
        driver.findElement(By.id("Text")).sendKeys("blablabla");
        driver.findElement(By.id("Number")).clear();
        driver.findElement(By.id("Number")).sendKeys(number);
        driver.findElement(By.cssSelector("input.buttonAsLink")).click();
        //
        //to confirm that  test is passed
        //1. The New Comments page is still opened.
        //
        WebDriverWait wait = new WebDriverWait(driver,10);
        Assert.assertTrue(wait.until(ExpectedConditions.urlContains(url+"/Editor/SaveReturn")));
        Assert.assertEquals(driver.getTitle(),"Editor");
        //
        //2. Red label with text Number field should be unique of empty
        //appears above Comment Text field.
        //
        Assert.assertEquals(driver.findElement(By.id("errorfield")).getText(), "Number field should be unique of empty");
        Assert.assertEquals(driver.findElement(By.id("errorfield")).getCssValue("color").toString(),"rgba(255, 0, 0, 1)");
    
    }
    @Test(dataProvider = "driverParameters")
    public void test10(BrowsersList browser,String url)  {
    	
    	driver = browser.getWebDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
  	    driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
    	
    	driver.get(url);
        //
        //check comment with text 'Comment Text 1' and click button Edit
        //
        driver.findElement(By.xpath("//td[text()='Comment Text 1']/preceding-sibling::td[2]")).click();
        driver.findElement(By.xpath("//input[@onclick=\"EditCmd('Edit')\"]")).click();
        
        // write down valid comment text 
        // click button Save
        driver.findElement(By.id("Text")).clear();
        driver.findElement(By.id("Text")).sendKeys("blablabla");
        driver.findElement(By.cssSelector("input.buttonAsLink")).click();
        //
        //to confirm that  test is passed
        //1. The New Comments page is still opened.
        //
        
        WebDriverWait wait = new WebDriverWait(driver,10);
        Assert.assertTrue(wait.until(ExpectedConditions.urlContains(url+"/Editor/EditComment")));
        Assert.assertEquals(driver.getTitle(),"Editor");
        //
        //2. Red label with text Please, select at least one category
        //appears above Comment Text field.
        //
        Assert.assertEquals(driver.findElement(By.id("errorfield")).getText(), "Please, select at least one category");
        Assert.assertEquals(driver.findElement(By.id("errorfield")).getCssValue("color").toString(),"rgba(255, 0, 0, 1)");
    
    }
    
}

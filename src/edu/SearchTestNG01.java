package edu;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import edu.IBrowser.BrowsersList;

public class SearchTestNG01 {
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
        if ( driver != null ) {
        	driver.quit(); 
        } 
        
    }
    @Test(dataProvider = "driverParameters")
    public void test1(BrowsersList browser,String url)  {
  	  
  	    driver = browser.getWebDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
  	    driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(),url+"/");
        
        Assert.assertTrue(driver.findElement(By.id("SelectedCateg")).isDisplayed());
        (new WebDriverWait(driver, 5))
             .until(ExpectedConditions.elementToBeClickable(By.id("SelectedCateg")));
        driver.findElement(By.id("SelectedCateg")).click();
        driver.findElement(By.xpath("//option[contains(text(),'Cat1')]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//option[contains(text(),'Cat1')]")).isSelected());
        String valueCat = driver.findElement(By.xpath("//option[contains(text(),'Cat1')]"))
        		.getAttribute("value").toString();
        
        Assert.assertTrue(driver.findElement(By.id("SelectedStatus")).isDisplayed());
        (new WebDriverWait(driver, 5))
        .until(ExpectedConditions.elementToBeClickable(By.id("SelectedStatus")));
        driver.findElement(By.id("SelectedStatus")).click();
        driver.findElement(By.xpath("//option[contains(text(),'Active')]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//option[contains(text(),'Active')]")).isSelected());
        String valueActive = driver.findElement(By.xpath("//option[contains(text(),'Active')]"))
        		.getAttribute("value").toString();
        
        
        Assert.assertTrue(driver.findElement(By.id("applybutton")).isDisplayed());
        (new WebDriverWait(driver, 5))
        .until(ExpectedConditions.elementToBeClickable(By.id("applybutton")));
        driver.findElement(By.id("applybutton")).click();
        Assert.assertEquals(driver.getCurrentUrl(),
        		url+"/?SelectedCategId="+valueCat+"&SelectedStatus="+valueActive);
        
    }
}

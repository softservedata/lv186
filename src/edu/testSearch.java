package edu;

import java.io.File;
import java.io.IOException;
import java.util.List;
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

public class testSearch {
WebDriver driver;
	
	@DataProvider
    public Object[][] driverParameters() {
        return new Object[][] {
				{ BrowsersList.FIREFOX_TEMPORARY, "http://commentssprintone.azurewebsites.net" },
            { BrowsersList.CHROME_TEMPORARY,"http://commentssprintone.azurewebsites.net" },
            { BrowsersList.FIREFOX_TEMPORARY,"http://comments.azurewebsites.net" },
            { BrowsersList.CHROME_TEMPORARY,"http://comments.azurewebsites.net" }
            };
    }
	
	

    @AfterMethod
    public void afterMethod() throws IOException {
        
        driver.quit();
        
    }
    @Test(dataProvider = "driverParameters")
    public void test1(BrowsersList browser,String url) {
    	/**
  	   *  Test search by categories and status functional. It select
  	   *   1 category(Cat1) and 1 status(Active) to test this test case.
  	   *  The main purpose is to confirm that search functional work correctly.
  	   */
    	boolean isNextPageAvailable = true;
        int count = 0;
        int findedAllCount = 0;
        int findedCount = 0;
  	  
  	    driver = browser.getWebDriver();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        
        
        driver.get(url);   
        
        while (isNextPageAvailable) {
        	List<WebElement> startComments =  driver.findElements(By.xpath("//table[@class='webgrid']/tbody/tr"));
        	if(driver.findElement(By.xpath
                    ("//table[@class='webgrid']/thead/tr[@class='webgrid-header']/*[4]/a")).getText().equals("Inactive") ) {
        		for(int i=0;i<startComments.size();i++) {
                	List<WebElement> test = startComments.get(i).findElements(By.className("inactivecolumn"));
                	if(test.get(0).getText().equals("V")) {
                		startComments.remove(i);
                		i--;
                		}
                	}
        		
        	} else if ( driver.findElement(By.xpath
          	      ("//table[@class='webgrid']/thead/tr[@class='webgrid-header']/*[4]/a")).getText().equals("Active") ) {
            for(int i=0;i<startComments.size();i++) {
            	List<WebElement> test = startComments.get(i).findElements(By.className("inactivecolumn"));
            	if(!test.get(0).getText().equals("V")) {
            		startComments.remove(i);
            		i--;
            		}
            	}
        	}
            for(int i=0;i<startComments.size();i++) {
            	
            	if(!startComments.get(i).findElement(By.className("categorycolumn")).getText().contains("Cat1")) {
            		
            		startComments.remove(i);
            		i--;
            	} 
            
            }
            count+=startComments.size();
            
            List<WebElement> next = driver.findElements(By.linkText(">"));
            if (next.size() > 0) {
                next.get(0).click();    
            } else {
            	isNextPageAvailable = false;
            }
        }
        driver.findElement(By.id("SelectedCateg")).click();
        driver.findElement(By.xpath("//option[contains(text(),'Cat1')]")).click();        
        
        driver.findElement(By.id("SelectedStatus")).click();
        driver.findElement(By.xpath("//option[contains(text(),'Active')]")).click();
        
        driver.findElement(By.id("applybutton")).click();   
        
        //count all tr after searching
        
        isNextPageAvailable = true;
        while (isNextPageAvailable) {
        	List<WebElement> startComments =  driver.findElements(By.xpath("//table[@class='webgrid']/tbody/tr"));
        	findedAllCount+=startComments.size();
            List<WebElement> next = driver.findElements(By.linkText(">"));
            if (next.size() > 0) {
                next.get(0).click();    
            } else {
            	isNextPageAvailable = false;
            }
        }
        
      //count all tr that meet the condition after searching
        
        isNextPageAvailable = true;
        while (isNextPageAvailable) {
        	List<WebElement> startComments =  driver.findElements(By.xpath("//table[@class='webgrid']/tbody/tr"));
        	if(driver.findElement(By.xpath
                    ("//table[@class='webgrid']/thead/tr[@class='webgrid-header']/*[4]/a")).getText().equals("Inactive") ) {
        		for(int i=0;i<startComments.size();i++) {
                	List<WebElement> test = startComments.get(i).findElements(By.className("inactivecolumn"));
                	if(test.get(0).getText().equals("V")) {
                		startComments.remove(i);
                		i--;
                		}
                	}
        		
        	} else if ( driver.findElement(By.xpath
          	      ("//table[@class='webgrid']/thead/tr[@class='webgrid-header']/*[4]/a")).getText().equals("Active") ) {
            for(int i=0;i<startComments.size();i++) {
            	List<WebElement> test = startComments.get(i).findElements(By.className("inactivecolumn"));
            	if(!test.get(0).getText().equals("V")) {
            		startComments.remove(i);
            		i--;
            		}
            	}
        	}
            for(int i=0;i<startComments.size();i++) {
            	
            	if(!startComments.get(i).findElement(By.className("categorycolumn")).getText().contains("Cat1")) {
            		startComments.remove(i);
            		i--;
            	} 
            
            }
            findedCount+=startComments.size();
            
            List<WebElement> next = driver.findElements(By.linkText("<"));
            if (next.size() > 0) {
                next.get(0).click();    
            } else {
            	isNextPageAvailable = false;
            }
        }
        System.out.println(findedAllCount);
        Assert.assertTrue(findedCount == findedAllCount);
        Assert.assertTrue(count == findedCount);
  }
}

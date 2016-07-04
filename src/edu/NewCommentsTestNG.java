package edu;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import edu.IBrowser.BrowsersList;


public class NewCommentsTestNG {
	
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
	  /**
	   *  Test new comments functional. It use valid number, 
	   *  valid comment text and 1 category to test this test case.
	   *  The main purpose is to confirm that this new comment was created
	   *  with correct definitions.
	   */
	  
	  boolean isWebElementFound = false;
      List<WebElement> comments = null;
      WebElement comment = null;
	  
	  driver = browser.getWebDriver();
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
      
      driver.get(url);

      driver.findElement(By.xpath("//div[@id='command-navigation']/*[1]")).click();
      driver.findElement(By.id("Text")).sendKeys("Comment by Yaryna1");
      driver.findElement(By.id("Number")).sendKeys("128");
      driver.findElement(By.xpath("//span[contains(text(),'Cat0')]/preceding-sibling::input[@id='Categories']")).click();
      driver.findElement(By.name("CurSelect")).click();
      driver.findElement(By.xpath("//input[@value='Save & Return']")).click();
    
      while ( !isWebElementFound ) {
          comments = driver.findElements(By.xpath("//td[contains(text(),'Comment by Yaryna1')]"));
          if ( comments.size() > 0 ) {
              isWebElementFound = true;
              comment = comments.get(0); 
          } else {
              List<WebElement> next = driver.findElements(By.linkText(">"));
              if ( next.size() > 0 ) {
                  next.get(0).click();
              } else {
                  break;
              }
          }
      }
      
      Assert.assertTrue( isWebElementFound );
      Assert.assertNotNull( comment );
      Assert.assertEquals( comment.getText() , "Comment by Yaryna1" );
      Assert.assertEquals(driver.findElement
    		  (By.xpath("//td[contains(text(),'Comment by Yaryna1')]/preceding-sibling::td[@class='numbercolumn']")).getText(),
    		  "128");
      Assert.assertEquals(driver.findElement
    		  (By.xpath("//td[contains(text(),'Comment by Yaryna1')]/following-sibling::td[@class='categorycolumn']")).getText(),
    		  "Cat0");
      
      if( driver.findElement(By.xpath
          	("//table[@class='webgrid']/thead/tr[@class='webgrid-header']/*[4]/a")).getText() == "Inactive"
          ) {
      	  	Assert.assertEquals( driver.findElement
      	  			(By.xpath("//td[contains(text(),'Comment by Yaryna1')]/following-sibling::td[@class='inactivecolumn']"))
      	  			.getText(), "" );
        } else if ( driver.findElement(By.xpath
      	        		("//table[@class='webgrid']/thead/tr[@class='webgrid-header']/*[4]/a"))
      		  				.getText() == "Active" ) {
      	    	 Assert.assertEquals(driver.findElement
      	    			 (By.xpath("//td[contains(text(),'Comment by Yaryna1')]/following-sibling::td[@class='inactivecolumn']"))
      	    			 	.getText(),"V" );
      	      }
      
      
      
  }
  @Test(dataProvider = "driverParameters")
  public void test2(BrowsersList browser,String url)  {
	  
	  /**
	   *  Test new comments functional. It use valid comment text 
	   *  without number and 1 category to test this test case.
	   *  The main purpose is to confirm that this new comment was created
	   *  with correct definitions.
	   */
	  
	  boolean isWebElementFound = false;
      List<WebElement> comments = null;
      WebElement comment = null;
	  
	  driver = browser.getWebDriver();
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
      
      driver.get(url);
     
      driver.findElement(By.xpath("//div[@id='command-navigation']/*[1]")).click();
      driver.findElement(By.id("Text")).sendKeys("Comment by Yaryna1");
      driver.findElement(By.xpath("//span[contains(text(),'Cat0')]/preceding-sibling::input[@id='Categories']")).click();
      driver.findElement(By.name("CurSelect")).click();
      driver.findElement(By.xpath("//input[@value='Save & Return']")).click();
      
      //Assert.assertEquals(driver.getTitle(),"Editor");
      //driver.get(url);
      
      while (!isWebElementFound) {
          comments = driver.findElements(By.xpath("//td[contains(text(),'Comment by Yaryna1')]"));
          if ( comments.size() > 0 ) {
              isWebElementFound = true;
              comment = comments.get(0); 
          } else {
              List<WebElement> next = driver.findElements(By.linkText(">"));
              if ( next.size() > 0 ) {
                  next.get(0).click();
              } else {
                  break;
              }
          }
      }
     
      Assert.assertNotNull(comment);
      Assert.assertEquals(comment.getText(), "Comment by Yaryna1");
      Assert.assertEquals(driver.findElement
    		  (By.xpath("//td[contains(text(),'Comment by Yaryna1')]/preceding-sibling::td[@class='numbercolumn']")).getText(),
    		  "");
      Assert.assertEquals(driver.findElement
    		  (By.xpath("//td[contains(text(),'Comment by Yaryna1')]/following-sibling::td[@class='categorycolumn']")).getText(),
    		  "Cat0");
      
      if( driver.findElement(By.xpath
          	("//table[@class='webgrid']/thead/tr[@class='webgrid-header']/*[4]/a")).getText() == "Inactive"
          ) {
      	  	Assert.assertEquals( driver.findElement
      	  			(By.xpath("//td[contains(text(),'Comment by Yaryna1')]/following-sibling::td[@class='inactivecolumn']"))
      	  			.getText(), "" );
        } else if ( driver.findElement(By.xpath
      	        		("//table[@class='webgrid']/thead/tr[@class='webgrid-header']/*[4]/a"))
      		  				.getText() == "Active" ) {
      	    	 Assert.assertEquals(driver.findElement
      	    			 (By.xpath("//td[contains(text(),'Comment by Yaryna1')]/following-sibling::td[@class='inactivecolumn']"))
      	    			 	.getText(),"V" );
      	      }
      
      
  }
  @Test(dataProvider = "driverParameters")
  public void test3(BrowsersList browser,String url)  {
	  
	  /**
	   *  Test new comments functional. It use valid number,
	   *  without comment text and 1 category to test this test case.
	   *  The main purpose is to confirm that this new comment wasn't
	   *   created.
	   */
	  
	  boolean isWebElementFound = false;
      List<WebElement> comments = null;
      
	  driver = browser.getWebDriver();
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
      
      driver.get(url);
     
      driver.findElement(By.xpath("//div[@id='command-navigation']/*[1]")).click();
      driver.findElement(By.id("Text")).sendKeys("");
      driver.findElement(By.id("Number")).sendKeys("128");
      driver.findElement(By.xpath("//span[contains(text(),'Cat0')]/preceding-sibling::input[@id='Categories']")).click();
      driver.findElement(By.name("CurSelect")).click();
      driver.findElement(By.xpath("//input[@value='Save & Return']")).click();
      
      Assert.assertEquals(driver.getTitle(),"Editor");
      
      Assert.assertEquals(driver.findElement(By.id("errorfield")).getText(), "The Comment Text field is required.");
      Assert.assertEquals(driver.findElement(By.id("errorfield")).getCssValue("color").toString(),"rgba(255, 0, 0, 1)");
      
      //
      // Go to the main page to confirm that this comment hasn't created
      //
      driver.get(url);
      
      while ( !isWebElementFound ) {
          comments = driver.findElements(By.className("numbercolumn"));
          for ( int i=0; i<comments.size(); i++ ) {
        	  if( comments.get(i).getText().equals("128") ) {
        		  isWebElementFound = true; 
        		  break;
        	  }
          }
           List<WebElement> next = driver.findElements(By.linkText(">"));
              if ( next.size() > 0 ) {
                  next.get(0).click();
              } else {
                  break;
              }
          
      }
      
      Assert.assertFalse( isWebElementFound );

      
  }
  @Test(dataProvider = "driverParameters")
  public void test4(BrowsersList browser,String url)  {
	  
	  /**
	   *  Test new comments functional. It use valid number, 
	   *  valid comment text,inactive status and 1 category 
	   *  to test this test case.
	   *  The main purpose is to confirm that this new comment was created
	   *  with correct definitions.
	   */
	  
	  boolean isWebElementFound = false;
      List<WebElement> comments = null;
      WebElement comment = null;
      
	  driver = browser.getWebDriver();
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
      
      driver.get(url);
     
      driver.findElement(By.xpath("//div[@id='command-navigation']/*[1]")).click();
      driver.findElement(By.id("Text")).sendKeys("Comment by Yaryna1");
      driver.findElement(By.id("Number")).sendKeys("128");
      driver.findElement(By.id("Active")).click();
      driver.findElement(By.xpath("//span[contains(text(),'Cat0')]/preceding-sibling::input[@id='Categories']")).click();
      driver.findElement(By.name("CurSelect")).click();
      driver.findElement(By.xpath("//input[@value='Save & Return']")).click();
      
      while (!isWebElementFound) {
          comments = driver.findElements(By.xpath("//td[contains(text(),'Comment by Yaryna1')]"));
          if ( comments.size() > 0 ) {
              isWebElementFound = true;
              comment = comments.get(0); 
          } else {
              List<WebElement> next = driver.findElements(By.linkText(">"));
              if ( next.size() > 0 ) {
                  next.get(0).click();
              } else {
                  break;
              }
          }
      }
      
      Assert.assertTrue( isWebElementFound );

      Assert.assertNotNull( comment );
      Assert.assertEquals( comment.getText() , "Comment by Yaryna1" );
      Assert.assertEquals( driver.findElement
    		  (By.xpath("//td[contains(text(),'Comment by Yaryna1')]/preceding-sibling::td[@class='numbercolumn']")).getText(),
    		  "128" );
      
      if( driver.findElement(By.xpath
        	("//table[@class='webgrid']/thead/tr[@class='webgrid-header']/*[4]/a")).getText() == "Inactive"
        ) {
    	  	Assert.assertEquals( driver.findElement
    	  			(By.xpath("//td[contains(text(),'Comment by Yaryna1')]/following-sibling::td[@class='inactivecolumn']"))
    	  			.getText(), "V" );
      } else if ( driver.findElement(By.xpath
    	        		("//table[@class='webgrid']/thead/tr[@class='webgrid-header']/*[4]/a"))
    		  				.getText() == "Active" ) {
    	    	 Assert.assertEquals(driver.findElement
    	    			 (By.xpath("//td[contains(text(),'Comment by Yaryna1')]/following-sibling::td[@class='inactivecolumn']"))
    	    			 	.getText(),"" );
    	      }
      
      Assert.assertEquals( driver.findElement
    		  (By.xpath("//td[contains(text(),'Comment by Yaryna1')]/following-sibling::td[@class='categorycolumn']")).getText(),
    		  "Cat0" );

      
  }
  @Test(dataProvider = "driverParameters")
  public void test6(BrowsersList browser,String url)  {
	  
	  /**
	   *  Test new comments functional. It use ALREADY EXIST COMMENT TEXT, 
	   *  valid comment text and 1 category to test this test case.
	   *  The main purpose is to confirm that this new comment wasn't created.
	   */
	  
      boolean isWebElementFound = false;
      String alreadyExistText = null;
      List<WebElement> comments = null;
      WebElement comment = null;
      
	  driver = browser.getWebDriver();
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
      
      driver.get(url);
      
      alreadyExistText = driver.findElement(By.className("textcolumn")).getText();
     
      driver.findElement(By.xpath("//div[@id='command-navigation']/*[1]")).click();
      //driver.findElement(By.id("Text")).sendKeys("Comment Text 1");
      driver.findElement(By.id("Text")).sendKeys(alreadyExistText);
      driver.findElement(By.id("Number")).sendKeys("128");
      driver.findElement(By.xpath("//span[contains(text(),'Cat0')]/preceding-sibling::input[@id='Categories']")).click();
      driver.findElement(By.name("CurSelect")).click();
      driver.findElement(By.xpath("//input[@value='Save & Return']")).click();
      
      Assert.assertEquals(driver.getTitle(),"Editor");

      Assert.assertEquals(driver.findElement(By.id("errorfield")).getText(), "Comment already exists");
      Assert.assertEquals(driver.findElement(By.id("errorfield")).getCssValue("color").toString(),"rgba(255, 0, 0, 1)");
      
      
      //
      // Go to the main page to confirm that this comment hasn't created
      //
      driver.findElement(By.partialLinkText("Return")).click();
      
      while ( !isWebElementFound ) {
          comments = driver.findElements(By.xpath("//td[contains(text(),'"+alreadyExistText+"')]"));
          if ( comments.size() > 0 ) {
              isWebElementFound = true;
              comment = comments.get(0); 
              
          } else {
              List<WebElement> next = driver.findElements(By.linkText(">"));
              if ( next.size() > 0 ) {
                  next.get(0).click();
              } else {
                  break;
              }
          }
      }
  
      Assert.assertTrue( isWebElementFound );

      Assert.assertNotNull( comment );

      Assert.assertEquals( comment.getText() , alreadyExistText );

      Assert.assertNotEquals( driver.findElement
    		  (By.xpath("//td[contains(text(),'"+alreadyExistText+"')]/preceding-sibling::td[@class='numbercolumn']")).getText(),
    		  "128" );
      
      
  }
  @Test(dataProvider = "driverParameters")
  public void test5(BrowsersList browser,String url)  {
	  /**
	   *  Test new comments functional. It use valid number, 
	   *  valid comment text and all category to test this test case.
	   *  The main purpose is to confirm that this new comment was created
	   *  with correct definitions.
	   */
	  
      boolean isWebElementFound = false;
      List<WebElement> selectedCategory = null;
      StringBuffer selCategories = new StringBuffer();
      List<WebElement> comments = null;
      WebElement comment = null;
	  boolean isEqualCat=false;

	  
	  driver = browser.getWebDriver();
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
      
      driver.get(url);
     
      //
      driver.findElement(By.xpath("//div[@id='command-navigation']/*[1]")).click();
      driver.findElement(By.id("Text")).sendKeys("Comment by Yaryna1");
      driver.findElement(By.id("Number")).sendKeys("128");
      driver.findElement(By.xpath("//span[contains(text(),'Cat0')]/preceding-sibling::input[@id='Categories']")).click();
      driver.findElement(By.name("AllSelect")).click();
      
      selectedCategory = driver.findElements(By.xpath("//div[@id='selectedCategories']/div[@class='categoryitem']"));
      
      for( int i=0; i<selectedCategory.size(); i++) {
	    	selCategories.append( selectedCategory.get(i).getText() + ";" ); 	
	    }
      
      driver.findElement(By.xpath("//input[@value='Save & Return']")).click();
      //
      
      while ( !isWebElementFound ) {
          comments = driver.findElements(By.xpath("//td[contains(text(),'Comment by Yaryna1')]"));
          if ( comments.size() > 0 ) {
              isWebElementFound = true;
              comment = comments.get(0); 
          } else {
              List<WebElement> next = driver.findElements(By.linkText(">"));
              if ( next.size() > 0 ) {
                  next.get(0).click();
              } else {
                  break;
              }
          }
      }

      Assert.assertTrue(isWebElementFound);
      Assert.assertNotNull( comment );
      Assert.assertEquals( comment.getText() , "Comment by Yaryna1" );
      Assert.assertEquals( driver.findElement
    		  (By.xpath("//td[contains(text(),'Comment by Yaryna1')]/preceding-sibling::td[@class='numbercolumn']")).getText(),
    		  "128" );
      
      StringTokenizer categories = new StringTokenizer(
      		driver.findElement(By.xpath(
      				"//td[contains(text(),'Comment by Yaryna1')]/following-sibling::td[@class='categorycolumn']")).getText()
      		," \t\n\r;,.:-_");
      StringTokenizer SelectedCategories = new StringTokenizer(selCategories.toString()," \t\n\r;,.:-_");
      
      for( int i = 0; i<selectedCategory.size(); i++) {
      	if( categories.nextToken().equals(SelectedCategories.nextToken()) ) {
      		isEqualCat = true;	
      	} else {
      		isEqualCat = false;
      		break;
      		}
	    }
      Assert.assertTrue(isEqualCat);
      
      if( driver.findElement(By.xpath
            	("//table[@class='webgrid']/thead/tr[@class='webgrid-header']/*[4]/a")).getText() == "Inactive"
            ) {
    	  		Assert.assertEquals( driver.findElement
        	  		(By.xpath("//td[contains(text(),'Comment by Yaryna1')]/following-sibling::td[@class='inactivecolumn']"))
        	  			.getText(), "" );
          } else if ( driver.findElement(By.xpath
        	        		("//table[@class='webgrid']/thead/tr[@class='webgrid-header']/*[4]/a"))
        		  				.getText() == "Active" ) {
        	  			Assert.assertEquals(driver.findElement
        	    			 (By.xpath("//td[contains(text(),'Comment by Yaryna1')]/following-sibling::td[@class='inactivecolumn']"))
        	    			 	.getText(),"V" );
        	      }

      
  }
  @Test(dataProvider = "driverParameters")
  public void test7(BrowsersList browser,String url)  {
	  /**
	   *  Test new comments functional. It use ALREADY EXIST NUMBER, 
	   *  valid comment text and 1 category to test this test case.
	   *  The main purpose is to confirm that this new comment wasn't created.
	   */
	   
	  String alreadyExistNumber = null;
	  boolean isWebElementFound = false;
	  List<WebElement> comments = null;
      WebElement comment = null;
	  
	  driver = browser.getWebDriver();
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
      
      driver.get(url);
      
      alreadyExistNumber = driver.findElement(By.className("numbercolumn")).getText();
     
      driver.findElement(By.xpath("//div[@id='command-navigation']/*[1]")).click();
      driver.findElement(By.id("Text")).sendKeys("Comment Text by Yaryna");
      driver.findElement(By.id("Number")).sendKeys(alreadyExistNumber);
      driver.findElement(By.xpath("//span[contains(text(),'Cat0')]/preceding-sibling::input[@id='Categories']")).click();
      driver.findElement(By.name("CurSelect")).click();
      driver.findElement(By.xpath("//input[@value='Save & Return']")).click();
      
      Assert.assertEquals(driver.getTitle(),"Editor");
      
      Assert.assertEquals(driver.findElement(By.id("errorfield")).getText(), 
    		  "The Number field should contain value from 0 to 999 and should be unique");
      Assert.assertEquals(driver.findElement(By.id("errorfield")).getCssValue("color").toString(),"rgba(255, 0, 0, 1)");
      
      //
      // Go to the main page to confirm that this comment hasn't created
      //
      driver.findElement(By.partialLinkText("Return")).click();
      
      while ( !isWebElementFound ) {
          comments = driver.findElements(By.xpath("//td[contains(text(),'Comment Text by Yaryna')]"));
          if ( comments.size() > 0 ) {
              isWebElementFound = true;
              comment = comments.get(0); 
          } else {
              List<WebElement> next = driver.findElements(By.linkText(">"));
              if ( next.size() > 0 ) {
                  next.get(0).click();
              } else {
                  break;
              }
          }
      }
      
      Assert.assertNull( comment );

      
  }
  

}

package commentsapplication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public interface IVersion {
	
	class Version1_0 implements IVersion {
		private static String url = "http://commentssprintone.azurewebsites.net";
		
		public String getUrl (){
			return this.url;
		}
		
		public void handleNotification(WebDriver driver){
			driver.switchTo().alert().accept();
		}
		
		public WebElement searchActiveComment (WebDriver driver){
			return driver.findElement(By.xpath("//tbody//*[@class='inactivecolumn'][not (contains(text(),'V'))]"
					  + "/.."));
		}
		
		public WebElement searchInactiveComment (WebDriver driver){
			return driver.findElement(By.xpath("//tbody//*[contains(text(),'V')]"
		  			+ "/.."));
		}
				
		public void assertActiveStatus(String actualValue){
        	Assert.assertEquals(actualValue, "");
        }
		
		public void assertInactiveStatus(String actualValue){
			Assert.assertEquals(actualValue, "V");
		}
		
	}
	
	class Version1_1 extends Version1_0 implements IVersion {
		private static String url = "http://comments.azurewebsites.net";
		
		public String getUrl (){
			return this.url;
		}
		
		public void handleNotification(WebDriver driver){
			driver.findElement(By.xpath("//button[@type='button']")).click();
		}
		
		public WebElement searchActiveComment (WebDriver driver){
			return driver.findElement(By.xpath("//tbody//*[contains(text(),'V')]"
		  			+ "/.."));
		}
			
		public WebElement searchInactiveComment (WebDriver driver){
			return driver.findElement(By.xpath("//tbody//*[@class='inactivecolumn'][not (contains(text(),'V'))]"
					  + "/.."));
		}
		
		public void assertActiveStatus(String actualValue){
        	Assert.assertEquals(actualValue, "V");
        }
		
		public void assertInactiveStatus(String actualValue){
			Assert.assertEquals(actualValue, "");
		}
	}
	
	public static enum VersionList {

        VERSION1_0 (new Version1_0()),
        VERSION1_1 (new Version1_1());

        private IVersion version;
        private VersionList (IVersion version){
        	this.version = version;
        }
        public String getUrl (){
        	return version.getUrl();
        }
        
        public void handleNotification(WebDriver driver){
        	version.handleNotification(driver);
        }
        
        WebElement searchActiveComment (WebDriver driver){
        	return version.searchActiveComment(driver);
        }
        
        WebElement searchInactiveComment (WebDriver driver){
        	return version.searchInactiveComment(driver);
        }
        
        void assertActiveStatus(String actualValue){
        	version.assertActiveStatus(actualValue);
        }
        
        void assertInactiveStatus(String actualValue){
        	version.assertInactiveStatus(actualValue);
        }
        
	}

    

	String getUrl();
	
	void handleNotification(WebDriver driver);
	
	WebElement searchInactiveComment (WebDriver driver);
	
	void assertActiveStatus(String actualValue);
	
	void assertInactiveStatus(String actualValue);
	
	WebElement searchActiveComment (WebDriver driver);

}

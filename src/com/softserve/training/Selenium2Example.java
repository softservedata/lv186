package com.softserve.training;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium2Example {

    public static void main(String[] args) throws Exception {
        //Create a new instance of the Firefox driver
//        System.setProperty("webdriver.chrome.driver",
//                "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        //WebDriver driver = new HtmlUnitDriver();
        WebDriver driver = new FirefoxDriver();
        //
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // !!! 0 by default
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        //
        // And now use this to visit Google
        driver.get("http://www.google.com");
        // Alternatively the same thing can be done like this
        // driver.navigate( ).to("http://www.google.com");
        //
        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));
        // Enter something to search for
        //
        System.out.println("Google: Page title is: " + driver.getTitle());
        //
        element.sendKeys("Cheese!");
        element.sendKeys(Keys.ENTER);
        //element.submit();
        //
        // Do not user sleep !!!
        //Thread.sleep(1000);
        //
        // Custom Wait
        (new WebDriverWait(driver, 5))
            .until(new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driverInner) {
                        return driverInner.getTitle().toLowerCase().startsWith("cheese!");
                  }   
                    }
            );
        //
        // Wait from Selenium
        (new WebDriverWait(driver, 5))
            .until(ExpectedConditions.titleContains("heese"));
        //
        // Check the title of the page
        System.out.println("Cheese: Page title is: " + driver.getTitle());
        //
        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        //Thread.sleep(1000);
        driver.findElement(By.partialLinkText("Cheese - Wikipedia, the free encyclopedia"));
        // Should see: "cheese! - Google Search"
        System.out.println("Last: Page title is: " + driver.getTitle());
        //
        //Thread.sleep(1000);
        driver.findElement(By.partialLinkText("Cheese - Wikipedia, the free encyclopedia")).click();
        System.out.println("Wikipedia: Page title is: " + driver.getTitle());
        //
        Thread.sleep(1000);
        // Close the browser
        driver.quit();
    }
}

package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        //driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver",
                "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        driver = new ChromeDriver();
        //
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() throws Exception {
        if (driver != null) {
            Thread.sleep(2000);
            driver.quit();
        }
    }

    @Test
    public void testSeleniumIDE() throws Exception {
        driver.get("https://www.google.com.ua/");
        Thread.sleep(1000);
        //
        WebElement searchField = driver.findElement(By.id("lst-ib"));
        searchField.clear();
        searchField.sendKeys("Selenium IDE");
        Thread.sleep(1000);
        driver.findElement(By.name("btnG")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Selenium IDE Plugins")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Download")).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.cssSelector("a[name='selenium_ide'] > p")).getText(),
                "Selenium IDE is a Firefox plugin which records and plays back user interactions with the browser. Use this to either create simple scripts or assist in exploratory testing. It can also export Remote Control or WebDriver scripts, though they tend to be somewhat brittle and should be overhauled into some sort of Page Object-y structure for any kind of resiliency.");
        Thread.sleep(1000);
    }

    @Test
    public void testT1862() throws Exception {
        driver.get("http://commentssprintone.azurewebsites.net/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//td[text()='Comment Text 2']/preceding-sibling::td[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@value='Edit..']")).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.id("Text")).getAttribute("value"), "Comment Text 2");
        Thread.sleep(1000);
    }
}

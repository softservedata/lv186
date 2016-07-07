package com.softserve.edu.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FourthTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
//        System.setProperty("webdriver.chrome.driver",
//                "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
//        driver = new ChromeDriver();
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
        WebElement currentWebElement;
        Actions action = new Actions(driver);
        //
        driver.get("https://www.google.com.ua/");
        Thread.sleep(1000);
        //
        driver.findElement(By.name("q")).sendKeys("Selenium IDE");
        Thread.sleep(1000);
        driver.findElement(By.name("btnG")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Selenium IDE Plugins")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Download")).click();
        Thread.sleep(2000);
        //
        currentWebElement = driver.findElement(By.xpath("//div[contains(text(),'CSV File Reader')]"));
        action.moveToElement(currentWebElement).perform();
        Assert.assertEquals(currentWebElement.getText(),"CSV File Reader","ERROR");
        Thread.sleep(2000);
        //
        currentWebElement = driver.findElement(By.name("selenium_ide")).findElement(By.tagName("h3"));
        action.moveToElement(currentWebElement).perform();
        Assert.assertEquals(currentWebElement.getText(),"Selenium IDE","ERROR");
        Thread.sleep(1000);
    }

}

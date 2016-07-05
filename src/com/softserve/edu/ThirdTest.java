package com.softserve.edu;

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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class ThirdTest {
    private WebDriver driver;
    private boolean isTestCompleted;

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

    @BeforeMethod
    public void beforeMethod() {
        isTestCompleted = false;  
    }

    @AfterMethod
    public void afterMethod() throws IOException {
        if (!isTestCompleted) {
            // takeScreenShort
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("./screenshot.png"));
        }
    }

    //@Test
    public void testComments() throws Exception {
        boolean isWebElementFound = false;
        driver.get("http://commentssprintone.azurewebsites.net");
        Thread.sleep(1000);
        //
        driver.findElement(By.partialLinkText("New")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("Text")).sendKeys("Privet From Lv");
        Thread.sleep(1000);
        driver.findElement(By.id("Number")).sendKeys("128");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'Cat0')]/preceding-sibling::input[@id='Categories']")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("CurSelect")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@value='Save']")).click();
        Thread.sleep(1000);
        driver.findElement(By.partialLinkText("Return")).click();
        //
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(2, TimeUnit.SECONDS)
                .pollingEvery(500, TimeUnit.NANOSECONDS)
                .ignoring(Exception.class);
                //.ignoring(NoSuchElementException.class);
                //.ignoring(TimeoutException.class);
        WebElement comment = null;
        while (!isWebElementFound) {
            //comment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Privet From Lv')]")));
            comment = wait.until(
                    new Function<WebDriver, WebElement>() {
                        @Override
                        public WebElement apply(WebDriver driver) {
                            return driver.findElement(By.xpath("//td[contains(text(),'Privet From Lv')]"));
                        }
                      }
                    );
            if (comment != null) {
                isWebElementFound = true;
            } else {
                //WebElement next = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(">")));
                WebElement next = wait.until(
                        new Function<WebDriver, WebElement>() {
                            @Override
                            public WebElement apply(WebDriver driver) {
                              return driver.findElement(By.linkText(">"));
                            }
                          }
                        );
                if (next != null) {
                    next.click();
                } else {
                    break;
                }
            }
        }
        Assert.assertTrue(isWebElementFound);
        Assert.assertNotNull(comment);
        Assert.assertEquals(comment.getText(), "Privet From Lv", "+++");
        Thread.sleep(1000);
        isTestCompleted = true;
    }

    @Test
    public void testComments2() throws Exception {
        boolean isWebElementFound = false;
        driver.get("http://commentssprintone.azurewebsites.net");
        Thread.sleep(1000);
        //
        driver.findElement(By.partialLinkText("New")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("Text")).sendKeys("Privet From Lv");
        Thread.sleep(1000);
        driver.findElement(By.id("Number")).sendKeys("128");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'Cat0')]/preceding-sibling::input[@id='Categories']")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("CurSelect")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@value='Save']")).click();
        Thread.sleep(1000);
        //int i=1/0;
        driver.findElement(By.partialLinkText("Return")).click();
        //
        List<WebElement> comments = null;
        WebElement comment = null;
        while (!isWebElementFound) {
            comments = driver.findElements(By.xpath("//td[contains(text(),'Privet From Lv')]"));
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
        Assert.assertEquals(comment.getText(), "Privet From Lv", "+++");
        Thread.sleep(1000);
        isTestCompleted = true;
    }

}

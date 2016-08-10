package com.softserve.edu.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.tools.IBrowser.BrowsersList;

public class FifthTest {
    
    @DataProvider
    public Object[][] driverParameters() {
        System.out.println("surefire.reports.directory = " 
                + System.getProperty("surefire.reports.directory"));
        System.out.println("surefire.webdriver.name = " 
                + System.getProperty("surefire.webdriver.name"));
        return new Object[][] {
            //{ BrowsersList.HTMLUNIT_TEMPORARY },
            { BrowsersList.FIREFOX_TEMPORARY },
            { BrowsersList.CHROME_TEMPORARY }
            };
    }

    @Test(dataProvider = "driverParameters")
    public void testSeleniumIDE(BrowsersList browser) throws Exception {
        WebDriver driver = browser.getWebDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //
        WebElement currentWebElement;
        Actions action = new Actions(driver);
        //
        driver.get("https://www.google.com.ua/");
        Thread.sleep(1000);
        //
        driver.findElement(By.name("q")).sendKeys("Selenium IDE");
        System.out.println(".sendKeys(Selenium IDE) DONE");
        Thread.sleep(1000);
        //driver.findElement(By.name("q")).submit();
        driver.findElement(By.name("btnG")).click();
        System.out.println("By.name(btnG)).click() DONE");
        Thread.sleep(1000);
        driver.findElement(By.linkText("Selenium IDE Plugins")).click();
        System.out.println("By.linkText(Selenium IDE Plugins)).click() DONE");
        Thread.sleep(1000);
        driver.findElement(By.linkText("Download")).click();
        Thread.sleep(2000);
        //
        currentWebElement = driver.findElement(By.xpath("//div[contains(text(),'CSV File Reader')]"));
        action.moveToElement(currentWebElement).perform();
        Assert.assertEquals(currentWebElement.getText(), "CSV File Reader", "ERROR");
        Thread.sleep(2000);
        //
        currentWebElement = driver.findElement(By.name("selenium_ide")).findElement(By.tagName("h3"));
        action.moveToElement(currentWebElement).perform();
        Assert.assertEquals(currentWebElement.getText(), "Selenium IDE", "ERROR");
        Thread.sleep(1000);
        //
        driver.quit();
    }

}

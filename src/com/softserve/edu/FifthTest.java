package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.IBrowser.BrowsersList;

public class FifthTest {
    
    @DataProvider
    public Object[][] driverParameters() {
        return new Object[][] {
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

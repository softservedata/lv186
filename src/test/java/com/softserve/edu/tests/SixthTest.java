package com.softserve.edu.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.tools.BrowserManager;
import com.softserve.edu.tools.IBrowser.BrowsersList;
import com.softserve.edu.tools.ListUtils;

public class SixthTest {
    
    @DataProvider//(parallel = true)
    public Object[][] driverParameters(ITestContext context) {
        return ListUtils.get().toMultiArray(BrowserManager.get().prepareBrowser(context));
//        return new Object[][] {
//            { BrowsersList.HTMLUNIT_TEMPORARY },
//            //{ BrowsersList.FIREFOX_TEMPORARY },
//            //{ BrowsersList.CHROME_TEMPORARY }
//            };
    }

    @Test(dataProvider = "driverParameters")
    public void testSeleniumIDE(BrowsersList browser) throws Exception {
        WebDriver driver = browser.getWebDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //
        driver.get("http://www.google.com");
        System.out.println("\tdriver.get http://www.google.com DONE");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Cheese!");
        System.out.println("\telement.sendKeys Cheese! DONE");
        System.out.println("\tPage title is: " + driver.getTitle());
        element.submit();
        //WebDriverWait wait = new WebDriverWait(driver, 5);
        //wait.until(ExpectedConditions.titleContains("Cheese"));
        (new WebDriverWait(driver, 5)).until(ExpectedConditions.titleContains("Cheese"));
        System.out.println("\tPage title is: " + driver.getTitle());
        //
        driver.findElement(By.partialLinkText("Cheese - Wikipedia")).click();
        System.out.println("\tElement is " + driver.findElement(By.id("firstHeading")).getText());
        Assert.assertEquals(driver.findElement(By.id("firstHeading")).getText(), "Cheese");
        Thread.sleep(2000);
        driver.quit();
    }

}

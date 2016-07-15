package com.softserve.edu.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SecondTest {
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

    //@Test
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

    //@Test
    public void testLocalOMS() throws Exception {
        driver.get("http://ssu-oms:8180/OMS/");
        Thread.sleep(2000);
        ((JavascriptExecutor)driver).executeScript("$('.all').fadeOut(1500);");
        Thread.sleep(2000);
        ((JavascriptExecutor)driver).executeScript("$('.all').fadeIn(1500);");
        Thread.sleep(2000);
        ((JavascriptExecutor)driver).executeScript("alert('PRIVET')");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        WebElement element = (WebElement)
                ((JavascriptExecutor)driver)
                        .executeScript("return $('.all')[0]");
        System.out.println("WebElement Context: " + element.getText());
    }

    //@Test
    public void testLocalOMS2() throws Exception {
        driver.get("http://ssu-oms:8180/OMS/");
        //
        WebElement login = driver.findElement(By.name("j_username"));
        login.sendKeys("ha-ha-ha");
        Thread.sleep(2000);
        driver.navigate().refresh();
        //
//        login.click();
//        login.clear();
//        login.sendKeys("login");
        driver.findElement(By.name("j_username")).click();
        driver.findElement(By.name("j_username")).clear();
        driver.findElement(By.name("j_username")).sendKeys("login");
        //
//        WebElement passwd = driver.findElement(By.name("j_password"));
//        passwd.click();
//        passwd.clear();
//        passwd.sendKeys("password");
        driver.findElement(By.name("j_password")).click();
        driver.findElement(By.name("j_password")).clear();
        driver.findElement(By.name("j_password")).sendKeys("password");
        //
        Thread.sleep(2000);
    }

    @Test
    public void testLocal() throws Exception {
        driver.get("file:///D:/Temp/5/aa.html");
        Thread.sleep(1000);
        WebElement hidden = driver.findElement(By.name("MyHidden"));
        //
//        WebElement hidden = (new WebDriverWait(driver, 5))
//                .until(ExpectedConditions.presenceOfElementLocated(By.name("MyHidden")));
        //
//        WebElement hidden = (new WebDriverWait(driver, 5))
//                .until(ExpectedConditions.visibilityOfElementLocated(By.name("MyHidden")));
        //
        System.out.println("Result: " + hidden.getAttribute("value"));
        System.out.println("is Displayed = " + hidden.isDisplayed());
        System.out.println("is Enabled = " + hidden.isEnabled());
        System.out.println("is Selected= " + hidden.isSelected());
        Thread.sleep(1000);
    }

}

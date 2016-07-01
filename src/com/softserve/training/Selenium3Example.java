package com.softserve.training;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium3Example {

    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        //WebDriver driver = new HtmlUnitDriver();
        WebDriver driver = new FirefoxDriver();
        //
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // !!! 0 by default
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        //
        driver.get("http://java.training.local:8080/registrator/login");
        //
        driver.findElement(By.id("login")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin");
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
        //
        Thread.sleep(2000);
        //
        driver.get("file:///D:/Temp/5/aa.html");
        Thread.sleep(1000);
        driver.findElement(By.name("MyButton")).click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        driver.findElement(By.name("q")).sendKeys("Hello");
        driver.findElement(By.name("Mysubmit")).click();
        //
        // Close the browser
        Thread.sleep(2000);
        driver.quit();
    }
}

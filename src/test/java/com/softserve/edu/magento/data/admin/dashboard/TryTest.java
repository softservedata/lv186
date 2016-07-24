package com.softserve.edu.magento.data.admin.dashboard;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TryTest {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
		driver.get("http://192.168.195.210/magento/admin/");
		driver.findElement(By.id("username")).sendKeys("bmakatc");
		driver.findElement(By.id("login")).sendKeys("qwerty-1");
		driver.findElement(By.cssSelector("button.action-login.action-primary")).click();;
		List<WebElement> lastOrdersRecords = driver.findElements(By
        		.cssSelector("#lastOrdersGrid_table tbody tr"));
	List<String> str =	SearchFromRecords.getElementsText(SearchFromRecords.getElements(lastOrdersRecords, "td.col-customer"));
	System.out.println(str.toString());
	}
}

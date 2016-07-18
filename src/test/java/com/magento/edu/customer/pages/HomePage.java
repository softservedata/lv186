package com.magento.edu.customer.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.magento.edu.customer.components.HeaderPanel;

public class HomePage extends HeaderPanel {
 
 public WebElement contentMessage;
 
 public HomePage(WebDriver driver) {
	 super(driver);
	 this.contentMessage = driver.findElement(By.xpath("//div[@class='column main']/p"));
 }
 //setters
public void setContecntMessage(WebElement contecntMessage) {
	this.contentMessage = contecntMessage;
}
//getters
public WebElement getContentMessage() {
	return contentMessage;
}
// business logic 
public String getContentMessageText() {
	return this.getContentMessage().getText();
}

}

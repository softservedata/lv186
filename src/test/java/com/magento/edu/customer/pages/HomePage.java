package com.magento.edu.customer.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	 
private WebElement contentMessage;
 
protected HomePage(WebDriver driver) {
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

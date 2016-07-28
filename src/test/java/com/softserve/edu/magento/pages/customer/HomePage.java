package com.softserve.edu.magento.pages.customer;

import org.openqa.selenium.WebElement;

import com.softserve.edu.magento.tools.Search;

public class HomePage {
	 
private WebElement contentMessage;
 
protected HomePage() {
	 this.contentMessage = Search.xpath("//div[@class='column main']/p");
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

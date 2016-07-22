package com.softserve.edu.magento.pages.menu.products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductValidatorPage extends AddProductPage {

	private WebElement productNameValidator;
	private WebElement skuValidator;
	private WebElement priceValidator;

	public ProductValidatorPage(WebDriver driver) {
		super(driver);
		productNameValidator = driver.findElement(By.xpath("(//label[@class='admin__field-error'])[1]"));
		skuValidator = driver.findElement(By.xpath("(//label[@class='admin__field-error'])[2]"));
		priceValidator = driver.findElement(By.xpath("(//label[@class='admin__field-error'])[3]"));
		// if (verifyElementExists(productNameValidatorXPath)) {
		// this.productNameValidator =
		// driver.findElement(productNameValidatorXPath);
		// }
		// if (verifyElementExists(skuValidatorXPath)) {
		// this.skuValidator = driver.findElement(skuValidatorXPath);
		// }
		// if (verifyElementExists(priceValidatorXPath)) {
		// this.priceValidator = driver.findElement(priceValidatorXPath);
		// }
	}

	// public boolean doesProductNameValidatorExist() {
	// return productNameValidator != null;
	// }
	//
	// public boolean doesSkuValidatorExist() {
	// return skuValidator != null;
	// }
	//
	// public boolean doesPriceValidatorExist() {
	// return priceValidator != null;
	// }

	// Getters

	public WebElement getProductNameValidator() {
		return this.productNameValidator;
	}

	public WebElement getSkuValidator() {
		return this.skuValidator;
	}

	public WebElement getPriceValidator() {
		return this.priceValidator;
	}

	public String getProductNameValidatorText() {
		return getProductNameValidator().getText().trim();
	}

	public String getSkuValidatorText() {
		return getSkuValidator().getText().trim();
	}

	public String getPriceValidatorText() {
		return getPriceValidator().getText().trim();
	}

}

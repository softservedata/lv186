package com.softserve.edu.magento.pages.menu.products;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductValidatorPage extends AddProductPage {

	private List<WebElement> productNameValidators;
	private List<WebElement> skuValidators;
	private List<WebElement> priceValidators;

	private WebElement productNameValidator;
	private WebElement skuValidator;
	private WebElement priceValidator;

	public ProductValidatorPage(WebDriver driver) {
		super(driver);
		// productNameValidator =
		// driver.findElement(By.xpath("(//label[@class='admin__field-error'])[1]"));
		// skuValidator =
		// driver.findElement(By.xpath("(//label[@class='admin__field-error'])[2]"));
		// priceValidator =
		// driver.findElement(By.xpath("(//label[@class='admin__field-error'])[3]"));

		productNameValidators = driver.findElements(By.xpath("(//label[@class='admin__field-error'])[1]"));
		skuValidators = driver.findElements(By.xpath("(//label[@class='admin__field-error'])[2]"));
		priceValidators = driver.findElements(By.xpath("(//label[@class='admin__field-error'])[3]"));

		if (productNameValidators.size() > 0) {
			this.productNameValidator = productNameValidators.get(0);
		}
		if (skuValidators.size() > 0) {
			this.skuValidator = skuValidators.get(0);
		}
		if (priceValidators.size() > 0) {
			this.priceValidator = priceValidators.get(0);
		}
	}

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

	// Functional

	public boolean isProductNameValidatorPresent() {
		return productNameValidator != null;
	}

	public boolean isSkuValidatorPresent() {
		return skuValidator != null;
	}

	public boolean isPriceValidatorPresent() {
		return priceValidator != null;
	}

}

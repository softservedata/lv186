package com.softserve.edu.magento.pages.admin.menu.products;

import java.util.List;


import org.openqa.selenium.WebElement;

import com.softserve.edu.magento.tools.Search;

public class ProductValidatorPage extends AddProductPage {

	private List<WebElement> productNameValidators;
	private List<WebElement> skuValidators;
	private List<WebElement> priceValidators;

	private WebElement productNameValidator;
	private WebElement skuValidator;
	private WebElement priceValidator;

	public ProductValidatorPage() {

		productNameValidators = Search.xpaths("(//label[@class='admin__field-error'])[1]");
		skuValidators = Search.xpaths("(//label[@class='admin__field-error'])[2]");
		priceValidators = Search.xpaths("(//label[@class='admin__field-error'])[3]");

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
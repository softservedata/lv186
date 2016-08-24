package com.softserve.edu.magento.pages.admin.menu.products;

import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.WebElement;

import com.softserve.edu.magento.tools.Search;

public class ProductValidatorPage extends AddProductPage {

	private WebElement productNameValidator;
	private WebElement skuValidator;
	private WebElement priceValidator;

	public ProductValidatorPage() {

//		WebElement productNameContainer = Search.xpath("//div[@data-index='name']");
//		List<WebElement> productNameValidators = Search.xpaths("//label[@class='admin__field-error']", productNameContainer);
//		WebElement skuContainer = Search.xpath("//div[@data-index='sku']");
//		List<WebElement> skuValidators = Search.xpaths("(//label[@class='admin__field-error'])", skuContainer);
//		WebElement priceContainer = Search.xpath("//fieldset[@data-index='container_price']");
//		List<WebElement> priceValidators = Search.xpaths("(//label[@class='admin__field-error'])", priceContainer);

		List<WebElement> productNameValidators = Search.xpaths("//div[@data-index='name']//label[@class='admin__field-error']");
		List<WebElement> skuValidators = Search.xpaths("(//div[@data-index='sku']//label[@class='admin__field-error'])");
		List<WebElement> priceValidators = Search.xpaths("(//fieldset[@data-index='container_price']//label[@class='admin__field-error'])");

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

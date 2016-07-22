package com.softserve.edu.magento.pages.menu.products;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.magento.data.IProduct;
import com.softserve.edu.magento.pages.VerticalMenu;

public class AddProductPage extends VerticalMenu {

	// Elements

	private WebElement saveButton;
	private WebElement saveDropdownToggle;
	private WebElement saveAndNewButton;
	private WebElement saveAndDuplicateButton;
	private WebElement saveAndCloseButton;
	private WebElement backButton;
	private WebElement addAttributeButton;

	private WebElement enableProductButton;
	private WebElement attributeSetInput;
	private WebElement productNameInput;
	private WebElement skuInput;
	private WebElement priceInput;
	private WebElement quantityInput;

	public AddProductPage(WebDriver driver) {
		super(driver);
		saveButton = driver.findElement(By.id("save-button"));
		saveDropdownToggle = driver.findElement(By.cssSelector("button[title=Save]:nth-child(2)"));
		saveAndNewButton = driver.findElement(By.id("save_and_new"));
		saveAndDuplicateButton = driver.findElement(By.id("save_and_duplicate"));
		saveAndCloseButton = driver.findElement(By.id("save_and_close"));
		backButton = driver.findElement(By.id("back"));
		addAttributeButton = driver.findElement(By.id("addAttribute"));
		enableProductButton = driver
				.findElement(By.xpath("//*[@id='container']/div/div[2]/div[1]/div/fieldset/div[1]/div/div"));
		attributeSetInput = driver.findElement(By.xpath("//*[@id='container']/div/div[2]/div[1]/div/fieldset/div[2]"));
		productNameInput = driver.findElement(By.cssSelector("input[name='product[name]']"));
		skuInput = driver.findElement(By.cssSelector("input[name='product[sku]']"));
		priceInput = driver.findElement(By.cssSelector("input[name='product[price]']"));
		quantityInput = driver.findElement(
				By.cssSelector(".admin__field-small input[name='product[quantity_and_stock_status][qty]']"));
	}

	// Getters

	public WebElement getEnableProductButtonStatus() {
		return this.enableProductButton;
	}

	public WebElement getAttributeSetInput() {
		return this.attributeSetInput;
	}

	public WebElement getProductNameInput() {
		return this.productNameInput;
	}

	public WebElement getSkuInput() {
		return this.skuInput;
	}

	public WebElement getPriceInput() {
		return this.priceInput;
	}

	public WebElement getQuantityInput() {
		return this.quantityInput;
	}

	public WebElement getSaveButton() {
		return this.saveButton;
	}

	public WebElement getSaveDropdownToggle() {
		return this.saveDropdownToggle;
	}

	public WebElement getSaveAndNewButton() {
		return this.saveAndNewButton;
	}

	public WebElement getSaveAndDuplicateButton() {
		return this.saveAndDuplicateButton;
	}

	public WebElement getSaveAndCloseButton() {
		return this.saveAndCloseButton;
	}

	public WebElement getBackButton() {
		return this.backButton;
	}

	public WebElement getAddAttributeButton() {
		return this.addAttributeButton;
	}

	public String getAttributeSetInputText() {
		return getAttributeSetInput().getText().trim();
	}

	public String getProductNameInputText() {
		return this.getProductNameInput().getText().trim();
	}

	public String getSkuInputText() {
		return this.getSkuInput().getText().trim();
	}

	public String getPriceInputText() {
		return this.getPriceInput().getText().trim();
	}

	public String getQuantityInputText() {
		return this.getQuantityInput().getText().trim();
	}

	// Setters

	public void setProductName(String productName) {
		getProductNameInput().sendKeys(productName);
	}

	public void setSku(String sku) {
		getSkuInput().sendKeys(sku);
	}

	public void setPrice(String price) {
		getPriceInput().sendKeys(price);
	}

	public void setQuantity(String quantity) {
		getQuantityInput().sendKeys(quantity);
	}

	public void clearProductNameInput() {
		getProductNameInput().clear();
	}

	public void clearSkuInput() {
		getSkuInput().clear();
	}

	public void clearPriceInput() {
		getPriceInput().clear();
	}

	public void clearQuantityInput() {
		getQuantityInput().clear();
	}

	public void changeEnableProductButtonStatus() {
		getEnableProductButtonStatus().click();
	}

	public void clickSaveButton() {
		getSaveButton().click();
	}

	public void clickSaveDropdownToggle() {
		getSaveDropdownToggle().click();
	}

	public void clickSaveAndNewButton() {
		clickSaveDropdownToggle();
		getSaveAndNewButton().click();
	}

	public void clickSaveAndDuplicateButton() {
		clickSaveDropdownToggle();
		getSaveAndDuplicateButton().click();
	}

	public void clickSaveAndCloseButton() {
		clickSaveDropdownToggle();
		getSaveAndCloseButton().click();
	}

	public void clickBackButton() {
		getBackButton().click();
	}

	public void clickAddAttributeButton() {
		getAddAttributeButton().click();
	}

	// set Data Business Logic

	public void setProductNameInputWithClear(String productName) {
		clearProductNameInput();
		setProductName(productName);
	}

	public void setSkuInputWithClear(String sku) {
		clearSkuInput();
		setSku(sku);
	}

	public void setPriceInputWithClear(String price) {
		clearPriceInput();
		setPrice(price);
	}

	public void setQuantityInputWithClear(String quantity) {
		clearQuantityInput();
		setQuantity(quantity);
	}

	public void setProductData(IProduct productData) {
		setAttributeSet(productData.getAttributeSet());
		setProductName(productData.getProductName());
		setSku(productData.getSku());
		setPrice(productData.getPrice());
	}

	public void setAttributeSet(String attributeSet) {
		attributeSetInput.click();
		List<WebElement> listsOfDropdownItems = driver
				.findElements(By.className("admin__action-multiselect-menu-inner"));
		WebElement listOfAttributeSets = listsOfDropdownItems.get(0);
		List<WebElement> attributeSetValues = listOfAttributeSets
				.findElements(By.className("admin__action-multiselect-label"));
		for (WebElement currentAttributeSet : attributeSetValues) {
			if (currentAttributeSet.getText().equals(attributeSet)) {
				currentAttributeSet.click();
				break;
			}
		}
	}

	public ProductCatalogPage returnToProductPage() {
		clickBackButton();
		return new ProductCatalogPage(driver);
	}

	public ProductCatalogPage gotoProductCatalogPage() {
		clickSaveAndCloseButton();
		return new ProductCatalogPage(driver);
	}

	public SuccessProductSavePage gotoSuccessProductSavePage() {
		clickSaveButton();
		return new SuccessProductSavePage(driver);
	}

	public SuccessProductSaveAndDuplicatePage gotoSuccessProductSaveAndDuplicatePage() {
		clickSaveButton();
		return new SuccessProductSaveAndDuplicatePage(driver);
	}

	public ProductExistsPage gotoProductExistsPage() {
		clickSaveButton();
		return new ProductExistsPage(driver);
	}

	public ProductValidatorPage gotoProductValidatorPage() {
		clickSaveButton();
		return new ProductValidatorPage(driver);
	}

}

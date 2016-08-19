package com.softserve.edu.magento.pages.admin.menu.products;

import java.util.List;

import org.apache.http.util.TextUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.softserve.edu.magento.data.admin.products.IProduct;
import com.softserve.edu.magento.pages.admin.VerticalMenu;
import com.softserve.edu.magento.tools.Search;

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

	public AddProductPage() {
		saveButton = Search.id("save-button");
		saveDropdownToggle = Search.cssSelector("button[title=Save]:nth-child(2)");
		saveAndNewButton = Search.id("save_and_new");
		saveAndDuplicateButton = Search.id("save_and_duplicate");
		saveAndCloseButton = Search.id("save_and_close");
		backButton = Search.id("back");
		addAttributeButton = Search.id("addAttribute");
		enableProductButton = Search.xpath("(//div[@class='admin__actions-switch'])[1]");
		attributeSetInput = Search.xpath("//*[@id='container']/div/div[2]/div[1]/div/fieldset/div[2]");
		productNameInput = Search.cssSelector("input[name='product[name]']");
		skuInput = Search.cssSelector("input[name='product[sku]']");
		priceInput = Search.cssSelector("input[name='product[price]']");
		quantityInput = Search.cssSelector(".admin__field-small input[name='product[quantity_and_stock_status][qty]']");
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
		//(new WebDriverWait(SearchRecords, 10).until(ExpectedConditions.elementToBeClickable(getSaveButton());
		getSaveButton().click();
	}

	public void clickSaveDropdownToggle() {
		//(new WebDriverWait(SearchRecords, 10).until(ExpectedConditions.elementToBeClickable(getSaveDropdownToggle());
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
		if (!TextUtils.isEmpty(productData.getAttributeSet())) {
			setAttributeSet(productData.getAttributeSet());
		}
		setProductNameInputWithClear(productData.getProductName());
		setSkuInputWithClear(productData.getSku());
		setPriceInputWithClear(productData.getPrice());
	}

	public void setAttributeSet(String attributeSet) {
		attributeSetInput.click();
		List<WebElement> listsOfDropdownItems = Search
				.classNames("admin__action-multiselect-menu-inner");
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

	// Functional

	public ProductCatalogPage returnToProductPage() {
		clickBackButton();
		return new ProductCatalogPage();
	}

	public SuccessProductSavePage gotoSuccessProductSavePageAfterSave() {
		clickSaveButton();
		return new SuccessProductSavePage();
	}

	public SuccessProductSavePage gotoSuccessProductSavePageAfterSaveAndNew() {
		clickSaveAndNewButton();
		return new SuccessProductSavePage();
	}

	public SuccessProductSaveAndDuplicatePage gotoSuccessProductSaveAndDuplicatePage() {
		clickSaveButton();
		return new SuccessProductSaveAndDuplicatePage();
	}

	public ProductCatalogPage gotoProductCatalogPage() {
		clickSaveAndCloseButton();
		return new ProductCatalogPage();
	}

	public ProductExistsPage gotoProductExistsPageAfterSave() {
		clickSaveButton();
		return new ProductExistsPage();
	}

	public ProductExistsPage gotoProductExistsPageAfterSaveAndNew() {
		clickSaveAndNewButton();
		return new ProductExistsPage();
	}

	public ProductExistsPage gotoProductExistsPageAfterSaveAndDuplicate() {
		clickSaveAndDuplicateButton();
		return new ProductExistsPage();
	}

	public ProductExistsPage gotoProductExistsPageAfterSaveAndClose() {
		clickSaveAndCloseButton();
		return new ProductExistsPage();
	}

	public ProductValidatorPage gotoProductValidatorPageAfterSave() {
		clickSaveButton();
		return new ProductValidatorPage();
	}

	public ProductValidatorPage gotoProductValidatorPageAfterSaveAndNew() {
		clickSaveAndNewButton();
		return new ProductValidatorPage();
	}

	public ProductValidatorPage gotoProductValidatorPageAfterSaveAndDuplicate() {
		clickSaveAndDuplicateButton();
		return new ProductValidatorPage();
	}

	public ProductValidatorPage gotoProductValidatorPageAfterSaveAndClose() {
		clickSaveAndCloseButton();
		return new ProductValidatorPage();
	}
}

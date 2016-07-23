package com.softserve.edu.magento.pages.menu.products;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.magento.data.FilterData;
import com.softserve.edu.magento.pages.VerticalMenu;

public class ProductCatalogPage extends VerticalMenu {

	// Fields

	protected WebDriver driver;

	private WebElement addProductButton;
	private WebElement addProductToggleButton;
	private WebElement simpleProductButton;
	private WebElement configurableProductButton;
	private WebElement groupedProductButton;
	private WebElement virtualProductButton;
	private WebElement bundleProductButton;
	private WebElement downloadableProductButton;

	private WebElement actionsDropdown;
	private WebElement deleteProductButton;
	private WebElement changeProductStatusButton;
	private WebElement updateProductAttributesButton;

	private WebElement nextPageButton;
	private List<ProductRow> productRows;
	private Filter filter;

	public ProductCatalogPage(WebDriver driver) {
		super(driver);
		addProductButton = driver.findElement(By.id("add_new_product-button"));
		addProductToggleButton = driver.findElement(By.className("action-toggle"));
		simpleProductButton = driver.findElement(By.cssSelector("span[title='Simple Product']"));
		configurableProductButton = driver.findElement(By.cssSelector("span[title='Configurable Product']"));
		groupedProductButton = driver.findElement(By.cssSelector("span[title='Grouped Product']"));
		virtualProductButton = driver.findElement(By.cssSelector("span[title='Virtual Product']"));
		bundleProductButton = driver.findElement(By.cssSelector("span[title='Bundle Product']"));
		downloadableProductButton = driver.findElement(By.cssSelector("span[title='Downloadable Product']"));

		actionsDropdown = driver.findElement(By.cssSelector("col-xs-2 .action-select-wrap"));
		deleteProductButton = driver
				.findElement(By.xpath("(//div[@class='action-menu-items']//span[contains(text(), 'Delete')])[1]"));
		changeProductStatusButton = driver
				.findElement(By.xpath("(//div[@class='action-menu-items']//span[contains(text(), 'Change')])[1]"));
		updateProductAttributesButton = driver
				.findElement(By.xpath("(//div[@class='action-menu-items']//span[contains(text(), 'Update')])[1]"));

		nextPageButton = driver.findElement(By.cssSelector("button[title='Next Page']"));
		productRows = new ArrayList<ProductRow>();
		List<WebElement> productRowsSource = driver.findElements(By.cssSelector("tbody tr"));
		for (WebElement row : productRowsSource) {
			ProductRow productRow = new ProductRow(row);
			productRows.add(productRow);
		}

		filter = new Filter();
	}

	// Getters

	public WebElement getAddProductButton() {
		return this.addProductButton;
	}

	public WebElement getAddProductToggleButton() {
		return this.addProductToggleButton;
	}

	public WebElement getSimpleProductButton() {
		return this.simpleProductButton;
	}

	public WebElement getConfigurableProductButton() {
		return this.configurableProductButton;
	}

	public WebElement getGroupedProductButton() {
		return this.groupedProductButton;
	}

	public WebElement getVirtualProductButton() {
		return this.virtualProductButton;
	}

	public WebElement getBundleProductButton() {
		return this.bundleProductButton;
	}

	public WebElement getDownloadableProductButton() {
		return this.downloadableProductButton;
	}

	public WebElement getActionsDropdown() {
		return this.actionsDropdown;
	}

	public WebElement getDeleteProductAction() {
		return this.deleteProductButton;
	}

	public WebElement getChangeStatusProductAction() {
		return this.changeProductStatusButton;
	}

	public WebElement getUpdateProductAttributesAction() {
		return this.updateProductAttributesButton;
	}

	public WebElement getNextPageButton() {
		return this.nextPageButton;
	}

	public Filter getFilter() {
		return this.filter;
	}

	// Setters
	public void clickAddProductButton() {
		getAddProductButton().click();
	}

	public void clickAddProductToggleButton() {
		getAddProductToggleButton().click();
	}

	public void clickSimpleProductButton() {
		getSimpleProductButton().click();
	}

	public void clickConfigurableProductButton() {
		getConfigurableProductButton().click();
	}

	public void clickGroupedProductButton() {
		getGroupedProductButton().click();
	}

	public void clickVirtualProductButton() {
		getVirtualProductButton().click();
	}

	public void clickBundleProductButton() {
		getBundleProductButton().click();
	}

	public void clickDownloadableProductButton() {
		getDownloadableProductButton().click();
	}

	public void clickActionsDropdown() {
		getActionsDropdown().click();
	}

	public void clickDeleteProductAction() {
		clickActionsDropdown();
		getDeleteProductAction().click();
	}

	public void clicChangeStatusProductAction() {
		clickActionsDropdown();
		getChangeStatusProductAction().click();
	}

	public void clickUpdateProductAttributesAction() {
		clickActionsDropdown();
		getUpdateProductAttributesAction().click();
	}

	// Functional Business Logic

	public AddProductPage gotoAddProductPage() {
		clickAddProductButton();
		return new AddProductPage(driver);
	}

	public ProductRow getRowWithProductName(String productName) {
		for (ProductRow row : productRows) {
			if (row.getProductNameText().equals(productName)) {
				return row;
			}
		}
		return null;
	}

	public ProductCatalogPage moveToNextPage() {
		nextPageButton.click();
		return new ProductCatalogPage(driver);
	}

	public boolean checkNextPageButtonIsEnabled() {
		if (getNextPageButton().isEnabled()) {
			return true;
		} else {
			return false;
		}
	}

	public List<ProductRow> getProducts() {
		return productRows;
	}

	// -------- ProductRowInnerClass ---------//

	public class ProductRow {
		private WebElement productCheckbox;
		private WebElement productId;
		private WebElement productName;
		private WebElement productType;
		private WebElement productAttributeSet;
		private WebElement productSku;
		private WebElement productPrice;
		private WebElement productQuantity;
		private WebElement productVisibility;
		private WebElement productStatus;
		private WebElement productWebsites;
		private WebElement productActions;
		private WebElement noProductFound;

		private ProductRow(WebElement row) {
			productCheckbox = row.findElement(By.cssSelector("td:first-child"));
			productId = row.findElement(By.cssSelector("td:nth-child(2)"));
			productName = row.findElement(By.cssSelector("td:nth-child(4)"));
			productType = row.findElement(By.cssSelector("td:nth-child(5)"));
			productAttributeSet = row.findElement(By.cssSelector("td:nth-child(6)"));
			productSku = row.findElement(By.cssSelector("td:nth-child(7)"));
			productPrice = row.findElement(By.cssSelector("td:nth-child(8)"));
			productQuantity = row.findElement(By.cssSelector("td:nth-child(9)"));
			productVisibility = row.findElement(By.cssSelector("td:nth-child(10)"));
			productStatus = driver.findElement(By.cssSelector("td:nth-child(11)"));
			productWebsites = row.findElement(By.cssSelector("td:nth-child(12)"));
			productActions = driver.findElement(By.cssSelector("td:nth-child(13)"));
			noProductFound = driver.findElement(By.className("data-grid-tr-no-data"));
		}

		public WebElement getProductCheckbox() {
			return this.productCheckbox;
		}

		public WebElement getProductAction() {
			return this.productActions;
		}

		public boolean isProductCheckboxSelected() {
			return getProductCheckbox().isSelected();
		}

		public String getProductIdText() {
			return productId.getText();
		}

		public String getProductNameText() {
			return productName.getText();
		}

		public String getProductTypeText() {
			return productType.getText();
		}

		public String getProductAttributeSetText() {
			return productAttributeSet.getText();
		}

		public String getProductSkuText() {
			return productSku.getText();
		}

		public String getProductPriceText() {
			return productPrice.getText();
		}

		public String getProductQuantityText() {
			return productQuantity.getText();
		}

		public String getProductVisibilityText() {
			return productVisibility.getText();
		}

		public String getProductStatusText() {
			return productStatus.getText();
		}

		public String getProductWebsitesText() {
			return productWebsites.getText();
		}

		public String getNoProductFoundMessage() {
			return noProductFound.getText();
		}

		public void editProduct() {
			getProductAction().click();
		}

		public void selectProduct() {
			getProductCheckbox().click();
		}
	}

	// -------- FilterInnerClass ---------//

	public class Filter {
		private WebElement filterButton;
		private WebElement filterIdFromInput;
		private WebElement filterIdToInput;
		private WebElement filterPriceFromInput;
		private WebElement filterPriceToInput;
		private WebElement filterQuantityFromInput;
		private WebElement filterQuantityToInput;
		private WebElement filterNameInput;
		private WebElement filterSkuInput;
		private WebElement applyFiltersButton;
		private WebElement cancelFiltersButton;

		private Filter() {
			filterButton = driver.findElement(By.className("data-grid-filters-actions-wrap"));
			filterIdFromInput = driver.findElement(By.cssSelector("input[name='entity_id[from]']"));
			filterIdToInput = driver.findElement(By.cssSelector("input[name='entity_id[to]']"));
			filterPriceFromInput = driver.findElement(By.cssSelector("input[name='price[from]']"));
			filterPriceToInput = driver.findElement(By.cssSelector("input[name='price[to]']"));
			filterQuantityFromInput = driver.findElement(By.cssSelector("input[name='qty[from]']"));
			filterQuantityToInput = driver.findElement(By.cssSelector("input[name='qty[to]']"));
			filterNameInput = driver.findElement(By.cssSelector("input[name='name']"));
			filterSkuInput = driver.findElement(By.cssSelector("input[name='sku']"));
			applyFiltersButton = driver.findElement(By.className("action-secondary"));
			cancelFiltersButton = driver.findElement(By.cssSelector(".admin__footer-main-actions .action-tertiary"));
		}

		// Setters
		public void clickFilterButton() {
			filterButton.click();
		}

		public void clickFilterIdFromInput() {
			filterIdFromInput.click();
		}

		public void clickFilterIdToInput() {
			filterIdToInput.click();
		}

		public void clickFilterPriceFromInput() {
			filterPriceFromInput.click();
		}

		public void clickFilterPriceToInput() {
			filterPriceToInput.click();
		}

		public void clickFilterQuantityFromInput() {
			filterQuantityFromInput.click();
		}

		public void clickFilterQuantityToInput() {
			filterQuantityToInput.click();
		}

		public void clickFilterNameInput() {
			filterNameInput.click();
		}

		public void clickFilterSkuInput() {
			filterSkuInput.click();
		}

		public ProductCatalogPage applyFilters() {
			applyFiltersButton.click();
			return new ProductCatalogPage(driver);
		}

		public void clickCancelFiltersButton() {
			cancelFiltersButton.click();
		}

		public void clearFilterIdFromInput() {
			filterIdFromInput.clear();
		}

		public void clearFilterIdToInput() {
			filterIdToInput.clear();
		}

		public void clearFilterPriceFromInput() {
			filterPriceFromInput.clear();
		}

		public void clearFilterPriceToInput() {
			filterPriceToInput.clear();
		}

		public void clearFilterQuantityFromInput() {
			filterQuantityFromInput.clear();
		}

		public void clearFilterQuantityToInput() {
			filterQuantityToInput.clear();
		}

		public void clearFilterNameInput() {
			filterNameInput.clear();
		}

		public void clearSkuNameInput() {
			filterSkuInput.clear();
		}

		public void setFilterIdFromInput(String filterIdFrom) {
			filterIdFromInput.sendKeys(filterIdFrom);
		}

		public void setFilterIdToInput(String filterIdTo) {
			filterIdToInput.sendKeys(filterIdTo);
		}

		public void setFilterPriceFromInput(String filterPriceFrom) {
			filterPriceFromInput.sendKeys(filterPriceFrom);
		}

		public void setFilterPriceToInput(String filterPriceTo) {
			filterPriceToInput.sendKeys(filterPriceTo);
		}

		public void setFilterQuantityFromInput(String filterQuantityFrom) {
			filterQuantityFromInput.sendKeys(filterQuantityFrom);
		}

		public void setFilterQuantityToInput(String filterQuantityTo) {
			filterQuantityToInput.sendKeys(filterQuantityTo);
		}

		public void setFilterNameInput(String filterName) {
			filterNameInput.sendKeys(filterName);
		}

		public void setFilterSkuInput(String filterSku) {
			filterSkuInput.sendKeys(filterSku);
		}

		public void setFilterIdFromInputClear(String filterIdFrom) {
			clearFilterIdFromInput();
			setFilterIdFromInput(filterIdFrom);
		}

		public void setFilterIdToInputClear(String filterIdTo) {
			clearFilterIdToInput();
			setFilterIdToInput(filterIdTo);
		}

		public void setFilterPriceFromInputClear(String filterPriceFrom) {
			clearFilterPriceFromInput();
			setFilterPriceFromInput(filterPriceFrom);
		}

		public void setFilterPriceToInputClear(String filterPriceTo) {
			clearFilterPriceToInput();
			setFilterPriceToInput(filterPriceTo);
		}

		public void setFilterQuantityFromInputClear(String filterQuantityFrom) {
			clearFilterQuantityFromInput();
			setFilterQuantityFromInput(filterQuantityFrom);
		}

		public void setFilterQuantityToInputClear(String filterQuantityTo) {
			clearFilterQuantityToInput();
			setFilterQuantityToInput(filterQuantityTo);
		}

		public void setFilterNameInputClear(String filterName) {
			clearFilterNameInput();
			setFilterNameInput(filterName);
		}

		public void setFilterSkuInputClear(String filterSku) {
			clearFilterNameInput();
			setFilterSkuInput(filterSku);
		}

		public void setFilterData(FilterData filterData) {
			setFilterIdFromInputClear(filterData.getIdFrom());
			setFilterIdToInputClear(filterData.getIdTo());
			setFilterPriceFromInputClear(filterData.getPriceFrom());
			setFilterPriceToInputClear(filterData.getPriceTo());
			setFilterQuantityFromInputClear(filterData.getQuantityFrom());
			setFilterQuantityToInputClear(filterData.getQuantityTo());
			setFilterNameInputClear(filterData.getName());
			setFilterSkuInputClear(filterData.getSku());
		}

	}

	public class DeleteConfirmationPage {

		private WebElement deleteConfirmationButton;
		private WebElement cancelDeleteLink;
		private WebElement closeDeletePopupButton;

		public DeleteConfirmationPage() {
			deleteConfirmationButton = driver.findElement(By.className("action-accept"));
			cancelDeleteLink = driver.findElement(By.className("action-dismiss"));
			closeDeletePopupButton = driver.findElement(By.xpath("(//button[@data-role='closeBtn'])[2]"));
		}

		// Getters

		public WebElement getDeleteConfirmationButton() {
			return this.deleteConfirmationButton;
		}

		public WebElement getCancelDeleteLink() {
			return this.cancelDeleteLink;
		}

		public WebElement getCloseDeletePopupButton() {
			return this.closeDeletePopupButton;
		}

		// Setters

		public void clickDeleteConfirmationButton() {
			getDeleteConfirmationButton().click();
		}

		public void clickCancelDeleteLink() {
			getCancelDeleteLink().click();
		}

		public void clickCloseDeletePopupButton() {
			getCloseDeletePopupButton().click();
		}
	}

}
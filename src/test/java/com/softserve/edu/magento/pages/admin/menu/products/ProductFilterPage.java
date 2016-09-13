package com.softserve.edu.magento.pages.admin.menu.products;

import com.softserve.edu.magento.data.admin.products.Filter;
import com.softserve.edu.magento.tools.Search;
import org.openqa.selenium.WebElement;

/**
 * Created by Corwin on 05.09.2016.
 */
public class ProductFilterPage extends ProductCatalogPage {

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

    private ProductFilterPage() {
        filterButton = Search.xpath("(//button[@class='action-default'])[1]");
        filterIdFromInput = Search.cssSelector("input[name='entity_id[from]']");
        filterIdToInput = Search.cssSelector("input[name='entity_id[to]']");
        filterPriceFromInput = Search.cssSelector("input[name='price[from]']");
        filterPriceToInput = Search.cssSelector("input[name='price[to]']");
        filterQuantityFromInput = Search.cssSelector("input[name='qty[from]']");
        filterQuantityToInput = Search.cssSelector("input[name='qty[to]']");
        filterNameInput = Search.cssSelector("input[name='name']");
        filterSkuInput = Search.cssSelector("input[name='sku']");
        applyFiltersButton = Search.className("action-secondary");
        cancelFiltersButton = Search.cssSelector(".admin__footer-main-actions .action-tertiary");
    }

    // Getters

    public WebElement getFilterButton() {
        return this.filterButton;
    }

    // Setters

    public void clearFilterSkuInput() {
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
        clearFilterSkuInput();
        setFilterSkuInput(filterSku);
    }

    public ProductFilterPage clickFilterButton() {
        getFilterButton().click();
        return new ProductFilterPage();
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
        return new ProductCatalogPage();
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

    // Functional

    public void setFilter(Filter filter) {
        setFilterIdFromInputClear(filter.getIdFrom());
        setFilterIdToInputClear(filter.getIdTo());
        setFilterPriceFromInputClear(filter.getPriceFrom());
        setFilterPriceToInputClear(filter.getPriceTo());
        setFilterQuantityFromInputClear(filter.getQuantityFrom());
        setFilterQuantityToInputClear(filter.getQuantityTo());
        setFilterNameInputClear(filter.getName());
        setFilterSkuInputClear(filter.getSku());
    }
}


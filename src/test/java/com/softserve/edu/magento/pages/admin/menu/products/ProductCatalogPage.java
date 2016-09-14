package com.softserve.edu.magento.pages.admin.menu.products;

import com.google.common.base.Predicate;
import com.softserve.edu.magento.controls.ITable;
import com.softserve.edu.magento.controls.Table;
import com.softserve.edu.magento.data.admin.products.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.magento.pages.admin.VerticalMenu;
import com.softserve.edu.magento.tools.Search;
import org.openqa.selenium.support.FindBy;

public class ProductCatalogPage extends VerticalMenu {
    public final static int COLUMN_PRODUCT_CHECK = 0;
    public final static int COLUMN_PRODUCT_NAME = 3;
    public final static int COLUMN_PRODUCT_ATTRIBUTE_SET = 5;
    public final static int COLUMN_PRODUCT_SKU = 6;
    public final static int COLUMN_PRODUCT_PRICE = 7;
    public final static int COLUMN_PRODUCT_QUANTITY = 8;

    // Fields
    private WebElement pageTitle;
    private WebElement addProductButton;
    private WebElement addProductToggleButton;
    private WebElement simpleProductButton;
    private WebElement configurableProductButton;
    private WebElement groupedProductButton;
    private WebElement virtualProductButton;
    private WebElement bundleProductButton;
    private WebElement downloadableProductButton;

    private ITable table;
    private WebElement actionsDropdown;
    private WebElement filterButton;
    private WebElement nextPageButton;

    protected ProductCatalogPage() {
//        Search.waitForSimpleLoaderDone();
        pageTitle = Search.className("page-title");
        addProductButton = Search.id("add_new_product-button");
        addProductToggleButton = Search.className("action-toggle");
        simpleProductButton = Search.cssSelector("span[title='Simple Product']");
        configurableProductButton = Search.cssSelector("span[title='Configurable Product']");
        groupedProductButton = Search.cssSelector("span[title='Grouped Product']");
        virtualProductButton = Search.cssSelector("span[title='Virtual Product']");
        bundleProductButton = Search.cssSelector("span[title='Bundle Product']");
        downloadableProductButton = Search.cssSelector("span[title='Downloadable Product']");
        actionsDropdown = Search.xpath("(//button[@class='action-select'])[1]");
        nextPageButton = Search.cssSelector("button[title='Next Page']");
        filterButton = Search.xpath("(//button[@class='action-default'])[1]");
//        Search.waitForSimpleLoaderDone();
        table = new Table(Search.cssSelector("table[data-role='grid']"));
    }

    public static ProductCatalogPage createProductCatalogPageInstance(){
        Search.waitUntil(new Predicate<WebDriver>() {
            @Override
            public boolean apply(WebDriver webDriver) {
                ProductCatalogPage newPage = null;
                try{
                    newPage = new ProductCatalogPage();
                } catch (Throwable error){
                }
                return newPage != null;
            }
        });
        return new ProductCatalogPage();
    }


    // Getters

    public ITable getTable() {
        return table;
    }

    public WebElement getPageTitle() {
        return this.pageTitle;
    }

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

    public WebElement getNextPageButton() {
        return this.nextPageButton;
    }

    public WebElement getFilterButton() {
        return this.filterButton;
    }

    public String getPageTitleText() {
        return pageTitle.getText();
    }

    // PageObject Logic

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

    public ActionsWithProductsPage clickActionsDropdown() {
        getActionsDropdown().click();
        return ActionsWithProductsPage.createActionsWithProductPage();
    }

    // Functional Business Logic
    public AddProductPage gotoAddProductPage() {
        clickAddProductButton();
        return new AddProductPage();
    }

    public boolean isProductWithNameExist(String productName) {
        return table.getRowIndexByValueInColumn(productName, COLUMN_PRODUCT_NAME) != -1;
    }

    public void selectProductByIndex(int rowIndex) {
        table.getCell(rowIndex, COLUMN_PRODUCT_CHECK).click();
    }

    public int getRowIndexByName(String productName) {
        int productIndex = table.getRowIndexByValueInColumn(productName, COLUMN_PRODUCT_NAME);
        return productIndex;
    }

    public int getRowIndexBySku(String productSku) {
        int productIndex = table.getRowIndexByValueInColumn(productSku, COLUMN_PRODUCT_SKU);
        return productIndex;
    }

    public String getProductAttributeSetTextByRowIndex(int rowIndex) {
        WebElement productAttributeSet = table.getCell(rowIndex, COLUMN_PRODUCT_ATTRIBUTE_SET);
        return productAttributeSet.getText();
    }

    public String getProductSkuTextByRowIndex(int rowIndex) {
        WebElement productSku = table.getCell(rowIndex, COLUMN_PRODUCT_SKU);
        return productSku.getText();
    }

    public String getProductPriceTextByRowIndex(int rowIndex) {
        WebElement productPrice = table.getCell(rowIndex, COLUMN_PRODUCT_PRICE);
        return productPrice.getText();
    }

    public String getProductQuantityTextByRowIndex(int rowIndex) {
        WebElement productQuantity = table.getCell(rowIndex, COLUMN_PRODUCT_QUANTITY);
        return productQuantity.getText();
    }

    public ProductCatalogPage moveToNextPage() {
        nextPageButton.click();
        return ProductCatalogPage.createProductCatalogPageInstance();
    }

    public boolean checkNextPageButtonIsEnabled() {
        if (getNextPageButton().isEnabled()) {
            return true;
        } else {
            return false;
        }
    }

    // -------- NoItemSelectedPopupInnerClass ---------//

    private class NoItemSelectedPopup {
        private WebElement noItemSelectedPopupTitle;
        private WebElement noItemSelectedPopupConfirmButton;
        private WebElement noItemSelectedPopupCloseButton;

        public NoItemSelectedPopup() {
            noItemSelectedPopupTitle = Search.xpath("//header[@class='modal-header']/h1[contains(text(), 'Attention')]");
            noItemSelectedPopupConfirmButton = Search.className("action-accept");
        }
    }

}
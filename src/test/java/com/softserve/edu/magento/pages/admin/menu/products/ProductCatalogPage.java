package com.softserve.edu.magento.pages.admin.menu.products;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Predicate;
import com.softserve.edu.magento.data.admin.products.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.magento.data.admin.products.Filter;
import com.softserve.edu.magento.pages.admin.VerticalMenu;
import com.softserve.edu.magento.tools.Search;

public class ProductCatalogPage extends VerticalMenu {

    // Fields

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
    private WebElement enableProduct;
    private WebElement disableProduct;
    private WebElement updateProductAttributesButton;

    private WebElement filterButton;
    private WebElement nextPageButton;
    private List<ProductRow> productRows;
    private List<WebElement> productRowsSource;

    public ProductCatalogPage() {

        addProductButton = Search.id("add_new_product-button");
        addProductToggleButton = Search.className("action-toggle");
        simpleProductButton = Search.cssSelector("span[title='Simple Product']");
        configurableProductButton = Search.cssSelector("span[title='Configurable Product']");
        groupedProductButton = Search.cssSelector("span[title='Grouped Product']");
        virtualProductButton = Search.cssSelector("span[title='Virtual Product']");
        bundleProductButton = Search.cssSelector("span[title='Bundle Product']");
        downloadableProductButton = Search.cssSelector("span[title='Downloadable Product']");
        actionsDropdown = Search.xpath("(//div[@class='action-select-wrap'])[1]");
        deleteProductButton = Search.xpath("(//div[@class='action-menu-items']//span[contains(text(), 'Delete')])[1]");
        changeProductStatusButton = Search.xpath("(//div[@class='action-menu-items']//span[contains(text(), 'Change')])[1]");
        enableProduct = Search.xpath("(//div[@class='action-menu-items']//span[contains(text(), 'Enable')])[1]");
        disableProduct = Search.xpath("(//div[@class='action-menu-items']//span[contains(text(), 'Disable')])[1]");

        updateProductAttributesButton = Search.xpath("(//div[@class='action-menu-items']//span[contains(text(), 'Update')])[1]");
        nextPageButton = Search.cssSelector("button[title='Next Page']");
        filterButton = Search.xpath("(//button[@class='action-default'])[1]");
        productRowsSource = Search.cssSelectors("tbody tr");
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

    public WebElement getEnableProductStatus() {
        return this.enableProduct;
    }

    public WebElement getDisableProductStatus() {
        return this.disableProduct;
    }

    public WebElement getUpdateProductAttributesAction() {
        return this.updateProductAttributesButton;
    }

    public WebElement getNextPageButton() {
        return this.nextPageButton;
    }

    public WebElement getFilterButton() {
        return this.filterButton;
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

    public DeleteConfirmationPopup clickDeleteProductAction() {
        clickActionsDropdown();
        getDeleteProductAction().click();
        return new DeleteConfirmationPopup();
    }

    public void clickChangeStatusProductAction() {
        clickActionsDropdown();
        getChangeStatusProductAction().click();
    }

    public void setEnableProductStatus() {
        clickChangeStatusProductAction();
        getEnableProductStatus().click();
    }

    public void setDisableProduct() {
        clickChangeStatusProductAction();
        getDisableProductStatus().click();
    }

    public void clickUpdateProductAttributesAction() {
        clickActionsDropdown();
        getUpdateProductAttributesAction().click();
    }

    public FilterObject clickFilterButton() {
        getFilterButton().click();
        return new FilterObject();
    }

    // Functional Business Logic
    public AddProductPage gotoAddProductPage() {
        clickAddProductButton();
        return new AddProductPage();
    }

    public ProductRow getRowWithProductName(String productName) {
        productRows = new ArrayList<>();
        for (WebElement row : productRowsSource) {
            ProductRow productRow = new ProductRow(row);
            productRows.add(productRow);
        }
        for (ProductRow row : productRows) {
            if (row.getProductNameText().equals(productName)) {
                return row;
            }
        }
        return null;
    }

    public ProductRow getRowWithDuplicatedProduct(String productName, String sku) {
        for (ProductRow row : productRows) {
            if (row.getProductNameText().equals(productName) && row.getProductSkuText().equals(sku)) {
                return row;
            }
        }
        return null;
    }

    public ProductCatalogPage moveToNextPage() {
        nextPageButton.click();
        return new ProductCatalogPage();
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
            productCheckbox = Search.cssSelector("td:first-child", row);
            productId = Search.cssSelector("td:nth-child(2)", row);
            productName = Search.cssSelector("td:nth-child(4)", row);
            productType = Search.cssSelector("td:nth-child(5)", row);
            productAttributeSet = Search.cssSelector("td:nth-child(6)", row);
            productSku = Search.cssSelector("td:nth-child(7)", row);
            productPrice = Search.cssSelector("td:nth-child(8)", row);
            productQuantity = Search.cssSelector("td:nth-child(9)", row);
            productVisibility = Search.cssSelector("td:nth-child(10)", row);
            productStatus = Search.cssSelector("td:nth-child(11)", row);
            productWebsites = Search.cssSelector("td:nth-child(12)", row);
            productActions = Search.cssSelector("td:nth-child(13)", row);
        }

        // Getters

        public WebElement getProductCheckbox() {
            return this.productCheckbox;
        }

        public WebElement getProductAction() {
            return this.productActions;
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

        // Functional

        public void editProduct() {
            getProductAction().click();
        }

        public boolean isProductCheckboxSelected() {
            return getProductCheckbox().isSelected();
        }

        public void selectProduct() {
            getProductCheckbox().click();
        }
    }

    // -------- FilterObjectInnerClass ---------//

    public class FilterObject {
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

        private FilterObject() {
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

    public class DeleteConfirmationPopup {

        private WebElement deleteConfirmationButton;
        private WebElement cancelDeleteLink;
        private WebElement closeDeletePopupButton;

        public DeleteConfirmationPopup() {
            deleteConfirmationButton = Search.className("action-accept");
            cancelDeleteLink = Search.className("action-dismiss");
            closeDeletePopupButton = Search.xpath("(//button[@data-role='closeBtn'])[2]");
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

        public ProductCatalogPage clickDeleteConfirmationButton() {
            getDeleteConfirmationButton().click();
            Search.waitUntil(new Predicate<WebDriver>() {
                @Override
                public boolean apply(WebDriver input) {
                    WebElement successMessage = Search.cssSelector("#messages .message-success:first-child");
                    if (successMessage != null) {
                        return Constants.PRODUCT_SAVED_MESSAGE.equals(successMessage.getText().trim());
                    }
                    return false;
                }
            });

            Search.waitUntil(new Predicate<WebDriver>() {
                @Override
                public boolean apply(WebDriver input) {
                    List<WebElement> foundRows = Search.cssSelectors("tbody tr");
                    return foundRows.size() > 0;
                }
            });
            return new ProductCatalogPage();
        }

        public void clickCancelDeleteLink() {
            getCancelDeleteLink().click();
        }

        public void clickCloseDeletePopupButton() {
            getCloseDeletePopupButton().click();
        }
    }

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
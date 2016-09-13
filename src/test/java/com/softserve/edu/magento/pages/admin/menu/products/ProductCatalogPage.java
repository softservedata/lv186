package com.softserve.edu.magento.pages.admin.menu.products;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.softserve.edu.magento.data.admin.products.Filter;
import com.softserve.edu.magento.pages.admin.VerticalMenu;
import com.softserve.edu.magento.tools.Search;

public class ProductCatalogPage extends VerticalMenu {

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

    private WebElement actionsDropdown;
//    private WebElement deleteProductButton;
//    private WebElement changeProductStatusButton;
//    private WebElement enableProduct;
//    private WebElement disableProduct;
//    private WebElement updateProductAttributesButton;

//    private WebElement filterButton;
    private WebElement nextPageButton;
    List<WebElement> productRowsSource;
    private List<ProductRow> productRows;

    public ProductCatalogPage() {
        pageTitle = Search.className("page-title");
        addProductButton = Search.id("add_new_product-button");
        //addProductButton = Search.xpath("//button[@data-ui-id='products-list-add-new-product-button']");
        addProductToggleButton = Search.className("action-toggle");
        simpleProductButton = Search.cssSelector("span[title='Simple Product']");
        configurableProductButton = Search.cssSelector("span[title='Configurable Product']");
        groupedProductButton = Search.cssSelector("span[title='Grouped Product']");
        virtualProductButton = Search.cssSelector("span[title='Virtual Product']");
        bundleProductButton = Search.cssSelector("span[title='Bundle Product']");
        downloadableProductButton = Search.cssSelector("span[title='Downloadable Product']");
        actionsDropdown = Search.xpath("(//button[@class='action-select'])[1]");
//        deleteProductButton = Search.xpath("(//div[@class='action-menu-items']//span[contains(text(), 'Delete')])[1]");
//        changeProductStatusButton = Search.xpath("(//div[@class='action-menu-items']//span[contains(text(), 'Change')])[1]");
//        enableProduct = Search.xpath("(//div[@class='action-menu-items']//span[contains(text(), 'Enable')])[1]");
//        disableProduct = Search.xpath("(//div[@class='action-menu-items']//span[contains(text(), 'Disable')])[1]");
//        updateProductAttributesButton = Search.xpath("(//div[@class='action-menu-items']//span[contains(text(), 'Update')])[1]");
        nextPageButton = Search.cssSelector("button[title='Next Page']");
//        filterButton = Search.xpath("(//button[@class='action-default'])[1]");
        productRows = new ArrayList<>();
        productRowsSource = Search.cssSelectors("tbody tr");
    }

    // Getters

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
//
//    public WebElement getDeleteProductAction() {
//        return this.deleteProductButton;
//    }
//
//    public WebElement getChangeStatusProductAction() {
//        return this.changeProductStatusButton;
//    }
//
//    public WebElement getEnableProductStatus() {
//        return this.enableProduct;
//    }
//
//    public WebElement getDisableProductStatus() {
//        return this.disableProduct;
//    }
//
//    public WebElement getUpdateProductAttributesAction() {
//        return this.updateProductAttributesButton;
//    }

    public WebElement getNextPageButton() {
        return this.nextPageButton;
    }

//    public WebElement getFilterButton() {
//        return this.filterButton;
//    }

    public String getPageTitleText() {return pageTitle.getText();}

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
        return new ActionsWithProductsPage();
    }
//
//    public DeleteConfirmationPopup clickDeleteProductAction() {
//        clickActionsDropdown();
//        getDeleteProductAction().click();
//        return new DeleteConfirmationPopup();
//    }
//
//    public void clickChangeStatusProductAction() {
//        clickActionsDropdown();
//        getChangeStatusProductAction().click();
//    }
//
//    public void setEnableProductStatus() {
//        clickChangeStatusProductAction();
//        getEnableProductStatus().click();
//    }
//
//    public void setDisableProduct() {
//        clickChangeStatusProductAction();
//        getDisableProductStatus().click();
//    }
//
//    public void clickUpdateProductAttributesAction() {
//        clickActionsDropdown();
//        getUpdateProductAttributesAction().click();
//    }

//    public FilterObject clickFilterButton() {
//        getFilterButton().click();
//        return new FilterObject();
//    }

    // Functional Business Logic
    public AddProductPage gotoAddProductPage() {
        clickAddProductButton();
        return new AddProductPage();
    }

    public ProductRow getRowWithProductName(String productName) {
        for (WebElement row1 : productRowsSource) {
            ProductRow productRow = new ProductRow(row1);
            productRows.add(productRow);
        }
        for (ProductRow row2 : productRows) {
            if (row2.getProductNameText().equals(productName)) {
                return row2;
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

    // -------- DeletePopupInnerClass ---------//

//    public class DeleteConfirmationPopup {
//
//        private WebElement deleteConfirmationButton;
//        private WebElement cancelDeleteLink;
//        private WebElement closeDeletePopupButton;
//
//        public DeleteConfirmationPopup() {
//            cancelDeleteLink = Search.xpath("//footer[@class='modal-footer']/button[1]");
//            deleteConfirmationButton = Search.xpath("//footer[@class='modal-footer']/button[2]");
//            closeDeletePopupButton = Search.xpath("(//button[@data-role='closeBtn'])[2]");
//        }

        // Getters

//        public WebElement getDeleteConfirmationButton() {
//            return this.deleteConfirmationButton;
//        }
//
//        public WebElement getCancelDeleteLink() {
//            return this.cancelDeleteLink;
//        }
//
//        public WebElement getCloseDeletePopupButton() {
//            return this.closeDeletePopupButton;
//        }

        // PageObject Logic

//        public ProductCatalogPage clickDeleteConfirmationButton() {
//            new DeleteConfirmationPopup();
//            getDeleteConfirmationButton().click();
//            return new ProductCatalogPage();
//        }
//
//        public void clickCancelDeleteLink() {
//            getCancelDeleteLink().click();
//        }
//
//        public void clickCloseDeletePopupButton() {
//            getCloseDeletePopupButton().click();
//        }
//    }

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
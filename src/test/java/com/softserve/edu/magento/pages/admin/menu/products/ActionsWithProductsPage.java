package com.softserve.edu.magento.pages.admin.menu.products;

import com.softserve.edu.magento.tools.Search;
import org.openqa.selenium.WebElement;

/**
 * Created by Yulia Nevinglovskaya on 05.09.2016.
 */
public class ActionsWithProductsPage extends ProductCatalogPage {

    //private WebElement actionsDropdown;
    private WebElement deleteProductButton;
    private WebElement changeProductStatusButton;
    private WebElement enableProduct;
    private WebElement disableProduct;
    private WebElement updateProductAttributesButton;

    ActionsWithProductsPage() {
        //actionsDropdown = Search.xpath("(//div[@class='action-select-wrap'])[1]");
        deleteProductButton = Search.xpath("(//div[@class='action-menu-items']//span[contains(text(), 'Delete')])[1]");
        changeProductStatusButton = Search.xpath("(//div[@class='action-menu-items']//span[contains(text(), 'Change')])[1]");
        enableProduct = Search.xpath("(//div[@class='action-menu-items']//span[contains(text(), 'Enable')])[1]");
        disableProduct = Search.xpath("(//div[@class='action-menu-items']//span[contains(text(), 'Disable')])[1]");
        updateProductAttributesButton = Search.xpath("(//div[@class='action-menu-items']//span[contains(text(), 'Update')])[1]");
    }

    // Getters

//    public WebElement getActionsDropdown() {
//        return this.actionsDropdown;
//    }

    public WebElement getDeleteProduct() {
        return this.deleteProductButton;
    }

    public WebElement getChangeProductStatus() {
        return this.changeProductStatusButton;
    }

    public WebElement getEnableProductStatus() {
        return this.enableProduct;
    }

    public WebElement getDisableProductStatus() {
        return this.disableProduct;
    }

    public WebElement getUpdateProductAttributes() {
        return this.updateProductAttributesButton;
    }

    // PageObject Logic

//    public void clickActionsDropdown() {
//        getActionsDropdown().click();
//    }

    public DeleteConfirmationPopup clickDeleteProductButton() {
        //clickActionsDropdown();
        getDeleteProduct().click();
        return new DeleteConfirmationPopup();
    }

    public void clickChangeProductStatus() {
        //clickActionsDropdown();
        getChangeProductStatus().click();
    }

    public void setEnableProductStatus() {
        clickChangeProductStatus();
        getEnableProductStatus().click();
    }

    public void setDisableProduct() {
        clickChangeProductStatus();
        getDisableProductStatus().click();
    }

    public void clickUpdateProductAttributesAction() {
        clickActionsDropdown();
        getUpdateProductAttributes().click();
    }

    // -------- DeletePopupInnerClass ---------//

    public class DeleteConfirmationPopup {
        private WebElement deleteConfirmationButton;
        private WebElement cancelDeleteLink;
        private WebElement closeDeletePopupButton;

        public DeleteConfirmationPopup() {
            cancelDeleteLink = Search.xpath("//footer[@class='modal-footer']/button[1]");
            deleteConfirmationButton = Search.xpath("//footer[@class='modal-footer']/button[2]");
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

        // PageObject Logic

        public ProductCatalogPage clickDeleteConfirmationButton() {
            //Search.waitElementToBeClickable(getDeleteConfirmationButton());
            getDeleteConfirmationButton().click();
            return new ProductCatalogPage();
        }

        public void clickCancelDeleteLink() {
            getCancelDeleteLink().click();
        }

        public void clickCloseDeletePopupButton() {
            getCloseDeletePopupButton().click();
        }
    }
}

package com.softserve.edu.magento.pages.admin.menu.products;

import com.softserve.edu.magento.tools.Search;
import org.openqa.selenium.WebElement;

/**
 * Created by Corwin on 05.09.2016.
 */
public class DeleteProductPage extends ProductCatalogPage {
    private WebElement deleteConfirmationButton;
    private WebElement cancelDeleteLink;
    private WebElement closeDeletePopupButton;

    public DeleteProductPage() {
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
//    public DeleteProductPage clickDeleteProductAction() {
//        clickActionsDropdown();
//        getDeleteProductAction().click();
//        return new DeleteProductPage();
//    }

    public ProductCatalogPage clickDeleteConfirmationButton() {
        new DeleteProductPage();
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

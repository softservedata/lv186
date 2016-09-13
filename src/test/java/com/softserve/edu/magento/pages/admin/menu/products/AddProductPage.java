package com.softserve.edu.magento.pages.admin.menu.products;

import com.softserve.edu.magento.data.admin.products.IProduct;
import com.softserve.edu.magento.pages.admin.VerticalMenu;
import com.softserve.edu.magento.tools.Search;
import org.apache.http.util.TextUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.seleniumemulation.WaitForPageToLoad;

import java.util.ArrayList;
import java.util.List;

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
        Search.waitForSimpleLoaderDone();
        saveButton = Search.id("save-button");
        saveDropdownToggle = Search.cssSelector("button[title=Save]:nth-child(2)");
        saveAndNewButton = Search.id("save_and_new");
        saveAndDuplicateButton = Search.id("save_and_duplicate");
        saveAndCloseButton = Search.id("save_and_close");
        backButton = Search.id("back");
        addAttributeButton = Search.id("addAttribute");
        enableProductButton = Search.xpath("(//div[@class='admin__actions-switch'])[1]");
        attributeSetInput = Search.xpath("//div[@data-index='attribute_set_id']//div[@class='admin__action-multiselect-text']");
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
        return this.getProductNameInput().getAttribute("value").trim();
    }

    public String getSkuInputText() {
        return this.getSkuInput().getAttribute("value").trim();
    }

    public String getPriceInputText() {
        return this.getPriceInput().getAttribute("value").trim();
    }

    public String getQuantityInputText() {
        return this.getQuantityInput().getAttribute("value").trim();
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

    public ProductCatalogPage clickBackButton() {
        backButton = Search.id("back");
        getBackButton().click();
        return new ProductCatalogPage();
    }

    public void clickAddAttributeButton() {
        getAddAttributeButton().click();
    }

    public void setProductNameInputWithClear(String productName) {
        //Search.setStrategy(Search.SearchStrategyList.EXPLICIT_STRATEGY_CLICKABLE.getSearchStrategy());
        getProductNameInput().click();
        clearProductNameInput();
        setProductName(productName);
    }

    public void setSkuInputWithClear(String sku) {
        getSkuInput().click();
        clearSkuInput();
        setSku(sku);
    }

    public void setPriceInputWithClear(String price) {
        getPriceInput().click();
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
        Search.waitForLoaderDone();
        setProductNameInputWithClear(productData.getProductName());
        setSkuInputWithClear(productData.getSku());
        setPriceInputWithClear(productData.getPrice());
        if (!TextUtils.isEmpty(productData.getQuantity())) {
            setQuantity(productData.getQuantity());
        }
    }

    public void setAttributeSet(String attributeSet) {
        getAttributeSetInput().click();
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
        Search.stalnessOf(getProductNameInput());
        return new SuccessProductSavePage();
    }

    public SuccessProductSavePage gotoSuccessProductSavePageAfterSaveAndNew() {
        clickSaveAndNewButton();
        Search.stalnessOf(getProductNameInput());
        //waitPageLoaded();
        return new SuccessProductSavePage();
    }

    public SuccessProductSaveAndDuplicatePage gotoSuccessProductSaveAndDuplicatePage() {
        clickSaveAndDuplicateButton();
        Search.stalnessOf(getProductNameInput());
        //waitPageLoaded();
        return new SuccessProductSaveAndDuplicatePage();
    }

    public ProductCatalogPage gotoCatalogPageAfterSaveClose() {
        clickSaveAndCloseButton();
        Search.stalnessOf(getProductNameInput());
        return new ProductCatalogPage();
    }

    public ProductExistsPage gotoProductExistsPageAfterSave() {
        clickSaveButton();
        Search.stalnessOf(getProductNameInput());
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
        Search.stalnessOf(getProductNameInput());
        //waitPageLoaded();
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
        waitPageLoaded();
        clickSaveAndCloseButton();
        return new ProductValidatorPage();
    }

    public void waitPageLoaded() {
        List<WebElement> loaders = new ArrayList<>();
        int currentSize = 0;
        while (currentSize == loaders.size()) {
            List<WebElement> blocker = Search.xpaths("//div[@class='loading-mask']");
            loaders.addAll(blocker);
            currentSize++;
        }
    }

}

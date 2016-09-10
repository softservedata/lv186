package com.softserve.edu.magento.tests;

import com.softserve.edu.magento.data.ApplicationSources;
import com.softserve.edu.magento.data.ApplicationSourcesRepository;
import com.softserve.edu.magento.data.admin.AdminUserRepository;
import com.softserve.edu.magento.data.admin.IAdminUser;
import com.softserve.edu.magento.data.admin.products.Constants;
import com.softserve.edu.magento.data.admin.products.IProduct;
import com.softserve.edu.magento.data.admin.products.ProductRepository;
import com.softserve.edu.magento.pages.admin.ApplicationAdmin;
import com.softserve.edu.magento.pages.admin.menu.dashboard.DashboardPage;
import com.softserve.edu.magento.pages.admin.menu.products.*;
import com.softserve.edu.magento.tools.ListUtils;
import com.softserve.edu.magento.tools.ParameterUtils;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ss.af.reporting.annotations.ServiceReport;

/**
 * Created by Yulia Nevinglovskaya on 8/18/2016.
 */
public class ProductFunctionalityTest extends TestBase {
    @DataProvider
    public Object[][] parameters(ITestContext context) {
        return ListUtils.get()
                .toMultiArray(ParameterUtils.get()
                                .updateParametersAll(ApplicationSourcesRepository.getChromeLocalhostAdmin(), context),
                        AdminUserRepository.get().adminYulia());
    }

    /**
     * The method tests if a new product is possible to save if obligatory fields are filled in with valid data
     * and 'Save' button is pressed; if entered data are present in the fields; if success save message appears.
     * @param applicationSources
     * @param adminUser
     */
    @Test(dataProvider = "parameters")
    @ServiceReport
    public void checkProductSaved(ApplicationSources applicationSources, IAdminUser adminUser) {
        /* Log in and go to AddProductPage */
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        ProductCatalogPage productCatalogPage = dashboardPage.gotoProductCatalogPage();
        AddProductPage addProductPage = productCatalogPage.gotoAddProductPage();

        /* Get data from Product Repository and set them */
        IProduct product = ProductRepository.get().getNewValidProduct();
        addProductPage.setProductData(product);
        SuccessProductSavePage savePage =
                addProductPage.gotoSuccessProductSavePageAfterSave();

		/* Check if message appeared and data are present in the fields */
        Assert.assertEquals(savePage.getSuccessfulProductSaveMessageText().trim(), Constants.PRODUCT_SAVED_MESSAGE);
        Assert.assertEquals(savePage.getProductNameInputText(), ProductRepository.VALID_PRODUCT_NAME);
        Assert.assertEquals(savePage.getSkuInputText(), ProductRepository.VALID_SKU);
        Assert.assertEquals(savePage.getPriceInputText(), ProductRepository.VALID_PRICE);
        Assert.assertEquals(savePage.getQuantityInputText(), ProductRepository.QUANTITY);

		/* Go to page with catalog and find row with needed name */
        ProductCatalogPage catalogPage = savePage.returnToProductPage();
        ProductCatalogPage.ProductRow row = catalogPage.getRowWithProductName(ProductRepository.VALID_PRODUCT_NAME);
        while (row == null) {
            if (catalogPage.checkNextPageButtonIsEnabled()) {
                catalogPage = catalogPage.moveToNextPage();
                row = catalogPage.getRowWithProductName(ProductRepository.VALID_PRODUCT_NAME);
            } else {
                break;
            }
        }

		/* Check if saved product is present in catalog */
        Assert.assertNotNull(row);
        Assert.assertEquals(row.getProductSkuText(), ProductRepository.VALID_SKU);
        Assert.assertEquals(row.getProductPriceText(), ProductRepository.VALID_PRICE_FOR_CHECK);
        Assert.assertEquals(row.getProductQuantityText(), ProductRepository.QUANTITY_FOR_CHECK);

		/* Delete saved product */
        row.selectProduct();
        ProductCatalogPage.DeleteConfirmationPopup popup = catalogPage.clickDeleteProductAction();
        catalogPage = popup.clickDeleteConfirmationButton();

		/* Logout */
        catalogPage.logout();
    }

    /**
     * The method tests if a new product is possible to save if obligatory fields are filled in with valid data
     * and 'Save&New' button is pressed; if entered into the fields data are reset; if success save message appears.
     * @param applicationSources
     * @param adminUser
     */
    @Test(dataProvider = "parameters")
    @ServiceReport
    public void checkProductSaveAndNew(ApplicationSources applicationSources, IAdminUser adminUser) {
        /* Log in and go to AddProductPage */
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        ProductCatalogPage productCatalogPage = dashboardPage.gotoProductCatalogPage();
        AddProductPage addProductPage = productCatalogPage.gotoAddProductPage();

        /* Get valid data from Product Repository and set them */
        IProduct product = ProductRepository.get().getNewValidProductForSaveAndNew();
        addProductPage.setProductData(product);
        SuccessProductSavePage savePage = addProductPage.gotoSuccessProductSavePageAfterSaveAndNew();

        /* Check if message appeared and fields are reset */
        Assert.assertEquals(savePage.getSuccessfulProductSaveMessageText().trim(), Constants.PRODUCT_SAVED_MESSAGE);
        Assert.assertEquals(savePage.getProductNameInputText(), "");
        Assert.assertEquals(savePage.getSkuInputText(), "");
        Assert.assertEquals(savePage.getPriceInputText(), "");
        Assert.assertEquals(savePage.getQuantityInputText(), "");

        /* Find row with newly saved product */
        ProductCatalogPage catalogPage = savePage.returnToProductPage();
        ProductCatalogPage.ProductRow row = catalogPage.getRowWithProductName(ProductRepository.VALID_PRODUCT_NAME_2);
        while (row == null) {
            if (catalogPage.checkNextPageButtonIsEnabled()) {
                catalogPage = catalogPage.moveToNextPage();
                row = catalogPage.getRowWithProductName(ProductRepository.VALID_PRODUCT_NAME_2);
            } else {
                break;
            }
        }

        /* Check if new product is present in catalog */
        Assert.assertNotNull(row);
        Assert.assertEquals(row.getProductSkuText(), ProductRepository.VALID_SKU_2);
        Assert.assertEquals(row.getProductPriceText(), ProductRepository.VALID_PRICE_FOR_CHECK);

        /* Delete saved product */
        row.selectProduct();
        ProductCatalogPage.DeleteConfirmationPopup popup = catalogPage.clickDeleteProductAction();
        catalogPage = popup.clickDeleteConfirmationButton();

		/* Logout */
        catalogPage.logout();
    }

    /**
     * The method tests if a new product is possible to save and duplicate if obligatory fields are filled in
     * with valid data and 'Save&Duplicate' button is pressed; if entered data are present in the fields ;
     * if success save message and success duplicate message appear.
     * @param applicationSources
     * @param adminUser
     */
    @Test(dataProvider = "parameters")
    @ServiceReport
    public void checkProductSaveAndDuplicate(ApplicationSources applicationSources, IAdminUser adminUser) {
        /* Log in and go to AddProductPage */
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        ProductCatalogPage productCatalogPage = dashboardPage.gotoProductCatalogPage();
        AddProductPage addProductPage = productCatalogPage.gotoAddProductPage();

        /* Get valid data from Product Repository and set them */
        IProduct product = ProductRepository.get().getNewValidProductForSaveAndDuplicate();
        addProductPage.setProductData(product);
        SuccessProductSaveAndDuplicatePage savePage = addProductPage.gotoSuccessProductSaveAndDuplicatePage();

        /* Check if messages appeared and data are present in the fields */
        Assert.assertEquals(savePage.getSuccessfulProductSaveMessageText().trim(), Constants.PRODUCT_SAVED_MESSAGE);
        Assert.assertEquals(savePage.getSuccessfulProductDuplicateMessageText().trim(), Constants.PRODUCT_DUPLICATED_MESSAGE);
        Assert.assertEquals(savePage.getProductNameInputText(), ProductRepository.VALID_PRODUCT_NAME_3);
        Assert.assertEquals(savePage.getSkuInputText(), ProductRepository.VALID_SKU_DUPLICATED);
        Assert.assertEquals(savePage.getPriceInputText(), ProductRepository.VALID_PRICE);
        Assert.assertEquals(savePage.getQuantityInputText(), "");

        /* Find row with newly saved product */
        ProductCatalogPage catalogPage = savePage.returnToProductPage();
        ProductCatalogPage.ProductRow row1 = catalogPage.getRowWithProductName(ProductRepository.VALID_PRODUCT_NAME_3);
        while (row1 == null) {
            if (catalogPage.checkNextPageButtonIsEnabled()) {
                catalogPage = catalogPage.moveToNextPage();
                row1 = catalogPage.getRowWithProductName(ProductRepository.VALID_PRODUCT_NAME_3);
            } else {
                break;
            }
        }

        /* Check if new product is present in catalog */
        Assert.assertNotNull(row1);
        Assert.assertEquals(row1.getProductSkuText(), ProductRepository.VALID_SKU_3);
        Assert.assertEquals(row1.getProductPriceText(), ProductRepository.VALID_PRICE_FOR_CHECK);
        Assert.assertEquals(row1.getProductQuantityText(), ProductRepository.QUANTITY_FOR_CHECK);

        /* Find row with duplicated product */
        ProductCatalogPage.ProductRow row2 = catalogPage.getRowWithDuplicatedProduct(ProductRepository.VALID_PRODUCT_NAME_3, ProductRepository.VALID_SKU_DUPLICATED);
        while (row2 == null) {
            if (catalogPage.checkNextPageButtonIsEnabled()) {
                catalogPage = catalogPage.moveToNextPage();
                row2 = catalogPage.getRowWithDuplicatedProduct(ProductRepository.VALID_PRODUCT_NAME, ProductRepository.VALID_SKU_DUPLICATED);
            } else {
                break;
            }
        }

        /* Check if duplicated product is present in catalog */
        Assert.assertNotNull(row2);
        Assert.assertEquals(row2.getProductSkuText(), ProductRepository.VALID_SKU_DUPLICATED);
        Assert.assertEquals(row2.getProductPriceText(), ProductRepository.VALID_PRICE_FOR_CHECK);
        Assert.assertEquals(row2.getProductQuantityText(), "");

        /* Delete saved product */
        row1.selectProduct();
        row2.selectProduct();
        ProductCatalogPage.DeleteConfirmationPopup popup = catalogPage.clickDeleteProductAction();
        catalogPage = popup.clickDeleteConfirmationButton();

		/* Logout */
        catalogPage.logout();
    }

    /**
     * The method tests if a new product is possible to save if obligatory fields are filled in with valid data
     * and 'Save&Close' button is pressed; if success save message appears; if it goes to catalog page.
     * @param applicationSources
     * @param adminUser
     */
    @Test(dataProvider = "parameters")
    @ServiceReport
    public void checkProductSaveAndClose(ApplicationSources applicationSources, IAdminUser adminUser) {
        /* Log in and go to AddProductPage */
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        ProductCatalogPage productCatalogPage = dashboardPage.gotoProductCatalogPage();
        AddProductPage addProductPage = productCatalogPage.gotoAddProductPage();

        /* Get valid data from Product Repository and set them */
        IProduct product = ProductRepository.get().getNewValidProduct();
        addProductPage.setProductData(product);
        ProductCatalogPage catalogPage = addProductPage.gotoCatalogPageAfterSaveClose();

        /* Check if it went to Catalog page */
        Assert.assertEquals(catalogPage.getPageTitleText(), Constants.CATALOG_PAGE_TITLE);

        /* Find row with newly saved product */
        ProductCatalogPage.ProductRow row = catalogPage.getRowWithProductName(ProductRepository.VALID_PRODUCT_NAME);
        while (row == null) {
            if (catalogPage.checkNextPageButtonIsEnabled()) {
                catalogPage = catalogPage.moveToNextPage();
                row = catalogPage.getRowWithProductName(ProductRepository.VALID_PRODUCT_NAME);
            } else {
                break;
            }
        }

        /* Check if new product is present in catalog */
        Assert.assertNotNull(row);
        Assert.assertEquals(row.getProductSkuText(), ProductRepository.VALID_SKU);
        Assert.assertEquals(row.getProductPriceText(), ProductRepository.VALID_PRICE_FOR_CHECK);

        /* Delete saved product */
        row.selectProduct();
        ProductCatalogPage.DeleteConfirmationPopup popup = catalogPage.clickDeleteProductAction();
        catalogPage = popup.clickDeleteConfirmationButton();

		/* Logout */
        catalogPage.logout();
    }

    /**
     * The method tests if product with existing name is impossible to save; if error message appears.
     * @param applicationSources
     * @param adminUser
     */
    @Test(dataProvider = "parameters")
    @ServiceReport
    public void checkProductExists(ApplicationSources applicationSources, IAdminUser adminUser) {
        /* Log in and go to AddProductPage */
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        ProductCatalogPage productCatalogPage = dashboardPage.gotoProductCatalogPage();
        AddProductPage addProductPage = productCatalogPage.gotoAddProductPage();

        /* Get data of existing product from Product Repository and set them */
        IProduct product = ProductRepository.get().getExistingProduct();
        addProductPage.setProductData(product);
        ProductExistsPage productExistsPage = addProductPage.gotoProductExistsPageAfterSave();

        /* Check if error messages appeared */
        Assert.assertEquals(productExistsPage.getProductAlreadyExistsMessageText(), Constants.PRODUCT_ALREADY_EXISTS_MESSAGE);

        /* Logout */
        productExistsPage.logout();
    }

    /**
     * The method tests if a product is impossible to save if obligatory fields are empty; if error messages appear.
     * @param applicationSources
     * @param adminUser
     */
    @Test(dataProvider = "parameters")
    @ServiceReport
    public void checkProductSaveValidation(ApplicationSources applicationSources, IAdminUser adminUser) {
        /* Log in and go to AddProductPage */
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        ProductCatalogPage productCatalogPage = dashboardPage.gotoProductCatalogPage();
        AddProductPage addProductPage = productCatalogPage.gotoAddProductPage();

        /* Get invalid data from Product Repository and set them */
        IProduct product = ProductRepository.get().getNewProductWithEmptyData();
        addProductPage.setProductData(product);
        ProductValidatorPage productValidatorPage = addProductPage.gotoProductValidatorPageAfterSaveAndClose();

		/* Check if error messages appeared */
        Assert.assertEquals(productValidatorPage.getProductNameValidatorText(), Constants.REQUIRED_EMPTY_FIELD_MESSAGE);
        Assert.assertEquals(productValidatorPage.getSkuValidatorText(), Constants.REQUIRED_EMPTY_FIELD_MESSAGE);
        Assert.assertEquals(productValidatorPage.getPriceValidatorText(), Constants.REQUIRED_EMPTY_FIELD_MESSAGE);

		/* Logout */
        productValidatorPage.logout();
    }

    /**
     * The method tests if a product is impossible to save if invalid product name consisting of 256 letters is entered;
     * if error message appears.
     * @param applicationSources
     * @param adminUser
     */
    @Test(dataProvider = "parameters")
    @ServiceReport
    public void checkProductSaveWithInvalidName(ApplicationSources applicationSources, IAdminUser adminUser) {
        /* Log in and go to AddProductPage */
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        ProductCatalogPage productCatalogPage = dashboardPage.gotoProductCatalogPage();
        AddProductPage addProductPage = productCatalogPage.gotoAddProductPage();

        /* Get data for non-obligatory fields from Product Repository and set them */
        IProduct product = ProductRepository.get().getNewProductWithInvalidName();
        addProductPage.setProductData(product);
        ProductValidatorPage productValidatorPage = addProductPage.gotoProductValidatorPageAfterSaveAndClose();

		/* Check if error messages appeared */
        Assert.assertEquals(productValidatorPage.getProductNameInputText(), ProductRepository.INVALID_PRODUCT_NAME);
        Assert.assertEquals(productValidatorPage.getProductNameValidatorText(), Constants.TOO_LONG_PRODUCT_NAME_MESSAGE);

		/* Logout */
        productValidatorPage.logout();
    }

    /**
     * The method tests if a product is impossible to save if invalid sku consisting of 65 letters is entered;
     * if error message appears.
     * @param applicationSources
     * @param adminUser
     */
    @Test(dataProvider = "parameters")
    @ServiceReport
    public void checkProductSaveWithInvalidSku(ApplicationSources applicationSources, IAdminUser adminUser) {
        /* Log in and go to AddProductPage */
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        ProductCatalogPage productCatalogPage = dashboardPage.gotoProductCatalogPage();
        AddProductPage addProductPage = productCatalogPage.gotoAddProductPage();

        /* Get data for non-obligatory fields from Product Repository and set them */
        IProduct product = ProductRepository.get().getNewProductWithInvalidSku();
        addProductPage.setProductData(product);
        ProductValidatorPage productValidatorPage = addProductPage.gotoProductValidatorPageAfterSaveAndNew();

		/* Check if error messages appeared */
        Assert.assertEquals(productValidatorPage.getSkuInputText(), ProductRepository.INVALID_SKU);
        Assert.assertEquals(productValidatorPage.getSkuValidatorText(), Constants.TOO_LONG_SKU_MESSAGE);

		/* Logout */
        productValidatorPage.logout();
    }

    /**
     * The method tests if a product is impossible to save if invalid price consisting of numerals and characters is entered;
     * if error message appears.
     * @param applicationSources
     * @param adminUser
     */
    @Test(dataProvider = "parameters")
    @ServiceReport
    public void checkProductSaveWithMixedPrice(ApplicationSources applicationSources, IAdminUser adminUser) {
        /* Log in and go to AddProductPage */
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        ProductCatalogPage productCatalogPage = dashboardPage.gotoProductCatalogPage();
        AddProductPage addProductPage = productCatalogPage.gotoAddProductPage();

        /* Get data with invalid price from Product Repository and set them */
        IProduct product = ProductRepository.get().getNewProductWithMixedPrice();
        addProductPage.setProductData(product);
        ProductValidatorPage productValidatorPage = addProductPage.gotoProductValidatorPageAfterSave();

        /* Check if error messages for price input appeared */
        Assert.assertEquals(productValidatorPage.getProductNameInputText(), ProductRepository.VALID_PRODUCT_NAME);
        Assert.assertEquals(productValidatorPage.getSkuInputText(), ProductRepository.VALID_SKU);
        Assert.assertEquals(productValidatorPage.getPriceValidatorText(), Constants.INVALID_PRICE_FIELD_MESSAGE);

        /* Logout */
        productValidatorPage.logout();
    }

    @AfterMethod
    public void afterMethod() {

        ApplicationAdmin.signout();
    }

    @AfterClass
    void tearDown() throws Exception {
        ApplicationAdmin.quitAll();
    }

}

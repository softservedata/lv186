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
                                .updateParametersAll(ApplicationSourcesRepository.getChromeRemoteAdmin(), context),
                        AdminUserRepository.get().adminYulia());
    }

//    @Test(dataProvider = "parameters")
//    @ServiceReport
    public void checkProductSaved(ApplicationSources applicationSources, IAdminUser adminUser) {
        /* Log in and go to AddProductPage */
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        ProductCatalogPage productCatalogPage = dashboardPage.gotoProductCatalogPage();
        AddProductPage addProductPage = productCatalogPage.gotoAddProductPage();

        /* Get data from Product Repository and set them */
        IProduct product = ProductRepository.get().getNewValidProduct();
        addProductPage.setProductData(product);
        SuccessProductSavePage savePage = addProductPage.gotoSuccessProductSavePageAfterSave();

		/* Check if message appeared and data are present in the fields */
        Assert.assertEquals(product.getAttributeSet(), ProductRepository.ATTRIBUTE_SET);
        Assert.assertEquals(product.getProductName(), ProductRepository.VALID_PRODUCT_NAME);
        Assert.assertEquals(product.getSku(), ProductRepository.VALID_SKU);
        Assert.assertEquals(product.getPrice(), ProductRepository.VALID_PRICE);
        Assert.assertEquals(product.getQuantity(), ProductRepository.QUANTITY);
        Assert.assertEquals(savePage.getSuccessfulProductSaveMessageText().trim(), Constants.PRODUCT_SAVED_MESSAGE);

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
        Assert.assertEquals(row.getProductAttributeSetText(), ProductRepository.ATTRIBUTE_SET);
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

    //@Test(dataProvider = "parameters")
    //@ServiceReport
    public void checkProductSaveValidation(ApplicationSources applicationSources, IAdminUser adminUser) {
        /* Log in and go to AddProductPage */
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        ProductCatalogPage productCatalogPage = dashboardPage.gotoProductCatalogPage();
        AddProductPage addProductPage = productCatalogPage.gotoAddProductPage();

       /* Get invalid data from Product Repository and set them */
        IProduct product = ProductRepository.get().getNewProductWithEmptyInvalidData();
        addProductPage.setProductData(product);
        ProductValidatorPage productValidatorPage = addProductPage.gotoProductValidatorPageAfterSaveAndClose();

		/* Check if error messages appeared */
        Assert.assertEquals(productValidatorPage.getProductNameValidatorText(), Constants.REQUIRED_EMPTY_FIELD_MESSAGE);
        Assert.assertEquals(productValidatorPage.getSkuValidatorText(), Constants.REQUIRED_EMPTY_FIELD_MESSAGE);
        Assert.assertEquals(productValidatorPage.getPriceValidatorText(), Constants.INVALID_PRICE_FIELD_MESSAGE);

		/* Logout */
        productValidatorPage.logout();
    }

    //@Test(dataProvider = "parameters")
    //@ServiceReport
    public void checkProductSaveWithInvalidPrice(ApplicationSources applicationSources, IAdminUser adminUser) {
        /* Log in and go to AddProductPage */
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        ProductCatalogPage productCatalogPage = dashboardPage.gotoProductCatalogPage();
        AddProductPage addProductPage = productCatalogPage.gotoAddProductPage();

         /* Get data with invalid price from Product Repository and set them */
        IProduct product = ProductRepository.get().getNewProductWithInvalidPrice();
        addProductPage.setProductData(product);
        ProductValidatorPage productValidatorPage = addProductPage.gotoProductValidatorPageAfterSave();

    /* Check if error messages for price input appeared */
        Assert.assertEquals(productValidatorPage.getProductNameValidatorText(), null);
        Assert.assertEquals(productValidatorPage.getPriceValidatorText(), Constants.INVALID_PRICE_FIELD_MESSAGE);
    }

    //@Test(dataProvider = "parameters")
    //@ServiceReport
    public void checkProductSaveWithNonRequiredFields(ApplicationSources applicationSources, IAdminUser adminUser) {
        /* Log in and go to AddProductPage */
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        ProductCatalogPage productCatalogPage = dashboardPage.gotoProductCatalogPage();
        AddProductPage addProductPage = productCatalogPage.gotoAddProductPage();

       /* Get data for non-obligatory fields from Product Repository and set them */
        IProduct product = ProductRepository.get().getNewProductWithNonRequiredFields();
        addProductPage.setProductData(product);
        ProductValidatorPage productValidatorPage = addProductPage.gotoProductValidatorPageAfterSaveAndClose();

		/* Check if error messages appeared */
        Assert.assertEquals(productValidatorPage.getAttributeSetInputText(), ProductRepository.ATTRIBUTE_SET);
        Assert.assertEquals(productValidatorPage.getProductNameValidatorText(), ProductRepository.VALID_PRODUCT_NAME);
        Assert.assertEquals(productValidatorPage.getSkuValidatorText(), Constants.REQUIRED_EMPTY_FIELD_MESSAGE);
        Assert.assertEquals(productValidatorPage.getPriceValidatorText(), Constants.REQUIRED_EMPTY_FIELD_MESSAGE);
        Assert.assertEquals(productValidatorPage.getQuantityInputText(), ProductRepository.QUANTITY);

		/* Logout */
        productValidatorPage.logout();
    }

    //@Test(dataProvider = "parameters")
    //@ServiceReport
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
        Assert.assertEquals(productExistsPage.getProductAlreadyExistsMessage(), Constants.PRODUCT_ALREADY_EXISTS_MESSAGE);

        /* Logout */
        productExistsPage.logout();
    }

    @Test(dataProvider = "parameters")
    @ServiceReport
    public void checkProductStatusChange(ApplicationSources applicationSources, IAdminUser adminUser) {
        /* Log in and go to ProductCatalogPage */
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        ProductCatalogPage productCatalogPage = dashboardPage.gotoProductCatalogPage();

        /* Select product and change its status */
        ProductCatalogPage.ProductRow row = productCatalogPage.getRowWithProductName(ProductRepository.EXISTING_PRODUCT_NAME);
        while (row == null) {
            if (productCatalogPage.checkNextPageButtonIsEnabled()) {
                productCatalogPage = productCatalogPage.moveToNextPage();
                row = productCatalogPage.getRowWithProductName(ProductRepository.EXISTING_PRODUCT_NAME);
            } else {
                break;
            }
        }
        row.selectProduct();
        productCatalogPage.setDisableProduct();

        /* Check if status is selected */
        Assert.assertNotEquals(row.getProductStatusText(), Constants.DISABLE_PRODUCT_STATUS);
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

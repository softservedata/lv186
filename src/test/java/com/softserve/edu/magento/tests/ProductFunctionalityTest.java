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
        SuccessProductSavePage savePage = addProductPage.gotoSuccessProductSavePageAfterSave();

		/* Check if message appeared and data are present in the fields */
        Assert.assertEquals(savePage.getAttributeSetInputText(), ProductRepository.ATTRIBUTE_SET);
        Assert.assertEquals(savePage.getProductNameInputText(), ProductRepository.VALID_PRODUCT_NAME);
        Assert.assertEquals(savePage.getSkuInputText(), ProductRepository.VALID_SKU);
        Assert.assertEquals(savePage.getPriceInputText(), ProductRepository.VALID_PRICE);
        Assert.assertEquals(savePage.getQuantityInputText(), ProductRepository.QUANTITY);
        Assert.assertEquals(savePage.getSuccessfulProductSaveMessageText().trim(), Constants.PRODUCT_SAVED_MESSAGE);

		/* Go to page with catalog and find row with needed name */
        ProductCatalogPage catalogPage = savePage.returnToProductPage();
        catalogPage = new ProductCatalogPage();
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

    @Test(dataProvider = "parameters")
    @ServiceReport
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
        Assert.assertTrue(productValidatorPage.isProductNameValidatorPresent());
        Assert.assertEquals(productValidatorPage.getProductNameInputText(), ProductRepository.VALID_PRODUCT_NAME);
        Assert.assertTrue(productValidatorPage.isSkuValidatorPresent());
        Assert.assertEquals(productValidatorPage.getSkuInputText(), ProductRepository.VALID_SKU);
        Assert.assertEquals(productValidatorPage.getPriceValidatorText(), Constants.INVALID_PRICE_FIELD_MESSAGE);
    }

    @Test(dataProvider = "parameters")
    @ServiceReport
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
        Assert.assertEquals(productValidatorPage.getProductNameInputText(), ProductRepository.VALID_PRODUCT_NAME);
        Assert.assertEquals(productValidatorPage.getSkuInputText(), "");
        Assert.assertEquals(productValidatorPage.getPriceValidatorText(), Constants.REQUIRED_EMPTY_FIELD_MESSAGE);
        Assert.assertEquals(productValidatorPage.getQuantityInputText(), ProductRepository.QUANTITY);

		/* Logout */
        productValidatorPage.logout();
    }

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
        productExistsPage = new ProductExistsPage();
        productExistsPage.logout();
    }

    @Test(dataProvider = "parameters")
    @ServiceReport
    public void checkProductSaveAndClose(ApplicationSources applicationSources, IAdminUser adminUser)
            throws Exception {
    /* Log in and go to AddProductPage */
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        ProductCatalogPage productCatalogPage = dashboardPage.gotoProductCatalogPage();
        AddProductPage addProductPage = productCatalogPage.gotoAddProductPage();

       /* Get valid data from Product Repository and set them */
        IProduct product = ProductRepository.get().getNewValidProduct();
        addProductPage.setProductData(product);
        ProductCatalogPage catalogPage = addProductPage.gotoCatalogPageAfterSaveClose();

        /* Find row with newly saved product */
        System.out.println("\t*****Check");
        Thread.sleep(5000);
        catalogPage = new ProductCatalogPage();
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
        Assert.assertEquals(row.getProductAttributeSetText(), ProductRepository.ATTRIBUTE_SET);
        Assert.assertEquals(row.getProductSkuText(), ProductRepository.VALID_SKU);
        Assert.assertEquals(row.getProductPriceText(), ProductRepository.VALID_PRICE_FOR_CHECK);

        /* Delete saved product */
        row.selectProduct();
        ProductCatalogPage.DeleteConfirmationPopup popup = catalogPage.clickDeleteProductAction();
        catalogPage = popup.clickDeleteConfirmationButton();

		/* Logout */
        catalogPage.logout();
    }

    @Test(dataProvider = "parameters")
    @ServiceReport
    public void checkProductSaveAndNew(ApplicationSources applicationSources, IAdminUser adminUser) {
    /* Log in and go to AddProductPage */
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        ProductCatalogPage productCatalogPage = dashboardPage.gotoProductCatalogPage();
        AddProductPage addProductPage = productCatalogPage.gotoAddProductPage();

       /* Get valid data from Product Repository and set them */
        IProduct product = ProductRepository.get().getNewValidProduct();
        addProductPage.setProductData(product);
        SuccessProductSavePage savePage = addProductPage.gotoSuccessProductSavePageAfterSaveAndNew();

        /* Check if message appeared and fields are reset */
        Assert.assertEquals(savePage.getAttributeSetInputText(), ProductRepository.ATTRIBUTE_SET);
        Assert.assertEquals(savePage.getProductNameInputText(), "");
        Assert.assertEquals(savePage.getSkuInputText(), "");
        Assert.assertEquals(savePage.getPriceInputText(), "");
        Assert.assertEquals(savePage.getQuantityInputText(), "");
        Assert.assertEquals(savePage.getSuccessfulProductSaveMessageText().trim(), Constants.PRODUCT_SAVED_MESSAGE);

        /* Find row with newly saved product */
        savePage = new SuccessProductSavePage();
        ProductCatalogPage catalogPage = savePage.gotoProductCatalogPage();
        catalogPage = new ProductCatalogPage();
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
        Assert.assertEquals(row.getProductAttributeSetText(), ProductRepository.ATTRIBUTE_SET);
        Assert.assertEquals(row.getProductSkuText(), ProductRepository.VALID_SKU);
        Assert.assertEquals(row.getProductPriceText(), ProductRepository.VALID_PRICE_FOR_CHECK);

        /* Delete saved product */
        row.selectProduct();
        ProductCatalogPage.DeleteConfirmationPopup popup = catalogPage.clickDeleteProductAction();
        catalogPage = popup.clickDeleteConfirmationButton();

		/* Logout */
        catalogPage.logout();
    }

    //@Test(dataProvider = "parameters")
    @ServiceReport
    public void checkProductSaveAndDuplicate(ApplicationSources applicationSources, IAdminUser adminUser) {
        /* Log in and go to AddProductPage */
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        ProductCatalogPage productCatalogPage = dashboardPage.gotoProductCatalogPage();
        AddProductPage addProductPage = productCatalogPage.gotoAddProductPage();

       /* Get valid data from Product Repository and set them */
        IProduct product = ProductRepository.get().getNewValidProduct();
        addProductPage.setProductData(product);
        SuccessProductSaveAndDuplicatePage savePage = addProductPage.gotoSuccessProductSaveAndDuplicatePage();

        /* Check if messages appeared and data are present in the fields */
        //Is product enabled
        Assert.assertEquals(savePage.getAttributeSetInputText(), ProductRepository.ATTRIBUTE_SET);
        Assert.assertEquals(savePage.getProductNameInputText(), ProductRepository.VALID_PRODUCT_NAME);
        Assert.assertEquals(savePage.getSkuInputText(), ProductRepository.VALID_SKU_DUPLICATED);
        Assert.assertEquals(savePage.getPriceInputText(), ProductRepository.VALID_PRICE);
        Assert.assertEquals(savePage.getQuantityInputText(), "");
        Assert.assertEquals(savePage.getSuccessfulProductSaveMessageText().trim(), Constants.PRODUCT_SAVED_MESSAGE);
        Assert.assertEquals(savePage.getSuccessfulProductDuplicateMessageText().trim(), Constants.PRODUCT_DUPLICATED_MESSAGE);

        /* Find row with newly saved product */
        savePage = new SuccessProductSaveAndDuplicatePage();
        ProductCatalogPage catalogPage = savePage.gotoProductCatalogPage();
        catalogPage = new ProductCatalogPage();
        ProductCatalogPage.ProductRow row1 = catalogPage.getRowWithProductName(ProductRepository.VALID_PRODUCT_NAME);
        while (row1 == null) {
            if (catalogPage.checkNextPageButtonIsEnabled()) {
                catalogPage = catalogPage.moveToNextPage();
                row1 = catalogPage.getRowWithProductName(ProductRepository.VALID_PRODUCT_NAME);
            } else {
                break;
            }
        }

        /* Check if new product is present in catalog */
        Assert.assertNotNull(row1);
        Assert.assertEquals(row1.getProductAttributeSetText(), ProductRepository.ATTRIBUTE_SET);
        Assert.assertEquals(row1.getProductSkuText(), ProductRepository.VALID_SKU);
        Assert.assertEquals(row1.getProductPriceText(), ProductRepository.VALID_PRICE_FOR_CHECK);
        Assert.assertEquals(row1.getProductQuantityText(), ProductRepository.QUANTITY_FOR_CHECK);

        /* Find row with duplicated product */
        ProductCatalogPage.ProductRow row2 = catalogPage.getRowWithDuplicatedProduct(ProductRepository.VALID_PRODUCT_NAME, ProductRepository.VALID_SKU_DUPLICATED);
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
        Assert.assertEquals(row2.getProductAttributeSetText(), ProductRepository.ATTRIBUTE_SET);
        Assert.assertEquals(row2.getProductSkuText(), ProductRepository.VALID_SKU_DUPLICATED);
        Assert.assertEquals(row2.getProductPriceText(), ProductRepository.VALID_PRICE_FOR_CHECK);
        Assert.assertEquals(row2.getProductQuantityText(), "");


        /* Delete saved product */
        row1.selectProduct();
        //row2.selectProduct();
        ProductCatalogPage.DeleteConfirmationPopup popup = catalogPage.clickDeleteProductAction();
        catalogPage = popup.clickDeleteConfirmationButton();

		/* Logout */
        catalogPage.logout();
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

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
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ss.af.reporting.annotations.ServiceReport;

/**
 * Created by Corwin on 12.09.2016.
 */
public class ProductValidationTest extends TestBase {

    private SoftAssert softAssert = new SoftAssert();
    @DataProvider
    public Object[][] parameters(ITestContext context) {
        return ListUtils.get()
                .toMultiArray(ParameterUtils.get()
                                .updateParametersAll(ApplicationSourcesRepository.getChromeLocalhostAdmin(), context),
                        AdminUserRepository.get().adminYulia());
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
        softAssert.assertEquals(productExistsPage.getProductAlreadyExistsMessageText(), Constants.PRODUCT_ALREADY_EXISTS_MESSAGE);
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
        softAssert.assertEquals(productValidatorPage.getProductNameValidatorText(), Constants.REQUIRED_EMPTY_FIELD_MESSAGE);
        softAssert.assertEquals(productValidatorPage.getSkuValidatorText(), Constants.REQUIRED_EMPTY_FIELD_MESSAGE);
        softAssert.assertEquals(productValidatorPage.getPriceValidatorText(), Constants.REQUIRED_EMPTY_FIELD_MESSAGE);
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
        softAssert.assertEquals(productValidatorPage.getProductNameInputText(), ProductRepository.INVALID_PRODUCT_NAME);
        softAssert.assertEquals(productValidatorPage.getProductNameValidatorText(), Constants.TOO_LONG_PRODUCT_NAME_MESSAGE);
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
        softAssert.assertEquals(productValidatorPage.getSkuInputText(), ProductRepository.INVALID_SKU);
        softAssert.assertEquals(productValidatorPage.getSkuValidatorText(), Constants.TOO_LONG_SKU_MESSAGE);

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
        softAssert.assertEquals(productValidatorPage.getPriceValidatorText(), Constants.INVALID_PRICE_FIELD_MESSAGE);
        softAssert.assertEquals(productValidatorPage.getProductNameInputText(), ProductRepository.VALID_PRODUCT_NAME);
        softAssert.assertEquals(productValidatorPage.getSkuInputText(), ProductRepository.VALID_SKU);
    }

    @AfterMethod
    public void afterMethod() {
        ApplicationAdmin.signout();
    }

    @AfterClass
    void tearDown() throws Exception {
        ApplicationAdmin.quitAll();
        softAssert.assertAll();
    }
}

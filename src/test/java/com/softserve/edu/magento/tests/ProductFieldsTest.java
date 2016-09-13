package com.softserve.edu.magento.tests;

import com.softserve.edu.magento.data.ApplicationSources;
import com.softserve.edu.magento.data.ApplicationSourcesRepository;
import com.softserve.edu.magento.data.admin.AdminUserRepository;
import com.softserve.edu.magento.data.admin.IAdminUser;
import com.softserve.edu.magento.data.admin.products.Constants;
import com.softserve.edu.magento.data.admin.products.ProductFieldRepository;
import com.softserve.edu.magento.pages.admin.ApplicationAdmin;
import com.softserve.edu.magento.pages.admin.menu.dashboard.DashboardPage;
import com.softserve.edu.magento.pages.admin.menu.products.AddProductPage;
import com.softserve.edu.magento.pages.admin.menu.products.ProductCatalogPage;
import com.softserve.edu.magento.pages.admin.menu.products.ProductValidatorPage;
import com.softserve.edu.magento.tools.ListUtils;
import com.softserve.edu.magento.tools.ParameterUtils;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ss.af.reporting.annotations.ServiceReport;

/**
 * Created by Yulia Nevinglovskaya on 23.08.2016.
 */
public class ProductFieldsTest extends TestBase {
    @DataProvider
    public Object[][] parameters(ITestContext context) {
        return ListUtils.get()
                .toMultiArray(ParameterUtils.get()
                                .updateParametersAll(ApplicationSourcesRepository.getChromeLocalhostAdmin(), context),
                        AdminUserRepository.get().adminYulia());
    }

    @Test(dataProvider = "parameters")
    @ServiceReport
    public void checkFieldsValidation(ApplicationSources applicationSources, IAdminUser adminUser) {
        /* Log in and go to AddProductPage */
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        ProductCatalogPage productCatalogPage = dashboardPage.gotoProductCatalogPage();
        AddProductPage addProductPage = productCatalogPage.gotoAddProductPage();

        addProductPage.setProductNameInputWithClear(ProductFieldRepository.VALID_PRODUCT_NAME);
        ProductValidatorPage productValidatorPage = addProductPage.gotoProductValidatorPageAfterSave();
        Assert.assertFalse(productValidatorPage.isProductNameValidatorPresent());
        productValidatorPage.clearProductNameInput();

        productValidatorPage.setProductNameInputWithClear(ProductFieldRepository.INVALID_PRODUCT_NAME);
        Assert.assertEquals(productValidatorPage.getProductNameValidatorText(), Constants.TOO_LONG_PRODUCT_NAME_MESSAGE);
        productValidatorPage.clearProductNameInput();

        productValidatorPage.setSkuInputWithClear(ProductFieldRepository.VALID_SKU);
        Assert.assertFalse(productValidatorPage.isSkuValidatorPresent());
        productValidatorPage.clearSkuInput();

        //productValidatorPage = new ProductValidatorPage();
        productValidatorPage.setSkuInputWithClear(ProductFieldRepository.INVALID_SKU);
        Assert.assertEquals(productValidatorPage.getSkuValidatorText(), Constants.TOO_LONG_SKU_MESSAGE);
        productValidatorPage.clearSkuInput();

        //productValidatorPage = new ProductValidatorPage();
        productValidatorPage.setPriceInputWithClear(ProductFieldRepository.VALID_PRICE);
        Assert.assertFalse(productValidatorPage.isPriceValidatorPresent());
        productValidatorPage.clearPriceInput();

        //productValidatorPage = new ProductValidatorPage();
        productValidatorPage.setSkuInputWithClear(ProductFieldRepository.INVALID_PRICE);
        Assert.assertEquals(productValidatorPage.getSkuValidatorText(), Constants.TOO_BIG_PRICE_MESSAGE);
        productValidatorPage.clearPriceInput();

        productValidatorPage.logout();
    }
}

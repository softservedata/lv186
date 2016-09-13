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
import com.softserve.edu.magento.pages.admin.menu.products.AddProductPage;
import com.softserve.edu.magento.pages.admin.menu.products.ProductCatalogPage;
import com.softserve.edu.magento.pages.admin.menu.products.ProductValidatorPage;
import com.softserve.edu.magento.tools.ListUtils;
import com.softserve.edu.magento.tools.ParameterUtils;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ss.af.reporting.annotations.ServiceReport;

/**
 * Created by Corwin on 12.09.2016.
 */
public class ProductActionsTest extends TestBase {
        private SoftAssert softAssert = new SoftAssert();

        @DataProvider
        public Object[][] parameters(ITestContext context) {
            return ListUtils.get()
                    .toMultiArray(ParameterUtils.get()
                                    .updateParametersAll(ApplicationSourcesRepository.getChromeLocalhostAdmin(), context),
                            AdminUserRepository.get().adminYulia());
        }

    @AfterMethod
    public void afterMethod() {
        ApplicationAdmin.signout();
    }

    @Test(dataProvider = "parameters")
    @ServiceReport
    public void checkProductSaveWithMixedPrice(ApplicationSources applicationSources, IAdminUser adminUser) {
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

        /* Logout */
        productValidatorPage.logout();
    }
}

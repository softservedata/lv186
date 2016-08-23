package com.softserve.edu.magento.tests;

import com.softserve.edu.magento.data.ApplicationSources;
import com.softserve.edu.magento.data.admin.IAdminUser;
import com.softserve.edu.magento.data.admin.products.Constants;
import com.softserve.edu.magento.data.admin.products.ProductRepository;
import com.softserve.edu.magento.pages.admin.ApplicationAdmin;
import com.softserve.edu.magento.pages.admin.menu.dashboard.DashboardPage;
import com.softserve.edu.magento.pages.admin.menu.products.ProductCatalogPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import ss.af.reporting.annotations.ServiceReport;

/**
 * Created by Yulia Nevinglovskaya on 23.08.2016.
 */
public class ProductActionsTest {
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
}

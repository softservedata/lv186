package com.softserve.edu.magento.tests;


import com.softserve.edu.magento.data.ApplicationSources;
import com.softserve.edu.magento.data.ApplicationSourcesRepository;
import com.softserve.edu.magento.data.admin.AdminUserRepository;
import com.softserve.edu.magento.data.admin.IAdminUser;
import com.softserve.edu.magento.data.admin.dashboard.ISearch;
import com.softserve.edu.magento.data.admin.dashboard.SearchFromRecords;
import com.softserve.edu.magento.data.admin.dashboard.SearchRepository;
import com.softserve.edu.magento.data.admin.products.IProduct;
import com.softserve.edu.magento.data.admin.products.ProductRepository;
import com.softserve.edu.magento.data.customer.user.CustomerUserRepository;
import com.softserve.edu.magento.data.customer.user.CustomerUserRepositoryForAdmin;
import com.softserve.edu.magento.data.customer.user.ICustomerUser;
import com.softserve.edu.magento.pages.admin.ApplicationAdmin;
import com.softserve.edu.magento.pages.admin.menu.dashboard.DashboardPage;
import com.softserve.edu.magento.pages.admin.menu.sales.CreateOrderFillInformationPage;
import com.softserve.edu.magento.pages.admin.menu.sales.CreateOrderSelectCustomerPage;
import com.softserve.edu.magento.pages.admin.menu.sales.OrdersPage;
import com.softserve.edu.magento.pages.customer.ApplicationCustomer;
import com.softserve.edu.magento.pages.customer.HomePageLogout;
import com.softserve.edu.magento.tools.Application;
import com.softserve.edu.magento.tools.ParameterUtils;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ss.af.reporting.annotations.ServiceReport;

import java.util.List;

import static com.softserve.edu.magento.pages.admin.menu.sales.CreateOrderFillInformationPage.SUCCESS_MESSAGE;
import static com.softserve.edu.magento.pages.admin.menu.sales.CreateOrderFillInformationPage.VALIDATION_MESSAGE;

public class OrdersTests extends TestBase {

    @DataProvider(parallel = true)
    public Object[][] parameters(ITestContext context) {
        return new Object[][]{
                {ParameterUtils.get().updateParametersAll(
                        ApplicationSourcesRepository.getChromeMyHostAdminLinux(),
                        context), AdminUserRepository.get().adminBohdan(),
                        CustomerUserRepositoryForAdmin.get().getVeronicaCostello(), ProductRepository.get().getListProducts(new IProduct[]{ProductRepository.get().getErikaRunningShort32Purple()})}};

    }

    @DataProvider(parallel = true)
    public Object[][] parameters2(ITestContext context) {
        return new Object[][]{
                {ParameterUtils.get().updateParametersAll(
                        ApplicationSourcesRepository.getChromeMyHostAdminLinux(),
                        context), AdminUserRepository.get().adminBohdan(),
                        CustomerUserRepository.get().UserYaryna(), ProductRepository.get().getListProducts(new IProduct[]{ProductRepository.get().getErikaRunningShort32Purple()})}};

    }

    @DataProvider(parallel = true)
    public Object[][] parameters3(ITestContext context) {
        return new Object[][]{
                {ParameterUtils.get().updateParametersAll(
                        ApplicationSourcesRepository.getChromeMyHostAdminLinux(),
                        context), AdminUserRepository.get().adminBohdan()}};

    }


    //@Test(dataProvider = "parameters")
    @ServiceReport
    public void tc1(ApplicationSources applicationSources, IAdminUser adminUser, ICustomerUser customerUser, List<IProduct> products) {
        SoftAssert softAssert = new SoftAssert();
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        OrdersPage ordersPage = dashboardPage.gotoOrdersPage();
        CreateOrderSelectCustomerPage createOrderSelectCustomerPage = ordersPage.gotoCreateOrderSelectCustomerPage();
        CreateOrderFillInformationPage createOrderFillInformationPage = createOrderSelectCustomerPage.gotoCreateOrderFillInformationPage(customerUser);
        createOrderFillInformationPage.addProducts(products);
        createOrderFillInformationPage.clickAddProductsToOrder();
        softAssert.assertEquals(createOrderFillInformationPage.getTableOfProducts().isDisplayed(), true);
        createOrderFillInformationPage.clickShippingMethod();
        createOrderFillInformationPage.clickFixedRate();
        createOrderFillInformationPage.successfulSubmitOrder();
        softAssert.assertEquals(createOrderFillInformationPage.getSuccessMessage().getText(), SUCCESS_MESSAGE);
        softAssert.assertAll();
    }

    @Test(dataProvider = "parameters2")
    @ServiceReport
    public void tc2(ApplicationSources applicationSources, IAdminUser adminUser, ICustomerUser customerUser, List<IProduct> products) {
        SoftAssert softAssert = new SoftAssert();
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        OrdersPage ordersPage = dashboardPage.gotoOrdersPage();
        CreateOrderSelectCustomerPage createOrderSelectCustomerPage = ordersPage.gotoCreateOrderSelectCustomerPage();
        CreateOrderFillInformationPage createOrderFillInformationPage = createOrderSelectCustomerPage.gotoCreateOrderFillInformationPage();
        createOrderFillInformationPage.addProducts(products);
        createOrderFillInformationPage.clickAddProductsToOrder();
        softAssert.assertEquals(createOrderFillInformationPage.getTableOfProducts().isDisplayed(), true);
        createOrderFillInformationPage.fillUserRequiredInformation(customerUser);
        createOrderFillInformationPage.clickShippingMethod();
        createOrderFillInformationPage.clickFixedRate();
        createOrderFillInformationPage.successfulSubmitOrder();
        softAssert.assertEquals(createOrderFillInformationPage.getSuccessMessage().getText(), SUCCESS_MESSAGE);
        softAssert.assertAll();
    }

    //@Test(dataProvider = "parameters")
    @ServiceReport
    public void tc3(ApplicationSources applicationSources, IAdminUser adminUser, ICustomerUser customerUser, List<IProduct> products) {
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        OrdersPage ordersPage = dashboardPage.gotoOrdersPage();
        CreateOrderSelectCustomerPage createOrderSelectCustomerPage = ordersPage.gotoCreateOrderSelectCustomerPage();
        CreateOrderFillInformationPage createOrderFillInformationPage = createOrderSelectCustomerPage.gotoCreateOrderFillInformationPage(customerUser);
        createOrderFillInformationPage.addProducts(products);
        createOrderFillInformationPage.clickAddProductsToOrder();
        createOrderFillInformationPage.clickShippingMethod();
        createOrderFillInformationPage.clickFixedRate();
        createOrderSelectCustomerPage = createOrderFillInformationPage.cancelCreateOrder();
        ordersPage = createOrderSelectCustomerPage.gotoOrdersPage();
        Assert.assertTrue(ordersPage.getLogo().isDisplayed());
    }

    //@Test(dataProvider = "parameters")
    @ServiceReport
    public void tc4(ApplicationSources applicationSources, IAdminUser adminUser, ICustomerUser customerUser, List<IProduct> products) {
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        OrdersPage ordersPage = dashboardPage.gotoOrdersPage();
        CreateOrderSelectCustomerPage createOrderSelectCustomerPage = ordersPage.gotoCreateOrderSelectCustomerPage();
        CreateOrderFillInformationPage createOrderFillInformationPage = createOrderSelectCustomerPage.gotoCreateOrderFillInformationPage(customerUser);
        createOrderFillInformationPage.invalidSubmitOrderShippingMethod();
        Assert.assertEquals(createOrderFillInformationPage.getInvalidMessage().getText(), VALIDATION_MESSAGE);
    }

    //@Test(dataProvider = "parameters3")
    @ServiceReport
    public void tc6(ApplicationSources applicationSources, IAdminUser adminUser) {
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        OrdersPage ordersPage = dashboardPage.gotoOrdersPage();
        CreateOrderSelectCustomerPage createOrderSelectCustomerPage = ordersPage.gotoCreateOrderSelectCustomerPage();
        CreateOrderFillInformationPage createOrderFillInformationPage = createOrderSelectCustomerPage.gotoCreateOrderFillInformationPage();
        createOrderFillInformationPage.invalidSubmitOrderUserInfo();
        Assert.assertEquals(SearchFromRecords.checkInvalidMessages(createOrderFillInformationPage.getInvalidMessages()), true);
    }

}

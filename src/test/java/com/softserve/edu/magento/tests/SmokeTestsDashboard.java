package com.softserve.edu.magento.tests;


import java.util.List;

import com.softserve.edu.magento.pages.admin.menu.sales.CreateOrderFillInformationPage;
import com.softserve.edu.magento.pages.admin.menu.sales.CreateOrderSelectCustomerPage;
import com.softserve.edu.magento.pages.admin.menu.sales.OrdersPage;
import com.softserve.edu.magento.tools.Application;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.magento.data.ApplicationSources;
import com.softserve.edu.magento.data.ApplicationSourcesRepository;
import com.softserve.edu.magento.data.admin.AdminUserRepository;
import com.softserve.edu.magento.data.admin.IAdminUser;
import com.softserve.edu.magento.data.admin.dashboard.ISearch;
import com.softserve.edu.magento.data.admin.dashboard.SearchRepository;
import com.softserve.edu.magento.data.customer.user.CustomerUserRepository;
import com.softserve.edu.magento.data.customer.user.CustomerUserRepositoryForAdmin;
import com.softserve.edu.magento.data.customer.user.ICustomerUser;
import com.softserve.edu.magento.pages.admin.ApplicationAdmin;
import com.softserve.edu.magento.pages.admin.menu.dashboard.DashboardPage;
import com.softserve.edu.magento.pages.customer.ApplicationCustomer;
import com.softserve.edu.magento.pages.customer.HomePageLogout;
import com.softserve.edu.magento.tools.ParameterUtils;
import ss.af.reporting.annotations.ServiceReport;

public class SmokeTestsDashboard extends TestBase {

    @DataProvider(parallel = true)
    public Object[][] smokeParameters(ITestContext context) {
        return new Object[][]{
                /*{ ParameterUtils.get().updateParametersAll(
						ApplicationSourcesRepository.getFirefoxLocalhostAdmin(),
						context), AdminUserRepository.get().adminTest(),
						CustomerUserRepositoryForAdmin.get().getTeodorDrayzer() },*/
                {ParameterUtils.get().updateParametersAll(
                        ApplicationSourcesRepository.getChromeMyHostAdminLinux(),
                        context), AdminUserRepository.get().adminBohdan(),
                        CustomerUserRepositoryForAdmin.get().getVeronicaCostello()}};

    }

    @DataProvider(parallel = true)
    public Object[][] smokeParameters2(ITestContext context) {
        return new Object[][]{
				/*{ ParameterUtils.get().updateParametersAll(
						ApplicationSourcesRepository.getFirefoxLocalhostAdmin(),
						context), AdminUserRepository.get().adminBohdan() },*/
                {ParameterUtils.get().updateParametersAll(
                        ApplicationSourcesRepository.getChromeMyHostAdminLinux(),
                        context), AdminUserRepository.get().adminBohdan()}};

    }

    @DataProvider(parallel = true)
    public Object[][] smokeParameters3(ITestContext context) {
        return new Object[][]{
                {ParameterUtils.get().updateParametersAll(
                        ApplicationSourcesRepository.getChromeMyHostCustomerLinux(),
                        context), AdminUserRepository.get().adminBohdan(),
                        ApplicationAdmin.get(ApplicationSourcesRepository.getChromeMyHostAdminLinux()),
                        SearchRepository.get().searchFields()},
				/*{ ParameterUtils.get().updateParametersAll(
						ApplicationSourcesRepository.getFirefoxLocalhostCustomer(),
						context), AdminUserRepository.get().adminTest(),
						ApplicationAdmin.get(ApplicationSourcesRepository.getFirefoxLocalhostAdmin()),
						SearchRepository.get().searchFields() }*/};

    }

    @Test(dataProvider = "smokeParameters")
    @ServiceReport
    public void testOrdersPages(ApplicationSources applicationSources, IAdminUser adminUser, ICustomerUser customerUser) {
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        OrdersPage ordersPage = dashboardPage.gotoOrdersPage();
        CreateOrderSelectCustomerPage createOrderSelectCustomerPage = ordersPage.gotoCreateOrderSelectCustomerPage();
        CreateOrderFillInformationPage createOrderFillInformationPage = createOrderSelectCustomerPage.gotoCreateOrderFillInformationPage(customerUser);
        System.out.println("OK");
    }

    //@Test(dataProvider = "smokeParameters")
    @ServiceReport
    public void findCustomerFromLastOrders(ApplicationSources applicationSources, IAdminUser adminUser,
                                           ICustomerUser customerUser) {
        applicationSources.setSearchStrategy("SearchExplicitStrategyPresent");
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        List<String> result = dashboardPage.getCustomersFromLastOrdersRecords();
        String searchCheck = customerUser.getPersonalInfo().getFirstname() + " "
                + customerUser.getPersonalInfo().getLastname();
        Assert.assertTrue(result.contains(searchCheck), "User not found");
        applicationAdmin.quit();
    }

    //@Test(dataProvider = "smokeParameters2")
    @ServiceReport
    public void checkReloadMessage(ApplicationSources applicationSources, IAdminUser adminUser) {
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        Assert.assertEquals(dashboardPage.getReloadMessageText(), DashboardPage.RELOAD_MESSAGE);
        applicationAdmin.quit();
    }

    //@Test(dataProvider = "smokeParameters3")
    public void checkSearchResults(ApplicationSources applicationSources,
                                   IAdminUser adminUser, ApplicationAdmin adminBrowser, ISearch listOfTerms) {
        ApplicationCustomer applicationCustomer = ApplicationCustomer.get(applicationSources);
        HomePageLogout homePage = applicationCustomer.load();
        List<String> searchTerms = listOfTerms.getSearchFields();
        homePage.search(searchTerms.get(0));
        ApplicationAdmin applicationAdmin = adminBrowser;
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        List<String> searchResultTable = dashboardPage.getSearchTermsFromLastSearchTermsRecords();
        Assert.assertTrue(searchResultTable.contains(searchTerms.get(0)), "SearchRecords term not found");
        applicationAdmin.quit();
    }

    //@AfterMethod
    public void afterMethod() {
        ApplicationAdmin.signout();
        Application.quitAll();
    }

    //@AfterClass
    void tearDown() {
        ApplicationAdmin.quitAll();
    }

}

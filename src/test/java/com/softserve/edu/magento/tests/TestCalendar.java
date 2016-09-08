package com.softserve.edu.magento.tests;

import com.softserve.edu.magento.data.ApplicationSources;
import com.softserve.edu.magento.data.ApplicationSourcesRepository;
import com.softserve.edu.magento.data.admin.AdminUserRepository;
import com.softserve.edu.magento.data.admin.IAdminUser;
import com.softserve.edu.magento.data.customer.user.CustomerUserRepositoryForAdmin;
import com.softserve.edu.magento.pages.admin.ApplicationAdmin;
import com.softserve.edu.magento.pages.admin.menu.customers.AllCustomersPage;
import com.softserve.edu.magento.pages.admin.menu.customers.AllCustomersPageAfterSuccesRegistration;
import com.softserve.edu.magento.pages.admin.menu.customers.RegistrationNewCustomerPage;
import com.softserve.edu.magento.pages.admin.menu.customers.editCustomer.Calendar;
import com.softserve.edu.magento.pages.admin.menu.customers.editCustomer.ICalendar;
import com.softserve.edu.magento.pages.admin.menu.dashboard.DashboardPage;
import com.softserve.edu.magento.tools.ListUtils;
import com.softserve.edu.magento.tools.ParameterUtils;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ss.af.reporting.annotations.ServiceReport;

import static org.testng.Assert.*;

/**
 * Created by ayaremctc on 07.09.2016.
 */
public class TestCalendar {
    @DataProvider
    public Object[][] smokeParameters(ITestContext context) {
        // return new Object[][] {
        // { ParameterUtils.get().updateParametersAll(
        // ApplicationSourcesRepository.getFirefoxLocalhostAdmin(), context),
        // AdminUserRepository.get().adminMykhaylo() },
        // { ParameterUtils.get().updateParametersAll(
        // ApplicationSourcesRepository.getChromeLocalhostAdmin(), context),
        // AdminUserRepository.get().adminMykhaylo() }
        // };
        return ListUtils.get()
                .toMultiArray(
                        ParameterUtils.get()
                                .updateParametersAll(ApplicationSourcesRepository.getChromeLocalhostAdmin(), context),
                        AdminUserRepository.get().adminMykhaylo());
    }



    @Test(dataProvider = "smokeParameters", priority = 1)
    @ServiceReport
    public void validRegistrationNewCustomerAndFindInTheTable(ApplicationSources applicationSources,
                                                              IAdminUser adminUser) throws Exception {
        // Precondition
        // login and go to DashboardPage
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        // go to AllCustomersPage
        AllCustomersPage acp = dashboardPage.gotoAllCustomersPage();
        // Verify that AllCustomersPage is opened

        // go to RegistrationNewCustomerPage
        RegistrationNewCustomerPage regNewCust = acp.goToRegistrationNewCustomerPage();
        // Verify that RegistrationNewCustomerPage is opened

        // setting data to login form
        Calendar calendar = Calendar.initCalendar();
        calendar.setData("10", Calendar.Months.AUGUST, "2005");
        Thread.sleep(8000);
        applicationAdmin.quit();
    }
}

package com.softserve.edu.magento.tests;

import com.softserve.edu.magento.data.ApplicationSources;
import com.softserve.edu.magento.data.ApplicationSourcesRepository;
import com.softserve.edu.magento.data.admin.AdminUserRepository;
import com.softserve.edu.magento.data.admin.IAdminUser;
import com.softserve.edu.magento.pages.admin.ApplicationAdmin;
import com.softserve.edu.magento.pages.admin.menu.customers.AllCustomersPage;
import com.softserve.edu.magento.pages.admin.menu.customers.editCustomer.EditCustomerPage;
import com.softserve.edu.magento.pages.admin.menu.dashboard.DashboardPage;
import com.softserve.edu.magento.tools.ListUtils;
import com.softserve.edu.magento.tools.ParameterUtils;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by ayaremctc on 25.08.2016.
 */
public class EditCustomerTestProper extends  TestBase {
    @DataProvider//(parallel = true)
    public Object[][] smokeParameters(ITestContext context) {
        return ListUtils.get()
                .toMultiArray(
                        ParameterUtils.get()
                                .updateParametersAll(ApplicationSourcesRepository.getChromeLocalhostAdmin(), context),
                        AdminUserRepository.get().adminAndrii());
    }

    @Test (dataProvider = "smokeParameters")
    public  void verifyInputSymbols(ApplicationSources applicationSources, IAdminUser adminUser) {
        // precondition
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        AllCustomersPage allCustomersPage = dashboardPage.gotoAllCustomersPage();
        EditCustomerPage editCustomerPage = allCustomersPage.getEditCustomerPage();
        //
    }
}

package com.softserve.edu.magento.tests;

import com.softserve.edu.magento.data.ApplicationSources;
import com.softserve.edu.magento.data.ApplicationSourcesRepository;
import com.softserve.edu.magento.data.admin.AdminUserRepository;
import com.softserve.edu.magento.data.admin.IAdminUser;
import com.softserve.edu.magento.pages.admin.ApplicationAdmin;
import com.softserve.edu.magento.pages.admin.menu.customers.AllCustomersPage;
import com.softserve.edu.magento.pages.admin.menu.customers.editCustomer.EditCustomerPage;
import com.softserve.edu.magento.pages.admin.menu.customers.editCustomer.ShellExecutor;
import com.softserve.edu.magento.pages.admin.menu.dashboard.DashboardPage;
import com.softserve.edu.magento.tools.ListUtils;
import com.softserve.edu.magento.tools.ParameterUtils;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.softserve.edu.magento.pages.admin.menu.customers.editCustomer.EditCustomerPage.Constants.DEFAULT_BILLING_ADDRESS;
import static com.softserve.edu.magento.pages.admin.menu.customers.editCustomer.EditCustomerPage.Constants.PAGE_TITLE;
import static org.testng.Assert.assertTrue;

/**
 * Created by ayaremctc on 25.08.2016.
 */
public class EditCustomerTestProper extends TestBase {
    @DataProvider
    public Object[][] smokeParameters(ITestContext context) {
        return ListUtils.get()
                .toMultiArray(
                        ParameterUtils.get()
                                .updateParametersAll(ApplicationSourcesRepository.getChromeLocalhostAdmin(), context),
                        AdminUserRepository.get().adminAndrii());
    }

    @Test (dataProvider = "smokeParameters",  groups = "positive")
    public void verifyInputSymbols(ApplicationSources applicationSources, IAdminUser adminUser) {
        // precondition
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        AllCustomersPage allCustomersPage = dashboardPage.gotoAllCustomersPage();
        EditCustomerPage editCustomerPage = allCustomersPage.getEditCustomerPage();

        //click Account Information tab.
        editCustomerPage.navToAccountInfo();

        //enter values into field
        editCustomerPage.enterValuesIntoFields(editCustomerPage.stringFromFile("SpecialSymbols.txt"));

        //click 'Save & Continue Edit' button.
        editCustomerPage = editCustomerPage.saveAndContinueEdit();

        //save page title.
        PAGE_TITLE.setValue(editCustomerPage.getEditCustomerTitle());

        //Verify changes has been made.
        assertTrue(PAGE_TITLE.toString()
                .contains(editCustomerPage.stringFromFile("SpecialSymbols.txt").substring(0, 5)));
        applicationAdmin.quit();
    }

    @Test (dataProvider = "smokeParameters",  groups = "positive")
    public void verifySymbolsMaxCountMandatoryField(ApplicationSources applicationSources, IAdminUser adminUser) {
        // precondition
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        AllCustomersPage allCustomersPage = dashboardPage.gotoAllCustomersPage();
        EditCustomerPage editCustomerPage = allCustomersPage.getEditCustomerPage();

        //click Account Information tab.
        editCustomerPage.navToAccountInfo();

        //enter values into field
        editCustomerPage.enterValueIntoFirstname(editCustomerPage.stringFromFile("SymbolsMaxCount.txt"));

        //click 'Save & Continue Edit' button.
        editCustomerPage = editCustomerPage.saveAndContinueEdit();

        //get error message if present
        editCustomerPage.locateErrorLabel();

        //Verify changes has been made.
        assertTrue(editCustomerPage.getErrorLabel().isDisplayed());
        applicationAdmin.quit();
    }

    @Test (dataProvider = "smokeParameters", groups = "negative")
    public void verifySymbolsMaxCountRegularField(ApplicationSources applicationSources, IAdminUser adminUser) {
        // precondition
        SoftAssert softAssert = new SoftAssert();
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        AllCustomersPage allCustomersPage = dashboardPage.gotoAllCustomersPage();
        EditCustomerPage editCustomerPage = allCustomersPage.getEditCustomerPage();

        //click Account Information tab.
        editCustomerPage.navToAccountInfo();

        //enter values into field
        editCustomerPage.enterValueIntoPrefix(editCustomerPage.stringFromFile("SymbolsMaxCount.txt"));

        //click 'Save & Continue Edit' button.
        editCustomerPage = editCustomerPage.saveAndContinueEdit();

        //get error message if present
        editCustomerPage.locateErrorLabel();

        //verify that validator appears
        softAssert.assertNotNull(editCustomerPage.getErrorLabel());

        //click Account Information tab.
        editCustomerPage.navToAccountInfo();

        //Verify changes has been made.
        softAssert.assertTrue(editCustomerPage.getPrefix().getText().length() ==
                editCustomerPage.stringFromFile("SymbolsMaxCount.txt").length());
        softAssert.assertAll();
        applicationAdmin.quit();
    }

    @Test (dataProvider = "smokeParameters", groups = "negative")
    public void verifySymbolsMaxCountDisplayed(ApplicationSources applicationSources, IAdminUser adminUser) {
        // precondition
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        AllCustomersPage allCustomersPage = dashboardPage.gotoAllCustomersPage();
        EditCustomerPage editCustomerPage = allCustomersPage.getEditCustomerPage();

        //click Account Information tab.
        editCustomerPage.navToAccountInfo();

        //enter values into field
        editCustomerPage.enterValueIntoFirstname(editCustomerPage
                .stringFromFile("SymbolsMaxCount.txt").substring(0, 200));

        //click 'Save & Continue Edit' button.
        editCustomerPage = editCustomerPage.saveAndContinueEdit();

        //get page title value
        PAGE_TITLE.setValue(editCustomerPage.getEditCustomerTitle());

        //Verify that page title contains entered data.
        assertTrue(PAGE_TITLE.toString()
                .contains(editCustomerPage.stringFromFile("SymbolsMaxCount.txt")));

        applicationAdmin.quit();
    }

    @Test(dataProvider = "smokeParameters", groups = "positive")
    public void pickNewDefaultBillingAddress(ApplicationSources applicationSources, IAdminUser adminUser) {
        // precondition
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        AllCustomersPage allCustomersPage = dashboardPage.gotoAllCustomersPage();
        EditCustomerPage editCustomerPage = allCustomersPage.getEditCustomerPage();

        //click Account Information tab.
        editCustomerPage.navToadresses();

        //enter values into field
        editCustomerPage.createNewAddress(editCustomerPage.stringFromFile("NewAddress.txt"));

        //select new billing address
        editCustomerPage.checkNewDefaultBillingAddress();

        //click 'Save & Continue Edit' button.
        editCustomerPage = editCustomerPage.saveAndContinueEdit();
        DEFAULT_BILLING_ADDRESS.setValue(editCustomerPage.getAddressValues());

        assertTrue(DEFAULT_BILLING_ADDRESS.toString().contains(editCustomerPage.stringFromFile("NewAddress.txt").substring(0, 19)));

        applicationAdmin.quit();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        ApplicationAdmin.signout();
        ApplicationAdmin.quitAll();
    }

    @AfterClass(alwaysRun = true)
    void tearDown() throws Exception {
        ShellExecutor executor = new ShellExecutor();
        executor.executeFile("dropmagento.sh");
        ApplicationAdmin.quitAll();
    }

}

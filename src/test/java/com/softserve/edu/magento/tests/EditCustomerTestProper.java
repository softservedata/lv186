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
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.softserve.edu.magento.pages.admin.menu.customers.editCustomer.EditCustomerPage.Constants.DEFAULT_BILLING_ADDRESS;
import static com.softserve.edu.magento.pages.admin.menu.customers.editCustomer.EditCustomerPage.Constants.PAGE_TITLE;

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

    //@Test (dataProvider = "smokeParameters")
    public  void verifyInputSymbols(ApplicationSources applicationSources, IAdminUser adminUser) {
        // precondition
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        AllCustomersPage allCustomersPage = dashboardPage.gotoAllCustomersPage();
        EditCustomerPage editCustomerPage = allCustomersPage.getEditCustomerPage();

        //save page title.
       PAGE_TITLE.setValue(editCustomerPage.getEditCustomerTitle());

        //click Account Information tab.
        editCustomerPage.navToAccountInfo();

        //enter values into field
        editCustomerPage.enterValuesIntoFields(editCustomerPage.stringFromFile("SpecialSymbols.txt"));

        //click 'Save & Continue Edit' button.
        editCustomerPage = editCustomerPage.saveAndContinueEdit();

        //Verify changes has been made.
        Assert.assertTrue(PAGE_TITLE.toString()
                .contains(editCustomerPage.stringFromFile("SpecialSymbols.txt")) );
        applicationAdmin.quit();
    }

    //@Test (dataProvider = "smokeParameters")
    public  void verifySymbolsMaxCountMandatoryField(ApplicationSources applicationSources, IAdminUser adminUser) {
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
        Assert.assertTrue(editCustomerPage.getErrorLabel().isDisplayed());
        applicationAdmin.quit();
    }

    //@Test (dataProvider = "smokeParameters")
    public  void verifySymbolsMaxCountRegularField(ApplicationSources applicationSources, IAdminUser adminUser) {
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

        editCustomerPage.locateErrorLabel();
        //get error message if present
        softAssert.assertNotNull(editCustomerPage.getErrorLabel());

        //click Account Information tab.
        editCustomerPage.navToAccountInfo();

        //Verify changes has been made.
        softAssert.assertTrue(editCustomerPage.getPrefix().getText().length() ==
                editCustomerPage.stringFromFile("SymbolsMaxCount.txt").length());
        softAssert.assertAll();
        applicationAdmin.quit();
    }

    @Test (dataProvider = "smokeParameters")
    public  void pickNewDefaultBillingAddress(ApplicationSources applicationSources, IAdminUser adminUser) {
        // precondition
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        AllCustomersPage allCustomersPage = dashboardPage.gotoAllCustomersPage();
        EditCustomerPage editCustomerPage = allCustomersPage.getEditCustomerPage();

        DEFAULT_BILLING_ADDRESS.setValue(editCustomerPage.getAddressValues());
        //click Account Information tab.
        editCustomerPage.navToadresses();

        //enter values into field
        editCustomerPage.createNewAddress(editCustomerPage.stringFromFile("NewAddress.txt"));

        //select new billing address
        editCustomerPage.checkNewDefaultBillingAddress();

        //click 'Save & Continue Edit' button.
        editCustomerPage = editCustomerPage.saveAndContinueEdit();

        Assert.assertTrue(editCustomerPage.getAddressValues().contains(editCustomerPage.stringFromFile("NewAddress.txt")));

        applicationAdmin.quit();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        ApplicationAdmin.signout();
        // ApplicationAdmin.quitAll();
    }

    @AfterClass(alwaysRun = true)
    void tearDown() throws Exception {
        ApplicationAdmin.quitAll();
    }

}

package com.softserve.edu.magento.tests;

import com.softserve.edu.magento.data.ApplicationSources;
import com.softserve.edu.magento.data.ApplicationSourcesRepository;
import com.softserve.edu.magento.data.admin.AdminUserRepository;
import com.softserve.edu.magento.data.admin.IAdminUser;
import com.softserve.edu.magento.data.admin.products.CategoryRepository;
import com.softserve.edu.magento.pages.admin.ApplicationAdmin;
import com.softserve.edu.magento.pages.admin.menu.dashboard.DashboardPage;
import com.softserve.edu.magento.pages.admin.menu.products.categories.CategoriesPage;
import com.softserve.edu.magento.tools.ParameterUtils;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ss.af.reporting.annotations.ServiceReport;

public class CategoryAddDeleteTest extends TestBase{
    private SoftAssert softAccert = new SoftAssert();

    @DataProvider
    public Object[][] parameters(ITestContext context) {
        return new Object[][] {
                { ParameterUtils.get().updateParametersAll(ApplicationSourcesRepository.getFirefoxLocalhostAdmin(),
                        context), AdminUserRepository.get().adminOlya() },
                { ParameterUtils.get().updateParametersAll(ApplicationSourcesRepository.getChromeLocalhostAdmin(),
                        context), AdminUserRepository.get().adminOlya() } };

    }

    @Test(dataProvider = "parameters", priority = 1)
    @ServiceReport
    public void addRootCategory(ApplicationSources applicationSources, IAdminUser adminUser){
        ApplicationAdmin admin = ApplicationAdmin.get(applicationSources);

        DashboardPage dashboardPage = admin.load().successAdminLogin(adminUser);
        CategoriesPage page = dashboardPage.gotoCategoriesPage();
        page.addNewCategory(CategoryRepository.CATEGORY_NAME);
        System.out.println(page.checkCategoryByName(CategoryRepository.CATEGORY_NAME));
        softAccert.assertTrue(page.checkCategoryByName(CategoryRepository.CATEGORY_NAME));
        System.out.println("addRootCategory done");
    }

    @Test (dataProvider = "parameters", priority = 2)
    @ServiceReport
    public void addSubCategory(ApplicationSources applicationSources, IAdminUser adminUser) {
        ApplicationAdmin admin = ApplicationAdmin.get(applicationSources);

        DashboardPage dashboardPage = admin.load().successAdminLogin(adminUser);
        CategoriesPage page = dashboardPage.gotoCategoriesPage();
        page.addNewSubCategory(CategoryRepository.SUBCATEGORY_PARENT_NAME, CategoryRepository.SUBCATEGORY_NAME);
        System.out.println(page.checkCategoryByName(CategoryRepository.SUBCATEGORY_NAME));
        softAccert.assertTrue(page.checkCategoryByName(CategoryRepository.SUBCATEGORY_NAME));
        System.out.println("addSubCategory done");
    }

    @Test(dataProvider = "parameters", priority = 3)
    @ServiceReport
    public void deleteCategoryTest(ApplicationSources applicationSources, IAdminUser adminUser) {
        ApplicationAdmin admin = ApplicationAdmin.get(applicationSources);

        DashboardPage dashboardPage = admin.load().successAdminLogin(adminUser);
        CategoriesPage page = dashboardPage.gotoCategoriesPage();
        page.deleteCategory(CategoryRepository.SUBCATEGORY_NAME);
        page.deleteCategory(CategoryRepository.CATEGORY_NAME);
        System.out.println(page.checkCategoryByName(CategoryRepository.CATEGORY_NAME));
        System.out.println(page.checkCategoryByName(CategoryRepository.SUBCATEGORY_NAME));
        softAccert.assertFalse(page.checkCategoryByName(CategoryRepository.CATEGORY_NAME));
        softAccert.assertFalse(page.checkCategoryByName(CategoryRepository.SUBCATEGORY_NAME));
        System.out.println("deleteCategory done");
    }

    @AfterMethod
    public void afterMethod() {
        ApplicationAdmin.signout();
    }

    @AfterClass
    void tearDown() throws Exception {
        ApplicationAdmin.quitAll();
        softAccert.assertAll();
    }
}

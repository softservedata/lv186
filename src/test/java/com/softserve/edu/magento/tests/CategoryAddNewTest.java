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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Olia on 22.07.2016.
 */
public class CategoryAddNewTest {
    @DataProvider(parallel = true)
    public Object[][] parameters(ITestContext context) {
        return new Object[][] {
                { ParameterUtils.get().updateParametersAll(ApplicationSourcesRepository.getFirefoxLocalhostAdmin(),
                        context), AdminUserRepository.get().adminOlya() }/*,
                { ParameterUtils.get().updateParametersAll(ApplicationSourcesRepository.getChromeLocalhostAdmin(),
                        context), AdminUserRepository.get().adminOlya() }*/ };

    }

    @Test(dataProvider = "parameters")
    public void addRootCategory(ApplicationSources applicationSources, IAdminUser adminUser){
        ApplicationAdmin admin = ApplicationAdmin.get(applicationSources);


        DashboardPage dashboardPage = admin.load().successAdminLogin(adminUser);
        CategoriesPage page = dashboardPage.gotoCategoriesPage();
        page.clickAddRootCategory();
        page = page.refresh();
        page.setCategoryName(CategoryRepository.CATEGORY_NAME);
        page.clickContent();
        page.saveCategory();
        page.checkCategoryByName(CategoryRepository.CATEGORY_NAME);

    }

    @Test (dataProvider = "parameters")
    public void addSubCategory(ApplicationSources applicationSources, IAdminUser adminUser) {
        ApplicationAdmin admin = ApplicationAdmin.get(applicationSources);

        DashboardPage dashboardPage = admin.load().successAdminLogin(adminUser);
        CategoriesPage page = dashboardPage.gotoCategoriesPage();
        page.clickAddSubcategory();
        page = page.refresh();
        page.setCategoryName(CategoryRepository.SUBCATEGORY_NAME);
        page.clickContent();
        page.saveCategory();
        page.checkCategoryByName(CategoryRepository.SUBCATEGORY_NAME);
    }

    @AfterClass
    void tearDown() throws Exception {
        ApplicationAdmin.quitAll();
    }
}

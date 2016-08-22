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
import org.testng.annotations.*;

/**
 * Created by Olia on 22.07.2016.
 */
public class CategoryPageSmokeTest {

    @DataProvider(parallel = true)
    public Object[][] parameters(ITestContext context) {
        return new Object[][] {
                { ParameterUtils.get().updateParametersAll(ApplicationSourcesRepository.getFirefoxLocalhostAdmin(),
                        context), AdminUserRepository.get().adminOlya() },
               /* { ParameterUtils.get().updateParametersAll(ApplicationSourcesRepository.getChromeLocalhostAdmin(),
                        context), AdminUserRepository.get().adminOlya() }*/ };

    }

    @Test(dataProvider = "parameters")
    public void clickable(ApplicationSources applicationSources, IAdminUser adminUser) throws InterruptedException {
        ApplicationAdmin admin = ApplicationAdmin.get(applicationSources);

        DashboardPage dashboardPage = admin.load().successAdminLogin(adminUser);
        CategoriesPage page = dashboardPage.gotoCategoriesPage();

        page.saveCategory();
        page = page.refresh();
        page.clickAddRootCategory();
        page = page.refresh();
        page.clickAddSubCategory();
        page = page.refresh();
        page.clickEnabledCategory();
        page.clickIncludeInMenu();
        page.setCategoryName(CategoryRepository.CATEGORY_NAME);
        page.clickContent();
        page.clickContent();
        page.clickDisplaySettings();
        page.clickDisplaySettings();
        page.clickSearchEngineOptimization();
        page.clickSearchEngineOptimization();
        page.clickProductsInCategory();
        page.clickProductsInCategory();
        page.clickDesign();
        page.clickDesign();
        page.clickScheduleDesignUpdate();
        page.clickScheduleDesignUpdate();

    }

    @AfterClass
    void tearDown() throws Exception {
        ApplicationAdmin.quitAll();
    }
}

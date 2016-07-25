package com.softserve.edu.magento.tests;

import com.softserve.edu.magento.data.AdminUserRepository;
import com.softserve.edu.magento.data.ApplicationSources;
import com.softserve.edu.magento.data.ApplicationSourcesRepository;
import com.softserve.edu.magento.data.IAdminUser;
import com.softserve.edu.magento.pages.ApplicationAdmin;
import com.softserve.edu.magento.pages.menu.dashboard.DashboardPage;
import com.softserve.edu.magento.pages.menu.products.Categories.CategoriesPage;
import com.softserve.edu.magento.tools.ParameterUtils;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Olia on 25.07.2016.
 */
public class CategoryDeleteTest {
    @DataProvider(parallel = true)
    public Object[][] parameters(ITestContext context) {
        return new Object[][] {
                { ParameterUtils.get().updateParametersAll(ApplicationSourcesRepository.getFirefoxLocalhostAdmin(),
                        context), AdminUserRepository.get().adminOlya() },
                { ParameterUtils.get().updateParametersAll(ApplicationSourcesRepository.getChromeLocalhostAdmin(),
                        context), AdminUserRepository.get().adminOlya() } };

    }

    @Test(dataProvider = "parameters")
    public void deleteCategoryTest(ApplicationSources applicationSources, IAdminUser adminUser){
        ApplicationAdmin admin = ApplicationAdmin.get(applicationSources);
        final String CATEGORY_NAME = "Name";

        DashboardPage dashboardPage = admin.load().successAdminLogin(adminUser);
        CategoriesPage page = dashboardPage.gotoCategoriesPage();
        page.findCategoryByName(CATEGORY_NAME).click();
        page.clickDelete();
        Assert.assertEquals(page.checkCategoryByName(CATEGORY_NAME), false);

    }
}

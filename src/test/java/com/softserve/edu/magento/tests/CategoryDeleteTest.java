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
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.softserve.edu.magento.data.admin.products.CategoryRepository.CATEGORY_NAME;

/**
 * Created by Olia on 25.07.2016.
 */
public class CategoryDeleteTest {
    @DataProvider(parallel = true)
    public Object[][] parameters(ITestContext context) {
        return new Object[][] {
                { ParameterUtils.get().updateParametersAll(ApplicationSourcesRepository.getFirefoxLocalhostAdmin(),
                        context), AdminUserRepository.get().adminOlya() }/*,
                { ParameterUtils.get().updateParametersAll(ApplicationSourcesRepository.getChromeLocalhostAdmin(),
                        context), AdminUserRepository.get().adminOlya() }*/ };

    }

    @Test(dataProvider = "parameters")
    public void deleteCategoryTest(ApplicationSources applicationSources, IAdminUser adminUser){
        ApplicationAdmin admin = ApplicationAdmin.get(applicationSources);

        DashboardPage dashboardPage = admin.load().successAdminLogin(adminUser);
        CategoriesPage page = dashboardPage.gotoCategoriesPage();
        page.selectCategory(CategoryRepository.CATEGORY_NAME);
        page.clickDelete();
        Assert.assertEquals(page.checkCategoryByName(CategoryRepository.CATEGORY_NAME), false);

    }
}

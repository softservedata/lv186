package com.softserve.edu.magento.tests;

import com.softserve.edu.magento.data.ApplicationSources;
import com.softserve.edu.magento.data.ApplicationSourcesRepository;
import com.softserve.edu.magento.data.admin.AdminUserRepository;
import com.softserve.edu.magento.data.admin.IAdminUser;
import com.softserve.edu.magento.pages.admin.ApplicationAdmin;
import com.softserve.edu.magento.pages.admin.menu.dashboard.DashboardPage;
import com.softserve.edu.magento.pages.admin.menu.products.categories.CategoriesPage;
import com.softserve.edu.magento.tools.ParameterUtils;
import org.testng.Assert;
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

    //@Test(dataProvider = "parameters")
    public void presents(ApplicationSources applicationSources, IAdminUser adminUser) throws Exception{
        /*WebDriver driver = new FirefoxDriver();
        driver.get("http://192.168.195.210/magento/admin");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);*/
        ApplicationAdmin admin = ApplicationAdmin.get(applicationSources);
        //DashboardPage dashboardPage = new AdminLoginPage(driver).successAdminLogin(AdminUserRepository.get().adminOlya());

        //TODO
        final String IMAGE_PATH = "C:\\Users\\Olia\\Pictures\\1.jpeg";
        final String CATEGORY_NAME = "Name";

        DashboardPage dashboardPage = admin.load().successAdminLogin(adminUser);
        CategoriesPage page = dashboardPage.gotoCategoriesPage();

        Assert.assertNotNull(page.getAddRootCategory());
        Assert.assertNotNull(page.getAddSubcategory());
        Assert.assertNotNull(page.getSave());
        Assert.assertNotNull(page.getEnabledCategory());
        Assert.assertNotNull(page.getIncludeInMenu());
        Assert.assertNotNull(page.getCategoryName());
        Assert.assertNotNull(page.getContent());
        Assert.assertNotNull(page.getDisplaySettings());
        Assert.assertNotNull(page.getSearchEngineOptimization());
        Assert.assertNotNull(page.getProductsInCategory());
        Assert.assertNotNull(page.getDesign());
        Assert.assertNotNull(page.getScheduleDesignUpdate());
        Assert.assertNull(page.getDelete());
        Assert.assertNull(page.getMessage());
    }

    @Test(dataProvider = "parameters")
    public void clickable(ApplicationSources applicationSources, IAdminUser adminUser) throws InterruptedException {
        ApplicationAdmin admin = ApplicationAdmin.get(applicationSources);
        final String CATEGORY_NAME = "Name";

        DashboardPage dashboardPage = admin.load().successAdminLogin(adminUser);
        CategoriesPage page = dashboardPage.gotoCategoriesPage();

        page.clickAddRootCategory();
        page = page.refresh();
        page.clickAddSubcategory();
        page = page.refresh();
        page.clickEnabledCategory();
        page.clickIncludeInMenu();
        page.setCategoryName(CATEGORY_NAME);
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
        page.saveCategory();
        System.out.println("ok");
    }

    /*@AfterMethod
    public void afterMethod() {
        ApplicationAdmin.signout();
    }*/

    @AfterClass
    void tearDown() throws Exception {
        ApplicationAdmin.quitAll();
    }
}

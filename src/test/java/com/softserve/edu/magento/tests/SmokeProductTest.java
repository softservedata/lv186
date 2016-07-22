package com.softserve.edu.magento.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.magento.data.AdminUserRepository;
import com.softserve.edu.magento.data.ApplicationSources;
import com.softserve.edu.magento.data.ApplicationSourcesRepository;
import com.softserve.edu.magento.data.Constants;
import com.softserve.edu.magento.data.FilterData;
import com.softserve.edu.magento.data.FilterRepository;
import com.softserve.edu.magento.data.IAdminUser;
import com.softserve.edu.magento.data.IProduct;
import com.softserve.edu.magento.data.ProductRepository;
import com.softserve.edu.magento.pages.AddProductPage;
import com.softserve.edu.magento.pages.ApplicationAdmin;
import com.softserve.edu.magento.pages.ProductCatalogPage;
import com.softserve.edu.magento.pages.ProductCatalogPage.ProductRow;
import com.softserve.edu.magento.pages.ProductValidatorPage;
import com.softserve.edu.magento.pages.SuccessProductSavePage;
import com.softserve.edu.magento.pages.menu.dashboard.DashboardPage;
import com.softserve.edu.magento.tools.ParameterUtils;

public class SmokeProductTest {

	@DataProvider(parallel = true)
	public Object[][] parameters(ITestContext context) {
		return new Object[][] {
				{ ParameterUtils.get().updateParametersAll(ApplicationSourcesRepository.getFirefoxLocalhostAdmin(),
						context), AdminUserRepository.get().adminMykhaylo() },
				{ ParameterUtils.get().updateParametersAll(ApplicationSourcesRepository.getChromeLocalhostAdmin(),
						context), AdminUserRepository.get().adminYulia() } };

	}

	@Test(dataProvider = "parameters")
	public void checkProductSaved(ApplicationSources applicationSources, IAdminUser adminUser) throws Exception {

		ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
		DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
		ProductCatalogPage productCatalogPage = dashboardPage.gotoProductCatalogPage();

		AddProductPage addProductPage = productCatalogPage.gotoAddProductPage();

		IProduct product = ProductRepository.get().getNewValidProduct();

		addProductPage.setAttributeSet(product.getAttributeSet());
		addProductPage.setProductName(product.getProductName());
		addProductPage.setSku(product.getSku());
		addProductPage.setPrice(product.getPrice());
		SuccessProductSavePage savePage = addProductPage.gotoSuccessProductSavePage();

		/* Check if message appeared and data are present in the fields */
		Assert.assertEquals(product.getAttributeSet(), ProductRepository.ATTRIBUTE_SET);
		Assert.assertEquals(product.getProductName(), ProductRepository.VALID_PRODUCT_NAME);
		Assert.assertEquals(product.getSku(), ProductRepository.VALID_SKU);
		Assert.assertEquals(product.getPrice(), ProductRepository.VALID_PRICE);
		Assert.assertEquals(savePage.getSuccessfulProductSaveMessageText().trim(), Constants.PRODUCT_SAVED_MESSAGE);

		/* Go to page with catalog and find row with needed name */
		ProductCatalogPage catalogPage = savePage.returnToProductPage();
		ProductRow row = catalogPage.getRowWithProductName(ProductRepository.VALID_PRODUCT_NAME);
		while (row == null) {
			if (catalogPage.checkNextPageButtonIsEnabled()) {
				catalogPage = catalogPage.moveToNextPage();
				row = catalogPage.getRowWithProductName(ProductRepository.VALID_PRODUCT_NAME);
			} else {
				break;
			}
		}

		/* Check if saved product is present in catalog */
		Assert.assertNotNull(row);
		Assert.assertEquals(row.getProductAttributeSetText(), ProductRepository.ATTRIBUTE_SET);
		Assert.assertEquals(row.getProductSkuText(), ProductRepository.VALID_SKU);
		Assert.assertEquals(row.getProductPriceText(), ProductRepository.VALID_PRICE);

		/* Logout */
		productCatalogPage.logout();

	}

	@Test(dataProvider = "parameters")
	public void checkProductSaveValidation(ApplicationSources applicationSources, IAdminUser adminUser)
			throws Exception {
		ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
		DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
		ProductCatalogPage productCatalogPage = dashboardPage.gotoProductCatalogPage();

		/* Go to page to create a new product */
		AddProductPage addProductPage = productCatalogPage.gotoAddProductPage();

		/* Enter invalid data into the fields */
		IProduct product = ProductRepository.get().getNewProductWithEmptyInvalidData();
		addProductPage.setProductData(product);
		addProductPage.clickSaveAndCloseButton();

		ProductValidatorPage productValidatorPage = addProductPage.gotoProductValidatorPage();

		// Assert.assertTrue(productValidatorPage.doesProductNameValidatorExist());
		// Assert.assertTrue(productValidatorPage.doesSkuValidatorExist());
		// Assert.assertTrue(productValidatorPage.doesPriceValidatorExist());

		/* Check if error messages appeared */
		Assert.assertEquals(productValidatorPage.getProductNameValidatorText(), Constants.REQUIRED_EMPTY_FIELD_MESSAGE);
		Assert.assertEquals(productValidatorPage.getSkuValidatorText(), Constants.REQUIRED_EMPTY_FIELD_MESSAGE);
		Assert.assertEquals(productValidatorPage.getPriceValidatorText(), Constants.INVALID_PRICE_FIELD_MESSAGE);

		/* Logout */
		productCatalogPage.logout();
	}

	@Test(dataProvider = "parameters")
	public void filterTest(ApplicationSources applicationSources, IAdminUser adminUser) throws Exception {
		ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
		DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
		ProductCatalogPage productCatalogPage = dashboardPage.gotoProductCatalogPage();

		FilterRepository filters = new FilterRepository();

		FilterData nameFilter = filters.getExistingName();
		productCatalogPage.getFilter().setFilterData(nameFilter);
		productCatalogPage = productCatalogPage.getFilter().applyFilters();

		List<ProductRow> filteredProducts = productCatalogPage.getProducts();

		for (ProductRow row : filteredProducts) {
			Assert.assertTrue(row.getProductNameText().contains(nameFilter.getName()));
		}

		// Assert.assertNotNull(page.getRowWithProductName(nameFilter.getFilterName()));

		/* Logout */
		productCatalogPage.logout();

	}

	@AfterMethod
	public void afterMethod() {
		ApplicationAdmin.signout();
		// ApplicationAdmin.quitAll();
	}

	@AfterClass
	void tearDown() throws Exception {
		ApplicationAdmin.quitAll();
	}

}

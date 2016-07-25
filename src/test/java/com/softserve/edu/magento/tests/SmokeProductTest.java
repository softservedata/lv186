package com.softserve.edu.magento.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.magento.data.admin.AdminUserRepository;
import com.softserve.edu.magento.data.ApplicationSources;
import com.softserve.edu.magento.data.ApplicationSourcesRepository;
import com.softserve.edu.magento.data.admin.products.Constants;
import com.softserve.edu.magento.data.Filter;
import com.softserve.edu.magento.data.admin.products.FilterRepository;
import com.softserve.edu.magento.data.admin.IAdminUser;
import com.softserve.edu.magento.data.admin.products.IProduct;
import com.softserve.edu.magento.data.admin.products.ProductRepository;
import com.softserve.edu.magento.pages.admin.ApplicationAdmin;
import com.softserve.edu.magento.pages.admin.menu.dashboard.DashboardPage;
import com.softserve.edu.magento.pages.admin.menu.products.AddProductPage;
import com.softserve.edu.magento.pages.admin.menu.products.ProductCatalogPage;
import com.softserve.edu.magento.pages.admin.menu.products.ProductCatalogPage.DeleteConfirmationPopup;
import com.softserve.edu.magento.pages.admin.menu.products.ProductCatalogPage.FilterObject;
import com.softserve.edu.magento.pages.admin.menu.products.ProductCatalogPage.ProductRow;
import com.softserve.edu.magento.pages.admin.menu.products.ProductValidatorPage;
import com.softserve.edu.magento.pages.admin.menu.products.SuccessProductSavePage;
import com.softserve.edu.magento.tools.ParameterUtils;

/**
 * SmokeProductTest class checks basic functionality of new product save,
 * validation, filtration.
 * 
 * @author Yulia Nevinglovskaya
 *
 */

public class SmokeProductTest {

	@DataProvider
	public Object[][] parameters(ITestContext context) {
		return new Object[][] {
				{ ParameterUtils.get().updateParametersAll(ApplicationSourcesRepository.getFirefoxLocalhostAdmin(),
						context), AdminUserRepository.get().adminYulia() } };
	}

	@Test(dataProvider = "parameters")
	public void checkProductSaved(ApplicationSources applicationSources, IAdminUser adminUser) throws Exception {

		/* Log in and go to AddProductPage */
		ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
		DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
		ProductCatalogPage productCatalogPage = dashboardPage.gotoProductCatalogPage();
		AddProductPage addProductPage = productCatalogPage.gotoAddProductPage();

		/* Get data from Product Repository and set them */
		IProduct product = ProductRepository.get().getNewValidProduct();
		addProductPage.setProductData(product);
		SuccessProductSavePage savePage = addProductPage.gotoSuccessProductSavePageAfterSave();

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
		Assert.assertEquals(row.getProductPriceText(), ProductRepository.VALID_PRICE_FOR_CHECK);

		/* Delete saved product */
		row.selectProduct();
		DeleteConfirmationPopup popup = catalogPage.clickDeleteProductAction();
		catalogPage = popup.clickDeleteConfirmationButton();

		/* Logout */
		catalogPage.logout();

	}

	@Test(dataProvider = "parameters")
	public void checkProductSaveValidation(ApplicationSources applicationSources, IAdminUser adminUser)
			throws Exception {

		/* Log in and go to AddProductPage */
		ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
		DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
		ProductCatalogPage productCatalogPage = dashboardPage.gotoProductCatalogPage();
		AddProductPage addProductPage = productCatalogPage.gotoAddProductPage();

		/* Get invalid data from Product Repository and set them */
		IProduct product = ProductRepository.get().getNewProductWithEmptyInvalidData();
		addProductPage.setProductData(product);
		ProductValidatorPage productValidatorPage = addProductPage.gotoProductValidatorPageAfterSaveAndClose();

		/* Check if error messages appeared */
		Assert.assertEquals(productValidatorPage.getProductNameValidatorText(), Constants.REQUIRED_EMPTY_FIELD_MESSAGE);
		Assert.assertEquals(productValidatorPage.getSkuValidatorText(), Constants.REQUIRED_EMPTY_FIELD_MESSAGE);
		Assert.assertEquals(productValidatorPage.getPriceValidatorText(), Constants.INVALID_PRICE_FIELD_MESSAGE);

		/* Logout */
		productValidatorPage.logout();
	}

	@Test(dataProvider = "parameters")
	public void checkFilters(ApplicationSources applicationSources, IAdminUser adminUser) throws Exception {

		/* Log in and go to ProductCatalogPage */
		ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
		DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
		ProductCatalogPage productCatalogPage = dashboardPage.gotoProductCatalogPage();

		FilterObject filterPage = productCatalogPage.clickFilterButton();
		Filter nameFilter = FilterRepository.get().getExistingName();
		filterPage.setFilter(nameFilter);
		productCatalogPage = filterPage.applyFilters();

		/* Check if there are only products of filtered name */
		List<ProductRow> filteredProducts = productCatalogPage.getProducts();
		for (ProductRow row : filteredProducts) {
			Assert.assertTrue(row.getProductNameText().contains(nameFilter.getName()));
		}

		/* Logout */
		productCatalogPage.logout();

	}

	@AfterMethod
	public void afterMethod() {
		ApplicationAdmin.signout();
	}

	@AfterClass
	void tearDown() throws Exception {
		ApplicationAdmin.quitAll();
	}
}
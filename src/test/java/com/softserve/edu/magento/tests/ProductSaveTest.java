package com.softserve.edu.magento.tests;

import com.softserve.edu.magento.data.ApplicationSources;
import com.softserve.edu.magento.data.ApplicationSourcesRepository;
import com.softserve.edu.magento.data.admin.AdminUserRepository;
import com.softserve.edu.magento.data.admin.IAdminUser;
import com.softserve.edu.magento.data.admin.products.Constants;
import com.softserve.edu.magento.data.admin.products.IProduct;
import com.softserve.edu.magento.data.admin.products.ProductRepository;
import com.softserve.edu.magento.pages.admin.ApplicationAdmin;
import com.softserve.edu.magento.pages.admin.menu.dashboard.DashboardPage;
import com.softserve.edu.magento.pages.admin.menu.products.*;
import com.softserve.edu.magento.tools.ListUtils;
import com.softserve.edu.magento.tools.ParameterUtils;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import ss.af.reporting.annotations.ServiceReport;

/**
 * Created by Yulia Nevinglovskaya on 8/18/2016.
 */
public class ProductSaveTest extends TestBase {
    private SoftAssert softAssert = new SoftAssert();

    @DataProvider
    public Object[][] parameters(ITestContext context) {
        return ListUtils.get()
                .toMultiArray(ParameterUtils.get()
                                .updateParametersAll(ApplicationSourcesRepository.getChromeLocalhostAdmin(), context),
                        AdminUserRepository.get().adminYulia());
    }

    /**
     * The method tests if a new product is possible to save if obligatory fields are filled in with valid data
     * and 'Save' button is pressed; if entered data are present in the fields; if success save message appears.
     *
     * @param applicationSources
     * @param adminUser
     */
    @Test(dataProvider = "parameters")
    @ServiceReport
    public void checkProductSaved(ApplicationSources applicationSources, IAdminUser adminUser) {
        /* Log in and go to AddProductPage */
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        ProductCatalogPage productCatalogPage = dashboardPage.gotoProductCatalogPage();
        AddProductPage addProductPage = productCatalogPage.gotoAddProductPage();

        /* Get data from Product Repository and set them */
        IProduct product = ProductRepository.get().getNewValidProduct();
        addProductPage.setProductData(product);
        SuccessProductSavePage savePage =
                addProductPage.gotoSuccessProductSavePageAfterSave();

		/* Check if message appeared and data are present in the fields */
        softAssert.assertEquals(savePage.getSuccessfulProductSaveMessageText().trim(), Constants.PRODUCT_SAVED_MESSAGE);
        softAssert.assertEquals(savePage.getAttributeSetInputText(), ProductRepository.ATTRIBUTE_SET);
        softAssert.assertEquals(savePage.getProductNameInputText(), ProductRepository.VALID_PRODUCT_NAME);
        softAssert.assertEquals(savePage.getSkuInputText(), ProductRepository.VALID_SKU);
        softAssert.assertEquals(savePage.getPriceInputText(), ProductRepository.VALID_PRICE);
        softAssert.assertEquals(savePage.getQuantityInputText(), ProductRepository.QUANTITY);

		/* Go to page with catalog and find row with needed name */
        ProductCatalogPage catalogPage = savePage.returnToProductPage();
        int productRowIndex = catalogPage.getRowIndexByName(ProductRepository.VALID_PRODUCT_NAME);
        while (productRowIndex == -1) {
            if (catalogPage.checkNextPageButtonIsEnabled()) {
                catalogPage = catalogPage.moveToNextPage();
                productRowIndex = catalogPage.getRowIndexByName(ProductRepository.VALID_PRODUCT_NAME);
            } else {
                break;
            }
        }

		/* Check if saved product is present in catalog */
        softAssert.assertNotEquals(productRowIndex, -1);
        if (productRowIndex != -1) {
            String attributeSetText = catalogPage.getProductAttributeSetTextByRowIndex(productRowIndex);
            softAssert.assertEquals(attributeSetText, ProductRepository.ATTRIBUTE_SET);
            String skuText = catalogPage.getProductSkuTextByRowIndex(productRowIndex);
            softAssert.assertEquals(skuText, ProductRepository.VALID_SKU);
            String priceText = catalogPage.getProductPriceTextByRowIndex(productRowIndex);
            softAssert.assertEquals(priceText, ProductRepository.VALID_PRICE_FOR_CHECK);
            String quantityText = catalogPage.getProductQuantityTextByRowIndex(productRowIndex);
            softAssert.assertEquals(quantityText, ProductRepository.QUANTITY_FOR_CHECK);
        }
    }

    /**
     * The method tests if a new product is possible to save if obligatory fields are filled in with valid data
     * and 'Save&New' button is pressed; if entered into the fields data are reset; if success save message appears.
     *
     * @param applicationSources
     * @param adminUser
     */
    @Test(dataProvider = "parameters")
    @ServiceReport
    public void checkProductSaveAndNew(ApplicationSources applicationSources, IAdminUser adminUser) {
        /* Log in and go to AddProductPage */
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        ProductCatalogPage productCatalogPage = dashboardPage.gotoProductCatalogPage();
        AddProductPage addProductPage = productCatalogPage.gotoAddProductPage();

        /* Get valid data from Product Repository and set them */
        IProduct product = ProductRepository.get().getNewValidProduct();
        addProductPage.setProductData(product);
        SuccessProductSavePage savePage = addProductPage.gotoSuccessProductSavePageAfterSaveAndNew();

        /* Check if message appeared and fields are reset */
        softAssert.assertEquals(savePage.getSuccessfulProductSaveMessageText().trim(), Constants.PRODUCT_SAVED_MESSAGE);
        softAssert.assertEquals(savePage.getProductNameInputText(), "");
        softAssert.assertEquals(savePage.getSkuInputText(), "");
        softAssert.assertEquals(savePage.getPriceInputText(), "");
        softAssert.assertEquals(savePage.getQuantityInputText(), "");

        /* Find row with newly saved product */
        ProductCatalogPage catalogPage = savePage.returnToProductPage();
        int productRowIndex = catalogPage.getRowIndexByName(ProductRepository.VALID_PRODUCT_NAME);
        while (productRowIndex == -1) {
            if (catalogPage.checkNextPageButtonIsEnabled()) {
                catalogPage = catalogPage.moveToNextPage();
                productRowIndex = catalogPage.getRowIndexByName(ProductRepository.VALID_PRODUCT_NAME);
            } else {
                break;
            }
        }

        /* Check if new product is present in catalog */
        softAssert.assertNotEquals(productRowIndex, -1);
        if (productRowIndex != -1) {
            String skuText = catalogPage.getProductSkuTextByRowIndex(productRowIndex);
            softAssert.assertEquals(skuText, ProductRepository.VALID_SKU);
            String priceText = catalogPage.getProductPriceTextByRowIndex(productRowIndex);
            softAssert.assertEquals(priceText, ProductRepository.VALID_PRICE_FOR_CHECK);
        }
    }

    /**
     * The method tests if a new product is possible to save and duplicate if obligatory fields are filled in
     * with valid data and 'Save&Duplicate' button is pressed; if entered data are present in the fields ;
     * if success save message and success duplicate message appear.
     *
     * @param applicationSources
     * @param adminUser
     */
    @Test(dataProvider = "parameters")
    @ServiceReport
    public void checkProductSaveAndDuplicate(ApplicationSources applicationSources, IAdminUser adminUser) {
        /* Log in and go to AddProductPage */
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        ProductCatalogPage productCatalogPage = dashboardPage.gotoProductCatalogPage();
        AddProductPage addProductPage = productCatalogPage.gotoAddProductPage();

        /* Get valid data from Product Repository and set them */
        IProduct product = ProductRepository.get().getNewValidProduct();
        addProductPage.setProductData(product);
        SuccessProductSaveAndDuplicatePage savePage = addProductPage.gotoSuccessProductSaveAndDuplicatePage();

        /* Check if messages appeared and data are present in the fields */
        softAssert.assertEquals(savePage.getSuccessfulProductSaveMessageText().trim(), Constants.PRODUCT_SAVED_MESSAGE);
        softAssert.assertEquals(savePage.getSuccessfulProductDuplicateMessageText().trim(), Constants.PRODUCT_DUPLICATED_MESSAGE);
        softAssert.assertEquals(savePage.getProductNameInputText(), ProductRepository.VALID_PRODUCT_NAME);
        softAssert.assertEquals(savePage.getSkuInputText(), ProductRepository.VALID_SKU_DUPLICATED);
        softAssert.assertEquals(savePage.getPriceInputText(), ProductRepository.VALID_PRICE);
        softAssert.assertEquals(savePage.getQuantityInputText(), "");

        /* Find row with newly saved product */
        ProductCatalogPage catalogPage = savePage.returnToProductPage();
        int productRowIndex1 = catalogPage.getRowIndexBySku(ProductRepository.VALID_SKU);
        while (productRowIndex1 == -1) {
            if (catalogPage.checkNextPageButtonIsEnabled()) {
                catalogPage = catalogPage.moveToNextPage();
                productRowIndex1 = catalogPage.getRowIndexBySku(ProductRepository.VALID_SKU);
            } else {
                break;
            }
        }

        /* Check if new product is present in catalog */
        softAssert.assertNotEquals(productRowIndex1, -1);
        if (productRowIndex1 != -1) {
            String skuText = catalogPage.getProductSkuTextByRowIndex(productRowIndex1);
            softAssert.assertEquals(skuText, ProductRepository.VALID_SKU);
            String priceText = catalogPage.getProductPriceTextByRowIndex(productRowIndex1);
            softAssert.assertEquals(priceText, ProductRepository.VALID_PRICE_FOR_CHECK);
            String quantityText = catalogPage.getProductQuantityTextByRowIndex(productRowIndex1);
            softAssert.assertEquals(quantityText, ProductRepository.QUANTITY_FOR_CHECK);
        }

        /* Find row with duplicated product */
        int productRowIndex2 = catalogPage.getRowIndexBySku(ProductRepository.VALID_SKU_DUPLICATED);
        while (productRowIndex2 == -1) {
            if (catalogPage.checkNextPageButtonIsEnabled()) {
                catalogPage = catalogPage.moveToNextPage();
                productRowIndex2 = catalogPage.getRowIndexBySku(ProductRepository.VALID_SKU);
            } else {
                break;
            }
        }

        /* Check if duplicated product is present in catalog */
        softAssert.assertNotEquals(productRowIndex2, -1);
        if (productRowIndex2 != -1) {
            String skuText = catalogPage.getProductSkuTextByRowIndex(productRowIndex2);
            softAssert.assertEquals(skuText, ProductRepository.VALID_SKU_DUPLICATED);
            String priceText = catalogPage.getProductPriceTextByRowIndex(productRowIndex2);
            softAssert.assertEquals(priceText, ProductRepository.VALID_PRICE_FOR_CHECK);
            String quantityText = catalogPage.getProductQuantityTextByRowIndex(productRowIndex2);
            softAssert.assertEquals(quantityText, "");
        }
    }

    /**
     * The method tests if a new product is possible to save if obligatory fields are filled in with valid data
     * and 'Save&Close' button is pressed; if success save message appears; if it goes to catalog page.
     *
     * @param applicationSources
     * @param adminUser
     */
    @Test(dataProvider = "parameters")
    @ServiceReport
    public void checkProductSaveAndClose(ApplicationSources applicationSources, IAdminUser adminUser) {
        /* Log in and go to AddProductPage */
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
        ProductCatalogPage productCatalogPage = dashboardPage.gotoProductCatalogPage();
        AddProductPage addProductPage = productCatalogPage.gotoAddProductPage();

        /* Get valid data from Product Repository and set them */
        IProduct product = ProductRepository.get().getNewValidProduct();
        addProductPage.setProductData(product);
        ProductCatalogPage catalogPage = addProductPage.gotoCatalogPageAfterSaveClose();

        /* Check if it went to Catalog page */
        softAssert.assertEquals(catalogPage.getPageTitleText(), Constants.CATALOG_PAGE_TITLE);

        /* Find row with newly saved product */
        int productRowIndex = catalogPage.getRowIndexByName(ProductRepository.VALID_PRODUCT_NAME);
        while (productRowIndex == -1) {
            if (catalogPage.checkNextPageButtonIsEnabled()) {
                catalogPage = catalogPage.moveToNextPage();
                productRowIndex = catalogPage.getRowIndexByName(ProductRepository.VALID_PRODUCT_NAME);
            } else {
                break;
            }
        }

        /* Check if new product is present in catalog */
        softAssert.assertNotEquals(productRowIndex, -1);
        if (productRowIndex != -1) {
            String skuText = catalogPage.getProductSkuTextByRowIndex(productRowIndex);
            softAssert.assertEquals(skuText, ProductRepository.VALID_SKU);
            String priceText = catalogPage.getProductPriceTextByRowIndex(productRowIndex);
            softAssert.assertEquals(priceText, ProductRepository.VALID_PRICE_FOR_CHECK);
        }
    }


    @AfterMethod
    public void afterMethod() {
        boolean productDeleted;
        do{
            productDeleted = false;
            ProductCatalogPage catalogPage = ProductCatalogPage.createProductCatalogPageInstance();
            catalogPage.gotoProductCatalogPage();
            int productRowIndex = catalogPage.getRowIndexByName(ProductRepository.VALID_PRODUCT_NAME);
            while (productRowIndex == -1) {
                if (catalogPage.checkNextPageButtonIsEnabled()) {
                    catalogPage = catalogPage.moveToNextPage();
                    productRowIndex = catalogPage.getRowIndexByName(ProductRepository.VALID_PRODUCT_NAME);
                } else {
                    break;
                }
            }
            if(productRowIndex != -1){
                catalogPage.selectProductByIndex(productRowIndex);
                ActionsWithProductsPage.DeleteConfirmationPopup popup = catalogPage.clickActionsDropdown().clickDeleteProductButton();
                popup.clickDeleteConfirmationButton();
                productDeleted = true;
            }
        }while(productDeleted);
        ApplicationAdmin.signout();
    }

    @AfterClass
    void tearDown() throws Exception {
        ApplicationAdmin.quitAll();
        softAssert.assertAll();
    }

}

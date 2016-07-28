
package com.softserve.edu.magento.pages.admin.menu.dashboard;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.softserve.edu.magento.data.admin.dashboard.SearchFromRecords;
import com.softserve.edu.magento.pages.admin.ApplicationAdmin;
import com.softserve.edu.magento.pages.admin.VerticalMenu;

public class DashboardPage extends VerticalMenu {
	
	private class StoreViewComponent{
		public final WebElement allStoreViews;
		public final WebElement	mainWebsite;
		public final WebElement	mainWebsiteStore;
		public final WebElement	defaultStoreView;
		public StoreViewComponent(){
			this.allStoreViews = driver.findElement(By
					.cssSelector(".store-switcher-all"));
			this.mainWebsite = driver.findElement(By
					.cssSelector(".store-switcher-website"));
			this.mainWebsiteStore = driver.findElement(By
					.cssSelector(".store-switcher-store"));
			this.defaultStoreView = driver.findElement(By
					.cssSelector(".store-switcher-store-view"));
		}
		
	}
    
    
    // Fields
    public final static String PAGE_TITLE = "Dashboard";
    public final static String HREF_ATTRIBUTE = "href";
    public final static String CUSTOMERS_LOCATOR = "td.col-customer";
    public final static String ITEMS_LOCATOR = "td.col-items.col-number";
    public final static String TOTAL_LOCATOR = "td.col-total.a-right.last";
    public final static String SEARCH_TERMS_LOCATOR = "td.col-search-query.col-search_query";
    public final static String RESULTS_LOCATOR = "td.col-num_results.col-number";
    public final static String USES_LOCATOR = "td.col-popularity.col-number.last";
    public final static String RELOAD_MESSAGE = "We updated lifetime statistic.";
    //
    
   
    // Elements
    private WebElement storeView;
    private WebElement lifeTimeSales;
    private WebElement lifeTimeSalesValue;
    private WebElement averageOrder;
    private WebElement averageOrderValue;
    private WebElement lastOrders;
    private List<WebElement> lastOrdersRecords;
    private WebElement lastSearchTerms;
    private List<WebElement> lastSearchTermsRecords;
    private WebElement topSearchTerms;
    private List<WebElement> topSearchTermsRecords;
    private WebElement revenue;
    private WebElement revenueValue;
    private WebElement tax;
    private WebElement taxValue;
    private WebElement shipping;
    private WebElement shippingValue;
    private WebElement quantity;
    private WebElement quantityValue;
    private WebElement reloadData;
    private WebElement bestsellersTab;
    private List<WebElement> bestsellersRecords;
    private WebElement mostViewedProductsTab;
    private List<WebElement> mostViewedProductsRecords;
    private WebElement newCustomersTab;
    private List<WebElement> newCustomersRecords;
    private WebElement customersTab;
    private List<WebElement> customersRecords;
    private WebElement ordersTab;
    private WebElement amountTab;
    private Select ordersPeriod;
    private Select amountPeriod;
    private WebElement reloadMessage;
    
    //Components
    private StoreViewComponent storeViewMenu;

    
    public DashboardPage(WebDriver driver) {
        super(driver);
        System.out.println("\tConstructor DashboardPage(WebDriver driver) Start");
        this.storeView = driver.findElement(By.id("store-change-button"));
        this.lifeTimeSales = driver.findElement(By
        		.xpath("//div[contains(text(),'Lifetime Sales')]"));
        this.lifeTimeSalesValue = driver.findElement(By
        		.xpath("//div[contains(text(),'Lifetime Sales')]/following-sibling::div//span[@class='price']"));
        System.out.println("\tConstructor DashboardPage(WebDriver driver) Start01");
        this.averageOrder = driver.findElement(By
        		.xpath("//div[contains(text(),'Average Order')]"));
        this.averageOrderValue = driver.findElement(By
        		.xpath("//div[contains(text(),'Average Order')]/following-sibling::div//span[@class='price']"));
        this.lastOrders = driver.findElement(By
        		.xpath("//div[contains(text(),'Last Orders')]"));
        System.out.println("\tConstructor DashboardPage(WebDriver driver) Start02");
        this.lastOrdersRecords = driver.findElements(By
        		.cssSelector("#lastOrdersGrid_table tbody tr"));
        this.lastSearchTerms = driver.findElement(By
        		.xpath("//div[contains(text(),'Last Search Terms')]"));
        this.lastSearchTermsRecords = driver.findElements(By
        		.cssSelector("#lastSearchGrid_table tbody tr"));
        this.topSearchTerms = driver.findElement(By
        		.xpath("//div[contains(text(),'Top Search Terms')]"));
        this.topSearchTermsRecords = driver.findElements(By
        		.cssSelector("#topSearchGrid_table tbody tr"));
        this.revenue = driver.findElement(By.
        		xpath("//span[contains(text(),'Revenue')]"));
        System.out.println("\tConstructor DashboardPage(WebDriver driver) Start03");
        this.revenueValue = driver.findElement(By.
        		xpath("//span[contains(text(),'Revenue')]/following-sibling::strong//span[@class='price']"));
        this.tax = driver.findElement(By.
        		xpath("//span[contains(text(),'Tax')]"));
        this.taxValue = driver.findElement(By.
        		xpath("//span[contains(text(),'Tax')]/following-sibling::strong//span[@class='price']"));
        this.shipping = driver.findElement(By.
        		xpath("//span[contains(text(),'Shipping')]"));
        this.shippingValue = driver.findElement(By.
        		xpath("//span[contains(text(),'Shipping')]/following-sibling::strong//span[@class='price']"));
        System.out.println("\tConstructor DashboardPage(WebDriver driver) Start04");
        this.quantity = driver.findElement(By.
        		xpath("//span[contains(text(),'Quantity')]"));
        this.quantityValue = driver.findElement(By.
        		xpath("//span[contains(text(),'Quantity')]/following-sibling::strong[@class='dashboard-totals-value']"));
        this.reloadData = driver.findElement(By.
        		cssSelector("button.action-primary"));
        this.bestsellersTab = driver.findElement(By.
        		id("grid_tab_ordered_products"));
        this.bestsellersRecords = driver.findElements(By
        		.cssSelector("#productsOrderedGrid_table tbody tr"));
        this.mostViewedProductsTab = driver.findElement(By.
        		id("grid_tab_reviewed_products"));
        System.out.println("\tConstructor DashboardPage(WebDriver driver) Start05");
        this.newCustomersTab = driver.findElement(By.
        		id("grid_tab_new_customers"));
        this.customersTab = driver.findElement(By.
        		id("grid_tab_customers"));
        this.ordersTab = driver.findElement(By.
        		id("diagram_tab_orders"));
        this.amountTab = driver.findElement(By.
        		id("diagram_tab_amounts"));
        this.ordersPeriod = new Select(driver.findElement(By.
        		id("order_orders_period")));
        this.amountPeriod = new Select(driver.findElement(By.
        		id("order_amounts_period")));
        //
        System.out.println("\tConstructor DashboardPage(WebDriver driver) Start06");
        saveLogoutUrl();
        System.out.println("\tConstructor DashboardPage(WebDriver driver) DONE");
    }
    private void saveLogoutUrl() {
        System.out.println("\t    saveLogoutUrl() Start");
        if ((ApplicationAdmin.getCurrentApplicationSources() != null) 
                && ((ApplicationAdmin.getCurrentApplicationSources().getLogoutUrl() == null)
                        || (ApplicationAdmin.getCurrentApplicationSources().getLogoutUrl().isEmpty()))) {
            System.out.println("\t    saveLogoutUrl() Start if ...");
            ApplicationAdmin.getCurrentApplicationSources()
                .setLogoutUrl(getSignOut().getAttribute(HREF_ATTRIBUTE));
            System.out.println("\t    saveLogoutUrl() setLogoutUrl DONE");
            getPageTitle().click();
            System.out.println("\t    saveLogoutUrl() getPageTitle().click() DONE");
        }
    }
    
    // Page Object
    // Get Data PageObject
    
	public WebElement getStoreView() {
		return this.storeView;
	}
	public WebElement getAllStoreViews() {
		clickStoreView();
		return this.storeViewMenu.allStoreViews;
	}
	public WebElement getMainWebsite() {
		clickStoreView();
		return this.storeViewMenu.mainWebsite;
	}
	public WebElement getMainWebsiteStore() {
		clickStoreView();
		return this.storeViewMenu.mainWebsiteStore;
	}
	public WebElement getDefaultStoreView() {
		clickStoreView();
		return this.storeViewMenu.defaultStoreView;
	}
	public WebElement getLifeTimeSales() {
		return this.lifeTimeSales;
	}

	public WebElement getLifeTimeSalesValue() {
		return this.lifeTimeSalesValue;
	}

	public WebElement getAverageOrder() {
		return this.averageOrder;
	}

	public WebElement getAverageOrderValue() {
		return this.averageOrderValue;
	}

	public WebElement getLastOrders() {
		return this.lastOrders;
	}

	public List<WebElement> getLastOrdersRecords() {
		return this.lastOrdersRecords;
	}

	public WebElement getLastSearchTerms() {
		return this.lastSearchTerms;
	}

	public List<WebElement> getLastSearchTermsRecords() {
		return this.lastSearchTermsRecords;
	}

	public WebElement getTopSearchTerms() {
		return this.topSearchTerms;
	}

	public List<WebElement> getTopSearchTermsRecords() {
		return this.topSearchTermsRecords;
	}

	public WebElement getRevenue() {
		return this.revenue;
	}

	public WebElement getRevenueValue() {
		return this.revenueValue;
	}

	public WebElement getTax() {
		return this.tax;
	}

	public WebElement getTaxValue() {
		return this.taxValue;
	}

	public WebElement getShipping() {
		return this.shipping;
	}

	public WebElement getShippingValue() {
		return this.shippingValue;
	}

	public WebElement getQuantity() {
		return this.quantity;
	}

	public WebElement getQuantityValue() {
		return this.quantityValue;
	}

	public WebElement getReloadData() {
		return this.reloadData;
	}

	public WebElement getBestsellersTab() {
		return this.bestsellersTab;
	}

	public WebElement getMostViewedProductsTab() {
		return this.mostViewedProductsTab;
	}

	public WebElement getNewCustomersTab() {
		return this.newCustomersTab;
	}

	public WebElement getCustomersTab() {
		return this.customersTab;
	}

	public WebElement getOrdersTab() {
		return this.ordersTab;
	}

	public WebElement getAmountTab() {
		return this.amountTab;
	}

	public Select getOrdersPeriod() {
		return this.ordersPeriod;
	}

	public Select getAmountPeriod() {
		return this.amountPeriod;
	}

	public WebElement getReloadMessage() {
		DashboardPage page = refreshPage();
		return page.reloadMessage;
	}
   
	public List<WebElement> getBestsellersRecords() {
		clickBestsellersTab();
		return bestsellersRecords;
	}

	public List<WebElement> getMostViewedProductsRecords() {
		clickMostViewedProductsTab();
		return mostViewedProductsRecords;
	}

	public List<WebElement> getNewCustomersRecords() {
		clickNewCustomersTab();
		return newCustomersRecords;
	}

	public List<WebElement> getCustomersRecords() {
		clickCustomersTab();
		return customersRecords;
	}
	
	
	// get Data Business Logic
	
	
	public String getLifeTimeSalesValueText() {
		return getLifeTimeSalesValue().getText();
	}

	public String getAverageOrderValueText() {
		return getAverageOrderValue().getText();
	}

	public String getRevenueValueText() {
		return getRevenueValue().getText();
	}

	public String getTaxValueText() {
		return getTaxValue().getText();
	}

	public String getShippingValueText() {
		return getShippingValue().getText();
	}

	public String getQuantityValueText() {
		return getQuantityValue().getText();
	}
    
	public String getReloadMessageText() {
		return getReloadMessage().getText();
	}
	
    public List<String> getCustomersFromLastOrdersRecords(){
    	return SearchFromRecords.
    			getElementsText(SearchFromRecords.
    					getElements(getLastOrdersRecords(), CUSTOMERS_LOCATOR));
    }
    public List<String> getItemsFromLastOrdersRecords(){
    	return SearchFromRecords.
    			getElementsText(SearchFromRecords.
    					getElements(getLastOrdersRecords(), ITEMS_LOCATOR));
    }
    public List<String> getTotalFromLastOrdersRecords(){
    	return SearchFromRecords.
    			getElementsText(SearchFromRecords.
    					getElements(getLastOrdersRecords(), TOTAL_LOCATOR));
    }
    public List<String> getSearchTermsFromLastSearchTermsRecords(){
    	return SearchFromRecords.
    			getElementsText(SearchFromRecords.
    					getElements(getLastSearchTermsRecords(), SEARCH_TERMS_LOCATOR));
    }
    public List<String> getResultsFromLastSearchTermsRecords(){
    	return SearchFromRecords.
    			getElementsText(SearchFromRecords.
    					getElements(getLastSearchTermsRecords(), RESULTS_LOCATOR));
    }
    public List<String> getUsesFromLastSearchTermsRecords(){
    	return SearchFromRecords.
    			getElementsText(SearchFromRecords.
    					getElements(getLastSearchTermsRecords(), USES_LOCATOR));
    }
    public List<String> getSearchTermsFromTopSearchTermsRecords(){
    	return SearchFromRecords.
    			getElementsText(SearchFromRecords.
    					getElements(getTopSearchTermsRecords(), SEARCH_TERMS_LOCATOR));
    }
    public List<String> getResultsFromTopSearchTermsRecords(){
    	return SearchFromRecords.
    			getElementsText(SearchFromRecords.
    					getElements(getTopSearchTermsRecords(), RESULTS_LOCATOR));
    }
    public List<String> getUsesFromTopSearchTermsRecords(){
    	return SearchFromRecords.
    			getElementsText(SearchFromRecords.
    					getElements(getTopSearchTermsRecords(), USES_LOCATOR));
    }
    // set Data PageObject
    
	public void clickStoreView() {
		getStoreView().click();
		this.storeViewMenu = new StoreViewComponent();
	}
	
	public void clickOrdersTab() {
		getOrdersTab().click();
	}

	public void clickAmountTab() {
		getAmountTab().click();
	}

	public void clickBestsellersTab() {
		getBestsellersTab().click();
		this.bestsellersRecords = driver.findElements(By
				.cssSelector("#productsOrderedGrid_table tbody tr"));
		this.mostViewedProductsRecords = null;
		this.newCustomersRecords = null;
		this.customersRecords = null;
	}

	public void clickMostViewedProductsTab() {
		getMostViewedProductsTab().click();
		this.bestsellersRecords = null;
		this.mostViewedProductsRecords = driver.findElements(By
				.cssSelector("#productsReviewedGrid_table tbody tr"));
		this.newCustomersRecords = null;
		this.customersRecords = null;

	}

	public void clickNewCustomersTab() {
		getNewCustomersTab().click();
		this.bestsellersRecords = null;
		this.mostViewedProductsRecords = null;
		this.newCustomersRecords = driver.findElements(By
				.cssSelector("#customersNewestGrid_table tbody tr"));
		this.customersRecords = null;
	}

	public void clickCustomersTab() {
		getCustomersTab().click();
		this.bestsellersRecords = null;
		this.mostViewedProductsRecords = null;
		this.newCustomersRecords = null;
		this.customersRecords = driver.findElements(By
				.cssSelector("#customersMostGrid_table tbody tr"));
	}

	public void clickReloadData() {
		getReloadData().click();
	}
	
	//  Business Logic
	public DashboardPage refreshPage() {
		clickReloadData();
		DashboardPage page = new DashboardPage(driver);
		page.reloadMessage = driver.findElement(By
				.cssSelector(".message.message-success.success"));
		return page;
	}
}


package com.softserve.edu.magento.pages.admin;

import com.softserve.edu.magento.pages.admin.menu.sales.OrdersPage;
import org.openqa.selenium.WebElement;

import com.softserve.edu.magento.pages.admin.menu.customers.AllCustomersPage;
import com.softserve.edu.magento.pages.admin.menu.dashboard.DashboardPage;
import com.softserve.edu.magento.pages.admin.menu.products.ProductCatalogPage;
import com.softserve.edu.magento.pages.admin.menu.products.categories.CategoriesPage;
import com.softserve.edu.magento.tools.Search;
import org.openqa.selenium.internal.seleniumemulation.WaitForPageToLoad;
import ss.af.reporting.annotations.ServiceReport;

public abstract class VerticalMenu extends ATopPage {

	// ----------------------------

	private class SalesComponent {
		public final WebElement title;
		public final WebElement groupTitle;
		public final WebElement orders;
		public final WebElement invoices;
		public final WebElement shipments;
		public final WebElement creditMemos;
		public final WebElement billingAgreements;
		public final WebElement transactions;
		public final WebElement close;

		public SalesComponent() {
			this.title = Search.xpath("//strong[text()='Sales']");
			this.groupTitle = Search.xpath("//span[text()='Operations']");
			this.orders = Search.cssSelector("li.item-sales-order.level-2");
			this.invoices = Search.linkText("Invoices");
			this.shipments = Search.linkText("Shipments");
			this.creditMemos = Search.linkText("Credit Memos");
			this.billingAgreements = Search.linkText("Billing Agreements");
			this.transactions = Search.linkText("Transactions");
			this.close = Search.cssSelector("#menu-magento-sales-sales > div > a");
		}

	}

	// ----------------------------

	private class ProductsComponent {
		public final WebElement title;
		public final WebElement groupTitle;
		public final WebElement catalog;
		public final WebElement categories;
		public final WebElement close;

		public ProductsComponent() {
			this.title = Search.xpath("//strong[text()='Products']");
			this.groupTitle = Search.xpath("//span[text()='Inventory']");
			this.catalog = Search.linkText("Catalog");
			this.categories = Search.linkText("Categories");
			this.close = Search.cssSelector("#menu-magento-catalog-catalog > div > a");
		}

	}

	// ----------------------------

	private class CustomersComponent {
		public final WebElement title;
		public final WebElement allCustomers;
		public final WebElement nowOnline;
		public final WebElement close;

		public CustomersComponent() {
			this.title = Search.xpath("//strong[text()='Customers']");
			this.allCustomers = Search.linkText("All Customers");
			this.nowOnline = Search.linkText("Now Online");
			this.close = Search.cssSelector("#menu-magento-customer-customer > div > a");
		}

	}

	// ----------------------------

	private class MarketingComponent {
		public final WebElement title;
		public final WebElement groupTitlePromotions;
		public final WebElement groupTitleCommunications;
		public final WebElement groupTitleSEOAndSearch;
		public final WebElement groupTitleUserContent;
		public final WebElement catalogPriceRule;
		public final WebElement cartPriceRules;
		public final WebElement emailTemplates;
		public final WebElement newsletterTemplate;
		public final WebElement newsletterQueue;
		public final WebElement newsletterSubscribers;
		public final WebElement URLRewrites;
		public final WebElement searchTerms;
		public final WebElement searchSynonyms;
		public final WebElement siteMap;
		public final WebElement reviews;
		public final WebElement close;

		public MarketingComponent() {
			this.title = Search.xpath("//strong[text()='Marketing']");
			this.groupTitlePromotions = Search.xpath("//strong[text()='Promotions']");
			this.groupTitleCommunications = Search.xpath("//span[text()='Communications']");
			this.groupTitleSEOAndSearch = Search.xpath("//span[text()='SEO & SearchRecords']");
			this.groupTitleUserContent = Search.xpath("//span[text()='User Content']");
			this.catalogPriceRule = Search.linkText("Catalog Price Rule");
			this.cartPriceRules = Search.linkText("Cart Price Rules");
			this.emailTemplates = Search.linkText("Email Templates");
			this.newsletterTemplate = Search.linkText("Newsletter Template");
			this.newsletterQueue = Search.linkText("Newsletter Queue");
			this.newsletterSubscribers = Search.linkText("Newsletter Subscribers");
			this.URLRewrites = Search.linkText("URL Rewrites");
			this.searchTerms = Search.linkText("SearchRecords Terms");
			this.searchSynonyms = Search.linkText("SearchRecords Synonyms");
			this.siteMap = Search.linkText("Site Map");
			this.reviews = Search.linkText("Reviews");
			this.close = Search.cssSelector("#menu-magento-backend-marketing > div > a");

		}

	}

	// ----------------------------

	private class ContentComponent {
		public final WebElement title;
		public final WebElement groupTitleElements;
		public final WebElement groupTitleDesign;
		public final WebElement pages;
		public final WebElement blocks;
		public final WebElement widgets;
		public final WebElement configuration;
		public final WebElement themes;
		public final WebElement schedule;
		public final WebElement close;

		public ContentComponent() {
			this.title = Search.xpath("//strong[text()='Content']");
			this.groupTitleElements = Search.xpath("//strong[text()='Elements']");
			this.groupTitleDesign = Search.xpath("//span[text()='Design']");
			this.pages = Search.linkText("Pages");
			this.blocks = Search.linkText("Blocks");
			this.widgets = Search.linkText("Widgets");
			this.configuration = Search.linkText("Configuration");
			this.themes = Search.linkText("Themes");
			this.schedule = Search.linkText("Schedule");
			this.close = Search.cssSelector("#menu-magento-backend-content > div > a");
		}

	}

	// ----------------------------

	private class ReportsComponent {

		public final WebElement title;
		public final WebElement groupTitleMarketing;
		public final WebElement groupTitleSales;
		public final WebElement groupTitleReviews;
		public final WebElement groupTitleCustomers;
		public final WebElement groupTitleProducts;
		public final WebElement groupTitleStatistics;
		public final WebElement productsInCart;
		public final WebElement searchTerms;
		public final WebElement abandonedCarts;
		public final WebElement newsletterProblemReports;
		public final WebElement byCustomers;
		public final WebElement byProducts;
		public final WebElement orders;
		public final WebElement tax;
		public final WebElement invoiced;
		public final WebElement shipping;
		public final WebElement refunds;
		public final WebElement coupons;
		public final WebElement payPalSettlement;
		public final WebElement braintreeSettlement;
		public final WebElement orderTotal;
		public final WebElement orderCount;
		public final WebElement newOne;
		public final WebElement views;
		public final WebElement bestsellers;
		public final WebElement lowStock;
		public final WebElement ordered;
		public final WebElement downloads;
		public final WebElement refreshStatistics;
		public final WebElement close;

		public ReportsComponent() {
			this.title = Search.xpath("//strong[text()='Reports']");
			this.groupTitleMarketing = Search.xpath("//strong[text()='Marketing']");
			this.groupTitleSales = Search.xpath("//span[text()='Sales']");
			this.groupTitleReviews = Search.xpath("//strong[text()='Reviews']");
			this.groupTitleCustomers = Search.xpath("//span[text()='Customers']");
			this.groupTitleProducts = Search.xpath("//strong[text()='Products']");
			this.groupTitleStatistics = Search.xpath("//span[text()='Statistics']");
			this.productsInCart = Search.linkText("Products in Cart");
			this.searchTerms = Search.linkText("SearchRecords Terms");
			this.abandonedCarts = Search.linkText("Abandoned Carts");
			this.newsletterProblemReports = Search.linkText("Newsletter Problem Reports");
			this.byCustomers = Search.linkText("By Customers");
			this.byProducts = Search.linkText("By Products");
			this.orders = Search.linkText("Orders");
			this.tax = Search.linkText("Pages");
			this.invoiced = Search.linkText("Invoiced");
			this.shipping = Search.linkText("Shipping");
			this.refunds = Search.linkText("Refunds");
			this.coupons = Search.linkText("Coupons");
			this.payPalSettlement = Search.linkText("PayPal Settlement");
			this.braintreeSettlement = Search.linkText("Braintree Settlement");
			this.orderTotal = Search.linkText("Order Total");
			this.orderCount = Search.linkText("Order Count");
			this.newOne = Search.linkText("New");
			this.views = Search.linkText("Views");
			this.bestsellers = Search.linkText("Pages");
			this.lowStock = Search.linkText("Low Stock");
			this.ordered = Search.linkText("Ordered");
			this.downloads = Search.linkText("Downloads");
			this.refreshStatistics = Search.linkText("Refresh Statistics");
			this.close = Search.cssSelector("#menu-magento-reports-report > div > a");
		}

	}

	// ----------------------------

	private class StoresComponent {
		public final WebElement title;
		public final WebElement groupTitleSettings;
		public final WebElement groupTitleAttributes;
		public final WebElement groupTitleTaxes;
		public final WebElement groupTitleCurrency;
		public final WebElement groupTitleOtherSettings;
		public final WebElement allStores;
		public final WebElement configuration;
		public final WebElement termsAndConditions;
		public final WebElement orderStatus;
		public final WebElement taxRules;
		public final WebElement taxZonesAndRates;
		public final WebElement currencyRates;
		public final WebElement currencySymbols;
		public final WebElement product;
		public final WebElement attributeSet;
		public final WebElement rating;
		public final WebElement customerGroups;
		public final WebElement close;

		public StoresComponent() {
			this.title = Search.xpath("//strong[text()='Reports']");
			this.groupTitleSettings = Search.xpath("//strong[text()='Settings']");
			this.groupTitleAttributes = Search.xpath("//span[text()='Attributes']");
			this.groupTitleTaxes = Search.xpath("//strong[text()='Taxes']");
			this.groupTitleCurrency = Search.xpath("//span[text()='Currency']");
			this.groupTitleOtherSettings = Search.xpath("//strong[text()='Other Settings']");
			this.allStores = Search.linkText("All Stores");
			this.configuration = Search.linkText("Configuration");
			this.termsAndConditions = Search.linkText("Terms and Conditions");
			this.orderStatus = Search.linkText("Order Status");
			this.taxRules = Search.linkText("Tax Rules");
			this.taxZonesAndRates = Search.linkText("Tax Zones and Rates");
			this.currencyRates = Search.linkText("Currency Rates");
			this.currencySymbols = Search.linkText("Currency Symbols");
			this.product = Search.linkText("Product");
			this.attributeSet = Search.linkText("Attribute Set");
			this.rating = Search.linkText("Rating");
			this.customerGroups = Search.linkText("Customer Groups");
			this.close = Search.cssSelector("#menu-magento-backend-stores > div > a");
		}

	}

	// ----------------------------

	private class SystemComponent {
		public final WebElement title;
		public final WebElement groupTitleDataTransfer;
		public final WebElement groupTitleExtensions;
		public final WebElement groupTitleTools;
		public final WebElement groupTitlePermissions;
		public final WebElement groupTitleOtherSettings;
		public final WebElement importOne;
		public final WebElement export;
		public final WebElement importExportTaxRates;
		public final WebElement importHistory;
		public final WebElement integrations;
		public final WebElement cacheManagement;
		public final WebElement backups;
		public final WebElement indexManagement;
		public final WebElement webSetupWizard;
		public final WebElement allUsers;
		public final WebElement lockedUsers;
		public final WebElement userRoles;
		public final WebElement notifications;
		public final WebElement customVariables;
		public final WebElement manageEncryptionKey;
		public final WebElement close;

		public SystemComponent() {
			this.title = Search.xpath("//strong[text()='System']");
			this.groupTitleDataTransfer = Search.xpath("//strong[text()='Data Transfer']");
			this.groupTitleExtensions = Search.xpath("//span[text()='Extensions']");
			this.groupTitleTools = Search.xpath("//strong[text()='Tools']");
			this.groupTitlePermissions = Search.xpath("//span[text()='Permissions']");
			this.groupTitleOtherSettings = Search.xpath("//strong[text()='Other Settings']");
			this.importOne = Search.linkText("Import");
			this.export = Search.linkText("Export");
			this.importExportTaxRates = Search.linkText("Import/Export Tax Rates");
			this.importHistory = Search.linkText("Import History");
			this.integrations = Search.linkText("Integrations");
			this.cacheManagement = Search.linkText("Cache Management");
			this.backups = Search.linkText("Backups");
			this.indexManagement = Search.linkText("Index Management");
			this.webSetupWizard = Search.linkText("Web Setup Wizard");
			this.allUsers = Search.linkText("All Users");
			this.lockedUsers = Search.linkText("Locked Users");
			this.userRoles = Search.linkText("User Roles");
			this.notifications = Search.linkText("Notifications");
			this.customVariables = Search.linkText("Custom Variables");
			this.manageEncryptionKey = Search.linkText("Manage Encryption Key");
			this.close = Search.cssSelector("#menu-magento-backend-system > div > a");
		}

	}

	// ----------------------------

	// Elements

	private WebElement logo;
	private WebElement dashboard;
	private WebElement sales;
	private WebElement products;
	private WebElement customers;
	private WebElement marketing;
	private WebElement content;
	private WebElement reports;
	private WebElement stores;
	private WebElement system;
	private WebElement findPartners;

	// Components

	private SalesComponent salesMenu;
	private ProductsComponent productsMenu;
	private CustomersComponent customersMenu;
	private MarketingComponent marketingMenu;
	private ContentComponent contentMenu;
	private ReportsComponent reportsMenu;
	private StoresComponent storesMenu;
	private SystemComponent systemMenu;

	protected VerticalMenu() {
		this.logo = Search.cssSelector(".logo-img");
		this.dashboard = Search.xpath("//*[@id='menu-magento-backend-dashboard']/a");
		this.sales = Search.xpath("//*[@id='menu-magento-sales-sales']/a");
		this.products = Search.xpath("//*[@id='menu-magento-catalog-catalog']/a");
		this.customers = Search.xpath("//*[@id='menu-magento-customer-customer']/a");
		this.marketing = Search.xpath("//*[@id='menu-magento-backend-marketing']/a");
		this.content = Search.xpath("//*[@id='menu-magento-backend-content']/a");
		this.reports = Search.xpath("//*[@id='menu-magento-reports-report']/a");
		this.stores = Search.xpath("//*[@id='menu-magento-backend-stores']/a");
		this.system = Search.xpath("//*[@id='menu-magento-backend-system']/a");
		this.findPartners = Search.xpath("//*[@id='menu-magento-marketplace-partners']/a");

	}

	// Page Object
	// Get Data PageObject

	public WebElement getLogo() {
		return this.logo;
	}

	public WebElement getMenuDashboard() {
		return this.dashboard;
	}

	public WebElement getMenuSales() {
		return this.sales;
	}

	public WebElement getMenuProducts() {
		return this.products;
	}

	public WebElement getMenuCustomers() {
		return this.customers;
	}

	public WebElement getMenuMarketing() {
		return this.marketing;
	}

	public WebElement getMenuContent() {
		return this.content;
	}

	public WebElement getMenuReports() {
		return this.reports;
	}

	public WebElement getMenuStores() {
		return this.stores;
	}

	public WebElement getMenuSystem() {
		return this.system;
	}

	public WebElement getMenuFindPartners() {
		return this.findPartners;
	}

	// -----------------Sales---------------

	public WebElement getMenuSalesTitle() {
		clickMenuSales();
		return this.salesMenu.title;
	}

	public WebElement getMenuSalesGroupTitle() {
		clickMenuSales();
		return this.salesMenu.groupTitle;
	}

	public WebElement getMenuSalesOrders() {
		clickMenuSales();
		return this.salesMenu.orders;
	}

	public WebElement getMenuSalesInvoices() {
		clickMenuSales();
		return this.salesMenu.invoices;
	}

	public WebElement getMenuSalesShipments() {
		clickMenuSales();
		return this.salesMenu.shipments;
	}

	public WebElement getMenuSalesCreditMemos() {
		clickMenuSales();
		return this.salesMenu.creditMemos;
	}

	public WebElement getMenuSalesBillingAgreements() {
		clickMenuSales();
		return this.salesMenu.billingAgreements;
	}

	public WebElement getMenuSalesTransactions() {
		clickMenuSales();
		return this.salesMenu.transactions;
	}

	public WebElement getMenuSalesClose() {
		clickMenuSales();
		return this.salesMenu.close;
	}

	// -----------------Products---------------

	public WebElement getMenuProductsTitle() {
		clickMenuProducts();
		return this.productsMenu.title;
	}

	public WebElement getMenuProductsGroupTitle() {
		clickMenuProducts();
		return this.productsMenu.groupTitle;
	}

	public WebElement getMenuProductsCatalog() {
		clickMenuProducts();
		return this.productsMenu.catalog;
	}

	public WebElement getMenuProductsCategories() {
		clickMenuProducts();
		return this.productsMenu.categories;
	}

	public WebElement getMenuProductsCloseProductMenu() {
		clickMenuProducts();
		return this.productsMenu.close;
	}

	// -----------------Customers---------------

	public WebElement getMenuCustomersTitle() {
		clickMenuCustomers();
		return this.customersMenu.title;
	}

	public WebElement getMenuCustomersAllCustomers() {
		clickMenuCustomers();
		return this.customersMenu.allCustomers;
	}

	public WebElement getMenuCustomersNowOnline() {
		clickMenuCustomers();
		return this.customersMenu.nowOnline;
	}

	public WebElement getMenuCustomersClose() {
		clickMenuCustomers();
		return this.customersMenu.close;
	}

	// -----------------Marketing---------------

	public WebElement getMenuMarketingTitle() {
		clickMenuMarketing();
		return this.marketingMenu.title;
	}

	public WebElement getMenuMarketingGroupTitlePromotions() {
		clickMenuMarketing();
		return this.marketingMenu.groupTitlePromotions;
	}

	public WebElement getMenuMarketingGroupTitleCommunications() {
		clickMenuMarketing();
		return this.marketingMenu.groupTitleCommunications;
	}

	public WebElement getMenuMarketingGroupTitleSEOAndSearch() {
		clickMenuMarketing();
		return this.marketingMenu.groupTitleSEOAndSearch;
	}

	public WebElement getMenuMarketingGroupTitleUserContent() {
		clickMenuMarketing();
		return this.marketingMenu.groupTitleUserContent;
	}

	public WebElement getMenuMarketingCatalogPriceRule() {
		clickMenuMarketing();
		return this.marketingMenu.catalogPriceRule;
	}

	public WebElement getMenuMarketingCartPriceRules() {
		clickMenuMarketing();
		return this.marketingMenu.cartPriceRules;
	}

	public WebElement getMenuMarketingEmailTemplates() {
		clickMenuMarketing();
		return this.marketingMenu.emailTemplates;
	}

	public WebElement getMenuMarketingNewsletterTemplate() {
		clickMenuMarketing();
		return this.marketingMenu.newsletterTemplate;
	}

	public WebElement getMenuMarketingNewsletterQueue() {
		clickMenuMarketing();
		return this.marketingMenu.newsletterQueue;
	}

	public WebElement getMenuMarketingNewsletterSubscribers() {
		clickMenuMarketing();
		return this.marketingMenu.newsletterSubscribers;
	}

	public WebElement getMenuMarketingURLRewrites() {
		clickMenuMarketing();
		return this.marketingMenu.URLRewrites;
	}

	public WebElement getMenuMarketingSearchTerms() {
		clickMenuMarketing();
		return this.marketingMenu.searchTerms;
	}

	public WebElement getMenuMarketingSearchSynonyms() {
		clickMenuMarketing();
		return this.marketingMenu.searchSynonyms;
	}

	public WebElement getMenuMarketingSiteMap() {
		clickMenuMarketing();
		return this.marketingMenu.siteMap;
	}

	public WebElement getMenuMarketingReviews() {
		clickMenuMarketing();
		return this.marketingMenu.reviews;
	}

	public WebElement getMenuMarketingClose() {
		clickMenuMarketing();
		return this.marketingMenu.close;
	}

	// -----------------Content---------------

	public WebElement getMenuContentTitle() {
		clickMenuContent();
		return this.contentMenu.title;
	}

	public WebElement getMenuContentGroupTitleElements() {
		clickMenuContent();
		return this.contentMenu.groupTitleElements;
	}

	public WebElement getMenuContentGroupTitleDesign() {
		clickMenuContent();
		return this.contentMenu.groupTitleDesign;
	}

	public WebElement getMenuContentPages() {
		clickMenuContent();
		return this.contentMenu.pages;
	}

	public WebElement getMenuContentBlocks() {
		clickMenuContent();
		return this.contentMenu.blocks;
	}

	public WebElement getMenuContentWidgets() {
		clickMenuContent();
		return this.contentMenu.widgets;
	}

	public WebElement getMenuContentConfiguration() {
		clickMenuContent();
		return this.contentMenu.configuration;
	}

	public WebElement getMenuContentThemes() {
		clickMenuContent();
		return this.contentMenu.themes;
	}

	public WebElement getMenuContentSchedule() {
		clickMenuContent();
		return this.contentMenu.schedule;
	}

	public WebElement getMenuContentClose() {
		clickMenuContent();
		return this.contentMenu.close;
	}

	// -----------------Reports---------------

	public WebElement getMenuReportsTitle() {
		clickMenuReports();
		return this.reportsMenu.title;
	}

	public WebElement getMenuReportsGroupTitleMarketing() {
		clickMenuReports();
		return this.reportsMenu.groupTitleMarketing;
	}

	public WebElement getMenuReportsGroupTitleSales() {
		clickMenuReports();
		return this.reportsMenu.groupTitleSales;
	}

	public WebElement getMenuReportsGroupTitleReviews() {
		clickMenuReports();
		return this.reportsMenu.groupTitleReviews;
	}

	public WebElement getMenuReportsGroupTitleCustomers() {
		clickMenuReports();
		return this.reportsMenu.groupTitleCustomers;
	}

	public WebElement getMenuReportsGroupTitleProducts() {
		clickMenuReports();
		return this.reportsMenu.groupTitleProducts;
	}

	public WebElement getMenuReportsGroupTitleStatistics() {
		clickMenuReports();
		return this.reportsMenu.groupTitleStatistics;
	}

	public WebElement getMenuReportsProductsInCart() {
		clickMenuReports();
		return this.reportsMenu.productsInCart;
	}

	public WebElement getMenuReportsSearchTerms() {
		clickMenuReports();
		return this.reportsMenu.searchTerms;
	}

	public WebElement getMenuReportsAbandonedCarts() {
		clickMenuReports();
		return this.reportsMenu.abandonedCarts;
	}

	public WebElement getMenuReportsNewsletterProblemReports() {
		clickMenuReports();
		return this.reportsMenu.newsletterProblemReports;
	}

	public WebElement getMenuReportsByCustomers() {
		clickMenuReports();
		return this.reportsMenu.byCustomers;
	}

	public WebElement getMenuReportsByProducts() {
		clickMenuReports();
		return this.reportsMenu.byProducts;
	}

	public WebElement getMenuReportsOrdersReportsMenu() {
		clickMenuReports();
		return this.reportsMenu.orders;
	}

	public WebElement getMenuReportsTax() {
		clickMenuReports();
		return this.reportsMenu.tax;
	}

	public WebElement getMenuReportsInvoiced() {
		clickMenuReports();
		return this.reportsMenu.invoiced;
	}

	public WebElement getMenuReportsShipping() {
		clickMenuReports();
		return this.reportsMenu.shipping;
	}

	public WebElement getMenuReportsRefunds() {
		clickMenuReports();
		return this.reportsMenu.refunds;
	}

	public WebElement getMenuReportsCoupons() {
		clickMenuReports();
		return this.reportsMenu.coupons;
	}

	public WebElement getMenuReportsPayPalSettlement() {
		clickMenuReports();
		return this.reportsMenu.payPalSettlement;
	}

	public WebElement getMenuReportsBraintreeSettlement() {
		clickMenuReports();
		return this.reportsMenu.braintreeSettlement;
	}

	public WebElement getMenuReportsOrderTotal() {
		clickMenuReports();
		return this.reportsMenu.orderTotal;
	}

	public WebElement getMenuReportsOrderCount() {
		clickMenuReports();
		return this.reportsMenu.orderCount;
	}

	public WebElement getMenuReportsNewOne() {
		clickMenuReports();
		return this.reportsMenu.newOne;
	}

	public WebElement getMenuReportsViews() {
		clickMenuReports();
		return this.reportsMenu.views;
	}

	public WebElement getMenuReportsBestsellers() {
		clickMenuReports();
		return this.reportsMenu.bestsellers;
	}

	public WebElement getMenuReportsLowStock() {
		clickMenuReports();
		return this.reportsMenu.lowStock;
	}

	public WebElement getMenuReportsOrdered() {
		clickMenuReports();
		return this.reportsMenu.ordered;
	}

	public WebElement getMenuReportsDownloads() {
		clickMenuReports();
		return this.reportsMenu.downloads;
	}

	public WebElement getMenuReportsRefreshStatistics() {
		clickMenuReports();
		return this.reportsMenu.refreshStatistics;
	}

	public WebElement getMenuReportsClose() {
		clickMenuReports();
		return this.reportsMenu.close;
	}

	// -----------------Stores---------------

	public WebElement getMenuStoresTitle() {
		clickMenuStores();
		return this.storesMenu.title;
	}

	public WebElement getMenuStoresGroupTitleSettings() {
		clickMenuStores();
		return this.storesMenu.groupTitleSettings;
	}

	public WebElement getMenuStoresGroupTitleAttributes() {
		clickMenuStores();
		return this.storesMenu.groupTitleAttributes;
	}

	public WebElement getMenuStoresGroupTitleTaxes() {
		clickMenuStores();
		return this.storesMenu.groupTitleTaxes;
	}

	public WebElement getMenuStoresGroupTitleCurrency() {
		clickMenuStores();
		return this.storesMenu.groupTitleCurrency;
	}

	public WebElement getMenuStoresGroupTitleOtherSettings() {
		clickMenuStores();
		return this.storesMenu.groupTitleOtherSettings;
	}

	public WebElement getMenuStoresAllStores() {
		clickMenuStores();
		return this.storesMenu.allStores;
	}

	public WebElement getMenuStoresConfiguration() {
		clickMenuStores();
		return this.storesMenu.configuration;
	}

	public WebElement getMenuStoresTermsAndConditions() {
		clickMenuStores();
		return this.storesMenu.termsAndConditions;
	}

	public WebElement getMenuStoresOrderStatus() {
		clickMenuStores();
		return this.storesMenu.orderStatus;
	}

	public WebElement getMenuStoresTaxRules() {
		clickMenuStores();
		return this.storesMenu.taxRules;
	}

	public WebElement getMenuStoresTaxZonesAndRates() {
		clickMenuStores();
		return this.storesMenu.taxZonesAndRates;
	}

	public WebElement getMenuStoresCurrencyRates() {
		clickMenuStores();
		return this.storesMenu.currencyRates;
	}

	public WebElement getMenuStoresCurrencySymbols() {
		clickMenuStores();
		return this.storesMenu.currencySymbols;
	}

	public WebElement getMenuStoresProduct() {
		clickMenuStores();
		return this.storesMenu.product;
	}

	public WebElement getMenuStoresAttributeSet() {
		clickMenuStores();
		return this.storesMenu.attributeSet;
	}

	public WebElement getMenuStoresRating() {
		clickMenuStores();
		return this.storesMenu.rating;
	}

	public WebElement getMenuStoresCustomerGroups() {
		clickMenuStores();
		return this.storesMenu.customerGroups;
	}

	public WebElement getMenuStoresClose() {
		clickMenuStores();
		return this.storesMenu.close;
	}

	// -----------------System---------------

	public WebElement getMenuSystemTitle() {
		clickMenuSystem();
		return this.systemMenu.title;
	}

	public WebElement getMenuSystemGroupTitleDataTransfer() {
		clickMenuSystem();
		return this.systemMenu.groupTitleDataTransfer;
	}

	public WebElement getMenuSystemGroupTitleExtensions() {
		clickMenuSystem();
		return this.systemMenu.groupTitleExtensions;
	}

	public WebElement getMenuSystemGroupTitleTools() {
		clickMenuSystem();
		return this.systemMenu.groupTitleTools;
	}

	public WebElement getMenuSystemGroupTitlePermissions() {
		clickMenuSystem();
		return this.systemMenu.groupTitlePermissions;
	}

	public WebElement getMenuSystemGroupTitleOtherSettings() {
		clickMenuSystem();
		return this.systemMenu.groupTitleOtherSettings;
	}

	public WebElement getMenuSystemImportOne() {
		clickMenuSystem();
		return this.systemMenu.importOne;
	}

	public WebElement getMenuSystemExport() {
		clickMenuSystem();
		return this.systemMenu.export;
	}

	public WebElement getMenuSystemImportExportTaxRates() {
		clickMenuSystem();
		return this.systemMenu.importExportTaxRates;
	}

	public WebElement getMenuSystemImportHistory() {
		clickMenuSystem();
		return this.systemMenu.importHistory;
	}

	public WebElement getMenuSystemIntegrations() {
		clickMenuSystem();
		return this.systemMenu.integrations;
	}

	public WebElement getMenuSystemCacheManagement() {
		clickMenuSystem();
		return this.systemMenu.cacheManagement;
	}

	public WebElement getMenuSystemBackups() {
		clickMenuSystem();
		return this.systemMenu.backups;
	}

	public WebElement getMenuSystemIndexManagement() {
		clickMenuSystem();
		return this.systemMenu.indexManagement;
	}

	public WebElement getMenuSystemWebSetupWizard() {
		clickMenuSystem();
		return this.systemMenu.webSetupWizard;
	}

	public WebElement getMenuSystemAllUsers() {
		clickMenuSystem();
		return this.systemMenu.allUsers;
	}

	public WebElement getMenuSystemLockedUsers() {
		clickMenuSystem();
		return this.systemMenu.lockedUsers;
	}

	public WebElement getMenuSystemUserRoles() {
		clickMenuSystem();
		return this.systemMenu.userRoles;
	}

	public WebElement getMenuSystemNotifications() {
		clickMenuSystem();
		return this.systemMenu.notifications;
	}

	public WebElement getMenuSystemCustomVariables() {
		clickMenuSystem();
		return this.systemMenu.customVariables;
	}

	public WebElement getMenuSystemManageEncryptionKey() {
		clickMenuSystem();
		return this.systemMenu.manageEncryptionKey;
	}

	public WebElement getMenuSystemClose() {
		// TODO Create inner class
		return this.systemMenu.close;
	}

	// Get Data Business Logic

	public String getMenuDashboardText() {
		return getMenuDashboard().getText();
	}

	public String getMenuSalesText() {
		return getMenuSales().getText();
	}

	public String getMenuProductsText() {
		return getMenuProducts().getText();
	}

	public String getMenuCustomersText() {
		return getMenuCustomers().getText();
	}

	public String getMenuMarketingText() {
		return getMenuMarketing().getText();
	}

	public String getMenuContentText() {
		return getMenuContent().getText();
	}

	public String getMenuReportsText() {
		return getMenuReports().getText();
	}

	public String getMenuStoresText() {
		return getMenuStores().getText();
	}

	public String getMenuSystemText() {
		return getMenuSystem().getText();
	}

	public String getMenuFindPartnersText() {
		return getMenuFindPartners().getText();
	}

	// set Data PageObject

	public void clickLogo() {
		// Goto Dashboard Page
		getLogo().click();
	}

	public void clickMenuDashboard() {
		// Goto Dashboard Page
		getMenuDashboard().click();
	}

	public void clickMenuSales() {
		getMenuSales().click();
		this.salesMenu = new SalesComponent();
	}

	public void clickMenuProducts() {
		getMenuProducts().click();
		this.productsMenu = new ProductsComponent();
	}

	public void clickMenuCustomers() {
		getMenuCustomers().click();
		this.customersMenu = new CustomersComponent();
	}

	public void clickMenuMarketing() {
		getMenuMarketing().click();
		this.marketingMenu = new MarketingComponent();
	}

	public void clickMenuContent() {
		getMenuContent().click();
		this.contentMenu = new ContentComponent();
	}

	public void clickMenuReports() {
		getMenuReports().click();
		this.reportsMenu = new ReportsComponent();
	}

	public void clickMenuStores() {
		getMenuStores().click();
		this.storesMenu = new StoresComponent();
	}

	public void clickMenuSystem() {
		getMenuSystem().click();
		this.systemMenu = new SystemComponent();
	}

	public void clickMenuFindPartners() {
		getMenuFindPartners().click();
	}

	// -----------------Sales---------------

	public void clickMenuSalesOrders() {

		getMenuSalesOrders().click();
	}

	public void clickMenuSalesInvoices() {
		getMenuSalesInvoices().click();
	}

	public void clickMenuSalesShipments() {
		getMenuSalesShipments().click();
	}

	public void clickMenuSalesCreditMemos() {
		getMenuSalesCreditMemos().click();
	}

	public void clickMenuSalesBillingAgreements() {
		getMenuSalesBillingAgreements().click();
	}

	public void clickMenuSalesTransactions() {
		getMenuSalesTransactions().click();
	}

	// -----------------Products---------------

	public void clickMenuProductsCatalog() {
		getMenuProductsCatalog().click();
	}

	public void clickMenuProductsCategories() {
		getMenuProductsCategories().click();
	}

	// -----------------Customers---------------

	public void clickMenuCustomersAllCustomers() {
		getMenuCustomersAllCustomers().click();
	}

	public void clickMenuCustomersNowOnline() {
		getMenuCustomersNowOnline().click();
	}

	// -----------------Marketing---------------

	public void clickMenuMarketingCatalogPriceRule() {
		getMenuMarketingCatalogPriceRule().click();
	}

	public void clickMenuMarketingCartPriceRules() {
		getMenuMarketingCartPriceRules().click();
	}

	public void clickMenuMarketingEmailTemplates() {
		getMenuMarketingEmailTemplates().click();
	}

	public void clickMenuMarketingNewsletterTemplate() {
		getMenuMarketingNewsletterTemplate().click();
	}

	public void clickMenuMarketingNewsletterQueue() {
		getMenuMarketingNewsletterQueue().click();
	}

	public void clickMenuMarketingNewsletterSubcribers() {
		getMenuMarketingNewsletterSubscribers().click();
	}

	public void clickMenuMarketingURLRewrites() {
		getMenuMarketingURLRewrites().click();
	}

	public void clickMenuMarketingSearchTerms() {
		getMenuMarketingSearchTerms().click();
	}

	public void clickMenuMarketingSearchSynonyms() {
		getMenuMarketingSearchSynonyms().click();
	}

	public void clickMenuMarketingSiteMap() {
		getMenuMarketingSiteMap().click();
	}

	public void clickMenuMarketingReviews() {
		getMenuMarketingReviews().click();
	}

	// -----------------Content---------------

	public void clickMenuContentPages() {
		getMenuContentPages().click();
	}

	public void clickMenuContentBlocks() {
		getMenuContentBlocks().click();
	}

	public void clickMenuContentWidgets() {
		getMenuContentWidgets().click();
	}

	public void clickMenuContentConfiguration() {
		getMenuContentConfiguration().click();
	}

	public void clickMenuContentThemes() {
		getMenuContentThemes().click();
	}

	public void clickMenuContentSchedule() {
		getMenuContentSchedule().click();
	}

	// -----------------Reports---------------

	public void clickMenuReportsProductsInCart() {
		getMenuReportsProductsInCart().click();
	}

	public void clickMenuReportsSearchTerms() {
		getMenuReportsSearchTerms().click();
	}

	public void clickMenuReportsAbandonedCarts() {
		getMenuReportsAbandonedCarts().click();
	}

	public void clickMenuReportsNewsletterProblemReports() {
		getMenuReportsNewsletterProblemReports().click();
	}

	public void clickMenuReportsByCustomers() {
		getMenuReportsByCustomers().click();
	}

	public void clickMenuReportsByProducts() {
		getMenuReportsByProducts().click();
	}

	public void clickMenuReportsOrders() {
		getMenuReportsOrdersReportsMenu().click();
	}

	public void clickMenuReportsTax() {
		getMenuReportsTax().click();
	}

	public void clickMenuReportsInvoiced() {
		getMenuReportsInvoiced().click();
	}

	public void clickMenuReportsShipping() {
		getMenuReportsShipping().click();
	}

	public void clickMenuReportsRefunds() {
		getMenuReportsRefunds().click();
	}

	public void clickMenuReportsCoupons() {
		getMenuReportsCoupons().click();
	}

	public void clickMenuReportsPayPalSettlement() {
		getMenuReportsPayPalSettlement().click();
	}

	public void clickMenuReportsBraintreeSettlement() {
		getMenuReportsBraintreeSettlement().click();
	}

	public void clickMenuReportsOrderTotal() {
		getMenuReportsOrderTotal().click();
	}

	public void clickMenuReportsOrderCount() {
		getMenuReportsOrderCount().click();
	}

	public void clickMenuReportsNew() {
		getMenuReportsNewOne().click();
	}

	public void clickMenuReportsViews() {
		getMenuReportsViews().click();
	}

	public void clicMenuReportskBestsellers() {
		getMenuReportsBestsellers().click();
	}

	public void clickMenuReportsLowStock() {
		getMenuReportsLowStock().click();
	}

	public void clickMenuReportsOrdered() {
		getMenuReportsOrdered().click();
	}

	public void clickMenuReportsDownloads() {
		getMenuReportsDownloads().click();
	}

	public void clickMenuReportsRefreshStatistics() {
		getMenuReportsRefreshStatistics().click();
	}

	// -----------------Stores---------------

	public void clickMenuStoresAllStores() {
		getMenuStoresAllStores().click();
	}

	public void clickMenuStoresConfiguration() {
		getMenuStoresConfiguration().click();
	}

	public void clickMenuStoresTermsAndConditions() {
		getMenuStoresTermsAndConditions().click();
	}

	public void clickMenuStoresOrderStatus() {
		getMenuStoresOrderStatus().click();
	}

	public void clickMenuStoresTaxRules() {
		getMenuStoresTaxRules().click();
	}

	public void clickMenuStoresTaxZonesAndRates() {
		getMenuStoresTaxZonesAndRates().click();
	}

	public void clickMenuStoresCurrencyRates() {
		getMenuStoresCurrencyRates().click();
	}

	public void clickMenuStoresCurrencySymbols() {
		getMenuStoresCurrencySymbols().click();
	}

	public void clickMenuStoresProduct() {
		getMenuStoresProduct().click();
	}

	public void clickMenuStoresAttributeSet() {
		getMenuStoresAttributeSet().click();
	}

	public void clickMenuStoresRating() {
		getMenuStoresRating().click();
	}

	public void clickMenuStoresCustomerGroups() {
		getMenuStoresCustomerGroups().click();
	}

	// -----------------System---------------

	public void clickMenuSystemImport() {
		getMenuSystemImportOne().click();
	}

	public void clickMenuSystemExport() {
		getMenuSystemExport().click();
	}

	public void clickMenuSystemImportExportTaxRates() {
		getMenuSystemImportExportTaxRates().click();
	}

	public void clickMenuSystemImportHistory() {
		getMenuSystemImportHistory().click();
	}

	public void clickMenuSystemIntegrations() {
		getMenuSystemIntegrations().click();
	}

	public void clickMenuSystemCacheManagement() {
		getMenuSystemCacheManagement().click();
	}

	public void clickMenuSystemBackups() {
		getMenuSystemBackups().click();
	}

	public void clickMenuSystemIndexManagement() {
		getMenuSystemIndexManagement().click();
	}

	public void clickMenuSystemWebSetupWizard() {
		getMenuSystemWebSetupWizard().click();
	}

	public void clickMenuSystemAllUsers() {
		getMenuSystemAllUsers().click();
	}

	public void clickMenuSystemLockedUsers() {
		getMenuSystemLockedUsers().click();
	}

	public void clickMenuSystemUserRoles() {
		getMenuSystemUserRoles().click();
	}

	public void clickMenuSystemNotifications() {
		getMenuSystemNotifications().click();
	}

	public void clickMenuSystemCustomVariables() {
		getMenuSystemCustomVariables().click();
	}

	public void clickMenuSystemManageEncryptionKey() {
		getMenuSystemManageEncryptionKey().click();
	}

	// Business Logic

	public DashboardPage gotoHomePage() {
		clickLogo();
		// Return a new page object representing the destination.
		return new DashboardPage();
	}

	public DashboardPage gotoDashboardPage() {
		clickMenuDashboard();
		// Return a new page object representing the destination.
		return new DashboardPage();
	}

	// -----------------Sales---------------

    public OrdersPage gotoOrdersPage() {
 		clickMenuSalesOrders();
		return new OrdersPage(); }

    /*
	 * public InvoicesPage gotoInvoicesPage() {
	 * clickMenuSalesInvoices(); return new InvoicesPage(driver); } public
	 * ShipmentsPage gotoShipmentsPage() { clickMenuSalesShipments(); return new
	 * ShipmentsPage(driver); } public CreditMemosPage gotoCreditMemosPage() {
	 * clickMenuSalesCreditMemos(); return new CreditMemosPage(driver); } public
	 * BillingAgreementsPage gotoBillingAgreementsPage() {
	 * clickMenuSalesBillingAgreements(); return new
	 * BillingAgreementsPage(driver); } public TransactionsPage
	 * gotoTransactionsPage() { clickMenuSalesTransactions(); return new
	 * TransactionsPage(driver); }
	 */
	// -----------------Products---------------

	public ProductCatalogPage gotoProductCatalogPage() {
		clickMenuProductsCatalog();
		return new ProductCatalogPage();
	}


	 public CategoriesPage gotoCategoriesPage() {
		 clickMenuProductsCategories();
		 return new CategoriesPage();
	 }


	// -----------------Customers---------------
	public AllCustomersPage gotoAllCustomersPage() {
		clickMenuCustomersAllCustomers();
		return new AllCustomersPage();
	}

	/*
	 * public NowOnlinePage gotoNowOnlinePage() { clickMenuCustomersNowOnline();
	 * return new NowOnlinePage(driver); }
	 */

	// -----------------Marketing---------------

	/*
	 * public CartPriceRulesPage gotoCartPriceRulesPage() {
	 * clickMenuMarketingCartPriceRules(); // Return a new page object
	 * representing the destination. return new CartPriceRulesPage(driver); }
	 */

	/*
	 * public CatalogPriceRulePage gotoCatalogPriceRulePage() {
	 * clickMenuMarketingCatalogPriceRule(); // Return a new page object
	 * representing the destination. return new CatalogPriceRulePage(driver); }
	 */

	/*
	 * public EmailTemplatesPage gotoEmailTemplatesPage() {
	 * clickMenuMarketingEmailTemplates(); // Return a new page object
	 * representing the destination. return new EmailTemplatesPage(driver); }
	 */

	/*
	 * public NewsletterQueuePage gotoNewsletterQueuePage() {
	 * clickMenuMarketingNewsletterQueue(); // Return a new page object
	 * representing the destination. return new NewsletterQueuePage(driver); }
	 */

	/*
	 * public NewsletterSubcribersPage gotoNewsletterSubcribersPage() {
	 * clickMenuMarketingNewsletterSubcribers(); // Return a new page object
	 * representing the destination. return new
	 * NewsletterSubcribersPage(driver); }
	 */

	/*
	 * public NewsletterTemplatePage gotoNewsletterTemplatePage() {
	 * clickMenuMarketingNewsletterTemplate(); // Return a new page object
	 * representing the destination. return new NewsletterTemplatePage(driver);
	 * }
	 */

	/*
	 * public ReviewsPage gotoReviewsPage() { clickMenuMarketingReviews(); //
	 * Return a new page object representing the destination. return new
	 * ReviewsPage(driver); }
	 */

	/*
	 * public SearchSynonymsPage gotoSearchSynonymsPage() {
	 * clickMenuMarketingSearchSynonyms(); // Return a new page object
	 * representing the destination. return new SearchSynonymsPage(driver); }
	 */

	/*
	 * public SearchTermsPage gotoSearchTermsPage() {
	 * clickMenuMarketingSearchTerms(); // Return a new page object representing
	 * the destination. return new SearchTermsPage(driver); }
	 */

	/*
	 * public SiteMapPage gotoSiteMapPage() { clickMenuMarketingSiteMap(); //
	 * Return a new page object representing the destination. return new
	 * SiteMapPage(driver); }
	 */

	/*
	 * public URLRewritesPage gotoURLRewritesPage() {
	 * clickMenuMarketingURLRewrites(); // Return a new page object representing
	 * the destination. return new URLRewritesPage(driver); }
	 */

	// -----------------Content---------------

	/*
	 * public BlocksPage gotoBlocksPage() { clickMenuContentBlocks(); return new
	 * BlocksPage(driver); }
	 */

	/*
	 * public ConfigurationPage gotoConfigurationPage() {
	 * clickMenuContentConfiguration(); return new ConfigurationPage(driver); }
	 */

	/*
	 * public PagesPage gotoPagesPage() { clickMenuContentPages(); return new
	 * PagesPage(driver); }
	 */

	/*
	 * public SchedulePage gotoSchedulePage() { clickMenuContentSchedule();
	 * return new SchedulePage(driver); }
	 */

	/*
	 * public ThemesPage gotoThemesPage() { clickMenuContentThemes(); return new
	 * ThemesPage(driver); }
	 */

	/*
	 * public WidgetsPage gotoWidgetsPage() { clickMenuContentWidgets(); return
	 * new WidgetsPage(driver); }
	 */

	// -----------------Reports---------------

	// -----------------Stores---------------

	// -----------------System---------------

}

package com.softserve.edu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class VerticalMenu extends ATopPage {
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
	private WebElement partnersAndExtensions;

	//----------------------------

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
			this.title = driver.findElement(By
					.xpath("//strong[text()='Sales']"));
			this.groupTitle = driver.findElement(By
					.xpath("//span[text()='Operations']"));
			this.orders = driver.findElement(By
					.linkText("Orders"));
			this.invoices = driver.findElement(By
					.linkText("Invoices"));
			this.shipments = driver.findElement(By
					.linkText("Shipments"));
			this.creditMemos = driver.findElement(By
					.linkText("Credit Memos"));
			this.billingAgreements = driver.findElement(By
					.linkText("Billing Agreements"));
			this.transactions = driver.findElement(By
					.linkText("Transcations"));
			this.close = driver.findElement(By
					.cssSelector("#menu-magento-sales-sales > div > a"));
		}
		
	}
	
	//----------------------------
	
	private class ProductsComponent {
		public final WebElement title;
		public final WebElement groupTitle;
		public final WebElement catalog;
		public final WebElement categories;
		public final WebElement close;

		public ProductsComponent() {
		this.title = driver.findElement(By.
				xpath("//strong[text()='Products']"));
		this.groupTitle = driver.findElement(By
				.xpath("//span[text()='Operations']"));
		this.catalog = driver.findElement(By
				.linkText("Catalog"));
		this.categories = driver.findElement(By
				.linkText("Categories"));
		this.close = driver.findElement(By
				.cssSelector("#menu-magento-catalog-catalog > div > a"));
		}
		
	}
	//----------------------------
	
	private class CustomersComponent {
		public final WebElement title;
		public final WebElement allCustomers;
		public final WebElement nowOnline;
		public final WebElement close;

		public CustomersComponent() {
			this.title = driver.findElement(By.
					xpath("//strong[text()='Customers']"));
			this.allCustomers = driver.findElement(By
					.linkText("All Customers"));
			this.nowOnline = driver.findElement(By
					.linkText("Now Online"));
			this.close = driver.findElement(By
					.cssSelector("#menu-magento-customer-customer > div > a"));
		}

		
	}
	//----------------------------
	
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
			this.title = driver.findElement(By.
					xpath("//strong[text()='Marketing']"));
			this.groupTitlePromotions = driver.findElement(By.
					xpath("//strong[text()='Promotions']"));
			this.groupTitleCommunications = driver.findElement(By
					.xpath("//span[text()='Communications']"));
			this.groupTitleSEOAndSearch = driver.findElement(By
					.xpath("//span[text()='SEO & Search']"));
			this.groupTitleUserContent = driver.findElement(By
					.xpath("//span[text()='User Content']"));
			this.catalogPriceRule = driver.findElement(By
					.linkText("Catalog Price Rule"));
			this.cartPriceRules = driver.findElement(By
					.linkText("Cart Price Rules"));
			this.emailTemplates = driver.findElement(By
					.linkText("Email Templates"));
			this.newsletterTemplate = driver.findElement(By
					.linkText("Newsletter Template"));
			this.newsletterQueue = driver.findElement(By
					.linkText("Newsletter Queue"));
			this.newsletterSubscribers = driver.findElement(By
					.linkText("Newsletter Subscribers"));
			this.URLRewrites = driver.findElement(By
					.linkText("URL Rewrites"));
			this.searchTerms = driver.findElement(By
					.linkText("Search Terms"));
			this.searchSynonyms = driver.findElement(By
					.linkText("Search Synonyms"));
			this.siteMap = driver.findElement(By
					.linkText("Site Map"));
			this.reviews = driver.findElement(By
					.linkText("Reviews"));
			this.close = driver.findElement(By
					.cssSelector("#menu-magento-backend-marketing > div > a"));

		}

		
	}
	//----------------------------
	
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
			this.title = driver.findElement(By.
					xpath("//strong[text()='Content']"));
			this.groupTitleElements = driver.findElement(By.
					xpath("//strong[text()='Elements']"));
			this.groupTitleDesign = driver.findElement(By
					.xpath("//span[text()='Design']"));
			this.pages = driver.findElement(By
					.linkText("Pages"));
			this.blocks = driver.findElement(By
					.linkText("Blocks"));
			this.widgets = driver.findElement(By
					.linkText("Widgets"));
			this.configuration = driver.findElement(By
					.linkText("Configuration"));
			this.themes = driver.findElement(By
					.linkText("Themes"));
			this.schedule = driver.findElement(By
					.linkText("Schedule"));
			this.close = driver.findElement(By
					.cssSelector("#menu-magento-backend-content > div > a"));
		}

		
	}
	//----------------------------
	
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
		
		this.title = driver.findElement(By.
				xpath("//strong[text()='Reports']"));
		this.groupTitleMarketing = driver.findElement(By.
				xpath("//strong[text()='Marketing']"));
		this.groupTitleSales = driver.findElement(By
				.xpath("//span[text()='Sales']"));
		this.groupTitleReviews = driver.findElement(By.
				xpath("//strong[text()='Reviews']"));
		this.groupTitleCustomers = driver.findElement(By
				.xpath("//span[text()='Customers']"));
		this.groupTitleProducts = driver.findElement(By.
				xpath("//strong[text()='Products']"));
		this.groupTitleStatistics = driver.findElement(By
				.xpath("//span[text()='Statistics']"));
		this.productsInCart = driver.findElement(By
				.linkText("Products in Cart"));
		this.searchTerms = driver.findElement(By
				.linkText("Search Terms"));
		this.abandonedCarts = driver.findElement(By
				.linkText("Abandoned Carts"));
		this.newsletterProblemReports = driver.findElement(By
				.linkText("Newsletter Problem Reports"));
		this.byCustomers = driver.findElement(By
				.linkText("By Customers"));
		this.byProducts = driver.findElement(By
				.linkText("By Products"));
		this.orders = driver.findElement(By
				.linkText("Orders"));
		this.tax = driver.findElement(By
				.linkText("Pages"));
		this.invoiced = driver.findElement(By
				.linkText("Invoiced"));
		this.shipping = driver.findElement(By
				.linkText("Shipping"));
		this.refunds = driver.findElement(By
				.linkText("Refunds"));
		this.coupons = driver.findElement(By
				.linkText("Coupons"));
		this.payPalSettlement = driver.findElement(By
				.linkText("PayPal Settlement"));
		this.braintreeSettlement = driver.findElement(By
				.linkText("Braintree Settlement"));
		this.orderTotal = driver.findElement(By
				.linkText("Order Total"));
		this.orderCount = driver.findElement(By
				.linkText("Order Count"));
		this.newOne = driver.findElement(By
				.linkText("New"));
		this.views = driver.findElement(By
				.linkText("Views"));
		this.bestsellers = driver.findElement(By
				.linkText("Pages"));
		this.lowStock = driver.findElement(By
				.linkText("Low Stock"));
		this.ordered = driver.findElement(By
				.linkText("Ordered"));
		this.downloads = driver.findElement(By
				.linkText("Downloads"));
		this.refreshStatistics = driver.findElement(By
				.linkText("Refresh Statistics"));
		this.close = driver.findElement(By
				.cssSelector("#menu-magento-reports-report > div > a"));
	}

		
		}
	//----------------------------
	
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
			this.title = driver.findElement(By.
					xpath("//strong[text()='Reports']"));
			this.groupTitleSettings = driver.findElement(By.
					xpath("//strong[text()='Settings']"));
			this.groupTitleAttributes = driver.findElement(By
					.xpath("//span[text()='Attributes']"));
			this.groupTitleTaxes = driver.findElement(By.
					xpath("//strong[text()='Taxes']"));
			this.groupTitleCurrency = driver.findElement(By
					.xpath("//span[text()='Currency']"));
			this.groupTitleOtherSettings = driver.findElement(By.
					xpath("//strong[text()='Other Settings']"));
			this.allStores = driver.findElement(By
					.linkText("All Stores"));
			this.configuration = driver.findElement(By
					.linkText("Configuration"));
			this.termsAndConditions = driver.findElement(By
					.linkText("Terms and Conditions"));
			this.orderStatus = driver.findElement(By
					.linkText("Order Status"));
			this.taxRules = driver.findElement(By
					.linkText("Tax Rules"));
			this.taxZonesAndRates = driver.findElement(By
					.linkText("Tax Zones and Rates"));
			this.currencyRates = driver.findElement(By
					.linkText("Currency Rates"));
			this.currencySymbols = driver.findElement(By
					.linkText("Currency Symbols"));
			this.product = driver.findElement(By
					.linkText("Product"));
			this.attributeSet = driver.findElement(By
					.linkText("Attribute Set"));
			this.rating = driver.findElement(By
					.linkText("Rating"));
			this.customerGroups = driver.findElement(By
					.linkText("Customer Groups"));
			this.close = driver.findElement(By
					.cssSelector("#menu-magento-backend-stores > div > a"));
		}

		
	}
	//----------------------------
	
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
			this.title = driver.findElement(By.
					xpath("//strong[text()='System']"));
			this.groupTitleDataTransfer = driver.findElement(By.
					xpath("//strong[text()='Data Transfer']"));
			this.groupTitleExtensions = driver.findElement(By
					.xpath("//span[text()='Extensions']"));
			this.groupTitleTools = driver.findElement(By.
					xpath("//strong[text()='Tools']"));
			this.groupTitlePermissions = driver.findElement(By
					.xpath("//span[text()='Permissions']"));
			this.groupTitleOtherSettings = driver.findElement(By.
					xpath("//strong[text()='Other Settings']"));
			this.importOne = driver.findElement(By
					.linkText("Import"));
			this.export = driver.findElement(By
					.linkText("Export"));
			this.importExportTaxRates = driver.findElement(By
					.linkText("Import/Export Tax Rates"));
			this.importHistory = driver.findElement(By
					.linkText("Import History"));
			this.integrations = driver.findElement(By
					.linkText("Integrations"));
			this.cacheManagement = driver.findElement(By
					.linkText("Cache Management"));
			this.backups = driver.findElement(By
					.linkText("Backups"));
			this.indexManagement = driver.findElement(By
					.linkText("Index Management"));
			this.webSetupWizard = driver.findElement(By
					.linkText("Web Setup Wizard"));
			this.allUsers = driver.findElement(By
					.linkText("All Users"));
			this.lockedUsers = driver.findElement(By
					.linkText("Locked Users"));
			this.userRoles = driver.findElement(By
					.linkText("User Roles"));
			this.notifications = driver.findElement(By
					.linkText("Notifications"));
			this.customVariables = driver.findElement(By
					.linkText("Custom Variables"));
			this.manageEncryptionKey = driver.findElement(By
					.linkText("Manage Encryption Key"));
			this.close = driver.findElement(By
					.cssSelector("#menu-magento-backend-system > div > a"));
		}

		

	}
	//----------------------------
	
	
	// Elements

	SalesComponent salesMenu;
	ProductsComponent productsMenu;
	CustomersComponent customersMenu;
	MarketingComponent marketingMenu;
	ContentComponent contentMenu;
	ReportsComponent reportsMenu;
	StoresComponent storesMenu;
	SystemComponent systemMenu;
	
	
	protected VerticalMenu(WebDriver driver) {
		super(driver);
		this.logo = driver.findElement(By.
				cssSelector(".logo-img"));
		this.dashboard = driver.findElement(By
				.xpath("//*[@id='menu-magento-backend-dashboard']/a"));
		this.sales = driver.findElement(By
				.xpath("//*[@id='menu-magento-sales-sales']/a"));
		this.products = driver.findElement(By
				.xpath("//*[@id='menu-magento-catalog-catalog']/a"));
		this.customers = driver.findElement(By
				.xpath("//*[@id='menu-magento-customer-customer']/a"));
		this.marketing = driver.findElement(By
				.xpath("//*[@id='menu-magento-backend-marketing']/a"));
		this.content = driver.findElement(By
				.xpath("//*[@id='menu-magento-backend-content']/a"));
		this.reports = driver.findElement(By
				.xpath("//*[@id='menu-magento-reports-report']/a"));
		this.stores = driver.findElement(By
				.xpath("//*[@id='menu-magento-backend-stores']/a"));
		this.system = driver.findElement(By
				.xpath("//*[@id='menu-magento-backend-system']/a"));
		this.partnersAndExtensions = driver.findElement(By
				.xpath("//*[@id='menu-magento-marketplace-partners']/a"));
		
	}

	// Page Object
	// Get Data PageObject
	public WebElement getLogo() {
		return this.logo;
	}

	public WebElement getDashboard() {
		return this.dashboard;
	}

	public WebElement getSales() {
		return this.sales;
	}

	public WebElement getProducts() {
		return this.products;
	}

	public WebElement getCustomers() {
		return this.customers;
	}

	public WebElement getMarketing() {
		return this.marketing;
	}

	public WebElement getContent() {
		return this.content;
	}

	public WebElement getReports() {
		return this.reports;
	}

	public WebElement getStores() {
		return this.stores;
	}

	public WebElement getSystem() {
		return this.system;
	}

	public WebElement getPartnersAndExtensions() {
		return this.partnersAndExtensions;
	}

	// -----------------Sales---------------
	public WebElement getTitleSalesMenu() {
		return this.salesMenu.title;
	}

	public WebElement getGroupTitleSalesMenu() {
		return this.salesMenu.groupTitle;
	}

	public WebElement getOrdersSalesMenu() {
		return this.salesMenu.orders;
	}

	public WebElement getInvoices() {
		return this.salesMenu.invoices;
	}

	public WebElement getShipments() {
		return this.salesMenu.shipments;
	}

	public WebElement getCreditMemos() {
		return this.salesMenu.creditMemos;
	}

	public WebElement getBillingAgreements() {
		return this.salesMenu.billingAgreements;
	}

	public WebElement getTransactions() {
		return this.salesMenu.transactions;
	}

	public WebElement getCloseSalesMenu() {
		return this.salesMenu.close;
	}

	// -----------------Products---------------
	public WebElement getTitleProductMenu() {
		return this.productsMenu.title;
	}

	public WebElement getGroupTitleProductMenu() {
		return this.productsMenu.groupTitle;
	}

	public WebElement getCatalog() {
		return this.productsMenu.catalog;
	}

	public WebElement getCategories() {
		return this.productsMenu.categories;
	}

	public WebElement getCloseProductMenu() {
		return this.productsMenu.close;
	}

	// -----------------Customers---------------
	public WebElement getTitleCustomersMenu() {
		return this.customersMenu.title;
	}

	public WebElement getAllCustomers() {
		return this.customersMenu.allCustomers;
	}

	public WebElement getNowOnline() {
		return this.customersMenu.nowOnline;
	}

	public WebElement getCloseCustomersMenu() {
		return this.customersMenu.close;
	}

	// -----------------Marketing---------------
	public WebElement getTitleMarketingMenu() {
		return this.marketingMenu.title;
	}

	public WebElement getGroupTitlePromotions() {
		return this.marketingMenu.groupTitlePromotions;
	}

	public WebElement getGroupTitleCommunications() {
		return this.marketingMenu.groupTitleCommunications;
	}

	public WebElement getGroupTitleSEOAndSearch() {
		return this.marketingMenu.groupTitleSEOAndSearch;
	}

	public WebElement getGroupTitleUserContent() {
		return this.marketingMenu.groupTitleUserContent;
	}

	public WebElement getCatalogPriceRule() {
		return this.marketingMenu.catalogPriceRule;
	}

	public WebElement getCartPriceRules() {
		return this.marketingMenu.cartPriceRules;
	}

	public WebElement getEmailTemplates() {
		return this.marketingMenu.emailTemplates;
	}

	public WebElement getNewsletterTemplate() {
		return this.marketingMenu.newsletterTemplate;
	}

	public WebElement getNewsletterQueue() {
		return this.marketingMenu.newsletterQueue;
	}

	public WebElement getNewsletterSubscribers() {
		return this.marketingMenu.newsletterSubscribers;
	}

	public WebElement getURLRewrites() {
		return this.marketingMenu.URLRewrites;
	}

	public WebElement getSearchTermsMarketingMenu() {
		return this.marketingMenu.searchTerms;
	}

	public WebElement getSearchSynonyms() {
		return this.marketingMenu.searchSynonyms;
	}

	public WebElement getSiteMap() {
		return this.marketingMenu.siteMap;
	}

	public WebElement getReviews() {
		return this.marketingMenu.reviews;
	}

	public WebElement getCloseMarketingMenu() {
		return this.marketingMenu.close;
	}

	// -----------------Content---------------
	public WebElement getTitleContentMenu() {
		return this.contentMenu.title;
	}

	public WebElement getGroupTitleElements() {
		return this.contentMenu.groupTitleElements;
	}

	public WebElement getGroupTitleDesign() {
		return this.contentMenu.groupTitleDesign;
	}

	public WebElement getPages() {
		return this.contentMenu.pages;
	}

	public WebElement getBlocks() {
		return this.contentMenu.blocks;
	}

	public WebElement getWidgets() {
		return this.contentMenu.widgets;
	}

	public WebElement getConfigurationContentMenu() {
		return this.contentMenu.configuration;
	}

	public WebElement getThemes() {
		return this.contentMenu.themes;
	}

	public WebElement getSchedule() {
		return this.contentMenu.schedule;
	}

	public WebElement getCloseContentMenu() {
		return this.contentMenu.close;
	}

	// -----------------Reports---------------
	public WebElement getTitleReportsMenu() {
		return this.reportsMenu.title;
	}

	public WebElement getGroupTitleMarketing() {
		return this.reportsMenu.groupTitleMarketing;
	}

	public WebElement getGroupTitleSales() {
		return this.reportsMenu.groupTitleSales;
	}

	public WebElement getGroupTitleReviews() {
		return this.reportsMenu.groupTitleReviews;
	}

	public WebElement getGroupTitleCustomers() {
		return this.reportsMenu.groupTitleCustomers;
	}

	public WebElement getGroupTitleProducts() {
		return this.reportsMenu.groupTitleProducts;
	}

	public WebElement getGroupTitleStatistics() {
		return this.reportsMenu.groupTitleStatistics;
	}

	public WebElement getProductsInCart() {
		return this.reportsMenu.productsInCart;
	}

	public WebElement getSearchTermsReportsMenu() {
		return this.reportsMenu.searchTerms;
	}

	public WebElement getAbandonedCarts() {
		return this.reportsMenu.abandonedCarts;
	}

	public WebElement getNewsletterProblemReports() {
		return this.reportsMenu.newsletterProblemReports;
	}

	public WebElement getByCustomers() {
		return this.reportsMenu.byCustomers;
	}

	public WebElement getByProducts() {
		return this.reportsMenu.byProducts;
	}

	public WebElement getOrdersReportsMenu() {
		return this.reportsMenu.orders;
	}

	public WebElement getTax() {
		return this.reportsMenu.tax;
	}

	public WebElement getInvoiced() {
		return this.reportsMenu.invoiced;
	}

	public WebElement getShipping() {
		return this.reportsMenu.shipping;
	}

	public WebElement getRefunds() {
		return this.reportsMenu.refunds;
	}

	public WebElement getCoupons() {
		return this.reportsMenu.coupons;
	}

	public WebElement getPayPalSettlement() {
		return this.reportsMenu.payPalSettlement;
	}

	public WebElement getBraintreeSettlement() {
		return this.reportsMenu.braintreeSettlement;
	}

	public WebElement getOrderTotal() {
		return this.reportsMenu.orderTotal;
	}

	public WebElement getOrderCount() {
		return this.reportsMenu.orderCount;
	}

	public WebElement getNewOne() {
		return this.reportsMenu.newOne;
	}

	public WebElement getViews() {
		return this.reportsMenu.views;
	}

	public WebElement getBestsellers() {
		return this.reportsMenu.bestsellers;
	}

	public WebElement getLowStock() {
		return this.reportsMenu.lowStock;
	}

	public WebElement getOrdered() {
		return this.reportsMenu.ordered;
	}

	public WebElement getDownloads() {
		return this.reportsMenu.downloads;
	}

	public WebElement getRefreshStatistics() {
		return this.reportsMenu.refreshStatistics;
	}

	public WebElement getCloseReportsMenu() {
		return this.reportsMenu.close;
	}

	// -----------------Stores---------------
	public WebElement getTitleStoresMenu() {
		return this.storesMenu.title;
	}

	public WebElement getGroupTitleSettings() {
		return this.storesMenu.groupTitleSettings;
	}

	public WebElement getGroupTitleAttributes() {
		return this.storesMenu.groupTitleAttributes;
	}

	public WebElement getGroupTitleTaxes() {
		return this.storesMenu.groupTitleTaxes;
	}

	public WebElement getGroupTitleCurrency() {
		return this.storesMenu.groupTitleCurrency;
	}

	public WebElement getGroupTitleOtherSettingsStoresMenu() {
		return this.storesMenu.groupTitleOtherSettings;
	}

	public WebElement getAllStores() {
		return this.storesMenu.allStores;
	}

	public WebElement getConfigurationStoresMenu() {
		return this.storesMenu.configuration;
	}

	public WebElement getTermsAndConditions() {
		return this.storesMenu.termsAndConditions;
	}

	public WebElement getOrderStatus() {
		return this.storesMenu.orderStatus;
	}

	public WebElement getTaxRules() {
		return this.storesMenu.taxRules;
	}

	public WebElement getTaxZonesAndRates() {
		return this.storesMenu.taxZonesAndRates;
	}

	public WebElement getCurrencyRates() {
		return this.storesMenu.currencyRates;
	}

	public WebElement getCurrencySymbols() {
		return this.storesMenu.currencySymbols;
	}

	public WebElement getProduct() {
		return this.storesMenu.product;
	}

	public WebElement getAttributeSet() {
		return this.storesMenu.attributeSet;
	}

	public WebElement getRating() {
		return this.storesMenu.rating;
	}

	public WebElement getCustomerGroups() {
		return this.storesMenu.customerGroups;
	}

	public WebElement getCloseStoresMenu() {
		return this.storesMenu.close;
	}

	// -----------------System---------------
	public WebElement getTitleSystemMenu() {
		return this.systemMenu.title;
	}

	public WebElement getGroupTitleDataTransfer() {
		return this.systemMenu.groupTitleDataTransfer;
	}

	public WebElement getGroupTitleExtensions() {
		return this.systemMenu.groupTitleExtensions;
	}

	public WebElement getGroupTitleTools() {
		return this.systemMenu.groupTitleTools;
	}

	public WebElement getGroupTitlePermissions() {
		return this.systemMenu.groupTitlePermissions;
	}

	public WebElement getGroupTitleOtherSettingsSystemMenu() {
		return this.systemMenu.groupTitleOtherSettings;
	}

	public WebElement getImportOne() {
		return this.systemMenu.importOne;
	}

	public WebElement getExport() {
		return this.systemMenu.export;
	}

	public WebElement getImportExportTaxRates() {
		return this.systemMenu.importExportTaxRates;
	}

	public WebElement getImportHistory() {
		return this.systemMenu.importHistory;
	}

	public WebElement getIntegrations() {
		return this.systemMenu.integrations;
	}

	public WebElement getCacheManagement() {
		return this.systemMenu.cacheManagement;
	}

	public WebElement getBackups() {
		return this.systemMenu.backups;
	}

	public WebElement getIndexManagement() {
		return this.systemMenu.indexManagement;
	}

	public WebElement getWebSetupWizard() {
		return this.systemMenu.webSetupWizard;
	}

	public WebElement getAllUsers() {
		return this.systemMenu.allUsers;
	}

	public WebElement getLockedUsers() {
		return this.systemMenu.lockedUsers;
	}

	public WebElement getUserRoles() {
		return this.systemMenu.userRoles;
	}

	public WebElement getNotifications() {
		return this.systemMenu.notifications;
	}

	public WebElement getCustomVariables() {
		return this.systemMenu.customVariables;
	}

	public WebElement getManageEncryptionKey() {
		return this.systemMenu.manageEncryptionKey;
	}

	public WebElement getCloseSystemMenu() {
		return this.systemMenu.close;
	}
	// Get Data Business Logic

	public String getDashboardText() {
		return getDashboard().getText();
	}

	public String getSalesText() {
		return getSales().getText();
	}

	public String getProductsText() {
		return getProducts().getText();
	}

	public String getCustomersText() {
		return getCustomers().getText();
	}

	public String getMarketingText() {
		return getMarketing().getText();
	}

	public String getContentText() {
		return getContent().getText();
	}

	public String getReportsText() {
		return getReports().getText();
	}

	public String getStoresText() {
		return getStores().getText();
	}

	public String getSystemText() {
		return getSystem().getText();
	}

	public String getPartnersAndExtensionsText() {
		return getPartnersAndExtensions().getText();
	}

	// set Data PageObject

	public void clickLogo() {
		getLogo().click();
	}

	public void clickDashboard() {
		getDashboard().click();
	}

	public void clickSales() {
		getSales().click();
		this.salesMenu = new SalesComponent();
	}

	public void clickProducts() {
		getProducts().click();
		this.productsMenu = new ProductsComponent();
	}

	public void clickCustomers() {
		getCustomers().click();
		this.customersMenu = new CustomersComponent();
	}

	public void clickMarketing() {
		getMarketing().click();
		this.marketingMenu = new MarketingComponent();
	}

	public void clickContent() {
		getContent().click();
		this.contentMenu = new ContentComponent();
	}

	public void clickReports() {
		getReports().click();
		this.reportsMenu = new ReportsComponent();
	}

	public void clickStores() {
		getStores().click();
		this.storesMenu = new StoresComponent();
	}

	public void clickSystem() {
		getSystem().click();
		this.systemMenu = new SystemComponent();
	}

	public void clickPartnersAndExtensions() {
		getPartnersAndExtensions().click();
	}

	public void clickOrdersSalesMenu() {
		getOrdersSalesMenu().click();
	}

	public void clickInvoices() {
		getInvoices().click();
	}

	public void clickShipments() {
		getShipments().click();
	}

	public void clickCreditMemos() {
		getCreditMemos().click();
	}

	public void clickBillingAgreements() {
		getBillingAgreements().click();
	}

	public void clickTransactions() {
		getTransactions().click();
	}

	public void clickCatalog() {
		getCatalog().click();
	}

	public void clickCategories() {
		getCategories().click();
	}

	public void clickAllCustomers() {
		getAllCustomers().click();
	}

	public void clickNowOnline() {
		getNowOnline().click();
	}

	public void clickCatalogPriceRule() {
		getCatalogPriceRule().click();
	}

	public void clickCartPriceRules() {
		getCartPriceRules().click();
	}

	public void clickEmailTemplates() {
		getEmailTemplates().click();
	}

	public void clickNewsletterTemplate() {
		getNewsletterTemplate().click();
	}

	public void clickNewsletterQueue() {
		getNewsletterQueue().click();
	}

	public void clickNewsletterSubcribers() {
		getNewsletterSubscribers().click();
	}

	public void clickURLRewrites() {
		getURLRewrites().click();
	}

	public void clickSearchTermsMarketingMenu() {
		getSearchTermsMarketingMenu().click();
	}

	public void clickSearchSynonyms() {
		getSearchSynonyms().click();
	}

	public void clickSiteMap() {
		getSiteMap().click();
	}

	public void clickReviews() {
		getReviews().click();
	}

	public void clickPages() {
		getPages().click();
	}

	public void clickBlocks() {
		getBlocks().click();
	}

	public void clickWidgets() {
		getWidgets().click();
	}

	public void clickConfigurationContentMenu() {
		getConfigurationContentMenu().click();
	}

	public void clickThemes() {
		getThemes().click();
	}

	public void clickSchedule() {
		getSchedule().click();
	}
}

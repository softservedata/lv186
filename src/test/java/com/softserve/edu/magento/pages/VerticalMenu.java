package com.softserve.edu.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
            this.title = driver.findElement(By.xpath("//strong[text()='Sales']"));
            this.groupTitle = driver.findElement(By.xpath("//span[text()='Operations']"));
            this.orders = driver.findElement(By.linkText("Orders"));
            this.invoices = driver.findElement(By.linkText("Invoices"));
            this.shipments = driver.findElement(By.linkText("Shipments"));
            this.creditMemos = driver.findElement(By.linkText("Credit Memos"));
            this.billingAgreements = driver.findElement(By.linkText("Billing Agreements"));
            this.transactions = driver.findElement(By.linkText("Transcations"));
            this.close = driver.findElement(By.cssSelector("#menu-magento-sales-sales > div > a"));
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
            this.title = driver.findElement(By.xpath("//strong[text()='Products']"));
            this.groupTitle = driver.findElement(By.xpath("//span[text()='Operations']"));
            this.catalog = driver.findElement(By.linkText("Catalog"));
            this.categories = driver.findElement(By.linkText("Categories"));
            this.close = driver.findElement(By.cssSelector("#menu-magento-catalog-catalog > div > a"));
        }

    }

    // ----------------------------

    private class CustomersComponent {
        public final WebElement title;
        public final WebElement allCustomers;
        public final WebElement nowOnline;
        public final WebElement close;

        public CustomersComponent() {
            this.title = driver.findElement(By.xpath("//strong[text()='Customers']"));
            this.allCustomers = driver.findElement(By.linkText("All Customers"));
            this.nowOnline = driver.findElement(By.linkText("Now Online"));
            this.close = driver.findElement(By.cssSelector("#menu-magento-customer-customer > div > a"));
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
            this.title = driver.findElement(By.xpath("//strong[text()='Marketing']"));
            this.groupTitlePromotions = driver.findElement(By.xpath("//strong[text()='Promotions']"));
            this.groupTitleCommunications = driver.findElement(By.xpath("//span[text()='Communications']"));
            this.groupTitleSEOAndSearch = driver.findElement(By.xpath("//span[text()='SEO & Search']"));
            this.groupTitleUserContent = driver.findElement(By.xpath("//span[text()='User Content']"));
            this.catalogPriceRule = driver.findElement(By.linkText("Catalog Price Rule"));
            this.cartPriceRules = driver.findElement(By.linkText("Cart Price Rules"));
            this.emailTemplates = driver.findElement(By.linkText("Email Templates"));
            this.newsletterTemplate = driver.findElement(By.linkText("Newsletter Template"));
            this.newsletterQueue = driver.findElement(By.linkText("Newsletter Queue"));
            this.newsletterSubscribers = driver.findElement(By.linkText("Newsletter Subscribers"));
            this.URLRewrites = driver.findElement(By.linkText("URL Rewrites"));
            this.searchTerms = driver.findElement(By.linkText("Search Terms"));
            this.searchSynonyms = driver.findElement(By.linkText("Search Synonyms"));
            this.siteMap = driver.findElement(By.linkText("Site Map"));
            this.reviews = driver.findElement(By.linkText("Reviews"));
            this.close = driver.findElement(By.cssSelector("#menu-magento-backend-marketing > div > a"));

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
            this.title = driver.findElement(By.xpath("//strong[text()='Content']"));
            this.groupTitleElements = driver.findElement(By.xpath("//strong[text()='Elements']"));
            this.groupTitleDesign = driver.findElement(By.xpath("//span[text()='Design']"));
            this.pages = driver.findElement(By.linkText("Pages"));
            this.blocks = driver.findElement(By.linkText("Blocks"));
            this.widgets = driver.findElement(By.linkText("Widgets"));
            this.configuration = driver.findElement(By.linkText("Configuration"));
            this.themes = driver.findElement(By.linkText("Themes"));
            this.schedule = driver.findElement(By.linkText("Schedule"));
            this.close = driver.findElement(By.cssSelector("#menu-magento-backend-content > div > a"));
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
            this.title = driver.findElement(By.xpath("//strong[text()='Reports']"));
            this.groupTitleMarketing = driver.findElement(By.xpath("//strong[text()='Marketing']"));
            this.groupTitleSales = driver.findElement(By.xpath("//span[text()='Sales']"));
            this.groupTitleReviews = driver.findElement(By.xpath("//strong[text()='Reviews']"));
            this.groupTitleCustomers = driver.findElement(By.xpath("//span[text()='Customers']"));
            this.groupTitleProducts = driver.findElement(By.xpath("//strong[text()='Products']"));
            this.groupTitleStatistics = driver.findElement(By.xpath("//span[text()='Statistics']"));
            this.productsInCart = driver.findElement(By.linkText("Products in Cart"));
            this.searchTerms = driver.findElement(By.linkText("Search Terms"));
            this.abandonedCarts = driver.findElement(By.linkText("Abandoned Carts"));
            this.newsletterProblemReports = driver.findElement(By.linkText("Newsletter Problem Reports"));
            this.byCustomers = driver.findElement(By.linkText("By Customers"));
            this.byProducts = driver.findElement(By.linkText("By Products"));
            this.orders = driver.findElement(By.linkText("Orders"));
            this.tax = driver.findElement(By.linkText("Pages"));
            this.invoiced = driver.findElement(By.linkText("Invoiced"));
            this.shipping = driver.findElement(By.linkText("Shipping"));
            this.refunds = driver.findElement(By.linkText("Refunds"));
            this.coupons = driver.findElement(By.linkText("Coupons"));
            this.payPalSettlement = driver.findElement(By.linkText("PayPal Settlement"));
            this.braintreeSettlement = driver.findElement(By.linkText("Braintree Settlement"));
            this.orderTotal = driver.findElement(By.linkText("Order Total"));
            this.orderCount = driver.findElement(By.linkText("Order Count"));
            this.newOne = driver.findElement(By.linkText("New"));
            this.views = driver.findElement(By.linkText("Views"));
            this.bestsellers = driver.findElement(By.linkText("Pages"));
            this.lowStock = driver.findElement(By.linkText("Low Stock"));
            this.ordered = driver.findElement(By.linkText("Ordered"));
            this.downloads = driver.findElement(By.linkText("Downloads"));
            this.refreshStatistics = driver.findElement(By.linkText("Refresh Statistics"));
            this.close = driver.findElement(By.cssSelector("#menu-magento-reports-report > div > a"));
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
            this.title = driver.findElement(By.xpath("//strong[text()='Reports']"));
            this.groupTitleSettings = driver.findElement(By.xpath("//strong[text()='Settings']"));
            this.groupTitleAttributes = driver.findElement(By.xpath("//span[text()='Attributes']"));
            this.groupTitleTaxes = driver.findElement(By.xpath("//strong[text()='Taxes']"));
            this.groupTitleCurrency = driver.findElement(By.xpath("//span[text()='Currency']"));
            this.groupTitleOtherSettings = driver.findElement(By.xpath("//strong[text()='Other Settings']"));
            this.allStores = driver.findElement(By.linkText("All Stores"));
            this.configuration = driver.findElement(By.linkText("Configuration"));
            this.termsAndConditions = driver.findElement(By.linkText("Terms and Conditions"));
            this.orderStatus = driver.findElement(By.linkText("Order Status"));
            this.taxRules = driver.findElement(By.linkText("Tax Rules"));
            this.taxZonesAndRates = driver.findElement(By.linkText("Tax Zones and Rates"));
            this.currencyRates = driver.findElement(By.linkText("Currency Rates"));
            this.currencySymbols = driver.findElement(By.linkText("Currency Symbols"));
            this.product = driver.findElement(By.linkText("Product"));
            this.attributeSet = driver.findElement(By.linkText("Attribute Set"));
            this.rating = driver.findElement(By.linkText("Rating"));
            this.customerGroups = driver.findElement(By.linkText("Customer Groups"));
            this.close = driver.findElement(By.cssSelector("#menu-magento-backend-stores > div > a"));
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
            this.title = driver.findElement(By.xpath("//strong[text()='System']"));
            this.groupTitleDataTransfer = driver.findElement(By.xpath("//strong[text()='Data Transfer']"));
            this.groupTitleExtensions = driver.findElement(By.xpath("//span[text()='Extensions']"));
            this.groupTitleTools = driver.findElement(By.xpath("//strong[text()='Tools']"));
            this.groupTitlePermissions = driver.findElement(By.xpath("//span[text()='Permissions']"));
            this.groupTitleOtherSettings = driver.findElement(By.xpath("//strong[text()='Other Settings']"));
            this.importOne = driver.findElement(By.linkText("Import"));
            this.export = driver.findElement(By.linkText("Export"));
            this.importExportTaxRates = driver.findElement(By.linkText("Import/Export Tax Rates"));
            this.importHistory = driver.findElement(By.linkText("Import History"));
            this.integrations = driver.findElement(By.linkText("Integrations"));
            this.cacheManagement = driver.findElement(By.linkText("Cache Management"));
            this.backups = driver.findElement(By.linkText("Backups"));
            this.indexManagement = driver.findElement(By.linkText("Index Management"));
            this.webSetupWizard = driver.findElement(By.linkText("Web Setup Wizard"));
            this.allUsers = driver.findElement(By.linkText("All Users"));
            this.lockedUsers = driver.findElement(By.linkText("Locked Users"));
            this.userRoles = driver.findElement(By.linkText("User Roles"));
            this.notifications = driver.findElement(By.linkText("Notifications"));
            this.customVariables = driver.findElement(By.linkText("Custom Variables"));
            this.manageEncryptionKey = driver.findElement(By.linkText("Manage Encryption Key"));
            this.close = driver.findElement(By.cssSelector("#menu-magento-backend-system > div > a"));
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

    protected VerticalMenu(WebDriver driver) {
        super(driver);
        this.logo = driver.findElement(By.cssSelector(".logo-img"));
        this.dashboard = driver.findElement(By.xpath("//*[@id='menu-magento-backend-dashboard']/a"));
        this.sales = driver.findElement(By.xpath("//*[@id='menu-magento-sales-sales']/a"));
        this.products = driver.findElement(By.xpath("//*[@id='menu-magento-catalog-catalog']/a"));
        this.customers = driver.findElement(By.xpath("//*[@id='menu-magento-customer-customer']/a"));
        this.marketing = driver.findElement(By.xpath("//*[@id='menu-magento-backend-marketing']/a"));
        this.content = driver.findElement(By.xpath("//*[@id='menu-magento-backend-content']/a"));
        this.reports = driver.findElement(By.xpath("//*[@id='menu-magento-reports-report']/a"));
        this.stores = driver.findElement(By.xpath("//*[@id='menu-magento-backend-stores']/a"));
        this.system = driver.findElement(By.xpath("//*[@id='menu-magento-backend-system']/a"));
        this.findPartners = driver.findElement(By.xpath("//*[@id='menu-magento-marketplace-partners']/a"));

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

    public WebElement getFindPartners() {
        return this.findPartners;
    }

    // -----------------Sales---------------
    
    public WebElement getTitleSalesMenu() {
        clickSales();
        return this.salesMenu.title;
    }

    public WebElement getGroupTitleSalesMenu() {
        clickSales();
        return this.salesMenu.groupTitle;
    }

    public WebElement getOrdersSalesMenu() {
        clickSales();
        return this.salesMenu.orders;
    }

    public WebElement getInvoices() {
        clickSales();
        return this.salesMenu.invoices;
    }

    public WebElement getShipments() {
        clickSales();
        return this.salesMenu.shipments;
    }

    public WebElement getCreditMemos() {
        clickSales();
        return this.salesMenu.creditMemos;
    }

    public WebElement getBillingAgreements() {
        clickSales();
        return this.salesMenu.billingAgreements;
    }

    public WebElement getTransactions() {
        clickSales();
        return this.salesMenu.transactions;
    }

    public WebElement getCloseSalesMenu() {
        clickSales();
        return this.salesMenu.close;
    }

    // -----------------Products---------------

    public WebElement getTitleProductMenu() {
        clickProducts();
        return this.productsMenu.title;
    }

    public WebElement getGroupTitleProductMenu() {
        clickProducts();
        return this.productsMenu.groupTitle;
    }

    public WebElement getCatalog() {
        clickProducts();
        return this.productsMenu.catalog;
    }

    public WebElement getCategories() {
        clickProducts();
        return this.productsMenu.categories;
    }

    public WebElement getCloseProductMenu() {
        clickProducts();
        return this.productsMenu.close;
    }

    // -----------------Customers---------------

    public WebElement getTitleCustomersMenu() {
        // TODO
        return this.customersMenu.title;
    }

    public WebElement getAllCustomers() {
        // TODO
        return this.customersMenu.allCustomers;
    }

    public WebElement getNowOnline() {
        // TODO
        return this.customersMenu.nowOnline;
    }

    public WebElement getCloseCustomersMenu() {
        // TODO
        return this.customersMenu.close;
    }

    // -----------------Marketing---------------

    public WebElement getTitleMarketingMenu() {
        // TODO
        return this.marketingMenu.title;
    }

    public WebElement getGroupTitlePromotions() {
        // TODO
        return this.marketingMenu.groupTitlePromotions;
    }

    public WebElement getGroupTitleCommunications() {
        // TODO
        return this.marketingMenu.groupTitleCommunications;
    }

    public WebElement getGroupTitleSEOAndSearch() {
        // TODO
        return this.marketingMenu.groupTitleSEOAndSearch;
    }

    public WebElement getGroupTitleUserContent() {
        // TODO
        return this.marketingMenu.groupTitleUserContent;
    }

    public WebElement getCatalogPriceRule() {
        // TODO
        return this.marketingMenu.catalogPriceRule;
    }

    public WebElement getCartPriceRules() {
        // TODO
        return this.marketingMenu.cartPriceRules;
    }

    public WebElement getEmailTemplates() {
        // TODO
        return this.marketingMenu.emailTemplates;
    }

    public WebElement getNewsletterTemplate() {
        // TODO
        return this.marketingMenu.newsletterTemplate;
    }

    public WebElement getNewsletterQueue() {
        // TODO
        return this.marketingMenu.newsletterQueue;
    }

    public WebElement getNewsletterSubscribers() {
        // TODO
        return this.marketingMenu.newsletterSubscribers;
    }

    public WebElement getURLRewrites() {
        // TODO
        return this.marketingMenu.URLRewrites;
    }

    public WebElement getSearchTermsMarketingMenu() {
        // TODO
        return this.marketingMenu.searchTerms;
    }

    public WebElement getSearchSynonyms() {
        // TODO
        return this.marketingMenu.searchSynonyms;
    }

    public WebElement getSiteMap() {
        // TODO
        return this.marketingMenu.siteMap;
    }

    public WebElement getReviews() {
        // TODO
        return this.marketingMenu.reviews;
    }

    public WebElement getCloseMarketingMenu() {
        // TODO
        return this.marketingMenu.close;
    }

    // -----------------Content---------------

    public WebElement getTitleContentMenu() {
        // TODO
        return this.contentMenu.title;
    }

    public WebElement getGroupTitleElements() {
        // TODO
        return this.contentMenu.groupTitleElements;
    }

    public WebElement getGroupTitleDesign() {
        // TODO
        return this.contentMenu.groupTitleDesign;
    }

    public WebElement getPages() {
        // TODO
        return this.contentMenu.pages;
    }

    public WebElement getBlocks() {
        // TODO
        return this.contentMenu.blocks;
    }

    public WebElement getWidgets() {
        // TODO
        return this.contentMenu.widgets;
    }

    public WebElement getConfigurationContentMenu() {
        // TODO
        return this.contentMenu.configuration;
    }

    public WebElement getThemes() {
        // TODO
        return this.contentMenu.themes;
    }

    public WebElement getSchedule() {
        // TODO
        return this.contentMenu.schedule;
    }

    public WebElement getCloseContentMenu() {
        // TODO
        return this.contentMenu.close;
    }

    // -----------------Reports---------------

    public WebElement getTitleReportsMenu() {
        // TODO
        return this.reportsMenu.title;
    }

    public WebElement getGroupTitleMarketing() {
        // TODO
        return this.reportsMenu.groupTitleMarketing;
    }

    public WebElement getGroupTitleSales() {
        // TODO
        return this.reportsMenu.groupTitleSales;
    }

    public WebElement getGroupTitleReviews() {
        // TODO
        return this.reportsMenu.groupTitleReviews;
    }

    public WebElement getGroupTitleCustomers() {
        // TODO
        return this.reportsMenu.groupTitleCustomers;
    }

    public WebElement getGroupTitleProducts() {
        // TODO
        return this.reportsMenu.groupTitleProducts;
    }

    public WebElement getGroupTitleStatistics() {
        // TODO
        return this.reportsMenu.groupTitleStatistics;
    }

    public WebElement getProductsInCart() {
        // TODO
        return this.reportsMenu.productsInCart;
    }

    public WebElement getSearchTermsReportsMenu() {
        // TODO
        return this.reportsMenu.searchTerms;
    }

    public WebElement getAbandonedCarts() {
        // TODO
        return this.reportsMenu.abandonedCarts;
    }

    public WebElement getNewsletterProblemReports() {
        // TODO
        return this.reportsMenu.newsletterProblemReports;
    }

    public WebElement getByCustomers() {
        // TODO
        return this.reportsMenu.byCustomers;
    }

    public WebElement getByProducts() {
        // TODO
        return this.reportsMenu.byProducts;
    }

    public WebElement getOrdersReportsMenu() {
        // TODO
        return this.reportsMenu.orders;
    }

    public WebElement getTax() {
        // TODO
        return this.reportsMenu.tax;
    }

    public WebElement getInvoiced() {
        // TODO
        return this.reportsMenu.invoiced;
    }

    public WebElement getShipping() {
        // TODO
        return this.reportsMenu.shipping;
    }

    public WebElement getRefunds() {
        // TODO
        return this.reportsMenu.refunds;
    }

    public WebElement getCoupons() {
        // TODO
        return this.reportsMenu.coupons;
    }

    public WebElement getPayPalSettlement() {
        // TODO
        return this.reportsMenu.payPalSettlement;
    }

    public WebElement getBraintreeSettlement() {
        // TODO
        return this.reportsMenu.braintreeSettlement;
    }

    public WebElement getOrderTotal() {
        // TODO
        return this.reportsMenu.orderTotal;
    }

    public WebElement getOrderCount() {
        // TODO
        return this.reportsMenu.orderCount;
    }

    public WebElement getNewOne() {
        // TODO
        return this.reportsMenu.newOne;
    }

    public WebElement getViews() {
        // TODO
        return this.reportsMenu.views;
    }

    public WebElement getBestsellers() {
        // TODO
        return this.reportsMenu.bestsellers;
    }

    public WebElement getLowStock() {
        // TODO
        return this.reportsMenu.lowStock;
    }

    public WebElement getOrdered() {
        // TODO
        return this.reportsMenu.ordered;
    }

    public WebElement getDownloads() {
        // TODO
        return this.reportsMenu.downloads;
    }

    public WebElement getRefreshStatistics() {
        // TODO
        return this.reportsMenu.refreshStatistics;
    }

    public WebElement getCloseReportsMenu() {
        // TODO
        return this.reportsMenu.close;
    }

    // -----------------Stores---------------

    public WebElement getTitleStoresMenu() {
        // TODO
        return this.storesMenu.title;
    }

    public WebElement getGroupTitleSettings() {
        // TODO
        return this.storesMenu.groupTitleSettings;
    }

    public WebElement getGroupTitleAttributes() {
        // TODO
        return this.storesMenu.groupTitleAttributes;
    }

    public WebElement getGroupTitleTaxes() {
        // TODO
        return this.storesMenu.groupTitleTaxes;
    }

    public WebElement getGroupTitleCurrency() {
        // TODO
        return this.storesMenu.groupTitleCurrency;
    }

    public WebElement getGroupTitleOtherSettingsStoresMenu() {
        // TODO
        return this.storesMenu.groupTitleOtherSettings;
    }

    public WebElement getAllStores() {
        // TODO
        return this.storesMenu.allStores;
    }

    public WebElement getConfigurationStoresMenu() {
        // TODO
        return this.storesMenu.configuration;
    }

    public WebElement getTermsAndConditions() {
        // TODO
        return this.storesMenu.termsAndConditions;
    }

    public WebElement getOrderStatus() {
        // TODO
        return this.storesMenu.orderStatus;
    }

    public WebElement getTaxRules() {
        // TODO
        return this.storesMenu.taxRules;
    }

    public WebElement getTaxZonesAndRates() {
        // TODO
        return this.storesMenu.taxZonesAndRates;
    }

    public WebElement getCurrencyRates() {
        // TODO
        return this.storesMenu.currencyRates;
    }

    public WebElement getCurrencySymbols() {
        // TODO
        return this.storesMenu.currencySymbols;
    }

    public WebElement getProduct() {
        // TODO
        return this.storesMenu.product;
    }

    public WebElement getAttributeSet() {
        // TODO
        return this.storesMenu.attributeSet;
    }

    public WebElement getRating() {
        // TODO
        return this.storesMenu.rating;
    }

    public WebElement getCustomerGroups() {
        // TODO
        return this.storesMenu.customerGroups;
    }

    public WebElement getCloseStoresMenu() {
        // TODO
        return this.storesMenu.close;
    }

    // -----------------System---------------

    public WebElement getTitleSystemMenu() {
        // TODO
        return this.systemMenu.title;
    }

    public WebElement getGroupTitleDataTransfer() {
        // TODO
        return this.systemMenu.groupTitleDataTransfer;
    }

    public WebElement getGroupTitleExtensions() {
        // TODO
        return this.systemMenu.groupTitleExtensions;
    }

    public WebElement getGroupTitleTools() {
        // TODO
        return this.systemMenu.groupTitleTools;
    }

    public WebElement getGroupTitlePermissions() {
        // TODO
        return this.systemMenu.groupTitlePermissions;
    }

    public WebElement getGroupTitleOtherSettingsSystemMenu() {
        // TODO
        return this.systemMenu.groupTitleOtherSettings;
    }

    public WebElement getImportOne() {
        // TODO
        return this.systemMenu.importOne;
    }

    public WebElement getExport() {
        // TODO
        return this.systemMenu.export;
    }

    public WebElement getImportExportTaxRates() {
        // TODO
        return this.systemMenu.importExportTaxRates;
    }

    public WebElement getImportHistory() {
        // TODO
        return this.systemMenu.importHistory;
    }

    public WebElement getIntegrations() {
        // TODO
        return this.systemMenu.integrations;
    }

    public WebElement getCacheManagement() {
        // TODO
        return this.systemMenu.cacheManagement;
    }

    public WebElement getBackups() {
        // TODO
        return this.systemMenu.backups;
    }

    public WebElement getIndexManagement() {
        // TODO
        return this.systemMenu.indexManagement;
    }

    public WebElement getWebSetupWizard() {
        // TODO
        return this.systemMenu.webSetupWizard;
    }

    public WebElement getAllUsers() {
        // TODO
        return this.systemMenu.allUsers;
    }

    public WebElement getLockedUsers() {
        // TODO
        return this.systemMenu.lockedUsers;
    }

    public WebElement getUserRoles() {
        // TODO
        return this.systemMenu.userRoles;
    }

    public WebElement getNotifications() {
        // TODO
        return this.systemMenu.notifications;
    }

    public WebElement getCustomVariables() {
        // TODO
        return this.systemMenu.customVariables;
    }

    public WebElement getManageEncryptionKey() {
        // TODO
        return this.systemMenu.manageEncryptionKey;
    }

    public WebElement getCloseSystemMenu() {
        // TODO Create inner class
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

    public String getFindPartnersText() {
        return getFindPartners().getText();
    }

    // set Data PageObject

    public void clickLogo() {
        // Goto Dashboard Page
        getLogo().click();
    }

    public void clickDashboard() {
        // Goto Dashboard Page
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

    public void clickFindPartners() {
        getFindPartners().click();
    }

    // -----------------Sales---------------
    
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

    // -----------------Products---------------

    public void clickCatalog() {
        getCatalog().click();
    }

    public void clickCategories() {
        getCategories().click();
    }

    // -----------------Customers---------------
    
    public void clickAllCustomers() {
        getAllCustomers().click();
    }

    public void clickNowOnline() {
        getNowOnline().click();
    }

    // -----------------Marketing---------------
    
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

    // -----------------Content---------------
    
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

    // -----------------Reports---------------

    public void clickProductsInCart() {
        getProductsInCart().click();
    }

    public void clickSearchTermsReportsMenu() {
        getSearchTermsMarketingMenu().click();
    }

    public void clickAbandonedCarts() {
        getAbandonedCarts().click();
    }

    public void clickNewsletterProblemReports() {
        getNewsletterProblemReports().click();
    }

    public void clickByCustomers() {
        getByCustomers().click();
    }

    public void clickByProducts() {
        getByProducts().click();
    }

    public void clickOrdersReportsMenu() {
        getOrdersReportsMenu().click();
    }

    public void clickTax() {
        getTax().click();
    }

    public void clickInvoiced() {
        getInvoiced().click();
    }

    public void clickShipping() {
        getShipping().click();
    }

    public void clickRefunds() {
        getRefunds().click();
    }

    public void clickCoupons() {
        getCoupons().click();
    }

    public void clickPayPalSettlement() {
        getPayPalSettlement().click();
    }

    public void clickBraintreeSettlement() {
        getBraintreeSettlement().click();
    }

    public void clickOrderTotal() {
        getOrderTotal().click();
    }

    public void clickOrderCount() {
        getOrderCount().click();
    }

    public void clickNew() {
        getNewOne().click();
    }

    public void clickViews() {
        getViews().click();
    }

    public void clickBestsellers() {
        getBestsellers().click();
    }

    public void clickLowStock() {
        getLowStock().click();
    }

    public void clickOrdered() {
        getOrdered().click();
    }

    public void clickDownloads() {
        getDownloads().click();
    }

    public void clickRefreshStatistics() {
        getRefreshStatistics().click();
    }

    // -----------------Stores---------------
    
    public void clickAllStores() {
        getAllStores().click();
    }

    public void clickConfigurationStoresMenu() {
        getConfigurationStoresMenu().click();
    }

    public void clickTermsAndConditions() {
        getTermsAndConditions().click();
    }

    public void clickOrderStatus() {
        getOrderStatus().click();
    }

    public void clickTaxRules() {
        getTaxRules().click();
    }

    public void clickTaxZonesAndRates() {
        getTaxZonesAndRates().click();
    }

    public void clickCurrencyRates() {
        getCurrencyRates().click();
    }

    public void clickCurrencySymbols() {
        getCurrencySymbols().click();
    }

    public void clickProduct() {
        getProduct().click();
    }

    public void clickAttributeSet() {
        getAttributeSet().click();
    }

    public void clickRating() {
        getRating().click();
    }

    public void clickCustomerGroups() {
        getCustomerGroups().click();
    }

    // -----------------System---------------

    public void clickImport() {
        getImportOne().click();
    }

    public void clickExport() {
        getExport().click();
    }

    public void clickImportExportTaxRates() {
        getImportExportTaxRates().click();
    }

    public void clickImportHistory() {
        getImportHistory().click();
    }

    public void clickIntegrations() {
        getIntegrations().click();
    }

    public void clickCacheManagement() {
        getCacheManagement().click();
    }

    public void clickBackups() {
        getBackups().click();
    }

    public void clickIndexManagement() {
        getIndexManagement().click();
    }

    public void clickWebSetupWizard() {
        getWebSetupWizard().click();
    }

    public void clickAllUsers() {
        getAllUsers().click();
    }

    public void clickLockedUsers() {
        getLockedUsers().click();
    }

    public void clickUserRoles() {
        getUserRoles().click();
    }

    public void clickNotifications() {
        getNotifications().click();
    }

    public void clickCustomVariables() {
        getCustomVariables().click();
    }

    public void clickManageEncryptionKey() {
        getManageEncryptionKey().click();
    }

    // Business Logic

    public DashboardPage gotoHomePage() {
        clickLogo();
        // Return a new page object representing the destination.
        return new DashboardPage(driver);
    }

    public DashboardPage gotoDashboardPage() {
        clickDashboard();
        // Return a new page object representing the destination.
        return new DashboardPage(driver);
    }

    // -----------------Sales---------------

    // -----------------Products---------------

    public CatalogPage gotoCatalogPage() {
        clickCatalog();
        return new CatalogPage(driver);
    }

    // -----------------Customers---------------


    // -----------------Marketing---------------


    // -----------------Content---------------


    // -----------------Reports---------------


    // -----------------Stores---------------


    // -----------------System---------------
   
}

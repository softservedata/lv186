package com.softserve.edu.magento.pages.admin.menu.products.categories;

import org.apache.log4j.lf5.viewer.categoryexplorer.CategoryPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.softserve.edu.magento.pages.admin.AdminLoginPage;
import com.softserve.edu.magento.pages.admin.VerticalMenu;

public class CategoriesPage extends VerticalMenu{


    //------------ Privates Classes --------------

    private class ContentComponent{
        public WebElement upload;
        public Description description;
        public WebElement wysiwygEditor;
        public WebElement cmsBlock;

        public ContentComponent(){
            this.upload = driver.findElement(By.xpath("//input[@name='image']"));
            this.description = new Description();
            this.wysiwygEditor = driver.findElement(By.xpath("//button[@title='WYSIWYG Editor']"));
            this.cmsBlock = driver.findElement(By.xpath("//select[@class='admin__control-select' and @name='landing_page']"));
        }



    }
    private class Description{}
    private class DisplaySettingsComponent {}
    private class SearchEngineOptimizationComponent {}
    private class ProductsInCategoryComponent {}
    private class DesignComponent {}
    private class ScheduleDesignUpdateComponent {}
    private class CategoryTree{
        public WebElement collapseAll;
        public WebElement expandAll;
        public WebElement tree;

        public CategoryTree(){
            this.collapseAll = driver.findElement(By.xpath("//a[text()='Collapse All']"));
            this.expandAll = driver.findElement(By.xpath("//a[text()='Expand All']"));
            this.tree = driver.findElement(By.id("tree-div"));
        }

        private boolean checkCategoryByName(String name){
            String path = "//li[@class='x-tree-node']//*[contains( text(),'" + name + "')]";
            if(!driver.findElements(By.xpath(path)).isEmpty()){
                return true;
            }
            return false;
        }

        public WebElement findCategoryByName(String name){
            String path = "//li[@class='x-tree-node']//*[contains( text(),'" + name + "')]";
            if(checkCategoryByName(name)){
                return driver.findElement(By.xpath(path));
            }
            return null;
        }
    }

    //------------ Elements ----------------------

    private WebElement title;
    private WebElement save;
    private WebElement addRootCategory;
    private WebElement addSubcategory;
    private WebElement enabledCategory;
    private WebElement includeInMenu;
    private WebElement categoryName;
    private WebElement content;
    private WebElement displaySettings ;
    private WebElement searchEngineOptimization;
    private WebElement productsInCategory ;
    private WebElement design;
    private WebElement scheduleDesignUpdate ;
    private WebElement delete;
    private WebElement message;

    //------------ Components --------------------

    private CategoryTree treeComponent;
    private ContentComponent contentComponent;
    private DisplaySettingsComponent displaysettingsComponent;
    private SearchEngineOptimizationComponent searchEngineOptimizationComponent;
    private ProductsInCategoryComponent productsInCategoryComponent;
    private DesignComponent designComponent;
    private ScheduleDesignUpdateComponent scheduleDesignUpdateComponent;


    public CategoriesPage(WebDriver driver){
        super(driver);
        this.title = driver.findElement(By.xpath("//h1[@class='page-title']"));
        this.save = driver.findElement(By.id("save"));
        this.addRootCategory = driver.findElement(By.id("add_root_category_button"));
        this.addSubcategory = driver.findElement(By.id("add_subcategory_button"));
        this.treeComponent = new CategoryTree();
        this.enabledCategory = driver.findElement(By.xpath("//input[@type='checkbox' and @name='is_active']"));
        this.includeInMenu = driver.findElement(By.xpath("//input[@type='checkbox' and @name='include_in_menu']"));
        this.categoryName = driver.findElement(By.xpath("//input[@type='text' and @name='name' and @class='admin__control-text']"));
        this.content = driver.findElement(By.xpath("//div[@class='fieldset-wrapper-title']//span[contains(text(),'Content')]/../.."));
        this.displaySettings = driver.findElement(By.xpath("//div[@class='fieldset-wrapper-title']//span[contains(text(),'Display Settings')]/../.."));
        this.searchEngineOptimization = driver.findElement(By.xpath("//div[@class='fieldset-wrapper-title']//span[contains(text(),'Search Engine Optimization')]/../.."));
        this.productsInCategory = driver.findElement(By.xpath("//div[@class='fieldset-wrapper-title']//span[contains(text(),'Products in Category')]/../.."));
        this.design = driver.findElement(By.xpath("//div[@class='fieldset-wrapper-title']//span[contains(text(),'Design')]/../.."));
        this.scheduleDesignUpdate = driver.findElement(By.xpath("//div[@class='fieldset-wrapper-title']//span[contains(text(),'Schedule Design Update')]/../.."));
        this.delete = null;
        this.message = null;

    }


    // Page Object
    //------------ Get Data PageObject -----------

    public CategoriesPage refresh(){
        return new CategoriesPage(driver);
    }

    public WebElement getTitle() {
        return title;
    }

    public WebElement getSave() {
        return save;
    }

    public WebElement getAddRootCategory() {
        return addRootCategory;
    }

    public WebElement getAddSubcategory() {
        return addSubcategory;
    }

    public WebElement getEnabledCategory() {
        return enabledCategory;
    }

    public WebElement getIncludeInMenu() {
        return includeInMenu;
    }

    public WebElement getCategoryName() {
        return categoryName;
    }

    public WebElement getContent() {
        return content;
    }

    public WebElement getDisplaySettings() {
        return displaySettings;
    }

    public WebElement getSearchEngineOptimization() {
        return searchEngineOptimization;
    }

    public WebElement getProductsInCategory() {
        return productsInCategory;
    }

    public WebElement getDesign() {
        return design;
    }

    public WebElement getScheduleDesignUpdate() {
        return scheduleDesignUpdate;
    }

    public WebElement getDelete() {
        return delete;
    }

    public WebElement getMessage() {
        return message;
    }

    //------------ Get Data Business Logic -----------------

    public String getTitleText() {
        return title.getText();
    }

    public String getSaveText() {
        return save.getText();
    }

    public String getAddRootCategoryText() {
        return addRootCategory.getText();
    }

    public String getAddSubcategoryText() {
        return addSubcategory.getText();
    }

    public String getEnabledCategoryText() {
        return enabledCategory.getText();
    }

    public String getIncludeInMenuText() {
        return includeInMenu.getText();
    }

    public String getCategoryNameText() {
        return categoryName.getText();
    }

    public String getContentText() {
        return content.getText();
    }

    public String getDisplaySettingsText() {
        return displaySettings.getText();
    }

    public String getSearchEngineOptimizationText() {
        return searchEngineOptimization.getText();
    }

    public String getProductsInCategoryText() {
        return productsInCategory.getText();
    }

    public String getDesignText() {
        return design.getText();
    }

    public String getScheduleDesignUpdateText() {
        return scheduleDesignUpdate.getText();
    }

    public String getDeleteText() {
        return delete.getText();
    }

    public String getMessageText() {
        return getMessage().getText();
    }

    //------------ Set Data PageObject -----------------

    public void clickSave(){
        getSave().click();
    }

    public void clickAddRootCategory() {
        getAddRootCategory().click();
    }

    public void clickAddSubcategory() {
        getAddSubcategory().click();
    }

    public void clickEnabledCategory() {
        getEnabledCategory().click();
    }

    public void clickIncludeInMenu() {
        getIncludeInMenu().click();
    }

    public void clickCategoryName() {
        getCategoryName().click();
    }

    public void clickContent() {
        getContent().click();
        this.contentComponent = new ContentComponent();
    }

    public void clickDisplaySettings() {
        getDisplaySettings().click();
        new DisplaySettingsComponent();
    }

    public void clickSearchEngineOptimization() {
        getSearchEngineOptimization().click();
        new SearchEngineOptimizationComponent();
    }

    public void clickProductsInCategory() {
        getProductsInCategory().click();
        new ProductsInCategoryComponent();
    }

    public void clickDesign() {
        getDesign().click();
        new DesignComponent();
    }

    public void clickScheduleDesignUpdate() {
        getScheduleDesignUpdate().click();
        new ScheduleDesignUpdateComponent();
    }

    public void clickDelete() {
        driver.findElement(By.id("delete")).click();
        //getDelete().click();
    }

    public void clickOkButton(){
        driver.findElement(By.xpath("//button[@class='action-primary action-accept']")).click();
    }


    //------------------ Content Component --------------

    public WebElement getUpload() {
        return contentComponent.upload;
    }

    public Description getDescription() {
        return contentComponent.description;
    }

    public WebElement getWysiwygEditor() {
        return contentComponent.wysiwygEditor;
    }

    public WebElement getCmsBlock() {
        return contentComponent.cmsBlock;
    }

    public void clickUpload() {
        getUpload().click();
    }

    public void clickWysiwygEditor() {
        getWysiwygEditor().click();
    }

    public void clickCmsBlock() {
        getCmsBlock().click();
    }

    //------------------ Business Logic -----------------

    public void setCategoryName (String name){
        getCategoryName().click();
        getCategoryName().sendKeys(name);
    }

    public void saveCategory(){
        this.clickSave();
    }

    public void selectImageFile(String path){
        this.getUpload().sendKeys(path);
    }

    public boolean checkCategoryByName (String name){
        return treeComponent.checkCategoryByName(name);
    }

    public WebElement findCategoryByName (String name){
        if (checkCategoryByName(name)){
            return treeComponent.findCategoryByName(name);
        }
        return null;
    }
    public void selectCategory (String name){
        if (checkCategoryByName(name)){
            treeComponent.findCategoryByName(name).click();
            this.delete = driver.findElement(By.id("delete"));
        }

    }

    public AdminLoginPage logout(){
        clickAccountMenu();
        clickSignOut();
        return new AdminLoginPage(driver);
    }

    public void clickAccountMenu(){
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
    }

    public void clickSignOut(){
        driver.findElement(By.xpath("//a[@class='account-signout']")).click();
    }



}
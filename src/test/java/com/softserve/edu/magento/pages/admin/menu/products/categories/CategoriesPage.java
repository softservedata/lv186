package com.softserve.edu.magento.pages.admin.menu.products.categories;

import com.softserve.edu.magento.tools.Search;

import org.openqa.selenium.WebElement;

import com.softserve.edu.magento.pages.admin.VerticalMenu;

public class CategoriesPage extends VerticalMenu{


    //------------ Privates Classes --------------

    private class ContentComponent{
        public WebElement upload;
        public Description description;
        public WebElement wysiwygEditor;
        public WebElement cmsBlock;

        public ContentComponent(){
            this.upload = Search.xpath("//input[@name='image']");
            this.description = new Description();
            this.wysiwygEditor = Search.xpath("//button[@title='WYSIWYG Editor']");
            this.cmsBlock = Search.xpath("//select[@class='admin__control-select' and @name='landing_page']");
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
            this.collapseAll = Search.xpath("//a[text()='Collapse All']");
            this.expandAll = Search.xpath("//a[text()='Expand All']");
            this.tree = Search.id("tree-div");
        }

        private boolean checkCategoryByName(String name){
            String path = "//li[@class='x-tree-node']//*[contains( text(),'" + name + "')]";
            if(!Search.xpaths(path).isEmpty()){
                return true;
            }
            return false;
        }

        public WebElement findCategoryByName(String name){
            String path = "//li[@class='x-tree-node']//*[contains( text(),'" + name + "')]";
            if(checkCategoryByName(name)){
                return Search.xpath(path);
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


    public CategoriesPage(){
        this.title = Search.xpath("//h1[@class='page-title']");
        this.save = Search.id("save");
        this.addRootCategory = Search.id("add_root_category_button");
        this.addSubcategory = Search.id("add_subcategory_button");
        this.treeComponent = new CategoryTree();
        this.enabledCategory = Search.xpath("//input[@type='checkbox' and @name='is_active']");
        this.includeInMenu = Search.xpath("//input[@type='checkbox' and @name='include_in_menu']");
        this.categoryName = Search.xpath("//input[@type='text' and @name='name' and @class='admin__control-text']");
        this.content = Search.xpath("//div[@class='fieldset-wrapper-title']//span[contains(text(),'Content')]/../..");
        this.displaySettings = Search.xpath("//div[@class='fieldset-wrapper-title']//span[contains(text(),'Display Settings')]/../..");
        this.searchEngineOptimization = Search.xpath("//div[@class='fieldset-wrapper-title']//span[contains(text(),'Search Engine Optimization')]/../..");
        this.productsInCategory = Search.xpath("//div[@class='fieldset-wrapper-title']//span[contains(text(),'Products in Category')]/../..");
        this.design = Search.xpath("//div[@class='fieldset-wrapper-title']//span[contains(text(),'Design')]/../..");
        this.scheduleDesignUpdate = Search.xpath("//div[@class='fieldset-wrapper-title']//span[contains(text(),'Schedule Design Update')]/../..");
        this.delete = null;
        this.message = null;

    }


    // Page Object
    //------------ Get Data PageObject -----------

    public CategoriesPage refresh(){
        return new CategoriesPage();
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

    public void initDeleteButton() {
        this.delete = Search.id("delete");
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
        //driver.findElement(By.id("delete")).click();
        Search.id("delete").click();
        //getDelete().click();
    }

    public void clickOkButton(){
        //driver.findElement(By.xpath("//button[@class='action-primary action-accept']")).click();
        Search.xpath("//button[@class='action-primary action-accept']").click();
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
            initDeleteButton();
        }

    }

}
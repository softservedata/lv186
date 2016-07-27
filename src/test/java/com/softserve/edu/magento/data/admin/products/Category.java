package com.softserve.edu.magento.data.admin.products;

/**
 * Created by Olia on 22.07.2016.
 */

interface INameCategory{
    IParent setName(String name);
}
interface IParent{
    IEnable setParent(String parent);
}
interface IEnable{
    IIncludeInMenu setEnable(boolean enable);
}
interface IIncludeInMenu{
    IBuildCategory setIncludeInMenu(boolean enable);
}
interface IBuildCategory{
    ICategory build();
}

public class Category implements INameCategory, IParent, IEnable, IIncludeInMenu, IBuildCategory, ICategory{
    private String name;
    private String parent;
    private boolean isEnable;
    private boolean isIncludeInMenu;
    //private String description;
    //private String displayMode;
    //private boolean anchor;
    //private Sort availableProductListingSort;      хтось робить?
    //private Sort defaultProductListingSort;
    //private int LayeredNavigationPrice;
    //private Image image;
    //private String cmsBlock;

    /*HashMap<String, ICategory> categoryMap = new HashMap<String, ICategory>();

    public boolean existCategory (ICategory category){
        String name = category.getName();
        for(Map.Entry<String, ICategory> entry: categoryMap.entrySet()){
            if (name == entry.getValue().getName()){
                return true;
            }
        }
        return false;
    }

    public boolean existCategoryByName (String name){
        for(Map.Entry<String, ICategory> entry: categoryMap.entrySet()){
            if (name == entry.getKey()){
                return true;
            }
        }
        return false;
    } */

    private Category (){

    }

    public static INameCategory get(){
        return new Category();
    }

    public IParent setName(String name){
        this.name = name;
        return this;
    }

    public IEnable setParent(String parent){
        this.parent = parent;
        return this;
    }

    public IIncludeInMenu setEnable(boolean isEnable){
        this.isEnable = isEnable;
        return this;
    }

    public IBuildCategory setIncludeInMenu(boolean includeInMenu){
        this.isIncludeInMenu = includeInMenu;
        return this;
    }

    public ICategory build(){
        //categoryMap.put(this.name, this);
        return this;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean getEnabled() {
        return this.isEnable;
    }

    @Override
    public boolean getIncludeInMenu() {
        return this.isIncludeInMenu;
    }
}

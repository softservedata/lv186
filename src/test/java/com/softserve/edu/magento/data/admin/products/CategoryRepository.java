package com.softserve.edu.magento.data.admin.products;

/**
 * Created by Olia on 22.07.2016.
 */
public class CategoryRepository {

    private static volatile CategoryRepository instance = null;
    public static final String CATEGORY_NAME = "Testing name";
    public static final String SUBCATEGORY_NAME = "Subcategory testing name";
    public static final String SUBCATEGORY_PARENT_NAME = CATEGORY_NAME;

    private CategoryRepository() {
    }

    public static CategoryRepository get() {
        if (instance == null) {
            synchronized (CategoryRepository.class) {
                if (instance == null) {
                    instance = new CategoryRepository();
                }
            }
        }
        return instance;
    }

    public ICategory addRootCategoryCompetur(){
        return Category.get()
                .setName("Computers")
                .setParent(null)
                .setEnable(true)
                .setIncludeInMenu(true)
                .build();

    }

    public ICategory addSubcategoryMotherboard(){
        return Category.get()
                .setName("Motherboard")
                .setParent("Computers")
                .setEnable(true)
                .setIncludeInMenu(true)
                .build();

    }

    public String getValues (){
        return CATEGORY_NAME;
    }
}

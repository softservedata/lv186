package com.softserve.edu.magento.data;

/**
 * Created by Olia on 22.07.2016.
 */
public class CategoryRepository {

    private static volatile CategoryRepository instance = null;

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
}

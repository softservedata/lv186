package com.softserve.edu.magento.data.admin.products;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    public final static String ATTRIBUTE_SET = "Test Attribute Set";
    public final static String VALID_PRODUCT_NAME = "Samsung Tablet";
    public final static String INVALID_PRODUCT_NAME = "qqqqqqqqqq2222222222qqqqqqqqqq2222222222qqqqqqqqqq2222222222qqqqqqqqqq2222222222qqqqqqqqqq2222222222qqqqqqqqqq2222222222qqqqqqqqqq2222222222qqqqqqqqqq2222222222qqqqqqqqqq2222222222qqqqqqqqqq2222222222qqqqqqqqqq2222222222qqqqqqqqqq2222222222qqqqqqqqqq333333";
    public final static String VALID_SKU = "Tablet";
    public final static String INVALID_SKU = "qqqqqqqqqq2222222222qqqqqqqqqq2222222222qqqqqqqqqq2222222222aaaaa";
    public final static String VALID_PRICE = "700.00";
    public final static String VALID_PRICE_FOR_CHECK = "$700.00";
    public final static String INVALID_PRICE = "Big Price";
    public final static String INVALID_MIXED_PRICE = "12qwerty34";
    public final static String EXISTING_PRODUCT_NAME = "Gigabyte";
    public final static String EXISTING_PRODUCT_SKU = "Gigabyte";
    public final static String EXISTING_PRICE = "100";
    public final static String QUANTITY = "50";
    public final static String QUANTITY_FOR_CHECK = "50.0000";
    public final static String VALID_PRODUCT_NAME_2 = "Samsung A3";
    public final static String VALID_SKU_2 = "A3";
    public final static String VALID_PRODUCT_NAME_3 = "Dell Laptop";
    public final static String VALID_SKU_3 = "Dell";
    public final static String VALID_SKU_DUPLICATED = "Dell-1";


    private ProductRepository() {
    }

    public static ProductRepository get() {
        return new ProductRepository();
    }

    public IProduct getNewValidProduct() {
        IProduct product = Product.get().setProductName(VALID_PRODUCT_NAME).setSku(VALID_SKU).setPrice(VALID_PRICE)
                .build();
        product.setQuantity(QUANTITY);
        return product;
    }

    public IProduct getNewValidProductForSaveAndNew() {
        IProduct product = Product.get().setProductName(VALID_PRODUCT_NAME_2).setSku(VALID_SKU_2).setPrice(VALID_PRICE)
                .build();
        product.setQuantity(QUANTITY);
        return product;
    }

    public IProduct getNewValidProductForSaveAndDuplicate() {
        IProduct product = Product.get().setProductName(VALID_PRODUCT_NAME_3).setSku(VALID_SKU_3).setPrice(VALID_PRICE)
                .build();
        product.setQuantity(QUANTITY);
        return product;
    }

    public IProduct getNewProductWithInvalidPrice() {
        IProduct product = Product.get().setProductName(VALID_PRODUCT_NAME).setSku(VALID_SKU).setPrice(INVALID_PRICE)
                .build();
        product.setQuantity(QUANTITY);
        return product;
    }

    public IProduct getNewProductWithMixedPrice() {
        IProduct product = Product.get().setProductName(VALID_PRODUCT_NAME).setSku(VALID_SKU).setPrice(INVALID_MIXED_PRICE)
                .build();
        product.setQuantity(QUANTITY);
        return product;
    }

    public IProduct getNewProductWithEmptyData() {
        IProduct product = Product.get().setProductName("").setSku("").setPrice("").build();
        return product;
    }

    public IProduct getExistingProduct() {
        IProduct product = Product.get().setProductName(EXISTING_PRODUCT_NAME).setSku(EXISTING_PRODUCT_SKU).setPrice(EXISTING_PRICE).build();
        return product;
    }

    public IProduct getNewProductWithEmptySku() {
        IProduct product = Product.get().setProductName(VALID_PRODUCT_NAME).setSku("").setPrice(VALID_PRICE).build();
        product.setQuantity(QUANTITY);
        return product;
    }

    public IProduct getNewProductWithInvalidName() {
        IProduct product = Product.get().setProductName(INVALID_PRODUCT_NAME).setSku(VALID_SKU).setPrice(VALID_PRICE).build();
        product.setQuantity(QUANTITY);
        return product;
    }

    public IProduct getNewProductWithInvalidSku() {
        IProduct product = Product.get().setProductName(VALID_PRODUCT_NAME).setSku(INVALID_SKU).setPrice(VALID_PRICE).build();
        product.setQuantity(QUANTITY);
        return product;
    }
    public IProduct getErikaRunningShort32Purple() {
        IProduct product = Product.get().setProductName("Erika Running Short-32-Purple").setSku("WSH12-32-Purple").setPrice("45")
                .build();
        return product;
    }
    public List<IProduct> getListProducts(IProduct[] iProducts){
        List<IProduct> productList = new ArrayList<>();
        for (IProduct product : iProducts) {
            productList.add(product);
        }
        return productList;
    }
}
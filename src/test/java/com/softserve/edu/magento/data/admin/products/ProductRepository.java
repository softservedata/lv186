package com.softserve.edu.magento.data.admin.products;

public class ProductRepository {

    public final static String ATTRIBUTE_SET = "Test Attribute Set";
    public final static String VALID_PRODUCT_NAME = "Samsung Tablet";
    public final static String VALID_SKU = "Tablet";
    public final static String VALID_PRICE = "700";
    public final static String VALID_PRICE_FOR_CHECK = "$700.00";
    public final static String INVALID_PRICE = "Big Price";
    public final static String EXISTING_PRODUCT_NAME = "Gigabyte";
    public final static String EXISTING_PRODUCT_SKU = "Gigabyte";
    public final static String EXISTING_PRICE = "100";
    public final static String QUANTITY = "50";
    public final static String QUANTITY_FOR_CHECK = "50.0000";

    private ProductRepository() {
    }

    public static ProductRepository get() {
        return new ProductRepository();
    }

    public IProduct getNewValidProduct() {
        IProduct product = Product.get().setProductName(VALID_PRODUCT_NAME).setSku(VALID_SKU).setPrice(VALID_PRICE)
                .build();
        product.setAttributeSet(ATTRIBUTE_SET);
        product.setQuantity(QUANTITY);
        return product;
    }

    public IProduct getNewProductWithInvalidPrice() {
        IProduct product = Product.get().setProductName(VALID_PRODUCT_NAME).setSku(VALID_SKU).setPrice(INVALID_PRICE)
                .build();
        product.setAttributeSet(ATTRIBUTE_SET);
        return product;
    }

    public IProduct getNewProductWithEmptyInvalidData() {
        IProduct product = Product.get().setProductName("").setSku("").setPrice(INVALID_PRICE).build();
        return product;
    }

    public IProduct getExistingProduct() {
        IProduct product = Product.get().setProductName(EXISTING_PRODUCT_NAME).setSku(EXISTING_PRODUCT_SKU).setPrice(EXISTING_PRICE).build();
        return product;
    }

    public IProduct getNewProductWithNonRequiredFields() {
        IProduct product = Product.get().setProductName(VALID_PRODUCT_NAME).setSku("").setPrice("").build();
        product.setAttributeSet(ATTRIBUTE_SET);
        product.setQuantity(QUANTITY);
        return product;
    }
}
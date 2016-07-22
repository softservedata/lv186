package com.softserve.edu.magento.data;

public class ProductRepository {

	public final static String ATTRIBUTE_SET = "Test Attribute Set";
	public final static String VALID_PRODUCT_NAME = "Samsung Tablet";
	public final static String VALID_SKU = "Tablet";
	public final static String VALID_PRICE = "700";
	public final static String INVALID_PRICE = "Big Price";

	private static volatile ProductRepository instance = null;

	private ProductRepository() {
	}

	public static ProductRepository get() {
		if (instance == null) {
			synchronized (ProductRepository.class) {
				if (instance == null) {
					instance = new ProductRepository();
				}
			}
		}
		return instance;
	}

	public IProduct getNewValidProduct() {
		IProduct product = Product.get().setProductName(VALID_PRODUCT_NAME).setSku(VALID_SKU).setPrice(VALID_PRICE)
				.build();
		product.setAttributeSet(ATTRIBUTE_SET);
		return product;
	}

	public IProduct getNewProductWithInvalidPrice() {
		IProduct product = Product.get().setProductName(VALID_PRODUCT_NAME).setSku(VALID_SKU).setPrice(INVALID_PRICE)
				.build();
		product.setAttributeSet("Test Attribute Set");
		return product;
	}

	public IProduct getNewProductWithEmptyInvalidData() {
		IProduct product = Product.get().setProductName("").setSku("").setPrice(INVALID_PRICE).build();
		product.setAttributeSet("Test Attribute Set");
		return product;
	}

}

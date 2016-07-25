package com.softserve.edu.magento.data;

interface IProductName {
	ISku setProductName(String productName);
}

interface ISku {
	IPrice setSku(String sku);
}

interface IPrice {
	IBuild setPrice(String price);
}

interface IBuild {
	IProduct build();
}

public class Product implements IProductName, ISku, IPrice, IBuild, IProduct {
	private String productName;
	private String sku;
	private String price;
	private String attributeSet;

	private Product() {
	}

	public static IProductName get() {
		return new Product();
	}

	public ISku setProductName(String productName) {
		this.productName = productName;
		return this;
	}

	public IPrice setSku(String sku) {
		this.sku = sku;
		return this;
	}

	public IBuild setPrice(String price) {
		this.price = price;
		return this;
	}

	public IProduct build() {
		return this;
	}

	public void setAttributeSet(String attributeSet) {
		this.attributeSet = attributeSet;
	}

	// getters

	public String getProductName() {
		return productName;
	}

	public String getSku() {
		return sku;
	}

	public String getPrice() {
		return price;
	}

	public String getAttributeSet() {
		return attributeSet;
	}

}

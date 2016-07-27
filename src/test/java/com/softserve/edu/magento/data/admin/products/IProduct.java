package com.softserve.edu.magento.data.admin.products;

public interface IProduct {
	String getAttributeSet();
	String getProductName();
	String getSku();
	String getPrice();
	void setAttributeSet(String attributeSet);
}


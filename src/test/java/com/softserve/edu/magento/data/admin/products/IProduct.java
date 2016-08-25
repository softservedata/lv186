package com.softserve.edu.magento.data.admin.products;

public interface IProduct {
	String getAttributeSet();
	String getProductName();
	String getSku();
	String getPrice();
	String getQuantity();
	void setAttributeSet(String attributeSet);
	void setQuantity(String quantity);
}


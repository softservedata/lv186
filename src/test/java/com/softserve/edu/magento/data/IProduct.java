package com.softserve.edu.magento.data;

public interface IProduct {
	String getAttributeSet();
	String getProductName();
	String getSku();
	String getPrice();
	void setAttributeSet(String attributeSet);
}


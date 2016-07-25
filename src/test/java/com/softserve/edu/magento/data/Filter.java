package com.softserve.edu.magento.data;

public class Filter {

	private String idFrom;
	private String idTo;
	private String priceFrom;
	private String priceTo;
	private String quantityFrom;
	private String quantityTo;
	private String name;
	private String sku;

	public Filter() {
	}

	// getters

	public Filter get() {
		return new Filter();
	}

	public String getIdFrom() {
		return this.idFrom;
	}

	public String getIdTo() {
		return this.idTo;
	}

	public String getPriceFrom() {
		return this.priceFrom;
	}

	public String getPriceTo() {
		return this.priceTo;
	}

	public String getQuantityFrom() {
		return this.quantityFrom;
	}

	public String getQuantityTo() {
		return this.quantityTo;
	}

	public String getName() {
		return this.name;
	}

	public String getSku() {
		return this.sku;
	}

	// setters

	public void setIdFrom(String idFrom) {
		this.idFrom = idFrom;
	}

	public void setIdTo(String idTo) {
		this.idTo = idTo;
	}

	public void setPriceFrom(String priceFrom) {
		this.priceFrom = priceFrom;
	}

	public void setPriceTo(String priceTo) {
		this.priceTo = priceTo;
	}

	public void setQuantityFrom(String quantityFrom) {
		this.quantityFrom = quantityFrom;
	}

	public void setQuantityTo(String quantityTo) {
		this.quantityTo = quantityTo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

}

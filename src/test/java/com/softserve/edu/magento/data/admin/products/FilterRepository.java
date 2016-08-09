package com.softserve.edu.magento.data.admin.products;

public class FilterRepository {

	public FilterRepository() {
	}

	public static FilterRepository get() {
		return new FilterRepository();
	}

	public Filter getExistingName() {
		Filter nameFilter = new Filter();
		nameFilter.setName("Gigabyte");
		return nameFilter;
	}

	public Filter getExistingPrice() {
		Filter priceFilter = new Filter();
		priceFilter.setPriceFrom("50");
		priceFilter.setPriceTo("100");
		return priceFilter;
	}

	public Filter getExistingNamePrice() {
		Filter namePriceFilter = new Filter();
		namePriceFilter.setName("Gigabyte");
		namePriceFilter.setPriceFrom("10");
		namePriceFilter.setPriceTo("1000");
		return namePriceFilter;
	}

	public Filter getNonExistingName() {
		Filter nameFilter = new Filter();
		nameFilter.setName("nonexistence");
		return nameFilter;
	}
}
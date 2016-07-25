package com.softserve.edu.magento.data.admin.products;

public class FilterRepository {

	public FilterRepository() {
	}

	public FilterData getExistingName() {
		FilterData nameFilterData = new FilterData();
		nameFilterData.setName("Gigabyte");
		return nameFilterData;
	}

	public FilterData getExistingPrice() {
		FilterData priceFilterData = new FilterData();
		priceFilterData.setPriceFrom("50");
		priceFilterData.setPriceTo("100");
		return priceFilterData;
	}

	public FilterData getExistingNamePrice() {
		FilterData namePriceFilterData = new FilterData();
		namePriceFilterData.setName("Gigabyte");
		namePriceFilterData.setPriceFrom("10");
		namePriceFilterData.setPriceTo("1000");
		return namePriceFilterData;
	}
	
	public FilterData getNonExistingName() {
		FilterData nameFilterData = new FilterData();
		nameFilterData.setName("nonexistence");
		return nameFilterData;
	}

}

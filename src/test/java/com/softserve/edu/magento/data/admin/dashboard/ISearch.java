package com.softserve.edu.magento.data.admin.dashboard;

import java.util.List;

public interface ISearch {
	public ISearchBuild setSearchField(String text);
	// getters

	List<String> getSearchFields();

}

package com.softserve.edu.magento.data.admin.dashboard;

import java.util.ArrayList;
import java.util.List;

interface ISearchField {
	ISearchBuild setSearchField(String text);
}

interface ISearchBuild {
	ISearch build();
}

public class SearchRecords implements ISearchField, ISearchBuild, ISearch {
	//
	private List<String> listOfTerms= new ArrayList<>();

	private SearchRecords() {
	}

	public ISearch build() {
		return this;
	}

	public static ISearchField get() {
		return new SearchRecords();
	}

	public ISearchBuild setSearchField(String text) {
		this.listOfTerms.add(text);
		return this;
	}

	// getters

	public List<String> getSearchFields() {
		return listOfTerms;
	}

 

}

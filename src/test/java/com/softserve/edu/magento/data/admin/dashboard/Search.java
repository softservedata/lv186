package com.softserve.edu.magento.data.admin.dashboard;

import java.util.ArrayList;
import java.util.List;

interface ISearchField {
	ISearchBuild setSearchField(String text);
}

interface ISearchBuild {
	ISearch build();
}

public class Search implements ISearchField, ISearchBuild, ISearch {
	//
	private List<String> listOfTerms= new ArrayList<>();

	private Search() {
	}

	public ISearch build() {
		return this;
	}

	public static ISearchField get() {
		return new Search();
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

package com.softserve.edu.magento.data.admin.dashboard;

public class SearchRepository {

    private static volatile SearchRepository instance = null;

    private SearchRepository() {
    }

    public static SearchRepository get() {
        if (instance == null) {
            synchronized (SearchRepository.class) {
                if (instance == null) {
                    instance = new SearchRepository();
                }
            }
        }
        return instance;
    }

   public ISearch searchFields() {
        return Search.get()
        		.setSearchField("aaaa")
        		.build()
        		.setSearchField("bbbb")
        		.build()
        		.setSearchField("cccc")
        		.build()
        		.setSearchField("dddd")
        		.build()
        		.setSearchField("eeee")
        		.build();
    
    }
   
   
   

}

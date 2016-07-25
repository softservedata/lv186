package com.softserve.edu.magento.data.customer.user;

import com.softserve.edu.magento.data.admin.AdminUserRepository;

public class CustomerNewRepository {
	 private static volatile CustomerNewRepository instance = null;

	    private CustomerNewRepository() {
	    }

	    public static CustomerNewRepository get() {
	        if (instance == null) {
	            synchronized (AdminUserRepository.class) {
	                if (instance == null) {
	                    instance = new CustomerNewRepository();
	                }
	            }
	        }
	        return instance;
	    }
	    
	    public ICustomerNewRegistration customerPavlo() {
	        return CustomerRegistrationInfo.get()
	        		.setPrefix("Bilyy")
	        		.setFirstname("Pavlo")
	        		.setMiddlename("Koob")
	        		.setLastname("Lazor")
	        		.setSufix("Iva")
	        		.setMail("pavlo@gmail.com")
	        		.setDateOfBirdth("12/06/1986")
	        		.setTaxNumber("1230")
	        		.build();
	    }
}

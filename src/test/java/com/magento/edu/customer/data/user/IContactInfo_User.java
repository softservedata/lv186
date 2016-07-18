package com.magento.edu.customer.data.user;

public interface IContactInfo_User {
	//setters
		public IContactInfo_User setCompanyName(String companyName);
	 	public IContactInfo_User setFax(String fax);
	//getters
		public String getPhoneNumber();
		public String getStreetAddress();
		public String getCity();
		public String getState();
		public String getPostalCode();
		public String getCountry();
		public String getCompanyName();
		public String getFax();
}

package com.softserve.edu.magento.data.customer.user;

public interface IContactInfo_User {
	//setters
		public IContactInfo_User setCompanyName(String companyName);
	 	public IContactInfo_User setFax(String fax);
	 	public IContactInfo_User setVatNumber(String vatNumber);
	//getters
		public String getPhoneNumber();
		public String getStreetAddress();
		public String getCity();
		public String getState();
		public String getPostalCode();
		public String getCountry();
		public String getCompanyName();
		public String getFax();
		public String getVatNumber();
}

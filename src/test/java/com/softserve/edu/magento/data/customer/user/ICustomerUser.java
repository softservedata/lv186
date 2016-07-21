package com.softserve.edu.magento.data.customer.user;

public interface ICustomerUser {
	//setters
	    public ICustomerUser setContactInfo_User(IContactInfo_User contactInfo);
	//getters
		public IPersonalInfo_User getPersonalInfo();
		public ISigninInfo_User getSigninInfo();
		public IContactInfo_User getContactInfo();
}

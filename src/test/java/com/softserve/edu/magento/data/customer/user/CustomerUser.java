package com.softserve.edu.magento.data.customer.user;
interface IIPersonalInfo_User {
	IISigninInfo_User setPersonalInfo(IPersonalInfo_User personalInfo);
}
interface IISigninInfo_User {
	IBuildUser setSigninInfo(ISigninInfo_User signinInfo);
}
interface IBuildUser {
	ICustomerUser build();
}
public class CustomerUser implements IIPersonalInfo_User,IISigninInfo_User,IBuildUser,ICustomerUser{
	private IPersonalInfo_User personalInfo;
	private ISigninInfo_User signinInfo;
	private IContactInfo_User contactInfo;
	
	private CustomerUser() {}
	public static IIPersonalInfo_User get() {
        return new  CustomerUser();
    }
//setters
	public IISigninInfo_User setPersonalInfo(IPersonalInfo_User personalInfo) {
		this.personalInfo = personalInfo;
		return this;
	}

	public IBuildUser setSigninInfo(ISigninInfo_User signinInfo) {
		this.signinInfo = signinInfo;
		return this;
	}
	public ICustomerUser build() {
        return this;
    }
	public ICustomerUser setContactInfo_User(IContactInfo_User contactInfo) {
		this.contactInfo = contactInfo;
		return this;
	}
//getters
	public IPersonalInfo_User getPersonalInfo() {
		return personalInfo;
	}
	public ISigninInfo_User getSigninInfo() {
		return signinInfo;
	}
	public IContactInfo_User getContactInfo() {
		return contactInfo;
	}
	
}

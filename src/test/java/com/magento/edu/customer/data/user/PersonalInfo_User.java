package com.magento.edu.customer.data.user;
interface IFirstname {
	ILastname setFirstname(String firstname);
}

interface ILastname {
	ISignUpNewsletter setLastname(String lastname);
}

interface ISignUpNewsletter {
	IBuild_PersonalInfo_User setSignUpNewsletter(Boolean signUpNewsletter);
}
interface IBuild_PersonalInfo_User {
	IPersonalInfo_User build();
}

public class PersonalInfo_User implements IFirstname,ILastname,ISignUpNewsletter,
IBuild_PersonalInfo_User,IPersonalInfo_User{
	private String firstname;
	private String lastname;
	private Boolean signUpNewsletter;
	private PersonalInfo_User() {}
	//SETTERS
	public static IFirstname get() {
        return new  PersonalInfo_User();
    }
	public ILastname setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}
	public ISignUpNewsletter setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}
	public IBuild_PersonalInfo_User setSignUpNewsletter(Boolean signUpNewsletter) {
		this.signUpNewsletter = signUpNewsletter;
		return this;
	}
	public IPersonalInfo_User build() {
        return this;
    }
	//getters
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public Boolean getSignUpNewsletter() {
		return signUpNewsletter;
	}
	
	
	
}

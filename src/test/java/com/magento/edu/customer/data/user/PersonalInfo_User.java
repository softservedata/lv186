package com.magento.edu.customer.data.user;
interface IFirstName {
	ILastName setFirstName(String firstName);
}

interface ILastName {
	ISignUpNewsletter setLastName(String lastName);
}

interface ISignUpNewsletter {
	IBuild_PersonalInfo_User setSignUpNewsletter(Boolean signUpNewsletter);
}
interface IBuild_PersonalInfo_User {
	IPersonalInfo_User build();
}

public class PersonalInfo_User implements IFirstName,ILastName,ISignUpNewsletter,
IBuild_PersonalInfo_User,IPersonalInfo_User{
	private String firstName;
	private String lastName;
	private Boolean signUpNewsletter;
	private PersonalInfo_User() {}
	//SETTERS
	public static IFirstName get() {
        return new  PersonalInfo_User();
    }
	public ILastName setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	public ISignUpNewsletter setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Boolean getSignUpNewsletter() {
		return signUpNewsletter;
	}
	
	
	
}

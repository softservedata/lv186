package com.softserve.edu.magento.data.customer.user;

import com.softserve.edu.magento.data.customer.user.SigninInfo_User.Group;

interface IEmail {
	IPassword setEmail(String email);
}

interface IPassword {
	IConfirmPassword setPassword(String password);
}

interface IConfirmPassword {
	IAssosiateToWebsite setConfirmPassword(String confirmPassword);
}
interface IAssosiateToWebsite {
	IGroup setAssosiateToWebsite(String assosiateToWebsite);
}
interface IGroup {
	IBuild_SigninInfo_User setGroup(Group Group);
}
interface IBuild_SigninInfo_User  {
	ISigninInfo_User build();
}


public class SigninInfo_User implements IEmail,IPassword,IConfirmPassword,IAssosiateToWebsite,
IGroup,IBuild_SigninInfo_User,ISigninInfo_User{
	public static enum Group {
		GENERAL("General"),
		WHOLESALE("Wholesale"),
		RETAILER("Retailer");
		//
		private String field;

		private Group(String field) {
			this.field = field;
		}

		@Override
		public String toString() {
			return this.field;
		}
	}
	//--------------------------------------
	private String email;
	private String password;
	private String confirmPassword;
	private String assosiateToWebsite;
	private String group;
	
	private  SigninInfo_User() {}
	
	public static IEmail get() {
        return new  SigninInfo_User();
    }
	public IPassword setEmail(String email) {
		this.email = email;
		return this;
	}
	public IConfirmPassword setPassword(String password) {
		this.password = password;
		return this;
	}
	public IAssosiateToWebsite setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
		return this;
	}
	public IGroup setAssosiateToWebsite(String assosiateToWebsite) {
		this.assosiateToWebsite = assosiateToWebsite;
		return this;
	}
	public IBuild_SigninInfo_User setGroup(Group Group) {
		this.group = Group.toString();
		return this;
	}
	public ISigninInfo_User build() {
		return this;
	}
		
	//getters
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public String getAssosiateToWebsite() {
		return assosiateToWebsite;
	}
	public String getGroup() {
		return group;
	}
	
	
}

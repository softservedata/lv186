package com.magento.edu.customer.data.user;
interface IIPersonalInfo_User {
	IISigninInfo_User setPersonalInfo(IPersonalInfo_User personalInfo);
}
interface IISigninInfo_User {
	IBuildUser setSigninInfo(ISigninInfo_User signinInfo);
}
interface IBuildUser {
	IUser build();
}
public class User implements IIPersonalInfo_User,IISigninInfo_User,IBuildUser,IUser{
	private IPersonalInfo_User personalInfo;
	private ISigninInfo_User signinInfo;
	
	private User() {}
	public static IIPersonalInfo_User get() {
        return new  User();
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
	public IUser build() {
        return this;
    }
//getters
	public IPersonalInfo_User getPersonalInfo() {
		return personalInfo;
	}
	public ISigninInfo_User getSigninInfo() {
		return signinInfo;
	}
	
}

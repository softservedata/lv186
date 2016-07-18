package com.magento.edu.customer.data.user;


interface IEmail {
	IPassword setEmail(String email);
}

interface IPassword {
	IConfirmPassword setPassword(String password);
}

interface IConfirmPassword {
	IBuild_SigninInfo_User setConfirmPassword(String confirmPassword);
}
interface IBuild_SigninInfo_User  {
	ISigninInfo_User build();
}


public class SigninInfo_User implements IEmail,IPassword,IConfirmPassword,
IBuild_SigninInfo_User,ISigninInfo_User{
	private String email;
	private String password;
	private String confirmPassword;
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
	public IBuild_SigninInfo_User setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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
	
	
}

package com.softserve.edu.magento.data.customer.user;

import com.softserve.edu.magento.data.customer.user.PersonalInfo_User.Gender;

public interface IPersonalInfo_User {
	//setters
	public IPersonalInfo_User setPrefix(String prefix);
	public IPersonalInfo_User setMiddlename(String middlename);
	public IPersonalInfo_User setSuffix(String suffix);
	public IPersonalInfo_User setBirthdayDate(IDate birthdayDate);
	public IPersonalInfo_User setGender(Gender Gender);
	//getters
	public String getFirstname();
	public String getLastname();
	public Boolean getSignUpNewsletter();
	public String getPrefix();
	public String getMiddlename();
	public String getSuffix();
	public IDate getBirthdayDate();
	public String getGender();
	public String getFullName();
}

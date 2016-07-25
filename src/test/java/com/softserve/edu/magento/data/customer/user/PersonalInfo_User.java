package com.softserve.edu.magento.data.customer.user;
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
	
	public static enum Gender {
		MALE("Male"),
		FEMALE("Female"),
		NOT_SPECIFIED("Not Specified");
		//
		private String field;

		private Gender(String field) {
			this.field = field;
		}

		@Override
		public String toString() {
			return this.field;
		}
	}
	//----------------------------------
	private String prefix;
	private String firstname;
	private String middlename;
	private String lastname;
	private String suffix;
	private IDate birthdayDate;
	private String gender;
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
	public IPersonalInfo_User setPrefix(String prefix) {
		this.prefix = prefix;
		return this;
	}
	public IPersonalInfo_User setMiddlename(String middlename) {
		this.middlename = middlename;
		return this;
	}
	public IPersonalInfo_User setSuffix(String suffix) {
		this.suffix = suffix;
		return this;
	}
	public IPersonalInfo_User setBirthdayDate(IDate birthdayDate) {
		this.birthdayDate = birthdayDate;
		return this;
	}
	public IPersonalInfo_User setGender(Gender Gender) {
		this.gender = Gender.toString();
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
	public String getPrefix() {
		return prefix;
	}
	public String getMiddlename() {
		return middlename;
	}
	public String getSuffix() {
		return suffix;
	}
	public IDate getBirthdayDate() {
		return birthdayDate;
	}
	public String getGender() {
		return gender;
	}
	public String getFullName() {
		StringBuffer fullName = new StringBuffer();
		if( getPrefix() != null && getPrefix() != " " ) {
			fullName.append(getPrefix()+" ");
		}
		fullName.append(getFirstname()+" ");
		if( getMiddlename() != null && getMiddlename() != " " ) {
			fullName.append(getMiddlename()+" ");
		}
		fullName.append(getLastname());
		if( getSuffix() != null && getSuffix() != " " ) {
			fullName.append(" "+getSuffix());
		}
		return new String(fullName);
	}
	
	
	
}

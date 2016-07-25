package com.softserve.edu.magento.data.customer.user;

interface IPhoneNumber {
	IStreetAddress setPhoneNumber(String phoneNumber);
}
interface IStreetAddress {
	ICity setStreetAddress(String streetAddress);
}
interface ICity {
	IState setCity(String city);
}
interface IState {
	IPostalCode setState(String state);
}
interface IPostalCode {
	ICountry setPostalCode(String postalCode);
}
interface ICountry {
	IBuild_ContactInfo_User setCountry(String country);
}
interface IBuild_ContactInfo_User {
	IContactInfo_User build();
}

public class ContactInfo_User implements IPhoneNumber,IStreetAddress,ICity,IState,IPostalCode,
ICountry,IBuild_ContactInfo_User,IContactInfo_User{
	private String phoneNumber;
	private String streetAddress;
	private String city;
	private String state;
	private String postalCode;
	private String country;
	private String companyName;
	private String fax;
	private String vatNumber;
	
	private ContactInfo_User() {}
	//setters
	public static IPhoneNumber get() {
        return new  ContactInfo_User();
    }
	
	public IStreetAddress setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	public ICity setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
		return this;
	}

	public IState setCity(String city) {
		this.city = city;
		return this;
	}

	public IPostalCode setState(String state) {
		this.state = state;
		return this;
	}

	public ICountry setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	}

	public IBuild_ContactInfo_User setCountry(String country) {
		this.country = country;
		return this;
	}
	public IContactInfo_User build() {
        return this;
    }
	public IContactInfo_User setCompanyName(String companyName) {
		this.companyName = companyName;
		return this;
	}

	public IContactInfo_User setFax(String fax) {
		this.fax = fax;
		return this;
	}
	public IContactInfo_User setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
		return this;
	}
	//getters
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public String getCountry() {
		return country;
	}
	public String getCompanyName() {
		return companyName;
	}
	public String getFax() {
		return fax;
	}
	public String getVatNumber() {
		return vatNumber;
	}

	
	
	
}

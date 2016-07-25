package com.softserve.edu.magento.data.customer.user;

interface ICustomerPrefix {
	ICustomerFirstname setPrefix(String prefix);
}

interface ICustomerFirstname {
	ICustomerMiddlename setFirstname(String firstname);
}

interface ICustomerMiddlename {
	ICustomerLastname setMiddlename(String middlename);
}

interface ICustomerLastname {
	ICustomerSufix setLastname(String lastName);
}

interface ICustomerSufix {
	ICustomerMail setSufix(String sufix);
}

interface ICustomerMail {
	ICustomerDateOfBirdth setMail(String email);
}

interface ICustomerDateOfBirdth {
	ICustomerTaxNumber setDateOfBirdth(String dateOfBirdth);
}

interface ICustomerTaxNumber {
	ICustomerBuild setTaxNumber(String taxNumber);
}

interface ICustomerBuild {
	ICustomerNewRegistration build();
}

public class CustomerRegistrationInfo
		implements ICustomerPrefix, ICustomerFirstname, ICustomerMiddlename, ICustomerLastname, ICustomerSufix,
		ICustomerMail, ICustomerDateOfBirdth, ICustomerTaxNumber, ICustomerBuild, ICustomerNewRegistration {
	// fields
	private String prefix;
	private String firstname;
	private String middlename;
	private String lastname;
	private String sufix;
	private String email;
	private String dateOfBirdth;
	private String taxNumber;

	private CustomerRegistrationInfo() {

	}

	public static ICustomerPrefix get() {
		return new CustomerRegistrationInfo();
	}

	public ICustomerNewRegistration build() {
		return this;
	}

	// setters
	public ICustomerBuild setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
		return this;
	}

	public ICustomerTaxNumber setDateOfBirdth(String dateOfBirdth) {
		this.dateOfBirdth = dateOfBirdth;
		return this;
	}

	public ICustomerDateOfBirdth setMail(String email) {
		this.email = email;
		return this;
	}

	public ICustomerMail setSufix(String sufix) {
		this.sufix = sufix;
		return this;
	}

	public ICustomerSufix setLastname(String lastName) {
		this.lastname = lastName;
		return this;
	}

	public ICustomerLastname setMiddlename(String middlename) {
		this.middlename = middlename;
		return this;
	}

	public ICustomerMiddlename setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public ICustomerFirstname setPrefix(String prefix) {
		this.prefix = prefix;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// getters

	public String getPrefix() {
		return prefix;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public String getSufix() {
		return sufix;
	}

	public String getDateOfBirdth() {
		return dateOfBirdth;
	}

	public String getTaxNumber() {
		return taxNumber;
	}

}

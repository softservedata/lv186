package com.softserve.edu.magento.data.customer.user;

import com.softserve.edu.magento.data.customer.user.Date.Month;
import com.softserve.edu.magento.data.customer.user.PersonalInfo_User.Gender;
import com.softserve.edu.magento.data.customer.user.SigninInfo_User.Group;

public class CustomerUserRepositoryForAdmin {

    private static volatile CustomerUserRepositoryForAdmin instance = null;

    private CustomerUserRepositoryForAdmin() {
    }

    public static CustomerUserRepositoryForAdmin get() {
        if (instance == null) {
            synchronized (CustomerUserRepositoryForAdmin.class) {
                if (instance == null) {
                    instance = new CustomerUserRepositoryForAdmin();
                }
            }
        }
        return instance;
    }
    public ICustomerUser SteveRinger(){
    	return CustomerUser.get()
    			.setPersonalInfo(PersonalInfo_User.get()
    					.setFirstname("Steve")
    					.setLastname("Ringer")
    					.setSignUpNewsletter(true)
    					.build()
    					.setGender(Gender.MALE)
    					.setMiddlename("x")
    					.setPrefix("x")
    					.setSuffix("x")
    					.setBirthdayDate(Date.get()
    							.setMonth(Month.AUGUST)
    							.setDay("15")
    							.setYear("1981")
    							.build())
    						)
    			.setSigninInfo(SigninInfo_User.get()
        				.setEmail("ringer@yahoo.com")
        				.setPassword("789")
        				.setConfirmPassword("789")
        				.setAssosiateToWebsite("Main Website")
        				.setGroup(Group.GENERAL)
        				.build())
        		.build()
        		.setContactInfo_User(ContactInfo_User.get()
        				.setPhoneNumber("0932791256")
        				.setStreetAddress("Fishers")
        				.setCity("London")
        				.setState("London")
        				.setPostalCode("1000")
        				.setCountry("England")
        				.build()
        				.setCompanyName("PrestonInnovations")
        				.setFax("0932791256")
        				.setVatNumber("111115412")
        				);
    }
    public ICustomerUser NewCustomerRegistrationFromAdminSide(){
    	return CustomerUser.get()
    			.setPersonalInfo(PersonalInfo_User.get()
    					.setFirstname("Vasyl")
    					.setLastname("Vasyltsiv")
    					.setSignUpNewsletter(true)
    					.build()
    					.setGender(Gender.MALE)
    					.setMiddlename("Ivanov")
    					.setPrefix("Pre")
    					.setSuffix("Iva")
    					.setBirthdayDate(Date.get()
    							.setMonth(Month.AUGUST)
    							.setDay("12")
    							.setYear("1988")
    							.build())
    						)
    			.setSigninInfo(SigninInfo_User.get()
        				.setEmail("vasyltsiv@ukr.net")
        				.setPassword("789")
        				.setConfirmPassword("789")
        				.setAssosiateToWebsite("Main Website")
        				.setGroup(Group.GENERAL)
        				.build())
        		.build()
        		.setContactInfo_User(ContactInfo_User.get()
        				.setPhoneNumber("0938791256")
        				.setStreetAddress("Kulparkivska")
        				.setCity("Lviv")
        				.setState("Lviv")
        				.setPostalCode("79040")
        				.setCountry("Ukraine")
        				.build()
        				.setCompanyName("SoftServe")
        				.setFax("0938791256")
        				.setVatNumber("998745412")
        				);
    }
    				
    

    
    public ICustomerUser getTeodorDrayzer(){
    	return CustomerUser.get().
    			setPersonalInfo(PersonalInfo_User.get()
    					.setFirstname("Teodor")
    					.setLastname("Drayzer")
    					.setSignUpNewsletter(true)
    					.build())
    			.setSigninInfo(SigninInfo_User.get()
    					.setEmail("teo@gmail.com")
    					.setPassword("qwerty-1")
    					.setConfirmPassword("qwerty-1")
    					.setAssosiateToWebsite("Main Website")
    					.setGroup(Group.GENERAL)
    					.build())
    			.build();
    			
    }

    public ICustomerUser customerWithInvalidFields(){
        return CustomerUser.get().setPersonalInfo(PersonalInfo_User.get()
		.setFirstname("vjhdvgkfkjwehfkjwhbkbcvwbkjwhlhflweklkucniqwueiucoehlfnweilnbefwilhlfklknflkewnlqcwbiljqcrLIJHLRQIHKFBKNCLBIUWEIHFOEHKFJKJENFLHBKJBhklfblknsgfvjrvnijawjgrjbjfralkjcihyocnuewrhgjhgfwcljercgjwehjjhweakgkjwcanhcewukgkwrkehlehejgfknhwinhkuwwgxuklgtxukhgtxkug3tjgkurhwilhtfkwaugtk3q3gkchgiehjljrqialwhiohtrhkhwegggggggggggggggggggggggggggggggggggggggggggieyh4iueailghjerhsjakugrwnaechfilwhjeckubgc4wyxinuerwilyiiweuiluilewhycrnilutiluotvbyiutvnjubltv4ulu43qtvilnut4vvt3")
		.setLastname("vjhdvgkfkjwehfkjwhbkbcvwbkjwhlhflweklkucniqwueiucoehlfnweilnbefwilhlfklknflkewnlqcwbiljqcrLIJHLRQIHKFBKNCLBIUWEIHFOEHKFJKJENFLHBKJBhklfblknsgfvjrvnijawjgrjbjfralkjcihyocnuewrhgjhgfwcljercgjwehjjhweakgkjwcanhcewukgkwrkehlehejgfknhwinhkuwwgxuklgtxukhgtxkug3tjgkurhwilhtfkwaugtk3q3gkchgiehjljrqialwhiohtrhkhwegggggggggggggggggggggggggggggggggggggggggggieyh4iueailghjerhsjakugrwnaehfilwhjeckubgc4wyxinuerwilyiiweuiluilewhycrnilutiluotvbyiutvnjubltv4ulu43qtvilnut4vvt3")
						.setSignUpNewsletter(true)
						.build()
						.setGender(Gender.MALE)
						.setMiddlename("Ivanov")
						.setPrefix("Pre")
						.setSuffix("Iva")
						.setBirthdayDate(Date.get()
								.setMonth(Month.AUGUST)
								.setDay("12")
								.setYear("1988")
								.build())
		)
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("iopa.ukr.net")
						.setPassword("789")
						.setConfirmPassword("789")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build()
				.setContactInfo_User(ContactInfo_User.get()
						.setPhoneNumber("0938791256")
						.setStreetAddress("Kulparkivska")
						.setCity("Lviv")
						.setState("Lviv")
						.setPostalCode("79040")
						.setCountry("Ukraine")
						.build()
						.setCompanyName("SoftServe")
						.setFax("0938791256")
						.setVatNumber("998745412")
				);
    }
    public ICustomerUser testEditor(){
    	return CustomerUser.get()
    			.setPersonalInfo(PersonalInfo_User.get()
    					.setFirstname("Clint")
    					.setLastname("Eastwood")
    					.setSignUpNewsletter(true)
    					.build()
    					.setGender(Gender.MALE)
    					.setMiddlename("Jr.")
    					.setPrefix("Mr.")
    					.setSuffix("cowboy")
    					.setBirthdayDate(Date.get()
    							.setMonth(Month.AUGUST)
    							.setDay("26")
    							.setYear("1946")
    							.build())
    						)
    			.setSigninInfo(SigninInfo_User.get()
        				.setEmail("astwood@bang.com")
        				.setPassword("123")
        				.setConfirmPassword("123")
        				.setAssosiateToWebsite("Main Website")
        				.setGroup(Group.GENERAL)
        				.build())
        		.build()
        		.setContactInfo_User(ContactInfo_User.get()
        				.setPhoneNumber("555-222-000")
        				.setStreetAddress("5th Avenue")
        				.setCity("New York")
        				.setState("Columbia")
        				.setPostalCode("1000")
        				.setCountry("US")
        				.build()
        				.setCompanyName("PrestonInnovations")
        				.setFax("0932791256")
        				.setVatNumber("111115412")
        				);
    }
    }

//    public List<IUser> getExistUsersCVS() {
//        return new UserUtils().getAllUsers();
//    }

//    public List<IUser> getExistUsersExcel() {
//        return new UserUtils("/users.xlsx", new ExcelUtils()).getAllUsers();
//    }



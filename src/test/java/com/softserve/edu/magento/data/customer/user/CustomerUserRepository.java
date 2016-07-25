package com.softserve.edu.magento.data.customer.user;

import com.softserve.edu.magento.data.customer.user.Date.Month;
import com.softserve.edu.magento.data.customer.user.PersonalInfo_User.Gender;
import com.softserve.edu.magento.data.customer.user.SigninInfo_User.Group;

public class CustomerUserRepository {

    private static volatile CustomerUserRepository instance = null;

    private CustomerUserRepository() {
    }

    public static CustomerUserRepository get() {
        if (instance == null) {
            synchronized (CustomerUserRepository.class) {
                if (instance == null) {
                    instance = new CustomerUserRepository();
                }
            }
        }
        return instance;
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
    				
    

    public ICustomerUser User() {
        return CustomerUser.get()
        		.setPersonalInfo(PersonalInfo_User.get()
        				.setFirstname("Yaryna")
        				.setLastname("Kharko")
        				.setSignUpNewsletter(true)
        				.build()
        				.setGender(Gender.FEMALE)
        				.setBirthdayDate(Date.get()
        						.setMonth(Month.MAY)
        						.setDay("26")
        						.setYear("1997")
        						.build())
        				)
        		.setSigninInfo(SigninInfo_User.get()
        				.setEmail("ya.kharko@nltu.lviv.ua")
        				.setPassword("25263004Ya")
        				.setConfirmPassword("25263004Ya")
        				.setAssosiateToWebsite("Main Website")
        				.setGroup(Group.GENERAL)
        				.build())
        		.build()
        		.setContactInfo_User(ContactInfo_User.get()
        				.setPhoneNumber("0987656786")
        				.setStreetAddress("st. petra pancha 10")
        				.setCity("Lviv")
        				.setState("Lviv")
        				.setPostalCode("70020")
        				.setCountry("Ukraine")
        				.build()
        				.setCompanyName("SoftServe")
        				.setFax("")
        				.setVatNumber("10009876543")
        				);
    }
    
    public ICustomerUser invalidUser() {
        return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("ggg")
						.setLastname("GGG")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("ggg@mail.com")
						.setPassword("77777777")
						.setConfirmPassword("77777777")
						.setAssosiateToWebsite("Main Website")
        				.setGroup(Group.GENERAL)
						.build())
				.build();
    }

    public ICustomerUser newUser() {
        return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("yulia")
						.setLastname("koval")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("yulia.koval@mail.com")
						.setPassword("11111111yU")
						.setConfirmPassword("11111111yU")
						.setAssosiateToWebsite("Main Website")
        				.setGroup(Group.GENERAL)
						.build())
				.build();
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
    }

//    public List<IUser> getExistUsersCVS() {
//        return new UserUtils().getAllUsers();
//    }

//    public List<IUser> getExistUsersExcel() {
//        return new UserUtils("/users.xlsx", new ExcelUtils()).getAllUsers();
//    }



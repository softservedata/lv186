package com.magento.edu.customer.data.user;

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

    public ICustomerUser User() {
        return CustomerUser.get()
        		.setPersonalInfo(PersonalInfo_User.get()
        				.setFirstname("Yaryna")
        				.setLastname("Kharko")
        				.setSignUpNewsletter(true)
        				.build())
        		.setSigninInfo(SigninInfo_User.get()
        				.setEmail("ya.kharko@nltu.lviv.ua")
        				.setPassword("25263004Ya")
        				.setConfirmPassword("25263004Ya")
        				.setAssosiateToWebsite("Main Website")
        				.setGroup("General")
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
        				.setCompanyName("")
        				.setFax(""));
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
        				.setGroup("General")
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
        				.setGroup("General")
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



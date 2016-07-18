package com.magento.edu.customer.data.user;

public class UserRepository {

    private static volatile UserRepository instance = null;

    private UserRepository() {
    }

    public static UserRepository get() {
        if (instance == null) {
            synchronized (UserRepository.class) {
                if (instance == null) {
                    instance = new UserRepository();
                }
            }
        }
        return instance;
    }

    public IUser User() {
        return User.get()
        		.setPersonalInfo(PersonalInfo_User.get()
        				.setFirstName("Yaryna")
        				.setLastName("Kharko")
        				.setSignUpNewsletter(true)
        				.build())
        		.setSigninInfo(SigninInfo_User.get()
        				.setEmail("ya.kharko@nltu.lviv.ua")
        				.setPassword("25263004Ya")
        				.setConfirmPassword("25263004Ya")
        				.build())
        		.build();
    }
    
    public IUser invalidUser() {
        return User.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstName("ggg")
						.setLastName("GGG")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("ggg@mail.com")
						.setPassword("77777777")
						.setConfirmPassword("77777777")
						.build())
				.build();
    }

    public IUser newUser() {
        return User.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstName("yulia")
						.setLastName("koval")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("yulia.koval@mail.com")
						.setPassword("11111111yU")
						.setConfirmPassword("11111111yU")
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



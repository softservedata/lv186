package com.softserve.edu.data;

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

   /* public IUser adminUser() {
        return User.get()
                .setFirstname("Адміністратор")
                .setLastname("Адміністратор")
                .setLogin("admin")
                .setPassword("admin")
                .setMail("admin@admin.com")
                .build();
    }
    
    public IUser invalidUser() {
        return User.get()
                .setFirstname("hahaha")
                .setLastname("hahaha")
                .setLogin("hahaha")
                .setPassword("hahaha")
                .setMail("hahaha@admin.com")
                .build();
    }

    public IUser newUser() {
        return User.get()
                .setFirstname("customer")
                .setLastname("customer")
                .setLogin("customer")
                .setPassword("customer")
                .setMail("customer@customer.com")
                .build();
    }*/

//    public List<IUser> getExistUsersCVS() {
//        return new UserUtils().getAllUsers();
//    }

//    public List<IUser> getExistUsersExcel() {
//        return new UserUtils("/users.xlsx", new ExcelUtils()).getAllUsers();
//    }

}

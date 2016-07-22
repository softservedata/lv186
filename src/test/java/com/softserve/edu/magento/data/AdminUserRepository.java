package com.softserve.edu.magento.data;

public class AdminUserRepository {

    private static volatile AdminUserRepository instance = null;

    private AdminUserRepository() {
    }

    public static AdminUserRepository get() {
        if (instance == null) {
            synchronized (AdminUserRepository.class) {
                if (instance == null) {
                    instance = new AdminUserRepository();
                }
            }
        }
        return instance;
    }

   public IAdminUser adminBohdan() {
        return AdminUser.get()
                .setUsername("bmakatc")
                .setFirstname("Bohdan")
                .setLastname("Makar")
                .setMail("bmakatc@gmail.com")
                .setPassword("qwerty-1")
                .build();
    }
   public IAdminUser adminMykhaylo() {
	   return AdminUser.get()
			   .setUsername("mholovatc")
			   .setFirstname("Mykhaylo")
			   .setLastname("Holovanov")
			   .setMail("mholovanov@gmail.com")
			   .setPassword("qwerty-1")
			   .build();
   }
   public IAdminUser adminYaryna() {
	   return AdminUser.get()
			   .setUsername("ykhartc")
			   .setFirstname("Yaryna")
			   .setLastname("Kharko")
			   .setMail("ykhartc@gmail.com")
			   .setPassword("qwerty-1")
			   .build();
   }
    
}
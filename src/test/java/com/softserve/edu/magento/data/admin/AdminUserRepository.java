package com.softserve.edu.magento.data.admin;

import java.util.List;

import com.softserve.edu.magento.db.entity.AdminUserDB;
import com.softserve.edu.magento.db.services.AdminUserService;

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
   
   public IAdminUser adminTest() {
       return AdminUser.get()
               .setUsername("testaccount")
               .setFirstname("testaccount")
               .setLastname("testaccount")
               .setMail("testaccount@gmail.com")
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

   public IAdminUser adminYulia() {
	   return AdminUser.get()
			   .setUsername("ynevitc")
			   .setFirstname("Yulia")
			   .setLastname("Nevinglovskaya")
			   .setMail("ynevitc@gmail.com")
			   .setPassword("qwerty-1")
			   .build();
   }
   
   public IAdminUser adminAndrii() {
	   return AdminUser.get()
			   .setUsername("ayaremctc")
			   .setFirstname("Andrii")
			   .setLastname("Yaremchuk")
			   .setMail("yaremchyck@gmail.com")
			   .setPassword("qwerty=1")
			   .build();
   }
   
   public IAdminUser invalid() {
       return AdminUser.get()
               .setUsername("invalid")
               .setFirstname("invalid")
               .setLastname("invalid")
               .setMail("invalid@gmail.com")
               .setPassword("invalid")
               .build();
   }

   public IAdminUser adminOlya() {
       return AdminUser.get()
               .setUsername("olutsitc")
               .setFirstname("Olya")
               .setLastname("Lutsiv")
               .setMail("olya.lutsiv@gmail.com")
               .setPassword("qwerty-1")
               .build();
   }

    public IAdminUser adminlocalOlya() {
        return AdminUser.get()
                .setUsername("olala")
                .setFirstname("Olya")
                .setLastname("Lutsiv")
                .setMail("olya.lutsiv@gmail.com")
                .setPassword("life-1s-good")
                .build();
    }

   public IAdminUser adminUserConvert(AdminUserDB adminUserDB) {
       return AdminUser.get()
               .setUsername(adminUserDB.getUsername())
               .setFirstname(adminUserDB.getFirstname())
               .setLastname(adminUserDB.getLastname())
               .setMail(adminUserDB.getEmail())
               .setPassword(adminUserDB.getPassword())
               .build();
   }

   public IAdminUser getAdminUserFromDB(String adminUserName) {
       return AdminUserService.get().getAdminUserByLogin(adminUserName); 
   }

   public List<IAdminUser> getAdminUsersFromDB() {
       return AdminUserService.get().getAdminUsers(); 
   }

}

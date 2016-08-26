package com.softserve.edu.magento.db.services;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.magento.data.admin.AdminUserRepository;
import com.softserve.edu.magento.data.admin.IAdminUser;
import com.softserve.edu.magento.db.dao.AdminUserDao;
import com.softserve.edu.magento.db.entity.AdminUserDB;
import com.softserve.edu.magento.db.entity.AdminUserDB.AdminUserDBFields;

public class AdminUserService {
    private static volatile AdminUserService instance = null;

    private AdminUserService() {
    }

    public static AdminUserService get() {
        if (instance == null) {
            synchronized (AdminUserService.class) {
                if (instance == null) {
                    instance = new AdminUserService();
                }
            }
        }
        return instance;
    }

    
    public AdminUserDB adminUserToAdminUserDB(IAdminUser adminUser) {
        return new AdminUserDB(0L, adminUser.getFirstname(),
                adminUser.getLastname(), adminUser.getMail(),
                adminUser.getUsername(), adminUser.getPassword());
    }
    
    // Create
    public boolean insertUser(IAdminUser adminUser) {
        return AdminUserDao.get().insert(adminUserToAdminUserDB(adminUser));
    }

    // Read
    public IAdminUser getAdminUserByLogin(String login) {
        return AdminUserRepository.get().adminUserConvert(AdminUserDao.get()
                .getByFieldName(AdminUserDBFields.USERNAME.toString(), login).get(0));
    }

    public List<IAdminUser> getAdminUsers() {
        List<IAdminUser> adminUsers = new ArrayList<IAdminUser>(); 
        for (AdminUserDB adminUserDB : AdminUserDao.get().getAll()) {
            adminUsers.add(AdminUserRepository.get().adminUserConvert(adminUserDB));
        }
        return adminUsers;
    }

    public String getAdminUserFirstnameByLogin(String login) {
        return AdminUserDao.get().getByFieldName(AdminUserDBFields.USERNAME.toString(),
                login).get(0).getFirstname();
    }

    public Long getAdminUserIdByLogin(String login) {
        return AdminUserDao.get().getByFieldName(AdminUserDBFields.USERNAME.toString(),
                login).get(0).getUser_id();
    }

    // Delete
    public boolean deleteUsersByLogin(String login) {
        return deleteUsersById(getAdminUserIdByLogin(login));
    }

    public boolean deleteUsersById(Long id) {
        return AdminUserDao.get().deleteById(id);
    }

    public boolean delete(IAdminUser adminUser) {
        return deleteUsersByLogin(adminUser.getUsername());
    }

}

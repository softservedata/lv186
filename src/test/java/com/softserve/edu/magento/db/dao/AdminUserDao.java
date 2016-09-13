package com.softserve.edu.magento.db.dao;

import com.softserve.edu.magento.db.entity.AdminUserDB;
import com.softserve.edu.magento.db.entity.AdminUserDB.AdminUserDBQueries;

public class AdminUserDao extends ADaoCRUD<AdminUserDB> {
    private static volatile AdminUserDao instance = null;

    private AdminUserDao() {
        super();
        init();
    }

    public static AdminUserDao get() {
        if (instance == null) {
            synchronized (AdminUserDao.class) {
                if (instance == null) {
                    instance = new AdminUserDao();
                }
            }
        }
        return instance;
    }

    // TODO Create abstract method in ADao
    protected void init() {
        for (AdminUserDBQueries adminUserDBQueries : AdminUserDBQueries.values()) {
            sqlQueries.put(adminUserDBQueries.getQueryName(), adminUserDBQueries);
        }
    }

    protected AdminUserDB createInstance(String[] args) {
        return new AdminUserDB(
            Long.parseLong(args[0] == null ? "0" : args[0]),
            args[1] == null ? new String() : args[1],
            args[2] == null ? new String() : args[2],
            args[3] == null ? new String() : args[3],
            args[4] == null ? new String() : args[4],
            args[5] == null ? new String() : args[5]);
    }

    protected String[] getFields(AdminUserDB entity) {
        //String[] fields = new String[UserDB.class.getDeclaredFields().length];
        String[] fields = new String[6];
        fields[0] = entity.getUser_id().toString();
        fields[1] = entity.getFirstname();
        fields[2] = entity.getLastname();
        fields[3] = entity.getEmail();
        fields[4] = entity.getUsername();
        fields[5] = entity.getPassword();
        return fields;
    }

}

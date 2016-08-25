package com.softserve.edu.magento.db.services;

import java.sql.Driver;
import java.sql.SQLException;

public final class DataSourceRepository {
    private static volatile DataSourceRepository instance = null;
    private static final String FAILED_JDBC_DRIVER = "Failed to Create JDBC Driver";

    private DataSourceRepository() {
    }

    public static DataSourceRepository getInstance() {
        if (instance == null) {
            synchronized (DataSourceRepository.class) {
                if (instance == null) {
                    instance = new DataSourceRepository();
                }
            }
        }
        return instance;
    }

    public DataSource getDefault() {
        return getMySqlLocalHost();
    }

    public DataSource getMySqlLocalHost() {
        Driver jdbcDriver;
        try {
            jdbcDriver = new com.mysql.jdbc.Driver();
        } catch (SQLException e) {
            // TODO Develop Custom Exception
            throw new RuntimeException(FAILED_JDBC_DRIVER);
        }
        return new DataSource(jdbcDriver, "jdbc:mysql://localhost:3306/lv186", "root", "root");
    }

    public DataSource getMySqlTrainingLocal() {
        Driver jdbcDriver;
        try {
            jdbcDriver = new com.mysql.jdbc.Driver();
        } catch (SQLException e) {
            // TODO Develop Custom Exception
            throw new RuntimeException(FAILED_JDBC_DRIVER);
        }
        return new DataSource(jdbcDriver, "jdbc:mysql://localhost:3306/lv186", "root", "root");
    }

}

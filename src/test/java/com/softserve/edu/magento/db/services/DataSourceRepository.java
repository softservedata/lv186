package com.softserve.edu.magento.db.services;

import java.sql.Driver;
import java.sql.SQLException;

interface IUpdateDataSourceNames {
    DataSource getDataSourceFromRepository();    
}

public final class DataSourceRepository {
    
    static class MySqlDefault implements IUpdateDataSourceNames {
        public DataSource getDataSourceFromRepository() {
            return DataSourceRepository.getInstance().getDefault();
        }
    }

    static class MySqlLocalHost implements IUpdateDataSourceNames {
        public DataSource getDataSourceFromRepository() {
            return DataSourceRepository.getInstance().getMySqlLocalHost();
        }
    }

    static class MySqlTrainingLocal implements IUpdateDataSourceNames {
        public DataSource getDataSourceFromRepository() {
            return DataSourceRepository.getInstance().getMySqlTrainingLocal();
        }
    }

    public static enum DataSourceNames {
        MYSQL_DEFAULT(new MySqlDefault(), "MySqlDefault"),
        MYSQL_LOCALHOST(new MySqlLocalHost(), "MySqlLocalHost"),
        MYSQL_TRAININGLOCAL(new MySqlTrainingLocal(), "MySqlTrainingLocal");
        private IUpdateDataSourceNames updateDataSourceNames;
        private String dataSourceName;

        private DataSourceNames(IUpdateDataSourceNames updateDataSourceNames, String dataSourceName) {
            this.updateDataSourceNames = updateDataSourceNames;
            this.dataSourceName = dataSourceName;
        }

        public DataSource getDataSource() {
            return updateDataSourceNames.getDataSourceFromRepository();
        }

        @Override
        public String toString() {
            return dataSourceName;
        }
    }

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
        return new DataSource(jdbcDriver, "jdbc:mysql://localhost:3306/magento", "root", "root");
    }

    public DataSource getMySqlTrainingLocal() {
        Driver jdbcDriver;
        try {
            jdbcDriver = new com.mysql.jdbc.Driver();
        } catch (SQLException e) {
            // TODO Develop Custom Exception
            throw new RuntimeException(FAILED_JDBC_DRIVER);
        }
        return new DataSource(jdbcDriver, "jdbc:mysql://localhost:3306/magento", "root", "root");
    }

}

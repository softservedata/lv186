package com.softserve.edu.magento.db.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private final static String FAILED_REGISTRATE_DRIVER = "Failed to Registrate JDBC Driver";
    private final static String FAILED_CREATE_CONNECTION = "Failed to Create Connection";
    private final static String FAILED_CLOSE_CONNECTION = "Failed to Close Connection";
    private final static String FAILED_CONNECTION = "Connection Failed";

    //
    private static volatile ConnectionManager instance = null;
    //
    private DataSource dataSource;
    private Connection connection;

    private ConnectionManager() {
    }

    public static ConnectionManager getInstance() {
        // if (instance == null) {
        // throw new RuntimeException(FAILED_REGISTRATE_DRIVER);
        // }
        // return instance;
        return getInstance(null);
    }

    public static ConnectionManager getInstance(DataSource dataSource) {
        if (instance == null) {
            synchronized (ConnectionManager.class) {
                if (instance == null) {
                    instance = new ConnectionManager();
                }
            }
        }
        instance.checkStatus(dataSource);
        return instance;
    }

    private void checkStatus(DataSource dataSource) {
        /*-		dataSource		this.dataSource		Action
         * 			null			null				create default
         * 			null			not null			nothing
         * 			not null		null				save dataSource
         * 			not null		not null			if equals then nothing 
         */
        if (dataSource == null) {
            if (getDataSource() == null) {
                setDataSource(DataSourceRepository.getInstance().getDefault());
            }
        } else if ((getDataSource() == null) || (!getDataSource().equals(dataSource))) {
            setDataSource(dataSource);
        }
    }

    private void setDataSource(DataSource dataSource) {
        synchronized (ConnectionManager.class) {
            this.dataSource = dataSource;
            registerDriver();
            closeAllConnections();
        }
    }

    private DataSource getDataSource() {
        return this.dataSource;
    }

    private void registerDriver() {
        try {
            DriverManager.registerDriver(getDataSource().getJdbcDriver());
        } catch (SQLException e) {
            throw new RuntimeException(FAILED_REGISTRATE_DRIVER, e);
        }
    }

    public Connection getConnection() {
        if (connection == null) {
            synchronized (ConnectionManager.class) {
                try {
                    connection = DriverManager.getConnection(getDataSource().getConnectionUrl(),
                            getDataSource().getUsername(), getDataSource().getPassword());
                } catch (SQLException e) {
                    throw new RuntimeException(FAILED_CREATE_CONNECTION, e);
                }
            }
        }
        return connection;
    }

    public void beginTransaction() {
        try {
            getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            // TODO Develop Custom Exceptions
            throw new RuntimeException(FAILED_CONNECTION, e);
        }
    }

    public void commitTransaction() {
        try {
            getConnection().commit();
        } catch (SQLException e) {
            // TODO Develop Custom Exceptions
            throw new RuntimeException(FAILED_CONNECTION, e);
        }
    }

    public void rollbackTransaction() {
        try {
            getConnection().rollback();
        } catch (SQLException e) {
            // TODO Develop Custom Exceptions
            throw new RuntimeException(FAILED_CONNECTION, e);
        }
    }

    public void closeAllConnections() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(FAILED_CLOSE_CONNECTION, e);
            }
        }
    }

}

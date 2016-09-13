package com.softserve.edu.magento.db.entity;

public class AdminUserDB implements IEntity {

    public static enum AdminUserDBFields {
        USER_ID("user_id"),
        FIRSTNAME("firstname"),
        LASTNAME("lastname"),
        EMAIL("email"),
        USERNAME("username"),
        PASSWORD("password");
        //
        private String field;

        private AdminUserDBFields(String field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return field;
        }
    }

    public static enum AdminUserDBQueries {
        INSERT(QueryNames.INSERT, "INSERT INTO admin_user (firstname, lastname, email, username, password) VALUES ('%s', '%s', '%s', '%s', '%s');"),
        GET_BY_ID(QueryNames.GET_BY_ID, "SELECT user_id, firstname, lastname, email, username, password FROM admin_user WHERE user_id = %s;"),
        GET_BY_FIELD(QueryNames.GET_BY_FIELD, "SELECT user_id, firstname, lastname, email, username, password FROM admin_user WHERE %s = '%s';"),
        // GET_RANGE(QueryNames.GET_ALL, "SELECT id_user, id_role, login, passwd
        // FROM admin_user LIMIT %s, %s;"),
        GET_ALL(QueryNames.GET_ALL, "SELECT user_id, firstname, lastname, email, username, password FROM admin_user;"),
        UPDATE_BY_FIELD(QueryNames.UPDATE_BY_FIELD, "UPDATE admin_user SET %s = '%s' WHERE %s = '%s';"),
        DELETE_BY_ID(QueryNames.DELETE_BY_ID, "DELETE FROM admin_user WHERE user_id = %s;"),
        DELETE_BY_FIELD(QueryNames.DELETE_BY_FIELD, "DELETE FROM admin_user WHERE %s = '%s';");
        // DELETE_USER_BY_PARTIAL_LOGIN("DELETE dbo.Users WHERE Login LIKE
        // '%s%%';");
        //
        private QueryNames queryName;
        private String query;

        private AdminUserDBQueries(QueryNames queryName, String query) {
        //private AdminUserDBQueries(String query) {
            this.queryName = queryName;
            this.query = query;
        }

        public QueryNames getQueryName() {
            return queryName;
        }

        @Override
        public String toString() {
            return query;
        }
    }

    // class AdminUserDB
    private Long user_id;
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;

    // TODO Create Factory, Builder
    public AdminUserDB(Long user_id, String firstname, String lastname,
            String email, String username, String password) {
        this.user_id = user_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    // implements IEntity

    public Long getId() {
        return getUser_id();
    }
    
    // getters

    public Long getUser_id() {
        return user_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // setters

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

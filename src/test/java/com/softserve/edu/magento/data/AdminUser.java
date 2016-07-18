package com.softserve.edu.magento.data;

interface IAdminUsername {
    IAdminFirstname setUsername(String username);
}

interface IAdminFirstname {
    IAdminLastname setFirstname(String firstname);
}

interface IAdminLastname {
    IAdminMail setLastname(String lastname);
}

interface IAdminMail {
    IAdminPassword setMail(String mail);
}

interface IAdminPassword {
    IAdminBuild setPassword(String password);
}

interface IAdminBuild {
    IAdminUser build();
}

public class AdminUser implements IAdminFirstname, IAdminLastname, IAdminUsername, IAdminPassword, IAdminMail,
        IAdminBuild, IAdminUser {
    //
    private String username;
    private String firstname;
    private String lastname;
    private String mail;
    private String password;

    private AdminUser() {
    }

    public static IAdminUsername get() {
        return new AdminUser();
    }

    public IAdminFirstname setUsername(String username) {
        this.username = username;
        return this;
    }

    public IAdminLastname setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public IAdminMail setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public IAdminPassword setMail(String mail) {
        this.mail = mail;
        return this;
    }

    public IAdminBuild setPassword(String password) {
        this.password = password;
        return this;
    }

    public IAdminUser build() {
        return this;
    }

    // getters

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

}

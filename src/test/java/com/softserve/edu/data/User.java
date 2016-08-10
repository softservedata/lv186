package com.softserve.edu.data;

interface IFirstname {
    ILastname setFirstname(String firstname);
}

interface ILastname {
    ILogin setLastname(String lastname);
}

interface ILogin {
    IPassword setLogin(String login);
}

interface IPassword {
    IMail setPassword(String password);
}

interface IMail {
    IBuild setMail(String mail);
}

//interface IBuild {
//    User build();
//}

//6. dependency inversion (add flexibility), add interface IUser
interface IBuild {
    IUser build();
}

public class User implements IFirstname, ILastname, ILogin, IPassword, IMail, IBuild, IUser {
    private String firstname;
    private String lastname;
    private String login;
    private String password;
    private String mail;
    private String city;
    private String passport;
    
    // 1.
//    public User(String firstname, String lastname, String login, String password, String mail, String city,
//            String passport) {
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.login = login;
//        this.password = password;
//        this.mail = mail;
//        this.city = city;
//        this.passport = passport;
//    }

    // 2.
    //public User() { }
    
    // 4.
    private User() { }
    
    // 4.
//    public static User get() {
//        return new User();
//    }

    // 5.
    public static IFirstname get() {
        return new User();
    }

    // setters
    
    // 3.
    public ILastname setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ILogin setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public IPassword setLogin(String login) {
        this.login = login;
        return this;
    }

    public IMail setPassword(String password) {
        this.password = password;
        return this;
    }

    public IBuild setMail(String mail) {
        this.mail = mail;
        return this;
    }

//    public User build() {
//        return this;
//    }
    
    // 6. dependency inversion (add flexibility), add interface IUser
    public IUser build() {
        return this;
    }

    //public User setCity(String city) {
    public IUser setCity(String city) {
        this.city = city;
        return this;
    }

    //public User setPassport(String passport) {
    public IUser setPassport(String passport) {
        this.passport = passport;
        return this;
    }

    // getters
    
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }

    public String getCity() {
        return city;
    }

    public String getPassport() {
        return passport;
    }

}

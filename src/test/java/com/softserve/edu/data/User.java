package com.softserve.edu.data;

interface IUserName {
	IFirstname setUserName(String userName);
}
interface IFirstname {
    ILastname setFirstName(String firstname);
}

interface ILastname {
	IMail setLastName(String lastname);
}

interface IMail {
	IPassword setMail(String mail);
}

interface IPassword {
	IBuild setPassword(String password);
}

//interface IBuild {
//    User build();
//}

//6. dependency inversion (add flexibility), add interface IUser
interface IBuild {
    IUser build();
}

public class User implements IFirstname, ILastname, IUserName, IPassword, IMail, IBuild, IUser {
    private String userName;
	private String firstName;
    private String lastName;
    private String mail;
    private String password;

    
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
    public static IUserName get() {
        return new User();
    }

    // setters
    
    // 3.
    public IFirstname setUserName(String userName) {
        this.userName = userName;
        return this;
    }
    public ILastname setFirstName(String firstname) {
        this.firstName = firstname;
        return this;
    }

    public IMail setLastName(String lastname) {
        this.lastName = lastname;
        return this;
    }

    public IPassword setMail(String mail) {
        this.mail = mail;
        return this;
    }
    public IBuild setPassword(String password) {
        this.password = password;
        return this;
    }


    

//    public User build() {
//        return this;
//    }
    
    // 6. dependency inversion (add flexibility), add interface IUser
    public IUser build() {
        return this;
    }


    // getters
    public String getUserName() {
        return userName;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

  


}

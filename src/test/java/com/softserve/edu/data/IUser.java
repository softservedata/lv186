package com.softserve.edu.data;

public interface IUser {

    // setters
    
    IUser setCity(String city);

    IUser setPassport(String passport);

    // getters

    String getFirstname();

    String getLastname();

    String getLogin();

    String getPassword();

    String getMail();

    String getCity();

    String getPassport();

}

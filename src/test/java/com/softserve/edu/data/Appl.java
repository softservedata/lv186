package com.softserve.edu.data;

public class Appl {

    public static void main(String[] args) {
        // 1.
        //User user = new User("first", "last", "login", "password", "mail", "city", "passport");
        //
        // 2 default constructor and use setter.
//        User user = new User();
//        user.setFirstname("first");
//        user.setLastname("lastname");
//        user.setLogin("login");
//        user.setPassword("password");
//        user.setMail("mail");
//        user.setPassport("passport");
//        user.setCity("city");
        //
        // 3 fluent interface.
//        User user = new User()
//                .setFirstname("firstname")
//                .setLastname("lastname")
//                .setLogin("login")
//                .setPassword("password")
//                .setMail("mail")
//                .setCity("city")
//                .setPassport("passport");
        //
        // 4. add static factory
//        User user = User.get()
//              .setFirstname("firstname")
//              .setLastname("lastname")
//              .setLogin("login")
//              //.setPassword("password")
//              .setMail("mail")
//              .setCity("city")
//              .setPassport("passport");
        //
        // 5. add builder
//        User user = User.get()
//                .setFirstname("firstname")
//                .setLastname("lastname")
//                .setLogin("login")
//                .setPassword("password")
//                .setMail("mail")
//                .build();
//                //.setCity("city");
//        user.setCity("city");
//        //user.setLogin("login222");
//        System.out.println("User Login = " + user.setLogin("1111"));
        //
        // 6. dependency inversion (add flexibility), add interface IUser
        IUser user = User.get()
              .setFirstname("firstname")
              .setLastname("lastname")
              .setLogin("login")
              .setPassword("password")
              .setMail("mail")
              .build()
              .setCity("city");
        //user.setCity("city");
        //user.setLogin("login222");
        //System.out.println("User Login = " + user.setLogin("1111"));
        //
        System.out.println("User Login = " + user.getLogin());
    }
}

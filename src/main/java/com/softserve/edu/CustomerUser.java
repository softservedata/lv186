package com.softserve.edu;


import java.util.Arrays;
import java.util.List;

/**
 * Created by bohdan on 09.09.16.
 */
public class CustomerUser {
    public int id;
    public int group_id;
    public int default_billing;
    public int default_shipping;
    public String created_at;
    public String updated_at;
    public String created_in;
    public String dob;
    public String email;
    public String firstname;
    public String lastname;
    public int gender;
    public int store_id;
    public int website_id;
    public List<Addresses> addresses;
    public int disable_auto_group_change;
    @Override
    public String toString() {
        return "CustomerUser{" +
                "id=" + id +
                ", group_id=" + group_id +
                ", default_billing=" + default_billing +
                ", default_shipping=" + default_shipping +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", created_in='" + created_in + '\'' +
                ", dob='" + dob + '\'' +
                ", email='" + email + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", gender=" + gender +
                ", store_id=" + store_id +
                ", website_id=" + website_id +
                ", addresses=" + addresses +
                ", disable_auto_group_change=" + disable_auto_group_change +
                '}';
    }


    public class Addresses {
        public int id;
        public int customer_id;
        public Region region;
        public int region_id;
        public String country_id;
        public String[] street;
        public String telephone;
        public String postcode;
        public String city;
        public String firstname;
        public String lastname;
        public boolean default_shipping;
        public boolean default_billing;

        @Override
        public String toString() {
            return "Addresses{" +
                    "id=" + id +
                    ", customer_id=" + customer_id +
                    ", region=" + region +
                    ", region_id=" + region_id +
                    ", country_id='" + country_id + '\'' +
                    ", street=" + Arrays.toString(street) +
                    ", telephone='" + telephone + '\'' +
                    ", postcode='" + postcode + '\'' +
                    ", city='" + city + '\'' +
                    ", firstname='" + firstname + '\'' +
                    ", lastname='" + lastname + '\'' +
                    ", default_shipping=" + default_shipping +
                    ", default_billing=" + default_billing +
                    '}';
        }

        public class Region {
            public String region_code;
            public String region;
            public int region_id;

            @Override
            public String toString() {
                return "Region{" +
                        "region_code='" + region_code + '\'' +
                        ", region='" + region + '\'' +
                        ", region_id=" + region_id +
                        '}';
            }
        }
    }
}

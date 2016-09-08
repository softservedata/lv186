package com.softserve.edu.magento.pages.admin.menu.customers.editCustomer;

/**
 * Created by yaremchuk-at on 16.08.2016.
 */
public interface ICalendar {
    enum Months {
        JANUARY("Jan"), FEBRUARY("Feb"),
        MARCH("Mar"), APRIL("Apr"), MAY("May"),
        JUNE("Jun"), JULY("Jul"), AUGUST("Aug"),
        SEPTEMBER("Sep"), OCTOBER("Oct"),
        NOVEMBER("Nov"), DECEMBER("Dec");

        private String month;

        Months(String month) {
            this.month = month;
        }

        @Override
        public String toString() {
            return this.month;
        }
    }

}

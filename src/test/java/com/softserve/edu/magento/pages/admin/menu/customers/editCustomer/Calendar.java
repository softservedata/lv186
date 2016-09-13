package com.softserve.edu.magento.pages.admin.menu.customers.editCustomer;

import com.softserve.edu.magento.tools.ASearch;
import com.softserve.edu.magento.tools.Search;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Calendar implements ICalendar {
    private static volatile Calendar instance;

    private Select month;
    private Select year;
    private List<WebElement> day;
    private WebElement goToday;
    private WebElement close;

    /**
     * Constructor.
     */
    private Calendar() {
        Search.cssSelector("button.ui-datepicker-trigger.v-middle").click();

        this.month = new Select(
                Search.cssSelector("select.ui-datepicker-month"));
        this.year = new Select(
                Search.cssSelector("select.ui-datepicker-year"));
        this.day = Search.cssSelectors("table.ui-datepicker-calendar a");
        this.goToday = Search.cssSelector("button[data-handler='today']");
        this.close = Search.cssSelector("button[data-handler='hide']");
        System.out.println("Constructor done!");
    }

    /**
     * Threadsafe initializer.
     */
    public static Calendar initCalendar() {
        if (instance == null) {
            synchronized (Calendar.class) {
                instance = new Calendar();
            }
        }
        return instance;
    }

    /*
     * Getters.
     */
    public Select getMonth() {
        return this.month;
    }

    public Select getYear() {
        return this.year;
    }

    public List<WebElement> getDay() {
        return this.day;
    }

    public WebElement getGoToday() {
        return this.goToday;
    }

    public WebElement getClose() {
        return this.close;
    }

    public void setMonth(Select month) {
        this.month = month;
    }

    public void setYear(Select year) {
        this.year = year;
    }

    public void setDay(List<WebElement> day) {
        this.day = day;
    }

    /**
     * Sets the date of birth from String
     * @param day String representation of day
     * @param month String representation of month
     * @param year String representation of year
     */
    public void setStringData (String day, String month, String year) {
        Search.cssSelector("input[name='customer[dob]']").click();
        String result = new String();
        result = String.format("%s/%s/%s", day, month, year);
        Search.cssSelector("input[name='customer[dob]']").sendKeys(result);
    }

    /**
     * Sets the date of birth with the calendar component.
     * @param day the day to be selected.
     * @param month the month to be selected.
     * @param year the year to be selected.
     */
    public void setData (String day, Calendar.Months month, String year){
       // -------------------------------- MONTH -----------------------------
        Search.cssSelector("select.ui-datepicker-month").click();
        List<WebElement> months = Search.cssSelectors("select.ui-datepicker-month option");
        List<String> monthsString = new ArrayList<>();
        for (WebElement e : months){
            monthsString.add(e.getText());
        }
        ASearch.getWebDriver().switchTo().activeElement();
        getMonth().selectByVisibleText(monthsString.get(monthsString.indexOf(month.toString())));
        //-------------------------------- YEAR -----------------------------
        setYear(new Select(Search.cssSelector("select.ui-datepicker-year")));
        Search.cssSelector("select.ui-datepicker-year").click();
        List<WebElement> years = Search.cssSelectors("select.ui-datepicker-year option");
        List<String> yearsString = new ArrayList<>();
        for(WebElement e : years){
            yearsString.add(e.getText());
        }
        ASearch.getWebDriver().switchTo().activeElement();
        getYear().selectByVisibleText(yearsString.get(yearsString.indexOf(year)));
        //-------------------------------- DAY -----------------------------
        setDay(Search.cssSelectors("table.ui-datepicker-calendar a"));
        getDay().get(Integer.parseInt(day)-1).click();
    }

    /**
     * Sets the date of birth with the calendar component.
     * @param day the day to be selected.
     * @param month the month to be selected.
     * @param year the year to be selected.
     */
    public void setData (int day, int month, int year){
        // -------------------------------- MONTH -----------------------------
        Search.cssSelector("select.ui-datepicker-month").click();
        ASearch.getWebDriver().switchTo().activeElement();
        getMonth().selectByValue(String.valueOf(day-1));
        //-------------------------------- YEAR -----------------------------
        setYear(new Select(Search.cssSelector("select.ui-datepicker-year")));
        Search.cssSelector("select.ui-datepicker-year").click();
        ASearch.getWebDriver().switchTo().activeElement();
        getYear().selectByValue(String.valueOf(year));
        //-------------------------------- DAY -----------------------------
        setDay(Search.cssSelectors("table.ui-datepicker-calendar a"));
        getDay().get(day-1).click();
    }

}

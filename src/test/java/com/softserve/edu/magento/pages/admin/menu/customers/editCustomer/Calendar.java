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
public class Calendar {
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
        this.month = new Select(
                Search.cssSelector("select[data-handler='selectMonth']"));
        this.year = new Select(
                Search.cssSelector("select[data-handler='selectYear']"));
        this.day = Search.cssSelectors("table.ui-datepicker-calendar a");
        this.goToday = Search.cssSelector("button[data-handler='today']");
        this.close = Search.cssSelector("button[data-handler='hide']");
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

    public String setStringData (String day, String month, String year) {
        String result = new String();
        return result = String.format("%s/%s/%s", day, month, year);
    }

    public void setData (String day, String month, String year){
        Search.cssSelector("button.ui-datepicker-trigger.v-middle").click();
        Select monthSelect = new Select(Search.cssSelector("select.ui-datepicker-month"));
        Search.cssSelector("select.ui-datepicker-month").click();
        List<WebElement> months = Search.cssSelectors("select.ui-datepicker-month option");
        System.out.println(months.size());
        List<String> monthsString = new ArrayList<String>();
        for (WebElement e : months){
            monthsString.add(e.getText());
        }
        System.out.println(monthsString.size());
        int index = monthsString.indexOf(month);
        System.out.println(index);
        ASearch.getWebDriver().switchTo().activeElement();
        monthSelect.selectByVisibleText(monthsString.get(index));
    }

}

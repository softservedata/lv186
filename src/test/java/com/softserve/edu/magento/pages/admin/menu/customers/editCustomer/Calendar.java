package com.softserve.edu.magento.pages.admin.menu.customers.editCustomer;

import com.softserve.edu.magento.tools.Search;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by yaremchuk-at on 15.08.2016.
 */
public class Calendar {
    private Select month;
    private Select year;
    private List<WebElement> day;
    private WebElement goToday;
    private WebElement close;

    public Calendar() {
        this.month = new Select(
                Search.cssSelector("select[data-handler='selectMonth']"));
        this.year = new Select(
                Search.cssSelector("select[data-handler='selectYear']"));
        this.day = Search.cssSelectors("");
    }
}

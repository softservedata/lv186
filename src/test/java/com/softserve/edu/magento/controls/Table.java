package com.softserve.edu.magento.controls;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.softserve.edu.magento.tools.Search;

/**
 * WebElement pretable = Search.xpath("");
 * ITable table = new Table(pretable);
 */
public final class Table implements ITable {
    private static final String OUT_ROWS_RANGE = "Out of rows range. Count row in table is %d, required %d";
    private static final String OUT_COLUMN_RANGE =  "Out of column range. Count column in table is %d, required %d";
    //
    private WebElement tableWebElement;
    private List<WebElement> tableHeader;
    private List<List<WebElement>> tableBody;

    public Table(WebElement tableWebElement) {
        this.tableWebElement = tableWebElement;
        initTable();
    }

    private void initTable() {
        // TODO
        this.tableHeader = new ArrayList<WebElement>();
        this.tableBody = new ArrayList<List<WebElement>>();
        //
        tableHeader = Search.tagNames("th", tableWebElement);
        WebElement tBody = Search.tagName("tbody", tableWebElement);
        for (WebElement tabteRow : Search.tagNames("tr", tBody)) {
            tableBody.add(Search.tagNames("td", tabteRow));
        }
    }

    public WebElement getTableWebElement() {
        return tableWebElement;
    }

    public List<WebElement> getHeader() {
        return tableHeader;
    }

    public List<List<WebElement>> getTableBody() {
        return tableBody;
    }

    public List<WebElement> getRowByIndex(int rowIndex) {
        if (rowIndex >= getTableBody().size()) {
            throw new RuntimeException(String.format(OUT_ROWS_RANGE,
                    getTableBody().size(), rowIndex));
        }
        return getTableBody().get(rowIndex);
    }

    public List<WebElement> getRowByValueInColumn(String value, int columnIndex) {
        return getRowByIndex(getRowIndexByValueInColumn(value, columnIndex));
    }

    public int getRowIndexByValueInColumn(String value, int columnIndex) {
        int rowIndex = -1;
        int i = -1;
        for (List<WebElement> row : getTableBody()) {
            i++;
            if (row.get(columnIndex).getText()
                    .trim().toLowerCase().equals(value.trim().toLowerCase())) {
                rowIndex = i;
                break;
            }
        }
        return rowIndex;
    }

    public List<WebElement> getColumnByIndex(int columnIndex) {
        List<WebElement> column = new ArrayList<>();
        if (columnIndex >= getTableBody().get(0).size()) {
            throw new RuntimeException(String.format(OUT_COLUMN_RANGE,
                    getTableBody().get(0).size(), columnIndex));
        }
        for (List<WebElement> row : getTableBody()) {
            column.add(row.get(columnIndex));
        }
        return column;
    }

    public List<WebElement> getColumnByValueInRow(String value, int rowIndex) {
        int columnIndex =-1;
        int i=-1;
        for (WebElement cell : getRowByIndex(rowIndex)) {
            i++;
            if (cell.getText().trim().toLowerCase().equals(value.trim().toLowerCase())) {
                columnIndex = i;
                break;
            }
        }
        return getColumnByIndex(columnIndex);
    }

    public List<WebElement> getColumnByValueOfHeader(String value) {
        return getColumnByIndex(getColumnIndexByValueOfHeader(value));
    }

    public int getColumnIndexByValueOfHeader(String value) {
        int columnIndex =-1;
        int i=-1;
        for (WebElement cell : getHeader()) {
            i++;
            if (cell.getText().trim().toLowerCase().equals(value.trim().toLowerCase())) {
                columnIndex = i;
                break;
            }
        }
        return columnIndex;
    }

    public WebElement getCell(int rowIndex, int columnIndex) {
        return getTableBody().get(rowIndex).get(columnIndex);
    }

    public void clickEditLink (){
        getColumnByValueOfHeader("Action")
                .get(getRowIndexByValueInColumn("garasym@gmail.com", getColumnIndexByValueOfHeader("Email")))
                .findElement(By.cssSelector("a")).click();
    }
//    int columnIndex = getColumnIndexByValueOfHeader("Name");
//    getRowByValueInColumn("Yaroslav Harasym", columnIndex).get(16).click();
}

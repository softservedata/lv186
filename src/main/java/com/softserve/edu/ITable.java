package com.softserve.edu;

import java.util.List;

import org.openqa.selenium.WebElement;

public interface ITable {

    List<WebElement> getHeader();

    List<WebElement> getRowByIndex(int rowIndex);

    List<WebElement> getRowByValueInColumn(String value, int columnIndex);

    int getRowIndexByValueInColumn(String value, int columnIndex);

    List<WebElement> getColumnByIndex(int columnIndex);

    List<WebElement> getColumnByValueInRow(String value, int rowIndex);

    List<WebElement> getColumnByValueOfHeader(String value);

    int getColumnIndexByValueOfHeader(String value);

    WebElement getCell(int rowIndex, int columnIndex);

}

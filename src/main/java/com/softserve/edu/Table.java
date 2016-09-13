package com.softserve.edu;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;




/**
 * WebElement pretable = Search.xpath("");
 * ITable table = new Table(pretable);
 */
//public final class Table {// implements ITable {
//    private WebElement tableWebElement;
//    private List<WebElement> tableHeader;
//    private List<List<WebElement>> tableBody;
//
//    public Table(WebElement tableWebElement) {
//        this.tableWebElement = tableWebElement;
//        initTable();
//    }
//
//    private void initTable() {
//        // TODO
//        this.tableHeader = new ArrayList<WebElement>();
//        this.tableBody = new ArrayList<List<WebElement>>();
//
//        tableHeader = Search.tagNames("th", tableWebElement);
//        WebElement tBody = Search.tagName("tbody", tableWebElement);
//        for (WebElement tabteRow : Search.tagNames("tr", tBody)) {
//            tableBody.add(Search.tagNames("td", tabteRow));
//        }
//    }
//
//    public WebElement getTableWebElement() {
//        return tableWebElement;
//    }
//
//    private List<WebElement> getTableHeader() {
//        return tableHeader;
//    }
//
//    private List<List<WebElement>> getTableBody() {
//        return tableBody;
//    }
//
//    /*
//     * public List<ILabelClickable> getHeader() { List<ILabelClickable>
//     * rowWithLabelType = new ArrayList<>(); for (ControlWrapper cell :
//     * control.getThead()) {
//     * rowWithLabelType.add(LabelClickable.get(Label.getByControl(cell,
//     * control.getControlLocation()))); } return rowWithLabelType; } public
//     * List<ILabelClickable> getRowByIndex(int rowIndex) { List<ILabelClickable>
//     * rowWithLabelType = new ArrayList<>(); for (ControlWrapper cell :
//     * control.getTbody().get(rowIndex)) {
//     * rowWithLabelType.add(LabelClickable.get(Label.getByControl(cell,
//     * control.getControlLocation()))); } return rowWithLabelType; } public
//     * List<ILabelClickable> getRowByValueInColumn(String value, int
//     * columnIndex) { return getRowByIndex(getRowIndexByValueInColumn(value,
//     * columnIndex)); } public int getRowIndexByValueInColumn(String value, int
//     * columnIndex) { int row; for (row = 0; row < control.getTbody().size();
//     * row++) { if
//     * (control.getTbody().get(row).get(columnIndex).getText().toLowerCase().
//     * equals(value.toLowerCase())) { break; } } if (row >=
//     * control.getTbody().size()) { // TODO Develop My Exception throw new
//     * RuntimeException("Value " + value + " not found"); } return row; } public
//     * List<ILabelClickable> getColumnByIndex(int columnIndex) {
//     * List<ILabelClickable> columnWithLabelType = new ArrayList<>(); int row;
//     * for (row = 0; row < control.getTbody().size(); row++) {
//     * columnWithLabelType.add(LabelClickable.get(
//     * Label.getByControl(control.getTbody().get(row).get(columnIndex),
//     * control.getControlLocation()))); } return columnWithLabelType; } public
//     * List<ILabelClickable> getColumnByValueInRow(String value, int rowIndex) {
//     * int column; for (column = 0; column <
//     * control.getTbody().get(rowIndex).size(); column++) { if
//     * (control.getTbody().get(rowIndex).get(column).getText().toLowerCase().
//     * equals(value.toLowerCase())) { break; } } if (column >=
//     * control.getTbody().get(rowIndex).size()) { // TODO Develop My Exception
//     * throw new RuntimeException("Value " + value + " not found"); } return
//     * getColumnByIndex(column); } public List<ILabelClickable>
//     * getColumnByValueOfHeader(String value) { return
//     * getColumnByIndex(getColumnIndexByValueOfHeader(value)); } public int
//     * getColumnIndexByValueOfHeader(String value) { int column; for (column =
//     * 0; column < control.getThead().size(); column++) { if
//     * (control.getThead().get(column).getText().toLowerCase().equals(value.
//     * toLowerCase())) { break; } } if (column >= control.getThead().size()) {
//     * // TODO Develop My Exception throw new RuntimeException("Value " + value
//     * + " not found"); } return column; } public ILabel getCell(int rowIndex,
//     * int columnIndex) { return
//     * Label.getByControl(control.getTbody().get(rowIndex).get(columnIndex),
//     * control.getControlLocation()); }
//     */
//}

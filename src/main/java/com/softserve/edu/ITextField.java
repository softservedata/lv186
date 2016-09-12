package com.softserve.edu;

public interface ITextField extends ILabelClickable {

    void clear();

    void sendKeys(String text);
    
    void sendKeysClear(String text);

}

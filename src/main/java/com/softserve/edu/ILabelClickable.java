package com.softserve.edu;

public interface ILabelClickable extends ILabel {
    
    boolean isClickable();

    void click();

    void setFocus();

}

package com.gmail.pages;

import com.gmail.UI.UIDriver;

public class BasePage {
    protected UIDriver UIDriver;

    public BasePage() {
        UIDriver = UIDriver.getUIDriver();
    }

    public void goToURL() {
        UIDriver.navigate("http://accounts.google.com/");
    }
}

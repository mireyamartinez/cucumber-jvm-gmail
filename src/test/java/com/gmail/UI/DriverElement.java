package com.gmail.UI;

public class DriverElement {
    private DriverElementLocator locator;
    private String locatorValue;

    public DriverElement(DriverElementLocator locator, String locatorValue) {
        this.locator = locator;
        this.locatorValue = locatorValue;
    }

    public DriverElementLocator getLocatorType() {
        return locator;
    }

    public String getLocatorValue() {
        return locatorValue;
    }
}

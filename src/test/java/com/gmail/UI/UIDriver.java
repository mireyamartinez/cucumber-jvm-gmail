package com.gmail.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UIDriver {
    private WebDriver webDriver = null;
    private static UIDriver uiDriver = null;

    private UIDriver() {
        webDriver = new FirefoxDriver();
    }

    public static UIDriver getUIDriver() {
        if (uiDriver == null)
            uiDriver = new UIDriver();

        return uiDriver;
    }

    public void click(DriverElement driverElement) {
        webDriver.findElement(getUILocator(driverElement)).click();
    }

    public By getUILocator(DriverElement driverElement) {
        switch (driverElement.getLocatorType()) {
            case ID:
                return By.id(driverElement.getLocatorValue());
            case CSS:
                return By.cssSelector(driverElement.getLocatorValue());
            default:
                return By.xpath(driverElement.getLocatorValue());
        }
    }

    public void navigate(String Url) {
        webDriver.navigate().to(Url);
    }

    public void quit() {
        if (uiDriver != null) {
            webDriver.quit();
            uiDriver = null;
        }
    }

    public void type(DriverElement driverElement, String text) {
        webDriver.findElement(getUILocator(driverElement)).clear();
        webDriver.findElement(getUILocator(driverElement)).sendKeys(text);

    }

    public String getText(DriverElement driverElement) {
        waitForDriverElement(driverElement);
        return webDriver.findElement(getUILocator(driverElement)).getText();
    }

    public void waitForDriverElement(DriverElement driverElement) {
        try {
            (new WebDriverWait(webDriver, 10)).until(ExpectedConditions.presenceOfElementLocated(getUILocator(driverElement)));
        } catch (Exception e) {
            throw new IllegalStateException("Element did not exist");
        }
    }
}

package com.gmail.steps;

import com.gmail.UI.UIDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CukeHooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("Before Scenario");
    }

    @After
    public void afterScenario(Scenario scenario) {
        System.out.println("After Scenario");
        UIDriver uiDriver = UIDriver.getUIDriver();
        uiDriver.quit();
    }
}

package com.gmail;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/cucumber", "json:target/cucumber/cucumber.json"},
        features = {"src/test/java/resources/features/"},
        glue = {"com.gmail.steps"},
        tags = {"@gmail"})
public class CukeRunner {
}

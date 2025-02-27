package com.shiv.test.cucmber.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber; 

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.shiv.test.cucmber.steps"},
        features = "src/test/resources/features",
        plugin = {"pretty", "html:target/cucumber-reports/cucumber.html", "json:target/cucumber-reports/cucumber.json"},
        tags = "@Mercari"
)

public class Runner {
	
}
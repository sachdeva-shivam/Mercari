package com.shiv.test.cucmber.hooks;

import javax.inject.Inject;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;

public class Hooks {

    private final WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);
    
    @Inject
    public Hooks(final WebDriver driver) {
        this.driver = driver;
    }

    @Before
    public void start(Scenario scenario) {
       System.out.println("Test started");
       logger.info("Initiating scenario: {}", scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        // Take a screenshot if the scenario fails
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
            logger.error("Scenario failed: {}. Screenshot taken.", scenario.getName());
        }

        // Close the WebDriver
        if (driver != null) {
            driver.quit();
            logger.info("WebDriver closed for scenario: {}", scenario.getName());
        }
    }
}

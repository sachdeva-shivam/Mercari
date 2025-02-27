package com.shiv.test.cucmber.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.shiv.test.cucmber.guice.provider.WebDriverProvider;


import org.openqa.selenium.WebDriver;

public final class ProjectModule extends AbstractModule {
    @Override
    public void configure() {
        bind(WebDriver.class).toProvider(WebDriverProvider.class).in(Singleton.class);
    }
}
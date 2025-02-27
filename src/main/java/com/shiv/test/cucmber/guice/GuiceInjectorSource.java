package com.shiv.test.cucmber.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

import io.cucumber.guice.CucumberModules;
import io.cucumber.guice.InjectorSource;


public class GuiceInjectorSource implements InjectorSource {
    @Override
    public Injector getInjector() {
    	return Guice.createInjector(new ProjectModule(), CucumberModules.createScenarioModule());
    }
}
package com.mygdx.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src\\com\\mygdx\\test\\feature",
        tags = {"@probar"}

)

public class RunCukesTest {

}

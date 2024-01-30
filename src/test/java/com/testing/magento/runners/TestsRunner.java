package com.testing.magento.runners;

import com.testing.magento.hooks.Hooks;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-report/cucumber.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        tags = "@regression",
        features = "src/test/resources/features"
        , glue = {"com.testing.magento.stepsDefinition", "com.testing.magento.hooks"}
)
public class TestsRunner extends Hooks {
}
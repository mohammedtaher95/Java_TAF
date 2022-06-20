package testRunner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = {//"src/test/java/features/Login.feature",
                             "src/test/java/features/Register.feature" },
        glue = {"stepDefinitions", "config"},
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber-report.json"},
        publish = true)
public class Runner extends AbstractTestNGCucumberTests{

    public void setUp(){

    }
}

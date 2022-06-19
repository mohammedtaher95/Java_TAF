package config;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ScreenShotHelper;

import java.io.IOException;

public class Hooks extends EnvironmentConfigurations {

    @Before
    public void StartingDriver() throws IOException {
        setUp();
    }

    @After
    public void screenShotOnFailure(Scenario scenario) throws IOException {

        if(scenario.isFailed())
        {
            System.out.println("Failed!");
            System.out.println("Taking Screenshot....");
            ScreenShotHelper.CaptureScreenshot(getDriver(), scenario.getName());
        }

    }

    @After(order = 2)
    public void QuittingDriver()
    {
        quitDriver();
    }
}

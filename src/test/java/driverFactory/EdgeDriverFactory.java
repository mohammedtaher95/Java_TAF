package driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverFactory extends DriverManagerAbstract {

    @Override
    protected void startDriver() {
        WebDriverManager.edgedriver().cachePath("drivers").setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }
}

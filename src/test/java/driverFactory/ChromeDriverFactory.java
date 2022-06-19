package driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverFactory extends DriverManagerAbstract{

    @Override
    protected void startDriver() {
        WebDriverManager.chromedriver().cachePath("drivers").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
}

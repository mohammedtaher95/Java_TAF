package config;

import driverFactory.DriverManagerAbstract;
import driverFactory.DriverManagerFactoryAbstract;
import constants.DriverType;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.annotations.Parameters;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import static utilities.PropertiesHandler.readPropertyFile;

public class EnvironmentConfigurations {

    protected Properties prop;
    protected String URL;
    protected static String envType;
    protected String browserName;

    private final ThreadLocal<DriverManagerAbstract> DriverManager = new ThreadLocal<>();
    private static final ThreadLocal<WebDriver> Driver = new ThreadLocal<>();


    public void setUp() throws IOException {

        prop = readPropertyFile("properties/environment.properties");

        envType = prop.getProperty("ENV_TYPE");
        browserName = prop.getProperty("BROWSER_NAME");
        URL = prop.getProperty("TEST_BASE_URL");

        if(envType.equalsIgnoreCase("local"))
        {
            LocalEnvInit();
        }
        if(envType.equalsIgnoreCase("Remote"))
        {
            RemoteEnvInit();
        }
    }

    public void LocalEnvInit(){
        setDriverManager(DriverManagerFactoryAbstract.getManager(DriverType.valueOf(browserName.toUpperCase())));
        setDriver(getDriverManager().getDriver());
        System.out.println("CURRENT THREAD: " + Thread.currentThread().getId() + ", " +
                "DRIVER = " + getDriver());
    }

    @Parameters(value = {"browser"})
    public void RemoteEnvInit() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", browserName);
        Driver.set(new RemoteWebDriver(new URL(prop.getProperty("REMOTE_ENV_URL")),caps));
        Driver.get().manage().window().maximize();
        Driver.get().navigate().to(URL);
    }

    public void quitDriver()
    {
        getDriver().manage().deleteAllCookies();
        getDriver().quit();
        Driver.remove();
    }

    /////////////////////////////Getters & Setters///////////////////////////////////////////////////

    private void setDriver(WebDriver driver){
        Driver.set(driver);
    }
    public static WebDriver getDriver()
    {
        return Driver.get();
    }

    private void setDriverManager(DriverManagerAbstract driverManager){
        this.DriverManager.set(driverManager);
    }

    protected DriverManagerAbstract getDriverManager(){
        return this.DriverManager.get();
    }

}

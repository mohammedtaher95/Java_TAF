package driverFactory;

import constants.DriverType;

public class DriverManagerFactoryAbstract {

    public static DriverManagerAbstract getManager(DriverType driverType){
        switch (driverType){
            case CHROME:
            {
                return new ChromeDriverFactory();
            }
            case FIREFOX:
            {
                return new FirefoxDriverFactory();
            }
            case EDGE:
            {
                return new EdgeDriverFactory();
            }
            default:
                throw new IllegalStateException("Unexpected value: " + driverType);
        }
    }
}

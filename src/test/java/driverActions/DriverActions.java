package driverActions;

import config.EnvironmentConfigurations;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class DriverActions {

    public WebDriver driver;
    public JavascriptExecutor JSE;
    public String URL = "http://automationpractice.com/";

    public DriverActions(){
        this.driver = EnvironmentConfigurations.getDriver();
        PageFactory.initElements(driver, this);
        driver.navigate().to(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void ClickButton(By btn)
    {
        WebElement button = driver.findElement(btn);
        button.click();
    }

    public void Fill_in_Text(By field ,String value)
    {
        WebElement Field = driver.findElement(field);
        Field.clear();
        Field.sendKeys(value);
    }

    public boolean ElementDisplayed(By by)
    {
        if(driver.findElement(by).isDisplayed())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}

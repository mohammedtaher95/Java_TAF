package driverActions;

import config.EnvironmentConfigurations;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class DriverActions {

    public WebDriver driver;
    public JavascriptExecutor JSE;
    public String URL = "http://automationpractice.com/";
    public Select Dropdown;
    public static WebDriverWait wait;

    public DriverActions(){
        this.driver = EnvironmentConfigurations.getDriver();
        PageFactory.initElements(driver, this);
        driver.navigate().to(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
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
        return driver.findElement(by).isDisplayed();
    }

    public void SelectItemByIndex(By by, int index)
    {
        Dropdown = new Select(driver.findElement(by));
        Dropdown.selectByIndex(index);
    }

    public void SelectItemByText(By by, String text)
    {
        Dropdown = new Select(driver.findElement(by));
        Dropdown.selectByVisibleText(text);
    }

    public String GetElementText(By by)
    {
        String text = driver.findElement(by).getText();
        return text;
    }

    public static void WaitForVisibility(By by)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}

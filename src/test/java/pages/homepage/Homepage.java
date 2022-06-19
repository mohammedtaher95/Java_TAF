package pages.homepage;

import driverActions.DriverActions;
import org.openqa.selenium.By;

public class Homepage extends DriverActions {

    By SignInLink = By.cssSelector("a.login");

    public void openLoginPage()
    {
        ClickButton(SignInLink);
    }

}

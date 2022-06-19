package pages.loginPage;

import driverActions.DriverActions;
import org.openqa.selenium.By;

public class LoginPage extends DriverActions {

    public LoginPage() {
        super();
    }

    By EmailField = By.id("email");
    By PasswordField = By.id("passwd");
    public By LoginBtn = By.id("SubmitLogin");
    By EmailRegisterField = By.id("email_create");
    By RegisterBtn = By.id("SubmitCreate");

    public void userLogin(String email, String password)
    {
        Fill_in_Text(EmailField, email);
        Fill_in_Text(PasswordField, password);
        ClickButton(LoginBtn);
    }

    public void userStartRegistration(String email)
    {
        Fill_in_Text(EmailRegisterField, email);
        ClickButton(RegisterBtn);
    }
}

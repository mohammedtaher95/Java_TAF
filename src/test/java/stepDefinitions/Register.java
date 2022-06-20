package stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.homepage.Homepage;
import pages.loginPage.LoginPage;
import pages.registrationPage.RegistrationPage;


public class Register {

    Homepage homepage;
    LoginPage loginpage;
    RegistrationPage RegisterPage;


    @Given("the user opened login page")
    public void the_user_opened_login_page() {
        homepage = new Homepage();
        loginpage = new LoginPage();
        RegisterPage = new RegistrationPage();

        homepage.openLoginPage();

    }

    @When("user enters his email for the first time and clicks on Create an account button")
    public void user_enters_his_email_for_the_first_time() {
        loginpage.userStartRegistration();
    }

    @Then("Registration page should be displayed successfully")
    public void registration_page_should_be_displayed_successfully() {
        RegisterPage.ElementDisplayed(RegisterPage.Header);
        System.out.println(RegisterPage.GetElementText(RegisterPage.Header));
//        Assert.assertTrue(RegisterPage.GetElementText(RegisterPage.Header)
//                .equalsIgnoreCase(RegisterPage.PageHeader));
    }
    @When("user fills his own data and Clicks on Register Button")
    public void user_fills_his_own_data_and_clicks_on_register_button() {
        RegisterPage.FillRegistrationForm();
    }
    @Then("User should be registered successfully")
    public void user_should_be_registered_successfully() {
        Assert.assertTrue(RegisterPage.ElementDisplayed(RegisterPage.SignOutlink));
        Assert.assertTrue(RegisterPage.ElementDisplayed(RegisterPage.FullName));
        Assert.assertTrue(RegisterPage.GetElementText(RegisterPage.SuccessMessage)
                .equalsIgnoreCase(RegisterPage.Message));
    }
}

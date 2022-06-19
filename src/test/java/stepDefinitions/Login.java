package stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.homepage.Homepage;
import pages.loginPage.LoginPage;

import java.io.IOException;

public class Login{

    Homepage homepage;
    LoginPage loginpage;

    @Given("the user opened the homepage")
    public void the_user_opened_the_homepage() throws IOException {
        homepage = new Homepage();
        loginpage = new LoginPage();
        //Assert.assertTrue(homepage.SignInLink.isDisplayed());
    }
    @When("he clicks on Sign in button")
    public void he_clicks_on_sign_in_button() {
       homepage.openLoginPage();
    }
    @Then("Login page should be opened successfully")
    public void login_page_should_be_opened_successfully() {
        Assert.assertTrue(homepage.ElementDisplayed(loginpage.LoginBtn));
    }
}

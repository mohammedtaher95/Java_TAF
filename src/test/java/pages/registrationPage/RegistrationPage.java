package pages.registrationPage;

import driverActions.DriverActions;
import org.openqa.selenium.By;
import utilities.UserFormData;

public class RegistrationPage extends DriverActions {

    public By Header = By.cssSelector("h1.page-heading");
    By MaleGender = By.id("id_gender1");
    By FemaleGender = By.id("id_gender2");
    By FirstName = By.id("customer_firstname");
    By LastName = By.id("customer_lastname");
    By Password = By.id("passwd");
    By Day = By.id("days");
    By Month = By.id("months");
    By Year = By.id("years");

    By Address = By.id("address1");
    By City = By.id("city");
    By State = By.id("id_state");
    By PostalCode = By.id("postcode");
    By MobileNumber = By.id("phone_mobile");
    By AddressAlias = By.id("alias");

    By RegisterButton = By.id("submitAccount");
    public By FullName = By.cssSelector("a.account");
    public By SignOutlink = By.cssSelector("a.logout");
    public By SuccessMessage = By.cssSelector("p.info-account");

    public String PageHeader = "Create an account";
    public String Message = "Welcome to your account. Here you can manage all of your personal information and orders.";
    private final UserFormData user = new UserFormData();


    public void FillRegistrationForm()
    {
        ClickButton(MaleGender);
        Fill_in_Text(FirstName, user.getFirstName());
        Fill_in_Text(LastName, user.getLastName());
        Fill_in_Text(Password, user.getOldPassword());
        SelectItemByIndex(Day, 1);
        SelectItemByIndex(Month, 1);
        SelectItemByIndex(Year, 20);
        Fill_in_Text(Address, user.getAddress());
        Fill_in_Text(City, user.getCity());
        SelectItemByIndex(State, 2);
        Fill_in_Text(PostalCode, user.getPostalCode());
        Fill_in_Text(MobileNumber, user.getPhoneNumber());
        System.out.println(user.getPhoneNumber());
        Fill_in_Text(AddressAlias, user.getAddress());
        ClickButton(RegisterButton);
    }

}

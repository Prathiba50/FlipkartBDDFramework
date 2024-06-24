package tests;

import appmanager.HelperBase;
import cucumber.api.java.en.*;
import org.springframework.beans.factory.annotation.Autowired;
import pages.HrmPage;

public class Hrm extends TestBase {

    @Autowired
    HrmPage  hrmPage;

    HelperBase helperbase = new HelperBase();

    @Given("^User launches the HRM application with: \"([^\"]*)\"$")
    public void user_launches_the_HRM_application_with(String arg1) throws Throwable {
        helperbase.checkLogInUserHRM(arg1);



    }

    @When("^user fetch and validate List of holidays$")
    public void user_fetch_and_validate_List_of_holidays() throws Throwable {
        hrmPage.validateHolidayList();
    }

    @Then("^User validate Important Contacts: \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_validate_Important_Contacts_and_and_and(String arg1, String arg2, String arg3, String arg4) throws Throwable {

    }

    @Then("^user validate phone number of each department in an Important Contacts$")
    public void user_validate_phone_number_of_each_department_in_an_Important_Contacts() throws Throwable {
        hrmPage.validatePhoneNumberInImportantContacts();
    }

    @Given("^User launches the Flipkart applicatione$")
    public void User_launches_the_Flipkart_applicatione() throws Throwable {
        helperbase.launchApplication();
    }

    @When("^User fill required details in request WFH$")
    public void user_fill_required_details_in_request_WFH() throws Throwable {
        hrmPage.enterValidDataInRequestWFH();

    }


}

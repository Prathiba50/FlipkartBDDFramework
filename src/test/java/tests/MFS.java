package tests;

import appmanager.HelperBase;
import cucumber.api.java.en.*;
import org.springframework.beans.factory.annotation.Autowired;
import pages.MFSPage;

public class MFS {

    @Autowired
    MFSPage mfsPage;

    HelperBase helperbase = new HelperBase();

    @Given("^User login to application: \"([^\"]*)\"$")
    public void user_login_to_application(String arg1) throws Throwable {
        helperbase.checkLogInUserMFS(arg1);
    }


    @When("^User Validate application by Entering country Father or Mother: \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_Validate_application_by_Entering_country_Father_or_Mother_and_and(String arg1, String arg2, String arg3) throws Throwable {
        mfsPage.validateAllQuestions(arg1,arg2,arg3);
    }

    @When("^User enters all required details and save: \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_enters_all_required_details_and_save_and_and_and_and_and_and_and_and(String Name, String Business, String PrimaryEmail, String ContactNumber, String BankAccountNum, String locality, String lang, String protocolVer, String bnk) throws Throwable {
        mfsPage.registerNewMerchant(Name, Business, PrimaryEmail, ContactNumber, BankAccountNum,locality, lang, protocolVer, bnk);

    }

    @Then("^user selects status and click save: \"([^\"]*)\"$")
    public void user_selects_status_and_click_save(String status) throws Throwable {
        mfsPage.selectStatusAndClickSave(status);

    }

    @Then("^Userenters all required details to  create new rule: \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userenters_all_required_details_to_create_new_rule_and_and_and_and_and_and_and_and_and_and(String Name, String description, String ruleFor, String serviceSelectOptionTxt, String partyAttribute,String conditonBalance,
                                                                                                           String balanceOperatorTxt, String balanceinput,String ExpOutput,String  TransactionFlag,String category) throws Throwable {
        mfsPage.createRule(Name,description,ruleFor,serviceSelectOptionTxt,partyAttribute,conditonBalance,
                balanceOperatorTxt,balanceinput,ExpOutput,TransactionFlag,category);
    }

    @Then("^User Verify success message:\"([^\"]*)\"$")
    public void user_Verify_success_message(String message) throws Throwable {
        mfsPage.verifySuccessMessage(message);
    }




}

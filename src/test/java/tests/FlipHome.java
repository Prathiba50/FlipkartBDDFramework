package tests;

import appmanager.HelperBase;
import cucumber.api.java.en.*;
import org.springframework.beans.factory.annotation.Autowired;
import pages.FlipHomePage;


public class FlipHome {

    @Autowired
    FlipHomePage fliphomepage;

    HelperBase helperbase = new HelperBase();

    @Given("^User launches the Flipkart application$")
    public void user_launches_the_Flipkart_application() throws Throwable {
        helperbase.checkLogInUser1();
    }

    @When("^User Verify the loading time of the home page$")
    public void
    user_Verify_the_loading_time_of_the_home_page() throws Throwable {
        fliphomepage.verifyLoadingTimeOfHomePage();
    }

    @Then("^User searches for the record:\"([^\"]*)\"$")
    public void user_searches_for_the_record(String productName) throws Throwable {
        fliphomepage.searchProductAndCountProducts(productName);
    }

    @Then("^User fetch all searched products and its price$")
    public void user_fetch_all_serched_products_and_its_price() throws Throwable {
        fliphomepage.fetchAllProductsAndPrices();
    }

    @When("^User Validate list of products in the homePage$")
    public void user_Validate_list_of_products_in_the_homePage() throws Throwable {
        fliphomepage.validateAllProduct();
    }

}

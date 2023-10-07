package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utils.TestContextSetup;

public class checkOutStepDefinition {
    TestContextSetup tcs;

    public checkOutStepDefinition(TestContextSetup tcs) {
        this.tcs = tcs;
    }

    @Then("Go to checkout page and proceed to checkout")
    public void go_to_checkout_page_and_proceed_to_checkout() {
        tcs.POM.getCheckoutPage().validateApplyBtn();
        Assert.assertEquals(tcs.POM.getCheckoutPage().validateErrorCodeMessage(), "Empy code ..!");
    }

    @Then("check whether  added product displayed properly")
    public void check_whether_added_product_displayed_properly() {
        String Name1 = tcs.POM.getCheckoutPage().validateProductNameOnCheckoutPage();
        String Name2 = tcs.POM.getLandingPage().cucumberProductNameValidation();
        System.out.println(Name1);
        System.out.println(Name2);
        Assert.assertEquals(Name1, Name2);
    }

    @Given("user is on flightBooking site")
    public void user_is_on_flight_booking_site() {


    }
    @When("^user clicks on (.+)$")
    public void user_clicks_on_radiobutton(String radioB) {


    }
    @Then("radio buttons should be accessible and validated one by one")
    public void radio_buttons_should_be_accessible_and_validated_one_by_one() {


    }

}

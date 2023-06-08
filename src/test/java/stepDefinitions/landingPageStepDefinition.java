package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utils.TestContextSetup;

public class landingPageStepDefinition {
    TestContextSetup tcs;
    public landingPageStepDefinition(TestContextSetup tcs){
        this.tcs= tcs;
    }

    @Given("user is on GreenCart landing page")
    public void user_is_on_green_cart_landing_page() {
   tcs.POM.getLandingPage().addToCartButtonCucumber();

    }
    @When("select the Cucumber and click on add to cart button")
    public void select_the_cucumber_and_click_on_add_to_cart_button() {
        tcs.POM.getLandingPage().addToCart();
    }



}

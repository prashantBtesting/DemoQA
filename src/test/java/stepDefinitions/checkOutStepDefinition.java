package stepDefinitions;

import io.cucumber.java.en.Then;
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
        Assert.assertEquals(tcs.POM.getCheckoutPage().validateErrorCodeMessage(), "Empty code ..!");
    }

    @Then("check whether  added product displayed properly")
    public void check_whether_added_product_displayed_properly() {
        String Name1 = tcs.POM.getCheckoutPage().validateProductNameOnCheckoutPage();
        String Name2 = tcs.POM.getLandingPage().cucumberProductNameValidation();
        System.out.println(Name1);
        System.out.println(Name2);
        Assert.assertEquals(Name1, Name2);
    }

}

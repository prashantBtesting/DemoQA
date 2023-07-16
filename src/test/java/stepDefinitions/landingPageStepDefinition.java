package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utils.TestContextSetup;

public class landingPageStepDefinition {
    TestContextSetup tcs;

    public landingPageStepDefinition(TestContextSetup tcs) {
        this.tcs = tcs;
    }

    @Given("user is on GreenCart landing page")
    public void user_is_on_green_cart_landing_page() {
        tcs.POM.getLandingPage().addToCartButtonCucumber();

    }

    @When("select the Cucumber and click on add to cart button")
    public void select_the_cucumber_and_click_on_add_to_cart_button() {
        tcs.POM.getLandingPage().myBag();
       tcs.POM.getCheckoutPage().calculatePriceInCartPreview();
        tcs.POM.getLandingPage().proceedToCheckout();
    }

    @Given("open url")
    public void open_url() {

    }

    @When("you search product and enter data")
    public void you_search_product_and_enter_data(DataTable dataTable) {
        /*
        List<List<String>> data = dataTable.asLists(String.class);
        tcs.POM.getLandingPage().searchProduct(data.get(0).get(0));
        tcs.POM.getLandingPage().searchProduct(data.get(0).get(1));

         */
/*
        List<Map<String, String >> listData = dataTable.asMaps(String.class, String.class);
        for(Map<String, String> map : listData ) {
            tcs.POM.getLandingPage().searchProduct(map.get("Names"));
        }
 */

    }

    @Then("validate product is visible")
    public void validate_product_is_visible() {

    }

    @When("^you search products and enter (.+)$")
    public void you_search_product_and_enter(String Names) {
        tcs.POM.getLandingPage().searchProduct(Names);
        System.out.println("Product Name is: "+ Names);

    }

    @Then("validate product is visible two")
    public void validate_product_is_visible_two() {
        Assert.assertTrue(tcs.POM.getLandingPage().productName.isDisplayed());
        System.out.println(tcs.POM.getLandingPage().productName);

    }

    @Then("enter the random quantity and calculate the price.")
    public void enter_the_random_quantity_and_calculate_the_price() throws InterruptedException {
        Thread.sleep(2000);
        tcs.POM.getLandingPage().enterRandomProductQuantity();
        Thread.sleep(2000);
        tcs.POM.getLandingPage().addToCartB();
        tcs.POM.getLandingPage().myBag();
        tcs.POM.getCheckoutPage().calculatePriceInCartPreview();
    }

    @Then("enter the random quantity in minus")
    public void enter_the_random_quantity_in_minus() throws InterruptedException {
        Thread.sleep(2000);
        tcs.POM.getLandingPage().enterRandomProductQuantityInMinus();
        tcs.POM.getLandingPage().addToCartB();
        tcs.POM.getLandingPage().myBag();
        Assert.assertTrue(tcs.POM.getCheckoutPage().calculatePriceInCartPreview());

    }

    @When("url is opened click on flight booking btn")
    public void url_is_opened_click_on_flight_booking_btn() {
        tcs.POM.getFlightBookingPage().openFlightBooking();
        tcs.POM.getFlightBookingPage().hotelsBtn.click();
        Assert.assertEquals(tcs.base.driver.getTitle(), "GreenKart - veg and fruits kart");
    }
    @Then("check flight booking window is opened and validate the title")
    public void check_flight_booking_window_is_opened_and_validate_the_title() {

    }



}

package pageObjects;

import org.openqa.selenium.WebDriver;
import utils.GenericUtilsPage;


public class PageObjectManager {
    WebDriver driver;
    landingPage landingPage;
    checkOutPage checkoutPage;
    flightBookingPage flightBookingPage;
    GenericUtilsPage GenericUtilsPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public landingPage getLandingPage() {
        landingPage = new landingPage(driver);
        return landingPage;
    }
    public checkOutPage getCheckoutPage(){
        checkoutPage = new checkOutPage(driver);
        return checkoutPage;
    }
    public flightBookingPage getFlightBookingPage(){
        flightBookingPage = new flightBookingPage(driver);
        return flightBookingPage;
    }
    public GenericUtilsPage getGenericUtilsPage(){
        GenericUtilsPage = new GenericUtilsPage(driver);
        return GenericUtilsPage;
    }
}

package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    WebDriver driver;
    landingPage landingPage;
    checkOutPage checkoutPage;
    flightBookingPage flightBookingPage;

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
}

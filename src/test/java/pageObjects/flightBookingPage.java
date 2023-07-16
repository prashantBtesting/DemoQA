package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;
import java.util.Set;

public class flightBookingPage {
    WebDriver driver;
    Random random;
    WebDriverWait wait;

    public flightBookingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        random = new Random();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @FindBy(xpath = "//a[text()='Flight Booking']")
    public WebElement flightBookingBtn;

    @FindBy(xpath ="//table[@id='ctl00_mainContent_rbtnl_Trip']/child::*/child::*/child::*")
    public WebElement radioButtons;

    @FindBy(xpath = "//span[normalize-space()='Hotels']")
    public WebElement hotelsBtn;

    public void openFlightBooking() {
        wait.until(ExpectedConditions.elementToBeClickable(flightBookingBtn));
        flightBookingBtn.click();
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String windowHandle : allWindowHandles) {
            driver.switchTo().window(windowHandle);
        }

    }





}

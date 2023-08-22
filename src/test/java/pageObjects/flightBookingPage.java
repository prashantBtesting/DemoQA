package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import static utils.GenericUtilsPage.selectRandomElement;

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

   // @FindBy(xpath = "//table[@id='ctl00_mainContent_rbtnl_Trip']/child::*/child::*/child::*")
   // public WebElement radioButtons;

    @FindBy(xpath = "//span[normalize-space()='Hotels']")
    public WebElement hotelsBtn;
    @FindBy(xpath = "//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")
    public WebElement originalStation;
    @FindBy(xpath = "//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")
    public WebElement DestinationStation;


    By departureFlightsLocations = By.xpath("(//td[@class='mapbg'])[1]//ul/li/a");
    By destinationFlightsLocations = By.xpath("(//td[@class='mapbg'])[2]//ul/li/a");
    By checkBoxes = By.xpath("//input[@type='checkbox']/ancestor::div[@id='discount-checkbox']//input");
    By radioButtons = By.xpath("//input[@type='radio']/ancestor::table[@class='tblTrip']//input");

    public void openFlightBooking() {
        wait.until(ExpectedConditions.elementToBeClickable(flightBookingBtn));
        flightBookingBtn.click();
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String windowHandle : allWindowHandles) {
            driver.switchTo().window(windowHandle);
        }
    }

    public void currencySelect() {
        Map<Integer, String> selectCurrency = new HashMap<>();
        selectCurrency.put(1, "INR");
        selectCurrency.put(2, "AED");
        selectCurrency.put(3, "USD");
        Select select = new Select(driver.findElement(By.name("ctl00$mainContent$DropDownListCurrency")));
        select.selectByVisibleText(selectCurrency.get(3));

    }


    public String selectFlightFromDepartureAndDestination() {

        wait.until(ExpectedConditions.elementToBeClickable(originalStation));
        originalStation.click();

        WebElement randomDepartureFlight = selectRandomElement(driver.findElements(departureFlightsLocations));
        String departureText = randomDepartureFlight.getText();
        randomDepartureFlight.click();

        wait.until(ExpectedConditions.elementToBeClickable(DestinationStation));
        DestinationStation.click();

        WebElement randomDestinationFlight = selectRandomElement(driver.findElements(destinationFlightsLocations));
        String destinationText = randomDestinationFlight.getText();
        randomDestinationFlight.click();

        System.out.println(departureText);
        System.out.println(destinationText);

        return departureText;
    }

    public void selectRandomCheckBox() {
        wait.until(ExpectedConditions.elementToBeClickable(checkBoxes));
        WebElement checkBox = selectRandomElement(driver.findElements(checkBoxes));
        String checkBoxText = checkBox.getText();
        checkBox.click();
        System.out.println(checkBoxText);

    }

    public void radioButtons(){
        wait.until(ExpectedConditions.elementToBeClickable(radioButtons));
        WebElement radioBtn = selectRandomElement(driver.findElements(radioButtons));
        wait.until(ExpectedConditions.visibilityOf(radioBtn));
        String radioBtnText = radioBtn.getText();
        radioBtn.click();
        System.out.println(radioBtnText);
    }

}

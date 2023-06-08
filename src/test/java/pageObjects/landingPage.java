package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class landingPage {
    WebDriver driver;
    WebDriverWait wait;

    public landingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div[3]/div[2]/a[2]")
    public WebElement cucumberPlus;
    @FindBy(xpath = "//div[3]//div[3]//button[1]")
    public WebElement addToCartCucumber;
    @FindBy(xpath = "//img[@alt='Cart']")
    public WebElement addToCartButton;
    @FindBy(xpath = "//button[normalize-space()='PROCEED TO CHECKOUT']")
    public WebElement proceedToCheckOut;

    @FindBy(xpath = "//div[@class='brand greenLogo']")
    public WebElement brandGreenLogo;
    @FindBy(xpath = "//h4[contains(text(),'Cucumber - 1 Kg')]")
    public WebElement cucumberProductName;




    public void addToCartButtonCucumber(){
        cucumberPlus.click();
        wait.until(ExpectedConditions.visibilityOf(addToCartCucumber));
        addToCartCucumber.click();

    }
    public void addToCart(){
        wait.until(ExpectedConditions.visibilityOf(addToCartButton));
        addToCartButton.click();
        wait.until(ExpectedConditions.visibilityOf(proceedToCheckOut));
        proceedToCheckOut.click();

    }
    public String cucumberProductNameValidation(){
        return cucumberProductName.getText();
    }




}

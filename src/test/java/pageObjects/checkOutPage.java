package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class checkOutPage {
    WebDriver driver;
    Random random;
    WebDriverWait wait;
    public checkOutPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        wait= new WebDriverWait(driver, Duration.ofSeconds(20));
        random = new Random();
    }
    @FindBy(css = "span.promoInfo")
    public WebElement PromoInfoErrorMessage;
    @FindBy(css = "button.promoBtn")
    public WebElement applyBtn;
    @FindBy(xpath = "//button[normalize-space()='Apply']")
    public WebElement applyButtonCheckoutPage;
    @FindBy(xpath = "//p[contains(text(),'Cucumber - 1 Kg')]")
    public WebElement cucumberProductNameCheckoutPage;




    public String validateErrorCodeMessage(){
        wait.until(ExpectedConditions.visibilityOf(applyBtn));
        applyBtn.click();
        wait.until(ExpectedConditions.visibilityOf(PromoInfoErrorMessage));
        String Ab=  PromoInfoErrorMessage.getText();
        return Ab;
    }
    public void randomPromoCodes(){
        Set<String> randomCodes = new HashSet<>((Arrays.asList("advg", "zxhi", "opwm")));

    }
    public void validateApplyBtn (){
        wait.until(ExpectedConditions.visibilityOf(applyButtonCheckoutPage));
        if (applyButtonCheckoutPage.isDisplayed()){
            System.out.println("apply button displayed");
        }else {
            System.out.println("apply button not displayed");

        }
    }
    public String validateProductNameOnCheckoutPage(){
        return cucumberProductNameCheckoutPage.getText();
    }







}

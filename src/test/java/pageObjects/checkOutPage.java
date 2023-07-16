package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class checkOutPage {
    Random random;
    WebDriverWait wait;

    public checkOutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
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

    @FindBy(css = "div[class='cart-preview active'] div div p[class='quantity']")
    public WebElement cartPreviewActiveQuantity;

    @FindBy(css = "div[class='cart-preview active'] div div p[class='amount']")
    public WebElement cartPreviewActiveTotalPrice;

    @FindBy(css = "div[class='cart-preview active'] div div p[class='product-price']")
    public WebElement cartPreviewActiveProductPrice;


    public String validateErrorCodeMessage() {
        wait.until(ExpectedConditions.visibilityOf(applyBtn));
        applyBtn.click();
        wait.until(ExpectedConditions.visibilityOf(PromoInfoErrorMessage));
        String Ab = PromoInfoErrorMessage.getText();
        return Ab;
    }

    public void randomPromoCodes() {
        Set<String> randomCodes = new HashSet<>((Arrays.asList("advg", "zxhi", "opwm")));

    }

    public void validateApplyBtn() {
        wait.until(ExpectedConditions.visibilityOf(applyButtonCheckoutPage));
        if (applyButtonCheckoutPage.isDisplayed()) {
            System.out.println("apply button displayed");
        } else {
            System.out.println("apply button not displayed");

        }
    }

    public String validateProductNameOnCheckoutPage() {
        return cucumberProductNameCheckoutPage.getText();
    }

    public boolean calculatePriceInCartPreview() {
        wait.until(ExpectedConditions.elementToBeClickable(cartPreviewActiveQuantity));
        int productQuantity = Integer.parseInt(cartPreviewActiveQuantity.getText().replaceAll("[^\\-\\d]", ""));

        wait.until(ExpectedConditions.elementToBeClickable(cartPreviewActiveTotalPrice));
        System.out.println("Product Quantity is: " + productQuantity);
        int productTotalPrice = Integer.parseInt(cartPreviewActiveTotalPrice.getText().replaceAll("[^\\-\\d]", ""));
        System.out.println("Product Total Price is: " + productTotalPrice);
        wait.until(ExpectedConditions.elementToBeClickable(cartPreviewActiveProductPrice));
        int productPrice = Integer.parseInt(cartPreviewActiveProductPrice.getText().replaceAll("[^\\-\\d]", ""));
        System.out.println("Product Price is: " + productPrice);

        int ActualProductTotalPrice;
        ActualProductTotalPrice = productPrice * productQuantity;
        Assert.assertEquals(ActualProductTotalPrice, productTotalPrice);
        if (cartPreviewActiveTotalPrice.getText().contains("-")){
            return true;
        }
        return true;
    }


}

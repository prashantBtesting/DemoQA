package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class landingPage {
    WebDriver driver;
    WebDriverWait wait;
    Random random;


    public landingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        random = new Random();
    }
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div[3]/div[2]/a[2]")
    public WebElement cucumberPlus;
    @FindBy(xpath = "//div[3]//div[3]//button[1]")
    public WebElement addToCartCucumber;
    @FindBy(xpath = "//img[@alt='Cart']")
    public WebElement bag;
    @FindBy(xpath = "//button[normalize-space()='PROCEED TO CHECKOUT']")
    public WebElement proceedToCheckOut;

    @FindBy(xpath = "//div[@class='brand greenLogo']")
    public WebElement brandGreenLogo;
    @FindBy(xpath = "//h4[contains(text(),'Cucumber - 1 Kg')]")
    public WebElement cucumberProductName;

    @FindBy(xpath = "//input[@type=\"search\"]")
    public WebElement searchProducts;


    @FindBy(xpath = "//h4[@class=\"product-name\"]")
    public WebElement productName;

    @FindBy(xpath = "//input[@type=\"number\"]")
    public WebElement productQuantityNumberBox;

    @FindBy(xpath = "//button[normalize-space()='ADD TO CART']")
    public WebElement addToCart;

    @FindBy(css = "h4[class='product-name']")
    public WebElement productN;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement searchButton;






    public void addToCartButtonCucumber(){
        cucumberPlus.click();
        wait.until(ExpectedConditions.visibilityOf(addToCartCucumber));
        addToCartCucumber.click();

    }
    public void myBag(){
        wait.until(ExpectedConditions.visibilityOf(bag));
        bag.click();

    }
    public void proceedToCheckout(){
        wait.until(ExpectedConditions.visibilityOf(proceedToCheckOut));
        proceedToCheckOut.click();
    }
    public String cucumberProductNameValidation(){
        return cucumberProductName.getText();
    }
   /*
    public void searchProduct(String string){
        searchProducts.sendKeys(string);
        System.out.println(productName.getText());
        searchProducts.clear();
        //wait.until(ExpectedConditions.visibilityOf(productName));
    }

    */
public void searchProduct(String names){
    wait.until(ExpectedConditions.visibilityOf(searchProducts));
    searchProducts.sendKeys(names);
    wait.until(ExpectedConditions.visibilityOf(searchButton));
    searchButton.click();

}


public void enterRandomProductQuantity(){

    String size = String.valueOf(random.nextInt(9)+1);
    wait.until(ExpectedConditions.elementToBeClickable(productQuantityNumberBox));
    productQuantityNumberBox.clear();
    productQuantityNumberBox.sendKeys(size);

}
public void  enterRandomProductQuantityInMinus(){
    String count = "-33";
    wait.until(ExpectedConditions.elementToBeClickable(productQuantityNumberBox));
    productQuantityNumberBox.clear();
    productQuantityNumberBox.sendKeys(count);
}
public void addToCartB(){
    addToCart.click();
}

}

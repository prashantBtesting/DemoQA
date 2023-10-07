package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;


public class TestXpath {
    WebDriver driver;
    TestXpath(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public void savedXpath(String element, String xpath){
        HashMap< String, By > xpaths = new HashMap<>();
        driver.findElement(By.xpath(xpath));
    }

}

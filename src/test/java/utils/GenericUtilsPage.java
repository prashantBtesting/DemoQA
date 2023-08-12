package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class GenericUtilsPage {
    Random random;
    WebDriverWait wait;
    WebDriver driver;
    public GenericUtilsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        random = new Random();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public static WebElement selectRandomElement(List<WebElement> elements) {
        Random random = new Random();
        int randomIndex = random.nextInt(elements.size());
        return elements.get(randomIndex);
    }

}

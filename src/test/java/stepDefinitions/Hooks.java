package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestContextSetup;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Hooks {
    WebDriverWait wait;
    TestContextSetup tcs;
public Hooks(TestContextSetup tcs){
    this.tcs=tcs;

}

    @After
    public void AfterScenario() throws IOException {
    tcs.base.initializeDriver().quit();
}
@AfterStep
    public void AddScreenshot(Scenario scenario) throws IOException {

    WebDriver driver =tcs.base.initializeDriver();

    //webDiver initialized and get life
    if(scenario.isFailed()){

        //condition if any scenario failed then at any step then execute below code & below code says take screenShot on failed step.
        File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //typecasting TakeScreenshot class selenium and added life to it wih the help of driver and then getScreenShotAs method from takeScreenShot method

        byte [] fileContent = FileUtils.readFileToByteArray(sourcePath);
        //convert or read file to bytearray using fileUtils class. on this step screenshot is ready but need t o convert it into the png image so added png format type in last stage
        scenario.attach(fileContent, "image/png", "image");
    }

}

}

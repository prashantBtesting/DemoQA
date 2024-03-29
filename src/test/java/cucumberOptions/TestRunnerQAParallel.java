package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepDefinitions",
        tags = "@Regressionn",
        monochrome = true,
        plugin = {"html:target/cucumber.html","json:target/cucumber.json",
                        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        publish = true
)
public class TestRunnerQAParallel extends AbstractTestNGCucumberTests{
@DataProvider(parallel = true)
public Object[][] scenarios(){
    return super.scenarios();
}
}

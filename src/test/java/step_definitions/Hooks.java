package step_definitions;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.APIUtil;
import utilities.Driver;
import utilities.ExtentReport;

public class Hooks {
    @Before
    public void setUp(Scenario scenario) {
        ExtentReport.startTest(scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println(scenario.getName());
        System.out.println(scenario.getStatus());
        if(scenario.isFailed() && Driver.getDriverReference() != null) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
            ExtentReport.fail();
        } else {
            ExtentReport.pass();
        }
        if(scenario.isFailed() && APIUtil.getResponseBody() != null){
            scenario.write(APIUtil.getResponseBody().getJsonResponse());
        }
        Driver.quitDriver();
    }
}


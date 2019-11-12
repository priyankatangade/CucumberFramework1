package runners;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
 features = "E:\\Workspace\\CucumberFramework\\src\\main\\resources\\functionalTests",
 glue={"stepDefinitions"}
 )
public class TestRunner {

}

package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.opentelemetry.sdk.metrics.internal.exemplar.TraceBasedExemplarFilter;

@CucumberOptions(features = "@target/failed_scenarios.txt",glue = "stepDefinitions",
monochrome = true,
plugin = {"html:target/cucumber.html","json:target/cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class FailedTestNGTestRunner extends AbstractTestNGCucumberTests {

	@DataProvider(parallel = true)
	@Override
	public Object[][] scenarios(){
		return super.scenarios();
	}
}

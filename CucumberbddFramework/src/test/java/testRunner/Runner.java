package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//import org.junit.runner.RunWith;
//
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;


//@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {".//Features/login.feature"},
		glue="stepDefinition",
		dryRun = false,
		monochrome = true,
		tags = "@Sanity",//scenario only sanity tag will executed
		//plugin = {"pretty","html:CucumberbddFramework/Reports/reports1.html"}
			plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}	
		)

public class Runner extends AbstractTestNGCucumberTests {
//nothing added
}

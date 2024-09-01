package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
		
		features = {".//Features/login.feature"},
		//features = {".//Features/createAccount.feature"},
		glue="stepDefinition",
		dryRun = false,
		monochrome = true,
		tags = "@Sanity",//scenario only sanity tag will executed
		//plugin = {"pretty","html:CucumberbddFramework/Reports/reports1.html"}
			plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}	
		)

public class LoginApplication extends AbstractTestNGCucumberTests{

	
}

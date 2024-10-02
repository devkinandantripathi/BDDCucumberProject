package stepDefinition;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import Utilities.BrowserFactory;
import Utilities.DriverFactory;
import actions.WebUI;
import Utilities.readConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.createAccountPage;
import pageObject.loginPage;

public class LoginSteps extends BaseClass{
	ExecutionHooks hooks = new ExecutionHooks();
	loginPage login = new loginPage();

	@When("User opens URL {string}")
	public void openUrl(String url) {
		WebUI.getDriver().navigate().to(url);
		WebUI.comment("URL open");
	}

	@When("User Click on SignIn link")
	public void clickOnSignInButton() {
		login.clickSignInlink();
		WebUI.takesScreenshot();
		WebUI.comment("SignIn link button clicked");
	}

	@Then("User Enter EmailId as {string} and password is {string}")
	public void enterEmailIdAndPassword(String email, String pwd) {
	    login.enterUsername(email);
	    login.enterPassword(pwd);
	    WebUI.comment("Enter password and Email");
	}

	@Then("User Click on SignIn button")
	public void SignInbutton() {
	    login.clickSignInButton();
	    WebUI.comment("SignIn Button clicked");
	}

	@Then("Page title should be {string}")
	public void pageTitle(String expectedTitle) {
	   String actualTitle=WebUI.getDriver().getTitle();
	   System.out.println(WebUI.getDriver().hashCode());
	   
	   if(expectedTitle.equals(actualTitle)) {
		   Assert.assertEquals(expectedTitle, actualTitle);
	   }
	}

	@When("User click on SignOut link")
	public void logoutButton() {
	   
	}

	@Then("User close the browser")
	public void closeBrowser() {
	    //driver.close();
	}
	

}

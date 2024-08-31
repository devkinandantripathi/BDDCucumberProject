
package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Utilities.DriverFactory;
import Utilities.WebUI;
import io.cucumber.java.en.*;
import pageObject.createAccountPage;

public class createAccountSteps {

	 createAccountPage createAccount = new createAccountPage();
	public createAccountSteps() {
		WebDriver driver = DriverFactory.getInstance().getDriver();
        PageFactory.initElements(driver, this);
       
	}
	@When("User Click on createAccount link")
	public void user_click_on_create_account_link() {
		createAccount.clickCreateAccountLink();

	}

	@Then("User Enter Confirm Password as {string}")
	public void user_enter_confirm_password(String confirmPwd) {
		createAccount.enterConfirmPassword(confirmPwd);
	}

	@Then("User Click on create Account button")
	public void user_click_on_create_account_button() {
		createAccount.clickCreateAccountBtn();
	}
	@Then("User Enter EmailId as {string} and password {string}")
	public void enterEmailIdAndPassword(String email, String pwd) {
		createAccount.enteremailAddress(email);
		createAccount.enterPassword(pwd);
	    WebUI.comment("Enter Email and password");
	}
	@And("User enter firstname as {string} and lastName as {string}")
	public void enterFirstNameAndlastName(String fName, String lname) {
		createAccount.enterFirstName(fName);
		createAccount.enterPassword(lname);
	}

}

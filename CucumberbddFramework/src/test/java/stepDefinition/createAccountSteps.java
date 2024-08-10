/*
 * package stepDefinition;
 * 
 * import org.openqa.selenium.WebDriver;
 * 
 * import io.cucumber.java.en.*; import pageObject.createAccountPage;
 * 
 * public class createAccountSteps {
 * 
 * public WebDriver driver; public createAccountPage createAccount= new
 * createAccountPage(driver);
 * 
 * @When("User Click on createAccount link") public void
 * user_click_on_create_account_link() { createAccount.clickCreateAccountLink();
 * 
 * }
 * 
 * @Then("User Enter Confirm Password as {string}") public void
 * user_enter_confirm_password(String confirmPwd) {
 * createAccount.enterConfirmPassword(confirmPwd); }
 * 
 * @Then("User Click on create Account button") public void
 * user_click_on_create_account_button() {
 * createAccount.clickCreateAccountBtn(); }
 * 
 * @And("User enter firstname as {string} and lastName as {string}") public void
 * enterFirstNameAndlastName(String fName, String lname) {
 * createAccount.enterFirstName(fName); createAccount.enterLastName(lname); }
 * 
 * }
 */
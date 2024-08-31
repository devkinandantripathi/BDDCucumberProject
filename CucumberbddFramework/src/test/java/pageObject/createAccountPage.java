package pageObject;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.DriverFactory;

public class createAccountPage{

	
	public createAccountPage() {
		WebDriver driver = DriverFactory.getInstance().getDriver();
        PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Create an Account")
	public WebElement createAcccountLink;
	
	@FindBy(id="firstname")
	public WebElement firstName;
	
	@FindBy(id="lastname")
	public WebElement lastName;
	
	@FindBy(id="email_address")
	public WebElement emailAddress;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(id="password-confirmation")
	public WebElement confirmPassword;
	
	@FindBy(xpath="//*[@title='Create an Account']//span")
	public WebElement createAccountBtn;
	
	public void clickCreateAccountLink() {
		createAcccountLink.click();
	}
	
	public void enterFirstName(String fName) {
		firstName.sendKeys(fName);
	}
	
	public void enterLastName(String lName) {
		lastName.sendKeys(lName);
	}
	
	public void enteremailAddress(String email) {
		
		emailAddress.sendKeys(email);
	}
	
	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void enterConfirmPassword(String pwd) {
		confirmPassword.sendKeys(pwd);
	}
	
	public void clickCreateAccountBtn() {
		createAccountBtn.click();
	}

}

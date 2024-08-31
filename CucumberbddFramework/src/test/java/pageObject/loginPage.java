package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.DriverFactory;

public class loginPage {

	public loginPage() {
		WebDriver driver = DriverFactory.getInstance().getDriver();
        PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="email")
	public WebElement email;
	
	@FindBy(id="pass")
	public WebElement password;
	
	@FindBy(xpath="//*[@id='send2']//span")
	public WebElement signInButton;
	
	@FindBy(linkText="Sign In")
	public WebElement signInLink;
	
	public void clickSignInlink() {
		signInLink.click();
	}
	
	public void enterUsername(String emailId) {
		email.sendKeys(emailId);
	}
	
	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void clickSignInButton() {
		signInButton.click();
	}
	
	
	
}

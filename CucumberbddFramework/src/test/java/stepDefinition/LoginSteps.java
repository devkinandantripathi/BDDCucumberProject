package stepDefinition;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import Utilities.BrowserFactory;
import Utilities.DriverFactory;
import Utilities.WebUI;
import Utilities.readConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.createAccountPage;
import pageObject.loginPage;

public class LoginSteps extends BaseClass{
	BrowserFactory bf=new BrowserFactory();
//	@Before("@Sanity")
//	public void setUp() {
//		prop= new readConfig();
//		logger = LogManager.getLogger(LoginSteps.class);
//		String browser=prop.getBrowser().toLowerCase();
//		
//		if(browser.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//		    driver = new ChromeDriver();
//		}else if(browser.equalsIgnoreCase("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver= new FirefoxDriver();
//		}else if(browser.equalsIgnoreCase("edge")) {
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//		}
//	    WebUI.comment("Setup1 Executed.......");
//	}
	
	@Before
	public void LaunchApplication() throws Exception {
		prop = new readConfig();
		logger = LogManager.getLogger(LoginSteps.class);
		driver = ThreadLocal.withInitial(() -> DriverFactory.getInstance().getDriver());
		String browser=prop.getBrowser().toLowerCase();
		String url = prop.getUrl();
		DriverFactory.getInstance().setDriver(bf.createBrowserInstance(browser));
		WebUI.getDriver().manage().window().maximize();
		WebUI.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebUI.getDriver().navigate().to(url);

	}

	@After
	public void tearDown() {
		DriverFactory.getInstance().closeBrowser();
	}
	
//	@After
//	public void tearDown(/*Scenario sc*/) throws IOException {
////		if(sc.isFailed()==true)
////		{
////			captureScreenshots("screenshots");
////		}
//		WebUI.comment("Driver closed.......");
//		driver.quit();
//	}
	
	@AfterStep
	public void addScreenshots(Scenario scenario) {
			
			final byte[] screenshot=((TakesScreenshot)DriverFactory.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
	}
	
	
	
	

	public String captureScreenshots(String screenShotName) throws IOException
    {
      TakesScreenshot ts = (TakesScreenshot)WebUI.getDriver();
      File source = ts.getScreenshotAs(OutputType.FILE);  

      File file = new File("C:\\Users\\Dev\\Screenshots\\screenshots.png");
      String dest = file.getCanonicalPath();
      File destination = new File(dest);
      FileUtils.copyFile(source, destination);                          
      return dest;        
    }
	
	@Given("User Launch chrome browser")
	public void openBrowser() {
	    
	    login = new loginPage(WebUI.getDriver());
	    createAccount=new createAccountPage(WebUI.getDriver());
	    WebUI.comment("User launch chrome browser");
	}

	@When("User opens URL {string}")
	public void openUrl(String url) {
		WebUI.getDriver().navigate().to(url);
		//System.out.println(driver.hashCode());
		WebUI.comment("URL open");
	}

	@When("User Click on SignIn link")
	public void clickOnSignInButton() {
		login.clickSignInlink();
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
	
	@And("User enter firstname as {string} and lastName as {string}")
	public void enterFirstNameAndlastName(String fName, String lname) {
		createAccount.enterFirstName(fName);
		createAccount.enterLastName(lname);
	}


}

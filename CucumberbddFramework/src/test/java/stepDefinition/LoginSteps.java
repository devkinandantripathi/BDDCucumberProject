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
import actions.WebUI;
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
	
	/*
	 * @Before("@Sanity") public void setUp() { prop= new readConfig(); logger =
	 * LogManager.getLogger(LoginSteps.class); String
	 * browser=prop.getBrowser().toLowerCase();
	 * 
	 * if(browser.equalsIgnoreCase("chrome")) {
	 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver(); }else
	 * if(browser.equalsIgnoreCase("firefox")) {
	 * WebDriverManager.firefoxdriver().setup(); driver= new FirefoxDriver(); }else
	 * if(browser.equalsIgnoreCase("edge")) { WebDriverManager.edgedriver().setup();
	 * driver = new EdgeDriver(); } WebUI.comment("Setup1 Executed......."); }
	 */
	
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
		WebUI.comment("Browser Closed");
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
	
	public void colorBrowser() {
		String browser=prop.getBrowser().toLowerCase();
		String colorBrowser = "\u001B[32m" + browser + "\u001B[0m";
		WebUI.comment("User launch "+colorBrowser+" browser");
		
		/*change the color of the browser */
//					Red: \u001B[31m
//		            Green: \u001B[32m
//		            Yellow: \u001B[33m
//		            Blue: \u001B[34m
//		            Magenta: \u001B[35m
//		            Cyan: \u001B[36m
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
	
	@Given("User Launch browser")
	public void openBrowser() { 
		colorBrowser();
		login = new loginPage();
		createAccount=new createAccountPage();
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
	

}

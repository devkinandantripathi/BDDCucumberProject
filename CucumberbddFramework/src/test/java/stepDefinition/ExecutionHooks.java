package stepDefinition;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Utilities.BrowserFactory;
import Utilities.DriverFactory;
import Utilities.readConfig;
import actions.WebUI;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;

public class ExecutionHooks extends BaseClass {
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
		logger = LogManager.getLogger(ExecutionHooks.class);
		String browser=prop.getBrowser().toLowerCase();
		String url = prop.getUrl();
		driver = ThreadLocal.withInitial(() -> DriverFactory.getInstance().getDriver());
		DriverFactory.getInstance().setDriver(bf.createBrowserInstance(browser));
		WebUI.getDriver().manage().window().maximize();
		WebUI.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebUI.getDriver().navigate().to(url);
		WebUI.takesScreenshot();

	}

	@After
	public void tearDown() {
		DriverFactory.getInstance().closeBrowser();
		WebUI.comment("Browser Closed");
	}
	
	@BeforeStep
	public void addAfterScreenshots(Scenario scenario) {
			
			final byte[] screenshot=((TakesScreenshot)WebUI.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
	}
	
//	@AfterStep
//	public void addAfterScreenshots(Scenario scenario) {
//			
//			final byte[] screenshot=((TakesScreenshot)WebUI.getDriver()).getScreenshotAs(OutputType.BYTES);
//			scenario.attach(screenshot, "image/png", scenario.getName());
//	}
	
	
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
	}
	
}

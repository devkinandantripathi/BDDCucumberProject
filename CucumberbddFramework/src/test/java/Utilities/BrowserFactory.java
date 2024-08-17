package Utilities;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import stepDefinition.BaseClass;

public class BrowserFactory extends BaseClass{

	//create webdriver object for given browser
		public WebDriver createBrowserInstance(String browser) throws MalformedURLException {

		//	WebDriver driver = null;
			RemoteWebDriver driver = null;

			if(browser.equalsIgnoreCase("Chrome")) {

				WebDriverManager.chromedriver().setup();
				System.setProperty("webdriver.chrome.silentOutput", "true");


				ChromeOptions options = new ChromeOptions();
				options.addArguments("--incognito");
				driver = new ChromeDriver(options);

			}else if (browser.equalsIgnoreCase("firefox")) {

				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions foptions = new FirefoxOptions();
				foptions.addArguments("-private");
				
//				/driver = new RemoteWebDriver(foptions);		        

				
				driver = new FirefoxDriver(foptions);

			} if (browser.equalsIgnoreCase("edge")) {

				WebDriverManager.iedriver().setup();
				EdgeOptions iOptions = new EdgeOptions();
				iOptions.addArguments("-private");

				driver = new EdgeDriver(iOptions);
			}
			return driver;
		}
}

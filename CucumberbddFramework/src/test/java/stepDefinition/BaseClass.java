package stepDefinition;

import org.openqa.selenium.WebDriver;

import Utilities.DriverFactory;
import Utilities.readConfig;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.*;

import pageObject.createAccountPage;
import pageObject.loginPage;

public class BaseClass {
	
	public static ThreadLocal<WebDriver> driver;
	//public static WebDriver driver;
	public loginPage login;
	public createAccountPage createAccount;
	public static Logger logger;
	public readConfig prop;
	
	
	public String generateRandomEmailid()
	{
		return (RandomStringUtils.randomAlphabetic(5));
		
	}

}

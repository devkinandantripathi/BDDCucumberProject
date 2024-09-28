package actions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.io.FileHandler;

import io.cucumber.java.Scenario;
import stepDefinition.BaseClass;

public class WebUI extends BaseClass{
	
	public static void comment(String message)
	{
		System.out.println(message);
		logger.info(message);
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	public static void scrolltoTop()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
        WebUI.comment("Page Scroll till Top of the page");
	}
	
	public static void scrolltoBottom()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        WebUI.comment("Page Scroll till Bottom of the page");
	}
	
	public static boolean takesScreenshot(){    
		try {
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot)getDriver();
			File source = ts.getScreenshotAs(OutputType.FILE);
			String destination = "C:\\Users\\Dev\\Screenshots\\screenshots"+dateName+".png";
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
			return true;
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    return true;
	}
	

}

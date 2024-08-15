package Utilities;

import org.openqa.selenium.JavascriptExecutor;

import stepDefinition.BaseClass;

public class WebUI extends BaseClass{
	
	public static void comment(String message)
	{
		System.out.println(message);
		logger.info(message);
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
	

}

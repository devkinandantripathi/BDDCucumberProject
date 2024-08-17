package Utilities;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
private DriverFactory() {
		
	}
	
	private static DriverFactory instance  = new DriverFactory();
	
	public static DriverFactory getInstance() {
		if (instance == null) {
            synchronized (DriverFactory.class) {
                if (instance == null) {
                    instance = new DriverFactory();
                }
            }
        }
        return instance;
	}
	
	
	//factory design pattern --> define separate factory methods for creating objects and create objects by calling that methods
	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public WebDriver getDriver() {
		return driver.get();
	}
	
	public void setDriver(WebDriver driverParm) {
		driver.set(driverParm);
	}
	
	
	public void closeBrowser() {
		driver.get().quit();
		driver.remove();
	}
}

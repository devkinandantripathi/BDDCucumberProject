package Utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;



public class readConfig {

	Properties prop;

	String path = "Configuration.properties";

	//constructor
	public readConfig() {
		try {
			prop = new Properties();

			
			//to open config .properties file in input mode and load the file
			FileInputStream  file = new FileInputStream("Configuration.properties");
			prop.load(file);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public String getBrowser()
	{
		String value = prop.getProperty("browser");

		if(value!=null)
			return value;
		else
			throw new RuntimeException("url not specified in config file.");

	}
	
}

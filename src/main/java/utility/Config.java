package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

	//public static WebDriver driver;
		  public static String config_Values(String value) throws IOException {
			
			Properties prop = new Properties();
			FileInputStream in= new FileInputStream("src//test//resources//testData//Config.properties");
               prop.load(in);
				// set the properties value
				return prop.getProperty(value);
				
}
		  
		  
		  public static String locator_Values(String value) throws IOException {
				
			Properties prop = new Properties();
			FileInputStream in= new FileInputStream("src//test//resources//locator//locator.properties");
               prop.load(in);
				// set the properties value
				return prop.getProperty(value);
				
}
		
		 
		  
//		  public static void configBrowser(String Browser, String Chromepath) throws IOException {
//		  
//			  if(Browser.equalsIgnoreCase("Chrome"))
//			  {
//				  
//				   System.setProperty("webdriver.chrome.driver", Config.config_Values("chromepath"));
//					
//					 
//			  }	
		  
//			  }
		  
		  
}

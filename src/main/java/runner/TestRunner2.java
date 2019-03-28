package runner;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.ios.IOSDriver;
import cucumber.api.testng.CucumberFeatureWrapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cucumber.listener.Reporter;

@CucumberOptions(
       features = {"src/test/resources/features/UI/LoginProfile.feature"},
        //features = {"src/test/resources/features/Content/Content.feature"},
        glue = {"stepdef"},
        tags = {"~@dddmayank"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/json-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun-reports/rerun.txt",
                "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"
        })
public class TestRunner2 {
	private TestNGCucumberRunner testNGCucumberRunner;
    public static WebDriver driver;
    
  
//**************OLD CONFIG START**************
//    private TestNGCucumberRunner testNGCucumberRunner;
//    
//	public static WebDriver driver;
//	
//	 //@BeforeSuite
//	 public void config_driver() throws IOException
//	 {
//		  System.setProperty("webdriver.chrome.driver", "src//test//resources//driver//chromedriver");
//		   driver=new ChromeDriver(); 
//		   driver.manage().window().maximize();
//		   driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//		   }
//**************OLD CONFIG END**************

    
//************NEW APPIUM START****************
	 
//************NEW APPIUM END****************

// ******************** Below is code for execution on Desktop local browser ***************
    @Parameters({"device"})
  	@BeforeTest
	 public void config_driver(String device) throws IOException
	 {
    	if(device.equalsIgnoreCase("chrome"))
		   {
				  System.setProperty("webdriver.chrome.driver", "src//test//resources//driver//chromedriver");
				   driver=new ChromeDriver(); 
				   //driver.manage().window().maximize();
				   //driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		   }
			   
				   else if (device.equalsIgnoreCase("firefox")) {
					   System.setProperty("webdriver.gecko.driver", "src//test//resources//driver//geckodriver");
					   driver=new FirefoxDriver(); 
					   //driver.manage().window().maximize();
					   //driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				   }
		 
		   }
		 
		   
    	
    	
    	
    	
    	
    	
    	
    	
//    	if(device.equalsIgnoreCase("chrome"))
//		   {
//			   DesiredCapabilities caps = DesiredCapabilities.chrome();
//			   
//			   // Below is code for mobile browser execution and desktop browser execution. Only one can be run at one time. 
//			   // Depending on requirement comment/uncomment either of them
//			   
////			    ********************* Below is Code for execution on Mobile Browser on SauceLab **********
////			   final String USERNAME = "mayankcareem";
////			   final String ACCESS_KEY = "dd921a69-c5ed-48e0-af6f-ce10dc3f7601";
////			   final String URL = "https://mayankcareem:dd921a69-c5ed-48e0-af6f-ce10dc3f7601@ondemand.saucelabs.com:443/wd/hub";
////		  	    caps.setCapability("platform", "Android");
////		  	    caps.setCapability("deviceName", "Samsung Galaxy S4 Emulator");
////		  	    caps.setCapability("platformVersion", "4.4");
////			   
//////			   caps.setCapability("platformName", "iOS");
//////		  	    caps.setCapability("deviceName", "iPhone 7");
//////		  	    caps.setCapability("platformVersion", "10.0");
////			   
////		  	    driver = new RemoteWebDriver(new URL(URL), caps);
////		  	    ******************** Code for Mobile browser ends here ************************ 
//			   
//
//			   // ******************** Below is code for execution on Desktop local browser ***************
//				  //System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
//				  System.setProperty("webdriver.chrome.driver", "src//test//resources//driver//chromedriver");
//				   driver=new ChromeDriver(); 
//				   //driver.manage().window().maximize();
//				   driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//			  // ******************** Code for Desktop local browser ends here ************************ 
//				   
//		   }
//		   
//		   if(device.equalsIgnoreCase("android"))
//		   {
//		    DesiredCapabilities caps = DesiredCapabilities.android();
//		    
//		    caps.setCapability("appiumVersion", "1.8.1");
//		    caps.setCapability("deviceName","Samsung Galaxy S8 HD GoogleAPI Emulator");
//		    caps.setCapability("deviceOrientation", "portrait");
//		    caps.setCapability("browserName", "Chrome");
//		    caps.setCapability("platformVersion", "7.1");
//		    caps.setCapability("platformName","Android");
//			caps.setCapability("name","AndroidTest");
//			//........for native and hybrid app
//		    //caps.setCapability("app", "sauce-storage:android-release-unsigned.ipa");
//		    //caps.setCapability("appPackage","");
//			//caps.setCapability("appActivity","");
//			//caps.setCapability("build","2.0");
//			driver = new AndroidDriver<WebElement>(new URL("http://testuser9955:0d8cb850-3e8f-43ce-ac08-9054423093c2@ondemand.saucelabs.com:80/wd/hub"), caps);
//			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//		   }
//		   
//		   if(device.equalsIgnoreCase("iPhone"))
//		   {	
//		    DesiredCapabilities caps = DesiredCapabilities.iphone();
//			caps.setCapability("deviceName","iPhone X Simulator");
//			caps.setCapability("deviceOrientation", "portrait");
//			caps.setCapability("platformVersion","11.3");
//			caps.setCapability("platformName", "iOS");
//			caps.setCapability("browserName", "Safari");
//			caps.setCapability("name","iPhoneTest");
//			//........for native and hybrid app
//		    //caps.setCapability("app", "sauce-storage:android-release-unsigned.ipa");
//		    //caps.setCapability("appPackage","");
//			//caps.setCapability("appActivity","");
//			//caps.setCapability("build","2.0");
//			driver = new IOSDriver<WebElement>(new URL("http://testuser9955:0d8cb850-3e8f-43ce-ac08-9054423093c2@ondemand.saucelabs.com:80/wd/hub"), caps);
//			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//		   }
		   
	 
	 
	@AfterSuite
	 public void Report() throws Exception 
	 {
		 driver.quit();
	 }

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("User Name",System.getProperty("user.name"));
        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));

        testNGCucumberRunner.finish();
    }
}

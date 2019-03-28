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

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
//import com.vimalselvam.cucumber.listener.Reporter;
import com.cucumber.listener.Reporter;


//******************** Below is code for Runner class of Selenium Grid concept "HUB/NODE" ************************** 
@CucumberOptions(
        features = {"src/test/resources/features/UI/LoginProfile_grid.feature"},
        glue = {"stepdef"},
        //tags = {"~@dddmayank"},
        plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"})
public class Grid_Runner {
	private TestNGCucumberRunner testNGCucumberRunner;
	String HubURL = "http://192.168.31.249:4444/wd/hub";
	public static WebDriver driver;

    
  	@BeforeTest
	 public  static void config_driver() throws IOException
	 {
  		
  		DesiredCapabilities capability = DesiredCapabilities.chrome();
    	capability.setBrowserName("chrome");
        capability.setPlatform(Platform.MAC);
        
        
        ChromeOptions options = new ChromeOptions();
        options.merge(capability);
         //driver = new RemoteWebDriver(new URL("http://192.168.31.249:1234/wd/hub"), capability);
        driver = new RemoteWebDriver(new URL("http://10.10.55.185:1234/wd/hub"), capability);
				   
		   }
/*
	@AfterSuite
	 public void Report() throws Exception 
	 {
		 driver.quit();
	 }
	 */

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
 // ********************* Below is Code for implementation of cucumber reporting **********
    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
    	Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
    	Reporter.setSystemInfo("User Name",System.getProperty("user.name"));
        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        
        testNGCucumberRunner.finish();
    }
 // ********************* End of Code for implementation of cucumber reporting **********
}

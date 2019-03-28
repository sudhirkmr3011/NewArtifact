package stepdef;


import utility.Config;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import runner.Grid_Runner;

import java.io.IOException;
//import config.*;
//import pages.*;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

//******************** Below is code for StepDef class of Selenium Grid concept "HUB/NODE" **************************
public class Grid_Stepdef extends Grid_Runner{
	
    @Given("^I grid am on the company home page on URL \"([^\"]*)\"$")
    public void i_am_on_the_page_on_URL(String arg1) throws IOException {
    	//10.150.126.245
		//driver.get(Config.locator_Values(arg1));
		driver.get(Config.config_Values(arg1));   //For passing fromn Config
 
    }
    
    @When("^I grid click on \"([^\"]*)\"$")
    public void i_click_on_the_element(String arg1) throws IOException  {
    	
    	driver.findElement(By.xpath(Config.locator_Values(arg1))).click();
    }

}
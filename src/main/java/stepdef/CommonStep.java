package stepdef;

import runner.TestRunner2;
import utility.Config;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.FileInputStream;
import java.io.IOException;
//import config.*;
//import pages.*;
import java.util.Iterator;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CommonStep extends TestRunner2{
    @Given("^I am on the company home page on URL \"([^\"]*)\"$")
    public void i_am_on_the_page_on_URL(String arg1) throws IOException {
    		driver.get(Config.config_Values(arg1));   //For passing fromn Config
		//driver.get(arg1);
 
    }
    
    @When("^I click on \"([^\"]*)\"$")
    public void i_click_on_the_element(String arg1) throws IOException  {
    	
    	driver.findElement(By.xpath(Config.locator_Values(arg1))).click();
    }

    @SuppressWarnings("unused")
	@Then("^I check content on page \"([^\"]*)\"$")
    public void testContent(String arg1) throws IOException {
    	System.out.println("page is1 " +arg1);
    	String userDir = System.getProperty("user.dir");
		try {
			Iterator<?> bodyElementIterator = new XWPFDocument(OPCPackage.open(new FileInputStream("Careem.docx"))).getBodyElementsIterator();
			outer: while (bodyElementIterator.hasNext()) {
				IBodyElement element = (IBodyElement) bodyElementIterator.next();
				if ("TABLE".equalsIgnoreCase(element.getElementType().name())) {
					for (XWPFTable table : element.getBody().getTables()) {
						System.out.println("table is1 " +table.getRow(1).getCell(2).getText());
						System.out.println("Doc text is --> " +arg1 +", AND Feature file text is --> " +table.getRow(1).getCell(2).getText());
						if(table.getRow(1).getCell(2).getText().equals(arg1)) 
						{
							System.out.println(" I am inside loop");
							for (int j=1; j<(table.getNumberOfRows())-1;j++) 
							{	
								Assert.assertEquals(driver.findElement(By.xpath(Config.locator_Values(table.getRow(j+1).getCell(2).getText()))).getText(), table.getRow(j+1).getCell(3).getText());
							}
						}
						else
							System.out.println("page did not match, Doc text is --> " +arg1 +", BUT Feature file text is --> " +table.getRow(1).getCell(2).getText());
							
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

    
    
}
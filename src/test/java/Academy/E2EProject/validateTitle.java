package Academy.E2EProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.landingPage;
import pageObjects.loginPage;
import resources.base;

public class validateTitle extends base {
	public WebDriver driver;
	public static Logger Log = LogManager.getLogger(base.class.getName());
	landingPage l; 
	
	@BeforeTest
	public void initialize() throws Exception
	{
		driver = initializeDriver();
		Log.info("Driver in Initialized");
		
		driver.get(prop.getProperty("url"));
		Log.info("Navigated to Homepage");
	}
	
	@Test
	public void landPageCourseTitle() throws Exception
	{
		
		//2 ways to access other class methods
		//1--- by inheritance
		//2---- by creating objects of that class
		
		l = new landingPage(driver);
      Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES123");
      Log.info("Correct header displayed");
      
     // Assert.assertTrue(l.getBar().isDisplayed());
		
		
	}
	
	@Test
	public void landPageHeaderValidate() throws Exception
	{
		
		//2 ways to access other class methods
		//1--- by inheritance
		//2---- by creating objects of that class
         Assert.assertEquals(l.getHeaderText().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");  
		Log.info("Header Text is correct");
		
	}
	
	
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

	
}

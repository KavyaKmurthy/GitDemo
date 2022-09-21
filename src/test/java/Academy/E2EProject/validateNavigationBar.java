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

public class validateNavigationBar extends base {
	public WebDriver driver;
	public static Logger Log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws Exception
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void landPageNavBar() throws Exception
	{
		
		//2 ways to access other class methods
		//1--- by inheritance
		//2---- by creating objects of that class
		
		landingPage l = new landingPage(driver);
      Assert.assertTrue(l.getBar().isDisplayed());
      Log.info("Navigation Bar is displayed");
      System.out.println("Navigation Bar kaansthaidhe");
		
		
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

	
}

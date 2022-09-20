package Academy.E2EProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.landingPage;
import pageObjects.loginPage;
import resources.base;

public class baseNavigation extends base {
	
	public WebDriver driver;
	
	public static Logger Log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws Exception
	{
		driver = initializeDriver();
		
		
	}
	
	@Test(dataProvider="getData")
	public void login(String username, String password, String text) throws Exception
	{
		
		//2 ways to access other class methods
		//1--- by inheritance
		//2---- by creating objects of that class
		driver.get(prop.getProperty("url"));
		landingPage l = new landingPage(driver);
		loginPage lp = l.getLogin();

		lp.userid().sendKeys(username);
		lp.password().sendKeys(password);
		lp.getLogin().click();
		//System.out.println(text);
		Log.info(text);
		
		ForgotPassword fp = lp.Forgotpassword();
		fp.getEmail().sendKeys("kavya");
		fp.forgotLink().click();
		
	}

	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][3];
		
		data[0][0] = "gooduser@abc.com";
		data[0][1] = "123456";
		data[0][2] = "gooduser";
		
		data[1][0] = "baduser@abc.com";
		data[1][1] = "123456";
		data[1][2] = "baduser";
		
		return data;
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}

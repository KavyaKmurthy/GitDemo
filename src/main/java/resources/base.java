package resources;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class base {
	
	public WebDriver driver;
	public Properties prop;
	
	@SuppressWarnings("deprecation")
	public WebDriver initializeDriver() throws Exception
	{
		
	prop = new Properties();
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
	prop.load(fis);
	String browserName = System.getProperty("browser");
	//String browserName = prop.getProperty("browser");
	
	if(browserName.contains("chrome"))
	{
		System.setProperty("webdriver.chrome.driver","D:\\Kavya\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		if(browserName.contains("headless"))
		{
			options.addArguments("headless");
		}
		
		driver = new ChromeDriver(options);
		
	}
	else if(browserName.equals("edge"))
	{
		System.setProperty("webdriver.edge.driver","D:\\Kavya\\msedgedriver.exe");
		driver = new EdgeDriver();
	}	
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	return driver;
	
	}	
	public String getScreenshotPath(String testcaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String filePath = System.getProperty("user.dir")+"\\reports\\"+testcaseName+".png";
		FileUtils.copyFile(source,new File(filePath));
		return filePath;
	}

}

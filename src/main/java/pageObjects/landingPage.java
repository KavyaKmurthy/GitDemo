package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class landingPage {
	
	public WebDriver driver;
	
	private By signIn = By.cssSelector("a[href*='sign_in']");
	private By title = By.xpath("//div[@class='text-center']/h2");
	private By naviBar = By.xpath("//nav[@class='navbar-collapse collapse']"); 
	private By headerText = By.xpath("//div[@class='col-sm-6 col-md-8 hidden-xs video-banner']/h3");
	
	
	
	 public landingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		 
		 this.driver = driver;
	}




public loginPage getLogin()
{
	driver.findElement(signIn).click();
	return new loginPage(driver);
	
}
public WebElement getTitle()
{
	return driver.findElement(title);
}
public WebElement getBar()
{
	return driver.findElement(naviBar);
}
public WebElement getHeaderText()
{
	return driver.findElement(headerText);
}
}

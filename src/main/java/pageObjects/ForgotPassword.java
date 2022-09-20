package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class ForgotPassword {
	
	public WebDriver driver;
	
	By email = By.xpath("//input[@id='user_email']");
	By SendMe = By.name("commit");
	 
	 public ForgotPassword(WebDriver driver) {
		// TODO Auto-generated constructor stub
		 
		 this.driver = driver;
	}
	 
	 public WebElement getEmail()
	 {
		 return driver.findElement(email);
	 }
	 
	 public WebElement forgotLink()
	 {
		 return driver.findElement(SendMe);
	 }
	 





}

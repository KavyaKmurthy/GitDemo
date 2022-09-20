package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class loginPage {
	
	public WebDriver driver;
	
	 By email = By.xpath("//input[@id='user_email']");
	 By password = By.xpath("//input[@type='password']");
	 By login = By.xpath("//input[@type='submit']");
	 By ForgtPassword = By.linkText("Forgot Password?");
	 public loginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		 
		 this.driver = driver;
	}

     public ForgotPassword Forgotpassword()
     {
    	 driver.findElement(ForgtPassword).click();
    	 return new ForgotPassword(driver);
    	 
     }

	 public WebElement userid()
	 {
	 	return driver.findElement(email);
	 }
	 public WebElement password()
	 {
	 	return driver.findElement(password);
	 }
public WebElement getLogin()
{
	return driver.findElement(login);
}

}

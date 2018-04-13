package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import testBase.TestBase;

public class FaceBookLoginPage extends TestBase{

	
	public static final By userName = By.xpath("//input[contains(@type,'email')]");
	
	public static final By password = By.xpath("//input[contains(@type,'email')]/following::input[1]");
	
	public static final By login = By.xpath("//input[contains(@value,'Log In')]");
	
	
	
	public static void enterUsername()
	{
		driver.findElement(FaceBookLoginPage.userName).sendKeys(prop.getProperty("username"));
		
	}
	
	public static void enterPassword()
	{
		driver.findElement(FaceBookLoginPage.password).sendKeys(prop.getProperty("password"));
	}
	
	public static void login()
	{
		driver.findElement(FaceBookLoginPage.password).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
			
}
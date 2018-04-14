package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import testBase.TestBase;

public class DatePickerPage extends TestBase {

	public static final  By skipLoginButton = By.xpath("//button[contains(text(),'Skip Sign In')]");
	
	public static final By widget =By.xpath("//a[contains(text(),'Widgets')]");
	
	public static final By dataPicker = By.xpath("//a[contains(text(),'Widgets')]/following::li[3]");
	
	public static final By enterData= By.xpath("//input[contains(@id,'datepicker1')]");
	
	JavascriptExecutor js;
	
	@Test
	public void selectDatePicker()
	{
		driver.findElement(skipLoginButton).click();
		Actions act = new Actions(driver);
		WebElement element = driver.findElement(widget);
		act.moveToElement(element).perform();
		driver.findElement(dataPicker).click();
		
	js = (JavascriptExecutor)driver;
	
	js.executeScript("document.getElementById('datapicker1').value='13/04/1993'");
	
	
//	js.executeScript("window.scrollBy(0,500)");
//	js.executeScript("window.history.back()");
		
	}
}


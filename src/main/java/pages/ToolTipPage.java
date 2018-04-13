package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.relevantcodes.extentreports.LogStatus;

import testBase.TestBase;

public class ToolTipPage extends TestBase {

	
	public static final By tooltip = By.xpath("//a[contains(text(),'Tooltip')]");
	
	public static final  By moveToAge = By.xpath("//label[contains(text(),'Your age:')]//following::input[1]");
	
	public static final By toolTip = By.xpath("//label[contains(text(),'Your age:')]//following::div[13]");
	
	
	Logger log = Logger.getLogger(ToolTipPage.class);
	
	
	
	public  void clicktooltip()
	{
		driver.findElement(tooltip).click();
		log.info("clicked on ToolTip");
	}
	public void tooltipfunction()
	{
		
		Actions act = new Actions(driver);
		WebElement element = driver.findElement(moveToAge);
		act.moveToElement(element).perform();

		WebElement tooltip1 = driver.findElement(toolTip);
		try{
		if(tooltip1.isDisplayed())
		{
			test.log(LogStatus.PASS, "tooltip is displayed");
		}
		
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		
		
	}
	
}

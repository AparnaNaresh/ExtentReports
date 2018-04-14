package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import testBase.TestBase;

public class AutoITFileUpload extends TestBase{

	public static final By chooseFile = By.xpath("//input[contains(@id,'imagesrc')]");
	
	@Test
	public void uploadFile() throws InterruptedException, IOException
	{
		driver.findElement(DatePickerPage.skipLoginButton).click();
		driver.findElement(chooseFile).click();
		
		Thread.sleep(10000);
		Runtime.getRuntime().exec("C:\\Users\\nares\\Desktop\\Aparna\\fileupload.exe");
		Thread.sleep(10000);
		
	}
}

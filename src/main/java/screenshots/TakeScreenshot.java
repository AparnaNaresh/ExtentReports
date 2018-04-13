package screenshots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import testBase.TestBase;

public class TakeScreenshot extends TestBase {

	

	public static String takeScreenshot() throws IOException
	{
		File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		String imageLocation =System.getProperty("user.dir")+System.currentTimeMillis()+".png";
		FileUtils.copyFile(screenshot, new File(imageLocation));
		return imageLocation;
	}
}

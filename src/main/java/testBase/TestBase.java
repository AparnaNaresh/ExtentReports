package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import screenshots.TakeScreenshot;

public class TestBase {

static public WebDriver driver;
 public static ExtentReports extent;
public  ExtentTest test;
 File f=null;
 FileInputStream fis =null;
 public static Properties prop=null;
 static{
	 Calendar cal = Calendar.getInstance();
	 SimpleDateFormat dataFormat = new SimpleDateFormat("mm-dd-yyy-hh-mm-ss");
	 extent = new ExtentReports(System.getProperty("user.dir")+"/ExtentReports/"+dataFormat.format(cal.getTime())+".html");
	 
	 extent.addSystemInfo("Environment","QA").addSystemInfo("Author","Aparna").addSystemInfo("Application","Facebook");
	 extent.loadConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));
 }
 @BeforeSuite
 public void loadproperties() throws IOException
 {
	 f= new File(System.getProperty("user.dir")+"/config/config.properties");
	 fis = new FileInputStream(f);
	 prop = new Properties();
	 prop.load(fis);
	 
	 
 }
 @BeforeTest
 public void setUp()
 {
	 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.get(prop.getProperty("url"));
	 
 }
 @DataProvider(name="exceldata")
 public void testData()
 {
 }
 
 @BeforeMethod
 public void beforeMethod(Method method)
 {
	 test = extent.startTest(method.getName());
	 test.log(LogStatus.INFO, method.getName()+"test is started");
	 
 }
 @AfterMethod
 public void afterMethod(ITestResult result) throws IOException
 {
	 if(result.getStatus()==ITestResult.SUCCESS)
	 {
		 String screenshot = TakeScreenshot.takeScreenshot();
		  test.log(LogStatus.INFO, result.getName());
		 test.log(LogStatus.PASS, test.addScreenCapture(screenshot));
	 }
	 	
	 else if(result.getStatus()==ITestResult.FAILURE)
	 {
		 String screenshotFail = TakeScreenshot.takeScreenshot();
		
		
		 test.log(LogStatus.FAIL, screenshotFail);
	 }
	 else if(result.getStatus()==ITestResult.SKIP)
		 test.log(LogStatus.SKIP, result.getName()+"is skipped");
	 extent.endTest(test);
 }

 @AfterSuite
 public void closereport()
 {
	
	 extent.flush();
	 extent.close();
	 driver.quit();
 }
}

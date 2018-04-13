package selenium;

import org.testng.annotations.Test;

import pages.FaceBookLoginPage;
import testBase.TestBase;

public class FaceBookLogin extends TestBase{

	@Test
	public void facebooklogin()
	{
		FaceBookLoginPage.enterUsername();
		FaceBookLoginPage.enterPassword();
		FaceBookLoginPage.login();
		
	}
}

package selenium;

import org.testng.annotations.Test;

import pages.ToolTipPage;
import testBase.TestBase;

public class ToolTip extends TestBase {
	ToolTipPage t = new ToolTipPage();
	@Test
	public void tooltiptest()
	{
		t.clicktooltip();
		t.tooltipfunction();
		System.out.println("Aparna");
		
	}
	
}

package in.beingzero.orangeHRMSuite;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SeleniumTest {
	@Test
	public void test()
	{
		FirefoxDriver fd = new FirefoxDriver();
		fd.quit();
	}
}

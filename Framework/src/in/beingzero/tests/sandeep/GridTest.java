package in.beingzero.tests.sandeep;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridTest {
	@Test
	public void test()
	{
		WebDriver wd=null;
		try {
			wd = new RemoteWebDriver(new URL("http://192.168.1.12:4444/wd/hub"), DesiredCapabilities.firefox());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wd.quit();
	}
}

package in.beingzero.tests.sandeep;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BrowserLaunch {

	@Test
	public void test()
	{
		FirefoxDriver fd = new FirefoxDriver();
		fd.get("http://google.com");
		Logger log = LogManager.getLogger("Test");
		Logger log1 = LogManager.getLogger("Test.mylogger");
		log.info("This is an Info Message");
	}
	
}

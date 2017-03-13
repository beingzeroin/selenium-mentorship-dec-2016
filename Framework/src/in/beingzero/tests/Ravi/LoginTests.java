package in.beingzero.tests.Ravi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import in.beingzero.framework.config.Ravi.ConfigManager;
import in.beingzero.framework.config.Ravi.OhrmObjectRepo;

public class LoginTests extends ConfigManager {

	public LoginTests() {
		
	}
	
	public LoginTests(String tstName)
	{
		
	}
	
	@BeforeMethod
	public void setup()
	{
		WebDriver wd = new FirefoxDriver();
		wd.get(OhrmObjectRepo.HOME_PAGE_URL);

		ConfigManager cm = new ConfigManager();
		
		if(cm.isPropertyExisting("fullscreen") && cm.getBooleanProperty("fullscreen"))
				wd.manage().window().maximize();
		
		// WHY part is MISSING!!
		
		// Do setup based on Configuration Manager
		// Launching Browser
		// Full Screen
		// Imp Wait
		// URL to open
	}
	
	@AfterMethod
	public void cleanup()
	{
		
	}
	
	@Test
	public void validLoginTest()
	{
		
	}
	
}

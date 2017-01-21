package in.beingzero.priya;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BeforeAfterTestNG {

	WebDriver driver;
	String downloadDirectory = System.getProperty("user.dir") + "/priya_download";
	
	/*@BeforeMethod
	@Parameters("browser")
	public void launchBrowser(@Optional("FF") String browser)
	{
		if(browser.equalsIgnoreCase("FF"))
		{
			System.out.println("In Firefox Browser");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.out.println("In Chrome browser");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		else
		{
			System.out.println("In IE Browser");
			driver = new InternetExplorerDriver();
		}
	
	}*/
	
	@BeforeMethod
	public void launchBrowser()
	{
		System.out.println("In Chrome browser");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	/*public void launchBrowser()
	{
		System.out.println("In FF browser");
		driver = FirefoxProfilesetup();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	WebDriver FirefoxProfilesetup()
	{
		   //Create FireFox Profile object
		FirefoxProfile fp = new FirefoxProfile();
 
		//Here '2' means save file at the location specified for the most recent download.
		fp.setPreference("browser.download.folderList", 2);
		fp.setPreference( "browser.download.manager.showWhenStarting", false );
		//Set Location to store files after downloading.
		fp.setPreference("browser.download.dir", downloadDirectory);
		//Set Preference to not show file download confirmation dialogue using MIME types Of different file extension types.
		fp.setPreference("browser.helperApps.neverAsk.saveToDisk", 
		    "text/csv;"); 
  
		//return FP parameter In webdriver to use preferences to download file.
		WebDriver driver = new FirefoxDriver(fp);  
		return driver;  

	}*/
	
	
	@AfterMethod
	public void closeBrowser()
	{
		if (driver != null)
		{
			driver.quit();
			driver = null;
		}
		
	}

}

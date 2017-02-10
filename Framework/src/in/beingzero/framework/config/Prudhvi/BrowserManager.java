package in.beingzero.framework.config.Prudhvi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserManager {
	WebDriver objDriver;
	

	public WebDriver launchBrowser()
	{
		ConfigManager objCM=new ConfigManager();
		String strBrowserName=objCM.getProperty("browser");
		WebDriver objDriver;
		if(strBrowserName.equalsIgnoreCase("CHROME"))
		{
			objDriver=new ChromeDriver();
		}
		else if(strBrowserName.equalsIgnoreCase("FIREFOX"))
		{
			objDriver=new FirefoxDriver();
		}
		else
		{
			objDriver=new InternetExplorerDriver();
		}
		
		//To open the URL
		
		objDriver.get(objCM.getProperty("url"));
		
		//To maximize the browser window.
		if(objCM.getBooleanProperty("runFullScreen"))
			objDriver.manage().window().maximize();

		//To set the implicit wait time
		objDriver.manage().timeouts().implicitlyWait(objCM.getLongProperty("implicitTimeoutInSeconds"),TimeUnit.SECONDS);
		return objDriver;
		
	}



	public void CloseBrowser() {
		objDriver.close();
		
	}
}

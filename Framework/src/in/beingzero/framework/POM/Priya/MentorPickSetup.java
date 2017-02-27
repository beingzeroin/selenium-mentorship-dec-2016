package in.beingzero.framework.POM.Priya;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import in.beingzero.framework.config.priya.ConfigMentorPick;

public class MentorPickSetup {

	protected WebDriver driver;
	ConfigMentorPick objConfig;
	
	public MentorPickSetup()
	{
		//Object instance of ConfigMentorPick
		objConfig = new ConfigMentorPick();
		
		//To select the browser 
		String strBrowserName=objConfig.getProperty("browser");
		if(strBrowserName.equalsIgnoreCase("CHROME"))
		{
			driver=new ChromeDriver();
		}
		else if(strBrowserName.equalsIgnoreCase("FIREFOX"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new InternetExplorerDriver();
		}
		
		//To open the URL
		driver.get(objConfig.getProperty("url"));
		
		//To maximize the browser window.
		if(objConfig.getBooleanProperty("runFullScreen"))
			driver.manage().window().maximize();

		//To set the implicit wait time
		driver.manage().timeouts().implicitlyWait(objConfig.getLongProperty("implicitTimeoutInSeconds"), TimeUnit.SECONDS);
	
}

	public MentorPickSetup(WebDriver driver)
	{
		this.driver = driver;
	}

}

package in.beingzero.sandeep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserManager {

		public WebDriver createDriverObject()
		{
			String brType = "chrome"; // We'll read it from a file
			
			WebDriver wd;
			
			if(brType.equals("chrome"))
				wd = new ChromeDriver();
			else if(brType.equals("ie"))
				wd = new InternetExplorerDriver();
			else
				wd = new FirefoxDriver();
			
			return wd;
			
		}
}

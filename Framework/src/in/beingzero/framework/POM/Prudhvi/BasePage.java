package in.beingzero.framework.POM.Prudhvi;

import org.openqa.selenium.WebDriver;

import in.beingzero.framework.config.Prudhvi.BrowserManager;

public class BasePage {
	
	WebDriver driver;
	
	public BasePage()
	{
		BrowserManager objBM=new BrowserManager();
		driver=objBM.launchBrowser();
		
	}

	//This constructor will be used when navigating from one page to another such that new page get opened in the same browser window.
		public BasePage(WebDriver driver)
		{
			this.driver = driver;
		}


}

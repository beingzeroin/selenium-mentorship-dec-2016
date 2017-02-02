package in.beingzero.objectoriented.prudhvi;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser extends BrowserBase
{
	
	@Override
	public void launch() {
		System.out.println("Launching Chrome Browser");
		wd=new ChromeDriver();
	}

	@Override
	public void quit() {
		System.out.println("Quitting Chrome Browser");
		wd.quit();
		
	} 

	String getBrowserName()
	{
		return "Google Chrome";
	}
	

}

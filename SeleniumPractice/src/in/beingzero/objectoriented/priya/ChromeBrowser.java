package in.beingzero.objectoriented.priya;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser extends BrowserBase{

	
	@Override
	public void launch() {
		driver = new ChromeDriver();
		System.out.println("Launching Chrome Browser");
		
	}

	@Override
	public void quit() {
		System.out.println("Quitting Chrome Browser");
	}

	/*@Override
	public void purpose() {
		System.out.println("Browser helps you fetch info from WEB");
	}*/

	public String getBrowserName()
	{
		String chromeTxt = "Google Chrome";
		return chromeTxt;
	}
}

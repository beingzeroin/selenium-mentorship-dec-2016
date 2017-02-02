package in.beingzero.objectoriented.prudhvi;

import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEBrowser extends BrowserBase {

	@Override
	public void launch() {
		System.out.println("Launching IE Browser");
		wd=new InternetExplorerDriver();
	}

	@Override
	public void quit() {
		System.out.println("Quitting IE Browser");
		wd.quit();
	}

	public void purpose()
	{
		System.out.println("IE Browser helps you fetch info from WEB SECURELY");
	}
	
	String getBrowserVersion()
	{
		return "9.11";
	}

}

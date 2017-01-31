package in.beingzero.objectoriented.priya;

import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEBrowser extends BrowserBase{

	@Override
	public void launch() {
		driver = new InternetExplorerDriver();
		System.out.println("Launching IE Browser");
		
	}

	@Override
	public void quit() {
		System.out.println("Quitting IE Browser");	
	}

	@Override
	public void purpose() {
		System.out.println("Browser helps you fetch info from WEB SECURELY");
	}

	public String  getBrowserVersion() {
		String IETxt = "9.11";
		return IETxt;
	}
}

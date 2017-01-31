package in.beingzero.objectoriented.priya;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowser extends BrowserBase{

	@Override
	public void launch() {
		driver = new FirefoxDriver();
		System.out.println("Launching Firefox Browser");
		
	}

	@Override
	public void quit() {
		System.out.println("Quitting Firefox Browser");	
	}

	/*@Override
	public void purpose() {
		System.out.println("Browser helps you fetch info from WEB");
	}*/

}

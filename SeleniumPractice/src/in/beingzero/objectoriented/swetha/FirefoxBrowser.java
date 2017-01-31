package in.beingzero.objectoriented.swetha;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowser extends BrowserBase{

	public void launch() {
		
		wd = new FirefoxDriver();
		
		System.out.println("Launching Firefox Browser");
		
	}

	public void quit() {
		System.out.println("Quitting Firefox Browser");
		
	}


}

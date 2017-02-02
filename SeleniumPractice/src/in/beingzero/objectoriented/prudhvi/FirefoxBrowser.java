package in.beingzero.objectoriented.prudhvi;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowser extends BrowserBase {

	@Override
	public void launch() {
		System.out.println("Launching Firefox Browser");
		wd=new FirefoxDriver();
	}

	@Override
	public void quit() {
		System.out.println("Quitting Firefox Browser");
		wd.quit();
	}

	
}

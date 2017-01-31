package in.beingzero.objectoriented.swetha;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowser extends BrowserBase{

	public void launch() {
		
		wd = new FirefoxDriver();
		
		System.out.println("Launching Firefox Browser");
		
	}

	public void quit() {
		wd.quit();
		System.out.println("Quitting Firefox Browser");
		
	}

//	public void launch(boolean launchMaximized) {
//		
//		if(launchMaximized){
////			wd = new FirefoxDriver();
//			wd.manage().window().maximize();
//			System.out.println("Browser maximized");
//		} 
////		else{
////			wd = new FirefoxDriver();
////		}
//	}
}

package in.beingzero.objectoriented.swetha;

import org.openqa.selenium.WebDriver;

public abstract class BrowserBase implements Browser{
	
	WebDriver wd;
	
	public void purpose() {
		
		System.out.println("Browser helps you fetch info from World Wide WEB");
		
	}
	public void launch(boolean launchMaximized) {
		
		if(launchMaximized){
			wd.manage().window().maximize();
			System.out.println("Browser maximized");
		}
	}	
		
}

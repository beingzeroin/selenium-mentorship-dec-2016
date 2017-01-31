package in.beingzero.objectoriented.swetha;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser extends BrowserBase{

	public void launch() {
		
		wd= new ChromeDriver();
		
		System.out.println("Launching Chrome Browser");
		
	}

	public void quit() {
		System.out.println("Quitting Chrome Browser");
		
	}
	
	public String getBrowserName(){
		return "Google Chrome";
	}
	
	public void launch(boolean launchMaximized) {
		
		if(launchMaximized){
			wd= new ChromeDriver();
			wd.manage().window().maximize();
			System.out.println("Browser maximized");
		} else{
			wd= new ChromeDriver();
		}
	}	
	

}

package in.beingzero.objectoriented.swetha;

import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEBrowser extends BrowserBase {

	@Override
	public void quit() {
		System.out.println("Quitting IE Browser");
		
	}
	

	String getBrowserVersion(){
		return "9.11";
		
	}
	
	public void purpose() {
		System.out.println("IE Browser helps you fetch info from WEB SECURELY");
		
	}

	@Override
	public void launch() {
		
		wd= new InternetExplorerDriver();
		System.out.println("Launching IE Browser");
		
	}



}

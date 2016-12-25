package in.beingzero.swetha;

import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserCommands {

	public static void main(String[] args) {
		// Launch browser
        FirefoxDriver browser = new FirefoxDriver();
 
       // Go to BeingZero Home Page.
       browser.get("http://beingzero.in/our-team");
 
       // Print Page Title, URL and Length of Page Source
       System.out.println("Currently On "+browser.getTitle()+ " Page");
       System.out.println("Current page URL is "+browser.getCurrentUrl());
       System.out.println("Length of Page Source Code : "+browser.getPageSource().length());
	}

}

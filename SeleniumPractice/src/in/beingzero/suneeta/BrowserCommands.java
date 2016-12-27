package in.beingzero.suneeta;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserCommands {

	public static void main(String[] args) {
			
			// Launch browser
			 WebDriver browser = new FirefoxDriver();
			
			 //Request webdriver object to browse ‘Our Team Page’ (http://beingzero.in/our-team)
			 browser.get("http://beingzero.in");
        
			//Print the Page Title, Current Url, Length of Page Source
			System.out.println("Currently On "+browser.getTitle()+ " Page");
		    System.out.println("Current page URL is "+browser.getCurrentUrl());
		    System.out.println("Length of Page Source Code : "+browser.getPageSource().length());
		 
		    
		    //Quit the Browser
		    browser.quit();
	}

}

package in.beingzero.swetha;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationCommands {
	
	public static String  CurrentUrl = null;
	
	public static String  GetTitle = null;

	public static void main(String[] args) throws InterruptedException {
		  // Launch Browser
        WebDriver browser = new FirefoxDriver();
 
        // Get Access to Navigator Object
        Navigation navigator = browser.navigate();
        
        // Navigate to Google and Wait for 2 seconds
        navigator.to("http://google.com");
        Thread.sleep(2000); 

        // Navigate to Yahoo and Wait for 2 seconds
        navigator.to("http://yahoo.com");
        Thread.sleep(2000); 
        
        // Navigate to Microsoft and Wait for 2 seconds
        navigator.to("http://microsoft.com");
        Thread.sleep(2000); 
        
        // Navigate Back to Yahoo and Wait for 2 seconds
        navigator.back();
        Thread.sleep(2000); 
        
        // Navigate forward to Microsoft and Wait for 2 seconds
        navigator.forward();
        Thread.sleep(2000); 
        
        CurrentUrl= browser.getCurrentUrl();
        System.out.println(CurrentUrl);
        
        GetTitle = browser.getTitle();
        System.out.println(GetTitle);
	}

}

package in.beingzero.framework.POM.sandeep;

import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {

	
	// If Test Wants to open page in new browser
	// Call this constructor
	public LoginPage() {
		//super();  // Inhertiance by default will call constructor of superclass
	}
	
	// If this page is being returned by some other function
	// That has a browser opened call this one.
	public LoginPage(WebDriver wd) {
		
		driver = wd;
		
	}

	public DashboardPage validLogin(String userName, String password) {
		
		// Find un textbox and sendkeys
		
		// find password txtbo and sendkeys
		
		// click login button
		
		return new DashboardPage(driver);
	}
	
}

package in.beingzero.priya;

import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserCommands {

	public static void main(String[] args) {
		
		FirefoxDriver driver = new FirefoxDriver();
		
		driver.get("http://beingzero.in/our-team");
		System.out.println("Page Title is : " + driver.getTitle());
		System.out.println("Current URL : " + driver.getCurrentUrl());
		System.out.println("Length of the current page source :" + driver.getPageSource().length());
		driver.quit();
		
	}

}

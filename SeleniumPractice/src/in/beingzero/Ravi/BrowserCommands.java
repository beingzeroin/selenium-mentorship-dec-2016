package in.beingzero.Ravi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BrowserCommands {

	public static void main(String[] args) {
		WebDriver fd = new ChromeDriver();
		fd.get("http://beingzero.in/our-team");
		System.out.println("Currently on "+fd.getTitle()+" page");
		System.out.println("URL of page is "+fd.getCurrentUrl());
		System.out.println("Length of the page source is "+fd.getPageSource().length());
		fd.quit();
	}

}

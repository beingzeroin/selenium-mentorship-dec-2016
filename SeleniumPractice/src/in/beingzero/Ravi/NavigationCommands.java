package in.beingzero.Ravi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationCommands {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		WebDriver ch = new ChromeDriver();
		Navigation navigator = ch.navigate();
		navigator.to("http://google.com");
		Thread.sleep(2000);
		navigator.to("http://yahoo.com");
		Thread.sleep(2000);
		navigator.to("http://microsoft.com");
		Thread.sleep(2000);
		navigator.back();
		Thread.sleep(2000);
		navigator.forward();
		Thread.sleep(2000);
		System.out.println("Page's URL is "+ch.getCurrentUrl());
		System.out.println("Currently on page "+ch.getTitle());
		ch.quit();
		

	}

}

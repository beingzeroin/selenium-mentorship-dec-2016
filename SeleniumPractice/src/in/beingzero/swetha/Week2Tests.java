package in.beingzero.swetha;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Week2Tests {

	public static void main(String[] args) {
		System.out.println("Verification passed");
		FirefoxDriver fd = new FirefoxDriver();

		fd.get("http://opensource.demo.orangehrmlive.com");
	}

}

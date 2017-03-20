package in.beingzero.Ravi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BeingZeroLogo {

	public static void main(String[] args) throws Exception {
		WebDriver ch = new FirefoxDriver();
		ch.get("http://beingzero.in/");
		Thread.sleep(4000);
		WebElement logo = ch.findElement(By.xpath("//div[@id='branding']//img[@class='preload-me']"));
		System.out.println("location: " + logo.getLocation());
		System.out.println("Dimension: " + logo.getSize());
		ch.quit();

	}

}

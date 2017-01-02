package in.beingzero.Ravi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriver ch = new ChromeDriver();
		Navigation navigator = ch.navigate();
		navigator.to("https://www.google.co.in/");
		WebElement srchbx = ch.findElement(By.name("q"));
		Thread.sleep(2000);
		srchbx.sendKeys("github");
		Thread.sleep(2000);
		srchbx.submit();
		navigator.back();
		Thread.sleep(2000);
		WebElement srch = ch.findElement(By.name("btnK"));
		Thread.sleep(2000);
		srchbx.sendKeys("let's play");
		Thread.sleep(2000);
		srch.submit();
		ch.quit();
	}

}

package in.beingzero.Ravi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookSignUpPage {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriver ch = new ChromeDriver();
		Navigation navigator = ch.navigate();
		navigator.to("https://www.facebook.com/");
		Thread.sleep(2000);
		WebElement un = ch.findElement(By.name("firstname"));
		WebElement uln = ch.findElement(By.name("lastname"));
		WebElement mob = ch.findElement(By.name("reg_email__"));
		WebElement conmob = ch.findElement(By.name("reg_email_confirmation__"));
		WebElement pwd = ch.findElement(By.name("reg_passwd__"));
		WebElement male = ch.findElement(By.id("u_0_i"));
		
		un.clear();
		un.sendKeys("Ravi");
		uln.clear();
		uln.sendKeys("Dubey");
		mob.clear();
		mob.sendKeys("9642994500");
		conmob.clear();
		conmob.sendKeys("9642994500");
		pwd.clear();
		pwd.sendKeys("test");
		male.click();
	}

}

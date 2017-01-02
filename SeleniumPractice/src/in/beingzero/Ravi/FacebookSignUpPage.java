package in.beingzero.Ravi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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
		WebElement dob = ch.findElement(By.id("day"));
		Select d = new Select(dob);
		WebElement mob1 = ch.findElement(By.id("month"));
		Select m = new Select(mob1);
		WebElement yob = ch.findElement(By.id("year"));
		Select y = new Select(yob);		
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
		d.selectByVisibleText("9");
		m.selectByVisibleText("Jun");
		y.selectByVisibleText("1986");
	}

}

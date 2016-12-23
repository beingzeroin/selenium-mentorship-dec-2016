package in.beingzero.priya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class WebElementCommands {

	public void FacebookAccCreation() throws Exception{
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.facebook.com/");
		
		WebElement firstname = driver.findElement(By.name("firstname"));
		firstname.clear();
		firstname.sendKeys("Jame");

		WebElement lastname = driver.findElement(By.name("lastname"));
		lastname.clear();
		lastname.sendKeys("Rai");
		
		WebElement email = driver.findElement(By.name("reg_email__"));
		email.clear();
		email.sendKeys("abc.def@gmail.com");
		
		
		WebElement confirmemail = driver.findElement(By.name("reg_email_confirmation__"));
		confirmemail.clear();
		confirmemail.sendKeys("abc.def@gmail.com");

		
		WebElement newpassword = driver.findElement(By.name("reg_passwd__"));
		newpassword.clear();
		newpassword.sendKeys("1234");
		
		
		WebElement gender = driver.findElement(By.id("u_0_i"));
		gender.click();
		
		Select birthdaydate = new Select(driver.findElement(By.name("birthday_day")));
		//Select birthdaydate = new Select(driver.findElement(By.xpath("//select[@name='birthday_day']")));
		birthdaydate.selectByValue("29");
		
		Select birthdaymon = new Select(driver.findElement(By.name("birthday_month")));
		birthdaymon.selectByValue("4");
		
		Select birthdayyear = new Select(driver.findElement(By.name("birthday_year")));
		birthdayyear.selectByValue("1905");
		
		//WebElement createaccount = driver.findElement(By.id("u_0_e"));
		//createaccount.click();
		//Thread.sleep(2000);
		
		
		driver.close();
	
	}

	
	public void googlequery()
	{
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.google.com/");
		
		WebElement querytxtbox = driver.findElement(By.id("lst-ib"));
		querytxtbox.clear();
		querytxtbox.sendKeys("Being Zero");
		
		WebElement googlesrch = driver.findElement(By.id("_fZl"));
		googlesrch.click();
		
		System.out.println("Being Zero result is shown");
		driver.quit();
	}
	
	public void BeingZeroImage()
	{
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://beingzero.in/");
		
		WebElement beingzeroimg = driver.findElement(By.xpath("//*[@id=’branding’]//img"));
		System.out.println("Location of BeingZero IMG : " + beingzeroimg.getLocation());
		System.out.println("Size of the BeingZero IMG : " + beingzeroimg.getSize());
		driver.quit();
		
		
	}
}

package in.beingzero.prudhvi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class WebElementCommands 
{
	
@Test
	public void SignupFacebook()
	{
	    //TODO:  PRUDHVI Portability Issue.  This won't run on other's machine. How to fix it?
		System.setProperty("webdriver.chrome.driver","E:\\SeleniumProject\\chromedriver.exe");
		//ChromeDriver driver=new ChromeDriver();
		FirefoxDriver driver =new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		
		WebElement Email=driver.findElementById("email");
		Email.clear();
		Email.sendKeys("abc@gmail.com");
		

		WebElement Password=driver.findElementById("pass");
		Password.clear();
		Password.sendKeys("Hello");
		
		
		WebElement FirstName=driver.findElementByName("firstname");
		FirstName.clear();
		FirstName.sendKeys("Prudhvi");
		

		WebElement LastName=driver.findElementByName("lastname");
		LastName.clear();
		LastName.sendKeys("Tammana");
		

		WebElement MobOrEmail=driver.findElementByName("reg_email__");
		MobOrEmail.clear();
		MobOrEmail.sendKeys("def@gmail.com");
		
		

		WebElement ReMobOrEmail=driver.findElementByName("reg_email_confirmation__");
		ReMobOrEmail.clear();
		ReMobOrEmail.sendKeys("def@gmail.com");
		

		WebElement NewPassword=driver.findElementByName("reg_passwd__");
		NewPassword.clear();
		NewPassword.sendKeys("PWD123");
		
			
		Select BirthDay = new Select(driver.findElement(By.name("birthday_day")));
		BirthDay.selectByValue("22");
		
		Select BirthMonth = new Select(driver.findElement(By.name("birthday_month")));
		BirthMonth.selectByValue("12");

		
		Select BirthYear = new Select(driver.findElement(By.name("birthday_year")));
		BirthYear.selectByValue("2012");


		WebElement Gender=driver.findElement(By.id("u_0_i"));
		
		Gender.click();
		
			

	}

@Test

public void SearchStringInGoogle()
{
	FirefoxDriver driver=new FirefoxDriver();
	
	driver.get("https://www.google.co.in");
	
	driver.findElementByName("q").sendKeys("Being Zero");
	driver.findElementByName("btnK");
	driver.close();
}

@Test

public void PrintLocationofImage()
{
FirefoxDriver driver=new FirefoxDriver();
	
	//System.setProperty("webdriver.chrome.driver","E:\\SeleniumProject\\chromedriver.exe");
	//ChromeDriver driver=new ChromeDriver();
	
	driver.get("http://beingzero.in");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	WebElement imgBeingZerp=driver.findElementByXPath("//*[@id='branding']/a/img");
	System.out.println("Location of the Image : " + imgBeingZerp.getLocation());
	System.out.println("Size of the Image : " + imgBeingZerp.getSize());
	driver.quit();
	

}

}

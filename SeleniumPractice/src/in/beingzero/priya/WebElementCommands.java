package in.beingzero.priya;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementCommands {

	public void FacebookAccCreation() throws Exception{
		
		//WebDriver driver = new FirefoxDriver();
		//TODO:  PRIYA Portability Problem, Won't Run on My Machine.
		System.setProperty("webdriver.chrome.driver","C:\\Users\\priya\\Desktop\\Priya\\SeleniumJava\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
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
		
		WebElement Birthdate = driver.findElement(By.name("birthday_day"));
		
		//Select birthdaydate = new Select(driver.findElement(By.xpath("//select[@name='birthday_day']")));
		
		System.out.println("Birthdate located");
		Select birthdaydate = new Select(Birthdate);
		System.out.println("Birthdate is going to Select");
		birthdaydate.selectByValue("29");
		System.out.println("Birthdate is Selected");
		
		WebElement BirthMonth = driver.findElement(By.name("birthday_month"));
		System.out.println("Birthmonth located");
		Select birthdaymon = new Select(BirthMonth);
		System.out.println("Birthmonth is going to Select");
		birthdaymon.selectByValue("4");
		System.out.println("Birthmonth is Selected");
		
		WebElement BirthYear = driver.findElement(By.name("birthday_year"));
		System.out.println("BirthYear located");
		Select birthdayyear = new Select(BirthYear);
		System.out.println("BirthYear is going to Select");
		birthdayyear.selectByValue("1905");
		System.out.println("BirthYear is Selected");
		
		WebElement createaccount = driver.findElement(By.id("u_0_e"));
		createaccount.click();
		
		//driver.close();
	
	}

	
	public void googlequery()
	{
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
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
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		//got the error "Your connection is not secure page displayed instead of loading the beingzero site"
		
		WebElement beingzeroimg = driver.findElement(By.xpath("//*[@id=�branding�]//img"));
		System.out.println("Location of BeingZero IMG : " + beingzeroimg.getLocation());
		System.out.println("Size of the BeingZero IMG : " + beingzeroimg.getSize());
		driver.quit();
		
		
	}
}

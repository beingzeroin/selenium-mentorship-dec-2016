package in.beingzero.priya;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Week2TClogout {

	public static void main(String[] args) throws Exception {

		//WebDriver driver = new FirefoxDriver();
		//TODO:  PRIYA Portability Issue, Won't Run on my machine.  Think of solving it.
		System.setProperty("webdriver.chrome.driver","C:\\Users\\priya\\Desktop\\Priya\\SeleniumJava\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		Navigation navigator = driver.navigate();
		
		//This is not working in firefox becuase of the existing issue that's why used the chrome driver to test it.
		Actions WelcomeAbt = new Actions(driver);
		
		driver.get("http://opensource.demo.orangehrmlive.com");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		WebElement UserId = driver.findElement(By.id("txtUsername"));
		UserId.clear();
		UserId.sendKeys("Admin");
	
		WebElement Password = driver.findElement(By.id("txtPassword"));
		Password.clear();
		Password.sendKeys("admin");
	
		WebElement Login = driver.findElement(By.id("btnLogin"));
		Login.click();
		
		WebElement WelcomeAdmin = driver.findElement(By.id("welcome"));
		WelcomeAdmin.click();
		System.out.println("welcome clicked");
		Thread.sleep(5000);
		
		WelcomeAbt.moveToElement(WelcomeAdmin).build().perform();
		System.out.println("welcome Menu");
		
		//WebElement WelcomeMenu = driver.findElement(By.id("welcome-menu"));
		//WelcomeMenu.click();
		//System.out.println("welcome Menu shown");
		
		
		WebDriverWait wait = new WebDriverWait(driver, 2); 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='welcome-menu']/ul/li[2]/a")));

		System.out.println("wait implemented");
		WebElement LogoutHRM = driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[2]/a"));
		LogoutHRM.click();
		System.out.println("Logout at Orange HRM clicked");
		navigator.to("http://opensource.demo.orangehrmlive.com/index.php/auth/login");
		
		
		String currenturl = driver.getCurrentUrl();
		String titleofcurrentpage = driver.getTitle();
		
		System.out.println("Current URL : " + currenturl);
		System.out.println("Current page Title is : " + titleofcurrentpage);
		
		String Expectedtitle = "OrangeHRM";
		Assert.assertEquals(titleofcurrentpage, Expectedtitle);
		
		System.out.println("Succesfully logout from orange HRM");
		
		
		driver.quit();

	}

}

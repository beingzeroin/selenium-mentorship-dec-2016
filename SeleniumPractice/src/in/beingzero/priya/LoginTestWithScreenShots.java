package in.beingzero.priya;

import java.io.File;

import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.TakesScreenshot;

public class LoginTestWithScreenShots {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new ChromeDriver();
		
		Navigation navigator = driver.navigate();
		
		
		Actions WelcomeAbt = new Actions(driver);
		
		driver.get("http://opensource.demo.orangehrmlive.com");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		// Take screenshot and store as a file format
		File src1= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src1, new File(System.getProperty("user.dir").concat("\\Images\\Priya\\LoginTestWithScreenShots\\login1.jpg")));
				
		WebElement UserId = driver.findElement(By.id("txtUsername"));
		UserId.clear();
		UserId.sendKeys("Admin");
	
		File src2= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src2, new File(System.getProperty("user.dir").concat("\\Images\\Priya\\LoginTestWithScreenShots\\login2.jpg")));
		
		WebElement Password = driver.findElement(By.id("txtPassword"));
		Password.clear();
		Password.sendKeys("admin");
	
		File src3= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src3, new File(System.getProperty("user.dir").concat("\\Images\\Priya\\LoginTestWithScreenShots\\login3.jpg")));
		
		WebElement Login = driver.findElement(By.id("btnLogin"));
		Login.click();
		
		File src4= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src4, new File(System.getProperty("user.dir").concat("\\Images\\Priya\\LoginTestWithScreenShots\\login4.jpg")));
		
		WebElement WelcomeAdmin = driver.findElement(By.id("welcome"));
		WelcomeAdmin.click();
		System.out.println("welcome clicked");
		Thread.sleep(5000);
		
		File src5= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src5, new File(System.getProperty("user.dir").concat("\\Images\\Priya\\LoginTestWithScreenShots\\login5.jpg")));
		
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
		
		File src6= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src6, new File(System.getProperty("user.dir").concat("\\Images\\Priya\\LoginTestWithScreenShots\\login6.jpg")));
		
		System.out.println("Logout at Orange HRM clicked");
		navigator.to("http://opensource.demo.orangehrmlive.com/index.php/auth/login");
		
		File src7= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src7, new File(System.getProperty("user.dir").concat("\\Images\\Priya\\LoginTestWithScreenShots\\login7.jpg")));
		
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

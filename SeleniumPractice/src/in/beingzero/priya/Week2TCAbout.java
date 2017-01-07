package in.beingzero.priya;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Week2TCAbout {

	public static void main(String[] args) throws Exception {
		
		
		WebDriver driver = new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\priya\\Desktop\\Priya\\SeleniumJava\\chromedriver_win32\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		//This is not working in firefox becuase of the existing issue that's why used the chrome driver to test it.
		Actions WelcomeAbt = new Actions(driver);
		
		driver.get("http://opensource.demo.orangehrmlive.com");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
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
		Thread.sleep(7000);
		
		WelcomeAbt.moveToElement(WelcomeAdmin).build().perform();
		System.out.println("welcome Menu");
		
		//WebElement WelcomeMenu = driver.findElement(By.id("welcome-menu"));
		//WelcomeMenu.click();
		//System.out.println("welcome Menu shown");
		
		//WelcomeAbt.moveToElement(WelcomeMenu).build().perform();
		// wait for max of 5 seconds before proceeding. This allows sub menu appears properly before trying to click on it
		WebDriverWait wait = new WebDriverWait(driver, 5); 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("aboutDisplayLink")));

		System.out.println("wait implemented");
		WebElement AboutHRM = driver.findElement(By.id("aboutDisplayLink"));
		AboutHRM.click();
		System.out.println("AboutHRM click");
		
		WebElement Formchk = driver.findElement(By.xpath("//div[@id='companyInfo']//p"));
		System.out.println("Paragraph identified");
		
		String AboutHRMtxt = Formchk.getText();
		String ExpectedHRMtxt = "Company Name: OrangeHRM (Pvt) Ltd";
		Assert.assertEquals(AboutHRMtxt, ExpectedHRMtxt);
		System.out.println("login to Company Name: OrangeHRM (Pvt) Ltd");
		driver.quit();

	}

}

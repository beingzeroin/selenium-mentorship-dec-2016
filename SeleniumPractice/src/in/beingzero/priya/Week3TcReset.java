package in.beingzero.priya;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Week3TcReset {

	public static void main(String[] args) throws Exception {
		
		
		//WebDriver driver = new FirefoxDriver();
		//TODO:  PRIYA Portability Issue.  Refer other TODOs
		//Done
		WebDriver driver = new ChromeDriver();
		
		//This is not working in firefox becuase of the existing issue that's why used the chrome driver to test it.
				
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
		
		WebElement Directory = driver.findElement(By.id("menu_directory_viewDirectory"));
		//Directory.click();
		String directoryhref = Directory.getAttribute("href");
		//String directoryhref = driver.findElement(By.xpath("//*[@id='menu_directory_viewDirectory']/a")).getAttribute("href");
		driver.get(directoryhref);
		System.out.println("directory clicked");
		
		
		WebElement DName = driver.findElement(By.id("searchDirectory_emp_name_empName"));
		DName.clear();
		DName.sendKeys("ABCD");
		
		WebElement Jobtitle = driver.findElement(By.id("searchDirectory_job_title"));
		Select seljobtitle = new Select(Jobtitle);
		seljobtitle.selectByValue("5");
		
		
		WebElement Joblocation = driver.findElement(By.id("searchDirectory_location"));
		Select seljoblocation = new Select(Joblocation);
		seljoblocation.selectByValue("4,-1");
		
		
		System.out.println("reset the values");
		WebElement resetbtn = driver.findElement(By.id("resetBtn"));
		System.out.println("reset button clicked");
		resetbtn.click();
		System.out.println("reset clicked");
		
		driver.quit();
	}

}

package in.beingzero.priya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

//TODO:  PRIYA Separate out Setup and Cleanup methods
//Done
public class SelTest1 extends BeforeAfterTestNG
{
	//Test Case 1 with Valid UserId and Valid Password
	@Test
	public void validUserNameandPassword()
	{
		//WebDriver driver = new FirefoxDriver();
		driver.get("http://opensource.demo.orangehrmlive.com");
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		WebElement UserId = driver.findElement(By.id("txtUsername"));
		UserId.clear();
		UserId.sendKeys("Admin");
	
		WebElement Password = driver.findElement(By.id("txtPassword"));
		Password.clear();
		Password.sendKeys("admin");
	
		WebElement Login = driver.findElement(By.id("btnLogin"));
		Login.click();
	
		//String Actuallogger = driver.findElement(By.xpath("//a[@class='Welcome Admin']/@href)")).getText();
		String Actuallogger = driver.findElement(By.id("welcome")).getText();
		String Expectedlogger = "Welcome Admin";
	
		Assert.assertEquals(Expectedlogger, Actuallogger);
		System.out.println("Successfully login into OrangeHRM by Admin");
		//driver.close();
		//driver.quit();
	}

	//Test Case 2 with invalid UserId and Valid Password
	@Test
	public void invalidUserNameandcorrectPassword()
	{
		//WebDriver driver = new FirefoxDriver();
		driver.get("http://opensource.demo.orangehrmlive.com");
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		WebElement UserId = driver.findElement(By.id("txtUsername"));
		UserId.clear();
		UserId.sendKeys("Amin");
	
		WebElement Password = driver.findElement(By.id("txtPassword"));
		Password.clear();
		Password.sendKeys("admin");
	
		WebElement Login = driver.findElement(By.id("btnLogin"));
		Login.click();
	
		String Actuallogger = driver.findElement(By.xpath("//span[contains(text(),'Invalid credentials')]")).getText();
		String Expectedlogger = "Invalid credentials";
	
		Assert.assertEquals(Expectedlogger, Actuallogger);
		System.out.println("Login with valid userid into OrangeHRM");
		//driver.close();
		
	}
	
	//Test Case 3 with Valid UserId and invalid Password
	@Test
	public void correctUserNameandInvalidPassword()
	{
		//WebDriver driver = new FirefoxDriver();
		driver.get("http://opensource.demo.orangehrmlive.com");
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		WebElement UserId = driver.findElement(By.id("txtUsername"));
		UserId.clear();
		UserId.sendKeys("Admin");
	
		WebElement Password = driver.findElement(By.id("txtPassword"));
		Password.clear();
		Password.sendKeys("admn");
	
		WebElement Login = driver.findElement(By.id("btnLogin"));
		Login.click();
	
		String Actuallogger = driver.findElement(By.xpath("//span[contains(text(),'Invalid credentials')]")).getText();
		String Expectedlogger = "Invalid credentials";
	
		Assert.assertEquals(Expectedlogger, Actuallogger);
		System.out.println("Login with valid password into OrangeHRM");
		//driver.close();
		
	}
	
	//Test Case 4 with blank UserId and Password
	@Test
	public void blankUserNameandPassword()
	{
		//WebDriver driver = new FirefoxDriver();
		driver.get("http://opensource.demo.orangehrmlive.com");
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		WebElement UserId = driver.findElement(By.id("txtUsername"));
		UserId.clear();
		UserId.sendKeys("");
	
		WebElement Password = driver.findElement(By.id("txtPassword"));
		Password.clear();
		Password.sendKeys("");
	
		WebElement Login = driver.findElement(By.id("btnLogin"));
		Login.click();
	
		String Actuallogger = driver.findElement(By.xpath("//span[contains(text(),'Username cannot be empty')]")).getText();
		String Expectedlogger = "Username cannot be empty";
	
		Assert.assertEquals(Expectedlogger, Actuallogger);
		System.out.println("User Id Should Not be blank");
		//driver.close();
		
	}

	//Test Case 5 with blank Password
	@Test
	public void validUserNameandBlankPassword()
	{
		//WebDriver driver = new FirefoxDriver();
		driver.get("http://opensource.demo.orangehrmlive.com");
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		WebElement UserId = driver.findElement(By.id("txtUsername"));
		UserId.clear();
		UserId.sendKeys("Admin");
	
		WebElement Password = driver.findElement(By.id("txtPassword"));
		Password.clear();
		Password.sendKeys("");
	
		WebElement Login = driver.findElement(By.id("btnLogin"));
		Login.click();
	
		String Actuallogger = driver.findElement(By.xpath("//span[contains(text(),'Password cannot be empty')]")).getText();
		String Expectedlogger = "Password cannot be empty";
	
		Assert.assertEquals(Expectedlogger, Actuallogger);
		System.out.println("Password Should Not be blank");
		//driver.close();
		//driver.quit();
	}
	
}

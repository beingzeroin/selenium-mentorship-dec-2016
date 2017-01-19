package in.beingzero.prudhvi;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScreenShots {
	
	
	String strUrl="http://opensource.demo.orangehrmlive.com";
	String strUserName="Admin";
	String strPwd="admin";
	WebDriver driver;
	public  void captureScreenShots(String strTestName,String strStepName)
	{
		Date objDate=new Date();
		String DateTime=objDate.toString().replace(":", "").replace(" ", "");
		System.out.println(DateTime);
		TakesScreenshot Ts;
		Ts=(TakesScreenshot) driver;
		
		File sourceFile=Ts.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(sourceFile, new File("./images/Prudhvi/"+strTestName+"/"+strStepName+"_"+DateTime+".jpg"));
			System.out.println("Taken capture");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
	}
	
	public static void main(String[] args)
	{
		
		
	}
	@BeforeMethod
	
	public void Setup()
	{
	
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void Login(ITestContext context)
	{
		driver.get(strUrl);
		//ITestResult result;
		String strTestName=context.getName();
		System.out.println(strTestName);
		captureScreenShots(strTestName,"Login");
		driver.findElement(By.id("txtUsername")).sendKeys(strUserName);
		captureScreenShots(strTestName,"UserName Entered");
		driver.findElement(By.id("txtPassword")).sendKeys(strPwd);
		captureScreenShots(strTestName,"Password Entered");
		driver.findElement(By.id("btnLogin")).sendKeys();
		driver.findElement(By.id("btnLogin")).click();
	}
	
	
	
	
	
	
	
	@AfterMethod
	public void Cleanup()
	{
		driver.quit();
	}

}

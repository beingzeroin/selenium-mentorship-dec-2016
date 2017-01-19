package in.beingzero.prudhvi;

import java.io.File;
import java.lang.reflect.Method;
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
	String strMethodName;
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
	
	public void Setup(Method method)
	{
		strMethodName=method.getName();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void Login( )
	{
		driver.get(strUrl);
		//ITestResult result;

		captureScreenShots(strMethodName,"Login");
		driver.findElement(By.id("txtUsername")).sendKeys(strUserName);
		captureScreenShots(strMethodName,"UserName Entered");
		driver.findElement(By.id("txtPassword")).sendKeys(strPwd);
		captureScreenShots(strMethodName,"Password Entered");
		driver.findElement(By.id("btnLogin")).sendKeys();
		driver.findElement(By.id("btnLogin")).click();
	}
	
	
	
	
	
	
	
	@AfterMethod
	public void Cleanup()
	{
		driver.quit();
	}

}

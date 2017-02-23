package in.beingzero.objectoriented.priya;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MentorPickTestCk {
	
		public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.get("http://mentorpick.com/");
		driver.manage().window().maximize();
		//driver.findElement(By.className("page-scroll")).click();;
		driver.findElement(By.xpath(".//*[@id='page-top']/nav/div/div[2]/ul/li[5]/a")).click();
		
		System.out.println("Login clicked");
		//Thread.sleep(000);
		
		//driver.findElement(By.cssSelector(".btn.btn-danger")).click();
		driver.findElement(By.xpath("/html/body/section/div/div/a[1]")).click();
		System.out.println("login with google clicked ");
		driver.navigate().to("http://mentorpick.com/auth/google");
		
		driver.findElement(By.id("Email")).sendKeys("priyataran@gmail.com");
		driver.findElement(By.id("next")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("Passwd")).sendKeys("");
		System.out.println("password send");
		driver.findElement(By.id("signIn")).click();
		System.out.println("signin clicked");
		driver.navigate().to("http://mentorpick.com/courses#");
		//List<WebElement> LockedClasses = driver.findElements(By.xpath("//div[contains(@class, 'glyphicon')]"));
		List<WebElement> LockedClasses = driver.findElements(By.xpath("/html/body/div[2]/div[3]/div/div/div[1]/a"));
		
		WebDriverWait lkClsBtnWt = new WebDriverWait(driver,30);
		List<WebElement> sveSuccessMsg = lkClsBtnWt.until(ExpectedConditions.
		//		presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class, 'glyphicon')]")));
				presenceOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/div[3]/div/div/div[1]/a")));
		List<WebElement> svelockMsg = driver.findElements(By.xpath("html/body/div[2]/div[3]/div/div/div[1]/div/a[2]"));
		
		System.out.println("locklinks: "+svelockMsg.size());
		System.out.println(sveSuccessMsg.size());
		System.out.println("Size of locked classes: "+ LockedClasses.size());
		
		
		List<WebElement> unlocklink = driver.findElements(By.xpath("//*[@ng-hide][@class='ng-hide']"));
		System.out.println("unlocklinks: "+unlocklink.size());
		
		for (int i=0;i<svelockMsg.size();i++)
		{
			for (int j=0;j<unlocklink.size();j++)
			{
				String lkmsg1 = svelockMsg.get(i).getAttribute("href");
				String Course = sveSuccessMsg.get(i).getText();
				//System.out.println();
				
				
				String unmsg2 = unlocklink.get(j).getAttribute("href");
				
				System.out.println("Course Name: "+ Course);
				System.out.println("lkMsg"+i+": "+ lkmsg1);
				System.out.println("unMsg"+j+": "+ unmsg2);
				
				if(lkmsg1.equals(unmsg2))
				{
					System.out.println("You have access to this reource");
					break;
				}
				else
				{
					System.out.println("You are not authorized to access this resource!");
					
				}
			
			}
			System.out.println();
		}
		driver.quit();
		}
	
}

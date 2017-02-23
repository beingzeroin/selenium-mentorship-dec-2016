package in.beingzero.framework.POM.Priya;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MentorPickDashBoardPage extends MentorPickSetup{

	public MentorPickDashBoardPage()
	{
		super();
	}
	public MentorPickDashBoardPage(WebDriver driver)
	{
		super(driver);
	}
	
	public  MentorPickCodeExer VerifyLockUnlockCourse(){
	
		WebDriverWait wait = new WebDriverWait(driver,30);
		List<WebElement> CoursesList = driver.findElements(By.xpath(objConfig.getProperty("CourseList")));
		
		List<WebElement>  CoursesListW = wait.until(ExpectedConditions.
								presenceOfAllElementsLocatedBy(By.xpath(objConfig.getProperty("CourseList"))));
		
		List<WebElement> CLRegV = driver.findElements(By.xpath(objConfig.getProperty("CLwithReg")));
		
		System.out.println("CoursesList without wait implemented: "+ CoursesList.size());
		System.out.println("Cousrses List with wait implemented : "+ CoursesListW.size());
				
		List<WebElement> unlockCourse = driver.findElements(By.xpath(objConfig.getProperty("UnLkCourse")));
		System.out.println("Unlocked Courses: "+unlockCourse.size());
		
		for (int i=0;i<CLRegV.size();i++)
		{
			for (int j=0;j<unlockCourse.size();j++)
			{
				String lkmsg1 = CLRegV.get(i).getAttribute("href");
				String Course = CoursesListW.get(i).getText();
				String unmsg2 = unlockCourse.get(j).getAttribute("href");
				
				if(lkmsg1.equals(unmsg2))
				{
					System.out.println("Course Name: "+ Course);
					System.out.println("lkMsg"+i+": "+ lkmsg1);
					System.out.println("unMsg"+j+": "+ unmsg2);
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

		return new MentorPickCodeExer(driver);
	}

}

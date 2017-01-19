package in.beingzero.priya;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Week3TcJobTitleSelection {

	public static void main(String[] args) {
		
				//WebDriver driver = new FirefoxDriver();
				//TODO:  PRIYA Portability Issue.  Refer other TODOs for this.
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
				
				
				WebElement Jobtitle = driver.findElement(By.id("searchDirectory_job_title"));
				Select seljobtitle = new Select(Jobtitle);
				seljobtitle.selectByIndex(4);
				String selectedjobtitle = seljobtitle.getFirstSelectedOption().getText();
				
				System.out.println("Selected Job Title : " + selectedjobtitle);
				
				WebElement searchbtn = driver.findElement(By.id("searchBtn"));
				searchbtn.click();
				
				WebElement searchrslt = driver.findElement(By.id("searchResults"));
				List<WebElement> res_rows = searchrslt.findElements(By.tagName("tr"));
				
				int no_of_rows = res_rows.size();
				System.out.println("No of rows : "+ no_of_rows);
				
				int getlitxt = 2;
				
				for(int row = 1; row<no_of_rows ; row++)
				{
					List<WebElement> col_rows = res_rows.get(row).findElements(By.tagName("td"));
					WebElement jobtitletxt = driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr["+getlitxt+"]/td[2]/ul/li[2]"));
					String celtxt = jobtitletxt.getText();
					System.out.println("Job Title : " + celtxt);
					Assert.assertEquals(selectedjobtitle, celtxt);
					System.out.println("Selected and displayed job title are same");
					getlitxt = getlitxt + 1;
					
				}
				driver.quit();

	}

}

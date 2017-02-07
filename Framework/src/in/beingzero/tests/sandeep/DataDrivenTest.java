package in.beingzero.tests.sandeep;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest {

	@Test(dataProvider = "exDataProvider")
	public void loginTest(String userName, String pwd, boolean shouldSucceed)
	{
		System.out.printf("un: %s, pwd: %s, re: %b\n", userName, pwd, shouldSucceed);
	}
	
	@DataProvider
	public Object[][] exDataProvider()
	{
		Object[][] data = new Object[10][3];
		 
		// 2darray.length is ROWS
		for(int i=0;i<data.length;i++)
		{
			// for(int j=0;j<data[i].length;j++)
			data[i][0] = "admin"+i;
			data[i][1] = "admin"+i;
			if(i%2==0)
				data[i][2] = true;
			else
				data[i][2] = false;
		}
		
		return data;
	}
	
	
}

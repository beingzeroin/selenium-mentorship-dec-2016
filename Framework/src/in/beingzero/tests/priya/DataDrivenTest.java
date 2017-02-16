package in.beingzero.tests.priya;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest {
	
	@Test(dataProvider = "exDataProvider")
	public void loginTest(String UName, String Pwd, boolean Shouldsucceed)
	{
		System.out.printf("un: %s, pwd: %s, re: %b\n", UName, Pwd, Shouldsucceed);
	}

	@DataProvider
	public Object[][] exDataProvider()
	{
		Object[][] data = new Object[2][3];
		
		data[0][0] = "admin";
		data[0][1] = "admin";
		data[0][2] = true;
		data[1][0] = "aadmin";
		data[1][1] = "aadmin";
		data[1][2] = false;
		return data;
		
	}
}

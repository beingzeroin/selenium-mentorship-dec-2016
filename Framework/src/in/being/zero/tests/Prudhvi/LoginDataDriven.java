package in.being.zero.tests.Prudhvi;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import in.beingzero.framework.data.sandeep.DataManager;
import in.beingzero.framework.data.sandeep.ExcelDataManager;

public class LoginDataDriven {

	@Test(dataProvider="dp")
	public void loginTest(String un, String pw, boolean exp)
	{
		System.out.printf("%s %s %b\n", un, pw, exp);
	}
	
	@DataProvider
	public Object[][] dp()
	{
		DataManager dm = new ExcelDataManager("testdata/OrangeHRM-TestData.xlsx", "AuthTests", "RightLoginTestData");
		return dm.getData();
	}

	
}

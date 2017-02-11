package in.beingzero.tests.sandeep;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import in.beingzero.framework.data.sandeep.DataManager;
import in.beingzero.framework.data.sandeep.ExcelDataManager;

public class LoginWithMultipleData {

	@Test(dataProvider = "loginTestData", enabled=false)
	public void loginTest(String userName, String password, boolean shouldSucceed) {

		System.out.println("USERNAME : " + userName + " PASSWORD: " + password + " EXPECTED OUTCOME: " + shouldSucceed);

		// %d for int, %f for float or double, %c - char
		// PRINT FORMATTED
		System.out.printf("USERNAME : %s, PASSWORD: %s, EXPECTED OUTCOME %b\n", userName, password, shouldSucceed);

		if (shouldSucceed == true) {
			// Verify that we are on dashboard page
			System.out.println("ASSERT THAT WE ARE ON DASHBOARD");
		} else {
			// Verify that we are on login page itself
			System.out.println("ASSERT THAT WE ARE ON LOGIN PAGE");
			// Assert.assertTrue(driver.getTitle().equals("LOGIN"));// If
			// assertion condition is false, This will be marked as failure
			//Assert.assertTrue(false);
		}

	}
	
	@Test
	public void addMultipleEmployees()
	{
		ExcelDataManager edm = new ExcelDataManager();
		
		/*
		 * ConfigWay of getting data file path
		ConfigManager cm = new ConfigManager();
		String excelPath = cm.getStringValue("TEST_DATA_EXCEL_ALTERNATE_PATH");
		Object[][] empData = edm.getExcelData(excelPath , "AuthTests", "RightLoginTestData");
		
		*/
		
		Object[][] empData = edm.getData("testdata/OrangeHRM-TestData.xlsx" , "AuthTests", "RightLoginTestData");
		
		// empData.length ---- Gives us row count
		for(int i=0;i<empData.length;i++)
		{
			//empData[0].length ---- Col count in 0th row
			//for(int j=0;j<empData[i].length;j++)
			//{
				String userName ;
				
				if(empData[i][0]==null)
					userName = "";
				else 
					userName= empData[i][0].toString();
				
				String password ;
				if(empData[i][1]==null)
					password = "";
				else 
					password = empData[i][1].toString();
				
				boolean result = Boolean.parseBoolean(empData[i][2].toString());
				
				System.out.printf("UN: %s, PW: %s, EX: %b\n", userName, password, result);
			//}
		}
		
	}

	@DataProvider
	public Object[][] loginTestData() {
		Object[][] tableToReturn;
		
		DataManager edm = new ExcelDataManager();
		
		//  edm.getExcelData("C:/orangeHRM/testdata/OrangeHRM-TestData.xlsx", "AuthTests", "RightLoginTestData");
		//  edm.getExcelData("C:\\orangeHRM\\testdata\\OrangeHRM-TestData.xlsx", "AuthTests", "RightLoginTestData");
		tableToReturn = edm.getData("testdata/OrangeHRM-TestData.xlsx" , "AuthTests", "RightLoginTestData");
		
		// A new overload in case excel has only one sheet
		// tableToReturn = edm.getExcelData("filePath" , "tableName");
		
		
		// TODO:  Somebody should fill in tableToRun from excel Sheet
		
		return tableToReturn;
		
	}
}

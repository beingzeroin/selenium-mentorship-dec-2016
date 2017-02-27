package in.beingzero.framework.data.priya;

import org.testng.annotations.DataProvider;

public class AddEmpMulDataExcel {
	

	@DataProvider
	public static Object[][] loginTestData() {
		Object[][] tableToReturn;
		String FirstName ;
		String MiddleName ;
		String LastName ;
		
		IExcelDataManager edm = new AddMultEmpExcel("testdata/OHRMTestData-Priya.xlsx", "OHRM-New-Emp-Data", "NewEmpData");
		return edm.getData();
		
		// A new overload in case excel has only one sheet
		//tableToReturn = edm.getExcelData("filePath" , "tableName");
		
		// tableToReturn.length ---- Gives us row count
		/*
		for(int i=0;i<tableToReturn.length;i++)
		{
			//tableToReturn[0].length ---- Col count in 0th row
			//for(int j=0;j<tableToReturn[i].length;j++)
			//{
				
				if(tableToReturn[i][0]==null)
					FirstName = "";
				else 
					FirstName= tableToReturn[i][0].toString();
				
				if(tableToReturn[i][1]==null)
					MiddleName = "";
				else 
					MiddleName = tableToReturn[i][1].toString();
				
				if(tableToReturn[i][1]==null)
					LastName = "";
				else 
					LastName = tableToReturn[i][1].toString();
		}
		*/
		
	}

	/*@Test
	public void addMultipleEmployees()
	{
		ExcelDataManager edm = new ExcelDataManager("testdata/OrangeHRM-TestData.xlsx", "AuthTests", "RightLoginTestData");
		
		/*
		 * ConfigWay of getting data file path
		ConfigManager cm = new ConfigManager();
		String excelPath = cm.getStringValue("TEST_DATA_EXCEL_ALTERNATE_PATH");
		Object[][] empData = edm.getExcelData(excelPath , "AuthTests", "RightLoginTestData");
		
		
		
		Object[][] empData = edm.getData();
		
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
		
	}*/

	
}

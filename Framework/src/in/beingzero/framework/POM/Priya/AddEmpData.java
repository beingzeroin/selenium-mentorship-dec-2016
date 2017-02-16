package in.beingzero.framework.POM.Priya;

import org.testng.annotations.DataProvider;

public class AddEmpData {


	@DataProvider(name="addempdata")
	public static Object[][] objData()
	{
		Object[][] data = new Object[10][3];
			
		data[0][0]="Test1F";data[0][1]="Test1M";data[0][2]="Test1L";
		data[1][0]="Test2F";data[1][1]="Test2M";data[1][2]="Test2L";
		data[2][0]="Test3F";data[2][1]="Test3M";data[2][2]="Test3L";
		data[3][0]="Test4F";data[3][1]="Test4M";data[3][2]="Test4L";
		data[4][0]="Test5F";data[4][1]="Test5M";data[4][2]="Test5L";
		data[5][0]="Test6F";data[5][1]="Test6M";data[5][2]="Test6L";
		data[6][0]="Test7F";data[6][1]="Test7M";data[6][2]="Test7L";
		data[7][0]="Test8F";data[7][1]="Test8M";data[7][2]="Test8L";
		data[8][0]="Test9F";data[8][1]="Test9M";data[8][2]="Test9L";
		data[9][0]="Test10F";data[9][1]="Test10M";data[9][2]="Test10L";
		
		return data;
		
	}
}

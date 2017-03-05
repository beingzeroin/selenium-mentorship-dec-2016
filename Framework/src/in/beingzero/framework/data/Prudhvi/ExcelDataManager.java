package in.beingzero.framework.data.Prudhvi;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataManager implements IDataManager 

{
	//./src/in/beingzero/framework/Data/Prudhvi/Data.xlsx'
	String strExcelSheetPath="D://Data.xlsx";
	private XSSFWorkbook objWb;
	
	//File objExcelWorkbook=new File(strExcelSheetPath);
	public static void main(String[] args) throws Exception
	{
		//ExcelDataManager obj=new ExcelDataManager();
				//obj.getData();
		String strExcelSheetPath="D://Data.xlsx";
		FileInputStream objInputStream=new FileInputStream(strExcelSheetPath);
		
		XSSFWorkbook objWB=new XSSFWorkbook(objInputStream);
		XSSFSheet objWs=objWB.getSheet("Sheet1");
		try
		{
		System.out.println(objWs.getPhysicalNumberOfRows());
		}
		finally
		{
			objWB.close();
		}
	}
	
	

	public void getData() throws Exception
	{
	
	FileInputStream objInputStream=new FileInputStream(new File(strExcelSheetPath));
	
	objWb = new XSSFWorkbook(objInputStream);
	XSSFSheet objWs=objWb.getSheet("Sheet1");
	
	System.out.println(objWs.getPhysicalNumberOfRows());
	}
	

}

package in.beingzero.framework.data.sandeep;

public class ExcelHelperTest {

	public static void main(String[] args) throws Exception {
		ExcelHelper eh = new ExcelHelper("testdata\\TestData.xlsx");
		
		
		System.out.println(eh.getRowCount("TestCaseData"));
		System.out.println(eh.getColumnCount("TestCaseData", 1));
		System.out.println(eh.getCellData("TestCaseData", 5, 2));
		System.out.println(eh.getCellData("TestCaseData", "IsValid", 3));
		System.out.println(eh.setCellData("TestCaseData", 3, 20, "IsValid"));
		System.out.println(eh.setCellData("TestCaseData", "Password", 22, "guru"));
		
		if(eh.sheetExists("Results"))
			eh.removeSheet("Results");
		
		eh.addSheet("Results");
		eh.addColumn("Results", "TCName");
		eh.addColumn("Results", "TCResult");
		eh.addColumn("Results", "TCCategory");
		
		
		eh.setCellData("Results", "TCName", 2, "LoginTest");
		
		eh.setCellData("Results", "TCResult", 2, "pass");
		eh.setCellData("Results", "TCCategory", 2, "Functional");
		
	}
}

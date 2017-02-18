package in.beingzero.framework.data.priya;

import java.io.File;

import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AddMultEmpExcel implements IExcelDataManager{

	String fp, ws, tbnm;
	public AddMultEmpExcel(String filePath, String worksheetName, String tbName)
	{
		fp=filePath;
		ws=worksheetName;
		tbnm=tbName;
	}
	
	public Object[][] getData(String filePath, String worksheetName, String tbName, boolean hasHeader)
	{
		XSSFWorkbook workbook = null;
		XSSFSheet sheet = null;
		try {
			workbook = new XSSFWorkbook(new File(filePath));
			sheet = workbook.getSheet(worksheetName);
			List<XSSFTable> tables = sheet.getTables();

			for (XSSFTable t : tables) {
				if (t.getDisplayName().equals(tbName) || t.getName().equals(tbName)) {

					Object[][] data = null;			

					// ZERO BASED INDEX 
					int startRow = t.getStartCellReference().getRow();
					int endRow = t.getEndCellReference().getRow();

					int startColumn = t.getStartCellReference().getCol();
					int endColumn = t.getEndCellReference().getCol();
					
					int rows = endRow -	startRow + 1;
					int cols = endColumn - startColumn + 1;
					
					// In case this is true
					if(hasHeader){
						rows--;
						startRow++;
					}
					
					data = new Object[rows][cols];

					System.out.println("rowCount = " + t.getRowCount());
					System.out.println("colCount = " + t.getNumerOfMappedColumns());
					System.out.println("startRow = " + startRow);
					System.out.println("endRow = " + endRow);
					System.out.println("startColumn = " + startColumn);
					System.out.println("endColumn = " + endColumn);
											

					for (int i = startRow, r = 0; i <= endRow; i++, r++) {
						for (int j = startColumn, c = 0; j <= endColumn; j++, c++) {
							XSSFCell cell = sheet.getRow(i).getCell(j);
							if (cell != null) {
								switch (cell.getCellType()) {
								case Cell.CELL_TYPE_STRING:
									data[r][c] = cell.getStringCellValue();
									break;
								case Cell.CELL_TYPE_NUMERIC:
								case Cell.CELL_TYPE_FORMULA:
									data[r][c] = cell.getNumericCellValue();
									break;
								case Cell.CELL_TYPE_BLANK:
									data[r][c] = "";
									break;
								case Cell.CELL_TYPE_BOOLEAN:
									data[r][c] = cell.getBooleanCellValue();
									break;
								}
							}
							System.out.print(data[r][c] + "\t");
						}
						System.out.println();
					}
					return data;
				}
			}

		} catch (Exception ex) {
			System.out.println("ERROR HAPPENED " + ex.getMessage());
			ex.printStackTrace();
			return null;
		} finally {
			if (workbook != null) {
				try {
					workbook.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	public Object[][] getData(String filePath, String sheetName, String tableName) {
		
		return getData(filePath, sheetName, tableName, true);
		
	}
	
	public Object[][] getData(String filePath, String tableName) {
		XSSFWorkbook workbook = null;
		XSSFSheet sheet = null;
	
			try {
				workbook = new XSSFWorkbook(new File(filePath));
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sheet = workbook.getSheetAt(0);
			
		return getData(filePath, sheet.getSheetName(), tableName, true);
	}


	@Override
	public Object[][] getData() {
		return getData(fp,ws,tbnm);
	}

}

package in.beingzero.framework.data.sandeep;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelHelper {

	private Workbook wbk;
	private Sheet sheet;
	private String filePath;

	public ExcelHelper(String filePath) throws Exception {
		this.filePath = filePath;
		wbk = WorkbookFactory.create(new FileInputStream(filePath));
		sheet = wbk.getSheetAt(0);
	}

	public int getRowCount(String sheetName) {
		sheet = wbk.getSheet(sheetName);	
		return sheet.getPhysicalNumberOfRows();
	}

	public int getColumnCount(String sheetName, int rowNumber) {
		sheet = wbk.getSheet(sheetName);
		Row row = sheet.getRow(rowNumber);
		if (row == null)
			return 0;
		return row.getPhysicalNumberOfCells();
	}

	private int getColumnNumber(String sheetName, String colName) {
		return getColumnNumber(sheetName, colName, 0);
	}

	private int getColumnNumber(String sheetName, String colName, int startRowIdx) {
		int colNumber = -1;
		int colIdx = 0;
		int rowIdx = 0;
		Sheet sheet = wbk.getSheet(sheetName);
		Row r = null;
		for (rowIdx = startRowIdx; rowIdx <= sheet.getLastRowNum(); rowIdx++) {
			r = sheet.getRow(rowIdx);
			if (r != null) {
				for (Cell c : r) {
					colIdx = 1 + c.getColumnIndex();
					if (c != null && getCellData(
							sheetName, colIdx, rowIdx+1).trim().equalsIgnoreCase(colName)) {
						colNumber = c.getColumnIndex() + 1;
						break;
					}
				}
			}
		}
		if(colNumber==-1)
			throw new RuntimeException(String.format("No Col with name '%s'", colName));
		return colNumber;
	}

	public String getCellData(String sheetName, String colName, int rowNumber) {
		int colNumber = getColumnNumber(sheetName, colName);
		return getCellData(sheetName, colNumber, rowNumber);
	}

	@SuppressWarnings("deprecation")
	public String getCellData(String sheetName, int colNumber, int rowNumber) {
		Row r = wbk.getSheet(sheetName).getRow(rowNumber - 1);
		if (r == null)
			return "";

		Cell cell = r.getCell(colNumber - 1);
		if (cell == null)
			return "";

		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();
		case Cell.CELL_TYPE_NUMERIC:
		case Cell.CELL_TYPE_FORMULA:
			String cellText = String.valueOf(cell.getNumericCellValue());
			if (DateUtil.isCellDateFormatted(cell)) {
				// format in form of M/D/YY
				double d = cell.getNumericCellValue();

				Calendar cal = Calendar.getInstance();
				cal.setTime(DateUtil.getJavaDate(d));
				cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
				cellText = cal.get(Calendar.MONTH) + 1 + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cellText;
			}
			return cellText;
		case Cell.CELL_TYPE_BLANK:
			return "";
		case Cell.CELL_TYPE_BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		}

		return "";
	}
	
	public boolean setCellData(String sheetName, String colName, int rowNumber, String data) throws Exception
	{
		int colNumber = getColumnNumber(sheetName, colName);
		return setCellData(sheetName, colNumber, rowNumber, data);
	}
	
	public boolean setCellData(String sheetName, int colNumber, int rowNumber, String data) throws Exception
	{
		Sheet sheet = wbk.getSheet(sheetName);
		Row r = sheet.getRow(rowNumber-1);
		if(r==null)
			r = sheet.createRow(rowNumber-1);

		Cell c = r.getCell(colNumber-1);
		if(c==null)
			c = r.createCell(colNumber-1);
		
		c.setCellValue(data);
		sheet.autoSizeColumn(colNumber-1);
		
		save();
		return true;
	}

	private void save() throws Exception {
		wbk.write(new FileOutputStream(filePath));
		wbk = WorkbookFactory.create(new FileInputStream(filePath));
	}
	
	public void addSheet(String  sheetname) throws Exception{		
		wbk.createSheet(sheetname);	
		save();
	}
	
	public boolean removeSheet(String sheetName) throws Exception{		
		int index = wbk.getSheetIndex(sheetName);
		if(index==-1)
			return false;

		wbk.removeSheetAt(index);
		save();
		return true;
	}
	
	public void addColumn(String sheetName, String colName) throws Exception
	{
		sheet = wbk.getSheet(sheetName);
		Row r = sheet.getRow(0);
		if(r==null)
			r = sheet.createRow(0);
		
		Cell c = null;
		if(r.getLastCellNum()==-1)
			c = r.createCell(0);
		else
			c = r.createCell(r.getLastCellNum());
		
		c.setCellValue(colName);
		save();
	}
	
	public boolean sheetExists(String sheetName){
		return (wbk.getSheetIndex(sheetName)!=-1);
	}
	
	public void removeColumn(String sheetName, int colNum) throws Exception {
	
		Row r;
		Cell c;
		for(int i =0;i<getRowCount(sheetName);i++){
			r=sheet.getRow(i);	
			if(r!=null){
				c=r.getCell(colNum);
				if(c!=null){
					r.removeCell(c);
					break;
				}
			}
		}
		save();
	}
}

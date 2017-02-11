package in.beingzero.framework.data.sandeep;

public interface DataManager {

	public abstract Object[][] getData(String filePath, String sheetName, String tableName);
	public abstract Object[][] getData(String filePath, String tableName);
	
}

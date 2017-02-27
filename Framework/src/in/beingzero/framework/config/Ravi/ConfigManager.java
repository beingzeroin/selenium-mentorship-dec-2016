package in.beingzero.framework.config.Ravi;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigManager implements IConfigManager {
	String str;
	Properties objProperties;
	public ConfigManager()
	{
		try
		{
			File objFile=new File("./src/in/beingzero/framework/config/Ravi/frameworkConfig.txt");	
			FileInputStream objFIS  = new FileInputStream(objFile);
			objProperties=new Properties();
			objProperties.load(objFIS);		
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}


	@Override
	public boolean isPropertyExisting(String propName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getProperty(String propName) {
		// TODO Auto-generated method stub
		return objProperties.getProperty(propName);
	}

	@Override
	public int getLongProperty(String propName) {
		// TODO Auto-generated method stub
		return Integer.parseInt(objProperties.getProperty(propName));
	}

	@Override
	public boolean getBooleanProperty(String propName) {
		// TODO Auto-generated method stub
		return Boolean.parseBoolean(objProperties.getProperty(propName));
	}

	
}

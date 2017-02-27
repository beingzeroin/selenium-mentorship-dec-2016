package in.beingzero.framework.config.priya;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigMentorPick implements IConfigMentorPick{

	String str;
	Properties objProp;
	
	public ConfigMentorPick()
	{
		try
		{
			File objFile=new File("./src/in/beingzero/framework/config/priya/MentorPickConfig.txt");	
			FileInputStream objFIS  = new FileInputStream(objFile);
			objProp=new Properties();
			objProp.load(objFIS);		
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	@Override
	public boolean isPropertyExisting(String propName) {
		
		boolean boolIsPropertyExist = false;
		objProp.containsKey(propName);
		return boolIsPropertyExist;
	}

	@Override
	public String getProperty(String propName) {
		
		return objProp.getProperty(propName);
	}

	@Override
	public int getLongProperty(String propName) {
		
		return Integer.parseInt(objProp.getProperty(propName));
	}

	@Override
	public boolean getBooleanProperty(String propName) {
		
		return Boolean.parseBoolean(objProp.getProperty(propName));
	}

}

package in.beingzero.framework.config.priya;

public interface IConfigManager {

	
		public boolean isPropertyExisting(String propName);
	    public String getBrowser(String propName);
	    public int getLongProperty(String propName);
		public boolean getBooleanProperty(String propName);
	
}

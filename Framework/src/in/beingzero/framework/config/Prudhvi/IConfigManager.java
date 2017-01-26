package in.beingzero.framework.config.Prudhvi;

public interface IConfigManager
{
	public boolean isPropertyExisting(String propName);
    public String getProperty(String propName);
    public int getLongProperty(String propName);
	public boolean getBooleanProperty(String propName);
}

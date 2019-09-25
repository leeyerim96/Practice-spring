package myDispatcher;

public class ViewResolver {
	private String prefix;
	private String suffix;
	
	public void setPrefix(String prefix) {
		this.prefix=prefix;
	}
	
	public void setSuffix(String suffix) {
		this.suffix=suffix;
	}
	
	public String getView(String vName) {
		String viewName = prefix+vName+suffix;
		System.out.println("** viewName =>"+viewName);
		return viewName;
	}
}

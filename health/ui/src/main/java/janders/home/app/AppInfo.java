package janders.home.app;

/**
 * Contains meta-data about this application including details on the specific build.
 */
public class AppInfo {

	private final String revision;
	
	public AppInfo(String manifestPath) {
		revision = "";
	}

	/**
	 * @return the identifier of the version control commit that this binary was built from
	 */
	public String getBuildRevision() {
		return revision;
	}
	
}

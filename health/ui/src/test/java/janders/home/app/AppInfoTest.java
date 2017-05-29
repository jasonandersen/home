package janders.home.app;

import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

public class AppInfoTest {
	
	private AppInfo app;
	
	@Before
	public void setupAppInfo() {
		app = new AppInfo("classpath:/data/manifest/TEST-MANIFEST.MF");
	}
	
	@Test
	public void testBuildRevision() {
		Assert.assertEquals("d0c60c86219ebe6f700b3fc161606325325cc567", app.getBuildRevision());
	}

}

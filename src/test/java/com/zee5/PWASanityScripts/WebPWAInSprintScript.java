package com.zee5.PWASanityScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5PWASanityWEBBusinessLogic;
import com.business.zee.Zee5PWAWEBMixPanelBusinessLogic;

public class WebPWAInSprintScript {

	private Zee5PWASanityWEBBusinessLogic Zee5WEBPWASanityBusinessLogic;
	private Zee5PWAWEBMixPanelBusinessLogic Zee5PWAWEBMixPanelBusinessLogic;

	@BeforeTest(groups = {"required_setup"})
	public void init() throws Exception {
		// zee5WebBusinessLogic.relaunchFlag = false;
		Zee5WEBPWASanityBusinessLogic = new Zee5PWASanityWEBBusinessLogic("Chrome");
	}

	@Test(priority = 1,groups = {"required_setup"})
	@Parameters({ "userType" })
	public void PWAWEBLogin(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.ZeeWEBPWALogin(userType);
	}

	@Test(priority=2, groups = {"sprint72-73"})
	@Parameters({ "userType" })
	public void Sprint72and73_PWA2_9106(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.authenticationFunctionality1(userType);
	}
	
	@Test(priority=3, groups = {"sprint72-73"})
	@Parameters({ "userType" })
	public void Sprint72and73_PWA2_8657(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.xdefaultUrlVerification(userType);
	}
	
	@Test(priority=3, groups = {"sprint72-73"})
	@Parameters({ "userType" })
	public void Sprint72and73_PWA2_9343(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.redirectUserVerification(userType);		
	}
	
	@Test(priority=3, groups = {"sprint73"})
	@Parameters({ "userType" })
	public void Sprint72and73_PWA2_9444(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.tearDown();
		Zee5PWAWEBMixPanelBusinessLogic = new Zee5PWAWEBMixPanelBusinessLogic("Chrome");
		Zee5PWAWEBMixPanelBusinessLogic.ZeeWEBPWAMixPanelLogin(userType);	
		String[] requiredEvents= {"Video View"};
		Zee5PWAWEBMixPanelBusinessLogic.ExecuteEvent_Set1(1,userType,"Home",0,"movie",requiredEvents,5,"premium");
		
	}
	
	@AfterClass(groups = {"required_setup"})
	public void tearDown() {
		Zee5WEBPWASanityBusinessLogic.tearDown();
	}
}
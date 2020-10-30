package com.zee5.MixpanelScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5MPWAMixPanelBusinessLogic;

public class AndroidPWAMixpanelScript {
	
	private Zee5MPWAMixPanelBusinessLogic Zee5PWAMixPanelAndroidBusinessLogic;

	@BeforeTest
	public void init() throws Exception {
		Zee5PWAMixPanelAndroidBusinessLogic = new Zee5MPWAMixPanelBusinessLogic("Chrome");
	}

//	@Test(priority = 1)
	@Parameters({ "userType" })
	public void ZeePWALogin(String userType) throws Exception {
		System.out.println("Login");
		Zee5PWAMixPanelAndroidBusinessLogic.ZeePWALogin("E-mail",userType);
	}
	
	@Test(priority = 2)
	@Parameters({ "userType" })
	public void verifySkipLoginEvent(String userType) throws Exception {
		System.out.println("Verify Skip Login Event");
		Zee5PWAMixPanelAndroidBusinessLogic.verifySkipLoginEvent(userType);
	}
	
	
	
	
	@AfterClass
	public void tearDown() {
		Zee5PWAMixPanelAndroidBusinessLogic.tearDown();
	}

}

package com.zee5.WebMixpanelScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5PWAWEBMixPanelBusinessLogic;

public class ScreenViewEvent {
	private Zee5PWAWEBMixPanelBusinessLogic Zee5PWAWEBMixPanelBusinessLogic;

	@BeforeTest
	public void init() throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic = new Zee5PWAWEBMixPanelBusinessLogic("Chrome");
	}

	@Test(priority = 0)
	@Parameters({ "userType" })
	public void PWAWEBMixPanelLogin(String userType) throws Exception {
		System.out.println("Login");
		Zee5PWAWEBMixPanelBusinessLogic.ZeeWEBPWAMixPanelLogin(userType);
	}

	@Test(priority = 1)
	@Parameters({ "Tab"})
	public void verifyScreenViewEvent(String tab) throws Exception {
		System.out.println("Verify Screen View Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyScreenViewEvent(tab);
	}

	@AfterClass
	public void tearDown() {
		Zee5PWAWEBMixPanelBusinessLogic.tearDown();
	}

}

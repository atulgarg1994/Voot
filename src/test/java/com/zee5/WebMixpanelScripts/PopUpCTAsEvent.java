package com.zee5.WebMixpanelScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5PWAWEBMixPanelBusinessLogic;

public class PopUpCTAsEvent {

	private Zee5PWAWEBMixPanelBusinessLogic Zee5PWAWEBMixPanelBusinessLogic;

	@BeforeTest
	public void init() throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic = new Zee5PWAWEBMixPanelBusinessLogic("Chrome");
	}
	
	@Test(priority = 1)
	@Parameters({ "userType", "keyword6" })
	public void verifyPopUpCTAsEvent(String userType, String keyword6) throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		System.out.println("Verify Pop Up CTA's Event when user clicks on CTA button displayed on the popup");
		Zee5PWAWEBMixPanelBusinessLogic.verifyPopUpCTAsEvent(userType, keyword6);
	}
	
	@AfterClass
	public void tearDown() {
		Zee5PWAWEBMixPanelBusinessLogic.tearDown();
	}
}

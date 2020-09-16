package com.zee5.PWAMixpanelScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.business.zee.Zee5PWAWEBMixPanelBusinessLogic;

public class WebPWAMixpanelScript {

	private Zee5PWAWEBMixPanelBusinessLogic Zee5PWAWEBMixPanelBusinessLogic;

	@BeforeTest
	public void init() throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic = new Zee5PWAWEBMixPanelBusinessLogic("Chrome");
	}
	
	@Test(priority = 1)
	@Parameters({ "userType" })
	public void PWAWEBMixPanelLogin(String userType) throws Exception {
		System.out.println("Login");
		Zee5PWAWEBMixPanelBusinessLogic.ZeeWEBPWAMixPanelLogin(userType);
	}
	
	@Test(priority = 2)
	@Parameters({ "userType" })
	public void verifySkipLoginEvent(String userType) throws Exception {
		System.out.println("Verify Skip Login Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifySkipLoginEvent(userType);
	}
	
	@Test(priority = 3)
	@Parameters({ "userType", "keyword" })
	public void verifySkipRegistrationEvent(String userType,String keyword) throws Exception {
		System.out.println("Verify Skip Registration Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifySkipRegistrationEvent(userType);
		Zee5PWAWEBMixPanelBusinessLogic.verifySkipRegistrationEventDuringContentPlayback(userType,keyword);
	}
	
	@Test(priority = 4)
	@Parameters({ "userType" })
	public void verifyLoginInitiatedEventForValidCredentials(String userType) throws Exception {
		System.out.println("Verify Login Initiated Event for Valid Credentials");
		Zee5PWAWEBMixPanelBusinessLogic.verifyLoginInitiatedEventForValidCredentials(userType);
	}
	
	
	@Test(priority = 5)
	@Parameters({ "userType" })
	public void verifyTVAuthenticationScreenDisplayEvent(String userType) throws Exception {
		System.out.println("Verify TV Authentication Screen Display Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyTVAuthenticationScreenDisplayEvent(userType);
	}
	
	@Test(priority = 6)
	@Parameters({ "userType", "keyword1", "keyword2" })
	public void verifySubscriptionPageViewedEvent(String userType,String keyword1,String keyword2) throws Exception {
		System.out.println("Verify Subscription Page Viewed Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifySubscriptionPageViewedEvent(userType,keyword1,keyword2);
	}
	
	@AfterClass
	public void tearDown() {
		Zee5PWAWEBMixPanelBusinessLogic.tearDown();
	}
}

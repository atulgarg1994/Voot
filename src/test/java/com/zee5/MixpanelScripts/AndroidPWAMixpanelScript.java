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

	@Test(priority = 1)
	@Parameters({ "userType" })
	public void ZeePWALogin(String userType) throws Exception {
		System.out.println("Login");
		Zee5PWAMixPanelAndroidBusinessLogic.ZeePWALogin("E-mail",userType);
	}
	
	@Test(priority = 2)
	@Parameters({ "userType" })
	public void verifyLogoutEvent(String userType) throws Exception {
		System.out.println("Verify Logout Event");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyLogoutEvent(userType);
	}
	
	@Test(priority = 3)
	@Parameters({ "userType" })
	public void verifyLoginScreenDisplayEventByClickingOnLoginButton(String userType) throws Exception {
		System.out.println("Verify Login Screen Display Event By Clicking On Login Button");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyLoginScreenDisplayEventByClickingOnLoginButton(userType);
	}
	
	@Test(priority = 4)
	@Parameters({ "userType", "keyword2" })
	public void verifyLoginScreenDisplayEventByClickingOnLoginButtonOnPlayer(String userType, String keyword2) throws Exception {
		System.out.println("Verify Login Screen Display Event By Clicking On Login Button On Player");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyLoginScreenDisplayEventByClickingOnLoginButtonOnPlayer(userType, keyword2);
	}
	
	@Test(priority = 5)
	@Parameters({ "userType"})
	public void verifyLoginScreenDisplayEventByClickingOnLoginButtonInRegistartionScreen(String userType) throws Exception {
		System.out.println("Verify Login Screen Display Event By Clicking On Login Button In Registartion Screen");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyLoginScreenDisplayEventByClickingOnLoginButtonInRegistartionScreen(userType);
	}
	
	@Test(priority = 6)
	@Parameters({ "userType", "keyword" })
	public void verifyLoginScreenDisplayEventByClickingOnLoginInRegistrationPopUp(String userType, String keyword) throws Exception {
		System.out.println("Verify Login Screen Display Event during content playback post clicking on login in registration popup");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyLoginScreenDisplayEventByClickingOnLoginInRegistrationPopUp(userType,keyword);
	}
	
	@Test(priority = 7)
	@Parameters({ "userType", "keyword2" })
	public void verifyLoginScreenDisplayEventByClickingOnLoginButtonInGetPremiumPopUp(String userType, String keyword2) throws Exception {
		System.out.println("Verify Login Screen Display Event By Clicking On Login Button In Get Premium Pop Up");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyLoginScreenDisplayEventByClickingOnLoginButtonInGetPremiumPopUp(userType, keyword2);
	}
	
	@Test(priority = 8)
	@Parameters({ "userType" })
	public void verifyLoginInitiatedEventForValidCredentials(String userType) throws Exception {
		System.out.println("Verify Login Initiated Event for Valid Credentials");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyLoginInitiatedEventForValidCredentials(userType,"fbLogin");
	}

	@Test(priority = 9)
	@Parameters({ "userType"})
	public void verifyLoginInitiatedEventForInvalidCredentials(String userType) throws Exception {
		System.out.println("Verify Login Initiated Event post entering invalid credentials");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyLoginInitiatedEventForInvalidCredentials(userType,"emailLogin");
	}
	
	@Test(priority = 10)
	@Parameters({ "userType" })
	public void verifyLoginResultEventForValidCredentials(String userType) throws Exception {
		System.out.println("Verify Login Result Event for Valid Credentials");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyLoginResultEventForValidCredentials(userType,"fbLogin");
	}
	
	@Test(priority = 11)
	@Parameters({ "userType"})
	public void verifyLoginResultEventForInvalidCredentials(String userType) throws Exception {
		System.out.println("Verify Login Result Event post entering invalid credentials");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyLoginResultEventForInvalidCredentials(userType,"mobileNumberLogin");
	}
	
	@Test(priority = 12)
	@Parameters({ "userType" })
	public void verifyTVAuthenticationScreenDisplayEvent(String userType) throws Exception {
		System.out.println("Verify TV Authentication Screen Display Event");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyTVAuthenticationScreenDisplayEvent(userType);
	}
	
	@AfterClass
	public void tearDown() {
		Zee5PWAMixPanelAndroidBusinessLogic.tearDown();
	}

}

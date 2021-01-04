package com.zee5.MixpanelScripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5ApplicasterMixPanelBusinessLogic;
import com.utility.Utilities;

public class ZNAMixpanel_OnboardingSuite1 {

	private Zee5ApplicasterMixPanelBusinessLogic Zee5ApplicasterMixPanelBusinessLogic;

	@BeforeTest
	public void init() throws Exception {
		Utilities.relaunch = true;
		Zee5ApplicasterMixPanelBusinessLogic = new Zee5ApplicasterMixPanelBusinessLogic("zee");
	}

//	@Test(priority = 1)
	@Parameters({ "userType" })
	public void ZNAMixPanelLogin(String userType) throws Exception {
		System.out.println("Login");
		Zee5ApplicasterMixPanelBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		Zee5ApplicasterMixPanelBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		Zee5ApplicasterMixPanelBusinessLogic.ZeeApplicasterLogin(userType);
	}

	/*
	 * Skip Login Event
	 */

	@Test(priority = 1)
	@Parameters({ "userType" })
	public void verifySkipLoginEventBrowseForFreeScreen(String userType) throws Exception {
		System.out.println("Skip Login Event when user navigated from Browse for Free CTA");
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifySkipLoginEventBrowseForFreeScreen(userType);
	}

//	@Test(priority = 2)
	@Parameters({ "userType" })
	public void verifySkipLoginEventFromLoginCTA(String userType) throws Exception {
		System.out.println("Skip Login Event when user navigated from Login CTA");
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifySkipLoginEventFromLoginCTA();
	}

	@Test(priority = 3)
	@Parameters({ "userType" })
	public void verifySkipLoginEventFromHamburgerMenu(String userType) throws Exception {
		System.out.println("Verify Skip Login Event from Hamburger menu");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifySkipLoginEventFromHamburgerMenu(userType);
	}

	@Test(priority = 4)
	@Parameters({ "userType", "keyword2" })
	public void verifySkipLogin_LoginInGetPremiumPopUp(String userType, String keyword2) throws Exception {
		System.out.println("Verify Skip Login Event from Get Ptremium Popup");
			Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
			Zee5ApplicasterMixPanelBusinessLogic.verifySkipLogin_LoginInGetPremiumPopUp(userType, keyword2);

	}

//	@Test(priority = 5)
	@Parameters({ "userType" })
	public void verifySkipLoginEvent(String userType) throws Exception {
		System.out.println("Verify Skip Login Event");
		Zee5ApplicasterMixPanelBusinessLogic.verifySkipLoginEventFromHamburgerMenu(userType);
	}

	/*
	 * Logout Event
	 */

//  @Test(priority = 6)
	@Parameters({ "userType" })
	public void verifyLogoutEvent(String userType) throws Exception {
		System.out.println("Verify Logout Event");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyLogoutEvent(userType);
	}

	/*
	 * Login Screen Display event
	 */

	@Test(priority = 7)
	@Parameters({ "userType" })
	public void verifyLoginScreenDisplayEventThroughBrowseForFreeInWelcomeScreen(String userType) throws Exception {
		System.out.println("Verify Login Screen Display Event By Clicking On Browse for free button in welcome screen");
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyLoginScreenDisplayEventThroughBrowseForScreen(userType);
	}

//	@Test(priority = 8)
	@Parameters({ "userType" })
	public void verifyLoginScreenDisplayEventThroughLoginLinkInWelcomeScreen(String userType) throws Exception {
		System.out.println("Verify Login Screen Display Event By Clicking On Login link in welcome screen");
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyLoginScreenDisplayEventThroughLoginLink(userType);
	}

	@Test(priority = 9)
	@Parameters({ "userType" })
	public void verifyLoginScreenDisplayEventThroughMoreMenu(String userType) throws Exception {
		System.out.println("Verify Login Screen Display Event through MoreMenu");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyLoginScreenDisplayEventThroughMoreMenu(userType);
	}

	@Test(priority = 10)
	@Parameters({ "userType", "keyword2" })
	public void verifyLoginScreenDisplayEventByClickingOnLoginButtonInGetPremiumPopUp(String userType, String keyword2)
			throws Exception {
		System.out.println("Verify Login Screen Display Event By Clicking On Login Button In Get Premium Pop Up");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic
				.verifyLoginScreenDisplayEventByClickingOnLoginButtonInGetPremiumPopUp(userType, keyword2);
	}

	/*
	 * Navigation : Get Premium CTA Event : Login Initiated
	 */

	@Test(priority = 11)
	@Parameters({ "userType" })
	public void verifyLoginIntiatedEventGPlusUserFromGetPremiumCTA(String userType) throws Exception {
			Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
			Zee5ApplicasterMixPanelBusinessLogic.verifyLoginIntiatedEventGPlusUserFromGetPremiumCTA();
	}

	@Test(priority = 12)
	@Parameters({ "userType" })
	public void verifyLoginIntiatedEventFBUserFromGetPremiumCTA(String userType) throws Exception {
			Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
			Zee5ApplicasterMixPanelBusinessLogic.verifyLoginIntiatedEventFBUserFromGetPremiumCTA();
		
	}

	@Test(priority = 13)
	@Parameters({ "userType" })
	public void verifyLoginIntiatedEventTwitterUserFromGetPremiumCTA(String userType) throws Exception {
			Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
			Zee5ApplicasterMixPanelBusinessLogic.verifyLoginIntiatedEventTwitterUserFromGetPremiumCTA();
	
	}

	@Test(priority = 14)
	@Parameters({ "userType" })
	public void verifyLoginIntiatedEventMobileOTPFromGetPremiumCTA(String userType) throws Exception {
			Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
			Zee5ApplicasterMixPanelBusinessLogic.verifyLoginIntiatedEventMobileOTPFromGetPremiumCTA();
		
	}

	@Test(priority = 15)
	@Parameters({ "userType" })
	public void verifyLoginIntiatedEventNonSubUserGetPremiumCTA(String userType) throws Exception {
			Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
			Zee5ApplicasterMixPanelBusinessLogic.verifyLoginIntiatedEventNonSubUserGetPremiumCTA();
	}

	@Test(priority = 16)
	@Parameters({ "userType" })
	public void verifyLoginIntiatedEventSubUserFromGetPremiumCTA(String userType) throws Exception {
			Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
			Zee5ApplicasterMixPanelBusinessLogic.verifyLoginIntiatedEventSubUserFromGetPremiumCTA();
		
	}

	@Test(priority = 17)
	@Parameters({ "userType" })
	public void verifyLoginInitiatedEventForInvalidDataEmailGetPremiumCTA(String userType) throws Exception {
			Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
			Zee5ApplicasterMixPanelBusinessLogic.verifyLoginInitiatedEventForInvalidDataEmailGetPremiumCTA();
		
	}

	@Test(priority = 18)
	@Parameters({ "userType" })
	public void verifyLoginInitiatedEventForInvalidDataMobileGetPremiumCTA(String userType) throws Exception {
			Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
			Zee5ApplicasterMixPanelBusinessLogic.verifyLoginInitiatedEventForInvalidDataMobileGetPremiumCTA();
	}

	/*
	 * Navigation : Login CTA Event : Login Initiated
	 */

//	@Test(priority = 19)
	@Parameters({ "userType" })
	public void verifyLoginIntiatedEventGPlusUserFromLoginCTA(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyLoginIntiatedEventGPlusUserFromLoginCTA();

	}

//	@Test(priority = 20)
	@Parameters({ "userType" })
	public void verifyLoginIntiatedEventFBUserFromLoginCTA(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyLoginIntiatedEventFBUserFromLoginCTA();

	}

//	@Test(priority = 21)
	@Parameters({ "userType" })
	public void verifyLoginIntiatedEventTwitterUserFromLoginCTA(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyLoginIntiatedEventTwitterUserFromLoginCTA();
	}

//	@Test(priority = 22)
	@Parameters({ "userType" })
	public void verifyLoginIntiatedEventMobileOTPFromLoginCTA(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyLoginIntiatedEventMobileOTPFromLoginCTA();
	}

//	@Test(priority = 23)
	@Parameters({ "userType" })
	public void verifyLoginIntiatedEventNonSubUserLoginCTA(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyLoginIntiatedEventNonSubUserLoginCTA();
	}

//	@Test(priority = 24)
	@Parameters({ "userType" })
	public void verifyLoginIntiatedEventSubUserFromLoginCTA(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyLoginIntiatedEventSubUserFromLoginCTA();

	}

//	@Test(priority = 25)
	@Parameters({ "userType" })
	public void verifyLoginInitiatedEventForInvalidDataEmailLoginCTA(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyLoginInitiatedEventForInvalidDataEmailLoginCTA();

	}

//	@Test(priority = 26)
	@Parameters({ "userType" })
	public void verifyLoginInitiatedEventForInvalidDataMobileLoginCTA(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyLoginInitiatedEventForInvalidDataMobileLoginCTA();

	}

	/*
	 * Navigation : Browse for free CTA Event : Login Initiated
	 */

	@Test(priority = 27)
	@Parameters({ "userType" })
	public void verifyLoginIntiatedEventGPlusUserFromBrowseForFreeCTA(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyLoginIntiatedEventGPlusUserFromBrowseForFreeCTA();

	}

	@Test(priority = 28)  
	@Parameters({ "userType" })
	public void verifyLoginIntiatedEventFBUserFromBrowseForFreeCTA(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyLoginIntiatedEventFBUserFromBrowseForFreeCTA();
	}

	@Test(priority = 29)  
	@Parameters({ "userType" })
	public void verifyLoginIntiatedEventTwitterUserFromBrowseForFreeCTA(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyLoginIntiatedEventTwitterUserFromBrowseForFreeCTA();
	}

	@Test(priority = 30)  
	@Parameters({ "userType" })
	public void verifyLoginIntiatedEventMobileOTPFromBrowseForFreeCTA(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyLoginIntiatedEventMobileOTPFromBrowseForFreeCTA();
	}

	@Test(priority = 31)  
	@Parameters({ "userType" })
	public void verifyLoginIntiatedEventNonSubUserBrowseForFreeCTA(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyLoginIntiatedEventNonSubUserBrowseForFreeCTA();
	}

	@Test(priority = 32)  
	@Parameters({ "userType" })
	public void verifyLoginIntiatedEventSubUserBrowseForFreeCTA(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyLoginIntiatedEventSubUserBrowseForFreeCTA();
	}

	@Test(priority = 33)  
	@Parameters({ "userType" })
	public void verifyLoginInitiatedEventForInvalidDataEmailLogin(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyLoginInitiatedEventForInvalidDataEmailLogin();
	}

	@Test(priority = 34)
	@Parameters({ "userType" })
	public void verifyLoginInitiatedEventForInvalidDataMobileLogin(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyLoginInitiatedEventForInvalidDataMobileLogin();
	}

	/*
	 * Event : Login Result Navigation : Browse for Free
	 */

	@Test(priority = 35)  
	@Parameters({ "userType" })
	public void LoginResultEventFromBrowseforFreeTwitterUser(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.LoginResultEventFromBrowseforFreeTwitterUser();
	}

	@Test(priority = 36)  
	@Parameters({ "userType" })
	public void LoginResultEventFromBrowseforFreeCTANonSubUser(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.LoginResultEventFromBrowseforFreeCTANonSubUser();
	}

	@Test(priority = 37)  
	@Parameters({ "userType" })
	public void LoginResultEventFromBrowseforFreeCTASubUser(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.LoginResultEventFromBrowseforFreeCTASubUser();
	}

	@Test(priority = 38)
	@Parameters({ "userType" })
	public void LoginResultEventFromBrowseforFreeCTAMobileLogin(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.LoginResultEventFromBrowseforFreeCTAMobileLogin();
	}

	@Test(priority = 39)
	@Parameters({ "userType" })
	public void LoginResultEventFromBrowseforFreeCTAMobileLoginInvalidData(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.LoginResultEventFromBrowseforFreeCTAMobileLoginInvalidData();
	}

	@Test(priority = 40)
	@Parameters({ "userType" })
	public void LoginResultEventFromBrowseforFreeCTAInvalidEmailID(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.LoginResultEventFromBrowseforFreeCTAInvalidEmailID();
	}

	/*
	 * Event : Login Result Navigation : Login CTA
	 */

//	@Test(priority = 41)
	@Parameters({ "userType" })
	public void LoginResultEventFromLoginCTATwitterUser(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.LoginResultEventFromLoginCTATwitterUser();
	}

//	@Test(priority = 42)
	@Parameters({ "userType" })
	public void LoginResultEventFromLoginCTANonSubUser(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.LoginResultEventFromLoginCTANonSubUser();
	}

//	@Test(priority = 43)
	@Parameters({ "userType" })
	public void LoginResultEventFromLoginCTASubUser(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.LoginResultEventFromLoginCTASubUser();
	}

//	@Test(priority = 44)
	@Parameters({ "userType" })
	public void LoginResultEventFromLoginCTAMobileLogin(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.LoginResultEventFromLoginCTAMobileLogin();
	}

//	@Test(priority = 45)
	@Parameters({ "userType" })
	public void LoginResultEventFromLoginCTAMobileLoginInvalidData(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.LoginResultEventFromLoginCTAMobileLoginInvalidData();
	}

//	@Test(priority = 46)
	@Parameters({ "userType" })
	public void LoginResultEventFromLoginCTAInvalidEmailID(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.LoginResultEventFromLoginCTAInvalidEmailID();
	}
	
	@AfterTest
	public void tearDownApp() {
		System.out.println("Quit the App");
		Zee5ApplicasterMixPanelBusinessLogic.tearDown();
	}
}
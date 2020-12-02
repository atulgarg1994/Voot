package com.zee5.MixpanelScripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5ApplicasterMixPanelBusinessLogic;
import com.utility.Utilities;

public class ZNAMixpanel_OnboardingSuite2 {

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
	 * Event : Login Result Navigation : Get Premium CTA
	 */

	@Test(priority = 2)
	@Parameters({ "userType" })
	public void LoginResultEventFromGetPremiumCTATwitterLogin(String userType) throws Exception {

		if (!userType.equalsIgnoreCase("SubscribedUser")) {
			Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
			Zee5ApplicasterMixPanelBusinessLogic.LoginResultEventFromGetPremiumCTATwitterLogin();
		}
	}

	@Test(priority = 3)
	@Parameters({ "userType" })
	public void LoginResultEventFromGetPremiumCTANonSubUser(String userType) throws Exception {

		if (!userType.equalsIgnoreCase("SubscribedUser")) {
			Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
			Zee5ApplicasterMixPanelBusinessLogic.LoginResultEventFromGetPremiumCTANonSubUser();
		}
	}

	@Test(priority = 4)
	@Parameters({ "userType" })
	public void LoginResultEventFromGetPremiumCTASubUser(String userType) throws Exception {

		if (!userType.equalsIgnoreCase("SubscribedUser")) {
			Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
			Zee5ApplicasterMixPanelBusinessLogic.LoginResultEventFromGetPremiumCTASubUser();
		}
	}

	@Test(priority = 5)
	@Parameters({ "userType" })
	public void LoginResultEventFromGetPremiumCTAMobileLogin(String userType) throws Exception {

		if (!userType.equalsIgnoreCase("SubscribedUser")) {
			Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
			Zee5ApplicasterMixPanelBusinessLogic.LoginResultEventFromGetPremiumCTAMobileLogin();
		}
	}

	@Test(priority = 6)
	@Parameters({ "userType" })
	public void LoginResultEventFromGetPremiumCTAMobileLoginInvlaidData(String userType) throws Exception {

		if (!userType.equalsIgnoreCase("SubscribedUser")) {
			Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
			Zee5ApplicasterMixPanelBusinessLogic.LoginResultEventFromGetPremiumCTAMobileLoginInvlaidData();
		}
	}

	@Test(priority = 7)
	@Parameters({ "userType" })
	public void LoginResultEventFromGetPremiumCTAEmailInvlaidData(String userType) throws Exception {

		if (!userType.equalsIgnoreCase("SubscribedUser")) {
			Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
			Zee5ApplicasterMixPanelBusinessLogic.LoginResultEventFromGetPremiumCTAEmailInvlaidData();
		}
	}

	/*
	 * Event : Register Screen Display
	 */

	@Test(priority = 8)
	@Parameters({ "userType" })
	public void verifyRegisterScreenDisplayEventFromBrowseForFreeCTAEmailIDLogin(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyRegisterScreenDisplayEventFromBrowseForFreeCTAEmailIDLogin();
	}

	@Test(priority =9)
	@Parameters({ "userType" })
	public void verifyRegisterScreenDisplayEventFromBrowseForFreeCTAMobileLogin(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyRegisterScreenDisplayEventFromBrowseForFreeCTAMobileLogin();
	}

	@Test(priority = 10)
	@Parameters({ "userType" })
	public void verifyRegisterScreenDisplayEventFromLoginCTAEmailIDLogin(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyRegisterScreenDisplayEventFromLoginCTAEmailIDLogin();
	}

	@Test(priority = 11)
	@Parameters({ "userType" })
	public void verifyRegisterScreenDisplayEventFromLoginCTAMobileLogin(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyRegisterScreenDisplayEventFromLoginCTAMobileLogin();
	}

	@Test(priority = 12)
	@Parameters({ "userType" })
	public void verifyRegisterScreenDisplayEventFromProfilePageMobileLogin(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyRegisterScreenDisplayEventFromProfilePageMobileLogin();
	}

	@Test(priority = 13)
	@Parameters({ "userType" })
	public void verifyRegisterScreenDisplayEventFromProfilePageEmailIDLogin(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyRegisterScreenDisplayEventFromProfilePageEmailIDLogin();
	}

	@Test(priority = 14)
	@Parameters({ "userType" })
	public void verifyRegisterScreenDisplayEventFromGetPremiumPageEmailIDLogin(String userType) throws Exception {
		if (!userType.equalsIgnoreCase("SubscribedUser")) {
			Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
			Zee5ApplicasterMixPanelBusinessLogic.verifyRegisterScreenDisplayEventFromGetPremiumPageEmailIDLogin();
		}
	}

	@Test(priority = 15)
	@Parameters({ "userType" })
	public void verifyRegisterScreenDisplayEventFromGetPremiumPageMobileLogin(String userType) throws Exception {
		if (!userType.equalsIgnoreCase("SubscribedUser")) {
			Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
			Zee5ApplicasterMixPanelBusinessLogic.verifyRegisterScreenDisplayEventFromGetPremiumPageEmailIDLogin();
		}
	}

	/*
	 * Event : Registration Initiated
	 */

	@Test(priority = 16)
	@Parameters({ "userType" })
	public void verifyRegistrationInitiatedEventFromBrowseForFreeCTAEmailLogin(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyRegistrationInitiatedEventFromBrowseForFreeCTAEmailLogin();
	}

	@Test(priority = 17)
	@Parameters({ "userType" })
	public void verifyRegistrationInitiatedEventFromBrowseForFreeCTAMobileLogin(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyRegistrationInitiatedEventFromBrowseForFreeCTAMobileLogin();
	}

	@Test(priority = 18)
	@Parameters({ "userType" })
	public void verifyRegistrationInitiatedEventFromLoginCTAEmailLogin(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyRegistrationInitiatedEventFromLoginCTAEmailLogin();
	}

	@Test(priority = 19)
	@Parameters({ "userType" })
	public void verifyRegistrationInitiatedEventFromLoginCTAMobileLogin(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyRegistrationInitiatedEventFromLoginCTAMobileLogin();
	}

	@Test(priority = 20)
	@Parameters({ "userType" })
	public void verifyRegistrationInitiatedEventFromGetPremiumCTAValidEmailLogin(String userType) throws Exception {
		if (!userType.equalsIgnoreCase("SuscibedUser")) {
			Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
			Zee5ApplicasterMixPanelBusinessLogic.verifyRegistrationInitiatedEventFromGetPremiumCTAValidEmailLogin();
		}
	}

	@Test(priority = 21)
	@Parameters({ "userType" })
	public void verifyRegistrtionInitiatedEventFroGetPremiumCTAMobileLoginInvalidData(String userType)
			throws Exception {
		if (!userType.equalsIgnoreCase("SuscibedUser")) {
			Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
			Zee5ApplicasterMixPanelBusinessLogic
					.verifyRegistrtionInitiatedEventFroGetPremiumCTAMobileLoginInvalidData();
		}
	}

	@Test(priority = 22)
	@Parameters({ "userType" })
	public void verifyRegistrationInitiatedEventFromHamburgerMenuValidEmailLogin(String userType) throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
			Zee5ApplicasterMixPanelBusinessLogic.verifyRegistrationInitiatedEventFromHamburgerMenuValidEmailLogin();
		}
	}

	@Test(priority = 23)
	@Parameters({ "userType" })
	public void verifyRegistrtionInitiatedEventFromHamburgerMenuMobileLoginInvalidData(String userType)
			throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
			Zee5ApplicasterMixPanelBusinessLogic
					.verifyRegistrtionInitiatedEventFromHamburgerMenuMobileLoginInvalidData();
		}
	}

	/*
	 * Event : Registration Result Navigation : Browse for Free CTA
	 */

	@Test(priority = 24)
	@Parameters({ "userType" })
	public void verifyRegistrationResultEventFromBrowseForFreeCTAValidEmailRegistration(String userType)
			throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyRegistrationResultEventFromBrowseForFreeCTAValidEmailRegistration();
	}

	@Test(priority = 25)
	@Parameters({ "userType" })
	public void verifyRegistrationResultEventFromBrowseForFreeCTAInvalidMobileDataRegistration(String userType)
			throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic
				.verifyRegistrationResultEventFromBrowseForFreeCTAInvalidMobileDataRegistration();
	}

	@Test(priority = 26)
	@Parameters({ "userType" })
	public void verifyRegistrationResultEventFromLoginCTAValidEmailRegistration(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyRegistrationResultEventFromLoginCTAValidEmailRegistration();
	}

	@Test(priority = 27)
	@Parameters({ "userType" })
	public void verifyRegistrationResultEventFromLoginCTACTAInvalidMobileDataRegistration(String userType)
			throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunchToIntroScreen(true);
		Zee5ApplicasterMixPanelBusinessLogic
				.verifyRegistrationResultEventFromLoginCTACTAInvalidMobileDataRegistration();
	}

	@Test(priority = 28)
	@Parameters({ "userType" })
	public void verifyRegistrationResultEventFromGetPremiumCTAValidEmailLogin(String userType) throws Exception {
		if (!userType.equalsIgnoreCase("SuscibedUser")) {
			Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
			Zee5ApplicasterMixPanelBusinessLogic.verifyRegistrationResultEventFromGetPremiumCTAValidEmailLogin();
		}
	}

	@Test(priority = 29)
	@Parameters({ "userType" })
	public void verifyRegistrtionResultEventFroGetPremiumCTAMobileLoginInvalidData(String userType) throws Exception {
		if (!userType.equalsIgnoreCase("SuscibedUser")) {
			Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
			Zee5ApplicasterMixPanelBusinessLogic.verifyRegistrtionResultEventFroGetPremiumCTAMobileLoginInvalidData();
		}
	}

	@Test(priority = 30)
	@Parameters({ "userType" })
	public void verifyRegistrationResultEventFromHamburgerMenuValidEmailLogin(String userType) throws Exception {
		if (!userType.equalsIgnoreCase("SuscibedUser")) {
			Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
			Zee5ApplicasterMixPanelBusinessLogic.verifyRegistrationResultEventFromHamburgerMenuValidEmailLogin();
		}
	}

	@Test(priority = 31)
	@Parameters({ "userType" })
	public void verifyRegistrtionResultEventFromHamburgerMenuMobileLoginInvalidData(String userType) throws Exception {
		if (!userType.equalsIgnoreCase("SuscibedUser")) {
			Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
			Zee5ApplicasterMixPanelBusinessLogic.verifyRegistrtionResultEventFromHamburgerMenuMobileLoginInvalidData();
		}
	}

	/*
	 * Event : Subscription Selected
	 */

	@Test(priority = 32)
	@Parameters({ "userType" })
	public void verifySubscriptionSelectedEvent(String userType) throws Exception {
		System.out.println("Verify Subscription Selected Event");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifySubscriptionSelectedEvent(userType);
	}

	@Test(priority = 33)
	@Parameters({ "userType" })
	public void verifySubscriptionSelectedEventByClubPack(String userType) throws Exception {
		System.out.println("Verify Subscription Selected Event");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifySubscriptionSelectedEventByClubPack(userType);
	}

	/*
	 * Event : Prepaid Code Result
	 */
	@Test(priority = 34)
	@Parameters({ "userType" })
	public void verifyPrepaidCodeResultEvent(String userType) throws Exception {
		if (!userType.equals("Guest")) {
			System.out.println("Verify Prepaid Code Result event");
			Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
			Zee5ApplicasterMixPanelBusinessLogic.verifyPrepaidCodeResultEvent();
		}
	}

	/*
	 * Event : Promo Code Result
	 */

	@Test(priority = 35)
	@Parameters({ "userType" })
	public void verifyPromoCodeResultEventForValid(String userType) throws Exception {
		System.out.println("Verify Promo Code Result Event For Valid code");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyPromoCodeResultEventForValid(userType);
	}

	@Test(priority = 36)
	@Parameters({ "userType" })
	public void verifyPromoCodeResultEventForInvalid(String userType) throws Exception {
		System.out.println("Verify Promo Code Result Event For Invalid code");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyPromoCodeResultEventForInvalid(userType);
	}
}

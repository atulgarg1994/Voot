package com.zee5.ApplicasterScripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5ApplicasterBusinessLogic;
import com.utility.Utilities;

public class AndroidApp_HLS {

	private Zee5ApplicasterBusinessLogic ZEE5ApplicasterBusinessLogic;

	@BeforeTest
	public void AppLaunch() throws InterruptedException {
		System.out.println("Launching Android App");
		Utilities.relaunch = true; // Clear App Data on First Launch
		ZEE5ApplicasterBusinessLogic = new Zee5ApplicasterBusinessLogic("zee");
	}

	@Test(priority = 0)
	@Parameters({ "userType" })
	public void ApplicasterLogin(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
	}
	
	@Test(priority = 1) // Kushal
	@Parameters({ "userType", "RegisteredEmail" })
	public void OnboardLoginScreenVerification(String userType, String RegisteredEmail) throws Exception {
		System.out.println("\n---Onboarding Login screen verification ---\n");
		ZEE5ApplicasterBusinessLogic.IntroScreenAndLoginScreenValidation(userType, RegisteredEmail);
	}
	
	@Test(priority = 2) // Manasa
	@Parameters({ "userType", "contentWithoutTrailer" })
	public void SubscriptionScreenValidPrepaidCodeVerificationHLS(String userType, String contentWithoutTrailer) throws Exception {
		System.out.println("\n---Verify valid Promo/prepaid code from Subscription Screen---\n");
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.subscriptionValidationHLSForValidPrepaidCode(userType);
	}

	@Test(priority = 3) 
	@Parameters({ "userType", "contentWithoutTrailer" })
	public void SubscriptionScreenInvalidPrepaidCodeVerificationHLS(String userType, String contentWithoutTrailer) throws Exception {
		System.out.println("\n----Verify invalid Promo/prepaid code from Subscription Screen ---\n");
		ZEE5ApplicasterBusinessLogic.SubscriptionValidationHLSForInvalidPrepaidCode(userType, contentWithoutTrailer);
	}
	
	@Test(priority = 4) 
	@Parameters({ "userType"})
	public void SubscriptionValidationHLSForSubUser(String userType) throws Exception {
		System.out.println("\n---Subscription screen Validation for SubscribedUser---\n");
		ZEE5ApplicasterBusinessLogic.SubscriptionValidationForSubscribedUser(userType);
	}
	
	@Test(priority = 5) // Sushma
	@Parameters({ "userType", "searchModuleKeyword", "searchKeyword10", "searchKeyword4" })
	public void HomeScreen_Search_Playback_HLS(String userType, String searchModuleKeyword, String searchKeyword10, String searchKeyword4)
			throws Exception {

		System.out.println("\n---Verify Home landing screen---\n");
		ZEE5ApplicasterBusinessLogic.home_LandingScreen(userType);

		System.out.println("\n---Verify Search ---\n");
		ZEE5ApplicasterBusinessLogic.TextSearchAndVoiceSearch(userType, searchModuleKeyword);

		System.out.println("\n---Verify Playback ---\n");
		ZEE5ApplicasterBusinessLogic.playBack(userType, searchKeyword10, searchKeyword4);

	}
	
	@Test(priority = 6) //--- Kushal
	@Parameters({"userType"})
	public void SkipButtonVerification(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.SkipToHomeLandingScreenVerification(userType);
	}
	
	@Test(priority = 7) //--- Kushal
	@Parameters({"userType"})
	public void TrendingAndRecentSearchScreen(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
		ZEE5ApplicasterBusinessLogic.RecentSearchHistoryValidation();
	}
	
	@Test(priority = 8) //--- Kushal
	@Parameters({"userType"})
	public void SkipToHomeScreen(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
		ZEE5ApplicasterBusinessLogic.HaveaCodeSubscriptionJourney(userType);
	}


	@AfterTest
	public void tearDownApp() {
		System.out.println("\nExecution Complete - Closing the App");
		ZEE5ApplicasterBusinessLogic.tearDown();
	}
}

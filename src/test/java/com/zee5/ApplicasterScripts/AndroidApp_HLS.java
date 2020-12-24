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
	public void Login(String userType) throws Exception {

		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();

	}
	
	@Test(priority = 1) // Manasa
	@Parameters({ "userType", "contentWithoutTrailer" })
	public void subscriptionValidationHLS(String userType, String contentWithoutTrailer) throws Exception {
		System.out.println("\n---Subscription Validation ---\n");
		ZEE5ApplicasterBusinessLogic.subscriptionValidationForHLS(userType, contentWithoutTrailer);
	}

	@Test(priority = 2) // Sushma
	@Parameters({ "userType", "searchModuleKeyword", "searchKeyword10", "searchKeyword4" })
	public void HLS(String userType, String searchModuleKeyword, String searchKeyword10, String searchKeyword4)
			throws Exception {

		System.out.println("\n---Verify Home landing screen---\n");
		ZEE5ApplicasterBusinessLogic.home_LandingScreen(userType);

		System.out.println("\n---Verify Search ---\n");
		ZEE5ApplicasterBusinessLogic.TextSearchAndVoiceSearch(userType, searchModuleKeyword);

		System.out.println("\n---Verify Playback ---\n");
		ZEE5ApplicasterBusinessLogic.playBack(userType, searchKeyword10, searchKeyword4);

	}

	@AfterTest
	public void tearDownApp() {
		System.out.println("\nQuit the App\n");
		ZEE5ApplicasterBusinessLogic.tearDown();
	}
}

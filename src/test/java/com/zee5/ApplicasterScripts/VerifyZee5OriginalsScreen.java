package com.zee5.ApplicasterScripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5ApplicasterBusinessLogic;

public class VerifyZee5OriginalsScreen {

	private Zee5ApplicasterBusinessLogic ZEE5ApplicasterBusinessLogic;

	@BeforeTest
	public void AppLaunch() throws InterruptedException {
		System.out.println("Launching Android App");
		// Utilities.relaunch = true; // Clear App Data on First Launch
		ZEE5ApplicasterBusinessLogic = new Zee5ApplicasterBusinessLogic("zee");
	}

	@Test(priority = 1)
	@Parameters({ "userType" }) // Manasa
	public void Login(String userType) throws Exception {
		System.out.println("\nVerify Display Language Screen and login flow for various usertypes");
//		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
//		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();;
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
	}

	@Test(priority = 2)
	@Parameters({ "userType", "tabName3" }) // Manasa
	public void zee5OriginalsLandingScreenValidation(String userType, String tabName) throws Exception {
		System.out.println("\nVerify Zee5 Originals Landing Screen");
		ZEE5ApplicasterBusinessLogic.zee5OriginalsLandingScreen(userType, tabName);

	}

	@AfterTest
	public void tearDownApp() {
		System.out.println("\nQuit the App\n");
		ZEE5ApplicasterBusinessLogic.tearDown();
	}
}

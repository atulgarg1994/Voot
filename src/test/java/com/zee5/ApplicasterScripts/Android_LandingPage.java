package com.zee5.ApplicasterScripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5ApplicasterBusinessLogic;

public class Android_LandingPage {

	private Zee5ApplicasterBusinessLogic ZEE5ApplicasterBusinessLogic;

	@BeforeTest
	public void AppLaunch() throws InterruptedException {
		System.out.println("Launching Andriod App");
//		Utilities.relaunch = true; // Clear App Data on First Launch
		ZEE5ApplicasterBusinessLogic = new Zee5ApplicasterBusinessLogic("zee");
	}
	
	@Test(priority = 0)
	@Parameters({ "userType" })
	public void Login(String userType) throws Exception {
		
//		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
//		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
	}

	@Test(priority = 1)
	@Parameters({ "userType" , "tabName"})
	public void landingScreen(String userType, String tabName) throws Exception
	{
		ZEE5ApplicasterBusinessLogic.homeLandingScreen(userType, tabName);
		ZEE5ApplicasterBusinessLogic.moviesLandingScreen(userType, tabName);
	}
	
	@Test(priority = 2)//only for Guest and NonSubscribedUser
	@Parameters({"tabName"})
	public void AdBannerVerification(String tabName) throws Exception
	{
		ZEE5ApplicasterBusinessLogic.adBannerVerify(tabName);
	}
	
	
	@Test(priority = 3)		// Manasa
	public void upcomingScreenValidation() throws Exception {
		System.out.println("\nVerify Upcoming Screen");
		ZEE5ApplicasterBusinessLogic.upcomingSectionValidation();
		ZEE5ApplicasterBusinessLogic.upcomingContentValidationWithAPIData();
	}
	
	@Test(priority = 4)	
	@Parameters({ "userType","searchKeyword" })	// Manasa
	public void parentalPinValidation(String userType,String searchKeyword) throws Exception {
		System.out.println("\nParental Pin Validation");
		ZEE5ApplicasterBusinessLogic.parentalPinValidation(userType, searchKeyword);
	}
	
	@Test(priority = 5)		// Manasa
	public void moreScreenValidation() throws Exception {
		System.out.println("\nVerify More Screen");
		ZEE5ApplicasterBusinessLogic.moreSectionValidation();
		
	}
	
	
	@AfterTest
	public void tearDownApp() {
		System.out.println("Quit the App");
		ZEE5ApplicasterBusinessLogic.tearDown();
	}
	
}

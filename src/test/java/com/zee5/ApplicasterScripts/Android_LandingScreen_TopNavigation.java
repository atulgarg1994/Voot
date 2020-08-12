package com.zee5.ApplicasterScripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5ApplicasterBusinessLogic;
import com.utility.Utilities;

public class Android_LandingScreen_TopNavigation {

	private Zee5ApplicasterBusinessLogic ZEE5ApplicasterBusinessLogic;

	@BeforeTest
	public void AppLaunch() throws InterruptedException {
		System.out.println("Launching Andriod App");
		Utilities.relaunch = true; // Clear App Data on First Launch
		ZEE5ApplicasterBusinessLogic = new Zee5ApplicasterBusinessLogic("zee");
	}

	@Test(priority = 0)
	@Parameters({ "userType" })
	public void Login(String userType) throws Exception {

		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
	}

	@Test(priority = 1) // Sushma
	@Parameters({ "userType", "tabName1"})
	public void landingScreenHome(String userType, String tabName1) throws Exception {
		System.out.println("\n---Verify Home landing screen---\n");
		ZEE5ApplicasterBusinessLogic.homeLandingScreen(userType, tabName1);
		
	}
	
	@Test(priority = 2)
	@Parameters({ "userType" }) //Bindu
	public void LandingScreenShows(String userType) throws Exception {
		System.out.println("\n---Verify Shows landing screen---\n");
		ZEE5ApplicasterBusinessLogic.verifyShowsScreen(userType);
		ZEE5ApplicasterBusinessLogic.verifyConsumptionScreenOfBeforeTVContent(userType);
		
	}
	
	@Test(priority = 3) // Sushma
	@Parameters({ "userType", "tabName2" })
	public void landingScreenMovies(String userType, String tabName2) throws Exception {
		System.out.println("\n---Verify Movies landing screen---\n");
		ZEE5ApplicasterBusinessLogic.moviesLandingScreen(userType, tabName2);
	}

	@Test(priority = 4)
	@Parameters({ "userType" }) //Vinay
	public void PremiumTabScreen(String userType) throws Exception {
		System.out.println("\n---Verify Premium landing screen---\n");
		ZEE5ApplicasterBusinessLogic.PremiumTabScreen(userType);
	}

	@Test(priority = 5)
	@Parameters({ "userType" }) //Bindu
	public void LandingScreenNews(String userType) throws Exception {
		System.out.println("\n---Verify News landing screen---\n");
		ZEE5ApplicasterBusinessLogic.verifyNewsLandingScreen(userType);
		ZEE5ApplicasterBusinessLogic.verifyTraysInNewsScreen(userType);
		ZEE5ApplicasterBusinessLogic.verifyListingCollectionScreen(userType);
	}
	
	@Test(priority = 6)
	@Parameters({ "userType" }) //Vinay
	public void KidsTabScreen(String userType) throws Exception {
		System.out.println("\n---Verify Kids landing screen---\n");
		ZEE5ApplicasterBusinessLogic.KidsTabScreen(userType);
	}

	@Test(priority = 7)
	@Parameters({ "userType" }) //Vinay
	public void MusicLandingScreen(String userType) throws Exception {
		System.out.println("\n---Verify Music landing screen---\n");
		ZEE5ApplicasterBusinessLogic.MusicLandingScreen(userType);
	}
	//@Test(priority = 8)
	@Parameters({ "userType" }) //Hitesh
	public void LandingScreenLiveTV(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.LiveTV(); // In Progress
	}

	@AfterTest
	public void tearDownApp() {
		System.out.println("Quit the App");
		ZEE5ApplicasterBusinessLogic.tearDown();
	}

}

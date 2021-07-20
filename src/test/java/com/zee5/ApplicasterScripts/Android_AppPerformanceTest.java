package com.zee5.ApplicasterScripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5ApplicasterBusinessLogic;
import com.utility.Utilities;

public class Android_AppPerformanceTest {
	
	private Zee5ApplicasterBusinessLogic ZEE5ApplicasterBusinessLogic;

	@BeforeTest
	public void AppLaunch() throws Exception {
		System.out.println("Launching Andriod App");
		Utilities.relaunch = true;	// Clear App Data on First Launch
		ZEE5ApplicasterBusinessLogic = new Zee5ApplicasterBusinessLogic("zee");
	}
		
	@Test(priority = 1)
	public void AppLaunchToHomeScreen() throws Exception {
		ZEE5ApplicasterBusinessLogic.appLaunchtoHomeScreen();
	}
	
	@Test(priority = 2)	
	public void LoginFunctionality() throws Exception {
		ZEE5ApplicasterBusinessLogic.Performance_LoginFunctionality();
	}
	
	@Test(priority = 3)	
	public void ScreenNavigation() throws Exception {
		ZEE5ApplicasterBusinessLogic.clearBackgroundApps();
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.SelectTopNavigationTab_Timer("Premium");
	}
	
	@Test(priority = 4)
	public void InitiateContentPlayback() throws Exception {
		ZEE5ApplicasterBusinessLogic.clearBackgroundApps();
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.Performance_InitiateContentPlayback();
	}
	
	@Test(priority = 5)
	public void DeeplinkToConsumptionScreen() throws Exception {
		System.out.println("\nAndriod App Consumption screen Deeplink Validation");
		ZEE5ApplicasterBusinessLogic.clearBackgroundApps();
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.deepLink_Validation("Consumption");
	}
	
	@Test(priority = 6)
	public void DeeplinkToSubscriptionScreen() throws Exception {
		System.out.println("\nAndriod App Subscription Screen Deeplink Validation");
		ZEE5ApplicasterBusinessLogic.clearBackgroundApps();
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.deepLink_Validation("SubscriptionScreen");
	}
	
	@Test(priority = 7)
	public void InitiateContentPlaybackSVODEpisode() throws Exception {
		ZEE5ApplicasterBusinessLogic.clearBackgroundApps();
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.InitiateContentPlaybackTVEPISODE();
	}
	
	@Test(priority = 8)
	public void ConsumptionScreenSVODEpisode() throws Exception {
		ZEE5ApplicasterBusinessLogic.clearBackgroundApps();
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.ConsumptionScreenforShows();
	}
		
	@Test(priority = 9)
	public void ConsumptionScreenSVODMovies() throws Exception {
		ZEE5ApplicasterBusinessLogic.clearBackgroundApps();
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.ConsumptionScreenforMovies();
	}
	
	@Test(priority = 10)
	@Parameters({ "userType" })
	public void InstallationZEE5APP(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.installZee5AppFromPlayStore();
		ZEE5ApplicasterBusinessLogic.appLaunchtoHomeScreen();
	}
	
	@AfterTest
	public void tearDownApp() {
		ZEE5ApplicasterBusinessLogic.tearDown();
	}
}

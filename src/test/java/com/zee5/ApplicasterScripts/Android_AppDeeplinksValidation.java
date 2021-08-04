package com.zee5.ApplicasterScripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5ApplicasterBusinessLogic;
import com.utility.Utilities;

public class Android_AppDeeplinksValidation {
	
	private Zee5ApplicasterBusinessLogic ZEE5ApplicasterBusinessLogic;

	@BeforeTest
	public void AppLaunch() throws Exception {
		Utilities.relaunch = true;	// Clear App Data on First Launch
		ZEE5ApplicasterBusinessLogic = new Zee5ApplicasterBusinessLogic("zee");
	}
	
	
	@Test(priority=1)
	@Parameters({"userType","DeepLink_Settings"})
	public void DeeplinkToSettings(String pUserType, String pDeeplink) throws Exception {
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(pUserType);
		ZEE5ApplicasterBusinessLogic.quitZEE5App();
		ZEE5ApplicasterBusinessLogic.executeDeeplink(pDeeplink);
		ZEE5ApplicasterBusinessLogic.SettingsScreenViaDeeplink();
	}
	
	@Test(priority=2)
	@Parameters({"userType","DeepLink_Watchlist"})
	public void DeeplinkToWatchlistScreen(String pUserType, String pDeeplink) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.quitZEE5App();
		ZEE5ApplicasterBusinessLogic.executeDeeplink(pDeeplink);
		ZEE5ApplicasterBusinessLogic.WatchlistScreenViaDeeplink(pUserType);
	}
	
	
	@Test(priority=3)
	@Parameters({"userType","DeepLink_Subscription"})
	public void DeeplinkToSubscriptionScreen(String pUserType, String pDeeplink) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.quitZEE5App();
		ZEE5ApplicasterBusinessLogic.executeDeeplink(pDeeplink);
		ZEE5ApplicasterBusinessLogic.SubscriptionScreenViaDeeplink(pUserType);
	}
	
	@AfterTest
	public void tearDownApp() {
		System.out.println("\nExecution Complete - Closing the App");
		ZEE5ApplicasterBusinessLogic.tearDown();
	}
}

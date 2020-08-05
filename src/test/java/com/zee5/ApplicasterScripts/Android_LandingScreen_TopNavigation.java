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

	@Test(priority = 1)  //Sushma
	@Parameters({ "userType" , "tabName1", "tabName2"})
	public void landingScreen(String userType, String tabName1, String tabName2) throws Exception
	{
		ZEE5ApplicasterBusinessLogic.homeLandingScreen(userType, tabName1);
		ZEE5ApplicasterBusinessLogic.moviesLandingScreen(userType, tabName2);
	}
	
	@Test(priority = 2)//only for Guest and NonSubscribedUser
	@Parameters({"tabName"})
	public void AdBannerVerification(String tabName) throws Exception
	{
		ZEE5ApplicasterBusinessLogic.adBannerVerify(tabName);
	}	
	
	@Test(priority = 3)
	@Parameters({ "userType"})
	public void LandingScreen(String userType) throws Exception
	{
		ZEE5ApplicasterBusinessLogic.verifyShowsScreen(userType);
		ZEE5ApplicasterBusinessLogic.verifyNewsLandingScreen(userType);
		ZEE5ApplicasterBusinessLogic.verifyTraysInNewsScreen( userType);
		ZEE5ApplicasterBusinessLogic.verifyListingCollectionScreen(userType);
	}
	
	@Test(priority = 4)
	@Parameters({ "userType"})
	public void LandingScreenLiveTV(String userType) throws Exception
	{
		ZEE5ApplicasterBusinessLogic.LiveTV(); //In Progress
	}
		
	@AfterTest
	public void tearDownApp() {
		System.out.println("Quit the App");
		ZEE5ApplicasterBusinessLogic.tearDown();
	}
	
}

package com.zee5.AndroidMixpanelTest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5ApplicasterMixPanelBusinessLogic;
import com.utility.Utilities;

public class AndroidMixpanel_VideoView {

	private Zee5ApplicasterMixPanelBusinessLogic Zee5ApplicasterMixPanelBusinessLogic;

	@BeforeTest
	public void init() throws Exception {
		Utilities.relaunch = true;
		Zee5ApplicasterMixPanelBusinessLogic = new Zee5ApplicasterMixPanelBusinessLogic("zee");
	}

	@Test(priority = 1)
	@Parameters({ "userType" })
	public void AndroidAppMixPanelLogin(String userType) throws Exception {
//		Zee5ApplicasterMixPanelBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		Zee5ApplicasterMixPanelBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		Zee5ApplicasterMixPanelBusinessLogic.ZeeApplicasterLogin(userType);
	}

	@Test(priority = 2)
	@Parameters({ "userType","pTabName"})
	public void VideoViewEvent_TopNavigation(String userType,String pTabName) throws Exception {
		System.out.println("\nVideo View event validation from "+pTabName+" tab navigation");
		Zee5ApplicasterMixPanelBusinessLogic.videoViewEventFromTopNavigationPage(userType, pTabName);
	}
	
//	@Test(priority = 3)		//###########  VIDEO VIEW EVENT FROM SEARCH TAB  ###########
	@Parameters({ "userType","freeContentID","freeContent"})
	public void VideoViewEventForFreeContentFromSearchPage(String userType,String freeContentID,String freeContent) throws Exception {
		System.out.println("\nVideo View event for Free content");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.VideoViewEventFromSearchTab(userType,"Free",freeContentID,freeContent);
	}
	
//	@Test(priority = 4)
	@Parameters({ "userType","trailerContentID","trailerContent"})
	public void VideoViewEventForTrailerContentFromSearchPage(String userType,String trailerContentID,String trailerContent) throws Exception {
		System.out.println("\nVideo View event for Trailer content");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.VideoViewEventFromSearchTab(userType,"Trailer",trailerContentID,trailerContent);
	}
	
//	@Test(priority = 5)
	@Parameters({ "userType","premiumContentID","premiumContent"})
	public void VideoViewEventForPremiumContentFromSearchPage(String userType,String premiumContentID,String premiumContent) throws Exception {
		System.out.println("\nVideo View event for Premium content");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.VideoViewEventFromSearchTab(userType,"Premium",premiumContentID,premiumContent);
	}
	
	@AfterTest
	public void tearDownApp() {
		System.out.println("\nExecution Complete");
		Zee5ApplicasterMixPanelBusinessLogic.tearDown();
	}
}
package com.zee5.AMDMixpanelScripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5ApplicasterMixPanelBusinessLogic;
import com.utility.Utilities;

public class ZNAMixpanel_VideoView {

	private Zee5ApplicasterMixPanelBusinessLogic Zee5ApplicasterMixPanelBusinessLogic;

	@BeforeTest
	public void init() throws Exception {
		Utilities.relaunch = true;
		Zee5ApplicasterMixPanelBusinessLogic = new Zee5ApplicasterMixPanelBusinessLogic("zee");
	}

	@Test(priority = 1)
	@Parameters({ "userType" })
	public void AndroidAppMixPanelLogin(String userType) throws Exception {
		System.out.println("\nLogin");
		Zee5ApplicasterMixPanelBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		Zee5ApplicasterMixPanelBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		Zee5ApplicasterMixPanelBusinessLogic.ZeeApplicasterLogin(userType);
	}

	@Test(priority = 2)
	@Parameters({ "userType","pTabName"})
	public void VideoViewEvent_HomePage(String userType,String pTabName) throws Exception {
		System.out.println("\nVideo View event validation from "+pTabName+" tab navigation");
		Zee5ApplicasterMixPanelBusinessLogic.videoViewEventFromTopNavigationPage(userType, pTabName);
	}
	
	@Test(priority = 3)
	@Parameters({ "userType","pTypeOfContent","pTabName"})
	public void VideoViewEventFromSearch(String userType,String pTypeOfContent, String pTabName) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.VideoViewEventThroughSearch(userType, pTypeOfContent, pTabName);
	}
	
//###############  VIDEO VIEW EVENT FROM SEARCH TAB  ###############
	
	@Test(priority = 12)
	@Parameters({ "userType","freeContentID","freeContent"})
	public void VideoViewEventForFreeContentFromSearchPage(String userType,String freeContentID,String freeContent) throws Exception {
		System.out.println("\n Video View  event of free content");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.VideoViewEvent(userType,"Free",freeContentID,freeContent);
	}
	
	@Test(priority = 13)
	@Parameters({ "userType","trailerContentID","trailerContent"})
	public void VideoViewEventForTrailerContentFromSearchPage(String userType,String trailerContentID,String trailerContent) throws Exception {
		System.out.println("\nVideo View event of trailer content");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.VideoViewEvent(userType,"Trailer",trailerContentID,trailerContent);
	}
	
	@Test(priority = 14)
	@Parameters({ "userType","premiumContentID","premiumContent"})
	public void VideoViewEventForPremiumContentFromSearchPage(String userType,String premiumContentID,String premiumContent) throws Exception {
		System.out.println("\nVideo View event of premium content");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.VideoViewEvent(userType,"Premium",premiumContentID,premiumContent);
	}
	
//###############-------END OF TEST-------###############

//###############  CAROUSEl TEST TO ADD  ###############	
	
//	@Test(priority = 4)
	public void VideoViewEventofCarouselContent() throws Exception {
		System.out.println("\nVideo view event of Carousel content");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.videoViewEventForCarouselContent("Home");
	}

//	@Test(priority = 5)
	@Parameters({ "userType", "keyword4" })
	public void VideoViewEventFromsearchpage(String userType, String keyword4) throws Exception {
		System.out.println("\nVideo view event of Content from Search page");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.videoViewEventOfcontentFromSearchPage(userType, keyword4);
	}

//	@Test(priority = 6)
	@Parameters({ "userType" })
	public void VideoViewEventFromMyWatchList(String userType) throws Exception {
		System.out.println("\nVideo view event of Content from My WatchList page");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.videoViewEventOfContentFromMyWatchListPage(userType);
	}

//	@Test(priority = 7)
	@Parameters({ "userType", "keyword4" })
	public void VideoViewEventFromUpNextRail(String userType, String keyword4) throws Exception {
		System.out.println("\nVideo view event of Content from Upnext Rail");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.videoViewEventOfContentFromUpNextRail(userType, keyword4);
	}


	@AfterTest
	public void tearDownApp() {
		System.out.println("\nQuit the App");
		Zee5ApplicasterMixPanelBusinessLogic.tearDown();
	}
}
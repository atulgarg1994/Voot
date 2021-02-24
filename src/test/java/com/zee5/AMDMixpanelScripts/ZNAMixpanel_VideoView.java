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
	@Parameters({ "userType" })
	public void VideoViewEvent_HomePage(String userType) throws Exception {
		System.out.println("\nVideo View validation from Home tab");
		Zee5ApplicasterMixPanelBusinessLogic.videoViewEventFromTopNavigationPage(userType, "Home");
	}

	@Test(priority = 3)
	@Parameters({ "userType" })
	public void VideoViewEvent_ShowsPage(String userType) throws Exception {
		System.out.println("\nVideo View validation from Shows tab");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.videoViewEventFromTopNavigationPage(userType, "Shows");
	}

	@Test(priority = 4)
	@Parameters({ "userType" })
	public void VideoViewEvent_MusicPage(String userType) throws Exception {
		System.out.println("\nVideo View validation from Music tab");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.videoViewEventFromTopNavigationPage(userType, "Music");
	}

	@Test(priority = 5)
	@Parameters({ "userType" })
	public void VideoViewEvent_MoviesPage(String userType) throws Exception {
		System.out.println("\nVideo View validation from Movies tab");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.videoViewEventFromTopNavigationPage(userType, "Movies");
	}

	@Test(priority = 6)
	@Parameters({ "userType" })
	public void VideoViewEvent_PremiumPage(String userType) throws Exception {
		System.out.println("\nVideo View validation from Premium tab");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.videoViewEventFromTopNavigationPage(userType, "premium");
	}
	
	@Test(priority = 7)
	@Parameters({ "userType" })
	public void VideoViewEvent_NewsPage(String userType) throws Exception {
		System.out.println("\nVideo View validation from News tab");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.videoViewEventFromTopNavigationPage(userType, "News");
	}

	@Test(priority = 8)
	@Parameters({ "userType" })
	public void VideoViewEvent_ClubPage(String userType) throws Exception {
		System.out.println("\nVideo View validation from Club tab");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.videoViewEventFromTopNavigationPage(userType, "Club");
	}

	@Test(priority = 9)
	@Parameters({ "userType" })
	public void VideoViewEvent_LiveTVPage(String userType) throws Exception {
		System.out.println("\nVideo View validation from Live TV tab");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.videoViewEventFromTopNavigationPage(userType, "Live TV");
	}
	
	@Test(priority = 10)
	@Parameters({ "userType" })
	public void VideoViewEvent_EduauraaPage(String userType) throws Exception {
		System.out.println("\nVideo View validation from Eduauraa tab");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.videoViewEventFromTopNavigationPage(userType, "Eduauraa");
	}
	
	@Test(priority = 11)
	@Parameters({ "userType" })
	public void VideoViewEvent_ZEE5OriginalsPage(String userType) throws Exception {
		System.out.println("\nVideo View validation from ZEE5 Originals tab");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.videoViewEventFromTopNavigationPage(userType, "Zee5 Originals");
	}

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

//	#############  SEARCH Entry point 	#############
	@AfterTest
	public void tearDownApp() {
		System.out.println("\nQuit the App");
		Zee5ApplicasterMixPanelBusinessLogic.tearDown();
	}
}
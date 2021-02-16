package com.zee5.WebMixpanelScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.business.zee.Zee5PWAWEBMixPanelBusinessLogic;

public class ResumeEvent {

	private Zee5PWAWEBMixPanelBusinessLogic Zee5PWAWEBMixPanelBusinessLogic;

	@BeforeTest
	public void init() throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic = new Zee5PWAWEBMixPanelBusinessLogic("Chrome");
	}
	
	@Test(priority = 0)
	@Parameters({ "userType" })
	public void PWAWEBMixPanelLogin(String userType) throws Exception {
		System.out.println("Login");
		Zee5PWAWEBMixPanelBusinessLogic.ZeeWEBPWAMixPanelLogin(userType);
	}

	@Test(priority = 1)
	@Parameters({ "userType" })
	public void verifyResumeEventForPremiumContent(String userType) throws Exception {
		System.out.println("Verify Resume Event For Premium Content");
		Zee5PWAWEBMixPanelBusinessLogic.verifyResumeEventForPremiumContent(userType, "Home");
	}

	@Test(priority = 2)
	@Parameters({ "userType", "keyword1" })
	public void verifyResumeEventForTrailer(String userType, String keyword1) throws Exception {
		System.out.println("Verify Resume Event For Trailer Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyResumeEventForTrailer(userType, keyword1);
	}

	@Test(priority = 3)
	public void verifyResumeEventForCarouselContent() throws Exception {
		System.out.println("Verify Resume Event For Carousel Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyResumeEventForCarouselContent();
	}

	@Test(priority = 4)
	public void verifyResumeEventForContentInTray() throws Exception {
		System.out.println("Verify Resume Event For Content played from Tray");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyResumeEventForContentInTray();
	}

	@Test(priority = 5)
	@Parameters({ "keyword1" })
	public void verifyResumeEventForContentFromSearchPage(String keyword1) throws Exception {
		System.out.println("Verify Resume Event For Content From Search Page");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyResumeEventForContentFromSearchPage(keyword1);
	}

	@Test(priority = 6)
	@Parameters({ "userType", "keyword" })
	public void verifyResumeEventForContentFromMyWatchlistPage(String userType, String keyword) throws Exception {
		System.out.println("Verify Resume Event For Content From My Watchlist Page");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyResumeEventForContentFromMyWatchlistPage(userType, keyword);
	}

	@Test(priority = 7)
	@Parameters({ "userType", "keyword" })
	public void verifyResumeEventForContentInPlaylist(String userType, String keyword) throws Exception {
		System.out.println("Verify Resume Event For Content played from Playlist");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyResumeEventForContentInPlaylist(userType, keyword);
	}

	@Test(priority = 8)
	@Parameters({ "userType", "keyword" })
	public void verifyRemoveFromWatchlistEventFromMyWatchlistPage(String userType, String keyword) throws Exception {
		System.out.println("Verify Remove From Watchlist Event for Content from My Watchlist page");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyRemoveFromWatchlistEventFromMyWatchlistPage(userType, keyword);
	}

	@Test(priority = 9)
	public void verifyResumeEventForContentInMegamenu() throws Exception {
		System.out.println("Verify Resume Event For Content played from Megamenu");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyResumeEventForContentInMegamenu();
	}

	@Test(priority = 10)
	public void verifyResumeEventForLinearContent() throws Exception {
		System.out.println("Verify Resume Event For Linear Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyResumeEventForLinearContent();
	}

	@Test(priority = 11)
	@Parameters({ "userType", "keyword4" })
	public void verifyResumeEventForContentFromUpnextRail(String userType, String keyword4) throws Exception {
		System.out.println("Verify Resume Event for content autoplayed from Upnext rail");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyResumeEventForContentFromUpnextRail(userType, keyword4);
	}

	@Test(priority = 12)
	@Parameters({ "freeContentURL" })
	public void verifyResumeEventForContentFromSharedLink(String freeContentURL) throws Exception {
		System.out.println("Verify Resume Event For content played from Shared Link");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyResumeEventForContentFromSharedLink(freeContentURL);
	}

	@AfterClass
	public void tearDown() {
		Zee5PWAWEBMixPanelBusinessLogic.tearDown();
	}
}

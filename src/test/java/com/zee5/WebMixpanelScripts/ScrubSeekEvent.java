package com.zee5.WebMixpanelScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.business.zee.Zee5PWAWEBMixPanelBusinessLogic;

public class ScrubSeekEvent {

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
	@Parameters({ "userType", "keyword4" })
	public void verifyScrubSeekEventForFreeContent(String userType, String keyword4) throws Exception {
		System.out.println("Verify Scrub/Seek Event For Free Content");
		Zee5PWAWEBMixPanelBusinessLogic.verifyScrubSeekEventForFreeContent(userType, keyword4);
	}

	@Test(priority = 2)
	@Parameters({ "userType" })
	public void verifyScrubSeekEventForPremiumContent(String userType) throws Exception {
		System.out.println("Verify Scrub/Seek Event For Premium Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyScrubSeekEventForPremiumContent(userType, "Home");
	}

	@Test(priority = 3)
	@Parameters({ "keyword1" })
	public void verifyScrubSeekEventForTrailer(String keyword1) throws Exception {
		System.out.println("Verify Scrub/Seek Event For Trailer Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyScrubSeekEventForTrailer(keyword1);
	}

	@Test(priority = 4)
	public void verifyScrubSeekEventForCarouselContent() throws Exception {
		System.out.println("Verify Scrub/Seek Event For Carousel Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyScrubSeekEventForCarouselContent();
	}

	@Test(priority = 5)
	public void verifyScrubSeekEventForContentInTray() throws Exception {
		System.out.println("Verify Scrub/Seek Event For Content played from Tray");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyScrubSeekEventForContentInTray();
	}

	@Test(priority = 6)
	@Parameters({ "keyword1" })
	public void verifyScrubSeekEventForContentFromSearchPage(String keyword1) throws Exception {
		System.out.println("Verify Scrub/Seek Event For Content From Search Page");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyScrubSeekEventForContentFromSearchPage(keyword1);
	}

	@Test(priority = 7)
	@Parameters({ "userType", "keyword" })
	public void verifyScrubSeekEventForContentFromMyWatchlistPage(String userType, String keyword) throws Exception {
		System.out.println("Verify Scrub/Seek Event For Content From My Watchlist Page");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyScrubSeekEventForContentFromMyWatchlistPage(userType, keyword);
	}

	@Test(priority = 8)
	public void verifyScrubSeekEventForContentInMegamenu() throws Exception {
		System.out.println("Verify Scrub/Seek Event For Content played from Megamenu");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyScrubSeekEventForContentInMegamenu();
	}

	@Test(priority = 9)
	@Parameters({ "userType", "keyword" })
	public void verifyScrubSeekEventForContentInPlaylist(String userType, String keyword) throws Exception {
		System.out.println("Verify Scrub/Seek Event For Content played from Playlist");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyScrubSeekEventForContentInPlaylist(userType, keyword);
	}

	@Test(priority = 10)
	@Parameters({ "userType", "keyword4" })
	public void verifyScrubSeekEventForContentFromUpnextRail(String userType, String keyword4) throws Exception {
		System.out.println("Verify Scrub/Seek Event For Content played from Upnext rail");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyScrubSeekEventForContentFromUpnextRail(userType, keyword4);
	}

	@Test(priority = 11)
	@Parameters({ "freeContentURL" })
	public void verifyScrubSeekEventForContentFromSharedLink(String freeContentURL) throws Exception {
		System.out.println("Verify Scrub/Seek Event For content played from Shared Link");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyScrubSeekEventForContentFromSharedLink(freeContentURL);
	}

	@AfterClass
	public void tearDown() {
		Zee5PWAWEBMixPanelBusinessLogic.tearDown();
	}
}

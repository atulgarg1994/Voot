package com.zee5.WebMixpanelScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5PWAWEBMixPanelBusinessLogic;

public class AdClickEvent {

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
	@Parameters({ "userType", "audioTrackContent" })
	public void verifyAdClickEventForFreeContent(String userType, String audioTrackContent) throws Exception {
		System.out.println("Verify Ad Click Event For Free Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdClickEventForFreeContent(userType, audioTrackContent);
	}

	@Test(priority = 2)
	@Parameters({ "userType", "keyword1" })
	public void verifyAdClickEventForTrailer(String userType, String keyword1) throws Exception {
		System.out.println("Verify Ad Click Event For Trailer Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdClickEventForTrailer(userType, keyword1);
	}

	@Test(priority = 3)
	@Parameters({ "userType" })
	public void verifyAdClickEventForCarouselContent(String userType) throws Exception {
		System.out.println("Verify Ad Click Event For Carousel Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdClickEventForCarouselContent(userType);
	}

	@Test(priority = 4)
	@Parameters({ "userType" })
	public void verifyAdClickEventForContentInTray(String userType) throws Exception {
		System.out.println("Verify Ad Click Event For Content played from Tray");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdClickEventForContentInTray(userType);
	}

	@Test(priority = 5)
	@Parameters({ "userType", "subtitleTrackContent" })
	public void verifyAdClickEventForContentFromSearchPage(String userType, String subtitleTrackContent)
			throws Exception {
		System.out.println("Verify Ad Click Event For Content From Search Page");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdClickEventForContentFromSearchPage(userType, subtitleTrackContent);
	}

	@Test(priority = 6)
	@Parameters({ "userType", "audioTrackContent" })
	public void verifyAdClickForContentFromMyWatchlistPage(String userType, String audioTrackContent) throws Exception {
		System.out.println("Verify Ad Click Event For Content From My Watchlist Page");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdClickForContentFromMyWatchlistPage(userType, audioTrackContent);
	}

	@Test(priority = 7)
	@Parameters({ "userType" })
	public void verifyAdClickEventForContentInMegamenu(String userType) throws Exception {
		System.out.println("Verify Ad Click Event For Content played from Megamenu");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdClickEventForContentInMegamenu(userType);
	}

	@Test(priority = 8)
	@Parameters({ "userType", "audioTrackContent" })
	public void verifyAdClickEventForContentInPlaylist(String userType, String audioTrackContent) throws Exception {
		System.out.println("Verify Ad Click Event For Content played from Playlist");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdClickEventForContentInPlaylist(userType, audioTrackContent);
	}

	@Test(priority = 9)
	@Parameters({ "userType", "audioTrackContent" })
	public void verifyAdClickEventForContentFromUpnextRail(String userType, String audioTrackContent) throws Exception {
		System.out.println("Verify Ad Click Event For Content played from Upnext rail");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdClickEventForContentFromUpnextRail(userType, audioTrackContent);
	}

	@Test(priority = 10)
	@Parameters({ "userType", "audioTrackURL" })
	public void verifyAdClickEventForContentFromSharedLink(String userType, String audioTrackURL) throws Exception {
		System.out.println("Verify Ad Click Event For content played from Shared Link");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdClickEventForContentFromSharedLink(userType, audioTrackURL);
	}

	@AfterClass
	public void tearDown() {
		Zee5PWAWEBMixPanelBusinessLogic.tearDown();
	}
}

package com.zee5.WebMixpanelScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5PWAWEBMixPanelBusinessLogic;

public class AdInitializedEvent {

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
	public void verifyAdInitializedEventForFreeContent(String userType, String audioTrackContent) throws Exception {
		System.out.println("Verify Ad Initialized Event For Free Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//			Zee5PWAWEBMixPanelBusinessLogic.verifyAdInitializedEventForFreeContent("Home","homepage",userType,"basavaraj.pn5@gmail.com","igsindia123");
	}

	@Test(priority = 2)
	@Parameters({ "userType", "keyword1" })
	public void verifyAdInitializedEventForTrailer(String userType, String keyword1) throws Exception {
		System.out.println("Verify Ad Initialized Event For Trailer Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdInitializedEventForTrailer(userType, keyword1);
	}

	@Test(priority = 3)
	@Parameters({ "userType" })
	public void verifyAdInitializedEventForCarouselContent(String userType) throws Exception {
		System.out.println("Verify Ad Initialized Event For Carousel Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdInitializedEventForCarouselContent(userType);
	}

	@Test(priority = 4)
	@Parameters({ "userType" })
	public void verifyAdInitializedEventForContentInTray(String userType) throws Exception {
		System.out.println("Verify Ad Initialized Event For Content played from Tray");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdInitializedEventForContentInTray(userType);
	}

	@Test(priority = 5)
	@Parameters({ "userType", "subtitleTrackContent" })
	public void verifyAdInitializedEventForContentFromSearchPage(String userType, String subtitleTrackContent)
			throws Exception {
		System.out.println("Verify Ad Initialized Event For Content From Search Page");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdInitializedEventForContentFromSearchPage(userType,
				subtitleTrackContent);
	}

	@Test(priority = 6)
	@Parameters({ "userType", "audioTrackContent" })
	public void verifyAdInitializedEventForContentFromMyWatchlistPage(String userType, String audioTrackContent)
			throws Exception {
		System.out.println("Verify Ad Initialized Event For Content From My Watchlist Page");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdInitializedEventForContentFromMyWatchlistPage(userType,
				audioTrackContent);
	}

	@Test(priority = 7)
	@Parameters({ "userType" })
	public void verifyAdInitializedEventForContentInMegamenu(String userType) throws Exception {
		System.out.println("Verify Ad Initialized Event For Content played from Megamenu");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdInitializedEventForContentInMegamenu(userType);
	}

	@Test(priority = 8)
	@Parameters({ "userType", "audioTrackContent" })
	public void verifyAdInitializedEventForContentInPlaylist(String userType, String audioTrackContent)
			throws Exception {
		System.out.println("Verify Ad Initialized Event For Content played from Playlist");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdInitializedEventForContentInPlaylist(userType, audioTrackContent);
	}

	@Test(priority = 9)
	@Parameters({ "userType", "audioTrackContent" })
	public void verifyAdInitializedEventForContentFromUpnextRail(String userType, String audioTrackContent)
			throws Exception {
		System.out.println("Verify Ad Initialized Event For Content played from Upnext rail");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdInitializedEventForContentFromUpnextRail(userType, audioTrackContent);
	}

	@Test(priority = 10)
	@Parameters({ "userType", "audioTrackURL" })
	public void verifyAdInitializedEventForContentFromSharedLink(String userType, String audioTrackURL)
			throws Exception {
		System.out.println("Verify Ad Initialized Event For content played from Shared Link");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdInitializedEventForContentFromSharedLink(userType, audioTrackURL);
	}
	
	@AfterClass
	public void tearDown() {
		Zee5PWAWEBMixPanelBusinessLogic.tearDown();
	}
}

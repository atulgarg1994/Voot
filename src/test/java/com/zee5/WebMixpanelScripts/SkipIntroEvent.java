package com.zee5.WebMixpanelScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5PWAWEBMixPanelBusinessLogic;

public class SkipIntroEvent {

	private Zee5PWAWEBMixPanelBusinessLogic Zee5PWAWEBMixPanelBusinessLogic;

	@BeforeTest
	public void init() throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic = new Zee5PWAWEBMixPanelBusinessLogic("Chrome");
	}

	@Test(priority = 1)
	@Parameters({ "userType", "freeMovie2" })
	public void verifySkipIntroEventForFreeContent(String userType, String freeMovie2) throws Exception {
		System.out.println("Verify Skip Intro Event For Free Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifySkipIntroEventForFreeContent(userType, freeMovie2);
	}

	@Test(priority = 2)
	@Parameters({ "userType" })
	public void verifySkipIntroEventForPremiumContent(String userType) throws Exception {
		System.out.println("Verify Skip Intro Event For Premium Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifySkipIntroEventForPremiumContent(userType, "Home");
	}

	@Test(priority = 3)
	@Parameters({ "keyword5" })
	public void verifySkipIntroEventForTrailer(String keyword5) throws Exception {
		System.out.println("Verify Skip Intro Event For Trailer Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifySkipIntroEventForTrailer(keyword5);
	}

	@Test(priority = 4)
	public void verifySkipIntroEventForCarouselContent() throws Exception {
		System.out.println("Verify Skip Intro Event For Carousel Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifySkipIntroEventForCarouselContent();
	}

	@Test(priority = 5)
	public void verifySkipIntroEventForContentInTray() throws Exception {
		System.out.println("Verify Skip Intro Event For Content played from Tray");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifySkipIntroEventForContentInTray();
	}

	@Test(priority = 6)
	@Parameters({ "freeMovie2" })
	public void verifySkipIntroEventForContentFromSearchPage(String freeMovie2) throws Exception {
		System.out.println("Verify Skip Intro Event For Content From Search Page");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifySkipIntroEventForContentFromSearchPage(freeMovie2);
	}

	@Test(priority = 7)
	@Parameters({ "userType", "freeMovie2" })
	public void verifySkipIntroEventForContentFromMyWatchlistPage(String userType, String freeMovie2) throws Exception {
		System.out.println("Verify Skip Intro Event For Content From My Watchlist Page");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifySkipIntroEventForContentFromMyWatchlistPage(userType, freeMovie2);
	}

	@Test(priority = 8)
	public void verifySkipIntroEventForContentInMegamenu() throws Exception {
		System.out.println("Verify Skip Intro Event For Content played from Megamenu");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifySkipIntroEventForContentInMegamenu();
	}

	@Test(priority = 9)
	@Parameters({ "userType", "freeMovie2" })
	public void verifySkipIntroEventForContentInPlaylist(String userType, String freeMovie2) throws Exception {
		System.out.println("Verify Skip Intro Event For Content played from Playlist");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifySkipIntroEventForContentInPlaylist(userType, freeMovie2);
	}

	@Test(priority = 10)
	@Parameters({ "userType", "freeMovie2" })
	public void verifySkipIntroEventForContentFromUpnextRail(String userType, String freeMovie2) throws Exception {
		System.out.println("Verify Skip Intro Event For Content played from Upnext rail");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifySkipIntroEventForContentFromUpnextRail(userType, freeMovie2);
	}

	@Test(priority = 11)
	@Parameters({ "skipIntroURL" })
	public void verifySkipIntroEventForContentFromSharedLink(String skipIntroURL) throws Exception {
		System.out.println("Verify Skip Intro Event For content played from Shared Link");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifySkipIntroEventForContentFromSharedLink(skipIntroURL);
	}

	@AfterClass
	public void tearDown() {
		Zee5PWAWEBMixPanelBusinessLogic.tearDown();
	}
}

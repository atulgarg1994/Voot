package com.zee5.MixpanelScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.business.zee.Zee5MPWAMixPanelBusinessLogic;

public class AndroidPWAMixpanel_PlayerEvents {

	private Zee5MPWAMixPanelBusinessLogic Zee5PWAMixPanelAndroidBusinessLogic;

	@BeforeTest
	public void init() throws Exception {
		Zee5PWAMixPanelAndroidBusinessLogic = new Zee5MPWAMixPanelBusinessLogic("Chrome");
	}

	@Test(priority = 1)
	@Parameters({ "userType" })
	public void ZeePWALogin(String userType) throws Exception {
		System.out.println("Login");
		Zee5PWAMixPanelAndroidBusinessLogic.ZeePWALogin("E-mail", userType);
	}

	@Test(priority = 2)
	public void verifyBannerAutoplayEventForNewsContent() throws Exception {
		System.out.println("Verify Banner Autoplay Event");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyBannerAutoplayEventForNewsContent();
	}

	@Test(priority = 3)
	@Parameters({ "userType" })
	public void verifyVideoViewEventForFreeContent(String userType) throws Exception {
		System.out.println("Verify Video View Event For Free Content");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoViewEventForFreeContent("Home", "homepage", userType,
				"basavaraj.pn5@gmail.com", "igsindia123");
	}

	@Test(priority = 4)
	@Parameters({ "userType" })
	public void verifyVideoViewEventForPremiumContent(String userType) throws Exception {
		System.out.println("Verify Video View Event For Premium Content");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoViewEventForPremiumContent(userType, "Home");
	}

	@Test(priority = 5)
	@Parameters({ "keyword1" })
	public void verifyVideoViewEventForTrailer(String keyword1) throws Exception {
		System.out.println("Verify Video View Event For Trailer Content");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoViewEventForTrailer(keyword1);
	}

	@Test(priority = 6)
	public void verifyVideoViewEventForCarouselContent() throws Exception {
		System.out.println("Verify Video View Event For Carousel Content");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoViewEventForCarouselContent();
	}

	@Test(priority = 7)
	public void verifyVideoViewEventForContentInTray() throws Exception {
		System.out.println("Verify Video View Event For Content played from Tray");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoViewEventForContentInTray();
	}

	@Test(priority = 8)
	@Parameters({ "keyword1" })
	public void verifyVideoViewEventForContentFromSearchPage(String keyword1) throws Exception {
		System.out.println("Verify Video View Event For Content From Search Page");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoViewEventForContentFromSearchPage(keyword1);
	}

	@Test(priority = 9)
	@Parameters({ "userType", "keyword" })
	public void verifyVideoViewEventForContentFromMyWatchlistPage(String userType, String keyword) throws Exception {
		System.out.println("Verify Video View Event For Content From My Watchlist Page");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoViewEventForContentFromMyWatchlistPage(userType, keyword);
	}

	@Test(priority = 10)
	@Parameters({ "userType", "keyword" })
	public void verifyVideoViewEventForContentFromUpnextRail(String userType, String keyword) throws Exception {
		System.out.println("Verify Video View Event for content autoplayed from Upnext rail");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoViewEventForContentFromUpnextRail(userType, keyword);
	}

	@Test(priority = 11)
	@Parameters({ "freeContentURL" })
	public void verifyVideoViewEventForContentFromSharedLink(String freeContentURL) throws Exception {
		System.out.println("Verify Video View Event For content played from Shared Link");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoViewEventForContentFromSharedLink(freeContentURL);
	}

	@Test(priority = 12)
	@Parameters({ "userType", "keyword" })
	public void verifyVideoViewEventForContentInPlaylist(String userType, String keyword) throws Exception {
		System.out.println("Verify Video View Event For Content played from Playlist");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoViewEventForContentInPlaylist(userType, keyword);
	}

	@Test(priority = 13)
	public void verifyVideoViewEventForContentInMegamenu() throws Exception {
		System.out.println("Verify Video View Event For Content played from Megamenu");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoViewEventForContentInMegamenu();
	}

	@Test(priority = 14)
	@Parameters({ "keyword1" })
	public void verifyVideoViewEventAfterRefreshingPage(String keyword1) throws Exception {
		System.out.println("Verify Video View Event after refreshing a page");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoViewEventAfterRefreshingPage(keyword1);
	}

	@Test(priority = 15)
	@Parameters({ "userType" })
	public void verifyVideoExitEventForFreeContent(String userType) throws Exception {
		System.out.println("Verify Video Exit Event For Free Content");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoExitEventForFreeContent("Home", "homepage", userType,
				"basavaraj.pn5@gmail.com", "igsindia123");
	}

	@Test(priority = 16)
	@Parameters({ "userType" })
	public void verifyVideoExitEventForPremiumContent(String userType) throws Exception {
		System.out.println("Verify Video Exit Event For Premium Content");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoExitEventForPremiumContent(userType, "Home");
	}

	@Test(priority = 17)
	@Parameters({ "keyword1" })
	public void verifyVideoExitEventForTrailer(String keyword1) throws Exception {
		System.out.println("Verify Video Exit Event For Trailer Content");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoExitEventForTrailer(keyword1);
	}

	@Test(priority = 18)
	public void verifyVideoExitEventForCarouselContent() throws Exception {
		System.out.println("Verify Video Exit Event For Carousel Content");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoExitEventForCarouselContent();
	}

	@Test(priority = 19)
	public void verifyVideoExitEventForContentInTray() throws Exception {
		System.out.println("Verify Video Exit Event For Content played from Tray");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoExitEventForContentInTray();
	}

	@Test(priority = 20)
	@Parameters({ "keyword1" })
	public void verifyVideoExitEventForContentFromSearchPage(String keyword1) throws Exception {
		System.out.println("Verify Video Exit Event For Content From Search Page");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoExitEventForContentFromSearchPage(keyword1);
	}

	@Test(priority = 21)
	@Parameters({ "userType", "keyword" })
	public void verifyVideoExitEventForContentFromMyWatchlistPage(String userType, String keyword) throws Exception {
		System.out.println("Verify Video Exit Event For Content From My Watchlist Page");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoExitEventForContentFromMyWatchlistPage(userType, keyword);
	}

	@Test(priority = 22)
	@Parameters({ "userType", "keyword" })
	public void verifyVideoExitEventForContentFromUpnextRail(String userType, String keyword) throws Exception {
		System.out.println("Verify Video Exit Event for content autoplayed from Upnext rail");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoExitEventForContentFromUpnextRail(userType, keyword);
	}

	@Test(priority = 23)
	@Parameters({ "freeContentURL" })
	public void verifyVideoExitEventForContentFromSharedLink(String freeContentURL) throws Exception {
		System.out.println("Verify Video Exit Event For content played from Shared Link");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoExitEventForContentFromSharedLink(freeContentURL);
	}

	@Test(priority = 24)
	@Parameters({ "userType", "keyword" })
	public void verifyVideoExitEventForContentInPlaylist(String userType, String keyword) throws Exception {
		System.out.println("Verify Video Exit Event For Content played from Playlist");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoExitEventForContentInPlaylist(userType, keyword);
	}

	@Test(priority = 25)
	public void verifyVideoExitEventForContentInMegamenu() throws Exception {
		System.out.println("Verify Video Exit Event For Content played from Megamenu");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoExitEventForContentInMegamenu();
	}

	@Test(priority = 26)
	@Parameters({ "keyword1" })
	public void verifyVideoExitEventAfterRefreshingPage(String keyword1) throws Exception {
		System.out.println("Verify Video Exit Event after refreshing a page");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoExitEventAfterRefreshingPage(keyword1);
	}

	@AfterClass
	public void tearDown() {
		Zee5PWAMixPanelAndroidBusinessLogic.tearDown();
	}

}

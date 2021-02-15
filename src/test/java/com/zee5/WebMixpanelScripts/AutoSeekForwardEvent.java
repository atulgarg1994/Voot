package com.zee5.WebMixpanelScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.business.zee.Zee5PWAWEBMixPanelBusinessLogic;

public class AutoSeekForwardEvent {

	private Zee5PWAWEBMixPanelBusinessLogic Zee5PWAWEBMixPanelBusinessLogic;

	@BeforeTest
	public void init() throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic = new Zee5PWAWEBMixPanelBusinessLogic("Chrome");
	}

	@Test(priority = 1)
	@Parameters({ "userType", "keyword4" })
	public void verifyAutoSeekForwardEventForFreeContent(String userType, String keyword4) throws Exception {
		System.out.println("Verify Auto Seek Forward Event For Free Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekForwardEventForFreeContent(userType, keyword4);
	}

	@Test(priority = 2)
	@Parameters({ "userType" })
	public void verifyAutoSeekForwardEventForPremiumContent(String userType) throws Exception {
		System.out.println("Verify Auto Seek Forward Event For Premium Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekForwardEventForPremiumContent(userType, "Home");
	}

	@Test(priority = 3)
	@Parameters({ "keyword1" })
	public void verifyAutoSeekForwardEventForTrailer(String keyword1) throws Exception {
		System.out.println("Verify Auto Seek Forward Event For Trailer Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekForwardEventForTrailer(keyword1);
	}

	@Test(priority = 4)
	public void verifyAutoSeekForwardEventForCarouselContent() throws Exception {
		System.out.println("Verify Auto Seek Forward Event For Carousel Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekForwardEventForCarouselContent();
	}

	@Test(priority = 5)
	public void verifyAutoSeekForwardEventForContentInTray() throws Exception {
		System.out.println("Verify Auto Seek Forward Event For Content played from Tray");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekForwardEventForContentInTray();
	}

	@Test(priority = 6)
	@Parameters({ "keyword1" })
	public void verifyAutoSeekForwardEventForContentFromSearchPage(String keyword1) throws Exception {
		System.out.println("Verify Auto Seek Forward Event For Content From Search Page");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekForwardEventForContentFromSearchPage(keyword1);
	}

	@Test(priority = 7)
	@Parameters({ "userType", "keyword" })
	public void verifyAutoSeekForwardEventForContentFromMyWatchlistPage(String userType, String keyword)
			throws Exception {
		System.out.println("Verify Auto Seek Forward Event For Content From My Watchlist Page");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekForwardEventForContentFromMyWatchlistPage(userType, keyword);
	}

	@Test(priority = 8)
	public void verifyAutoSeekForwardEventForContentInMegamenu() throws Exception {
		System.out.println("Verify Auto Seek Forward Event For Content played from Megamenu");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekForwardEventForContentInMegamenu();
	}

	@Test(priority = 9)
	@Parameters({ "userType", "keyword" })
	public void verifyAutoSeekForwardEventForContentInPlaylist(String userType, String keyword) throws Exception {
		System.out.println("Verify Auto Seek Forward Event For Content played from Playlist");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekForwardEventForContentInPlaylist(userType, keyword);
	}

	@Test(priority = 10)
	@Parameters({ "userType", "keyword4" })
	public void verifyAutoSeekForwardEventForContentFromUpnextRail(String userType, String keyword4) throws Exception {
		System.out.println("Verify Auto Seek Forward Event For Content played from Upnext rail");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekForwardEventForContentFromUpnextRail(userType, keyword4);
	}

	@Test(priority = 11)
	@Parameters({ "freeContentURL" })
	public void verifyAutoSeekForwardEventForContentFromSharedLink(String freeContentURL) throws Exception {
		System.out.println("Verify Auto Seek Forward Event For content played from Shared Link");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekForwardEventForContentFromSharedLink(freeContentURL);
	}

	@Test(priority = 12)
	@Parameters({ "userType", "keyword4" })
	public void verifyAutoSeekRewindEventForFreeContent(String userType, String keyword4) throws Exception {
		System.out.println("Verify Auto Seek Rewind Event For Free Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekRewindEventForFreeContent(userType, keyword4);
	}

	@Test(priority = 13)
	@Parameters({ "userType" })
	public void verifyAutoSeekRewindEventForPremiumContent(String userType) throws Exception {
		System.out.println("Verify Auto Seek Rewind Event For Premium Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekRewindEventForPremiumContent(userType, "Home");
	}

	@Test(priority = 14)
	@Parameters({ "keyword1" })
	public void verifyAutoSeekRewindEventForTrailer(String keyword1) throws Exception {
		System.out.println("Verify Auto Seek Rewind Event For Trailer Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekRewindEventForTrailer(keyword1);
	}

	@Test(priority = 15)
	public void verifyAutoSeekRewindEventForCarouselContent() throws Exception {
		System.out.println("Verify Auto Seek Rewind Event For Carousel Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekRewindEventForCarouselContent();
	}

	@Test(priority = 16)
	public void verifyAutoSeekRewindEventForContentInTray() throws Exception {
		System.out.println("Verify Auto Seek Rewind Event For Content played from Tray");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekRewindEventForContentInTray();
	}

	@Test(priority = 17)
	@Parameters({ "keyword1" })
	public void verifyAutoSeekRewindEventForContentFromSearchPage(String keyword1) throws Exception {
		System.out.println("Verify Auto Seek Rewind Event For Content From Search Page");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekRewindEventForContentFromSearchPage(keyword1);
	}

	@Test(priority = 18)
	@Parameters({ "userType", "keyword" })
	public void verifyAutoSeekRewindEventForContentFromMyWatchlistPage(String userType, String keyword)
			throws Exception {
		System.out.println("Verify Auto Seek Rewind Event For Content From My Watchlist Page");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekRewindEventForContentFromMyWatchlistPage(userType, keyword);
	}

	@Test(priority = 19)
	public void verifyAutoSeekRewindEventForContentInMegamenu() throws Exception {
		System.out.println("Verify Auto Seek Rewind Event For Content played from Megamenu");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekRewindEventForContentInMegamenu();
	}

	@Test(priority = 20)
	@Parameters({ "userType", "keyword" })
	public void verifyAutoSeekRewindEventForContentInPlaylist(String userType, String keyword) throws Exception {
		System.out.println("Verify Auto Seek Rewind Event For Content played from Playlist");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekRewindEventForContentInPlaylist(userType, keyword);
	}

	@Test(priority = 21)
	@Parameters({ "userType", "keyword4" })
	public void verifyAutoSeekRewindEventForContentFromUpnextRail(String userType, String keyword4) throws Exception {
		System.out.println("Verify Auto Seek Rewind Event For Content played from Upnext rail");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekRewindEventForContentFromUpnextRail(userType, keyword4);
	}

	@Test(priority = 22)
	@Parameters({ "freeContentURL" })
	public void verifyAutoSeekRewindEventForContentFromSharedLink(String freeContentURL) throws Exception {
		System.out.println("Verify Auto Seek Rewind Event For content played from Shared Link");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekRewindEventForContentFromSharedLink(freeContentURL);
	}

	@AfterClass
	public void tearDown() {
		Zee5PWAWEBMixPanelBusinessLogic.tearDown();
	}
}

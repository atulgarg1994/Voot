package com.zee5.WebMixpanelScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.business.zee.Zee5PWAWEBMixPanelBusinessLogic;

public class AdWatchDurationEvent {

	private Zee5PWAWEBMixPanelBusinessLogic Zee5PWAWEBMixPanelBusinessLogic;

	@BeforeTest
	public void init() throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic = new Zee5PWAWEBMixPanelBusinessLogic("Chrome");
	}

	@Test(priority = 1)
	@Parameters({ "userType", "audioTrackContent" })
	public void verifyAdWatchDurationEventForFreeContentForceExit(String userType, String audioTrackContent)
			throws Exception {
		System.out.println("Verify Ad Watch Duration Event when user force quits the ad playback for free content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForFreeContentForceExit(userType, audioTrackContent);
	}

	@Test(priority = 2)
	@Parameters({ "userType", "keyword1" })
	public void verifyAdWatchDurationEventForTrailerForceExit(String userType, String keyword1) throws Exception {
		System.out.println("Verify Ad Watch Duration Event when user force quits the ad playback For Trailer Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForTrailerForceExit(userType, keyword1);
	}

	@Test(priority = 3)
	@Parameters({ "userType" })
	public void verifyAdWatchDurationEventForCarouselContentForceExit(String userType) throws Exception {
		System.out.println("Verify Ad Watch Duration Event when user force quits the ad playback For Carousel Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForCarouselContentForceExit(userType);
	}

	@Test(priority = 4)
	@Parameters({ "userType" })
	public void verifyAdWatchDurationEventForContentInTrayForceExit(String userType) throws Exception {
		System.out.println(
				"Verify Ad Watch Duration Event when user force quits the ad playback For Content played from Tray");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentInTrayForceExit(userType);
	}

	@Test(priority = 5)
	@Parameters({ "userType", "subtitleTrackContent" })
	public void verifyAdWatchDurationEventForContentFromSearchPageForceExit(String userType,
			String subtitleTrackContent) throws Exception {
		System.out.println(
				"Verify Ad Watch Duration Event when user force quits the ad playback For Content From Search Page");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentFromSearchPageForceExit(userType,
				subtitleTrackContent);
	}

	@Test(priority = 6)
	@Parameters({ "userType", "audioTrackContent" })
	public void verifyAdWatchDurationEventForContentFromMyWatchlistPageForceExit(String userType,
			String audioTrackContent) throws Exception {
		System.out.println(
				"Verify Ad Watch Duration Event when user force quits the ad playback For Content From My Watchlist Page");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentFromMyWatchlistPageForceExit(userType,
				audioTrackContent);
	}

	@Test(priority = 7)
	@Parameters({ "userType" })
	public void verifyAdWatchDurationEventForContentInMegamenuForceExit(String userType) throws Exception {
		System.out.println(
				"Verify Ad Watch Duration Event when user force quits the ad playback For Content played from Megamenu");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentInMegamenuForceExit(userType);
	}

	@Test(priority = 8)
	@Parameters({ "userType", "audioTrackContent" })
	public void verifyAdWatchDurationEventForContentInPlaylistForceExit(String userType, String audioTrackContent)
			throws Exception {
		System.out.println(
				"Verify Ad Watch Duration Event when user force quits the ad playback For Content played from Playlist");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentInPlaylistForceExit(userType,
				audioTrackContent);
	}

	@Test(priority = 9)
	@Parameters({ "userType", "audioTrackContent" })
	public void verifyAdWatchDurationEventForContentFromUpnextRailForceExit(String userType, String audioTrackContent)
			throws Exception {
		System.out.println(
				"Verify Ad Watch Duration Event when user force quits the ad playback For Content played from Upnext rail");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentFromUpnextRailForceExit(userType,
				audioTrackContent);
	}

	@Test(priority = 10)
	@Parameters({ "userType", "audioTrackURL" })
	public void verifyAdWatchDurationEventForContentFromSharedLinkForceExit(String userType, String audioTrackURL)
			throws Exception {
		System.out.println(
				"Verify Ad Watch Duration Event when user force quits the ad playback For content played from Shared Link");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentFromSharedLinkForceExit(userType,
				audioTrackURL);
	}

	@Test(priority = 11)
	@Parameters({ "userType", "audioTrackContent" })
	public void verifyAdWatchDurationEventForFreeContentComplete(String userType, String audioTrackContent)
			throws Exception {
		System.out
				.println("Verify Ad Watch Duration Event when user completly watches the ad playback for free content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForFreeContentComplete(userType, audioTrackContent);
	}

	@Test(priority = 12)
	@Parameters({ "userType", "keyword1" })
	public void verifyAdWatchDurationEventForTrailerComplete(String userType, String keyword1) throws Exception {
		System.out.println(
				"Verify Ad Watch Duration Event when user completly watches the ad playback For Trailer Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForTrailerComplete(userType, keyword1);
	}

	@Test(priority = 13)
	@Parameters({ "userType" })
	public void verifyAdWatchDurationEventForCarouselContentComplete(String userType) throws Exception {
		System.out.println(
				"Verify Ad Watch Duration Event when user completly watches the ad playback For Carousel Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForCarouselContentComplete(userType);
	}

	@Test(priority = 14)
	@Parameters({ "userType" })
	public void verifyAdWatchDurationEventForContentInTrayComplete(String userType) throws Exception {
		System.out.println(
				"Verify Ad Watch Duration Event when user completly watches the ad playback For Content played from Tray");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentInTrayComplete(userType);
	}

	@Test(priority = 15)
	@Parameters({ "userType", "subtitleTrackContent" })
	public void verifyAdWatchDurationEventForContentFromSearchPageComplete(String userType, String subtitleTrackContent)
			throws Exception {
		System.out.println(
				"Verify Ad Watch Duration Event when user completly watches the ad playback For Content From Search Page");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentFromSearchPageComplete(userType,
				subtitleTrackContent);
	}

	@Test(priority = 16)
	@Parameters({ "userType", "audioTrackContent" })
	public void verifyAdWatchDurationEventForContentFromMyWatchlistPageComplete(String userType,
			String audioTrackContent) throws Exception {
		System.out.println(
				"Verify Ad Watch Duration Event when user completly watches ad playback For Content From My Watchlist Page");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentFromMyWatchlistPageComplete(userType,
				audioTrackContent);
	}

	@Test(priority = 17)
	@Parameters({ "userType" })
	public void verifyAdWatchDurationEventForContentInMegamenuComplete(String userType) throws Exception {
		System.out.println(
				"Verify Ad Watch Duration Event when user completly watches the ad playback For Content played from Megamenu");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentInMegamenuComplete(userType);
	}

	@Test(priority = 18)
	@Parameters({ "userType", "audioTrackContent" })
	public void verifyAdWatchDurationEventForContentInPlaylistComplete(String userType, String audioTrackContent)
			throws Exception {
		System.out.println(
				"Verify Ad Watch Duration Event when user completly watches the ad playback For Content played from Playlist");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentInPlaylistComplete(userType,
				audioTrackContent);
	}

	@Test(priority = 19)
	@Parameters({ "userType", "audioTrackContent" })
	public void verifyAdWatchDurationEventForContentFromUpnextRailComplete(String userType, String audioTrackContent)
			throws Exception {
		System.out.println(
				"Verify Ad Watch Duration Event when user completly watches the ad playback For Content played from Upnext rail");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentFromUpnextRailComplete(userType,
				audioTrackContent);
	}

	@Test(priority = 20)
	@Parameters({ "userType", "audioTrackURL" })
	public void verifyAdWatchDurationEventForContentFromSharedLinkComplete(String userType, String audioTrackURL)
			throws Exception {
		System.out.println(
				"Verify Ad Watch Duration Event when user completly watches ad playback For content played from Shared Link");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentFromSharedLinkComplete(userType,
				audioTrackURL);
	}

	@Test(priority = 21)
	@Parameters({ "userType", "audioTrackContent" })
	public void verifyAdWatchDurationEventForFreeContentSkipAd(String userType, String audioTrackContent)
			throws Exception {
		System.out.println("Verify Ad Watch Duration Event when user skips the ad playback for free content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForFreeContentSkipAd(userType, audioTrackContent);
	}

	@Test(priority = 22)
	@Parameters({ "userType", "keyword1" })
	public void verifyAdWatchDurationEventForTrailerSkipAd(String userType, String keyword1) throws Exception {
		System.out.println("Verify Ad Watch Duration Event when user skips the ad playback For Trailer Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForTrailerSkipAd(userType, keyword1);
	}

	@Test(priority = 23)
	@Parameters({ "userType" })
	public void verifyAdWatchDurationEventForCarouselContentSkipAd(String userType) throws Exception {
		System.out.println("Verify Ad Watch Duration Event when user skips the ad playback For Carousel Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForCarouselContentSkipAd(userType);
	}

	@Test(priority = 24)
	@Parameters({ "userType" })
	public void verifyAdWatchDurationEventForContentInTraySkipAd(String userType) throws Exception {
		System.out
				.println("Verify Ad Watch Duration Event when user skips the ad playback For Content played from Tray");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentInTraySkipAd(userType);
	}

	@Test(priority = 25)
	@Parameters({ "userType", "subtitleTrackContent" })
	public void verifyAdWatchDurationEventForContentFromSearchPageSkipAd(String userType, String subtitleTrackContent)
			throws Exception {
		System.out
				.println("Verify Ad Watch Duration Event when user skips the ad playback For Content From Search Page");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentFromSearchPageSkipAd(userType,
				subtitleTrackContent);
	}

	@Test(priority = 26)
	@Parameters({ "userType", "audioTrackContent" })
	public void verifyAdWatchDurationEventForContentFromMyWatchlistPageSkipAd(String userType, String audioTrackContent)
			throws Exception {
		System.out.println(
				"Verify Ad Watch Duration Event when user skips ad playback For Content From My Watchlist Page");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentFromMyWatchlistPageSkipAd(userType,
				audioTrackContent);
	}

	@Test(priority = 27)
	@Parameters({ "userType" })
	public void verifyAdWatchDurationEventForContentInMegamenuSkipAd(String userType) throws Exception {
		System.out.println(
				"Verify Ad Watch Duration Event when user skips the ad playback For Content played from Megamenu");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentInMegamenuSkipAd(userType);
	}

	@Test(priority = 28)
	@Parameters({ "userType", "audioTrackContent" })
	public void verifyAdWatchDurationEventForContentInPlaylistSkipAd(String userType, String audioTrackContent)
			throws Exception {
		System.out.println(
				"Verify Ad Watch Duration Event when user skips the ad playback For Content played from Playlist");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentInPlaylistSkipAd(userType,
				audioTrackContent);
	}

	@Test(priority = 29)
	@Parameters({ "userType", "audioTrackContent" })
	public void verifyAdWatchDurationEventForContentFromUpnextRailSkipAd(String userType, String audioTrackContent)
			throws Exception {
		System.out.println(
				"Verify Ad Watch Duration Event when user skips the ad playback For Content played from Upnext rail");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentFromUpnextRailSkipAd(userType,
				audioTrackContent);
	}

	@Test(priority = 30)
	@Parameters({ "userType", "audioTrackURL" })
	public void verifyAdWatchDurationEventForContentFromSharedLinkSkipAd(String userType, String audioTrackURL)
			throws Exception {
		System.out.println(
				"Verify Ad Watch Duration Event when user skips ad playback For content played from Shared Link");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentFromSharedLinkSkipAd(userType,
				audioTrackURL);
	}

	@AfterClass
	public void tearDown() {
		Zee5PWAWEBMixPanelBusinessLogic.tearDown();
	}
}

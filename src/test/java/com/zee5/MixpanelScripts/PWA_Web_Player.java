package com.zee5.MixpanelScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.business.zee.Zee5PWAWEBMixPanelBusinessLogic;

public class PWA_Web_Player {

	private Zee5PWAWEBMixPanelBusinessLogic Zee5PWAWEBMixPanelBusinessLogic;

	@BeforeTest
	public void init() throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic = new Zee5PWAWEBMixPanelBusinessLogic("Chrome");
	}
	
	@Test
	public void checkPageName() throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic.clickOnTab();
	}
	
//	@Test(priority = 1)
//	@Parameters({ "userType" })
//	public void PWAWEBMixPanelLogin(String userType) throws Exception {
//		System.out.println("Login");
//		Zee5PWAWEBMixPanelBusinessLogic.ZeeWEBPWAMixPanelLogin(userType);
//	}
//	
//	@Test(priority = 2)
//	public void verifyBannerAutoplayEventForNewsContent() throws Exception {
//		System.out.println("Verify Banner Autoplay Event");
//		Zee5PWAWEBMixPanelBusinessLogic.verifyBannerAutoplayEventForNewsContent();
//	}
//	
////	=========================================================================================================
//	@Test(priority = 3)
//	@Parameters({ "userType", "keyword4"})
//	public void verifyVideoViewEventForContentFromUpnextRail(String userType,String keyword4) throws Exception {
//		System.out.println("Verify Video View Event for content autoplayed from Upnext rail");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoViewEventForContentFromUpnextRail(userType,keyword4);
//	}
//	
//	@Test(priority = 4)
//	@Parameters({"freeContentURL"})
//	public void verifyVideoViewEventForContentFromSharedLink(String freeContentURL) throws Exception {
//		System.out.println("Verify Video View Event For content played from Shared Link");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoViewEventForContentFromSharedLink(freeContentURL);
//	}
//	
//	@Test(priority = 5)
//	@Parameters({ "userType", "keyword4"})
//	public void verifyVideoViewEventForFreeContent(String userType,String keyword4) throws Exception {
//		System.out.println("Verify Video View Event For Free Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoViewEventForFreeContent(userType,keyword4);
//	}
//	
//	@Test(priority = 6)
//	@Parameters({ "userType"})
//	public void verifyVideoViewEventForPremiumContent(String userType) throws Exception {
//		System.out.println("Verify Video View Event For Premium Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoViewEventForPremiumContent(userType,"Home");
//	}
//	
//	@Test(priority = 7)
//	@Parameters({ "keyword1"})
//	public void verifyVideoViewEventForTrailer(String keyword1) throws Exception {
//		System.out.println("Verify Video View Event For Trailer Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoViewEventForTrailer(keyword1);
//	}
//	
//	@Test(priority = 8)
//	public void verifyVideoViewEventForCarouselContent() throws Exception {
//		System.out.println("Verify Video View Event For Carousel Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoViewEventForCarouselContent();
//	}
//	
//	@Test(priority = 9)
//	public void verifyVideoViewEventForContentInTray() throws Exception {
//		System.out.println("Verify Video View Event For Content played from Tray");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoViewEventForContentInTray();
//	}
//	
//	@Test(priority = 10)
//	@Parameters({"keyword1"})
//	public void verifyVideoViewEventForContentFromSearchPage(String keyword1) throws Exception {
//		System.out.println("Verify Video View Event For Content From Search Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoViewEventForContentFromSearchPage(keyword1);
//	}
//	
//	@Test(priority = 11)
//	@Parameters({ "userType", "keyword"})
//	public void verifyVideoViewEventForContentFromMyWatchlistPage(String userType,String keyword) throws Exception {
//		System.out.println("Verify Video View Event For Content From My Watchlist Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoViewEventForContentFromMyWatchlistPage(userType,keyword);
//	}
//	
//	@Test(priority = 12)
//	public void verifyVideoViewEventForContentInMegamenu() throws Exception {
//		System.out.println("Verify Video View Event For Content played from Megamenu");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoViewEventForContentInMegamenu();
//	}
//	
//	@Test(priority = 13)
//	@Parameters({ "userType", "keyword"})
//	public void verifyVideoViewEventForContentInPlaylist(String userType,String keyword) throws Exception {
//		System.out.println("Verify Video View Event For Content played from Playlist");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoViewEventForContentInPlaylist(userType,keyword);
//	}
//	
//	@Test(priority = 14)
//	@Parameters({"keyword1"})
//	public void verifyVideoViewEventAfterRefreshingPage(String keyword1) throws Exception {
//		System.out.println("Verify Video View Event after refreshing a page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoViewEventAfterRefreshingPage(keyword1);
//	}
//	
////======================video Exit========================
//	
//	@Test(priority = 15)
//	@Parameters({ "userType", "keyword"})
//	public void verifyVideoExitEventForContentInPlaylist(String userType,String keyword) throws Exception {
//		System.out.println("Verify Video Exit Event For Content played from Playlist");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoExitEventForContentInPlaylist(userType,keyword);
//	}
//	
//	@Test(priority = 16)
//	@Parameters({"keyword1"})
//	public void verifyVideoExitEventAfterRefreshingPage(String keyword1) throws Exception {
//		System.out.println("Verify Video Exit Event after refreshing a page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoExitEventAfterRefreshingPage(keyword1);
//	}
//	
//	@Test(priority = 17)
//	@Parameters({ "userType", "keyword4"})
//	public void verifyVideoExitEventForContentFromUpnextRail(String userType,String keyword4) throws Exception {
//		System.out.println("Verify Video Exit Event for content autoplayed from Upnext rail");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoExitEventForContentFromUpnextRail(userType,keyword4);
//	}
//	
//	@Test(priority = 18)
//	@Parameters({"freeContentURL"})
//	public void verifyVideoExitEventForContentFromSharedLink(String freeContentURL) throws Exception {
//		System.out.println("Verify Video Exit Event For content played from Shared Link");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoExitEventForContentFromSharedLink(freeContentURL);
//	}
//	
//	@Test(priority = 19)
//	@Parameters({ "userType", "keyword4"})
//	public void verifyVideoExitEventForFreeContent(String userType,String keyword4) throws Exception {
//		System.out.println("Verify Video Exit Event For Free Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoExitEventForFreeContent(userType,keyword4);
//	}
//	
//	@Test(priority = 20)
//	@Parameters({ "userType"})
//	public void verifyVideoExitEventForPremiumContent(String userType) throws Exception {
//		System.out.println("Verify Video Exit Event For Premium Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoExitEventForPremiumContent(userType,"Home");
//	}
//	
//	@Test(priority = 21)
//	@Parameters({ "keyword1"})
//	public void verifyVideoExitEventForTrailer(String keyword1) throws Exception {
//		System.out.println("Verify Video Exit Event For Trailer Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoExitEventForTrailer(keyword1);
//	}
//	
//	@Test(priority = 22)
//	public void verifyVideoExitEventForCarouselContent() throws Exception {
//		System.out.println("Verify Video Exit Event For Carousel Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoExitEventForCarouselContent();
//	}
//	
//	@Test(priority = 23)
//	public void verifyVideoExitEventForContentInTray() throws Exception {
//		System.out.println("Verify Video Exit Event For Content played from Tray");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoExitEventForContentInTray();
//	}
//	
//	@Test(priority = 24)
//	@Parameters({"keyword1"})
//	public void verifyVideoExitEventForContentFromSearchPage(String keyword1) throws Exception {
//		System.out.println("Verify Video Exit Event For Content From Search Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoExitEventForContentFromSearchPage(keyword1);
//	}
//	
//	@Test(priority = 25)
//	@Parameters({ "userType", "keyword"})
//	public void verifyVideoExitEventForContentFromMyWatchlistPage(String userType,String keyword) throws Exception {
//		System.out.println("Verify Video Exit Event For Content From My Watchlist Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoExitEventForContentFromMyWatchlistPage(userType,keyword);
//	}
//	
//	@Test(priority = 26)
//	public void verifyVideoExitEventForContentInMegamenu() throws Exception {
//		System.out.println("Verify Video Exit Event For Content played from Megamenu");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoExitEventForContentInMegamenu();
//	}
//	
////======================video Watch Duration======================
//	@Test(priority = 27)
//	@Parameters({ "userType", "keyword4"})
//	public void verifyVideoWatchDurationEventForFreeContentAbrupt(String userType,String keyword4) throws Exception {
//		System.out.println("Verify Video Watch Duration Event when video is closed abruptly For Free Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoWatchDurationEventForFreeContentAbrupt(userType,keyword4);
//	}
//	
//	@Test(priority = 28)
//	@Parameters({ "userType"})
//	public void verifyVideoWatchDurationEventForPremiumContentAbrupt(String userType) throws Exception {
//		System.out.println("Verify Video Watch Duration when video is closed abruptly Event For Premium Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoWatchDurationEventForPremiumContentAbrupt(userType,"Home");
//	}
//	
//	@Test(priority = 29)
//	@Parameters({ "userType", "keyword1"})
//	public void verifyVideoWatchDurationEventForTrailerAbrupt(String userType,String keyword1) throws Exception {
//		System.out.println("Verify Video Watch Duration Event when video is closed abruptly For Trailer Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoWatchDurationEventForTrailerAbrupt(userType,keyword1);
//	}
//	
//	@Test(priority = 30)
//	public void verifyVideoWatchDurationEventForCarouselContentAbrupt() throws Exception {
//		System.out.println("Verify Video Watch Duration Event when video is closed abruptly For Carousel Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoWatchDurationEventForCarouselContentAbrupt();
//	}
//	
//	@Test(priority = 31)
//	public void verifyVideoWatchDurationEventForContentInTrayAbrupt() throws Exception {
//		System.out.println("Verify Video Watch Duration Event when video is closed abruptly For Content played from Tray");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoWatchDurationEventForContentInTrayAbrupt();
//	}
//	
//	@Test(priority = 32)
//	@Parameters({"keyword1"})
//	public void verifyVideoWatchDurationEventForContentFromSearchPageAbrupt(String keyword1) throws Exception {
//		System.out.println("Verify Video Watch Duration Event when video is closed abruptly For Content From Search Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoWatchDurationEventForContentFromSearchPageAbrupt(keyword1);
//	}
//	
//	@Test(priority = 33)
//	@Parameters({ "userType", "keyword"})
//	public void verifyVideoWatchDurationEventForContentFromMyWatchlistPageAbrupt(String userType,String keyword) throws Exception {
//		System.out.println("Verify Video Watch Duration Event when video is closed abruptly For Content From My Watchlist Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoWatchDurationEventForContentFromMyWatchlistPageAbrupt(userType,keyword);
//	}
//	
//	@Test(priority = 34)
//	public void verifyVideoWatchDurationEventForContentInMegamenuAbrupt() throws Exception {
//		System.out.println("Verify Video Watch Duration Event when video is closed abruptly For Content played from Megamenu");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoWatchDurationEventForContentInMegamenuAbrupt();
//	}
//	
//	@Test(priority = 35)
//	@Parameters({ "userType", "keyword"})
//	public void verifyVideoWatchDurationEventForContentInPlaylistAbrupt(String userType,String keyword) throws Exception {
//		System.out.println("Verify Video Watch Duration Event when video is closed abruptly For Content played from Playlist");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoWatchDurationEventForContentInPlaylistAbrupt(userType,keyword);
//	}
//	
//	@Test(priority = 36)
//	@Parameters({ "userType", "keyword4"})
//	public void verifyVideoWatchDurationEventForFreeContentComplete(String userType,String keyword4) throws Exception {
//		System.out.println("Verify Video Watch Duration Event when user completely watches For Free Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoWatchDurationEventForFreeContentComplete(userType,keyword4);
//	}
//	
//	@Test(priority = 37)
//	@Parameters({ "userType"})
//	public void verifyVideoWatchDurationEventForPremiumContentComplete(String userType) throws Exception {
//		System.out.println("Verify Video Watch Duration Event when user completely watches Premium Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoWatchDurationEventForPremiumContentComplete(userType,"Home");
//	}
//	
//	@Test(priority = 38)
//	@Parameters({ "userType", "keyword1"})
//	public void verifyVideoWatchDurationEventForTrailerComplete(String userType,String keyword1) throws Exception {
//		System.out.println("Verify Video Watch Duration Event  when user completely watches Trailer Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoWatchDurationEventForTrailerComplete(userType,keyword1);
//	}
//	
//	@Test(priority = 39)
//	public void verifyVideoWatchDurationEventForCarouselContentComplete() throws Exception {
//		System.out.println("Verify Video Watch Duration Event when user completely watches Carousel Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoWatchDurationEventForCarouselContentComplete();
//	}
//	
//	@Test(priority = 40)
//	public void verifyVideoWatchDurationEventForContentInTrayComplete() throws Exception {
//		System.out.println("Verify Video Watch Duration Event when user completely watches Content played from Tray");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoWatchDurationEventForContentInTrayComplete();
//	}
//	
//	@Test(priority = 41)
//	@Parameters({"keyword1"})
//	public void verifyVideoWatchDurationEventForContentFromSearchPageComplete(String keyword1) throws Exception {
//		System.out.println("Verify Video Watch Duration Event when user completely watches Content From Search Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoWatchDurationEventForContentFromSearchPageComplete(keyword1);
//	}
//	
//	@Test(priority = 42)
//	@Parameters({ "userType", "keyword"})
//	public void verifyVideoWatchDurationEventForContentFromMyWatchlistPageComplete(String userType,String keyword) throws Exception {
//		System.out.println("Verify Video Watch Duration Event when user completely watches Content From My Watchlist Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoWatchDurationEventForContentFromMyWatchlistPageComplete(userType,keyword);
//	}
//	
//	@Test(priority = 43)
//	public void verifyVideoWatchDurationEventForContentInMegamenuComplete() throws Exception {
//		System.out.println("Verify Video Watch Duration Event when user completely watches Content played from Megamenu");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoWatchDurationEventForContentInMegamenuComplete();
//	}
//	
//	@Test(priority = 44)
//	@Parameters({ "userType", "keyword"})
//	public void verifyVideoWatchDurationEventForContentInPlaylistComplete(String userType,String keyword) throws Exception {
//		System.out.println("Verify Video Watch Duration Event when user completely watches Content played from Playlist");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoWatchDurationEventForContentInPlaylistComplete(userType,keyword);
//	}
//	
//	@Test(priority = 45)
//	@Parameters({ "userType", "keyword4"})
//	public void verifyVideoWatchDurationEventForContentFromUpnextRailComplete(String userType,String keyword4) throws Exception {
//		System.out.println("Verify Video Watch Duration Event When user completely watches the  auto-played content from Upnext rail");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoWatchDurationEventForContentFromUpnextRailComplete(userType,keyword4);
//	}
//
//	@Test(priority = 46)
//	@Parameters({ "freeContentURL"})
//	public void verifyVideoWatchDurationEventForContentFromSharedLinkComplete(String freeContentURL) throws Exception {
//		System.out.println("Verify Video Watch Duration Event when user completely watches the content playback shared through shared link");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoWatchDurationEventForContentFromSharedLinkComplete(freeContentURL);
//	}
//	
//	@Test(priority = 47)
//	@Parameters({ "userType", "keyword4"})
//	public void verifyVideoWatchDurationEventForContentFromUpnextRailAbrupt(String userType,String keyword4) throws Exception {
//		System.out.println("Verify Video Watch Duration Event when video is closed abruptly on auto-played content from Upnext rail");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoWatchDurationEventForContentFromUpnextRailAbrupt(userType,keyword4);
//	}
//	
//	@Test(priority = 48)
//	@Parameters({"freeContentURL"})
//	public void verifyVideoWatchDurationEventForContentFromSharedLinkAbrupt(String freeContentURL) throws Exception {
//		System.out.println("Verify Video Watch Duration Event when video is closed abruptly For content played from Shared Link");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoWatchDurationEventForContentFromSharedLinkAbrupt(freeContentURL);
//	}
//	
////=============AD Initialized=======================
//	@Test(priority = 49)
//	@Parameters({ "userType", "audioTrackContent"})
//	public void verifyAdInitializedEventForFreeContent(String userType,String audioTrackContent) throws Exception {
//		System.out.println("Verify Ad Initialized Event For Free Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
////		Zee5PWAWEBMixPanelBusinessLogic.verifyAdInitializedEventForFreeContent("Home","homepage",userType,"basavaraj.pn5@gmail.com","igsindia123");
//	}
//
//	@Test(priority = 50)
//	@Parameters({"userType", "keyword1"})
//	public void verifyAdInitializedEventForTrailer(String userType,String keyword1) throws Exception {
//		System.out.println("Verify Ad Initialized Event For Trailer Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdInitializedEventForTrailer(userType,keyword1);
//	}
//	
//	@Test(priority = 51)
//	@Parameters({ "userType"})
//	public void verifyAdInitializedEventForCarouselContent(String userType) throws Exception {
//		System.out.println("Verify Ad Initialized Event For Carousel Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdInitializedEventForCarouselContent(userType);
//	}
//	
//	@Test(priority = 52)
//	@Parameters({ "userType"})
//	public void verifyAdInitializedEventForContentInTray(String userType) throws Exception {
//		System.out.println("Verify Ad Initialized Event For Content played from Tray");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdInitializedEventForContentInTray(userType);
//	}
//	
//	@Test(priority = 53)
//	@Parameters({"userType","subtitleTrackContent"})
//	public void verifyAdInitializedEventForContentFromSearchPage(String userType,String subtitleTrackContent) throws Exception {
//		System.out.println("Verify Ad Initialized Event For Content From Search Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdInitializedEventForContentFromSearchPage(userType,subtitleTrackContent);
//	}
//	
//	@Test(priority = 54)
//	@Parameters({ "userType", "audioTrackContent"})
//	public void verifyAdInitializedEventForContentFromMyWatchlistPage(String userType,String audioTrackContent) throws Exception {
//		System.out.println("Verify Ad Initialized Event For Content From My Watchlist Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdInitializedEventForContentFromMyWatchlistPage(userType,audioTrackContent);
//	}
//	
//	@Test(priority = 55)
//	@Parameters({ "userType"})
//	public void verifyAdInitializedEventForContentInMegamenu(String userType) throws Exception {
//		System.out.println("Verify Ad Initialized Event For Content played from Megamenu");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdInitializedEventForContentInMegamenu(userType);
//	}
//	
//	@Test(priority = 56)
//	@Parameters({ "userType", "audioTrackContent"})
//	public void verifyAdInitializedEventForContentInPlaylist(String userType,String audioTrackContent) throws Exception {
//		System.out.println("Verify Ad Initialized Event For Content played from Playlist");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdInitializedEventForContentInPlaylist(userType,audioTrackContent);
//	}
//	
//	@Test(priority = 57)
//	@Parameters({ "userType", "audioTrackContent"})
//	public void verifyAdInitializedEventForContentFromUpnextRail(String userType,String audioTrackContent) throws Exception {
//		System.out.println("Verify Ad Initialized Event For Content played from Upnext rail");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdInitializedEventForContentFromUpnextRail(userType,audioTrackContent);
//	}
//	
//	@Test(priority = 58)
//	@Parameters({"userType","audioTrackURL"})
//	public void verifyAdInitializedEventForContentFromSharedLink(String userType,String audioTrackURL) throws Exception {
//		System.out.println("Verify Ad Initialized Event For content played from Shared Link");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdInitializedEventForContentFromSharedLink(userType,audioTrackURL);
//	}
//	
////=========Ad Viewed===================
//	@Test(priority = 59)
//	@Parameters({ "userType", "audioTrackContent"})
//	public void verifyAdViewEventForFreeContent(String userType,String audioTrackContent) throws Exception {
//		System.out.println("Verify Ad View Event For Free Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdViewEventForFreeContent(userType,audioTrackContent);
//	}
//
//	@Test(priority = 60)
//	@Parameters({ "userType","keyword1"})
//	public void verifyAdViewEventForTrailer(String userType,String keyword1) throws Exception {
//		System.out.println("Verify Ad View Event For Trailer Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdViewEventForTrailer(userType,keyword1);
//	}
//	
//	@Test(priority = 61)
//	@Parameters({ "userType"})
//	public void verifyAdViewEventForCarouselContent(String userType) throws Exception {
//		System.out.println("Verify Ad View Event For Carousel Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdViewEventForCarouselContent(userType);
//	}
//	
//	@Test(priority = 62)
//	@Parameters({ "userType"})
//	public void verifyAdViewEventForContentInTray(String userType) throws Exception {
//		System.out.println("Verify Ad View Event For Content played from Tray");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdViewEventForContentInTray(userType);
//	}
//	
//	@Test(priority = 63)
//	@Parameters({"userType","subtitleTrackContent"})
//	public void verifyAdViewEventForContentFromSearchPage(String userType,String subtitleTrackContent) throws Exception {
//		System.out.println("Verify Ad View Event For Content From Search Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdViewEventForContentFromSearchPage(userType,subtitleTrackContent);
//	}
//	
//	@Test(priority = 64)
//	@Parameters({ "userType", "audioTrackContent"})
//	public void verifyAdViewEventForContentFromMyWatchlistPage(String userType,String audioTrackContent) throws Exception {
//		System.out.println("Verify Ad View Event For Content From My Watchlist Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdViewEventForContentFromMyWatchlistPage(userType,audioTrackContent);
//	}
//	
//	@Test(priority = 65)
//	@Parameters({ "userType"})
//	public void verifyAdViewEventForContentInMegamenu(String userType) throws Exception {
//		System.out.println("Verify Ad View Event For Content played from Megamenu");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdViewEventForContentInMegamenu(userType);
//	}
//	
//	@Test(priority = 66)
//	@Parameters({ "userType", "audioTrackContent"})
//	public void verifyAdViewEventForContentInPlaylist(String userType,String audioTrackContent) throws Exception {
//		System.out.println("Verify Ad View Event For Content played from Playlist");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdViewEventForContentInPlaylist(userType,audioTrackContent);
//	}
//	
//	@Test(priority = 67)
//	@Parameters({ "userType", "audioTrackContent"})
//	public void verifyAdViewEventForContentFromUpnextRail(String userType,String audioTrackContent) throws Exception {
//		System.out.println("Verify Ad View Event For Content played from Upnext rail");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdViewEventForContentFromUpnextRail(userType,audioTrackContent);
//	}
//	
//	@Test(priority = 68)
//	@Parameters({"userType","audioTrackURL"})
//	public void verifyAdViewEventForContentFromSharedLink(String userType,String audioTrackURL) throws Exception {
//		System.out.println("Verify Ad View Event For content played from Shared Link");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdViewEventForContentFromSharedLink(userType,audioTrackURL);
//	}
//	
////======================Ad force exit========================
//	@Test(priority = 69)
//	@Parameters({ "userType", "audioTrackContent"})
//	public void verifyAdForcedExitEventForFreeContent(String userType,String audioTrackContent) throws Exception {
//		System.out.println("Verify Ad Forced Exit Event For Free Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdForcedExitEventForFreeContent(userType,audioTrackContent);
//	}
//
//	@Test(priority = 70)
//	@Parameters({"userType", "keyword1"})
//	public void verifyAdForcedExitEventForTrailer(String userType,String keyword1) throws Exception {
//		System.out.println("Verify Ad Forced Exit Event For Trailer Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdForcedExitEventForTrailer(userType,keyword1);
//	}
//	
//	@Test(priority = 71)
//	@Parameters({ "userType"})
//	public void verifyAdForcedExitEventForCarouselContent(String userType) throws Exception {
//		System.out.println("Verify Ad Forced Exit Event For Carousel Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdForcedExitEventForCarouselContent(userType);
//	}
//	
//	@Test(priority = 72)
//	@Parameters({ "userType"})
//	public void verifyAdForcedExitEventForContentInTray(String userType) throws Exception {
//		System.out.println("Verify Ad Forced Exit Event For Content played from Tray");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdForcedExitEventForContentInTray(userType);
//	}
//	
//	@Test(priority = 73)
//	@Parameters({"userType","subtitleTrackContent"})
//	public void verifyAdForcedExitEventForContentFromSearchPage(String userType,String subtitleTrackContent) throws Exception {
//		System.out.println("Verify Ad Forced Exit Event For Content From Search Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdForcedExitEventForContentFromSearchPage(userType,subtitleTrackContent);
//	}
//	
//	@Test(priority = 74)
//	@Parameters({ "userType", "audioTrackContent"})
//	public void verifyAdForcedExitEventForContentFromMyWatchlistPage(String userType,String audioTrackContent) throws Exception {
//		System.out.println("Verify Ad Forced Exit Event For Content From My Watchlist Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdForcedExitEventForContentFromMyWatchlistPage(userType,audioTrackContent);
//	}
//	
//	@Test(priority = 75)
//	@Parameters({ "userType"})
//	public void verifyAdForcedExitEventForContentInMegamenu(String userType) throws Exception {
//		System.out.println("Verify Ad Forced Exit Event For Content played from Megamenu");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdForcedExitEventForContentInMegamenu(userType);
//	}
//	
//	@Test(priority = 76)
//	@Parameters({ "userType", "audioTrackContent"})
//	public void verifyAdForcedExitEventForContentInPlaylist(String userType,String audioTrackContent) throws Exception {
//		System.out.println("Verify Ad Forced Exit Event For Content played from Playlist");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdForcedExitEventForContentInPlaylist(userType,audioTrackContent);
//	}
//	
//	@Test(priority = 77)
//	@Parameters({ "userType", "audioTrackContent"})
//	public void verifyAdForcedExitEventForContentFromUpnextRail(String userType,String audioTrackContent) throws Exception {
//		System.out.println("Verify Ad Forced Exit Event For Content played from Upnext rail");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdForcedExitEventForContentFromUpnextRail(userType,audioTrackContent);
//	}
//	
//	@Test(priority = 78)
//	@Parameters({"userType","audioTrackURL"})
//	public void verifyAdForcedExitEventForContentFromSharedLink(String userType,String audioTrackURL) throws Exception {
//		System.out.println("Verify Ad Forced Exit Event For content played from Shared Link");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdForcedExitEventForContentFromSharedLink(userType,audioTrackURL);
//	}
//	
////===============Ad Click======================================
//	@Test(priority = 79)
//	@Parameters({ "userType", "audioTrackContent"})
//	public void verifyAdClickEventForFreeContent(String userType,String audioTrackContent) throws Exception {
//		System.out.println("Verify Ad Click Event For Free Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdClickEventForFreeContent(userType,audioTrackContent);
//	}
//
//	@Test(priority = 80)
//	@Parameters({"userType", "keyword1"})
//	public void verifyAdClickEventForTrailer(String userType,String keyword1) throws Exception {
//		System.out.println("Verify Ad Click Event For Trailer Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdClickEventForTrailer(userType,keyword1);
//	}
//	
//	@Test(priority = 81)
//	@Parameters({ "userType"})
//	public void verifyAdClickEventForCarouselContent(String userType) throws Exception {
//		System.out.println("Verify Ad Click Event For Carousel Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdClickEventForCarouselContent(userType);
//	}
//	
//	@Test(priority = 82)
//	@Parameters({ "userType"})
//	public void verifyAdClickEventForContentInTray(String userType) throws Exception {
//		System.out.println("Verify Ad Click Event For Content played from Tray");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdClickEventForContentInTray(userType);
//	}
//	
//	@Test(priority = 83)
//	@Parameters({"userType","subtitleTrackContent"})
//	public void verifyAdClickEventForContentFromSearchPage(String userType,String subtitleTrackContent) throws Exception {
//		System.out.println("Verify Ad Click Event For Content From Search Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdClickEventForContentFromSearchPage(userType,subtitleTrackContent);
//	}
//	
//	@Test(priority = 84)
//	@Parameters({ "userType", "audioTrackContent"})
//	public void verifyAdClickForContentFromMyWatchlistPage(String userType,String audioTrackContent) throws Exception {
//		System.out.println("Verify Ad Click Event For Content From My Watchlist Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdClickForContentFromMyWatchlistPage(userType,audioTrackContent);
//	}
//	
//	@Test(priority = 85)
//	@Parameters({ "userType"})
//	public void verifyAdClickEventForContentInMegamenu(String userType) throws Exception {
//		System.out.println("Verify Ad Click Event For Content played from Megamenu");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdClickEventForContentInMegamenu(userType);
//	}
//	
//	@Test(priority = 86)
//	@Parameters({ "userType", "audioTrackContent"})
//	public void verifyAdClickEventForContentInPlaylist(String userType,String audioTrackContent) throws Exception {
//		System.out.println("Verify Ad Click Event For Content played from Playlist");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdClickEventForContentInPlaylist(userType,audioTrackContent);
//	}
//	
//	@Test(priority = 87)
//	@Parameters({ "userType", "audioTrackContent"})
//	public void verifyAdClickEventForContentFromUpnextRail(String userType,String audioTrackContent) throws Exception {
//		System.out.println("Verify Ad Click Event For Content played from Upnext rail");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdClickEventForContentFromUpnextRail(userType,audioTrackContent);
//	}
//	
//	@Test(priority = 88)
//	@Parameters({"userType","audioTrackURL"})
//	public void verifyAdClickEventForContentFromSharedLink(String userType,String audioTrackURL) throws Exception {
//		System.out.println("Verify Ad Click Event For content played from Shared Link");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdClickEventForContentFromSharedLink(userType,audioTrackURL);
//	}
//	
////==============Ad Watch Duration===============
//	@Test(priority = 89)
//	@Parameters({ "userType", "audioTrackContent"})
//	public void verifyAdWatchDurationEventForFreeContentForceExit(String userType,String audioTrackContent) throws Exception {
//		System.out.println("Verify Ad Watch Duration Event when user force quits the ad playback for free content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForFreeContentForceExit(userType,audioTrackContent);
//	}
//
//	@Test(priority = 90)
//	@Parameters({"userType", "keyword1"})
//	public void verifyAdWatchDurationEventForTrailerForceExit(String userType,String keyword1) throws Exception {
//		System.out.println("Verify Ad Watch Duration Event when user force quits the ad playback For Trailer Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForTrailerForceExit(userType,keyword1);
//	}
//	
//	@Test(priority = 91)
//	@Parameters({ "userType"})
//	public void verifyAdWatchDurationEventForCarouselContentForceExit(String userType) throws Exception {
//		System.out.println("Verify Ad Watch Duration Event when user force quits the ad playback For Carousel Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForCarouselContentForceExit(userType);
//	}
//	
//	@Test(priority = 92)
//	@Parameters({ "userType"})
//	public void verifyAdWatchDurationEventForContentInTrayForceExit(String userType) throws Exception {
//		System.out.println("Verify Ad Watch Duration Event when user force quits the ad playback For Content played from Tray");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentInTrayForceExit(userType);
//	}
//	
//	@Test(priority = 93)
//	@Parameters({"userType","subtitleTrackContent"})
//	public void verifyAdWatchDurationEventForContentFromSearchPageForceExit(String userType,String subtitleTrackContent) throws Exception {
//		System.out.println("Verify Ad Watch Duration Event when user force quits the ad playback For Content From Search Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentFromSearchPageForceExit(userType,subtitleTrackContent);
//	}
//	
//	@Test(priority = 94)
//	@Parameters({ "userType", "audioTrackContent"})
//	public void verifyAdWatchDurationEventForContentFromMyWatchlistPageForceExit(String userType,String audioTrackContent) throws Exception {
//		System.out.println("Verify Ad Watch Duration Event when user force quits the ad playback For Content From My Watchlist Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentFromMyWatchlistPageForceExit(userType,audioTrackContent);
//	}
//	
//	@Test(priority = 95)
//	@Parameters({ "userType"})
//	public void verifyAdWatchDurationEventForContentInMegamenuForceExit(String userType) throws Exception {
//		System.out.println("Verify Ad Watch Duration Event when user force quits the ad playback For Content played from Megamenu");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentInMegamenuForceExit(userType);
//	}
//	
//	@Test(priority = 96)
//	@Parameters({ "userType", "audioTrackContent"})
//	public void verifyAdWatchDurationEventForContentInPlaylistForceExit(String userType,String audioTrackContent) throws Exception {
//		System.out.println("Verify Ad Watch Duration Event when user force quits the ad playback For Content played from Playlist");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentInPlaylistForceExit(userType,audioTrackContent);
//	}
//	
//	@Test(priority = 97)
//	@Parameters({ "userType", "audioTrackContent"})
//	public void verifyAdWatchDurationEventForContentFromUpnextRailForceExit(String userType,String audioTrackContent) throws Exception {
//		System.out.println("Verify Ad Watch Duration Event when user force quits the ad playback For Content played from Upnext rail");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentFromUpnextRailForceExit(userType,audioTrackContent);
//	}
//	
//	@Test(priority = 98)
//	@Parameters({"userType","audioTrackURL"})
//	public void verifyAdWatchDurationEventForContentFromSharedLinkForceExit(String userType,String audioTrackURL) throws Exception {
//		System.out.println("Verify Ad Watch Duration Event when user force quits the ad playback For content played from Shared Link");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentFromSharedLinkForceExit(userType,audioTrackURL);
//	}
//	
//	@Test(priority = 99)
//	@Parameters({ "userType", "audioTrackContent"})
//	public void verifyAdWatchDurationEventForFreeContentComplete(String userType,String audioTrackContent) throws Exception {
//		System.out.println("Verify Ad Watch Duration Event when user completly watches the ad playback for free content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForFreeContentComplete(userType,audioTrackContent);
//	}
//
//	@Test(priority = 100)
//	@Parameters({"userType", "keyword1"})
//	public void verifyAdWatchDurationEventForTrailerComplete(String userType,String keyword1) throws Exception {
//		System.out.println("Verify Ad Watch Duration Event when user completly watches the ad playback For Trailer Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForTrailerComplete(userType,keyword1);
//	}
//	
//	@Test(priority = 101)
//	@Parameters({ "userType"})
//	public void verifyAdWatchDurationEventForCarouselContentComplete(String userType) throws Exception {
//		System.out.println("Verify Ad Watch Duration Event when user completly watches the ad playback For Carousel Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForCarouselContentComplete(userType);
//	}
//	
//	@Test(priority = 102)
//	@Parameters({ "userType"})
//	public void verifyAdWatchDurationEventForContentInTrayComplete(String userType) throws Exception {
//		System.out.println("Verify Ad Watch Duration Event when user completly watches the ad playback For Content played from Tray");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentInTrayComplete(userType);
//	}
//	
//	@Test(priority = 103)
//	@Parameters({"userType","subtitleTrackContent"})
//	public void verifyAdWatchDurationEventForContentFromSearchPageComplete(String userType,String subtitleTrackContent) throws Exception {
//		System.out.println("Verify Ad Watch Duration Event when user completly watches the ad playback For Content From Search Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentFromSearchPageComplete(userType,subtitleTrackContent);
//	}
//	
//	@Test(priority = 104)
//	@Parameters({ "userType", "audioTrackContent"})
//	public void verifyAdWatchDurationEventForContentFromMyWatchlistPageComplete(String userType,String audioTrackContent) throws Exception {
//		System.out.println("Verify Ad Watch Duration Event when user completly watches ad playback For Content From My Watchlist Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentFromMyWatchlistPageComplete(userType,audioTrackContent);
//	}
//	
//	@Test(priority = 106)
//	@Parameters({ "userType"})
//	public void verifyAdWatchDurationEventForContentInMegamenuComplete(String userType) throws Exception {
//		System.out.println("Verify Ad Watch Duration Event when user completly watches the ad playback For Content played from Megamenu");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentInMegamenuComplete(userType);
//	}
//	
//	@Test(priority = 107)
//	@Parameters({ "userType", "audioTrackContent"})
//	public void verifyAdWatchDurationEventForContentInPlaylistComplete(String userType,String audioTrackContent) throws Exception {
//		System.out.println("Verify Ad Watch Duration Event when user completly watches the ad playback For Content played from Playlist");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentInPlaylistComplete(userType,audioTrackContent);
//	}
//	
//	@Test(priority = 108)
//	@Parameters({ "userType", "audioTrackContent"})
//	public void verifyAdWatchDurationEventForContentFromUpnextRailComplete(String userType,String audioTrackContent) throws Exception {
//		System.out.println("Verify Ad Watch Duration Event when user completly watches the ad playback For Content played from Upnext rail");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentFromUpnextRailComplete(userType,audioTrackContent);
//	}
//	
//	@Test(priority = 109)
//	@Parameters({"userType","audioTrackURL"})
//	public void verifyAdWatchDurationEventForContentFromSharedLinkComplete(String userType,String audioTrackURL) throws Exception {
//		System.out.println("Verify Ad Watch Duration Event when user completly watches ad playback For content played from Shared Link");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentFromSharedLinkComplete(userType,audioTrackURL);
//	}
//
//	@Test(priority = 110)
//	@Parameters({ "userType", "audioTrackContent"})
//	public void verifyAdWatchDurationEventForFreeContentSkipAd(String userType,String audioTrackContent) throws Exception {
//		System.out.println("Verify Ad Watch Duration Event when user skips the ad playback for free content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForFreeContentSkipAd(userType,audioTrackContent);
//	}
//
//	@Test(priority = 111)
//	@Parameters({"userType", "keyword1"})
//	public void verifyAdWatchDurationEventForTrailerSkipAd(String userType,String keyword1) throws Exception {
//		System.out.println("Verify Ad Watch Duration Event when user skips the ad playback For Trailer Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForTrailerSkipAd(userType,keyword1);
//	}
//	
//	@Test(priority = 112)
//	@Parameters({ "userType"})
//	public void verifyAdWatchDurationEventForCarouselContentSkipAd(String userType) throws Exception {
//		System.out.println("Verify Ad Watch Duration Event when user skips the ad playback For Carousel Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForCarouselContentSkipAd(userType);
//	}
//	
//	@Test(priority = 113)
//	@Parameters({ "userType"})
//	public void verifyAdWatchDurationEventForContentInTraySkipAd(String userType) throws Exception {
//		System.out.println("Verify Ad Watch Duration Event when user skips the ad playback For Content played from Tray");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentInTraySkipAd(userType);
//	}
//	
//	@Test(priority = 114)
//	@Parameters({"userType","subtitleTrackContent"})
//	public void verifyAdWatchDurationEventForContentFromSearchPageSkipAd(String userType,String subtitleTrackContent) throws Exception {
//		System.out.println("Verify Ad Watch Duration Event when user skips the ad playback For Content From Search Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentFromSearchPageSkipAd(userType,subtitleTrackContent);
//	}
//	
//	@Test(priority = 115)
//	@Parameters({ "userType", "audioTrackContent"})
//	public void verifyAdWatchDurationEventForContentFromMyWatchlistPageSkipAd(String userType,String audioTrackContent) throws Exception {
//		System.out.println("Verify Ad Watch Duration Event when user skips ad playback For Content From My Watchlist Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentFromMyWatchlistPageSkipAd(userType,audioTrackContent);
//	}
//	
//	@Test(priority = 116)
//	@Parameters({ "userType"})
//	public void verifyAdWatchDurationEventForContentInMegamenuSkipAd(String userType) throws Exception {
//		System.out.println("Verify Ad Watch Duration Event when user skips the ad playback For Content played from Megamenu");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentInMegamenuSkipAd(userType);
//	}
//	
//	@Test(priority = 117)
//	@Parameters({ "userType", "audioTrackContent"})
//	public void verifyAdWatchDurationEventForContentInPlaylistSkipAd(String userType,String audioTrackContent) throws Exception {
//		System.out.println("Verify Ad Watch Duration Event when user skips the ad playback For Content played from Playlist");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentInPlaylistSkipAd(userType,audioTrackContent);
//	}
//	
//	@Test(priority = 118)
//	@Parameters({ "userType", "audioTrackContent"})
//	public void verifyAdWatchDurationEventForContentFromUpnextRailSkipAd(String userType,String audioTrackContent) throws Exception {
//		System.out.println("Verify Ad Watch Duration Event when user skips the ad playback For Content played from Upnext rail");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentFromUpnextRailSkipAd(userType,audioTrackContent);
//	}
//	
//	@Test(priority = 119)
//	@Parameters({"userType","audioTrackURL"})
//	public void verifyAdWatchDurationEventForContentFromSharedLinkSkipAd(String userType,String audioTrackURL) throws Exception {
//		System.out.println("Verify Ad Watch Duration Event when user skips ad playback For content played from Shared Link");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAdWatchDurationEventForContentFromSharedLinkSkipAd(userType,audioTrackURL);
//	}
//	
////===============Resume ==========================
//	@Test(priority = 200)
//	@Parameters({ "userType"})
//	public void verifyResumeEventForPremiumContent(String userType) throws Exception {
//		System.out.println("Verify Resume Event For Premium Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyResumeEventForPremiumContent(userType,"Home");
//	}
//	
//	@Test(priority = 201)
//	@Parameters({ "userType", "keyword1"})
//	public void verifyResumeEventForTrailer(String userType,String keyword1) throws Exception {
//		System.out.println("Verify Resume Event For Trailer Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyResumeEventForTrailer(userType,keyword1);
//	}
//	
//	@Test(priority = 202)
//	public void verifyResumeEventForCarouselContent() throws Exception {
//		System.out.println("Verify Resume Event For Carousel Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyResumeEventForCarouselContent();
//	}
//	
//	@Test(priority = 203)
//	public void verifyResumeEventForContentInTray() throws Exception {
//		System.out.println("Verify Resume Event For Content played from Tray");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyResumeEventForContentInTray();
//	}
//	
//	@Test(priority = 204)
//	@Parameters({"keyword1"})
//	public void verifyResumeEventForContentFromSearchPage(String keyword1) throws Exception {
//		System.out.println("Verify Resume Event For Content From Search Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyResumeEventForContentFromSearchPage(keyword1);
//	}
//	
//	@Test(priority = 205)
//	@Parameters({ "userType", "keyword"})
//	public void verifyResumeEventForContentFromMyWatchlistPage(String userType,String keyword) throws Exception {
//		System.out.println("Verify Resume Event For Content From My Watchlist Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyResumeEventForContentFromMyWatchlistPage(userType,keyword);
//	}
//	
//	@Test(priority = 206)
//	@Parameters({ "userType", "keyword"})
//	public void verifyResumeEventForContentInPlaylist(String userType,String keyword) throws Exception {
//		System.out.println("Verify Resume Event For Content played from Playlist");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyResumeEventForContentInPlaylist(userType,keyword);
//	}
//	
//	@Test(priority = 207)
//	@Parameters({ "userType", "keyword"})
//	public void verifyRemoveFromWatchlistEventFromMyWatchlistPage(String userType,String keyword) throws Exception {
//		System.out.println("Verify Remove From Watchlist Event for Content from My Watchlist page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyRemoveFromWatchlistEventFromMyWatchlistPage(userType,keyword);
//	}
//	
//	@Test(priority = 208)
//	public void verifyResumeEventForContentInMegamenu() throws Exception {
//		System.out.println("Verify Resume Event For Content played from Megamenu");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyResumeEventForContentInMegamenu();
//	}
//	
//	@Test(priority = 209)
//	public void verifyResumeEventForLinearContent() throws Exception {
//		System.out.println("Verify Resume Event For Linear Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyResumeEventForLinearContent();
//	}
//	
//	@Test(priority = 210)
//	@Parameters({ "userType", "keyword4"})
//	public void verifyResumeEventForContentFromUpnextRail(String userType,String keyword4) throws Exception {
//		System.out.println("Verify Resume Event for content autoplayed from Upnext rail");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyResumeEventForContentFromUpnextRail(userType,keyword4);
//	}
//	
//	@Test(priority = 211)
//	@Parameters({"freeContentURL"})
//	public void verifyResumeEventForContentFromSharedLink(String freeContentURL) throws Exception {
//		System.out.println("Verify Resume Event For content played from Shared Link");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyResumeEventForContentFromSharedLink(freeContentURL);
//	}
//	
////==============pause=========================
//	@Test(priority = 212)
//	@Parameters({ "userType", "keyword4"})
//	public void verifyPauseEventForFreeContent(String userType,String keyword4) throws Exception {
//		System.out.println("Verify Pause Event For Free Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyPauseEventForFreeContent(userType,keyword4);
//	}
//	
//	@Test(priority = 213)
//	@Parameters({ "userType"})
//	public void verifyPauseEventForPremiumContent(String userType) throws Exception {
//		System.out.println("Verify Pause Event For Premium Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyPauseEventForPremiumContent(userType,"Home");
//	}
//	
//	@Test(priority = 214)
//	@Parameters({ "userType", "keyword1"})
//	public void verifyPauseEventForTrailer(String userType,String keyword1) throws Exception {
//		System.out.println("Verify Pause Event For Trailer Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyPauseEventForTrailer(userType,keyword1);
//	}
//	
//	@Test(priority = 215)
//	public void verifyPauseEventForCarouselContent() throws Exception {
//		System.out.println("Verify Pause Event For Carousel Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyPauseEventForCarouselContent();
//	}
//	
//	@Test(priority = 216)
//	public void verifyPauseEventForContentInTray() throws Exception {
//		System.out.println("Verify Pause Event For Content played from Tray");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyPauseEventForContentInTray();
//	}
//	
//	@Test(priority = 217)
//	@Parameters({"keyword1"})
//	public void verifyPauseEventForContentFromSearchPage(String keyword1) throws Exception {
//		System.out.println("Verify Pause Event For Content From Search Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyPauseEventForContentFromSearchPage(keyword1);
//	}
//	
//	@Test(priority = 218)
//	@Parameters({ "userType", "keyword"})
//	public void verifyPauseEventForContentFromMyWatchlistPage(String userType,String keyword) throws Exception {
//		System.out.println("Verify Pause Event For Content From My Watchlist Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyPauseEventForContentFromMyWatchlistPage(userType,keyword);
//	}
//	
//	@Test(priority = 219)
//	@Parameters({ "userType", "keyword"})
//	public void verifyPauseEventForContentInPlaylist(String userType,String keyword) throws Exception {
//		System.out.println("Verify Pause Event For Content played from Playlist");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyPauseEventForContentInPlaylist(userType,keyword);
//	}
//	
//	@Test(priority = 220)
//	public void verifyPauseEventForLinearContent() throws Exception {
//		System.out.println("Verify Pause Event For Linear Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyPauseEventForLinearContent();
//	}
//	
//	@Test(priority = 221)
//	@Parameters({ "userType", "keyword4"})
//	public void verifyPauseEventForContentFromUpnextRail(String userType,String keyword4) throws Exception {
//		System.out.println("Verify Pause Event for content autoplayed from Upnext rail");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyPauseEventForContentFromUpnextRail(userType,keyword4);
//	}
//	
//	@Test(priority = 222)
//	@Parameters({"freeContentURL"})
//	public void verifyPauseEventForContentFromSharedLink(String freeContentURL) throws Exception {
//		System.out.println("Verify Pause Event For content played from Shared Link");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyPauseEventForContentFromSharedLink(freeContentURL);
//	}
//	
//	@Test(priority = 223)
//	public void verifyPauseEventForContentInMegamenu() throws Exception {
//		System.out.println("Verify Pause Event For Content played from Megamenu");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyPauseEventForContentInMegamenu();
//	}
//	
////================Scrubseek=========================================
//	@Test(priority = 224)
//	@Parameters({ "userType", "keyword4"})
//	public void verifyScrubSeekEventForFreeContent(String userType,String keyword4) throws Exception {
//		System.out.println("Verify Scrub/Seek Event For Free Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyScrubSeekEventForFreeContent(userType,keyword4);
//	}
//	
//	@Test(priority = 225)
//	@Parameters({ "userType"})
//	public void verifyScrubSeekEventForPremiumContent(String userType) throws Exception {
//		System.out.println("Verify Scrub/Seek Event For Premium Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyScrubSeekEventForPremiumContent(userType,"Home");
//	}
//	
//	@Test(priority = 226)
//	@Parameters({ "keyword1"})
//	public void verifyScrubSeekEventForTrailer(String keyword1) throws Exception {
//		System.out.println("Verify Scrub/Seek Event For Trailer Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyScrubSeekEventForTrailer(keyword1);
//	}
//	
//	@Test(priority = 227)
//	public void verifyScrubSeekEventForCarouselContent() throws Exception {
//		System.out.println("Verify Scrub/Seek Event For Carousel Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyScrubSeekEventForCarouselContent();
//	}
//	
//	@Test(priority = 228)
//	public void verifyScrubSeekEventForContentInTray() throws Exception {
//		System.out.println("Verify Scrub/Seek Event For Content played from Tray");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyScrubSeekEventForContentInTray();
//	}
//	
//	@Test(priority = 229)
//	@Parameters({"keyword1"})
//	public void verifyScrubSeekEventForContentFromSearchPage(String keyword1) throws Exception {
//		System.out.println("Verify Scrub/Seek Event For Content From Search Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyScrubSeekEventForContentFromSearchPage(keyword1);
//	}
//	
//	@Test(priority = 230)
//	@Parameters({ "userType", "keyword"})
//	public void verifyScrubSeekEventForContentFromMyWatchlistPage(String userType,String keyword) throws Exception {
//		System.out.println("Verify Scrub/Seek Event For Content From My Watchlist Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyScrubSeekEventForContentFromMyWatchlistPage(userType,keyword);
//	}
//	
//	@Test(priority = 231)
//	public void verifyScrubSeekEventForContentInMegamenu() throws Exception {
//		System.out.println("Verify Scrub/Seek Event For Content played from Megamenu");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyScrubSeekEventForContentInMegamenu();
//	}
//	
//	@Test(priority = 232)
//	@Parameters({ "userType", "keyword"})
//	public void verifyScrubSeekEventForContentInPlaylist(String userType,String keyword) throws Exception {
//		System.out.println("Verify Scrub/Seek Event For Content played from Playlist");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyScrubSeekEventForContentInPlaylist(userType,keyword);
//	}
//	
//	@Test(priority = 233)
//	@Parameters({ "userType", "keyword4"})
//	public void verifyScrubSeekEventForContentFromUpnextRail(String userType,String keyword4) throws Exception {
//		System.out.println("Verify Scrub/Seek Event For Content played from Upnext rail");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyScrubSeekEventForContentFromUpnextRail(userType,keyword4);
//	}
//	
//	@Test(priority = 234)
//	@Parameters({"freeContentURL"})
//	public void verifyScrubSeekEventForContentFromSharedLink(String freeContentURL) throws Exception {
//		System.out.println("Verify Scrub/Seek Event For content played from Shared Link");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyScrubSeekEventForContentFromSharedLink(freeContentURL);
//	}
//	
////===========Quality change================
//	@Test(priority = 235)
//	@Parameters({ "keyword1" })
//	public void verifyQualityChangeEvent(String keyword1) throws Exception {
//		System.out.println("Verify Quality Change Event");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyQualityChangeEvent(keyword1);
//		}
//	
//	@Test(priority = 236)
//	@Parameters({ "userType", "keyword4"})
//	public void verifyQualityChangeEventForFreeContent(String userType,String keyword4) throws Exception {
//		System.out.println("Verify Quality Change Event For Free Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyQualityChangeEventForFreeContent(userType,keyword4);
//	}
//	
//	@Test(priority = 237)
//	@Parameters({ "userType"})
//	public void verifyQualityChangeEventForPremiumContent(String userType) throws Exception {
//		System.out.println("Verify Quality Change Event For Premium Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyQualityChangeEventForPremiumContent(userType,"Home");
//	}
//	
//	@Test(priority = 238)
//	@Parameters({ "keyword1"})
//	public void verifyQualityChangeEventForTrailer(String keyword1) throws Exception {
//		System.out.println("Verify Quality Change Event For Trailer Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyQualityChangeEventForTrailer(keyword1);
//	}
//	
//	@Test(priority = 239)
//	public void verifyQualityChangeEventForCarouselContent() throws Exception {
//		System.out.println("Verify Quality Change Event For Carousel Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyQualityChangeEventForCarouselContent();
//	}
//	
//	@Test(priority = 240)
//	public void verifyQualityChangeEventForContentInTray() throws Exception {
//		System.out.println("Verify Quality Change Event For Content played from Tray");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyQualityChangeEventForContentInTray();
//	}
//	
//	@Test(priority = 241)
//	@Parameters({"keyword1"})
//	public void verifyQualityChangeEventForContentFromSearchPage(String keyword1) throws Exception {
//		System.out.println("Verify Quality Change Event For Content From Search Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyQualityChangeEventForContentFromSearchPage(keyword1);
//	}
//	
//	@Test(priority = 242)
//	@Parameters({ "userType", "keyword"})
//	public void verifyQualityChangeEventForContentFromMyWatchlistPage(String userType,String keyword) throws Exception {
//		System.out.println("Verify Quality Change Event For Content From My Watchlist Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyQualityChangeEventForContentFromMyWatchlistPage(userType,keyword);
//	}
//	
//	@Test(priority = 243)
//	public void verifyQualityChangeEventForContentInMegamenu() throws Exception {
//		System.out.println("Verify Quality Change Event For Content played from Megamenu");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyQualityChangeEventForContentInMegamenu();
//	}
//	
//	@Test(priority = 244)
//	@Parameters({ "userType", "keyword"})
//	public void verifyQualityChangeEventForContentInPlaylist(String userType,String keyword) throws Exception {
//		System.out.println("Verify Quality Change Event For Content played from Playlist");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyQualityChangeEventForContentInPlaylist(userType,keyword);
//	}
//	
//	@Test(priority = 245)
//	@Parameters({ "userType", "keyword4"})
//	public void verifyQualityChangeEventForContentFromUpnextRail(String userType,String keyword4) throws Exception {
//		System.out.println("Verify Quality Change Event For Content played from Upnext rail");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyQualityChangeEventForContentFromUpnextRail(userType,keyword4);
//	}
//	
//	@Test(priority = 246)
//	@Parameters({"freeContentURL"})
//	public void verifyQualityChangeEventForContentFromSharedLink(String freeContentURL) throws Exception {
//		System.out.println("Verify Quality Change Event For content played from Shared Link");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyQualityChangeEventForContentFromSharedLink(freeContentURL);
//	}
//	
//	@Test(priority = 247)
//	public void verifyQualityChangeEventForLinearContent() throws Exception {
//		System.out.println("Verify Quality Change Event For Linear Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyQualityChangeEventForLinearContent();
//	}
//	
////============Audio Language=================
//	@Test(priority = 248)
//	@Parameters({ "userType", "audioTrackContent"})
//	public void verifyAudioLanguageChangeEventForFreeContent(String userType,String audioTrackContent) throws Exception {
//		System.out.println("Verify Audio Language Change Event For Free Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAudioLanguageChangeEventForFreeContent(userType,audioTrackContent);
//	}
//	
//	@Test(priority = 249)
//	@Parameters({ "userType"})
//	public void verifyAudioLanguageChangeEventForPremiumContent(String userType) throws Exception {
//		System.out.println("Verify Audio Language Change Event For Premium Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAudioLanguageChangeEventForPremiumContent(userType,"Home");
//	}
//	
//	@Test(priority = 250)
//	@Parameters({ "keyword1"})
//	public void verifyAudioLanguageChangeEventForTrailer(String audioTrackTrailerContent) throws Exception {
//		System.out.println("Verify Audio Language Change Event For Trailer Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAudioLanguageChangeEventForTrailer(audioTrackTrailerContent);
//	}
//	
//	@Test(priority = 251)
//	public void verifyAudioLanguageChangeEventForCarouselContent() throws Exception {
//		System.out.println("Verify Audio Language Change Event For Carousel Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAudioLanguageChangeEventForCarouselContent();
//	}
//	
//	@Test(priority = 252)
//	public void verifyAudioLanguageChangeEventForContentInTray() throws Exception {
//		System.out.println("Verify Audio Language Change Event For Content played from Tray");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAudioLanguageChangeEventForContentInTray();
//	}
//	
//	@Test(priority = 253)
//	@Parameters({"audioTrackContent"})
//	public void verifyAudioLanguageChangeEventForContentFromSearchPage(String audioTrackContent) throws Exception {
//		System.out.println("Verify Audio Language Change Event For Content From Search Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAudioLanguageChangeEventForContentFromSearchPage(audioTrackContent);
//	}
//	
//	@Test(priority = 254)
//	@Parameters({ "userType", "audioTrackContent"})
//	public void verifyAudioLanguageChangeEventForContentFromMyWatchlistPage(String userType,String audioTrackContent) throws Exception {
//		System.out.println("Verify Audio Language Change Event For Content From My Watchlist Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAudioLanguageChangeEventForContentFromMyWatchlistPage(userType,audioTrackContent);
//	}
//	
//	@Test(priority = 255)
//	public void verifyAudioLanguageChangeEventForContentInMegamenu() throws Exception {
//		System.out.println("Verify Audio Language Change Event For Content played from Megamenu");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAudioLanguageChangeEventForContentInMegamenu();
//	}
//	
//	@Test(priority = 256)
//	@Parameters({ "userType", "audioTrackContent"})
//	public void verifyAudioLanguageChangeEventForContentInPlaylist(String userType,String audioTrackContent) throws Exception {
//		System.out.println("Verify Audio Language Change Event For Content played from Playlist");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAudioLanguageChangeEventForContentInPlaylist(userType,audioTrackContent);
//	}
//	
//	@Test(priority = 257)
//	@Parameters({ "userType", "audioTrackContent"})
//	public void verifyAudioLanguageChangeEventForContentFromUpnextRail(String userType,String audioTrackContent) throws Exception {
//		System.out.println("Verify Audio Language Change Event For Content played from Upnext rail");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAudioLanguageChangeEventForContentFromUpnextRail(userType,audioTrackContent);
//	}
//	
//	@Test(priority = 258)
//	@Parameters({"audioTrackURL"})
//	public void verifyAudioLanguageChangeEventForContentFromSharedLink(String audioTrackURL) throws Exception {
//		System.out.println("Verify Audio Language Change Event For content played from Shared Link");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAudioLanguageChangeEventForContentFromSharedLink(audioTrackURL);
//	}
//	
////===============SubtaitleLanguage================
//	@Test(priority = 259)
//	@Parameters({ "userType", "subtitleTrackContent"})
//	public void verifySubtitleLanguageChangeEventForFreeContent(String userType,String subtitleTrackContent) throws Exception {
//		System.out.println("Verify Subtitle Language Change Event For Free Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifySubtitleLanguageChangeEventForFreeContent(userType,subtitleTrackContent);
//	}
//	
//	@Test(priority = 260)
//	@Parameters({ "userType"})
//	public void verifySubtitleLanguageChangeEventForPremiumContent(String userType) throws Exception {
//		System.out.println("Verify Subtitle Language Change Event For Premium Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifySubtitleLanguageChangeEventForPremiumContent(userType,"Home");
//	}
//	
//	@Test(priority = 261)
//	@Parameters({ "keyword5"})
//	public void verifySubtitleLanguageChangeEventForTrailer(String keyword5) throws Exception {
//		System.out.println("Verify Subtitle Language Change Event For Trailer Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifySubtitleLanguageChangeEventForTrailer(keyword5);
//	}
//	
//	@Test(priority = 262)
//	public void verifySubtitleLanguageChangeEventForCarouselContent() throws Exception {
//		System.out.println("Verify Subtitle Language Change Event For Carousel Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifySubtitleLanguageChangeEventForCarouselContent();
//	}
//	
//	@Test(priority = 263)
//	public void verifySubtitleLanguageChangeEventForContentInTray() throws Exception {
//		System.out.println("Verify Subtitle Language Change Event For Content played from Tray");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifySubtitleLanguageChangeEventForContentInTray();
//	}
//	
//	@Test(priority = 264)
//	@Parameters({"subtitleTrackContent"})
//	public void verifySubtitleLanguageChangeEventForContentFromSearchPage(String subtitleTrackContent) throws Exception {
//		System.out.println("Verify Subtitle Language Change Event For Content From Search Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifySubtitleLanguageChangeEventForContentFromSearchPage(subtitleTrackContent);
//	}
//	
//	@Test(priority = 265)
//	@Parameters({ "userType", "subtitleTrackContent"})
//	public void verifySubtitleLanguageChangeEventForContentFromMyWatchlistPage(String userType,String subtitleTrackContent) throws Exception {
//		System.out.println("Verify Subtitle Language Change Event For Content From My Watchlist Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifySubtitleLanguageChangeEventForContentFromMyWatchlistPage(userType,subtitleTrackContent);
//	}
//	
//	@Test(priority = 266)
//	public void verifySubtitleLanguageChangeEventForContentInMegamenu() throws Exception {
//		System.out.println("Verify Subtitle Language Change Event For Content played from Megamenu");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifySubtitleLanguageChangeEventForContentInMegamenu();
//	}
//	
//	@Test(priority = 267)
//	@Parameters({ "userType", "subtitleTrackContent"})
//	public void verifySubtitleLanguageChangeEventForContentInPlaylist(String userType,String subtitleTrackContent) throws Exception {
//		System.out.println("Verify Subtitle Language Change Event For Content played from Playlist");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifySubtitleLanguageChangeEventForContentInPlaylist(userType,subtitleTrackContent);
//	}
//	
//	@Test(priority = 268)
//	@Parameters({ "userType", "subtitleTrackContent"})
//	public void verifySubtitleLanguageChangeEventForContentFromUpnextRail(String userType,String subtitleTrackContent) throws Exception {
//		System.out.println("Verify Subtitle Language Change Event For Content played from Upnext rail");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifySubtitleLanguageChangeEventForContentFromUpnextRail(userType,subtitleTrackContent);
//	}
//	
//	@Test(priority = 269)
//	@Parameters({"audioTrackURL"})
//	public void verifySubtitleLanguageChangeEventForContentFromSharedLink(String subtitleTrackURL) throws Exception {
//		System.out.println("Verify Subtitle Language Change Event For content played from Shared Link");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifySubtitleLanguageChangeEventForContentFromSharedLink(subtitleTrackURL);
//	}
//	
////================Skip Intro=========================
//	@Test(priority = 270)
//	@Parameters({ "userType", "freeMovie2"})
//	public void verifySkipIntroEventForFreeContent(String userType,String freeMovie2) throws Exception {
//		System.out.println("Verify Skip Intro Event For Free Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifySkipIntroEventForFreeContent(userType,freeMovie2);
//	}
//	
//	@Test(priority = 271)
//	@Parameters({ "userType"})
//	public void verifySkipIntroEventForPremiumContent(String userType) throws Exception {
//		System.out.println("Verify Skip Intro Event For Premium Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifySkipIntroEventForPremiumContent(userType,"Home");
//	}
//	
//	@Test(priority = 272)
//	@Parameters({ "keyword5"})
//	public void verifySkipIntroEventForTrailer(String keyword5) throws Exception {
//		System.out.println("Verify Skip Intro Event For Trailer Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifySkipIntroEventForTrailer(keyword5);
//	}
//	
//	@Test(priority = 273)
//	public void verifySkipIntroEventForCarouselContent() throws Exception {
//		System.out.println("Verify Skip Intro Event For Carousel Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifySkipIntroEventForCarouselContent();
//	}
//	
//	@Test(priority = 274)
//	public void verifySkipIntroEventForContentInTray() throws Exception {
//		System.out.println("Verify Skip Intro Event For Content played from Tray");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifySkipIntroEventForContentInTray();
//	}
//	
//	@Test(priority = 275)
//	@Parameters({"freeMovie2"})
//	public void verifySkipIntroEventForContentFromSearchPage(String freeMovie2) throws Exception {
//		System.out.println("Verify Skip Intro Event For Content From Search Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifySkipIntroEventForContentFromSearchPage(freeMovie2);
//	}
//	
//	@Test(priority = 276)
//	@Parameters({ "userType", "freeMovie2"})
//	public void verifySkipIntroEventForContentFromMyWatchlistPage(String userType,String freeMovie2) throws Exception {
//		System.out.println("Verify Skip Intro Event For Content From My Watchlist Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifySkipIntroEventForContentFromMyWatchlistPage(userType,freeMovie2);
//	}
//	
//	@Test(priority = 277)
//	public void verifySkipIntroEventForContentInMegamenu() throws Exception {
//		System.out.println("Verify Skip Intro Event For Content played from Megamenu");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifySkipIntroEventForContentInMegamenu();
//	}
//	
//	@Test(priority = 278)
//	@Parameters({ "userType", "freeMovie2"})
//	public void verifySkipIntroEventForContentInPlaylist(String userType,String freeMovie2) throws Exception {
//		System.out.println("Verify Skip Intro Event For Content played from Playlist");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifySkipIntroEventForContentInPlaylist(userType,freeMovie2);
//	}
//	
//	@Test(priority = 279)
//	@Parameters({ "userType", "freeMovie2"})
//	public void verifySkipIntroEventForContentFromUpnextRail(String userType,String freeMovie2) throws Exception {
//		System.out.println("Verify Skip Intro Event For Content played from Upnext rail");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifySkipIntroEventForContentFromUpnextRail(userType,freeMovie2);
//	}
//	
//	@Test(priority = 280)
//	@Parameters({"skipIntroURL"})
//	public void verifySkipIntroEventForContentFromSharedLink(String skipIntroURL) throws Exception {
//		System.out.println("Verify Skip Intro Event For content played from Shared Link");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifySkipIntroEventForContentFromSharedLink(skipIntroURL);
//	}
//	
////============Auto Seek=====================
//	@Test(priority = 281)
//	@Parameters({ "userType", "keyword4"})
//	public void verifyAutoSeekForwardEventForFreeContent(String userType,String keyword4) throws Exception {
//		System.out.println("Verify Auto Seek Forward Event For Free Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekForwardEventForFreeContent(userType,keyword4);
//	}
//	
//	@Test(priority = 282)
//	@Parameters({ "userType"})
//	public void verifyAutoSeekForwardEventForPremiumContent(String userType) throws Exception {
//		System.out.println("Verify Auto Seek Forward Event For Premium Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekForwardEventForPremiumContent(userType,"Home");
//	}
//	
//	@Test(priority = 283)
//	@Parameters({ "keyword1"})
//	public void verifyAutoSeekForwardEventForTrailer(String keyword1) throws Exception {
//		System.out.println("Verify Auto Seek Forward Event For Trailer Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekForwardEventForTrailer(keyword1);
//	}
//	
//	@Test(priority = 284)
//	public void verifyAutoSeekForwardEventForCarouselContent() throws Exception {
//		System.out.println("Verify Auto Seek Forward Event For Carousel Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekForwardEventForCarouselContent();
//	}
//	
//	@Test(priority = 285)
//	public void verifyAutoSeekForwardEventForContentInTray() throws Exception {
//		System.out.println("Verify Auto Seek Forward Event For Content played from Tray");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekForwardEventForContentInTray();
//	}
//	
//	@Test(priority = 286)
//	@Parameters({"keyword1"})
//	public void verifyAutoSeekForwardEventForContentFromSearchPage(String keyword1) throws Exception {
//		System.out.println("Verify Auto Seek Forward Event For Content From Search Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekForwardEventForContentFromSearchPage(keyword1);
//	}
//	
//	@Test(priority = 287)
//	@Parameters({ "userType", "keyword"})
//	public void verifyAutoSeekForwardEventForContentFromMyWatchlistPage(String userType,String keyword) throws Exception {
//		System.out.println("Verify Auto Seek Forward Event For Content From My Watchlist Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekForwardEventForContentFromMyWatchlistPage(userType,keyword);
//	}
//	
//	@Test(priority = 288)
//	public void verifyAutoSeekForwardEventForContentInMegamenu() throws Exception {
//		System.out.println("Verify Auto Seek Forward Event For Content played from Megamenu");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekForwardEventForContentInMegamenu();
//	}
//	
//	@Test(priority = 289)
//	@Parameters({ "userType", "keyword"})
//	public void verifyAutoSeekForwardEventForContentInPlaylist(String userType,String keyword) throws Exception {
//		System.out.println("Verify Auto Seek Forward Event For Content played from Playlist");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekForwardEventForContentInPlaylist(userType,keyword);
//	}
//	
//	@Test(priority = 290)
//	@Parameters({ "userType", "keyword4"})
//	public void verifyAutoSeekForwardEventForContentFromUpnextRail(String userType,String keyword4) throws Exception {
//		System.out.println("Verify Auto Seek Forward Event For Content played from Upnext rail");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekForwardEventForContentFromUpnextRail(userType,keyword4);
//	}
//	
//	@Test(priority = 291)
//	@Parameters({"freeContentURL"})
//	public void verifyAutoSeekForwardEventForContentFromSharedLink(String freeContentURL) throws Exception {
//		System.out.println("Verify Auto Seek Forward Event For content played from Shared Link");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekForwardEventForContentFromSharedLink(freeContentURL);
//	}
//	
//	@Test(priority = 292)
//	@Parameters({ "userType", "keyword4"})
//	public void verifyAutoSeekRewindEventForFreeContent(String userType,String keyword4) throws Exception {
//		System.out.println("Verify Auto Seek Rewind Event For Free Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekRewindEventForFreeContent(userType,keyword4);
//	}
//	
//	@Test(priority = 293)
//	@Parameters({ "userType"})
//	public void verifyAutoSeekRewindEventForPremiumContent(String userType) throws Exception {
//		System.out.println("Verify Auto Seek Rewind Event For Premium Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekRewindEventForPremiumContent(userType,"Home");
//	}
//	
//	@Test(priority = 294)
//	@Parameters({ "keyword1"})
//	public void verifyAutoSeekRewindEventForTrailer(String keyword1) throws Exception {
//		System.out.println("Verify Auto Seek Rewind Event For Trailer Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekRewindEventForTrailer(keyword1);
//	}
//	
//	@Test(priority = 295)
//	public void verifyAutoSeekRewindEventForCarouselContent() throws Exception {
//		System.out.println("Verify Auto Seek Rewind Event For Carousel Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekRewindEventForCarouselContent();
//	}
//	
//	@Test(priority = 296)
//	public void verifyAutoSeekRewindEventForContentInTray() throws Exception {
//		System.out.println("Verify Auto Seek Rewind Event For Content played from Tray");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekRewindEventForContentInTray();
//	}
//	
//	@Test(priority = 297)
//	@Parameters({"keyword1"})
//	public void verifyAutoSeekRewindEventForContentFromSearchPage(String keyword1) throws Exception {
//		System.out.println("Verify Auto Seek Rewind Event For Content From Search Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekRewindEventForContentFromSearchPage(keyword1);
//	}
//	
//	@Test(priority = 298)
//	@Parameters({ "userType", "keyword"})
//	public void verifyAutoSeekRewindEventForContentFromMyWatchlistPage(String userType,String keyword) throws Exception {
//		System.out.println("Verify Auto Seek Rewind Event For Content From My Watchlist Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekRewindEventForContentFromMyWatchlistPage(userType,keyword);
//	}
//	
//	@Test(priority = 299)
//	public void verifyAutoSeekRewindEventForContentInMegamenu() throws Exception {
//		System.out.println("Verify Auto Seek Rewind Event For Content played from Megamenu");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekRewindEventForContentInMegamenu();
//	}
//	
//	@Test(priority = 300)
//	@Parameters({ "userType", "keyword"})
//	public void verifyAutoSeekRewindEventForContentInPlaylist(String userType,String keyword) throws Exception {
//		System.out.println("Verify Auto Seek Rewind Event For Content played from Playlist");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekRewindEventForContentInPlaylist(userType,keyword);
//	}
//	
//	@Test(priority = 301)
//	@Parameters({ "userType", "keyword4"})
//	public void verifyAutoSeekRewindEventForContentFromUpnextRail(String userType,String keyword4) throws Exception {
//		System.out.println("Verify Auto Seek Rewind Event For Content played from Upnext rail");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekRewindEventForContentFromUpnextRail(userType,keyword4);
//	}
//	
//	@Test(priority = 302)
//	@Parameters({"freeContentURL"})
//	public void verifyAutoSeekRewindEventForContentFromSharedLink(String freeContentURL) throws Exception {
//		System.out.println("Verify Auto Seek Rewind Event For content played from Shared Link");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyAutoSeekRewindEventForContentFromSharedLink(freeContentURL);
//	}
//	
////==========Mute Change===========
//	@Test(priority = 303)
//	public void verifyMuteChangedEventForNewsContent() throws Exception {
//		System.out.println("Verify Mute Changed Event");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyMuteChangedEventForNewsContent();
//	}
//	
//	@Test(priority = 304)
//	@Parameters({"keyword1"})
//	public void verifyMuteChangedEventDuringContentPlayback(String keyword1) throws Exception {
//		System.out.println("Verify Mute Changed Event During Content Playback");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyMuteChangedEventDuringContentPlayback(keyword1);
//	}
////=============Parent overlay=================
//	@Test(priority = 305)
//	@Parameters({ "userType", "keyword4"})
//	public void verifyParentalOverlayImpressionEventForFreeContent(String userType,String keyword4) throws Exception {
//		System.out.println("Verify Parental Overlay Impression Event For Free Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayImpressionEventForFreeContent(userType,keyword4);
//	}
//	
//	@Test(priority = 306)
//	@Parameters({ "userType"})
//	public void verifyParentalOverlayImpressionEventForPremiumContent(String userType) throws Exception {
//		System.out.println("Verify Parental Overlay Impression Event For Premium Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayImpressionEventForPremiumContent(userType,"Home");
//	}
//	
//	@Test(priority = 307)
//	@Parameters({ "keyword1", "userType"})
//	public void verifyParentalOverlayImpressionEventForTrailer(String keyword1,String userType) throws Exception {
//		System.out.println("Verify Parental Overlay Impression Event For Trailer Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayImpressionEventForTrailer(keyword1,userType);
//	}
//	
//	@Test(priority = 308)
//	@Parameters({ "userType"})
//	public void verifyParentalOverlayImpressionEventForCarouselContent(String userType) throws Exception {
//		System.out.println("Verify Parental Overlay Impression Event For Carousel Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayImpressionEventForCarouselContent(userType);
//	}
//	
//	@Test(priority = 309)
//	@Parameters({ "userType"})
//	public void verifyParentalOverlayImpressionEventForContentInTray(String userType) throws Exception {
//		System.out.println("Verify Parental Overlay Impression Event For Content played from Tray");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayImpressionEventForContentInTray(userType);
//	}
//	
//	@Test(priority = 310)
//	@Parameters({"keyword1", "userType"})
//	public void verifyParentalOverlayImpressionEventForContentFromSearchPage(String keyword1,String userType) throws Exception {
//		System.out.println("Verify Parental Overlay Impression Event For Content From Search Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayImpressionEventForContentFromSearchPage(keyword1,userType);
//	}
//	
//	@Test(priority = 311)
//	@Parameters({ "userType", "keyword"})
//	public void verifyParentalOverlayImpressionEventForContentFromMyWatchlistPage(String userType,String keyword) throws Exception {
//		System.out.println("Verify Parental Overlay Impression Event For Content From My Watchlist Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayImpressionEventForContentFromMyWatchlistPage(userType,keyword);
//	}
//	
//	@Test(priority = 312)
//	@Parameters({ "userType"})
//	public void verifyParentalOverlayImpressionEventForContentInMegamenu(String userType) throws Exception {
//		System.out.println("Verify Parental Overlay Impression Event For Content played from Megamenu");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayImpressionEventForContentInMegamenu(userType);
//	}
//	
//	@Test(priority = 313)
//	@Parameters({ "userType", "keyword"})
//	public void verifyParentalOverlayImpressionEventForContentInPlaylist(String userType,String keyword) throws Exception {
//		System.out.println("Verify Parental Overlay Impression Event For Content played from Playlist");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayImpressionEventForContentInPlaylist(userType,keyword);
//	}
//	
//	@Test(priority = 314)
//	@Parameters({ "userType", "keyword4"})
//	public void verifyParentalOverlayImpressionEventForContentFromUpnextRail(String userType,String keyword4) throws Exception {
//		System.out.println("Verify Parental Overlay Impression Event For Content played from Upnext rail");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayImpressionEventForContentFromUpnextRail(userType,keyword4);
//	}
//	
//	@Test(priority = 315)
//	@Parameters({"freeContentURL", "userType"})
//	public void verifyParentalOverlayImpressionEventForContentFromSharedLink(String freeContentURL,String userType) throws Exception {
//		System.out.println("Verify Parental Overlay Impression Event For content played from Shared Link");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayImpressionEventForContentFromSharedLink(freeContentURL,userType);
//	}
//	
//	@Test(priority = 316)
//	@Parameters({"keyword1", "userType"})
//	public void verifyParentalOverlayImpressionEventAfterPageRefresh(String keyword1,String userType) throws Exception {
//		System.out.println("Verify Parental Overlay Impression Event after refreshing the page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayImpressionEventAfterPageRefresh(keyword1,userType);
//	}
////=============Parent overlay result============
//	@Test(priority = 317)
//	@Parameters({ "userType", "keyword4"})
//	public void verifyParentalOverlayResultEventForFreeContent(String userType,String keyword4) throws Exception {
//		System.out.println("Verify Parental Overlay Result Event For Free Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayResultEventForFreeContent(userType,keyword4);
//	}
//	
//	@Test(priority = 318)
//	@Parameters({ "userType"})
//	public void verifyParentalOverlayResultEventForPremiumContent(String userType) throws Exception {
//		System.out.println("Verify Parental Overlay Result Event For Premium Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayResultEventForPremiumContent(userType,"Home");
//	}
//	
//	@Test(priority = 319)
//	@Parameters({ "keyword1",  "userType"})
//	public void verifyParentalOverlayResultEventForTrailer(String keyword1,String userType) throws Exception {
//		System.out.println("Verify Parental Overlay Result Event For Trailer Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayResultEventForTrailer(keyword1,userType);
//	}
//	
////	@Test(priority = 320)
//	@Parameters({ "userType"})
//	public void verifyParentalOverlayResultEventForCarouselContent(String userType) throws Exception {
//		System.out.println("Verify Parental Overlay Result Event For Carousel Content");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayResultEventForCarouselContent(userType);
//	}
//	
////	@Test(priority = 321)
//	@Parameters({ "userType"})
//	public void verifyParentalOverlayResultEventForContentInTray(String userType) throws Exception {
//		System.out.println("Verify Parental Overlay Result Event For Content played from Tray");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayResultEventForContentInTray(userType);
//	}
//	
////	@Test(priority = 322)
//	@Parameters({"keyword1", "userType"})
//	public void verifyParentalOverlayResultEventForContentFromSearchPage(String keyword1,String userType) throws Exception {
//		System.out.println("Verify Parental Overlay Result Event For Content From Search Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayResultEventForContentFromSearchPage(keyword1,userType);
//	}
//	
////	@Test(priority = 323)
//	@Parameters({ "userType", "keyword"})
//	public void verifyParentalOverlayResultEventForContentFromMyWatchlistPage(String userType,String keyword) throws Exception {
//		System.out.println("Verify Parental Overlay Result Event For Content From My Watchlist Page");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayResultEventForContentFromMyWatchlistPage(userType,keyword);
//	}
//	
////	@Test(priority = 324)
//	@Parameters({ "userType"})
//	public void verifyParentalOverlayResultEventForContentInMegamenu(String userType) throws Exception {
//		System.out.println("Verify Parental Overlay Result Event For Content played from Megamenu");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayResultEventForContentInMegamenu(userType);
//	} 
//	
////	@Test(priority = 325)
//	@Parameters({ "userType", "keyword"})
//	public void verifyParentalOverlayResultEventForContentInPlaylist(String userType,String keyword) throws Exception {
//		System.out.println("Verify Parental Overlay Result Event For Content played from Playlist");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayResultEventForContentInPlaylist(userType,keyword);
//	}
//	
////	@Test(priority = 326)
//	@Parameters({ "userType", "keyword4"})
//	public void verifyParentalOverlayResultEventForContentFromUpnextRail(String userType,String keyword4) throws Exception {
//		System.out.println("Verify Parental Overlay Result Event For Content played from Upnext rail");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayResultEventForContentFromUpnextRail(userType,keyword4);
//	}
//	
////	@Test(priority = 327)
//	@Parameters({"freeContentURL" ,"userType"})
//	public void verifyParentalOverlayResultEventForContentFromSharedLink(String freeContentURL,String userType) throws Exception {
//		System.out.println("Verify Parental Overlay Result Event For content played from Shared Link");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
//		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayResultEventForContentFromSharedLink(freeContentURL,userType);
//	}
	
	@AfterClass
	public void tearDown() {
		Zee5PWAWEBMixPanelBusinessLogic.tearDown();
	}
}

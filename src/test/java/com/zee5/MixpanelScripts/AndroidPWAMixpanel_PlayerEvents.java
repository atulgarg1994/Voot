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
		Zee5PWAMixPanelAndroidBusinessLogic.ZeePWALogin("E-mail",userType);
	}
	
	@Test(priority = 2)
	public void verifyBannerAutoplayEventForNewsContent() throws Exception {
		System.out.println("Verify Banner Autoplay Event");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyBannerAutoplayEventForNewsContent();
	}
	
	@Test(priority = 3)
	@Parameters({ "userType"})
	public void verifyVideoViewEventForFreeContent(String userType) throws Exception {
		System.out.println("Verify Video View Event For Free Content");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoViewEventForFreeContent("Home","home",userType,"basavaraj.pn5@gmail.com","igsindia123");
	}
	
	@Test(priority = 4)
	@Parameters({ "userType"})
	public void verifyVideoViewEventForPremiumContent(String userType) throws Exception {
		System.out.println("Verify Video View Event For Premium Content");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoViewEventForPremiumContent(userType,"Home");
	}
	
	@Test(priority = 5)
	@Parameters({ "keyword1"})
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
	@Parameters({"keyword1"})
	public void verifyVideoViewEventForContentFromSearchPage(String keyword1) throws Exception {
		System.out.println("Verify Video View Event For Content From Search Page");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoViewEventForContentFromSearchPage(keyword1);
	}
	
	@Test(priority = 9)
	@Parameters({ "userType", "keyword"})
	public void verifyVideoViewEventForContentFromMyWatchlistPage(String userType,String keyword) throws Exception {
		System.out.println("Verify Video View Event For Content From My Watchlist Page");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoViewEventForContentFromMyWatchlistPage(userType,keyword);
	}
	
	@Test(priority = 10)
	@Parameters({ "userType", "keyword4"})
	public void verifyVideoViewEventForContentFromUpnextRail(String userType,String keyword4) throws Exception {
		System.out.println("Verify Video View Event for content autoplayed from Upnext rail");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoViewEventForContentFromUpnextRail(userType,keyword4);
	}
	
	@Test(priority = 11)
	@Parameters({"freeContentURL"})
	public void verifyVideoViewEventForContentFromSharedLink(String freeContentURL) throws Exception {
		System.out.println("Verify Video View Event For content played from Shared Link");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoViewEventForContentFromSharedLink(freeContentURL);
	}	
	
	@Test(priority = 12)
	@Parameters({ "userType", "keyword"})
	public void verifyVideoViewEventForContentInPlaylist(String userType,String keyword) throws Exception {
		System.out.println("Verify Video View Event For Content played from Playlist");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoViewEventForContentInPlaylist(userType,keyword);
	}
	
	@Test(priority = 13)
	public void verifyVideoViewEventForContentInMegamenu() throws Exception {
		System.out.println("Verify Video View Event For Content played from Megamenu");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoViewEventForContentInMegamenu();
	}
	
	@Test(priority = 14)
	@Parameters({"keyword1"})
	public void verifyVideoViewEventAfterRefreshingPage(String keyword1) throws Exception {
		System.out.println("Verify Video View Event after refreshing a page");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoViewEventAfterRefreshingPage(keyword1);
	}
	
	@Test(priority = 15)
	@Parameters({ "userType"})
	public void verifyVideoExitEventForFreeContent(String userType) throws Exception {
		System.out.println("Verify Video Exit Event For Free Content");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoExitEventForFreeContent("Home","homepage",userType,"basavaraj.pn5@gmail.com","igsindia123");
	}
	
	@Test(priority = 16)
	@Parameters({ "userType"})
	public void verifyVideoExitEventForPremiumContent(String userType) throws Exception {
		System.out.println("Verify Video Exit Event For Premium Content");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoExitEventForPremiumContent(userType,"Home");
	}
	
	@Test(priority = 17)
	@Parameters({ "keyword1"})
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
	@Parameters({"keyword1"})
	public void verifyVideoExitEventForContentFromSearchPage(String keyword1) throws Exception {
		System.out.println("Verify Video Exit Event For Content From Search Page");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoExitEventForContentFromSearchPage(keyword1);
	}
	
	@Test(priority = 21)
	@Parameters({ "userType", "keyword"})
	public void verifyVideoExitEventForContentFromMyWatchlistPage(String userType,String keyword) throws Exception {
		System.out.println("Verify Video Exit Event For Content From My Watchlist Page");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoExitEventForContentFromMyWatchlistPage(userType,keyword);
	}
	
	@Test(priority = 22)
	@Parameters({ "userType", "keyword"})
	public void verifyVideoExitEventForContentFromUpnextRail(String userType,String keyword) throws Exception {
		System.out.println("Verify Video Exit Event for content autoplayed from Upnext rail");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoExitEventForContentFromUpnextRail(userType,keyword);
	}
	
	@Test(priority = 23)
	@Parameters({"freeContentURL"})
	public void verifyVideoExitEventForContentFromSharedLink(String freeContentURL) throws Exception {
		System.out.println("Verify Video Exit Event For content played from Shared Link");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoExitEventForContentFromSharedLink(freeContentURL);
	}
	
	@Test(priority = 24)
	@Parameters({ "userType", "keyword"})
	public void verifyVideoExitEventForContentInPlaylist(String userType,String keyword) throws Exception {
		System.out.println("Verify Video Exit Event For Content played from Playlist");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoExitEventForContentInPlaylist(userType,keyword);
	}
		
	@Test(priority = 25)
	public void verifyVideoExitEventForContentInMegamenu() throws Exception {
		System.out.println("Verify Video Exit Event For Content played from Megamenu");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoExitEventForContentInMegamenu();
	}
	
	@Test(priority = 26)
	@Parameters({"keyword1"})
	public void verifyVideoExitEventAfterRefreshingPage(String keyword1) throws Exception {
		System.out.println("Verify Video Exit Event after refreshing a page");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoExitEventAfterRefreshingPage(keyword1);
	}
	
	
	@Test(priority = 27)
	@Parameters({ "userType", "keyword4"})
	public void verifyPauseEventForFreeContent(String userType,String keyword4) throws Exception {
		System.out.println("Verify Pause Event For Free Content");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyPauseEventForFreeContent(userType,keyword4);
	}
	
	@Test(priority = 28)
	@Parameters({ "userType"})
	public void verifyPauseEventForPremiumContent(String userType) throws Exception {
		System.out.println("Verify Pause Event For Premium Content");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyPauseEventForPremiumContent(userType,"Home");
	}
	
	@Test(priority = 29)
	@Parameters({ "userType", "keyword1"})
	public void verifyPauseEventForTrailer(String userType,String keyword1) throws Exception {
		System.out.println("Verify Pause Event For Trailer Content");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyPauseEventForTrailer(userType,keyword1);
	}
	
	@Test(priority = 30)
	public void verifyPauseEventForCarouselContent() throws Exception {
		System.out.println("Verify Pause Event For Carousel Content");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyPauseEventForCarouselContent();
	}
	
	@Test(priority = 31)
	public void verifyPauseEventForContentInTray() throws Exception {
		System.out.println("Verify Pause Event For Content played from Tray");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyPauseEventForContentInTray();
	}
	
	@Test(priority = 32)
	@Parameters({"keyword1"})
	public void verifyPauseEventForContentFromSearchPage(String keyword1) throws Exception {
		System.out.println("Verify Pause Event For Content From Search Page");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyPauseEventForContentFromSearchPage(keyword1);
	}
	
	@Test(priority = 33)
	@Parameters({ "userType", "keyword"})
	public void verifyPauseEventForContentFromMyWatchlistPage(String userType,String keyword) throws Exception {
		System.out.println("Verify Pause Event For Content From My Watchlist Page");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyPauseEventForContentFromMyWatchlistPage(userType,keyword);
	}
	
	@Test(priority = 34)
	@Parameters({ "userType", "keyword"})
	public void verifyPauseEventForContentInPlaylist(String userType,String keyword) throws Exception {
		System.out.println("Verify Pause Event For Content played from Playlist");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyPauseEventForContentInPlaylist(userType,keyword);
	}
	
	@Test(priority = 35)
	public void verifyPauseEventForLinearContent() throws Exception {
		System.out.println("Verify Pause Event For Linear Content");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyPauseEventForLinearContent();
	}
	
	@Test(priority = 36)
	@Parameters({ "userType", "keyword"})
	public void verifyPauseEventForContentFromUpnextRail(String userType,String keyword) throws Exception {
		System.out.println("Verify Pause Event for content autoplayed from Upnext rail");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyPauseEventForContentFromUpnextRail(userType,keyword);
	}
	
	@Test(priority = 37)
	@Parameters({"freeContentURL"})
	public void verifyPauseEventForContentFromSharedLink(String freeContentURL) throws Exception {
		System.out.println("Verify Pause Event For content played from Shared Link");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyPauseEventForContentFromSharedLink(freeContentURL);
	}
	
	@Test(priority = 38)
	@Parameters({ "userType", "keyword4"})
	public void verifyVideoWatchDurationEventForFreeContentComplete(String userType,String keyword4) throws Exception {
		System.out.println("Verify Video Watch Duration Event when user completely watches For Free Content");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoWatchDurationEventForFreeContentComplete(userType,keyword4);
	}
	
	@Test(priority = 39)
	@Parameters({ "userType"})
	public void verifyVideoWatchDurationEventForPremiumContentComplete(String userType) throws Exception {
		System.out.println("Verify Video Watch Duration Event when user completely watches Premium Content");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoWatchDurationEventForPremiumContentComplete(userType,"Home");
	}
	
	@Test(priority = 40)
	@Parameters({ "userType", "keyword1"})
	public void verifyVideoWatchDurationEventForTrailerComplete(String userType,String keyword1) throws Exception {
		System.out.println("Verify Video Watch Duration Event  when user completely watches Trailer Content");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoWatchDurationEventForTrailerComplete(userType,keyword1);
	}
	
	@Test(priority = 41)
	public void verifyVideoWatchDurationEventForCarouselContentComplete() throws Exception {
		System.out.println("Verify Video Watch Duration Event when user completely watches Carousel Content");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoWatchDurationEventForCarouselContentComplete();
	}
	
	@Test(priority = 42)
	public void verifyVideoWatchDurationEventForContentInTrayComplete() throws Exception {
		System.out.println("Verify Video Watch Duration Event when user completely watches Content played from Tray");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoWatchDurationEventForContentInTrayComplete();
	}
	
	@Test(priority = 43)
	@Parameters({"keyword1"})
	public void verifyVideoWatchDurationEventForContentFromSearchPageComplete(String keyword1) throws Exception {
		System.out.println("Verify Video Watch Duration Event when user completely watches Content From Search Page");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoWatchDurationEventForContentFromSearchPageComplete(keyword1);
	}
	
	@Test(priority = 44)
	@Parameters({ "userType", "keyword"})
	public void verifyVideoWatchDurationEventForContentFromMyWatchlistPageComplete(String userType,String keyword) throws Exception {
		System.out.println("Verify Video Watch Duration Event when user completely watches Content From My Watchlist Page");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoWatchDurationEventForContentFromMyWatchlistPageComplete(userType,keyword);
	}
	
	@Test(priority = 45)
	public void verifyVideoWatchDurationEventForContentInMegamenuComplete() throws Exception {
		System.out.println("Verify Video Watch Duration Event when user completely watches Content played from Megamenu");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoWatchDurationEventForContentInMegamenuComplete();
	}
	
	@Test(priority = 46)
	@Parameters({ "userType", "keyword"})
	public void verifyVideoWatchDurationEventForContentInPlaylistComplete(String userType,String keyword) throws Exception {
		System.out.println("Verify Video Watch Duration Event when user completely watches Content played from Playlist");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoWatchDurationEventForContentInPlaylistComplete(userType,keyword);
	}
	
	@Test(priority = 47)
	@Parameters({ "userType", "keyword"})
	public void verifyVideoWatchDurationEventForContentFromUpnextRailComplete(String userType,String keyword) throws Exception {
		System.out.println("Verify Video Watch Duration Event When user completely watches the  auto-played content from Upnext rail");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoWatchDurationEventForContentFromUpnextRailComplete(userType,keyword);
	}

	@Test(priority = 48)
	@Parameters({ "freeContentURL"})
	public void verifyVideoWatchDurationEventForContentFromSharedLinkComplete(String freeContentURL) throws Exception {
		System.out.println("Verify Video Watch Duration Event when user completely watches the content playback shared through shared link");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoWatchDurationEventForContentFromSharedLinkComplete(freeContentURL);
	}
	
	
	@Test(priority = 49)
	@Parameters({ "userType", "keyword4"})
	public void verifyVideoWatchDurationEventForFreeContentAbrupt(String userType,String keyword4) throws Exception {
		System.out.println("Verify Video Watch Duration Event when video is closed abruptly For Free Content");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoWatchDurationEventForFreeContentAbrupt(userType,keyword4);
	}
	
	@Test(priority = 50)
	@Parameters({ "userType"})
	public void verifyVideoWatchDurationEventForPremiumContentAbrupt(String userType) throws Exception {
		System.out.println("Verify Video Watch Duration when video is closed abruptly Event For Premium Content");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoWatchDurationEventForPremiumContentAbrupt(userType,"Home");
	}
	
	@Test(priority = 51)
	@Parameters({ "userType", "keyword1"})
	public void verifyVideoWatchDurationEventForTrailerAbrupt(String userType,String keyword1) throws Exception {
		System.out.println("Verify Video Watch Duration Event when video is closed abruptly For Trailer Content");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoWatchDurationEventForTrailerAbrupt(userType,keyword1);
	}
	
	@Test(priority = 52)
	public void verifyVideoWatchDurationEventForCarouselContentAbrupt() throws Exception {
		System.out.println("Verify Video Watch Duration Event when video is closed abruptly For Carousel Content");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoWatchDurationEventForCarouselContentAbrupt();
	}
	
	@Test(priority = 53)
	public void verifyVideoWatchDurationEventForContentInTrayAbrupt() throws Exception {
		System.out.println("Verify Video Watch Duration Event when video is closed abruptly For Content played from Tray");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoWatchDurationEventForContentInTrayAbrupt();
	}
	
	@Test(priority = 54)
	@Parameters({"keyword1"})
	public void verifyVideoWatchDurationEventForContentFromSearchPageAbrupt(String keyword1) throws Exception {
		System.out.println("Verify Video Watch Duration Event when video is closed abruptly For Content From Search Page");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoWatchDurationEventForContentFromSearchPageAbrupt(keyword1);
	}
	
	@Test(priority = 55)
	@Parameters({ "userType", "keyword"})
	public void verifyVideoWatchDurationEventForContentFromMyWatchlistPageAbrupt(String userType,String keyword) throws Exception {
		System.out.println("Verify Video Watch Duration Event when video is closed abruptly For Content From My Watchlist Page");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoWatchDurationEventForContentFromMyWatchlistPageAbrupt(userType,keyword);
	}
	
	@Test(priority = 56)
	public void verifyVideoWatchDurationEventForContentInMegamenuAbrupt() throws Exception {
		System.out.println("Verify Video Watch Duration Event when video is closed abruptly For Content played from Megamenu");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoWatchDurationEventForContentInMegamenuAbrupt();
	}
	
	@Test(priority = 57)
	@Parameters({ "userType", "keyword"})
	public void verifyVideoWatchDurationEventForContentInPlaylistAbrupt(String userType,String keyword) throws Exception {
		System.out.println("Verify Video Watch Duration Event when video is closed abruptly For Content played from Playlist");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoWatchDurationEventForContentInPlaylistAbrupt(userType,keyword);
	}
	
	@Test(priority = 58)
	@Parameters({ "userType", "keyword"})
	public void verifyVideoWatchDurationEventForContentFromUpnextRailAbrupt(String userType,String keyword) throws Exception {
		System.out.println("Verify Video Watch Duration Event when video is closed abruptly on auto-played content from Upnext rail");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoWatchDurationEventForContentFromUpnextRailAbrupt(userType,keyword);
	}
	
	@Test(priority = 59)
	@Parameters({"freeContentURL"})
	public void verifyVideoWatchDurationEventForContentFromSharedLinkAbrupt(String freeContentURL) throws Exception {
		System.out.println("Verify Video Watch Duration Event when video is closed abruptly For content played from Shared Link");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyVideoWatchDurationEventForContentFromSharedLinkAbrupt(freeContentURL);
	}
	
	@Test(priority = 60)
	@Parameters({ "userType", "keyword4"})
	public void verifyResumeEventForFreeContent(String userType,String keyword4) throws Exception {
		System.out.println("Verify Resume Event For Free Content");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyResumeEventForFreeContent(userType,keyword4);
	}
	
	@Test(priority = 61)
	@Parameters({ "userType"})
	public void verifyResumeEventForPremiumContent(String userType) throws Exception {
		System.out.println("Verify Resume Event For Premium Content");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyResumeEventForPremiumContent(userType,"Home");
	}
	
	@Test(priority = 62)
	@Parameters({ "userType", "keyword1"})
	public void verifyResumeEventForTrailer(String userType,String keyword1) throws Exception {
		System.out.println("Verify Resume Event For Trailer Content");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyResumeEventForTrailer(userType,keyword1);
	}
	
	@Test(priority = 63)
	public void verifyResumeEventForCarouselContent() throws Exception {
		System.out.println("Verify Resume Event For Carousel Content");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyResumeEventForCarouselContent();
	}
	
	@Test(priority = 64)
	public void verifyResumeEventForContentInTray() throws Exception {
		System.out.println("Verify Resume Event For Content played from Tray");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyResumeEventForContentInTray();
	}
	
	@Test(priority = 65)
	@Parameters({"keyword1"})
	public void verifyResumeEventForContentFromSearchPage(String keyword1) throws Exception {
		System.out.println("Verify Resume Event For Content From Search Page");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyResumeEventForContentFromSearchPage(keyword1);
	}
	
	@Test(priority = 66)
	@Parameters({ "userType", "keyword"})
	public void verifyResumeEventForContentFromMyWatchlistPage(String userType,String keyword) throws Exception {
		System.out.println("Verify Resume Event For Content From My Watchlist Page");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyResumeEventForContentFromMyWatchlistPage(userType,keyword);
	}
	
	@Test(priority = 67)
	@Parameters({ "userType", "keyword"})
	public void verifyResumeEventForContentInPlaylist(String userType,String keyword) throws Exception {
		System.out.println("Verify Resume Event For Content played from Playlist");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyResumeEventForContentInPlaylist(userType,keyword);
	}
	
	
	@Test(priority = 68)
	public void verifyResumeEventForContentInMegamenu() throws Exception {
		System.out.println("Verify Resume Event For Content played from Megamenu");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyResumeEventForContentInMegamenu();
	}
	
	@Test(priority = 69)
	public void verifyResumeEventForLinearContent() throws Exception {
		System.out.println("Verify Resume Event For Linear Content");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyResumeEventForLinearContent();
	}
	
	@Test(priority = 70)
	@Parameters({ "userType", "keyword"})
	public void verifyResumeEventForContentFromUpnextRail(String userType,String keyword) throws Exception {
		System.out.println("Verify Resume Event for content autoplayed from Upnext rail");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyResumeEventForContentFromUpnextRail(userType,keyword);
	}
	
	@Test(priority = 71)
	@Parameters({"freeContentURL"})
	public void verifyResumeEventForContentFromSharedLink(String freeContentURL) throws Exception {
		System.out.println("Verify Resume Event For content played from Shared Link");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyResumeEventForContentFromSharedLink(freeContentURL);
	}
	
	@Test(priority = 72)
	@Parameters({ "userType", "audioTrackContent"})
	public void verifyAdInitializedEventForFreeContent(String userType,String audioTrackContent) throws Exception {
		System.out.println("Verify Ad Initialized Event For Free Content");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyAdInitializedEventForFreeContent("Home","homepage",userType,"basavaraj.pn5@gmail.com","igsindia123");
	}

	@Test(priority = 73)
	@Parameters({"userType", "keyword1"})
	public void verifyAdInitializedEventForTrailer(String userType,String keyword1) throws Exception {
		System.out.println("Verify Ad Initialized Event For Trailer Content");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyAdInitializedEventForTrailer(userType,keyword1);
	}
	
	@Test(priority = 74)
	@Parameters({ "userType"})
	public void verifyAdInitializedEventForCarouselContent(String userType) throws Exception {
		System.out.println("Verify Ad Initialized Event For Carousel Content");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyAdInitializedEventForCarouselContent(userType);
	}
	
	@Test(priority = 75)
	@Parameters({ "userType"})
	public void verifyAdInitializedEventForContentInTray(String userType) throws Exception {
		System.out.println("Verify Ad Initialized Event For Content played from Tray");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyAdInitializedEventForContentInTray(userType);
	}
	
	@Test(priority = 76)
	@Parameters({"userType","subtitleTrackContent"})
	public void verifyAdInitializedEventForContentFromSearchPage(String userType,String subtitleTrackContent) throws Exception {
		System.out.println("Verify Ad Initialized Event For Content From Search Page");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyAdInitializedEventForContentFromSearchPage(userType,subtitleTrackContent);
	}
	
	@Test(priority = 77)
	@Parameters({ "userType", "audioTrackContent"})
	public void verifyAdInitializedEventForContentFromMyWatchlistPage(String userType,String audioTrackContent) throws Exception {
		System.out.println("Verify Ad Initialized Event For Content From My Watchlist Page");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyAdInitializedEventForContentFromMyWatchlistPage(userType,audioTrackContent);
	}
	
	@Test(priority = 78)
	@Parameters({ "userType"})
	public void verifyAdInitializedEventForContentInMegamenu(String userType) throws Exception {
		System.out.println("Verify Ad Initialized Event For Content played from Megamenu");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyAdInitializedEventForContentInMegamenu(userType);
	}
	
	@Test(priority = 79)
	@Parameters({ "userType", "audioTrackContent"})
	public void verifyAdInitializedEventForContentInPlaylist(String userType,String audioTrackContent) throws Exception {
		System.out.println("Verify Ad Initialized Event For Content played from Playlist");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyAdInitializedEventForContentInPlaylist(userType,audioTrackContent);
	}
	
	@Test(priority = 80)
	@Parameters({ "userType", "audioTrackContent"})
	public void verifyAdInitializedEventForContentFromUpnextRail(String userType,String audioTrackContent) throws Exception {
		System.out.println("Verify Ad Initialized Event For Content played from Upnext rail");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyAdInitializedEventForContentFromUpnextRail(userType,audioTrackContent);
	}
	
	@Test(priority = 81)
	@Parameters({"userType","audioTrackURL"})
	public void verifyAdInitializedEventForContentFromSharedLink(String userType,String audioTrackURL) throws Exception {
		System.out.println("Verify Ad Initialized Event For content played from Shared Link");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyAdInitializedEventForContentFromSharedLink(userType,audioTrackURL);
	}
	
	@Test(priority = 82)
	@Parameters({ "userType", "audioTrackContent"})
	public void verifyAdViewEventForFreeContent(String userType,String audioTrackContent) throws Exception {
		System.out.println("Verify Ad View Event For Free Content");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyAdViewEventForFreeContent(userType,audioTrackContent);
	}

	@Test(priority = 83)
	@Parameters({ "userType","keyword1"})
	public void verifyAdViewEventForTrailer(String userType,String keyword1) throws Exception {
		System.out.println("Verify Ad View Event For Trailer Content");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyAdViewEventForTrailer(userType,keyword1);
	}
	
	@Test(priority = 84)
	@Parameters({ "userType"})
	public void verifyAdViewEventForCarouselContent(String userType) throws Exception {
		System.out.println("Verify Ad View Event For Carousel Content");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyAdViewEventForCarouselContent(userType);
	}
	
	@Test(priority = 85)
	@Parameters({ "userType"})
	public void verifyAdViewEventForContentInTray(String userType) throws Exception {
		System.out.println("Verify Ad View Event For Content played from Tray");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyAdViewEventForContentInTray(userType);
	}
	
	@Test(priority = 86)
	@Parameters({"userType","subtitleTrackContent"})
	public void verifyAdViewEventForContentFromSearchPage(String userType,String subtitleTrackContent) throws Exception {
		System.out.println("Verify Ad View Event For Content From Search Page");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyAdViewEventForContentFromSearchPage(userType,subtitleTrackContent);
	}
	
	@Test(priority = 87)
	@Parameters({ "userType", "audioTrackContent"})
	public void verifyAdViewEventForContentFromMyWatchlistPage(String userType,String audioTrackContent) throws Exception {
		System.out.println("Verify Ad View Event For Content From My Watchlist Page");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyAdViewEventForContentFromMyWatchlistPage(userType,audioTrackContent);
	}
	
	@Test(priority = 88)
	@Parameters({ "userType"})
	public void verifyAdViewEventForContentInMegamenu(String userType) throws Exception {
		System.out.println("Verify Ad View Event For Content played from Megamenu");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyAdViewEventForContentInMegamenu(userType);
	}
	
	@Test(priority = 89)
	@Parameters({ "userType", "audioTrackContent"})
	public void verifyAdViewEventForContentInPlaylist(String userType,String audioTrackContent) throws Exception {
		System.out.println("Verify Ad View Event For Content played from Playlist");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyAdViewEventForContentInPlaylist(userType,audioTrackContent);
	}
	
	@Test(priority = 90)
	@Parameters({ "userType", "audioTrackContent"})
	public void verifyAdViewEventForContentFromUpnextRail(String userType,String audioTrackContent) throws Exception {
		System.out.println("Verify Ad View Event For Content played from Upnext rail");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyAdViewEventForContentFromUpnextRail(userType,audioTrackContent);
	}
	
	@Test(priority = 91)
	@Parameters({"userType","audioTrackURL"})
	public void verifyAdViewEventForContentFromSharedLink(String userType,String audioTrackURL) throws Exception {
		System.out.println("Verify Ad View Event For content played from Shared Link");
		Zee5PWAMixPanelAndroidBusinessLogic.verifyAdViewEventForContentFromSharedLink(userType,audioTrackURL);
	}
	
	
	@AfterClass
	public void tearDown() {
		Zee5PWAMixPanelAndroidBusinessLogic.tearDown();
	}


}

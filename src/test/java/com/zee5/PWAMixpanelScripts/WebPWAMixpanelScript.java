package com.zee5.PWAMixpanelScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5PWAWEBMixPanelBusinessLogic;

public class WebPWAMixpanelScript {

	private Zee5PWAWEBMixPanelBusinessLogic Zee5PWAWEBMixPanelBusinessLogic;

	@BeforeTest
	public void init() throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic = new Zee5PWAWEBMixPanelBusinessLogic("Chrome");
	}

	@Test(priority = 1)
	@Parameters({ "userType" })
	public void PWAWEBMixPanelLogin(String userType) throws Exception {
		System.out.println("Login");
		Zee5PWAWEBMixPanelBusinessLogic.ZeeWEBPWAMixPanelLogin(userType);
	}

	@Test(priority = 2)
	@Parameters({ "userType" })
	public void verifySkipLoginEvent(String userType) throws Exception {
		System.out.println("Verify Skip Login Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifySkipLoginEvent(userType);
	}

	@Test(priority = 3)
	@Parameters({ "userType", "keyword" })
	public void verifySkipLoginByClickingOnLoginInRegistrationPopUp(String userType, String keyword) throws Exception {
		System.out.println("Verify Skip Login Event during content playback post clicking on login in registration popup");
		Zee5PWAWEBMixPanelBusinessLogic.verifySkipLoginByClickingOnLoginInRegistrationPopUp(userType,keyword);
	}
	
	@Test(priority = 4)
	@Parameters({ "userType", "keyword2" })
	public void verifySkipLoginByClickingOnLoginInGetPremiumPopUp(String userType, String keyword2) throws Exception {
		System.out.println("Verify Skip Login Event during content playback post clicking on login button in Get Premium popup");
		Zee5PWAWEBMixPanelBusinessLogic.verifySkipLoginByClickingOnLoginInGetPremiumPopUp(userType,keyword2);
	}
	
	
	@Test(priority = 5)
	@Parameters({ "userType" })
	public void verifySkipRegistrationEvent(String userType) throws Exception {
		System.out.println("Verify Skip Registration Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifySkipRegistrationEvent(userType);
	}
	
	@Test(priority = 6)
	@Parameters({ "userType" })
	public void verifyLoginScreenDisplayEventByClickingOnLoginButton(String userType) throws Exception {
		System.out.println("Verify Login Screen Display Event By Clicking On Login Button");
		Zee5PWAWEBMixPanelBusinessLogic.verifyLoginScreenDisplayEventByClickingOnLoginButton(userType);
	}
	
	@Test(priority = 7)
	@Parameters({ "userType", "keyword2" })
	public void verifyLoginScreenDisplayEventByClickingOnLoginButtonOnPlayer(String userType, String keyword2) throws Exception {
		System.out.println("Verify Login Screen Display Event By Clicking On Login Button On Player");
		Zee5PWAWEBMixPanelBusinessLogic.verifyLoginScreenDisplayEventByClickingOnLoginButtonOnPlayer(userType, keyword2);
	}
	
	@Test(priority = 8)
	@Parameters({ "userType"})
	public void verifyLoginScreenDisplayEventByClickingOnLoginButtonInRegistartionScreen(String userType) throws Exception {
		System.out.println("Verify Login Screen Display Event By Clicking On Login Button In Registartion Screen");
		Zee5PWAWEBMixPanelBusinessLogic.verifyLoginScreenDisplayEventByClickingOnLoginButtonInRegistartionScreen(userType);
	}
	
	@Test(priority = 9)
	@Parameters({ "userType", "keyword2" })
	public void verifyLoginScreenDisplayEventByClickingOnLoginButtonInGetPremiumPopUp(String userType, String keyword2) throws Exception {
		System.out.println("Verify Login Screen Display Event By Clicking On Login Button In Get Premium Pop Up");
		Zee5PWAWEBMixPanelBusinessLogic.verifyLoginScreenDisplayEventByClickingOnLoginButtonInGetPremiumPopUp(userType, keyword2);
	}
	
	@Test(priority = 10)
	@Parameters({ "userType" })
	public void verifyTVAuthenticationScreenDisplayEvent(String userType) throws Exception {
		System.out.println("Verify TV Authentication Screen Display Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyTVAuthenticationScreenDisplayEvent(userType);
	}
	

	@Test(priority = 11)
	@Parameters({ "userType" })
	public void verifySubscriptionPageViewedEventViaSubscribeBtn(String userType) throws Exception {
		System.out.println("Verify Subscription Page Viewed Event by clicking on Subscribe button at header");
		Zee5PWAWEBMixPanelBusinessLogic.verifySubscriptionPageViewedEventViaSubscribeBtn(userType);
	}

	@Test(priority = 12)
	@Parameters({ "userType" })
	public void verifyLoginInitiatedEventForValidCredentials(String userType) throws Exception {
		System.out.println("Verify Login Initiated Event for Valid Credentials");
		Zee5PWAWEBMixPanelBusinessLogic.verifyLoginInitiatedEventForValidCredentials(userType,"fbLogin");
	}

	@Test(priority = 13)
	@Parameters({ "userType" })
	public void verifyCarouselBannerClickEvent(String userType) throws Exception {
		System.out.println("Verify Carousel Banner Click Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyCarouselBannerClickEvent("Home");
	}

	@Test(priority = 14)
	@Parameters({ "userType" })
	public void verifyThumbnailClickEventFromTray(String userType) throws Exception {
		System.out.println("Verify Thumbnail Click Event form Tray");
		Zee5PWAWEBMixPanelBusinessLogic.verifyThumbnailClickEventFromTray("Shows");
	}
	
	@Test(priority = 15)
	@Parameters({ "userType" })
	public void verifyThumbnailClickEventFromViewMorePage(String userType) throws Exception {
		System.out.println("Verify Thumbnail Click Event From View More Page");
		Zee5PWAWEBMixPanelBusinessLogic.verifyThumbnailClickEventFromViewMorePage("Shows");
	}
	
	@Test(priority = 16)
	@Parameters({ "userType" })
	public void verifyThumbnailClickEventFromShowDetailPage(String userType) throws Exception {
		System.out.println("Verify Thumbnail Click Event From Show Detail Page");
		Zee5PWAWEBMixPanelBusinessLogic.verifyThumbnailClickEventFromShowDetailPage(userType);
	}
	
	@Test(priority = 17)
	@Parameters({ "userType", "keyword" })
	public void verifyThumbnailClickEventFromPlaybackPage(String keyword,String userType) throws Exception {
		System.out.println("Verify Thumbnail Click Event From Show Detail Page");
		Zee5PWAWEBMixPanelBusinessLogic.verifyThumbnailClickEventFromPlaybackPage(userType,keyword);
	}

	@Test(priority = 18)
	@Parameters({ "keyword3" })
	public void verifyClearSearchHistoryEvent(String keyword3) throws Exception {
		System.out.println("Verify Clear Search Histroy Event");
		Zee5PWAWEBMixPanelBusinessLogic.clearSearchHistoryEvent( keyword3);
	}
	
	@Test(priority = 19)
	@Parameters({ "keyword" })
	public void verifyEpisodeListChosenEventFromShowDetailPage(String keyword) throws Exception {
		System.out.println("Verify Episode List Chosen Event in Show Detail page");
		Zee5PWAWEBMixPanelBusinessLogic.verifyEpisodeListChosenEventFromShowDetailPage(keyword);
	}
	
	@Test(priority = 20)
	@Parameters({ "keyword" })
	public void verifyContentBucketSwipeEventFromShowDetailPage(String keyword) throws Exception {
		System.out.println("Verify Content Bucket Swipe Event in Show Detail page");
		Zee5PWAWEBMixPanelBusinessLogic.verifyContentBucketSwipeEventFromShowDetailPage(keyword);
	}
	
	@Test(priority = 21)
	@Parameters({ "keyword" })
	public void verifyViewMoreSelectedEventFromShowDetailPage(String keyword) throws Exception {
		System.out.println("Verify View More Selected Event For content played from Show detail page");
		Zee5PWAWEBMixPanelBusinessLogic.verifyViewMoreSelectedEventFromShowDetailPage(keyword);
	}
	
	@Test(priority = 22)
	public void verifySearchExecutedEvent() throws Exception {
		System.out.println("Verify Clear Search Histroy Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifySearchExecutedEvent();
	}
	
	@Test(priority = 23)
	public void verifyScreenViewEvent() throws Exception {
		System.out.println("Verify Screen View Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyScreenViewEvent("Shows");
	}
	
	@Test(priority = 24)
	@Parameters({ "userType", "keyword1" })
	public void verifyAddtoWatchlistFromPlaybackPage(String keyword1,String userType) throws Exception {
		System.out.println("Verify Add to Watchlist Event From Playback Page");
		Zee5PWAWEBMixPanelBusinessLogic.verifyAddtoWatchlistFromPlaybackPage(userType,keyword1);
	}
	
	@Test(priority = 25)
	@Parameters({ "userType", "keyword1" })
	public void verifyRemoveFomWatchlistEventFromPlaybackPage(String keyword1,String userType) throws Exception {
		System.out.println("Verify Remove From Watchlist Event From Playback Page");
		Zee5PWAWEBMixPanelBusinessLogic.verifyRemoveFomWatchlistEventFromPlaybackPage(userType,keyword1);
	}
	
	
	@Test(priority = 26)
	@Parameters({ "userType" })
	public void verifyAddToWatchlistEventByMouseHover(String userType) throws Exception {
		System.out.println("Verify Add to Watchlist Event by mouse hovering on a Content Card");
		Zee5PWAWEBMixPanelBusinessLogic.verifyAddToWatchlistEventByMouseHover(userType);
	}
	
	@Test(priority = 27)
	@Parameters({ "userType" })
	public void verifyRemoveFomWatchlistEventByMouseHover(String userType) throws Exception {
		System.out.println("Verify Remove from Watchlist Event by mouse hovering on a Content Card");
		Zee5PWAWEBMixPanelBusinessLogic.verifyRemoveFomWatchlistEventByMouseHover(userType);
	}
	
	@Test(priority = 28)
	public void verifyShareEventByMouseHover() throws Exception {
		System.out.println("Verify Share Event By Mouse Hovering on a Content Card");
		Zee5PWAWEBMixPanelBusinessLogic.verifyShareEventByMouseHover();
	}
	
	
	@Test(priority = 29)
	@Parameters({ "keyword1" })
	public void verifyShareEventFromPlaybackPage(String keyword1) throws Exception {
		System.out.println("Verify Share Event From Playback Page");
		Zee5PWAWEBMixPanelBusinessLogic.verifyShareEventFromPlaybackPage(keyword1);
	}
	

	
	@Test(priority = 30)
	@Parameters({ "keyword1" })
	public void verifyQualityChangeEvent(String keyword1) throws Exception {
		System.out.println("Verify Quality Change Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyQualityChangeEvent(keyword1);
		}
	
	@Test(priority = 31)
	@Parameters({ "userType", "keyword1" })
	public void verifyContentBucketSwipeEventInPlaybackPage(String keyword1) throws Exception {
		System.out.println("Verify Quality Change Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyContentBucketSwipeEventInPlaybackPage(keyword1);
		}
	
	@Test(priority = 32)
	public void verifyDisplayAndContentLanguageChangeEvent() throws Exception {
		System.out.println("Verify Display And Content Language Change Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyDisplayAndContentLanguageChangeEvent();
	}
	
	@Test(priority = 33)
	@Parameters({ "userType" })
	public void verifyDefaultSettingRestoredEvent(String userType) throws Exception {
		System.out.println("Verify Default Setting Restored Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyDefaultSettingRestoredEvent(userType);
	}
	
	@Test(priority = 34)
	public void verifyAdBannerImpressionEvent(String tabName) throws Exception {
		System.out.println("Verify Ad Banner Impression Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdBannerImpressionEvent("Shows");
	}
	
	@Test(priority = 35)
	public void verifyCarouselBannerSwipeEvent(String tabName) throws Exception {
		System.out.println("Verify Carousel Banner Swipe Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyCarouselBannerSwipeEvent("Shows");
	}
	
	@Test(priority = 36)
	public void verifyContentBucketSwipeEvent(String tabName) throws Exception {
		System.out.println("Verify Content Bucket Swipe Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyContentBucketSwipeEvent("Shows");
	}
	
	@Test(priority = 37)
	@Parameters({ "userType" })
	public void verifyCTAsEvent(String userType,String tabName) throws Exception {
		System.out.println("Verify CTAs Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyCTAsEvent(userType,"Shows");
	}
	
	@Test(priority = 38)
	public void verifyBannerAutoplayEventForNewsContent() throws Exception {
		System.out.println("Verify Banner Autoplay Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyBannerAutoplayEventForNewsContent();
	}
	
	@Test(priority = 39)
	public void verifyMuteChangedEventForNewsContent() throws Exception {
		System.out.println("Verify Mute Changed Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyMuteChangedEventForNewsContent();
	}
	
	@Test(priority = 40)
	@Parameters({ "userType", "keyword4"})
	public void verifyResumeEventForFreeContent(String userType,String keyword4) throws Exception {
		System.out.println("Verify Resume Event For Free Content");
		Zee5PWAWEBMixPanelBusinessLogic.verifyResumeEventForFreeContent(userType,keyword4);
	}
	
	@Test(priority = 41)
	@Parameters({ "userType", "keyword1"})
	public void verifyResumeEventForPremiumContent(String userType,String keyword1) throws Exception {
		System.out.println("Verify Resume Event For Premium Content");
		Zee5PWAWEBMixPanelBusinessLogic.verifyResumeEventForPremiumContent(userType,keyword1);
	}
	
	@Test(priority = 42)
	@Parameters({ "userType", "keyword1"})
	public void verifyResumeEventForTrailer(String userType,String keyword1) throws Exception {
		System.out.println("Verify Resume Event For Trailer Content");
		Zee5PWAWEBMixPanelBusinessLogic.verifyResumeEventForTrailer(userType,keyword1);
	}
	
	@Test(priority = 43)
	public void verifyResumeEventForCarouselContent() throws Exception {
		System.out.println("Verify Resume Event For Carousel Content");
		Zee5PWAWEBMixPanelBusinessLogic.verifyResumeEventForCarouselContent();
	}
	
	@Test(priority = 44)
	public void verifyResumeEventForContentInTray() throws Exception {
		System.out.println("Verify Resume Event For Content played from Tray");
		Zee5PWAWEBMixPanelBusinessLogic.verifyResumeEventForContentInTray();
	}
	
	@Test(priority = 45)
	@Parameters({"keyword1"})
	public void verifyResumeEventForContentFromSearchPage(String keyword1) throws Exception {
		System.out.println("Verify Resume Event For Content From Search Page");
		Zee5PWAWEBMixPanelBusinessLogic.verifyResumeEventForContentFromSearchPage(keyword1);
	}
	
	@Test(priority = 46)
	@Parameters({ "userType", "keyword"})
	public void verifyResumeEventForContentFromMyWatchlistPage(String userType,String keyword) throws Exception {
		System.out.println("Verify Resume Event For Content From My Watchlist Page");
		Zee5PWAWEBMixPanelBusinessLogic.verifyResumeEventForContentFromMyWatchlistPage(userType,keyword);
	}
	
	@Test(priority = 47)
	@Parameters({ "userType", "keyword"})
	public void verifyResumeEventForContentInPlaylist(String userType,String keyword) throws Exception {
		System.out.println("Verify Resume Event For Content played from Playlist");
		Zee5PWAWEBMixPanelBusinessLogic.verifyResumeEventForContentInPlaylist(userType,keyword);
	}
	
	@Test(priority = 48)
	@Parameters({ "userType", "keyword"})
	public void verifyRemoveFromWatchlistEventFromMyWatchlistPage(String userType,String keyword) throws Exception {
		System.out.println("Verify Remove From Watchlist Event for Content from My Watchlist page");
		Zee5PWAWEBMixPanelBusinessLogic.verifyRemoveFromWatchlistEventFromMyWatchlistPage(userType,keyword);
	}
	
	@Test(priority = 49)
	public void verifyResumeEventForContentInMegamenu() throws Exception {
		System.out.println("Verify Resume Event For Content played from Megamenu");
		Zee5PWAWEBMixPanelBusinessLogic.verifyResumeEventForContentInMegamenu();
	}
	
	@Test(priority = 50)
	@Parameters({ "userType" })
	public void verifyChangePasswordStartedEvent(String userType) throws Exception {
		System.out.println("Verify Change Password Started Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyChangePasswordStartedEvent(userType);
	}
	
	@Test(priority = 51)
	@Parameters({ "userType" })
	public void verifyChangePasswordResultEvent(String userType) throws Exception {
		System.out.println("Verify Change Password Result Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyChangePasswordResultEvent(userType);
	}
	
	@Test(priority = 52)
	@Parameters({ "userType" })
	public void verifyProfileUpdateResultEvent(String userType) throws Exception {
		System.out.println("Verify Profile Update Result Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyProfileUpdateResultEvent(userType);
	}
	
	@Test(priority = 53)
	public void verifyShareEventForUpcomingProgram() throws Exception {
		System.out.println("Verify Profile Update Result Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyShareEventForUpcomingProgram();
	}
	
	@Test(priority = 54)
	@Parameters({ "userType" })
	public void verifySetReminderEventForUpcomingProgram(String userType) throws Exception {
		System.out.println("Verify Profile Update Result Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifySetReminderEventForUpcomingProgram(userType);
	}
	
	@Test(priority = 55)
	public void verifySearchCancelledEvent() throws Exception {
		System.out.println("Verify Search Cancelled Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifySearchCancelledEvent();
	}
	
	@Test(priority = 56)
	@Parameters({ "userType" })
	public void verifyParentalRestrictionAndSettingChangedEvent(String userType) throws Exception {
		System.out.println("Verify Parental Restriction And Setting Changed Event");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch(true);
		Zee5PWAWEBMixPanelBusinessLogic.ZeeWEBPWAMixPanelLoginForParentalControl(userType);
		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalRestrictionEvent(userType,"NoRestriction");
		
	}
	
	@Test(priority = 57)
	@Parameters({ "keyword" })
	public void verifyShareEventFromShowDetailPage(String keyword) throws Exception {
		System.out.println("Verify Share Event From Show Detail Page");
		Zee5PWAWEBMixPanelBusinessLogic.verifyShareEventFromShowDetailPage(keyword);
	}
	
	@Test(priority = 40)
	@Parameters({ "userType", "keyword4"})
	public void verifyVideoWatchDurationEventForFreeContent(String userType,String keyword4) throws Exception {
		System.out.println("Verify Video Watch Duration Event For Free Content");
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoWatchDurationEventForFreeContent(userType,keyword4);
	}
	
	@Test(priority = 41)
	@Parameters({ "userType", "keyword1"})
	public void verifyVideoWatchDurationEventForPremiumContent(String userType,String keyword1) throws Exception {
		System.out.println("Verify Video Watch Duration Event For Premium Content");
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoWatchDurationEventForPremiumContent(userType,keyword1);
	}
	
	@Test(priority = 42)
	@Parameters({ "userType", "keyword1"})
	public void verifyVideoWatchDurationEventForTrailer(String userType,String keyword1) throws Exception {
		System.out.println("Verify Video Watch Duration Event For Trailer Content");
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoWatchDurationEventForTrailer(userType,keyword1);
	}
	
	@Test(priority = 43)
	public void verifyVideoWatchDurationEventForCarouselContent() throws Exception {
		System.out.println("Verify Video Watch Duration Event For Carousel Content");
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoWatchDurationEventForCarouselContent();
	}
	
	@Test(priority = 44)
	public void verifyVideoWatchDurationEventForContentInTray() throws Exception {
		System.out.println("Verify Video Watch Duration Event For Content played from Tray");
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoWatchDurationEventForContentInTray();
	}
	
	@Test(priority = 45)
	@Parameters({"keyword1"})
	public void verifyVideoWatchDurationEventForContentFromSearchPage(String keyword1) throws Exception {
		System.out.println("Verify Video Watch Duration Event For Content From Search Page");
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoWatchDurationEventForContentFromSearchPage(keyword1);
	}
	
	@Test(priority = 46)
	@Parameters({ "userType", "keyword"})
	public void verifyVideoWatchDurationEventForContentFromMyWatchlistPage(String userType,String keyword) throws Exception {
		System.out.println("Verify Video Watch Duration Event For Content From My Watchlist Page");
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoWatchDurationEventForContentFromMyWatchlistPage(userType,keyword);
	}
	
	@Test(priority = 47)
	public void verifyVideoWatchDurationEventForContentInMegamenu() throws Exception {
		System.out.println("Verify Video Watch Duration Event For Content played from Megamenu");
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoWatchDurationEventForContentInMegamenu();
	}
	
	@Test(priority = 48)
	@Parameters({ "userType", "keyword"})
	public void verifyVideoWatchDurationEventForContentInPlaylist(String userType,String keyword) throws Exception {
		System.out.println("Verify Resume Event For Content played from Playlist");
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoWatchDurationEventForContentInPlaylist(userType,keyword);
	}
	
	@Test(priority = 49)
	@Parameters({ "userType", "keyword4"})
	public void verifyVideoViewEventForFreeContent(String userType,String keyword4) throws Exception {
		System.out.println("VerifyVideo View Event For Free Content");
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoViewEventForFreeContent(userType,keyword4);
	}
	
	@Test(priority = 50)
	@Parameters({ "userType", "keyword1"})
	public void verifyVideoViewEventForPremiumContent(String userType,String keyword1) throws Exception {
		System.out.println("Verify Video View Event For Premium Content");
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoViewEventForPremiumContent(userType,keyword1);
	}
	
	@Test(priority = 51)
	@Parameters({ "keyword1"})
	public void verifyVideoViewEventForTrailer(String keyword1) throws Exception {
		System.out.println("Verify Video View Event For Trailer Content");
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoViewEventForTrailer(keyword1);
	}
	
	@Test(priority = 52)
	public void verifyVideoViewEventForCarouselContent() throws Exception {
		System.out.println("Verify Video View Event For Carousel Content");
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoViewEventForCarouselContent();
	}
	
	@Test(priority = 53)
	public void verifyVideoViewEventForContentInTray() throws Exception {
		System.out.println("Verify Video View Event For Content played from Tray");
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoViewEventForContentInTray();
	}
	
	@Test(priority = 54)
	@Parameters({"keyword1"})
	public void verifyVideoViewEventForContentFromSearchPage(String keyword1) throws Exception {
		System.out.println("Verify Video View Event For Content From Search Page");
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoViewEventForContentFromSearchPage(keyword1);
	}
	
	@Test(priority = 55)
	@Parameters({ "userType", "keyword"})
	public void verifyVideoViewEventForContentFromMyWatchlistPage(String userType,String keyword) throws Exception {
		System.out.println("Verify Video View Event For Content From My Watchlist Page");
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoViewEventForContentFromMyWatchlistPage(userType,keyword);
	}
	
	@Test(priority = 56)
	public void verifyVideoViewEventForContentInMegamenu() throws Exception {
		System.out.println("Verify Video View Event For Content played from Megamenu");
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoViewEventForContentInMegamenu();
	}
	
	@Test(priority = 57)
	@Parameters({ "userType", "keyword"})
	public void verifyVideoViewEventForContentInPlaylist(String userType,String keyword) throws Exception {
		System.out.println("Verify Video View Event For Content played from Playlist");
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoWatchDurationEventForContentInPlaylist(userType,keyword);
	}
	
	@Test(priority = 58)
	@Parameters({"keyword1"})
	public void verifyVideoViewEventAfterRefreshingPage(String keyword1) throws Exception {
		System.out.println("Verify Video View Event after refreshing a page");
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoViewEventAfterRefreshingPage(keyword1);
	}
	
	@Test(priority = 59)
	@Parameters({ "userType", "keyword4"})
	public void verifyVideoExitEventForFreeContent(String userType,String keyword4) throws Exception {
		System.out.println("Verify Video Exit Event For Free Content");
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoExitEventForFreeContent(userType,keyword4);
	}
	
	@Test(priority = 60)
	@Parameters({ "userType", "keyword1"})
	public void verifyVideoExitEventForPremiumContent(String userType,String keyword1) throws Exception {
		System.out.println("Verify Video Exit Event For Premium Content");
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoExitEventForPremiumContent(userType,keyword1);
	}
	
	@Test(priority = 61)
	@Parameters({ "keyword1"})
	public void verifyVideoExitEventForTrailer(String keyword1) throws Exception {
		System.out.println("Verify Video Exit Event For Trailer Content");
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoExitEventForTrailer(keyword1);
	}
	
	@Test(priority = 62)
	public void verifyVideoExitEventForCarouselContent() throws Exception {
		System.out.println("Verify Video Exit Event For Carousel Content");
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoExitEventForCarouselContent();
	}
	
	@Test(priority = 63)
	public void verifyVideoExitEventForContentInTray() throws Exception {
		System.out.println("Verify Video Exit Event For Content played from Tray");
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoExitEventForContentInTray();
	}
	
	@Test(priority = 64)
	@Parameters({"keyword1"})
	public void verifyVideoExitEventForContentFromSearchPage(String keyword1) throws Exception {
		System.out.println("Verify Video Exit Event For Content From Search Page");
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoExitEventForContentFromSearchPage(keyword1);
	}
	
	@Test(priority = 65)
	@Parameters({ "userType", "keyword"})
	public void verifyVideoExitEventForContentFromMyWatchlistPage(String userType,String keyword) throws Exception {
		System.out.println("Verify Video Exit Event For Content From My Watchlist Page");
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoExitEventForContentFromMyWatchlistPage(userType,keyword);
	}
	
	@Test(priority = 66)
	public void verifyVideoExitEventForContentInMegamenu() throws Exception {
		System.out.println("Verify Video Exit Event For Content played from Megamenu");
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoExitEventForContentInMegamenu();
	}
	
	@Test(priority = 67)
	@Parameters({ "userType", "keyword"})
	public void verifyVideoExitEventForContentInPlaylist(String userType,String keyword) throws Exception {
		System.out.println("Verify Exit Event For Content played from Playlist");
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoExitEventForContentInPlaylist(userType,keyword);
	}
	
	@Test(priority = 68)
	@Parameters({"keyword1"})
	public void verifyVideoExitEventAfterRefreshingPage(String keyword1) throws Exception {
		System.out.println("Verify Video Exit Event after refreshing a page");
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoExitEventAfterRefreshingPage(keyword1);
	}
	
	@Test(priority = 69)
	@Parameters({"keyword1"})
	public void verifyViewMoreSelectedEventFromPlaybackPage(String keyword1) throws Exception {
		System.out.println("Verify View More Selected Event For content played from Playback page");
		Zee5PWAWEBMixPanelBusinessLogic.verifyViewMoreSelectedEventFromPlaybackPage(keyword1);
	}
	
	
	@Test(priority = 70)
	public void verifyViewMoreSelectedEventFromTray() throws Exception {
		System.out.println("Verify View More Selected Event For content played from Tray");
		Zee5PWAWEBMixPanelBusinessLogic.verifyViewMoreSelectedEventFromTray();
	}
	
	@Test(priority = 71)
	@Parameters({ "userType" })
	public void verifySubscriptionPageViewedEventViaBuySubscription(String userType) throws Exception {
		System.out.println("Verify Subscription Page Viewed Event by clicking on Buy subscription in hamburger menu");
		Zee5PWAWEBMixPanelBusinessLogic.verifySubscriptionPageViewedEventViaBuySubscription(userType);
	}
	
	@Test(priority = 72)
	@Parameters({ "userType" })
	public void verifySubscriptionPageViewedEventViaPrepaidCode(String userType) throws Exception {
		System.out.println("Verify Subscription Page Viewed Event by clicking on prepaid code option in hamburger menu");
		Zee5PWAWEBMixPanelBusinessLogic.verifySubscriptionPageViewedEventViaPrepaidCode(userType);
	}
	
	@Test(priority = 73)
	@Parameters({ "userType" })
	public void verifySubscriptionSelectedEvent(String userType) throws Exception {
		System.out.println("Verify Subscription Selected Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifySubscriptionSelectedEvent(userType);
	}
	
	@Test(priority = 74)
	@Parameters({ "userType" })
	public void verifyPromoCodeResultEventForValid(String userType) throws Exception {
		System.out.println("Verify Promo Code Result Event For Valid code");
		Zee5PWAWEBMixPanelBusinessLogic.verifyPromoCodeResultEventForValid(userType);
	}
	
	@Test(priority = 75)
	@Parameters({ "userType" })
	public void verifyPromoCodeResultEventForInvalid(String userType) throws Exception {
		System.out.println("Verify Promo Code Result Event For Invalid code");
		Zee5PWAWEBMixPanelBusinessLogic.verifyPromoCodeResultEventForInvalid(userType);
	}
	
	@Test(priority = 76)
	@Parameters({ "userType" })
	public void verifySubscriptionSelectedEventByClubPack(String userType) throws Exception {
		System.out.println("Verify Subscription Selected Event By selecting Club Pack");
		Zee5PWAWEBMixPanelBusinessLogic.verifySubscriptionSelectedEventByClubPack(userType);
	}
	
	@Test(priority = 77)
	public void verifySessionEvent() throws Exception {
		System.out.println("Verify Session Event");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch(true);
	}
	
	@Test(priority = 78)
	@Parameters({ "userType" })
	public void verifyLoginResultEventForValidCredentials(String userType) throws Exception {
		System.out.println("Verify Login Result Event for Valid Credentials");
		Zee5PWAWEBMixPanelBusinessLogic.verifyLoginResultEventForValidCredentials(userType,"fbLogin");
	}
	
	@Test(priority = 79)
	@Parameters({ "userType" })
	public void verifyRegisterScreenDisplayEvent(String userType) throws Exception {
		System.out.println("Verify Register Screen Display Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyRegisterScreenDisplayEvent(userType);
	}
	
	@Test(priority = 80)
	@Parameters({ "userType", "keyword2" })
	public void verifyPopUpLaunchEventForGetPremiumPopUp(String userType, String keyword2) throws Exception {
		System.out.println("Verify Pop Up Launch Event when get premium popup is displayed on playing premium content");
		Zee5PWAWEBMixPanelBusinessLogic.verifyPopUpLaunchEventForGetPremiumPopUp(userType,keyword2);
	}
	
	
	@AfterClass
	public void tearDown() {
		Zee5PWAWEBMixPanelBusinessLogic.tearDown();
	}
}

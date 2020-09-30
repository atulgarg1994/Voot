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
	public void verifySkipRegistrationEvent(String userType, String keyword) throws Exception {
		System.out.println("Verify Skip Registration Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifySkipRegistrationEvent(userType);
		Zee5PWAWEBMixPanelBusinessLogic.verifySkipRegistrationEventDuringContentPlayback(userType, keyword);
	}

	@Test(priority = 4)
	@Parameters({ "userType", "keyword2" })
	public void verifyLoginScreenDisplayEvent(String userType, String keyword2) throws Exception {
		System.out.println("Verify Login Screen Display Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyLoginScreenDisplayEvent(userType, keyword2);
	}

	@Test(priority = 5)
	@Parameters({ "userType" })
	public void verifyLoginInitiatedEventForValidCredentials(String userType) throws Exception {
		System.out.println("Verify Login Initiated Event for Valid Credentials");
		Zee5PWAWEBMixPanelBusinessLogic.verifyLoginInitiatedEventForValidCredentials(userType);
	}

	@Test(priority = 6)
	@Parameters({ "userType" })
	public void verifyTVAuthenticationScreenDisplayEvent(String userType) throws Exception {
		System.out.println("Verify TV Authentication Screen Display Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyTVAuthenticationScreenDisplayEvent(userType);
	}

	@Test(priority = 7)
	@Parameters({ "userType", "keyword1", "keyword2" })
	public void verifySubscriptionPageViewedEvent(String userType, String keyword1, String keyword2) throws Exception {
		System.out.println("Verify Subscription Page Viewed Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifySubscriptionPageViewedEvent(userType, keyword1, keyword2);
	}

	@Test(priority = 8)
	@Parameters({ "userType" })
	public void verifyCarouselBannerClickEvent(String userType) throws Exception {
		System.out.println("Verify Carousel Banner Click Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyCarouselBannerClickEventAndVideoViewEvent(userType, "Home");
	}

	@Test(priority = 9)
	@Parameters({ "userType" })
	public void verifyThumbnailClickEvent(String userType) throws Exception {
		System.out.println("Verify Thumbnail Click Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyThumbnailClickEventAndVideoViewEvent(userType, "Shows");
	}

	@Test(priority = 10)
	@Parameters({ "userType", "keyword2" })
	public void verifyClearSearchHistoryEvent(String userType, String keyword3) throws Exception {
		System.out.println("Verify Clear Search Histroy Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifySearchExecutedAndClearSearchHistoryEvent(userType, keyword3);
	}

	@Test(priority = 12)
	@Parameters({ "userType", "keyword1", "keyword" })
	public void verifyAddAndRemoveFomWatchlistAndShareEvent(String userType, String keyword1, String keyword)
			throws Exception {
		System.out.println("Verify Add And Remove Fom Watchlist And Share Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyAddAndRemoveFomWatchlistAndShareEvent(userType, keyword1);
		System.out.println("Verify Add And Remove Fom Watchlist And Share Event From Show Detail Page");
		Zee5PWAWEBMixPanelBusinessLogic.verifyShareEventFromShowDetailPage(userType, keyword);
		System.out.println("Verify Add And Remove Fom Watchlist And Share Event By Mouse Hover");
		Zee5PWAWEBMixPanelBusinessLogic.verifyAddAndRemoveFomWatchlistAndShareEventByMouseHover(userType);
	}

	@Test(priority = 13)
	@Parameters({ "userType", "keyword1" })
	public void verifyQualityChangeEvent(String userType, String keyword1) throws Exception {
		System.out.println("Verify Quality Change Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyQualityChangeEvent(keyword1);
	}

	@Test(priority = 14)
	public void verifyDisplayAndContentLanguageChangeEvent() throws Exception {
		System.out.println("Verify Display And Content Language Change Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyDisplayAndContentLanguageChangeEvent();
	}

	@Test(priority = 15)
	@Parameters({ "userType", "keyword4", "keyword5" })
	public void verifyEvents(String userType, String keyword4, String keyword5) throws Exception {
		System.out.println("Verify Carousel Banner Swipe Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyCarouselBannerSwipeEvent();
		System.out.println("Verify Content Bucket Swipe Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyContentBucketSwipeEvent();
		System.out.println("Verify Ad Banner Impression Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdBannerImpressionEvent();
		System.out.println("Verify Default Setting Restored Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyDefaultSettingRestoredEvent(userType);
		System.out.println("Verify Set Reminder And Share Event For Upcoming Live Program Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifySetReminderAndShareEventForUpcomingLiveProgram(userType);
		System.out.println("Verify Change Password Started And Password Result Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyChangePasswordStartedAndPasswordResultEvent(userType);
		System.out.println("Verify Profile Update Result Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyProfileUpdateResultEvent(userType);
		System.out.println("Verify Video View And Video Exit Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoViewAndVideoExitEvent(userType, keyword4, keyword5);
	}

	@Test(priority = 16)
	@Parameters({ "userType" })
	public void verifyParentalRestrictionAndSettingChangedEvent(String userType) throws Exception {
		System.out.println("Verify Parental Restriction And Setting Changed Event");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch(true);
		Zee5PWAWEBMixPanelBusinessLogic.ZeeWEBPWAMixPanelLoginForParentalControl(userType);
		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalRestrictionAndSettingChangedEvent(userType);
	}

	@AfterClass
	public void tearDown() {
		Zee5PWAWEBMixPanelBusinessLogic.tearDown();
	}
}

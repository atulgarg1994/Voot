package com.zee5.MixpanelScripts;

import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5PWAWEBMixPanelBusinessLogic;

public class PWA_Web_Journey {

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
	public void verifySessionEvent() throws Exception {
		System.out.println("Verify Session Event");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch(true);
	}

	@Test(priority = 3)
	@Parameters({ "userType" })
	public void verifyCarouselBannerClickEvent(String userType) throws Exception {
		System.out.println("Verify Carousel Banner Click Event");
//		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyCarouselBannerClickEvent("Home");
	}

	

	@Test(priority = 8)
	@Parameters({ "userType" })
	public void verifyParentalRestriction(String userType) throws Exception {
		System.out.println("Verify Parental Restriction Event");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.ZeeWEBPWAMixPanelLoginForParentalControl(userType);
		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalRestrictionEvent(userType, "NoRestriction");
	}

	@Test(priority = 9)
	@Parameters({ "keyword1" })
	public void verifyClearSearchHistoryEvent(String keyword1) throws Exception {
		System.out.println("Verify Clear Search Histroy Event");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.clearSearchHistoryEvent(keyword1);
	}

	@Test(priority = 10)
	public void verifyScreenViewEvent() throws Exception {
		System.out.println("Verify Screen View Event");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyScreenViewEvent("Shows");
	}

	

	@Test(priority = 14)
	@Parameters({ "userType" })
	public void verifySetReminderEventForUpcomingProgram(String userType) throws Exception {
		System.out.println("Verify Set Reminder Event For Upcoming Program");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifySetReminderEventForUpcomingProgram(userType);
	}

	

	

	

	

	@Test(priority = 28)
	@Parameters({ "userType" })
	public void verifyChangePasswordStartedEvent(String userType) throws Exception {
		System.out.println("Verify Change Password Started Event");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyChangePasswordStartedEvent(userType);
	}

	@Test(priority = 29)
	@Parameters({ "userType" })
	public void verifyChangePasswordResultEvent(String userType) throws Exception {
		System.out.println("Verify Change Password Result Event");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyChangePasswordResultEvent(userType);
	}

	@Test(priority = 30)
	public void verifyDisplayLanguageChangeEvent() throws Exception {
		System.out.println("Verify Display Language Change Event");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyDisplayLanguageChangeEvent();
	}

	@Test(priority = 31)
	public void verifyContentLanguageChangeEvent() throws Exception {
		System.out.println("Verify Content Language Change Event");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyContentLanguageChangeEvent();
	}

	@Test(priority = 32)
	@Parameters({ "userType", "audioTrackContent" })
	public void verifyAdClickEventForFreeContent(String userType, String audioTrackContent) throws Exception {
		System.out.println("Verify Ad Click Event For Free Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdClickEventForFreeContent(userType, audioTrackContent);
	}

	@Test(priority = 33)
	@Parameters({ "userType", "keyword4" })
	public void verifyPauseEventForFreeContent(String userType, String keyword4) throws Exception {
		System.out.println("Verify Pause Event For Free Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyPauseEventForFreeContent(userType, keyword4);
	}

	@Test(priority = 34)
	public void verifyResumeEventForContentInMegamenu() throws Exception {
		System.out.println("Verify Resume Event For Content played from Megamenu");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyResumeEventForContentInMegamenu();
	}

	@Test(priority = 35)
	@Parameters({ "userType" })
	public void verifySettingChangedEventAfterAgeIsSet(String userType) throws Exception {
		System.out.println("Verify Setting Changed Event when Parental Control Age is Set");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.ZeeWEBPWAMixPanelLoginForParentalControl(userType);
		Zee5PWAWEBMixPanelBusinessLogic.verifySettingChangedEventAfterAgeIsSet(userType);
	}

	@Test(priority = 36)
	public void verifyDefaultSettingRestoredEvent() throws Exception {
		System.out.println("Verify Default Setting Restored Event");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyDefaultSettingRestoredEvent();
	}

	@Test(priority = 37)
	public void verifyCarouselBannerSwipeEvent() throws Exception {
		System.out.println("Verify Carousel Banner Swipe Event");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyCarouselBannerSwipeEvent("Shows");
	}

	@Test(priority = 38)
	@Parameters({ "keyword" })
	public void verifyContentBucketSwipeEventFromShowDetailPage(String keyword) throws Exception {
		System.out.println("Verify Content Bucket Swipe Event in Show Detail page");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyContentBucketSwipeEventFromShowDetailPage(keyword);
	}

	@Test(priority = 39)
	public void verifyContentBucketSwipeEvent() throws Exception {
		System.out.println("Verify Content Bucket Swipe Event");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyContentBucketSwipeEvent("Shows");
	}

	@Test(priority = 40)
	@Parameters({ "userType", "keyword1" })
	public void verifyContentBucketSwipeEventInPlaybackPage(String userType,String keyword1) throws Exception {
		System.out.println("Verify Quality Change Event");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyContentBucketSwipeEventInPlaybackPage(keyword1);
	}

	@Test(priority = 41)
	public void verifyCTAsEventForOptionInHamburger() throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		System.out.println("Verify CTAs Event when user clicks on any option in hamburger menu");
		Zee5PWAWEBMixPanelBusinessLogic.verifyCTAsEventForOptionInHamburger();
	}

	@Test(priority = 42)
	@Parameters({ "userType" })
	public void verifyLoginPasswordEnteredEvent(String userType) throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		System.out.println("Verify Login Password Entered Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyLoginUsernameEnteredEvent(userType, "Password");
	}

	@Test(priority = 43)
	@Parameters({ "userType" })
	public void verifyLoginUsernameEnteredEvent(String userType) throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		System.out.println("Verify Login Username Entered Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyLoginUsernameEnteredEvent(userType, "UserName");
	}

	@Test(priority = 44)
	public void verifySearchCancelledEvent() throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		System.out.println("Verify Search Cancelled Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifySearchCancelledEvent();
	}

	@Test(priority = 45)
	@Parameters({ "userType" })
	public void verifyProfileUpdateResultEvent(String userType) throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		System.out.println("Verify Profile Update Result Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyProfileUpdateResultEvent(userType);
	}

	@Test(priority = 46)
	public void verifyAdBannerImpressionEvent(String tabName) throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		System.out.println("Verify Ad Banner Impression Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyAdBannerImpressionEvent("Shows");
	}

	@Test(priority = 47)
	@Parameters({ "keyword" })
	public void verifyEpisodeListChosenEventFromShowDetailPage(String keyword) throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		System.out.println("Verify Episode List Chosen Event in Show Detail page");
		Zee5PWAWEBMixPanelBusinessLogic.verifyEpisodeListChosenEventFromShowDetailPage(keyword);
	}

	@Test(priority = 48)
	@Parameters({ "userType", "keyword6" })
	public void verifyPopUpCTAsEvent(String userType, String keyword6) throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		System.out.println("Verify Pop Up CTA's Event when user clicks on CTA button displayed on the popup");
		Zee5PWAWEBMixPanelBusinessLogic.verifyPopUpCTAsEvent(userType, keyword6);
	}

	@Test(priority = 49)
	@Parameters({ "userType" })
	public void verifyRecommendedRailImpressionEventByScrollingPage() throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		System.out.println(
				"Verify Recommended Rail Impression event when user is able to see the recommended tray by scrolling down the page");
		Zee5PWAWEBMixPanelBusinessLogic.verifyRecommendedRailImpressionEventByScrollingPage("Home", "Trending");
	}

	@Test(priority = 50)
	@Parameters({ "keyword" })
	public void verifyRecommendedRailImpressionEventInShowDetailPage(String keyword) throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		System.out.println("Verify Recommended Rail Impression Event In Show Detail Page");
		Zee5PWAWEBMixPanelBusinessLogic.verifyRecommendedRailImpressionEventInShowDetailPage(keyword, "Trending");
	}

	@Test(priority = 51)
	@Parameters({ "keyword1" })
	public void verifyRecommendedRailImpressionEventInConsumptionScreen(String keyword1) throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		System.out.println("Verify Recommended Rail Impression Event In Consumption Screen");
		Zee5PWAWEBMixPanelBusinessLogic.verifyRecommendedRailImpressionEventInConsumptionScreen(keyword1, "Trending");
	}

	@Test(priority = 52)
	@Parameters({ "userType", "keyword2" })
	public void verifyPopUpLaunchEventForGetPremiumPopUp(String userType, String keyword2) throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		System.out.println("Verify Pop Up Launch Event when get premium popup is displayed on playing premium content");
		Zee5PWAWEBMixPanelBusinessLogic.verifyPopUpLaunchEventForGetPremiumPopUp(userType, keyword2);
	}

	@Test(priority = 53)
	@Parameters({ "userType", "keyword" })
	public void verifyPopUpLaunchEventForRegisterPopUp(String userType, String keyword) throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		System.out.println("Verify Pop Up Launch Event when Native popup is displayed");
		Zee5PWAWEBMixPanelBusinessLogic.verifyPopUpLaunchEventForRegisterPopUp(userType, keyword);
	}

	@Test(priority = 54)
	@Parameters({ "userType" })
	public void verifyPopUpLaunchEventForCompleteProfilePopUp(String userType) throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		System.out.println("Verify Pop Up Launch Event when Complete Profile popup is displayed");
		Zee5PWAWEBMixPanelBusinessLogic.verifyPopUpLaunchEventForCompleteProfilePopUp(userType);
	}

	// Login through ClubUser Id
	@Test(priority = 55)
	@Parameters({ "userType", "keyword6" })
	public void verifyPopUpLaunchEventForClubUser(String userType, String keyword6) throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		System.out.println("Verify Pop Up Launch Event when user gets Upgrade popup for Club User");
		Zee5PWAWEBMixPanelBusinessLogic.verifyPopUpLaunchEventForClubUser(userType, keyword6);
	}

	@Test(priority = 56)
	@Parameters({ "userType" })
	public void verifyToastMessageImpressionEventInSignInScreen(String userType) throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		System.out.println("Verify Toast Message Impression Event In Sign In Screen");
		Zee5PWAWEBMixPanelBusinessLogic.verifyToastMessageImpressionEventInSignInScreen(userType);
	}

	@Test(priority = 57)
	@Parameters({ "userType" })
	public void verifyToastMessageImpressionEventInPaymentPage(String userType) throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		System.out.println("Verify Toast Message Impression Event in payment page");
		Zee5PWAWEBMixPanelBusinessLogic.verifyToastMessageImpressionEventInPaymentPage(userType);
	}

	@Test(priority = 58)
	@Parameters({ "userType" })
	public void verifyToastMessageImpressionEventInOTPScreen(String userType) throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		System.out.println("Verify Toast Message Impression Event In OTP Screen");
		Zee5PWAWEBMixPanelBusinessLogic.verifyToastMessageImpressionEventInOTPScreen(userType);
	}

	@Test(priority = 59)
	@Parameters({ "userType" })
	public void verifyToastMessageImpressionEventInSignUpScreen(String userType) throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		System.out.println("Verify Toast Message Impression Event In Sign Up Screen");
		Zee5PWAWEBMixPanelBusinessLogic.verifyToastMessageImpressionEventInSignUpScreen(userType);
	}

	@Test(priority = 60)
	public void verifyToastMessageImpressionEventAfterResetSettingsToDefault() throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		System.out.println("Verify Toast Message Impression Event After Reset Settings To Default");
		Zee5PWAWEBMixPanelBusinessLogic.verifyToastMessageImpressionEventAfterResetSettingsToDefault();
	}

	@Test(priority = 61)
	@Parameters({ "userType" })
	public void verifyToastMessageImpressionEventInParentalControlScreen(String userType) throws Exception {
		System.out.println("Verify Toast Message Impression Event In Parental Control Screen");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.ZeeWEBPWAMixPanelLoginForParentalControl(userType);
		Zee5PWAWEBMixPanelBusinessLogic.verifyToastMessageImpressionEventInParentalControlScreen(userType);
	}

	@Test(priority = 62)
	@Parameters({ "userType" })
	public void verifyToastMessageImpressionEventInAuthenticateScreen(String userType) throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		System.out.println("Verify Toast Message Impression Event In Authenticate Screen");
		Zee5PWAWEBMixPanelBusinessLogic.verifyToastMessageImpressionEventInAuthenticateScreen(userType);
	}

	@Test(priority = 63)
	@Parameters({ "userType" })
	public void verifyToastMessageImpressionEventForAddToWatchlist(String userType) throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		System.out.println("Verify Toast Message Impression Event after adding card to watchlist");
		Zee5PWAWEBMixPanelBusinessLogic.verifyToastMessageImpressionEventForAddToWatchlist(userType);
	}

	@Test(priority = 64)
	@Parameters({ "userType" })
	public void verifyToastMessageImpressionEventForRemoveFomWatchlist(String userType) throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		System.out.println("Verify Toast Message Impression Event after removing card from watchlist");
		Zee5PWAWEBMixPanelBusinessLogic.verifyToastMessageImpressionEventForRemoveFomWatchlist(userType);
	}

	@Test(priority = 65)
	@Parameters({ "userType", "keyword1" })
	public void verifyToastMessageImpressionEventForEmbedPopUp(String userType, String keyword1) throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		System.out.println("Verify Toast Message Impression Event when user gets a toast message in embed popup");
		Zee5PWAWEBMixPanelBusinessLogic.verifyToastMessageImpressionEventForEmbedPopUp(userType, keyword1);
	}

	@Test(priority = 66)
	@Parameters({ "userType" })
	public void verifyToastMessageImpressionEventAfterUpdatingProfile(String userType) throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		System.out.println("Verify Toast Message Impression event when user updates the profile details");
		Zee5PWAWEBMixPanelBusinessLogic.verifyToastMessageImpressionEventAfterUpdatingProfile(userType);
	}

	@Test(priority = 67)
	@Parameters({ "userType" })
	public void verifyToastMessageImpressionEventInPackSelectionPage(String userType) throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		System.out.println("Verify Toast Message Impression event in pack selection page");
		Zee5PWAWEBMixPanelBusinessLogic.verifyToastMessageImpressionEventInPackSelectionPage(userType);
	}

	@Test(priority = 68)
	@Parameters({ "userType" })
	public void verifyToastMessageImpressionEventAfterChangingPassword(String userType) throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		System.out.println("Verify Toast Message Impression event when user changes the password");
		Zee5PWAWEBMixPanelBusinessLogic.verifyToastMessageImpressionEventAfterChangingPassword(userType);
	}

	@Test(priority = 69)
	@Parameters({ "userType" })
	public void verifyPopupLaunchEventTriggerforParentControl(String userType) throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		System.out.println("Verify Toast Message Impression event when user changes the password");
		Zee5PWAWEBMixPanelBusinessLogic.verifyPopupLaunchEventTriggerforParentControl(userType);
	}
	
	@AfterClass
	public void tearDown() {
		Zee5PWAWEBMixPanelBusinessLogic.tearDown();
	}

}

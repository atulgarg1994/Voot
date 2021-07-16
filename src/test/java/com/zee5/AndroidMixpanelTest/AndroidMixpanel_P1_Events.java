package com.zee5.AndroidMixpanelTest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5ApplicasterMixPanelBusinessLogic;
import com.utility.Utilities;

public class AndroidMixpanel_P1_Events {

private Zee5ApplicasterMixPanelBusinessLogic Zee5ApplicasterMixPanelBusinessLogic;
	
	@BeforeTest
	public void init() throws Exception {
		Utilities.relaunch = true;
		Zee5ApplicasterMixPanelBusinessLogic = new Zee5ApplicasterMixPanelBusinessLogic("zee");
	}

	@Test(priority = 1)
	@Parameters({ "userType" })
	public void AndroidAppMixPanelLogin(String userType) throws Exception {
		System.out.println("\nLogin");
		Zee5ApplicasterMixPanelBusinessLogic.navigateToHomeScreen();
		Zee5ApplicasterMixPanelBusinessLogic.ZeeApplicasterLogin(userType);
	}
	
	@Test(priority = 2)
	@Parameters({ "userType", "clipContent" })
	public void AdInitializedEvent_Search(String usertype, String clipContent) throws Exception {
		System.out.println("\nAd initialized event of content");
		//Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.AdInitializedEventOfcontentFromSearchPage(usertype, clipContent);
	}
	
	@Test(priority = 3)
	@Parameters({ "userType", "clipContent" })
	public void AdViewEvent_Search(String usertype, String clipContent) throws Exception {
		System.out.println("\nAd view event of Carousel content");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.AdViewEventOfcontentFromSearchPage(usertype, clipContent);
	}
	
	@Test(priority = 4)
	@Parameters({ "userType", "clipContent" })
	public void AdClickEvent_Search(String usertype, String clipContent) throws Exception {
		System.out.println("\nAd click event of Carousel content");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.AdClickEventOfcontentFromSearchPage(usertype, clipContent);
	}
	
	@Test(priority = 5)
	@Parameters({"userType"})
	public void AndroidMixPanel_CTAsEventValidation(String pUserType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.navigateToHomeScreen();
		Zee5ApplicasterMixPanelBusinessLogic.ZeeApplicasterLogin(pUserType);
		Zee5ApplicasterMixPanelBusinessLogic.verifyCTAsEvent(pUserType,"Subscribe");
	}
	
	@Test(priority = 6)
	@Parameters({"userType","keyword9"})
	public void MixPanel_SearchButtonClickEventValidation(String pUserType,String pContentName) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.navigateToHomeScreen();
		Zee5ApplicasterMixPanelBusinessLogic.ZeeApplicasterLogin(pUserType);
		Zee5ApplicasterMixPanelBusinessLogic.SearchButtonClickEventValidation(pUserType, pContentName);
	}
	
	@Test(priority = 7)
	@Parameters({"userType","keyword9"})
	public void MixPanel_SearchResultClickedEventValidation(String pUserType,String pContentName) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.navigateToHomeScreen();
		Zee5ApplicasterMixPanelBusinessLogic.ZeeApplicasterLogin(pUserType);
		Zee5ApplicasterMixPanelBusinessLogic.SearchResultClickedEventValidation(pUserType, pContentName);
	}
	
	@Test(priority = 8)
	@Parameters({"userType"})
	public void MixPanel_PopUpLaunchEventValidation(String pUserType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.navigateToHomeScreen();
		Zee5ApplicasterMixPanelBusinessLogic.ZeeApplicasterLogin(pUserType);
		Zee5ApplicasterMixPanelBusinessLogic.PopupLaunchEventValidation(pUserType);
	}
	
	@Test(priority = 9)
	@Parameters({"userType"})
	public void MixPanel_PopupCTAEventValidation(String pUserType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.navigateToHomeScreen();
		Zee5ApplicasterMixPanelBusinessLogic.ZeeApplicasterLogin(pUserType);
		Zee5ApplicasterMixPanelBusinessLogic.PopupCTAEventValidation(pUserType);
	}
	
	@Test(priority = 10)
	@Parameters({"userType"})
	public void AndroidMixPanel_LoginInitiatedEventValidation(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.navigateToHomeScreen();
		Zee5ApplicasterMixPanelBusinessLogic.ZeeApplicasterLogin(userType);
		Zee5ApplicasterMixPanelBusinessLogic.verifyLoginInitiatedEvent(userType, "mobileNumberLogin");
	}
	
	@Test(priority = 11)
	@Parameters({"userType"})
	public void AndroidMixPanel_LoginResultEventValidation(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.navigateToHomeScreen();
		Zee5ApplicasterMixPanelBusinessLogic.ZeeApplicasterLogin(userType);
		Zee5ApplicasterMixPanelBusinessLogic.verifyLoginResultEvent(userType, "mobileNumberLogin");
	}
	
	@Test(priority = 12)
	@Parameters({"userType"})
	public void AndroidMixPanel_LoginScreenDisplayEventValidation(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.navigateToHomeScreen();
		Zee5ApplicasterMixPanelBusinessLogic.ZeeApplicasterLogin(userType);
		Zee5ApplicasterMixPanelBusinessLogic.verifyLoginScreenDisplayEvent(userType,"emailLogin");
	}
	
	@Test(priority = 13)
	@Parameters({"userType"})
	public void MixPanel_RegistrationEventsValidation(String pUserType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.navigateToHomeScreen();
		Zee5ApplicasterMixPanelBusinessLogic.ZeeApplicasterLogin(pUserType);
		Zee5ApplicasterMixPanelBusinessLogic.RegistrationEventValidation(pUserType);
	}
	
	@Test(priority = 14)
	@Parameters({"userType"})
	public void MixPanel_SubscriptionJourneyEventValidation(String pUserType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.navigateToHomeScreen();
		Zee5ApplicasterMixPanelBusinessLogic.ZeeApplicasterLogin(pUserType);
		Zee5ApplicasterMixPanelBusinessLogic.SubscriptionJourneyEventValidation(pUserType);
	}
	
	@Test(priority = 15)
	@Parameters({"userType", "displayLanguage"})
	public void verifyDisplayLanguageChangeEvent(String userType, String displayLanguage) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.navigateToHomeScreen();
		Zee5ApplicasterMixPanelBusinessLogic.ZeeApplicasterLogin(userType);
		Zee5ApplicasterMixPanelBusinessLogic.verifyDisplayLanguageChangeEvent(userType, displayLanguage);
	}
	
	@Test(priority = 16)
	@Parameters({"userType", "displayLanguage"})
	public void verifyContentLanguageChangeEvent(String userType, String displayLanguage) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.navigateToHomeScreen();
		Zee5ApplicasterMixPanelBusinessLogic.ZeeApplicasterLogin(userType);
		Zee5ApplicasterMixPanelBusinessLogic.verifyContentLanguageChangeEvent(userType);
	}
	
	@Test(priority = 17)
	@Parameters({"userType"})
	public void AndroidMixPanel_CarouselBannerClickEventValidation(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.navigateToHomeScreen();
		Zee5ApplicasterMixPanelBusinessLogic.ZeeApplicasterLogin(userType);
		Zee5ApplicasterMixPanelBusinessLogic.verifyCarousalBannerClickEvent(userType,"Home");
	}
	
	@Test(priority = 18)
	@Parameters({"userType","pTabName"})
	public void VerifyThumbnailClickEvent(String userType,String pTabName) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.navigateToHomeScreen();
		Zee5ApplicasterMixPanelBusinessLogic.ZeeApplicasterLogin(userType);
		Zee5ApplicasterMixPanelBusinessLogic.JourneyToThumbnailClickEvent(userType,pTabName);
		Zee5ApplicasterMixPanelBusinessLogic.EventValidation(userType, "Thumbnail Click","Homepage","More");
	}
	
	@Test(priority = 19)
	@Parameters({"userType"})
	public void AndroidMixPanel_CarouselBannerSwipeEventValidation(String userType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.navigateToHomeScreen();
		Zee5ApplicasterMixPanelBusinessLogic.ZeeApplicasterLogin(userType);
		Zee5ApplicasterMixPanelBusinessLogic.verifyCarouselBannerSwipeEvent(userType,"Home");
	}
	
	@Test(priority = 20)
	@Parameters({"userType","pTabName"})
	public void AndroidMixPanel_VideoWatchDurationEventValidation(String userType,String pTabName) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.navigateToHomeScreen();
		Zee5ApplicasterMixPanelBusinessLogic.ZeeApplicasterLogin(userType);
		Zee5ApplicasterMixPanelBusinessLogic.JourneyForVideoWatchDurationEvent(userType, pTabName);
		Zee5ApplicasterMixPanelBusinessLogic.EventValidation(userType, "Video Watch Duration","ConsumptionPage","Homepage");
	}
	
	@Test(priority = 21)
	@Parameters({"userType","firstEpisode"})
	public void MixPanel_af_svod_first_episode_free_EventValidation(String userType,String firstEpisode) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.navigateToHomeScreen();
		Zee5ApplicasterMixPanelBusinessLogic.ZeeApplicasterLogin(userType);
		Zee5ApplicasterMixPanelBusinessLogic.verify_af_svod_first_episode_free_Event(userType, firstEpisode);
	}
	
	@Test(priority = 22)
	@Parameters({ "userType","pTabName"})
	public void VideoViewEvent_TopNavigation(String userType,String pTabName) throws Exception {
		System.out.println("\nVideo View event validation from "+pTabName+" tab navigation");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.navigateToHomeScreen();
		Zee5ApplicasterMixPanelBusinessLogic.ZeeApplicasterLogin(userType);
		Zee5ApplicasterMixPanelBusinessLogic.videoViewEventFromTopNavigationPage(userType, pTabName);
	}
	
	@Test(priority = 23)
	@Parameters({"userType", "pTabName"})
	public void verifyScreenViewEvent(String userType, String pTabName) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.navigateToHomeScreen();
		Zee5ApplicasterMixPanelBusinessLogic.ZeeApplicasterLogin(userType);
		Zee5ApplicasterMixPanelBusinessLogic.verifyScreenViewEvent(userType);
	}
	
	
	@AfterTest
	public void tearDownApp() {
		System.out.println("\nExecution Complete - Reports Generated");
		Zee5ApplicasterMixPanelBusinessLogic.tearDown();
	}
	
}

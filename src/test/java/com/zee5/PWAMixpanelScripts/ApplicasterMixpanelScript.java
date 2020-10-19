package com.zee5.PWAMixpanelScripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5ApplicasterMixPanelBusinessLogic;
import com.utility.Utilities;

public class ApplicasterMixpanelScript {

	private Zee5ApplicasterMixPanelBusinessLogic Zee5ApplicasterMixPanelBusinessLogic;

	@BeforeTest
	public void init() throws Exception {
		Utilities.relaunch = true;
		Zee5ApplicasterMixPanelBusinessLogic = new Zee5ApplicasterMixPanelBusinessLogic("zee");
	}

	@Test(priority = 1)
	@Parameters({ "userType" })
	public void PWAWEBMixPanelLogin(String userType) throws Exception {
		System.out.println("Login");
		Zee5ApplicasterMixPanelBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		Zee5ApplicasterMixPanelBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		Zee5ApplicasterMixPanelBusinessLogic.ZeeApplicasterLogin(userType);
		
	}

	@Test(priority = 2)
	@Parameters({ "userType" })
	public void verifySkipLoginEvent(String userType) throws Exception {
		System.out.println("Verify Skip Login Event");
		Zee5ApplicasterMixPanelBusinessLogic.verifySkipLoginEvent(userType);
	}
	
	@Test(priority = 3)
	@Parameters({ "userType", "keyword2" })
	public void verifySkipLoginByClickingOnLoginInGetPremiumPopUp(String userType, String keyword2) throws Exception {
		System.out.println("Verify Skip Login Event during content playback post clicking on login button in Get Premium popup");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifySkipLogin_LoginInGetPremiumPopUp(userType, keyword2);
	}
	
	@Test(priority = 4)
	@Parameters({ "userType"})
	public void verifyLogoutEvent(String userType) throws Exception {
		System.out.println("Verify Logout Event");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyLogoutEvent(userType);
	}
	
	@Test(priority = 5)
	@Parameters({ "userType" })
	public void verifyLoginScreenDisplayEventByClickingOnLoginButton(String userType) throws Exception {
		System.out.println("Verify Login Screen Display Event By Clicking On Login Button");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyLoginScreenDisplayEventByClickingOnLoginButton(userType);
	}
	
	@Test(priority = 6)
	@Parameters({ "userType", "keyword2" })
	public void verifyLoginScreenDisplayEventByClickingOnLoginButtonOnPlayer(String userType, String keyword2) throws Exception {
		System.out.println("Verify Login Screen Display Event By Clicking On Login Button On Player");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyLoginScreenDisplayEventByClickingOnLoginButtonOnPlayer(userType, keyword2);
	}
	
	@Test(priority = 7)
	@Parameters({ "userType", "keyword2" })
	public void verifyLoginScreenDisplayEventByClickingOnLoginButtonInGetPremiumPopUp(String userType, String keyword2) throws Exception {
		System.out.println("Verify Login Screen Display Event By Clicking On Login Button In Get Premium Pop Up");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyLoginScreenDisplayEventByClickingOnLoginButtonInGetPremiumPopUp(userType, keyword2);
	}
	
	@Test(priority = 8)
	@Parameters({ "userType" })
	public void verifyLoginInitiatedEventForValidCredentials(String userType) throws Exception {
		System.out.println("Verify Login Initiated Event for Valid Credentials");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyLoginInitiatedEventForValidCredentials(userType,"fbLogin");
	}
	
	@Test(priority = 10)
	@Parameters({ "userType" })
	public void verifyLoginResultEventForValidCredentials(String userType) throws Exception {
		System.out.println("Verify Login Result Event for Valid Credentials");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyLoginResultEventForValidCredentials(userType,"fbLogin");
	}
	
	@Test(priority = 11)
	@Parameters({ "userType" })
	public void verifyTVAuthenticationScreenDisplayEvent(String userType) throws Exception {
		System.out.println("Verify TV Authentication Screen Display Event");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyTVAuthenticationScreenDisplayEvent(userType);
	}
	
	@Test(priority = 12)
	@Parameters({ "userType" })
	public void verifySubscriptionPageViewedEventViaBuySubscription(String userType) throws Exception {
		System.out.println("Verify Subscription Page Viewed Event by clicking on Buy subscription in more menu");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifySubscriptionPageViewedEventViaBuySubscription(userType);
	}
	
	@Test(priority = 13)
	@Parameters({ "userType", "keyword2" })
	public void verifySubscriptionpageViewedEventByClickingGetPremiumCTAOnCarousel(String userType, String keyword2) throws Exception {
		System.out.println("Verify Login Screen Display Event By Clicking On Login Button On Player");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyLoginScreenDisplayEventByClickingOnLoginButtonOnPlayer(userType, keyword2);
	}
	
	@Test(priority = 14)
	@Parameters({ "userType" })
	public void verifySubscriptionPageViewedEventViaSubscribeBtn(String userType) throws Exception {
		System.out.println("Verify Subscription Page Viewed Event by clicking on Subscribe button at header");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifySubscriptionPageViewedEventViaSubscribeBtn(userType);
	}
	
	@Test(priority = 15)
	@Parameters({ "userType" })
	public void verifySubscriptionSelectedEvent(String userType) throws Exception {
		System.out.println("Verify Subscription Selected Event");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifySubscriptionSelectedEvent(userType);
	}
	
	@Test(priority = 16)
	@Parameters({ "userType" })
	public void verifySubscriptionSelectedEventByClubPack(String userType) throws Exception {
		System.out.println("Verify Subscription Selected Event By selecting Club Pack");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifySubscriptionSelectedEventByClubPack(userType);
	}
	
	@Test(priority = 17)
	@Parameters({ "userType" })
	public void verifyPromoCodeResultEventForValid(String userType) throws Exception {
		System.out.println("Verify Promo Code Result Event For Valid code");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyPromoCodeResultEventForValid(userType);
	}
	
	@Test(priority = 18)
	@Parameters({ "userType" })
	public void verifyPromoCodeResultEventForInvalid(String userType) throws Exception {
		System.out.println("Verify Promo Code Result Event For Invalid code");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyPromoCodeResultEventForInvalid(userType);
	}
	
	@Test(priority = 19)
	public void verifyCarouselBannerClickEvent() throws Exception {
		System.out.println("Verify Carousel Banner Click Event");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyCarouselBannerClickEvent();
	}
	
	@Test(priority = 20)
	public void verifyThumbnailClickEventFromTray() throws Exception {
		System.out.println("Verify Thumbnail Click Event form Tray");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyThumbnailClickEventFromTray();
	}
	
	@Test(priority = 21)
	@Parameters({ "keyword2" })
	public void verifyThumbnailClickEventByClickingThumbnialFromPlaybackPage(String keyword2) throws Exception {
		System.out.println("Verify Thumbnail Click Event form Tray from playback page");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyThumbnailClickEventFromTrayInPlayBackPage(keyword2);
	}
	
	@Test(priority = 22)
	@Parameters({ "userType", "keyword2" })
	public void verifySubscriptionPageViewedEventByClickingSubscriptionbelowThePlayer(String usertype, String keyword2) throws Exception {
		System.out.println("Verify Subscription page viewed event by clicking Subscription CTA below the player in consumption page");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifySubscriptionPageViewedEventByClickingSubscriptionbelowThePlayer(usertype, keyword2);
	}
	
	@Test(priority = 23)
	@Parameters({ "keyword1" })
	public void verifyClearSearchHistoryEvent(String keyword1) throws Exception {
		System.out.println("Verify Clear Search Histroy Event");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.clearSearchHistoryEvent( keyword1);
	}
	
	@Test(priority = 24)
	public void verifyScreenViewEvent() throws Exception {
		System.out.println("Verify Screen View Event");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyScreenViewEvent("Shows");
	}
	
	@Test(priority = 25)
	public void verifyViewMoreSelectedEventFromTray() throws Exception {
		System.out.println("Verify View More Selected Event For content played from Tray");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyViewMoreSelectedEventFromTray();
	}
	
	@Test(priority = 26)
	@Parameters({"keyword2"})
	public void verifyViewMoreSelectedEventFromPlaybackPage(String keyword2) throws Exception {
		System.out.println("Verify View More Selected Event For content played from Playback page");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyViewMoreSelectedEventFromPlaybackPage(keyword2);
	}
	
	@Test(priority = 27)
	public void verifySearchButtonClickEvent() throws Exception {
		System.out.println("Verify Search Button Click Event");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifySearchButtonClickEvent();
	}
	
	@Test(priority = 28)
	@Parameters({"keyword2"})
	public void verifySearchExecutedEvent(String keyword2) throws Exception {
		System.out.println("Verify Clear Search Histroy Event");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifySearchExecutedEvent(keyword2);
	}
	
	@Test(priority = 29)
	@Parameters({"keyword2"})
	public void verifySearchResultClickedEvent(String keyword2) throws Exception {
		System.out.println("Verify Search Result Clicked Event");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifySearchResultClickedEvent(keyword2);
	}
	
}

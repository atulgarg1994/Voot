package com.zee5.MixpanelScripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.business.zee.Zee5PWAWEBMixPanelBusinessLogic;

public class HL_PWA_WEB_Mixpanel {
	
private Zee5PWAWEBMixPanelBusinessLogic zee5PWABusinessLogic;
	
	
	@BeforeTest
	public void init() throws InterruptedException
	{
		zee5PWABusinessLogic = new Zee5PWAWEBMixPanelBusinessLogic("Chrome");
	}

	
	
//	@Test(priority = 1)
	@Parameters({ "userType" })
	public void PWAWEBLoginUserType(String userType) throws Exception
	{
	//	zee5PWABusinessLogic.launchURL();
	//	zee5PWABusinessLogic.dismissDisplayContentLanguagePopUp();
	//	zee5PWABusinessLogic.ZeeWEBPWALogin(userType);
	}


	
	//==============================LoginInitiated Event=================================
	@Test(priority = 2)
	@Parameters({ "userType" })
	public void verifyLoginInitiatedEvent(String userType) throws Exception {
		System.out.println("Verify Login Initiated Event");
		zee5PWABusinessLogic.relaunch();
		zee5PWABusinessLogic.verifyLoginInitiatedEventForInvalidCredentials(userType,"mobileNumberLogin");
	}

	
	//==============================LoginResult Event=================================
	@Test(priority = 3)
	@Parameters({ "userType"})
	public void verifyLoginResultEventForInvalidCredentials(String userType) throws Exception {
		System.out.println("Verify Login Result Event post entering invalid credentials");
		zee5PWABusinessLogic.relaunch();
		zee5PWABusinessLogic.verifyLoginResultEventForInvalidCredentials(userType,"mobileNumberLogin");
	}

	
	//============================RegistrationInitiated Event=======================================
	@Test(priority = 4)
	@Parameters({ "userType"})
	public void verifyRegistrationInitiatedEventForInvalidCredentials(String userType) throws Exception {
		System.out.println("Verify Registration Initiated Event post entering invalid credentials");
		zee5PWABusinessLogic.relaunch();
		zee5PWABusinessLogic.verifyRegistrationInitiatedEventForInvalidCredentials(userType);
	}
		

	//=============================RegistrationResultEvent=======================================
	
		@Test(priority = 5)
		@Parameters({ "userType"})
		public void verifyRegistrationResultEventForInvalidCredentials(String userType) throws Exception {
			System.out.println("Verify Registration Result Event post entering invalid credentials");
			zee5PWABusinessLogic.relaunch();
			zee5PWABusinessLogic.verifyRegistrationResultEventForInvalidCredentials(userType);
		}

	
	
		//===============================SubscriptionPageViewedEvent=================================
		@Test(priority = 6)
		@Parameters({ "userType" })
		public void verifySubscriptionPageViewedEventViaSubscribeBtn(String userType) throws Exception {
			System.out.println("Verify Subscription Page Viewed Event by clicking on Subscribe button at header");
			zee5PWABusinessLogic.relaunch();
			zee5PWABusinessLogic.verifySubscriptionPageViewedEventViaSubscribeBtn(userType);
		}

		//===============================SubscriptionSelectedEvent=================================
		@Test(priority = 7)
		@Parameters({ "userType" })
		public void verifySubscriptionSelectedEvent(String userType) throws Exception {
			System.out.println("Verify Subscription Selected Event");
			zee5PWABusinessLogic.relaunch();
			zee5PWABusinessLogic.verifySubscriptionSelectedEvent(userType);
		}
		
		
		//=============================SubscriptionCallInitiated==================================
		
		@Test(priority = 8)
		@Parameters({ "userType"})
		public void verifySubscriptionCallInitiatedEvent(String userType) throws Exception {
			System.out.println("Verify Subscription Call Initiated Event for All access pack");
			zee5PWABusinessLogic.relaunch();
			zee5PWABusinessLogic.verifySubscriptionCallInitiatedEvent(userType);
		}

		
		//=============================SubscriptionCallReturned===================================
		@Test(priority = 9)
		@Parameters({ "userType"})
		public void verifySubscriptionCallReturnedEvent(String userType) throws Exception {
			System.out.println("Verify Subscription Call Returned Event when user makes unsuccessful transaction by quitting the payment gateway screen");
			zee5PWABusinessLogic.relaunch();
			zee5PWABusinessLogic.verifySubscriptionCallReturnedEvent(userType);
		}

		
		//=============================Thumbnail Click Event===================================
		@Test(priority = 10)
		
		public void verifyThumbanilClickEvent() throws Exception {
			System.out.println("Verify Thumbnail Click Event");
			zee5PWABusinessLogic.relaunch();
			zee5PWABusinessLogic.verifyThumbnailClickEventFromTray("Home");
		}

		
		
		//=============================ContentBucketSwipe Event===================================
		@Test(priority = 11)
		public void verifyContentBucketSwipeEvent() throws Exception {
			System.out.println("Verify Content Bucket Swipe Event");
			zee5PWABusinessLogic.relaunch();
			zee5PWABusinessLogic.verifyContentBucketSwipeEvent("Shows");
		}
		
		
		//=============================CarouselBannerSwipe Event===================================
		@Test(priority = 12)
		public void verifyCarouselBannerSwipeEvent() throws Exception {
			System.out.println("Verify Carousel Banner Swipe Event");
			zee5PWABusinessLogic.relaunch();
			zee5PWABusinessLogic.verifyCarouselBannerSwipeEvent("Shows");
		}
		
		
		//=============================CarouselBannerClick Event===================================
		@Test(priority = 13)
		public void verifyCarouselBannerClickEvent() throws Exception {
			System.out.println("Verify Carousel Banner Click Event");
			zee5PWABusinessLogic.relaunch();
			zee5PWABusinessLogic.verifyCarouselBannerClickEvent("Home");
		}

		
		//=============================SearchButtonClick Event===================================
		@Test(priority = 14)
		@Parameters({ "userType" })
		public void verifySearchButtonClickEvent() throws Exception {
			System.out.println("Verify Search Button Click Event");
			zee5PWABusinessLogic.relaunch();
			zee5PWABusinessLogic.verifySearchButtonClickEvent();
		}

		
		//=============================SearchResultClick Event===================================
		@Test(priority = 15)
		public void verifySearchResultClickedEvent() throws Exception {
			System.out.println("Verify Search Result Clicked Event");
			zee5PWABusinessLogic.relaunch();
			zee5PWABusinessLogic.verifySearchResultClickedEvent("Gattimela");
		}

		
		//=============================SearchExecuted Event===================================
		@Test(priority = 16)
		public void verifySearchExecutedEvent() throws Exception {
			System.out.println("Verify Search Executed Event");
			zee5PWABusinessLogic.relaunch();
			zee5PWABusinessLogic.verifySearchExecutedEvent();
		}

		
		//=============================VideoView Event===================================
		@Test(priority = 17)
		@Parameters({ "userType", "keyword4"})
		public void verifyVideoViewEventForFreeContent(String userType,String keyword4) throws Exception {
			System.out.println("Verify Video View Event For Free Content");
			zee5PWABusinessLogic.relaunch();
			zee5PWABusinessLogic.verifyVideoViewEventForFreeContent(userType,keyword4);
		}


		//=============================Pause Event===================================
		@Test(priority = 18)
		@Parameters({ "userType", "keyword4"})
		public void verifyPauseViewEventForFreeContent(String userType,String keyword4) throws Exception {
			System.out.println("Verify Pause Event For Free Content");
			zee5PWABusinessLogic.relaunch();
			zee5PWABusinessLogic.verifyPauseEventForFreeContent(userType,keyword4);
		}

		
		//=============================Resume Event===================================
		@Test(priority = 19)
		@Parameters({ "userType", "keyword4"})
		public void verifyResumeEventForFreeContent(String userType,String keyword4) throws Exception {
			System.out.println("Verify Resume Event For Free Content");
			zee5PWABusinessLogic.relaunch();
			zee5PWABusinessLogic.verifyResumeEventForFreeContent(userType,keyword4);
		}
		
		
		//=============================AutoSeek Event===================================
		@Test(priority = 20)
		@Parameters({ "userType", "keyword4"})
		public void verifyAutoSeekEventForFreeContent(String userType,String keyword4) throws Exception {
			System.out.println("Verify AutoSeek Event For Free Content");
			zee5PWABusinessLogic.relaunch();
			zee5PWABusinessLogic.verifyAutoSeekForwardEventForFreeContent(userType,keyword4);
		}
		
		
		//=============================SeekScrub Event===================================
		@Test(priority = 21)
		@Parameters({ "userType", "keyword4"})
		public void verifySeekScrubEventForFreeContent(String userType,String keyword4) throws Exception {
			System.out.println("Verify SeekScrub Event For Free Content");
			zee5PWABusinessLogic.relaunch();
			zee5PWABusinessLogic.verifyScrubSeekEventForFreeContent(userType,keyword4);
		}
		
		
		
		
		
		//=============================ADInitialised Event===================================
		@Test(priority = 22)
		@Parameters({ "userType", "keyword4"})
		public void verifyAdInitializedEventForFreeContent(String userType, String keyword4) throws Exception {
			System.out.println("Verify Ad Initialized Event For Free Content");
			zee5PWABusinessLogic.relaunch();
			zee5PWABusinessLogic.verifyAdInitializedEventForFreeContent(userType,keyword4);
		}

		
		//=============================ADView Event===================================
		@Test(priority = 23)
		@Parameters({ "userType", "audioTrackContent"})
		public void verifyAdViewEventForFreeContent(String userType,String audioTrackContent) throws Exception {
			System.out.println("Verify Ad View Event For Free Content");
			zee5PWABusinessLogic.relaunch();
			zee5PWABusinessLogic.verifyAdViewEventForFreeContent(userType,audioTrackContent);
		}

		
		//=============================ADWatchDuration Event===================================
		@Test(priority = 24)
		@Parameters({ "userType", "subtitleTrackContent"})
		public void verifyAdWatchDurationEventForFreeContentForceExit(String userType,String subtitleTrackContent) throws Exception {
			System.out.println("Verify Ad Watch Duration Event when user force quits the ad playback for free content");
			zee5PWABusinessLogic.relaunch();
			zee5PWABusinessLogic.verifyAdWatchDurationEventForFreeContentForceExit(userType,subtitleTrackContent);
		}

		
		
		//=============================RentalPurchaseCallInitiated Event==================================
		
		@Test(priority = 25)
		@Parameters({ "userType"})
		public void verifyRentalPurchaseCallInitiatedEvent(String userType) throws Exception {
			System.out.println("Verify RentalPurchase Call Initiated Event for All access pack");
			zee5PWABusinessLogic.relaunch();
			zee5PWABusinessLogic.verifyRentalPurchaseCallInitiatedEvent(userType);
		}

		
		
		//=============================RentalPurchaseCallReturned Event==================================
		
		@Test(priority = 26)
		@Parameters({ "userType"})
		public void verifyRentalPurchaseCallReturnedEvent(String userType) throws Exception {
			System.out.println("Verify RentalPurchase Call Initiated Event for All access pack");
			zee5PWABusinessLogic.relaunch();
			zee5PWABusinessLogic.verifyRentalPurchaseCallReturnedEvent(userType);
		}
		
		
		
	
	@AfterTest
	public void teardown()
	{
		System.out.println("teardown");
		zee5PWABusinessLogic.tearDown();
	}

	

}

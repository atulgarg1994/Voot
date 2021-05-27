package com.zee5.ApplicasterScripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5ApplicasterBusinessLogic;
import com.utility.Utilities;

public class TasksAndDefects {

	private Zee5ApplicasterBusinessLogic ZEE5ApplicasterBusinessLogic;

	@BeforeTest
	public void AppLaunch() throws InterruptedException {
		System.out.println("Launching Android App");
		Utilities.relaunch = true; // Clear App Data on First Launch
		ZEE5ApplicasterBusinessLogic = new Zee5ApplicasterBusinessLogic("zee");
	}

	@Test(priority = 0)
	@Parameters({ "userType" })
	public void ApplicasterLogin(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
	}

	@Test(priority = 1)
	@Parameters({ "userType", "searchKeyword4" })
	public void TasksAndDefects(String userType, String searchKeyword4) throws Exception {
		ZEE5ApplicasterBusinessLogic.tasksAndDefectsValidation(userType, searchKeyword4);

	}

	@Test(priority = 2)
	@Parameters({ "userType" })
	public void TasksAndDefectsMethod2(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.navigateToHomeLandingScreen();
		ZEE5ApplicasterBusinessLogic.DownloadUpNextContent(userType);
		ZEE5ApplicasterBusinessLogic.PostLogoutValidation(userType);
		ZEE5ApplicasterBusinessLogic.LoginFromMoreScreen(userType);
		ZEE5ApplicasterBusinessLogic.RecommendRailInMovies(userType);
	}

	@Test(priority = 3)
	@Parameters({ "userType" })
	public void TasksAndDefectsMethod3(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.PlayEduauraaAndValidateExpandCollapseofBenefitsSection(userType);
		ZEE5ApplicasterBusinessLogic.RecommendRailListingScreenInNews(userType);
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.ContinueWatchingTrayDefectValidation(userType);
		ZEE5ApplicasterBusinessLogic.TrendingNews(userType);
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.SearchedContent(userType);

	}

	@Test(priority = 4)
	@Parameters({ "userType" })
	public void TasksAndDefectsMethod4(String userType) throws Exception {
		// re-launch
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.navigateToHomeLandingScreen();

		ZEE5ApplicasterBusinessLogic.ValidationOfDownloadedContentInDownlodsScreen(userType);
		ZEE5ApplicasterBusinessLogic.prepaidCodeValidation(userType);
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.EduaraaCarousel(userType);

	}

	@Test(priority = 5)
	@Parameters({ "userType" })
	public void TasksAndDefectsMethod5(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.navigateToHomeLandingScreen();
		ZEE5ApplicasterBusinessLogic.contentPlayBackValidation(userType);
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.DownloadBeforeTvContent(userType);
		ZEE5ApplicasterBusinessLogic.AllEpisodeTrayListingScreen(userType);

	}

	@Test(priority = 6)
	@Parameters({ "userType" })
	public void TasksAndDefectsMethod6(String userType) throws Exception {
		// re-launch
		ZEE5ApplicasterBusinessLogic.relaunch(true);		
		ZEE5ApplicasterBusinessLogic.LaunchAppinOffline(userType);
		ZEE5ApplicasterBusinessLogic.ValidatingQualityOptionDefect(userType);
		// Login CTA in subscribe screen is not present in latest build
		// ZEE5ApplicasterBusinessLogic.FirstEpisodeContentPlayback(userType);
		ZEE5ApplicasterBusinessLogic.LoginThroughAnyentryPointDefect(userType);
	}

	@Test(priority = 7)
	@Parameters({ "userType" })
	public void TasksAndDefectsMethod7(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.navigateToHomeLandingScreen();
		ZEE5ApplicasterBusinessLogic.PlayerControlDefect(userType);
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.SomethingWentWrongDefectValidation(userType);
		// skip CTA on player is not present in latest build
		// ZEE5ApplicasterBusinessLogic.PreviousIconForPremiumContent(userType);
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.RentNowCTAforTVODcontent(userType);
	}

	@Test(priority = 8)
	@Parameters({ "userType" })
	public void TasksAndDefectsMethod8(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.navigateToHomeLandingScreen();
		ZEE5ApplicasterBusinessLogic.VerifyBackButtonFromPaymentScreen(userType);
		ZEE5ApplicasterBusinessLogic.VerifySubscribeIcon(userType);
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.verifyExplorePremiiumOffline(userType);
		
	}
	
	@Test(priority = 9)
	@Parameters({ "userType" })
	public void TasksAndDefectsMethod9(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.navigateToHomeLandingScreen();
		ZEE5ApplicasterBusinessLogic.verifyNegativeRoundOffPrice(userType);
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.verifyBuyPlanForEduauraa(userType);
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.VerifyDiscountAmount(userType);
	}
	
	@Test(priority = 10)
	@Parameters({ "userType" })
	public void VerifyAccountPopupDefect(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.navigateToHomeLandingScreen();
		ZEE5ApplicasterBusinessLogic.AccountInfoPopupDefect(userType);
	}
	
	@Test(priority = 11)
	@Parameters({ "userType" })
	public void VerifyLogoutAndAuthenticateOptions(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.VerifyLogoutAndAuthenticateDeviceOptions(userType);
	}
	
	@Test(priority = 12)
	@Parameters({ "userType" })
	public void VeirfyMyTransactions(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.navigateToHomeLandingScreen();
		ZEE5ApplicasterBusinessLogic.verifyMyTransactionOption(userType);		
	}
	
	@Test(priority = 13)
	@Parameters({ "userType" })
	public void VeirfyGoogleLoginFromSubscriptionJourney(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.VerifyGoogleIconInSubscriptionScreen(userType);		
	}
	
	@Test(priority = 14)
	@Parameters({ "userType" })
	public void DownloadIconValidation(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", "Guest");
		ZEE5ApplicasterBusinessLogic.navigateToHomeScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
		ZEE5ApplicasterBusinessLogic.DownloadIconValidation_NetworkInterupption(userType, "Movies");
		
	}
	
	@Test(priority = 15)
	@Parameters({ "userType" })
	public void contentPlaybackValidation_afterTappingReplayIcon(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", "Guest");
		ZEE5ApplicasterBusinessLogic.navigateToHomeScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
		ZEE5ApplicasterBusinessLogic.contentPlayBack_afterTappingReplayIcon(userType);	
	}
	
	@Test(priority = 16)
	@Parameters({ "userType" })
	public void NavigationToEduauraaWebPageValidation(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", "Guest");
		ZEE5ApplicasterBusinessLogic.navigateToHomeScreen();
		ZEE5ApplicasterBusinessLogic.LoginWithEmailID("smoke.622@gmail.com", "11223344");
		ZEE5ApplicasterBusinessLogic.NavigationToEduauraaWeb(userType, "Eduauraa");	
	}
	
	@AfterTest
	public void tearDownApp() {
		System.out.println("Quit the App");
		ZEE5ApplicasterBusinessLogic.tearDown();
	}
}
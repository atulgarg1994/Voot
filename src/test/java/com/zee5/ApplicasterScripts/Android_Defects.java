package com.zee5.ApplicasterScripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.business.zee.Zee5ApplicasterBusinessLogic;
import com.utility.Utilities;

public class Android_Defects {
	
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
	
	@Test(priority = 1)//Sushma
	@Parameters({ "userType"})
	public void PremiumTag_SearchResultScreen(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.premiumTagOnSearchResultScreen(userType);

	}
	
	@Test(priority = 2)//Sushma
	public void SwipeOnContentCards() throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.swipeFunctionalityOnContentCardsOfTray();

	}
	
	@Test(priority = 3)//Sushma
	public void BackbuttonAndHeaderName_ListingScreen() throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.ListingScreenBackArrowAndHeaderName("Home");
	}
	
	@Test(priority = 4)//Sushma
	public void PlayBack_IndiaTodayLiveChannelContent() throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.IndiaTodayLiveChannel();
	}
	
	@Test(priority = 5)//Sushma
	@Parameters({ "userType" })
	public void audioLanguageoptionValidation(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.audioLanguageValidation("Trailer - Khushi");
	}
	
	@Test(priority = 6)////Sushma
	@Parameters({ "userType" })
	public void BottomNavigationBar_ListingScreen(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.bottomNavigationBarValidationInListingScreen(userType);
	}
	
	@Test(priority = 7)//Sushma
	public void ListingScreenHeaderValidation() throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.listingScreenHeader("Unlimited Fun | Kannada");
	}
	
	@Test(priority = 8)//Sushma
	@Parameters({ "userType" })
	public void UserAccountInfoValidation(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", "Guest");
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.LoginWithEmailID("7892215214", "User@123");
		ZEE5ApplicasterBusinessLogic.accountInfoValidationInPaymentPage(userType);
	}
	
	@Test(priority = 9)//Sushma
	@Parameters({ "userType" })
	public void HaveACodeOptionInPlanSelectionScreen(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", "Guest");
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.haveAPrepaidCodeDuringUpgradeJourney(userType,"newsubsrevamp4@mailnesia.com", "111222");
	}
	
	@Test(priority = 10)//Sushma
	public void AppCrash_LearnWithEduauraaTray() throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.AppcrashIssue_OnTappingBackButton_LearnWithEduauraaTray();
	}
	
	@Test(priority = 11)//Sushma
	public void AppCrashIssue_tapingOptionsBelowThePlayer() throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.CrashIssue_OptionBelowPlayer("Expiry Date");
	}

	@Test(priority = 12)//Sushma
	@Parameters({ "userType" })
	public void AppCrash_TVODContent(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", "Guest");
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
		ZEE5ApplicasterBusinessLogic.AppcrashIssue_ChennaiVSChina(userType,"Chennai vs China | Trailer");
	}
	
	@Test(priority = 13)//Sushma
	@Parameters({ "userType" })
	public void AppCrashIssue_MaximizeAndMinimize_LiveContents(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", "Guest");
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
		ZEE5ApplicasterBusinessLogic.CrashIssue_LiveTvContents();
	}	
	
	@Test(priority = 14)//Sushma
	@Parameters({ "userType", "searchKeyword4" })
	public void DownloadingMovieContent_DownloadsTab(String userType, String searchKeyword4) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", "Guest");
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
		ZEE5ApplicasterBusinessLogic.movieDownloadFunctonality(userType, searchKeyword4);

	}

//	@Test(priority = 15)//Sushma
	@Parameters({ "userType" })
	public void contentPlaybackValidation_afterTappingReplayIcon(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", "Guest");
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
		ZEE5ApplicasterBusinessLogic.contentPlayBack_afterTappingReplayIcon(userType);
	}
	
	@Test(priority = 16)//Sushma
	@Parameters({ "userType" })
	public void NavigationToEduauraaWebPageValidation(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", "Guest");
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.LoginWithEmailID("smoke.622@gmail.com", "11223344");
		ZEE5ApplicasterBusinessLogic.NavigationToEduauraaWeb(userType, "Eduauraa");
	}
	
	@Test(priority = 17)//Sushma
	@Parameters({ "userType" })
	public void PlayBackInBackgroundValidation(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", "Guest");
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
		ZEE5ApplicasterBusinessLogic.contentPlayBackInBackGroundValidation(userType, "Music");
	}
	
	@Test(priority = 18)//Sushma
	@Parameters({ "userType" })
	public void DownloadIconValidation(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", "Guest");
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
		ZEE5ApplicasterBusinessLogic.DownloadIconValidation_NetworkInterupption(userType, "Movies");

	}
	
	@Test(priority = 19)//Sushma
	public void OffineMode_UpComingScreenValdation() throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.UpcomingScreen_OfflineMode();
	}
	
	@Test(priority = 20)//Sushma
	public void OffineMode_AppCrash_OnTappingShareOption() throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.CrashIssue_Share_OfflineMode();
	}
	
	@Test(priority = 21)//Sushma
	@Parameters({ "userType" })
	public void OfflineMode_AppLaunch(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", "Guest");
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
	    ZEE5ApplicasterBusinessLogic.crashIssue_AppLaunch_OfflineMode(userType);
	}
	
	
	@Test(priority = 22) //Bhavana
	@Parameters({ "userType" })
	public void VerifyDownloadUpNextContent(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.navigateToHomeLandingScreen();
		ZEE5ApplicasterBusinessLogic.DownloadUpNextContent(userType);
			}
	
	@Test(priority = 23) //Bhavana
	@Parameters({ "userType" })
	public void LogoutValidation(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.navigateToHomeLandingScreen();
		ZEE5ApplicasterBusinessLogic.PostLogoutValidation(userType);
		
			}
	
	@Test(priority = 24) //Bhavana
	@Parameters({ "userType" })
	public void loginFromMoreScreen(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.LoginFromMoreScreen(userType);
		
			}
	
	@Test(priority = 25) //Bhavana
	@Parameters({ "userType" })
	public void RecommendRailInMoviesAndNews(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.navigateToHomeLandingScreen();
		ZEE5ApplicasterBusinessLogic.RecommendRailInMovies(userType);
		ZEE5ApplicasterBusinessLogic.RecommendRailListingScreenInNews(userType);
			}
	
	@Test(priority = 26) //Bhavana
	@Parameters({ "userType" })
	public void EduauraaAndValidateBenefitsSection(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.navigateToHomeLandingScreen();
		ZEE5ApplicasterBusinessLogic.PlayEduauraaAndValidateExpandCollapseofBenefitsSection(userType);
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.EduaraaCarousel(userType);
			}
	
	@Test(priority = 27) //Bhavana
	@Parameters({ "userType" })
	public void AllEpisodesListingScreen(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(false);		
		ZEE5ApplicasterBusinessLogic.AllEpisodeTrayListingScreen(userType);
		
			}
	
	@Test(priority = 28) //Bhavana
	@Parameters({ "userType" })
	public void ContinueWatchingTray(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.navigateToHomeLandingScreen();
		ZEE5ApplicasterBusinessLogic.ContinueWatchingTrayDefectValidation(userType);
			}
	
	@Test(priority = 29) //Bhavana
	@Parameters({ "userType" })
	public void TrendingNews(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(false);	
		ZEE5ApplicasterBusinessLogic.TrendingNews(userType);
			}
	
	@Test(priority = 30) //Bhavana
	@Parameters({ "userType" })
	public void SearchedContent(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(false);	
		ZEE5ApplicasterBusinessLogic.SearchedContent(userType);
			}
	

	@Test(priority = 31) //Bhavana
	@Parameters({ "userType" })
	public void VerifyDownloadContent(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.navigateToHomeLandingScreen();
		ZEE5ApplicasterBusinessLogic.ValidationOfDownloadedContentInDownlodsScreen(userType);		
		
	}
	
	@Test(priority = 32) //Bhavana
	@Parameters({ "userType" })
	public void DownloadBeforeTvContent(String userType) throws Exception {		
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.DownloadBeforeTvContent(userType);
	}

	@Test(priority = 33) //Bhavana
	@Parameters({ "userType" })
	public void ContentPlayBackValidation(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.navigateToHomeLandingScreen();
		ZEE5ApplicasterBusinessLogic.contentPlayBackValidation(userType);
			}

	@Test(priority = 34) //Bhavana
	@Parameters({ "userType" })
	public void LaunchAppInOffline(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);		
		ZEE5ApplicasterBusinessLogic.LaunchAppinOffline(userType);
		}
	
	@Test(priority = 35) //Bhavana
	@Parameters({ "userType" })
	public void LoginThroughAnyentryPointDefect(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.LoginThroughAnyentryPointDefect(userType);
		}
	
	// Login CTA in subscribe screen is not present in latest build
	//@Test(priority = 36) //Bhavana
	@Parameters({ "userType" })
	public void FirstEpisodeContentPlayback(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.FirstEpisodeContentPlayback(userType);
		}
	
	@Test(priority = 37) //Bhavana
	@Parameters({ "userType" })
	public void PlayerControlDefect(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.navigateToHomeLandingScreen();
		ZEE5ApplicasterBusinessLogic.PlayerControlDefect(userType);
		}
	
	@Test(priority = 38) //Bhavana
	@Parameters({ "userType" })
	public void ValidateQualityOptions(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.ValidatingQualityOptionDefect(userType);
		}
	

	@Test(priority = 39) //Bhavana
	@Parameters({ "userType" })
	public void SomethingWentWrongDefectValidation(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.SomethingWentWrongDefectValidation(userType);
		}
	
	@Test(priority = 40) //Bhavana
	@Parameters({ "userType" })
	public void RentNowCTAforTVODcontent(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.RentNowCTAforTVODcontent(userType);
		}
	
	// skip CTA on player is not present in latest build
	//@Test(priority = 41)  //Bhavana
	@Parameters({ "userType" })
	public void PreviousIconForPremiumContent(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.PreviousIconForPremiumContent(userType);
		}
	
	@Test(priority = 42) //Bhavana
	@Parameters({ "userType" })
	public void VerifyBackButtonFromPaymentScreen(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.navigateToHomeLandingScreen();
		ZEE5ApplicasterBusinessLogic.VerifyBackButtonFromPaymentScreen(userType);
		
	}
	
	@Test(priority = 43) //Bhavana
	@Parameters({ "userType" })
	public void VerifySubscribeIcon(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.VerifySubscribeIcon(userType);
		
	}

	@Test(priority = 44) //Bhavana
	@Parameters({ "userType" })
	public void verifyExplorePremiiumOffline(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.verifyExplorePremiiumOffline(userType);
		
	}
	@Test(priority = 45) //Bhavana
	@Parameters({ "userType" })
	public void verifyNegativeRoundOffPrice(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.navigateToHomeLandingScreen();
		ZEE5ApplicasterBusinessLogic.verifyNegativeRoundOffPrice(userType);
		
	}
	
	@Test(priority = 46) //Bhavana
	@Parameters({ "userType" })
	public void verifyBuyPlanForEduauraa(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.navigateToHomeLandingScreen();
		ZEE5ApplicasterBusinessLogic.verifyBuyPlanForEduauraa(userType);
	}
	
	@Test(priority = 47) //Bhavana
	@Parameters({ "userType" })
	public void VerifyDiscountAmount(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.VerifyDiscountAmount(userType);
	}
	
	@Test(priority = 48) //Bhavana
	@Parameters({ "userType" })
	public void VerifyAccountPopupDefect(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.navigateToHomeLandingScreen();
		ZEE5ApplicasterBusinessLogic.AccountInfoPopupDefect(userType);
	}
	
	@Test(priority = 49) //Bhavana
	@Parameters({ "userType" })
	public void VerifyLogoutAndAuthenticateOptions(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.VerifyLogoutAndAuthenticateDeviceOptions(userType);
	}
	
	@Test(priority = 50) //Bhavana
	@Parameters({ "userType" })
	public void VeirfyMyTransactions(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.navigateToHomeLandingScreen();
		ZEE5ApplicasterBusinessLogic.verifyMyTransactionOption(userType);		
	}
	
	@Test(priority = 51) //Bhavana
	@Parameters({ "userType" })
	public void VeirfyGoogleLoginFromSubscriptionJourney(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.VerifyGoogleIconInSubscriptionScreen(userType);		
	}
	
	@Test(priority = 52) //Bhavana
	public void VerifyUpcomingContent() throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.navigateToHomeLandingScreen();
		ZEE5ApplicasterBusinessLogic.VerifyUpcomingContent();		
	}
	
	@Test(priority = 53) //Bhavana
	@Parameters({ "userType" })
	public void DownloadWeekInShortContent(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.navigateToHomeLandingScreen();
		ZEE5ApplicasterBusinessLogic.VerifyWeekInShorts(userType);		
	}

	@AfterTest
	public void tearDownApp() {
		System.out.println("\nExecution Complete - Closing the App");
		ZEE5ApplicasterBusinessLogic.tearDown();
	}
	
	
		
}

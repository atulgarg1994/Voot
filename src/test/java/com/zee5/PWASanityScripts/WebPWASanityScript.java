package com.zee5.PWASanityScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5PWASanityWEBBusinessLogic;

public class WebPWASanityScript {

	private Zee5PWASanityWEBBusinessLogic Zee5WEBPWASanityBusinessLogic;

	@BeforeTest
	public void init() throws Exception {
		// zee5WebBusinessLogic.relaunchFlag = false;
		Zee5WEBPWASanityBusinessLogic = new Zee5PWASanityWEBBusinessLogic("Chrome");
	}

	@Test(priority = 1)
	@Parameters({ "userType" })
	public void PWAWEBLogin(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.ZeeWEBPWALogin(userType);
	}

//	 ------------------SHREENIDHI Mandatory Registration---------------------
//	@Test(priority = 2)
	@Parameters({ "userType" })
	public void PWARegistrationPopUp(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.registerPopUpScenarios(userType);
	}

	// -------------------------SUSHMA Onboarding--------------------------
	@Test(priority = 3)
	@Parameters({ "userType" })
	public void Onboarding(String userType) throws Exception {
		// Contains both sanity and smoke
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.OnboardingScenario(userType);
	}

	// --------------------------SHREENIDHI Profile-------------------------- Last
	@Test(priority = 4)
	@Parameters({ "userType" })
	public void PWAProfile(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.myProfileScenarios(userType);
	}

	// -------------------------MANASA Subscription--------------------------
	@Test(priority = 5)
	@Parameters({ "userType" })
	public void subscriptionPageValidation(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		// SMOKE
		Zee5WEBPWASanityBusinessLogic.WEBPWAValidatingSubscriptionAndTransaction(userType);
		Zee5WEBPWASanityBusinessLogic.WEBPWAValidatingSubscribeLinks(userType);
		// SMOKE SubscriptionModule //SATISH
		Zee5WEBPWASanityBusinessLogic.zeePWASubscriptionSuite(userType);
		// SANITY
		Zee5WEBPWASanityBusinessLogic.contentLanguageVerify(userType);
		Zee5WEBPWASanityBusinessLogic.verifyUIofMySubscriptionPage(userType);
		Zee5WEBPWASanityBusinessLogic.validatingActiveAndExpiredCardsinMyTransactionPage(userType);
		Zee5WEBPWASanityBusinessLogic.verifyUIofZEESubscriptionPage(userType);
	}

	// -------------------------BHAVANA External links--------------------------
	@Test(priority = 6)
	@Parameters({ "userType" })
	public void ExternalLinks(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.LinksValidation(userType);
	}

	// -------------------------BHAVANA Static,Footer--------------------------
	@Test(priority = 7)
	@Parameters({ "userType" })
	public void staticPagesInMenuAndFooterSectionValidation(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.staticPagesandFooterSectionValidation(userType);
	}

	// --------------------------BASAVARAJ TimedAnchors--------------------------
	//@Test(priority = 8)
	@Parameters({ "userType" })
	public void PWATimedAnchors(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.TimedAnchors(userType);
		Zee5WEBPWASanityBusinessLogic.ShowsTimeperiodProvided(userType);
		Zee5WEBPWASanityBusinessLogic.musicTimeperiodProvided(userType);
		Zee5WEBPWASanityBusinessLogic.moviesTimeperiodProvided(userType);
		Zee5WEBPWASanityBusinessLogic.continueWatchingtrayData(userType);
	}

	@Test(priority = 9)
	@Parameters({ "userType" })
	public void landingPageValidation(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		//SMOKE LANDINGPAGE : TEJAS
		Zee5WEBPWASanityBusinessLogic.mandatoryRegistrationPopUp(userType);
		Zee5WEBPWASanityBusinessLogic.landingpagePropertiesValidation(userType);
		// SANITY
		Zee5WEBPWASanityBusinessLogic.mandatoryRegistrationPopUp(userType);
		if (userType.equals("Guest")) {
			Zee5WEBPWASanityBusinessLogic.guesttrayTitleAndContentValidationWithApiData("Home", "homepage");
			Zee5WEBPWASanityBusinessLogic.LandingPagegap("The Power Game", "Chemistry of Kariyappa", "Guest");
		} else if (userType.equals("NonSubscribedUser") || userType.equals("SubscribedUser")) {
			Zee5WEBPWASanityBusinessLogic.trayTitleAndContentValidationWithApiData("Home", "homepage");
		}

		Zee5WEBPWASanityBusinessLogic.ContinuewatchingTray(userType);
		Zee5WEBPWASanityBusinessLogic.mandatoryRegistrationPopUp(userType);
		Zee5WEBPWASanityBusinessLogic.FreeContentAndPremiumContent(userType);		
	}


	// -------------------------SUSHMA MoviePage--------------------------
	@Test(priority = 10)
	@Parameters({ "userType" })
	public void Movies(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.Moviepage(userType, "Movies");
	}

	// -------------------------MANASA PremiumPage--------------------------
	@Test(priority = 11)
	@Parameters({ "userType" })
	public void premiumPageValidation(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		// SMOKE DEFAULT HOME PAGE : MANASA
		Zee5WEBPWASanityBusinessLogic.verifyUIofHomePage();

		// SANITY
		Zee5WEBPWASanityBusinessLogic.landingPagesValidation("Premium");
		Zee5WEBPWASanityBusinessLogic.landingPagesTrailerAndPopUpValidation(userType, "Premium");
		Zee5WEBPWASanityBusinessLogic.premiumPageTrayTitleAndContentValidationWithApiData("Premium", "premiumcontents");
	}

	// -------------------------HITESH MusicPage--------------------------
	@Test(priority = 12)
	@Parameters({ "userType" })
	public void musicPageValidation(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.landingPagesValidation("Music");
		Zee5WEBPWASanityBusinessLogic.musicPageTrayTitleAndContentValidationWithApiData("Music", "music", userType);
		Zee5WEBPWASanityBusinessLogic.musicPageValidation("Music", userType,
				"Kalede Hode Naanu - Chambal | Sathish Ninasam | Sonu Gowda");
	}

	// -------------------------TEJAS ShowsPage--------------------------
	@Test(priority = 13)
	@Parameters({ "userType" })
	public void tvShowsPage(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.ShowsValidationWeb(userType);
	}

	// -------------------------YASHASWINI NewsPage--------------------------
	@Test(priority = 14)
	@Parameters({ "userType" })
	public void newsPageValidation(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.mandatoryRegistrationPopUp(userType);
		Zee5WEBPWASanityBusinessLogic.newsPageValidation("News");
		Zee5WEBPWASanityBusinessLogic.mandatoryRegistrationPopUp(userType);
		Zee5WEBPWASanityBusinessLogic.trayTitleAndContentValidationWithApiDataNews("News", "news");
	}

	// -------------------------BINDU Zee5Originals--------------------------
	@Test(priority = 15)
	@Parameters({ "userType" })
	public void webSeriesValidation(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.Zee5OriginalsScreen(userType, "Web Series");

	}

	// -------------------------BINDU Search--------------------------
	@Test(priority = 16)
	@Parameters({ "userType" })
	public void Search(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		// Sanity
		Zee5WEBPWASanityBusinessLogic.SearchResultsScreen(userType);
		// Smoke : sushma
		String liveContentName = Zee5WEBPWASanityBusinessLogic.fetchLiveContent();
		Zee5WEBPWASanityBusinessLogic.landingOnSearchScreen();
		Zee5WEBPWASanityBusinessLogic.searchResultScreen("Paaru");
		Zee5WEBPWASanityBusinessLogic.liveTv(liveContentName);
		Zee5WEBPWASanityBusinessLogic.navigationToConsumptionScreenThroughTrendingSearches(userType);
	}

	// -------------------------SATISH SubscriptionPopup--------------------------
	@Test(priority = 17)
	@Parameters({ "userType" })
	public void SubscriptionPopup(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		// Sanity
		Zee5WEBPWASanityBusinessLogic.SubscriptionPopupScenarios(userType);
	}

	// -------------------------SATISH UserActions--------------------------
	@Test(priority = 18)
	@Parameters({ "userType" })
	public void UserActions(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		if (userType.equals("Guest")) {
			// Zee5PWASanityBusinessLogic.validateDisplayLanguagePopup();
			Zee5WEBPWASanityBusinessLogic.mandatoryRegistrationPopUp(userType);
			Zee5WEBPWASanityBusinessLogic.UserActionGuestUser(userType);
		} else if (userType.equals("NonSubscribedUser")) {
			Zee5WEBPWASanityBusinessLogic.UserActionLoggedInUser(userType);
		} else {
			Zee5WEBPWASanityBusinessLogic.ContinueWatching();
			Zee5WEBPWASanityBusinessLogic.MyReminder();
			Zee5WEBPWASanityBusinessLogic.MyWatchlistSubscribedUser();
		}
	}

	// --------------------------SHREENIDHI Menu&Settings--------------------------
	@Test(priority = 19)
	@Parameters({ "userType" })
	public void PWAMenuOrSetting(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.MenuOrSettingScenarios(userType);
	}

	// -------------------------VINAY LanguageSettings--------------------------
	@Test(priority = 20)
	@Parameters({ "userType" })
	public void PWAlanguageSettingsValidation(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.LanguageModule(userType);
	}

	// -------------------------TEJAS Recommendation--------------------------
	@Test(priority = 21)
	@Parameters({ "userType" })
	public void PWARecoTalamoosModule(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.verificationOfRecoTalamoosWeb(userType);
	}

	// -------------------------SUSHMA LiveTV--------------------------
	 @Test(priority = 22)	  
	 @Parameters({ "userType" }) public void LiveTvPage(String userType) throws Exception {
	  // SANITY 
	  Zee5WEBPWASanityBusinessLogic.navigateToHome();
	  Zee5WEBPWASanityBusinessLogic.liveLandingPage(userType);
	  Zee5WEBPWASanityBusinessLogic.live();
	//Zee5WEBPWASanityBusinessLogic.premiumPopUp();
	  Zee5WEBPWASanityBusinessLogic.ChannelGuide(userType); 
         // SMOKE
	  Zee5WEBPWASanityBusinessLogic.verifyLiveTvAndChannelGuideScreen();
	  }

	// -------------------------VINAY KALTURA--------------------------
	@Test(priority = 23)
	@Parameters({ "userType" })
	public void PWAkalturaValidation(String userType) throws Exception {
		// SANITY
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.Kaltura(userType);
		// content
		Zee5WEBPWASanityBusinessLogic.checkDurationInLivetv(userType);
		Zee5WEBPWASanityBusinessLogic.checkDurationandProgressVideo(userType);

		// SMOKE
		Zee5WEBPWASanityBusinessLogic.ValidatingPlayer(userType);

	}

	// -------------------------BHAVANA Content Details--------------------------
	@Test(priority = 24)
	@Parameters({ "browserType", "url", "userType", "consumptionsEpisode", "consumptionsShow",
		"consumptionsFreeContent", "consumptionsPremiumContent" })
	public void PWAContentDetails(String browser, String url, String userType,
			String consumptionsEpisode, String consumptionsShow, String consumptionsFreeContent,
			String consumptionsPremiumContent) throws Exception {
		// SANITY
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.contentDetailsValidation(userType);

		// SMOKE : Tanisha
		Zee5WEBPWASanityBusinessLogic.verifyConsumptionsScreenTappingOnCard(userType, "Episode", consumptionsEpisode);
		Zee5WEBPWASanityBusinessLogic.verifyConsumptionsScreenTappingOnCard(userType, "Live TV", "");
		Zee5WEBPWASanityBusinessLogic.mandatoryRegistrationPopUp(userType);
		Zee5WEBPWASanityBusinessLogic.verifyNoSubscriptionPopupForFreeContent(userType, "Ramayana "); // changed_6th
		Zee5WEBPWASanityBusinessLogic.verifySubscriptionPopupForPremiumContent(userType, consumptionsPremiumContent);
		Zee5WEBPWASanityBusinessLogic.verifyCTAandMetaDataInDetailsAndConsumption(consumptionsShow);
	}

	// -------------------------TEJAS Carousel--------------------------
	@Test(priority = 25)
	@Parameters({ "userType" })
	public void WebPWACarouselAndLanding(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		// SANITY
		Zee5WEBPWASanityBusinessLogic.ValidatingWebPwaCarousalinalltabs(userType);

		// SMOKE
		// auto rotating
		Zee5WEBPWASanityBusinessLogic.verifyAutoroatingOnCarousel("Home");
		Zee5WEBPWASanityBusinessLogic.verifyAutoroatingOnCarousel("Movies");
		// Zee5WEBPWASanityBusinessLogic.verifyAutoroatingOnCarousel("Free Movies");
		Zee5WEBPWASanityBusinessLogic.verifyAutoroatingOnCarousel("TV Shows");
		Zee5WEBPWASanityBusinessLogic.verifyAutoroatingOnCarousel("Premium");
		Zee5WEBPWASanityBusinessLogic.verifyAutoroatingOnCarousel("Play");
		Zee5WEBPWASanityBusinessLogic.verifyAutoroatingOnCarousel("Kids");
		// Zee5WEBPWASanityBusinessLogic.verifyAutoroatingOnCarousel("Stories");
		// Zee5WEBPWASanityBusinessLogic.verifyAutoroatingOnCarousel("ZEE5 Originals");
		// play icon functionality
		Zee5WEBPWASanityBusinessLogic.verifyPlayIconFunctionality("Web Series");
		Zee5WEBPWASanityBusinessLogic.verifyPlayIconFunctionality("Kids");
		Zee5WEBPWASanityBusinessLogic.verifyPlayIconFunctionality("Premium");
		Zee5WEBPWASanityBusinessLogic.verifyPlayIconFunctionality("Home");
		Zee5WEBPWASanityBusinessLogic.verifyPlayIconFunctionality("TV Shows");
		// Zee5WEBPWASanityBusinessLogic.verifyPlayIconFunctionality("Free Movies");

		Zee5WEBPWASanityBusinessLogic.verifyPlayIconFunctionality("Movies");
		Zee5WEBPWASanityBusinessLogic.verifyPlayIconFunctionality("Home");
		// premium icon functionality
		Zee5WEBPWASanityBusinessLogic.verifyPremiumIconFunctionality("Home", userType);
		Zee5WEBPWASanityBusinessLogic.verifyPremiumIconFunctionality("Premium", userType);
		Zee5WEBPWASanityBusinessLogic.verifyPremiumIconFunctionality("Movies", userType);
		Zee5WEBPWASanityBusinessLogic.verifyPremiumIconFunctionality("Web Series", userType);
		// left right functionality
		Zee5WEBPWASanityBusinessLogic.verifyLeftRightFunctionality("Home");
		Zee5WEBPWASanityBusinessLogic.verifyLeftRightFunctionality("Movies");
		// Zee5WEBPWASanityBusinessLogic.verifyLeftRightFunctionality("Free Movies");
		Zee5WEBPWASanityBusinessLogic.verifyLeftRightFunctionality("TV Shows");
		Zee5WEBPWASanityBusinessLogic.verifyLeftRightFunctionality("Premium");
		Zee5WEBPWASanityBusinessLogic.verifyLeftRightFunctionality("Play");
		Zee5WEBPWASanityBusinessLogic.verifyLeftRightFunctionality("Kids");
		// Zee5WEBPWASanityBusinessLogic.verifyLeftRightFunctionality("Stories");
		Zee5WEBPWASanityBusinessLogic.verifyLeftRightFunctionality("Web Series");
		// zee5WebBusinessLogic.verifyLeftRightFunctionality("News");
		// metadata
		String languageSmallText = Zee5WEBPWASanityBusinessLogic.allSelectedLanguagesWEB();
		Zee5WEBPWASanityBusinessLogic.verifyMetadataOnCarousel("Web Series", "zeeoriginals", languageSmallText);
		// Zee5WEBPWASanityBusinessLogic.verifyMetadataOnCarousel("Stories", "stories", "");
		Zee5WEBPWASanityBusinessLogic.verifyMetadataOnCarousel("Kids", "kids", languageSmallText);
		Zee5WEBPWASanityBusinessLogic.verifyMetadataOnCarousel("Play", "play", languageSmallText);
		Zee5WEBPWASanityBusinessLogic.verifyMetadataOnCarousel("Premium", "premiumcontents", languageSmallText);
		Zee5WEBPWASanityBusinessLogic.verifyMetadataOnCarousel("TV Shows", "tvshows", languageSmallText);
		// Zee5WEBPWASanityBusinessLogic.verifyMetadataOnCarousel("Free Movies", "freemovies", languageSmallText);
		Zee5WEBPWASanityBusinessLogic.verifyMetadataOnCarousel("Movies", "movies", languageSmallText);
		Zee5WEBPWASanityBusinessLogic.verifyMetadataOnCarousel("Home", "home", languageSmallText);
		// zee5WebBusinessLogic.verifyMetadataOnNews("News", "news", languageSmallText);
	}

	//@Test(priority = 26)
	@Parameters({ "userType" })
	public void club(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.landingPagesValidationclub("Club");
		Zee5WEBPWASanityBusinessLogic.trayTitleAndContentValidationWithApiDataClub("Club", "club");
		Zee5WEBPWASanityBusinessLogic.landingPagesTrailerAndPopUpValidationClub(userType, "Club");
	}

	//@Test(priority = 27)
	@Parameters({ "userType" })
	public void CTAPageValidation(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.VerifyCTA(userType);
	}

	@Test(priority = 28)
	@Parameters({ "userType" })
	public void eduauraa (String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.validatingEduaraa(userType ,"Kids");
		Zee5WEBPWASanityBusinessLogic.validatingclaimCTA(userType ,"Kids");
	}

	@Test(priority = 29)
	@Parameters({ "userType" })
	public void zeeplexvalidation(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.zeeplex(userType ,"ZEEPLEX");
	}

	//@Test(priority = 30)
	@Parameters({ "userType" })
	public void ConvivaVerification(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.ConvivaVerification(userType);
	}
	
	@Test(priority = 31)
	@Parameters({ "userType" })
	public void TasksImplementation(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.defects(userType, "ZEEPLEX");
		Zee5WEBPWASanityBusinessLogic.TasksAndDefectssprint57(userType);
		Zee5WEBPWASanityBusinessLogic.PWA2Sprint58(userType);
		Zee5WEBPWASanityBusinessLogic.TasksAndDefects(userType);
	}
	
	@Test(priority = 32)
	@Parameters({ "userType" })
	public void InSprintAutomation(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.Sprint58(userType);
	}
	
	@AfterClass
	public void tearDown() {
		Zee5WEBPWASanityBusinessLogic.tearDown();
	}
}
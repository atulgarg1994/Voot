package com.zee5.PWASanityScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5PWASanityAndroidBusinessLogic;

public class AndroidPWASanityScript {

	private Zee5PWASanityAndroidBusinessLogic Zee5PWASanityBusinessLogic;

	@BeforeTest
	public void init() throws Exception {
		Zee5PWASanityBusinessLogic = new Zee5PWASanityAndroidBusinessLogic("Chrome");
	}

	@Test(priority = 0)
	@Parameters({ "userType" })
	public void Login(String userType) throws Exception {
		Zee5PWASanityBusinessLogic.ZeePWALogin("E-mail", userType);
	}
/*
	@Test(priority = 1)
	@Parameters({ "userType" }) // SHREENIDHI
	public void PWAMenuOrSettingScenarios(String userType) throws Exception {
		Zee5PWASanityBusinessLogic.MenuOrSettingScenarios(userType);
	}

	@Test(priority = 2)
	@Parameters({"userType","searchModuleSearchKey","url"}) // SUSHMA SEARCH
	public void PWASearch(String userType,String searchKey,String url) throws Exception {
		Zee5PWASanityBusinessLogic.searchScreen(userType);
		//smoke
		String liveContentName = Zee5PWASanityBusinessLogic.fetchLiveContent();
		System.out.println("Live content : "+liveContentName);
		Zee5PWASanityBusinessLogic.landingOnSearchScreen();
		Zee5PWASanityBusinessLogic.searchResultScreen(searchKey);
		Zee5PWASanityBusinessLogic.liveTv(liveContentName);
		Zee5PWASanityBusinessLogic.navigationToConsumptionScreenThroughTrendingSearches();		
	}
	
	@Test(priority = 3)
	@Parameters({"userType"})
	public void PWALiveTV(String userType) throws Exception //SUSHMA LIVE TV
	{
		Zee5PWASanityBusinessLogic.LiveTvScreen(userType);
		//smoke
		Zee5PWASanityBusinessLogic.verifyLiveTvAndChannelGuideScreen();
		
	}
	
	@Test(priority = 4)
	@Parameters({"userType"})
	public void PWAMoviesPageValidation(String userType) throws Exception  //SUSHMA MOVIES
	{
		Zee5PWASanityBusinessLogic.Moviepage(userType, "Movies");
	}
	
	@Test(priority = 5)
	@Parameters({ "userType" }) // MANASA
	public void PWASubscriptionPageValidation(String userType) throws Exception {
		Zee5PWASanityBusinessLogic.ZeePWALogin("E-mail", userType);
		Zee5PWASanityBusinessLogic.contentLanguageVerify(userType);
		Zee5PWASanityBusinessLogic.verifyUIofZEESubscriptionPage(userType);
		Zee5PWASanityBusinessLogic.verifyUIofMySubscriptionPage(userType);
		Zee5PWASanityBusinessLogic.validatingActiveAndExpiredCardsinMyTransactionPage(userType);
	}

	@Test(priority = 6)
	@Parameters({ "userType" }) // YASHASHWINI
	public void PWANewsPageValidation(String userType) throws Exception {
		Zee5PWASanityBusinessLogic.newsPageValidation("News");
	}

	@Test(priority = 7)
	@Parameters({ "userType" }) // HITESH
	public void PWAMusicPageValidation(String userType) throws Exception {
		Zee5PWASanityBusinessLogic.navigateToMusicTab(userType);
		Zee5PWASanityBusinessLogic.landingPagesValidation("Music");
	}

	@Test(priority = 8)
	@Parameters({ "userType" }) // SHREENIDHI
	public void PWAMandatoryRegistration(String userType) throws Exception {
		Zee5PWASanityBusinessLogic.registerPopUpScenarios(userType);
	}

	@Test(priority = 9)
	@Parameters({ "userType" }) // MANASA
	public void PWAPremiumPageValidation(String userType) throws Exception {
		Zee5PWASanityBusinessLogic.landingPagesValidation("Premium");
		Zee5PWASanityBusinessLogic.landingPagesTrailerAndPopUpValidation(userType,"Premium");
		//smoke
		Zee5PWASanityBusinessLogic.ValidatingLandingPages(userType);//Tejas
		Zee5PWASanityBusinessLogic.verifyUIofHomePage(); // manasa default home
		
	}

	@Test(priority = 10)
	@Parameters({ "userType" }) // SHREENIDHI
	public void PWANetworkInterruptions(String userType) throws Exception {
		Zee5PWASanityBusinessLogic.networkInterruptionScenarios(userType);
	}

	@Test(priority = 11)
	@Parameters({ "userType" }) // SATHISH
	public void PWASubscriptionPopUp(String userType) throws Exception {
		Zee5PWASanityBusinessLogic.zeePWAVerifySubscriptionPopupAfterTrailerPlaybackIsComplete(userType);
		Zee5PWASanityBusinessLogic.zeePWAVerifyNavigationToSubscriptionFlowFromSubscriptionPopupFullscreenPlayer(userType);
		//smoke
		Zee5PWASanityBusinessLogic.zeePWASubscriptionSuite(userType); 
	}

	@Test(priority = 12)
	@Parameters({ "userType" }) // BHAVANA
	public void PWAShowsPageValidation(String userType) throws Exception {
		Zee5PWASanityBusinessLogic.ShowsValidation(userType);
	}

	@Test(priority = 13)
	@Parameters({ "userType" }) // BHAVANA
	public void PWAExternalLinks(String userType) throws Exception {
		Zee5PWASanityBusinessLogic.dismissDisplayContentLanguagePopUp();
		Zee5PWASanityBusinessLogic.LinksValidation(userType);
	}

	@Test(priority = 14)
	@Parameters({ "userType" ,"url"}) // TEJAS
	public void PWACarousel(String userType, String url) throws Exception {
		Zee5PWASanityBusinessLogic.ValidatingCarousalinalltabs(userType);
		//smoke landing
		// autorotating
		Zee5PWASanityBusinessLogic.verifyAutoroatingOnCarousel("Home");
		Zee5PWASanityBusinessLogic.verifyAutoroatingOnCarousel("Movies");
		Zee5PWASanityBusinessLogic.verifyAutoroatingOnCarousel("Free Movies");
		Zee5PWASanityBusinessLogic.verifyAutoroatingOnCarousel("Videos");
		Zee5PWASanityBusinessLogic.verifyAutoroatingOnCarousel("Shows");
		Zee5PWASanityBusinessLogic.verifyAutoroatingOnCarousel("Premium");
		Zee5PWASanityBusinessLogic.verifyAutoroatingOnCarousel("Play");
		//Zee5PWASanityBusinessLogic.verifyAutoroatingOnCarousel("Kids");
		//Zee5PWASanityBusinessLogic.verifyAutoroatingOnCarousel("Stories");
		Zee5PWASanityBusinessLogic.verifyAutoroatingOnCarousel("ZEE5 Originals");	
		// play icon functionality
		Zee5PWASanityBusinessLogic.verifyPlayIconFunctionality("ZEE5 Originals");
		Zee5PWASanityBusinessLogic.verifyPlayIconFunctionality("Kids");
		Zee5PWASanityBusinessLogic.verifyPlayIconFunctionality("Premium");
		Zee5PWASanityBusinessLogic.verifyPlayIconFunctionality("Shows");
		Zee5PWASanityBusinessLogic.verifyPlayIconFunctionality("Free Movies");
		Zee5PWASanityBusinessLogic.verifyPlayIconFunctionality("Videos");
		Zee5PWASanityBusinessLogic.verifyPlayIconFunctionality("Movies");
		Zee5PWASanityBusinessLogic.verifyPlayIconFunctionality("Home");
		// premium icon functionality
		Zee5PWASanityBusinessLogic.verifyPremiumIconFunctionality("Home", userType);
		Zee5PWASanityBusinessLogic.verifyPremiumIconFunctionality("Premium", userType);
		Zee5PWASanityBusinessLogic.verifyPremiumIconFunctionality("Movies", userType);
		Zee5PWASanityBusinessLogic.verifyPremiumIconFunctionality("ZEE5 Originals", userType);
		// metadata
		String languageSmallText = Zee5PWASanityBusinessLogic.allSelectedLanguages();
		Zee5PWASanityBusinessLogic.verifyMetadataOnCarousel("ZEE5 Originals","zeeoriginals", languageSmallText);
		//Zee5PWASanityBusinessLogic.verifyMetadataOnCarousel("Stories", "stories", "");
		//Zee5PWASanityBusinessLogic.verifyMetadataOnCarousel("Kids", "kids", languageSmallText);
		Zee5PWASanityBusinessLogic.verifyMetadataOnCarousel("Play","play", languageSmallText);
		Zee5PWASanityBusinessLogic.verifyMetadataOnCarousel("Premium","premiumcontents", languageSmallText);
		Zee5PWASanityBusinessLogic.verifyMetadataOnCarousel("Shows", "tvshows", languageSmallText);
		Zee5PWASanityBusinessLogic.verifyMetadataOnCarousel("Free Movies", "freemovies", languageSmallText);
		Zee5PWASanityBusinessLogic.verifyMetadataOnCarousel("Videos", "videos", languageSmallText);
		Zee5PWASanityBusinessLogic.verifyMetadataOnCarousel("Movies", "movies", languageSmallText);
		Zee5PWASanityBusinessLogic.verifyMetadataOnCarousel("Home", "home", languageSmallText);	
		//Zee5PWASanityBusinessLogic.verifyMetadataOnNews("News", "news", languageSmallText);
		// <> Functionality
		Zee5PWASanityBusinessLogic.verifyLeftRightFunctionality("News", url);
		System.out.println(">>>> 4th method completed");
	}
/*
	@Test(priority = 15)
	@Parameters({ "userType" }) // VINAY
	public void PWAUserActions(String userType) throws Exception {		
		Zee5PWASanityBusinessLogic.UserActions(userType);	
	}
/*
	@Test(priority = 16) // TANISHA
	@Parameters({ "userType" })
	public void PWARecoTalamoosModule(String userType) throws Exception {
		Zee5PWASanityBusinessLogic.verificationOfRecoTalamoos(userType);
	}

	@Test(priority = 17) // BASAVARAJ
	public void PWAVIL() throws Exception {
		Zee5PWASanityBusinessLogic.verifyingVodafoneNativeApp();
	}

	@Test(priority = 18) // BASAVARAJ
	@Parameters({ "userType" })
	public void PWAKalturaPlayability(String userType) throws Exception {
		Zee5PWASanityBusinessLogic.Kaltura(userType);
		//smoke Vinay
		Zee5PWASanityBusinessLogic.playerValidations(userType);
		Zee5PWASanityBusinessLogic.UpnextRail();
	}

	@Test(priority = 19) // BASAVARAJ
	@Parameters({"url", "userType", "devicePin", "consumptionsEpisode","consumptionsShow","consumptionsFreeContent","consumptionsPremiumContent"}) 
	public void PWAContentDetails(String url, String userType, String devicePin, String consumptionsEpisode,String consumptionsShow,String consumptionsFreeContent,String consumptionsPremiumContent)throws Exception {
		Zee5PWASanityBusinessLogic.ContentDetails(userType);
		Zee5PWASanityBusinessLogic.checkDurationInLivetv();
		Zee5PWASanityBusinessLogic.checkDurationandProgressVideo(userType);
		//smoke Tanisha
		Zee5PWASanityBusinessLogic.verifyConsumptionsScreenTappingOnCard(userType, "Episode", consumptionsEpisode); // Episode //Mahira accuses Preeta of// trying to kill Mahesh //Neil gets// emotional while apologising to Jhende
		Zee5PWASanityBusinessLogic.verifyConsumptionsScreenTappingOnCard(userType, "Live TV", ""); // Live TV Card
		Zee5PWASanityBusinessLogic.verifyNoSubscriptionPopupForFreeContent(userType, consumptionsFreeContent);
		Zee5PWASanityBusinessLogic.verifySubscriptionPopupForPremiumContent(userType, consumptionsPremiumContent);
		Zee5PWASanityBusinessLogic.verifyCTAandMetaDataInDetailsAndConsumption(consumptionsShow);
	}

	@Test(priority = 20) // BASAVARAJ
	@Parameters({ "userType" })
	public void PWATimedAnchors(String userType) throws Exception {	
		Zee5PWASanityBusinessLogic.ShowsTimeperiodProvided(userType);
		Zee5PWASanityBusinessLogic.musicTimeperiodProvided(userType);
		Zee5PWASanityBusinessLogic.TimedAnchors(userType);
		Zee5PWASanityBusinessLogic.moviesTimeperiodProvided(userType);
		Zee5PWASanityBusinessLogic.continueWatchingtrayData(userType);
		
	}

	@Test(priority = 21) // SHREENIDHI
	@Parameters({ "userType" })
	public void PWAProfile(String userType) throws Exception {
		Zee5PWASanityBusinessLogic.myProfileScenarios(userType);
	}

	
	@Test(priority = 22) // SHREENIDHI
	@Parameters({ "userType" })
	public void PWAOnboardingScenarios(String userType) throws Exception {
		Zee5PWASanityBusinessLogic.OnboardingScenario(userType); //from smoke
	}
	
*/	
	@Test(priority = 23) // BHAVANA
	@Parameters({"userType"})
	public void PWAStaticPagesInMenuAndFooterSection(String userType) throws Exception{
		Zee5PWASanityBusinessLogic.staticPagesandFooterSectionValidation(userType); 		
	}	
/*
	@Test(priority = 24)// BINDU
	@Parameters({ "userType"})
    public void PWAZeeOriginalsPageValidation(String UserType) throws Exception {
		Zee5PWASanityBusinessLogic.Zee5OriginalsScreen(UserType, "ZEE5 Originals");
    }

	@Test(priority = 25)// VINAY
	@Parameters({ "userType"})
    public void PWALanguageModule(String UserType) throws Exception {
		Zee5PWASanityBusinessLogic.LanguageModule(UserType);
    }
*/		
	@AfterClass
	public void tearDown() {
		Zee5PWASanityBusinessLogic.tearDown();
	}
}

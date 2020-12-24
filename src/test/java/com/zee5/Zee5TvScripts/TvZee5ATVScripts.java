package com.zee5.Zee5TvScripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5TvBusinessLogic;

public class TvZee5ATVScripts {

	private Zee5TvBusinessLogic Zee5TvBusiness;

	@BeforeTest
	public void Before() throws InterruptedException {
		// Utilities.relaunch = true;
		Zee5TvBusiness = new Zee5TvBusinessLogic("zee");
	}

//	@Test(priority = 1)
	@Parameters({ "userType" })
	public void chooseLanguage(String userType) throws Exception {
		Zee5TvBusiness.chooseLanguagePopup();
	}
//	@Test(priority = 2)
	public void deviceAuthentication() throws Exception {
		Zee5TvBusiness.device();
	}
	@Test(priority = 3)
	@Parameters({ "userType" })
	public void welcomescreen(String userType) throws Exception {
		Zee5TvBusiness.welcomescreen();
	}

	@Test(priority = 4)
	@Parameters({ "userType" })
	public void Login(String userType) throws Exception {
		Zee5TvBusiness.login(userType);
	}

//	@Test(priority = 5)
	@Parameters({ "userType" })
	public void searchScenarios(String userType) throws Exception {
		Zee5TvBusiness.searchScenarios(userType);
	}

//	@Test(priority = 6)
	@Parameters({ "userType" })
	public void playback(String userType) throws Exception {
		Zee5TvBusiness.playbackHomepage();
//		Zee5TvBusiness.playbackShowspage();
//		Zee5TvBusiness.playbackMoviespage();
//		Zee5TvBusiness.playbackNewspage();
//		Zee5TvBusiness.playbackPremiumpage();
//		Zee5TvBusiness.playbackvideospage();
	}

//	@Test(priority = 7)
	@Parameters({ "userType" })
	public void carousel(String tab) throws Exception {
		Zee5TvBusiness.carouselValidation("Home");
//		Zee5TvBusiness.carouselValidation("Shows");
//		Zee5TvBusiness.carouselValidation("Movies");
//		Zee5TvBusiness.carouselValidation("News");
//		Zee5TvBusiness.carouselValidation("Premium");
//		Zee5TvBusiness.carouselValidation("Videos");
	}

//	@Test(priority = 8)
	@Parameters({ "userType" })
	public void landingScenarios(String userType) throws Exception {
		Zee5TvBusiness.landingPageHome(userType);
//		Zee5TvBusiness.landingPageShows(userType);
//		Zee5TvBusiness.landingPageMovies(userType);
//		Zee5TvBusiness.landingPageNews(userType);
//		Zee5TvBusiness.landingPagePremium(userType);
//		Zee5TvBusiness.landingPageVideos(userType);
	}

//	@Test(priority = 9)
	@Parameters({ "userType" })
	public void playerScenarios(String userType) throws Exception {
		Zee5TvBusiness.playerScenarios();
	}

//	@Test(priority = 10)
	@Parameters({ "userType" })
	public void setting(String userType) throws Exception {
		Zee5TvBusiness.setting(userType);
	}

//	@Test(priority = 11)
	public void collectingPage() throws Exception {
		Zee5TvBusiness.collectionpage();
	}

//	@Test(priority = 12)
	public void subscription() throws Exception {
		Zee5TvBusiness.subscription();
	}

//	@Test(priority = 13)
	public void continueWatching() throws Exception {
		Zee5TvBusiness.continueWatching();
	}

//	@Test(priority = 14)
	public void liveTV() throws Exception {
		Zee5TvBusiness.liveTv();
	}

//	@Test(priority = 15)
	public void beforeTV() throws Exception {
		Zee5TvBusiness.beforeTV();
	}

//	@Test(priority = 16)
	public void upNext() throws Exception {
		Zee5TvBusiness.upnext();
	}

	@Test(priority = 17)
	public void language() throws Exception {
		Zee5TvBusiness.languagePage();
	}
	
//	@Test(priority = 18)
	public void ads() throws Exception {
		Zee5TvBusiness.ads();
	}
	
//	@Test(priority = 19)
	public void profile() throws Exception {
		Zee5TvBusiness.profile();
	}
	
//	@Test(priority = 20)
	public void deeplinking() throws Exception {
		Zee5TvBusiness.deeplinking();
	}
	
	@Test(priority = 21)
	public void headerSection() throws Exception {
		Zee5TvBusiness.headerSection();
	}
//	@Test(priority = 22)
	public void talamoos() throws Exception {
		Zee5TvBusiness.talamoos();
	}

	@Test(priority = 23)
	public void staticPage() throws Exception {
		Zee5TvBusiness.staticPages();
	}
	
	@AfterTest
	public void After() {
		System.out.println("Tear Down");
		Zee5TvBusiness.TvtearDown();
	}

}

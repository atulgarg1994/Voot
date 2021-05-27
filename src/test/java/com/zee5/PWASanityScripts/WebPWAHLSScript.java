package com.zee5.PWASanityScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5PWASanityWEBBusinessLogic;

public class WebPWAHLSScript {

	private Zee5PWASanityWEBBusinessLogic Zee5WEBPWASanityBusinessLogic;

	@BeforeTest
	public void init() throws Exception {
		Zee5WEBPWASanityBusinessLogic = new Zee5PWASanityWEBBusinessLogic("Chrome");
	}

	@Test(priority = 1)
	@Parameters({ "userType" })
	public void PWAWEBLogin(String userType) throws Exception {
		System.out.println("PWAWEBLogin");
		Zee5WEBPWASanityBusinessLogic.ZeeWEBPWALogin(userType);
	}

	@Test(priority = 2)
	@Parameters({ "userType" })
	public void homePageValidationHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.Homepagevalidation(userType, "Home");
	}

	@Test(priority = 3)
	@Parameters({ "userType" })
	public void moviePageValidationHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.movies("Movies", userType);
	}

	@Test(priority = 4)
	@Parameters({ "userType" })
	public void tvShowsPageValidationHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.tvShowsValidation("TV Shows", userType);
	}

	@Test(priority = 5)
	@Parameters({ "userType" })
	public void onBoardingHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.silentRegistrationViaEmail(userType);
		Zee5WEBPWASanityBusinessLogic.SocialLogin(userType);
		Zee5WEBPWASanityBusinessLogic.Carouselcontent(userType);
	}

	@Test(priority = 6)
	@Parameters({ "userType" })
	public void newsPageValidationHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.newsValidation(userType, "News");
	}

	//@Test(priority = 7)
	@Parameters({ "userType" })
	public void clubPageValidationHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.Clubvalidation("Club", userType);
	}

	@Test(priority = 8)
	@Parameters({ "userType" })
	public void premiumPageValidationHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.Premiumvalidation("Premium", userType);
	}

	@Test(priority = 9)
	@Parameters({ "userType" })
	public void musicPageValidationHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.Musicvalidation("Music", userType);
	}

	@Test(priority = 10)
	@Parameters({ "userType" })
	public void livePageValidationHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.LiveTVValidation(userType, "Live TV");
	}

	@Test(priority = 11)
	@Parameters({ "userType" })
	public void storiesPageValidationHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.storiesvalidation(userType, "Stories");
	}

	@Test(priority = 12)
	@Parameters({ "userType" })
	public void videoPageValidationHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.videoValidation(userType, "Videos");
	}

	@Test(priority = 13)
	@Parameters({ "userType" })
	public void webSeriesPageValidationHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.webSeriesValidation(userType, "Web Series");
	}

	@Test(priority = 14)
	@Parameters({ "userType" })
	public void searchPageValidationHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.Search("Paaru ");
	}

	@Test(priority = 15)
	@Parameters({ "userType" })
	public void playPageValidationHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.PlayValidation("Play", userType);
	}

	@Test(priority = 16)
	@Parameters({ "userType" })
	public void kalturaPageValidationHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.kaltura(userType, "Home");
	}

	@Test(priority = 17)
	@Parameters({ "userType" })
	public void subscriptionPageValidationHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.Subscriptionjourney(userType, "Home");
	}

	@Test(priority = 18)
	@Parameters({ "userType" })
	public void mySubscriptionPageValidationHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.MySubscription(userType);
		Zee5WEBPWASanityBusinessLogic.MyTransactions(userType);
	}

	//@Test(priority = 19)
	@Parameters({ "userType" })
	public void upgradePageValidationHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.upgrade(userType);
	}

	@Test(priority = 20)
	@Parameters({ "userType" })
	public void zeeplexValidationHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.zeeplexvalidation("ZEEPLEX", userType);
	}

	@Test(priority = 21)
	@Parameters({ "userType" })
	public void kidsPageValidationHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.kidsvalidation(userType, "Kids");
	}
	
//	@Test(priority = 22)
//	@Parameters({ "userType" })
//	public void InSprintComboOfferAutomation(String userType) throws Exception {
//		Zee5WEBPWASanityBusinessLogic.navigateToHome();
//		Zee5WEBPWASanityBusinessLogic.ComboOfferPremiumPlex(userType);
//	}
	

	@AfterClass
	public void tearDown() {
		
		Zee5WEBPWASanityBusinessLogic.tearDown();
	}
}
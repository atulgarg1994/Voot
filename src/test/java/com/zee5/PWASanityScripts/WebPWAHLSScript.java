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
		// zee5WebBusinessLogic.relaunchFlag = false;
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
	public void HomePagevalidationHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.Homepagevalidation(userType, "Home");
//		Zee5WEBPWASanityBusinessLogic.trayTitleAndContentValidationWithApiDataHome("Home", "home");
//		Zee5WEBPWASanityBusinessLogic.MetadataOnCarousel("Premium", userType);
		// Zee5WEBPWASanityBusinessLogic.MetadataOnCarousel("Premium", userType);
	}

	@Test(priority = 3)
	@Parameters({ "userType" })
	public void MoviePagevalidationHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.movies("Movies", userType);
	}

	@Test(priority = 4)
	@Parameters({ "userType" })
	public void ShowsPagevalidationHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.Shows("Shows", userType);
	}

	@Test(priority = 5)
	@Parameters({ "userType" })
	public void onboardingHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.silentRegistrationViaEmail(userType);
		Zee5WEBPWASanityBusinessLogic.SocialLogin(userType);
		Zee5WEBPWASanityBusinessLogic.Carouselcontent(userType);
	}

	@Test(priority = 6)
	@Parameters({ "userType" })
	public void NewsPagevalidationHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.newsValidation(userType, "News");
	}

	@Test(priority = 7)
	@Parameters({ "userType" })
	public void ClubPagevalidationHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.Clubvalidation("Club", userType);
	}

	@Test(priority = 8)
	@Parameters({ "userType" })
	public void PremiumPagevalidationHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.Premiumvalidation("Premium", userType);
	}

	@Test(priority = 9)
	@Parameters({ "userType" })
	public void musicPagevalidationHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.Musicvalidation("Music", userType);
	}

	@Test(priority = 10)
	@Parameters({ "userType" })
	public void LivePagevalidationHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.LiveTVValidation(userType, "Music");
	}

	@Test(priority = 11)
	@Parameters({ "userType" })
	public void StoriesPagevalidationHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.storiesvalidation(userType, "Stories");
	}

	@Test(priority = 12)
	@Parameters({ "userType" })
	public void videoPagevalidationHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.videoValidation(userType, "Videos");
	}

	@Test(priority = 13)
	@Parameters({ "userType" })
	public void Zee5PagevalidationHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.Zee5OriginalsValidation(userType, "ZEE5 Originals");
	}

	@Test(priority = 14)
	@Parameters({ "userType" })
	public void SearchPagevalidationHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.Search("Parru ");
	}

	@Test(priority = 15)
	@Parameters({ "userType" })
	public void PlayPagevalidationHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.PlayValidation("Play", userType);
	}

	@Test(priority = 16)
	@Parameters({ "userType" })
	public void KalturaPagevalidationHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.kaltura(userType, "Home");
	}

	@Test(priority = 17)
	@Parameters({ "userType" })
	public void SubscriptionPagevalidationHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.Subscriptionjourney(userType, "Home");
	}

	@Test(priority = 18)
	@Parameters({ "userType" })
	public void MySubscriptionPagevalidationHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.MySubscription(userType);
		Zee5WEBPWASanityBusinessLogic.MyTransactions(userType);
	}

	@Test(priority = 19)
	@Parameters({ "userType" })
	public void UpgradePagevalidationHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.upgrade(userType);
	}

	@Test(priority = 20)
	@Parameters({ "userType" })
	public void zeeplexvalidationHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.zeeplexvalidation("ZEEPLEX", userType);
	}

	@Test(priority = 21)
	@Parameters({ "userType" })
	public void KidsPagevalidationHLS(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.kidsvalidation(userType, "Kids");
	}

	@AfterClass
	public void tearDown() {
		Zee5WEBPWASanityBusinessLogic.tearDown();
	}
}

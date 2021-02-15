package com.zee5.WebMixpanelScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5PWAWEBMixPanelBusinessLogic;

public class ParentalOverlayImpressionEvent {

	private Zee5PWAWEBMixPanelBusinessLogic Zee5PWAWEBMixPanelBusinessLogic;

	@BeforeTest
	public void init() throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic = new Zee5PWAWEBMixPanelBusinessLogic("Chrome");
	}

	@Test(priority = 1)
	@Parameters({ "userType", "keyword4" })
	public void verifyParentalOverlayImpressionEventForFreeContent(String userType, String keyword4) throws Exception {
		System.out.println("Verify Parental Overlay Impression Event For Free Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayImpressionEventForFreeContent(userType, keyword4);
	}

	@Test(priority = 2)
	@Parameters({ "userType" })
	public void verifyParentalOverlayImpressionEventForPremiumContent(String userType) throws Exception {
		System.out.println("Verify Parental Overlay Impression Event For Premium Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayImpressionEventForPremiumContent(userType, "Home");
	}

	@Test(priority = 3)
	@Parameters({ "keyword1", "userType" })
	public void verifyParentalOverlayImpressionEventForTrailer(String keyword1, String userType) throws Exception {
		System.out.println("Verify Parental Overlay Impression Event For Trailer Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayImpressionEventForTrailer(keyword1, userType);
	}

	@Test(priority = 4)
	@Parameters({ "userType" })
	public void verifyParentalOverlayImpressionEventForCarouselContent(String userType) throws Exception {
		System.out.println("Verify Parental Overlay Impression Event For Carousel Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayImpressionEventForCarouselContent(userType);
	}

	@Test(priority = 5)
	@Parameters({ "userType" })
	public void verifyParentalOverlayImpressionEventForContentInTray(String userType) throws Exception {
		System.out.println("Verify Parental Overlay Impression Event For Content played from Tray");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayImpressionEventForContentInTray(userType);
	}

	@Test(priority = 6)
	@Parameters({ "keyword1", "userType" })
	public void verifyParentalOverlayImpressionEventForContentFromSearchPage(String keyword1, String userType)
			throws Exception {
		System.out.println("Verify Parental Overlay Impression Event For Content From Search Page");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayImpressionEventForContentFromSearchPage(keyword1,
				userType);
	}

	@Test(priority = 7)
	@Parameters({ "userType", "keyword" })
	public void verifyParentalOverlayImpressionEventForContentFromMyWatchlistPage(String userType, String keyword)
			throws Exception {
		System.out.println("Verify Parental Overlay Impression Event For Content From My Watchlist Page");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayImpressionEventForContentFromMyWatchlistPage(userType,
				keyword);
	}

	@Test(priority = 8)
	@Parameters({ "userType" })
	public void verifyParentalOverlayImpressionEventForContentInMegamenu(String userType) throws Exception {
		System.out.println("Verify Parental Overlay Impression Event For Content played from Megamenu");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayImpressionEventForContentInMegamenu(userType);
	}

	@Test(priority = 9)
	@Parameters({ "userType", "keyword" })
	public void verifyParentalOverlayImpressionEventForContentInPlaylist(String userType, String keyword)
			throws Exception {
		System.out.println("Verify Parental Overlay Impression Event For Content played from Playlist");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayImpressionEventForContentInPlaylist(userType, keyword);
	}

	@Test(priority = 10)
	@Parameters({ "userType", "keyword4" })
	public void verifyParentalOverlayImpressionEventForContentFromUpnextRail(String userType, String keyword4)
			throws Exception {
		System.out.println("Verify Parental Overlay Impression Event For Content played from Upnext rail");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayImpressionEventForContentFromUpnextRail(userType,
				keyword4);
	}

	@Test(priority = 11)
	@Parameters({ "freeContentURL", "userType" })
	public void verifyParentalOverlayImpressionEventForContentFromSharedLink(String freeContentURL, String userType)
			throws Exception {
		System.out.println("Verify Parental Overlay Impression Event For content played from Shared Link");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayImpressionEventForContentFromSharedLink(freeContentURL,
				userType);
	}

	@Test(priority = 12)
	@Parameters({ "keyword1", "userType" })
	public void verifyParentalOverlayImpressionEventAfterPageRefresh(String keyword1, String userType)
			throws Exception {
		System.out.println("Verify Parental Overlay Impression Event after refreshing the page");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayImpressionEventAfterPageRefresh(keyword1, userType);
	}

	@AfterClass
	public void tearDown() {
		Zee5PWAWEBMixPanelBusinessLogic.tearDown();
	}
}

package com.zee5.WebMixpanelScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.business.zee.Zee5PWAWEBMixPanelBusinessLogic;

public class ParentalOverlayResultEvent {

	private Zee5PWAWEBMixPanelBusinessLogic Zee5PWAWEBMixPanelBusinessLogic;

	@BeforeTest
	public void init() throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic = new Zee5PWAWEBMixPanelBusinessLogic("Chrome");
	}
	
	@Test(priority = 0)
	@Parameters({ "userType" })
	public void PWAWEBMixPanelLogin(String userType) throws Exception {
		System.out.println("Login");
		Zee5PWAWEBMixPanelBusinessLogic.ZeeWEBPWAMixPanelLogin(userType);
	}

	@Test(priority = 1)
	@Parameters({ "userType", "keyword4" })
	public void verifyParentalOverlayResultEventForFreeContent(String userType, String keyword4) throws Exception {
		System.out.println("Verify Parental Overlay Result Event For Free Content");
		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayResultEventForFreeContent(userType, keyword4);
	}

	@Test(priority = 2)
	@Parameters({ "userType" })
	public void verifyParentalOverlayResultEventForPremiumContent(String userType) throws Exception {
		System.out.println("Verify Parental Overlay Result Event For Premium Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayResultEventForPremiumContent(userType, "Home");
	}

	@Test(priority = 3)
	@Parameters({ "keyword1", "userType" })
	public void verifyParentalOverlayResultEventForTrailer(String keyword1, String userType) throws Exception {
		System.out.println("Verify Parental Overlay Result Event For Trailer Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayResultEventForTrailer(keyword1, userType);
	}

	@Test(priority = 4)
	@Parameters({ "userType" })
	public void verifyParentalOverlayResultEventForCarouselContent(String userType) throws Exception {
		System.out.println("Verify Parental Overlay Result Event For Carousel Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayResultEventForCarouselContent(userType);
	}

	@Test(priority = 5)
	@Parameters({ "userType" })
	public void verifyParentalOverlayResultEventForContentInTray(String userType) throws Exception {
		System.out.println("Verify Parental Overlay Result Event For Content played from Tray");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayResultEventForContentInTray(userType);
	}

	@Test(priority = 6)
	@Parameters({ "keyword1", "userType" })
	public void verifyParentalOverlayResultEventForContentFromSearchPage(String keyword1, String userType)
			throws Exception {
		System.out.println("Verify Parental Overlay Result Event For Content From Search Page");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayResultEventForContentFromSearchPage(keyword1, userType);
	}

	@Test(priority = 7)
	@Parameters({ "userType", "keyword" })
	public void verifyParentalOverlayResultEventForContentFromMyWatchlistPage(String userType, String keyword)
			throws Exception {
		System.out.println("Verify Parental Overlay Result Event For Content From My Watchlist Page");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayResultEventForContentFromMyWatchlistPage(userType,
				keyword);
	}

	@Test(priority = 8)
	@Parameters({ "userType" })
	public void verifyParentalOverlayResultEventForContentInMegamenu(String userType) throws Exception {
		System.out.println("Verify Parental Overlay Result Event For Content played from Megamenu");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayResultEventForContentInMegamenu(userType);
	}

	@Test(priority = 9)
	@Parameters({ "userType", "keyword" })
	public void verifyParentalOverlayResultEventForContentInPlaylist(String userType, String keyword) throws Exception {
		System.out.println("Verify Parental Overlay Result Event For Content played from Playlist");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayResultEventForContentInPlaylist(userType, keyword);
	}

	@Test(priority = 10)
	@Parameters({ "userType", "keyword4" })
	public void verifyParentalOverlayResultEventForContentFromUpnextRail(String userType, String keyword4)
			throws Exception {
		System.out.println("Verify Parental Overlay Result Event For Content played from Upnext rail");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayResultEventForContentFromUpnextRail(userType, keyword4);
	}

	@Test(priority = 11)
	@Parameters({ "freeContentURL", "userType" })
	public void verifyParentalOverlayResultEventForContentFromSharedLink(String freeContentURL, String userType)
			throws Exception {
		System.out.println("Verify Parental Overlay Result Event For content played from Shared Link");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyParentalOverlayResultEventForContentFromSharedLink(freeContentURL,
				userType);
	}

	@AfterClass
	public void tearDown() {
		Zee5PWAWEBMixPanelBusinessLogic.tearDown();
	}
}

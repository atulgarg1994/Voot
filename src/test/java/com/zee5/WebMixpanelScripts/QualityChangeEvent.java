package com.zee5.WebMixpanelScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.business.zee.Zee5PWAWEBMixPanelBusinessLogic;

public class QualityChangeEvent {

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
	@Parameters({ "keyword1" })
	public void verifyQualityChangeEvent(String keyword1) throws Exception {
		System.out.println("Verify Quality Change Event");
		Zee5PWAWEBMixPanelBusinessLogic.verifyQualityChangeEvent(keyword1);
	}

	@Test(priority = 2)
	@Parameters({ "userType", "keyword4" })
	public void verifyQualityChangeEventForFreeContent(String userType, String keyword4) throws Exception {
		System.out.println("Verify Quality Change Event For Free Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyQualityChangeEventForFreeContent(userType, keyword4);
	}

	@Test(priority = 3)
	@Parameters({ "userType" })
	public void verifyQualityChangeEventForPremiumContent(String userType) throws Exception {
		System.out.println("Verify Quality Change Event For Premium Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyQualityChangeEventForPremiumContent(userType, "Home");
	}

	@Test(priority = 4)
	@Parameters({ "keyword1" })
	public void verifyQualityChangeEventForTrailer(String keyword1) throws Exception {
		System.out.println("Verify Quality Change Event For Trailer Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyQualityChangeEventForTrailer(keyword1);
	}

	@Test(priority = 5)
	public void verifyQualityChangeEventForCarouselContent() throws Exception {
		System.out.println("Verify Quality Change Event For Carousel Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyQualityChangeEventForCarouselContent();
	}

	@Test(priority = 6)
	public void verifyQualityChangeEventForContentInTray() throws Exception {
		System.out.println("Verify Quality Change Event For Content played from Tray");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyQualityChangeEventForContentInTray();
	}

	@Test(priority = 7)
	@Parameters({ "keyword1" })
	public void verifyQualityChangeEventForContentFromSearchPage(String keyword1) throws Exception {
		System.out.println("Verify Quality Change Event For Content From Search Page");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyQualityChangeEventForContentFromSearchPage(keyword1);
	}

	@Test(priority = 8)
	@Parameters({ "userType", "keyword" })
	public void verifyQualityChangeEventForContentFromMyWatchlistPage(String userType, String keyword)
			throws Exception {
		System.out.println("Verify Quality Change Event For Content From My Watchlist Page");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyQualityChangeEventForContentFromMyWatchlistPage(userType, keyword);
	}

	@Test(priority = 9)
	public void verifyQualityChangeEventForContentInMegamenu() throws Exception {
		System.out.println("Verify Quality Change Event For Content played from Megamenu");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyQualityChangeEventForContentInMegamenu();
	}

	@Test(priority = 10)
	@Parameters({ "userType", "keyword" })
	public void verifyQualityChangeEventForContentInPlaylist(String userType, String keyword) throws Exception {
		System.out.println("Verify Quality Change Event For Content played from Playlist");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyQualityChangeEventForContentInPlaylist(userType, keyword);
	}

	@Test(priority = 11)
	@Parameters({ "userType", "keyword4" })
	public void verifyQualityChangeEventForContentFromUpnextRail(String userType, String keyword4) throws Exception {
		System.out.println("Verify Quality Change Event For Content played from Upnext rail");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyQualityChangeEventForContentFromUpnextRail(userType, keyword4);
	}

	@Test(priority = 12)
	@Parameters({ "freeContentURL" })
	public void verifyQualityChangeEventForContentFromSharedLink(String freeContentURL) throws Exception {
		System.out.println("Verify Quality Change Event For content played from Shared Link");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyQualityChangeEventForContentFromSharedLink(freeContentURL);
	}

	@Test(priority = 13)
	public void verifyQualityChangeEventForLinearContent() throws Exception {
		System.out.println("Verify Quality Change Event For Linear Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyQualityChangeEventForLinearContent();
	}

	@AfterClass
	public void tearDown() {
		Zee5PWAWEBMixPanelBusinessLogic.tearDown();
	}
}

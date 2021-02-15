package com.zee5.WebMixpanelScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.business.zee.Zee5PWAWEBMixPanelBusinessLogic;

public class VideoViewEvent {

	private Zee5PWAWEBMixPanelBusinessLogic Zee5PWAWEBMixPanelBusinessLogic;

	@BeforeTest
	public void init() throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic = new Zee5PWAWEBMixPanelBusinessLogic("Chrome");
	}
	
	@Test(priority = 1)
	@Parameters({ "userType", "keyword4"})
	public void verifyVideoViewEventForContentFromUpnextRail(String userType,String keyword4) throws Exception {
		System.out.println("Verify Video View Event for content autoplayed from Upnext rail");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoViewEventForContentFromUpnextRail(userType,keyword4);
	}
	
	@Test(priority = 2)
	@Parameters({"freeContentURL"})
	public void verifyVideoViewEventForContentFromSharedLink(String freeContentURL) throws Exception {
		System.out.println("Verify Video View Event For content played from Shared Link");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoViewEventForContentFromSharedLink(freeContentURL);
	}
	
	@Test(priority = 3)
	@Parameters({ "userType", "keyword4"})
	public void verifyVideoViewEventForFreeContent(String userType,String keyword4) throws Exception {
		System.out.println("Verify Video View Event For Free Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoViewEventForFreeContent(userType,keyword4);
	}
	
	@Test(priority = 4)
	@Parameters({ "userType"})
	public void verifyVideoViewEventForPremiumContent(String userType) throws Exception {
		System.out.println("Verify Video View Event For Premium Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoViewEventForPremiumContent(userType,"Home");
	}
	
	@Test(priority = 5)
	@Parameters({ "keyword1"})
	public void verifyVideoViewEventForTrailer(String keyword1) throws Exception {
		System.out.println("Verify Video View Event For Trailer Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoViewEventForTrailer(keyword1);
	}
	
	@Test(priority = 6)
	public void verifyVideoViewEventForCarouselContent() throws Exception {
		System.out.println("Verify Video View Event For Carousel Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoViewEventForCarouselContent();
	}
	
	@Test(priority = 7)
	public void verifyVideoViewEventForContentInTray() throws Exception {
		System.out.println("Verify Video View Event For Content played from Tray");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoViewEventForContentInTray();
	}
	
	@Test(priority = 8)
	@Parameters({"keyword1"})
	public void verifyVideoViewEventForContentFromSearchPage(String keyword1) throws Exception {
		System.out.println("Verify Video View Event For Content From Search Page");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoViewEventForContentFromSearchPage(keyword1);
	}
	
	@Test(priority = 9)
	@Parameters({ "userType", "keyword"})
	public void verifyVideoViewEventForContentFromMyWatchlistPage(String userType,String keyword) throws Exception {
		System.out.println("Verify Video View Event For Content From My Watchlist Page");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoViewEventForContentFromMyWatchlistPage(userType,keyword);
	}
	
	@Test(priority = 10)
	public void verifyVideoViewEventForContentInMegamenu() throws Exception {
		System.out.println("Verify Video View Event For Content played from Megamenu");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoViewEventForContentInMegamenu();
	}
	
	@Test(priority = 11)
	@Parameters({ "userType", "keyword"})
	public void verifyVideoViewEventForContentInPlaylist(String userType,String keyword) throws Exception {
		System.out.println("Verify Video View Event For Content played from Playlist");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoViewEventForContentInPlaylist(userType,keyword);
	}
	
	@Test(priority = 12)
	@Parameters({"keyword1"})
	public void verifyVideoViewEventAfterRefreshingPage(String keyword1) throws Exception {
		System.out.println("Verify Video View Event after refreshing a page");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoViewEventAfterRefreshingPage(keyword1);
	}
	
	@AfterClass
	public void tearDown() {
		Zee5PWAWEBMixPanelBusinessLogic.tearDown();
	}
}

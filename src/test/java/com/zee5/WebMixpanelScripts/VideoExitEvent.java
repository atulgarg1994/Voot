package com.zee5.WebMixpanelScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.business.zee.Zee5PWAWEBMixPanelBusinessLogic;

public class VideoExitEvent {

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
	@Parameters({ "userType", "keyword"})
	public void verifyVideoExitEventForContentInPlaylist(String userType,String keyword) throws Exception {
		System.out.println("Verify Video Exit Event For Content played from Playlist");
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoExitEventForContentInPlaylist(userType,keyword);
	}
	
	@Test(priority = 2)
	@Parameters({"keyword1"})
	public void verifyVideoExitEventAfterRefreshingPage(String keyword1) throws Exception {
		System.out.println("Verify Video Exit Event after refreshing a page");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoExitEventAfterRefreshingPage(keyword1);
	}
	
	@Test(priority = 3)
	@Parameters({ "userType", "keyword4"})
	public void verifyVideoExitEventForContentFromUpnextRail(String userType,String keyword4) throws Exception {
		System.out.println("Verify Video Exit Event for content autoplayed from Upnext rail");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoExitEventForContentFromUpnextRail(userType,keyword4);
	}
	
	@Test(priority = 4)
	@Parameters({"freeContentURL"})
	public void verifyVideoExitEventForContentFromSharedLink(String freeContentURL) throws Exception {
		System.out.println("Verify Video Exit Event For content played from Shared Link");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoExitEventForContentFromSharedLink(freeContentURL);
	}
	
	@Test(priority = 5)
	@Parameters({ "userType", "keyword4"})
	public void verifyVideoExitEventForFreeContent(String userType,String keyword4) throws Exception {
		System.out.println("Verify Video Exit Event For Free Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoExitEventForFreeContent(userType,keyword4);
	}
	
	@Test(priority = 6)
	@Parameters({ "userType"})
	public void verifyVideoExitEventForPremiumContent(String userType) throws Exception {
		System.out.println("Verify Video Exit Event For Premium Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoExitEventForPremiumContent(userType,"Home");
	}
	
	@Test(priority = 7)
	@Parameters({ "keyword1"})
	public void verifyVideoExitEventForTrailer(String keyword1) throws Exception {
		System.out.println("Verify Video Exit Event For Trailer Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoExitEventForTrailer(keyword1);
	}
	
	@Test(priority = 8)
	public void verifyVideoExitEventForCarouselContent() throws Exception {
		System.out.println("Verify Video Exit Event For Carousel Content");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoExitEventForCarouselContent();
	}
	
	@Test(priority = 9)
	public void verifyVideoExitEventForContentInTray() throws Exception {
		System.out.println("Verify Video Exit Event For Content played from Tray");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoExitEventForContentInTray();
	}
	
	@Test(priority = 10)
	@Parameters({"keyword1"})
	public void verifyVideoExitEventForContentFromSearchPage(String keyword1) throws Exception {
		System.out.println("Verify Video Exit Event For Content From Search Page");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoExitEventForContentFromSearchPage(keyword1);
	}
	
	@Test(priority = 11)
	@Parameters({ "userType", "keyword"})
	public void verifyVideoExitEventForContentFromMyWatchlistPage(String userType,String keyword) throws Exception {
		System.out.println("Verify Video Exit Event For Content From My Watchlist Page");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoExitEventForContentFromMyWatchlistPage(userType,keyword);
	}
	
	@Test(priority = 12)
	public void verifyVideoExitEventForContentInMegamenu() throws Exception {
		System.out.println("Verify Video Exit Event For Content played from Megamenu");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifyVideoExitEventForContentInMegamenu();
	}
	
	@AfterClass
	public void tearDown() {
		Zee5PWAWEBMixPanelBusinessLogic.tearDown();
	}
}

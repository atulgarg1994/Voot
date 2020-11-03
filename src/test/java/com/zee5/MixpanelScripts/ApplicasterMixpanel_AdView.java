package com.zee5.MixpanelScripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.business.zee.Zee5ApplicasterMixPanelBusinessLogic;
import com.utility.Utilities;

public class ApplicasterMixpanel_AdView {

	private Zee5ApplicasterMixPanelBusinessLogic Zee5ApplicasterMixPanelBusinessLogic;

	@BeforeTest
	public void init() throws Exception {
		Utilities.relaunch = true;
		Zee5ApplicasterMixPanelBusinessLogic = new Zee5ApplicasterMixPanelBusinessLogic("zee");
	}

	@Test(priority = 1)
	@Parameters({ "userType" })
	public void PWAWEBMixPanelLogin(String userType) throws Exception {
		System.out.println("Login");
		Zee5ApplicasterMixPanelBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		Zee5ApplicasterMixPanelBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		Zee5ApplicasterMixPanelBusinessLogic.ZeeApplicasterLogin(userType);
		
	}
	
	@Test(priority = 2)
	@Parameters({ "userType", "keyword3"})
	public void AdViewEventofTrailerContent(String userType, String keyword3) throws Exception {
		System.out.println("Ad View event of Trailer content");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.AdViewEventForTrailerContent(userType,keyword3);
		
	}

	@Test(priority = 3)
	@Parameters({ "userType"})
	public void AdViewEventofCarouselContent(String userType) throws Exception {
		System.out.println("Ad View event of Carousel content");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.AdViewEventForCarouselContent(userType, "Home");
	}
	
	@Test(priority = 4)
	@Parameters({ "userType"})
	public void AdViewEventofContentFromTray(String userType) throws Exception {
		System.out.println("Ad View event of Content from tray");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.AdViewEventForContentFromTray(userType, "Home");
	}

	@Test(priority = 5)
	@Parameters({ "userType","keyword4"})
	public void AdViewEventFromsearchpage(String userType, String keyword4) throws Exception {
		System.out.println("Ad View event of Content from Search page");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.AdViewEventOfcontentFromSearchPage(userType, keyword4);
	}
	
	@Test(priority = 6)
	@Parameters({ "userType"})
	public void AdViewEventFromMyWatchList(String userType) throws Exception {
		System.out.println("Ad View event of Content from My WatchList page");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.AdViewEventOfContentFromMyWatchListPage(userType);
		
	}
	
	@Test(priority = 7)
	@Parameters({ "userType", "keyword4"})
	public void AdViewEventFromUpNextRail(String userType, String keyword4) throws Exception {
		System.out.println("Ad View event of Content from Upnext Rail");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.AdViewEventOfContentFromUpNextRail(userType, keyword4);
		
	}
}

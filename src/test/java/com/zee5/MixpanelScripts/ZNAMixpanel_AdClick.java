package com.zee5.MixpanelScripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.business.zee.Zee5ApplicasterMixPanelBusinessLogic;
import com.utility.Utilities;

public class ZNAMixpanel_AdClick {

	private Zee5ApplicasterMixPanelBusinessLogic Zee5ApplicasterMixPanelBusinessLogic;

	@BeforeTest
	public void init() throws Exception {
		Utilities.relaunch = true;
		Zee5ApplicasterMixPanelBusinessLogic = new Zee5ApplicasterMixPanelBusinessLogic("zee");
	}

	@Test(priority = 1)
	@Parameters({ "userType" })
	public void AndroidAppMixPanelLogin(String userType) throws Exception {
		System.out.println("Login");
		Zee5ApplicasterMixPanelBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		Zee5ApplicasterMixPanelBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		Zee5ApplicasterMixPanelBusinessLogic.ZeeApplicasterLogin(userType);
		
	}
	
	@Test(priority = 2)
	@Parameters({ "userType", "keyword3"})
	public void AdClickEventofTrailerContent(String userType, String keyword3) throws Exception {
		System.out.println("Ad Click event of Trailer content");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.AdClickEventForTrailerContent(userType,keyword3);
		
	}
	
	@Test(priority = 3)
	@Parameters({ "userType"})
	public void AdClickEventofCarouselContent(String userType) throws Exception {
		System.out.println("Ad Click event of Carousel content");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.AdClickEventForCarouselContent(userType, "Home");
	}
	
	@Test(priority = 4)
	@Parameters({ "userType"})
	public void AdClickEventofContentFromTray(String userType) throws Exception {
		System.out.println("Ad Click event of Content from tray");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.AdClickEventForContentFromTray(userType, "Home");
	}
	
	@Test(priority = 5)
	@Parameters({ "userType","keyword4"})
	public void AdClickEventFromsearchpage(String userType, String keyword4) throws Exception {
		System.out.println("Ad Click event of Content from Search page");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.AdClickEventOfcontentFromSearchPage(userType, keyword4);
	}
	
	@Test(priority = 6)
	@Parameters({ "userType"})
	public void AdClickEventFromMyWatchList(String userType) throws Exception {
		System.out.println("Ad Click event of Content from My WatchList page");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.AdClickEventOfContentFromMyWatchListPage(userType);
		
	}
	
	@Test(priority = 7)
	@Parameters({ "userType", "keyword4"})
	public void AdClickEventFromUpNextRail(String userType, String keyword4) throws Exception {
		System.out.println("Ad Click event of Content from Upnext Rail");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.AdClickEventOfContentFromUpNextRail(userType, keyword4);
		
	}
}

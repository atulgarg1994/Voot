package com.zee5.AndroidSupermoonMixpanel;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5ApplicasterMixPanelBusinessLogic;
import com.utility.Utilities;

public class SuperMoon_RentalPageCTA {
	
private Zee5ApplicasterMixPanelBusinessLogic Zee5ApplicasterMixPanelBusinessLogic;
	
	@BeforeTest
	public void init() throws Exception {
		Utilities.relaunch = true;
		Zee5ApplicasterMixPanelBusinessLogic = new Zee5ApplicasterMixPanelBusinessLogic("zee");
	}

	@Test(priority = 1)
	@Parameters({ "userType", "SuperMoonRentalUserName", "SuperMoonRentalPassword" })
	public void AndroidAppMixPanelLogin(String userType, String SuperMoonRentalUserName, String SuperMoonRentalPassword) throws Exception {
		System.out.println("\nLogin");
		Zee5ApplicasterMixPanelBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		Zee5ApplicasterMixPanelBusinessLogic.LoginWithEmailID(SuperMoonRentalUserName, SuperMoonRentalPassword);
	}
	
	@Test(priority = 2)
	@Parameters({ "userType", "supermoonContentName", "SuperMoonRentalUserName", "SuperMoonRentalPassword" })
	public void RentalPageCTAsEvent(String usertype, String supermoonContentName, String SuperMoonRentalUserName, String SuperMoonRentalPassword) throws Exception {
		System.out.println("\n Rental page CTAs event");
		Zee5ApplicasterMixPanelBusinessLogic.RentalPageCTAEvent(usertype, supermoonContentName, SuperMoonRentalUserName, SuperMoonRentalPassword);
	}
	

	//###############-------END OF TEST-------###############
	
	@AfterTest
	public void tearDownApp() {
		System.out.println("\nQuit the App");
		Zee5ApplicasterMixPanelBusinessLogic.tearDown();
	}

}

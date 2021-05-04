package com.zee5.ApplicasterScripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5ApplicasterBusinessLogic;
import com.utility.Utilities;

public class Android_TVOD_ComboOffer {

	private Zee5ApplicasterBusinessLogic ZEE5ApplicasterBusinessLogic;
	
	@BeforeTest
	public void AppLaunch() throws InterruptedException {
		System.out.println("Launching Andriod App");
		Utilities.relaunch = true; // Clear App Data on First Launch
		ZEE5ApplicasterBusinessLogic = new Zee5ApplicasterBusinessLogic("zee");
	}

	@Test(priority = 0)
	@Parameters({ "userType", })
	public void ApplicasterLogin(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
	}
	
	@Test(priority = 1)
	@Parameters({ "userType" })
	public void SubscriptionScreenValidation(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.TVODComboOfferScreenValidation(userType);
	}
	
	
	@Test(priority = 2)
	@Parameters({ "userType","","","Radhe"}) //---Need to pass the credentials which has Radhe active plan
	public void ZEEPLEXContentInPlayerCTAValidation(String userType,String pEmailId, String pPassword, String pContentTitle) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToLoginScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.LoginWithEmailID(pEmailId, pPassword);
		ZEE5ApplicasterBusinessLogic.SearchZEEPLEXContentAndPlay(pContentTitle);
		ZEE5ApplicasterBusinessLogic.ZeePlexContentInPlayerCTAValidation();
	}
	
	@Test(priority = 3)
	@Parameters({ "userType","OneYearPremiumPack","CommomPassword","Mard Ki Zubaan"}) //---Need to pass the Zeeplex content name which is not rented
	public void ZEEPLEXContentPaymentScreenValidation(String userType,String pEmailId, String pPassword, String pContentTitle) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToLoginScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.LoginWithEmailID(pEmailId, pPassword);
		ZEE5ApplicasterBusinessLogic.SearchZEEPLEXContentAndPlay(pContentTitle);
		ZEE5ApplicasterBusinessLogic.ZeePlexContentRentNowCTAValidation();
	}
	
	
	@AfterTest
	public void tearDownApp() {
		System.out.println("\nQuit the App\n");
		ZEE5ApplicasterBusinessLogic.tearDown();
	}
	
}

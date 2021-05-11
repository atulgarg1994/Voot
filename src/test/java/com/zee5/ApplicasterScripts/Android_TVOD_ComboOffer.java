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
	
	@Test(priority = 3)		//AMA2-14007
	@Parameters({ "userType","OneYearPremiumPack","CommomPassword","RentalContentName1"}) //---Need to pass the Zeeplex content name which is not rented
	public void ZEEPLEXContentPaymentScreenValidation(String userType,String pEmailId, String pPassword, String pContentTitle) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToHomeScreen();
		ZEE5ApplicasterBusinessLogic.LoginWithEmailID(pEmailId, pPassword);
		ZEE5ApplicasterBusinessLogic.SearchZEEPLEXContentAndPlay(pContentTitle);
		ZEE5ApplicasterBusinessLogic.ZeePlexContentRentNowCTAValidation();
	}
	
	@Test(priority = 4)//Sushma - Logged in subscribed user with premium plans lower in value than the Combo offer price of 499/- without Radhe rental
	@Parameters({ "userType","99PremiumPackEmail", "249PremiumPackEmail", "299PremiumPackEmail", "CommomPassword", "tabName1", "Radhe"})
	public void UseCase1(String userType, String PremiumPackEmail99, String PremiumPackEmail249, String PremiumPackEmail299, String pPassword, String ptabName, String pContentTitle) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToLoginScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.LoginWithEmailID(PremiumPackEmail99, pPassword);
		ZEE5ApplicasterBusinessLogic.premiumUser_99(ptabName, pContentTitle);
		
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToLoginScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.LoginWithEmailID(PremiumPackEmail249, pPassword);
		ZEE5ApplicasterBusinessLogic.premiumUser_249(ptabName, pContentTitle);
		
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToLoginScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.LoginWithEmailID(PremiumPackEmail299, pPassword);
		ZEE5ApplicasterBusinessLogic.premiumUser_299(ptabName, pContentTitle);
		
	}
	
	@Test(priority = 5)
	@Parameters({"SubsUserWithActiveRentalPlan","CommomPassword" })	//---Need to pass Susbcribeduser credentials which has 1-year Premium+Radhe Active plan
	public void GuestUserLogsinAsSubsUserWithRentalActivePlan(String pEmailId,String pPassword) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", "Guest");
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin("Guest");
		ZEE5ApplicasterBusinessLogic.VerifyRentalPlanAsSubscribedUser(pEmailId, pPassword);
	}
	
	@Test(priority = 6)
	@Parameters({"NonSubsUserWithActiveRentalPlan","CommomPassword" })	//---Need to pass Non-Susbcribeduser credentials which has only Radhe rental Active plan activated
	public void GuestUserLogsinAsNonSubsUserWithRentalActivePlan(String pEmailId,String pPassword) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", "Guest");
		ZEE5ApplicasterBusinessLogic.navigateToHomeScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin("Guest");
		ZEE5ApplicasterBusinessLogic.VerifyRentalPlanAsNonSubscribedUser(pEmailId, pPassword);
	}
	
	@Test(priority = 7)
	@Parameters({ "userType","SubsUserWithActiveRentalPlan","CommomPassword","Radhe"}) //---Need to pass Susbcribeduser credentials which has 1-year Premium+Radhe Active plan
	public void UseCase3a(String userType,String pEmailId, String pPassword, String pContentTitle) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToHomeScreen();
		ZEE5ApplicasterBusinessLogic.LoginWithEmailID(pEmailId, pPassword);
		ZEE5ApplicasterBusinessLogic.SearchZEEPLEXContentAndPlay(pContentTitle);
		ZEE5ApplicasterBusinessLogic.ZeePlexContentInPlayerCTAValidation();
	}
	
	@Test(priority = 8)//Sushma - Logged in subscribed user with any non-premium plans lower or equal in value to the Combo offer price of 499/- without Radhe rental 
	@Parameters({ "userType", "RSVOD49PackEmail", "RSVOD499PackEmail", "CommomPassword", "tabName1", "Radhe"})
	public void UseCase2(String userType, String RSVOD49PackEmail, String RSVOD499PackEmail, String pPassword, String ptabName, String pContentTitle) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToLoginScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.LoginWithEmailID(RSVOD49PackEmail, pPassword);
		ZEE5ApplicasterBusinessLogic.RSVODUser_49(ptabName, pContentTitle);
		
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToLoginScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.LoginWithEmailID(RSVOD499PackEmail, pPassword);
		ZEE5ApplicasterBusinessLogic.RSVODUser_499(ptabName, pContentTitle);
	}
	
	@Test(priority = 9)//Sushma - Guest user -->>Login as already subscribeduser with premium plans lower in value than the combo offer price of 499/- without radhe rental
	@Parameters({ "userType","99PremiumPackEmail", "299PremiumPackEmail", "CommomPassword", "tabName1", "Radhe"}) 
	public void UseCase6(String userType, String PremiumPackEmail99, String PremiumPackEmail299, String pPassword, String ptabName, String pContentTitle) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
		ZEE5ApplicasterBusinessLogic.Guest_premiumUser_99(ptabName, pContentTitle, PremiumPackEmail99, pPassword);
		
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
		ZEE5ApplicasterBusinessLogic.Guest_premiumUser_299(ptabName, pContentTitle, PremiumPackEmail299, pPassword);
	}
	
	@Test(priority = 10)//Sushma - Guest user -->>Login as already subscribeduser with active premium plan(1 year or 6 months plan users) without radhe rental
	@Parameters({ "userType","SubscribedUserName", "CommomPassword", "tabName1", "Radhe"}) 
	public void UseCase6b(String userType, String SubscribedUserName, String pPassword, String ptabName, String pContentTitle) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
		ZEE5ApplicasterBusinessLogic.Guest_premiumUser_499(ptabName, pContentTitle, SubscribedUserName, pPassword);
	}
	
	
	@Test(priority = 11)//Sushma -  Guest user -->>Login as already subscribeduser with any non-premium plans without radhe rental
	@Parameters({ "userType","RSVOD49PackEmail", "RSVOD499PackEmail", "CommomPassword", "tabName1", "Radhe"}) 
	public void UseCase7(String userType, String RSVOD49PackEmail, String RSVOD499PackEmail, String pPassword, String ptabName, String pContentTitle) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
		ZEE5ApplicasterBusinessLogic.Guest_RSVODUser_49(ptabName, pContentTitle, RSVOD49PackEmail, pPassword);
		
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
		ZEE5ApplicasterBusinessLogic.Guest_RSVODUser_499(ptabName, pContentTitle, RSVOD499PackEmail, pPassword);
	}
	
	@Test(priority = 12)
	@Parameters({ "userType","SubsUserWithoutRentalPlan","CommomPassword","RentalContentName3"}) //---Need to pass Susbcribeduser credentials which has 1-year Premium plan without Rental Active plan
	public void UseCase3b(String userType,String pEmailId, String pPassword, String pContentTitle) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToHomeScreen();
		ZEE5ApplicasterBusinessLogic.LoginWithEmailID(pEmailId, pPassword);
		ZEE5ApplicasterBusinessLogic.SearchZEEPLEXContentAndPlay(pContentTitle);
		ZEE5ApplicasterBusinessLogic.ZeePlexContentInPlayerCTAValidation();
	}
	
	@AfterTest
	public void tearDownApp() {
		System.out.println("\nQuit the App\n");
		ZEE5ApplicasterBusinessLogic.tearDown();
	}
	
}

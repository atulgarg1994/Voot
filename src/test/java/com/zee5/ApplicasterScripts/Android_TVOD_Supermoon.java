package com.zee5.ApplicasterScripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.business.zee.Zee5ApplicasterBusinessLogic;
import com.utility.Utilities;

public class Android_TVOD_Supermoon {
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
     	ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
	}
	
	@Test(priority = 1)// Logged in subscribed user with premium plans lower in value than the Combo offer price of 499/- without Supermoon rental
	@Parameters({ "userType","99PremiumPackEmail", "99PremiumPackPwd", "tabName1", "RentalContentName1"})
	public void LoginAs99PremiumUserWithoutRentalPlanToValidateComboOfferScreen(String userType, String PremiumPackEmail99, String PremiumPackPwd99, String ptabName, String pContentTitle) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.LoginWithEmailID(PremiumPackEmail99, PremiumPackPwd99);
		ZEE5ApplicasterBusinessLogic.premiumUser_99(ptabName, pContentTitle);
	}
	
	@Test(priority = 2) //Logged in subscribed user with premium plans lower in value than the Combo offer price of 499/- without Supermoon rental
	@Parameters({ "userType","299PremiumPackEmail", "CommomPassword", "tabName1", "RentalContentName1"})
	public void LoginAs299PremiumUserWithoutRentalPlanToValidateComboOfferScreen(String userType,String PremiumPackEmail299, String pPassword, String ptabName, String pContentTitle) throws Exception {		
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.LoginWithEmailID(PremiumPackEmail299, pPassword);
		ZEE5ApplicasterBusinessLogic.premiumUser_299(ptabName, pContentTitle);		
	}
	
	@Test(priority = 3)//Logged in subscribed user with any non-premium plans (49) lower or equal in value to the Combo offer price of 499/- without Supermoon rental 
	@Parameters({ "userType", "RSVOD49PackEmail", "RSVOD49PackPwd", "tabName1", "RentalContentName1"})
	public void LoginAsNonPremiumRSVOD49WithoutRentalPlanToValidateComboOfferScreen(String userType, String RSVOD49PackEmail, String RSVOD49PackPwd, String ptabName, String pContentTitle) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.LoginWithEmailID(RSVOD49PackEmail, RSVOD49PackPwd);
		ZEE5ApplicasterBusinessLogic.RSVODUser_49(ptabName, pContentTitle);
	}
	
	@Test(priority = 4)//Logged in subscribed user with any non-premium plans (499) lower or equal in value to the Combo offer price of 499/- without Supermoon rental 
	@Parameters({ "userType", "RSVOD499PackEmail", "CommomPassword", "tabName1", "RentalContentName1"})
	public void LoginAsNonPremiumRSVOD499WithoutRentalPlanToValidateComboOfferScreen(String userType, String RSVOD499PackEmail, String pPassword, String ptabName, String pContentTitle) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.LoginWithEmailID(RSVOD499PackEmail, pPassword);
		ZEE5ApplicasterBusinessLogic.RSVODUser_499(ptabName, pContentTitle);
	}
	
	@Test(priority = 5)
	@Parameters({ "userType","NonsubscribedUserName","CommomPassword","tabName1", "RentalContentName1"})
	public void NonSubsribedWithoutRentalPlan(String userType, String pEmailId, String pPassword, String ptabName, String pContentTitle) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.LoginWithEmailID(pEmailId,pPassword);
        ZEE5ApplicasterBusinessLogic.NonSubscribed_withoutSupermoon(ptabName,pContentTitle); 
    }
		
	@Test(priority = 6)//Guest user -->>Login as already subscribeduser with premium plans lower in value than the combo offer price of 99/- without Supermoon rental
	@Parameters({ "userType","99PremiumPackEmail", "99PremiumPackPwd", "tabName1", "RentalContentName1"}) 
	public void GuestUserFromComboPageLoginWithPremium99ToValidateUpgradeBottomsheetUC6(String userType, String PremiumPackEmail99, String PremiumPackPwd99, String ptabName, String pContentTitle) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
		ZEE5ApplicasterBusinessLogic.Guest_premiumUser_99(ptabName, pContentTitle, PremiumPackEmail99, PremiumPackPwd99);
	}
	
	@Test(priority = 7)//Guest user -->>Login as already subscribeduser with premium plans lower in value than the combo offer price of 499/- without Supermoon rental
	@Parameters({ "userType","299PremiumPackEmail", "CommomPassword", "tabName1", "RentalContentName1"}) 
	public void GuestUserFromComboPageLoginWithPremium299ToValidateUpgradeBottomsheetUC6(String userType, String PremiumPackEmail299, String pPassword, String ptabName, String pContentTitle) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
		ZEE5ApplicasterBusinessLogic.Guest_premiumUser_299(ptabName, pContentTitle, PremiumPackEmail299, pPassword);
	}
	
	@Test(priority = 8)//Guest user -->>Login as already subscribeduser with active premium plan(1 year or 6 months plan users) without Supermoon rental
	@Parameters({ "userType","SubscribedUserName", "SubscribedPassword", "tabName1", "RentalContentName1"}) 
	public void GuestUserFromComboPageLoginWithPremium499UserUC6b(String userType, String PremiumPackEmail499, String pPassword, String ptabName, String pContentTitle) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
		ZEE5ApplicasterBusinessLogic.Guest_premiumUser_499(ptabName, pContentTitle, PremiumPackEmail499, pPassword);
	}
	
	@Test(priority = 9)// Guest user -->>Login as already subscribeduser with any non-premium plans without Supermoon rental
	@Parameters({ "userType","RSVOD49PackEmail", "RSVOD49PackPwd", "tabName1", "RentalContentName1"}) 
	public void  GuestUserFromComboPageLoginAsNonPremiumRSVOD49ToValidateUpgradeBottomsheetUC7(String userType, String RSVOD49PackEmail, String RSVOD49PackPwd, String ptabName, String pContentTitle) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
		ZEE5ApplicasterBusinessLogic.Guest_RSVODUser_49(ptabName, pContentTitle, RSVOD49PackEmail, RSVOD49PackPwd);
	}
	
	@Test(priority = 10)//Guest user -->>Login as already subscribeduser with any non-premium plans without Supermoon rental
	@Parameters({ "userType", "RSVOD499PackEmail", "CommomPassword", "tabName1", "RentalContentName1"}) 
	public void  GuestUserFromComboPageLoginAsNonPremiumRSVOD499ToValidateUpgradeBottomsheetUC7(String userType, String RSVOD499PackEmail, String pPassword, String ptabName, String pContentTitle) throws Exception {		
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
		ZEE5ApplicasterBusinessLogic.Guest_RSVODUser_499(ptabName, pContentTitle, RSVOD499PackEmail, pPassword);
	}	

	@Test(priority = 11)
	@Parameters({"NonSubsUserWithActiveRentalPlan","NonSubsUserWithActiveRentalPlanPwd","RentalContentName3"})	//---Need to pass Non-Susbcribeduser credentials which has only Supermoon rental Active plan activated
	public void GuestUserLogsinAsNonSubsUserWithRentalActivePlan(String pEmailId,String pPassword,String pContent) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", "Guest");
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.VerifyRentalPlanAsNonSubscribedUser(pEmailId, pPassword,pContent);
	}
		
	@Test(priority = 12)//Guest user -->>Login as already subscribeduser with premium plans lower in value than the combo offer price of 99/- with Active Supermoon rental
	@Parameters({ "userType","99PremiumPackEmailWithActiveSupermoon", "99PremiumPackEmailPasswordWithActiveSupermoon", "RentalContentName1","tabName1"}) 
	public void GuestUserFromComboPageLoginWithPremium99withActiveSupermoon(String userType, String PremiumPackEmail99, String PremiumPackPwd99,String pContentTitle, String ptabName) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.Guest_premiumUser_99_WithActiveSupermoon(PremiumPackEmail99,PremiumPackPwd99, pContentTitle,ptabName);
	}
	
	@Test(priority = 13)//Guest user -->>Login as already subscribeduser with premium plans lower in value than the combo offer price of 299/- with Active Supermoon rental
	@Parameters({ "userType","299PremiumPackEmailWithActiveSupermoon", "299PremiumPackEmailPasswordWithActiveSupermoon", "RentalContentName1","tabName1"}) 
	public void GuestUserFromComboPageLoginWithPremium299withActiveSupermoon(String userType, String PremiumPackEmail99, String PremiumPackPwd99,String pContentTitle, String ptabName) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.Guest_premiumUser_299_WithActiveSupermoon(PremiumPackEmail99,PremiumPackPwd99, pContentTitle,ptabName);
	}
	
	@Test(priority = 14)//Guest user -->>Login as already subscribeduser with RSVOD 49 with Active Supermoon rental
	@Parameters({ "userType","RSVOD49PackEmailWithActiveSupermoon", "RSVOD49PackEmailPasswordWithActiveSupermoon", "RentalContentName1","tabName1"}) 
	public void GuestUserFromComboPageLoginWithRSVOD49withActiveSupermoon(String userType, String PremiumPackEmail99, String PremiumPackPwd99,String pContentTitle, String ptabName) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.Guest_premiumUser_RSVOD49_WithActiveSupermoon(PremiumPackEmail99,PremiumPackPwd99, pContentTitle,ptabName);
	}
	
	//@Test(priority = 15)//Guest user -->>Login as already subscribeduser with RSVOD 499 with Active Supermoon rental
	@Parameters({ "userType","RSVOD499PackEmailWithActiveSupermoon", "RSVOD499PackEmailPasswordWithActiveSupermoon", "RentalContentName1","tabName1"}) 
	public void GuestUserFromComboPageLoginWithRSVOD499withActiveSupermoon(String userType, String PremiumPackEmail99, String PremiumPackPwd99,String pContentTitle, String ptabName) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.Guest_premiumUser_RSVOD499_WithActiveSupermoon(PremiumPackEmail99,PremiumPackPwd99, pContentTitle,ptabName);
	}
	
	@Test(priority = 16)//Guest user -->>Login as already subscribeduser with premium plans of 499/- with Active Supermoon rental
	@Parameters({ "SubsUserWithActiveRentalPlan","SubsUserWithActiveRentalPlanPwd","RentalContentName3","tabName1"}) 
	public void GuestUserFromComboPageLoginWithPremium499withActiveSupermoon(String pEmailId,String pPassword,String pContent,String ptabName) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", "Guest");
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.VerifyRentalPlanAsSubscribedUser(pEmailId, pPassword,pContent,ptabName);
	}
	
	@Test(priority = 17)//Only Guest user 
	@Parameters({ "userType", "RentalContentName1"})
	public void Guest_SearchZeePlexConsumptionPage(String userType, String contentTitle) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow","Guest");
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();;
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
		ZEE5ApplicasterBusinessLogic.Guest_SearchEntryPoint_ZeePlexConsumptionPage(userType, contentTitle);
	}
	
	@Test(priority = 18)//All usertypes
	@Parameters({ "userType", "tabName1"})
	public void ThumbhnailEntryPoint_ZeeplexConsumptionPage(String userType, String tabName) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
		ZEE5ApplicasterBusinessLogic.ThumbhnailEntryPoint_ZeeplexConsumptionPage(userType, tabName);
	}
	
	@Test(priority = 19)
	@Parameters({ "userType", "NonSubsUserWithActiveRentalPlan", "NonSubsUserWithActiveRentalPlanPwd", "RentalContentName1","RentalContentName2"})
	public void NonSub_WatchlistEntryPoint_ZeeplexConsumptionPage(String userType, String nonSubEmail, String nonSubPwd, String contentTitle,String contentTitle2) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.LoginWithEmailID(nonSubEmail, nonSubPwd);
		ZEE5ApplicasterBusinessLogic.SearchZEEPLEXContentAndPlay(contentTitle);
		ZEE5ApplicasterBusinessLogic.WatchListForLiveVOD();
		ZEE5ApplicasterBusinessLogic.SearchZEEPLEXContentAndPlay(contentTitle2);
		ZEE5ApplicasterBusinessLogic.AddtoWatchList();
		ZEE5ApplicasterBusinessLogic.WatchlistEntryPoint(userType, contentTitle);
	}
	
	@Test(priority = 20)
	@Parameters({ "userType", "SubsUserWithActiveRentalPlan","SubsUserWithActiveRentalPlanPwd", "RentalContentName1" ,"RentalContentName2"})
	public void Sub_WatchlistEntryPoint_ZeeplexConsumptionPage(String userType, String subEmail, String pwd, String contentTitle , String contentTitle2) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.LoginWithEmailID(subEmail, pwd);
		ZEE5ApplicasterBusinessLogic.SearchZEEPLEXContentAndPlay(contentTitle);
		ZEE5ApplicasterBusinessLogic.WatchListForLiveVOD();
		ZEE5ApplicasterBusinessLogic.SearchZEEPLEXContentAndPlay(contentTitle2);
		ZEE5ApplicasterBusinessLogic.AddtoWatchList();
		ZEE5ApplicasterBusinessLogic.WatchlistEntryPoint(userType, contentTitle);
	}
	
	@Test(priority = 21)
	@Parameters({ "SubsUserWithActiveRentalPlan","SubsUserWithActiveRentalPlanPwd"}) 
	public void MyTransactions(String email, String pswd) throws Exception {		
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow","Guest");
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.LoginWithEmailID(email, pswd);
		ZEE5ApplicasterBusinessLogic.VerifyMyTransactionForPLEXPlan();
	}
	
	@Test(priority = 22)
	@Parameters({"SettingsNonsubscribedUserName","SettingsNonsubscribedPassword", "RentalContentName3"})	
	public void ParentalControlValidationForTVOD_WithoutSupermoonActive(String pEmailId,String pPassword,String pContent) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", "Guest");
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.LoginWithEmailID(pEmailId, pPassword);	
		ZEE5ApplicasterBusinessLogic.ParentalControlValidationOnClickingTrailer(pEmailId, pPassword,pContent);		
	}
	
	@Test(priority = 23)
	@Parameters({"NonSubsUserWithActiveRentalPlan","NonSubsUserWithActiveRentalPlanPwd","RentalContentName3"})	
	public void ParentalControlValidationForTVOD_WithActiveSupermoon(String EmailId, String Password,String pContent) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow","Guest");
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.LoginWithEmailID(EmailId, Password);
		ZEE5ApplicasterBusinessLogic.playerControlValidationOnclickingWatchNowCTA(EmailId, Password,pContent);
	}
	
	@Test(priority = 24)
	@Parameters({ "NonSubsUserWithActiveRentalPlan","NonSubsUserWithActiveRentalPlanPwd"}) 
	public void MyRentalsForContentYetToWatch(String email, String pswd) throws Exception {		
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow","Guest");
		ZEE5ApplicasterBusinessLogic.LoginWithEmailID(email, pswd);
		ZEE5ApplicasterBusinessLogic.MyRentalsScreenVerification();
		ZEE5ApplicasterBusinessLogic.PLEXContentYetToWatch();
		
	}
	
	@Test(priority = 25)//Guest user
	@Parameters({ "userType","RentalContentName3"}) 
	public void GuestUserVideoConsumptionPage(String userType,String pContentName) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
		ZEE5ApplicasterBusinessLogic.Guest_VideoConsumptionPageForPLEXContent(pContentName);
	}

	
	
	
	
}

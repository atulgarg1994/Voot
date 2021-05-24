package com.zee5.ApplicasterScripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5ApplicasterBusinessLogic;
import com.utility.Utilities;

public class Android_ComboOffer {

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
		ZEE5ApplicasterBusinessLogic.navigateToHomeScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
	}
	
	@Test(priority = 1)
	@Parameters({"NonsubscribedUserName","NonsubscribedPassword","NonSubsUserWithActiveRentalPlan","NonSubsUserWithActiveRentalPlanPwd","RentalContentName3"})	
	public void ParentalControlValidationForTVOD(String pEmailId,String pPassword,String EmailId, String Password,String pContent) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", "Guest");
		ZEE5ApplicasterBusinessLogic.navigateToHomeScreen();
		ZEE5ApplicasterBusinessLogic.LoginWithEmailID(pEmailId, pPassword);
		ZEE5ApplicasterBusinessLogic.ParentalControlValidationOnClickingTrailer(pEmailId, pPassword,pContent);
		
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow","Guest");
		ZEE5ApplicasterBusinessLogic.navigateToHomeScreen();
		ZEE5ApplicasterBusinessLogic.LoginWithEmailID(EmailId, Password);
		ZEE5ApplicasterBusinessLogic.playerControlValidationOnclickingWatchNowCTA(EmailId, Password,pContent);
	}
	
	@Test(priority = 2)
	@Parameters({"userType","ExpiredRadheRentalEmail","ExpiredRadheRentalPassword","RentalContentName3"}) //Need to pass TVOD expired credentials
	public void SearchValidationForTVOD(String userType,String email,String pswd,String ContentTitle) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", "Guest");
		ZEE5ApplicasterBusinessLogic.navigateToHomeScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
		ZEE5ApplicasterBusinessLogic.SearchForTVODContent(ContentTitle);
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow","Guest");
		ZEE5ApplicasterBusinessLogic.navigateToHomeScreen();
		ZEE5ApplicasterBusinessLogic.LoginWithEmailID(email, pswd);
		ZEE5ApplicasterBusinessLogic.SearchForExpiredTVODContent(email, pswd, ContentTitle);
	}
	
	@Test(priority = 3)
	@Parameters({ "userType","RentalContentName3"}) 
	public void HaveACodeValidationForTVOD(String userType,String contentTitle) throws Exception {		
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow","Guest");
		ZEE5ApplicasterBusinessLogic.navigateToHomeScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
		ZEE5ApplicasterBusinessLogic.HaveACodeValidationTVOD(userType,contentTitle);
	}

	
	@Test(priority = 4)
	@Parameters({ "userType", "RentalContentName1"})
	public void Guest_SearchZeePlexConsumptionPage(String userType, String contentTitle) throws Exception {
		ZEE5ApplicasterBusinessLogic.Guest_SearchEntryPoint_ZeePlexConsumptionPage(userType, contentTitle);
	}
	
	@Test(priority = 5)
	@Parameters({ "userType", "tabName1"})
	public void ThumbhnailEntryPoint_ZeeplexConsumptionPage(String userType, String tabName) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToHomeScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
		ZEE5ApplicasterBusinessLogic.ThumbhnailEntryPoint_ZeeplexConsumptionPage(userType, tabName);
	}
	
	@AfterTest
	public void tearDownApp() {
		System.out.println("\nExecution Complete - Closing the App");
		ZEE5ApplicasterBusinessLogic.tearDown();
	}
	
}

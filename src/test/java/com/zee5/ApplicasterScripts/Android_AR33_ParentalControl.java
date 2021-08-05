package com.zee5.ApplicasterScripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5ApplicasterBusinessLogic;
import com.utility.Utilities;

public class Android_AR33_ParentalControl {

	private Zee5ApplicasterBusinessLogic ZEE5ApplicasterBusinessLogic;

	@BeforeTest
	public void AppLaunch() throws InterruptedException {
		System.out.println("Launching Android App");
		Utilities.relaunch = true; // Clear App Data on First Launch
		ZEE5ApplicasterBusinessLogic = new Zee5ApplicasterBusinessLogic("zee");
	}
	
	@Test(priority = 0)
	@Parameters({ "userType" })
	public void ApplicasterLogin(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
	}
	
	@Test(priority = 1)  //Kartheek
	@Parameters({ "userType" })		
	public void parentalControlValidation(String userType) throws Exception {
		
		ZEE5ApplicasterBusinessLogic.parentalControlValidation(userType);		
	}
	
	@Test(priority = 2) //Veena
	@Parameters({ "userType" })
	public void ParentalControl18Plus(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
		ZEE5ApplicasterBusinessLogic.ParentalControl18Plus(userType);//TC_15
	}
	
	//@Test(priority = 3) //Veena
	@Parameters({ "userType" })
	public void ParentalControl16Plus(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.ParentalControl16Plus(userType);//TC_16
	}
	
	//@Test(priority = 4)//Veena
	@Parameters({ "userType" })
	public void ParentalControl7Plus(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.ParentalControl7Plus(userType);//TC_18
	}
	
	@Test(priority = 5) //Veena
	@Parameters({ "userType" })
	public void ParentalControl13Plus(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.ParentalControl13Plus(userType);//TC_17
	}
	@Test(priority = 6) //Veena
	@Parameters({ "userType" })
	public void ParentalControlRestrictAll(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.ParentalControlRestrictAll(userType);//TC_19
	}
	
	
	@Test(priority = 7)//Veena
	@Parameters({ "userType" })
	public void ParentalPinValidation(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
		ZEE5ApplicasterBusinessLogic.ParentalPinValidation(userType);//TC_35,36
	}
	
	@Test(priority = 8)//Veena
	@Parameters({ "userType" })
	public void NewAge_U_RatingValidationBelowPlayer(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.NewAgeRatingValidationBelowPlayer(userType);//TC_30
	}
	
	@Test(priority = 13) //Veena
	@Parameters({ "userType" })
	public void VerifyContentPlayPostSettingParentalControl(String userType) throws Exception {
		//ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.VerifyContentPlayPostSettingParentalControl(userType);//TC_42
	}
	
	
	@Test(priority = 14) //Veena
	@Parameters({ "userType" })
	public void VerifyContentPlayContentPostSettingParentalControl(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.VerifyContentPlayContentPostSettingParentalControl(userType);//TC_43,44


	}
	
	@Test(priority = 15) //Veena
	@Parameters({ "userType" })
	public void VerifyContentErrorMessagePostSettingParentalControl(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.VerifyContentErrorMessagePostSettingParentalControl(userType);//TC45
	}
	
	
	
	@Test(priority = 16) //Veena
	@Parameters({ "userType" })
	public void VerifyLiveTVContentPostSettingParentalControl(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.VerifyLiveTVContentPostSettingParentalControl(userType);//TC_46


	}	
	
	@Test(priority = 17) //Veena
	@Parameters({ "userType" })
	public void VerifyParentalPinResetPin(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.VerifyParentalPinResetPin(userType);//TC_68
	}
	
	
	@Test(priority = 18) //Veena
	@Parameters({ "userType" })
	public void VerifyParentalPinJourneyviaDeeplink(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.VerifyParentalPinJourneyPostviaDeeplink(userType);//_48
}
	
		
	@Test(priority = 19) //Veena
	@Parameters({ "userType" })
	public void ParentalControlPlatformValidation(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.ParentalPinPlatformValidation(userType);//TC_38
}


	
	@AfterTest
	public void tearDownApp() {
		System.out.println("Quit the App");
		ZEE5ApplicasterBusinessLogic.tearDown();
	}
	
}

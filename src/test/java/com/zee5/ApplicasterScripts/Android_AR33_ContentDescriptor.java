package com.zee5.ApplicasterScripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.business.zee.Zee5ApplicasterBusinessLogic;
import com.utility.Utilities;

public class Android_AR33_ContentDescriptor {
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
	
	@Test(priority = 1)  //Bhavana
	@Parameters({ "userType" })		
	public void ContentDescriptorForDifferentContent(String userType) throws Exception {	
		ZEE5ApplicasterBusinessLogic.ContentDescriptionValidation(userType,"14 Phere","Movie");
		ZEE5ApplicasterBusinessLogic.ContentDescriptionValidation(userType,"Bebaakee","Video");		
	}
	
	@Test(priority = 2)  //Bhavana
	@Parameters({ "userType" })		
	public void VerifyContentDescriptorForNewsandLiveContent(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.ContentDescriptorForNewsAndLiveContent(userType);		
	}
	
	@Test(priority = 3)  //Bhavana
	@Parameters({ "userType" })		
	public void VerifyContentDescriptorForAds(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.VerifyContentDescriptorForAds(userType,"Shivajinagara");		
	}
	
	@Test(priority = 4)  //Bhavana
	@Parameters({ "userType" })		
	public void VerifyContentDescriptorAfterAdFinishes(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.VerifyContentDescriptorAfterAdFinishes(userType,"Rekke");		
	}
	
	@Test(priority = 5)  //Bhavana
	@Parameters({ "userType" })		
	public void VerifyContentDescriptor_DownloadedContent_WithandWithout_DataEnabled(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
		ZEE5ApplicasterBusinessLogic.ContentDescriptorForDownloadedContent(userType);
		ZEE5ApplicasterBusinessLogic.ContentDescriptorForDownloadedContentInOffline(userType);
	}
	
	@Test(priority = 6)  //Bhavana
	@Parameters({ "userType" })		
	public void VerifyAgeRATED_If_CD_is_Empty(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.VerifyAgeRatedIfCDisEmpty(userType);
	}	
	
	@Test(priority = 7)  //Bhavana
	@Parameters({ "userType" })		
	public void VerifyAgeRating_OnPlayerAndBelowPlayer(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.verifyAgeRating_OnPlayer_And_BelowPlayer(userType,"14 Phere");
	}
	
	@Test(priority = 8)  //Bhavana
	@Parameters({ "userType" })		
	public void VerifyContentDescriptor_AfterEntering_ParentalPIN(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.VerifyContentDescriptor_AfterEntering_ParentalPIN(userType,"Dial 100");
	}
	
}

package com.VootTvScripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TvVootScripts {

	
	private com.business.voot.VootTvBusinessLogic VootTvBusiness;

	@BeforeTest
	public void Before() throws InterruptedException {
		// Utilities.relaunch = true;
		VootTvBusiness = new com.business.voot.VootTvBusinessLogic("vootTV");
	}
	
//	@Test(priority = 1)
	@Parameters({ "userType" })
	public void Demo(String userType) throws Exception {
		VootTvBusiness.demo(userType);
	}
	
	//==================================ATUL==================================
    
	  @Test
	  public void verifySportsPage() throws Exception
	  {
//		  VootTvBusiness.validateSportsPageOnVoot();
		  VootTvBusiness.navigateToLoginPage();
//	      System.out.println("Sports Page Validation is Done");
	      System.out.println("Login Page Validation is Done");
	      Thread.sleep(6000);
	  }
	
	
	
	
	
	
//	@AfterTest
	public void After() {
		System.out.println("Tear Down");
		// System.out.println(Zee5TvBusiness.performaceDetails);
		VootTvBusiness.TvtearDown();
	}

}

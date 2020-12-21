package com.zee5.DFP;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5ApplicasterBusinessLogic;
import com.utility.Utilities;

public class AMDDFPTestScript {

	private Zee5ApplicasterBusinessLogic zee5ApplicasterBusinessLogic;

	@BeforeTest
	public void init() throws Exception {
		CharlesConfigure.openCharles();
		Utilities.relaunch = true;
		zee5ApplicasterBusinessLogic = new Zee5ApplicasterBusinessLogic("zee");
	}

	@Test(priority = 1)
	@Parameters({ "userType" })
	public void AMDLogin(String userType) throws Exception {
		System.out.println("\nLogin to App");
		zee5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		zee5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		zee5ApplicasterBusinessLogic.Zee5AppLoginDFP(userType);	
	}
	
	@Test(priority = 2)
	@Parameters({ "userType", "keyword2" })
	public void DFPValidation(String userType, String pSearch) throws Exception {
		System.out.println("\nAndroid DFP Validation");
		zee5ApplicasterBusinessLogic.AMDDFPValidation(userType, pSearch);
	}
	
	@AfterTest
	public void tearDownApp() {
		System.out.println("\nExecution Complete - Quiting the App");
		zee5ApplicasterBusinessLogic.tearDown();
		CharlesConfigure.saveCharles("DFPContentlog_");
		PubAds.main(null);
	}
}

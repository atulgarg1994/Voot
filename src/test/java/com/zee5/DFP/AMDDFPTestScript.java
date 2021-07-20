package com.zee5.DFP;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

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
	public void ValidationOfDifferentTypeAds(String userType) throws Exception {
		System.out.println("\n Ads validation");
		zee5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		zee5ApplicasterBusinessLogic.SelectYourCountryAndLanguage();
		zee5ApplicasterBusinessLogic.Zee5AppLoginDFP(userType);	
		zee5ApplicasterBusinessLogic.ValidateNativeAds(userType);
		zee5ApplicasterBusinessLogic.ValidateMastheadAds(userType);
		zee5ApplicasterBusinessLogic.ValidateCompanionAds(userType);
	}
	
	
	@Test(priority = 2)
	@Parameters({ "userType", "keyword2" })
	public void DFPValidation(String userType, String pSearch) throws Exception {
		System.out.println("\nAndroid DFP Validation");
		zee5ApplicasterBusinessLogic.relaunch(true);
		zee5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		zee5ApplicasterBusinessLogic.SelectYourCountryAndLanguage();
		zee5ApplicasterBusinessLogic.Zee5AppLoginDFP(userType);	
		zee5ApplicasterBusinessLogic.AMDDFPValidation(userType, pSearch);
	}
	
	
	@Test(priority = 3)
	@Parameters({ "userType", "keyword2" })
	public void CharlesValidation(String userType, String pSearch) throws Exception {
		System.out.println("\nAndroid DFP Validation");
		zee5ApplicasterBusinessLogic.relaunch(true);
		//CharlesConfigure.clearCharlesLog();
		zee5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		zee5ApplicasterBusinessLogic.SelectYourCountryAndLanguage();
		zee5ApplicasterBusinessLogic.Zee5AppLoginDFP(userType);	
		zee5ApplicasterBusinessLogic.AMDCharlesValidation(userType, pSearch);
		if(!userType.equalsIgnoreCase("SubscribedUser")){
			CharlesConfigure.saveCharles("DFPContentlog3_");
			ParseCharlesLogs.readDocumnet();
		}
	}
	
	@AfterTest
	public void tearDownApp() throws ParserConfigurationException, SAXException, IOException, InterruptedException {
		System.out.println("\nExecution Complete - Quiting the App");
		zee5ApplicasterBusinessLogic.tearDown();
	}
}

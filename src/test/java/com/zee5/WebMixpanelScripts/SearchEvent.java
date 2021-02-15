package com.zee5.WebMixpanelScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5PWAWEBMixPanelBusinessLogic;

public class SearchEvent {

	private Zee5PWAWEBMixPanelBusinessLogic Zee5PWAWEBMixPanelBusinessLogic;

	@BeforeTest
	public void init() throws Exception {
		Zee5PWAWEBMixPanelBusinessLogic = new Zee5PWAWEBMixPanelBusinessLogic("Chrome");
	}

	@Test(priority = 1)
	public void verifySearchButtonClickEvent() throws Exception {
		System.out.println("Verify Search Button Click Event");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifySearchButtonClickEvent();
	}

	@Test(priority = 2)
	@Parameters({ "keyword" })
	public void verifySearchResultClickedEvent(String keyword) throws Exception {
		System.out.println("Verify Search Result Clicked Event");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifySearchResultClickedEvent(keyword);
	}

	@Test(priority = 3)
	public void verifySearchExecutedEvent() throws Exception {
		System.out.println("Verify Search Executed Event");
		Zee5PWAWEBMixPanelBusinessLogic.relaunch();
		Zee5PWAWEBMixPanelBusinessLogic.verifySearchExecutedEvent();
	}

	@AfterClass
	public void tearDown() {
		Zee5PWAWEBMixPanelBusinessLogic.tearDown();
	}
}

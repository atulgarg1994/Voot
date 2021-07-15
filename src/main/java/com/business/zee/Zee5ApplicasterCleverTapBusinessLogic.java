package com.business.zee;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.CleverTap.CleverTapDashboardData;
import com.driverInstance.CommandBase;
import com.extent.ExtentReporter;
import com.propertyfilereader.PropertyFileReader;
import com.utility.LoggingUtils;
import com.utility.Utilities;
import com.zee5.ApplicasterPages.AMDCleverTapPage;
import com.zee5.ApplicasterPages.AMDConsumptionScreen;
import com.zee5.ApplicasterPages.AMDHomePage;
import com.zee5.ApplicasterPages.AMDMoreMenu;
import com.zee5.ApplicasterPages.AMDMySubscriptionPage;
import com.zee5.ApplicasterPages.AMDSearchScreen;
import com.zee5.ApplicasterPages.AMDWatchlistPage;
import com.zee5.CleverTapScripts.AMDCelverTapScript;
import com.zee5.PWAPages.CleverTapPage;
import com.zee5.PWAPages.PWASubscriptionPages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;

public class Zee5ApplicasterCleverTapBusinessLogic extends Utilities{

	
	public Zee5ApplicasterCleverTapBusinessLogic(String Application) {
		new CommandBase(Application);
		init();
	}

	private int timeout;

	/** Retry Count */
	private int retryCount;
	ExtentReporter extent = new ExtentReporter();

	/** The Constant logger. */
	static LoggingUtils logger = new LoggingUtils();

	/** The Android driver. */
	public AndroidDriver<AndroidElement> androidDriver;

	/** The Android driver. */
	public IOSDriver<WebElement> iOSDriver;

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public int getRetryCount() {
		return retryCount;
	}

	public void setRetryCount(int retryCount) {
		this.retryCount = retryCount;
	}

	public void init() {

		PropertyFileReader handler = new PropertyFileReader("properties/Execution.properties");
		setTimeout(Integer.parseInt(handler.getproperty("TIMEOUT")));
		setRetryCount(Integer.parseInt(handler.getproperty("RETRY_COUNT")));
	}
	
	public void tearDown() {
		getWebDriver().quit();
	}
	
	public void navigateToCleverTap() throws Exception{
		HeaderChildNode("Navigating to Segment section");
		verifyElementPresentAndClick(CleverTapPage.objSegments, "Segment");
		type(CleverTapPage.objSearchField, "Autoclevertap@g.com", "Search field");
		verifyElementPresentAndClick(CleverTapPage.objFindBtn, "Find button");
		waitTime(20000);
		verifyElementPresentAndClick(CleverTapPage.objActivityBtn, "Activity button");
		
	}
	
	public void loginCleverTap() throws Exception {
		HeaderChildNode("Login Clever tap");
		type(CleverTapPage.objEmailID, "prathap.r@igsindia.net", "email field");
		type(CleverTapPage.objPasswordEditBx, "Qwerty123", "email field");
		verifyElementPresentAndClick(CleverTapPage.objLoginBtn, "Login button");
//		prathap.r@igsindia.net
//		Qwerty123
	}
	
	public void getEventName() {
		HeaderChildNode("Event Name");
		CleverTapDashboardData.creatExcelCleverTap();
		waitTime(10000);
		List<WebElement> event = findElements(CleverTapPage.objEventName);
		System.out.println(event.size());
		for (int i = 0; i < event.size(); i++) {
			if (event.get(i).getText().contains("Subscription Page Viewed")) {
				List<WebElement> eventParameter = findElements(
						By.xpath("(((.//*[@class='new_day'])[1])//td/span[1])["+(i+1)+"]//following-sibling::*[contains(@class,'label-gray')]//span"));
				for (int j = 0; j < eventParameter.size(); j++) {
					String Key = eventParameter.get(j).getAttribute("title");
					String Value = eventParameter.get(j).getText();
					CleverTapDashboardData.InsertEventProperties((j+1), Key, Value);
				}
				break;
			}
		}
	}

	
	public void SubscriptionPageViewed() throws Exception {
		HeaderChildNode("Subscription Page Viewed");
		verifyElementPresentAndClick(AMDCleverTapPage.objCountryScreenConitnueBtn, "Continue button");
		verifyElementPresentAndClick(AMDHomePage.objBuyPlanCTA, "Buy Plan");
	}
	
	public void SubscriptionSelected() throws Exception {
		HeaderChildNode("Subscription Selected");
		verifyElementPresentAndClick(AMDMySubscriptionPage.objSelectPlanCheckBx, "Premium Plan Check Box");
	}
	
	public void SubscriptionCallInitiated() throws Exception {
		HeaderChildNode("Subscription Call Initiated");
		verifyElementPresentAndClick(AMDMySubscriptionPage.objContinueBtnInBuyPremiumNow, "Continue button");
	}
	
	public void SubscriptionCallReturned() throws Exception {
		HeaderChildNode("Subscription Call Returned");
		verifyElementPresentAndClick(AMDMySubscriptionPage.objEnterCardNumberBtn, "Enter Card Number");
		type(AMDMySubscriptionPage.objEnterCCTxt,"4012001037141112", "Card Number");
		type(AMDMySubscriptionPage.objExpiryCCTxt, "0525", "Expiry");
		type(AMDMySubscriptionPage.objCVVTxt, "124", "CVV");
		verifyElementPresentAndClick(AMDMySubscriptionPage.objPayNow, "Pay Now button");
	}
	
	
	public void DisplayLanguageChange() throws Exception {
		HeaderChildNode("Display Language Change");
		verifyElementPresentAndClick(AMDHomePage.objMoreMenuBtn, "More menu");
		verifyElementPresentAndClick(AMDMoreMenu.objSettings, "Settings");
		verifyElementPresentAndClick(AMDMoreMenu.objDisplayLang, "Display Language");
		verifyElementPresentAndClick(AMDMoreMenu.objContinueLangBtn,"Continue");
	}

	public void ContentLanguageChange() throws Exception {
		HeaderChildNode("Content Language Change");
		verifyElementPresentAndClick(AMDHomePage.objMoreMenuBtn, "More menu");
		verifyElementPresentAndClick(AMDMoreMenu.objSettings, "Settings");
		verifyElementPresentAndClick(AMDMoreMenu.objContentLang, "Content Language");
		verifyElementPresentAndClick(AMDMoreMenu.objContinueLangBtn,"Continue");
	}

	public void SearchCancelled() throws Exception {
		HeaderChildNode("Search Cancelled");
		verifyElementPresentAndClick(AMDHomePage.objSearchBtn, "Search");
		verifyElementPresentAndClick(AMDSearchScreen.objBackBtn, "Back button");
	}

	public void AddToWatchlist() throws Exception {
		HeaderChildNode("Add To Watchlist");
		verifyElementPresentAndClick(AMDHomePage.objSearchBtn, "Search");
		type(AMDSearchScreen.objsearchBox,"love u ganesha","search field");
		verifyElementPresentAndClick(AMDSearchScreen.objFisrtSearchContent,"First Content In Search");
		verifyElementPresentAndClick(AMDConsumptionScreen.objWatchlistBtn, "Watchlist button");
	}

	public void Share() {
		HeaderChildNode("Share");
		
	}

	public void RemoveFromWatchlist() throws Exception {
		HeaderChildNode("Remove From Watchlist");
		verifyElementPresentAndClick(AMDHomePage.objMoreMenuBtn, "More menu");
		verifyElementPresentAndClick(AMDMoreMenu.objWatchlist, "Watchlist");
		verifyElementPresentAndClick(AMDWatchlistPage.objEditBtn, "Edit button");
		verifyElementPresentAndClick(AMDWatchlistPage.objSelectCheckBox, "Check box");
		verifyElementPresentAndClick(AMDWatchlistPage.objDeleteAllBtn, "Delete button");
	}

	public void PromoCodeResult() {
		HeaderChildNode("Promo Code Result");
		
	}
	
}

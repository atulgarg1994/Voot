package com.business.zee;

import java.util.List;
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
import com.zee5.ApplicasterPages.AMDLoginScreen;
import com.zee5.ApplicasterPages.AMDMoreMenu;
import com.zee5.ApplicasterPages.AMDMySubscriptionPage;
import com.zee5.ApplicasterPages.AMDSearchScreen;
import com.zee5.ApplicasterPages.AMDWatchlistPage;
import com.zee5.PWAPages.CleverTapPage;
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
		CleverTapTime();
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
		type(CleverTapPage.objEmailID, getParameterFromXML("CTUser"), "email field");
		type(CleverTapPage.objPasswordEditBx, getParameterFromXML("CTPwd"), "email field");
		verifyElementPresentAndClick(CleverTapPage.objLoginBtn, "Login button");
	}
	
	public void getEventName(String EventName) {
		HeaderChildNode("Event Name");
		CleverTapDashboardData.creatExcelCleverTap();
		waitTime(10000);
		List<WebElement> event = findElements(CleverTapPage.objEventName);
		List<WebElement> time = findElements(CleverTapPage.objTime);
		System.out.println(event.size());
		for (int i = 0; i < event.size(); i++) {
			
			if(time.get(i).getText().contains(currentDate)) {
			if (event.get(i).getText().contains(EventName)) {
//				List<WebElement> eventParameter = findElements(
//						By.xpath("(((.//*[@class='new_day'])[1])//td/span[1])["+(i+1)+"]//following-sibling::*[contains(@class,'label-gray')]//span"));
//				for (int j = 0; j < eventParameter.size(); j++) {
//					String Key = eventParameter.get(j).getAttribute("title");
//					String Value = eventParameter.get(j).getText();
//					CleverTapDashboardData.InsertEventProperties((j+1), Key, Value);
//				}
//				break;
				logger.info("Event Reflected in dashboard "+EventName);
				extent.extentLoggerPass("Event", "Event Reflected in dashboard "+EventName);
			}
		  }
		}
	}

	
	public void SubscriptionPageViewed() throws Exception {
		HeaderChildNode("Subscription Page Viewed");
		waitTime(2000);
//		verifyElementPresentAndClick(AMDCleverTapPage.objCountryScreenConitnueBtn, "Continue button");
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
		waitTime(180000);
	}
	
	
	public void DisplayLanguageChange() throws Exception {
		HeaderChildNode("Display Language Change");
		Back(1);
		Back(1);
		verifyElementPresentAndClick(AMDHomePage.objMoreMenuBtn, "More menu");
		verifyElementPresentAndClick(AMDMoreMenu.objSettings, "Settings");
		verifyElementPresentAndClick(AMDMoreMenu.objDisplayLang, "Display Language");
		click(AMDMoreMenu.objContinueLangBtn,"Continue");
	}

	public void ContentLanguageChange() throws Exception {
		HeaderChildNode("Content Language Change");
//		verifyElementPresentAndClick(AMDHomePage.objMoreMenuBtn, "More menu");
//		verifyElementPresentAndClick(AMDMoreMenu.objSettings, "Settings");		
		verifyElementPresentAndClick(AMDMoreMenu.objContentLang, "Content Language");
		click(AMDMoreMenu.objContinueLangBtn,"Continue");
	}

	public void SearchCancelled() throws Exception {
		Back(1);
		waitTime(2000);
		Back(1);
		HeaderChildNode("Search Cancelled");
		verifyElementPresentAndClick(AMDHomePage.objSearchBtn, "Search");
		verifyElementPresentAndClick(AMDSearchScreen.objSearchBackBtn, "Back button");
	}

	public void AddToWatchlist() throws Exception {
		HeaderChildNode("Add To Watchlist");
		waitTime(2000);
		verifyElementPresentAndClick(AMDHomePage.objSearchBtn, "Search");
		waitTime(2000);
		type(AMDSearchScreen.objsearchBox,"love u ganesha","search field");
		waitTime(2000);
		verifyElementPresentAndClick(AMDSearchScreen.objFisrtSearchContent,"First Content In Search");
		verifyElementPresentAndClick(AMDConsumptionScreen.objWatchlistBtn, "Watchlist button");
	}

	public void Share() throws Exception {
		HeaderChildNode("Share");
		extent.HeaderChildNode("Verify Share CTA functionality");
		System.out.println("\nVerify Share CTA functionality");

		click(AMDConsumptionScreen.objShareBtn, "Share button");
		boolean isShareOption = verifyIsElementDisplayed(AMDMoreMenu.objshareOptions);
		if (isShareOption) {
			logger.info("User is navigated share options screen");
			extent.extentLoggerPass("Share through options screen", "User is navigated to share options screen");
			int shareOptions = getDriver().findElements(AMDMoreMenu.objShareOptions).size();
			if (shareOptions == 0) {
				extent.extentLoggerFail("Verify share options", "Share Options are not available");
				logger.info("Share Options are not available");
			} else {
				for (int i = 2; i <= shareOptions; i++) {
					String shareOptionName = getText(AMDMoreMenu.objShareOptions(i));
					logger.info("Share Option : \"" + shareOptionName + "\" is available to share");
					extent.extentLoggerPass("Share Option ",
							"Share Option : \"" + shareOptionName + "\" is available to share");
				}
			}
		} else {
			logger.info("Share Options are not displayed after clicking on Share CTA");
			extent.extentLoggerFail("Share through options screen",
					"Share Options are not displayed after clicking on Share CTA");
		}
		Back(1);
	}

	public void RemoveFromWatchlist() throws Exception {
		Back(1);
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
	
	
	public void ZeeApplicasterLogin(String LoginMethod) throws Exception {
		System.out.println("\nLogin to the App");

		switch (LoginMethod) {
		case "Guest":
			extent.HeaderChildNode("Logged in as <b>Guest</b> User");

			extent.extentLogger("Accessing the application as Guest user",
					"Accessing the application as <b>Guest</b> user");
			break;

		case "NonSubscribedUser":
			extent.HeaderChildNode("Login as NonSubscribed User");
			verifyElementPresentAndClick(AMDCleverTapPage.objCountryScreenConitnueBtn, "Continue button");
			String Username = getParameterFromXML("NonsubscribedUserName");
			String Password = getParameterFromXML("NonsubscribedPassword");

			verifyElementPresentAndClick(AMDHomePage.objHomeBtn, "Home tab");
			verifyElementPresentAndClick(AMDHomePage.objMoreMenu, "More Menu");
			verifyElementPresent(AMDMoreMenu.objLoginRegisterText, "Login/Register for best experience text");

			click(AMDMoreMenu.objLoginRegisterText, "Login/Registet link");
			verifyElementPresentAndClick(AMDLoginScreen.objEmailIdField, "Email field");
			type(AMDLoginScreen.objEmailIdField, Username, "Email Field");
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			verifyElementPresentAndClick(AMDLoginScreen.objPasswordField, "Password Field");
			type(AMDLoginScreen.objPasswordField, Password, "Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
			waitTime(3000);
			break;

		case "SubscribedUser":
			extent.HeaderChildNode("Login as Subscribed User");

			String SubscribedUsername = getParameterFromXML("SubscribedUserName");
			String SubscribedPassword = getParameterFromXML("SubscribedPassword");

			verifyElementPresentAndClick(AMDHomePage.objHomeBtn, "Home tab");
			verifyElementPresentAndClick(AMDHomePage.objMoreMenu, "More Menu");
			verifyElementPresent(AMDMoreMenu.objLoginRegisterText, "Login/Register for best experience text");

			click(AMDMoreMenu.objLoginRegisterText, "Login/Registet link");
			verifyElementPresentAndClick(AMDLoginScreen.objEmailIdField, "Email field");
			type(AMDLoginScreen.objEmailIdField, SubscribedUsername, "Email Field");
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			verifyElementPresentAndClick(AMDLoginScreen.objPasswordField, "Password Field");
			type(AMDLoginScreen.objPasswordField, SubscribedPassword, "Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
			waitTime(3000);
			break;																
		}
	}
	
	public void logout() throws Exception {
		HeaderChildNode("LogOut");
		verifyElementPresentAndClick(AMDHomePage.objMoreMenuBtn, "More menu");
	}
	
	public void validateResult() throws Exception {
		HeaderChildNode("Verify Events are reflected in dashboard");
		setPlatform("Web");
		new Zee5ApplicasterCleverTapBusinessLogic("Chrome");
			loginCleverTap();
			navigateToCleverTap();
			getEventName("Subscription Call Returned");
			getEventName("Subscription Call Initiated");
			getEventName("Subscription Selected");
			getEventName("Subscription Page Viewed");
			getEventName("Share");
			getEventName("Remove From Watchlist");
			getEventName("Search Cancelled");
			getEventName("Content Language Changed");
			getEventName("Display Language Changed");
			getEventName("Login Result");
			getWebDriver().quit();
			setPlatform("Android");
	}
}

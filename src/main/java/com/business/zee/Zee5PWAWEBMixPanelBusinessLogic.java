package com.business.zee;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import com.driverInstance.CommandBase;
import com.extent.ExtentReporter;
import com.propertyfilereader.PropertyFileReader;
import com.utility.Utilities;
import com.zee5.PWAPages.PWAAddToWatchListPage;
import com.zee5.PWAPages.PWAHamburgerMenuPage;
import com.zee5.PWAPages.PWAHomePage;
import com.zee5.PWAPages.PWALandingPages;
import com.zee5.PWAPages.PWALanguageSettingsPage;
import com.zee5.PWAPages.PWALiveTVPage;
import com.zee5.PWAPages.PWALoginPage;
import com.zee5.PWAPages.PWANewsPage;
import com.zee5.PWAPages.PWAPlayerPage;
import com.zee5.PWAPages.PWAPremiumPage;
import com.zee5.PWAPages.PWAQualitySettingsPage;
import com.zee5.PWAPages.PWASearchPage;
import com.zee5.PWAPages.PWAShowsPage;
import com.zee5.PWAPages.PWASignupPage;
import com.zee5.PWAPages.PWASubscriptionPages;

public class Zee5PWAWEBMixPanelBusinessLogic extends Utilities {

	public Zee5PWAWEBMixPanelBusinessLogic(String Application) throws InterruptedException {
		new CommandBase(Application);
		init();
	}

	String URL = getParameterFromXML("url");

	private int timeout;

	/** Retry Count */
	private int retryCount;

	ExtentReporter extent = new ExtentReporter();

	/** The Constant logger. */
	final static Logger logger = Logger.getLogger("rootLogger");

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
		logger.info(
				"Loaded the following properties" + " TimeOut :" + getTimeout() + " RetryCount :" + getRetryCount());
	}

	public void ZeeWEBPWAMixPanelLogin(String LoginMethod) throws Exception {
		String userType = getParameterFromXML("userType");
		switch (userType) {
		case "Guest":
			extent.HeaderChildNode("Guest User");
			extent.extentLogger("Accessing the application as Guest user", "Accessing the application as Guest user");
			dismissDisplayContentLanguagePopUp();
			waitTime(3000);
			break;

		case "NonSubscribedUser":
			extent.HeaderChildNode("Login as NonSubscribed User");
			String Username = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("NonsubscribedUserName");
			String Password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("NonsubscribedPassword");
			verifyElementPresentAndClick(PWALoginPage.objWebLoginBtn, "Login button");
			waitTime(3000);
			verifyElementPresent(PWALoginPage.objWebLoginPageText, "Login page");
			verifyElementPresentAndClick(PWALoginPage.objEmailField, "Email field");
			type(PWALoginPage.objEmailField, Username, "Email Field");
			waitTime(3000);
			verifyElementPresentAndClick(PWALoginPage.objPasswordField, "Password Field");
			type(PWALoginPage.objPasswordField, Password, "Password field");
			waitTime(5000);
			click(PWALoginPage.objWebLoginButton, "Login Button");
			waitTime(3000);
			break;

		case "SubscribedUser":
			extent.HeaderChildNode("Login as Subscribed User");
			String SubscribedUsername = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("SubscribedUserName");
			String SubscribedPassword = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("SubscribedPassword");
			verifyElementPresentAndClick(PWALoginPage.objWebLoginBtn, "Login button");
			waitTime(3000);
			verifyElementPresent(PWALoginPage.objWebLoginPageText, "Login page");
			verifyElementPresentAndClick(PWALoginPage.objEmailField, "Email field");
			type(PWALoginPage.objEmailField, SubscribedUsername, "Email Field");
			waitTime(3000);
			verifyElementPresentAndClick(PWALoginPage.objPasswordField, "Password Field");
			type(PWALoginPage.objPasswordField, SubscribedPassword, "Password field");
			waitTime(5000);
			click(PWALoginPage.objWebLoginButton, "Login Button");
			waitTime(3000);
			break;
		}
	}

	public void ZeeWEBPWAMixPanelLoginForParentalControl(String LoginMethod) throws Exception {
		String userType = getParameterFromXML("userType");
		switch (userType) {
		case "Guest":
			extent.HeaderChildNode("Guest User");
			extent.extentLogger("Accessing the application as Guest user", "Accessing the application as Guest user");
			dismissDisplayContentLanguagePopUp();
			waitTime(3000);
			break;

		case "NonSubscribedUser":
			extent.HeaderChildNode("Login as NonSubscribed User");
			String SUsername = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("SettingsNonsubscribedUserName");
			String SPassword = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("SettingsNonsubscribedPassword");
			verifyElementPresentAndClick(PWALoginPage.objWebLoginBtn, "Login button");
			waitTime(3000);
			verifyElementPresent(PWALoginPage.objWebLoginPageText, "Login page");
			verifyElementPresentAndClick(PWALoginPage.objEmailField, "Email field");
			type(PWALoginPage.objEmailField, SUsername, "Email Field");
			waitTime(3000);
			verifyElementPresentAndClick(PWALoginPage.objPasswordField, "Password Field");
			type(PWALoginPage.objPasswordField, SPassword, "Password field");
			waitTime(5000);
			click(PWALoginPage.objWebLoginButton, "Login Button");
			waitTime(3000);
			break;

		case "SubscribedUser":
			extent.HeaderChildNode("Login as Subscribed User");
			String SettingsSubscribedUsername = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("SettingsSubscribedUserName");
			String SettingsSubscribedPassword = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("SettingsSubscribedPassword");
			verifyElementPresentAndClick(PWALoginPage.objWebLoginBtn, "Login button");
			waitTime(3000);
			verifyElementPresent(PWALoginPage.objWebLoginPageText, "Login page");
			verifyElementPresentAndClick(PWALoginPage.objEmailField, "Email field");
			type(PWALoginPage.objEmailField, SettingsSubscribedUsername, "Email Field");
			waitTime(3000);
			verifyElementPresentAndClick(PWALoginPage.objPasswordField, "Password Field");
			type(PWALoginPage.objPasswordField, SettingsSubscribedPassword, "Password field");
			waitTime(5000);
			click(PWALoginPage.objWebLoginButton, "Login Button");
			waitTime(3000);
			break;
		}
	}

	/**
	 * Dismiss the Display Language pop up
	 */
	public void dismissDisplayContentLanguagePopUp() throws Exception {
		extent.HeaderChildNode("Dismiss Display and Content Language Pop Ups");
		waitForElementAndClickIfPresent(PWAHomePage.objContinueDisplayContentLangPopup, 90,
				"Continue on Display Language Pop Up");
		Thread.sleep(5000);
		waitForElementAndClickIfPresent(PWAHomePage.objContinueDisplayContentLangPopup, 10,
				"Continue on Content Language Pop Up");
	}

	/**
	 * Function to enter url
	 */
	public void enterURLInWEBBrowser(String browser, String url) {
		extent.HeaderChildNode("Enter Browser URL");
		if (browser.equalsIgnoreCase("chrome")) {
			try {
				getWebDriver().get(url);
				extent.extentLogger("enteredURL", "Entered " + url + " in " + browser + " browser");
				logger.info("Entered " + url + " in " + browser + " browser");
			} catch (Exception e) {
				extent.extentLogger("failToEnterURL", "Failed to enter " + url + " in " + browser + " browser");
			}
		}
	}

	/**
	 * Function to select any tab
	 * 
	 */
	public boolean navigateToAnyScreenOnWeb(String screen) throws Exception {
		try {
			if (checkElementDisplayed(PWAHomePage.objHomeBarText(screen), screen + " Tab")) {
				click(PWAHomePage.objHomeBarText(screen), screen + " Tab");
				return true;
			} else {
				JavascriptExecutor executor = (JavascriptExecutor) getWebDriver();
				getWebDriver().findElement(PWAHomePage.objMoreMenuIcon);
				waitTime(2000);
				try {
					WebElement tab = getWebDriver().findElement(PWAHomePage.objMoreMenuTabs(screen));
					logger.info(screen + " Tab is displayed");
					extent.extentLogger("tabDisplayed", screen + " Tab is displayed");
					executor.executeScript("arguments[0].click();", tab);
					logger.info("Clicked on " + screen + " Tab");
					extent.extentLogger("tabClicked", "Clicked on " + screen + " Tab");
				} catch (Exception e) {
				}
			}

		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
		}
		return false;
	}

	/**
	 * Function to scroll down
	 */
	public static void scrollDownWEB() {
		js.executeScript("window.scrollBy(0,250)", "");
	}

	/**
	 * Waits for player loader to complete
	 * 
	 * @throws Exception
	 */
	public void waitForPlayerLoaderToComplete() throws Exception {
		// verifyElementNotPresent(PWAPlayerPage.objPlayerLoader, 60);

		new WebDriverWait(getWebDriver(), 120)
				.until(ExpectedConditions.invisibilityOfElementLocated(PWAPlayerPage.objPlayerLoader));
	}

	/**
	 * Video Player or Live Player Ad verify
	 * 
	 * @param playerType
	 * @throws Exception
	 */
	public void waitForPlayerAdToComplete(String playerType) throws Exception {
		boolean adWasDisplayed = false;
		boolean playerDisplayed = false;
		int confirmCount = 0;
		waitTime(5000);
		main: for (int trial = 0; trial < 120; trial++) {
			try {
				findElement(PWAPlayerPage.objAd);
				adWasDisplayed = true;
				if (trial == 5) {
					logger.info("Ad play in progress");
					extent.extentLogger("AdPlayInProgress", "Ad play in progress");
					try {
						getWebDriver().findElement(PWAPlayerPage.objAd);
					} catch (Exception e) {
					}
				}
				if (Math.floorMod(trial, 15) == 0)
					System.out.println("Ad play in progress");
				Thread.sleep(1000);

//				//SkipAD
//				if(checkElementExist(PWAPlayerPage.objSkipAd, "SkipAd")){
//					Thread.sleep(5000);
//					click(PWAPlayerPage.objSkipAd, "SkipButton");					
//				}
//				else
//				{
//					System.out.println("No Skip Button Displayed");
//				}

			} catch (Exception e) {
				try {
					if (playerType.equals("Live Player")) {
						findElement(PWAPlayerPage.objLivePlayerLiveTag);
					} else if (playerType.equals("Video Player")) {
						findElement(PWAPlayerPage.objPlayerSeekBar);
					}
					playerDisplayed = true;
					confirmCount++;
					if (confirmCount == 1) {
						if (adWasDisplayed == false) {
							logger.info("Ad did not play");
							extent.extentLogger("AdDidNotPlay", "Ad did not play");
						} else {
							logger.info("Ad play complete");
							extent.extentLogger("AdPlayComplete", "Ad play complete");
						}
						break main;
					}
				} catch (Exception e1) {
				}
			}
		}
		if (playerDisplayed == false && adWasDisplayed == false) {
			logger.error("Ad play failure");
			extent.extentLogger("failedAd", "Ad play failure");
		}
	}

	/**
	 * Function Scroll to Element
	 *
	 * @param element
	 * @throws Exception
	 */
	public void ScrollToTheElementWEB(By element) throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor) getWebDriver();
		jse.executeScript("arguments[0].scrollIntoView(true);", findElement(element));
		jse.executeScript("window.scrollBy(0,-250)", "");
	}

	public void tearDown() {
		getWebDriver().quit();
	}

	public void navigateHome() {
		getWebDriver().get("https://newpwa.zee5.com/");
		getWebDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void Back_TO_TopArrow_Web(String usertype) throws Exception {

		scrollToBottomOfPageWEB();
		if (usertype.equalsIgnoreCase("Guest")) {
			if (checkElementExist(PWAHomePage.objWhatWonderingPopUp, "Wondering popUp")) {
				waitTime(3000);
				click(PWAHomePage.objWhatWonderingPopUpCloseIcon, "Close icon");
			}
		}

		if (checkElementExist(PWALandingPages.obj_Pwa_Back_to_Top_Arrow_btn, "Back to Top")) {
			click(PWALandingPages.obj_Pwa_Back_to_Top_Arrow_btn, "Back to Top");
			System.out.println("Scrolled back to top using Back to top btn");
		}

	}

	/**
	 * The method will wait for the element to be located for a maximum of given
	 * seconds. The method terminates immediately once the element is located. The
	 * method throws error if the element could not be located within the given
	 * seconds
	 */
	public boolean waitForElement(By locator, int seconds, String message) throws InterruptedException {
		for (int time = 0; time <= seconds; time++) {
			try {
				getWebDriver().findElement(locator);
				logger.info("Located element " + message);
				extent.extentLogger("locatedElement", "Located element " + message);
				return true;
			} catch (Exception e) {
				Thread.sleep(1000);
				if (time == seconds) {
					logger.error("Failed to locate element " + message);
					extent.extentLoggerFail("failedLocateElement", "Failed to locate element " + message);
				}
			}
		}
		return false;
	}

	/**
	 * Generic function to Logout.
	 */
	public void logout() throws Exception {
		extent.HeaderChildNode("Logout");
		verifyElementPresentAndClick(PWALandingPages.objWebProfileIcon, "Profile Icon");
		waitTime(3000);
		verifyElementPresentAndClick(PWAHamburgerMenuPage.objMyProfileOptionsWEB("Logout"), "Logout option");
		waitTime(3000);
		verifyElementNotPresent(PWAHamburgerMenuPage.objProfileIconWEB, 5);
		if (verifyElementPresent(PWALoginPage.objLoginBtnWEB, "Logout")) {
			logger.info("User successfuly logged out");
			extent.extentLogger("Log out", "User successfuly logged out");
		}
		click(PWAHomePage.objZeeLogo, "Home page");
	}

	public void verifySkipLoginEvent(String userType) throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("Verify Skip Login Event");
			verifyElementPresentAndClick(PWALoginPage.objWebLoginBtn, "Login button");
			waitTime(3000);
			verifyElementPresentAndClick(PWALoginPage.objSkip, "Skip Login");

		}
	}

	public void verifySkipLoginByClickingOnLoginInRegistrationPopUp(String userType, String keyword) throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {

			extent.HeaderChildNode(
					"Verify Skip Login Event during content playback post clicking on login in registration popup");
			click(PWAHomePage.objSearchBtn, "Search Icon");
			type(PWASearchPage.objSearchEditBox, keyword + "\n", "Search Edit box: " + keyword);
			waitTime(4000);
			waitForElement(PWASearchPage.objSearchResult(keyword), 10, "Search Result");
			click(PWASearchPage.objSearchResult(keyword), "Search Result");
			click(PWAPremiumPage.obj1stContentInShowDetailPage, "Content Card");
			waitForElement(PWALoginPage.objLoginLink, 20, "Login Link");
			click(PWALoginPage.objLoginLink, "Login Link");
			waitForElement(PWALoginPage.objSkip, 10, "Skip Login");
			click(PWALoginPage.objSkip, "Skip Login");
			waitTime(2000);
			Back(1);
		}
	}

	public void verifySkipLoginByClickingOnLoginInGetPremiumPopUp(String userType, String keyword2) throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {

			extent.HeaderChildNode(
					"Verify Skip Login Event during content playback post clicking on login button in Get Premium popup");
			click(PWAHomePage.objSearchBtn, "Search Icon");
			type(PWASearchPage.objSearchEditBox, keyword2 + "\n", "Search Edit box: " + keyword2);
			waitTime(4000);
			waitForElement(PWASearchPage.objSearchResult(keyword2), 10, "Search Result");
			click(PWASearchPage.objSearchResult(keyword2), "Search Result");
			click(PWALoginPage.objLoginCTAInPremiumPopup, "Login CTA");
			waitForElement(PWALoginPage.objSkip, 20, "Skip Login");
			click(PWALoginPage.objSkip, "Skip Login");
			waitTime(2000);
			Back(2);
		}
	}

	public void verifySkipRegistrationEvent(String userType) throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("Verify Skip Registration Event");
			click(PWALoginPage.objLoginBtnWEB, "Login button");
			waitTime(3000);
			click(PWALoginPage.objRegisterLink, "Register Link");
			verifyElementPresentAndClick(PWALoginPage.objSkip, "Skip Registration");
		}
	}

	public void verifySkipRegistrationEventDuringContentPlayback(String userType, String keyword) throws Exception {
		extent.HeaderChildNode("Verify Skip Registration Event During Content Playback");
		if (userType.equalsIgnoreCase("Guest")) {
			click(PWAHomePage.objSearchBtn, "Search Icon");
			type(PWASearchPage.objSearchEditBox, keyword + "\n", "Search Edit box: " + keyword);
			waitTime(4000);
			waitForElement(PWASearchPage.objSearchResult(keyword), 10, "Search Result");
			click(PWASearchPage.objSearchResult(keyword), "Search Result");
			click(PWAPremiumPage.obj1stContentInShowDetailPage, "Content Card");
			waitForElement(PWALoginPage.objCloseRegisterPopup, 20, "Skip Registration");
			click(PWALoginPage.objCloseRegisterPopup, "Skip Registration");

		}
	}

	public void verifySubscriptionPageViewedEvent(String userType, String keyword1, String keyword2) throws Exception {
		extent.HeaderChildNode("Verify Subscription Page Viewed Event");
		if (userType.equalsIgnoreCase("Guest")) {
			click(PWAHomePage.objSubscribeBtn, "Subscribe button");
			Back(1);
			click(PWAHomePage.objHamburgerMenu, "Hamburger Menu");
			click(PWAHamburgerMenuPage.objBuySubscription, "Buy Subscription option");
			Back(1);
			click(PWAHomePage.objHamburgerMenu, "Hamburger Menu");
			click(PWAHamburgerMenuPage.objHaveAPrepaidCode, "Have a Prepaid Code? option");
			Back(1);
		}
		click(PWAHomePage.objSearchBtn, "Search Icon");
		type(PWASearchPage.objSearchEditBox, keyword1 + "\n", "Search Edit box: " + keyword1);
		waitTime(4000);
		waitForElement(PWASearchPage.objSearchResult(keyword1), 10, "Search Result");
		click(PWASearchPage.objSearchResult(keyword1), "Search Result");
		waitForElement(PWAPlayerPage.objGetPremiumCTABelowPlayerScreen, 10, "Get Premium/Subscribe CTA below player");
		click(PWAPlayerPage.objGetPremiumCTABelowPlayerScreen, "Get Premium/Subscribe CTA below player");
		click(PWASubscriptionPages.objPopupProceedBtn, "Popup Proceed Button");
		Back(1);

		click(PWAHomePage.objSubscribeBtn, "Subscribe button");
		verifyElementPresentAndClick(PWASubscriptionPages.objHaveACode, "Have A Code section");
		type(PWASubscriptionPages.objHaveACode, "sdcrfd", "Prepaid Code");
		click(PWASubscriptionPages.objApplyBtn, "Apply Button");
		waitTime(2000);
		click(PWASubscriptionPages.objHaveACodeCloseBtn, "Close Button");
		click(PWASubscriptionPages.objHaveACode, "Have A Code section");
		type(PWASubscriptionPages.objHaveACode, "PNB20", "Prepaid Code");
		click(PWASubscriptionPages.objApplyBtn, "Apply Button");
		waitTime(2000);
		click(PWASubscriptionPages.objContinueBtn, "Continue Button");
		waitTime(2000);
		click(PWAHomePage.objZeeLogo, "Zee Logo");

	}

	public void verifyTVAuthenticationScreenDisplayEvent(String userType) throws Exception {
		if (!(userType.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode("Verify TV Authentication Screen Display Event");
			click(PWAHomePage.objHamburgerMenu, "Hamburger Menu");
			waitTime(3000);
			verifyElementPresentAndClick(PWAHamburgerMenuPage.objAuthenticationOption, "Authenticate Device");
			Back(1);
		}
	}

	public void facebookLogin() throws Exception {
		extent.HeaderChildNode("Login through Facebook");
		getWebDriver().get(URL);
		verifyElementPresentAndClick(PWALoginPage.objLoginBtnWEB, "Login button");

		waitForElementDisplayed(PWALoginPage.objFacebookIcon, 10);

		checkElementDisplayed(PWALoginPage.objGoogleIcon, "Google icon");
		waitTime(1000);
		checkElementDisplayed(PWALoginPage.objTwitterIcon, "Twitter icon");

		checkElementDisplayed(PWALoginPage.objFacebookIcon, "Facebook icon");

		waitTime(10000);
		click(PWALoginPage.objFacebookIcon, "Facebook Icon");
		switchToWindow(2);

		if (checkElementDisplayed(PWALandingPages.objWebProfileIcon, "Profile icon")) {
			logger.info("User Logged in Successfully");
			extent.extentLogger("Logged in", "User Logged in Successfully");

		}

		else {
			checkElementDisplayed(PWALoginPage.objFacebookPageVerificationWeb, "Facebook page");
			verifyElementPresent(PWALoginPage.objFacebookLoginEmailWeb, " Email Field");
			type(PWALoginPage.objFacebookLoginEmailWeb, "igstesttt@gmail.com", "Emial Field");
			verifyElementPresent(PWALoginPage.objFacebookLoginpasswordWeb, " Password Field");
			type(PWALoginPage.objFacebookLoginpasswordWeb, "Igs123!@#", "Password Field");
			verifyElementPresentAndClick(PWALoginPage.objFacebookLoginButtonInFbPageWeb, "Login Button");
			switchToWindow(1);
			waitForElementDisplayed(PWALandingPages.objWebProfileIcon, 20);
			if (verifyElementPresent(PWALandingPages.objWebProfileIcon, "Profile icon")) {
				logger.info("User Logged in Successfully");
				extent.extentLogger("Logged in", "User Logged in Successfully");
			}
		}
		logout();
	}

	public void phoneNumberRegistration() throws Exception {
		extent.HeaderChildNode(
				"verifing that user is able to enter Mobile number, Password, date of birth, gender in Registration page");
		click(PWALoginPage.objSignUpBtnWEB, "Sign up button");
		waitForElementDisplayed(PWALoginPage.objEmailField, 5);
		checkElementDisplayed(PWALoginPage.objEmailField, "Email/PhoneNo Field");
		type(PWALoginPage.objEmailField, "7892215214", "PhoneNumber Field");
		click(PWASignupPage.objSignUpButtonHighlightedWeb, "Continue Button");
		type(PWASignupPage.objOTP1, "1", "OTP box1");
		type(PWASignupPage.objOTP2, "2", "OTP box2");
		type(PWASignupPage.objOTP3, "3", "OTP box3");
		type(PWASignupPage.objOTP4, "4", "OTP box4");
		waitTime(3000);
		verifyElementPresentAndClick(PWASignupPage.objVerifyBtnWeb, "Verified Button");

	}

	public void twitterLogin() throws Exception {
		extent.HeaderChildNode("Login through Twitter");

		verifyElementPresentAndClick(PWALoginPage.objLoginBtnWEB, "Login button");
		waitForElementDisplayed(PWALoginPage.objLoginPageheader, 10);

		waitForElementDisplayed(PWALoginPage.objTwitterIcon, 10);
		checkElementDisplayed(PWALoginPage.objTwitterIcon, "Twitter icon");
		waitTime(1000);

		click(PWALoginPage.objTwitterIcon, "twitter Icon");
		switchToWindow(2);

		if (checkElementDisplayed(PWALandingPages.objWebProfileIcon, "Profile icon")) {
			logger.info("User Logged in Successfully");
			extent.extentLogger("Logged in", "User Logged in Successfully");
			logout();

		}

		else {
			verifyElementPresent(PWALoginPage.objTwitterEmaildField, " Email Field");
			type(PWALoginPage.objTwitterEmaildField, "zee5latest@gmail.com", "Email Field");

			verifyElementPresent(PWALoginPage.objTwitterPasswordField, " Password Field");
			type(PWALoginPage.objTwitterPasswordField, "User@123", "Password Field");

			verifyElementPresentAndClick(PWALoginPage.objTwitterSignInButton, "Login Button");
			switchToParentWindow();
			waitForElementDisplayed(PWALandingPages.objWebProfileIcon, 20);
			if (checkElementDisplayed(PWALandingPages.objWebProfileIcon, "Profile icon")) {
				logger.info("User Logged in Successfully");
				extent.extentLogger("Logged in", "User Logged in Successfully");
				logout();
			} else {
				logger.info("User is not logged in Successfully");
				extent.extentLoggerFail("Logged in", "User is not logged in Successfully");
				Back(1);
			}
		}

	}

	public void socialLogin(String LoginMethod) throws Exception {
		switch (LoginMethod) {

		case "twitterLogin":
			twitterLogin();
			waitTime(3000);
			break;

		case "fbLogin":
			facebookLogin();
			waitTime(3000);
			break;

		}
	}

	public void verifyLoginInitiatedEventForValidCredentials(String userType, String loginMethod) throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("Verify Login Initiated Event for Valid Credentials");
			socialLogin(loginMethod);
		}
	}

	public void verifyLoginScreenDisplayEventByClickingOnLoginButton(String userType) throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("Verify Login Screen Display Event By Clicking On Login Button");
			verifyElementPresentAndClick(PWALoginPage.objWebLoginBtn, "Login button");
			waitTime(3000);
			Back(1);

		}
	}

	public void verifyLoginScreenDisplayEventByClickingOnLoginButtonOnPlayer(String userType, String keyword2)
			throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("Verify Login Screen Display Event By Clicking On Login Button On Player");

			click(PWAHomePage.objSearchBtn, "Search Icon");
			type(PWASearchPage.objSearchEditBox, keyword2 + "\n", "Search Edit box: " + keyword2);
			waitTime(4000);
			waitForElement(PWASearchPage.objSearchResult(keyword2), 10, "Search Result");
			click(PWASearchPage.objSearchResult(keyword2), "Search Result");

			if (checkElementDisplayed(PWAHamburgerMenuPage.objGetPremiumPopup, "GET PREMIUM POPUP") == true) {
				verifyElementPresentAndClick(PWAHamburgerMenuPage.objPopupClose, "POP-UP CLOSE BUTTON");
			}
			verifyElementPresent(PWASubscriptionPages.objLoginLinkInPlayer, "Login link");
			JSClick(PWASubscriptionPages.objLoginLinkInPlayer, "Login link");
			waitTime(2000);
			Back(1);
			if (checkElementDisplayed(PWAHamburgerMenuPage.objGetPremiumPopup, "GET PREMIUM POPUP") == true) {
				verifyElementPresentAndClick(PWAHamburgerMenuPage.objPopupClose, "POP-UP CLOSE BUTTON");
			}
		}
	}

	public void verifyLoginScreenDisplayEventByClickingOnLoginButtonInRegistartionScreen(String userType)
			throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode(
					"Verify Login Screen Display Event By Clicking On Login Button In Registartion Screen");
			click(PWALoginPage.objWebLoginBtn, "Login button");
			click(PWALoginPage.objRegisterLink, "Register link");
			JSClick(PWALoginPage.objLoginLink, "Login link");
			Back(1);
		}
	}

	public void verifyLoginScreenDisplayEventByClickingOnLoginButtonInGetPremiumPopUp(String userType, String keyword2)
			throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode(
					"Verify Login Screen Display Event By Clicking On Login Button In Get Premium Pop Up");

			click(PWAHomePage.objSearchBtn, "Search Icon");
			type(PWASearchPage.objSearchEditBox, keyword2 + "\n", "Search Edit box: " + keyword2);
			waitTime(4000);
			waitForElement(PWASearchPage.objSearchResult(keyword2), 10, "Search Result");
			click(PWASearchPage.objSearchResult(keyword2), "Search Result");

			if (checkElementDisplayed(PWAHamburgerMenuPage.objGetPremiumPopup, "GET PREMIUM POPUP") == true) {
				// ScrollToTheElementWEB(PWALoginPage.objLoginCTAInPremiumPopup);
				verifyElementPresentAndClick(PWALoginPage.objLoginCTAInPremiumPopup, "Login link");
				Back(1);
			}

		}
	}

	public void verifyCarouselBannerClickEvent(String tabName) throws Exception {
		extent.HeaderChildNode(
				"Verify Carousel Banner Click Event And Video View Event For content played from Carousel");
		navigateToAnyScreenOnWeb(tabName);
		waitTime(5000);
		verifyElementPresentAndClick(PWAPremiumPage.objWEBMastheadCarousel, "Carousel Content");

	}

	public void verifyCarouselBannerClickEventAndVideoViewEvent(String userType, String tabName) throws Exception {
		extent.HeaderChildNode(
				"Verify Carousel Banner Click Event And Video View Event For content played from Carousel");
		navigateToAnyScreenOnWeb(tabName);
		waitTime(5000);
		verifyElementPresentAndClick(PWAPremiumPage.objWEBMastheadCarousel, "Carousel Content");
		waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
		waitTime(5000);
		click(PWAPlayerPage.objPlaybackVideoOverlay, "Player");
		click(PWAPlayerPage.objPlayerPause, "Pause Icon");
		click(PWAPlayerPage.maximizeBtn, "Maximize icon");
		click(PWAPlayerPage.minimizeBtn, "Minimize icon");
		extent.HeaderChildNode(
				"Verify Video Watch Duration event when video is closed abruptly on playing Carousel Content");
		Back(1);

		click(PWAHomePage.objZeeLogo, "Zee Logo");
	}

	public void verifyThumbnailClickEventFromTray(String tabName) throws Exception {
		extent.HeaderChildNode("Verify Thumbnail Click Event For content played from trays");
		navigateToAnyScreenOnWeb(tabName);
		waitTime(5000);
		verifyElementPresentAndClick(PWAPremiumPage.objThumbnail, "Thumbnail from a tray");
	}

	public void verifyThumbnailClickEventFromViewMorePage(String tabName) throws Exception {
		extent.HeaderChildNode("Verify Thumbnail Click Event For content played from trays");
		navigateToAnyScreenOnWeb(tabName);
		waitTime(5000);
		click(PWAPremiumPage.objViewAllBtn, "View All Button");
		verifyElementPresentAndClick(PWAPremiumPage.objThumbnail, "Thumbnail from View More Page");

	}

	public void verifyThumbnailClickEventFromShowDetailPage(String keyword) throws Exception {
		extent.HeaderChildNode("Verify Thumbnail Click Event From Show Detail Page");
		click(PWAHomePage.objSearchBtn, "Search Icon");
		type(PWASearchPage.objSearchEditBox, keyword + "\n", "Search Edit box: " + keyword);
		waitTime(4000);
		click(PWASearchPage.objSearchResult(keyword), "Search Result");

		verifyElementPresentAndClick(PWAPremiumPage.obj1stContentInShowDetailPage, "Thumbnail from Show detail page");
	}

	public void verifyThumbnailClickEventFromPlaybackPage(String keyword, String userType) throws Exception {
		extent.HeaderChildNode("Verify Thumbnail Click Event From Playback Page");
		click(PWAHomePage.objSearchBtn, "Search Icon");
		type(PWASearchPage.objSearchEditBox, keyword + "\n", "Search Edit box: " + keyword);
		waitTime(4000);
		click(PWASearchPage.objSearchResult(keyword), "Search Result");

		click(PWAPremiumPage.obj1stContentInShowDetailPage, "Thumbnail");
		mandatoryRegistrationPopUp(userType);
		verifyElementPresentAndClick(PWAPremiumPage.obj1stContentInShowDetailPage, "Thumbnail from playback page");

	}

	public void verifyThumbnailClickEventAndVideoViewEvent(String userType, String tabName) throws Exception {
		extent.HeaderChildNode("Verify Thumbnail Click Event And Video View Event For content played from trays");
		navigateToAnyScreenOnWeb(tabName);
		waitTime(5000);
		verifyElementPresentAndClick(PWAPremiumPage.objThumbnail, "Thumbnail from a tray");
		mandatoryRegistrationPopUp(userType);
		waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
		waitForPlayerAdToComplete("Video Player");
		waitTime(5000);
		click(PWAPlayerPage.objPlaybackVideoOverlay, "Player");
		click(PWAPlayerPage.objPlayerPause, "Pause Icon");
		click(PWAPlayerPage.maximizeBtn, "Maximize icon");
		click(PWAPlayerPage.minimizeBtn, "Minimize icon");
		Back(1);
		click(PWAPremiumPage.objViewAllBtn, "View All Button");
		click(PWAPremiumPage.objThumbnail, "Thumbnail from View More Page");
		Back(1);
		click(PWAHomePage.objZeeLogo, "Zee Logo");
//		navigateToAnyScreenOnWeb("Shows");
//		click(PWAPremiumPage.objThumbnail, "Thumbnail from a tray");
//		Back(1);
//		navigateToAnyScreenOnWeb("Movies");
//		click(PWAPremiumPage.objThumbnail, "Thumbnail from a tray");
//
//		if (checkElementDisplayed(PWAHamburgerMenuPage.objGetPremiumPopup, "GET PREMIUM POPUP") == true) {
//			verifyElementPresentAndClick(PWAHamburgerMenuPage.objPopupClose, "POP-UP CLOSE BUTTON");
//		}
//		Back(1);
//		navigateToAnyScreenOnWeb("Premium");
//		click(PWAPremiumPage.objThumbnail, "Thumbnail from a tray");
//
//		if (checkElementDisplayed(PWAHamburgerMenuPage.objGetPremiumPopup, "GET PREMIUM POPUP") == true) {
//			verifyElementPresentAndClick(PWAHamburgerMenuPage.objPopupClose, "POP-UP CLOSE BUTTON");
//		}
//		Back(1);
//		click(PWAPremiumPage.objViewAllBtn, "View All Button");
//		click(PWAPremiumPage.objThumbnail, "Thumbnail from View More Page");
//		Back(1);
//		navigateToAnyScreenOnWeb("Movies");
//		click(PWAPremiumPage.objViewAllBtn, "View All Button");
//		waitTime(5000);
//		click(PWAPremiumPage.objThumbnail, "Thumbnail from View More Page");
//
//		if (checkElementDisplayed(PWAHamburgerMenuPage.objGetPremiumPopup, "GET PREMIUM POPUP") == true) {
//			verifyElementPresentAndClick(PWAHamburgerMenuPage.objPopupClose, "POP-UP CLOSE BUTTON");
//		}
//		
//		navigateToAnyScreenOnWeb("Shows");
//		click(PWAPremiumPage.objThumbnail, "Thumbnail from a tray");
//		click(PWAPremiumPage.objViewAllBtn, "View All Button");
//		Back(1);
//		click(PWAPremiumPage.objThumbnail, "Thumbnail from Show detail page");
//		click(PWAPremiumPage.objViewAllBtn, "View All Button");
//		click(PWAHomePage.objZeeLogo, "Zee Logo");	
	}

	public void verifySearchExecutedEvent() throws Exception {
		extent.HeaderChildNode("Verify Search Executed Event");
		click(PWAHomePage.objSearchBtn, "Search Icon");
		type(PWASearchPage.objSearchEditBox, "kam" + "\n", "Search Edit box: ");
		waitTime(4000);

	}

	public void verifyScreenViewEvent(String screen) throws Exception {
		extent.HeaderChildNode("Verify Screen View Event");
		navigateToAnyScreenOnWeb(screen);

	}

	public void clearSearchHistoryEvent(String keyword3) throws Exception {
		extent.HeaderChildNode("Verify Clear Search History Event");
		click(PWAHomePage.objSearchBtn, "Search Icon");
		type(PWASearchPage.objSearchEditBox, keyword3 + "\n", "Search Edit box: " + keyword3);
		waitTime(4000);
		verifyElementPresentAndClick(PWASearchPage.objSearchCloseButton, "Clear Search Icon");

	}

	public void verifyParentalRestrictionEvent(String userType, String restriction) throws Exception {
		if (!(userType.equalsIgnoreCase("Guest"))) {

			extent.HeaderChildNode("Verify Parental Restriction Event");
			click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger menu");
			click(PWAHamburgerMenuPage.objParentalControl, "ParentalControl");
			checkElementDisplayed(PWALoginPage.objPasswordField, "password field");
			String password = "";
			if (userType.equals("NonSubscribedUser")) {
				password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("SettingsNonsubscribedPassword");
			} else if (userType.equals("SubscribedUser")) {
				password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("SettingsSubscribedPassword");
			}
			type(PWALoginPage.objPasswordField, password, "Password field");
			click(PWAHamburgerMenuPage.objContinueButtonInVerifyAccount, "Continue button");
			waitTime(2000);
			checkElementDisplayed(PWAHamburgerMenuPage.objParentControlPageTitle, "Parent control page");

			switch (restriction) {

			case "Age13+":
				click(PWAHamburgerMenuPage.objRestrict13PlusContent, "Restrict all option");
				click(PWAHamburgerMenuPage.objParentalLockPin1, "Set Lock Field");
				type(PWAHamburgerMenuPage.objParentalLockPin1, "1", "ParentalLockPin");
				type(PWAHamburgerMenuPage.objParentalLockPin2, "2", "ParentalLockPin");
				type(PWAHamburgerMenuPage.objParentalLockPin3, "3", "ParentalLockPin");
				type(PWAHamburgerMenuPage.objParentalLockPin4, "4", "ParentalLockPin");
				waitTime(4000);
				click(PWAHamburgerMenuPage.objSetParentalLockButton, "Set Parental lock button");
				waitTime(2000);
				checkElementDisplayed(PWAHomePage.objZeeLogo, "zee logo");
				waitTime(3000);

				click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger menu");
				click(PWAHamburgerMenuPage.objParentalControl, "ParentalControl");
				checkElementDisplayed(PWALoginPage.objPasswordField, "password field");
				type(PWALoginPage.objPasswordField, password, "Password field");
				waitTime(2000);
				click(PWAHamburgerMenuPage.objContinueButtonInVerifyAccount, "Continue button");
				waitTime(2000);
				checkElementDisplayed(PWAHamburgerMenuPage.objParentControlPageTitle, "Parent control page");
				click(PWAHamburgerMenuPage.objParentalLockNoRestrictionOption, "No restriction option");
				click(PWAHamburgerMenuPage.objSetParentalLockButton, "Set Parental lock button");
				waitTime(2000);
				click(PWAHomePage.objZeeLogo, "zee logo");

			case "RestrictAll":
				click(PWAHamburgerMenuPage.objRestrictAll, "Restrict all option");
				click(PWAHamburgerMenuPage.objParentalLockPin1, "Set Lock Field");
				type(PWAHamburgerMenuPage.objParentalLockPin1, "1", "ParentalLockPin");
				type(PWAHamburgerMenuPage.objParentalLockPin2, "2", "ParentalLockPin");
				type(PWAHamburgerMenuPage.objParentalLockPin3, "3", "ParentalLockPin");
				type(PWAHamburgerMenuPage.objParentalLockPin4, "4", "ParentalLockPin");
				waitTime(4000);
				click(PWAHamburgerMenuPage.objSetParentalLockButton, "Set Parental lock button");
				waitTime(2000);
				checkElementDisplayed(PWAHomePage.objZeeLogo, "zee logo");
				waitTime(3000);

				click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger menu");
				click(PWAHamburgerMenuPage.objParentalControl, "ParentalControl");
				checkElementDisplayed(PWALoginPage.objPasswordField, "password field");
				type(PWALoginPage.objPasswordField, password, "Password field");
				waitTime(2000);
				click(PWAHamburgerMenuPage.objContinueButtonInVerifyAccount, "Continue button");
				waitTime(2000);
				checkElementDisplayed(PWAHamburgerMenuPage.objParentControlPageTitle, "Parent control page");
				click(PWAHamburgerMenuPage.objParentalLockNoRestrictionOption, "No restriction option");
				click(PWAHamburgerMenuPage.objSetParentalLockButton, "Set Parental lock button");
				waitTime(2000);
				click(PWAHomePage.objZeeLogo, "zee logo");

			case "NoRestriction":
				click(PWAHamburgerMenuPage.objNoRestrictionSelected, "Restrict all option");
				click(PWAHamburgerMenuPage.objContinueButton, "Continue Button");

			}

		}
	}

	public void verifyAddAndRemoveFomWatchlistAndShareEvent(String userType, String keyword1) throws Exception {

		click(PWAHomePage.objSearchBtn, "Search Icon");
		type(PWASearchPage.objSearchEditBox, keyword1 + "\n", "Search Edit box: " + keyword1);
		waitTime(4000);
		waitForElement(PWASearchPage.objSearchResult(keyword1), 10, "Search Result");
		click(PWASearchPage.objSearchResult(keyword1), "Search Result");

		if (!(userType.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode("Verify Add to Watchlist Event");
			verifyElementPresentAndClick(PWAPlayerPage.watchListBtn, "Add to Watchlist button");
			waitTime(2000);
			extent.HeaderChildNode("Verify Remove From Watchlist Event");
			verifyElementPresentAndClick(PWAPlayerPage.watchListBtn, "Remove From Watchlist button");
			waitTime(4000);
		}
		extent.HeaderChildNode("Verify Share Event");
		click(PWAPlayerPage.shareBtn, "Share Option");
		click(PWAPlayerPage.facebookShareBtn, "Facebook share option");

		switchToWindow(2);
		Thread.sleep(2000);

		if (checkElementDisplayed(PWALiveTVPage.objFacebookEmailField, "Facebook Email field")) {
			click(PWALiveTVPage.objFacebookEmailField, "Facebook Email field");

			getWebDriver().findElement(PWALiveTVPage.objFacebookEmailField).sendKeys("igszeetest@gmail.com");
			click(PWALiveTVPage.objFacebookPasswordField, "Facebook Password field");
			getWebDriver().findElement(PWALiveTVPage.objFacebookPasswordField).sendKeys("igs@12345");
			click(PWALiveTVPage.objFacebookLoginBtn, "Facebook Login button");
			waitTime(2000);
			verifyAlert();
			waitTime(2000);
		}
		click(PWALiveTVPage.objPostToFacebookBtn, "Post to Facebook");
		getWebDriver().close();
		switchToWindow(1);
		waitTime(3000);

		click(PWAPlayerPage.shareBtn, "Share Option");
		Thread.sleep(2000);
		click(PWAPlayerPage.twitterShareBtn, "Twitter share option");
		Thread.sleep(2000);
		switchToWindow(2);
		Thread.sleep(2000);
		verifyAlert();
		waitTime(3000);

		if (checkElementDisplayed(PWALiveTVPage.objTwitterEmailField, "Twitter Email field")) {
			waitTime(2000);
			click(PWALiveTVPage.objTwitterEmailField, "Twitter Email field");
			getWebDriver().findElement(PWALiveTVPage.objTwitterEmailField).sendKeys("zee5latest@gmail.com");
			waitTime(2000);
			click(PWALiveTVPage.objTwitterPasswordField, "Twitter Password field");
			getWebDriver().findElement(PWALiveTVPage.objTwitterPasswordField).sendKeys("User@123");
			click(PWALiveTVPage.objTwitterLoginButton, "Twitter Login button");
			waitTime(2000);
			verifyAlert();
			waitTime(2000);
		}
		click(PWALiveTVPage.objTweetButton, "Tweet button");
		waitTime(2000);
		verifyAlert();
		getWebDriver().close();
		switchToParentWindow();
		Thread.sleep(2000);

	}

	public void verifyAddAndRemoveFomWatchlistAndShareEventByMouseHover(String userType) throws Exception {
		Actions actions = new Actions(getWebDriver());
		WebElement contentCard = getWebDriver().findElement(PWAPremiumPage.obj1stContentInShowDetailPage);
		if (!(userType.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode(
					"Verify Add to Watchlist and Remove from Watchlist Event by mouse hovering on a Content Card");

			actions.moveToElement(contentCard).build().perform();

			verifyElementPresentAndClick(PWAPremiumPage.objContentCardWatchlistBtn, "Add to Watchlist icon");
			actions.moveToElement(contentCard).build().perform();
			verifyElementPresentAndClick(PWAPremiumPage.objContentCardWatchlistBtn, "Remove from Watchlist icon");
		}

		extent.HeaderChildNode("Verify Share Event By Mouse Hovering on a Content Card");
		actions.moveToElement(contentCard).build().perform();
		verifyElementPresentAndClick(PWAPremiumPage.objContentCardShareBtn, "Share icon");

		click(PWAPlayerPage.facebookShareBtn, "Facebook share option");

		switchToWindow(2);
		Thread.sleep(2000);

		if (checkElementDisplayed(PWALiveTVPage.objFacebookEmailField, "Facebook Email field")) {
			verifyElementPresentAndClick(PWALiveTVPage.objFacebookEmailField, "Facebook Email field");

			getWebDriver().findElement(PWALiveTVPage.objFacebookEmailField).sendKeys("igszeetest@gmail.com");
			click(PWALiveTVPage.objFacebookPasswordField, "Facebook Password field");
			getWebDriver().findElement(PWALiveTVPage.objFacebookPasswordField).sendKeys("igs@12345");
			click(PWALiveTVPage.objFacebookLoginBtn, "Facebook Login button");
			waitTime(2000);
			verifyAlert();
			waitTime(2000);
		}
		click(PWALiveTVPage.objPostToFacebookBtn, "Post to Facebook");
		getWebDriver().close();
		switchToWindow(1);
		waitTime(3000);
		actions.moveToElement(contentCard).build().perform();
		click(PWAPremiumPage.objContentCardShareBtn, "Share icon");
		Thread.sleep(2000);
		click(PWAPlayerPage.twitterShareBtn, "Twitter share option");
		Thread.sleep(2000);
		switchToWindow(2);
		Thread.sleep(2000);
		verifyAlert();
		waitTime(3000);

		if (checkElementDisplayed(PWALiveTVPage.objTwitterEmailField, "Twitter Email field")) {
			waitTime(2000);
			click(PWALiveTVPage.objTwitterEmailField, "Twitter Email field");
			getWebDriver().findElement(PWALiveTVPage.objTwitterEmailField).sendKeys("zee5latest@gmail.com");
			waitTime(2000);
			click(PWALiveTVPage.objTwitterPasswordField, "Twitter Password field");
			getWebDriver().findElement(PWALiveTVPage.objTwitterPasswordField).sendKeys("User@123");
			click(PWALiveTVPage.objTwitterLoginButton, "Twitter Login button");
			waitTime(2000);
			verifyAlert();
			waitTime(2000);
		}
		click(PWALiveTVPage.objTweetButton, "Tweet button");
		waitTime(2000);
		verifyAlert();
		getWebDriver().close();
		switchToParentWindow();
		Thread.sleep(2000);

	}

	public void verifyShareEventFromShowDetailPage(String userType, String keyword) throws Exception {

		extent.HeaderChildNode("Verify Search Cancelled Event");
		click(PWAHomePage.objSearchBtn, "Search Icon");
		click(PWASearchPage.objSearchCancel, "Close Button");

		extent.HeaderChildNode("Verify Share Event From Show Detail Page");
		click(PWAHomePage.objSearchBtn, "Search Icon");
		type(PWASearchPage.objSearchEditBox, keyword + "\n", "Search Edit box: " + keyword);
		waitTime(4000);
		click(PWASearchPage.objSearchResult(keyword), "Search Result");

		click(PWAPlayerPage.shareBtn, "Share Option");
		click(PWAPlayerPage.facebookShareBtn, "Facebook share option");

		switchToWindow(2);
		Thread.sleep(2000);

		if (checkElementDisplayed(PWALiveTVPage.objFacebookEmailField, "Facebook Email field")) {
			verifyElementPresentAndClick(PWALiveTVPage.objFacebookEmailField, "Facebook Email field");

			getWebDriver().findElement(PWALiveTVPage.objFacebookEmailField).sendKeys("igszeetest@gmail.com");
			click(PWALiveTVPage.objFacebookPasswordField, "Facebook Password field");
			getWebDriver().findElement(PWALiveTVPage.objFacebookPasswordField).sendKeys("igs@12345");
			click(PWALiveTVPage.objFacebookLoginBtn, "Facebook Login button");
			waitTime(2000);
			verifyAlert();
			waitTime(2000);
		}
		click(PWALiveTVPage.objPostToFacebookBtn, "Post to Facebook");
		getWebDriver().close();
		switchToWindow(1);
		waitTime(3000);

		click(PWAPlayerPage.shareBtn, "Share Option");
		Thread.sleep(2000);
		click(PWAPlayerPage.twitterShareBtn, "Twitter share option");
		Thread.sleep(2000);
		switchToWindow(2);
		Thread.sleep(2000);
		verifyAlert();
		waitTime(3000);

		if (checkElementDisplayed(PWALiveTVPage.objTwitterEmailField, "Twitter Email field")) {
			waitTime(2000);
			click(PWALiveTVPage.objTwitterEmailField, "Twitter Email field");
			getWebDriver().findElement(PWALiveTVPage.objTwitterEmailField).sendKeys("zee5latest@gmail.com");
			waitTime(2000);
			click(PWALiveTVPage.objTwitterPasswordField, "Twitter Password field");
			getWebDriver().findElement(PWALiveTVPage.objTwitterPasswordField).sendKeys("User@123");
			click(PWALiveTVPage.objTwitterLoginButton, "Twitter Login button");
			waitTime(2000);
			verifyAlert();
			waitTime(2000);
		}
		click(PWALiveTVPage.objTweetButton, "Tweet button");
		waitTime(2000);
		verifyAlert();
		getWebDriver().close();
		switchToParentWindow();
		Thread.sleep(2000);

		extent.HeaderChildNode("Verify Content Bucket Swipe Event in Show Detail page");
		click(PWAPremiumPage.objRightArrowBtn, "Right Arrow Button");
		click(PWAPremiumPage.objLeftArrowBtn, "Left Arrow Button");

		extent.HeaderChildNode("Verify Episode List Chosen Event in Show Detail page");
		click(PWAShowsPage.objShowDetailEpisodeDropdown, "Episode Dropdown");
		click(PWAShowsPage.objShowDetailEpisodeDropdownValues(2), "Episodes 11-20");
		waitTime(5000);
		extent.HeaderChildNode(
				"Verify Thumbnail Click Event And Video View Event For content played from Show detail page");
		click(PWAPremiumPage.obj1stContentInShowDetailPage, "Thumbnail from Show detail page");
		extent.HeaderChildNode(
				"Verify Thumbnail Click Event And Video View Event For content played from playback page");
		verifyElementPresentAndClick(PWAPremiumPage.obj1stContentInShowDetailPage, "Thumbnail from playback page");
		mandatoryRegistrationPopUp(userType);
		waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
		extent.HeaderChildNode(
				"Verify Video Watch Duration event when video is closed abruptly on playing Content from a tray");
		Back(1);
		extent.HeaderChildNode("Verify View More Selected Event For content played from Show detail page");
		click(PWAPremiumPage.objViewAllBtn, "View All Button");

		if (!(userType.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode(
					"Verify Add and Remove From Watchlist Event By Mouse Hovering on a Content Card in Show Detail Page");
			Actions actions = new Actions(getWebDriver());
			WebElement contentCard = getWebDriver().findElement(PWAPremiumPage.obj1stContentInShowDetailPage);
			actions.moveToElement(contentCard).build().perform();

			verifyElementPresentAndClick(PWAPremiumPage.objContentCardWatchlistBtn, "Add to Watchlist icon");
			click(PWALandingPages.objWebProfileIcon, "Profile icon");
			click(PWAAddToWatchListPage.objMyWatchList, "My Watchlist option");

			extent.HeaderChildNode("Verify Video View and Video Exit Event for Content from My Watchlist page");
			click(PWAAddToWatchListPage.objWatchlistedItems, "Content Card in Watchlist page");
			mandatoryRegistrationPopUp(userType);
			waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
			waitTime(6000);
			click(PWAPlayerPage.objPlaybackVideoOverlay, "Player");
			click(PWAPlayerPage.objPlayerPause, "Pause Icon");
			click(PWAPlayerPage.maximizeBtn, "Maximize icon");
			click(PWAPlayerPage.minimizeBtn, "Minimize icon");
			extent.HeaderChildNode(
					"Verify Video Watch Duration event when video is closed abruptly on playing Content from My Watchlist page");
			Back(1);
			verifyElementPresentAndClick(PWAAddToWatchListPage.objRemoveContentsInWatchList,
					"Remove From Watchlist option");
			Back(1);
			actions.moveToElement(contentCard).build().perform();
			click(PWAPremiumPage.objContentCardWatchlistBtn, "Add to Watchlist icon");
			actions.moveToElement(contentCard).build().perform();
			click(PWAPremiumPage.objContentCardWatchlistBtn, "Remove from Watchlist icon");
		}
	}

	/**
	 * Function to Relaunch the driver
	 */
	public void relaunch(boolean clearData) throws Exception {
		HeaderChildNode("Relaunch the app");
		logger.info("Relaunching the application");
		extent.extentLogger("Relaunch", "Relaunching the application");
		waitTime(10000);
		getWebDriver().quit();
		relaunch = clearData;
		new Zee5PWAWEBMixPanelBusinessLogic("Chrome");
	}

	public void verifyQualityChangeEvent(String keyword1) throws Exception {

		extent.HeaderChildNode("Verify Quality Change Event");

		click(PWAHomePage.objSearchBtn, "Search Icon");
		type(PWASearchPage.objSearchEditBox, keyword1 + "\n", "Search Edit box: " + keyword1);
		waitTime(4000);
		verifyElementPresentAndClick(PWASearchPage.objSearchResult(keyword1), "Search Result");
		waitTime(5000);
		click(PWAPlayerPage.objPlaybackVideoOverlay, "Player");
		click(PWAPlayerPage.settingsBtn, "Setting icon");
		click(PWAPlayerPage.qualityBtn, "Quality option");
		for (int i = 1; i <= findElements(PWAQualitySettingsPage.objAllQualities).size(); i++) {
			click(PWAQualitySettingsPage.objIndividualQuality(i), "Quality option");
			click(PWAPlayerPage.settingsBtn, "Setting icon");
			click(PWAPlayerPage.qualityBtn, "Quality option");
		}
		extent.HeaderChildNode("Verify Content Bucket Swipe Event in Playback page");
		click(PWAPremiumPage.objNextArrowBtn, "Right Arrow Button");
		click(PWAPremiumPage.objLeftArrowBtn, "Left Arrow Button");
	}

	public void verifyDisplayAndContentLanguageChangeEvent() throws Exception {
		extent.HeaderChildNode("Verify Display And Content Language Change Event");
		verifyElementPresentAndClick(PWAHomePage.objLanguageBtn, "Language button");
		JSClick(PWALanguageSettingsPage.objFirstLanguage, "Hindi display language");
		JSClick(PWALanguageSettingsPage.objApplyBtn, "Apply button");
		JSClick(PWALanguageSettingsPage.objAllLangByindex(1), "Hindi content language");
		JSClick(PWALanguageSettingsPage.objApplyBtn, "Apply button");

		verifyElementPresentAndClick(PWAHomePage.objLanguageBtn, "Language button");
		JSClick(PWALanguageSettingsPage.objSecondLanguage, "English display language");
		JSClick(PWALanguageSettingsPage.objApplyBtn, "Apply button");
		JSClick(PWALanguageSettingsPage.objAllLangByindex(1), "Hindi content language");
		JSClick(PWALanguageSettingsPage.objApplyBtn, "Apply button");
	}

	public void verifyContentBucketSwipeEvent() throws Exception {
		extent.HeaderChildNode("Verify Content Bucket Swipe Event Across tabs");
		click(PWAPremiumPage.objNextArrowBtn, "Right Arrow Button");
		click(PWAPremiumPage.objPreviousArrowBtn, "Left Arrow Button");
		navigateToAnyScreenOnWeb("Shows");
		click(PWAPremiumPage.objNextArrowBtn, "Right Arrow Button");
		click(PWAPremiumPage.objPreviousArrowBtn, "Left Arrow Button");
		navigateToAnyScreenOnWeb("Movies");
		click(PWAPremiumPage.objNextArrowBtn, "Right Arrow Button");
		click(PWAPremiumPage.objPreviousArrowBtn, "Left Arrow Button");
		navigateToAnyScreenOnWeb("Premium");
		click(PWAPremiumPage.objNextArrowBtn, "Right Arrow Button");
		click(PWAPremiumPage.objPreviousArrowBtn, "Left Arrow Button");
	}

	public void verifyCarouselBannerSwipeEvent() throws Exception {
		extent.HeaderChildNode("Verify Carousel Banner Swipe Event Across tabs");
		click(PWAPremiumPage.objRightArrowBtn, "Right Arrow Button");
		click(PWAPremiumPage.objLeftArrowBtn, "Left Arrow Button");
		navigateToAnyScreenOnWeb("Shows");
		click(PWAPremiumPage.objRightArrowBtn, "Right Arrow Button");
		click(PWAPremiumPage.objLeftArrowBtn, "Left Arrow Button");
		navigateToAnyScreenOnWeb("Movies");
		click(PWAPremiumPage.objRightArrowBtn, "Right Arrow Button");
		click(PWAPremiumPage.objLeftArrowBtn, "Left Arrow Button");
		navigateToAnyScreenOnWeb("Premium");
		click(PWAPremiumPage.objRightArrowBtn, "Right Arrow Button");
		click(PWAPremiumPage.objLeftArrowBtn, "Left Arrow Button");
	}

	public void verifyAdBannerImpressionEvent() throws Exception {
		extent.HeaderChildNode("Verify Ad Banner Impression Event Across tabs");
		checkElementDisplayed(PWAHomePage.objAdBanner, "Ad Banner");
		navigateToAnyScreenOnWeb("Shows");
		waitTime(5000);
		checkElementDisplayed(PWAHomePage.objAdBanner, "Ad Banner");
		navigateToAnyScreenOnWeb("Movies");
		waitTime(5000);
		checkElementDisplayed(PWAHomePage.objAdBanner, "Ad Banner");
		navigateToAnyScreenOnWeb("Premium");
		waitTime(5000);
		checkElementDisplayed(PWAHomePage.objAdBanner, "Ad Banner");
	}

	public void verifyDefaultSettingRestoredEvent(String userType) throws Exception {
		if (!(userType.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode("Verify Default Setting Restored Event");
			click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger menu");
			click(PWAHamburgerMenuPage.objMoreSettingInHamburger, "More settings");
			click(PWAHamburgerMenuPage.objResetSettingsToDefault, "Reset Settings to Default");
			waitTime(3000);
		}
	}

	public void FilterLanguage(String lang) throws Exception {
		click(PWALiveTVPage.objFilterLanguageChannelGuide, "Filter language");
		int size = findElements(PWALiveTVPage.objSelectedlang).size();
		for (int i = 1; i <= size; i++) {
			click(PWALiveTVPage.objSelectedlang, "Selected language");
		}
		click(PWALiveTVPage.objSelectLang(lang), lang + " language");
		click(PWALiveTVPage.objApplyBtn, "Apply button");
	}

	public void verifySetReminderAndShareEventForUpcomingLiveProgram(String userType) throws Exception {

		navigateToAnyScreenOnWeb("Live TV");
		wouldYouLikeToPopupClose();
		click(PWALiveTVPage.objChannelGuideToggle, "Channel Guide");

		click(PWALiveTVPage.objTomorrowDate, "Tomorrow date");
		FilterLanguage("Bengali");

		click(PWALiveTVPage.objBanglaShow1, "Show detail");

		if (!(userType.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode("Verify Set Reminder Event");
			click(PWALiveTVPage.objRemainderButton, "Reminder option");
		}
		extent.HeaderChildNode("Verify Share Event For Upcoming Live Program");
		click(PWALiveTVPage.objUpcomingLiveProgramShareBtn, "Share button");
		waitTime(3000);
		click(PWALiveTVPage.objFacebookShareBtn, "Share to Facebook");
		waitTime(3000);
		verifyAlert();
		switchToWindow(2);
		if (!checkElementDisplayed(PWALiveTVPage.objPostToFacebookBtn, "Post to Facebook")) {
			click(PWALiveTVPage.objFacebookEmailField, "Facebook Email field");
			getWebDriver().findElement(PWALiveTVPage.objFacebookEmailField).sendKeys("igszeetest@gmail.com");
			click(PWALiveTVPage.objFacebookPasswordField, "Facebook Password field");
			getWebDriver().findElement(PWALiveTVPage.objFacebookPasswordField).sendKeys("igs@12345");
			click(PWALiveTVPage.objFacebookLoginBtn, "Facebook Login button");
			waitTime(4000);
		}
		click(PWALiveTVPage.objPostToFacebookBtn, "Post to Facebook");
		waitTime(7000);
		acceptAlert();
		waitTime(3000);
		switchToParentWindow();
		waitTime(3000);

		click(PWALiveTVPage.objUpcomingLiveProgramShareBtn, "Share button");
		Thread.sleep(2000);
		click(PWAPlayerPage.twitterShareBtn, "Twitter share option");
		Thread.sleep(2000);
		switchToWindow(2);
		Thread.sleep(2000);
		verifyAlert();
		waitTime(3000);

		if (checkElementDisplayed(PWALiveTVPage.objTwitterEmailField, "Twitter Email field")) {
			waitTime(2000);
			click(PWALiveTVPage.objTwitterEmailField, "Twitter Email field");
			getWebDriver().findElement(PWALiveTVPage.objTwitterEmailField).sendKeys("zee5latest@gmail.com");
			waitTime(2000);
			click(PWALiveTVPage.objTwitterPasswordField, "Twitter Password field");
			getWebDriver().findElement(PWALiveTVPage.objTwitterPasswordField).sendKeys("User@123");
			click(PWALiveTVPage.objTwitterLoginButton, "Twitter Login button");
			waitTime(2000);
			verifyAlert();
			waitTime(2000);
		}
		click(PWALiveTVPage.objTweetButton, "Tweet button");
		waitTime(2000);
		verifyAlert();
		switchToParentWindow();
		Thread.sleep(2000);

		if (checkElementDisplayed(PWALiveTVPage.objUpcomingLiveProgramCloseBtn, "Popup Close Button")) {
			click(PWALiveTVPage.objUpcomingLiveProgramCloseBtn, "Popup Close Button");
		}
		waitTime(3000);
	}

	public void wouldYouLikeToPopupClose() throws Exception {
		if (checkElementDisplayed(PWAPlayerPage.objWouldYouLikeClosePopup, "WouldYouLikeClosePopup") == true) {
			click(PWAPlayerPage.objWouldYouLikeClosePopup, "WouldYouLikeClosePopup");
		}
	}

	public void verifyChangePasswordStartedAndPasswordResultEvent(String userType) throws Exception {
		if (!(userType.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode("Verify Change Password Started And Change Password Result Event");
			click(PWALandingPages.objWebProfileIcon, "Profile Icon");
			click(PWAHamburgerMenuPage.objProfileIconInProfilePage, "profile icon");
			click(PWAHamburgerMenuPage.objChangePasswordBtn, "change password button");
			click(PWAHamburgerMenuPage.objChangeOldPassword, "password field");
			type(PWAHamburgerMenuPage.objChangeOldPassword, "igsindia123", "Current password field");
			click(PWAHamburgerMenuPage.objNewPassword, "new password field");
			type(PWAHamburgerMenuPage.objNewPassword, "igszee5", "new password field");
			click(PWAHamburgerMenuPage.objNewPassword, "confirm password field");
			type(PWAHamburgerMenuPage.objConfirmNewPassword, "igszee5", "Current confirm field");
			waitTime(3000);
			click(PWAHamburgerMenuPage.objUpdatePasswordBtnHighlighted, "Update password button");
			waitTime(2000);

			click(PWAHamburgerMenuPage.objChangePasswordBtn, "change password button");
			click(PWAHamburgerMenuPage.objChangeOldPassword, "password field");
			type(PWAHamburgerMenuPage.objChangeOldPassword, "igszee5", "Current password field");
			click(PWAHamburgerMenuPage.objNewPassword, "new password field");
			type(PWAHamburgerMenuPage.objNewPassword, "igsindia123", "new password field");
			click(PWAHamburgerMenuPage.objNewPassword, "confirm password field");
			type(PWAHamburgerMenuPage.objConfirmNewPassword, "igsindia123", "Current confirm field");
			waitTime(3000);
			click(PWAHamburgerMenuPage.objUpdatePasswordBtnHighlighted, "Update password button");
			waitTime(2000);
		}
	}

	public void verifyProfileUpdateResultEvent(String userType) throws Exception {
		if (!(userType.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode("Verify Profile Update Result Event");
			click(PWALandingPages.objWebProfileIcon, "Profile Icon");
			click(PWAHamburgerMenuPage.objProfileIconInProfilePage, "profile icon");
			verifyElementPresentAndClick(PWAHamburgerMenuPage.objProfileEditBtn, "Edit button");
			verifyElementPresent(PWAHamburgerMenuPage.objEditProfileTextWEB, "edit profile page");
			verifyElementPresentAndClick(PWAHamburgerMenuPage.objEditProfileFirstName, "First name column");
			clearField(PWAHamburgerMenuPage.objEditProfileFirstName, "email field");
			type(PWAHamburgerMenuPage.objEditProfileFirstName, "Zee5", "Editprofile first name");

			verifyElementPresentAndClick(PWAHamburgerMenuPage.objEditProfileSavechangesBtn, "save changes");
			waitTime(2000);
			verifyElementPresentAndClick(PWAHamburgerMenuPage.objEditProfileGoBackBtn, "go back button");
			verifyElementPresent(PWAHamburgerMenuPage.objMyAccountOptionsText("My Profile"), "My Profile page");
		}
	}

	public void verifyVideoViewAndVideoExitEvent(String userType, String keyword4, String keyword5, String keyword)
			throws Exception {
		extent.HeaderChildNode(
				"Verify Video View and Video Exit Event For Free Content/Content played from Search Page");
		click(PWAHomePage.objSearchBtn, "Search Icon");
		type(PWASearchPage.objSearchEditBox, keyword4 + "\n", "Search Edit box: " + keyword4);
		waitTime(4000);
		verifyElementPresentAndClick(PWASearchPage.objSearchResult(keyword4), "Search Result");
		waitForPlayerAdToComplete("Video Player");
		waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
		waitTime(6000);
		click(PWAPlayerPage.objPlaybackVideoOverlay, "Player");
		click(PWAPlayerPage.objPlayerPlay, "Play Icon");
		click(PWAPlayerPage.objPlayerPause, "Pause Icon");
		click(PWAPlayerPage.maximizeBtn, "Maximize icon");
		click(PWAPlayerPage.minimizeBtn, "Minimize icon");
		extent.HeaderChildNode(
				"Verify Video Watch Duration event when video is closed abruptly on playing Free Content/Content played from Search Page");
		Back(1);

		if (userType.equalsIgnoreCase("SubscribedUser")) {
			extent.HeaderChildNode("Verify Video View and Video Exit Event For Premium Content");
			// click(PWAHomePage.objSearchBtn, "Search Icon");
			type(PWASearchPage.objSearchEditBox, keyword5 + "\n", "Search Edit box: " + keyword5);
			waitTime(4000);
			verifyElementPresentAndClick(PWASearchPage.objSearchResult(keyword5), "Search Result");
			waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
			waitTime(6000);
			click(PWAPlayerPage.objPlaybackVideoOverlay, "Player");
			click(PWAPlayerPage.objPlayerPlay, "Play Icon");
			click(PWAPlayerPage.objPlayerPause, "Pause Icon");
			click(PWAPlayerPage.maximizeBtn, "Maximize icon");
			click(PWAPlayerPage.minimizeBtn, "Minimize icon");
			extent.HeaderChildNode(
					"Verify Video Watch Duration event when video is closed abruptly on playing Premium Content");
			Back(1);
		}

		if (!(userType.equalsIgnoreCase("SubscribedUser"))) {
			extent.HeaderChildNode("Verify Video View and Video Exit Event For Trailer");
			// click(PWAHomePage.objSearchBtn, "Search Icon");
			type(PWASearchPage.objSearchEditBox, keyword5 + "\n", "Search Edit box: " + keyword5);
			waitTime(4000);
			verifyElementPresentAndClick(PWASearchPage.objSearchResult(keyword5), "Search Result");
			waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
			waitTime(6000);
			click(PWAPlayerPage.objPlaybackVideoOverlay, "Player");
			click(PWAPlayerPage.objPlayerPlay, "Play Icon");
			click(PWAPlayerPage.objPlayerPause, "Pause Icon");
			click(PWAPlayerPage.maximizeBtn, "Maximize icon");
			click(PWAPlayerPage.minimizeBtn, "Minimize icon");
			waitTime(2000);
			extent.HeaderChildNode("Verify Video View event and Video Exit when page is refreshed");
			getWebDriver().navigate().refresh();
			extent.HeaderChildNode(
					"Verify Video Watch Duration event when video is closed abruptly on playing Trailer");
			Back(2);
		}
		waitTime(5000);
		Actions actions = new Actions(getWebDriver());
		WebElement contentCard = getWebDriver().findElement(PWAHomePage.objHomeBarText("Movies"));
		actions.moveToElement(contentCard).build().perform();

		click(PWAPlayerPage.megaMenuContentCard, "Content Card in Megamenu");
		// waitForPlayerAdToComplete("Video Player");
		waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
		waitTime(6000);
		click(PWAPlayerPage.objPlaybackVideoOverlay, "Player");
		click(PWAPlayerPage.objPlayerPlay, "Play Icon");
		click(PWAPlayerPage.objPlayerPause, "Pause Icon");
		click(PWAPlayerPage.maximizeBtn, "Maximize icon");
		click(PWAPlayerPage.minimizeBtn, "Minimize icon");
		waitTime(2000);
		extent.HeaderChildNode("Verify Video View event and Video Exit when page is refreshed");
		getWebDriver().navigate().refresh();
		extent.HeaderChildNode(
				"Verify Video Watch Duration event when video is closed abruptly on playing content from Megamenu");
		Back(1);

		extent.HeaderChildNode("Verify Video View and Video Exit Event For content played from Playlist");
		click(PWAHomePage.objSearchBtn, "Search Icon");
		type(PWASearchPage.objSearchEditBox, keyword + "\n", "Search Edit box: " + keyword);
		waitTime(4000);
		verifyElementPresentAndClick(PWASearchPage.objSearchResult(keyword), "Search Result");
		waitForPlayerAdToComplete("Video Player");
		click(PWAPremiumPage.objContentInPlaylist, "Content card in Playlist");
		waitTime(6000);
		click(PWAPlayerPage.objPlaybackVideoOverlay, "Player");
		click(PWAPlayerPage.objPlayerPlay, "Play Icon");
		click(PWAPlayerPage.objPlayerPause, "Pause Icon");
		click(PWAPlayerPage.maximizeBtn, "Maximize icon");
		click(PWAPlayerPage.minimizeBtn, "Minimize icon");
		extent.HeaderChildNode(
				"Verify Video Watch Duration event when video is closed abruptly on playing Free Content/Content played from Search Page");
		Back(1);
	}

	public void verifyCTAsEvent(String tabName, String userType) throws Exception {
		extent.HeaderChildNode("Verify CTAs Event");
		navigateToAnyScreenOnWeb(tabName);

		click(PWAHomePage.objSearchBtn, "Search Icon");
		Back(1);
		click(PWAHomePage.objLanguageBtn, "Language button");
		Back(1);
		if (!(userType.equalsIgnoreCase("Guest"))) {
			click(PWALandingPages.objWebProfileIcon, "Profile Icon");
			Back(1);
		}

		click(PWAHomePage.objSubscribeBtn, "Subscribe button");

		Back(1);

		click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger menu");

		click(PWAHamburgerMenuPage.objMoreSettingInHamburger, "More settings");
		Back(1);
	}

	public void verifyBannerAutoplayAndMuteChangedEventForNewsContent(String userType) throws Exception {
		extent.HeaderChildNode("Verify Banner Autoplay And Mute Changed Event");
		navigateToAnyScreenOnWeb("News");

		waitForElementDisplayed(PWANewsPage.objBannerUnMute, 20);

		if (checkElementDisplayed(PWANewsPage.objBannerUnMute, "Volume icon") == true) {
			JSClick(PWANewsPage.objBannerUnMute, "Mute Icon");
		} else {
			JSClick(PWANewsPage.objBannerMute, "UnMute Icon");
		}

	}

	public void verifyResumeEventForFreeContent(String userType, String keyword4) throws Exception {
		extent.HeaderChildNode("Verify Resume Event For Free Content");
		click(PWAHomePage.objSearchBtn, "Search Icon");
		type(PWASearchPage.objSearchEditBox, keyword4 + "\n", "Search Edit box: " + keyword4);
		waitForElement(PWASearchPage.objSearchResult(keyword4), 20, "Search Result");
		click(PWASearchPage.objSearchResult(keyword4), "Search Result");
		waitForPlayerAdToComplete("Video Player");
		waitTime(6000);
		waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
		click(PWAPlayerPage.objPlaybackVideoOverlay, "Player");
		click(PWAPlayerPage.objPlayerPause, "Pause Icon");
		waitTime(2000);
		click(PWAPlayerPage.objPlayerPlay, "Play Icon");
	}

	public void verifyResumeEventForPremiumContent(String userType, String keyword1) throws Exception {
		if (userType.equalsIgnoreCase("SubscribedUser")) {
			extent.HeaderChildNode("Verify Resume Event For Premium Content");
			click(PWAHomePage.objSearchBtn, "Search Icon");
			type(PWASearchPage.objSearchEditBox, keyword1 + "\n", "Search Edit box: " + keyword1);
			waitTime(4000);
			waitForElement(PWASearchPage.objSearchResult(keyword1), 10, "Search Result");
			click(PWASearchPage.objSearchResult(keyword1), "Search Result");
			waitTime(6000);
			waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
			click(PWAPlayerPage.objPlaybackVideoOverlay, "Player");
			click(PWAPlayerPage.objPlayerPause, "Pause Icon");
			waitTime(2000);
			click(PWAPlayerPage.objPlayerPlay, "Play Icon");
		}
	}

	public void verifyResumeEventForTrailer(String userType, String keyword1) throws Exception {
		extent.HeaderChildNode("Verify Resume Event For Trailer Content");
		click(PWAHomePage.objSearchBtn, "Search Icon");
		type(PWASearchPage.objSearchEditBox, keyword1 + "\n", "Search Edit box: " + keyword1);
		waitTime(4000);
		waitForElement(PWASearchPage.objSearchResult(keyword1), 10, "Search Result");
		click(PWASearchPage.objSearchResult(keyword1), "Search Result");
		waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
		waitTime(6000);
		click(PWAPlayerPage.objPlaybackVideoOverlay, "Player");
		click(PWAPlayerPage.objPlayerPause, "Pause Icon");
		waitTime(2000);
		click(PWAPlayerPage.objPlayerPlay, "Play Icon");
	}

	public void verifyResumeEventForCarouselContent() throws Exception {
		extent.HeaderChildNode("Verify Resume Event For Carousel Content");
		waitTime(5000);
		click(PWAPremiumPage.objWEBMastheadCarousel, "Carousel Content");
		waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
		waitTime(6000);
		click(PWAPlayerPage.objPlaybackVideoOverlay, "Player");
		click(PWAPlayerPage.objPlayerPause, "Pause Icon");
		waitTime(2000);
		click(PWAPlayerPage.objPlayerPlay, "Play Icon");
	}

	public void verifyResumeEventForContentInTray() throws Exception {
		extent.HeaderChildNode("Verify Resume Event For Content played from Tray");
		click(PWAPremiumPage.objThumbnail, "Content From a tray");
		waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
		waitTime(6000);
		click(PWAPlayerPage.objPlaybackVideoOverlay, "Player");
		click(PWAPlayerPage.objPlayerPause, "Pause Icon");
		waitTime(2000);
		click(PWAPlayerPage.objPlayerPlay, "Play Icon");
	}

	public void verifyResumeEventForContentFromSearchPage(String userType, String keyword1) throws Exception {
		extent.HeaderChildNode("Verify Resume Event For Content From Search Page");
		click(PWAHomePage.objSearchBtn, "Search Icon");
		type(PWASearchPage.objSearchEditBox, keyword1 + "\n", "Search Edit box: " + keyword1);
		waitTime(4000);
		waitForElement(PWASearchPage.objSearchResult(keyword1), 10, "Search Result");
		click(PWASearchPage.objSearchResult(keyword1), "Search Result");
		waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
		waitTime(6000);
		click(PWAPlayerPage.objPlaybackVideoOverlay, "Player");
		click(PWAPlayerPage.objPlayerPause, "Pause Icon");
		waitTime(2000);
		click(PWAPlayerPage.objPlayerPlay, "Play Icon");
	}

	public void verifyResumeEventForContentFromMyWatchlistPage(String userType, String keyword) throws Exception {
		if (!(userType.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode("Verify Resume Event For Content From My Watchlist Page");
			click(PWAHomePage.objSearchBtn, "Search Icon");
			type(PWASearchPage.objSearchEditBox, keyword + "\n", "Search Edit box: " + keyword);
			waitTime(4000);
			waitForElement(PWASearchPage.objSearchResult(keyword), 10, "Search Result");
			click(PWASearchPage.objSearchResult(keyword), "Search Result");

			Actions actions = new Actions(getWebDriver());
			WebElement contentCard = getWebDriver().findElement(PWAPremiumPage.obj1stContentInShowDetailPage);
			actions.moveToElement(contentCard).build().perform();

			verifyElementPresentAndClick(PWAPremiumPage.objContentCardWatchlistBtn, "Add to Watchlist icon");

			click(PWALandingPages.objWebProfileIcon, "Profile icon");
			click(PWAAddToWatchListPage.objMyWatchList, "My Watchlist option");

			extent.HeaderChildNode("Verify Video View and Video Exit Event for Content from My Watchlist page");
			click(PWAAddToWatchListPage.objWatchlistedItems, "Content Card in Watchlist page");
			mandatoryRegistrationPopUp(userType);
			waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
			waitTime(6000);
			click(PWAPlayerPage.objPlaybackVideoOverlay, "Player");
			click(PWAPlayerPage.objPlayerPause, "Pause Icon");
			waitTime(2000);
			click(PWAPlayerPage.objPlayerPlay, "Play Icon");
		}
	}

	public void verifyResumeEventForContentInMegamenu() throws Exception {
		extent.HeaderChildNode("Verify Resume Event For Content played from Megamenu");
		waitTime(5000);
		Actions actions = new Actions(getWebDriver());
		WebElement contentCard = getWebDriver().findElement(PWAHomePage.objHomeBarText("Movies"));
		actions.moveToElement(contentCard).build().perform();

		click(PWAPlayerPage.megaMenuContentCard, "Content Card in Megamenu");
		waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
		waitTime(6000);
		click(PWAPlayerPage.objPlaybackVideoOverlay, "Player");
		click(PWAPlayerPage.objPlayerPlay, "Play Icon");
		click(PWAPlayerPage.objPlayerPause, "Pause Icon");
	}

	public void verifyResumeEventForContentInPlaylist(String keyword, String userType) throws Exception {
		extent.HeaderChildNode("Verify Resume Event For Content played from Playlist");
		click(PWAHomePage.objSearchBtn, "Search Icon");
		type(PWASearchPage.objSearchEditBox, keyword + "\n", "Search Edit box: " + keyword);
		waitTime(4000);
		verifyElementPresentAndClick(PWASearchPage.objSearchResult(keyword), "Search Result");
		waitForPlayerAdToComplete("Video Player");
		click(PWAPremiumPage.obj1stContentInViewAllPage, "Content From a tray");
		mandatoryRegistrationPopUp(userType);
		waitTime(2000);
		click(PWAPremiumPage.objContentInPlaylist, "Content card in Playlist");
		waitTime(6000);
		click(PWAPlayerPage.objPlaybackVideoOverlay, "Player");
		click(PWAPlayerPage.objPlayerPlay, "Play Icon");
		click(PWAPlayerPage.objPlayerPause, "Pause Icon");
	}

}

package com.business.zee;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import com.driverInstance.CommandBase;
import com.extent.ExtentReporter;
import com.metadata.ResponseInstance;
import com.mixpanelValidation.Mixpanel;
import com.propertyfilereader.PropertyFileReader;
import com.utility.LoggingUtils;
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
import com.zee5.PWAPages.PWASearchPage;
import com.zee5.PWAPages.PWAShowsPage;
import com.zee5.PWAPages.PWASignupPage;
import com.zee5.PWAPages.PWASubscriptionPages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Zee5MPWAMixPanelBusinessLogic extends Utilities {

	public Zee5MPWAMixPanelBusinessLogic(String Application) throws InterruptedException {
		new CommandBase(Application);
		init();
	}

	private int timeout;

	/** Retry Count */
	private int retryCount;

	ExtentReporter extent = new ExtentReporter();

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

	Mixpanel mixpanel = new Mixpanel();

	static LoggingUtils logger = new LoggingUtils();
	
	String UserType = getParameterFromXML("userType");

	String Username;
	String Password;

	public void init() {

		PropertyFileReader handler = new PropertyFileReader("properties/Execution.properties");
		setTimeout(Integer.parseInt(handler.getproperty("TIMEOUT")));
		setRetryCount(Integer.parseInt(handler.getproperty("RETRY_COUNT")));
		logger.info(
				"Loaded the following properties" + " TimeOut :" + getTimeout() + " RetryCount :" + getRetryCount());
	}

	/**
	 * Generic function to click on the Player.
	 */

	public void playerClick(By byLocator, String validationtext) throws Exception {
		try {
			WebElement element = findElement(byLocator);
			element.click();
			logger.info("Clicked on the" + validationtext);
			extent.extentLogger("click", "Clicked on the " + " " + validationtext);
		} catch (Exception e) {
			logger.error(e);
		}
	}

	/**
	 * The method s for element and clicks if present. Returns no error if not
	 * present. Implemented for random popups
	 */
	public boolean waitForElementAndClickIfPresent(By locator, int seconds, String message)
			throws InterruptedException {
		for (int time = 0; time <= seconds; time++) {
			try {
				getDriver().findElement(locator).click();
				logger.info("Clicked element " + message);
				extent.extentLogger("clickedElement", "Clicked element " + message);
				return true;
			} catch (Exception e) {
				Thread.sleep(1000);
			}
		}
		return false;
	}

	/**
	 * Function to quit the driver
	 */
	public void tearDown() {
		getDriver().quit();
	}

	public void ZeePWALogin(String LoginMethod, String userType) throws Exception {
		String url = getParameterFromXML("url");
		extent.HeaderChildNode("User-Type : " + userType + ", Environment: " + url);
		// Get the email and password from properties
//		 dismissSystemPopUp();
		// waitTime(3000);
		// dismissSystemPopUp();
		// dismissAppInstallPopUp();
		// dismissStayTundedPopUp();
		// dismiss3xPopUp();
//		 dismissDisplayContentLanguagePopUp();
		// dismissSystemPopUp();
		dismissAllPopUps();
		if (userType.equalsIgnoreCase("Guest")) {
			extent.extentLogger("Guest", "Accessing the application as Guest user");
		} else if (userType.equalsIgnoreCase("SubscribedUser")) {
			extent.extentLogger("Subscribed", "Accessing the application as Subscribed user");
			Username = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("SubscribedUserName");
			Password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("SubscribedPassword");
		} else if (userType.equalsIgnoreCase("NonSubscribedUser")) {
			extent.extentLogger("Non-Subscribed", "Accessing the application as Non-Subscribed user");
			Username = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("NonsubscribedUserName");
			Password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("NonsubscribedPassword");
		}
		if (userType.equalsIgnoreCase("SubscribedUser") || userType.equalsIgnoreCase("NonSubscribedUser")) {
			if (!checkElementDisplayed(PWALoginPage.objLoginBtn, "Login Button")) {
				verifyElementPresentAndClick(PWAHomePage.objHamburgerMenu, "Hamburger Menu");
			}
			waitTime(3000);
			click(PWALoginPage.objLoginBtn, "Login button");
			waitTime(3000);
			HeaderChildNode("Login - Method" + LoginMethod);
			switch (LoginMethod) {

			case "E-mail":
				dismissAppInstallPopUp();
				verifyElementPresentAndClick(PWALoginPage.objEmailField, "Email field");
				waitTime(10000);
				// getDriver().getKeyboard().sendKeys("Bla bla");//works
				type(PWALoginPage.objEmailField, Username, "Email Field");
				hideKeyboard();
				waitTime(3000);
				dismissSystemPopUp();
				verifyElementPresentAndClick(PWALoginPage.objPasswordField, "Password Field");
				type(PWALoginPage.objPasswordField, Password + "\n", "Password field");
				hideKeyboard();
				waitTime(5000);
				directClickReturnBoolean(PWALoginPage.objLoginBtnLoginPage, "Login Button");
				waitTime(10000);
				break;

			case "Mobile":
				verifyElementPresentAndClick(PWALoginPage.objEmailField, "Email field");
				type(PWALoginPage.objEmailField, "8792396107\n", "Email Field");
				hideKeyboard();
				verifyElementPresentAndClick(PWALoginPage.objLoginBtn, "Login butotn");
				waitTime(3000);
				hideKeyboard();
				waitTime(5000);
				verifyElementPresentAndClick(PWALoginPage.objpasswordphno, "Password field");
				waitTime(3000);
				verifyElementPresentAndClick(PWALoginPage.objPasswordField, "password-field");
				type(PWALoginPage.objPasswordField, "tanisha19\n", "password-field");
				hideKeyboard();
				waitTime(2000);
				click(PWALoginPage.objproceedphno, "Proceed button");
				waitTime(5000);
				break;

			case "Facebook":
				extent.HeaderChildNode("Login through Facebook");
				verifyElementPresentAndClick(PWALoginPage.objFacebookIcon, "Facebook Icon");
				System.out.println(getDriver().getCurrentUrl());
				System.out.println(getDriver().getWindowHandles());
				getDriver().switchTo().window("CDwindow-1");
				waitTime(7000);
				if (verifyIsElementDisplayed(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger")) {
					click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
					verifyElementPresent(PWAHamburgerMenuPage.objProfilePageIcon, "Profile icon");
					logger.info("User Logged in Successfully");
					extent.extentLogger("Logged in", "User Logged in Successfully");
				}

				else if (verifyIsElementDisplayed(PWALoginPage.objFacebookPageVerification, "Facebook page")) {
					verifyElementPresent(PWALoginPage.objFacebookPageVerification, "Facebook page");
					verifyElementPresent(PWALoginPage.objFacebookLoginEmail, " Email Field");
					type(PWALoginPage.objFacebookLoginEmail, "igszeetesttest@gmail.com", "Emial Field");
					verifyElementPresent(PWALoginPage.objFacebookLoginpassword, " Password Field");
					type(PWALoginPage.objFacebookLoginpassword, "Igs$123Zee\n", "Password Field");
					verifyElementPresentAndClick(PWALoginPage.objFacebookLoginButtonInFbPage, " Login Button");
					waitTime(9000);
					getDriver().switchTo().window("CDwindow-0");
					verifyIsElementDisplayed(PWALoginPage.objFbCountinueBtn, "Continue button");
					if (verifyIsElementDisplayed(PWASignupPage.objSignUpTxt, "SignUp")) {
						regestrationfromSocialMedia();
						verifyElementPresent(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						verifyElementPresent(PWAHamburgerMenuPage.objProfilePageIcon, "Profile icon");
						logger.info("User Logged in Successfully");
						extent.extentLogger("Logged in", "User Logged in Successfully");
					} else {
						waitTime(3000);
						verifyElementPresent(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						verifyElementPresent(PWAHamburgerMenuPage.objProfileIcon, "Profile icon");
						logger.info("User Logged in Successfully");
						extent.extentLogger("Logged in", "User Logged in Successfully");
					}

				} else if (verifyElementPresent(PWALoginPage.objFbCountinueBtn, "Continue button") == true) {
					click(PWALoginPage.objFbCountinueBtn, "Continue fb");
					if (verifyElementPresent(PWASignupPage.objSignUpTxt, "SignUp") == true) {
						regestrationfromSocialMedia();
						verifyElementPresent(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						verifyElementPresent(PWAHamburgerMenuPage.objProfilePageIcon, "Profile icon");
						logger.info("User Logged in Successfully");
						extent.extentLogger("Logged in", "User Logged in Successfully");
					} else {
						waitTime(7000);
						verifyElementPresent(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						verifyElementPresent(PWAHamburgerMenuPage.objProfilePageIcon, "Profile icon");
						logger.info("User Logged in Successfully");
						extent.extentLogger("Logged in", "User Logged in Successfully");
					}
				}

				break;

			case "Gmail":
				extent.HeaderChildNode("Login through Gmail");
				System.out.println(getDriver().getCurrentUrl());
				System.out.println(getDriver().getWindowHandles());
				verifyElementPresentAndClick(PWALoginPage.objGoogleIcon, "Google Icon");
				getDriver().switchTo().window("CDwindow-1");
				waitTime(4000);
				if (verifyIsElementDisplayed(PWALoginPage.objGmailEmailField, " Email Field")) {
					type(PWALoginPage.objGmailEmailField, "Zee5latest@gmail.com", "Emial Field");
					hideKeyboard();
					verifyElementPresentAndClick(PWALoginPage.objGmailNextButton, "clicked on next button");
					waitTime(3000);
					verifyElementPresent(PWALoginPage.objGmailPasswordField, " Password Field");
					type(PWALoginPage.objGmailPasswordField, "User@123\n", "Password Field");
					hideKeyboard();
					verifyElementPresentAndClick(PWALoginPage.objGmailNextButton, "clicked on next button");
					waitTime(5000);
					getDriver().switchTo().window("CDwindow-0");
					if (verifyIsElementDisplayed(PWASignupPage.objSignUpTxt, "signup")) {
						regestrationfromSocialMedia();
					}
					waitTime(5000);
					verifyElementPresent(PWAHomePage.objZeeLogo, "Zee logo");
					logger.info("User is Logged in successfully");
					extent.extentLogger("Logged in", "User is Logged in successfully");
				} else {
					waitTime(10000);
					verifyElementPresent(PWAHomePage.objZeeLogo, "Zee logo");
					logger.info("User is Logged in successfully");
					extent.extentLogger("Logged in", "User is Logged in successfully");
				}

				break;

			case "Twitter":
				extent.HeaderChildNode("Login through Twitter");
				verifyElementPresentAndClick(PWALoginPage.objTwitterIcon, "Twitter icon");
				waitTime(7000);
				System.out.println(getDriver().getWindowHandles());
				System.out.println(getDriver().getCurrentUrl());
				getDriver().switchTo().window("CDwindow-1");

				waitTime(5000);
				System.out.println(getDriver().getCurrentUrl());

				if (verifyIsElementDisplayed(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger")) {
					verifyElementPresentAndClick(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
					verifyElementPresent(PWAHamburgerMenuPage.objProfilePageIcon, "Profile icon");
					logger.info("User Logged in Successfully");
					extent.extentLogger("Logged in", "User Logged in Successfully");
				}

				else if (verifyIsElementDisplayed(PWALoginPage.objTwitterAuthorizeButton, "Authorize app")) {
					click(PWALoginPage.objTwitterAuthorizeButton, "Authorize app");
					regestrationfromSocialMedia();
				} else if (verifyIsElementDisplayed(PWALoginPage.objTwitterEmaildField, "Twitter Email field")) {

					type(PWALoginPage.objTwitterEmaildField, "Zee5latest@gmail.com", "Email Field");
					hideKeyboard();
					verifyElementPresentAndClick(PWALoginPage.objTwitterPasswordField, "Twitter Password field");
					type(PWALoginPage.objTwitterPasswordField, "User@123\n", "Password field");
					click(PWALoginPage.objTwitterSignInButton, "Sign in button");
					waitTime(5000);
					verifyElementPresentAndClick(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
					click(PWAHamburgerMenuPage.objLoginBtn, "Login");
					verifyElementPresentAndClick(PWALoginPage.objTwitterIcon, "Twitter icon");
				}

				if (verifyIsElementDisplayed(PWALoginPage.objTwitterAuthorizeButton, "Authorize")) {
					click(PWALoginPage.objTwitterAuthorizeButton, "Authorize");
					waitTime(7000);
					verifyElementPresentAndClick(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
					verifyElementPresent(PWAHamburgerMenuPage.objProfilePageIcon, "Profile icon");
					logger.info("User Logged in Successfully");
					extent.extentLogger("Logged in", "User Logged in Successfully");
				}
				break;
			}
		}
		dismiss3xPopUp();
		dismissAppInstallPopUp();
	}

	public void dismiss3xPopUp() throws Exception {
		String url = getParameterFromXML("url");
		if (!url.contains("newpwa")) {
			getDriver().context("NATIVE_APP");
			waitTime(3000);
			directClickReturnBoolean(PWAHomePage.obj3xfasterPopUpNoThanks, "NO THANKS in 3x Pop Up");
			getDriver().context("CHROMIUM");
		}
	}

	public void dismissAppInstallPopUp() throws Exception {
		directClickReturnBoolean(PWAHomePage.objAppInstallPopUpClose, "Close in App Install Pop Up");
	}

	public void dismissStayTundedPopUp() throws Exception {
		directClickReturnBoolean(PWAHomePage.objStayTunedPopUpClose, "Close in Stay Tuned Pop Up");
	}

	public boolean directClickReturnBoolean(By byLocator, String validationtext) throws Exception {
		try {
			WebElement element = (new WebDriverWait(getDriver(), 1))
					.until(ExpectedConditions.presenceOfElementLocated(byLocator));
			if (element.isDisplayed() == true) {
				element.click();
				logger.info("Clicked on " + validationtext);
				extent.extentLogger("click", "Clicked on " + validationtext);
				element = null;
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}

	public void dismissSystemPopUp() throws Exception {
		getDriver().context("NATIVE_APP");
		directClickReturnBoolean(PWASearchPage.objallow, "Allow in pop up");
		getDriver().context("CHROMIUM");
	}

	public void dismissAllPopUps() throws Exception {
		for (int trial = 0; trial < 8; trial++) {
			if (directClickReturnBoolean(PWAHomePage.objAppInstallPopUpClose, "Close in App Install Pop Up"))
				break;
			waitTime(5000);
		}
		for (int trial = 0; trial < 2; trial++) {
			try {
				waitTime(5000);
				getDriver().context("NATIVE_APP");
				directClickReturnBoolean(PWASearchPage.objallow, "Allow in pop up");
				getDriver().context("CHROMIUM");
				directClickReturnBoolean(PWAHomePage.objAppInstallPopUpClose, "Close in App Install Pop Up");
				directClickReturnBoolean(PWAHomePage.objStayTunedPopUpClose, "Close in Stay Tuned Pop Up");
				WebElement displayContentLang = (new WebDriverWait(getDriver(), 60))
						.until(ExpectedConditions.elementToBeClickable(PWAHomePage.objContinueDisplayContentLangPopup));
				if (displayContentLang.isDisplayed() == true) {
					if (directClickReturnBoolean(PWAHomePage.objContinueDisplayContentLangPopup,
							"Continue on Display Language Pop Up")) {
						dismissSystemPopUp();
						waitTime(3000);
						directClickReturnBoolean(PWAHomePage.objContinueDisplayContentLangPopup,
								"Continue on Content Language Pop Up");
						break;
					}
				}
			} catch (Exception e) {
			}
		}
	}

	public void regestrationfromSocialMedia() throws Exception {
		extent.HeaderChildNode("Regestration Screen");
		click(PWASignupPage.objDayPickerTab, "Day Tab");
		verifyElementPresentAndClick(PWASignupPage.objDayPickerTabValue, "Day option");
		verifyElementPresentAndClick(PWASignupPage.objMonthPickerTab, "Month Tab");
		verifyElementPresentAndClick(PWASignupPage.objMonthPickerTabValue, "Month option");
		verifyElementPresentAndClick(PWASignupPage.objYearPickerTab, "year Tab");
		verifyElementPresentAndClick(PWASignupPage.objYearPickerTabValue, "year option");
		verifyElementPresentAndClick(PWASignupPage.objGenderMaleBtn, "Gender tab");
		verifyElementPresentAndClick(PWALoginPage.objSignUpBtn, "signUp button");
		waitTime(10000);
		verifyElementPresent(PWAHomePage.objZeeLogo, "Zee logo");
		logger.info("User Logged in Successfully");
		extent.extentLogger("Logged in", "User Logged in Successfully");
	}

	@SuppressWarnings("static-access")
	public void verifyLoginScreenDisplayEventByClickingOnLoginButton(String userType) throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("Verify Skip Login Event");
			waitTime(5000);
			click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
			waitTime(3000);
			click(PWALoginPage.objLoginBtn, "Login button");

			waitTime(5000);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			String token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			System.out.println(token);

			mixpanel.FEProp.setProperty("Source", "home");
			mixpanel.FEProp.setProperty("Page Name", "sign_in");
			mixpanel.ValidateParameter(token, "Login Screen Display");
		}
	}

	@SuppressWarnings("static-access")
	public void verifyLoginScreenDisplayEventByClickingOnLoginButtonOnPlayer(String userType, String keyword2)
			throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("Verify Login Screen Display Event By Clicking On Login Button On Player");

			click(PWAHomePage.objSearchBtn, "Search Icon");
			type(PWAHomePage.objSearchField, keyword2, "Search");
			waitTime(5000);
			click(PWASearchPage.objSearchedResult(keyword2), "Search Result");
			waitTime(6000);

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
			waitTime(3000);

			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			String token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			System.out.println(token);

			mixpanel.FEProp.setProperty("Source", "movie_detail");
			mixpanel.FEProp.setProperty("Page Name", "sign_in");
			mixpanel.ValidateParameter(token, "Login Screen Display");
		}
	}

	@SuppressWarnings("static-access")
	public void verifyLoginScreenDisplayEventByClickingOnLoginButtonInRegistartionScreen(String userType)
			throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode(
					"Verify Login Screen Display Event By Clicking On Login Button In Registartion Screen");
			click(PWALoginPage.objSignUpBtnWEB, "Sign Up For Free");
			JSClick(PWALoginPage.objLoginLink, "Login link");
			Back(1);
			waitTime(2000);

			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			String token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			System.out.println(token);

			mixpanel.FEProp.setProperty("Source", "home");
			mixpanel.FEProp.setProperty("Page Name", "sign_in");
			mixpanel.ValidateParameter(token, "Login Screen Display");
		}
	}

	@SuppressWarnings("static-access")
	public void verifyLoginScreenDisplayEventByClickingOnLoginButtonInGetPremiumPopUp(String userType, String keyword2)
			throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode(
					"Verify Login Screen Display Event By Clicking On Login Button In Get Premium Pop Up");

			click(PWAHomePage.objSearchBtn, "Search Icon");
			type(PWAHomePage.objSearchField, keyword2, "Search");
			waitTime(5000);
			click(PWASearchPage.objSearchedResult(keyword2), "Search Result");
			waitTime(6000);

			if (checkElementDisplayed(PWAHamburgerMenuPage.objGetPremiumPopup, "GET PREMIUM POPUP") == true) {
				verifyElementPresentAndClick(PWALoginPage.objLoginCTAInPremiumPopup, "Login link");
				Back(1);
			}
			waitTime(2000);

			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			String token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			System.out.println(token);

			mixpanel.FEProp.setProperty("Source", "movie_detail");
			mixpanel.FEProp.setProperty("Page Name", "sign_in");
			mixpanel.ValidateParameter(token, "Login Screen Display");
		}
	}

	public void verifyLoginScreenDisplayEventByClickingOnLoginInRegistrationPopUp(String userType, String keyword)
			throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {

			extent.HeaderChildNode(
					"Verify Login Screen Display Event during content playback post clicking on login in registration popup");
			click(PWAHomePage.objSearchBtn, "Search Icon");
			type(PWASearchPage.objSearchEditBox, keyword + "\n", "Search Edit box: " + keyword);
			waitTime(4000);
			waitForElement(PWASearchPage.objSearchResult(keyword), 10, "Search Result");
			click(PWASearchPage.objSearchResult(keyword), "Search Result");
			click(PWAPremiumPage.obj1stContentInShowDetailPage, "Content Card");
			waitForElement(PWALoginPage.objLoginLink, 20, "Login Link");
			click(PWALoginPage.objLoginLink, "Login Link");
			waitTime(5000);

			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			String token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			System.out.println(token);

			mixpanel.FEProp.setProperty("Source", "show_detail");
			mixpanel.FEProp.setProperty("Page Name", "sign_in");
			mixpanel.ValidateParameter(token, "Login Screen Display");
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
				getDriver().findElement(locator);
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
		click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger menu");
		waitTime(2000);
		click(PWAHamburgerMenuPage.objDownArrow("My Account"), "Expander button");
		PartialSwipe("UP", 1);
		click(PWAHamburgerMenuPage.objExploreItemBtn("Logout"), "Logout option");
		waitTime(3000);
	}

	public void verifyLogoutEvent(String userType) throws Exception {
		if (!(userType.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode("Verify Logout Event");
			waitTime(10000);

			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
			System.out.println(ID);
			mixpanel.FEProp.setProperty("Element", "LOGOUT");
			mixpanel.FEProp.setProperty("Page Name", "home");

			logout();
			waitTime(5000);
			mixpanel.ValidateParameter(ID, "Logout");
		}
	}

	public void login(String LoginMethod, String userType) throws Exception {
		String url = getParameterFromXML("url");
		extent.HeaderChildNode("User-Type : " + userType + ", Environment: " + url);
		// Get the email and password from properties
		String email = "";
		String password = "";
		// dismissSystemPopUp();
		// waitTime(3000);
		// dismissSystemPopUp();
		// dismissAppInstallPopUp();
		// dismissStayTundedPopUp();
		// dismiss3xPopUp();
		// dismissDisplayContentLanguagePopUp();
		// dismissSystemPopUp();
		dismissAllPopUps();
		if (userType.equalsIgnoreCase("Guest")) {
			extent.extentLogger("Guest", "Accessing the application as Guest user");
		} else if (userType.equalsIgnoreCase("SubscribedUser")) {
			extent.extentLogger("Subscribed", "Accessing the application as Subscribed user");
			email = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("SubscribedUserName");
			password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("SubscribedPassword");
		} else if (userType.equalsIgnoreCase("NonSubscribedUser")) {
			extent.extentLogger("Non-Subscribed", "Accessing the application as Non-Subscribed user");
			email = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("NonsubscribedUserName");
			password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("NonsubscribedPassword");
		}
		if (userType.equalsIgnoreCase("SubscribedUser") || userType.equalsIgnoreCase("NonSubscribedUser")) {
			if (!checkElementDisplayed(PWALoginPage.objLoginBtn, "Login Button")) {
				verifyElementPresentAndClick(PWAHomePage.objHamburgerMenu, "Hamburger Menu");
			}
			waitTime(3000);
			click(PWALoginPage.objLoginBtn, "Login button");
			waitTime(3000);
			HeaderChildNode("Login - Method" + LoginMethod);
			switch (LoginMethod) {

			case "E-mail":
				dismissAppInstallPopUp();
				verifyElementPresentAndClick(PWALoginPage.objEmailField, "Email field");
				waitTime(10000);
				// getDriver().getKeyboard().sendKeys("Bla bla");//works
				type(PWALoginPage.objEmailField, email, "Email Field");
				hideKeyboard();
				waitTime(3000);
				dismissSystemPopUp();
				verifyElementPresentAndClick(PWALoginPage.objPasswordField, "Password Field");
				type(PWALoginPage.objPasswordField, password + "\n", "Password field");
				hideKeyboard();
				waitTime(5000);
				directClickReturnBoolean(PWALoginPage.objLoginBtnLoginPage, "Login Button");
				waitTime(10000);
				break;

			case "Mobile":
				verifyElementPresentAndClick(PWALoginPage.objEmailField, "Email field");
				type(PWALoginPage.objEmailField, "8792396107\n", "Email Field");
				hideKeyboard();
				verifyElementPresentAndClick(PWALoginPage.objLoginBtn, "Login butotn");
				waitTime(3000);
				hideKeyboard();
				waitTime(5000);
				verifyElementPresentAndClick(PWALoginPage.objpasswordphno, "Password field");
				waitTime(3000);
				verifyElementPresentAndClick(PWALoginPage.objPasswordField, "password-field");
				type(PWALoginPage.objPasswordField, "tanisha19\n", "password-field");
				hideKeyboard();
				waitTime(2000);
				click(PWALoginPage.objproceedphno, "Proceed button");
				waitTime(5000);
				break;

			case "Facebook":
				extent.HeaderChildNode("Login through Facebook");
				verifyElementPresentAndClick(PWALoginPage.objFacebookIcon, "Facebook Icon");
				System.out.println(getDriver().getCurrentUrl());
				System.out.println(getDriver().getWindowHandles());
				getDriver().switchTo().window("CDwindow-1");
				waitTime(7000);
				if (verifyIsElementDisplayed(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger")) {
					click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
					verifyElementPresent(PWAHamburgerMenuPage.objProfilePageIcon, "Profile icon");
					logger.info("User Logged in Successfully");
					extent.extentLogger("Logged in", "User Logged in Successfully");
				}

				else if (verifyIsElementDisplayed(PWALoginPage.objFacebookPageVerification, "Facebook page")) {
					verifyElementPresent(PWALoginPage.objFacebookPageVerification, "Facebook page");
					verifyElementPresent(PWALoginPage.objFacebookLoginEmail, " Email Field");
					type(PWALoginPage.objFacebookLoginEmail, "igszeetesttest@gmail.com", "Emial Field");
					verifyElementPresent(PWALoginPage.objFacebookLoginpassword, " Password Field");
					type(PWALoginPage.objFacebookLoginpassword, "Igs$123Zee\n", "Password Field");
					verifyElementPresentAndClick(PWALoginPage.objFacebookLoginButtonInFbPage, " Login Button");
					waitTime(9000);
					getDriver().switchTo().window("CDwindow-0");
					verifyIsElementDisplayed(PWALoginPage.objFbCountinueBtn, "Continue button");
					if (verifyIsElementDisplayed(PWASignupPage.objSignUpTxt, "SignUp")) {
						regestrationfromSocialMedia();
						verifyElementPresent(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						verifyElementPresent(PWAHamburgerMenuPage.objProfilePageIcon, "Profile icon");
						logger.info("User Logged in Successfully");
						extent.extentLogger("Logged in", "User Logged in Successfully");
					} else {
						waitTime(3000);
						verifyElementPresent(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						verifyElementPresent(PWAHamburgerMenuPage.objProfileIcon, "Profile icon");
						logger.info("User Logged in Successfully");
						extent.extentLogger("Logged in", "User Logged in Successfully");
					}

				} else if (verifyElementPresent(PWALoginPage.objFbCountinueBtn, "Continue button") == true) {
					click(PWALoginPage.objFbCountinueBtn, "Continue fb");
					if (verifyElementPresent(PWASignupPage.objSignUpTxt, "SignUp") == true) {
						regestrationfromSocialMedia();
						verifyElementPresent(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						verifyElementPresent(PWAHamburgerMenuPage.objProfilePageIcon, "Profile icon");
						logger.info("User Logged in Successfully");
						extent.extentLogger("Logged in", "User Logged in Successfully");
					} else {
						waitTime(7000);
						verifyElementPresent(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						verifyElementPresent(PWAHamburgerMenuPage.objProfilePageIcon, "Profile icon");
						logger.info("User Logged in Successfully");
						extent.extentLogger("Logged in", "User Logged in Successfully");
					}
				}

				break;

			case "Twitter":
				extent.HeaderChildNode("Login through Twitter");
				verifyElementPresentAndClick(PWALoginPage.objTwitterIcon, "Twitter icon");
				waitTime(7000);
				System.out.println(getDriver().getWindowHandles());
				System.out.println(getDriver().getCurrentUrl());
				getDriver().switchTo().window("CDwindow-1");

				waitTime(5000);
				System.out.println(getDriver().getCurrentUrl());

				if (verifyIsElementDisplayed(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger")) {
					verifyElementPresentAndClick(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
					verifyElementPresent(PWAHamburgerMenuPage.objProfilePageIcon, "Profile icon");
					logger.info("User Logged in Successfully");
					extent.extentLogger("Logged in", "User Logged in Successfully");
				}

				else if (verifyIsElementDisplayed(PWALoginPage.objTwitterAuthorizeButton, "Authorize app")) {
					click(PWALoginPage.objTwitterAuthorizeButton, "Authorize app");
					regestrationfromSocialMedia();
				} else if (verifyIsElementDisplayed(PWALoginPage.objTwitterEmaildField, "Twitter Email field")) {

					type(PWALoginPage.objTwitterEmaildField, "Zee5latest@gmail.com", "Email Field");
					hideKeyboard();
					verifyElementPresentAndClick(PWALoginPage.objTwitterPasswordField, "Twitter Password field");
					type(PWALoginPage.objTwitterPasswordField, "User@123\n", "Password field");
					click(PWALoginPage.objTwitterSignInButton, "Sign in button");
					waitTime(5000);
					verifyElementPresentAndClick(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
					click(PWAHamburgerMenuPage.objLoginBtn, "Login");
					verifyElementPresentAndClick(PWALoginPage.objTwitterIcon, "Twitter icon");
				}

				if (verifyIsElementDisplayed(PWALoginPage.objTwitterAuthorizeButton, "Authorize")) {
					click(PWALoginPage.objTwitterAuthorizeButton, "Authorize");
					waitTime(7000);
					verifyElementPresentAndClick(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
					verifyElementPresent(PWAHamburgerMenuPage.objProfilePageIcon, "Profile icon");
					logger.info("User Logged in Successfully");
					extent.extentLogger("Logged in", "User Logged in Successfully");
				}
				break;
			}
		}
		dismiss3xPopUp();
		dismissAppInstallPopUp();
	}

	public void verifyLoginInitiatedEventForValidCredentials(String userType, String loginMethod) throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("Verify Login Initiated Event for Valid Credentials");
			login(userType, loginMethod);
			mixpanel.FEProp.setProperty("Source", "home");
			mixpanel.FEProp.setProperty("Page Name", "sign_in");
			String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			mixpanel.ValidateParameter(gToken, "Login Initiated");
		}
	}

	public void verifyLoginResultEventForValidCredentials(String userType, String loginMethod) throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("Verify Login Result Event for Valid Credentials");
			login(userType, loginMethod);
			mixpanel.FEProp.setProperty("Source", "home");
			mixpanel.FEProp.setProperty("Page Name", "sign_in");
			String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			mixpanel.ValidateParameter(gToken, "Login Result");
		}
	}

	public void verifyLoginInitiatedEventForInvalidCredentials(String userType, String loginMethod) throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("Verify Login Initiated Event post entering invalid credentials");

			String url = getParameterFromXML("url");
			extent.HeaderChildNode("User-Type : " + userType + ", Environment: " + url);
			// Get the email and password from properties
			String email = "";
			String password = "";
			// dismissSystemPopUp();
			// waitTime(3000);
			// dismissSystemPopUp();
			// dismissAppInstallPopUp();
			// dismissStayTundedPopUp();
			// dismiss3xPopUp();
			// dismissDisplayContentLanguagePopUp();
			// dismissSystemPopUp();
			dismissAllPopUps();
			if (userType.equalsIgnoreCase("Guest")) {
				extent.extentLogger("Guest", "Accessing the application as Guest user");
			} else if (userType.equalsIgnoreCase("SubscribedUser")) {
				extent.extentLogger("Subscribed", "Accessing the application as Subscribed user");
				email = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("SubscribedUserName");
				password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("SubscribedPassword");
			} else if (userType.equalsIgnoreCase("NonSubscribedUser")) {
				extent.extentLogger("Non-Subscribed", "Accessing the application as Non-Subscribed user");
				email = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("NonsubscribedUserName");
				password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("NonsubscribedPassword");
			}
			if (userType.equalsIgnoreCase("SubscribedUser") || userType.equalsIgnoreCase("NonSubscribedUser")) {
				if (!checkElementDisplayed(PWALoginPage.objLoginBtn, "Login Button")) {
					verifyElementPresentAndClick(PWAHomePage.objHamburgerMenu, "Hamburger Menu");
				}
				waitTime(3000);
				click(PWALoginPage.objLoginBtn, "Login button");
				waitTime(3000);
				HeaderChildNode("Login - Method" + loginMethod);
				switch (loginMethod) {

				case "E-mail":
					dismissAppInstallPopUp();
					verifyElementPresentAndClick(PWALoginPage.objEmailField, "Email field");
					waitTime(10000);
					// getDriver().getKeyboard().sendKeys("Bla bla");//works
					type(PWALoginPage.objEmailField, email, "Email Field");
					hideKeyboard();
					waitTime(3000);
					dismissSystemPopUp();
					verifyElementPresentAndClick(PWALoginPage.objPasswordField, "Password Field");
					type(PWALoginPage.objPasswordField, "vhgvgv" + "\n", "Password field");
					hideKeyboard();
					waitTime(5000);
					directClickReturnBoolean(PWALoginPage.objLoginBtnLoginPage, "Login Button");
					waitTime(10000);
					break;

				case "Mobile":
					verifyElementPresentAndClick(PWALoginPage.objEmailField, "Email field");
					type(PWALoginPage.objEmailField, "8792396107\n", "Email Field");
					hideKeyboard();
					verifyElementPresentAndClick(PWALoginPage.objLoginBtn, "Login butotn");
					waitTime(3000);
					hideKeyboard();
					waitTime(5000);
					verifyElementPresentAndClick(PWALoginPage.objpasswordphno, "Password field");
					waitTime(3000);
					verifyElementPresentAndClick(PWALoginPage.objPasswordField, "password-field");
					type(PWALoginPage.objPasswordField, "bhvb4223\n", "password-field");
					hideKeyboard();
					waitTime(2000);
					click(PWALoginPage.objproceedphno, "Proceed button");
					waitTime(5000);
					break;

				}
				
				mixpanel.FEProp.setProperty("Source", "home");
				mixpanel.FEProp.setProperty("Page Name", "sign_in");

				String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
				mixpanel.ValidateParameter(gToken, "Login Initiated");
				
			}
		}
	}

	public void verifyLoginResultEventForInvalidCredentials(String userType, String loginMethod) throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("Verify Login Result Event post entering invalid credentials");

			String url = getParameterFromXML("url");
			extent.HeaderChildNode("User-Type : " + userType + ", Environment: " + url);
			// Get the email and password from properties
			String email = "";
			String password = "";
			// dismissSystemPopUp();
			// waitTime(3000);
			// dismissSystemPopUp();
			// dismissAppInstallPopUp();
			// dismissStayTundedPopUp();
			// dismiss3xPopUp();
			// dismissDisplayContentLanguagePopUp();
			// dismissSystemPopUp();
			dismissAllPopUps();
			if (userType.equalsIgnoreCase("Guest")) {
				extent.extentLogger("Guest", "Accessing the application as Guest user");
			} else if (userType.equalsIgnoreCase("SubscribedUser")) {
				extent.extentLogger("Subscribed", "Accessing the application as Subscribed user");
				email = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("SubscribedUserName");
				password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("SubscribedPassword");
			} else if (userType.equalsIgnoreCase("NonSubscribedUser")) {
				extent.extentLogger("Non-Subscribed", "Accessing the application as Non-Subscribed user");
				email = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("NonsubscribedUserName");
				password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("NonsubscribedPassword");
			}
			if (userType.equalsIgnoreCase("SubscribedUser") || userType.equalsIgnoreCase("NonSubscribedUser")) {
				if (!checkElementDisplayed(PWALoginPage.objLoginBtn, "Login Button")) {
					verifyElementPresentAndClick(PWAHomePage.objHamburgerMenu, "Hamburger Menu");
				}
				waitTime(3000);
				click(PWALoginPage.objLoginBtn, "Login button");
				waitTime(3000);
				HeaderChildNode("Login - Method" + loginMethod);
				switch (loginMethod) {

				case "E-mail":
					dismissAppInstallPopUp();
					verifyElementPresentAndClick(PWALoginPage.objEmailField, "Email field");
					waitTime(10000);
					type(PWALoginPage.objEmailField, email, "Email Field");
					hideKeyboard();
					waitTime(3000);
					dismissSystemPopUp();
					verifyElementPresentAndClick(PWALoginPage.objPasswordField, "Password Field");
					type(PWALoginPage.objPasswordField, "bhjvjbm" + "\n", "Password field");
					hideKeyboard();
					waitTime(5000);
					directClickReturnBoolean(PWALoginPage.objLoginBtnLoginPage, "Login Button");
					waitTime(10000);
					break;

				case "Mobile":
					verifyElementPresentAndClick(PWALoginPage.objEmailField, "Email field");
					type(PWALoginPage.objEmailField, "8792396107\n", "Email Field");
					hideKeyboard();
					verifyElementPresentAndClick(PWALoginPage.objLoginBtn, "Login butotn");
					waitTime(3000);
					hideKeyboard();
					waitTime(5000);
					verifyElementPresentAndClick(PWALoginPage.objpasswordphno, "Password field");
					waitTime(3000);
					verifyElementPresentAndClick(PWALoginPage.objPasswordField, "password-field");
					type(PWALoginPage.objPasswordField, "hbjh211\n", "password-field");
					hideKeyboard();
					waitTime(2000);
					click(PWALoginPage.objproceedphno, "Proceed button");
					waitTime(5000);
					break;

				}
				
				mixpanel.FEProp.setProperty("Source", "home");
				mixpanel.FEProp.setProperty("Page Name", "sign_in");

				String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
				mixpanel.ValidateParameter(gToken, "Login Result");
				
			}
		}
	}

	public void verifyTVAuthenticationScreenDisplayEvent(String userType) throws Exception {
		if (!(userType.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode("Verify TV Authentication Screen Display Event");
			click(PWAHomePage.objHamburgerMenu, "Hamburger Menu");
			waitTime(3000);
			click(PWAHamburgerMenuPage.objAuthenticationOption, "Authenticate Device");

			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
			System.out.println(ID);
			mixpanel.FEProp.setProperty("Source", "home");
			mixpanel.FEProp.setProperty("Page Name", "device_authentication");
			mixpanel.FEProp.setProperty("element", "Authenticate Device");
			mixpanel.ValidateParameter(ID, "TV Authentication Screen Display");

		}
	}

	public void verifySessionEvent(String LoginMethod, String userType) throws Exception {
		String url = getParameterFromXML("url");
		extent.HeaderChildNode("User Session event");
		String email = "";
		String password = "";
		dismissAllPopUps();
		if (userType.equalsIgnoreCase("Guest")) {
			extent.extentLogger("Guest", "Accessing the application as Guest user");
		} else if (userType.equalsIgnoreCase("SubscribedUser")) {
			extent.extentLogger("Subscribed", "Accessing the application as Subscribed user");
			email = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("SubscribedUserName");
			password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("SubscribedPassword");
		} else if (userType.equalsIgnoreCase("NonSubscribedUser")) {
			extent.extentLogger("Non-Subscribed", "Accessing the application as Non-Subscribed user");
			email = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("NonSubscribedUserName");
			password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("NonSubscribedPassword");
		}
		if (userType.equalsIgnoreCase("SubscribedUser") || userType.equalsIgnoreCase("NonSubscribedUser")) {
			if (!checkElementDisplayed(PWALoginPage.objLoginBtn, "Login Button")) {
				verifyElementPresentAndClick(PWAHomePage.objHamburgerMenu, "Hamburger Menu");
			}
			waitTime(3000);
			click(PWALoginPage.objLoginBtn, "Login button");
			waitTime(3000);
			HeaderChildNode("Login - Method" + LoginMethod);
			switch (LoginMethod) {

			case "E-mail":
				dismissAppInstallPopUp();
				verifyElementPresentAndClick(PWALoginPage.objEmailField, "Email field");
				waitTime(10000);
				// getDriver().getKeyboard().sendKeys("Bla bla");//works
				type(PWALoginPage.objEmailField, email, "Email Field");
				hideKeyboard();
				waitTime(3000);
				dismissSystemPopUp();
				verifyElementPresentAndClick(PWALoginPage.objPasswordField, "Password Field");
				type(PWALoginPage.objPasswordField, password + "\n", "Password field");
				hideKeyboard();
				waitTime(5000);
				directClickReturnBoolean(PWALoginPage.objLoginBtnLoginPage, "Login Button");
				waitTime(10000);
				break;

			case "Mobile":
				verifyElementPresentAndClick(PWALoginPage.objEmailField, "Email field");
				type(PWALoginPage.objEmailField, "8792396107\n", "Email Field");
				hideKeyboard();
				verifyElementPresentAndClick(PWALoginPage.objLoginBtn, "Login butotn");
				waitTime(3000);
				hideKeyboard();
				waitTime(5000);
				verifyElementPresentAndClick(PWALoginPage.objpasswordphno, "Password field");
				waitTime(3000);
				verifyElementPresentAndClick(PWALoginPage.objPasswordField, "password-field");
				type(PWALoginPage.objPasswordField, "tanisha19\n", "password-field");
				hideKeyboard();
				waitTime(2000);
				click(PWALoginPage.objproceedphno, "Proceed button");
				waitTime(5000);
				break;

			case "Facebook":
				extent.HeaderChildNode("Login through Facebook");
				verifyElementPresentAndClick(PWALoginPage.objFacebookIcon, "Facebook Icon");
				System.out.println(getDriver().getCurrentUrl());
				System.out.println(getDriver().getWindowHandles());
				getDriver().switchTo().window("CDwindow-1");
				waitTime(7000);
				if (verifyIsElementDisplayed(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger")) {
					click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
					verifyElementPresent(PWAHamburgerMenuPage.objProfilePageIcon, "Profile icon");
					logger.info("User Logged in Successfully");
					extent.extentLogger("Logged in", "User Logged in Successfully");
				}

				else if (verifyIsElementDisplayed(PWALoginPage.objFacebookPageVerification, "Facebook page")) {
					verifyElementPresent(PWALoginPage.objFacebookPageVerification, "Facebook page");
					verifyElementPresent(PWALoginPage.objFacebookLoginEmail, " Email Field");
					type(PWALoginPage.objFacebookLoginEmail, "igszeetesttest@gmail.com", "Emial Field");
					verifyElementPresent(PWALoginPage.objFacebookLoginpassword, " Password Field");
					type(PWALoginPage.objFacebookLoginpassword, "Igs$123Zee\n", "Password Field");
					verifyElementPresentAndClick(PWALoginPage.objFacebookLoginButtonInFbPage, " Login Button");
					waitTime(9000);
					getDriver().switchTo().window("CDwindow-0");
					verifyIsElementDisplayed(PWALoginPage.objFbCountinueBtn, "Continue button");
					if (verifyIsElementDisplayed(PWASignupPage.objSignUpTxt, "SignUp")) {
						regestrationfromSocialMedia();
						verifyElementPresent(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						verifyElementPresent(PWAHamburgerMenuPage.objProfilePageIcon, "Profile icon");
						logger.info("User Logged in Successfully");
						extent.extentLogger("Logged in", "User Logged in Successfully");
					} else {
						waitTime(3000);
						verifyElementPresent(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						verifyElementPresent(PWAHamburgerMenuPage.objProfileIcon, "Profile icon");
						logger.info("User Logged in Successfully");
						extent.extentLogger("Logged in", "User Logged in Successfully");
					}

				} else if (verifyElementPresent(PWALoginPage.objFbCountinueBtn, "Continue button") == true) {
					click(PWALoginPage.objFbCountinueBtn, "Continue fb");
					if (verifyElementPresent(PWASignupPage.objSignUpTxt, "SignUp") == true) {
						regestrationfromSocialMedia();
						verifyElementPresent(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						verifyElementPresent(PWAHamburgerMenuPage.objProfilePageIcon, "Profile icon");
						logger.info("User Logged in Successfully");
						extent.extentLogger("Logged in", "User Logged in Successfully");
					} else {
						waitTime(7000);
						verifyElementPresent(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						verifyElementPresent(PWAHamburgerMenuPage.objProfilePageIcon, "Profile icon");
						logger.info("User Logged in Successfully");
						extent.extentLogger("Logged in", "User Logged in Successfully");
					}
				}

				break;

			case "Gmail":
				extent.HeaderChildNode("Login through Gmail");
				System.out.println(getDriver().getCurrentUrl());
				System.out.println(getDriver().getWindowHandles());
				verifyElementPresentAndClick(PWALoginPage.objGoogleIcon, "Google Icon");
				getDriver().switchTo().window("CDwindow-1");
				waitTime(4000);
				if (verifyIsElementDisplayed(PWALoginPage.objGmailEmailField, " Email Field")) {
					type(PWALoginPage.objGmailEmailField, "Zee5latest@gmail.com", "Emial Field");
					hideKeyboard();
					verifyElementPresentAndClick(PWALoginPage.objGmailNextButton, "clicked on next button");
					waitTime(3000);
					verifyElementPresent(PWALoginPage.objGmailPasswordField, " Password Field");
					type(PWALoginPage.objGmailPasswordField, "User@123\n", "Password Field");
					hideKeyboard();
					verifyElementPresentAndClick(PWALoginPage.objGmailNextButton, "clicked on next button");
					waitTime(5000);
					getDriver().switchTo().window("CDwindow-0");
					if (verifyIsElementDisplayed(PWASignupPage.objSignUpTxt, "signup")) {
						regestrationfromSocialMedia();
					}
					waitTime(5000);
					verifyElementPresent(PWAHomePage.objZeeLogo, "Zee logo");
					logger.info("User is Logged in successfully");
					extent.extentLogger("Logged in", "User is Logged in successfully");
				} else {
					waitTime(10000);
					verifyElementPresent(PWAHomePage.objZeeLogo, "Zee logo");
					logger.info("User is Logged in successfully");
					extent.extentLogger("Logged in", "User is Logged in successfully");
				}

				break;

			case "Twitter":
				extent.HeaderChildNode("Login through Twitter");
				verifyElementPresentAndClick(PWALoginPage.objTwitterIcon, "Twitter icon");
				waitTime(7000);
				System.out.println(getDriver().getWindowHandles());
				System.out.println(getDriver().getCurrentUrl());
				getDriver().switchTo().window("CDwindow-1");

				waitTime(5000);
				System.out.println(getDriver().getCurrentUrl());

				if (verifyIsElementDisplayed(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger")) {
					verifyElementPresentAndClick(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
					verifyElementPresent(PWAHamburgerMenuPage.objProfilePageIcon, "Profile icon");
					logger.info("User Logged in Successfully");
					extent.extentLogger("Logged in", "User Logged in Successfully");
				}

				else if (verifyIsElementDisplayed(PWALoginPage.objTwitterAuthorizeButton, "Authorize app")) {
					click(PWALoginPage.objTwitterAuthorizeButton, "Authorize app");
					regestrationfromSocialMedia();
				} else if (verifyIsElementDisplayed(PWALoginPage.objTwitterEmaildField, "Twitter Email field")) {

					type(PWALoginPage.objTwitterEmaildField, "Zee5latest@gmail.com", "Email Field");
					hideKeyboard();
					verifyElementPresentAndClick(PWALoginPage.objTwitterPasswordField, "Twitter Password field");
					type(PWALoginPage.objTwitterPasswordField, "User@123\n", "Password field");
					click(PWALoginPage.objTwitterSignInButton, "Sign in button");
					waitTime(5000);
					verifyElementPresentAndClick(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
					click(PWAHamburgerMenuPage.objLoginBtn, "Login");
					verifyElementPresentAndClick(PWALoginPage.objTwitterIcon, "Twitter icon");
				}

				if (verifyIsElementDisplayed(PWALoginPage.objTwitterAuthorizeButton, "Authorize")) {
					click(PWALoginPage.objTwitterAuthorizeButton, "Authorize");
					waitTime(7000);
					verifyElementPresentAndClick(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
					verifyElementPresent(PWAHamburgerMenuPage.objProfilePageIcon, "Profile icon");
					logger.info("User Logged in Successfully");
					extent.extentLogger("Logged in", "User Logged in Successfully");
				}
				break;
			}
		}
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String Token;
		if (!userType.equals("Guest")) {
			Token = js.executeScript("return window.localStorage.getItem('ID');").toString();
		} else {
			Token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
		}
		mixpanel.ValidateParameter(Token, "Session");
		dismiss3xPopUp();
		dismissAppInstallPopUp();
	}

	/**
	 * Function to verify Play icon functionality
	 * 
	 * @throws Exception
	 */
	public void verifyCarouselBannerClickEvent(String userType, String screen) throws Exception {
		extent.HeaderChildNode("Verifying play icon functionality on carousel for : " + screen);
		// handle mandatory pop up
		String user = getParameterFromXML("userType");
		mandatoryRegistrationPopUp(user);
		if (navigateToAnyScreen(screen)) {
			waitTime(5000);
			waitForElementAndClick(PWAHomePage.objPlayBtn, 20, "Play icon");
			waitTime(2000);
			if (verifyElementPresent(PWAPlayerPage.objPlayerControlScreen, "Player control containing screen")) {
				logger.info("Navigated to consumption screen");
				extent.extentLogger("Play btn validation", "Navigated to consumption screen");
				mixpanel.FEProp.setProperty("Source", "");
				mixpanel.FEProp.setProperty("Element", "");
				String id = getDriver().getCurrentUrl();
				Pattern p = Pattern.compile("[0-9]-[0-9]-[0-9]+");
				Matcher m = p.matcher(id);
				String value = null;
				while (m.find()) {
					value = m.group(0);
				}
				ResponseInstance.getContentDetails(value);
				String Token;
				if (!userType.equals("Guest")) {
					Token = js.executeScript("return window.localStorage.getItem('ID');").toString();
				} else {
					Token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
				}
				mixpanel.ValidateParameter(Token, "Carousal Banner Click");

			} else {
				logger.error("Not Navigated to consumption screen");
				extent.extentLoggerFail("Play btn validation", "Not Navigated to consumption screen");
			}
		} else {
			logger.error("Failed to click on : " + screen);
			extent.extentLoggerFail("play", "Failed to click on : " + screen);
		}
	}

	public boolean navigateToAnyScreen(String screen) throws Exception {
		for (int i = 0; i < 3; i++) {
			try {
				if (verifyElementPresentAndClick(PWAHomePage.objTabName(screen), "Tab : " + screen))
					return true;
			} catch (Exception e) {
				try {
					swipeOnTab("Left");
					if (verifyElementPresentAndClick(PWAHomePage.objTabName(screen), "Tab : " + screen)) {
						waitTime(5000);
						return true;
					}
				} catch (Exception exc) {
					swipeOnTab("Right");
				}
			}
		}
		return false;
	}

	public void waitForElementAndClick(By locator, int seconds, String message) throws InterruptedException {
		main: for (int time = 0; time <= seconds; time++) {
			try {
				getDriver().findElement(locator).click();
				logger.info("Clicked element " + message);
				extent.extentLogger("clickedElement", "Clicked element " + message);
				break main;
			} catch (Exception e) {
				Thread.sleep(1000);
				if (time == seconds) {
					logger.error("Failed to click element " + message);
					extent.extentLoggerFail("failedClickElement", "Failed to click element " + message);
				}
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public void swipeOnTab(String dire) throws InterruptedException {
		extent.HeaderChildNode("Swipping on tab");
		touchAction = new TouchAction(getDriver());
		Dimension size = getDriver().findElement(PWAHomePage.objTabContBar).getSize();
		if (dire.equalsIgnoreCase("Left")) {
			int startx = (int) (size.width * 0.5);
			int endx = (int) (size.width * 0.1);
			int starty = size.height / 2;
			touchAction.press(PointOption.point(startx, starty))
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
					.moveTo(PointOption.point(endx, starty)).release().perform();
		} else if (dire.equalsIgnoreCase("Right")) {
			int startx = (int) (size.width * 0.5);
			int endx = (int) (size.width * 0.9);
			int starty = size.height / 2;
			touchAction.press(PointOption.point(startx, starty))
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
					.moveTo(PointOption.point(endx, starty)).release().perform();
		}
	}

	public void verifyThumbnailClickEventFromTray(String userType, String tabName) throws Exception {
		extent.HeaderChildNode("Verify Thumbnail Click Event For content played from trays");
		waitTime(5000);
		navigateToAnyScreen(tabName);
		waitTime(5000);
		verifyElementPresentAndClick(PWAPremiumPage.objThumbnail, "Thumbnail from a tray");

		waitTime(2000);
		mixpanel.FEProp.setProperty("Source", tabName);
		mixpanel.FEProp.setProperty("Page Name", "home");
		mixpanel.FEProp.setProperty("Element", "Play");
		String id = getDriver().getCurrentUrl();
		Pattern p = Pattern.compile("[0-9]-[0-9]-[0-9]+");
		Matcher m = p.matcher(id);
		String value = null;
		while (m.find()) {
			value = m.group(0);
		}
		ResponseInstance.getContentDetails(value);
		String Token;
		if (!userType.equals("Guest")) {
			Token = js.executeScript("return window.localStorage.getItem('ID');").toString();
		} else {
			Token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
		}
		mixpanel.ValidateParameter(Token, "Thumbnail Click");
	}

	public void verifyThumbnailClickEventFromViewMorePage(String tabName) throws Exception {
		extent.HeaderChildNode("Verify Thumbnail Click Event For content played from trays");
		navigateToAnyScreen(tabName);
		waitTime(5000);
		click(PWAPremiumPage.objViewAllBtn, "View All Button");
		verifyElementPresentAndClick(PWAPremiumPage.objThumbnail, "Thumbnail from View More Page");
		mixpanel.FEProp.setProperty("Source", tabName);
		mixpanel.FEProp.setProperty("Page Name", "view_all_top-20-on-zee5-kannada");
		waitTime(2000);
		mixpanel.FEProp.setProperty("Source", tabName);
		mixpanel.FEProp.setProperty("Page Name", "home");
		mixpanel.FEProp.setProperty("Element", "Play");
		String id = getDriver().getCurrentUrl();
		Pattern p = Pattern.compile("[0-9]-[0-9]-[0-9]+");
		Matcher m = p.matcher(id);
		String value = null;
		while (m.find()) {
			value = m.group(0);
		}
		ResponseInstance.getContentDetails(value);
		String Token;
		if (!userType.equals("Guest")) {
			Token = js.executeScript("return window.localStorage.getItem('ID');").toString();
		} else {
			Token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
		}
		mixpanel.ValidateParameter(Token, "Thumbnail Click");
	}

	public void verifyThumbnailClickEventFromShowDetailPage(String keyword) throws Exception {
		extent.HeaderChildNode("Verify Thumbnail Click Event From Show Detail Page");
		click(PWAHomePage.objSearchBtn, "Search Icon");
		type(PWASearchPage.objSearchEditBox, keyword + "\n", "Search Edit box: " + keyword);
		waitTime(4000);
		click(PWASearchPage.objSearchResult(keyword), "Search Result");
		verifyElementPresentAndClick(PWAPremiumPage.obj1stContentInShowDetailPage, "Thumbnail from Show detail page");
		mixpanel.FEProp.setProperty("Source", "search");
		mixpanel.FEProp.setProperty("Page Name", "show_detail");
		waitTime(2000);
		mixpanel.FEProp.setProperty("Source", "search");
		mixpanel.FEProp.setProperty("Page Name", "home");
		mixpanel.FEProp.setProperty("Element", "Play");
		String id = getDriver().getCurrentUrl();
		Pattern p = Pattern.compile("[0-9]-[0-9]-[0-9]+");
		Matcher m = p.matcher(id);
		String value = null;
		while (m.find()) {
			value = m.group(0);
		}
		ResponseInstance.getContentDetails(value);
		String Token;
		if (!userType.equals("Guest")) {
			Token = js.executeScript("return window.localStorage.getItem('ID');").toString();
		} else {
			Token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
		}
		mixpanel.ValidateParameter(Token, "Thumbnail Click");
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
		mixpanel.FEProp.setProperty("Source", "show_detail");
		mixpanel.FEProp.setProperty("Page Name", "episode_detail");
		waitTime(2000);
		mixpanel.FEProp.setProperty("Source", "search");
		mixpanel.FEProp.setProperty("Page Name", "home");
		mixpanel.FEProp.setProperty("Element", "Play");
		String id = getDriver().getCurrentUrl();
		Pattern p = Pattern.compile("[0-9]-[0-9]-[0-9]+");
		Matcher m = p.matcher(id);
		String value = null;
		while (m.find()) {
			value = m.group(0);
		}
		ResponseInstance.getContentDetails(value);
		String Token;
		if (!userType.equals("Guest")) {
			Token = js.executeScript("return window.localStorage.getItem('ID');").toString();
		} else {
			Token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
		}
		mixpanel.ValidateParameter(Token, "Thumbnail Click");
	}

	public void ZeeWEBPWAMixPanelLoginForParentalControl(String LoginMethod) throws Exception {
		String userType = getParameterFromXML("userType");
		switch (userType) {
		case "Guest":
			extent.HeaderChildNode("Guest User");
			extent.extentLogger("Accessing the application as Guest user", "Accessing the application as Guest user");
			dismissAllPopUps();
			waitTime(3000);
			break;

		case "NonSubscribedUser":
			extent.HeaderChildNode("Login as NonSubscribed User");
			String SUsername = getParameterFromXML("SettingsNonsubscribedUserName");
			String SPassword = getParameterFromXML("SettingsNonsubscribedPassword");
			if (!checkElementDisplayed(PWALoginPage.objLoginBtn, "Login Button")) {
				verifyElementPresentAndClick(PWAHomePage.objHamburgerMenu, "Hamburger Menu");
			}
			verifyElementPresentAndClick(PWALoginPage.objLoginBtn, "Login button");
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
			String SettingsSubscribedUsername = getParameterFromXML("SettingsSubscribedUserName");
			String SettingsSubscribedPassword = getParameterFromXML("SettingsSubscribedPassword");
			if (!checkElementDisplayed(PWALoginPage.objLoginBtn, "Login Button")) {
				verifyElementPresentAndClick(PWAHomePage.objHamburgerMenu, "Hamburger Menu");
			}
			verifyElementPresentAndClick(PWALoginPage.objLoginBtn, "Login button");
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
	 * Function to Relaunch the driver
	 */
	public void relaunch(boolean clearData) throws Exception {
		HeaderChildNode("Relaunch the app");
		logger.info("Relaunching the application");
		extent.extentLogger("Relaunch", "Relaunching the application");
		waitTime(10000);
		getDriver().quit();
		relaunch = clearData;
		new Zee5PWAWEBMixPanelBusinessLogic("Chrome");
		dismissAllPopUps();
	}

	public void verifyParentalRestrictionEvent(String userType, String restriction) throws Exception {
		if (!(userType.equalsIgnoreCase("Guest"))) {

			extent.HeaderChildNode("Verify Parental Restriction Event");
			click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger menu");
			click(PWAHamburgerMenuPage.objParentalControl, "ParentalControl");
			checkElementDisplayed(PWALoginPage.objPasswordField, "password field");
			String password = "";
			if (userType.equals("NonSubscribedUser")) {
				password = getParameterFromXML("SettingsNonsubscribedPassword");
			} else if (userType.equals("SubscribedUser")) {
				password = getParameterFromXML("SettingsSubscribedPassword");
			}
			type(PWALoginPage.objPasswordField, password, "Password field");
			click(PWAHamburgerMenuPage.objContinueButtonInVerifyAccount, "Continue button");
			waitTime(2000);
			checkElementDisplayed(PWAHamburgerMenuPage.objParentControlPageTitle, "Parent control page");

			switch (restriction) {

			case "Age13+":
				click(PWAHamburgerMenuPage.objRestrict13PlusContent, "Restrict 13+ content");
				click(PWAHamburgerMenuPage.objParentalLockPin1, "Set Lock Field");
				type(PWAHamburgerMenuPage.objParentalLockPin1, "1", "ParentalLockPin");
				type(PWAHamburgerMenuPage.objParentalLockPin2, "2", "ParentalLockPin");
				type(PWAHamburgerMenuPage.objParentalLockPin3, "3", "ParentalLockPin");
				type(PWAHamburgerMenuPage.objParentalLockPin4, "4", "ParentalLockPin");
				waitTime(4000);
				click(PWAHamburgerMenuPage.objSetParentalLockButton, "Set Parental lock button");
				waitTime(3000);

				break;

			case "RestrictAll":
				click(PWAHamburgerMenuPage.objRestrictAll, "Restrict all option");
				click(PWAHamburgerMenuPage.objParentalLockPin1, "Set Lock Field");
				type(PWAHamburgerMenuPage.objParentalLockPin1, "1", "ParentalLockPin");
				type(PWAHamburgerMenuPage.objParentalLockPin2, "2", "ParentalLockPin");
				type(PWAHamburgerMenuPage.objParentalLockPin3, "3", "ParentalLockPin");
				type(PWAHamburgerMenuPage.objParentalLockPin4, "4", "ParentalLockPin");
				waitTime(4000);
				click(PWAHamburgerMenuPage.objSetParentalLockButton, "Set Parental lock button");
				waitTime(3000);
				break;

			case "NoRestriction":
				click(PWAHamburgerMenuPage.objNoRestrictionSelected, "No Restriction option");
				click(PWAHamburgerMenuPage.objContinueButton, "Continue Button");
				break;
			}
			mixpanel.FEProp.setProperty("Source", "home");
			mixpanel.FEProp.setProperty("Parent Control Setting", "A");
			mixpanel.FEProp.setProperty("Setting Changed", "A");
			mixpanel.FEProp.setProperty("Page Name", "parental_control");
			String Token;
			Token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			mixpanel.ValidateParameter(Token, "Thumbnail Click");
		}
	}

	public void clearSearchHistoryEvent(String keyword1) throws Exception {
		extent.HeaderChildNode("Verify Clear Search History Event");
		click(PWAHomePage.objSearchBtn, "Search Icon");
		type(PWASearchPage.objSearchEditBox, keyword1 + "\n", "Search Edit box: " + keyword1);
		waitTime(5000);
		verifyElementPresentAndClick(PWASearchPage.objSearchCloseButton, "Clear Search Icon");
		mixpanel.FEProp.setProperty("Source", "home");
		mixpanel.FEProp.setProperty("Page Name", "search");
		mixpanel.FEProp.setProperty("Setting Changed", "clear search history");
		String Token;
		if (!userType.equals("Guest")) {
			Token = js.executeScript("return window.localStorage.getItem('ID');").toString();
		} else {
			Token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
		}
		mixpanel.ValidateParameter(Token, "Clear Search History");
	}

	public void verifyScreenViewEvent(String screen) throws Exception {
		extent.HeaderChildNode("Verify Screen View Event");
		navigateToAnyScreen(screen);
		mixpanel.FEProp.setProperty("Source", "home");
		mixpanel.FEProp.setProperty("Page Name", screen + "_landing");
		String Token;
		if (!userType.equals("Guest")) {
			Token = js.executeScript("return window.localStorage.getItem('ID');").toString();
		} else {
			Token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
		}
		mixpanel.ValidateParameter(Token, "Screen View");
	}

	public void verifySetReminderEventForUpcomingProgram(String userType) throws Exception {
		if (!(userType.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode("Verify Set Reminder Event");
			navigateToAnyScreen("Live TV");
//			wouldYouLikeToPopupClose();
			click(PWALiveTVPage.objChannelGuideToggle, "Channel Guide");
			click(PWALiveTVPage.objTomorrowDate, "Tomorrow date");
			FilterLanguage("Bengali");
			click(PWALiveTVPage.objBanglaShow1, "Show detail");
			if (checkElementDisplayed(PWALiveTVPage.objSetReminder, "Reminder")) {
				click(PWALiveTVPage.objSetReminder, "Reminder option");
				waitTime(3000);
			} else {
				click(PWALiveTVPage.objSetReminderOn, "Reminder option");
				waitTime(3000);
				click(PWALiveTVPage.objSetReminder, "Reminder option");
			}
			mixpanel.FEProp.setProperty("Source", "live_tv");
			mixpanel.FEProp.setProperty("Page Name", "tv_guide");
			mixpanel.FEProp.setProperty("element", "Set Reminder");
			String Token;
			if (!userType.equals("Guest")) {
				Token = js.executeScript("return window.localStorage.getItem('ID');").toString();
			} else {
				Token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			}
			mixpanel.ValidateParameter(Token, "Set Reminder");
		}
	}

	public void wouldYouLikeToPopupClose() throws Exception {
		if (checkElementDisplayed(PWAPlayerPage.objWouldYouLikeClosePopup, "WouldYouLikeClosePopup") == true) {
			click(PWAPlayerPage.objWouldYouLikeClosePopup, "WouldYouLikeClosePopup");
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

	public void verifySearchButtonClickEvent() throws Exception {
		extent.HeaderChildNode("Verify Search Button Click Event");
		click(PWAHomePage.objSearchBtn, "Search Icon");
		waitTime(5000);
		mixpanel.FEProp.setProperty("Element", "Search");
		mixpanel.FEProp.setProperty("Page Name", "home");
		String Token;
		if (!userType.equals("Guest")) {
			Token = js.executeScript("return window.localStorage.getItem('ID');").toString();
		} else {
			Token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
		}
		mixpanel.ValidateParameter(Token, "Search Button Click");
	}

	public void verifySearchExecutedEvent() throws Exception {
		extent.HeaderChildNode("Verify Search Executed Event");
		click(PWAHomePage.objSearchBtn, "Search Icon");
		String searchtxt = "Kam";
		type(PWASearchPage.objSearchEditBox, searchtxt + "\n", "Search Edit box: ");
		waitTime(4000);
		mixpanel.FEProp.setProperty("Source", "home");
		mixpanel.FEProp.setProperty("Search Type", "text");
		mixpanel.FEProp.setProperty("Results Returned", ResponseInstance.getresponse(searchtxt));
		mixpanel.FEProp.setProperty("Search Query", searchtxt);
		mixpanel.FEProp.setProperty("Search Success", "true");
		String Token;
		if (!userType.equals("Guest")) {
			Token = js.executeScript("return window.localStorage.getItem('ID');").toString();
		} else {
			Token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
		}
		mixpanel.ValidateParameter(Token, "Search Executed");
	}

	public void verifySearchResultClickedEvent(String keyword) throws Exception {
		extent.HeaderChildNode("Verify Search Result Clicked Event");
		click(PWAHomePage.objSearchBtn, "Search Icon");
		type(PWASearchPage.objSearchEditBox, keyword + "\n", "Search Edit box: " + keyword);
		waitTime(4000);
		waitForElement(PWASearchPage.objSearchResult(keyword), 10, "Search Result");
		click(PWASearchPage.objSearchResult(keyword), "Search Result");
		waitTime(5000);
		String Token;
		if (!userType.equals("Guest")) {
			Token = js.executeScript("return window.localStorage.getItem('ID');").toString();
		} else {
			Token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
		}
		mixpanel.ValidateParameter(Token, "Search Result Clicked");
	}

	public void verifyChangePasswordStartedEvent(String userType) throws Exception {
		if (!(userType.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode("Verify Change Password Started Event");
			verifyElementPresentAndClick(PWAHomePage.objHamburgerMenu, "Hamburger Menu");
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
			mixpanel.FEProp.setProperty("Source", "home");
			mixpanel.FEProp.setProperty("Element", "Update");
			mixpanel.FEProp.setProperty("Page Name", "my_profile");
			String Token;
			Token = js.executeScript("return window.localStorage.getItem('ID');").toString();
			mixpanel.ValidateParameter(Token, "Search Result Clicked");
		}
	}

	public void verifyChangePasswordResultEvent(String userType) throws Exception {
		if (!(userType.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode("Verify Change Password Result Event");
			verifyElementPresentAndClick(PWAHomePage.objHamburgerMenu, "Hamburger Menu");
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
			mixpanel.FEProp.setProperty("Source", "home");
			mixpanel.FEProp.setProperty("Element", "Update");
			mixpanel.FEProp.setProperty("Page Name", "my_profile");
			String Token;
			Token = js.executeScript("return window.localStorage.getItem('ID');").toString();
			mixpanel.ValidateParameter(Token, "Change Password Result");
		}
	}

	public void verifyDisplayLanguageChangeEvent() throws Exception {
		extent.HeaderChildNode("Verify Display Language Change Event");
		verifyElementPresentAndClick(PWAHomePage.objHamburgerMenu, "Hamburger Menu");
		verifyElementPresentAndClick(PWAHomePage.objLanguageBtn, "Language button");
		JSClick(PWALanguageSettingsPage.objFirstLanguage, "Hindi display language");
		JSClick(PWALanguageSettingsPage.objApplyBtn, "Apply button");
		JSClick(PWALanguageSettingsPage.objAllLangByindex(1), "Hindi content language");
		JSClick(PWALanguageSettingsPage.objApplyBtn, "Apply button");
		waitTime(5000);
		JSClick(PWALanguageSettingsPage.objApplyBtn, "Apply button");
		String Token;
		if (!userType.equals("Guest")) {
			Token = js.executeScript("return window.localStorage.getItem('ID');").toString();
		} else {
			Token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
		}
		mixpanel.ValidateParameter(Token, "Display Language Change");
	}

	public void verifyContentLanguageChangeEvent() throws Exception {
		extent.HeaderChildNode("Verify Content Language Change Event");
		verifyElementPresentAndClick(PWAHomePage.objHamburgerMenu, "Hamburger Menu");
		verifyElementPresentAndClick(PWAHomePage.objLanguageBtn, "Language button");
		if (userType.equals("Guest")) {
			mixpanel.FEProp.setProperty("Old Content Language:",
					ResponseInstance.getUserOldSettingsDetails("", "").getProperty("content_language"));
		} else {
			mixpanel.FEProp.setProperty("Old Content Language:",
					ResponseInstance.getUserOldSettingsDetails(Username, Password).getProperty("content_language"));
		}
		JSClick(PWALanguageSettingsPage.objApplyBtn, "Apply button");
		JSClick(PWALanguageSettingsPage.objAllLangByindex(1), "Hindi content language");
		JSClick(PWALanguageSettingsPage.objApplyBtn, "Apply button");
		waitTime(3000);
		String Token;
		if (!userType.equals("Guest")) {
			Token = js.executeScript("return window.localStorage.getItem('ID');").toString();
		} else {
			Token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
		}
		mixpanel.ValidateParameter(Token, "Content Language Change");
	}

	public void verifyDefaultSettingRestoredEvent() throws Exception {
		extent.HeaderChildNode("Verify Default Setting Restored Event");
		click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger menu");
		click(PWAHamburgerMenuPage.objMoreSettingInHamburger, "More settings");
		click(PWAHamburgerMenuPage.objResetSettingsToDefault, "Reset Settings to Default");
		waitTime(3000);
		mixpanel.FEProp.setProperty("Source", "home");
		mixpanel.FEProp.setProperty("Page Name", "settings");
		mixpanel.FEProp.setProperty("Setting Changed", "Default Setting Restored");
		mixpanel.FEProp.setProperty("Element", "Reset Settings to default");
		String Token;
		if (!userType.equals("Guest")) {
			Token = js.executeScript("return window.localStorage.getItem('ID');").toString();
		} else {
			Token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
		}
		mixpanel.ValidateParameter(Token, "Default Setting Restored");
	}

	public void verifyDeviceAuthenticationEvent(String userType) throws Exception {
		if (!(userType.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode(
					"Verify Device Authentication Event when authentication fails in TV Authentication screen");
			String AuthPin = "abcdef";
			click(PWAHomePage.objHamburgerMenu, "Hamburger Menu");
			waitTime(3000);
			verifyElementPresentAndClick(PWAHamburgerMenuPage.objAuthenticationOption, "Authenticate Device");
			type(PWAHamburgerMenuPage.objAuthenticationField, AuthPin, "AuthenticationField");
			click(PWAHamburgerMenuPage.objAuthenticationButtonHighlighted, "Authenticate button");
			mixpanel.FEProp.setProperty("Page Name", "device_authentication");
			mixpanel.FEProp.setProperty("Failure Reason", "Device code " + AuthPin + " has expired");
			mixpanel.FEProp.setProperty("Element", "Authenticate");
			String Token;
			Token = js.executeScript("return window.localStorage.getItem('ID');").toString();
			mixpanel.ValidateParameter(Token, "Device Authentication");
		}
	}

	public void verifyCarouselBannerSwipeEvent(String tabName) throws Exception {
		extent.HeaderChildNode("Verify Carousel Banner Swipe Event Across tabs");
		navigateToAnyScreen(tabName);
		swipeCarouselContents(1);
		mixpanel.FEProp.setProperty("Source", "home");
		mixpanel.FEProp.setProperty("Page Name", "tv_shows_view_all");
		mixpanel.FEProp.setProperty("Element", "right-arrow");
		mixpanel.FEProp.setProperty("Direction", "Right");
		String Token;
		if (!userType.equals("Guest")) {
			Token = js.executeScript("return window.localStorage.getItem('ID');").toString();
		} else {
			Token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
		}
		mixpanel.ValidateParameter(Token, "Carousal Banner Swipe");
	}

	@SuppressWarnings("rawtypes")
	public void swipeCarouselContents(int noOfTimes) {
		// HeaderChildNode("Carousel swipe");
		for (int i = 0; i < noOfTimes; i++) {
			int deviceWidth = getDriver().manage().window().getSize().width;
			int deviceHeight = getDriver().manage().window().getSize().height;
			int y = deviceHeight / 4;
			waitTime(2000);
			touchAction = new TouchAction(getDriver());
			touchAction.press(PointOption.point((deviceWidth - 250), (y - 100)))
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
					.moveTo(PointOption.point(0, (y - 100))).release().perform();
			System.out.println("Swiped : " + i);
		}
	}

	@SuppressWarnings("static-access")
	public void verifyRegisterScreenDisplayEvent(String userType) throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode(
					"Verify Register Screen Display Event By Clicking On Login Button In Registartion Screen");
			click(PWAHomePage.objHamburgerMenu, "Hamburger Menu");
			waitTime(3000);
			click(PWALoginPage.objSignUpBtnWEB, "Sign Up For Free");
			waitTime(5000);

			String token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			System.out.println(token);

			mixpanel.FEProp.setProperty("Source", "home");
			mixpanel.FEProp.setProperty("Page Name", "sign_in");
			mixpanel.ValidateParameter(token, "Register Screen Display");
		}
	}

	public void verifyRegistrationInitiatedEventForInvalidCredentials(String userType) throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("Verify Registration Initiated Event post entering invalid credentials");
			click(PWAHomePage.objHamburgerMenu, "Hamburger Menu");
			waitTime(3000);
			click(PWALoginPage.objSignUpBtnWEB, "Sign up button");
			waitForElementDisplayed(PWALoginPage.objEmailField, 5);
			checkElementDisplayed(PWALoginPage.objEmailField, "Email/PhoneNo Field");
			type(PWALoginPage.objEmailField, "9073258519", "PhoneNumber Field");
			click(PWASignupPage.objSignUpButtonHighlightedWeb, "Continue Button");

			String token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			System.out.println(token);

			mixpanel.FEProp.setProperty("Source", "register");
			mixpanel.FEProp.setProperty("Page Name", "otp_page");
			mixpanel.ValidateParameter(token, "Registration Initiated");
		}
	}

	public void verifyRegistrationResultEventForInvalidCredentials(String userType) throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("Verify Registration Result Event post entering invalid credentials");
			click(PWAHomePage.objHamburgerMenu, "Hamburger Menu");
			waitTime(3000);
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
			click(PWASignupPage.objVerifyBtnWeb, "Verified Button");

			String token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			System.out.println(token);

			mixpanel.FEProp.setProperty("Source", "register");
			mixpanel.FEProp.setProperty("Page Name", "otp_page");
			mixpanel.FEProp.setProperty("Failure Reason", "Either OTP is not valid or has expired");
			mixpanel.ValidateParameter(token, "Registration Result");
		}
	}

	public void verifySubscriptionPageViewedEventViaSubscribeBtn(String userType) throws Exception {
		extent.HeaderChildNode("Verify Subscription Page Viewed Event");
		if (!(userType.equalsIgnoreCase("SubscribedUser"))) {
			waitTime(3000);
			click(PWAHomePage.objSubscribeBtn, "Subscribe button");
			waitTime(3000);

			mixpanel.FEProp.setProperty("Source", "home");
			mixpanel.FEProp.setProperty("Page Name", "pack_selection");

			if (userType.equals("Guest")) {
				String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
				mixpanel.ValidateParameter(gToken, "Subscription Page Viewed");
			} else {
				String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
				mixpanel.ValidateParameter(ID, "Subscription Page Viewed");
			}
		}
	}

	public void verifySubscriptionPageViewedEventViaBuySubscription(String userType) throws Exception {
		extent.HeaderChildNode(
				"Verify Subscription Page Viewed Event by clicking on Buy subscription in hamburger menu");
		if (userType.equalsIgnoreCase("Guest")) {
			click(PWAHomePage.objHamburgerMenu, "Hamburger Menu");
			click(PWAHamburgerMenuPage.objBuySubscription, "Buy Subscription option");

			mixpanel.FEProp.setProperty("Source", "home");
			mixpanel.FEProp.setProperty("Page Name", "pack_selection");

			if (userType.equals("Guest")) {
				String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
				mixpanel.ValidateParameter(gToken, "Subscription Page Viewed");
			} else {
				String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
				mixpanel.ValidateParameter(ID, "Subscription Page Viewed");
			}
		}
	}

	public void verifySubscriptionPageViewedEventViaPrepaidCode(String userType) throws Exception {
		extent.HeaderChildNode(
				"Verify Subscription Page Viewed Event by clicking on prepaid code option in hamburger menu");
		if (userType.equalsIgnoreCase("Guest")) {
			click(PWAHomePage.objHamburgerMenu, "Hamburger Menu");
			click(PWAHamburgerMenuPage.objHaveAPrepaidCode, "Have a Prepaid Code? option");

			mixpanel.FEProp.setProperty("Source", "home");
			mixpanel.FEProp.setProperty("Page Name", "pack_selection");

			if (userType.equals("Guest")) {
				String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
				mixpanel.ValidateParameter(gToken, "Subscription Page Viewed");
			} else {
				String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
				mixpanel.ValidateParameter(ID, "Subscription Page Viewed");
			}

		}
	}

	public void verifySubscriptionPageViewedEventByClickingGetPremiumCTAOnCarousel(String userType) throws Exception {
		extent.HeaderChildNode("Verify Subscription Page Viewed Event By Clicking on Get Premium CTA On Carousel");
		if (!(userType.equalsIgnoreCase("SubscribedUser"))) {
			waitTime(3000);
			navigateToAnyScreen("Premium");
			JSClick(PWAPremiumPage.objGetPremiumCTAOnCarousel, "Get Premium CTA on carousel");
			waitTime(5000);

			mixpanel.FEProp.setProperty("Source", "home");
			mixpanel.FEProp.setProperty("Page Name", "pack_selection");

			if (userType.equals("Guest")) {
				String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
				mixpanel.ValidateParameter(gToken, "Subscription Page Viewed");
			} else {
				String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
				mixpanel.ValidateParameter(ID, "Subscription Page Viewed");
			}
		}
	}

	public void verifySubscriptionSelectedEvent(String userType) throws Exception {
		extent.HeaderChildNode("Verify Subscription Selected Event");
		if (!(userType.equalsIgnoreCase("SubscribedUser"))) {
			click(PWAHomePage.objSubscribeBtn, "Subscribe button");

			mixpanel.FEProp.setProperty("Page Name", "pack_selection");
			mixpanel.FEProp.setProperty("Element", "Continue");
			mixpanel.FEProp.setProperty("Source", "home");
			String[] cost = getText(PWASubscriptionPages.objSelectedSubscriptionPlanAmount).split(" ");
			mixpanel.FEProp.setProperty("Transaction Currency", cost[0]);
			mixpanel.FEProp.setProperty("cost", cost[1]);
			mixpanel.FEProp.setProperty("Current Subscription", "false");
			click(PWASubscriptionPages.objContinueBtn, "Continue Button");
			waitTime(2000);

			if (userType.equals("Guest")) {
				String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
				mixpanel.ValidateParameter(gToken, "Subscription Selected");
			} else {
				String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
				mixpanel.ValidateParameter(ID, "Subscription Selected");
			}
		}
	}

	public void verifySubscriptionSelectedEventByClubPack(String userType) throws Exception {
		extent.HeaderChildNode("Verify Subscription Selected Event By selecting Club Pack");
		if (!(userType.equalsIgnoreCase("SubscribedUser"))) {
			click(PWAHomePage.objSubscribeBtn, "Subscribe button");
			click(PWASubscriptionPages.objClubPack, "Club Pack");
			click(PWASubscriptionPages.objPackAmount1, "Pack");
			mixpanel.FEProp.setProperty("Page Name", "pack_selection");
			mixpanel.FEProp.setProperty("Source", "home");
			mixpanel.FEProp.setProperty("Element", "Continue");
			String[] cost = getText(PWASubscriptionPages.objSelectedSubscriptionPlanAmount).split(" ");
			mixpanel.FEProp.setProperty("Transaction Currency", cost[0]);
			mixpanel.FEProp.setProperty("cost", cost[1]);
			click(PWASubscriptionPages.objContinueBtn, "Continue Button");
			waitTime(2000);

			if (userType.equals("Guest")) {
				String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
				mixpanel.ValidateParameter(gToken, "Subscription Selected");
			} else {
				String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
				mixpanel.ValidateParameter(ID, "Subscription Selected");
			}
		}
	}

	public void verifyPrepaidCodeResultEventForInvalid(String userType) throws Exception {
		extent.HeaderChildNode("Verify Prepaid Code Result Event For Invalid code");
		String promocode = "Z56MSK93rJGDyi";
		if (!(userType.equalsIgnoreCase("SubscribedUser"))) {
			click(PWAHomePage.objSubscribeBtn, "Subscribe button");

			click(PWASubscriptionPages.objHaveACode, "Have A Code section");
			type(PWASubscriptionPages.objHaveACode, promocode, "Prepaid Code");
			click(PWASubscriptionPages.objApplyBtn, "Apply Button");

			if (userType.equals("Guest")) {
				if (checkElementDisplayed(PWASubscriptionPages.objEmailIDTextField, "Email ID field")) {
					click(PWASubscriptionPages.objEmailIDTextField, "Email ID field");
					type(PWASubscriptionPages.objEmailIDTextField, "igszee5test123g@gmail.com", "Email Id");
					verifyElementPresentAndClick(PWASubscriptionPages.objPaymentPageProceedBtn, "Proceed Button");
					// Password Popup
					verifyElementPresent(PWASubscriptionPages.objEnterPasswordPopupTitle, "Enter Password Popup Title");
					click(PWASubscriptionPages.objPasswordFieldHidden, "Password Field");
					type(PWASubscriptionPages.objPasswordFieldHidden, "igs@12345", "Password Field");
					verifyElementPresentAndClick(PWASubscriptionPages.objPopupProceedBtn, "Proceed Button");
				}
			}
			mixpanel.FEProp.setProperty("Page Name", "pack_selection");
			mixpanel.FEProp.setProperty("Source", "home");
			mixpanel.FEProp.setProperty("Element", "APPLY");
			mixpanel.FEProp.setProperty("Success", "false");
			String[] cost = getText(PWASubscriptionPages.objSelectedSubscriptionPlanAmount).split(" ");
			mixpanel.FEProp.setProperty("Transaction Currency", cost[0]);
			mixpanel.FEProp.setProperty("cost", cost[1]);
			mixpanel.FEProp.setProperty("Promo Code Type", "Product");
			mixpanel.FEProp.setProperty("Promo Code", promocode);

			if (userType.equals("Guest")) {
				String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
				mixpanel.ValidateParameter(gToken, "Prepaid Code Result");
			} else {
				String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
				mixpanel.ValidateParameter(ID, "Prepaid Code Result");
			}
		}
	}

	public void verifyPromoCodeResultEventForValid(String userType) throws Exception {
		extent.HeaderChildNode("Verify Promo Code Result Event For Valid code");
		String promoCode = "PNB20";
		if (!(userType.equalsIgnoreCase("SubscribedUser"))) {
			click(PWAHomePage.objSubscribeBtn, "Subscribe button");

			click(PWASubscriptionPages.objHaveACode, "Have A Code section");
			type(PWASubscriptionPages.objHaveACode, promoCode, "Prepaid Code");
			click(PWASubscriptionPages.objApplyBtn, "Apply Button");
			waitTime(2000);
			if (userType.equals("Guest")) {
				if (checkElementDisplayed(PWASubscriptionPages.objEmailIDTextField, "Email ID field")) {
					click(PWASubscriptionPages.objEmailIDTextField, "Email ID field");
					type(PWASubscriptionPages.objEmailIDTextField, "igszee5test123g@gmail.com", "Email Id");
					verifyElementPresentAndClick(PWASubscriptionPages.objPaymentPageProceedBtn, "Proceed Button");
					// Password Popup
					verifyElementPresent(PWASubscriptionPages.objEnterPasswordPopupTitle, "Enter Password Popup Title");
					verifyElementPresentAndClick(PWASubscriptionPages.objPasswordFieldHidden, "Password Field");
					type(PWASubscriptionPages.objPasswordFieldHidden, "igs@12345", "Password Field");
					verifyElementPresentAndClick(PWASubscriptionPages.objPopupProceedBtn, "Proceed Button");
				}
			}
			mixpanel.FEProp.setProperty("Page Name", "pack_selection");
			mixpanel.FEProp.setProperty("Source", "home");
			mixpanel.FEProp.setProperty("Element", "APPLY");
			mixpanel.FEProp.setProperty("Success", "true");
			String[] cost = getText(PWASubscriptionPages.objSelectedSubscriptionPlanAmount).split(" ");
			mixpanel.FEProp.setProperty("Transaction Currency", cost[0]);
			mixpanel.FEProp.setProperty("cost", cost[1]);
			mixpanel.FEProp.setProperty("Promo Code Type", "Product");
			mixpanel.FEProp.setProperty("Promo Code", promoCode);

			if (userType.equals("Guest")) {
				String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
				mixpanel.ValidateParameter(gToken, "Promo Code Result");
			} else {
				String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
				mixpanel.ValidateParameter(ID, "Promo Code Result");
			}
		}
	}

	public void verifyPromoCodeResultEventForInvalid(String userType) throws Exception {
		extent.HeaderChildNode("Verify Promo Code Result Event For Invalid code");
		String promocode = "sdcrfd";
		if (!(userType.equalsIgnoreCase("SubscribedUser"))) {
			click(PWAHomePage.objSubscribeBtn, "Subscribe button");

			verifyElementPresentAndClick(PWASubscriptionPages.objHaveACode, "Have A Code section");
			type(PWASubscriptionPages.objHaveACode, promocode, "Prepaid Code");
			click(PWASubscriptionPages.objApplyBtn, "Apply Button");

			if (userType.equals("Guest")) {
				if (checkElementDisplayed(PWASubscriptionPages.objEmailIDTextField, "Email ID field")) {
					click(PWASubscriptionPages.objEmailIDTextField, "Email ID field");
					type(PWASubscriptionPages.objEmailIDTextField, "igszee5test123g@gmail.com", "Email Id");
					verifyElementPresentAndClick(PWASubscriptionPages.objPaymentPageProceedBtn, "Proceed Button");
					// Password Popup
					verifyElementPresent(PWASubscriptionPages.objEnterPasswordPopupTitle, "Enter Password Popup Title");
					verifyElementPresentAndClick(PWASubscriptionPages.objPasswordFieldHidden, "Password Field");
					type(PWASubscriptionPages.objPasswordFieldHidden, "igs@12345", "Password Field");
					verifyElementPresentAndClick(PWASubscriptionPages.objPopupProceedBtn, "Proceed Button");
				}
			}
			mixpanel.FEProp.setProperty("Page Name", "pack_selection");
			mixpanel.FEProp.setProperty("Source", "home");
			mixpanel.FEProp.setProperty("Element", "APPLY");
			mixpanel.FEProp.setProperty("Success", "false");
			String[] cost = getText(PWASubscriptionPages.objSelectedSubscriptionPlanAmount).split(" ");
			mixpanel.FEProp.setProperty("Transaction Currency", cost[0]);
			mixpanel.FEProp.setProperty("cost", cost[1]);
			mixpanel.FEProp.setProperty("Promo Code Type", "Product");
			mixpanel.FEProp.setProperty("Promo Code", promocode);

			if (userType.equals("Guest")) {
				String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
				mixpanel.ValidateParameter(gToken, "Promo Code Result");
			} else {
				String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
				mixpanel.ValidateParameter(ID, "Promo Code Result");
			}
		}
	}

	public void verifySubscriptionCallInitiatedEvent(String userType) throws Exception {
		extent.HeaderChildNode("Subscription Call Initiated Event for All access pack");

		if (!(userType.equals("SubscribedUser"))) {
			click(PWAHomePage.objSubscribeBtn, "Subscribe button");
			mixpanel.FEProp.setProperty("Page Name", "payment_page");
			mixpanel.FEProp.setProperty("Source", "account_info");
			String[] cost = getText(PWASubscriptionPages.objSelectedSubscriptionPlanAmount).split(" ");
			mixpanel.FEProp.setProperty("Transaction Currency", cost[0]);
			mixpanel.FEProp.setProperty("cost", cost[1]);
			mixpanel.FEProp.setProperty("Payment Method", "mastercard");
			click(PWASubscriptionPages.objContinueBtn, "Continue Button");
			waitTime(2000);

			if (userType.equals("Guest")) {
				if (checkElementDisplayed(PWASubscriptionPages.objEmailIDTextField, "Email ID field")) {
					click(PWASubscriptionPages.objEmailIDTextField, "Email ID field");
					type(PWASubscriptionPages.objEmailIDTextField, "igszee5test123g@gmail.com", "Email Id");
					verifyElementPresentAndClick(PWASubscriptionPages.objPaymentPageProceedBtn, "Proceed Button");
					// Password Popup
					verifyElementPresent(PWASubscriptionPages.objEnterPasswordPopupTitle, "Enter Password Popup Title");
					verifyElementPresentAndClick(PWASubscriptionPages.objPasswordFieldHidden, "Password Field");
					type(PWASubscriptionPages.objPasswordFieldHidden, "igs@12345", "Password Field");
					verifyElementPresentAndClick(PWASubscriptionPages.objPopupProceedBtn, "Proceed Button");
				}
			}
			waitTime(10000);
			WebElement iframeElement = getDriver().findElement(By.id("juspay_iframe"));
			Thread.sleep(5000);
			Thread.sleep(5000);
			Thread.sleep(5000);
			getDriver().switchTo().frame(iframeElement);

			click(PWASubscriptionPages.objEnterCardNumber, "Card Number");
			type(PWASubscriptionPages.objEnterCardNumber, "5123456789012346", "Card Number");
			click(PWASubscriptionPages.objEnterExpiry, "Expiry");
			type(PWASubscriptionPages.objEnterExpiry, "0224", "Expiry");
			click(PWASubscriptionPages.objEnterCVV, "CVV");
			type(PWASubscriptionPages.objEnterCVV, "123", "CVV");
			click(PWASubscriptionPages.objCreditDebitProceedToPay, "Proceed To Pay Button");
			waitTime(10000);

			if (userType.equals("Guest")) {
				String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
				mixpanel.ValidateParameter(gToken, "Subscription Call Initiated");
			} else {
				String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
				mixpanel.ValidateParameter(ID, "Subscription Call Initiated");
			}
		}
	}

	public void verifySubscriptionCallInitiatedEventClubPack(String userType) throws Exception {
		extent.HeaderChildNode("Subscription Call Initiated Event for Club pack");

		if (userType.equals("ClubUser")) {
			click(PWAHomePage.objSubscribeBtn, "Subscribe button");
			click(PWASubscriptionPages.objClubPack, "Club Pack");
			click(PWASubscriptionPages.objPackAmount1, "Pack");
			mixpanel.FEProp.setProperty("Page Name", "payment_page");
			mixpanel.FEProp.setProperty("Source", "account_info");
			String[] cost = getText(PWASubscriptionPages.objSelectedSubscriptionPlanAmount).split(" ");
			mixpanel.FEProp.setProperty("Transaction Currency", cost[0]);
			mixpanel.FEProp.setProperty("cost", cost[1]);
			mixpanel.FEProp.setProperty("Payment Method", "mastercard");
			click(PWASubscriptionPages.objContinueBtn, "Continue Button");
			waitTime(2000);

			if (userType.equals("Guest")) {
				if (checkElementDisplayed(PWASubscriptionPages.objEmailIDTextField, "Email ID field")) {
					click(PWASubscriptionPages.objEmailIDTextField, "Email ID field");
					type(PWASubscriptionPages.objEmailIDTextField, "igszee5test123g@gmail.com", "Email Id");
					verifyElementPresentAndClick(PWASubscriptionPages.objPaymentPageProceedBtn, "Proceed Button");
					// Password Popup
					verifyElementPresent(PWASubscriptionPages.objEnterPasswordPopupTitle, "Enter Password Popup Title");
					verifyElementPresentAndClick(PWASubscriptionPages.objPasswordFieldHidden, "Password Field");
					type(PWASubscriptionPages.objPasswordFieldHidden, "igs@12345", "Password Field");
					verifyElementPresentAndClick(PWASubscriptionPages.objPopupProceedBtn, "Proceed Button");
				}
			}
			waitTime(10000);
			WebElement iframeElement = getDriver().findElement(By.id("juspay_iframe"));
			Thread.sleep(5000);
			Thread.sleep(5000);
			Thread.sleep(5000);
			getDriver().switchTo().frame(iframeElement);

			click(PWASubscriptionPages.objEnterCardNumber, "Card Number");
			type(PWASubscriptionPages.objEnterCardNumber, "5123456789012346", "Card Number");
			click(PWASubscriptionPages.objEnterExpiry, "Expiry");
			type(PWASubscriptionPages.objEnterExpiry, "0224", "Expiry");
			click(PWASubscriptionPages.objEnterCVV, "CVV");
			type(PWASubscriptionPages.objEnterCVV, "123", "CVV");
			click(PWASubscriptionPages.objCreditDebitProceedToPay, "Proceed To Pay Button");
			waitTime(10000);

			if (userType.equals("Guest")) {
				String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
				mixpanel.ValidateParameter(gToken, "Subscription Call Initiated");
			} else {
				String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
				mixpanel.ValidateParameter(ID, "Subscription Call Initiated");
			}

		}
	}

	public void verifySubscriptionCallReturnedEvent(String userType) throws Exception {
		extent.HeaderChildNode(
				"Subscription Call Returned Event when user makes unsuccessful transaction by quitting the payment gateway screen");

		if (!(userType.equals("SubscribedUser"))) {
			click(PWAHomePage.objSubscribeBtn, "Subscribe button");
			click(PWASubscriptionPages.objContinueBtn, "Continue Button");
			waitTime(2000);

			mixpanel.FEProp.setProperty("Page Name", "payment_page");
			mixpanel.FEProp.setProperty("Source", "account_info");
			String[] cost = getText(PWASubscriptionPages.objSelectedSubscriptionPlanAmount).split(" ");
			mixpanel.FEProp.setProperty("Transaction Currency", cost[0]);
			mixpanel.FEProp.setProperty("cost", cost[1]);
			mixpanel.FEProp.setProperty("Payment Method", "mastercard");

			if (userType.equals("Guest")) {
				if (checkElementDisplayed(PWASubscriptionPages.objEmailIDTextField, "Email ID field")) {
					click(PWASubscriptionPages.objEmailIDTextField, "Email ID field");
					type(PWASubscriptionPages.objEmailIDTextField, "igszee5test123g@gmail.com", "Email Id");
					verifyElementPresentAndClick(PWASubscriptionPages.objPaymentPageProceedBtn, "Proceed Button");
					// Password Popup
					verifyElementPresent(PWASubscriptionPages.objEnterPasswordPopupTitle, "Enter Password Popup Title");
					verifyElementPresentAndClick(PWASubscriptionPages.objPasswordFieldHidden, "Password Field");
					type(PWASubscriptionPages.objPasswordFieldHidden, "igs@12345", "Password Field");
					verifyElementPresentAndClick(PWASubscriptionPages.objPopupProceedBtn, "Proceed Button");
				}
			}
			waitTime(10000);

			Swipe("UP", 1);
			waitTime(3000);
			getDriver().context("NATIVE_APP");
			verifyElementPresentAndClick(PWASubscriptionPages.objMobileCreditDebitCardOption,
					"'Credit / Debit Card' option");
			click(PWASubscriptionPages.objMobileCardNumberText, "Card Number");
			type(PWASubscriptionPages.objMobileCardNumberText, "5123456789012346", "Card Number");
			click(PWASubscriptionPages.objMobileExpiryText, "Expiry field");
			type(PWASubscriptionPages.objMobileExpiryText, "0224", "Expiry");
			click(PWASubscriptionPages.objMobileCVVText, "CVV field");
			type(PWASubscriptionPages.objEnterCVV, "123", "CVV");
			verifyElementPresent(PWASubscriptionPages.objMobileProceedToPayButton, "Proceed to Pay button");
			click(PWASubscriptionPages.objCreditDebitClose, "Credit/Debit card Close");
			getDriver().context("CHROMIUM");
			Back(1);
			extent.HeaderChildNode("Validating the payment gateway using Paytm");
			getDriver().context("NATIVE_APP");

			WebElement iframeElement = getDriver().findElement(By.id("juspay_iframe"));
			Thread.sleep(5000);
			Thread.sleep(5000);
			Thread.sleep(5000);
			getDriver().switchTo().frame(iframeElement);

			click(PWASubscriptionPages.objEnterCardNumber, "Card Number");
			type(PWASubscriptionPages.objEnterCardNumber, "5123456789012346", "Card Number");
			click(PWASubscriptionPages.objEnterExpiry, "Expiry");
			type(PWASubscriptionPages.objEnterExpiry, "0224", "Expiry");
			click(PWASubscriptionPages.objEnterCVV, "CVV");
			type(PWASubscriptionPages.objEnterCVV, "123", "CVV");
			click(PWASubscriptionPages.objCreditDebitProceedToPay, "Proceed To Pay Button");
			waitTime(10000);
			click(PWASubscriptionPages.objZeeLink, "Zee link");
			waitTime(5000);

			if (userType.equals("Guest")) {
				String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
				mixpanel.ValidateParameter(gToken, "Subscription Call Returned");
			} else {
				String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
				mixpanel.ValidateParameter(ID, "Subscription Call Returned");
			}
		}
	}
	
	public void verifyViewMoreSelectedEventFromShowDetailPage(String keyword) throws Exception {
		extent.HeaderChildNode("Verify View More Selected Event For content played from Show detail page");
		click(PWAHomePage.objSearchBtn, "Search Icon");
		type(PWASearchPage.objSearchEditBox, keyword + "\n", "Search Edit box: " + keyword);
		waitTime(4000);
		click(PWASearchPage.objSearchResult(keyword), "Search Result");
		waitTime(4000);
		verifyElementPresentAndClick(PWAPremiumPage.objViewAllBtn, "View All Button");

		mixpanel.FEProp.setProperty("Source", "search");
		mixpanel.FEProp.setProperty("Element", "View All");
		mixpanel.FEProp.setProperty("Page Name", "show_detail");
		String Token;
		if (!userType.equals("Guest")) {
			Token = js.executeScript("return window.localStorage.getItem('ID');").toString();
		} else {
			Token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
		}
		mixpanel.ValidateParameter(Token, "View More Selected");		
	}
	
	public void verifyViewMoreSelectedEventFromPlaybackPage(String audioTrackContent, String userType)
			throws Exception {
		extent.HeaderChildNode("Verify View More Selected Event For content played from Playback page");
		click(PWAHomePage.objSearchBtn, "Search Icon");
		type(PWASearchPage.objSearchEditBox, audioTrackContent + "\n", "Search Edit box: " + audioTrackContent);
		waitTime(4000);
		click(PWASearchPage.objSearchResultTxt(audioTrackContent), "Search Result");
		waitTime(4000);
		mandatoryRegistrationPopUp(userType);
		verifyElementPresentAndClick(PWAPremiumPage.objViewAllBtn, "View All Button");
		
		mixpanel.FEProp.setProperty("Source", "search");
		mixpanel.FEProp.setProperty("Element", "View All");
		mixpanel.FEProp.setProperty("Page Name", "episode_detail");
		String Token;
		if (!userType.equals("Guest")) {
			Token = js.executeScript("return window.localStorage.getItem('ID');").toString();
		} else {
			Token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
		}
		mixpanel.ValidateParameter(Token, "View More Selected");
	}
	
	public void verifyViewMoreSelectedEventFromTray() throws Exception {
		extent.HeaderChildNode("Verify View More Selected Event For content played from Tray");
		waitTime(5000);
		verifyElementPresentAndClick(PWAPremiumPage.objViewAllBtn, "View All Button");
		mixpanel.FEProp.setProperty("Source", "sign_in");
		mixpanel.FEProp.setProperty("Element", "View All");
		mixpanel.FEProp.setProperty("Page Name", "home");
		String Token;
		if (!userType.equals("Guest")) {
			Token = js.executeScript("return window.localStorage.getItem('ID');").toString();
		} else {
			Token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
		}
		mixpanel.ValidateParameter(Token, "View More Selected");
	}
	
	public void verifyAddtoWatchlistFromPlaybackPage(String userType, String keyword1) throws Exception {
		if (!(userType.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode("Verify Add to Watchlist Event From Playback Page");
			click(PWAHomePage.objSearchBtn, "Search Icon");
			type(PWASearchPage.objSearchEditBox, keyword1 + "\n", "Search Edit box: " + keyword1);
			waitTime(4000);
			waitForElement(PWASearchPage.objSearchResult(keyword1), 10, "Search Result");
			click(PWASearchPage.objSearchResult(keyword1), "Search Result");

			if (checkElementDisplayed(PWAPlayerPage.objAddToWatchlist, "Add To Watchlist icon")) {
				click(PWAPlayerPage.objAddToWatchlist, "Watchlist icon");
			} else {
				click(PWAPlayerPage.objRemoveFromWatchlist, "Remove From Watchlist icon");
				waitTime(4000);
				click(PWAPlayerPage.objAddToWatchlist, "Add To Watchlist icon");
				waitTime(4000);
			}
			waitTime(4000);
			mixpanel.FEProp.setProperty("Source", "search");
			mixpanel.FEProp.setProperty("Page Name", "movie_detail");
			mixpanel.FEProp.setProperty("Element", "Watchlist");
			String Token;
			if (!userType.equals("Guest")) {
				Token = js.executeScript("return window.localStorage.getItem('ID');").toString();
			} else {
				Token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			}
			mixpanel.ValidateParameter(Token, "Add To Watchlist");
		}
	}
	public void verifyAddToWatchlistEventFromShowDetailPage(String userType, String keyword) throws Exception {
		if (!(userType.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode("Verify Add To Watchlist Event From Show Detail Page");
			click(PWAHomePage.objSearchBtn, "Search Icon");
			type(PWASearchPage.objSearchEditBox, keyword + "\n", "Search Edit box: " + keyword);
			waitTime(4000);
			click(PWASearchPage.objSearchResult(keyword), "Search Result");
			waitTime(5000);
			Actions actions = new Actions(getDriver());
			WebElement contentCard = getDriver().findElement(PWAPremiumPage.obj1stContentInShowDetailPage);
			actions.moveToElement(contentCard).build().perform();
			if (checkElementDisplayed(PWAPlayerPage.objAddToWatchlist, "Add To Watchlist icon")) {
				click(PWAPlayerPage.objAddToWatchlist, "Watchlist icon");
			} else {
				click(PWAPlayerPage.objRemoveFromWatchlist, "Remove From Watchlist icon");
				waitTime(3000);
				actions.moveToElement(contentCard).build().perform();
				click(PWAPlayerPage.objAddToWatchlist, "Add To Watchlist icon");
				waitTime(4000);
			}
			
			mixpanel.FEProp.setProperty("Source", "search");
			mixpanel.FEProp.setProperty("Page Name", "show_detail");
			mixpanel.FEProp.setProperty("Element", "Watchlist");
			String Token;
			if (!userType.equals("Guest")) {
				Token = js.executeScript("return window.localStorage.getItem('ID');").toString();
			} else {
				Token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			}
			mixpanel.ValidateParameter(Token, "Add To Watchlist");
		}
	}
	
	public void verifyShareEventFromPlaybackPage(String keyword1) throws Exception {

		extent.HeaderChildNode("Verify Share Event From Playback Page");
		click(PWAHomePage.objSearchBtn, "Search Icon");
		type(PWASearchPage.objSearchEditBox, keyword1 + "\n", "Search Edit box: " + keyword1);
		waitTime(4000);
		waitForElement(PWASearchPage.objSearchResult(keyword1), 10, "Search Result");
		click(PWASearchPage.objSearchResult(keyword1), "Search Result");
		click(PWAPlayerPage.shareBtn, "Share Option");
		click(PWAPlayerPage.facebookShareBtn, "Facebook share option");
		switchToWindow(2);
		Thread.sleep(2000);

		if (checkElementDisplayed(PWALiveTVPage.objFacebookEmailField, "Facebook Email field")) {
			click(PWALiveTVPage.objFacebookEmailField, "Facebook Email field");
			getDriver().findElement(PWALiveTVPage.objFacebookEmailField).sendKeys("igszeetest@gmail.com");
			click(PWALiveTVPage.objFacebookPasswordField, "Facebook Password field");
			getDriver().findElement(PWALiveTVPage.objFacebookPasswordField).sendKeys("igs@12345");
			click(PWALiveTVPage.objFacebookLoginBtn, "Facebook Login button");
			waitTime(2000);
			verifyAlert();
			waitTime(2000);
		}
		click(PWALiveTVPage.objPostToFacebookBtn, "Post to Facebook");
		getDriver().close();
		switchToWindow(1);
		waitTime(3000);
		mixpanel.FEProp.setProperty("Source", "search");
		mixpanel.FEProp.setProperty("Page Name", "movie_detail");
		mixpanel.FEProp.setProperty("Sharing Platform", "Facebook");
		String Token;
		if (!userType.equals("Guest")) {
			Token = js.executeScript("return window.localStorage.getItem('ID');").toString();
		} else {
			Token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
		}
		mixpanel.ValidateParameter(Token, "Share");
	}
	
	public void verifyShareEventForUpcomingProgram() throws Exception {
		extent.HeaderChildNode("Verify Share Event For Upcoming Program");
		navigateToAnyScreen("Live TV");
		
		waitTime(5000);
		wouldYouLikeToPopupClose();
		click(PWALiveTVPage.objChannelGuideToggle, "Channel Guide");
		click(PWALiveTVPage.objTomorrowDate, "Tomorrow date");
		FilterLanguage("Bengali");
		click(PWALiveTVPage.objBanglaShow1, "Show detail");

		click(PWAPremiumPage.objContentCardShareBtn, "Share button");
		waitTime(3000);
		click(PWALiveTVPage.objFacebookShareBtn, "Share to Facebook");
		waitTime(3000);
		verifyAlert();
		switchToWindow(2);
		if (!checkElementDisplayed(PWALiveTVPage.objPostToFacebookBtn, "Post to Facebook")) {
			click(PWALiveTVPage.objFacebookEmailField, "Facebook Email field");
			getDriver().findElement(PWALiveTVPage.objFacebookEmailField).sendKeys("igszeetest@gmail.com");
			click(PWALiveTVPage.objFacebookPasswordField, "Facebook Password field");
			getDriver().findElement(PWALiveTVPage.objFacebookPasswordField).sendKeys("igs@12345");
			click(PWALiveTVPage.objFacebookLoginBtn, "Facebook Login button");
			waitTime(4000);
		}
		click(PWALiveTVPage.objPostToFacebookBtn, "Post to Facebook");
		waitTime(7000);
		acceptAlert();
		waitTime(3000);
		switchToParentWindow();
		waitTime(3000);
		mixpanel.FEProp.setProperty("Source", "live_tv");
		mixpanel.FEProp.setProperty("Page Name", "tv_guide");
		mixpanel.FEProp.setProperty("Sharing Platform", "Facebook");
		String Token;
		if (!userType.equals("Guest")) {
			Token = js.executeScript("return window.localStorage.getItem('ID');").toString();
		} else {
			Token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
		}
		mixpanel.ValidateParameter(Token, "Share");
	}
	
	public void verifyShareEventFromShowDetailPage(String keyword) throws Exception {

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

			getDriver().findElement(PWALiveTVPage.objFacebookEmailField).sendKeys("igszeetest@gmail.com");
			click(PWALiveTVPage.objFacebookPasswordField, "Facebook Password field");
			getDriver().findElement(PWALiveTVPage.objFacebookPasswordField).sendKeys("igs@12345");
			click(PWALiveTVPage.objFacebookLoginBtn, "Facebook Login button");
			waitTime(2000);
			verifyAlert();
			waitTime(2000);
		}
		click(PWALiveTVPage.objPostToFacebookBtn, "Post to Facebook");
		getDriver().close();
		switchToWindow(1);
		waitTime(3000);
		mixpanel.FEProp.setProperty("Source", "home");
		mixpanel.FEProp.setProperty("Page Name", "show_detail");
		mixpanel.FEProp.setProperty("Sharing Platform", "Facebook");
		String Token;
		if (!userType.equals("Guest")) {
			Token = js.executeScript("return window.localStorage.getItem('ID');").toString();
		} else {
			Token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
		}
		mixpanel.ValidateParameter(Token, "Share");
	}
	
	public void verifySettingChangedEventAfterAccountVerification(String userType) throws Exception {
		if (!(userType.equalsIgnoreCase("Guest"))) {

			extent.HeaderChildNode("Verify Setting Changed Event when Parental Control Account Verification is done");
			click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger menu");
			click(PWAHamburgerMenuPage.objParentalControl, "ParentalControl");
			checkElementDisplayed(PWALoginPage.objPasswordField, "password field");
			String password = "";
			if (userType.equals("NonSubscribedUser")) {
				password = getParameterFromXML("SettingsNonsubscribedPassword");
			} else if (userType.equals("SubscribedUser")) {
				password = getParameterFromXML("SettingsSubscribedPassword");
			}
			type(PWALoginPage.objPasswordField, password, "Password field");
			click(PWAHamburgerMenuPage.objContinueButtonInVerifyAccount, "Continue button");
			waitTime(2000);
			mixpanel.FEProp.setProperty("Source", "N/A");
			mixpanel.FEProp.setProperty("Page Name", "home");
			mixpanel.FEProp.setProperty("Element", "Continue");
			mixpanel.FEProp.setProperty("Setting Changed", "Parental Control Account Verification");
			String Token;
			if (!userType.equals("Guest")) {
				Token = js.executeScript("return window.localStorage.getItem('ID');").toString();
			} else {
				Token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			}
			mixpanel.ValidateParameter(Token, "Setting Changed");
		}
	}
	
	public void verifySettingChangedEventAfterParentalPinIsSet(String userType) throws Exception {
		if (!(userType.equalsIgnoreCase("Guest"))) {

			extent.HeaderChildNode("Verify Setting Changed Event when Parental Control PIN is Set");
			click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger menu");
			click(PWAHamburgerMenuPage.objParentalControl, "ParentalControl");
			checkElementDisplayed(PWALoginPage.objPasswordField, "password field");
			String password = "";
			if (userType.equals("NonSubscribedUser")) {
				password = getParameterFromXML("SettingsNonsubscribedPassword");
			} else if (userType.equals("SubscribedUser")) {
				password = getParameterFromXML("SettingsSubscribedPassword");
			}
			type(PWALoginPage.objPasswordField, password, "Password field");
			click(PWAHamburgerMenuPage.objContinueButtonInVerifyAccount, "Continue button");
			waitTime(2000);
			click(PWAHamburgerMenuPage.objRestrictAll, "Restrict all option");
			click(PWAHamburgerMenuPage.objParentalLockPin1, "Set Lock Field");
			type(PWAHamburgerMenuPage.objParentalLockPin1, "1", "ParentalLockPin");
			type(PWAHamburgerMenuPage.objParentalLockPin2, "2", "ParentalLockPin");
			type(PWAHamburgerMenuPage.objParentalLockPin3, "3", "ParentalLockPin");
			type(PWAHamburgerMenuPage.objParentalLockPin4, "4", "ParentalLockPin");
			waitTime(4000);
			click(PWAHamburgerMenuPage.objSetParentalLockButton, "Set Parental lock button");
			waitTime(2000);
			mixpanel.FEProp.setProperty("Source", "home");
			mixpanel.FEProp.setProperty("Page Name", "parental_control");
			mixpanel.FEProp.setProperty("Setting Changed", "Parental Control Age Set");
			mixpanel.FEProp.setProperty("Element", "Set parental lock");
			String Token;
			if (!userType.equals("Guest")) {
				Token = js.executeScript("return window.localStorage.getItem('ID');").toString();
			} else {
				Token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			}
			mixpanel.ValidateParameter(Token, "Setting Changed");
		}
	}

	public void verifySettingChangedEventAfterAgeIsSet(String userType) throws Exception {
		if (!(userType.equalsIgnoreCase("Guest"))) {

			extent.HeaderChildNode("Verify Setting Changed Event when Parental Control Age is Set");
			click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger menu");
			click(PWAHamburgerMenuPage.objParentalControl, "ParentalControl");
			checkElementDisplayed(PWALoginPage.objPasswordField, "password field");
			String password = "";
			if (userType.equals("NonSubscribedUser")) {
				password = getParameterFromXML("SettingsNonsubscribedPassword");
			} else if (userType.equals("SubscribedUser")) {
				password = getParameterFromXML("SettingsSubscribedPassword");
			}
			type(PWALoginPage.objPasswordField, password, "Password field");
			click(PWAHamburgerMenuPage.objContinueButtonInVerifyAccount, "Continue button");
			waitTime(2000);
			click(PWAHamburgerMenuPage.objRestrict13PlusContent, "Restrict 13+ Content");
			click(PWAHamburgerMenuPage.objParentalLockPin1, "Set Lock Field");
			type(PWAHamburgerMenuPage.objParentalLockPin1, "1", "ParentalLockPin");
			type(PWAHamburgerMenuPage.objParentalLockPin2, "2", "ParentalLockPin");
			type(PWAHamburgerMenuPage.objParentalLockPin3, "3", "ParentalLockPin");
			type(PWAHamburgerMenuPage.objParentalLockPin4, "4", "ParentalLockPin");
			waitTime(4000);
			click(PWAHamburgerMenuPage.objSetParentalLockButton, "Set Parental lock button");
			waitTime(2000);
			mixpanel.FEProp.setProperty("Source", "home");
			mixpanel.FEProp.setProperty("Page Name", "parental_control");
			mixpanel.FEProp.setProperty("Setting Changed", "Parental Control Age Set");
			mixpanel.FEProp.setProperty("Element", "Set parental lock");
			mixpanel.FEProp.setProperty("Parent Control Setting", "U/A");
			String Token;
			if (!userType.equals("Guest")) {
				Token = js.executeScript("return window.localStorage.getItem('ID');").toString();
			} else {
				Token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			}
			mixpanel.ValidateParameter(Token, "Setting Changed");
		}
	}
	
	public void verifyPopUpCTAsEvent(String userType, String keyword6) throws Exception {
		if (!(userType.equalsIgnoreCase("SubscribedUser"))) {
			extent.HeaderChildNode("Verify Pop Up CTA's Event when user clicks on CTA button displayed on the popup");

			click(PWAHomePage.objSearchBtn, "Search Icon");
			type(PWASearchPage.objSearchEditBox, keyword6 + "\n", "Search Edit box: " + keyword6);
			waitTime(4000);
			waitForElement(PWASearchPage.objSearchResultTxt(keyword6), 10, "Search Result");
			click(PWASearchPage.objSearchResultTxt(keyword6), "Search Result");

			if (checkElementDisplayed(PWAHamburgerMenuPage.objGetPremiumPopup, "GET PREMIUM POPUP") == true) {
				verifyElementPresentAndClick(PWAHamburgerMenuPage.objPopupClose, "POP-UP CLOSE BUTTON");
			}
			mixpanel.FEProp.setProperty("Source", "search");
			mixpanel.FEProp.setProperty("Element", "Cross");
			mixpanel.FEProp.setProperty("Page Name", "movie_detail");
			String id = getDriver().getCurrentUrl();
			Pattern p = Pattern.compile("[0-9]-[0-9]-[0-9]+");
			Matcher m = p.matcher(id);
			m.find();
			ResponseInstance.getContentDetails(m.group(0));
			String Token;
			if (!userType.equals("Guest")) {
				Token = js.executeScript("return window.localStorage.getItem('ID');").toString();
			} else {
				Token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			}
			mixpanel.ValidateParameter(Token, "Pop Up CTAs");
		}
	}
	
	public void verifyLoginUsernameEnteredEvent(String LoginMethod, String EventName) throws Exception {
		String userType = getParameterFromXML("userType");
		waitTime(5000);
		switch (userType) {
		case "Guest":
			extent.HeaderChildNode("Guest User");
			extent.extentLogger("Accessing the application as Guest user", "Accessing the application as Guest user");
//			dismissDisplayContentLanguagePopUp();
//			waitTime(3000);
			break;

		case "NonSubscribedUser":
			extent.HeaderChildNode("Login as NonSubscribed User");
			Username = getParameterFromXML("NonsubscribedUserName");
			Password = getParameterFromXML("NonsubscribedUserPassword");
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
			Username = getParameterFromXML("SubscribedUserName");
			Password = getParameterFromXML("SubscribedUserPassword");
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
		}
		mixpanel.FEProp.setProperty("Source", "home");
		mixpanel.FEProp.setProperty("Page Name", "sign_in");
		String Token;
		if (!userType.equals("Guest")) {
			Token = js.executeScript("return window.localStorage.getItem('ID');").toString();
		} else {
			Token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
		}
		
		if (EventName.equals("UserName")) {
			mixpanel.ValidateParameter(Token, "Login Username Entered");
		} else {
			mixpanel.ValidateParameter(Token, "Login Password Entered");
		}
	}
	
	public void verifySearchCancelledEvent() throws Exception {
		extent.HeaderChildNode("Verify Search Cancelled Event");
		click(PWAHomePage.objSearchBtn, "Search Icon");
		click(PWASearchPage.objBackButton, "Back Button");
		mixpanel.FEProp.setProperty("Source", "home");
		mixpanel.FEProp.setProperty("Page Name", "search");
		mixpanel.FEProp.setProperty("Results Returned", "0");
		mixpanel.FEProp.setProperty("Search Query", "N/A");
		mixpanel.FEProp.setProperty("Search Type", "N/A");
		String Token;
		if (!userType.equals("Guest")) {
			Token = js.executeScript("return window.localStorage.getItem('ID');").toString();
		} else {
			Token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
		}
		mixpanel.ValidateParameter(Token, "Search Cancelled");
	}
	
	public void verifyAdBannerImpressionEvent(String tabName) throws Exception {
		extent.HeaderChildNode("Verify Ad Banner Impression Event Across tabs");
		navigateToAnyScreen(tabName);
		waitTime(8000);
		checkElementDisplayed(PWAHomePage.objAdBanner, "Ad Banner");
		String Token;
		if (!userType.equals("Guest")) {
			Token = js.executeScript("return window.localStorage.getItem('ID');").toString();
		} else {
			Token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
		}
		mixpanel.ValidateParameter(Token, "Ad Banner Impression");
	}
	
	public void verifyProfileUpdateResultEvent(String userType) throws Exception {
		if (!(userType.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode("Verify Profile Update Result Event");
			waitTime(5000);
			click(PWALandingPages.objWebProfileIcon, "Profile Icon");
			click(PWAHamburgerMenuPage.objProfileIconInProfilePage, "profile icon");
			verifyElementPresentAndClick(PWAHamburgerMenuPage.objProfileEditBtn, "Edit button");
			verifyElementPresent(PWAHamburgerMenuPage.objEditProfileTextWEB, "edit profile page");
			verifyElementPresentAndClick(PWAHamburgerMenuPage.objEditProfileFirstName, "First name column");
			clearField(PWAHamburgerMenuPage.objEditProfileFirstName, "email field");
			type(PWAHamburgerMenuPage.objEditProfileFirstName, "Zee5", "Editprofile first name");
			verifyElementPresentAndClick(PWAHamburgerMenuPage.objEditProfileSavechangesBtn, "save changes");
			waitTime(2000);
			mixpanel.FEProp.setProperty("Source", "home");
			mixpanel.FEProp.setProperty("Page Name", "my_profile");
			mixpanel.FEProp.setProperty("Partner Name", "Zee5");
			String Token;
			Token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			mixpanel.ValidateParameter(Token, "Profile Update Result");
		}
	}
	
	public void verifyEpisodeListChosenEventFromShowDetailPage(String keyword) throws Exception {
		extent.HeaderChildNode("Verify Episode List Chosen Event in Show Detail page");
		click(PWAHomePage.objSearchBtn, "Search Icon");
		type(PWASearchPage.objSearchEditBox, keyword + "\n", "Search Edit box: " + keyword);
		waitTime(4000);
		click(PWASearchPage.objSearchResult(keyword), "Search Result");
		waitTime(4000);
		click(PWAShowsPage.objShowDetailEpisodeDropdown, "Episode Dropdown");
		click(PWAShowsPage.objShowDetailEpisodeDropdownValues(2), "Episodes 11-20");
		waitTime(5000);
		mixpanel.FEProp.setProperty("Source", "search");
		mixpanel.FEProp.setProperty("Page Name", "show_detail");
		mixpanel.FEProp.setProperty("Series", "Jodi Hakki");
		String Token;
		if (!userType.equals("Guest")) {
			Token = js.executeScript("return window.localStorage.getItem('ID');").toString();
		} else {
			Token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
		}
		mixpanel.ValidateParameter(Token, "Episode list Chosen");
	}
	
	public void verifyContentBucketSwipeEventFromShowDetailPage(String keyword) throws Exception {
		extent.HeaderChildNode("Verify Content Bucket Swipe Event in Show Detail page");
		click(PWAHomePage.objSearchBtn, "Search Icon");
		type(PWASearchPage.objSearchEditBox, keyword + "\n", "Search Edit box: " + keyword);
		waitTime(4000);
		click(PWASearchPage.objSearchResult(keyword), "Search Result");
		swipeTumbnailToLeft();
		String TrayTitle = findElement(By.xpath("(.//*[@class='trayHeader']//*[@class='titleLink'])[1]")).getText();
		String link = findElement(By.xpath("(.//*[@class='trayHeader']//*[@class='titleLink'])[1]")).getAttribute("href");
		Pattern p = Pattern.compile("[0-9]-[0-9]-[0-9]+");
		Matcher m = p.matcher(link);
		String value = null;
		while (m.find()) {
			value = m.group(0);
		}
		mixpanel.FEProp.setProperty("Carousal ID", value);
		mixpanel.FEProp.setProperty("Carousal Name",TrayTitle);
		mixpanel.FEProp.setProperty("Source", "search");
		mixpanel.FEProp.setProperty("Page Name", "show_detail");
		mixpanel.FEProp.setProperty("Element", "right-arrow");
		mixpanel.FEProp.setProperty("Direction", "Right");
		String Token;
		if (!userType.equals("Guest")) {
			Token = js.executeScript("return window.localStorage.getItem('ID');").toString();
		} else {
			Token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
		}
		mixpanel.ValidateParameter(Token, "Content Bucket Swipe");
	}
	
	public void verifyContentBucketSwipeEvent(String tabName) throws Exception {
		extent.HeaderChildNode("Verify Content Bucket Swipe Event Across tabs");
		navigateToAnyScreen(tabName);
		waitTime(5000);
		swipeTumbnailToLeft();
		String TrayTitle = findElement(By.xpath("(.//*[@class='trayHeader']//*[@class='titleLink'])[1]")).getText();
		String link = findElement(By.xpath("(.//*[@class='trayHeader']//*[@class='titleLink'])[1]")).getAttribute("href");
		Pattern p = Pattern.compile("[0-9]-[0-9]-[0-9]+");
		Matcher m = p.matcher(link);
		String value = null;
		while (m.find()) {
			value = m.group(0);
		}
		mixpanel.FEProp.setProperty("Carousal ID", value);
		mixpanel.FEProp.setProperty("Carousal Name",TrayTitle);
		mixpanel.FEProp.setProperty("Source", "home");
		mixpanel.FEProp.setProperty("Page Name", "tv_shows_view_all");
		mixpanel.FEProp.setProperty("Element", "right-arrow");
		mixpanel.FEProp.setProperty("Direction", "Right");
		String Token;
		if (!userType.equals("Guest")) {
			Token = js.executeScript("return window.localStorage.getItem('ID');").toString();
		} else {
			Token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
		}
		mixpanel.ValidateParameter(Token, "Content Bucket Swipe");
	}
	
	public void verifyContentBucketSwipeEventInPlaybackPage(String keyword1) throws Exception {

		extent.HeaderChildNode("Verify Content Bucket Swipe Event in Playback page");

		click(PWAHomePage.objSearchBtn, "Search Icon");
		type(PWASearchPage.objSearchEditBox, keyword1 + "\n", "Search Edit box: " + keyword1);
		waitTime(4000);
		verifyElementPresentAndClick(PWASearchPage.objSearchResult(keyword1), "Search Result");
		waitTime(5000);
		swipeTumbnailToLeft();
		String TrayTitle = findElement(By.xpath("(.//*[@class='trayHeader']//*[@class='titleLink'])[1]")).getText();
		String link = findElement(By.xpath("(.//*[@class='trayHeader']//*[@class='titleLink'])[1]")).getAttribute("href");
		Pattern p = Pattern.compile("[0-9]-[0-9]-[0-9]+");
		Matcher m = p.matcher(link);
		String value = null;
		while (m.find()) {
			value = m.group(0);
		}
		mixpanel.FEProp.setProperty("Carousal ID", value);
		mixpanel.FEProp.setProperty("Carousal Name",TrayTitle);
		mixpanel.FEProp.setProperty("Source", "search");
		mixpanel.FEProp.setProperty("Page Name", "movie_detail");
		mixpanel.FEProp.setProperty("Element", "right-arrow");
		mixpanel.FEProp.setProperty("Direction", "Right");
		String Token;
		if (!userType.equals("Guest")) {
			Token = js.executeScript("return window.localStorage.getItem('ID');").toString();
		} else {
			Token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
		}
		mixpanel.ValidateParameter(Token, "Content Bucket Swipe");
	}
	
	public void swipeTumbnailToLeft() throws InterruptedException {
		WebElement sourceLocator = getDriver().findElement(By.xpath("((((//div[.='']//parent::*//parent::*//parent::*)//child::*[@class='movieTrayWrapper'])//child::*[1][@class='noSelect clickWrapper'])[4])"));
		WebElement targetLocator = getDriver().findElement(By.xpath("((((//div[.='']//parent::*//parent::*//parent::*)//child::*[@class='movieTrayWrapper'])//child::*[1][@class='noSelect clickWrapper'])[2])"));
		Thread.sleep(4000);
		Actions action = new Actions(getDriver());
		action.dragAndDrop(sourceLocator, targetLocator).build().perform();
	}
	
	public void verifyBannerAutoplayEventForNewsContent() throws Exception {
		extent.HeaderChildNode("Verify Banner Autoplay Event For News Content");
		navigateToAnyScreen("News");
		waitForElementDisplayed(PWANewsPage.objVolume, 30);
		
		mixpanel.FEProp.setProperty("Source", "news_landing");
		mixpanel.FEProp.setProperty("Page Name", "news_landing");
		mixpanel.FEProp.setProperty("Player Name", "kaltura-player-js");
		mixpanel.FEProp.setProperty("Video Autoplay", "true");
		mixpanel.FEProp.setProperty("Tab Name", "news_landing");

		String id = getDriver().getCurrentUrl();
		Pattern p = Pattern.compile("[0-9]-[0-9]-[0-9]+");
		Matcher m = p.matcher(id);
		String value = null;
		while (m.find()) {
			value = m.group(0);
		}
		ResponseInstance.getContentDetails(value);
		
		if (userType.equals("Guest")) {
			String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			mixpanel.ValidateParameter(gToken, "Banner Autoplay");
		} else {
			String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
			mixpanel.ValidateParameter(ID, "Banner Autoplay");
		}
	}
	
	public void verifyVideoViewEventForFreeContent(String tab,String api,String userType,String un,String pwd) throws Exception {
		extent.HeaderChildNode("Verify Video View Event For Free Content");

		navigateToAnyScreen(tab);

		if (ResponseInstance.getFreeContent(api, un, pwd).equals("No Free Contents")) {
			if (userType.equals("NonSubscribedUser")) {
				WebElement mastHeadEle = (new WebDriverWait(getDriver(), 60))
						.until(ExpectedConditions.presenceOfElementLocated(PWAHomePage
								.objContTitleTextCarouselWeb(ResponseInstance.getFreeContent(api, un, pwd))));
				mastHeadEle.click();
			} else if (!userType.equals("")) {
				WebElement mastHeadEle = (new WebDriverWait(getDriver(), 60))
						.until(ExpectedConditions.presenceOfElementLocated(PWAHomePage
								.objContTitleTextCarouselWeb(ResponseInstance.getFreeContent(api, un, pwd))));
				mastHeadEle.click();
			}

			waitTime(5000);
			waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
			mixpanel.FEProp.setProperty("Source", "home");
			mixpanel.FEProp.setProperty("Page Name", "movie_detail");
			mixpanel.FEProp.setProperty("Player Name", "kaltura-player-js");
			mixpanel.FEProp.setProperty("Video View", "1");

			String id = getDriver().getCurrentUrl();
			Pattern p = Pattern.compile("[0-9]-[0-9]-[0-9]+");
			Matcher m = p.matcher(id);
			String value = null;
			while (m.find()) {
				value = m.group(0);
			}
			ResponseInstance.getContentDetails(value);
			
			if (userType.equals("Guest")) {
				String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
				mixpanel.ValidateParameter(gToken, "Video View");
			} else {
				String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
				mixpanel.ValidateParameter(ID, "Video View");
			}
		}
	}
	
	public void verifyVideoViewEventForPremiumContent(String userType, String tab) throws Exception {
		if (userType.equalsIgnoreCase("SubscribedUser")) {
			extent.HeaderChildNode("Verify Video View Event For Premium Content");
			navigateToAnyScreen(tab);
			waitTime(8000);
			partialScrollDown();
			click(PWAPremiumPage.objPremiumTag, "Premium Content");
			waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
			mixpanel.FEProp.setProperty("Source", "home");
			mixpanel.FEProp.setProperty("Page Name", "movie_detail");
			mixpanel.FEProp.setProperty("Player Name", "kaltura-player-js");
			mixpanel.FEProp.setProperty("Video View", "1");

			String id = getDriver().getCurrentUrl();
			Pattern p = Pattern.compile("[0-9]-[0-9]-[0-9]+");
			Matcher m = p.matcher(id);
			String value = null;
			while (m.find()) {
				value = m.group(0);
			}
			ResponseInstance.getContentDetails(value);
			if (userType.equals("Guest")) {
				String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
				mixpanel.ValidateParameter(gToken, "Video View");
			} else {
				String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
				mixpanel.ValidateParameter(ID, "Video View");
			}

		}
	}

	public void verifyVideoViewEventForTrailer(String keyword1) throws Exception {
		extent.HeaderChildNode("Verify Video View Event For Trailer Content");
		click(PWAHomePage.objSearchBtn, "Search Icon");
		type(PWASearchPage.objSearchEditBox, keyword1 + "\n", "Search Edit box: " + keyword1);
		waitTime(4000);
		waitForElement(PWASearchPage.objSearchResult(keyword1), 10, "Search Result");
		click(PWASearchPage.objSearchResult(keyword1), "Search Result");
		waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
		waitTime(6000);

		mixpanel.FEProp.setProperty("Source", "search");
		mixpanel.FEProp.setProperty("Page Name", "movie_detail");
		mixpanel.FEProp.setProperty("Player Name", "kaltura-player-js");
		mixpanel.FEProp.setProperty("Video View", "1");
		String id = getDriver().getCurrentUrl();
		Pattern p = Pattern.compile("[0-9]-[0-9]-[0-9]+");
		Matcher m = p.matcher(id);
		String value = null;
		while (m.find()) {
			value = m.group(0);
		}
		ResponseInstance.getContentDetails(value);

		if (userType.equals("Guest")) {
			String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			mixpanel.ValidateParameter(gToken, "Video View");
		} else {
			String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
			mixpanel.ValidateParameter(ID, "Video View");
		}

	}

	public void verifyVideoViewEventForCarouselContent() throws Exception {
		extent.HeaderChildNode("Verify Video View Event For Carousel Content");
		waitTime(5000);
		click(PWAPremiumPage.objWEBMastheadCarousel, "Carousel Content");
		waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
		waitTime(6000);

		mixpanel.FEProp.setProperty("Source", "home");
		mixpanel.FEProp.setProperty("Page Name", "movie_detail");
		mixpanel.FEProp.setProperty("Player Name", "kaltura-player-js");
		mixpanel.FEProp.setProperty("Video View", "1");
		String id = getDriver().getCurrentUrl();
		Pattern p = Pattern.compile("[0-9]-[0-9]-[0-9]+");
		Matcher m = p.matcher(id);
		String value = null;
		while (m.find()) {
			value = m.group(0);
		}
		ResponseInstance.getContentDetails(value);
		if (userType.equals("Guest")) {
			String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			mixpanel.ValidateParameter(gToken, "Video View");
		} else {
			String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
			mixpanel.ValidateParameter(ID, "Video View");
		}

	}

	public void verifyVideoViewEventForContentInTray() throws Exception {
		extent.HeaderChildNode("Verify Video View Event For Content played from Tray");
		click(PWAPremiumPage.objThumbnail, "Content From a tray");
		waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
		waitTime(6000);

		mixpanel.FEProp.setProperty("Source", "home");
		mixpanel.FEProp.setProperty("Page Name", "movie_detail");
		mixpanel.FEProp.setProperty("Player Name", "kaltura-player-js");
		mixpanel.FEProp.setProperty("Video View", "1");
		String id = getDriver().getCurrentUrl();
		Pattern p = Pattern.compile("[0-9]-[0-9]-[0-9]+");
		Matcher m = p.matcher(id);
		String value = null;
		while (m.find()) {
			value = m.group(0);
		}
		ResponseInstance.getContentDetails(value);
		if (userType.equals("Guest")) {
			String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			mixpanel.ValidateParameter(gToken, "Video View");
		} else {
			String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
			mixpanel.ValidateParameter(ID, "Video View");
		}

	}

	public void verifyVideoViewEventForContentFromSearchPage(String keyword1) throws Exception {
		extent.HeaderChildNode("Verify Video View Event For Content From Search Page");
		click(PWAHomePage.objSearchBtn, "Search Icon");
		type(PWASearchPage.objSearchEditBox, keyword1 + "\n", "Search Edit box: " + keyword1);
		waitTime(4000);
		waitForElement(PWASearchPage.objSearchResult(keyword1), 10, "Search Result");
		click(PWASearchPage.objSearchResult(keyword1), "Search Result");
		waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
		waitTime(6000);

		mixpanel.FEProp.setProperty("Source", "search");
		mixpanel.FEProp.setProperty("Page Name", "movie_detail");
		mixpanel.FEProp.setProperty("Player Name", "kaltura-player-js");
		mixpanel.FEProp.setProperty("Video View", "1");
		String id = getDriver().getCurrentUrl();
		Pattern p = Pattern.compile("[0-9]-[0-9]-[0-9]+");
		Matcher m = p.matcher(id);
		String value = null;
		while (m.find()) {
			value = m.group(0);
		}
		ResponseInstance.getContentDetails(value);
	
		if (userType.equals("Guest")) {
			String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			mixpanel.ValidateParameter(gToken, "Video View");
		} else {
			String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
			mixpanel.ValidateParameter(ID, "Video View");
		}

	}

	public void verifyVideoViewEventForContentFromMyWatchlistPage(String userType, String keyword) throws Exception {
		if (!(userType.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode("Verify Video View Event For Content From My Watchlist Page");
			click(PWAHomePage.objSearchBtn, "Search Icon");
			type(PWASearchPage.objSearchEditBox, keyword + "\n", "Search Edit box: " + keyword);
			waitTime(4000);
			waitForElement(PWASearchPage.objSearchResult(keyword), 10, "Search Result");
			click(PWASearchPage.objSearchResult(keyword), "Search Result");

			Actions actions = new Actions(getDriver());
			WebElement contentCard = getDriver().findElement(PWAPremiumPage.obj1stContentInShowDetailPage);
			actions.moveToElement(contentCard).build().perform();

			if (checkElementDisplayed(PWAPremiumPage.objContentCardAddToWatchlistBtn, "Add To Watchlist icon")) {
				click(PWAPremiumPage.objContentCardAddToWatchlistBtn, "Add To Watchlist icon");
			}
			click(PWALandingPages.objWebProfileIcon, "Profile icon");
			click(PWAAddToWatchListPage.objMyWatchList, "My Watchlist option");

			click(PWAAddToWatchListPage.objWatchlistedItems, "Content Card in Watchlist page");
			mandatoryRegistrationPopUp(userType);
			waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
			waitTime(6000);

			mixpanel.FEProp.setProperty("Source", "show_detail");
			mixpanel.FEProp.setProperty("Page Name", "episode_detail");
			mixpanel.FEProp.setProperty("Player Name", "kaltura-player-js");
			mixpanel.FEProp.setProperty("Video View", "1");
			String id = getDriver().getCurrentUrl();
			Pattern p = Pattern.compile("[0-9]-[0-9]-[0-9]+");
			Matcher m = p.matcher(id);
			String value = null;
			while (m.find()) {
				value = m.group(0);
			}
			ResponseInstance.getContentDetails(value);
			if (userType.equals("Guest")) {
				String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
				mixpanel.ValidateParameter(gToken, "Video View");
			} else {
				String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
				mixpanel.ValidateParameter(ID, "Video View");
			}
		}
	}

	public void verifyVideoViewEventForContentInMegamenu() throws Exception {
		extent.HeaderChildNode("Verify Video View Event For Content played from Megamenu");
		waitTime(5000);
		Actions actions = new Actions(getDriver());
		WebElement contentCard = getDriver().findElement(PWAHomePage.objHomeBarText("Movies"));
		actions.moveToElement(contentCard).build().perform();

		click(PWAPlayerPage.megaMenuContentCard, "Content Card in Megamenu");
		waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
		waitTime(6000);

		mixpanel.FEProp.setProperty("Source", "home");
		mixpanel.FEProp.setProperty("Page Name", "movie_detail");
		mixpanel.FEProp.setProperty("Player Name", "kaltura-player-js");
		mixpanel.FEProp.setProperty("Video View", "1");
		String id = getDriver().getCurrentUrl();
		Pattern p = Pattern.compile("[0-9]-[0-9]-[0-9]+");
		Matcher m = p.matcher(id);
		String value = null;
		while (m.find()) {
			value = m.group(0);
		}
		ResponseInstance.getContentDetails(value);
		if (userType.equals("Guest")) {
			String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			mixpanel.ValidateParameter(gToken, "Video View");
		} else {
			String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
			mixpanel.ValidateParameter(ID, "Video View");
		}

	}

	public void verifyVideoViewEventForContentInPlaylist(String userType, String keyword) throws Exception {
		extent.HeaderChildNode("Verify Video View Event For Content played from Playlist");
		click(PWAHomePage.objSearchBtn, "Search Icon");
		type(PWASearchPage.objSearchEditBox, keyword + "\n", "Search Edit box: " + keyword);
		waitTime(4000);
		verifyElementPresentAndClick(PWASearchPage.objSearchResult(keyword), "Search Result");
		waitForPlayerAdToComplete("Video Player");
		click(PWAPremiumPage.obj1stContentInViewAllPage, "Content From a tray");
		mandatoryRegistrationPopUp(userType);
		waitTime(2000);
		click(PWAPremiumPage.objContentInPlaylist, "Content card in Playlist");
		waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
		waitTime(6000);

		mixpanel.FEProp.setProperty("Source", "show_detail");
		mixpanel.FEProp.setProperty("Page Name", "episode_detail");
		mixpanel.FEProp.setProperty("Player Name", "kaltura-player-js");
		mixpanel.FEProp.setProperty("Video View", "1");

		String id = getDriver().getCurrentUrl();
		Pattern p = Pattern.compile("[0-9]-[0-9]-[0-9]+");
		Matcher m = p.matcher(id);
		String value = null;
		while (m.find()) {
			value = m.group(0);
		}
		ResponseInstance.getContentDetails(value);
		if (userType.equals("Guest")) {
			String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			mixpanel.ValidateParameter(gToken, "Video View");
		} else {
			String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
			mixpanel.ValidateParameter(ID, "Video View");
		}
	}

	public void verifyVideoViewEventAfterRefreshingPage(String keyword1) throws Exception {
		extent.HeaderChildNode("Verify Video View Event after refreshing a page");
		click(PWAHomePage.objSearchBtn, "Search Icon");
		type(PWASearchPage.objSearchEditBox, keyword1 + "\n", "Search Edit box: " + keyword1);
		waitTime(4000);
		waitForElement(PWASearchPage.objSearchResult(keyword1), 10, "Search Result");
		click(PWASearchPage.objSearchResult(keyword1), "Search Result");
		waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
		waitTime(6000);
		getDriver().navigate().refresh();
		waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
		waitTime(6000);
		mixpanel.FEProp.setProperty("Source", "N/A");
		mixpanel.FEProp.setProperty("Page Name", "movie_detail");
		mixpanel.FEProp.setProperty("Player Name", "kaltura-player-js");
		mixpanel.FEProp.setProperty("Video View", "1");
		String id = getDriver().getCurrentUrl();
		Pattern p = Pattern.compile("[0-9]-[0-9]-[0-9]+");
		Matcher m = p.matcher(id);
		String value = null;
		while (m.find()) {
			value = m.group(0);
		}
		ResponseInstance.getContentDetails(value);
		if (userType.equals("Guest")) {
			String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			mixpanel.ValidateParameter(gToken, "Video View");
		} else {
			String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
			mixpanel.ValidateParameter(ID, "Video View");
		}
	}
	
	public void verifyVideoViewEventForContentFromUpnextRail(String userType, String keyword4) throws Exception {
		extent.HeaderChildNode("Verify Video View Event for content autoplayed from Upnext rail");
		click(PWAHomePage.objSearchBtn, "Search Icon");
		type(PWASearchPage.objSearchEditBox, keyword4 + "\n", "Search Edit box: " + keyword4);
		waitForElement(PWASearchPage.objSearchResult(keyword4), 20, "Search Result");
		click(PWASearchPage.objSearchResult(keyword4), "Search Result");
		click(PWAPlayerPage.objPromo, "Play Icon");
		waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
		mandatoryRegistrationPopUp(userType);
		waitForPlayerAdToComplete("Video Player");
		waitTime(6000);
		click(PWAPlayerPage.objPlaybackVideoOverlay, "Player");
		playerScrubTillLastWeb();
		click(PWAPlayerPage.objPlayerPlay, "Play Icon");
		waitTime(6000);
		waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
		mixpanel.FEProp.setProperty("Source", "episode_detail");
		mixpanel.FEProp.setProperty("Page Name", "episode_detail");
		mixpanel.FEProp.setProperty("Player Name", "kaltura-player-js");
		mixpanel.FEProp.setProperty("Video View", "1");
		String id = getDriver().getCurrentUrl();
		Pattern p = Pattern.compile("[0-9]-[0-9]-[0-9]+");
		Matcher m = p.matcher(id);
		String value = null;
		while (m.find()) {
			value = m.group(0);
		}
		ResponseInstance.getContentDetails(value);
		if (userType.equals("Guest")) {
			String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			mixpanel.ValidateParameter(gToken, "Video View");
		} else {
			String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
			mixpanel.ValidateParameter(ID, "Video View");
		}
	}

	public void verifyVideoViewEventForContentFromSharedLink(String freeContentURL) throws Exception {
		extent.HeaderChildNode("Verify Video View Event For content played from Shared Link");
		getDriver().get(freeContentURL);
		waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);

		mixpanel.FEProp.setProperty("Source", "home");
		mixpanel.FEProp.setProperty("Page Name", "movie_detail");
		mixpanel.FEProp.setProperty("Player Name", "kaltura-player-js");
		mixpanel.FEProp.setProperty("Video View", "1");

		String id = getDriver().getCurrentUrl();
		Pattern p = Pattern.compile("[0-9]-[0-9]-[0-9]+");
		Matcher m = p.matcher(id);
		String value = null;
		while (m.find()) {
			value = m.group(0);
		}
		ResponseInstance.getContentDetails(value);
		if (userType.equals("Guest")) {
			String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			mixpanel.ValidateParameter(gToken, "Video View");
		} else {
			String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
			mixpanel.ValidateParameter(ID, "Video View");
		}
	}

	public void playerScrubTillLastWeb() {
		WebElement scrubber = getDriver().findElement(PWAPlayerPage.objPlayerScrubber);
		WebElement progressBar = getDriver().findElement(PWAPlayerPage.objPlayerProgressBar);
		Actions action = new Actions(getDriver());
		action.clickAndHold(scrubber).moveToElement(progressBar, 350, 0).release().perform();
	}

	
	public void verifyVideoExitEventForFreeContent(String tab,String api,String userType,String un,String pwd) throws Exception {
		extent.HeaderChildNode("Verify Video Exit Event For Free Content");

		navigateToAnyScreen(tab);

		if (ResponseInstance.getFreeContent(api, un, pwd).equals("No Free Contents")) {
			if (userType.equals("NonSubscribedUser")) {
				WebElement mastHeadEle = (new WebDriverWait(getDriver(), 60))
						.until(ExpectedConditions.presenceOfElementLocated(PWAHomePage
								.objContTitleTextCarouselWeb(ResponseInstance.getFreeContent(api, un, pwd))));
				mastHeadEle.click();
			} else if (!userType.equals("")) {
				WebElement mastHeadEle = (new WebDriverWait(getDriver(), 60))
						.until(ExpectedConditions.presenceOfElementLocated(PWAHomePage
								.objContTitleTextCarouselWeb(ResponseInstance.getFreeContent(api, un, pwd))));
				mastHeadEle.click();
			}

			waitTime(5000);
			waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
			mixpanel.FEProp.setProperty("Source", "home");
			mixpanel.FEProp.setProperty("Page Name", "movie_detail");
			mixpanel.FEProp.setProperty("Player Name", "kaltura-player-js");
			
			String id = getDriver().getCurrentUrl();
			Pattern p = Pattern.compile("[0-9]-[0-9]-[0-9]+");
			Matcher m = p.matcher(id);
			String value = null;
			while (m.find()) {
				value = m.group(0);
			}
			ResponseInstance.getContentDetails(value);
			Back(1);
			if (userType.equals("Guest")) {
				String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
				mixpanel.ValidateParameter(gToken, "Video Exit");
			} else {
				String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
				mixpanel.ValidateParameter(ID, "Video Exit");
			}
		}
	}
	

	public void verifyVideoExitEventForPremiumContent(String userType, String tab) throws Exception {
		if (userType.equalsIgnoreCase("SubscribedUser")) {
			extent.HeaderChildNode("Verify Video Exit Event For Premium Content");
			navigateToAnyScreen(tab);
			click(PWAPremiumPage.objPremiumTag, "Premium Content");
			waitTime(6000);
			waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
			mixpanel.FEProp.setProperty("Source", "home");
			mixpanel.FEProp.setProperty("Page Name", "movie_detail");
			mixpanel.FEProp.setProperty("Player Name", "kaltura-player-js");
			String id = getDriver().getCurrentUrl();
			Pattern p = Pattern.compile("[0-9]-[0-9]-[0-9]+");
			Matcher m = p.matcher(id);
			String value = null;
			while (m.find()) {
				value = m.group(0);
			}
			ResponseInstance.getContentDetails(value);
			Back(1);
			
			if (userType.equals("Guest")) {
				String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
				mixpanel.ValidateParameter(gToken, "Video Exit");
			} else {
				String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
				mixpanel.ValidateParameter(ID, "Video Exit");
			}
		}
	}

	public void verifyVideoExitEventForTrailer(String keyword1) throws Exception {
		extent.HeaderChildNode("Verify Video Exit Event For Trailer Content");
		click(PWAHomePage.objSearchBtn, "Search Icon");
		type(PWASearchPage.objSearchEditBox, keyword1 + "\n", "Search Edit box: " + keyword1);
		waitTime(4000);
		waitForElement(PWASearchPage.objSearchResult(keyword1), 10, "Search Result");
		click(PWASearchPage.objSearchResult(keyword1), "Search Result");
		waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
		waitTime(6000);
		mixpanel.FEProp.setProperty("Source", "search");
		mixpanel.FEProp.setProperty("Page Name", "movie_detail");
		mixpanel.FEProp.setProperty("Player Name", "kaltura-player-js");
		String id = getDriver().getCurrentUrl();
		Pattern p = Pattern.compile("[0-9]-[0-9]-[0-9]+");
		Matcher m = p.matcher(id);
		String value = null;
		while (m.find()) {
			value = m.group(0);
		}
		ResponseInstance.getContentDetails(value);
		Back(1);
		if (userType.equals("Guest")) {
			String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			mixpanel.ValidateParameter(gToken, "Video Exit");
		} else {
			String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
			mixpanel.ValidateParameter(ID, "Video Exit");
		}
	}

	public void verifyVideoExitEventForCarouselContent() throws Exception {
		extent.HeaderChildNode("Verify Video Exit Event For Carousel Content");
		waitTime(5000);
		click(PWAPremiumPage.objWEBMastheadCarousel, "Carousel Content");
		waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
		waitTime(6000);
		mixpanel.FEProp.setProperty("Source", "home");
		mixpanel.FEProp.setProperty("Page Name", "movie_detail");
		mixpanel.FEProp.setProperty("Player Name", "kaltura-player-js");

		String id = getDriver().getCurrentUrl();
		Pattern p = Pattern.compile("[0-9]-[0-9]-[0-9]+");
		Matcher m = p.matcher(id);
		String value = null;
		while (m.find()) {
			value = m.group(0);
		}
		ResponseInstance.getContentDetails(value);
		Back(1);
		
		if (userType.equals("Guest")) {
			String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			mixpanel.ValidateParameter(gToken, "Video Exit");
		} else {
			String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
			mixpanel.ValidateParameter(ID, "Video Exit");
		}
	}

	public void verifyVideoExitEventForContentInTray() throws Exception {
		extent.HeaderChildNode("Verify Video Exit Event For Content played from Tray");
		click(PWAPremiumPage.objThumbnail, "Content From a tray");
		waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
		waitTime(6000);
		mixpanel.FEProp.setProperty("Source", "home");
		mixpanel.FEProp.setProperty("Page Name", "movie_detail");
		mixpanel.FEProp.setProperty("Player Name", "kaltura-player-js");
		String id = getDriver().getCurrentUrl();
		Pattern p = Pattern.compile("[0-9]-[0-9]-[0-9]+");
		Matcher m = p.matcher(id);
		String value = null;
		while (m.find()) {
			value = m.group(0);
		}
		ResponseInstance.getContentDetails(value);
		Back(1);
		if (userType.equals("Guest")) {
			String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			mixpanel.ValidateParameter(gToken, "Video Exit");
		} else {
			String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
			mixpanel.ValidateParameter(ID, "Video Exit");
		}
	}

	public void verifyVideoExitEventForContentFromSearchPage(String keyword1) throws Exception {
		extent.HeaderChildNode("Verify Video Exit Event For Content From Search Page");
		click(PWAHomePage.objSearchBtn, "Search Icon");
		type(PWASearchPage.objSearchEditBox, keyword1 + "\n", "Search Edit box: " + keyword1);
		waitTime(4000);
		waitForElement(PWASearchPage.objSearchResult(keyword1), 10, "Search Result");
		click(PWASearchPage.objSearchResult(keyword1), "Search Result");
		waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
		waitTime(6000);
		mixpanel.FEProp.setProperty("Source", "search");
		mixpanel.FEProp.setProperty("Page Name", "movie_detail");
		mixpanel.FEProp.setProperty("Player Name", "kaltura-player-js");
		String id = getDriver().getCurrentUrl();
		Pattern p = Pattern.compile("[0-9]-[0-9]-[0-9]+");
		Matcher m = p.matcher(id);
		String value = null;
		while (m.find()) {
			value = m.group(0);
		}
		ResponseInstance.getContentDetails(value);
		Back(1);
		if (userType.equals("Guest")) {
			String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			mixpanel.ValidateParameter(gToken, "Video Exit");
		} else {
			String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
			mixpanel.ValidateParameter(ID, "Video Exit");
		}
	}

	public void verifyVideoExitEventForContentFromMyWatchlistPage(String userType, String keyword) throws Exception {
		if (!(userType.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode("Verify Video Exit Event For Content From My Watchlist Page");
			click(PWAHomePage.objSearchBtn, "Search Icon");
			type(PWASearchPage.objSearchEditBox, keyword + "\n", "Search Edit box: " + keyword);
			waitTime(4000);
			waitForElement(PWASearchPage.objSearchResult(keyword), 10, "Search Result");
			click(PWASearchPage.objSearchResult(keyword), "Search Result");

			Actions actions = new Actions(getDriver());
			WebElement contentCard = getDriver().findElement(PWAPremiumPage.obj1stContentInShowDetailPage);
			actions.moveToElement(contentCard).build().perform();

			if (checkElementDisplayed(PWAPremiumPage.objContentCardAddToWatchlistBtn, "Add To Watchlist icon")) {
				click(PWAPremiumPage.objContentCardAddToWatchlistBtn, "Add To Watchlist icon");
			}

			click(PWALandingPages.objWebProfileIcon, "Profile icon");
			click(PWAAddToWatchListPage.objMyWatchList, "My Watchlist option");

			click(PWAAddToWatchListPage.objWatchlistedItems, "Content Card in Watchlist page");
			mandatoryRegistrationPopUp(userType);
			waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
			waitTime(6000);
			mixpanel.FEProp.setProperty("Source", "show_detail");
			mixpanel.FEProp.setProperty("Page Name", "episode_detail");
			mixpanel.FEProp.setProperty("Player Name", "kaltura-player-js");
			String id = getDriver().getCurrentUrl();
			Pattern p = Pattern.compile("[0-9]-[0-9]-[0-9]+");
			Matcher m = p.matcher(id);
			String value = null;
			while (m.find()) {
				value = m.group(0);
			}
			ResponseInstance.getContentDetails(value);
			Back(1);
			if (userType.equals("Guest")) {
				String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
				mixpanel.ValidateParameter(gToken, "Video Exit");
			} else {
				String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
				mixpanel.ValidateParameter(ID, "Video Exit");
			}
		}
	}

	public void verifyVideoExitEventForContentInMegamenu() throws Exception {
		extent.HeaderChildNode("Verify Video Exit Event For Content played from Megamenu");
		waitTime(5000);
		Actions actions = new Actions(getDriver());
		WebElement contentCard = getDriver().findElement(PWAHomePage.objHomeBarText("Movies"));
		actions.moveToElement(contentCard).build().perform();

		click(PWAPlayerPage.megaMenuContentCard, "Content Card in Megamenu");
		waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
		waitTime(6000);
		mixpanel.FEProp.setProperty("Source", "home");
		mixpanel.FEProp.setProperty("Page Name", "movie_detail");
		mixpanel.FEProp.setProperty("Player Name", "kaltura-player-js");
		String id = getDriver().getCurrentUrl();
		Pattern p = Pattern.compile("[0-9]-[0-9]-[0-9]+");
		Matcher m = p.matcher(id);
		String value = null;
		while (m.find()) {
			value = m.group(0);
		}
		ResponseInstance.getContentDetails(value);
		Back(1);
		if (userType.equals("Guest")) {
			String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			mixpanel.ValidateParameter(gToken, "Video Exit");
		} else {
			String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
			mixpanel.ValidateParameter(ID, "Video Exit");
		}
	}

	public void verifyVideoExitEventForContentInPlaylist(String userType, String keyword) throws Exception {
		extent.HeaderChildNode("Verify Video Exit Event For Content played from Playlist");
		click(PWAHomePage.objSearchBtn, "Search Icon");
		type(PWASearchPage.objSearchEditBox, keyword + "\n", "Search Edit box: " + keyword);
		waitTime(4000);
		verifyElementPresentAndClick(PWASearchPage.objSearchResult(keyword), "Search Result");
		waitForPlayerAdToComplete("Video Player");
		click(PWAPremiumPage.obj1stContentInViewAllPage, "Content From a tray");
		mandatoryRegistrationPopUp(userType);
		waitTime(2000);
		click(PWAPremiumPage.objContentInPlaylist, "Content card in Playlist");
		waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
		waitTime(6000);
		String id = getDriver().getCurrentUrl();
		Pattern p = Pattern.compile("[0-9]-[0-9]-[0-9]+");
		Matcher m = p.matcher(id);
		String value = null;
		while (m.find()) {
			value = m.group(0);
		}
		ResponseInstance.getContentDetails(value);
		Back(1);
		mixpanel.FEProp.setProperty("Source", "show_detail");
		mixpanel.FEProp.setProperty("Page Name", "episode_detail");
		mixpanel.FEProp.setProperty("Player Name", "kaltura-player-js");
		if (userType.equals("Guest")) {
			String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			mixpanel.ValidateParameter(gToken, "Video Exit");
		} else {
			String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
			mixpanel.ValidateParameter(ID, "Video Exit");
		}
	}

	public void verifyVideoExitEventAfterRefreshingPage(String keyword1) throws Exception {
		extent.HeaderChildNode("Verify Video Exit Event after refreshing a page");
		click(PWAHomePage.objSearchBtn, "Search Icon");
		type(PWASearchPage.objSearchEditBox, keyword1 + "\n", "Search Edit box: " + keyword1);
		waitTime(4000);
		waitForElement(PWASearchPage.objSearchResult(keyword1), 10, "Search Result");
		click(PWASearchPage.objSearchResult(keyword1), "Search Result");
		waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
		waitTime(6000);

		getDriver().navigate().refresh();
		waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
		waitTime(6000);
		mixpanel.FEProp.setProperty("Source", "N/A");
		mixpanel.FEProp.setProperty("Page Name", "movie_detail");
		mixpanel.FEProp.setProperty("Player Name", "kaltura-player-js");

		String id = getDriver().getCurrentUrl();
		Pattern p = Pattern.compile("[0-9]-[0-9]-[0-9]+");
		Matcher m = p.matcher(id);
		String value = null;
		while (m.find()) {
			value = m.group(0);
		}
		ResponseInstance.getContentDetails(value);
		Back(1);
		
		if (userType.equals("Guest")) {
			String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			mixpanel.ValidateParameter(gToken, "Video Exit");
		} else {
			String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
			mixpanel.ValidateParameter(ID, "Video Exit");
		}
	}

	public void verifyVideoExitEventForContentFromUpnextRail(String userType, String keyword4) throws Exception {
		extent.HeaderChildNode("Verify Video Exit Event for content autoplayed from Upnext rail");
		click(PWAHomePage.objSearchBtn, "Search Icon");
		type(PWASearchPage.objSearchEditBox, keyword4 + "\n", "Search Edit box: " + keyword4);
		waitForElement(PWASearchPage.objSearchResult(keyword4), 20, "Search Result");
		click(PWASearchPage.objSearchResult(keyword4), "Search Result");

		waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
		mandatoryRegistrationPopUp(userType);
		waitForPlayerAdToComplete("Video Player");
		waitTime(6000);
		click(PWAPlayerPage.objPlaybackVideoOverlay, "Player");
		playerScrubTillLastWeb();
		click(PWAPlayerPage.objPlayerPlay, "Play Icon");
		waitTime(6000);
		waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
		mandatoryRegistrationPopUp(userType);
		waitForPlayerAdToComplete("Video Player");
		waitTime(6000);
		mixpanel.FEProp.setProperty("Source", "episode_detail");
		mixpanel.FEProp.setProperty("Page Name", "episode_detail");
		mixpanel.FEProp.setProperty("Player Name", "kaltura-player-js");
		String id = getDriver().getCurrentUrl();
		Pattern p = Pattern.compile("[0-9]-[0-9]-[0-9]+");
		Matcher m = p.matcher(id);
		String value = null;
		while (m.find()) {
			value = m.group(0);
		}
		ResponseInstance.getContentDetails(value);
		Back(1);
		if (userType.equals("Guest")) {
			String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			mixpanel.ValidateParameter(gToken, "Video Exit");
		} else {
			String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
			mixpanel.ValidateParameter(ID, "Video Exit");
		}
	}
	
	public void verifyVideoExitEventForContentFromSharedLink(String freeContentURL) throws Exception {
		extent.HeaderChildNode("Verify Video Exit Event For content played from Shared Link");
		getDriver().get(freeContentURL);
		waitForElementDisplayed(PWAPlayerPage.objPlaybackVideoOverlay, 20);
		mixpanel.FEProp.setProperty("Source", "home");
		mixpanel.FEProp.setProperty("Page Name", "movie_detail");
		mixpanel.FEProp.setProperty("Player Name", "kaltura-player-js");
		String id = getDriver().getCurrentUrl();
		Pattern p = Pattern.compile("[0-9]-[0-9]-[0-9]+");
		Matcher m = p.matcher(id);
		String value = null;
		while (m.find()) {
			value = m.group(0);
		}
		ResponseInstance.getContentDetails(value);
		Back(1);
		if (userType.equals("Guest")) {
			String gToken = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			mixpanel.ValidateParameter(gToken, "Video Exit");
		} else {
			String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
			mixpanel.ValidateParameter(ID, "Video Exit");
		}
	}
	
	public void waitForPlayerAdToComplete(String playerType) throws Exception {
		boolean adDisplayed = false;
		boolean playerDisplayed = false;
		int confirmCount = 0;
		waitTime(5000);
		main: for (int trial = 0; trial < 200; trial++) {
			if (verifyElementDisplayed(PWAPlayerPage.objAd)) {
				adDisplayed = true;
				if (trial == 5) {
					logger.info("Ad play in progress");
					extent.extentLogger("AdPlayInProgress", "Ad play in progress");
				}
				if (Math.floorMod(trial, 40) == 0)
					System.out.println("Ad play in progress");
				Thread.sleep(1000);
			} else {
				try {
					getDriver().findElement(PWAPlayerPage.objPlayerSettings);
					playerDisplayed = true;
					Thread.sleep(1000);
					confirmCount++;
					System.out.println(confirmCount);
					if (confirmCount == 3) {
						if (adDisplayed == false) {
							logger.info("Ad did not play");
							extent.extentLogger("AdDidNotPlay", "Ad did not play");
						} else {
							logger.info("Ad play complete");
							extent.extentLogger("AdPlayComplete", "Ad play complete");
						}
						break main;
					}
				} catch (Exception e1) {
					waitTime(2000);
				}
			}
		}
		if (playerDisplayed == false && adDisplayed == false) {
			logger.info("Ad play failure");
			extent.extentLogger("failedAd", "Ad play failure");
		}
	}
}

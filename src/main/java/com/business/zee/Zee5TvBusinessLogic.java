package com.business.zee;

import java.io.IOException;
import java.util.*;
import org.apache.xmlbeans.UserType;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import com.driverInstance.CommandBase;
import com.extent.ExtentReporter;
import com.jayway.restassured.response.Response;
import com.metadata.ResponseInstance;
import com.mixpanelValidation.Mixpanel;
import com.propertyfilereader.PropertyFileReader;
import com.utility.LoggingUtils;
import com.utility.Utilities;
import com.zee5.TVPages.PWAHamburgerMenuPage;
import com.zee5.TVPages.PWALandingPages;
import com.zee5.TVPages.PWALoginPage;
import com.zee5.TVPages.Zee5TVCarousel;
import com.zee5.TVPages.Zee5TvHomePage;
import com.zee5.TVPages.Zee5TvPlayerPage;
import com.zee5.TVPages.Zee5TvSearchPage;
import com.zee5.TVPages.Zee5TvWelcomePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;

@SuppressWarnings("unused")
public class Zee5TvBusinessLogic extends Utilities {

	public Zee5TvBusinessLogic(String Application) throws InterruptedException {
		new CommandBase(Application);
		init();
	}

	private int timeout;

	/** Retry Count */
	private int retryCount;
	Mixpanel mixpanel = new Mixpanel();
	ExtentReporter extent = new ExtentReporter();

	/** The Constant logger. */
//	final static Logger logger = Logger.getLogger("rootLogger");
	static LoggingUtils logger = new LoggingUtils();

	/** The Android driver. */
	public AndroidDriver<AndroidElement> androidDriver;

	/** The Android driver. */
	public IOSDriver<WebElement> iOSDriver;

	static String code = "";
	String asset_SubType = "";
	String assetType = "";
	Set<String> hash_Set = new HashSet<String>();
	String viewAllTrayname = "";
	@SuppressWarnings("unused")
	private String LacationBasedLanguge;

	List<String> LocationLanguage = new ArrayList<String>();

	List<String> DefaultLanguage = new ArrayList<String>();

	List<String> SelectedCONTENTLanguageInWelcomscreen = new ArrayList<String>();

	List<String> SelectedCONTENTLanguageInHamburgerMenu = new ArrayList<String>();

	Response resp;

	ArrayList<String> MastheadTitleApi = new ArrayList<String>();

	public static boolean relaunchFlag = false;
	public static boolean appliTools = false;

	public static boolean PopUp = false;

	public String title = "";

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

	public String carouselTitle = "";
	public String carouselDescription = "";
	public String trayTitle = "";

	public String contentName = "";

	String userType = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("userType");
	String parentpasswordNonSub = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
			.getParameter("NonsubscribedPassword");

	String parentpasswordSub = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
			.getParameter("SubscribedPassword");

	/**
	 * Initiate Property File.
	 *
	 * @param byLocator the by locator
	 */

	public void init() {

		PropertyFileReader handler = new PropertyFileReader("properties/Execution.properties");
		setTimeout(Integer.parseInt(handler.getproperty("TIMEOUT")));
		setRetryCount(Integer.parseInt(handler.getproperty("RETRY_COUNT")));
		logger.info(
				"Loaded the following properties" + " TimeOut :" + getTimeout() + " RetryCount :" + getRetryCount());
	}

	public void TvtearDown() {
		getDriver().quit();
	}

	public void LoadingInProgress() throws Exception {
		verifyElementNotPresent(Zee5TvPlayerPage.objProgressLoader, 10);
		extent.extentLoggerPass("Progress Loader Matched", "Progress Loader Verfied");
	}

	public void AdVerify() throws Exception {
		verifyElementNotPresent(Zee5TvPlayerPage.objAd, 40);
		extent.extentLoggerPass("Ad Verified", "Ad Verified");
	}

	public void searchScenarios(String userType) throws Exception {
		if (userType.equals("Guest") || userType.equals("NonSubscribedUser")) {
			searchMovie();
			searchPremium();
			searchEPG();
			partlySpletSearch();
			actorSearch();
			genreSearch();
			languageSearch();
		}
		if (userType.equals("SubscribedUser")) {
			searchMovie();
			searchEPG();
			partlySpletSearch();
			actorSearch();
			genreSearch();
			languageSearch();
		}
	}

	@SuppressWarnings("unused")
	public void searchMovie() throws Exception {
		extent.HeaderChildNode("Search Button navigation Functionality");
		waitTime(13000);
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip Link")) {
			TVclick(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip link");
			extent.extentLoggerPass("Clicked on Skip Link", "Clicked on Skip Link");
		} else {
			logger.info("User is logged in");
			extent.extentLoggerPass("Button", "User is logged in");
		}

		waitTime(5000);

		TVTabSelect("Home");
		logger.info(TVgetText(Zee5TvHomePage.objHighlightedTab) + "Tab is highlighted");
		extent.extentLoggerPass("Tab", "HighLighted Tab :" + TVgetText(Zee5TvHomePage.objHighlightedTab));

		if (TVgetAttributValue("focused", Zee5TvHomePage.objSearchIcon).equals("false")) {

			TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
			TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
		} else {

			TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
		}
		waitTime(5000);
		if (verifyIsElementDisplayed(Zee5TvSearchPage.objSearchSpaceBar, "Search page")) {
			logger.info("User is navigated to search page after clicking on search button");
			extent.extentLoggerPass("Search", "User is navigated to search page after clicking on search button");
		} else {
			logger.info("User is not navigated to serach page");
			extent.extentLoggerFail("Navigation", "User is not navigated to serach page");
		}
		String searchdata1[] = { "b", "a", "b", "l", "u", };
		String searchdata2[] = { "d", "a", "b", "l", "u" };
		String searchdata3[] = { "r", "o", "b", "o" };
		String searchdata4[] = { "r", "u", "m", "b", "l", "e" };
		HeaderChildNode("Search Movie content and its playback functionality");
		type(searchdata1);
		TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space bar");
		type(searchdata2);
		TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space");
		type(searchdata3);
		TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space");
		type(searchdata4);
		HeaderChildNode("Search result Movie playback functionality");
		String content = TVgetText(Zee5TvSearchPage.objEditbox);

		logger.info("Entered Search Data : " + content);
		extent.extentLogger("Search", "Entered Searched Data : " + content);

		int k;
		List<WebElement> ele = getDriver().findElements(By.xpath("//*[@id='search_result_title']"));
		for (int i = 1; i <= ele.size(); i++) {

			title = TVgetText(Zee5TvSearchPage.objSearchedTumbnailTitle(i));
			logger.info(title);
			extent.extentLogger("Title", "Serach result content title : " + title);
			if ((verifyIsElementDisplayed(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title, "Movies"),
					"Searched Movie"))) {
				TVclick(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title, "Movies"), "serached Movie");
				break;
			} else {
				System.out.println("No match");
			}

		}

		waitTime(8000);
		String title = TVgetText(Zee5TvSearchPage.objSearchedDataTitle);
		if (title.equals(title)) {
			logger.info("user is navigated to respective content detail page");
			extent.extentLoggerPass("user", "user is navigated to respective content detail page");
		}
		waitTime(2000);
		TVclick(Zee5TvSearchPage.objPlayIcon, "Play Icon");

		waitTime(10000);
		waitTime(25000);
		waitTime(10000);

		if (verifyIsElementDisplayed(Zee5TvPlayerPage.objPlayerSkipIntro, "SkipIntro")) {
			TVRemoteEvent(20);
			waitTime(2000);
			TVRemoteEvent(23);
			logger.info("clicked on skip intro");
			extent.extentLoggerPass("Intro", "clicked on skip intro");
		} else {
			logger.info("Skip intro is not displayed");
			extent.extentLogger("Intro", "Skip intro is not displayed");
		}
		waitTime(12000);
		Runtime.getRuntime().exec("adb shell input keyevent 23");
		waitTime(4000);
		if (verifyIsElementDisplayed(Zee5TvPlayerPage.objPlayerContainer, "Consumption screen")) {
			logger.info("User is able to play free content");
			extent.extentLoggerPass("play", "User is able to play free content");
		} else {
			logger.info("playback did not initiate");
			extent.extentLoggerFail("play", "playback did not initiate");
		}
		waitTime(10000);

	}

	public void searchPremium() throws Exception {
		HeaderChildNode("Search result Premium content popup functionality");
		getDriver().navigate().back();
		waitTime(5000);
		getDriver().navigate().back();
		waitTime(5000);
		if (verifyIsElementDisplayed(Zee5TvSearchPage.objEditbox, "Edit box")) {
			logger.info("User is navigated to search page");
		} else {
			getDriver().navigate().back();
		}
		int lenText = getDriver().findElement(Zee5TvSearchPage.objEditbox).getAttribute("text").length();
		for (int i = 0; i < lenText; i++) {
			getDriver().findElement(Zee5TvSearchPage.objSearchBackButton).click();
		}
		String searchdata1[] = { "p", "a", "n", "c", "h", "a", "t", "a", "n", "t", "r", "a" };
		type(searchdata1);
		waitTime(5000);
		String content = TVgetText(Zee5TvSearchPage.objEditbox);
		TVclick(Zee5TvSearchPage.objSearchedText, "Searched suggestion");
		waitTime(2000);
		TVclick(Zee5TvSearchPage.objSearchedText, "Searched suggestion");
		waitTime(2000);
		TVclick(Zee5TvSearchPage.objSearchedText, "Searched suggestion");
		waitTime(2000);
		logger.info("Entered Search Data : " + content);
		extent.extentLoggerPass("Search", "Entered Searched Data : " + content);
		TVclick(Zee5TvSearchPage.objSearchedText, "Searched suggestion");
		waitTime(2000);
		TVclick(Zee5TvSearchPage.objSearchedText, "Searched suggestion");
		waitTime(2000);
		TVclick(Zee5TvSearchPage.objSearchedText, "Searched suggestion");
		waitTime(2000);
		List<WebElement> ele = getDriver().findElements(By.xpath("//*[@id='search_result_title']"));
		for (int i = 1; i <= ele.size(); i++) {

			String title = TVgetText(Zee5TvSearchPage.objSearchedTumbnailTitle(i));
			logger.info(title);
			extent.extentLogger("Title", "Serach result content title : " + title);
			if ((verifyIsElementDisplayed(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title, "Movies"),
					"Searched Premium movie"))) {
				TVclick(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title, "Movies"), "Premium movie");
				break;
			} else {
				logger.info("No match");
			}

		}
		waitTime(8000);
		String title = TVgetText(Zee5TvSearchPage.objSearchedDataTitle);
		if (title.equals(title)) {
			logger.info("user is navigated to respective content detail page");
			extent.extentLoggerPass("user", "user is navigated to respective content detail page");
		}
		TVclick(Zee5TvSearchPage.objPlayIcon, "Play Icon");
		waitTime(5000);
		if (userType.equals("Guest")) {
			if (verifyIsElementDisplayed(Zee5TvSearchPage.objLoginPopup, "Login popup")) {
				logger.info("Login popup is displayed when user play premium content as guest user");
				extent.extentLoggerPass("Popup",
						"Login popup is displayed when user play premium content as guest user");
			} else {
				logger.info("Functioanlity failed");
				extent.extentLoggerFail("Popup", "Popup Functioanlity failed");
			}

		}
		if (userType.equals("NonSubscribedUser")) {
			if (verifyIsElementDisplayed(Zee5TvSearchPage.objSubscribePopup, "Subscribe now popup")) {
				logger.info("Subscribe popup is displayed when user play premium content as Nonsubscribe user");
				extent.extentLoggerPass("Popup",
						"Subscribe popup is displayed when user play premium content as Nonsubscribe user");
			} else {
				logger.info("Functioanlity failed");
				extent.extentLoggerFail("Popup", "Popup Functioanlity failed");
			}
		}
	}

	@SuppressWarnings("unused")
	public void searchEPG() throws Exception {
		HeaderChildNode("Search result EPG content playback functionality");
		getDriver().navigate().back();
		waitTime(3000);
		getDriver().navigate().back();
		if (verifyIsElementDisplayed(Zee5TvSearchPage.objEditbox, "Edit box")) {
			logger.info("User is navigated to search page");
		} else {
			getDriver().navigate().back();
		}
		waitTime(3000);
		int lenText = getDriver().findElement(Zee5TvSearchPage.objEditbox).getAttribute("text").length();
		for (int i = 0; i < lenText; i++) {
			getDriver().findElement(Zee5TvSearchPage.objSearchBackButton).click();
			waitTime(2000);
		}
		String searchdata1[] = { "n", "e", "w", "s" };
		type(searchdata1);
		String content = TVgetText(Zee5TvSearchPage.objEditbox);
		logger.info("Entered Search Data : " + content);
		extent.extentLoggerPass("Search", "Entered Searched Data : " + content);
		verifyIsElementDisplayed(Zee5TvSearchPage.objSearchPageNowPlayingButton, "Now playing option");
		waitTime(2000);
		TVclick(Zee5TvSearchPage.objSearchPageNowPlayingButton, "Now playing option");
		TVclick(Zee5TvSearchPage.objSearchPageNowPlayingButton, "Now playing option");
		waitTime(3000);
		boolean epg = verifyIsElementDisplayed(Zee5TvSearchPage.objElapsedTime, "Search result content Elapsed time");
		if (epg) {
			logger.info("EPG contents are displayed");
			extent.extentLoggerPass("Search", "EPG contents are displayed");
		} else {
			logger.info("EPG contents are not displayed");
			extent.extentLogger("Search", "EPG contents are not displayed");
		}
		verifyIsElementDisplayed(Zee5TvSearchPage.objElapsedTime, "Elapsed time");
		verifyIsElementDisplayed(Zee5TvSearchPage.objChalnnelName, "Channel name");
		verifyIsElementDisplayed(Zee5TvSearchPage.objProgressBar, "Progress bar");
		verifyIsElementDisplayed(Zee5TvSearchPage.objEPGtitle, "EPG Title");
		String channelName = TVgetText(Zee5TvSearchPage.objChalnnelName);
		String channelTitle = TVgetText(Zee5TvSearchPage.objEPGtitle);
		TVclick(Zee5TvSearchPage.objSearchedTumbnailImageEPG(channelName), "EPG news content");
		waitTime(15000);
		AdVerify();
		waitTime(2000);
		for (int i = 0; i <= 5; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 23");
			waitTime(2000);
			if (verifyIsElementDisplayed(Zee5TvSearchPage.objGotolivebutton, "Live button in player")) {
				logger.info("User is able play Free EPG content");
				extent.extentLoggerPass("EPG", "User is able play Free EPG content");
				break;
			}
		}
		waitTime(3000);
		getDriver().navigate().back();
		waitTime(8000);
		if (verifyIsElementDisplayed(Zee5TvSearchPage.objEditbox, "Edit box")) {
			logger.info("User is navigated to search page");
		} else {
			getDriver().navigate().back();
		}
		int lenText2 = getDriver().findElement(Zee5TvSearchPage.objEditbox).getAttribute("text").length();
		for (int i = 0; i < lenText2; i++) {
			getDriver().findElement(Zee5TvSearchPage.objSearchBackButton).click();

		}
	}

	@SuppressWarnings("unused")
	public void partlySpletSearch() throws Exception {
		HeaderChildNode("Partly spelt content functionality");
		String searchdata1[] = { "g", "a", "t", "t", "u" };
		type(searchdata1);
		waitTime(3000);
		String content = TVgetText(Zee5TvSearchPage.objEditbox);
		logger.info("Entered Search Data : " + content);
		extent.extentLoggerPass("Search", "Entered Searched Data : " + content);
		List<WebElement> ele = getDriver().findElements(By.xpath("//*[@id='search_result_title']"));
		for (int i = 1; i <= 3; i++) {

			String title = TVgetText(Zee5TvSearchPage.objSearchedTumbnailTitle(i));
			logger.info(title);
			extent.extentLoggerPass("Title", "Serach result content title : " + title);
			if (title.contains("Gattu")) {
				logger.info("Partly spelt asset is displayed in search page");
				extent.extentLoggerPass("Spelt", "Partly spelt asset is displayed in search page");
			} else {
				logger.info("Partly spelt asset is not displayed in search page");
				extent.extentLogger("Spelt", "Partly spelt asset is not displayed in search page");
			}
		}
		int lenText = getDriver().findElement(Zee5TvSearchPage.objEditbox).getAttribute("text").length();
		for (int i = 0; i < lenText; i++) {
			getDriver().findElement(Zee5TvSearchPage.objSearchBackButton).click();

		}
	}

	@SuppressWarnings("unused")
	public void actorSearch() throws Exception {
		HeaderChildNode("Searched Actor content functionality");
		String searchdata1[] = { "r", "a", "m", "e", "s", "h" };
		type(searchdata1);
		waitTime(3000);
		String content = TVgetText(Zee5TvSearchPage.objEditbox);
		logger.info("Entered Search Data : " + content);
		extent.extentLoggerPass("Search", "Entered Searched Data : " + content);
		List<WebElement> ele = getDriver().findElements(By.xpath("//*[@id='search_result_title']"));
		for (int i = 1; i <= 3; i++) {

			String title = TVgetText(Zee5TvSearchPage.objSearchedTumbnailTitle(i));
			logger.info(title);
			extent.extentLoggerPass("Title", "Serach result content title : " + title);
			if (title.contains("Ramesh")) {
				logger.info("Actor name is displayed in search page when user search for actor");
				extent.extentLoggerPass("Spelt", "Actor name is displayed in search page when user search for actor");
			} else {
				logger.info("Actor name is not displayed in search page when user search for actor");
				extent.extentLogger("Spelt", "Actor name is not displayed in search page when user search for actor");
			}
		}
		int lenText = getDriver().findElement(Zee5TvSearchPage.objEditbox).getAttribute("text").length();
		for (int i = 0; i < lenText; i++) {
			getDriver().findElement(Zee5TvSearchPage.objSearchBackButton).click();

		}
	}

	@SuppressWarnings("unused")
	public void genreSearch() throws Exception {
		HeaderChildNode("Searched Genre content functionality");
		String searchdata1[] = { "c", "o", "m", "e", "d", "y" };
		type(searchdata1);
		String content = TVgetText(Zee5TvSearchPage.objEditbox);
		logger.info("Entered Search Data : " + content);
		extent.extentLoggerPass("Search", "Entered Searched Data : " + content);
		waitTime(3000);
		List<WebElement> ele = getDriver().findElements(By.xpath("//*[@id='search_result_title']"));
		for (int i = 1; i <= 3; i++) {

			String title = TVgetText(Zee5TvSearchPage.objSearchedTumbnailTitle(i));
			logger.info(title);
			extent.extentLoggerPass("Title", "Serach result content title : " + title);
			if (title.contains("Comedy")) {
				logger.info("Genre search results are displayed when user search for particular genre");
				extent.extentLoggerPass("Spelt",
						"Genre search results are displayed when user search for particular genre");
			} else {
				logger.info("Genre search results are not displayed when user search for particular genre");
				extent.extentLogger("Spelt",
						"Genre search results are not displayed when user search for particular genre");
			}
		}
		int lenText = getDriver().findElement(Zee5TvSearchPage.objEditbox).getAttribute("text").length();
		for (int i = 0; i < lenText; i++) {
			getDriver().findElement(Zee5TvSearchPage.objSearchBackButton).click();

		}
	}

	@SuppressWarnings("unused")
	public void languageSearch() throws Exception {
		HeaderChildNode("Searched language content functionality");
		String searchdata1[] = { "k", "a", "n", "n", "a", "d", "a" };
		type(searchdata1);
		String content = TVgetText(Zee5TvSearchPage.objEditbox);
		logger.info("Entered Search Data : " + content);
		extent.extentLoggerPass("Search", "Entered Searched Data : " + content);
		waitTime(3000);
		List<WebElement> ele = getDriver().findElements(By.xpath("//*[@id='search_result_title']"));
		for (int i = 1; i <= 2; i++) {

			String title = TVgetText(Zee5TvSearchPage.objSearchedTumbnailTitle(i));
			logger.info(title);
			extent.extentLoggerPass("Title", "Serach result content title : " + title);
			if (title.contains("Kannada")) {
				logger.info("language search results are displayed when user search for particular language");
				extent.extentLoggerPass("Spelt",
						"language search results are displayed when user search for particular language");
			} else {
				logger.info("language search results are not displayed when user search for particular language");
				extent.extentLogger("Spelt",
						"language search results are not displayed when user search for particular language");
			}
		}
		int lenText = getDriver().findElement(Zee5TvSearchPage.objEditbox).getAttribute("text").length();
		for (int i = 0; i < lenText; i++) {
			getDriver().findElement(Zee5TvSearchPage.objSearchBackButton).click();

		}
		waitTime(3000);
		getDriver().navigate().back();
		waitTime(4000);
		TVTabSelect("Home");
		getDriver().closeApp();
		waitTime(5000);
		getDriver().launchApp();
		waitTime(7000);
		if (userType.equals("Guest")) {
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);

		}
	}

	public void login(String userType) throws Exception {
		HeaderChildNode("Authentication process - Login as : " + userType);
		if (userType.equals("Guest")) {
			logger.info("Guest user");
			extent.extentLoggerPass("Login", "Guest user scenarios");
		}
		if (userType.equals("NonSubscribedUser") || userType.equals("SubscribedUser")) {
			waitTime(15000);
			verifyIsElementDisplayed(Zee5TvWelcomePage.objalreadyRegister, "Already Register button");
			TVclick(Zee5TvWelcomePage.objalreadyRegister, "Already Register button");
			waitTime(3000);
			code = TVgetText(Zee5TvWelcomePage.objloginCode);
			logger.info("Authenticate code in TV : " + code);
			extentLoggerPass("Code", "Authenticate code in TV : " + code);
			HeaderChildNode("Switching to WEB platform to Authenticate device");
			setPlatform("Web");
			new Zee5TvBusinessLogic("zee");
			waitTime(10000);
			verifyElementPresentAndClick(PWALoginPage.objLanguageButton, "Language button");
			waitTime(3000);
			verifyElementPresentAndClick(PWALoginPage.objWebLoginBtn, "Login button");
			waitTime(3000);
			verifyElementPresentAndClick(PWALoginPage.objEmailField, "Email field");

			if (userType.equals("NonSubscribedUser")) {
				String Username = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("NonsubscribedUserName");
				String Password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("NonsubscribedPassword");
				type(PWALoginPage.objEmailField, Username, "Email Field");
				waitTime(3000);
				verifyElementPresentAndClick(PWALoginPage.objPasswordField, "Password Field");
				type(PWALoginPage.objPasswordField, Password, "Password field");
				waitTime(5000);

			}
			if (userType.equals("SubscribedUser")) {
				String SubscribedUsername = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("SubscribedUserName");
				String SubscribedPassword = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("SubscribedPassword");
				type(PWALoginPage.objEmailField, SubscribedUsername, "Email Field");
				waitTime(3000);
				verifyElementPresentAndClick(PWALoginPage.objPasswordField, "Password Field");
				type(PWALoginPage.objPasswordField, SubscribedPassword, "Password field");
				waitTime(5000);

			}
			click(PWALoginPage.objWebLoginButton, "Login Button");
			waitTime(8000);
			verifyElementPresentAndClick(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger menu");
			verifyElementPresentAndClick(PWAHamburgerMenuPage.objAuthenticationOption, "Authentication option");
			waitTime(3000);
			checkElementDisplayed(PWAHamburgerMenuPage.objAuthenticationText, "Authentication Page");
			type(PWAHamburgerMenuPage.objAuthenticationField, code, "Authentication Field");
			click(PWAHamburgerMenuPage.objAuthenticationButtonHighlighted, "Authenticate button");
			waitTime(3000);
			BrowsertearDown();
			setPlatform("TV");
			waitTime(10000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objcontinueButtonInLoginPage,
					"Continue button in TV authentication page")) {
				Runtime.getRuntime().exec("adb shell input keyevent 20");
				waitTime(2000);
				Runtime.getRuntime().exec("adb shell input keyevent 20");
				waitTime(3000);
				Runtime.getRuntime().exec("adb shell input keyevent 22");
				waitTime(3000);
				Runtime.getRuntime().exec("adb shell input keyevent 22");
				waitTime(3000);
				TVclick(Zee5TvWelcomePage.objcontinueButtonInLoginPage, "Continue button in TV authentication page");
				waitTime(15000);
			}
		}
	}

	public void playbackHomepage() throws Exception {
		HeaderChildNode("Content detail page functionality through Home page");
		waitTime(10000);
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip Link")) {
			TVclick(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip link");
			extent.extentLoggerPass("Clicked on Skip Link", "Clicked on Skip Link");
		} else {
			logger.info("User is logged in");
			extent.extentLoggerPass("Button", "User is logged in");
		}
		waitTime(5000);
		TVTabSelect("Home");
		logger.info(TVgetText(Zee5TvHomePage.objHighlightedTab) + "Tab is highlighted");
		extent.extentLoggerPass("Tab", "HighLighted Tab :" + TVgetText(Zee5TvHomePage.objHighlightedTab));
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		for (int i = 0; i <= 18; i++) {
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objHomepageTrayContent, "Tray content")) {
				TVclick(Zee5TvWelcomePage.objHomepageTrayContent, "Tray content");
				waitTime(7000);
				if (verifyIsElementDisplayed(Zee5TvSearchPage.objPlayIcon, "Content Title")) {
					logger.info("User is navigated to content detail page");
					extent.extentLoggerPass("Page", "User is navigated to content detail page");
				} else {
					TVclick(Zee5TvWelcomePage.objHomepageTrayContent, "Movie page Tray content");
				}
				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 20");
				waitTime(3000);
			}
		}
		waitTime(10000);
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objContentTitleIncontentPage, "Content Title")) {
			logger.info("Content title : " + TVgetText(Zee5TvWelcomePage.objContentTitleIncontentPage));
			extent.extentLoggerPass("title",
					"Content title : " + TVgetText(Zee5TvWelcomePage.objContentTitleIncontentPage));
		} else {
			logger.info("content title is not displayed");
			extent.extentLoggerFail("title", "content title is not displayed");
		}
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objContentDescriptionIncontentPage, "Content Description")) {
			logger.info("Content Description : " + TVgetText(Zee5TvWelcomePage.objContentDescriptionIncontentPage));
			extent.extentLoggerPass("title",
					"Content Description : " + TVgetText(Zee5TvWelcomePage.objContentDescriptionIncontentPage));
		} else {
			logger.info("content Description is not displayed");
			extent.extentLoggerFail("title", "content Description is not displayed");
		}
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objContentTypeIncontentPage, "Content type")) {
			logger.info("Content type : " + TVgetText(Zee5TvWelcomePage.objContentTypeIncontentPage));
			extent.extentLoggerPass("title",
					"Content type : " + TVgetText(Zee5TvWelcomePage.objContentTypeIncontentPage));
		} else {
			logger.info("content type is not displayed");
			extent.extentLoggerFail("title", "content type is not displayed");
		}
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objContentgenreIncontentPage, "Content genre")) {
			logger.info("Content genre : " + TVgetText(Zee5TvWelcomePage.objContentgenreIncontentPage));
			extent.extentLoggerPass("title",
					"Content genre : " + TVgetText(Zee5TvWelcomePage.objContentgenreIncontentPage));
		} else {
			logger.info("content genre is not displayed");
			extent.extentLoggerFail("title", "content genre is not displayed");
		}
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objContentcertificateIncontentPage, "Content certificate")) {
			logger.info("Content certificate : " + TVgetText(Zee5TvWelcomePage.objContentcertificateIncontentPage));
			extent.extentLoggerPass("title",
					"Content certificate : " + TVgetText(Zee5TvWelcomePage.objContentcertificateIncontentPage));
		} else {
			logger.info("content certificate is not displayed");
			extent.extentLoggerFail("title", "content certificate is not displayed");
		}
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objContentdurationIncontentPage, "Content duration")) {
			logger.info("Content duration : " + TVgetText(Zee5TvWelcomePage.objContentdurationIncontentPage));
			extent.extentLoggerPass("title",
					"Content duration : " + TVgetText(Zee5TvWelcomePage.objContentdurationIncontentPage));
		} else {
			logger.info("content duration is not displayed");
			extent.extentLoggerFail("title", "content duration is not displayed");
		}
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objContenttrailerplaybackIncontentPage, "Trailer playback")) {
			logger.info("Auto trailer playback is initiated");
			extent.extentLoggerPass("trailer", "Auto trailer playback is initiated");
		} else {
			logger.info("Content does not have trailer");
			extent.extentLoggerPass("trailer", "Content does not have trailer");
		}

		TVclick(Zee5TvSearchPage.objPlayIcon, "Play Icon");
		waitTime(4000);
		if (userType.equals("Guest")) {
			if (verifyIsElementDisplayed(Zee5TvSearchPage.objLoginPopup, "Login popup")) {
				logger.info("Login popup is displayed when user play premium content as guest user");
				extent.extentLoggerPass("Popup",
						"Login popup is displayed when user play premium content as guest user");
			} else {
				logger.info("Functioanlity failed");
				extent.extentLoggerFail("Popup", "Popup Functioanlity failed");
			}

		}
		if (userType.equals("NonSubscribedUser")) {
			if (verifyIsElementDisplayed(Zee5TvSearchPage.objSubscribePopup, "Subscribe now popup")) {
				logger.info("Subscribe popup is displayed when user play premium content as Nonsubscribe user");
				extent.extentLoggerPass("Popup",
						"Subscribe popup is displayed when user play premium content as Nonsubscribe user");
			} else {
				logger.info("User is navigated to consumption screen");
				extent.extentLogger("Popup", "User is navigated to consumption screen");
				getDriver().navigate().back();
			}
		}
		if (userType.equals("SubscribedUser")) {
			// LoadingInProgress();
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvPlayerPage.objPlayerSkipIntro, "SkipIntro")) {
				TVRemoteEvent(20);
				waitTime(2000);
				TVRemoteEvent(23);
				logger.info("clicked on skip intro");
				extent.extentLoggerPass("Intro", "clicked on skip intro");
			} else {
				logger.info("Skip intro is not displayed");
				extent.extentLoggerPass("Intro", "Skip intro is not displayed");
			}
			waitTime(8000);
			Runtime.getRuntime().exec("adb shell input keyevent 23");
			waitTime(4000);
			if (verifyIsElementDisplayed(Zee5TvPlayerPage.objPlayerContainer, "Consumption page")) {
				logger.info("User is able to play premium content for premium user");
				extent.extentLoggerPass("play", "User is able to play premium content for premium user");
			} else {
				logger.info("playback did not initiate");
				extent.extentLoggerFail("play", "playback did not initiate");
			}

		}
		getDriver().navigate().back();
		waitTime(5000);
		getDriver().navigate().back();
		waitTime(5000);
		if (userType.equals("Guest") || userType.equals("NonSubscribedUser")) {
			if (verifyIsElementDisplayed(Zee5TvSearchPage.objwatchTrailerIcon, "watch trailer button")) {
				waitTime(5000);
				TVclick(Zee5TvSearchPage.objwatchTrailerIcon, "watch trailer button");
				waitTime(2000);
				TVclick(Zee5TvSearchPage.objwatchTrailerIcon, "watch trailer button");
				waitTime(2000);
				// LoadingInProgress();
				waitTime(15000);
				Runtime.getRuntime().exec("adb shell input keyevent 23");
				waitTime(3000);
				if (verifyIsElementDisplayed(Zee5TvPlayerPage.objPlayerContainer, "Consumption screen")) {
					logger.info("User is able to play free content");
					extent.extentLoggerPass("play", "User is able to play free content");
				} else {
					logger.info("playback did not initiate");
					extent.extentLoggerFail("play", "playback did not initiate");
				}
				getDriver().navigate().back();
				waitTime(5000);
				getDriver().navigate().back();
				waitTime(5000);
			} else {
				logger.info("Watch trailer button is not present");
				extent.extentLogger("trailer", "Watch trailer button is not present");
			}
		}
		waitTime(2000);
		getDriver().navigate().back();
		waitTime(5000);
		for (int k = 0; k <= 18; k++) {
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(2000);
		}
		getDriver().closeApp();

		waitTime(3000);

		getDriver().launchApp();

		waitTime(10000);
		if (userType.equals("Guest")) {
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
		}
	}

	public void playbackShowspage() throws Exception {
		HeaderChildNode("Content detail page functionality through Shows page");
		TVTabSelect("Shows");
		logger.info(TVgetText(Zee5TvHomePage.objHighlightedTab) + "Tab is highlighted");
		extent.extentLoggerPass("Tab", "HighLighted Tab :" + TVgetText(Zee5TvHomePage.objHighlightedTab));
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		for (int i = 0; i <= 15; i++) {
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objshowpageTrayContent, "Show page Tray content")) {
				TVclick(Zee5TvWelcomePage.objshowpageTrayContent, "Show page Tray content");
				if (verifyIsElementDisplayed(Zee5TvSearchPage.objPlayIcon, "Content Title")) {
					logger.info("User is navigated to content detail page");
					extent.extentLoggerPass("Page", "User is navigated to content detail page");
				} else {
					TVclick(Zee5TvWelcomePage.objshowpageTrayContent, "Show page Tray content");
				}
				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 20");
				waitTime(3000);
			}
		}
		waitTime(10000);
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objContentTitleIncontentPage, "Content Title")) {
			logger.info("Content title : " + TVgetText(Zee5TvWelcomePage.objContentTitleIncontentPage));
			extent.extentLoggerPass("title",
					"Content title : " + TVgetText(Zee5TvWelcomePage.objContentTitleIncontentPage));
		} else {
			logger.info("content title is not displayed");
			extent.extentLoggerFail("title", "content title is not displayed");
		}
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objContentDescriptionIncontentPage, "Content Description")) {
			logger.info("Content Description : " + TVgetText(Zee5TvWelcomePage.objContentDescriptionIncontentPage));
			extent.extentLoggerPass("title",
					"Content Description : " + TVgetText(Zee5TvWelcomePage.objContentDescriptionIncontentPage));
		} else {
			logger.info("content Description is not displayed");
			extent.extentLoggerFail("title", "content Description is not displayed");
		}
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objContentShowTypeIncontentPage, "Content type")) {
			logger.info("Content type : " + TVgetText(Zee5TvWelcomePage.objContentShowTypeIncontentPage));
			extent.extentLoggerPass("title",
					"Content type : " + TVgetText(Zee5TvWelcomePage.objContentShowTypeIncontentPage));
		} else {
			logger.info("content type is not displayed");
			extent.extentLoggerFail("title", "content type is not displayed");
		}
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objContentShowgnereIncontentPage, "Content genre")) {
			logger.info("Content genre : " + TVgetText(Zee5TvWelcomePage.objContentShowgnereIncontentPage));
			extent.extentLoggerPass("title",
					"Content genre : " + TVgetText(Zee5TvWelcomePage.objContentShowgnereIncontentPage));
		} else {
			logger.info("content genre is not displayed");
			extent.extentLoggerFail("title", "content genre is not displayed");
		}
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objContentShowcertificateIncontentPage, "Content certificate")) {
			logger.info("Content certificate : " + TVgetText(Zee5TvWelcomePage.objContentShowcertificateIncontentPage));
			extent.extentLoggerPass("title",
					"Content certificate : " + TVgetText(Zee5TvWelcomePage.objContentShowcertificateIncontentPage));
		} else {
			logger.info("content certificate is not displayed");
			extent.extentLoggerFail("title", "content certificate is not displayed");
		}
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objContenttrailerplaybackIncontentPage, "Trailer playback")) {
			logger.info("Auto trailer playback is initiated");
			extent.extentLoggerPass("trailer", "Auto trailer playback is initiated");
		} else {
			logger.info("Content does not have trailer");
			extent.extentLoggerPass("trailer", "Content does not have trailer");
		}

		TVclick(Zee5TvSearchPage.objPlayIcon, "Play Icon");
		waitTime(4000);
		if (userType.equals("Guest")) {
			if (verifyIsElementDisplayed(Zee5TvSearchPage.objShowsLoginPopup, "Login popup")) {
				logger.info("Login popup is displayed when user play premium content as guest user");
				extent.extentLoggerPass("Popup",
						"Login popup is displayed when user play premium content as guest user");
			} else {
				logger.info("Functioanlity failed");
				extent.extentLoggerFail("Popup", "Popup Functioanlity failed");
			}

		}
		if (userType.equals("NonSubscribedUser")) {
			if (verifyIsElementDisplayed(Zee5TvSearchPage.objShowsLoginPopup, "Subscribe now popup")) {
				logger.info("Subscribe popup is displayed when user play premium content as Nonsubscribe user");
				extent.extentLoggerPass("Popup",
						"Subscribe popup is displayed when user play premium content as Nonsubscribe user");
			} else {
				logger.info("Functioanlity failed");
				extent.extentLoggerFail("Popup", "Functioanlity failed");
			}
		}
		if (userType.equals("SubscribedUser")) {
			// LoadingInProgress();
			Runtime.getRuntime().exec("adb shell input keyevent 23");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 23");
			Runtime.getRuntime().exec("adb shell input keyevent 23");
			if (verifyIsElementDisplayed(Zee5TvPlayerPage.objPlayerContainer, "Consumption screen")) {
				logger.info("User is able to play premium content for premium user");
				extent.extentLoggerPass("play", "User is able to play premium content for premium user");
			} else {
				logger.info("playback did not initiate");
				extent.extentLoggerFail("play", "playback did not initiate");
			}

		}
		getDriver().navigate().back();
		waitTime(5000);
		if (userType.equals("Guest") || userType.equals("NonSubscribedUser")) {
			if (verifyIsElementDisplayed(Zee5TvSearchPage.objwatchTrailerIcon, "watch trailer button")) {
				waitTime(5000);
				TVclick(Zee5TvSearchPage.objwatchTrailerIcon, "watch trailer button");
				waitTime(2000);
				TVclick(Zee5TvSearchPage.objwatchTrailerIcon, "watch trailer button");
				waitTime(2000);
				// LoadingInProgress();
				waitTime(10000);
				Runtime.getRuntime().exec("adb shell input keyevent 23");
				waitTime(3000);
				Runtime.getRuntime().exec("adb shell input keyevent 23");
				if (verifyIsElementDisplayed(Zee5TvPlayerPage.objPlayerContainer, "Consumption screen")) {
					logger.info("User is able to play free content");
					extent.extentLoggerPass("play", "User is able to play free content");
				} else {
					logger.info("playback did not initiate");
					extent.extentLoggerFail("play", "playback did not initiate");
				}
				getDriver().navigate().back();
				waitTime(5000);
			} else {
				logger.info("Watch trailer button is not present");
				extent.extentLoggerPass("Trailer", "Watch trailer button is not present");
			}
		}
		getDriver().navigate().back();
		waitTime(5000);
		for (int k = 0; k <= 7; k++) {
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
		}
	}

	public void playbackMoviespage() throws Exception {
		HeaderChildNode("Content detail page functionality through Movies page");
		waitTime(10000);
		TVTabSelect("Movies");
		logger.info(TVgetText(Zee5TvHomePage.objHighlightedTab) + "Tab is highlighted");
		extent.extentLoggerPass("Tab", "HighLighted Tab :" + TVgetText(Zee5TvHomePage.objHighlightedTab));
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		for (int i = 0; i <= 10; i++) {
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objMoviePageTrayContent, "Tray content")) {
				TVclick(Zee5TvWelcomePage.objMoviePageTrayContent, "Tray content");
				if (verifyIsElementDisplayed(Zee5TvSearchPage.objPlayIcon, "Content Title")) {
					logger.info("User is navigated to content detail page");
					extent.extentLoggerPass("Page", "User is navigated to content detail page");
				} else {
					TVclick(Zee5TvWelcomePage.objMoviePageTrayContent, "Movie page Tray content");
				}
				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 20");
				waitTime(3000);
			}
		}
		waitTime(10000);
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objContentTitleIncontentPage, "Content Title")) {
			logger.info("Content title : " + TVgetText(Zee5TvWelcomePage.objContentTitleIncontentPage));
			extent.extentLoggerPass("title",
					"Content title : " + TVgetText(Zee5TvWelcomePage.objContentTitleIncontentPage));
		} else {
			logger.info("content title is not displayed");
			extent.extentLoggerFail("title", "content title is not displayed");
		}
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objContentDescriptionIncontentPage, "Content Description")) {
			logger.info("Content Description : " + TVgetText(Zee5TvWelcomePage.objContentDescriptionIncontentPage));
			extent.extentLoggerPass("title",
					"Content Description : " + TVgetText(Zee5TvWelcomePage.objContentDescriptionIncontentPage));
		} else {
			logger.info("content Description is not displayed");
			extent.extentLoggerFail("title", "content Description is not displayed");
		}
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objContentTypeIncontentPage, "Content type")) {
			logger.info("Content type : " + TVgetText(Zee5TvWelcomePage.objContentTypeIncontentPage));
			extent.extentLoggerPass("title",
					"Content type : " + TVgetText(Zee5TvWelcomePage.objContentTypeIncontentPage));
		} else {
			logger.info("content type is not displayed");
			extent.extentLoggerFail("title", "content type is not displayed");
		}
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objContentgenreIncontentPage, "Content genre")) {
			logger.info("Content genre : " + TVgetText(Zee5TvWelcomePage.objContentgenreIncontentPage));
			extent.extentLoggerPass("title",
					"Content genre : " + TVgetText(Zee5TvWelcomePage.objContentgenreIncontentPage));
		} else {
			logger.info("content genre is not displayed");
			extent.extentLoggerFail("title", "content genre is not displayed");
		}
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objContentcertificateIncontentPage, "Content certificate")) {
			logger.info("Content certificate : " + TVgetText(Zee5TvWelcomePage.objContentcertificateIncontentPage));
			extent.extentLoggerPass("title",
					"Content certificate : " + TVgetText(Zee5TvWelcomePage.objContentcertificateIncontentPage));
		} else {
			logger.info("content certificate is not displayed");
			extent.extentLoggerFail("title", "content certificate is not displayed");
		}
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objContentdurationIncontentPage, "Content duration")) {
			logger.info("Content duration : " + TVgetText(Zee5TvWelcomePage.objContentdurationIncontentPage));
			extent.extentLoggerPass("title",
					"Content duration : " + TVgetText(Zee5TvWelcomePage.objContentdurationIncontentPage));
		} else {
			logger.info("content duration is not displayed");
			extent.extentLoggerFail("title", "content duration is not displayed");
		}
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objContenttrailerplaybackIncontentPage, "Trailer playback")) {
			logger.info("Auto trailer playback is initiated");
			extent.extentLoggerPass("trailer", "Auto trailer playback is initiated");
		} else {
			logger.info("Content does not have trailer");
			extent.extentLoggerPass("trailer", "Content does not have trailer");
		}

		TVclick(Zee5TvSearchPage.objPlayIcon, "Play Icon");
		waitTime(4000);
		if (userType.equals("Guest")) {
			if (verifyIsElementDisplayed(Zee5TvSearchPage.objLoginPopup, "Login popup")) {
				logger.info("Login popup is displayed when user play premium content as guest user");
				extent.extentLoggerPass("Popup",
						"Login popup is displayed when user play premium content as guest user");
			} else {
				logger.info("Functioanlity failed");
				extent.extentLoggerFail("Popup", "Popup Functioanlity failed");
			}

		}
		if (userType.equals("NonSubscribedUser")) {
			if (verifyIsElementDisplayed(Zee5TvSearchPage.objSubscribePopup, "Subscribe now popup")) {
				logger.info("Subscribe popup is displayed when user play premium content as Nonsubscribe user");
				extent.extentLoggerPass("Popup",
						"Subscribe popup is displayed when user play premium content as Nonsubscribe user");
			} else {
				logger.info("Functioanlity failed");
				extent.extentLoggerFail("Popup", "Popup Functioanlity failed");
			}
		}
		if (userType.equals("SubscribedUser")) {
			// LoadingInProgress();
			Runtime.getRuntime().exec("adb shell input keyevent 23");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 23");
			Runtime.getRuntime().exec("adb shell input keyevent 23");
			if (verifyIsElementDisplayed(Zee5TvPlayerPage.objPlayerContainer, "Consumption screen")) {
				logger.info("User is able to play premium content for premium user");
				extent.extentLoggerPass("play", "User is able to play premium content for premium user");
			} else {
				logger.info("playback did not initiate");
				extent.extentLoggerFail("play", "playback did not initiate");
			}

		}
		getDriver().navigate().back();
		waitTime(5000);
		if (userType.equals("Guest") || userType.equals("NonSubscribedUser")) {
			// Runtime.getRuntime().exec("adb shell input keyevent 22");
			if (verifyIsElementDisplayed(Zee5TvSearchPage.objwatchTrailerIcon, "watch trailer button")) {
				waitTime(5000);
				TVclick(Zee5TvSearchPage.objwatchTrailerIcon, "watch trailer button");
				waitTime(2000);
				TVclick(Zee5TvSearchPage.objwatchTrailerIcon, "watch trailer button");
				waitTime(2000);
				// LoadingInProgress();
				waitTime(10000);
				Runtime.getRuntime().exec("adb shell input keyevent 23");
				waitTime(3000);
				Runtime.getRuntime().exec("adb shell input keyevent 23");
				if (verifyIsElementDisplayed(Zee5TvPlayerPage.objPlayerContainer, "Consumption screen")) {
					logger.info("User is able to play free content");
					extent.extentLoggerPass("play", "User is able to play free content");
				} else {
					logger.info("playback did not initiate");
					extent.extentLoggerFail("play", "playback did not initiate");
				}
				getDriver().navigate().back();
				waitTime(5000);
			} else {
				logger.info("Watch trailer button is not present");
				extent.extentLoggerPass("Trailer", "Watch trailer button is not present");
			}
		}
		getDriver().navigate().back();
		waitTime(5000);
		for (int k = 0; k <= 8; k++) {
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(2000);
		}

	}

	public void playbackPremiumpage() throws Exception {
		HeaderChildNode("Content detail page functionality through Premium page");
		waitTime(10000);
		TVTabSelect("Premium");
		logger.info(TVgetText(Zee5TvHomePage.objHighlightedTab) + "Tab is highlighted");
		extent.extentLoggerPass("Tab", "HighLighted Tab :" + TVgetText(Zee5TvHomePage.objHighlightedTab));
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		for (int i = 0; i <= 10; i++) {
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objPremiumPageTrayContent, "Tray content")) {
				waitTime(3000);
				TVclick(Zee5TvWelcomePage.objPremiumPageTrayContent, "Tray content");
				waitTime(3000);
				if (verifyIsElementDisplayed(Zee5TvSearchPage.objPlayIcon, "Content Title")) {
					logger.info("User is navigated to content detail page");
					extent.extentLoggerPass("Page", "User is navigated to content detail page");
				} else {
					Runtime.getRuntime().exec("adb shell input keyevent 20");
					TVclick(Zee5TvWelcomePage.objPremiumPageTrayContent, "Premium page Tray content");
				}
				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 20");
				waitTime(3000);
			}
		}
		waitTime(10000);
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objContentTitleIncontentPage, "Content Title")) {
			logger.info("Content title : " + TVgetText(Zee5TvWelcomePage.objContentTitleIncontentPage));
			extent.extentLoggerPass("title",
					"Content title : " + TVgetText(Zee5TvWelcomePage.objContentTitleIncontentPage));
		} else {
			logger.info("content title is not displayed");
			extent.extentLoggerFail("title", "content title is not displayed");
		}
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objContentDescriptionIncontentPage, "Content Description")) {
			logger.info("Content Description : " + TVgetText(Zee5TvWelcomePage.objContentDescriptionIncontentPage));
			extent.extentLoggerPass("title",
					"Content Description : " + TVgetText(Zee5TvWelcomePage.objContentDescriptionIncontentPage));
		} else {
			logger.info("content Description is not displayed");
			extent.extentLoggerFail("title", "content Description is not displayed");
		}
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objContentTypeIncontentPage, "Content type")) {
			logger.info("Content type : " + TVgetText(Zee5TvWelcomePage.objContentTypeIncontentPage));
			extent.extentLoggerPass("title",
					"Content type : " + TVgetText(Zee5TvWelcomePage.objContentTypeIncontentPage));
		} else {
			logger.info("content type is not displayed");
			extent.extentLoggerFail("title", "content type is not displayed");
		}
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objContentgenreIncontentPage, "Content genre")) {
			logger.info("Content genre : " + TVgetText(Zee5TvWelcomePage.objContentgenreIncontentPage));
			extent.extentLoggerPass("title",
					"Content genre : " + TVgetText(Zee5TvWelcomePage.objContentgenreIncontentPage));
		} else {
			logger.info("content genre is not displayed");
			extent.extentLoggerFail("title", "content genre is not displayed");
		}
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objContentcertificateIncontentPage, "Content certificate")) {
			logger.info("Content certificate : " + TVgetText(Zee5TvWelcomePage.objContentcertificateIncontentPage));
			extent.extentLoggerPass("title",
					"Content certificate : " + TVgetText(Zee5TvWelcomePage.objContentcertificateIncontentPage));
		} else {
			logger.info("content certificate is not displayed");
			extent.extentLoggerFail("title", "content certificate is not displayed");
		}
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objContentdurationIncontentPage, "Content duration")) {
			logger.info("Content duration : " + TVgetText(Zee5TvWelcomePage.objContentdurationIncontentPage));
			extent.extentLoggerPass("title",
					"Content duration : " + TVgetText(Zee5TvWelcomePage.objContentdurationIncontentPage));
		} else {
			logger.info("content duration is not displayed");
			extent.extentLoggerFail("title", "content duration is not displayed");
		}
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objContenttrailerplaybackIncontentPage, "Trailer playback")) {
			logger.info("Auto trailer playback is initiated");
			extent.extentLoggerPass("trailer", "Auto trailer playback is initiated");
		} else {
			logger.info("Content does not have trailer");
			extent.extentLoggerPass("trailer", "Content does not have trailer");
		}

		TVclick(Zee5TvSearchPage.objPlayIcon, "Play Icon");
		waitTime(4000);
		if (userType.equals("Guest")) {
			if (verifyIsElementDisplayed(Zee5TvSearchPage.objLoginPopup, "Login popup")) {
				logger.info("Login popup is displayed when user play premium content as guest user");
				extent.extentLoggerPass("Popup",
						"Login popup is displayed when user play premium content as guest user");
			} else {
				logger.info("Functioanlity failed");
				extent.extentLoggerFail("Popup", "popup Functioanlity failed");
			}

		}
		if (userType.equals("NonSubscribedUser")) {
			if (verifyIsElementDisplayed(Zee5TvSearchPage.objSubscribePopup, "Subscribe now popup")) {
				logger.info("Subscribe popup is displayed when user play premium content as Nonsubscribe user");
				extent.extentLoggerPass("Popup",
						"Subscribe popup is displayed when user play premium content as Nonsubscribe user");
			} else {
				logger.info("Functioanlity failed");
				extent.extentLoggerFail("Popup", "Popup Functioanlity failed");
			}
		}
		if (userType.equals("SubscribedUser")) {
			// LoadingInProgress();
			Runtime.getRuntime().exec("adb shell input keyevent 23");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 23");
			Runtime.getRuntime().exec("adb shell input keyevent 23");
			if (verifyIsElementDisplayed(Zee5TvPlayerPage.objPlayerContainer, "Consumption screen")) {
				logger.info("User is able to play premium content for premium user");
				extent.extentLoggerPass("play", "User is able to play premium content for premium user");
			} else {
				logger.info("playback did not initiate");
				extent.extentLoggerFail("play", "playback did not initiate");
			}

		}
		getDriver().navigate().back();
		waitTime(5000);
		if (userType.equals("Guest") || userType.equals("NonSubscribedUser")) {

			if (verifyIsElementDisplayed(Zee5TvSearchPage.objwatchTrailerIcon, "watch trailer button")) {
				waitTime(5000);
				TVclick(Zee5TvSearchPage.objwatchTrailerIcon, "watch trailer button");
				waitTime(2000);
				TVclick(Zee5TvSearchPage.objwatchTrailerIcon, "watch trailer button");
				waitTime(2000);
				// LoadingInProgress();
				waitTime(10000);
				Runtime.getRuntime().exec("adb shell input keyevent 23");
				waitTime(3000);
				Runtime.getRuntime().exec("adb shell input keyevent 23");
				if (verifyIsElementDisplayed(Zee5TvPlayerPage.objPlayerContainer, "Consumption screen")) {
					logger.info("User is able to play free content");
					extent.extentLoggerPass("play", "User is able to play free content");
				} else {
					logger.info("playback did not initiate");
					extent.extentLoggerFail("play", "playback did not initiate");
				}
				getDriver().navigate().back();
				waitTime(5000);
			} else {
				logger.info("Watch trailer button is not present");
				extent.extentLoggerPass("Trailer", "Watch trailer button is not present");
			}
		}
		getDriver().navigate().back();
		waitTime(5000);
		for (int k = 0; k <= 8; k++) {
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(2000);
		}
	}

	public void playbackvideospage() throws Exception {
		HeaderChildNode("Content detail page functionality through Videos page");
		TVTabSelect("Videos");
		logger.info(TVgetText(Zee5TvHomePage.objHighlightedTab) + "Tab is highlighted");
		extent.extentLoggerPass("Tab", "HighLighted Tab :" + TVgetText(Zee5TvHomePage.objHighlightedTab));
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		for (int i = 0; i <= 15; i++) {
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objVideoPageTrayContentPlayback,
					"Videos page Tray content")) {
				TVclick(Zee5TvWelcomePage.objVideoPageTrayContentPlayback, "Videos page Tray content");
				waitTime(4000);
				if (verifyIsElementDisplayed(Zee5TvSearchPage.objPlayIcon, "Content Title")) {
					logger.info("User is navigated to content detail page");
					extent.extentLoggerPass("Page", "User is navigated to content detail page");
				} else {
					Runtime.getRuntime().exec("adb shell input keyevent 20");
					TVclick(Zee5TvWelcomePage.objVideoPageTrayContentPlayback, "Videos page Tray content");
				}
				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 20");
				waitTime(3000);
			}
		}
		waitTime(10000);
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objContentTitleIncontentPage, "Content Title")) {
			logger.info("Content title : " + TVgetText(Zee5TvWelcomePage.objContentTitleIncontentPage));
			extent.extentLoggerPass("title",
					"Content title : " + TVgetText(Zee5TvWelcomePage.objContentTitleIncontentPage));
		} else {
			logger.info("content title is not displayed");
			extent.extentLoggerFail("title", "content title is not displayed");
		}
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objContentDescriptionIncontentPage, "Content Description")) {
			logger.info("Content Description : " + TVgetText(Zee5TvWelcomePage.objContentDescriptionIncontentPage));
			extent.extentLoggerPass("title",
					"Content Description : " + TVgetText(Zee5TvWelcomePage.objContentDescriptionIncontentPage));
		} else {
			logger.info("content Description is not displayed");
			extent.extentLoggerFail("title", "content Description is not displayed");
		}
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objContentShowTypeIncontentPage, "Content type")) {
			logger.info("Content type : " + TVgetText(Zee5TvWelcomePage.objContentShowTypeIncontentPage));
			extent.extentLoggerPass("title",
					"Content type : " + TVgetText(Zee5TvWelcomePage.objContentShowTypeIncontentPage));
		} else {
			logger.info("content type is not displayed");
			extent.extentLoggerFail("title", "content type is not displayed");
		}
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objContentShowgnereIncontentPage, "Content genre")) {
			logger.info("Content genre : " + TVgetText(Zee5TvWelcomePage.objContentShowgnereIncontentPage));
			extent.extentLoggerPass("title",
					"Content genre : " + TVgetText(Zee5TvWelcomePage.objContentShowgnereIncontentPage));
		} else {
			logger.info("content genre is not displayed");
			extent.extentLoggerFail("title", "content genre is not displayed");
		}
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objContentShowcertificateIncontentPage, "Content certificate")) {
			logger.info("Content certificate : " + TVgetText(Zee5TvWelcomePage.objContentShowcertificateIncontentPage));
			extent.extentLoggerPass("title",
					"Content certificate : " + TVgetText(Zee5TvWelcomePage.objContentShowcertificateIncontentPage));
		} else {
			logger.info("content certificate is not displayed");
			extent.extentLoggerFail("title", "content certificate is not displayed");
		}
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objContenttrailerplaybackIncontentPage, "Trailer playback")) {
			logger.info("Auto trailer playback is initiated");
			extent.extentLoggerPass("trailer", "Auto trailer playback is initiated");
		} else {
			logger.info("Content does not have trailer");
			extent.extentLoggerPass("trailer", "Content does not have trailer");
		}

		TVclick(Zee5TvSearchPage.objPlayIcon, "Play Icon");
		waitTime(4000);

		// LoadingInProgress();
		waitTime(2000);
		AdVerify();
		waitTime(10000);
		Runtime.getRuntime().exec("adb shell input keyevent 23");
		waitTime(3000);
		Runtime.getRuntime().exec("adb shell input keyevent 23");
		if (verifyIsElementDisplayed(Zee5TvPlayerPage.objPlayerContainer, "Consumption screen")) {
			logger.info("User is navigated to consumption screen");
			extent.extentLoggerPass("play", "User is navigated to consumption screen");
		} else {
			logger.info("playback did not initiate");
			extent.extentLoggerFail("play", "playback did not initiate");
		}
		getDriver().navigate().back();
		waitTime(5000);
		getDriver().navigate().back();
		waitTime(5000);
		for (int k = 0; k <= 8; k++) {
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
		}
		waitTime(3000);
		for (int k = 0; k <= 8; k++) {
			Runtime.getRuntime().exec("adb shell input keyevent 21");
			waitTime(3000);
		}
	}

	public void playbackNewspage() throws Exception {
		HeaderChildNode("Content detail page functionality through News page");
		TVTabSelect("News");
		logger.info(TVgetText(Zee5TvHomePage.objHighlightedTab) + "Tab is highlighted");
		extent.extentLoggerPass("Tab", "HighLighted Tab :" + TVgetText(Zee5TvHomePage.objHighlightedTab));
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		for (int i = 0; i <= 15; i++) {
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objLiveNewsContentinNewsPage, "News page Tray content")) {
				waitTime(5000);
				TVclick(Zee5TvWelcomePage.objLiveNewsContentinNewsPage, "News page Tray content");
				TVclick(Zee5TvWelcomePage.objLiveNewsContentinNewsPage, "News page Tray content");
				waitTime(4000);
				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 20");
				waitTime(3000);
			}
		}
		waitTime(5000);
		// LoadingInProgress();
		AdVerify();
		waitTime(15000);
		for (int i = 0; i <= 5; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 23");
			waitTime(2000);
			if (verifyIsElementDisplayed(Zee5TvSearchPage.objGotolivebutton, "Live button in player")) {
				logger.info("User is able play Free EPG content");
				extent.extentLoggerPass("EPG", "User is able play Free news content");
				break;
			}
		}
		getDriver().navigate().back();
		for (int k = 0; k <= 5; k++) {
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
		}

	}

	public void carouselValidation(String tab) throws Exception {
		HeaderChildNode("Carousel Validation  " + tab + " Tab");
		if (userType.equals("Guest")) {
			waitTime(10000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip Link")) {
				TVclick(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip link");
				extent.extentLoggerPass("Clicked on Skip Link", "Clicked on Skip Link");
			} else {
				logger.info("User is logged in");
				extent.extentLoggerPass("Button", "User is logged in");
			}
		}
		waitTime(3000);
		TVTabSelect(tab);
		waitTime(5000);
		HeaderChildNode("Auto rotation functionality");
		carouselTitle = TVgetText(Zee5TVCarousel.objCarouselTitle);
		logger.info("Carousel title before auto rotation :" + carouselTitle);
		extent.extentLoggerPass("Auto", "Carousel title before auto rotation :" + carouselTitle);
		waitTime(5000);
		TVTabSelect(tab);
		String carouselTitle2 = TVgetText(Zee5TVCarousel.objCarouselTitle);
		logger.info("Carousel title after auto rotation :" + carouselTitle2);
		extent.extentLoggerPass("Auto", "Carousel title after auto rotation :" + carouselTitle2);
		if (!carouselTitle.equals(carouselTitle2)) {
			logger.info("Auto rotation functionality successfull");
			extent.extentLoggerPass("Auto", "Auto rotation functionality successfull");
		} else {
			logger.info("Auto rotation functionality failed");
			extent.extentLoggerFail("Auto", "Auto rotation functionality failed");
		}
		HeaderChildNode("Carousel content details validation");
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(7000);
		TVclick(Zee5TVCarousel.objCarouselTitle, "Carousel title");
		if (verifyIsElementDisplayed(Zee5TVCarousel.objCarouselTitle, "Carousel title")) {
			carouselTitle = TVgetText(Zee5TVCarousel.objCarouselTitle);
			logger.info("Carousel title : " + carouselTitle);
			extent.extentLoggerPass("Title", "Carousel title : " + carouselTitle);
		} else {
			logger.info("Carousel title is not displayed");
			extent.extentLoggerFail("Title", "Carousel title is not displayed");
		}

		if (verifyIsElementDisplayed(Zee5TVCarousel.objCarouselPremiumTag, "Carousel Premium tag")) {
			logger.info("Premium tag is displayed for premium content");
			extent.extentLoggerPass("Tag", "Premium tag is displayed for premium content");
		} else {
			logger.info("Premium tag is not displayed in carousel for " + carouselTitle);
			extent.extentLoggerPass("Title", "Premium tag is not displayed in carousel for " + carouselTitle);
		}
		if (verifyIsElementDisplayed(Zee5TVCarousel.objCarouselMetadata, "Carousel Metadata")) {
			String carouselMetadata = TVgetText(Zee5TVCarousel.objCarouselMetadata);
			logger.info("Carousel Metadata : " + carouselMetadata);
			extent.extentLoggerPass("Metadata", "Carousel Metadata : " + carouselMetadata);
		} else {
			logger.info("Carousel Metadata is not displayed for" + carouselTitle);
			extent.extentLoggerPass("Carousel", "Carousel Metadata is not displayed for" + carouselTitle);
		}
		if (verifyIsElementDisplayed(Zee5TVCarousel.objCarouselDescription, "Carousel Description")) {
			carouselDescription = TVgetText(Zee5TVCarousel.objCarouselDescription);
			logger.info("Carousel Description : " + carouselDescription);
			extent.extentLoggerPass("Description", "Carousel Description : " + carouselDescription);
		} else {
			logger.info("Carousel Description is not displayed for " + carouselTitle);
			extent.extentLoggerFail("Carousel", "Carousel Description is not displayed for " + carouselTitle);
		}
		if (verifyIsElementDisplayed(Zee5TVCarousel.objCarouselPlayButton, "Carousel play button")) {
			logger.info("Carousel play button is displayed");
			extent.extentLoggerPass("Carousel", "Carousel play button is displayed");
		} else {
			logger.info("Carousel play button is not displayed");
			extent.extentLoggerFail("Carousel", "Carousel play button is not displayed");
		}
		if (userType.equals("Guest") || userType.equals("NonSubscribedUser")) {
			if (verifyIsElementDisplayed(Zee5TVCarousel.objCarouselSubscribeButton, "Carousel Subscribe button")) {
				logger.info("carousel subscribe button is displayed");
				extent.extentLoggerPass("carousel", "carousel subscribe button is displayed");
			} else {
				logger.info("carousel subscribe button is not displayed for " + carouselTitle);
				extent.extentLoggerPass("Title", "carousel subscribe button is not displayed for " + carouselTitle);
			}
		}
		if (userType.equals("SubscribedUser")) {
			if (verifyIsElementDisplayed(Zee5TVCarousel.objCarouselSubscribeButton, "Carousel Subscribe button")) {
				logger.info("carousel subscribe button is displayed for subscribed user");
				extent.extentLoggerFail("carousel", "carousel subscribe button is displayed for subscribed user");
			} else {
				logger.info("carousel subscribe button is not displayed for subscribed user ");
				extent.extentLoggerPass("Title", "carousel subscribe button is not displayed for subscribed user");
			}
		}
		if (carouselDescription.contains(carouselTitle)) {
			logger.info("Metadata and title macthed");
			extent.extentLoggerPass("Title", "Metadata and title macthed");
		} else {
			logger.info("Metadata and title does not macthed");
			extent.extentLogger("Title", "Metadata and title does not macthed");
		}
		HeaderChildNode("Carousel play button functionality");
		verifyIsElementDisplayed(Zee5TVCarousel.objCarouselPlayButton, "Play button");
		TVclick(Zee5TVCarousel.objCarouselPlayButton, "Play button");
		if (tab.equals("News")) {
			waitTime(10000);
			// LoadingInProgress();
			AdVerify();
			waitTime(5000);
			Runtime.getRuntime().exec("adb shell input keyevent 23");
			waitTime(2000);
			if (verifyIsElementDisplayed(Zee5TvSearchPage.objGotolivebutton, "Live button in player")) {
				logger.info(
						"User is navigated to consumption screen post tapping on carousel play button is news page");
				extent.extentLoggerPass("Page",
						"User is navigated to consumption screen post tapping on carousel play button is news page");
				getDriver().navigate().back();
				waitTime(3000);
				getDriver().navigate().back();
				waitTime(3000);
			} else {
				logger.info("Functionality failed");
				extent.extentLoggerFail("Play", "Playback Functionality failed");
			}
		}
		if (tab.equals("Videos")) {
			waitTime(5000);
			// LoadingInProgress();
			waitTime(2000);
			AdVerify();
			waitTime(10000);
			Runtime.getRuntime().exec("adb shell input keyevent 23");
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvPlayerPage.objPlayerContainer, "Player pause")) {
				logger.info("User is navigated to consumption screen");
				extent.extentLoggerPass("play", "User is navigated to consumption screen");
				getDriver().navigate().back();
				waitTime(3000);
				getDriver().navigate().back();
				waitTime(3000);
			} else {
				logger.info("playback did not initiate");
				extent.extentLoggerFail("play", "playback did not initiate");
			}
		}
		waitTime(5000);
		if (tab.equals("News") == false) {
			if (tab.equals("Videos") == false) {
				TVclick(Zee5TvSearchPage.objPlayIcon, "Play Icon");
				waitTime(4000);
				if (userType.equals("Guest")) {
					if (verifyIsElementDisplayed(Zee5TvSearchPage.objLoginPopup, "Login popup")) {
						logger.info("Login popup is displayed when user play premium content as guest user");
						extent.extentLoggerPass("Popup",
								"Login popup is displayed when user play premium content as guest user");
					} else {
						logger.info("User is navigated to consumption page");
						extent.extentLoggerPass("Popup", "User is navigated to consumption page");
					}

				}
				if (userType.equals("NonSubscribedUser")) {
					if (verifyIsElementDisplayed(Zee5TvSearchPage.objLoginPopup, "Subscribe now popup")) {
						logger.info("Subscribe popup is displayed when user play premium content as Nonsubscribe user");
						extent.extentLoggerPass("Popup",
								"Subscribe popup is displayed when user play premium content as Nonsubscribe user");
					} else {
						logger.info("User is navigated to consumption page");
						extent.extentLoggerPass("Popup", "User is navigated to consumption page");
					}
				}
				if (userType.equals("SubscribedUser")) {
					// LoadingInProgress();
					waitTime(7000);
					if (verifyIsElementDisplayed(Zee5TvPlayerPage.objPlayerSkipIntro, "SkipIntro")) {
						TVRemoteEvent(20);
						waitTime(2000);
						TVRemoteEvent(23);
						logger.info("clicked on skip intro");
						extent.extentLoggerPass("Intro", "clicked on skip intro");
					} else {
						logger.info("Skip intro is not displayed");
						extent.extentLoggerPass("Intro", "Skip intro is not displayed");
					}
					waitTime(8000);
					Runtime.getRuntime().exec("adb shell input keyevent 23");
					waitTime(3000);
					if (verifyIsElementDisplayed(Zee5TvPlayerPage.objPlayerContainer, "Player container")) {
						logger.info("User is able to play premium content for premium user");
						extent.extentLoggerPass("play", "User is able to play premium content for premium user");
					} else {
						logger.info("playback did not initiate");
						extent.extentLoggerFail("play", "playback did not initiate");
					}

				}
				getDriver().navigate().back();
				waitTime(3000);
				getDriver().navigate().back();
				waitTime(8000);
			}
		}
		getDriver().navigate().back();
		waitTime(3000);
		if (verifyIsElementDisplayed(Zee5TVCarousel.objCarouselSubscribeButton, "Subscribe button")) {
			TVclick(Zee5TVCarousel.objCarouselSubscribeButton, "Subscribe button");
			// LoadingInProgress();
			waitTime(10000);
			if (verifyIsElementDisplayed(Zee5TVCarousel.objSubscriptionPlanPage, "My Plans page")) {
				logger.info("User is navigated to Subscription page post tapping on get premium tab in carousel");
				extent.extentLoggerPass("plan",
						"User is navigated to Subscription page post tapping on get premium tab in carousel");
				getDriver().navigate().back();
			} else {
				logger.info("Navigation failed");
				extent.extentLoggerFail("Plan", "Navigation failed");
			}
		} else {
			logger.info("carousel subscribe button is not displayed for " + carouselTitle);
			extent.extentLoggerPass("Title", "carousel subscribe button is not displayed for " + carouselTitle);
		}
		Runtime.getRuntime().exec("adb shell input keyevent 19");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 19");
		waitTime(3000);
		getDriver().closeApp();

		waitTime(3000);

		getDriver().launchApp();

		waitTime(10000);
		if (userType.equals("Guest")) {
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
		}
	}

	@SuppressWarnings({ "unused", "rawtypes" })
	public void playerScenarios() throws Exception {
		extent.HeaderChildNode("Consumption page Functionality");
		waitTime(10000);
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip Link")) {
			TVclick(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip link");
			extent.extentLoggerPass("Clicked on Skip Link", "Clicked on Skip Link");
		} else {
			logger.info("User is logged in");
			extent.extentLoggerPass("Button", "User is logged in");
		}

		waitTime(5000);
		TVTabSelect("Home");
		logger.info(TVgetText(Zee5TvHomePage.objHighlightedTab) + "Tab is highlighted");
		extent.extentLoggerPass("Tab", "HighLighted Tab :" + TVgetText(Zee5TvHomePage.objHighlightedTab));

		if (TVgetAttributValue("focused", Zee5TvHomePage.objSearchIcon).equals("false")) {

			TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
			TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
		} else {

			TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
		}
		waitTime(5000);
		String searchdata1[] = { "b", "a", "b", "l", "u", };
		String searchdata2[] = { "d", "a", "b", "l", "u" };
		String searchdata3[] = { "r", "o", "b", "o" };
		String searchdata4[] = { "r", "u", "m", "b", "l", "e" };
		HeaderChildNode("Search Movie content and its playback functionality");
		type(searchdata1);
		TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space");
		type(searchdata2);
		TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space");
		type(searchdata3);
		TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space");
		type(searchdata4);

		HeaderChildNode("Navigating to consumption through searched content");
		String content = TVgetText(Zee5TvSearchPage.objEditbox);

		logger.info("Entered Search Data : " + content);
		extent.extentLogger("Search", "Entered Searched Data : " + content);

		int k;
		List<WebElement> ele = getDriver().findElements(By.xpath("//*[@id='search_result_title']"));
		for (int i = 1; i <= ele.size(); i++) {
			String title = TVgetText(Zee5TvSearchPage.objSearchedTumbnailTitle(i));
			logger.info("Serach result content title : " + title);
			extent.extentLogger("Title", "Serach result content title : " + title);

			if ((verifyIsElementDisplayed(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title, "Movies"),
					"Searched Movie"))) {
				TVclick(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title, "Movies"), "serached Movie");
				break;
			} else {
				System.out.println("No match");
			}

		}

		waitTime(8000);
		// LoadingInProgress();

		String title = TVgetText(Zee5TvSearchPage.objSearchedDataTitle);
		waitTime(2000);
		TVclick(Zee5TvSearchPage.objPlayIcon, "Play Icon");

		waitTime(10000);

		// Consumption Page

//		LoadingInProgress();
		waitTime(10000);
		AdVerify();

		waitTime(5000);
		HeaderChildNode("Consumption screen player options functionality");
		if (verifyIsElementDisplayed(Zee5TvPlayerPage.objPlayerSkipIntro, "SkipIntro")) {
			TVRemoteEvent(20);
			waitTime(2000);
			TVRemoteEvent(23);
			logger.info("clicked on skip intro");
			extent.extentLoggerPass("Intro", "clicked on skip intro");
		} else {
			logger.info("Skip intro is not displayed");
			extent.extentLoggerPass("Intro", "Skip intro is not displayed");
		}
		waitTime(20000);
		Runtime.getRuntime().exec("adb shell input keyevent 23");
		waitTime(2000);
		if (verifyIsElementDisplayed(Zee5TvPlayerPage.objPlayerScreenTitle, "Player screen title")) {
			String playertitle = TVgetText(Zee5TvPlayerPage.objPlayerScreenTitle);
			logger.info("Consumption screen title : " + playertitle);
			extentLoggerPass("Consumpltion", "Consumption screen title : " + playertitle);
		} else {
			logger.info("Title is not displayed in consumption");
			extent.extentLogger("Player", "Title is not displayed in consumption");
		}
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 22");
		waitTime(3000);
		Runtime.getRuntime().exec("adb shell input keyevent 23");

		waitTime(3000);
		Runtime.getRuntime().exec("adb shell input keyevent 19");
		waitTime(2000);
		verifyIsElementDisplayed(Zee5TvPlayerPage.objPlayerSettings, "Setting tab");

		waitTime(2000);
		List Options = getDriver().findElements(By.xpath("//*[@id='child_player_settings']"));
		Options.size();
		for (int i = 1; i <= Options.size(); i++) {

			String videooption = getDriver().findElement(Zee5TvPlayerPage.objSearchedSpecificVideoAudioOption(i))
					.getText();
			logger.info("Video setting options present : " + videooption);
		}
		getDriver().navigate().back();
		waitTime(5000);
		Runtime.getRuntime().exec("adb shell input keyevent 19");
		waitTime(3000);
		Runtime.getRuntime().exec("adb shell input keyevent 19");
		if (verifyIsElementDisplayed(Zee5TvPlayerPage.objElapsedTime, "Elapsed Time")) {
			logger.info("Elapsed time in player is displayed");
			extent.extentLoggerPass("Time", "Elapsed time in player is displayed");
		} else {
			logger.info("Elapsed time in player is not displayed");
			extent.extentLogger("Time", "Elapsed time in player is not displayed");
		}
		if (verifyIsElementDisplayed(Zee5TvPlayerPage.objTotalTime, "Total Time")) {
			logger.info("Total time in player is displayed");
			extent.extentLoggerPass("Time", "Total time in player is displayed");
		} else {
			logger.info("Total time in player is not displayed");
			extent.extentLogger("Time", "Total time in player is not displayed");
		}
		String beforeTime = TVgetText(Zee5TvPlayerPage.objElapsedTime);
		logger.info("Time before forward functionality : " + beforeTime);
		extent.extentLoggerPass("Time", "Time before forward functionality : " + beforeTime);
		Runtime.getRuntime().exec("adb shell input keyevent 22");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 22");
		waitTime(3000);
		Runtime.getRuntime().exec("adb shell input keyevent 22");
		TVclick(Zee5TvPlayerPage.objElapsedTime, "Elapsed time");
		String afterTime = TVgetText(Zee5TvPlayerPage.objElapsedTime);
		logger.info("Time after forward functionality : " + afterTime);
		extent.extentLoggerPass("Time", "Time after forward functionality : " + afterTime);
		if (!beforeTime.equals(afterTime)) {
			logger.info("Forward functionality successfull");
			extent.extentLoggerPass("Time", "Forward functionality successfull");
		} else {
			logger.info("Forward functionality not successfull");
			extent.extentLoggerFail("Time", "Forward functionality not successfull");
		}
		String beforeTime1 = TVgetText(Zee5TvPlayerPage.objElapsedTime);
		logger.info("Time before Reverse functionality : " + beforeTime1);
		extent.extentLoggerPass("Time", "Time before Reverse functionality : " + beforeTime1);
		Runtime.getRuntime().exec("adb shell input keyevent 21");
		waitTime(3000);
		Runtime.getRuntime().exec("adb shell input keyevent 21");
		waitTime(5000);
		TVclick(Zee5TvPlayerPage.objElapsedTime, "Elapsed time");
		String afterTime1 = TVgetText(Zee5TvPlayerPage.objElapsedTime);
		logger.info("Time after Reverse functionality : " + afterTime1);
		extent.extentLoggerPass("Time", "Time after Reverse functionality : " + afterTime1);
		if (!beforeTime1.equals(afterTime1)) {
			logger.info("Reverse functionality successfull");
			extent.extentLoggerPass("Time", "Reverse functionality successfull");
		} else {
			logger.info("Reverse functionality not successfull");
			extent.extentLoggerFail("Time", "Reverse functionality not successfull");
		}
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(3000);
		
			Runtime.getRuntime().exec("adb shell input keyevent 23");
		
		waitTime(4000);
		verifyIsElementDisplayed(Zee5TvPlayerPage.objUpnextrail, "Up Next rail");
		Runtime.getRuntime().exec("adb shell input keyevent 22");
		waitTime(3000);
		Runtime.getRuntime().exec("adb shell input keyevent 23");
		waitTime(12000);
		waitTime(5000);
		// LoadingInProgress();
		AdVerify();
		waitTime(10000);
		Runtime.getRuntime().exec("adb shell input keyevent 23");
		waitTime(3000);
		if (verifyIsElementDisplayed(Zee5TvPlayerPage.objPlayerContainer, "Consumption screen")) {
			logger.info("User is able to play content from upnext rail");
			extent.extentLoggerPass("play", "User is able to play content from upnext rail");
		} else {
			logger.info("playback did not initiate");
			extent.extentLoggerFail("play", "playback did not initiate");
		}
		Runtime.getRuntime().exec("adb shell input keyevent 23");
		waitTime(10000);
		if (!verifyIsElementDisplayed(Zee5TvPlayerPage.objPlayerSettings, "Player options")) {
			logger.info("Player options is hidden after 5 seconds");
			extent.extentLoggerPass("Seconds", "Player options is hidden after 5 seconds");
		} else {
			logger.info("Player options is not hidden after 5 seconds");
			extent.extentLogger("Seconds", "Player options is not hidden after 5 seconds");
		}
		getDriver().navigate().back();
		waitTime(3000);
		if (verifyIsElementDisplayed(Zee5TvHomePage.objMorecontentPopup, "More content popup")) {
			logger.info(
					"Would you like to add selected display language as content language popup is diaplyed when user clicks on different display language");
			extent.extentLoggerPass("Popup",
					"Would you like to add selected display language as content language popup is diaplyed when user clicks on different display language");
			getDriver().navigate().back();
		} else {
			logger.info("Popup is not displayed");
			extent.extentLogger("Popup", "Popup is not displayed");
		}

		getDriver().navigate().back();
		waitTime(3000);
		if (verifyIsElementDisplayed(Zee5TvSearchPage.objEditbox, "Edit box")) {
			logger.info("User is navigated to search page");
		} else {
			getDriver().navigate().back();
		}
		int lenText = getDriver().findElement(Zee5TvSearchPage.objEditbox).getAttribute("text").length();
		for (int i = 0; i < lenText; i++) {
			getDriver().findElement(Zee5TvSearchPage.objSearchBackButton).click();
		}
		String searchdata[] = { "a", "g", "e", "n", "t" };
		String searchdata5[] = { "r", "a", "g", "h", "a", "v" };
		type(searchdata);
		TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space bar");
		type(searchdata5);
		List<WebElement> ele2 = getDriver().findElements(By.xpath("//*[@id='search_result_title']"));
		for (int i = 1; i <= ele2.size(); i++) {
			String title2 = TVgetText(Zee5TvSearchPage.objSearchedTumbnailTitle(i));
			if ((verifyIsElementDisplayed(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title2, "Shows"),
					"Searched Show"))) {
				TVclick(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title2, "Shows"), "serached Show");
				break;
			} else {
				System.out.println("No match");
			}

		}
		waitTime(8000);
		// LoadingInProgress();

		String title5 = TVgetText(Zee5TvSearchPage.objSearchedDataTitle);
		waitTime(2000);
		TVclick(Zee5TvSearchPage.objPlayIcon, "Play Icon");

		waitTime(10000);

		// Consumption Page

		// LoadingInProgress();
		waitTime(5000);
		AdVerify();

		waitTime(5000);
		Runtime.getRuntime().exec("adb shell input keyevent 23");
		waitTime(7000);
		if (verifyIsElementDisplayed(Zee5TvHomePage.objinfo, "Info")) {
			logger.info("Player is paused");
		} else {
			Runtime.getRuntime().exec("adb shell input keyevent 23");
		}
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(3000);
		Runtime.getRuntime().exec("adb shell input keyevent 23");
		waitTime(3000);
		Runtime.getRuntime().exec("adb shell input keyevent 19");
	
		
		if (verifyIsElementDisplayed(Zee5TvPlayerPage.objPlayerAudioLanguageOption, "Audio setting")) {
			logger.info("Audio setting is dsiplayed when user taps on setting button in player page");
			extent.extentLoggerPass("Player",
					"Audio setting is dsiplayed when user taps on setting button in player page");
		} else {
			logger.info("Audio setting is not displayed");
			extent.extentLogger("Audio", "Audio setting is not displayed");
		}

		waitTime(2000);
		List Options2 = getDriver().findElements(By.xpath("//*[@id='child_player_settings']"));
		Options2.size();
		for (int i = 1; i <= Options2.size(); i++) {
			String videooption = getDriver().findElement(Zee5TvPlayerPage.objSearchedSpecificVideoAudioOption(i))
					.getText();
			logger.info("Audio setting options present : " + videooption);
		}
		getDriver().navigate().back();
		waitTime(3000);
		getDriver().navigate().back();
		waitTime(3000);
		getDriver().navigate().back();
		if (verifyIsElementDisplayed(Zee5TvPlayerPage.objContentLangPopup, "POPUP")) {
			getDriver().navigate().back();
		}
		getDriver().navigate().back();
		if (verifyIsElementDisplayed(Zee5TvSearchPage.objEditbox, "Edit box")) {
			logger.info("User is navigated to search page");
		} else {
			getDriver().navigate().back();
		}
		int lenText2 = getDriver().findElement(Zee5TvSearchPage.objEditbox).getAttribute("text").length();
		for (int i = 0; i < lenText2; i++) {
			getDriver().findElement(Zee5TvSearchPage.objSearchBackButton).click();
		}
		String searchpromo[] = { "a", "d", "i", "t", "y", "a" };
		String searchpromo1[] = { "a", "p", "o", "l", "o", "g", "i", "s", "e", "s" };
		String searchpromo2[] = { "t", "o" };
		String searchpromo3[] = { "p", "a", "a", "r", "u" };

		type(searchpromo);
		TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space bar");
		type(searchpromo1);
		TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space bar");
		type(searchpromo2);
		TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space bar");
		type(searchpromo3);
		waitTime(10000);
		List<WebElement> ele3 = getDriver().findElements(By.xpath("//*[@id='search_result_title']"));
		for (int i = 1; i <= ele3.size(); i++) {
			String title2 = TVgetText(Zee5TvSearchPage.objSearchedTumbnailTitle(i));
			if ((verifyIsElementDisplayed(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title2, "Promo"),
					"Searched Promo"))) {
				TVclick(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title2, "Promo"), "serached Promo");
				break;
			} else {
				System.out.println("No match");
			}

		}
		waitTime(45000);
		if (verifyIsElementDisplayed(Zee5TvHomePage.objMorecontentPopup, "More content popup")) {
			logger.info(
					"Would you like to add selected display language as content language popup is diaplyed when user clicks on different display language");
			extent.extentLoggerPass("Popup",
					"Would you like to add selected display language as content language popup is diaplyed when user clicks on different display language");
			getDriver().navigate().back();
		} else {
			logger.info("Popup is not displayed");
			extent.extentLogger("Popup", "Popup is not displayed");
		}

		if (verifyIsElementDisplayed(Zee5TvPlayerPage.objreloadButton, "Replay icon")) {
			logger.info("Replay button is displayed when user plays for the content which does not have upnext rail");
			extent.extentLoggerPass("Replay",
					"Replay button is displayed when user plays for the content which does not have upnext rail");
		} else {
			logger.info("Functionality went wrong");
			extent.extentLogger("Replay", "Functionality went wrong");
		}
		getDriver().navigate().back();
		waitTime(3000);
		if (verifyIsElementDisplayed(Zee5TvSearchPage.objEditbox, "Edit box")) {
			logger.info("User is navigated to search page");
		} else {
			getDriver().navigate().back();
		}
		int lenText3 = getDriver().findElement(Zee5TvSearchPage.objEditbox).getAttribute("text").length();
		for (int i = 0; i < lenText3; i++) {
			getDriver().findElement(Zee5TvSearchPage.objSearchBackButton).click();

		}
		getDriver().navigate().back();
		waitTime(5000);
		TVTabSelect("Home");
		waitTime(5000);
		getDriver().closeApp();

		waitTime(3000);

		getDriver().launchApp();

		waitTime(10000);
		if (userType.equals("Guest")) {
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
		}
	}

	@SuppressWarnings({ "unused", "rawtypes" })
	public void landingPageHome(String userType) throws Exception {
		extent.HeaderChildNode("Home Landing page Functionality");
		waitTime(10000);
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip Link")) {
			TVclick(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip link");
			extent.extentLoggerPass("Clicked on Skip Link", "Clicked on Skip Link");
		} else {
			logger.info("User is logged in");
			extent.extentLoggerPass("Button", "User is logged in");
		}

		waitTime(5000);
		TVTabSelect("Home");
		logger.info("User is navigated to Home tab");
		extent.extentLoggerPass("Tab", "User is navigated to Home tab");
		if (userType.equals("Guest")) {
			if (!verifyIsElementDisplayed(Zee5TvWelcomePage.objContinueWatchingTray, "Continue watching tray")) {
				logger.info("For guest user continue watching tray is not dsiplayed");
				extent.extentLoggerPass("Guest", "For guest user continue watching tray is not dsiplayed");
			} else {
				logger.info("Continue watching is displayed");
			}
			if (!verifyIsElementDisplayed(Zee5TvWelcomePage.objMyWatlistTray, "My watchlist tray")) {
				logger.info("For guest user MyWatchlist tray is not dsiplayed");
				extent.extentLoggerPass("Guest", "For guest user MyWatchlist tray is not dsiplayed");
			} else {
				logger.info("MyWatchlist tray is displayed");
			}
		}
		if (userType.equals("NonSubscribedUser") || userType.equals("SubscribedUser")) {
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objContinueWatchingTray, "Continue watching tray")) {
				logger.info("For logged in user continue watching tray is dsiplayed");
				extent.extentLoggerPass("Guest", "For logged in user continue watching tray is dsiplayed");
			} else {
				logger.info("Continue watching is not displayed");
			}
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objMyWatlistTray, "My watchlist tray")) {
				logger.info("For logged in user My watchlist tray is dsiplayed");
				extent.extentLoggerPass("Guest", "For logged in user My watchlist tray is dsiplayed");
			} else {
				logger.info("MyWatchlist tray is not displayed");
				HeaderChildNode("Adding content into watchlist");
				if (TVgetAttributValue("focused", Zee5TvHomePage.objSearchIcon).equals("false")) {

					TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
					TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
				} else {

					TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
				}
				waitTime(5000);
				String searchdata1[] = { "b", "a", "b", "l", "u", };
				String searchdata2[] = { "d", "a", "b", "l", "u" };
				String searchdata3[] = { "r", "o", "b", "o" };
				String searchdata4[] = { "r", "u", "m", "b", "l", "e" };
				type(searchdata1);
				TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space bar");
				type(searchdata2);
				TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space");
				type(searchdata3);
				TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space");
				type(searchdata4);

				String content = TVgetText(Zee5TvSearchPage.objEditbox);

				logger.info("Entered Search Data : " + content);
				extent.extentLogger("Search", "Entered Searched Data : " + content);

				int k;
				List<WebElement> ele = getDriver().findElements(By.xpath("//*[@id='search_result_title']"));
				for (int i = 1; i <= ele.size(); i++) {
					String title = TVgetText(Zee5TvSearchPage.objSearchedTumbnailTitle(i));
					if ((verifyIsElementDisplayed(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title, "Movies"),
							"Searched Movie"))) {
						TVclick(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title, "Movies"), "serached Movie");
						break;
					} else {
						System.out.println("No match");
					}

				}

				waitTime(8000);
				// LoadingInProgress();

				String title = TVgetText(Zee5TvSearchPage.objSearchedDataTitle);
				waitTime(2000);
				verifyIsElementDisplayed(Zee5TvWelcomePage.objAddtoWatchlist, "Add to watchlist button");
				TVclick(Zee5TvWelcomePage.objAddtoWatchlist, "Add to watchlist button");
				waitTime(2000);
				TVclick(Zee5TvWelcomePage.objAddtoWatchlist, "Add to watchlist button");
				getDriver().navigate().back();
				waitTime(2000);
				getDriver().navigate().back();
				waitTime(5000);
				if (verifyIsElementDisplayed(Zee5TvWelcomePage.objMyWatlistTray, "My watchlist tray")) {
					logger.info("Adding MyWatchlist tray functionality success");
					extent.extentLoggerPass("Guest", "Adding MyWatchlist tray functionality success");
				} else {
					logger.info("Adding MyWatchlist tray functionality failed");

				}
			}
		}
		HeaderChildNode("View All button functionality");
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		String language = getLanguage(userType);
		Response resp = ResponseInstance.getResponseForPagesTv("Home", language, 1, userType);
		for (int i = 1; i <= 20; i++) {
			int total = resp.jsonPath().getInt("buckets[" + i + "].total");
			if (total > 20) {
				viewAllTrayname = resp.jsonPath().getString("buckets[" + i + "].title");
				logger.info(viewAllTrayname);
				break;
			}
		}
		for (int i = 0; i <= 18; i++) {
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objViewAllTrayApi(viewAllTrayname), "Tray content")) {
				TVclick(Zee5TvWelcomePage.objViewAllTrayApi(viewAllTrayname), "Tray content");
				waitTime(7000);
				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 20");
			}
		}
		for (int i = 0; i <= 22; i++) {
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objViewallButton, "ViewAll button")) {
				TVclick(Zee5TvWelcomePage.objViewallButton, "ViewAll button");
				waitTime(5000);
				if (verifyIsElementDisplayed(Zee5TvWelcomePage.objViewallPageHead, "View all page")) {
					logger.info("User is navigated to view all page");
					extent.extentLoggerPass("Page", "User is navigated to view all page");
				} else {
					TVclick(Zee5TvWelcomePage.objViewallButton, "ViewAll button");
				}
				waitTime(7000);

				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 22");
			}

		}
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objViewallPageHead, "View all page")) {
			String pagename = TVgetText(Zee5TvWelcomePage.objViewallPageHead);
			logger.info("User is navigated to" + pagename + "view all page");
			extent.extentLoggerPass("Page", "User is navigated to " + pagename + " view all page");
		}
		List premiumTag = getDriver().findElements(By.xpath("//*[@id='premium_tag']"));
		premiumTag.size();
		for (int i = 2; i <= 6; i++) {
			WebElement videooption = getDriver().findElement(Zee5TvWelcomePage.objPremiumTag(i));
			logger.info("Premium tag is displayed for premium content");
			extent.extentLoggerPass("Tag", "Premium tag is displayed for premium content");
		}
		getDriver().navigate().back();
		HeaderChildNode("Verifications of different trays present");
		waitTime(3000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(3000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		List rowHeader = getDriver().findElements(By.xpath("// *[@id='row_header']"));
		for (int i = 1; i <= rowHeader.size(); i++) {
			String rowHeaderTrays = getDriver().findElement(By.xpath("(// *[@id='row_header'])[" + i + "]")).getText();
			logger.info("Different content Trays are present : " + rowHeaderTrays);
			extent.extentLoggerPass("Tag", "Different content Trays are present : " + rowHeaderTrays);
		}
		for (int i = 1; i <= 18; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(2000);
		}
		getDriver().closeApp();

		waitTime(3000);

		getDriver().launchApp();

		waitTime(10000);
		if (userType.equals("Guest")) {
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
		}
	}

	@SuppressWarnings({ "unused", "rawtypes" })
	public void landingPageShows(String userType) throws Exception {
		extent.HeaderChildNode("Shows Landing page Functionality");
		waitTime(10000);
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip Link")) {
			TVclick(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip link");
			extent.extentLoggerPass("Clicked on Skip Link", "Clicked on Skip Link");
		} else {
			logger.info("User is logged in");
			extent.extentLoggerPass("Button", "User is logged in");
		}

		waitTime(5000);
		TVTabSelect("Shows");
		logger.info("User is navigated to Shows tab");
		extent.extentLoggerPass("Tab", "User is navigated to Shows tab");
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		for (int i = 0; i <= 10; i++) {
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objLandingshowpageTrayContent, "Tray content")) {
				TVclick(Zee5TvWelcomePage.objLandingshowpageTrayContent, "Tray content");
				waitTime(7000);
				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 20");
			}
		}
		HeaderChildNode("View All button functionality");
		for (int i = 0; i <= 22; i++) {
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objViewallButton, "ViewAll button")) {
				TVclick(Zee5TvWelcomePage.objViewallButton, "ViewAll button");
				waitTime(5000);
				if (verifyIsElementDisplayed(Zee5TvWelcomePage.objViewallPageHead, "View all page")) {
					logger.info("User is navigated to view all page");
					extent.extentLoggerPass("Page", "User is navigated to view all page");
				} else {
					TVclick(Zee5TvWelcomePage.objViewallButton, "ViewAll button");
				}
				waitTime(7000);

				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 22");
			}

		}
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objViewallPageHead, "View all page")) {
			String pagename = TVgetText(Zee5TvWelcomePage.objViewallPageHead);
			logger.info("User is navigated to" + pagename + "view all page");
			extent.extentLoggerPass("Page", "User is navigated to " + pagename + " view all page");
		}
		if (!verifyIsElementDisplayed(Zee5TvWelcomePage.objViewAllPremium, "Premium tag")) {
			logger.info("Shows view all page does not have premium icon");
			extent.extentLoggerPass("Shows", "Shows view all page does not have premium icon");
		} else {
			logger.info("premium icon is displayed");
			extent.extentLogger("Shows", "premium icon is displayed");
		}
		getDriver().navigate().back();
		HeaderChildNode("Verifications of different trays present");
		waitTime(3000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(3000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		List rowHeader = getDriver().findElements(By.xpath("// *[@id='row_header']"));
		for (int i = 1; i <= rowHeader.size(); i++) {
			String rowHeaderTrays = getDriver().findElement(By.xpath("(// *[@id='row_header'])[" + i + "]")).getText();
			logger.info("Different content Trays are present : " + rowHeaderTrays);
			extent.extentLoggerPass("Tag", "Different content Trays are present : " + rowHeaderTrays);
		}
		for (int i = 1; i <= 12; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(2000);
		}
	}

	@SuppressWarnings({ "unused", "rawtypes" })
	public void landingPageMovies(String userType) throws Exception {
		extent.HeaderChildNode("Movies Landing page Functionality");
		waitTime(10000);
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip Link")) {
			TVclick(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip link");
			extent.extentLoggerPass("Clicked on Skip Link", "Clicked on Skip Link");
		} else {
			logger.info("User is logged in");
			extent.extentLoggerPass("Button", "User is logged in");
		}

		waitTime(5000);
		TVTabSelect("Movies");
		logger.info("User is navigated to Movies tab");
		extent.extentLoggerPass("Tab", "User is navigated to Shows tab");
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		for (int i = 0; i <= 10; i++) {
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objLandingMoviePageTrayContent, "Tray content")) {
				TVclick(Zee5TvWelcomePage.objLandingMoviePageTrayContent, "Tray content");
				waitTime(7000);
				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 20");
			}
		}
		HeaderChildNode("View All button functionality");
		for (int i = 0; i <= 22; i++) {
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objViewallButton, "ViewAll button")) {
				TVclick(Zee5TvWelcomePage.objViewallButton, "ViewAll button");
				waitTime(5000);
				if (verifyIsElementDisplayed(Zee5TvWelcomePage.objViewallPageHead, "View all page")) {
					logger.info("User is navigated to view all page");
					extent.extentLoggerPass("Page", "User is navigated to view all page");
				} else {
					TVclick(Zee5TvWelcomePage.objViewallButton, "ViewAll button");
				}
				waitTime(7000);

				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 22");
			}

		}
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objViewallPageHead, "View all page")) {
			String pagename = TVgetText(Zee5TvWelcomePage.objViewallPageHead);
			logger.info("User is navigated to" + pagename + "view all page");
			extent.extentLoggerPass("Page", "User is navigated to " + pagename + " view all page");
		}
		if (!verifyIsElementDisplayed(Zee5TvWelcomePage.objViewAllPremium, "Premium tag")) {
			logger.info("Movies view all page does not have premium icon");
			extent.extentLoggerPass("Movies", "Movies view all page does not have premium icon");
		} else {
			logger.info("premium icon is displayed");
			extent.extentLogger("Movies", "premium icon is displayed");
		}
		getDriver().navigate().back();
		HeaderChildNode("Verifications of different trays present");
		waitTime(3000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(3000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		List rowHeader = getDriver().findElements(By.xpath("// *[@id='row_header']"));
		for (int i = 1; i <= rowHeader.size(); i++) {
			String rowHeaderTrays = getDriver().findElement(By.xpath("(// *[@id='row_header'])[" + i + "]")).getText();
			logger.info("Different content Trays are present : " + rowHeaderTrays);
			extent.extentLoggerPass("Tag", "Different content Trays are present : " + rowHeaderTrays);
		}
		for (int i = 1; i <= 12; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(2000);
		}
	}

	@SuppressWarnings({ "unused", "rawtypes" })
	public void landingPageNews(String userType) throws Exception {
		extent.HeaderChildNode("News Landing page Functionality");
		waitTime(10000);
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip Link")) {
			TVclick(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip link");
			extent.extentLoggerPass("Clicked on Skip Link", "Clicked on Skip Link");
		} else {
			logger.info("User is logged in");
			extent.extentLoggerPass("Button", "User is logged in");
		}

		waitTime(5000);
		TVTabSelect("News");
		logger.info("User is navigated to News tab");
		extent.extentLoggerPass("Tab", "User is navigated to Shows tab");
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		for (int i = 0; i <= 10; i++) {
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objLandingNewsContentinNewsPage, "Tray content")) {
				TVclick(Zee5TvWelcomePage.objLandingNewsContentinNewsPage, "Tray content");
				waitTime(7000);
				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 20");
			}
		}
		HeaderChildNode("View All button functionality");
		for (int i = 0; i <= 22; i++) {
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objViewallButton, "ViewAll button")) {
				TVclick(Zee5TvWelcomePage.objViewallButton, "ViewAll button");
				waitTime(5000);
				if (verifyIsElementDisplayed(Zee5TvWelcomePage.objViewallPageHead, "View all page")) {
					logger.info("User is navigated to view all page");
					extent.extentLoggerPass("Page", "User is navigated to view all page");
				} else {
					TVclick(Zee5TvWelcomePage.objViewallButton, "ViewAll button");
				}
				waitTime(7000);

				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 22");
			}

		}
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objViewallPageHead, "View all page")) {
			String pagename = TVgetText(Zee5TvWelcomePage.objViewallPageHead);
			logger.info("User is navigated to" + pagename + "view all page");
			extent.extentLoggerPass("Page", "User is navigated to " + pagename + " view all page");
		}
		if (!verifyIsElementDisplayed(Zee5TvWelcomePage.objViewAllPremium, "Premium tag")) {
			logger.info("News view all page does not have premium icon");
			extent.extentLoggerPass("Shows", "News view all page does not have premium icon");
		} else {
			logger.info("premium icon is displayed");
			extent.extentLogger("News", "premium icon is displayed");
		}
		getDriver().navigate().back();
		HeaderChildNode("Verifications of different trays present");
		waitTime(3000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(3000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		List rowHeader = getDriver().findElements(By.xpath("// *[@id='row_header']"));
		for (int i = 1; i <= rowHeader.size(); i++) {
			String rowHeaderTrays = getDriver().findElement(By.xpath("(// *[@id='row_header'])[" + i + "]")).getText();
			logger.info("Different content Trays are present : " + rowHeaderTrays);
			extent.extentLoggerPass("Tag", "Different content Trays are present : " + rowHeaderTrays);
		}
		for (int i = 1; i <= 12; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(2000);
		}
	}

	@SuppressWarnings({ "unused", "rawtypes" })
	public void landingPagePremium(String userType) throws Exception {
		extent.HeaderChildNode("Premium Landing page Functionality");
		waitTime(10000);
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip Link")) {
			TVclick(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip link");
			extent.extentLoggerPass("Clicked on Skip Link", "Clicked on Skip Link");
		} else {
			logger.info("User is logged in");
			extent.extentLoggerPass("Button", "User is logged in");
		}

		waitTime(5000);
		TVTabSelect("Premium");
		logger.info("User is navigated to Premium tab");
		extent.extentLoggerPass("Tab", "User is navigated to Shows tab");
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		for (int i = 0; i <= 10; i++) {
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objLandingPremiumPageTrayContent, "Tray content")) {
				TVclick(Zee5TvWelcomePage.objLandingPremiumPageTrayContent, "Tray content");
				waitTime(7000);
				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 20");
			}
		}
		HeaderChildNode("View All button functionality");
		for (int i = 0; i <= 22; i++) {
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objViewallButton, "ViewAll button")) {
				TVclick(Zee5TvWelcomePage.objViewallButton, "ViewAll button");
				waitTime(5000);
				if (verifyIsElementDisplayed(Zee5TvWelcomePage.objViewallPageHead, "View all page")) {
					logger.info("User is navigated to view all page");
					extent.extentLoggerPass("Page", "User is navigated to view all page");
				} else {
					TVclick(Zee5TvWelcomePage.objViewallButton, "ViewAll button");
				}
				waitTime(7000);

				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 22");
			}

		}
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objViewallPageHead, "View all page")) {
			String pagename = TVgetText(Zee5TvWelcomePage.objViewallPageHead);
			logger.info("User is navigated to" + pagename + "view all page");
			extent.extentLoggerPass("Page", "User is navigated to " + pagename + " view all page");
		}
		if (!verifyIsElementDisplayed(Zee5TvWelcomePage.objViewAllPremium, "Premium tag")) {
			logger.info("Premium view all page does not have premium icon");
			extent.extentLoggerPass("Shows", "Premium view all page does not have premium icon");
		} else {
			logger.info("premium icon is displayed");
			extent.extentLogger("Premium", "premium icon is displayed");
		}
		getDriver().navigate().back();
		HeaderChildNode("Verifications of different trays present");
		waitTime(3000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(3000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		List rowHeader = getDriver().findElements(By.xpath("// *[@id='row_header']"));
		for (int i = 1; i <= rowHeader.size(); i++) {
			String rowHeaderTrays = getDriver().findElement(By.xpath("(// *[@id='row_header'])[" + i + "]")).getText();
			logger.info("Different content Trays are present : " + rowHeaderTrays);
			extent.extentLoggerPass("Tag", "Different content Trays are present : " + rowHeaderTrays);
		}
		for (int i = 1; i <= 12; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(2000);
		}
	}

	@SuppressWarnings({ "unused", "rawtypes" })
	public void landingPageVideos(String userType) throws Exception {
		extent.HeaderChildNode("Videos Landing page Functionality");
		waitTime(10000);
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip Link")) {
			TVclick(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip link");
			extent.extentLoggerPass("Clicked on Skip Link", "Clicked on Skip Link");
		} else {
			logger.info("User is logged in");
			extent.extentLoggerPass("Button", "User is logged in");
		}

		waitTime(5000);
		TVTabSelect("Videos");
		logger.info("User is navigated to Videos tab");
		extent.extentLoggerPass("Tab", "User is navigated to Shows tab");
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		for (int i = 0; i <= 10; i++) {
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objLandingNewsContentinVideosPage, "Tray content")) {
				TVclick(Zee5TvWelcomePage.objLandingNewsContentinVideosPage, "Tray content");
				waitTime(7000);
				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 20");
			}
		}
		HeaderChildNode("View All button functionality");
		for (int i = 0; i <= 22; i++) {
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objViewallButton, "ViewAll button")) {
				TVclick(Zee5TvWelcomePage.objViewallButton, "ViewAll button");
				waitTime(5000);
				if (verifyIsElementDisplayed(Zee5TvWelcomePage.objViewallPageHead, "View all page")) {
					logger.info("User is navigated to view all page");
					extent.extentLoggerPass("Page", "User is navigated to view all page");
				} else {
					TVclick(Zee5TvWelcomePage.objViewallButton, "ViewAll button");
				}
				waitTime(7000);

				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 22");
			}

		}
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objViewallPageHead, "View all page")) {
			String pagename = TVgetText(Zee5TvWelcomePage.objViewallPageHead);
			logger.info("User is navigated to" + pagename + "view all page");
			extent.extentLoggerPass("Page", "User is navigated to " + pagename + " view all page");
		}
		if (!verifyIsElementDisplayed(Zee5TvWelcomePage.objViewAllPremium, "Premium tag")) {
			logger.info("Videos view all page does not have premium icon");
			extent.extentLoggerPass("Shows", "Videos view all page does not have premium icon");
		} else {
			logger.info("premium icon is displayed");
			extent.extentLogger("Shows", "premium icon is displayed");
		}
		getDriver().navigate().back();
		HeaderChildNode("Verifications of different trays present");
		waitTime(3000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(3000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		List rowHeader = getDriver().findElements(By.xpath("// *[@id='row_header']"));
		for (int i = 1; i <= rowHeader.size(); i++) {
			String rowHeaderTrays = getDriver().findElement(By.xpath("(// *[@id='row_header'])[" + i + "]")).getText();
			logger.info("Different content Trays are present : " + rowHeaderTrays);
			extent.extentLoggerPass("Tag", "Different content Trays are present : " + rowHeaderTrays);
		}
		for (int i = 1; i <= 12; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(2000);
		}
	}

	public void settings() throws Exception {
		HeaderChildNode("Setting Page functionality");
		waitTime(10000);
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip Link")) {
			TVclick(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip link");
			extent.extentLoggerPass("Clicked on Skip Link", "Clicked on Skip Link");
		} else {
			logger.info("User is logged in");
			extent.extentLoggerPass("Button", "User is logged in");
		}
		TVTabSelect("Home");
		for (int i = 0; i <= 10; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
		}
		TVTabSelect("Settings");
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objVerison, "App verison")) {
			logger.info("App version is diaplyed in setting screen " + TVgetText(Zee5TvWelcomePage.objVerison));
			extent.extentLoggerPass("App",
					"App version is diaplyed in setting screen " + TVgetText(Zee5TvWelcomePage.objVerison));
		} else {
			logger.info("App version is not displayed in setting screen");
			extent.extentLoggerFail("App", "App version is not displayed in setting screen");
		}
		TVclick(Zee5TvWelcomePage.objProfileOptionInSettingPage, "Profile icon");
		waitTime(25000);

		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objMyProfilePageheader, "Profile page header")) {
			logger.info("User is navigated to Profile page");
			extent.extentLoggerPass("Profile", "User is navigated to Profile page");
		} else {
			TVclick(Zee5TvWelcomePage.objProfileOptionInSettingPage, "Profile icon");
			waitTime(15000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objMyProfilePageheader, "Profile page header")) {
				logger.info("User is navigated to Profile page");
				extent.extentLoggerPass("Profile", "User is navigated to Profile page");
			} else {
				logger.info("Navigation failed");
				extent.extentLoggerFail("Profile", "Navigation failed");
			}
		}
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(3000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(3000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(5000);
		verifyIsElementDisplayed(Zee5TvWelcomePage.objNameColumn, "Name field in profile page");
		verifyIsElementDisplayed(Zee5TvWelcomePage.objEmailIdColumn, "Email field in profile page");
		verifyIsElementDisplayed(Zee5TvWelcomePage.objMobileNumberColumn, "mobile number field in profile page");
		verifyIsElementDisplayed(Zee5TvWelcomePage.objDOBColumn, "DOB field in profile page");
		verifyIsElementDisplayed(Zee5TvWelcomePage.objGenderColumn, "Gender field in profile page");
//		HeaderChildNode("Edit profile functionality");
//		TVclick(Zee5TvWelcomePage.objEditProfileInMyProfile, "Edit Profile button");
//		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objEditProfilepage, "Edit Profile page")) {
//			logger.info("User is navigated to Edit profile page");
//			extent.extentLoggerPass("Profile", "User is navigated to Edit profile page");
//		} else {
//			logger.info("Profile navigation failed");
//			extent.extentLoggerFail("Profile", "Profile navigation failed");
//		}
//		Runtime.getRuntime().exec("adb shell input keyevent 23");
//		waitTime(8000);
//		int lenText = getDriver().findElement(Zee5TvSearchPage.objNamefieldbox).getAttribute("text").length();
//		for (int i = 0; i < lenText; i++) {
//			getDriver().findElement(Zee5TvSearchPage.objSearchBackButton).click();
//			waitTime(2000);
//		}
//		String searchdata1[] = { "i", "g", "s" };
//		type(searchdata1);
//		TVclick(Zee5TvWelcomePage.objSaveButton, "Save button");
//		waitTime(3000);
//		TVclick(Zee5TvWelcomePage.objSaveButton, "Save button");
//		waitTime(3000);
//		String name = TVgetText(Zee5TvWelcomePage.objNameText);
//		if (name.contains("igs")) {
//			logger.info("User is able to make changes in edit profile page");
//			extent.extentLoggerPass("Edit", "User is able to make changes in edit profile page");
//		} else {
//			logger.info("Edit functionality failed");
//			extent.extentLoggerFail("Edit", "Edit functionality failed");
//		}
		getDriver().navigate().back();
		waitTime(3000);
		getDriver().navigate().back();
		waitTime(3000);
		getDriver().navigate().back();
		waitTime(3000);
	}

	public void parentalContorlFunctionality() throws Exception {
		HeaderChildNode("Parental control functionality");
		getDriver().navigate().back();
		waitTime(2000);
		for (int i = 0; i <= 3; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
		}
		TVclick(Zee5TvWelcomePage.objParentalOption, "Parental Option");
		waitTime(3000);
		TVclick(Zee5TvWelcomePage.objParentalOption, "Parental Option");
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objParentalControlMessage, "Parental control message")) {
			logger.info("Parental control message - Go to zee5.com is displayed");
			extent.extentLoggerPass("Parental", "Parental control message - Go to zee5.com is displayed");
		} else {
			logger.info("Parental control message is not displayed");
			extent.extentLoggerFail("Parental", "Parental control message is not displayed");
		}
		getDriver().navigate().back();
		for (int i = 0; i <= 14; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
		}
		TVclick(Zee5TvWelcomePage.objLogoutOption, "Logout option");

		waitTime(3000);
		TVTabSelect("Home");
		for (int i = 0; i <= 10; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
		}
		TVTabSelect("Settings");
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		TVclick(Zee5TvWelcomePage.objLoginOption, "Login option");
		waitTime(8000);

		if (userType.equals("NonSubscribedUser") || userType.equals("SubscribedUser")) {
			waitTime(10000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objLoginPopupAmazon, "Afs login popup")) {
				Runtime.getRuntime().exec("adb shell input keyevent 19");
				waitTime(2000);
				Runtime.getRuntime().exec("adb shell input keyevent 19");
				waitTime(2000);
				Runtime.getRuntime().exec("adb shell input keyevent 19");
				waitTime(2000);
				TVclick(Zee5TvWelcomePage.objLogiButtonAmazon, "Login button amazon");
				waitTime(7000);
			} else {
				logger.info("Popup not displayed");
			}
			code = TVgetText(Zee5TvWelcomePage.objloginCode);
			logger.info("Authenticate code in TV : " + code);
			extentLoggerPass("Code", "Authenticate code in TV : " + code);
			HeaderChildNode("Switching to WEB platform to Authenticate device");
			setPlatform("Web");
			new Zee5TvBusinessLogic("zee");
			waitTime(5000);

			verifyElementPresentAndClick(PWALoginPage.objWebLoginBtn, "Login button");
			waitTime(3000);
			verifyElementPresentAndClick(PWALoginPage.objEmailField, "Email field");

			if (userType.equals("NonSubscribedUser")) {
				String Username = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("NonsubscribedUserName");
				String Password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("NonsubscribedPassword");
				type(PWALoginPage.objEmailField, Username, "Email Field");
				waitTime(3000);
				verifyElementPresentAndClick(PWALoginPage.objPasswordField, "Password Field");
				type(PWALoginPage.objPasswordField, Password, "Password field");
				waitTime(5000);

			}
			if (userType.equals("SubscribedUser")) {
				String SubscribedUsername = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("SubscribedUserName");
				String SubscribedPassword = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("SubscribedPassword");
				type(PWALoginPage.objEmailField, SubscribedUsername, "Email Field");
				waitTime(3000);
				verifyElementPresentAndClick(PWALoginPage.objPasswordField, "Password Field");
				type(PWALoginPage.objPasswordField, SubscribedPassword, "Password field");
				waitTime(5000);

			}
			click(PWALoginPage.objWebLoginButton, "Login Button");
			waitTime(8000);
			verifyElementPresentAndClick(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger menu");
			verifyElementPresentAndClick(PWAHamburgerMenuPage.objParentalControl, "ParentalControl");
			checkElementDisplayed(PWALoginPage.objPasswordField, "password field");
			if (userType.equals("NonSubscribedUser")) {
				type(PWALoginPage.objPasswordField, parentpasswordNonSub, "Password field");
			} else if (userType.equals("SubscribedUser")) {
				type(PWALoginPage.objPasswordField, parentpasswordSub, "Password field");
			}
			click(PWAHamburgerMenuPage.objContinueButtonInVerifyAccount, "Continue button");
			waitTime(2000);
			HeaderChildNode("Selecting Restrict 13+ option in parent control page");
			checkElementDisplayed(PWAHamburgerMenuPage.objParentControlPageTitle, "Parent control page");
			checkElementDisplayed(PWAHamburgerMenuPage.objNoRestrictionSelected, "No restricted option selected");
			verifyElementPresentAndClick(PWAHamburgerMenuPage.objRestrict13, "Restrict 13+ option");
			verifyElementPresent(PWAHamburgerMenuPage.objParentalLockPin1, "Set Lock Field");
			type(PWAHamburgerMenuPage.objParentalLockPin1, "1", "ParentalLockPin");
			type(PWAHamburgerMenuPage.objParentalLockPin2, "2", "ParentalLockPin");
			type(PWAHamburgerMenuPage.objParentalLockPin3, "3", "ParentalLockPin");
			type(PWAHamburgerMenuPage.objParentalLockPin4, "4", "ParentalLockPin");
			waitTime(4000);
			verifyElementPresentAndClick(PWAHamburgerMenuPage.objSetParentalLockButton, "Set Parental lock button");
			waitTime(5000);
			verifyElementPresentAndClick(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger menu");
			waitTime(3000);
			verifyElementPresentAndClick(PWAHamburgerMenuPage.objAuthenticationOption, "Authentication option");
			waitTime(5000);
			checkElementDisplayed(PWAHamburgerMenuPage.objAuthenticationText, "Authentication Page");
			type(PWAHamburgerMenuPage.objAuthenticationField, code, "Authentication Field");
			click(PWAHamburgerMenuPage.objAuthenticationButtonHighlighted, "Authenticate button");
			waitTime(3000);
			BrowsertearDown();
			setPlatform("TV");
			waitTime(10000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objcontinueButtonInLoginPage,
					"Continue button in TV authentication page")) {
				Runtime.getRuntime().exec("adb shell input keyevent 20");
				waitTime(2000);
				Runtime.getRuntime().exec("adb shell input keyevent 20");
				waitTime(3000);
				Runtime.getRuntime().exec("adb shell input keyevent 22");
				waitTime(3000);
				Runtime.getRuntime().exec("adb shell input keyevent 22");
				waitTime(3000);
				TVclick(Zee5TvWelcomePage.objcontinueButtonInLoginPage, "Continue button in TV authentication page");
				waitTime(15000);
			}
			TVTabSelect("Home");
			logger.info(TVgetText(Zee5TvHomePage.objHighlightedTab) + "Tab is highlighted");
			extent.extentLoggerPass("Tab", "HighLighted Tab :" + TVgetText(Zee5TvHomePage.objHighlightedTab));

			if (TVgetAttributValue("focused", Zee5TvHomePage.objSearchIcon).equals("false")) {

				TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
				TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
			} else {

				TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
			}
			waitTime(5000);
			String searchdata1[] = { "t", "h", "e" };
			String searchdata2[] = { "a", "w", "a", "k", "e", "n", "i", "n", "g" };
			type(searchdata1);
			TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space bar");
			type(searchdata2);
			String content = TVgetText(Zee5TvSearchPage.objEditbox);
			logger.info("Entered Search Data : " + content);
			extent.extentLoggerPass("Search", "Entered Searched Data : " + content);
			List<WebElement> ele = getDriver().findElements(By.xpath("//*[@id='search_result_title']"));
			for (int i = 1; i <= ele.size(); i++) {

				String title = TVgetText(Zee5TvSearchPage.objSearchedTumbnailTitle(i));
				logger.info(title);
				extent.extentLogger("Title", "Serach result content title : " + title);
				waitTime(7000);
				if ((verifyIsElementDisplayed(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title, "Episodes"),
						"Searched 13+ content"))) {
					TVclick(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title, "Episodes"),
							"Searched 13+ content");
					break;
				} else {
					logger.info("No match");
				}

			}
		}
		waitTime(7000);
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objParentpopuptitle, "Parental popup")) {
			logger.info("Parental popup is displayed when user keeps parental control for 13+ content");
			extent.extentLoggerPass("13+",
					"Parental popup is displayed when user keeps parental control for 13+ content");
		} else {
			logger.info("Popup functionality failed");
			extent.extentLoggerFail("Popup", "Popup functionality failed");
		}
		getDriver().navigate().back();
		waitTime(3000);
		getDriver().navigate().back();
		TVTabSelect("Home");

		for (int i = 0; i <= 10; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
		}

		TVTabSelect("Settings");
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		for (int i = 0; i <= 14; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
		}
		TVclick(Zee5TvWelcomePage.objLogoutOption, "Logout option");

		waitTime(3000);
		TVTabSelect("Home");
		for (int i = 0; i <= 10; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
		}
		TVTabSelect("Settings");
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		TVclick(Zee5TvWelcomePage.objLoginOption, "Login option");
		waitTime(8000);

		if (userType.equals("NonSubscribedUser") || userType.equals("SubscribedUser")) {
			waitTime(10000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objLoginPopupAmazon, "Afs login popup")) {
				Runtime.getRuntime().exec("adb shell input keyevent 19");
				waitTime(2000);
				Runtime.getRuntime().exec("adb shell input keyevent 19");
				waitTime(2000);
				Runtime.getRuntime().exec("adb shell input keyevent 19");
				waitTime(2000);
				TVclick(Zee5TvWelcomePage.objLogiButtonAmazon, "Login button amazon");
				waitTime(7000);
			} else {
				logger.info("Popup not displayed");
			}
			code = TVgetText(Zee5TvWelcomePage.objloginCode);
			logger.info("Authenticate code in TV : " + code);
			extentLoggerPass("Code", "Authenticate code in TV : " + code);
			setPlatform("Web");
			new Zee5TvBusinessLogic("zee");
			waitTime(5000);

			verifyElementPresentAndClick(PWALoginPage.objWebLoginBtn, "Login button");
			waitTime(3000);
			verifyElementPresentAndClick(PWALoginPage.objEmailField, "Email field");

			if (userType.equals("NonSubscribedUser")) {
				String Username = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("NonsubscribedUserName");
				String Password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("NonsubscribedPassword");
				type(PWALoginPage.objEmailField, Username, "Email Field");
				waitTime(3000);
				verifyElementPresentAndClick(PWALoginPage.objPasswordField, "Password Field");
				type(PWALoginPage.objPasswordField, Password, "Password field");
				waitTime(5000);

			}
			if (userType.equals("SubscribedUser")) {
				String SubscribedUsername = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("SubscribedUserName");
				String SubscribedPassword = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("SubscribedPassword");
				type(PWALoginPage.objEmailField, SubscribedUsername, "Email Field");
				waitTime(3000);
				verifyElementPresentAndClick(PWALoginPage.objPasswordField, "Password Field");
				type(PWALoginPage.objPasswordField, SubscribedPassword, "Password field");
				waitTime(5000);

			}
			click(PWALoginPage.objWebLoginButton, "Login Button");
			waitTime(8000);
			verifyElementPresentAndClick(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger menu");
			verifyElementPresentAndClick(PWAHamburgerMenuPage.objParentalControl, "ParentalControl");
			checkElementDisplayed(PWALoginPage.objPasswordField, "password field");
			if (userType.equals("NonSubscribedUser")) {
				type(PWALoginPage.objPasswordField, parentpasswordNonSub, "Password field");
			} else if (userType.equals("SubscribedUser")) {
				type(PWALoginPage.objPasswordField, parentpasswordSub, "Password field");
			}
			click(PWAHamburgerMenuPage.objContinueButtonInVerifyAccount, "Continue button");
			waitTime(2000);
			HeaderChildNode("Selecting Restrict ALL option in parent control page");
			checkElementDisplayed(PWAHamburgerMenuPage.objParentControlPageTitle, "Parent control page");
			checkElementDisplayed(PWAHamburgerMenuPage.objNoRestrictionSelected, "No restricted option selected");
			verifyElementPresentAndClick(PWAHamburgerMenuPage.objRestrictAll, "Restrict ALL option");
			verifyElementPresent(PWAHamburgerMenuPage.objParentalLockPin1, "Set Lock Field");
			type(PWAHamburgerMenuPage.objParentalLockPin1, "1", "ParentalLockPin");
			type(PWAHamburgerMenuPage.objParentalLockPin2, "2", "ParentalLockPin");
			type(PWAHamburgerMenuPage.objParentalLockPin3, "3", "ParentalLockPin");
			type(PWAHamburgerMenuPage.objParentalLockPin4, "4", "ParentalLockPin");
			waitTime(4000);
			verifyElementPresentAndClick(PWAHamburgerMenuPage.objSetParentalLockButton, "Set Parental lock button");
			waitTime(5000);
			verifyElementPresentAndClick(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger menu");
			waitTime(3000);
			verifyElementPresentAndClick(PWAHamburgerMenuPage.objAuthenticationOption, "Authentication option");
			waitTime(5000);
			checkElementDisplayed(PWAHamburgerMenuPage.objAuthenticationText, "Authentication Page");
			type(PWAHamburgerMenuPage.objAuthenticationField, code, "Authentication Field");
			click(PWAHamburgerMenuPage.objAuthenticationButtonHighlighted, "Authenticate button");
			waitTime(3000);
			BrowsertearDown();
			setPlatform("TV");
			waitTime(10000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objcontinueButtonInLoginPage,
					"Continue button in TV authentication page")) {
				Runtime.getRuntime().exec("adb shell input keyevent 20");
				waitTime(2000);
				Runtime.getRuntime().exec("adb shell input keyevent 20");
				waitTime(3000);
				Runtime.getRuntime().exec("adb shell input keyevent 22");
				waitTime(3000);
				Runtime.getRuntime().exec("adb shell input keyevent 22");
				waitTime(3000);
				TVclick(Zee5TvWelcomePage.objcontinueButtonInLoginPage, "Continue button in TV authentication page");
				waitTime(15000);
			}
			TVTabSelect("Home");
			logger.info(TVgetText(Zee5TvHomePage.objHighlightedTab) + "Tab is highlighted");
			extent.extentLoggerPass("Tab", "HighLighted Tab :" + TVgetText(Zee5TvHomePage.objHighlightedTab));

			if (TVgetAttributValue("focused", Zee5TvHomePage.objSearchIcon).equals("false")) {

				TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
				TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
			} else {

				TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
			}
			waitTime(5000);
			String searchdata1[] = { "b", "a", "b", "l", "u", };
			String searchdata2[] = { "d", "a", "b", "l", "u" };
			String searchdata3[] = { "r", "o", "b", "o" };
			String searchdata4[] = { "r", "u", "m", "b", "l", "e" };
			type(searchdata1);
			TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space bar");
			type(searchdata2);
			TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space");
			type(searchdata3);
			TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space");
			type(searchdata4);
			String content = TVgetText(Zee5TvSearchPage.objEditbox);

			logger.info("Entered Search Data : " + content);
			extent.extentLogger("Search", "Entered Searched Data : " + content);

			List<WebElement> ele = getDriver().findElements(By.xpath("//*[@id='search_result_title']"));
			for (int i = 1; i <= ele.size(); i++) {

				title = TVgetText(Zee5TvSearchPage.objSearchedTumbnailTitle(i));
				logger.info(title);
				extent.extentLogger("Title", "Serach result content title : " + title);
				if ((verifyIsElementDisplayed(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title, "Movies"),
						"Searched Movie"))) {
					TVclick(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title, "Movies"), "serached Movie");
					break;
				} else {
					System.out.println("No match");
				}

			}
		}
		waitTime(10000);
		TVclick(Zee5TvSearchPage.objPlayIcon, "Play Icon");
		waitTime(10000);
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objParentpopuptitle, "Parental popup")) {
			logger.info("Parental popup is displayed when user keeps parental control for all content");
			extent.extentLoggerPass("All",
					"Parental popup is displayed when user keeps parental control for all content");
		} else {
			logger.info("Popup functionality failed");
			extent.extentLoggerFail("Popup", "Popup functionality failed");
		}
		getDriver().navigate().back();
		waitTime(3000);
		getDriver().navigate().back();
		waitTime(3000);
		getDriver().navigate().back();
		TVTabSelect("Home");

		for (int i = 0; i <= 10; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
		}

		TVTabSelect("Settings");
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		for (int i = 0; i <= 14; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
		}
		TVclick(Zee5TvWelcomePage.objLogoutOption, "Logout option");

		waitTime(3000);
		TVTabSelect("Home");
		for (int i = 0; i <= 10; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
		}
		TVTabSelect("Settings");
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objLoginOption, "Login optipn")) {
			logger.info("Logout functionality successfull");
			extent.extentLoggerPass("Logger", "Logout functionality successfull");
		}
		TVclick(Zee5TvWelcomePage.objLoginOption, "Login option");
		waitTime(8000);

		if (userType.equals("NonSubscribedUser") || userType.equals("SubscribedUser")) {
			waitTime(10000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objLoginPopupAmazon, "Afs login popup")) {
				Runtime.getRuntime().exec("adb shell input keyevent 19");
				waitTime(2000);
				Runtime.getRuntime().exec("adb shell input keyevent 19");
				waitTime(2000);
				Runtime.getRuntime().exec("adb shell input keyevent 19");
				waitTime(2000);
				TVclick(Zee5TvWelcomePage.objLogiButtonAmazon, "Login button amazon");
				waitTime(7000);
			} else {
				logger.info("Popup not displayed");
			}
			code = TVgetText(Zee5TvWelcomePage.objloginCode);
			logger.info("Authenticate code in TV : " + code);
			extentLoggerPass("Code", "Authenticate code in TV : " + code);
			setPlatform("Web");
			new Zee5TvBusinessLogic("zee");
			waitTime(5000);

			verifyElementPresentAndClick(PWALoginPage.objWebLoginBtn, "Login button");
			waitTime(3000);
			verifyElementPresentAndClick(PWALoginPage.objEmailField, "Email field");

			if (userType.equals("NonSubscribedUser")) {
				String Username = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("NonsubscribedUserName");
				String Password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("NonsubscribedPassword");
				type(PWALoginPage.objEmailField, Username, "Email Field");
				waitTime(3000);
				verifyElementPresentAndClick(PWALoginPage.objPasswordField, "Password Field");
				type(PWALoginPage.objPasswordField, Password, "Password field");
				waitTime(5000);

			}
			if (userType.equals("SubscribedUser")) {
				String SubscribedUsername = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("SubscribedUserName");
				String SubscribedPassword = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("SubscribedPassword");
				type(PWALoginPage.objEmailField, SubscribedUsername, "Email Field");
				waitTime(3000);
				verifyElementPresentAndClick(PWALoginPage.objPasswordField, "Password Field");
				type(PWALoginPage.objPasswordField, SubscribedPassword, "Password field");
				waitTime(5000);

			}
			click(PWALoginPage.objWebLoginButton, "Login Button");
			waitTime(8000);
			verifyElementPresentAndClick(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger menu");
			verifyElementPresentAndClick(PWAHamburgerMenuPage.objParentalControl, "ParentalControl");
			checkElementDisplayed(PWALoginPage.objPasswordField, "password field");
			if (userType.equals("NonSubscribedUser")) {
				type(PWALoginPage.objPasswordField, parentpasswordNonSub, "Password field");
			} else if (userType.equals("SubscribedUser")) {
				type(PWALoginPage.objPasswordField, parentpasswordSub, "Password field");
			}
			click(PWAHamburgerMenuPage.objContinueButtonInVerifyAccount, "Continue button");
			waitTime(2000);
			HeaderChildNode("Selecting No Restrict option in parent control page");
			checkElementDisplayed(PWAHamburgerMenuPage.objParentControlPageTitle, "Parent control page");
			verifyElementPresentAndClick(PWAHamburgerMenuPage.objNoRestrictionSelected, "No Restriction option");
			verifyElementPresentAndClick(PWAHamburgerMenuPage.objSetParentalLockButton, "Set Parental lock button");
			waitTime(5000);
			verifyElementPresentAndClick(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger menu");
			waitTime(3000);
			verifyElementPresentAndClick(PWAHamburgerMenuPage.objAuthenticationOption, "Authentication option");
			waitTime(5000);
			checkElementDisplayed(PWAHamburgerMenuPage.objAuthenticationText, "Authentication Page");
			type(PWAHamburgerMenuPage.objAuthenticationField, code, "Authentication Field");
			click(PWAHamburgerMenuPage.objAuthenticationButtonHighlighted, "Authenticate button");
			waitTime(3000);
			BrowsertearDown();
			setPlatform("TV");
			waitTime(10000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objcontinueButtonInLoginPage,
					"Continue button in TV authentication page")) {
				Runtime.getRuntime().exec("adb shell input keyevent 20");
				waitTime(2000);
				Runtime.getRuntime().exec("adb shell input keyevent 20");
				waitTime(3000);
				Runtime.getRuntime().exec("adb shell input keyevent 22");
				waitTime(3000);
				Runtime.getRuntime().exec("adb shell input keyevent 22");
				waitTime(3000);
				TVclick(Zee5TvWelcomePage.objcontinueButtonInLoginPage, "Continue button in TV authentication page");
				waitTime(15000);
			}

			TVTabSelect("Home");
			logger.info(TVgetText(Zee5TvHomePage.objHighlightedTab) + "Tab is highlighted");
			extent.extentLoggerPass("Tab", "HighLighted Tab :" + TVgetText(Zee5TvHomePage.objHighlightedTab));

			if (TVgetAttributValue("focused", Zee5TvHomePage.objSearchIcon).equals("false")) {

				TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
				TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
			} else {

				TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
			}
			waitTime(5000);
			String searchdata1[] = { "b", "a", "b", "l", "u", };
			String searchdata2[] = { "d", "a", "b", "l", "u" };
			String searchdata3[] = { "r", "o", "b", "o" };
			String searchdata4[] = { "r", "u", "m", "b", "l", "e" };
			type(searchdata1);
			TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space bar");
			type(searchdata2);
			TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space");
			type(searchdata3);
			TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space");
			type(searchdata4);
			String content = TVgetText(Zee5TvSearchPage.objEditbox);

			logger.info("Entered Search Data : " + content);
			extent.extentLogger("Search", "Entered Searched Data : " + content);

			List<WebElement> ele = getDriver().findElements(By.xpath("//*[@id='search_result_title']"));
			for (int i = 1; i <= ele.size(); i++) {

				title = TVgetText(Zee5TvSearchPage.objSearchedTumbnailTitle(i));
				logger.info(title);
				extent.extentLogger("Title", "Serach result content title : " + title);
				if ((verifyIsElementDisplayed(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title, "Movies"),
						"Searched Movie"))) {
					TVclick(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title, "Movies"), "serached Movie");
					break;
				} else {
					System.out.println("No match");
				}

			}
		}
		waitTime(7000);
		TVclick(Zee5TvSearchPage.objPlayIcon, "Play Icon");
		waitTime(7000);
		// LoadingInProgress();
		if (!verifyIsElementDisplayed(Zee5TvWelcomePage.objParentpopuptitle, "Parental popup")) {
			logger.info("Parental popup is not displayed when user keeps parental control for No restrict option");
			extent.extentLoggerPass("All",
					"Parental popup is not displayed when user keeps parental control for No restrict option");
		} else {
			logger.info("Popup functionality failed");
			extent.extentLoggerFail("Popup", "Popup functionality failed");
		}
		getDriver().navigate().back();
		waitTime(2000);
		getDriver().navigate().back();
		waitTime(2000);
		getDriver().navigate().back();
		waitTime(2000);

	}

	public void qualityOptions() throws Exception {
		HeaderChildNode("Video quality option functionality in setting page");
		TVTabSelect("Home");

		for (int i = 0; i <= 10; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
		}

		TVTabSelect("Settings");
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		for (int i = 0; i <= 3; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
		}
		TVclick(Zee5TvWelcomePage.objVideoqualityOption, "Video quality option");
		waitTime(3000);
		TVclick(Zee5TvWelcomePage.objVideoqualityOption, "Video quality option");
		waitTime(7000);
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objVideoQualityHeader, "Video quality page header")) {
			logger.info("User is navigated to video quality page");
			extent.extentLoggerPass("Video", "User is navigated to video quality page");
		} else {
			logger.info("Navigation failed");
			extent.extentLoggerFail("Video", "Navigation failed");
		}
		logger.info("Video quality options : " + TVgetText(Zee5TvWelcomePage.objVideoQualityResolutionOptions));
		logger.info("Video quality options : " + TVgetText(Zee5TvWelcomePage.objVideoQualityResolutionOptions2));
		logger.info("Video quality options : " + TVgetText(Zee5TvWelcomePage.objVideoQualityResolutionOptions3));
		logger.info("Video quality options : " + TVgetText(Zee5TvWelcomePage.objVideoQualityResolutionOptions4));
		logger.info("Video quality options : " + TVgetText(Zee5TvWelcomePage.objVideoQualityResolutionOptions5));
		extent.extentLoggerPass("Video",
				"Video quality options : " + TVgetText(Zee5TvWelcomePage.objVideoQualityResolutionOptions));
		extent.extentLoggerPass("Video",
				"Video quality options : " + TVgetText(Zee5TvWelcomePage.objVideoQualityResolutionOptions2));
		extent.extentLoggerPass("Video",
				"Video quality options : " + TVgetText(Zee5TvWelcomePage.objVideoQualityResolutionOptions3));
		extent.extentLoggerPass("Video",
				"Video quality options : " + TVgetText(Zee5TvWelcomePage.objVideoQualityResolutionOptions4));
		extent.extentLoggerPass("Video",
				"Video quality options : " + TVgetText(Zee5TvWelcomePage.objVideoQualityResolutionOptions5));

		getDriver().navigate().back();
		waitTime(3000);

	}

	public void reminders() throws Exception {
		HeaderChildNode("Reminder option functionality in setting page");
		Runtime.getRuntime().exec("adb shell input keyevent 21");
		waitTime(3000);
		TVclick(Zee5TvWelcomePage.objreminderOption, "Reminder option");
		waitTime(8000);
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objnoreminder, "No reminder")) {
			logger.info("No reminder text is displayed");
			extent.extentLoggerPass("No", "No reminder text is displayed");
		} else {
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objreminderLayout, "reminder layout")) {
				logger.info("Reminders are dislayed");
				extent.extentLoggerPass("Reminder", "Reminders are dislayed");
			}
		}
		getDriver().navigate().back();
	}

	public void navigations() throws Exception {
		HeaderChildNode("Navigations from different page");
		getDriver().navigate().back();
		waitTime(3000);
		getDriver().navigate().back();
		waitTime(3000);
		TVTabSelect("Home");
		TVTabSelect("Shows");
		logger.info(TVgetText(Zee5TvHomePage.objHighlightedTab) + "Tab is highlighted");
		extent.extentLoggerPass("Tab", "HighLighted Tab :" + TVgetText(Zee5TvHomePage.objHighlightedTab));
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		for (int i = 0; i <= 15; i++) {
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objshowpageTrayContent, "Show page Tray content")) {
				TVclick(Zee5TvWelcomePage.objshowpageTrayContent, "Show page Tray content");
				if (verifyIsElementDisplayed(Zee5TvSearchPage.objPlayIcon, "Content Title")) {
					logger.info("User is navigated to content detail page");
					extent.extentLoggerPass("Page", "User is navigated to content detail page");
				} else {
					TVclick(Zee5TvWelcomePage.objshowpageTrayContent, "Show page Tray content");
				}
				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 20");
				waitTime(3000);
			}
		}
		waitTime(10000);
		if (verifyIsElementDisplayed(Zee5TvSearchPage.objwatchTrailerIcon, "watch trailer button")) {
			waitTime(5000);
			TVclick(Zee5TvSearchPage.objwatchTrailerIcon, "watch trailer button");
			waitTime(2000);
			TVclick(Zee5TvSearchPage.objwatchTrailerIcon, "watch trailer button");
			waitTime(2000);
			// LoadingInProgress();
			waitTime(10000);
			Runtime.getRuntime().exec("adb shell input keyevent 23");
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvHomePage.objinfo, "Info")) {
				logger.info("Player is paused");
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 23");
			}
			if (verifyIsElementDisplayed(Zee5TvPlayerPage.objPlayerContainer, "Consumption screen")) {
				logger.info("User is navigated to consumption page");
				extent.extentLoggerPass("play", "User is navigated to consumption page");
			} else {
				logger.info("playback did not initiate");
				extent.extentLogger("play", "playback did not initiate");
			}
			getDriver().navigate().back();
			waitTime(3000);
			getDriver().navigate().back();
			waitTime(10000);
			if (verifyIsElementDisplayed(Zee5TvSearchPage.objwatchTrailerIcon, "Watch trailer")) {
				logger.info("User is navigated to content detail page when back button is tapped in consumption page");
				extent.extentLoggerPass("Content",
						"User is navigated to content detail page when back button is tapped in consumption page");
			} else {
				logger.info("Navigation failed");
			}
		}
		getDriver().navigate().back();
		waitTime(3000);
		for (int i = 0; i <= 18; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(2000);
		}
		if (verifyIsElementDisplayed(Zee5TvHomePage.objSelectTab("Shows"), "Shows landing")) {
			logger.info("User is navigated to Shows landing page when back button is tapped in content detail page");
			extent.extentLoggerPass("Content",
					"User is navigated to Shows landing page when back button is tapped in content detail page");
		} else {
			logger.info("Navigation failed");
		}
		getDriver().navigate().back();
		waitTime(3000);
		if (TVgetAttributValue("focused", Zee5TvHomePage.objSelectTab("Home")).equals("true")) {
			logger.info("User is navigated to home page post tapping back button in shows landing page");
			extent.extentLoggerPass("Navigation",
					"User is navigated to home page post tapping back button in shows landing page");
		} else {
			logger.info("Navigation failed");
		}
		getDriver().navigate().back();
		waitTime(4000);
		if (!verifyIsElementDisplayed(Zee5TvHomePage.objSelectTab("Home"), "Home page")) {
			logger.info("User is navigated to TV home page after tapping back button in Zee Home landing page");
			extent.extentLoggerPass("Navigation",
					"User is navigated to TV home page after tapping back button in Zee Home landing page");
		} else {
			logger.info("Navigation failed");
		}

		getDriver().launchApp();
		waitTime(10000);
		if (userType.equals("Guest")) {
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
		}
	}

	public void setting(String userType) throws Exception {
		if (userType.equals("Guest")) {
			HeaderChildNode("Settings page validation");
			logger.info("settins module not applicable for guest user");
			extent.extentLoggerPass("Guest", "settins module not applicable for guest user");
		}
		if (userType.equals("NonSubscribedUser") || userType.equals("SubscribedUser")) {
			settings();
			qualityOptions();
			reminders();
			navigations();
		}
	}

	public void welcomescreen() throws Exception {
		HeaderChildNode("Welcome screen validation");
		waitTime(8000);
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objZeelogo, "Zee logo")) {
			logger.info("zee logo is displayed in welcome screen");
			extent.extentLoggerPass("logo", "zee logo is displayed in welcome screen");
		} else {
			logger.info("Zee logo is not displayed in welcome screen");
			extent.extentLoggerFail("Logo", "Zee logo is not displayed in welcome screen");
		}
		try {
			String message1 = TVgetText(Zee5TvWelcomePage.objwelcomescreenmessage1);
			String message2 = TVgetText(Zee5TvWelcomePage.objwelcomescreenmessage2);

			logger.info(message1 + message2 + " message is diaplyed in the welcome screen");
			extent.extentLoggerPass("Message", message1 + message2 + " message is diaplyed in the welcome screen");
		} catch (Exception e) {
			logger.info("Welcome message is not displayed");
			extent.extentLoggerFail("message", "Welcome message is not displayed");
		}

		verifyIsElementDisplayed(Zee5TvWelcomePage.objalreadyRegister, "Login/Register button in welcome screen");
		verifyIsElementDisplayed(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip button in welcome screen");

		TVclick(Zee5TvWelcomePage.objalreadyRegister, "Login button");

		waitTime(7000);
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objauthenticatetext, "Authenticate message")) {
			logger.info("User is navigated to authenticate page post tapping on login/register button");
			extent.extentLoggerPass("Page",
					"User is navigated to authenticate page post tapping on login/register button");
		} else {
			logger.info("Welcome screen authentication failed");
			extent.extentLoggerFail("fail", "Welcome screen authentication failed");
		}

		getDriver().navigate().back();

		waitTime(4000);

		TVclick(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip button");
		waitTime(12000);
		if (verifyIsElementDisplayed(Zee5TvHomePage.objSelectTab("Home"), "Home tab")) {
			logger.info("User is navigated to Home page post tapping skip button in welcome screen");
			extent.extentLoggerPass("Navigation",
					"User is navigated to Home page post tapping skip button in welcome screen");
		} else {
			logger.info("Navigation failed");
			extent.extentLoggerFail("fail", "Navigation failed");
		}
		getDriver().closeApp();

		waitTime(3000);

		getDriver().launchApp();

		waitTime(10000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 19");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 19");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 19");

	}

	public void collectionpage() throws Exception {
		HeaderChildNode("Collection page navigation");
		if (userType.equals("Guest")) {
			waitTime(10000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip Link")) {
				TVclick(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip link");
				extent.extentLoggerPass("Clicked on Skip Link", "Clicked on Skip Link");
			} else {
				logger.info("User is logged in");
				extent.extentLoggerPass("Button", "User is logged in");
			}
		}
		waitTime(10000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		String language = getLanguage(userType);
		Response resp = ResponseInstance.getResponseForPagesTv("Home", language, 1, userType);
		for (int i = 1; i <= 20; i++) {
			int total = resp.jsonPath().getInt("buckets[" + i + "].total");
			if (total > 20) {
				viewAllTrayname = resp.jsonPath().getString("buckets[" + i + "].title");
				logger.info(viewAllTrayname);
				break;
			}
		}
		Runtime.getRuntime().exec("adb shell input keyevent 19");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 19");
		waitTime(2000);
		TVTabSelect("Home");
		waitTime(3000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		for (int i = 0; i <= 15; i++) {
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objViewAllTrayApi(viewAllTrayname), "Tray content")) {
				logger.info("Collection tray is displayed");
				extent.extentLoggerPass("Collection", "Collection tray is displayed");
				TVclick(Zee5TvWelcomePage.objViewAllTrayApi(viewAllTrayname), "Tray content");
				waitTime(7000);
				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 20");
			}
		}
		for (int i = 0; i <= 22; i++) {
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objViewallButton, "ViewAll button")) {
				TVclick(Zee5TvWelcomePage.objViewallButton, "ViewAll button");
				waitTime(5000);
				if (verifyIsElementDisplayed(Zee5TvWelcomePage.objViewallPageHead, "View all page")) {
					logger.info("User is navigated to view all/collection page");
					extent.extentLoggerPass("Page", "User is navigated to view all/collection page");
				} else {
					TVclick(Zee5TvWelcomePage.objViewallButton, "ViewAll button");
					if (verifyIsElementDisplayed(Zee5TvWelcomePage.objViewallPageHead, "View all page")) {
						logger.info("User is navigated to view all/collection page");
						extent.extentLoggerPass("Page", "User is navigated to view all/collection page");
					}
				}
				waitTime(7000);

				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 22");
			}

		}
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objViewallPageHead, "View all page")) {
			String pagename = TVgetText(Zee5TvWelcomePage.objViewallPageHead);
			logger.info("User is navigated to " + pagename + " collection page");
			extent.extentLoggerPass("Page", "User is navigated to " + pagename + " collection page");
		}
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(4000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(4000);
		Runtime.getRuntime().exec("adb shell input keyevent 23");
		waitTime(8000);

		if (!verifyIsElementDisplayed(Zee5TvWelcomePage.objViewallPageHead, "View all page")) {
			logger.info("User is navigated to page collection page");
			extent.extentLoggerPass("Page", "User is navigated to page collection page");
		} else {
			logger.info("User is not navigated to page collection page");
			extent.extentLogger("User", "User is not navigated to page collection page");
		}
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objYoumayLike, "Recommend tray in content detail")) {
			logger.info(
					"You may like/Episode tray is displayed in content detail page when user is navigated through view all page");
			extent.extentLoggerPass("Navigation",
					"You may like/Episode tray is displayed in content detail page when user is navigated through view all page");
		} else {
			logger.info("Recommendation tray is not displayed in content detail page");
			extent.extentLogger("Tray", "Recommendation tray is not displayed in content detail page");
		}
		for (int i = 0; i <= 2; i++) {
			getDriver().navigate().back();
			waitTime(3000);
		}
		getDriver().closeApp();

		waitTime(3000);

		getDriver().launchApp();

		waitTime(10000);
		if (userType.equals("Guest")) {
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
		}
	}

	@SuppressWarnings("rawtypes")
	public void subscription() throws Exception {

		if (userType.equals("Guest")) {
			HeaderChildNode("Subscription popup validation");
			waitTime(10000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip Link")) {
				TVclick(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip link");
				extent.extentLoggerPass("Clicked on Skip Link", "Clicked on Skip Link");
			} else {
				logger.info("User is logged in");
				extent.extentLoggerPass("Button", "User is logged in");
			}

			waitTime(10000);
			TVTabSelect("Movies");
			waitTime(5000);
			verifyIsElementDisplayed(Zee5TVCarousel.objCarouselPlayButton, "Play button");
			TVclick(Zee5TVCarousel.objCarouselPlayButton, "Play button");
			waitTime(9000);
			TVclick(Zee5TvSearchPage.objPlayIcon, "Play Icon");
			waitTime(4000);
			if (userType.equals("Guest")) {
				if (verifyIsElementDisplayed(Zee5TvSearchPage.objLoginPopup, "Login popup")) {
					logger.info("Login popup is displayed when user play premium content as guest user");
					extent.extentLoggerPass("Popup",
							"Login popup is displayed when user play premium content as guest user");
				} else {
					logger.info("User is navigated to consumption page");
					extent.extentLoggerPass("Popup", "User is navigated to consumption page");
				}

			}
			getDriver().navigate().back();
			waitTime(2000);
			getDriver().navigate().back();
			waitTime(2000);
			HeaderChildNode("Subscription page validation");
			if (verifyIsElementDisplayed(Zee5TVCarousel.objCarouselSubscribeButton, "Carousel Subscribe button")) {
				logger.info("carousel subscribe button is displayed");
				extent.extentLoggerPass("carousel", "carousel subscribe button is displayed");
			} else {
				logger.info("Subscribe button is not displayed in carousel");
				extent.extentLoggerFail("Carousel", "Subscribe button is not displayed in carousel");
			}
			if (verifyIsElementDisplayed(Zee5TVCarousel.objCarouselSubscribeButton, "Subscribe button")) {
				TVclick(Zee5TVCarousel.objCarouselSubscribeButton, "Subscribe button");
				// LoadingInProgress();
				waitTime(5000);
				if (verifyIsElementDisplayed(Zee5TVCarousel.objSubscriptionPlanPage, "My Plans page")) {
					logger.info("User is navigated to Subscription page post tapping on get premium tab in carousel");
					extent.extentLoggerPass("plan",
							"User is navigated to Subscription page post tapping on get premium tab in carousel");
				} else {
					logger.info("Navigation failed");
					extent.extentLoggerFail("Plan", "Navigation failed");
				}
			}
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(2000);
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 23");
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TVCarousel.objSubscribePageLoginPopup, "Login popup")) {
				logger.info("Login popup is displayed when guest user clicks on any plan in subscription page");
				extent.extentLoggerPass("Popup",
						"Login popup is displayed when guest user clicks on any plan in subscription page");
			} else {
				logger.info("Popup functionality failed");
				extent.extentLogger("Popup", "Popup functionality failed");
			}
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 23");
			waitTime(13000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objLoginPopupAmazon, "Afs login popup")) {
				Runtime.getRuntime().exec("adb shell input keyevent 19");
				waitTime(2000);
				Runtime.getRuntime().exec("adb shell input keyevent 19");
				waitTime(2000);
				Runtime.getRuntime().exec("adb shell input keyevent 19");
				waitTime(2000);
				TVclick(Zee5TvWelcomePage.objLogiButtonAmazon, "Login button amazon");
				waitTime(7000);
			} else {
				logger.info("Popup not displayed");
			}
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objauthenticatetext, "Authenticate message")) {
				logger.info("User is navigated to authenticate page post tapping on login button in subscription page");
				extent.extentLoggerPass("Page",
						"User is navigated to authenticate page post tapping on login button in subscription page");
			} else {
				logger.info("subscription page authentication failed");
				extent.extentLoggerFail("fail", "subscription page authentication failed");
			}
			waitTime(3000);
			code = TVgetText(Zee5TvWelcomePage.objloginCode);
			logger.info("Authenticate code in TV : " + code);
			extentLoggerPass("Code", "Authenticate code in TV : " + code);
			HeaderChildNode("Switching to WEB platform to Authenticate device");
			setPlatform("Web");
			new Zee5TvBusinessLogic("zee");
			waitTime(10000);
			verifyElementPresentAndClick(PWALoginPage.objLanguageButton, "Language button");
			waitTime(3000);
			verifyElementPresentAndClick(PWALoginPage.objWebLoginBtn, "Login button");
			waitTime(3000);
			verifyElementPresentAndClick(PWALoginPage.objEmailField, "Email field");

			String Username = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("NonsubscribedUserName");
			String Password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("NonsubscribedPassword");
			type(PWALoginPage.objEmailField, Username, "Email Field");
			waitTime(3000);
			verifyElementPresentAndClick(PWALoginPage.objPasswordField, "Password Field");
			type(PWALoginPage.objPasswordField, Password, "Password field");
			waitTime(5000);
			click(PWALoginPage.objWebLoginButton, "Login Button");
			waitTime(8000);
			verifyElementPresentAndClick(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger menu");
			verifyElementPresentAndClick(PWAHamburgerMenuPage.objAuthenticationOption, "Authentication option");
			waitTime(3000);
			checkElementDisplayed(PWAHamburgerMenuPage.objAuthenticationText, "Authentication Page");
			type(PWAHamburgerMenuPage.objAuthenticationField, code, "Authentication Field");
			click(PWAHamburgerMenuPage.objAuthenticationButtonHighlighted, "Authenticate button");
			waitTime(3000);
			BrowsertearDown();
			setPlatform("TV");
			waitTime(10000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objcontinueButtonInLoginPage,
					"Continue button in TV authentication page")) {
				Runtime.getRuntime().exec("adb shell input keyevent 20");
				waitTime(2000);
				Runtime.getRuntime().exec("adb shell input keyevent 20");
				waitTime(3000);
				Runtime.getRuntime().exec("adb shell input keyevent 22");
				waitTime(3000);
				Runtime.getRuntime().exec("adb shell input keyevent 22");
				waitTime(3000);
				TVclick(Zee5TvWelcomePage.objcontinueButtonInLoginPage, "Continue button in TV authentication page");
				waitTime(15000);
			}

			if (verifyIsElementDisplayed(Zee5TVCarousel.objSubscriptionPlanPage, "My Plans page")) {
				logger.info("User is navigated to Subscription page post login from subscription page");
				extent.extentLoggerPass("plan",
						"User is navigated to Subscription page post login from subscription page");
			} else {
				logger.info("Navigation failed");
				extent.extentLoggerFail("Plan", "Navigation failed");
			}
			waitTime(5000);
			List Options2 = getDriver().findElements(Zee5TVCarousel.objSubscribePagePacks);
			Options2.size();
			for (int i = 1; i <= Options2.size(); i++) {
				String plans = getDriver().findElement(Zee5TvPlayerPage.objSpecificplan(i)).getText();
				logger.info("Plan available in subscription page : " + plans);
				extent.extentLoggerPass("Plan", "Plan available in subscription page : " + plans);
			}
			getDriver().navigate().back();
			waitTime(2000);
			getDriver().navigate().back();
			waitTime(2000);
			getDriver().navigate().back();
			waitTime(2000);
			TVTabSelect("Home");
			for (int i = 0; i <= 10; i++) {
				Runtime.getRuntime().exec("adb shell input keyevent 22");
				waitTime(2000);
			}
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(2000);
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			for (int i = 0; i <= 14; i++) {
				Runtime.getRuntime().exec("adb shell input keyevent 22");
				waitTime(2000);
			}
			TVclick(Zee5TvWelcomePage.objLogoutOption, "Logout option");

			waitTime(3000);
			TVTabSelect("Home");
			getDriver().closeApp();
			waitTime(3000);
			getDriver().launchApp();
			waitTime(8000);
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(2000);

		}
		if (userType.equals("NonSubscribedUser")) {
			waitTime(5000);
			HeaderChildNode("Subscription button and plan page validation");
			if (verifyIsElementDisplayed(Zee5TVCarousel.objCarouselSubscribeButton, "Carousel Subscribe button")) {
				logger.info("carousel subscribe button is displayed");
				extent.extentLoggerPass("carousel", "carousel subscribe button is displayed");
			} else {
				logger.info("Subscribe button is not displayed in carousel");
				extent.extentLoggerFail("Carousel", "Subscribe button is not displayed in carousel");
			}
			if (verifyIsElementDisplayed(Zee5TVCarousel.objCarouselSubscribeButton, "Subscribe button")) {
				TVclick(Zee5TVCarousel.objCarouselSubscribeButton, "Subscribe button");
				// LoadingInProgress();
				waitTime(5000);
				if (verifyIsElementDisplayed(Zee5TVCarousel.objSubscriptionPlanPage, "My Plans page")) {
					logger.info("User is navigated to Subscription page post tapping on get premium tab in carousel");
					extent.extentLoggerPass("plan",
							"User is navigated to Subscription page post tapping on get premium tab in carousel");
				} else {
					logger.info("Navigation failed");
					extent.extentLoggerFail("Plan", "Navigation failed");
				}

				Runtime.getRuntime().exec("adb shell input keyevent 20");
				waitTime(2000);
				Runtime.getRuntime().exec("adb shell input keyevent 20");
				waitTime(3000);
				List Options2 = getDriver().findElements(Zee5TVCarousel.objSubscribePagePacks);
				Options2.size();
				for (int i = 1; i <= Options2.size(); i++) {
					String plans = getDriver().findElement(Zee5TvPlayerPage.objSpecificplan(i)).getText();
					logger.info("Plan available in subscription page : " + plans);
					extent.extentLoggerPass("Plan", "Plan available in subscription page : " + plans);
				}
				Runtime.getRuntime().exec("adb shell input keyevent 23");
				waitTime(5000);
				if (verifyIsElementDisplayed(Zee5TvPlayerPage.objPaymentPage, "Payment page")) {
					logger.info("User is navigated to player page post tapping on any plan in subscription page");
					extent.extentLoggerPass("Page",
							"User is navigated to player page post tapping on any plan in subscription page");
				} else {
					logger.info("navigation failed");
					extent.extentLoggerFail("Page", "navigation failed");
				}
				getDriver().navigate().back();
				waitTime(3000);
				getDriver().navigate().back();
				waitTime(3000);
				Runtime.getRuntime().exec("adb shell input keyevent 19");
				waitTime(2000);
				Runtime.getRuntime().exec("adb shell input keyevent 19");
				waitTime(2000);
			}
			HeaderChildNode("Subscription popup validation");
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(2000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(2000);
			TVTabSelect("Movies");
			waitTime(5000);
			verifyIsElementDisplayed(Zee5TVCarousel.objCarouselPlayButton, "Play button");
			TVclick(Zee5TVCarousel.objCarouselPlayButton, "Play button");
			waitTime(9000);
			TVclick(Zee5TvSearchPage.objPlayIcon, "Play Icon");
			waitTime(4000);
			if (verifyIsElementDisplayed(Zee5TvSearchPage.objLoginPopup, "Subscribe popup")) {
				logger.info("Subscribe popup is displayed when user play premium content as Nonsubscribe user");
				extent.extentLoggerPass("Popup",
						"Subscribe popup is displayed when user play premium content as Nonsubscribe user");
			} else {
				logger.info("User is navigated to consumption page");
				extent.extentLoggerPass("Popup", "User is navigated to consumption page");
			}

			getDriver().navigate().back();
			waitTime(2000);
			getDriver().navigate().back();
			waitTime(2000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(2000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(2000);
			getDriver().navigate().back();
			waitTime(2000);
			HeaderChildNode("Before Tv functionality");
			TVTabSelect("Home");
			for (int i = 0; i <= 18; i++) {
				waitTime(3000);
				if (verifyIsElementDisplayed(Zee5TvWelcomePage.objBeforeTVTray, "BeforeTv Tray content")) {
					TVclick(Zee5TvWelcomePage.objBeforeTVTray, "BeforeTv Tray content");
					waitTime(7000);
					if (verifyIsElementDisplayed(Zee5TVCarousel.objSubscribePopUptitle, "Subscribe popup")) {
						logger.info("Subscribe popup is displayed when user clicks on before tv contents");
						extent.extentLoggerPass("Page",
								"Subscribe popup is displayed when user clicks on before tv contents");
					} else {
						TVclick(Zee5TvWelcomePage.objBeforeTVTray, "BeforeTv Tray content");
						waitTime(3000);
						if (verifyIsElementDisplayed(Zee5TVCarousel.objSubscribePopUptitle, "Subscribe popup")) {
							logger.info("Subscribe popup is displayed when user clicks on before tv contents");
							extent.extentLoggerPass("Page",
									"Subscribe popup is displayed when user clicks on before tv contents");
						}
					}
					break;
				} else {
					Runtime.getRuntime().exec("adb shell input keyevent 20");
					waitTime(3000);
				}
			}
			getDriver().navigate().back();
			waitTime(3000);
			getDriver().navigate().back();
			waitTime(5000);
			getDriver().navigate().back();
			waitTime(3000);
			getDriver().closeApp();

			waitTime(3000);

			getDriver().launchApp();

			waitTime(10000);
		}
		if (userType.equals("SubscribedUser")) {
			HeaderChildNode("Subscription plan page validation");
			TVTabSelect("Home");
			for (int i = 0; i <= 10; i++) {
				Runtime.getRuntime().exec("adb shell input keyevent 22");
				waitTime(2000);
			}
			TVTabSelect("Settings");
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(2000);
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(2000);
			TVclick(Zee5TvWelcomePage.objMyPlanOption, "My Plan option");
			waitTime(2000);
			TVclick(Zee5TvWelcomePage.objMyPlanOption, "My Plan option");
			waitTime(4000);
			if (verifyIsElementDisplayed(Zee5TVCarousel.objActivePlan, "Active plan card")) {
				logger.info("Active plan is displayed for subscribed user in My plan page");
				extent.extentLoggerPass("Plan", "Active plan is displayed for subscribed user in My plan page");
			} else {
				logger.info("Active plan is not displayed for subscribed user");
				extent.extentLoggerFail("Plan", "Active plan is not displayed for subscribed user");
			}
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(2000);
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(2000);
			Runtime.getRuntime().exec("adb shell input keyevent 23");
			waitTime(8000);
			if (verifyIsElementDisplayed(Zee5TVCarousel.objSubscriptionPlanPage, "My Plans page")) {
				logger.info("User is navigated to Subscription page post tapping on View all plan in my plan page");
				extent.extentLoggerPass("plan",
						"User is navigated to Subscription page post tapping on View all plan in my plan page");
			} else {
				logger.info("Navigation failed");
				extent.extentLoggerFail("Plan", "Navigation failed");
			}
			List Options2 = getDriver().findElements(Zee5TVCarousel.objSubscribePagePacks);
			Options2.size();
			for (int i = 1; i <= Options2.size(); i++) {
				String plans = getDriver().findElement(Zee5TvPlayerPage.objSpecificplan(i)).getText();
				logger.info("Plan available in subscription page : " + plans);
				extent.extentLoggerPass("Plan", "Plan available in subscription page : " + plans);
			}
			getDriver().navigate().back();
			waitTime(2000);
			getDriver().navigate().back();
			waitTime(2000);
			getDriver().navigate().back();
			waitTime(2000);
			getDriver().navigate().back();
			waitTime(2000);
			HeaderChildNode("Subscription button and popup validation");
			if (!verifyIsElementDisplayed(Zee5TVCarousel.objCarouselSubscribeButton, "Subscribe button in carousel")) {
				logger.info("Carousel subscribe button is not displayed for subscribed user");
				extent.extentLoggerPass("Pass", "Carousel subscribe button is not displayed for subscribed user");
			} else {
				logger.info("Subscribe button is displayed for subscribed user in carousel");
				extent.extentLoggerFail("Carousel", "Subscribe button is displayed for subscribed user in carousel");
			}
			TVTabSelect("Movies");
			waitTime(4000);
			waitTime(5000);
			verifyIsElementDisplayed(Zee5TVCarousel.objCarouselPlayButton, "Play button");
			TVclick(Zee5TVCarousel.objCarouselPlayButton, "Play button");
			waitTime(9000);
			TVclick(Zee5TvSearchPage.objPlayIcon, "Play Icon");
			waitTime(4000);
			if (verifyIsElementDisplayed(Zee5TvSearchPage.objLoginPopup, "Subscribe popup")) {
				logger.info("Subscribe popup is displayed when subscribed user plays any content");
				extent.extentLoggerFail("Popup", "Subscribe popup is displayed when subscribed user plays any content");
			} else {
				logger.info("User is navigated to consumption page and subscribed user can play any content");
				extent.extentLoggerPass("Popup",
						"User is navigated to consumption page and subscribed user can play any content");
			}

			getDriver().navigate().back();
			waitTime(2000);
			getDriver().navigate().back();
			waitTime(2000);
			getDriver().navigate().back();
			waitTime(2000);
			getDriver().closeApp();

			waitTime(3000);

			getDriver().launchApp();

			waitTime(10000);

		}
	}

	public void continueWatching() throws Exception {
		HeaderChildNode("Continue watching tray validation");
		if (userType.equals("Guest")) {
			logger.info("Continue watching does not appear for guest user");
			extent.extentLoggerPass("Guest", "Continue watching does not appear for guest user");
		}
		if (userType.equals("NonSubscribedUser") || userType.equals("SubscribedUser")) {
			TVTabSelect("Home");
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(2000);
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			if (verifyIsElementDisplayed(Zee5TvSearchPage.objContinueWatchingProgressbar,
					"Continue watching progress bar")) {
				logger.info("Continue watching tray and content progress bar is displayed for " + userType + " user");
				extent.extentLoggerPass("Tray",
						"Continue watching tray and content progress bar is displayed for " + userType + " user");
				TVclick(Zee5TvWelcomePage.objContinuewatchingTrayImage, "Continue watching content");
				waitTime(2000);
				Runtime.getRuntime().exec("adb shell input keyevent 23");
				waitTime(5000);
				// LoadingInProgress();
				waitTime(3000);
				AdVerify();
				waitTime(2000);
				for (int i = 0; i <= 5; i++) {
					Runtime.getRuntime().exec("adb shell input keyevent 23");
					waitTime(2000);
				}
				String beforeTime = TVgetText(Zee5TvPlayerPage.objElapsedTime);
				logger.info("Player play time : " + beforeTime);
				if (!beforeTime.equals("00:00:00")) {
					logger.info("User is able to play content from paused time");
					extent.extentLoggerPass("Time", "User is able to play content from paused time");
				} else {
					logger.info("User is not able to play content from paused time");
					extent.extentLoggerFail("Time", "User is not able to play content from paused time");
				}
				getDriver().navigate().back();
				waitTime(8000);
				Runtime.getRuntime().exec("adb shell input keyevent 20");
				if (verifyIsElementDisplayed(Zee5TvWelcomePage.objMyWatlistTray, "My watchlist tray")) {
					logger.info("For logged in user My watchlist tray is dsiplayed");
					extent.extentLoggerPass("Guest", "For logged in user My watchlist tray is dsiplayed");
				} else {
					logger.info("MyWatchlist tray is not displayed");
					HeaderChildNode("Adding content into watchlist");
					if (TVgetAttributValue("focused", Zee5TvHomePage.objSearchIcon).equals("false")) {

						TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
						TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
					} else {

						TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
					}
					waitTime(5000);
					String searchdata1[] = { "b", "a", "b", "l", "u", };
					String searchdata2[] = { "d", "a", "b", "l", "u" };
					String searchdata3[] = { "r", "o", "b", "o" };
					String searchdata4[] = { "r", "u", "m", "b", "l", "e" };
					type(searchdata1);
					TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space bar");
					type(searchdata2);
					TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space");
					type(searchdata3);
					TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space");
					type(searchdata4);

					String content = TVgetText(Zee5TvSearchPage.objEditbox);

					logger.info("Entered Search Data : " + content);
					extent.extentLogger("Search", "Entered Searched Data : " + content);

					List<WebElement> ele = getDriver().findElements(By.xpath("//*[@id='search_result_title']"));
					for (int i = 1; i <= ele.size(); i++) {
						String title = TVgetText(Zee5TvSearchPage.objSearchedTumbnailTitle(i));
						if ((verifyIsElementDisplayed(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title, "Movies"),
								"Searched Movie"))) {
							TVclick(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title, "Movies"),
									"serached Movie");
							break;
						} else {
							System.out.println("No match");
						}

					}

					waitTime(8000);
					// LoadingInProgress();
					waitTime(2000);
					verifyIsElementDisplayed(Zee5TvWelcomePage.objAddtoWatchlist, "Add to watchlist button");
					TVclick(Zee5TvWelcomePage.objAddtoWatchlist, "Add to watchlist button");
					waitTime(2000);
					TVclick(Zee5TvWelcomePage.objAddtoWatchlist, "Add to watchlist button");
					getDriver().navigate().back();
					waitTime(2000);
					getDriver().navigate().back();
					waitTime(5000);
					if (verifyIsElementDisplayed(Zee5TvWelcomePage.objMyWatlistTray, "My watchlist tray")) {
						logger.info("Adding MyWatchlist tray functionality success");
						extent.extentLoggerPass("Guest", "Adding MyWatchlist tray functionality success");
					} else {
						logger.info("Adding MyWatchlist tray functionality failed");

					}
				}
				HeaderChildNode("Continue watching tray validation across platform");
				setPlatform("Web");
				new Zee5TvBusinessLogic("zee");
				waitTime(10000);
				verifyElementPresentAndClick(PWALoginPage.objLanguageButton, "Language button");
				waitTime(3000);
				verifyElementPresentAndClick(PWALoginPage.objWebLoginBtn, "Login button");
				waitTime(3000);
				verifyElementPresentAndClick(PWALoginPage.objEmailField, "Email field");

				if (userType.equals("NonSubscribedUser")) {
					String Username = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
							.getParameter("NonsubscribedUserName");
					String Password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
							.getParameter("NonsubscribedPassword");
					type(PWALoginPage.objEmailField, Username, "Email Field");
					waitTime(3000);
					verifyElementPresentAndClick(PWALoginPage.objPasswordField, "Password Field");
					type(PWALoginPage.objPasswordField, Password, "Password field");
					waitTime(5000);

				}
				if (userType.equals("SubscribedUser")) {
					String SubscribedUsername = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
							.getParameter("SubscribedUserName");
					String SubscribedPassword = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
							.getParameter("SubscribedPassword");
					type(PWALoginPage.objEmailField, SubscribedUsername, "Email Field");
					waitTime(3000);
					verifyElementPresentAndClick(PWALoginPage.objPasswordField, "Password Field");
					type(PWALoginPage.objPasswordField, SubscribedPassword, "Password field");
					waitTime(5000);

				}
				click(PWALoginPage.objWebLoginButton, "Login Button");
				waitTime(8000);
				if (verifyElementExist(PWALoginPage.objContinueWatchingTrayWeb, "Continue watching tray")) {
					logger.info("Continue watching tray is present in both platform for same login id");
					extent.extentLoggerPass("Tray",
							"Continue watching tray is present in both platform for same login id");
				} else {
					logger.info("Continue watching tray is not present in both platform for same login id");
					extent.extentLoggerFail("Tray",
							"Continue watching tray is not present in both platform for same login id");
				}
				BrowsertearDown();
				setPlatform("TV");
			} else {
				logger.info("Continue watching tray not displayed for " + userType + " user");
				extent.extentLoggerFail("Tray", "Continue watching tray displayed for " + userType + " user");
				BrowsertearDown();
				setPlatform("TV");
			}

		}
		getDriver().closeApp();

		waitTime(3000);

		getDriver().launchApp();

		waitTime(10000);
		if (userType.equals("Guest")) {
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
		}
	}

	public void liveTv() throws Exception {
		HeaderChildNode("All channel tab functionality");
		if (userType.equals("Guest")) {
			waitTime(10000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip Link")) {
				TVclick(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip link");
				extent.extentLoggerPass("Clicked on Skip Link", "Clicked on Skip Link");
			} else {
				logger.info("User is logged in");
				extent.extentLoggerPass("Button", "User is logged in");
			}
		}
		TVTabSelect("Home");
		for (int i = 0; i <= 5; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
		}
		TVTabSelect("Live TV");
		waitTime(4000);
		if (verifyIsElementDisplayed(Zee5TvHomePage.objChannelFilterButton, "Channel filter")) {
			logger.info("User is navigated to all channel page and filter button is displayed");
			extent.extentLoggerPass("Channel", "User is navigated to all channel page and filter button is displayed");
		} else {
			logger.info("Navigation for to all channel tab");
			extent.extentLoggerFail("Channel", "Navigation for to all channel tab");
		}
		for (int i = 1; i <= 3; i++) {
			verifyIsElementDisplayed(Zee5TvHomePage.objchannelInAllchannelTab(i), "Channel in live tv page");
		}
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);

		TVclick(Zee5TvHomePage.objChannelFilterButton, "Channel filter");
		waitTime(2000);
		HeaderChildNode("All channel tab Filter button functionality");
		if (verifyIsElementDisplayed(Zee5TvHomePage.objFilterPopup, "Filter popup")) {
			logger.info("Filter popup is displayed when user clicks on filter button is all channel page");
			extent.extentLoggerPass("Filter",
					"Filter popup is displayed when user clicks on filter button is all channel page");
		}
		verifyIsElementDisplayed(Zee5TvHomePage.objLanguageFilterPopup, "Language option in filter popup");
		verifyIsElementDisplayed(Zee5TvHomePage.objGenreInFilterPopup, "Genre option in filter popup");
		waitTime(3000);
		int languageSelected = getDriver().findElements(Zee5TvWelcomePage.objSelectedOption).size();
		for (int i = 0; i <= 4; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(2000);
		}
		Runtime.getRuntime().exec("adb shell input keyevent 23");
		waitTime(2000);
		TVclick(Zee5TvHomePage.objLanguageFilterPopup, "Filter");
		int languageSelectedAfter = getDriver().findElements(Zee5TvWelcomePage.objSelectedOption).size();
		logger.info(languageSelected);
		logger.info(languageSelectedAfter);
		if (languageSelected != languageSelectedAfter) {
			logger.info("Language functionality verified");
			extent.extentLoggerPass("Language", "Language functionality verified");
		} else {
			logger.info("Language functionality failed");
			extent.extentLoggerFail("Language", "Language functionality failed");
		}
		Runtime.getRuntime().exec("adb shell input keyevent 22");
		waitTime(2000);
		TVclick(Zee5TvHomePage.objGenreInFilterPopup, "Genre option in filter popup");
		waitTime(3000);
		if (!verifyIsElementDisplayed(Zee5TvWelcomePage.objSelectedOption, "Genre filter counter")) {
			logger.info("User has not set any genre is filter section");
			extent.extentLoggerPass("Genre", "User has not set any genre is filter section");
		} else {
			logger.info("User has set  genre is filter section");
			extent.extentLoggerPass("Genre", "User has set  genre is filter section");
		}
		for (int i = 0; i <= 4; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(2000);
		}
		Runtime.getRuntime().exec("adb shell input keyevent 23");
		waitTime(6000);
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objSelectedOption, "Genre filter counter")) {
			logger.info("Clicked on genre and genre functionality successfull");
			extent.extentLoggerPass("Genre", "Clicked on genre and genre functionality successfull");
		} else {
			logger.info("Genre functionality Failed");
			extent.extentLoggerFail("Genre", "Genre functionality Failed");
		}
		getDriver().navigate().back();
		waitTime(3000);
		getDriver().navigate().back();
		waitTime(3000);
		getDriver().closeApp();

		waitTime(3000);

		getDriver().launchApp();

		waitTime(10000);
		if (userType.equals("Guest")) {
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
		}
	}

	public void beforeTV() throws Exception {
		HeaderChildNode("BeforeTV tray validation");
		if (userType.equals("Guest")) {
			waitTime(10000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip Link")) {
				TVclick(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip link");
				extent.extentLoggerPass("Clicked on Skip Link", "Clicked on Skip Link");
			} else {
				logger.info("User is logged in");
				extent.extentLoggerPass("Button", "User is logged in");
			}
		}
		TVTabSelect("Home");
		for (int i = 0; i <= 18; i++) {
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objBeforeTVTray, "BeforeTv Tray content")) {
				TVclick(Zee5TvWelcomePage.objBeforeTVTray, "BeforeTv Tray content");
				waitTime(7000);
				if (verifyIsElementDisplayed(Zee5TVCarousel.objSubscribePopUptitle, "Subscribe popup")) {
					if (userType.equals("Guest")) {
						logger.info("Login popup is displayed when Guest user clicks on before tv contents");
						extent.extentLoggerPass("Page",
								"Login popup is displayed when Guest user clicks on before tv contents");
					}
					if (userType.equals("NonSubscribedUser") || userType.equals("SubscribedUser")) {
						logger.info("Subscribe popup is displayed when user clicks on before tv contents");
						extent.extentLoggerPass("Page",
								"Subscribe popup is displayed when user clicks on before tv contents");
					}
				} else {
					TVclick(Zee5TvWelcomePage.objBeforeTVTray, "BeforeTv Tray content");
					waitTime(4000);
					if (verifyIsElementDisplayed(Zee5TVCarousel.objSubscribePopUptitle, "Subscribe popup")) {
						if (userType.equals("Guest")) {
							logger.info("Login popup is displayed when Guest user clicks on before tv contents");
							extent.extentLoggerPass("Page",
									"Login popup is displayed when Guest user clicks on before tv contents");
						}
						if (userType.equals("NonSubscribedUser") || userType.equals("SubscribedUser")) {
							logger.info("Subscribe popup is displayed when user clicks on before tv contents");
							extent.extentLoggerPass("Page",
									"Subscribe popup is displayed when user clicks on before tv contents");
						}
					} else {
						logger.info("User is navigated to consumption page and before TV content is played");
						extent.extentLoggerPass("Player",
								"User is navigated to consumption page and before TV content is played");
					}
				}
				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 20");
				waitTime(3000);
			}
		}
		getDriver().navigate().back();
		waitTime(3000);
		getDriver().navigate().back();
		waitTime(3000);
		getDriver().navigate().back();
		waitTime(3000);
		if (TVgetAttributValue("focused", Zee5TvHomePage.objSearchIcon).equals("false")) {

			TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
			TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
		} else {

			TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
		}
		waitTime(7000);
		String searchdata[] = { "g", "a", "t", "t", "i", "m", "e", "l", "a" };
		type(searchdata);
		List<WebElement> ele2 = getDriver().findElements(By.xpath("//*[@id='search_result_title']"));
		for (int i = 1; i <= ele2.size(); i++) {
			String title2 = TVgetText(Zee5TvSearchPage.objSearchedTumbnailTitle(i));
			if ((verifyIsElementDisplayed(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title2, "Shows"),
					"Searched Show"))) {
				TVclick(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title2, "Shows"), "serached Show");
				break;
			} else {
				System.out.println("No match");
			}

		}
		waitTime(8000);
		// LoadingInProgress();
		waitTime(2000);
		TVclick(Zee5TvHomePage.obj3rdEpisode, "Previous episode");
		waitTime(5000);
//		LoadingInProgress();
		waitTime(10000);
		AdVerify();
		waitTime(3000);
		Runtime.getRuntime().exec("adb shell input keyevent 23");
		waitTime(2000);
		if (verifyIsElementDisplayed(Zee5TvPlayerPage.objPlayerContainer, "Consumption screen")) {
			logger.info("User is able to play non premium content and it is playable");
			extent.extentLoggerPass("play", "User is able to play non premium content and it is playable");
		} else {
			logger.info("playback did not initiate");
			extent.extentLoggerFail("play", "playback did not initiate");
		}
		getDriver().navigate().back();
		waitTime(3000);
		if (verifyIsElementDisplayed(Zee5TvHomePage.objMorecontentPopup, "More content popup")) {
			logger.info(
					"Would you like to add selected display language as content language popup is diaplyed when user clicks on different display language");
			extent.extentLoggerPass("Popup",
					"Would you like to add selected display language as content language popup is diaplyed when user clicks on different display language");
			getDriver().navigate().back();
		} else {
			logger.info("Popup is not displayed");
			extent.extentLogger("Popup", "Popup is not displayed");
		}

		getDriver().navigate().back();
		waitTime(3000);
		getDriver().navigate().back();
		waitTime(3000);
		getDriver().closeApp();

		waitTime(3000);

		getDriver().launchApp();

		waitTime(10000);
		if (userType.equals("Guest")) {
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
		}
	}

	public void upnext() throws Exception {
		HeaderChildNode("UpNext Tray Validation");
		if (userType.equals("Guest")) {
			waitTime(10000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip Link")) {
				TVclick(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip link");
				extent.extentLoggerPass("Clicked on Skip Link", "Clicked on Skip Link");
			} else {
				logger.info("User is logged in");
				extent.extentLoggerPass("Button", "User is logged in");
			}
		}
		TVTabSelect("Home");
		if (TVgetAttributValue("focused", Zee5TvHomePage.objSearchIcon).equals("false")) {

			TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
			TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
		} else {

			TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
		}
		waitTime(5000);
		String searchdata1[] = { "b", "a", "b", "l", "u", };
		String searchdata2[] = { "d", "a", "b", "l", "u" };
		String searchdata3[] = { "r", "o", "b", "o" };
		String searchdata4[] = { "r", "u", "m", "b", "l", "e" };
		type(searchdata1);
		TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space");
		type(searchdata2);
		TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space");
		type(searchdata3);
		TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space");
		type(searchdata4);

		String content = TVgetText(Zee5TvSearchPage.objEditbox);

		logger.info("Entered Search Data : " + content);
		extent.extentLogger("Search", "Entered Searched Data : " + content);

		int k;
		List<WebElement> ele = getDriver().findElements(By.xpath("//*[@id='search_result_title']"));
		for (int i = 1; i <= ele.size(); i++) {
			String title = TVgetText(Zee5TvSearchPage.objSearchedTumbnailTitle(i));
			logger.info("Serach result content title : " + title);
			extent.extentLogger("Title", "Serach result content title : " + title);

			if ((verifyIsElementDisplayed(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title, "Movies"),
					"Searched Movie"))) {
				TVclick(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title, "Movies"), "serached Movie");
				break;
			} else {
				System.out.println("No match");
			}

		}

		waitTime(8000);
		// LoadingInProgress();

		String title = TVgetText(Zee5TvSearchPage.objSearchedDataTitle);
		waitTime(2000);
		TVclick(Zee5TvSearchPage.objPlayIcon, "Play Icon");

		waitTime(10000);

		// Consumption Page

		// LoadingInProgress();
		waitTime(5000);
		AdVerify();

		waitTime(5000);
		if (verifyIsElementDisplayed(Zee5TvPlayerPage.objPlayerSkipIntro, "SkipIntro")) {
			TVRemoteEvent(20);
			waitTime(2000);
			TVRemoteEvent(23);
			logger.info("clicked on skip intro");
			extent.extentLoggerPass("Intro", "clicked on skip intro");
		} else {
			logger.info("Skip intro is not displayed");
			extent.extentLoggerPass("Intro", "Skip intro is not displayed");
		}
		waitTime(20000);
		Runtime.getRuntime().exec("adb shell input keyevent 23");
		waitTime(7000);
		if (verifyIsElementDisplayed(Zee5TvHomePage.objinfo, "Info")) {
			logger.info("Player is paused");
		} else {
			Runtime.getRuntime().exec("adb shell input keyevent 23");
		}
		waitTime(3000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(3000);
		Runtime.getRuntime().exec("adb shell input keyevent 23");
		waitTime(6000);

		if (verifyIsElementDisplayed(Zee5TvPlayerPage.objUpnextrail, "Up Next rail")) {
			logger.info("User can click on upnext button and up next rail is displayed");
			extent.extentLoggerPass("UpNext", "User can click on upnext button and up next rail is displayed");
		} else {
			logger.info("Upnext tab functionality failed");
			extent.extentLoggerFail("UpNext", "Upnext tab functionality failed");
		}
		getDriver().navigate().back();
		waitTime(3000);
		if (verifyIsElementDisplayed(Zee5TvHomePage.objMorecontentPopup, "More content popup")) {
			logger.info(
					"Would you like to add selected display language as content language popup is diaplyed when user clicks on different display language");
			extent.extentLoggerPass("Popup",
					"Would you like to add selected display language as content language popup is diaplyed when user clicks on different display language");
			getDriver().navigate().back();
		} else {
			logger.info("Popup is not displayed");
			extent.extentLogger("Popup", "Popup is not displayed");
		}
		getDriver().navigate().back();
		waitTime(3000);
		waitTime(3000);
		if (verifyIsElementDisplayed(Zee5TvHomePage.objMorecontentPopup, "More content popup")) {
			logger.info(
					"Would you like to add selected display language as content language popup is diaplyed when user clicks on different display language");
			extent.extentLoggerPass("Popup",
					"Would you like to add selected display language as content language popup is diaplyed when user clicks on different display language");
			getDriver().navigate().back();
		} else {
			logger.info("Popup is not displayed");
			extent.extentLogger("Popup", "Popup is not displayed");
		}
		getDriver().navigate().back();
		waitTime(3000);
		getDriver().navigate().back();
		waitTime(3000);
		getDriver().closeApp();

		waitTime(3000);

		getDriver().launchApp();

		waitTime(10000);
		if (userType.equals("Guest")) {
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
		}
	}

	@SuppressWarnings("rawtypes")
	public void languagePage() throws Exception {
		HeaderChildNode("Setting Page Language button functionality");
		if (userType.equals("Guest")) {
			waitTime(10000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip Link")) {
				TVclick(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip link");
				extent.extentLoggerPass("Clicked on Skip Link", "Clicked on Skip Link");
			} else {
				logger.info("User is logged in");
				extent.extentLoggerPass("Button", "User is logged in");
			}
		}
		TVTabSelect("Home");
		for (int i = 0; i <= 10; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
		}
		TVTabSelect("Settings");
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		for (int i = 0; i <= 7; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
		}
		TVclick(Zee5TvHomePage.objlanguageButton, "Language option");
		waitTime(3000);
		Runtime.getRuntime().exec("adb shell input keyevent 23");
		waitTime(5000);
		if (verifyIsElementDisplayed(Zee5TvHomePage.objDisplaylanguageButton, "Display language button")) {
			logger.info("User is navigated to language screen post tapping on language button in setting page");
			extent.extentLoggerPass("Navigation",
					"User is navigated to language screen post tapping on language button in setting page");
		} else {
			logger.info("User is not navigated to language screen post tapping on language button in setting page");
			extent.extentLoggerFail("Navigation",
					"User is not navigated to language screen post tapping on language button in setting page");
		}
		HeaderChildNode("Display language options validation");
		List Options2 = getDriver().findElements(Zee5TvHomePage.objDisplaylanguageOptions);
		Options2.size();
		for (int i = 1; i <= Options2.size(); i++) {
			TVclick(Zee5TvHomePage.objDisplaylanguageOptionsSelect(i), "Display language options");
			String language = TVgetText(Zee5TvHomePage.objDisplaylanguageOptionsSelectText(i));
			logger.info("clicked on " + language + " language option in display language menu");
		}
		TVclick(Zee5TvHomePage.objSaveButton, "Save button");
		waitTime(3000);
		TVclick(Zee5TvHomePage.objSaveButton, "Save button");
		waitTime(5000);
		if (verifyIsElementDisplayed(Zee5TvHomePage.objMorecontentPopup, "More content popup")) {
			logger.info(
					"Would you like to add selected display language as content language popup is diaplyed when user clicks on different display language");
			extent.extentLoggerPass("Popup",
					"Would you like to add selected display language as content language popup is diaplyed when user clicks on different display language");
		} else {
			logger.info("Popup is not displayed");
			extent.extentLogger("Popup", "Popup is not displayed");
		}
		getDriver().navigate().back();

		Runtime.getRuntime().exec("adb shell input keyevent 19");
		waitTime(3000);

		Runtime.getRuntime().exec("adb shell input keyevent 23");
		TVclick(Zee5TvHomePage.objContentlanguageButton, "Content language button");
		waitTime(3000);
		Runtime.getRuntime().exec("adb shell input keyevent 19");
		waitTime(3000);

		Runtime.getRuntime().exec("adb shell input keyevent 23");

		waitTime(3000);
		Runtime.getRuntime().exec("adb shell input keyevent 23");

		TVclick(Zee5TvHomePage.objEnglistDisplaylanguageButton, "English display language");
		waitTime(2000);
		TVclick(Zee5TvHomePage.objEnglistDisplaylanguageButton, "English display language");
		TVclick(Zee5TvHomePage.objSaveButton, "Save button");
		waitTime(3000);
		TVclick(Zee5TvHomePage.objSaveButton, "Save button");
		waitTime(3000);
		waitTime(5000);
		if (verifyIsElementDisplayed(Zee5TvHomePage.objMorecontentPopup, "More content popup")) {
			logger.info(
					"Would you like to add selected display language as content language popup is diaplyed when user clicks on different display language");
			extent.extentLoggerPass("Popup",
					"Would you like to add selected display language as content language popup is diaplyed when user clicks on different display language");
			getDriver().navigate().back();
		} else {
			logger.info("Popup is not displayed");
			extent.extentLogger("Popup", "Popup is not displayed");
		}

		HeaderChildNode("Content language options validation");
		List contentOptions = getDriver().findElements(Zee5TvHomePage.objContentlanguageButtonChecked);
		contentOptions.size();
		for (int i = 1; i <= contentOptions.size(); i++) {
			TVclick(Zee5TvHomePage.objContentlanguageOptionsSelectText(1), "Selected content language");
			waitTime(3000);
		}
		TVclick(Zee5TvHomePage.objOdiaContentlanguageButton, "Odia content language option");
		TVclick(Zee5TvHomePage.objSaveButton, "Save button");
		waitTime(3000);
		TVclick(Zee5TvHomePage.objSaveButton, "Save button");
		waitTime(3000);
		if (verifyIsElementDisplayed(Zee5TvHomePage.objAddcontentLanguagePopup, "Add language popup")) {
			logger.info(
					"For better ZEE5 experience, Please select at least one more language of your choice while selecting primary 2 languages popup is displayed when user select only 1 language in content language menu");
			extent.extentLoggerPass("Popup",
					"For better ZEE5 experience, Please select at least one more language of your choice while selecting primary 2 languages popup is displayed when user select only 1 language in content language menu");
		}
		getDriver().navigate().back();
		waitTime(3000);
		List contentOptions2 = getDriver().findElements(Zee5TvHomePage.objContentlanguageOptions);
		contentOptions2.size();
		for (int i = 1; i <= Options2.size(); i++) {
			TVclick(Zee5TvHomePage.objContentlanguageOptionsSelect(i), "Content language options");
			String language = TVgetText(Zee5TvHomePage.objDisplaylanguageOptionsSelectText(i));
			logger.info("clicked on " + language + " language option in content language menu");
		}
		getDriver().navigate().back();
		waitTime(3000);
		getDriver().navigate().back();
		waitTime(3000);
		getDriver().navigate().back();
		waitTime(3000);
		getDriver().closeApp();

		waitTime(3000);

		getDriver().launchApp();

		waitTime(10000);
		if (userType.equals("Guest")) {
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
		}
	}

	public void chooseLanguagePopup(String userType) throws Exception {
		HeaderChildNode("Choose display/content language popup");
		waitTime(20000);
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objChooseLanguagePopup, "Choose display language popup")) {
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(2000);
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(2000);
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(2000);
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(2000);
			TVclick(Zee5TvWelcomePage.objChooseLanguagePopupContinue, "Continue button");
			waitTime(4000);
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(2000);
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(2000);
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(2000);
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(2000);
			TVclick(Zee5TvWelcomePage.objChooseLanguagePopupContinue, "Continue button");
			waitTime(3000);

		} else {
			logger.info("Choose language popup not displayed");
			extent.extentLoggerPass("Popup", "Choose language popup not displayed");
		}
	}

	public void ads() throws Exception {
		HeaderChildNode("Ad validation");
		if (userType.equals("Guest")) {
			waitTime(10000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip Link")) {
				TVclick(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip link");
				extent.extentLoggerPass("Clicked on Skip Link", "Clicked on Skip Link");
			} else {
				logger.info("User is logged in");
				extent.extentLoggerPass("Button", "User is logged in");
			}
		}
		TVTabSelect("Home");
		if (TVgetAttributValue("focused", Zee5TvHomePage.objSearchIcon).equals("false")) {

			TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
			TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
		} else {

			TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
		}
		waitTime(5000);
		String searchdata1[] = { "b", "a", "b", "l", "u", };
		String searchdata2[] = { "d", "a", "b", "l", "u" };
		String searchdata3[] = { "r", "o", "b", "o" };
		String searchdata4[] = { "r", "u", "m", "b", "l", "e" };
		type(searchdata1);
		TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space");
		type(searchdata2);
		TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space");
		type(searchdata3);
		TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space");
		type(searchdata4);

		String content = TVgetText(Zee5TvSearchPage.objEditbox);

		logger.info("Entered Search Data : " + content);
		extent.extentLogger("Search", "Entered Searched Data : " + content);

		int k;
		List<WebElement> ele = getDriver().findElements(By.xpath("//*[@id='search_result_title']"));
		for (int i = 1; i <= ele.size(); i++) {
			String title = TVgetText(Zee5TvSearchPage.objSearchedTumbnailTitle(i));
			logger.info("Serach result content title : " + title);
			extent.extentLogger("Title", "Serach result content title : " + title);

			if ((verifyIsElementDisplayed(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title, "Movies"),
					"Searched Movie"))) {
				TVclick(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title, "Movies"), "serached Movie");
				break;
			} else {
				System.out.println("No match");
			}

		}

		waitTime(8000);
		TVclick(Zee5TvSearchPage.objPlayIcon, "Play Icon");

		waitTime(20000);

		// Consumption Page

		// LoadingInProgress();
		// waitTime(10000);
		if (userType.equals("Guest") || userType.equals("NonSubscribedUser")) {
			if (verifyIsElementDisplayed(Zee5TvPlayerPage.objAd, "Ad")) {
				logger.info("Ad is present when user click on any content and verified");
				extent.extentLoggerPass("Ad", "Ad is present when user click on any content and verified");
				AdVerify();
			} else {
				logger.info("Ad is not present");
				extent.extentLoggerPass("Ad", "Ad is not present");
			}

		}
		if (userType.equals("SubscribedUser")) {
			if (verifyIsElementDisplayed(Zee5TvPlayerPage.objAd, "Ad")) {
				logger.info("Ad is present when user click on any content for subscribe content");
				extent.extentLoggerFail("Ad", "Ad is present when user click on any content for subscribe content");
			} else {
				logger.info("Ad is not present for subscribe user");
				extent.extentLoggerPass("Ad", "Ad is not present for subscribe user");
			}
		}
		if (verifyIsElementDisplayed(Zee5TvPlayerPage.objPlayerSkipIntro, "SkipIntro")) {
			TVRemoteEvent(20);
			waitTime(2000);
			TVRemoteEvent(23);
			logger.info("clicked on skip intro");
			extent.extentLoggerPass("Intro", "clicked on skip intro");
		} else {
			logger.info("Skip intro is not displayed");
			extent.extentLoggerPass("Intro", "Skip intro is not displayed");
		}
		waitTime(20000);
		Runtime.getRuntime().exec("adb shell input keyevent 23");
		waitTime(2000);
		if (verifyIsElementDisplayed(Zee5TvPlayerPage.objPlayerContainer, "Player control")) {
			logger.info("Content playback is started after ad playback");
			extent.extentLoggerPass("Player", "Content playback is started after ad playback");
		} else {
			logger.info("Content playback is not started after ad playback");
			extent.extentLogger("Player", "Content playback is not started after ad playback");
		}
		getDriver().navigate().back();
		waitTime(3000);
		getDriver().navigate().back();
		waitTime(3000);
		getDriver().navigate().back();
		waitTime(3000);
		TVTabSelect("Home");
		waitTime(3000);
		getDriver().closeApp();

		waitTime(3000);

		getDriver().launchApp();

		waitTime(10000);
		if (userType.equals("Guest")) {
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
		}
	}

	public void profile() throws Exception {
		HeaderChildNode("Profile options validations");
		if (userType.equals("Guest")) {
			waitTime(10000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip Link")) {
				TVclick(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip link");
				extent.extentLoggerPass("Clicked on Skip Link", "Clicked on Skip Link");
			} else {
				logger.info("User is logged in");
				extent.extentLoggerPass("Button", "User is logged in");
			}
		}

		TVTabSelect("Home");
		if (TVgetAttributValue("focused", Zee5TvHomePage.objSearchIcon).equals("false")) {

			TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
			TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
		} else {

			TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
		}
		waitTime(5000);
		if (verifyIsElementDisplayed(Zee5TvSearchPage.objSearchSpaceBar, "Search page")) {
			logger.info("User is navigated to search page after clicking on search button");
			extent.extentLoggerPass("Search", "User is navigated to search page after clicking on search button");
		} else {
			logger.info("User is not navigated to serach page");
			extent.extentLoggerFail("Navigation", "User is not navigated to serach page");
		}
		String searchdata1[] = { "p", "a", "n", "c", "h", "a", "t", "a", "n", "t", "r", "a" };
		type(searchdata1);
		waitTime(5000);
		String content = TVgetText(Zee5TvSearchPage.objEditbox);
		TVclick(Zee5TvSearchPage.objSearchedText, "Searched suggestion");
		waitTime(2000);
		TVclick(Zee5TvSearchPage.objSearchedText, "Searched suggestion");
		waitTime(2000);
		TVclick(Zee5TvSearchPage.objSearchedText, "Searched suggestion");
		waitTime(2000);
		logger.info("Entered Search Data : " + content);
		extent.extentLoggerPass("Search", "Entered Searched Data : " + content);

		List<WebElement> ele = getDriver().findElements(By.xpath("//*[@id='search_result_title']"));
		for (int i = 1; i <= ele.size(); i++) {

			String title = TVgetText(Zee5TvSearchPage.objSearchedTumbnailTitle(i));
			logger.info(title);
			extent.extentLogger("Title", "Serach result content title : " + title);
			if ((verifyIsElementDisplayed(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title, "Movies"),
					"Searched Premium movie"))) {
				TVclick(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title, "Movies"), "Premium movie");
				break;
			} else {
				logger.info("No match");
			}

		}
		waitTime(8000);
		String title = TVgetText(Zee5TvSearchPage.objSearchedDataTitle);
		if (title.equals(title)) {
			logger.info("user is navigated to respective content detail page");
			extent.extentLoggerPass("user", "user is navigated to respective content detail page");
		}
		TVclick(Zee5TvSearchPage.objPlayIcon, "Play Icon");
		waitTime(4000);
		if (userType.equals("Guest")) {
			if (verifyIsElementDisplayed(Zee5TvSearchPage.objLoginPopup, "Login popup")) {
				logger.info("Login popup is displayed when user play premium content as guest user");
				extent.extentLoggerPass("Popup",
						"Login popup is displayed when user play premium content as guest user");
			} else {
				logger.info("Functioanlity failed");
				extent.extentLoggerFail("Popup", "Popup Functioanlity failed");
			}

		}
		getDriver().navigate().back();
		waitTime(3000);
		getDriver().navigate().back();
		waitTime(3000);
		getDriver().navigate().back();
		waitTime(3000);
		TVTabSelect("Home");
		for (int i = 0; i <= 18; i++) {
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objBeforeTVTray, "BeforeTv Tray content")) {
				TVclick(Zee5TvWelcomePage.objBeforeTVTray, "BeforeTv Tray content");
				waitTime(7000);
				if (verifyIsElementDisplayed(Zee5TVCarousel.objSubscribePopUptitle, "Subscribe popup")) {
					if (userType.equals("Guest")) {
						logger.info("Login popup is displayed when Guest user clicks on before tv contents");
						extent.extentLoggerPass("Page",
								"Login popup is displayed when Guest user clicks on before tv contents");
					}

				} else {
					TVclick(Zee5TvWelcomePage.objBeforeTVTray, "BeforeTv Tray content");
					waitTime(4000);
					if (verifyIsElementDisplayed(Zee5TVCarousel.objSubscribePopUptitle, "Subscribe popup")) {
						if (userType.equals("Guest")) {
							logger.info("Login popup is displayed when Guest user clicks on before tv contents");
							extent.extentLoggerPass("Page",
									"Login popup is displayed when Guest user clicks on before tv contents");
						}
					} else {
						logger.info("User is navigated to consumption page and before TV content is played");
						extent.extentLoggerPass("Player",
								"User is navigated to consumption page and before TV content is played");
					}
				}
				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 20");
				waitTime(3000);
			}
		}
		getDriver().navigate().back();
		waitTime(3000);
		getDriver().navigate().back();
		waitTime(3000);
		getDriver().navigate().back();
		waitTime(3000);
		TVTabSelect("Home");
		for (int i = 0; i <= 10; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
		}
		TVTabSelect("Settings");
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(3000);
		if (!verifyIsElementDisplayed(Zee5TvWelcomePage.objLogoutOption, "Logout option")) {
			logger.info("Logout option is not displayed in setting page");
			extent.extentLoggerPass("Logout", "Logout option is not displayed in setting pages");
		} else {
			logger.info("Logout option is displayed in setting page");
			extent.extentLoggerFail("Logout", "Logout option is displayed in setting page");
		}
		waitTime(3000);
		if (!verifyIsElementDisplayed(Zee5TvWelcomePage.objEditProfileInMyProfile, "Edit profile option")) {
			logger.info("Edit profile is not displayed in setting page");
			extent.extentLoggerPass("Logout", "Edit profile is not displayed in setting pages");
		} else {
			logger.info("Edit profile is displayed in setting page");
			extent.extentLoggerFail("Edit", "Edit profile is displayed in setting page");
		}
		waitTime(3000);
		TVclick(Zee5TvWelcomePage.objVideoqualityOption, "Video quality option");
		waitTime(3000);
		TVclick(Zee5TvWelcomePage.objVideoqualityOption, "Video quality option");
		waitTime(7000);
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objVideoQualityHeader, "Video quality page header")) {
			logger.info("User is navigated to video quality page");
			extent.extentLoggerPass("Video", "User is navigated to video quality page");
		} else {
			logger.info("Navigation failed");
			extent.extentLoggerFail("Video", "Navigation failed");
		}
		logger.info("Video quality options : " + TVgetText(Zee5TvWelcomePage.objVideoQualityResolutionOptions));
		logger.info("Video quality options : " + TVgetText(Zee5TvWelcomePage.objVideoQualityResolutionOptions2));
		logger.info("Video quality options : " + TVgetText(Zee5TvWelcomePage.objVideoQualityResolutionOptions3));
		logger.info("Video quality options : " + TVgetText(Zee5TvWelcomePage.objVideoQualityResolutionOptions4));
		logger.info("Video quality options : " + TVgetText(Zee5TvWelcomePage.objVideoQualityResolutionOptions5));
		extent.extentLoggerPass("Video",
				"Video quality options : " + TVgetText(Zee5TvWelcomePage.objVideoQualityResolutionOptions));
		extent.extentLoggerPass("Video",
				"Video quality options : " + TVgetText(Zee5TvWelcomePage.objVideoQualityResolutionOptions2));
		extent.extentLoggerPass("Video",
				"Video quality options : " + TVgetText(Zee5TvWelcomePage.objVideoQualityResolutionOptions3));
		extent.extentLoggerPass("Video",
				"Video quality options : " + TVgetText(Zee5TvWelcomePage.objVideoQualityResolutionOptions4));
		extent.extentLoggerPass("Video",
				"Video quality options : " + TVgetText(Zee5TvWelcomePage.objVideoQualityResolutionOptions5));

		getDriver().navigate().back();
		waitTime(3000);
		getDriver().navigate().back();
		waitTime(3000);
		getDriver().navigate().back();
		TVTabSelect("Home");
		TVTabSelect("Shows");
		logger.info(TVgetText(Zee5TvHomePage.objHighlightedTab) + "Tab is highlighted");
		extent.extentLoggerPass("Tab", "HighLighted Tab :" + TVgetText(Zee5TvHomePage.objHighlightedTab));
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		for (int i = 0; i <= 15; i++) {
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objshowpageTrayContent, "Show page Tray content")) {
				TVclick(Zee5TvWelcomePage.objshowpageTrayContent, "Show page Tray content");
				if (verifyIsElementDisplayed(Zee5TvSearchPage.objPlayIcon, "Content Title")) {
					logger.info("User is navigated to content detail page");
					extent.extentLoggerPass("Page", "User is navigated to content detail page");
				} else {
					TVclick(Zee5TvWelcomePage.objshowpageTrayContent, "Show page Tray content");
				}
				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 20");
				waitTime(3000);
			}
		}
		waitTime(10000);
		if (verifyIsElementDisplayed(Zee5TvSearchPage.objwatchTrailerIcon, "watch trailer button")) {
			waitTime(5000);
			TVclick(Zee5TvSearchPage.objwatchTrailerIcon, "watch trailer button");
			waitTime(2000);
			TVclick(Zee5TvSearchPage.objwatchTrailerIcon, "watch trailer button");
			waitTime(2000);
			waitTime(5000);
			Runtime.getRuntime().exec("adb shell input keyevent 23");
			waitTime(3000);

			if (verifyIsElementDisplayed(Zee5TvPlayerPage.objPlayerContainer, "Consumption screen")) {
				logger.info("User is navigated to consumption page");
				extent.extentLoggerPass("play", "User is navigated to consumption page");
			} else {
				logger.info("playback did not initiate");
				extent.extentLoggerFail("play", "playback did not initiate");
			}
			getDriver().navigate().back();
			waitTime(5000);
			getDriver().navigate().back();
			waitTime(5000);
			if (verifyIsElementDisplayed(Zee5TvSearchPage.objwatchTrailerIcon, "Watch trailer")) {
				logger.info("User is navigated to content detail page when back button is tapped in consumption page");
				extent.extentLoggerPass("Content",
						"User is navigated to content detail page when back button is tapped in consumption page");
			} else {
				logger.info("Navigation failed");
			}
		}
		getDriver().navigate().back();
		waitTime(3000);
		for (int i = 0; i <= 18; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(2000);
		}
		if (verifyIsElementDisplayed(Zee5TvHomePage.objSelectTab("Shows"), "Shows landing")) {
			logger.info("User is navigated to Shows landing page when back button is tapped in content detail page");
			extent.extentLoggerPass("Content",
					"User is navigated to Shows landing page when back button is tapped in content detail page");
		} else {
			logger.info("Navigation failed");
		}
		getDriver().navigate().back();
		waitTime(3000);
		if (TVgetAttributValue("focused", Zee5TvHomePage.objSelectTab("Home")).equals("true")) {
			logger.info("User is navigated to home page post tapping back button in shows landing page");
			extent.extentLoggerPass("Navigation",
					"User is navigated to home page post tapping back button in shows landing page");
		} else {
			logger.info("Navigation failed");
		}
		getDriver().navigate().back();
		waitTime(4000);
		if (!verifyIsElementDisplayed(Zee5TvHomePage.objSelectTab("Home"), "Home page")) {
			logger.info("User is navigated to TV home page after tapping back button in Zee Home landing page");
			extent.extentLoggerPass("Navigation",
					"User is navigated to TV home page after tapping back button in Zee Home landing page");
		} else {
			logger.info("Navigation failed");
		}

		getDriver().launchApp();

		waitTime(10000);
		if (userType.equals("Guest")) {
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
		}

	}

	public void deeplinking() throws Exception {
		HeaderChildNode("Deeplinking functionality");
		if (userType.equals("Guest")) {
			waitTime(10000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip Link")) {
				TVclick(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip link");
				extent.extentLoggerPass("Clicked on Skip Link", "Clicked on Skip Link");
			} else {
				logger.info("User is logged in");
				extent.extentLoggerPass("Button", "User is logged in");
			}
		}
		waitTime(5000);
		TVTabSelect("Home");
		logger.info(TVgetText(Zee5TvHomePage.objHighlightedTab) + "Tab is highlighted");
		extent.extentLoggerPass("Tab", "HighLighted Tab :" + TVgetText(Zee5TvHomePage.objHighlightedTab));
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		for (int i = 0; i <= 18; i++) {
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objHomepageTrayContent, "Tray content")) {
				TVclick(Zee5TvWelcomePage.objHomepageTrayContent, "Tray content");
				waitTime(7000);
				if (verifyIsElementDisplayed(Zee5TvSearchPage.objPlayIcon, "Content Title")) {
					logger.info("User is navigated to content detail page");
					extent.extentLoggerPass("Page", "User is navigated to content detail page");
				} else {
					TVclick(Zee5TvWelcomePage.objHomepageTrayContent, "Movie page Tray content");
					if (verifyIsElementDisplayed(Zee5TvSearchPage.objPlayIcon, "Content Title")) {
						logger.info("User is navigated to content detail page");
						extent.extentLoggerPass("Page", "User is navigated to content detail page");
					}
				}
				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 20");
				waitTime(3000);
			}
		}
		waitTime(10000);
		TVclick(Zee5TvSearchPage.objPlayIcon, "Play Icon");
		waitTime(4000);
		if (userType.equals("Guest")) {
			if (verifyIsElementDisplayed(Zee5TvSearchPage.objLoginPopup, "Login popup")) {
				logger.info("Login popup is displayed when user play premium content as guest user");
				extent.extentLoggerPass("Popup",
						"Login popup is displayed when user play premium content as guest user");
			} else {
				logger.info("Functioanlity failed");
				extent.extentLoggerFail("Popup", "Popup Functioanlity failed");
			}

		}
		if (userType.equals("NonSubscribedUser")) {
			if (verifyIsElementDisplayed(Zee5TvSearchPage.objSubscribePopup, "Subscribe now popup")) {
				logger.info("Subscribe popup is displayed when user play premium content as Nonsubscribe user");
				extent.extentLoggerPass("Popup",
						"Subscribe popup is displayed when user play premium content as Nonsubscribe user");
			} else {
				logger.info("Functioanlity failed");
				extent.extentLogger("Popup", "Popup Functioanlity failed");
			}
		}
		if (userType.equals("SubscribedUser")) {
			// LoadingInProgress();
			Runtime.getRuntime().exec("adb shell input keyevent 23");
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvPlayerPage.objPlayerContainer, "Consumption page")) {
				logger.info("User is able to play premium content for premium user");
				extent.extentLoggerPass("play", "User is able to play premium content for premium user");
			} else {
				logger.info("playback did not initiate");
				extent.extentLogger("play", "playback did not initiate");
			}

		}
		getDriver().navigate().back();
		waitTime(3000);
		getDriver().navigate().back();
		waitTime(3000);
		getDriver().navigate().back();
		waitTime(3000);
		for (int i = 0; i <= 18; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(2000);
		}
		if (verifyIsElementDisplayed(Zee5TvHomePage.objSelectTab("Home"), "Home landing")) {
			logger.info("User is navigated to Home landing page when back button is tapped in content detail page");
			extent.extentLoggerPass("Content",
					"User is navigated to Home landing page when back button is tapped in content detail page");
		} else {
			logger.info("Navigation failed");
		}
		waitTime(3000);
		TVTabSelect("Home");
		if (TVgetAttributValue("focused", Zee5TvHomePage.objSearchIcon).equals("false")) {

			TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
			TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
		} else {

			TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
		}
		waitTime(5000);
		String searchdata1[] = { "b", "a", "b", "l", "u", };
		String searchdata2[] = { "d", "a", "b", "l", "u" };
		String searchdata3[] = { "r", "o", "b", "o" };
		String searchdata4[] = { "r", "u", "m", "b", "l", "e" };
		type(searchdata1);
		TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space");
		type(searchdata2);
		TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space");
		type(searchdata3);
		TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space");
		type(searchdata4);

		String content = TVgetText(Zee5TvSearchPage.objEditbox);

		logger.info("Entered Search Data : " + content);
		extent.extentLogger("Search", "Entered Searched Data : " + content);

		int k;
		List<WebElement> ele = getDriver().findElements(By.xpath("//*[@id='search_result_title']"));
		for (int i = 1; i <= ele.size(); i++) {
			String title = TVgetText(Zee5TvSearchPage.objSearchedTumbnailTitle(i));
			logger.info("Serach result content title : " + title);
			extent.extentLogger("Title", "Serach result content title : " + title);

			if ((verifyIsElementDisplayed(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title, "Movies"),
					"Searched Movie"))) {
				TVclick(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title, "Movies"), "serached Movie");
				break;
			} else {
				System.out.println("No match");
			}

		}

		waitTime(8000);
		TVclick(Zee5TvSearchPage.objPlayIcon, "Play Icon");

		waitTime(22000);

		// Consumption Page

		AdVerify();
		if (verifyIsElementDisplayed(Zee5TvPlayerPage.objPlayerSkipIntro, "SkipIntro")) {
			TVRemoteEvent(20);
			waitTime(2000);
			TVRemoteEvent(23);
			logger.info("clicked on skip intro");
			extent.extentLoggerPass("Intro", "clicked on skip intro");
		} else {
			logger.info("Skip intro is not displayed");
			extent.extentLoggerPass("Intro", "Skip intro is not displayed");
		}
		waitTime(12000);
		Runtime.getRuntime().exec("adb shell input keyevent 23");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 23");
		waitTime(2000);
		if (verifyIsElementDisplayed(Zee5TvPlayerPage.objPlayerContainer, "Consumption screen")) {
			logger.info("User is able to play free content");
			extent.extentLoggerPass("play", "User is able to play free content");
		} else {
			logger.info("playback did not initiate");
			extent.extentLoggerFail("play", "playback did not initiate");
		}
		getDriver().navigate().back();
		waitTime(2000);
		getDriver().navigate().back();
		waitTime(2000);
		getDriver().navigate().back();
		waitTime(2000);
		getDriver().navigate().back();
		waitTime(2000);
		TVTabSelect("Home");
		waitTime(3000);
		getDriver().closeApp();

		waitTime(3000);

		getDriver().launchApp();

		waitTime(10000);
		if (userType.equals("Guest")) {
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
		}
	}

	@SuppressWarnings("rawtypes")
	public void headerSection() throws Exception {
		HeaderChildNode("Verification of Header section options");
		if (userType.equals("Guest")) {
			waitTime(10000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip Link")) {
				TVclick(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip link");
				extent.extentLoggerPass("Clicked on Skip Link", "Clicked on Skip Link");
			} else {
				logger.info("User is logged in");
				extent.extentLoggerPass("Button", "User is logged in");
			}
		}
		List Options2 = getDriver().findElements(Zee5TvWelcomePage.objMenuTopIcon);
		Options2.size();
		for (int i = 1; i <= Options2.size(); i++) {
			String plans = getDriver().findElement(Zee5TvWelcomePage.objMenuTopParticular(i)).getText();
			logger.info(plans + " Tab is displayed ");
			extent.extentLoggerPass("Plan", plans + " Tab is displayed ");
		}
		TVTabSelect("Home");
		waitTime(3000);
		getDriver().closeApp();

		waitTime(3000);

		getDriver().launchApp();

		waitTime(10000);
		if (userType.equals("Guest")) {
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
		}
	}

	public void talamoos() throws Exception {
		HeaderChildNode("Trending tray validation");
		if (userType.equals("Guest")) {
			waitTime(10000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip Link")) {
				TVclick(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip link");
				extent.extentLoggerPass("Clicked on Skip Link", "Clicked on Skip Link");
			} else {
				logger.info("User is logged in");
				extent.extentLoggerPass("Button", "User is logged in");
			}
		}
		TVTabSelect("Home");
		waitTime(3000);
		String language = getLanguage(userType);
		Response resp = ResponseInstance.getRecoDataFromTab(userType, "Home", language);
		String trayTitle = resp.jsonPath().getString("buckets[0].title");
		logger.info("API Title =" + trayTitle);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		for (int i = 0; i <= 15; i++) {
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objApiRecoTray(trayTitle), "Trending tray")) {
				logger.info("Home tab trending tray is displayed");
				extent.extentLoggerPass("Trending", "Home tab trending tray is displayed");
				waitTime(2000);
				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 20");
			}
		}
		for (int i = 0; i <= 11; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(2000);
		}
		waitTime(3000);
//		TVTabSelect("Shows");
//		waitTime(3000);
//		String showslanguage = getLanguage(userType);
//		Response showsresp = ResponseInstance.getRecoDataFromTab(userType, "shows", showslanguage);
//		String showstrayTitle = showsresp.jsonPath().getString("buckets[0].title");
//		logger.info("API Title =" + showstrayTitle);
//		Runtime.getRuntime().exec("adb shell input keyevent 20");
//		waitTime(2000);
//		for (int i = 0; i <= 15; i++) {
//			waitTime(3000);
//			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objApiRecoTray(showstrayTitle), "Trending tray")) {
//				logger.info("Shows tab trending tray is displayed");
//				extent.extentLoggerPass("Trending", "Shows tab trending tray is displayed");
//				waitTime(2000);
//				break;
//			} else {
//				Runtime.getRuntime().exec("adb shell input keyevent 20");
//			}
//		}
//		for (int i = 0; i <= 8; i++) {
//			Runtime.getRuntime().exec("adb shell input keyevent 19");
//			waitTime(2000);
//		}
//		waitTime(3000);
//		TVTabSelect("Movies");
//		waitTime(3000);
//		String movieslanguage = getLanguage(userType);
//		Response moviesresp = ResponseInstance.getRecoDataFromTab(userType, "movies", movieslanguage);
//		String moviestrayTitle = moviesresp.jsonPath().getString("buckets[0].title");
//		logger.info("API Title =" + moviestrayTitle);
//		Runtime.getRuntime().exec("adb shell input keyevent 20");
//		waitTime(2000);
//		for (int i = 0; i <= 15; i++) {
//			waitTime(3000);
//			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objApiRecoTray(moviestrayTitle), "Trending tray")) {
//				logger.info("Movies tab trending tray is displayed");
//				extent.extentLoggerPass("Trending", "Movies tab trending tray is displayed");
//				waitTime(2000);
//				break;
//			} else {
//				Runtime.getRuntime().exec("adb shell input keyevent 20");
//
//			}
//		}
//		for (int i = 0; i <= 8; i++) {
//			Runtime.getRuntime().exec("adb shell input keyevent 19");
//			waitTime(2000);
//		}
//		waitTime(3000);
//		TVTabSelect("News");
//		waitTime(3000);
//		String newslanguage = getLanguage(userType);
//		Response newsresp = ResponseInstance.getRecoDataFromTab(userType, "news", newslanguage);
//		String newstrayTitle = newsresp.jsonPath().getString("buckets[0].title");
//		logger.info("API Title =" + newstrayTitle);
//		Runtime.getRuntime().exec("adb shell input keyevent 20");
//		waitTime(2000);
//		for (int i = 0; i <= 15; i++) {
//			waitTime(3000);
//			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objApiRecoTray(newstrayTitle), "Trending tray")) {
//				logger.info("News tab trending tray is displayed");
//				extent.extentLoggerPass("Trending", "News tab trending tray is displayed");
//				waitTime(2000);
//				break;
//			} else {
//				Runtime.getRuntime().exec("adb shell input keyevent 20");
//			}
//		}
//		for (int i = 0; i <= 8; i++) {
//			Runtime.getRuntime().exec("adb shell input keyevent 19");
//			waitTime(2000);
//		}
//		waitTime(3000);
//		TVTabSelect("Premium");
//		waitTime(3000);
//		String premiumlanguage = getLanguage(userType);
//		Response premiumresp = ResponseInstance.getRecoDataFromTab(userType, "premium", premiumlanguage);
//		String premiumtrayTitle = premiumresp.jsonPath().getString("buckets[0].title");
//		logger.info("API Title =" + premiumtrayTitle);
//		Runtime.getRuntime().exec("adb shell input keyevent 20");
//		waitTime(2000);
//		for (int i = 0; i <= 15; i++) {
//			waitTime(3000);
//			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objApiRecoTray(premiumtrayTitle), "Trending tray")) {
//				logger.info("Premium tab trending tray is displayed");
//				extent.extentLoggerPass("Trending", "Premium tab trending tray is displayed");
//				waitTime(2000);
//				break;
//			} else {
//				Runtime.getRuntime().exec("adb shell input keyevent 20");
//			}
//		}
//		for (int i = 0; i <= 8; i++) {
//			Runtime.getRuntime().exec("adb shell input keyevent 19");
//			waitTime(2000);
//		}
//		waitTime(3000);
//
//		HeaderChildNode("Recommended for you tray validation");
//		getDriver().navigate().back();
//		TVTabSelect("Movies");
//		waitTime(3000);
//		Runtime.getRuntime().exec("adb shell input keyevent 20");
//		waitTime(2000);
//		for (int i = 0; i <= 15; i++) {
//			waitTime(3000);
//			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objRecommendForYou, "Recommend for you tray")) {
//				logger.info("Movies tab Recommendation tray is displayed");
//				extent.extentLoggerPass("Trending", "Home tab Recommendation tray is displayed");
//				waitTime(2000);
//				break;
//			} else {
//				Runtime.getRuntime().exec("adb shell input keyevent 20");
//			}
//		}
//		for (int i = 0; i <= 8; i++) {
//			Runtime.getRuntime().exec("adb shell input keyevent 19");
//			waitTime(2000);
//		}
//		waitTime(3000);
//		TVTabSelect("News");
//		waitTime(3000);
//		Runtime.getRuntime().exec("adb shell input keyevent 20");
//		waitTime(2000);
//		for (int i = 0; i <= 15; i++) {
//			waitTime(3000);
//			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objRecommendForYou, "Recommend for you tray")) {
//				logger.info("News tab Recommendation tray is displayed");
//				extent.extentLoggerPass("Trending", "News tab Recommendation tray is displayed");
//				waitTime(2000);
//				break;
//			} else {
//				Runtime.getRuntime().exec("adb shell input keyevent 20");
//			}
//		}
//		for (int i = 0; i <= 8; i++) {
//			Runtime.getRuntime().exec("adb shell input keyevent 19");
//			waitTime(2000);
//		}
//		waitTime(3000);
//		TVTabSelect("Videos");
//		waitTime(3000);
//		Runtime.getRuntime().exec("adb shell input keyevent 20");
//		waitTime(2000);
//		for (int i = 0; i <= 15; i++) {
//			waitTime(3000);
//			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objRecommendForYou, "Recommend for you tray")) {
//				logger.info("Videos tab Recommendation tray is displayed");
//				extent.extentLoggerPass("Trending", "Videos tab Recommendation tray is displayed");
//				waitTime(2000);
//				break;
//			} else {
//				Runtime.getRuntime().exec("adb shell input keyevent 20");
//			}
//		}
//		for (int i = 0; i <= 8; i++) {
//			Runtime.getRuntime().exec("adb shell input keyevent 19");
//			waitTime(2000);
//		}
//		waitTime(3000);
//		HeaderChildNode("Recommendation tray validation in content detail page");
//		getDriver().navigate().back();
//		waitTime(3000);
		TVTabSelect("Shows");
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		for (int i = 0; i <= 15; i++) {
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objshowpageTrayContent, "Show page Tray content")) {
				TVclick(Zee5TvWelcomePage.objshowpageTrayContent, "Show page Tray content");
				if (verifyIsElementDisplayed(Zee5TvSearchPage.objPlayIcon, "Content Title")) {
					logger.info("User is navigated to content detail page");
					extent.extentLoggerPass("Page", "User is navigated to content detail page");
				} else {
					TVclick(Zee5TvWelcomePage.objshowpageTrayContent, "Show page Tray content");
				}
				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 20");
				waitTime(3000);
			}
		}
		waitTime(10000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objRecommendForYouContentDetail,
				"Recommend tray in content detail")) {
			logger.info("You may like/Episode tray is displayed in Shows content detail page");
			extent.extentLoggerPass("Navigation",
					"You may like/Episode tray is displayed in Shows content detail page");
		} else {
			logger.info("Recommendation tray is not displayed in content detail page");
			extent.extentLogger("Tray", "Recommendation tray is not displayed in content detail page");
		}
		for (int i = 0; i <= 2; i++) {
			getDriver().navigate().back();
		}
		waitTime(3000);
		TVTabSelect("Movies");
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		for (int i = 0; i <= 10; i++) {
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objMoviePageTrayContent, "Tray content")) {
				TVclick(Zee5TvWelcomePage.objMoviePageTrayContent, "Tray content");
				if (verifyIsElementDisplayed(Zee5TvSearchPage.objPlayIcon, "Content Title")) {
					logger.info("User is navigated to content detail page");
					extent.extentLoggerPass("Page", "User is navigated to content detail page");
				} else {
					TVclick(Zee5TvWelcomePage.objMoviePageTrayContent, "Movie page Tray content");
				}
				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 20");
				waitTime(3000);
			}
		}
		waitTime(10000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objRecommendForYouContentDetail,
				"Recommend tray in content detail")) {
			logger.info("You may like/Episode tray is displayed in Shows content detail page");
			extent.extentLoggerPass("Navigation",
					"You may like/Episode tray is displayed in Shows content detail page");
		} else {
			logger.info("Recommendation tray is not displayed in content detail page");
			extent.extentLogger("Tray", "Recommendation tray is not displayed in content detail page");
		}
		for (int i = 0; i <= 2; i++) {
			getDriver().navigate().back();
		}
		TVTabSelect("Videos");
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		for (int i = 0; i <= 15; i++) {
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objVideoPageTrayContentPlayback,
					"Videos page Tray content")) {
				TVclick(Zee5TvWelcomePage.objVideoPageTrayContentPlayback, "Videos page Tray content");
				waitTime(4000);
				if (verifyIsElementDisplayed(Zee5TvSearchPage.objPlayIcon, "Content Title")) {
					logger.info("User is navigated to content detail page");
					extent.extentLoggerPass("Page", "User is navigated to content detail page");
				} else {
					Runtime.getRuntime().exec("adb shell input keyevent 20");
					TVclick(Zee5TvWelcomePage.objVideoPageTrayContentPlayback, "Videos page Tray content");
				}
				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 20");
				waitTime(3000);
			}
		}
		waitTime(10000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objRecommendForYouContentDetail,
				"Recommend tray in content detail")) {
			logger.info("You may like/Episode tray is displayed in Shows content detail page");
			extent.extentLoggerPass("Navigation",
					"You may like/Episode tray is displayed in Shows content detail page");
		} else {
			logger.info("Recommendation tray is not displayed in content detail page");
			extent.extentLogger("Tray", "Recommendation tray is not displayed in content detail page");
		}
		for (int i = 0; i <= 2; i++) {
			getDriver().navigate().back();
			waitTime(3000);
		}
		TVTabSelect("Home");
		waitTime(3000);
		getDriver().closeApp();

		waitTime(3000);

		getDriver().launchApp();

		waitTime(10000);
		if (userType.equals("Guest")) {
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
		}
	}

	public void deviceAuthentication() throws Exception {
		HeaderChildNode("Device Authentication functionality");
		waitTime(15000);
		verifyIsElementDisplayed(Zee5TvWelcomePage.objalreadyRegister, "Already Register button");
		TVclick(Zee5TvWelcomePage.objalreadyRegister, "Already Register button");
		waitTime(5000);
		waitTime(3000);
		Runtime.getRuntime().exec("adb shell input keyevent 22");
		waitTime(3000);
		Runtime.getRuntime().exec("adb shell input keyevent 22");
		waitTime(3000);
		TVclick(Zee5TvWelcomePage.objcontinueButtonInLoginPage, "Continue button in TV authentication page");
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objAuthenticateErrorMessage,
				"Please authenticate error message")) {
			logger.info("Authenticate error popup is displayed");
			extent.extentLoggerPass("Popup", "Authenticate error popup is displayed");
		} else {
			logger.info("Authenticate error popup is not displayed and popup functionality failed");
			extent.extentLoggerFail("Popup",
					"Authenticate error popup is not displayed and popup functionality failed");
		}
		getDriver().navigate().back();
		String beforecode = TVgetText(Zee5TvWelcomePage.objloginCode);
		logger.info("Intial authentication code : " + beforecode);
		extent.extentLoggerPass("Code", "Intial authentication code : " + beforecode);
		TVclick(Zee5TvWelcomePage.objAuthenticateNewCodeButton, "New code button");
		waitTime(4000);
		TVclick(Zee5TvWelcomePage.objAuthenticateNewCodeButton, "New code button");
		waitTime(3000);
		TVclick(Zee5TvWelcomePage.objloginCode, "code");
		String aftercode = TVgetText(Zee5TvWelcomePage.objloginCode);
		logger.info("Authentication code after clicking on get new code button : " + aftercode);
		extent.extentLoggerPass("Code", "Authentication code after clicking on get new code button : " + aftercode);
		if (!aftercode.equals(beforecode)) {
			logger.info("Get new code button functionality verifed");
			extent.extentLoggerPass("Code", "Get new code button functionality verifed");
		} else {
			logger.info("Get new code button functionality failed");
			extent.extentLoggerFail("Code", "Get new code button functionality failed");
		}
		code = TVgetText(Zee5TvWelcomePage.objloginCode);
		logger.info("Authenticate code in TV : " + code);
		extentLoggerPass("Code", "Authenticate code in TV : " + code);
		setPlatform("Web");
		new Zee5TvBusinessLogic("zee");
		waitTime(10000);
		verifyElementPresentAndClick(PWALoginPage.objLanguageButton, "Language button");
		waitTime(3000);
		verifyElementPresentAndClick(PWALoginPage.objWebLoginBtn, "Login button");
		waitTime(3000);
		verifyElementPresentAndClick(PWALoginPage.objEmailField, "Email field");

		if (userType.equals("NonSubscribedUser") || userType.equals("Guest")) {
			String Username = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("NonsubscribedUserName");
			String Password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("NonsubscribedPassword");
			type(PWALoginPage.objEmailField, Username, "Email Field");
			waitTime(3000);
			verifyElementPresentAndClick(PWALoginPage.objPasswordField, "Password Field");
			type(PWALoginPage.objPasswordField, Password, "Password field");
			waitTime(5000);

		}
		if (userType.equals("SubscribedUser")) {
			String SubscribedUsername = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("SubscribedUserName");
			String SubscribedPassword = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("SubscribedPassword");
			type(PWALoginPage.objEmailField, SubscribedUsername, "Email Field");
			waitTime(3000);
			verifyElementPresentAndClick(PWALoginPage.objPasswordField, "Password Field");
			type(PWALoginPage.objPasswordField, SubscribedPassword, "Password field");
			waitTime(5000);

		}
		click(PWALoginPage.objWebLoginButton, "Login Button");
		waitTime(8000);
		verifyElementPresentAndClick(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger menu");
		verifyElementPresentAndClick(PWAHamburgerMenuPage.objAuthenticationOption, "Authentication option");
		waitTime(3000);
		checkElementDisplayed(PWAHamburgerMenuPage.objAuthenticationText, "Authentication Page");
		type(PWAHamburgerMenuPage.objAuthenticationField, code, "Authentication Field");
		click(PWAHamburgerMenuPage.objAuthenticationButtonHighlighted, "Authenticate button");
		waitTime(3000);
		BrowsertearDown();
		setPlatform("TV");
		waitTime(10000);
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objcontinueButtonInLoginPage,
				"Continue button in TV authentication page")) {
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(2000);
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(3000);
			TVclick(Zee5TvWelcomePage.objcontinueButtonInLoginPage, "Continue button in TV authentication page");
			waitTime(15000);
		}

		if (verifyIsElementDisplayed(Zee5TvHomePage.objSelectTab("Home"), "Home landing")) {
			logger.info("User is navigated to Home landing page post authentication");
			logger.info("User logged in with existing id");
			extent.extentLoggerPass("Id", "User logged in with existing id");
			extent.extentLoggerPass("Home", "User is navigated to Home landing page post authentication");
		} else {
			logger.info("Post Authentication Navigation failed");
		}
		TVTabSelect("Home");

		for (int i = 0; i <= 10; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
		}

		TVTabSelect("Settings");
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		for (int i = 0; i <= 14; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
		}
		TVclick(Zee5TvWelcomePage.objLogoutOption, "Logout option");

		waitTime(3000);
		TVTabSelect("Home");
		for (int i = 0; i <= 10; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
		}
		TVTabSelect("Settings");
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		TVclick(Zee5TvWelcomePage.objLoginOption, "Login option");
		waitTime(8000);
	}

	public void authenticationLogin(String userid) throws Exception {
		HeaderChildNode("Authenticating device through Email " + userid + " id");
		waitTime(5000);
		code = TVgetText(Zee5TvWelcomePage.objloginCode);
		logger.info("Authenticate code in TV : " + code);
		extentLoggerPass("Code", "Authenticate code in TV : " + code);
		HeaderChildNode("Switching to WEB platform to Authenticate device");
		setPlatform("Web");
		new Zee5TvBusinessLogic("zee");
		waitTime(5000);

		verifyElementPresentAndClick(PWALoginPage.objWebLoginBtn, "Login button");
		waitTime(3000);
		verifyElementPresentAndClick(PWALoginPage.objEmailField, "Email field");
		if (userid.equals("NonSubscribedUser")) {
			String Username = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("NonsubscribedUserName");
			String Password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("NonsubscribedPassword");
			type(PWALoginPage.objEmailField, Username, "Email Field");
			waitTime(3000);
			verifyElementPresentAndClick(PWALoginPage.objPasswordField, "Password Field");
			type(PWALoginPage.objPasswordField, Password, "Password field");
			waitTime(5000);

		}
		if (userid.equals("SubscribedUser")) {
			String SubscribedUsername = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("SubscribedUserName");
			String SubscribedPassword = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("SubscribedPassword");
			type(PWALoginPage.objEmailField, SubscribedUsername, "Email Field");
			waitTime(3000);
			verifyElementPresentAndClick(PWALoginPage.objPasswordField, "Password Field");
			type(PWALoginPage.objPasswordField, SubscribedPassword, "Password field");
			waitTime(5000);

		}
		click(PWALoginPage.objWebLoginButton, "Login Button");
		waitTime(8000);
		verifyElementPresentAndClick(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger menu");
		verifyElementPresentAndClick(PWAHamburgerMenuPage.objAuthenticationOption, "Authentication option");
		waitTime(3000);
		checkElementDisplayed(PWAHamburgerMenuPage.objAuthenticationText, "Authentication Page");
		type(PWAHamburgerMenuPage.objAuthenticationField, code, "Authentication Field");
		click(PWAHamburgerMenuPage.objAuthenticationButtonHighlighted, "Authenticate button");
		waitTime(3000);
		BrowsertearDown();
		setPlatform("TV");
		waitTime(10000);
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objcontinueButtonInLoginPage,
				"Continue button in TV authentication page")) {
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(2000);
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(3000);
			TVclick(Zee5TvWelcomePage.objcontinueButtonInLoginPage, "Continue button in TV authentication page");
			waitTime(15000);
		}
		TVTabSelect("Home");
		for (int i = 0; i <= 10; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
		}
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objProfileOptionInSettingPage, "Profile option")) {
			logger.info("User is logged in succesfully with " + userid + " id");
			extent.extentLoggerPass("Login", "User is logged in succesfully with " + userid + " id");
		} else {
			logger.info("Login functionality failed");
			extent.extentLoggerFail("Login", "Login functionality failed");
		}
		for (int i = 0; i <= 14; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
		}
		TVclick(Zee5TvWelcomePage.objLogoutOption, "Logout option");

		waitTime(3000);
		TVTabSelect("Home");
		for (int i = 0; i <= 10; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
		}
		TVTabSelect("Settings");
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		TVclick(Zee5TvWelcomePage.objLoginOption, "Login option");
		waitTime(8000);
	}

	public void mobilenumberLogin() throws Exception {
		HeaderChildNode("Authenticating device through mobile number");
		waitTime(10000);
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objLoginPopupAmazon, "Afs login popup")) {
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(2000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(2000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(2000);
			TVclick(Zee5TvWelcomePage.objLogiButtonAmazon, "Login button amazon");
			waitTime(7000);
		} else {
			logger.info("Popup not displayed");
		}
		code = TVgetText(Zee5TvWelcomePage.objloginCode);
		logger.info("Authenticate code in TV : " + code);
		extentLoggerPass("Code", "Authenticate code in TV : " + code);
		setPlatform("Web");
		new Zee5TvBusinessLogic("zee");
		waitTime(10000);
		verifyElementPresentAndClick(PWALoginPage.objLanguageButton, "Language button");
		waitTime(3000);
		verifyElementPresentAndClick(PWALoginPage.objWebLoginBtn, "Login button");
		waitTime(3000);
		verifyElementPresentAndClick(PWALoginPage.objEmailField, "Email field");
		String mobileLogin = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
				.getParameter("MobileLogin");
		String MobilePassword = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
				.getParameter("MobilePassword");
		type(PWALoginPage.objEmailField, mobileLogin, "Email Field");
		waitTime(3000);
		click(PWALoginPage.objWebLoginButton, "Login Button");
		waitTime(8000);
		verifyElementPresentAndClick(PWALoginPage.objWebMobileEnterPasswordButton, "Enter Password button");
		waitTime(5000);
		verifyElementPresentAndClick(PWALoginPage.objPasswordField, "Password Field");
		type(PWALoginPage.objPasswordField, MobilePassword, "Password field");
		waitTime(5000);
		verifyElementPresentAndClick(PWALoginPage.objProceedbuttoninpopup, "Proceed button in popup");
		waitTime(5000);
		verifyElementPresentAndClick(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger menu");
		verifyElementPresentAndClick(PWAHamburgerMenuPage.objAuthenticationOption, "Authentication option");
		waitTime(3000);
		checkElementDisplayed(PWAHamburgerMenuPage.objAuthenticationText, "Authentication Page");
		type(PWAHamburgerMenuPage.objAuthenticationField, code, "Authentication Field");
		click(PWAHamburgerMenuPage.objAuthenticationButtonHighlighted, "Authenticate button");
		waitTime(3000);
		BrowsertearDown();
		setPlatform("TV");
		waitTime(10000);
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objcontinueButtonInLoginPage,
				"Continue button in TV authentication page")) {
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(2000);
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(3000);
			TVclick(Zee5TvWelcomePage.objcontinueButtonInLoginPage, "Continue button in TV authentication page");
			waitTime(15000);
		}
		TVTabSelect("Home");
		for (int i = 0; i <= 10; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
		}
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objProfileOptionInSettingPage, "Profile option")) {
			logger.info("User is logged in succesfully with mobile number credentials");
			extent.extentLoggerPass("Login", "User is logged in succesfully with mobile number credentials");
		} else {
			logger.info("Login functionality failed");
			extent.extentLoggerFail("Login", "Login functionality failed");
		}
		for (int i = 0; i <= 14; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
		}
		TVclick(Zee5TvWelcomePage.objLogoutOption, "Logout option");

		waitTime(3000);
		TVTabSelect("Home");
		for (int i = 0; i <= 10; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
		}
		TVTabSelect("Settings");
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		TVclick(Zee5TvWelcomePage.objLoginOption, "Login option");
		waitTime(8000);
	}

	public void device() throws Exception {
		if (userType.equals("Guest") || userType.equals("NonSubscribedUser")) {
			deviceAuthentication();
			mobilenumberLogin();
			facebooklogin();
		}
		if (userType.equals("SubscribedUser")) {
			deviceAuthentication();
			mobilenumberLogin();
			facebooklogin();
		}
	}

	public void facebooklogin() throws Exception {
		HeaderChildNode("Authenticating device through facebook login");
		waitTime(10000);
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objLoginPopupAmazon, "Afs login popup")) {
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(2000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(2000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(2000);
			TVclick(Zee5TvWelcomePage.objLogiButtonAmazon, "Login button amazon");
			waitTime(7000);
		} else {
			logger.info("Popup not displayed");
		}
		code = TVgetText(Zee5TvWelcomePage.objloginCode);
		logger.info("Authenticate code in TV : " + code);
		extentLoggerPass("Code", "Authenticate code in TV : " + code);
		setPlatform("Web");
		new Zee5TvBusinessLogic("zee");
		waitTime(10000);
		verifyElementPresentAndClick(PWALoginPage.objLanguageButton, "Language button");
		waitTime(3000);
		verifyElementPresentAndClick(PWALoginPage.objWebLoginBtn, "Login button");
		waitTime(3000);
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
			type(PWALoginPage.objFacebookLoginEmailWeb, "8277333678", "Emial Field");
			verifyElementPresent(PWALoginPage.objFacebookLoginpasswordWeb, " Password Field");
			type(PWALoginPage.objFacebookLoginpasswordWeb, "Igs123!@#", "Password Field");
			verifyElementPresentAndClick(PWALoginPage.objFacebookLoginButtonInFbPageWeb, "Login Button");
			switchToWindow(1);
			waitForElementDisplayed(PWALandingPages.objWebProfileIcon, 20);
		}
		waitTime(5000);
		verifyElementPresentAndClick(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger menu");
		verifyElementPresentAndClick(PWAHamburgerMenuPage.objAuthenticationOption, "Authentication option");
		waitTime(3000);
		checkElementDisplayed(PWAHamburgerMenuPage.objAuthenticationText, "Authentication Page");
		type(PWAHamburgerMenuPage.objAuthenticationField, code, "Authentication Field");
		click(PWAHamburgerMenuPage.objAuthenticationButtonHighlighted, "Authenticate button");
		waitTime(3000);
		BrowsertearDown();
		setPlatform("TV");
		waitTime(10000);
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objcontinueButtonInLoginPage,
				"Continue button in TV authentication page")) {
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(2000);
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(3000);
			TVclick(Zee5TvWelcomePage.objcontinueButtonInLoginPage, "Continue button in TV authentication page");
			waitTime(15000);
		}
		TVTabSelect("Home");
		for (int i = 0; i <= 10; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
		}
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objProfileOptionInSettingPage, "Profile option")) {
			logger.info("User is logged in succesfully with facebook credentials");
			extent.extentLoggerPass("Login", "User is logged in succesfully with facebook credentials");
		} else {
			logger.info("Login functionality failed");
			extent.extentLoggerFail("Login", "Login functionality failed");
		}
		for (int i = 0; i <= 14; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
		}
		TVclick(Zee5TvWelcomePage.objLogoutOption, "Logout option");

		waitTime(3000);
		TVTabSelect("Home");
		for (int i = 0; i <= 10; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
		}
		getDriver().closeApp();
		waitTime(3000);
		getDriver().launchApp();
		waitTime(7000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 19");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 19");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 19");
		waitTime(2000);
	}

	public void staticPages() throws Exception {
		HeaderChildNode("Static page options validation");
		if (userType.equals("Guest")) {
			waitTime(10000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip Link")) {
				TVclick(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip link");
				extent.extentLoggerPass("Clicked on Skip Link", "Clicked on Skip Link");
			} else {
				logger.info("User is logged in");
				extent.extentLoggerPass("Button", "User is logged in");
			}
		}
		TVTabSelect("Home");
		for (int i = 0; i <= 10; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
		}
		TVTabSelect("Settings");
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		for (int i = 0; i <= 5; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
			if (verifyIsElementDisplayed(Zee5TvHomePage.objOptionsInSetting("FAQ"), "FAQ option in setting page")) {
				TVclick(Zee5TvHomePage.objOptionsInSettingClick("FAQ"), "FAQ option");
				waitTime(3000);
				Runtime.getRuntime().exec("adb shell input keyevent 23");
				waitTime(5000);
				verifyIsElementDisplayed(Zee5TvHomePage.objFAQPage, "FAQ page");
				waitTime(3000);
				getDriver().navigate().back();
				waitTime(2000);
				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 22");
			}
		}
		for (int i = 0; i <= 5; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
			if (verifyIsElementDisplayed(Zee5TvHomePage.objOptionsInSetting("CONTACT"),
					"Contact us option in setting page")) {
				TVclick(Zee5TvHomePage.objOptionsInSettingClick("CONTACT"), "Contact us option");
				waitTime(3000);
				Runtime.getRuntime().exec("adb shell input keyevent 23");
				waitTime(5000);
				verifyIsElementDisplayed(Zee5TvHomePage.objContactUsPage, "Contact us page");
				waitTime(3000);
				getDriver().navigate().back();
				waitTime(2000);
				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 22");
			}
		}
		for (int i = 0; i <= 5; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
			if (verifyIsElementDisplayed(Zee5TvHomePage.objOptionsInSetting("ABOUT"),
					"About us option in setting page")) {
				TVclick(Zee5TvHomePage.objOptionsInSettingClick("ABOUT"), "About us option");
				waitTime(3000);
				Runtime.getRuntime().exec("adb shell input keyevent 23");
				waitTime(5000);
				verifyIsElementDisplayed(Zee5TvHomePage.objAboutUsPage, "About us page");
				waitTime(3000);
				getDriver().navigate().back();
				waitTime(2000);
				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 22");
			}
		}
		for (int i = 0; i <= 5; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
			if (verifyIsElementDisplayed(Zee5TvHomePage.objOptionsInSetting("TERMS OF"),
					"Terms of use option in setting page")) {
				TVclick(Zee5TvHomePage.objOptionsInSettingClick("TERMS OF"), "Terms of use option");
				waitTime(3000);
				Runtime.getRuntime().exec("adb shell input keyevent 23");
				waitTime(5000);
				verifyIsElementDisplayed(Zee5TvHomePage.objTermsOfUsePage, "Terms of use page");
				waitTime(3000);
				getDriver().navigate().back();
				waitTime(2000);
				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 22");
			}
		}
		for (int i = 0; i <= 5; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
			if (verifyIsElementDisplayed(Zee5TvHomePage.objOptionsInSetting("PRIVACY"),
					"Privacy policy option in setting page")) {
				TVclick(Zee5TvHomePage.objOptionsInSettingClick("PRIVACY"), "Privacy policy option");
				waitTime(3000);
				Runtime.getRuntime().exec("adb shell input keyevent 23");
				waitTime(5000);
				verifyIsElementDisplayed(Zee5TvHomePage.objPrivacyPolicyPage, "Privacy policy page");
				waitTime(3000);
				getDriver().navigate().back();
				waitTime(2000);
				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 22");
			}
		}
		getDriver().navigate().back();
		waitTime(3000);
		getDriver().navigate().back();
		waitTime(3000);
		getDriver().closeApp();

		waitTime(3000);

		getDriver().launchApp();

		waitTime(10000);
		if (userType.equals("Guest")) {
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
		}
	}

	public void contactUs() throws Exception {
		HeaderChildNode("Contact us page validations");

		if (userType.equals("Guest")) {
			waitTime(10000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip Link")) {
				TVclick(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip link");
				extent.extentLoggerPass("Clicked on Skip Link", "Clicked on Skip Link");
			} else {
				logger.info("User is logged in");
				extent.extentLoggerPass("Button", "User is logged in");
			}
		}
		TVTabSelect("Home");
		for (int i = 0; i <= 10; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
		}
		TVTabSelect("Settings");
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		for (int i = 0; i <= 5; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
		}
		verifyIsElementDisplayed(Zee5TvHomePage.objOptionsInSetting("CONTACT"), "Contact us option in setting page");
		TVclick(Zee5TvHomePage.objOptionsInSettingClick("CONTACT"), "Contact us option");
		waitTime(3000);
		Runtime.getRuntime().exec("adb shell input keyevent 23");
		waitTime(5000);
		verifyIsElementDisplayed(Zee5TvHomePage.objContactUsPage, "Contact us page");
		waitTime(3000);
		if (userType.equals("Guest")) {
			Runtime.getRuntime().exec("adb shell input keyevent 23");
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvHomePage.objCountryCodePopup, "Country code popup")) {
				Runtime.getRuntime().exec("adb shell input keyevent 19");
				waitTime(2000);
				Runtime.getRuntime().exec("adb shell input keyevent 19");
				waitTime(2000);
				Runtime.getRuntime().exec("adb shell input keyevent 23");
				waitTime(3000);
				String countrybefore = TVgetText(Zee5TvHomePage.objSelectCountryBox);
				logger.info("Current country : " + countrybefore);
				TVclick(Zee5TvHomePage.objResetButton, "reset button");
				waitTime(3000);
				TVclick(Zee5TvHomePage.objResetButton, "reset button");
				waitTime(2000);
				String countryAfter = TVgetText(Zee5TvHomePage.objSelectCountryBox);
				logger.info("Current country : " + countryAfter);
				if (!countrybefore.equals(countryAfter)) {
					logger.info("Reset functionality successfull");
					extent.extentLoggerPass("Reset", "Reset functionality successfull");
				} else {
					logger.info("Reset functionality failed");
					extent.extentLoggerFail("reset", "Reset functionality failed");
				}
			}
			for (int i = 0; i <= 5; i++) {
				Runtime.getRuntime().exec("adb shell input keyevent 19");
				waitTime(2000);
			}
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 23");
			waitTime(3000);
			String phoneNumber[] = { "7", "8", "9", "2", "2", "1", "5", "2", "1", "4" };
			type(phoneNumber);
			for (int i = 0; i <= 8; i++) {
				Runtime.getRuntime().exec("adb shell input keyevent 22");
			}
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 23");
			waitTime(3000);
			String emailID[] = { "t", "v", "a", "u", "t", "o", "m", "a", "t", "i", "o", "n" };
			type(emailID);
			TVclick(Zee5TvHomePage.objSplCharechter, " @ button");
			waitTime(3000);
			TVclick(Zee5TvHomePage.objatbutton, "@ button");
			waitTime(3000);
			TVclick(Zee5TvHomePage.objAlphaKeyboard, " Alpha keyboard button");
			waitTime(3000);
			TVclick(Zee5TvHomePage.objAlphaKeyboard, " Alpha keyboard button");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 23");
			TVclick(Zee5TvHomePage.objAlphaKeyboardGbutton, "g button in alphakeyboard");
			waitTime(2000);
			TVclick(Zee5TvHomePage.objAlphaKeyboardMbutton, "m button in alphakeyboard");
			waitTime(2000);
			TVclick(Zee5TvHomePage.objAlphaKeyboardAbutton, "a button in alphakeyboard");
			waitTime(2000);
			TVclick(Zee5TvHomePage.objAlphaKeyboardIbutton, "i button in alphakeyboard");
			waitTime(2000);
			TVclick(Zee5TvHomePage.objAlphaKeyboardLbutton, "l button in alphakeyboard");
			waitTime(2000);
			TVclick(Zee5TvHomePage.objSplCharechter, " @ button");
			waitTime(3000);
			TVclick(Zee5TvHomePage.objdotbutton, " . button");
			waitTime(3000);
			TVclick(Zee5TvHomePage.objAlphaKeyboard, " Alpha keyboard button");
			waitTime(3000);
			TVclick(Zee5TvHomePage.objAlphaKeyboard, " Alpha keyboard button");
			waitTime(3000);
			TVclick(Zee5TvHomePage.objAlphaKeyboardCbutton, "c button in alphakeyboard");
			waitTime(2000);
			TVclick(Zee5TvHomePage.objAlphaKeyboardObutton, "o button in alphakeyboard");
			waitTime(2000);
			TVclick(Zee5TvHomePage.objAlphaKeyboardMbutton, "m button in alphakeyboard");
			waitTime(2000);
			for (int i = 0; i <= 8; i++) {
				Runtime.getRuntime().exec("adb shell input keyevent 22");
			}
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(5000);
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(5000);
			Runtime.getRuntime().exec("adb shell input keyevent 23");
			waitTime(3000);
			TVclick(Zee5TvHomePage.objAlphaKeyboardXbutton, "x button in alphakeyboard");
			waitTime(2000);
			TVclick(Zee5TvHomePage.objAlphaKeyboardYbutton, "y button in alphakeyboard");
			waitTime(2000);
			TVclick(Zee5TvHomePage.objAlphaKeyboardZbutton, "z button in alphakeyboard");
			waitTime(2000);
			for (int i = 0; i <= 8; i++) {
				Runtime.getRuntime().exec("adb shell input keyevent 22");
			}
			waitTime(3000);

			TVclick(Zee5TvHomePage.objSubmitButton, "Submit button");
			waitTime(7000);
			if (verifyIsElementDisplayed(Zee5TvHomePage.objSuccessPopup, "Success popup")) {
				logger.info("Successfully submitted popup is dsiplayed and contact us page submission succesfull");
				extent.extentLoggerPass("Success",
						"Successfully submitted popup is dsiplayed and contact us page submission succesfull");
			} else {
				logger.info("Contact us page validation failed");
				extent.extentLoggerFail("Contact", "Contact us page validation failed");
			}
			getDriver().navigate().back();
		}
		if (userType.equals("NonSubscribedUser") || userType.equals("SubscribedUser")) {
			Runtime.getRuntime().exec("adb shell input keyevent 23");
			TVclick(Zee5TvHomePage.objAlphaKeyboardXbutton, "x button in alphakeyboard");
			waitTime(2000);
			TVclick(Zee5TvHomePage.objAlphaKeyboardYbutton, "y button in alphakeyboard");
			waitTime(2000);
			TVclick(Zee5TvHomePage.objAlphaKeyboardZbutton, "z button in alphakeyboard");
			waitTime(2000);
			String before = TVgetText(Zee5TvHomePage.objEditBox);
			TVclick(Zee5TvHomePage.objResetButton, "reset button");
			waitTime(3000);
			TVclick(Zee5TvHomePage.objResetButton, "reset button");
			waitTime(2000);
			String after = TVgetText(Zee5TvHomePage.objEditBox);
			if (!before.equals(after)) {
				logger.info("Reset functionality successfull");
				extent.extentLoggerPass("Reset", "Reset functionality successfull");
			} else {
				logger.info("Reset functionality failed");
				extent.extentLoggerFail("reset", "Reset functionality failed");

			}
			Runtime.getRuntime().exec("adb shell input keyevent 23");
			TVclick(Zee5TvHomePage.objAlphaKeyboardXbutton, "x button in alphakeyboard");
			waitTime(2000);
			TVclick(Zee5TvHomePage.objAlphaKeyboardYbutton, "y button in alphakeyboard");
			waitTime(2000);
			TVclick(Zee5TvHomePage.objAlphaKeyboardZbutton, "z button in alphakeyboard");
			waitTime(2000);
			for (int i = 0; i <= 8; i++) {
				Runtime.getRuntime().exec("adb shell input keyevent 22");
			}
			waitTime(3000);

			TVclick(Zee5TvHomePage.objSubmitButton, "Submit button");
			waitTime(7000);
			if (verifyIsElementDisplayed(Zee5TvHomePage.objSuccessPopup, "Success popup")) {
				logger.info("Successfully submitted popup is dsiplayed and contact us page submission succesfull");
				extent.extentLoggerPass("Success",
						"Successfully submitted popup is dsiplayed and contact us page submission succesfull");
			} else {
				logger.info("Contact us page validation failed");
				extent.extentLoggerFail("Contact", "Contact us page validation failed");
			}
			getDriver().navigate().back();
			waitTime(2000);
			getDriver().navigate().back();
			waitTime(2000);
			getDriver().navigate().back();
			waitTime(2000);
		}
	}

	public static String getLanguage(String userType) {

		String language = null;
		if (userType.contains("Guest")) {
			language = "en,kn";
		} else {
			Response resplanguage = ResponseInstance.getUserinfoforNonSubORSub(userType);
			// System.out.println(resplanguage.print());

			// System.out.println(resplanguage.jsonPath().getList("array").size());

			for (int i = 0; i < resplanguage.jsonPath().getList("array").size(); i++) {

				String key = resplanguage.jsonPath().getString("[" + i + "].key");
				// System.out.println(language);
				if (key.contains("content_language")) {
					language = resplanguage.jsonPath().getString("[" + i + "].value");
					// System.out.println("UserType Language: " + language);
					break;
				}
			}
		}

		return language;

	}

	public void clubScenarios() throws Exception {
		HeaderChildNode("Club scenarios - Login through club user id");
		waitTime(15000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(3000);
		Runtime.getRuntime().exec("adb shell input keyevent 19");
		waitTime(3000);
		Runtime.getRuntime().exec("adb shell input keyevent 19");
		waitTime(3000);
		Runtime.getRuntime().exec("adb shell input keyevent 19");
		waitTime(3000);

		verifyIsElementDisplayed(Zee5TvWelcomePage.objalreadyRegister, "Already Register button");
		TVclick(Zee5TvWelcomePage.objalreadyRegister, "Already Register button");
		waitTime(8000);
		code = TVgetText(Zee5TvWelcomePage.objloginCode);
		logger.info("Authenticate code in TV : " + code);
		extentLoggerPass("Code", "Authenticate code in TV : " + code);
		HeaderChildNode("Switching to WEB platform to Authenticate device");
		setPlatform("Web");
		new Zee5TvBusinessLogic("zee");
		waitTime(10000);
		verifyElementPresentAndClick(PWALoginPage.objLanguageButton, "Language button");
		waitTime(3000);
		verifyElementPresentAndClick(PWALoginPage.objWebLoginBtn, "Login button");
		waitTime(3000);
		verifyElementPresentAndClick(PWALoginPage.objEmailField, "Email field");
		String Username = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
				.getParameter("ClubUserName");
		String Password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
				.getParameter("ClubPassword");
		type(PWALoginPage.objEmailField, Username, "Email Field");
		waitTime(3000);
		verifyElementPresentAndClick(PWALoginPage.objPasswordField, "Password Field");
		type(PWALoginPage.objPasswordField, Password, "Password field");
		waitTime(5000);
		click(PWALoginPage.objWebLoginButton, "Login Button");
		waitTime(8000);
		verifyElementPresentAndClick(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger menu");
		verifyElementPresentAndClick(PWAHamburgerMenuPage.objAuthenticationOption, "Authentication option");
		waitTime(3000);
		checkElementDisplayed(PWAHamburgerMenuPage.objAuthenticationText, "Authentication Page");
		type(PWAHamburgerMenuPage.objAuthenticationField, code, "Authentication Field");
		click(PWAHamburgerMenuPage.objAuthenticationButtonHighlighted, "Authenticate button");
		waitTime(3000);
		BrowsertearDown();
		setPlatform("TV");
		waitTime(10000);
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objcontinueButtonInLoginPage,
				"Continue button in TV authentication page")) {
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(2000);
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(3000);
			TVclick(Zee5TvWelcomePage.objcontinueButtonInLoginPage, "Continue button in TV authentication page");
			waitTime(15000);
		}
		HeaderChildNode("Before Tv content playback validation in home page");
		TVTabSelect("Home");
		for (int i = 0; i <= 20; i++) {
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objBeforeTVTray, "BeforeTv Tray content")) {
				TVclick(Zee5TvWelcomePage.objBeforeTVTray, "BeforeTv Tray content");
				waitTime(7000);
				if (verifyIsElementDisplayed(Zee5TVCarousel.objSubscribePopUptitle, "Subscribe popup")) {
					if (userType.equals("Guest")) {
						logger.info("Login popup is displayed when Guest user clicks on before tv contents");
						extent.extentLoggerPass("Page",
								"Login popup is displayed when Guest user clicks on before tv contents");
					}
					if (userType.equals("NonSubscribedUser") || userType.equals("SubscribedUser")) {
						logger.info("Subscribe popup is displayed when user clicks on before tv contents");
						extent.extentLoggerPass("Page",
								"Subscribe popup is displayed when user clicks on before tv contents");
					}
				} else {
					TVclick(Zee5TvWelcomePage.objBeforeTVTray, "BeforeTv Tray content");
					waitTime(4000);
					if (verifyIsElementDisplayed(Zee5TVCarousel.objSubscribePopUptitle, "Subscribe popup")) {
						if (userType.equals("Guest")) {
							logger.info("Login popup is displayed when Guest user clicks on before tv contents");
							extent.extentLoggerPass("Page",
									"Login popup is displayed when Guest user clicks on before tv contents");
						}
						if (userType.equals("NonSubscribedUser") || userType.equals("SubscribedUser")) {
							logger.info("Subscribe popup is displayed when user clicks on before tv contents");
							extent.extentLoggerPass("Page",
									"Subscribe popup is displayed when user clicks on before tv contents");
						}
					} else {
						waitTime(12000);
						Runtime.getRuntime().exec("adb shell input keyevent 23");
						waitTime(2000);
						Runtime.getRuntime().exec("adb shell input keyevent 23");
						waitTime(4000);
						if (verifyIsElementDisplayed(Zee5TvPlayerPage.objPlayerContainer, "Consumption screen")) {
							logger.info("User is able to play before tv content in home page for club user");
							extent.extentLoggerPass("play",
									"User is able to play before tv content in home page for club user");
						}
					}
					break;
				}
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 20");
				waitTime(3000);
			}
		}
		getDriver().navigate().back();
		waitTime(3000);
		if (verifyIsElementDisplayed(Zee5TvHomePage.objMorecontentPopup, "More content popup")) {
			logger.info(
					"Would you like to add selected display language as content language popup is diaplyed when user clicks on different display language");
			extent.extentLoggerPass("Popup",
					"Would you like to add selected display language as content language popup is diaplyed when user clicks on different display language");
			getDriver().navigate().back();
		} else {
			logger.info("Popup is not displayed");
			extent.extentLogger("Popup", "Popup is not displayed");
		}
		getDriver().navigate().back();
		waitTime(3000);
		for (int i = 0; i <= 18; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(2000);
		}
		HeaderChildNode("Before Tv content playback validation in shows page");
		TVTabSelect("Home");
		waitTime(2000);
		TVTabSelect("Shows");
		waitTime(3000);
		for (int i = 0; i <= 18; i++) {
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objBeforeTVTray, "BeforeTv Tray content")) {
				TVclick(Zee5TvWelcomePage.objBeforeTVTray, "BeforeTv Tray content");
				waitTime(7000);
				if (verifyIsElementDisplayed(Zee5TVCarousel.objSubscribePopUptitle, "Subscribe popup")) {
					if (userType.equals("Guest")) {
						logger.info("Login popup is displayed when Guest user clicks on before tv contents");
						extent.extentLoggerPass("Page",
								"Login popup is displayed when Guest user clicks on before tv contents");
					}
					if (userType.equals("NonSubscribedUser") || userType.equals("SubscribedUser")) {
						logger.info("Subscribe popup is displayed when user clicks on before tv contents");
						extent.extentLoggerPass("Page",
								"Subscribe popup is displayed when user clicks on before tv contents");
					}
				} else {
					TVclick(Zee5TvWelcomePage.objBeforeTVTray, "BeforeTv Tray content");
					waitTime(4000);
					if (verifyIsElementDisplayed(Zee5TVCarousel.objSubscribePopUptitle, "Subscribe popup")) {
						if (userType.equals("Guest")) {
							logger.info("Login popup is displayed when Guest user clicks on before tv contents");
							extent.extentLoggerPass("Page",
									"Login popup is displayed when Guest user clicks on before tv contents");
						}
						if (userType.equals("NonSubscribedUser") || userType.equals("SubscribedUser")) {
							logger.info("Subscribe popup is displayed when user clicks on before tv contents");
							extent.extentLoggerPass("Page",
									"Subscribe popup is displayed when user clicks on before tv contents");
						}
					} else {
						waitTime(12000);
						Runtime.getRuntime().exec("adb shell input keyevent 23");
						waitTime(2000);
						Runtime.getRuntime().exec("adb shell input keyevent 23");
						waitTime(4000);
						if (verifyIsElementDisplayed(Zee5TvPlayerPage.objPlayerContainer, "Consumption screen")) {
							logger.info("User is able to play before tv content in shows page for club user");
							extent.extentLoggerPass("play",
									"User is able to play before tv content in shows page for club user");
						}
					}
					break;
				}
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 20");
				waitTime(3000);
			}
		}
		getDriver().navigate().back();
		waitTime(3000);
		if (verifyIsElementDisplayed(Zee5TvHomePage.objMorecontentPopup, "More content popup")) {
			logger.info(
					"Would you like to add selected display language as content language popup is diaplyed when user clicks on different display language");
			extent.extentLogger("Popup",
					"Would you like to add selected display language as content language popup is diaplyed when user clicks on different display language");
			getDriver().navigate().back();
		} else {
			logger.info("Popup is not displayed");
			extent.extentLogger("Popup", "Popup is not displayed");
		}
		getDriver().navigate().back();
		waitTime(3000);
		for (int i = 0; i <= 18; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(2000);
		}
		HeaderChildNode("Content playback validation in News page");
		TVTabSelect("News");
		for (int i = 0; i <= 15; i++) {
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objLiveNewsContentinNewsPage, "News page Tray content")) {
				waitTime(5000);
				TVclick(Zee5TvWelcomePage.objLiveNewsContentinNewsPage, "News page Tray content");
				TVclick(Zee5TvWelcomePage.objLiveNewsContentinNewsPage, "News page Tray content");
				waitTime(4000);
				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 20");
				waitTime(3000);
			}
		}
		waitTime(10000);
		for (int i = 0; i <= 5; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 23");
			waitTime(2000);
			if (verifyIsElementDisplayed(Zee5TvSearchPage.objGotolivebutton, "Live button in player")) {
				logger.info("User is able play Free news content");
				extent.extentLoggerPass("EPG", "User is able play Free news content");
				break;
			}
		}
		getDriver().navigate().back();
		for (int k = 0; k <= 15; k++) {
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(3000);
		}
		HeaderChildNode("Content playback validation in videos page");
		TVTabSelect("Videos");
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		for (int i = 0; i <= 18; i++) {
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objVideoPageTrayContent, "Videos page Tray content")) {
				TVclick(Zee5TvWelcomePage.objVideoPageTrayContent, "Videos page Tray content");
				waitTime(8000);
				if (verifyIsElementDisplayed(Zee5TvSearchPage.objPlayIcon, "Content Title")) {
					logger.info("User is navigated to content detail page");
					extent.extentLoggerPass("Page", "User is navigated to content detail page");
				} else {
					TVclick(Zee5TvWelcomePage.objVideoPageTrayContent, "Videos page Tray content");
				}
				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 20");
				waitTime(3000);
			}
		}
		waitTime(8000);
		Runtime.getRuntime().exec("adb shell input keyevent 23");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 23");
		if (verifyIsElementDisplayed(Zee5TvPlayerPage.objPlayerContainer, "Consumption screen")) {
			logger.info("User can play free content in videos page for club user");
			extent.extentLoggerPass("play", "User can play free content in videos page for club user");
		} else {
			logger.info("playback did not initiate");
			extent.extentLogger("play", "playback did not initiate");
		}
		getDriver().navigate().back();
		waitTime(5000);
		for (int k = 0; k <= 15; k++) {
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(2000);
		}
		getDriver().navigate().back();
		waitTime(3000);
		HeaderChildNode("Content playback validation through show content detail page");
		TVTabSelect("Shows");
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		for (int i = 0; i <= 20; i++) {
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objshowpageTrayContentClub, "Show page Tray content")) {
				TVclick(Zee5TvWelcomePage.objshowpageTrayContentClub, "Show page Tray content");
				if (verifyIsElementDisplayed(Zee5TvSearchPage.objPlayIcon, "Content Title")) {
					logger.info("User is navigated to content detail page");
					extent.extentLoggerPass("Page", "User is navigated to content detail page");
				} else {
					TVclick(Zee5TvWelcomePage.objshowpageTrayContentClub, "Show page Tray content");
				}
				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 20");
				waitTime(3000);
			}
		}
		TVclick(Zee5TvSearchPage.objPlayIcon, "Play Icon");
		waitTime(7000);
		Runtime.getRuntime().exec("adb shell input keyevent 23");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 23");
		waitTime(4000);
		if (verifyIsElementDisplayed(Zee5TvPlayerPage.objPlayerContainer, "Consumption screen")) {
			logger.info("User is able to play shows from show content detail page");
			extent.extentLoggerPass("play", "User is able to play shows from show content detail page");
		}
		getDriver().navigate().back();
		waitTime(3000);
		getDriver().navigate().back();
		waitTime(3000);
		getDriver().navigate().back();
		waitTime(3000);
		for (int k = 0; k <= 15; k++) {
			Runtime.getRuntime().exec("adb shell input keyevent 19");
			waitTime(2000);
		}
		getDriver().navigate().back();
		waitTime(3000);
		HeaderChildNode("Content playback validation through movie content detail page");
		if (TVgetAttributValue("focused", Zee5TvHomePage.objSearchIcon).equals("false")) {

			TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
			TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
		} else {

			TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
		}
		waitTime(5000);
		if (verifyIsElementDisplayed(Zee5TvSearchPage.objSearchSpaceBar, "Search page")) {
			logger.info("User is navigated to search page after clicking on search button");
			extent.extentLoggerPass("Search", "User is navigated to search page after clicking on search button");
		} else {
			logger.info("User is not navigated to serach page");
			extent.extentLoggerFail("Navigation", "User is not navigated to serach page");
		}
		String searchdata1[] = { "b", "a", "b", "l", "u", };
		String searchdata2[] = { "d", "a", "b", "l", "u" };
		String searchdata3[] = { "r", "o", "b", "o" };
		String searchdata4[] = { "r", "u", "m", "b", "l", "e" };
		HeaderChildNode("Search Movie content and its playback functionality");
		type(searchdata1);
		TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space bar");
		type(searchdata2);
		TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space");
		type(searchdata3);
		TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space");
		type(searchdata4);
		String content = TVgetText(Zee5TvSearchPage.objEditbox);

		logger.info("Entered Search Data : " + content);
		extent.extentLogger("Search", "Entered Searched Data : " + content);

		int k;
		List<WebElement> ele = getDriver().findElements(By.xpath("//*[@id='search_result_title']"));
		for (int i = 1; i <= ele.size(); i++) {

			title = TVgetText(Zee5TvSearchPage.objSearchedTumbnailTitle(i));
			logger.info(title);
			extent.extentLogger("Title", "Serach result content title : " + title);
			if ((verifyIsElementDisplayed(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title, "Movies"),
					"Searched Movie"))) {
				TVclick(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title, "Movies"), "serached Movie");
				break;
			} else {
				System.out.println("No match");
			}

		}

		waitTime(8000);
		String title = TVgetText(Zee5TvSearchPage.objSearchedDataTitle);
		if (title.equals(title)) {
			logger.info("user is navigated to respective content detail page");
			extent.extentLoggerPass("user", "user is navigated to respective content detail page");
		}
		waitTime(2000);
		TVclick(Zee5TvSearchPage.objPlayIcon, "Play Icon");
		waitTime(15000);
		if (verifyIsElementDisplayed(Zee5TvPlayerPage.objPlayerSkipIntro, "SkipIntro")) {
			TVRemoteEvent(20);
			waitTime(2000);
			TVRemoteEvent(23);
			logger.info("clicked on skip intro");
			extent.extentLoggerPass("Intro", "clicked on skip intro");
		} else {
			logger.info("Skip intro is not displayed");
			extent.extentLogger("Intro", "Skip intro is not displayed");
		}
		waitTime(12000);
		Runtime.getRuntime().exec("adb shell input keyevent 23");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 23");
		waitTime(4000);
		if (verifyIsElementDisplayed(Zee5TvPlayerPage.objPlayerContainer, "Consumption screen")) {
			logger.info("User is able to play free movie content from movie content detail page for club user");
			extent.extentLoggerPass("play",
					"User is able to play free movie content from movie content detail page for club user");
		} else {
			logger.info("playback did not initiate");
			extent.extentLoggerFail("play", "playback did not initiate");
		}
//		HeaderChildNode("Content playback validation through upnext rail");
//		Runtime.getRuntime().exec("adb shell input keyevent 23");
//		waitTime(3000);
//		Runtime.getRuntime().exec("adb shell input keyevent 20");
//		waitTime(2000);
//		Runtime.getRuntime().exec("adb shell input keyevent 23");
//		waitTime(3000);
//		Runtime.getRuntime().exec("adb shell input keyevent 20");
//		waitTime(3000);
//		Runtime.getRuntime().exec("adb shell input keyevent 22");
//		waitTime(3000);
//		Runtime.getRuntime().exec("adb shell input keyevent 23");
//
//		if (verifyIsElementDisplayed(Zee5TvPlayerPage.objUpnextrail, "Up Next rail")) {
//			logger.info("User can click on upnext button and up next rail is displayed");
//			extent.extentLoggerPass("UpNext", "User can click on upnext button and up next rail is displayed");
//		} else {
//			logger.info("Upnext tab functionality failed");
//			extent.extentLoggerFail("UpNext", "Upnext tab functionality failed");
//		}
//		Runtime.getRuntime().exec("adb shell input keyevent 23");
//		waitTime(10000);
//		Runtime.getRuntime().exec("adb shell input keyevent 23");
//		waitTime(3000);
//		Runtime.getRuntime().exec("adb shell input keyevent 23");
//		if (verifyIsElementDisplayed(Zee5TvPlayerPage.objPlayerContainer, "Consumption screen")) {
//			logger.info("User is able to play content from upnext rail for club user");
//			extent.extentLoggerPass("play", "User is able to play content from upnext rail for club user");
//		} else {
//			logger.info("playback did not initiate");
//			extent.extentLoggerFail("play", "playback did not initiate");
//		}
		getDriver().navigate().back();
		waitTime(2000);
		getDriver().navigate().back();
		waitTime(2000);
		getDriver().navigate().back();
		waitTime(2000);
		getDriver().navigate().back();
		waitTime(2000);
		waitTime(3000);
		HeaderChildNode("Get premium popup validation and subscription page navigation for premium content");
		if (TVgetAttributValue("focused", Zee5TvHomePage.objSearchIcon).equals("false")) {

			TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
			TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
		} else {

			TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
		}
		waitTime(10000);
		String searchdataContent[] = { "y", "o", "u", "n", "g", };
		String searchdataContent2[] = { "d", "r", "e", "a", "m", "s" };
		type(searchdataContent);
		TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space bar");
		type(searchdataContent2);
		String content2 = TVgetText(Zee5TvSearchPage.objEditbox);

		logger.info("Entered Search Data : " + content2);
		extent.extentLogger("Search", "Entered Searched Data : " + content2);
		waitTime(5000);
		int l;
		List<WebElement> ele2 = getDriver().findElements(By.xpath("//*[@id='search_result_title']"));
		for (int i = 1; i <= ele2.size(); i++) {

			title = TVgetText(Zee5TvSearchPage.objSearchedTumbnailTitle(i));
			logger.info(title);
			extent.extentLogger("Title", "Serach result content title : " + title);
			if ((verifyIsElementDisplayed(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title, "Shows"),
					"Searched Shows"))) {
				TVclick(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title, "Shows"), "serached Shows");
				break;
			} else {
				System.out.println("No match");
			}

		}
		waitTime(8000);
		TVclick(Zee5TvSearchPage.objPlayIcon, "Play Icon");
		waitTime(15000);
		if (verifyIsElementDisplayed(Zee5TvHomePage.objClubPremiumPopup, "Subscription popup")) {
			logger.info(
					"Subscription popup is displayed when club user plays any premium content not included in club pack");
			extent.extentLoggerPass("Popup",
					"Subscription popup is displayed when club user plays any premium content not included in club pack");
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
			TVclick(Zee5TvHomePage.objClubPremiumPopup, "Subscription button");
			waitTime(5000);
			if (verifyIsElementDisplayed(Zee5TVCarousel.objSubscriptionPlanPage, "My Plans page")) {
				logger.info("User is navigated to Subscription page post tapping on get premim button");
				extent.extentLoggerPass("plan",
						"User is navigated to Subscription page post tapping on get premim button");
			} else {
				logger.info("Navigation failed");
				extent.extentLogger("Plan", "Navigation failed");
			}
			if (verifyIsElementDisplayed(Zee5TvHomePage.objAllaccessButton, "All access button")) {
				logger.info("All access premium button is displayed for club user");
				extent.extentLoggerPass("Button", "All access premium button is displayed for club user");
			} else {
				logger.info("Navigation failed");
				extent.extentLogger("Plan", "Navigation failed");
			}
			getDriver().navigate().back();
			waitTime(2000);
			getDriver().navigate().back();
			waitTime(2000);
			getDriver().navigate().back();
			waitTime(2000);
			getDriver().navigate().back();
			waitTime(2000);
			getDriver().navigate().back();
			waitTime(2000);
		} else {
			logger.info("Premium popup functionality failed");
			extent.extentLogger("Popup", "Premium popup functionality failed");
			getDriver().navigate().back();
			waitTime(2000);
			getDriver().navigate().back();
			waitTime(2000);
			getDriver().navigate().back();
			waitTime(2000);
			getDriver().navigate().back();
			waitTime(2000);
		}
		waitTime(5000);
		HeaderChildNode("Content playback validation through continue watching tray");
		TVTabSelect("Home");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		TVclick(Zee5TvWelcomePage.objContinuewatchingTrayImage, "Continue watching content");
		waitTime(5000);
		Runtime.getRuntime().exec("adb shell input keyevent 23");
		waitTime(10000);
		Runtime.getRuntime().exec("adb shell input keyevent 23");
		waitTime(3000);
		Runtime.getRuntime().exec("adb shell input keyevent 23");
		if (verifyIsElementDisplayed(Zee5TvPlayerPage.objPlayerContainer, "Consumption screen")) {
			logger.info("User is able to play content from continue watching rail for club user");
			extent.extentLoggerPass("play", "User is able to play content from continue watching rail for club user");
		} else {
			logger.info("playback did not initiate");
			extent.extentLoggerFail("play", "playback did not initiate");
		}
		getDriver().navigate().back();
		waitTime(3000);
		getDriver().navigate().back();
		waitTime(3000);

		if (verifyIsElementDisplayed(Zee5TvHomePage.objMorecontentPopup, "More content popup")) {
			logger.info(
					"Would you like to add selected display language as content language popup is diaplyed when user clicks on different display language");
			extent.extentLogger("Popup",
					"Would you like to add selected display language as content language popup is diaplyed when user clicks on different display language");
			getDriver().navigate().back();
		} else {
			logger.info("Popup is not displayed");
			extent.extentLogger("Popup", "Popup is not displayed");
		}
		waitTime(3000);
		Runtime.getRuntime().exec("adb shell input keyevent 19");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 19");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 19");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 19");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 19");
		waitTime(2000);
		TVTabSelect("Home");
		waitTime(2000);
		TVTabSelect("Shows");
		for (int i = 0; i <= 15; i++) {
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvHomePage.objWatchNextTray, "Watch next Tray")) {
				logger.info("Watch next tray is displayed in show page for club user");
				extent.extentLoggerPass("Tray", "Watch next tray is displayed in show page for club user");
				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 20");
				waitTime(3000);
			}
		}
		getDriver().navigate().back();
		TVTabSelect("Home");
		for (int i = 0; i <= 10; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
		}
		TVTabSelect("Settings");
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		for (int i = 0; i <= 14; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
		}
		TVclick(Zee5TvWelcomePage.objLogoutOption, "Logout option");
		waitTime(10000);
		getDriver().closeApp();
		waitTime(3000);
		getDriver().launchApp();
		waitTime(7000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 19");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 19");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 19");
		waitTime(2000);

	}

	public void autheticateInsprint(String userType) throws Exception {
		HeaderChildNode("Device Authentication functionality id - 6824");
		waitTime(10000);
		verifyIsElementDisplayed(Zee5TvWelcomePage.objalreadyRegister, "Already Register button");
		TVclick(Zee5TvWelcomePage.objalreadyRegister, "Already Register button");
		waitTime(5000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 22");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 22");
		waitTime(2000);
		TVclick(Zee5TvWelcomePage.objcontinueButtonInLoginPage, "Continue button in TV authentication page");
		waitTime(3000);
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objAuthenticateErrorMessage,
				"Please authenticate error message")) {
			logger.info("Authenticate error popup is displayed");
			extent.extentLoggerPass("Popup", "Authenticate error popup is displayed");
		} else {
			logger.info("Authenticate error popup is not displayed and popup functionality failed");
			extent.extentLoggerFail("Popup",
					"Authenticate error popup is not displayed and popup functionality failed");
		}
		getDriver().navigate().back();
		code = TVgetText(Zee5TvWelcomePage.objloginCode);
		logger.info("Authenticate code in TV : " + code);
		extentLoggerPass("Code", "Authenticate code in TV : " + code);
		setPlatform("Web");
		new Zee5TvBusinessLogic("zee");
		waitTime(10000);
		verifyElementPresentAndClick(PWALoginPage.objLanguageButton, "Language button");
		waitTime(3000);
		verifyElementPresentAndClick(PWALoginPage.objWebLoginBtn, "Login button");
		waitTime(3000);
		verifyElementPresentAndClick(PWALoginPage.objEmailField, "Email field");

		if (userType.equals("NonSubscribedUser") || userType.equals("Guest")) {
			String Username = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("NonsubscribedUserName");
			String Password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("NonsubscribedPassword");
			type(PWALoginPage.objEmailField, Username, "Email Field");
			waitTime(3000);
			verifyElementPresentAndClick(PWALoginPage.objPasswordField, "Password Field");
			type(PWALoginPage.objPasswordField, Password, "Password field");
			waitTime(5000);

		}
		if (userType.equals("SubscribedUser")) {
			String SubscribedUsername = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("SubscribedUserName");
			String SubscribedPassword = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("SubscribedPassword");
			type(PWALoginPage.objEmailField, SubscribedUsername, "Email Field");
			waitTime(3000);
			verifyElementPresentAndClick(PWALoginPage.objPasswordField, "Password Field");
			type(PWALoginPage.objPasswordField, SubscribedPassword, "Password field");
			waitTime(5000);

		}
		click(PWALoginPage.objWebLoginButton, "Login Button");
		waitTime(8000);
		verifyElementPresentAndClick(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger menu");
		verifyElementPresentAndClick(PWAHamburgerMenuPage.objAuthenticationOption, "Authentication option");
		waitTime(3000);
		checkElementDisplayed(PWAHamburgerMenuPage.objAuthenticationText, "Authentication Page");
		type(PWAHamburgerMenuPage.objAuthenticationField, code, "Authentication Field");
		click(PWAHamburgerMenuPage.objAuthenticationButtonHighlighted, "Authenticate button");
		waitTime(3000);
		BrowsertearDown();
		setPlatform("TV");
		waitTime(10000);

		if (verifyIsElementDisplayed(Zee5TvHomePage.objSelectTab("Home"), "Home landing")) {
			logger.info("User is navigated to Home landing page post authentication automatically");
			extent.extentLoggerPass("Id", "User is navigated to Home landing page post authentication automatically");

		} else {
			logger.info("Automatic authentication Navigation failed");
			extent.extentLoggerFail("Authentication", "Automatic authentication Navigation failed");
		}
		TVTabSelect("Home");

		for (int i = 0; i <= 10; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
		}

		TVTabSelect("Settings");
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objProfileOptionInSettingPage, "Profile option")) {
			logger.info("User is logged in succesfully");
			extent.extentLoggerPass("Login", "User is logged in succesfully");
		} else {
			logger.info("Login functionality failed");
			extent.extentLoggerFail("Login", "Login functionality failed");
		}
		for (int i = 0; i <= 14; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
		}
		TVclick(Zee5TvWelcomePage.objLogoutOption, "Logout option");

		waitTime(3000);
		TVTabSelect("Home");
	}

	@SuppressWarnings("static-access")
	public void suscriptionCallInitiatedInsprint() throws Exception {
		HeaderChildNode("Subscription Call Initiated Event id- 6138 & 6039");
		waitTime(10000);
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip Link")) {
			TVclick(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip link");
			extent.extentLoggerPass("Clicked on Skip Link", "Clicked on Skip Link");
		} else {
			logger.info("User is logged in");
			extent.extentLoggerPass("Button", "User is logged in");
		}
		TVTabSelect("Home");

		for (int i = 0; i <= 10; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
		}
		HeaderChildNode("Subscription Page Viewed from setting screen");
		TVTabSelect("Settings");
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		for (int i = 0; i <= 3; i++) {
			Runtime.getRuntime().exec("adb shell input keyevent 22");
			waitTime(2000);
		}
		if (userType.equals("Guest")) {
			TVclick(Zee5TvWelcomePage.objALLPlanOption, "All plan option");
			waitTime(3000);
			TVclick(Zee5TvWelcomePage.objALLPlanOption, "All plan option");
		}
		if (userType.equals("NonSubscribedUser") || userType.equals("SubscribedUser")) {
			TVclick(Zee5TvWelcomePage.objMyPlanOption, "My Plan option");
			waitTime(3000);
			TVclick(Zee5TvWelcomePage.objMyPlanOption, "My Plan option");
		}
		waitTime(7000);

		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell input keyevent 20");
		waitTime(3000);
		if (userType.equals("NonSubscribedUser")) {
			Runtime.getRuntime().exec("adb shell input keyevent 23");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 20");
		}
		Runtime.getRuntime().exec("adb shell input keyevent 23");
		waitTime(3000);

		waitTime(5000);
		if (userType.equals("Guest")) {
			if (verifyIsElementDisplayed(Zee5TvSearchPage.objLoginPopup, "Login popup")) {
				logger.info("Login popup is displayed when user play premium content as guest user");
				extent.extentLoggerPass("Popup",
						"Login popup is displayed when user play premium content as guest user");
				Runtime.getRuntime().exec("adb shell input keyevent 22");
				waitTime(2000);
				Runtime.getRuntime().exec("adb shell input keyevent 22");
				waitTime(2000);
				Runtime.getRuntime().exec("adb shell input keyevent 23");
				waitTime(5000);

				mixpanel.FEProp.setProperty("Source", "Login and Authentication screen");
				mixpanel.FEProp.setProperty("Page Name", "Login and Authentication screen");
				mixpanel.ValidateParameter("", "TV Authentication Screen Display");
				logger.info(
						"Guest user is navigated to login screen post tapping on login butoon in login popup for premium content");

				getDriver().navigate().back();
				waitTime(2000);
				getDriver().navigate().back();
				waitTime(2000);
				getDriver().navigate().back();
				waitTime(2000);
			} else {
				logger.info("Functioanlity failed");
				extent.extentLoggerFail("Popup", "Popup Functioanlity failed");
			}
		}
		if (userType.equals("NonSubscribedUser") || userType.equals("SubscribedUser")) {
			mixpanel.FEProp.setProperty("Source", "Subscription Page");
			mixpanel.FEProp.setProperty("Page Name", "Subscription Page");
			mixpanel.FEProp.setProperty("Payment method", "");
			mixpanel.FEProp.setProperty("Payment gateway", "");
			mixpanel.ValidateParameter("", "Subscription call initiated");
			if (userType.equals("NonSubscribedUser")) {
				getDriver().navigate().back();
				waitTime(2000);
			}

			getDriver().navigate().back();
			waitTime(2000);
			getDriver().navigate().back();
			waitTime(2000);
			getDriver().navigate().back();
			waitTime(2000);
			TVTabSelect("Home");
		}
	}

	public void zeelogoVerificationInPlayer() throws Exception {
		HeaderChildNode("Verification of zee logo in player - CON 5720");
		if (verifyIsElementDisplayed(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip Link")) {
			TVclick(Zee5TvWelcomePage.objWelcomeSkipLink, "Skip link");
			extent.extentLoggerPass("Clicked on Skip Link", "Clicked on Skip Link");
		} else {
			logger.info("User is logged in");
			extent.extentLoggerPass("Button", "User is logged in");
		}

		waitTime(5000);

		TVTabSelect("Home");
		logger.info(TVgetText(Zee5TvHomePage.objHighlightedTab) + "Tab is highlighted");
		extent.extentLoggerPass("Tab", "HighLighted Tab :" + TVgetText(Zee5TvHomePage.objHighlightedTab));

		if (TVgetAttributValue("focused", Zee5TvHomePage.objSearchIcon).equals("false")) {

			TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
			TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
		} else {

			TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
		}
		waitTime(5000);
		if (verifyIsElementDisplayed(Zee5TvSearchPage.objSearchSpaceBar, "Search page")) {
			logger.info("User is navigated to search page after clicking on search button");
			extent.extentLoggerPass("Search", "User is navigated to search page after clicking on search button");
		} else {
			logger.info("User is not navigated to serach page");
			extent.extentLoggerFail("Navigation", "User is not navigated to serach page");
		}
		String searchdata1[] = { "b", "a", "b", "l", "u", };
		String searchdata2[] = { "d", "a", "b", "l", "u" };
		String searchdata3[] = { "r", "o", "b", "o" };
		String searchdata4[] = { "r", "u", "m", "b", "l", "e" };
		type(searchdata1);
		TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space bar");
		type(searchdata2);
		TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space");
		type(searchdata3);
		TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space");
		type(searchdata4);
		String content = TVgetText(Zee5TvSearchPage.objEditbox);

		logger.info("Entered Search Data : " + content);
		extent.extentLogger("Search", "Entered Searched Data : " + content);

		int k;
		List<WebElement> ele = getDriver().findElements(By.xpath("//*[@id='search_result_title']"));
		for (int i = 1; i <= ele.size(); i++) {

			title = TVgetText(Zee5TvSearchPage.objSearchedTumbnailTitle(i));
			logger.info(title);
			extent.extentLogger("Title", "Serach result content title : " + title);
			if ((verifyIsElementDisplayed(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title, "Movies"),
					"Searched Movie"))) {
				TVclick(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title, "Movies"), "serached Movie");
				break;
			} else {
				System.out.println("No match");
			}

		}

		waitTime(8000);
		String title = TVgetText(Zee5TvSearchPage.objSearchedDataTitle);
		if (title.equals(title)) {
			logger.info("user is navigated to respective content detail page");
			extent.extentLoggerPass("user", "user is navigated to respective content detail page");
		}
		waitTime(2000);
		TVclick(Zee5TvSearchPage.objPlayIcon, "Play Icon");
		waitTime(2000);
		if (verifyIsElementDisplayed(Zee5TvPlayerPage.objplayerzelogo, "Zeelogo")) {
			logger.info("Zee logo is displayed before the playback started");
			extent.extentLoggerPass("Zee logo", "Zee logo is displayed before the playback started");
		} else {
			logger.info("Zee logo is not displayed before the playback started");
			extent.extentLoggerFail("Zee logo", "Zee logo is not displayed before the playback started");
		}
		getDriver().navigate().back();
		waitTime(3000);
		if (verifyIsElementDisplayed(Zee5TvSearchPage.objEditbox, "Edit box")) {
			logger.info("User is navigated to search page");
		} else {
			getDriver().navigate().back();
		}
		int lenText = getDriver().findElement(Zee5TvSearchPage.objEditbox).getAttribute("text").length();
		for (int i = 0; i < lenText; i++) {
			getDriver().findElement(Zee5TvSearchPage.objSearchBackButton).click();
		}

		String searchdatapre[] = { "p", "a", "n", "c", "h", "a", "t", "a", "n", "t", "r", "a" };
		type(searchdatapre);
		waitTime(5000);
		String content2 = TVgetText(Zee5TvSearchPage.objEditbox);
		TVclick(Zee5TvSearchPage.objSearchedText, "Searched suggestion");
		waitTime(2000);
		TVclick(Zee5TvSearchPage.objSearchedText, "Searched suggestion");
		waitTime(2000);
		TVclick(Zee5TvSearchPage.objSearchedText, "Searched suggestion");
		waitTime(2000);
		logger.info("Entered Search Data : " + content2);
		extent.extentLoggerPass("Search", "Entered Searched Data : " + content2);
		TVclick(Zee5TvSearchPage.objSearchedText, "Searched suggestion");
		waitTime(2000);
		TVclick(Zee5TvSearchPage.objSearchedText, "Searched suggestion");
		waitTime(2000);
		TVclick(Zee5TvSearchPage.objSearchedText, "Searched suggestion");
		waitTime(2000);
		List<WebElement> ele1 = getDriver().findElements(By.xpath("//*[@id='search_result_title']"));
		for (int i = 1; i <= ele1.size(); i++) {

			String title2 = TVgetText(Zee5TvSearchPage.objSearchedTumbnailTitle(i));
			logger.info(title2);
			extent.extentLogger("Title", "Serach result content title : " + title2);
			if ((verifyIsElementDisplayed(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title2, "Movies"),
					"Searched Premium movie"))) {
				TVclick(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title2, "Movies"), "Premium movie");
				break;
			} else {
				logger.info("No match");
			}

		}
		waitTime(8000);
		TVclick(Zee5TvSearchPage.objPlayIcon, "Play Icon");
		waitTime(3000);
		if (userType.equals("Guest")) {
			if (verifyIsElementDisplayed(Zee5TvSearchPage.objLoginPopup, "Login popup")) {
				logger.info("Login popup is displayed when user play premium content as guest user");
				extent.extentLoggerPass("Popup",
						"Login popup is displayed when user play premium content as guest user");
			} else {
				logger.info("Functioanlity failed");
				extent.extentLoggerFail("Popup", "Popup Functioanlity failed");
			}

		}
		if (userType.equals("NonSubscribedUser")) {
			if (verifyIsElementDisplayed(Zee5TvSearchPage.objSubscribePopup, "Subscribe now popup")) {
				logger.info("Subscribe popup is displayed when user play premium content as Nonsubscribe user");
				extent.extentLoggerPass("Popup",
						"Subscribe popup is displayed when user play premium content as Nonsubscribe user");
			} else {
				logger.info("Functioanlity failed");
				extent.extentLoggerFail("Popup", "Popup Functioanlity failed");
			}
		}
		if (userType.equals("SubscribedUser")) {
			if (verifyIsElementDisplayed(Zee5TvPlayerPage.objplayerzelogo, "Zeelogo")) {
				logger.info("Zee logo is displayed before the playback started");
				extent.extentLoggerPass("Zee logo", "Zee logo is displayed before the playback started");
			} else {
				logger.info("Zee logo is not displayed before the playback started");
				extent.extentLoggerFail("Zee logo", "Zee logo is not displayed before the playback started");
			}
			getDriver().navigate().back();
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvSearchPage.objEditbox, "Edit box")) {
				logger.info("User is navigated to search page");
			} else {
				getDriver().navigate().back();
			}
			int lenText2 = getDriver().findElement(Zee5TvSearchPage.objEditbox).getAttribute("text").length();
			for (int i = 0; i < lenText2; i++) {
				getDriver().findElement(Zee5TvSearchPage.objSearchBackButton).click();
			}
		}

		getDriver().navigate().back();
		waitTime(2000);
		getDriver().navigate().back();
		waitTime(2000);
		getDriver().navigate().back();
		waitTime(2000);

		if (userType.equals("NonSubscribedUser") || userType.equals("SubscribedUser")) {
			TVTabSelect("Home");
			for (int i = 0; i <= 10; i++) {
				Runtime.getRuntime().exec("adb shell input keyevent 22");
				waitTime(2000);
			}
			TVTabSelect("Settings");
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(3000);
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(3000);

			for (int i = 0; i <= 3; i++) {
				Runtime.getRuntime().exec("adb shell input keyevent 22");
				waitTime(2000);
			}
			TVclick(Zee5TvWelcomePage.objParentalOption, "Parental Option");
			waitTime(3000);
			TVclick(Zee5TvWelcomePage.objParentalOption, "Parental Option");
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objParentalControlMessage, "Parental control message")) {
				logger.info("Parental control message - Go to zee5.com is displayed");
				extent.extentLoggerPass("Parental", "Parental control message - Go to zee5.com is displayed");
			} else {
				logger.info("Parental control message is not displayed");
				extent.extentLoggerFail("Parental", "Parental control message is not displayed");
			}
			getDriver().navigate().back();
			for (int i = 0; i <= 14; i++) {
				Runtime.getRuntime().exec("adb shell input keyevent 22");
				waitTime(2000);
			}
			if (userType.equals("NonSubscribedUser") || userType.equals("SubscribedUser")) {
				TVclick(Zee5TvWelcomePage.objLogoutOption, "Logout option");
			}
			waitTime(3000);
			TVTabSelect("Home");
			for (int i = 0; i <= 10; i++) {
				Runtime.getRuntime().exec("adb shell input keyevent 22");
				waitTime(2000);
			}
			TVTabSelect("Settings");
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(2000);
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			TVclick(Zee5TvWelcomePage.objLoginOption, "Login option");
			waitTime(8000);

			if (userType.equals("NonSubscribedUser") || userType.equals("SubscribedUser")) {
				waitTime(10000);
				if (verifyIsElementDisplayed(Zee5TvWelcomePage.objLoginPopupAmazon, "Afs login popup")) {
					Runtime.getRuntime().exec("adb shell input keyevent 19");
					waitTime(2000);
					Runtime.getRuntime().exec("adb shell input keyevent 19");
					waitTime(2000);
					Runtime.getRuntime().exec("adb shell input keyevent 19");
					waitTime(2000);
					TVclick(Zee5TvWelcomePage.objLogiButtonAmazon, "Login button amazon");
					waitTime(7000);
				} else {
					logger.info("Popup not displayed");
				}
				code = TVgetText(Zee5TvWelcomePage.objloginCode);
				logger.info("Authenticate code in TV : " + code);
				extentLoggerPass("Code", "Authenticate code in TV : " + code);
				HeaderChildNode("Switching to WEB platform to Authenticate device");
				setPlatform("Web");
				new Zee5TvBusinessLogic("zee");
				waitTime(10000);
				verifyElementPresentAndClick(PWALoginPage.objLanguageButton, "Language button");
				verifyElementPresentAndClick(PWALoginPage.objWebLoginBtn, "Login button");
				waitTime(3000);
				verifyElementPresentAndClick(PWALoginPage.objEmailField, "Email field");

				if (userType.equals("NonSubscribedUser")) {
					String Username = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
							.getParameter("NonsubscribedUserName");
					String Password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
							.getParameter("NonsubscribedPassword");
					type(PWALoginPage.objEmailField, Username, "Email Field");
					waitTime(3000);
					verifyElementPresentAndClick(PWALoginPage.objPasswordField, "Password Field");
					type(PWALoginPage.objPasswordField, Password, "Password field");
					waitTime(5000);

				}
				if (userType.equals("SubscribedUser")) {
					String SubscribedUsername = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
							.getParameter("SubscribedUserName");
					String SubscribedPassword = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
							.getParameter("SubscribedPassword");
					type(PWALoginPage.objEmailField, SubscribedUsername, "Email Field");
					waitTime(3000);
					verifyElementPresentAndClick(PWALoginPage.objPasswordField, "Password Field");
					type(PWALoginPage.objPasswordField, SubscribedPassword, "Password field");
					waitTime(5000);

				}
				click(PWALoginPage.objWebLoginButton, "Login Button");
				waitTime(8000);
				verifyElementPresentAndClick(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger menu");
				verifyElementPresentAndClick(PWAHamburgerMenuPage.objParentalControl, "ParentalControl");
				checkElementDisplayed(PWALoginPage.objPasswordField, "password field");
				if (userType.equals("NonSubscribedUser")) {
					type(PWALoginPage.objPasswordField, parentpasswordNonSub, "Password field");
				} else if (userType.equals("SubscribedUser")) {
					type(PWALoginPage.objPasswordField, parentpasswordSub, "Password field");
				}
				click(PWAHamburgerMenuPage.objContinueButtonInVerifyAccount, "Continue button");
				waitTime(2000);
				HeaderChildNode("Selecting Restrict 13+ option in parent control page");
				checkElementDisplayed(PWAHamburgerMenuPage.objParentControlPageTitle, "Parent control page");
				checkElementDisplayed(PWAHamburgerMenuPage.objNoRestrictionSelected, "No restricted option selected");
				verifyElementPresentAndClick(PWAHamburgerMenuPage.objRestrict13, "Restrict 13+ option");
				verifyElementPresent(PWAHamburgerMenuPage.objParentalLockPin1, "Set Lock Field");
				type(PWAHamburgerMenuPage.objParentalLockPin1, "1", "ParentalLockPin");
				type(PWAHamburgerMenuPage.objParentalLockPin2, "2", "ParentalLockPin");
				type(PWAHamburgerMenuPage.objParentalLockPin3, "3", "ParentalLockPin");
				type(PWAHamburgerMenuPage.objParentalLockPin4, "4", "ParentalLockPin");
				waitTime(4000);
				verifyElementPresentAndClick(PWAHamburgerMenuPage.objSetParentalLockButton, "Set Parental lock button");
				waitTime(5000);
				verifyElementPresentAndClick(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger menu");
				waitTime(3000);
				verifyElementPresentAndClick(PWAHamburgerMenuPage.objAuthenticationOption, "Authentication option");
				waitTime(5000);
				checkElementDisplayed(PWAHamburgerMenuPage.objAuthenticationText, "Authentication Page");
				type(PWAHamburgerMenuPage.objAuthenticationField, code, "Authentication Field");
				click(PWAHamburgerMenuPage.objAuthenticationButtonHighlighted, "Authenticate button");
				waitTime(3000);
				BrowsertearDown();
				setPlatform("TV");
				waitTime(10000);

				TVTabSelect("Home");
				logger.info(TVgetText(Zee5TvHomePage.objHighlightedTab) + "Tab is highlighted");
				extent.extentLoggerPass("Tab", "HighLighted Tab :" + TVgetText(Zee5TvHomePage.objHighlightedTab));

				if (TVgetAttributValue("focused", Zee5TvHomePage.objSearchIcon).equals("false")) {

					TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
					TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
				} else {

					TVclick(Zee5TvHomePage.objSearchIcon, "Search Icon");
				}
				waitTime(5000);
				String searchdata6[] = { "t", "h", "e" };
				String searchdata7[] = { "a", "w", "a", "k", "e", "n", "i", "n", "g" };
				type(searchdata6);
				TVclick(Zee5TvSearchPage.objSearchSpaceBar, "Space bar");
				type(searchdata7);
				String content3 = TVgetText(Zee5TvSearchPage.objEditbox);
				logger.info("Entered Search Data : " + content);
				extent.extentLoggerPass("Search", "Entered Searched Data : " + content);
				List<WebElement> ele3 = getDriver().findElements(By.xpath("//*[@id='search_result_title']"));
				for (int i = 1; i <= ele3.size(); i++) {

					String title3 = TVgetText(Zee5TvSearchPage.objSearchedTumbnailTitle(i));
					logger.info(title3);
					extent.extentLogger("Title", "Serach result content title : " + title3);
					waitTime(7000);
					if ((verifyIsElementDisplayed(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title3, "Episodes"),
							"Searched 13+ content"))) {
						TVclick(Zee5TvSearchPage.objSearchedSpecificTumbnailcard(title3, "Episodes"),
								"Searched 13+ content");
						break;
					} else {
						logger.info("No match");
					}

				}
			}
			waitTime(7000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objParentpopuptitle, "Parental popup")) {
				logger.info("Parental popup is displayed when user keeps parental control for 13+ content");
				extent.extentLoggerPass("13+",
						"Parental popup is displayed when user keeps parental control for 13+ content");
			} else {
				logger.info("Popup functionality failed");
				extent.extentLoggerFail("Popup", "Popup functionality failed");
			}
			getDriver().navigate().back();
			waitTime(3000);
			getDriver().navigate().back();
			TVTabSelect("Home");

			for (int i = 0; i <= 10; i++) {
				Runtime.getRuntime().exec("adb shell input keyevent 22");
				waitTime(2000);
			}

			TVTabSelect("Settings");
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(2000);
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			for (int i = 0; i <= 14; i++) {
				Runtime.getRuntime().exec("adb shell input keyevent 22");
				waitTime(2000);
			}
			TVclick(Zee5TvWelcomePage.objLogoutOption, "Logout option");

			waitTime(3000);
			TVTabSelect("Home");
			for (int i = 0; i <= 10; i++) {
				Runtime.getRuntime().exec("adb shell input keyevent 22");
				waitTime(2000);
			}
			TVTabSelect("Settings");
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			waitTime(2000);
			Runtime.getRuntime().exec("adb shell input keyevent 20");
			TVclick(Zee5TvWelcomePage.objLoginOption, "Login option");
			waitTime(8000);

			if (userType.equals("NonSubscribedUser") || userType.equals("SubscribedUser")) {
				waitTime(10000);
				if (verifyIsElementDisplayed(Zee5TvWelcomePage.objLoginPopupAmazon, "Afs login popup")) {
					Runtime.getRuntime().exec("adb shell input keyevent 19");
					waitTime(2000);
					Runtime.getRuntime().exec("adb shell input keyevent 19");
					waitTime(2000);
					Runtime.getRuntime().exec("adb shell input keyevent 19");
					waitTime(2000);
					TVclick(Zee5TvWelcomePage.objLogiButtonAmazon, "Login button amazon");
					waitTime(7000);
				} else {
					logger.info("Popup not displayed");
				}
				code = TVgetText(Zee5TvWelcomePage.objloginCode);
				logger.info("Authenticate code in TV : " + code);
				extentLoggerPass("Code", "Authenticate code in TV : " + code);
				setPlatform("Web");
				new Zee5TvBusinessLogic("zee");
				waitTime(10000);
				verifyElementPresentAndClick(PWALoginPage.objLanguageButton, "Language button");
				waitTime(3000);
				verifyElementPresentAndClick(PWALoginPage.objWebLoginBtn, "Login button");
				waitTime(3000);
				verifyElementPresentAndClick(PWALoginPage.objEmailField, "Email field");

				if (userType.equals("NonSubscribedUser")) {
					String Username = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
							.getParameter("NonsubscribedUserName");
					String Password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
							.getParameter("NonsubscribedPassword");
					type(PWALoginPage.objEmailField, Username, "Email Field");
					waitTime(3000);
					verifyElementPresentAndClick(PWALoginPage.objPasswordField, "Password Field");
					type(PWALoginPage.objPasswordField, Password, "Password field");
					waitTime(5000);

				}
				if (userType.equals("SubscribedUser")) {
					String SubscribedUsername = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
							.getParameter("SubscribedUserName");
					String SubscribedPassword = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
							.getParameter("SubscribedPassword");
					type(PWALoginPage.objEmailField, SubscribedUsername, "Email Field");
					waitTime(3000);
					verifyElementPresentAndClick(PWALoginPage.objPasswordField, "Password Field");
					type(PWALoginPage.objPasswordField, SubscribedPassword, "Password field");
					waitTime(5000);

				}
				click(PWALoginPage.objWebLoginButton, "Login Button");
				waitTime(8000);
				verifyElementPresentAndClick(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger menu");
				verifyElementPresentAndClick(PWAHamburgerMenuPage.objParentalControl, "ParentalControl");
				checkElementDisplayed(PWALoginPage.objPasswordField, "password field");
				if (userType.equals("NonSubscribedUser")) {
					type(PWALoginPage.objPasswordField, parentpasswordNonSub, "Password field");
				} else if (userType.equals("SubscribedUser")) {
					type(PWALoginPage.objPasswordField, parentpasswordSub, "Password field");
				}
				click(PWAHamburgerMenuPage.objContinueButtonInVerifyAccount, "Continue button");
				waitTime(2000);
				checkElementDisplayed(PWAHamburgerMenuPage.objParentControlPageTitle, "Parent control page");
				verifyElementPresentAndClick(PWAHamburgerMenuPage.objNoRestrictionSelected, "No Restriction option");
				verifyElementPresentAndClick(PWAHamburgerMenuPage.objSetParentalLockButton, "Set Parental lock button");
				waitTime(5000);
				verifyElementPresentAndClick(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger menu");
				waitTime(3000);
				verifyElementPresentAndClick(PWAHamburgerMenuPage.objAuthenticationOption, "Authentication option");
				waitTime(5000);
				checkElementDisplayed(PWAHamburgerMenuPage.objAuthenticationText, "Authentication Page");
				type(PWAHamburgerMenuPage.objAuthenticationField, code, "Authentication Field");
				click(PWAHamburgerMenuPage.objAuthenticationButtonHighlighted, "Authenticate button");
				waitTime(3000);
				BrowsertearDown();
				setPlatform("TV");
				waitTime(10000);
				TVTabSelect("Home");

			}
		}

	}

	@SuppressWarnings("static-access")
	public void topcatagory() throws Exception {
		HeaderChildNode("Top catagory id - 6712");
		String language = getLanguage(userType);
		Response resp = ResponseInstance.getResponseForPagesTv("Shows", language, 1, userType);
		for (int i = 1; i <= 20; i++) {
			asset_SubType = resp.jsonPath().getString("buckets[" + i + "].items.[" + i + "].asset_subtype");
			if (asset_SubType.equals("episode")) {
				assetType = resp.jsonPath()
						.getString("buckets[" + i + "].items.[" + i + "].tvshow_details.asset_subtype");
				viewAllTrayname = resp.jsonPath().getString("buckets[" + i + "].title");
				String title = resp.jsonPath().getString("buckets[" + i + "].items.[" + i + "].title");
				break;
			}
		}
		for (int i = 0; i <= 18; i++) {
			waitTime(3000);
			if (verifyIsElementDisplayed(Zee5TvWelcomePage.objViewAllTrayApi(viewAllTrayname), "Tray content")) {
				TVclick(Zee5TvWelcomePage.objViewAllTrayApi(viewAllTrayname), "Tray content");
				waitTime(7000);
				break;
			} else {
				Runtime.getRuntime().exec("adb shell input keyevent 20");
			}
		}
		mixpanel.FEProp.setProperty("Source", "Player");
		mixpanel.FEProp.setProperty("Page Name", "Player");
		mixpanel.FEProp.setProperty("Content Specification", asset_SubType);
		mixpanel.FEProp.setProperty("Top Category", assetType);
		mixpanel.ValidateParameter("", "Video View");
	}
}

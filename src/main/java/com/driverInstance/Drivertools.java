package com.driverInstance;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Stream;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.SkipException;
import com.applitools.eyes.images.Eyes;
import com.extent.ExtentReporter;
import com.propertyfilereader.PropertyFileReader;
import com.utility.Utilities;
import io.appium.java_client.AppiumDriver;

public class Drivertools {

	private String host;
	private int port;
	private String deviceName;
	private static String platform;
	private int appTimeOut;
	private String remoteUrl;
	private String appPackage;
	private String appActivity;
	private String appVersion;
	private String APkFileName;
	private PropertyFileReader handler;
	private String testName;
	private String browserType;
	private String url;
	public static String runModule;
	private URLConnection connection;
	private URL connectURL;

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public static ThreadLocal<AppiumDriver<WebElement>> tlDriver = new ThreadLocal<>();

	public static ThreadLocal<WebDriver> tlWebDriver = new ThreadLocal<>();

	public static Eyes eyes = new Eyes();

	public static ExtentReporter extent = new ExtentReporter();

	protected DesiredCapabilities capabilities = new DesiredCapabilities();

	protected Utilities util = new Utilities();

	/** The Constant logger. */
	final static Logger logger = Logger.getLogger("rootLogger");

	public static AppiumDriver<WebElement> getDriver() {
		return tlDriver.get();
	}

	public static WebDriver getWebDriver() {
		return tlWebDriver.get();
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	protected static String getPlatform() {
		return platform;
	}

	@SuppressWarnings("static-access")
	protected void setPlatfrom(String Platform) {
		this.platform = Platform;
	}

	protected int getappTimeOut() {
		return appTimeOut;
	}

	protected void setappTimeOut(int timeOut) {
		this.appTimeOut = timeOut;
	}

	protected String getremoteUrl() {
		return this.remoteUrl;
	}

	protected void setremoteUrl(String remoteUrl) {
		this.remoteUrl = remoteUrl;
	}

	protected void setAppPackage(String appPackage) {
		this.appPackage = appPackage;
	}

	protected String getAppPackage() {
		return this.appPackage;
	}

	protected void setAppActivity(String appActivity) {
		this.appActivity = appActivity;
	}

	protected String getappActivity() {
		return this.appActivity;
	}

	protected void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	protected String getAppVersion() {
		return this.appVersion;
	}

	protected String getAPKName() {
		return this.APkFileName;
	}

	protected void setAPKName(String apkName) {
		this.APkFileName = apkName;
	}

	protected PropertyFileReader getHandler() {
		return handler;
	}

	protected void setHandler(PropertyFileReader handler) {
		this.handler = handler;
	}
	
	protected void setBrowserType(String BrowserType) {
		this.browserType = BrowserType;
	}
	
	protected String getBrowserType() {
		return this.browserType;
	}
	
	protected void setURL(String url) {
		this.url = url;
	}
	
	protected String getURL() {
		return this.url;
	}
	
	@SuppressWarnings("static-access")
	protected void setRunModule(String runModule){
		this.runModule = runModule;
	}
	
	public static String getRunModule() {
		return runModule;
	}

	public Drivertools(String application) {
		setHandler(new PropertyFileReader("properties/Execution.properties"));
		setHost(getHandler().getproperty("HOST_IP"));
		setPort(Integer.parseInt(getHandler().getproperty("HOST_PORT")));
		setappTimeOut(Integer.parseInt(getHandler().getproperty("APP_TIMEOUT")));
		setremoteUrl("http://" + getHost() + ":" + getPort() + "/wd/hub");

		setHandler(new PropertyFileReader("properties/AppPackageActivity.properties"));
		setAppPackage(getHandler().getproperty(application + "Package"));
		setAppActivity(getHandler().getproperty(application + "Activity"));
		setAppVersion(getHandler().getproperty(application + "Version"));
		setAPKName(getHandler().getproperty(application + "apkfile"));
	}

	{
		setPlatfrom(Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getSuite().getName());
		setTestName(Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getName());
		setBrowserType(Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browserType"));
		setURL(Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("url"));
		setRunModule(Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("runModule"));
		try {
			connectURL = new URL("https://www.google.com");
			connection = connectURL.openConnection();
			connection.connect();
			connection.getInputStream().close();
		} catch (IOException e1) {
			System.out.println("<<<<<<---- Network is Down  ---->>>>>>>");
			System.exit(0);
		}
		
		logger.info("PlatForm :: " + getPlatform());
		
		if (Stream.of("Android", "ios", "Web", "MPWA").anyMatch(getPlatform()::equals)) {

			try {
				setHandler(new PropertyFileReader("properties/ExecutionControl.properties"));
				if (getHandler().getproperty(getTestName()).equals("Y")) {
					logger.info("Running Test :: " + getTestName());
					logger.info("Run Mode :: YES");
				} else {
					logger.info(getTestName() + " : Test Skipped");
					logger.info("RunMode is :: No");
					throw new SkipException(getTestName() + " : Test Skipped ");
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.info("RunMode is required.");
				throw new SkipException("Run mode is required...");
			}
		} else {
			throw new SkipException("PlatForm not matched...");
		}
	}

}

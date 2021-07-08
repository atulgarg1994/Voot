package com.business.zee;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.driverInstance.CommandBase;
import com.extent.ExtentReporter;
import com.propertyfilereader.PropertyFileReader;
import com.utility.LoggingUtils;
import com.utility.Utilities;
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
	}
	
	public void tearDown() {
		getWebDriver().quit();
	}
	
	public void navigateToCleverTap() throws Exception{
		HeaderChildNode("Navigating to Segment section");
		verifyElementPresentAndClick(CleverTapPage.objSegments, "Segment");
		type(CleverTapPage.objSearchField, "zee5latest@gmail.com", "Search field");
		verifyElementPresentAndClick(CleverTapPage.objFindBtn, "Find button");
		waitTime(10000);
		verifyElementPresentAndClick(CleverTapPage.objActivityBtn, "Activity button");
		
	}
	
	public void loginCleverTap() throws Exception {
		HeaderChildNode("Login Clever tap");
		type(CleverTapPage.objEmailID, "karthik.hs@igsindia.net", "email field");
		type(CleverTapPage.objPasswordEditBx, "Password@123", "email field");
		verifyElementPresentAndClick(CleverTapPage.objLoginBtn, "Login button");
	}
	
	public void getEventName() {
		HeaderChildNode("Event Name");
		waitTime(10000);
		List<WebElement> event = findElements(CleverTapPage.objEventName);
		System.out.println(event.size());
		for (int i = 0; i < event.size(); i++) {
			System.out.println(event.get(i).getText());
			if (event.get(i).getText().contains("Exit Before Ad Start")) {
				List<WebElement> eventParameter = findElements(
						By.xpath("(((.//*[@class='new_day'])[1])//td/span[1])["+(i+1)+"]//following-sibling::*[contains(@class,'label-gray')]//span"));
				for (int j = 0; j < eventParameter.size(); j++) {
					String Key = eventParameter.get(j).getAttribute("title");
					String Value = eventParameter.get(j).getText();
					System.out.println(Key+" ======= "+Value);
				}
				break;
			}
		}
	}
	
}

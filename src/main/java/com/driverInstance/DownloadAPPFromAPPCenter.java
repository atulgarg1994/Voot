package com.driverInstance;

import java.util.List;
import org.openqa.selenium.WebElement;
import com.utility.Utilities;
import com.zee5.PWAPages.AppCenterPage;

public class DownloadAPPFromAPPCenter extends Utilities{

	
	public void AppCenter(String build,String buildVersion) throws Exception {
		HeaderChildNode("App Center");
		verifyElementPresentAndClick(AppCenterPage.objMicrosoft, "Microsoft");
		type(AppCenterPage.objEmail, "ABC@igsindia.net", "Email Field");
		verifyElementPresentAndClick(AppCenterPage.objSignIn, "Next Icon");
		waitTime(4000);
		type(AppCenterPage.objPassword, "password", "Password Field");
		verifyElementPresentAndClick(AppCenterPage.objSignIn, "Next Icon");
		if (verifyElementPresent(AppCenterPage.objSignIn, "Next Icon")) {
			verifyElementPresentAndClick(AppCenterPage.objSignIn, "Next Icon");
		}
		waitTime(4000);
		if (verifyElementPresent(AppCenterPage.objMoreInformationRequiredPopUp, "More Information")) {
			click(AppCenterPage.objCancelBtn, "Cancel");
		}
		waitTime(4000);
		if (verifyElementPresent(AppCenterPage.objNoBtn, "No Icon")) {
			click(AppCenterPage.objNoBtn, "No Icon");
		}
		
		if(verifyElementPresent(AppCenterPage.objZee5AndroidHeader, "ZEE5 Android Header")) {
			if(build.equals("latest")) {
			click(AppCenterPage.objDownloadLatestReleaseBtn, "Dwonload button");
			}else {
				List<WebElement> version = findElements(AppCenterPage.objVersion);
				List<WebElement> expend = findElements(AppCenterPage.objExpandMore);
				int buildsVersion = version.size();
				for (int i = 1; i < buildsVersion; i++) {
					System.out.println(version.get(i).getText());
					if(version.get(i).getText().contains(buildVersion)) {
						expend.get(i).click();
						verifyElementPresentAndClick(AppCenterPage.objDownloadBtn,"Download button");
						break;
					}
				}
			}
		}
	}
}

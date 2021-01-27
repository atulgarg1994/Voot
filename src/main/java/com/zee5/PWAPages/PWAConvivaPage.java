package com.zee5.PWAPages;

import org.openqa.selenium.By;

public class PWAConvivaPage {
	// User name 
	public static By objUserNameField = By.xpath("//input[@id='idp-discovery-username']"); //murali.appadi@zee.esselgroup.com
	
	//Next
	public static By objNextButton = By.xpath("//input[@id='idp-discovery-submit']");
	
	//Password
	public static By objPasswordField = By.xpath("//input[@id='okta-signin-password']");//Ch@ng3m3!!
	
	//Sign In button
	public static By objSignInButton = By.xpath("//input[@id='okta-signin-submit']");
	
	//Select user type dropdown
	public static By objUserTypeDropdown = By.xpath("//button[@class='sc-fzoLsD mgdkq']");
	
	//Admin user
	public static By objAdminUser = By.xpath("//li[contains(@class,'ant-menu-item') and contains(text(),'Zee_Admin')]");
	
	//Menu button
	public static By objMenuIcon = By.xpath("//*[@id='menu-toggle']");
	
	//Viewers option
	public static By objViewersOption = By.xpath("//*[@title='Viewers']");
	
	//Viewer ID field
	public static By objViewerIDField = By.xpath("//input[@id='viewerId']");
	
	//Find Viewer button
	public static By objFindViewerButton = By.xpath("//*[@class='Btn submit' and @value='Find Viewer']");
	
	//Time duration dropdown
	public static By objTimeDurationDropdown = By.xpath("//*[contains(@class,'Btn Choice')]");
	
	//Live duration
	public static By objLiveDuration = By.xpath("//li[text()='Live']");
	
	//1 day duration
	public static By obj1DayDuration = By.xpath("//li[text()='1 day']");
	
	//7 days duration
	public static By obj7DaysDuration = By.xpath("//li[text()='7 days']");
	
	//30 days duration
	public static By obj30DaysDuration = By.xpath("//li[text()='30 days']");
	
	//Row with ContentID
	public static By objRow(String contentID) {
		return By.xpath("//*[@class='text_wrapper mx-sub-200' and contains(@title,'"+contentID+"')]");
	}
	
	//Show 
	public static By objContentShow = By.xpath("//div[@class='tag_div' and contains(@title,'show:')]");
	
	//ContentID
	public static By objContentID = By.xpath("//div[@class='tag_div' and contains(@title,'contentID:')]");
	
	//Genre
	public static By objGenre = By.xpath("//div[@class='tag_div' and contains(@title,'genre:')]");
	
	//Acess Type
	public static By objAccessType = By.xpath("//div[@class='tag_div' and contains(@title,'accessType:')]");
	
	//iFrame Pulse 4
	public static By objIframePulse4 = By.xpath("//iframe[@title='Pulse 4']");
	
	//Google search field
	public  static By objSearchEditField = By.xpath("//input[@title='Search']");
	
	//Google whats my ip suggestion
	public static By objWhatsMyIPSuggestion = By.xpath("(//div[contains(@class,'suggestions')]//span[text()='whats my ip'])[1]");
	
	//Google public IP
	public static By objPublicIP = By.xpath("(//div[@id='search']//div[@jsname='A813te']//span//span)[1]");
	
	//Manage IP Sort button
	public static By objManageIPSortButton (String ManageIPName) {
		return By.xpath("//div[text()='"+ManageIPName+"']//parent::td//parent::tr//td[@class='actions nosort']//div");
	}
	
	//Manage IP Sort bitton Edit Option
	public static By objEditIP (String ManageIPName) {
		return By.xpath("//div[text()='"+ManageIPName+"']//parent::td//parent::tr//td[@class='actions nosort']//div//ul//li[text()='Edit']");
	}
	
	//IP Address field
	public static By objIPAddressField = By.xpath("//input[@id='id_ip']");
	
	//Update button
	public static By objUpdateButton = By.xpath("//input[@value='Update']");
	
	//Filters button
	public static By objFiltersButton = By.xpath("//span[text()='Filters']");
	
	//Delete Filters
	public static By objDeleteFilters = By.xpath("//span[@title='remove item']");
	
	//Filters edit field
	public static By objFiltersEditField = By.xpath("//div[@class='field focus']//input");
	
	//For_automation filter suggestion
	public static By objForAutomationFilterSuggestion= By.xpath("//div[@class='defaultItem hover']//span//b[text()='For_Automation']");
	
	//Apply for Filter selection
	public static By objApplyFilter = By.xpath("//input[@type='submit']");
	
	//whatismyip IP Address
	public static By objIPAddress = By.xpath("//a[contains(@title,'IP address')]"); 
	
	// attempts
	public static By objAttempts = By.xpath("//*[@title='Attempts']//ancestor::div[@class='container']//div[@class='big_num']");
	
	// concurrent plays
	public static By objConcurrentPlays = By.xpath("//*[@title='Concurrent Plays']//ancestor::div[@class='container']//div[@class='big_num']");	

	// 
	public static By objAverageFrameRate = By.xpath("//*[@title='Average Frame Rate']//ancestor::div[@class='container']//div[@class='big_num']");	

	//device validation sort
	public static By objDeviceValidationSortButton = By.xpath("//*[@id='time_selector']");
	
	//device validation sort historical
	public static By objDeviceValidationSortHistorical = By.xpath("//li[text()='Historical']");
	
	//device validation sort live
	public static By objDeviceValidationSortLive = By.xpath("//li[text()='Live']");	
	
	//device validation filter
	public static By objDeviceValidationFilter = By.xpath("//*[@id='ip_selector']");
	
	//Automation filter
	public static By objDeviceValidation (String filterName) {
		return By.xpath("//li[contains(text(),'"+filterName+"')]");
	}
	
	//monitor session ID
	public static By objMonitorSessionID (String content) {
		return By.xpath("//div[contains(text(),'"+content+"')]//ancestor::tr//a");
	}
	
	//monitor session ID with Playing content
	public static By objMonitorSessionIDPlayingContent (String content) {
		return By.xpath("//div[contains(text(),'"+content+"')]//ancestor::tr//td//div[@title='Playing']//ancestor::tr//a");
	}	
	
	//monitor session ID with Played content
	public static By objMonitorSessionIDPlayedContent (String content) {
		return By.xpath("//div[contains(text(),'"+content+"')]//ancestor::tr//td//div[@title='Played']//ancestor::tr//a");
	}
	
	//monitor session ID with Started - Not Joined content 
	public static By objMonitorSessionIDStartedNotJoinedContent (String content) {
		return By.xpath("//div[contains(text(),'"+content+"')]//ancestor::tr//td//div[@title='Started - Not Joined']//ancestor::tr//a");
	}
	
	//monitor session ID with Exit Before Video Start
	public static By objMonitorSessionIDExitBeforeVideoStart (String content) {
		return By.xpath("//div[contains(text(),'"+content+"')]//ancestor::tr//td//div[@title='Exit Before Video Start']//ancestor::tr//a");
	}	
		
	//client ID
	public static By objClientID = By.xpath("//td[@data-value='Client ID']//following-sibling::td");
	
	//viewer ID
	public static By objViewerID = By.xpath("//td[@data-value='Viewer ID']//following-sibling::td");
	
	//Video Startup Time
	public static By objVST = By.xpath("//td[@data-value='Video Startup Time']//following-sibling::td");
	
	//Avg % Complete
	public static By objAvgPercentageComplete = By.xpath("//td[@data-value='Average % Complete']//following-sibling::td");
	
	//Total Playing Time
	public static By objTotalPlayingTime = By.xpath("//td[@data-value='Total Playing Time']//following-sibling::td");
	
	//Session
	public static By objSessionStatus = By.xpath("//td[@data-value='Session Status']//following-sibling::td");
	
	//search filter field
	public static By objSearchFilterField = By.xpath("//input[@type='search']");
	
	//filters sort button
	public static By objFiltersSortButton = By.xpath("//div[@title='For_Automation']//ancestor::tr//td[@class='actions nosort']");
	
	//filters Edit option
	public static By objFiltersEditButton = By.xpath("//li[text()='Edit']");
	
	//Client ID value field
	public static By objClientIDVlaueField = By.xpath("//input[@class='val_field']");
	
	//Save Filter button
	public static By objSaveFilterButton = By.xpath("//input[@value='Save']");
	
	//Ad UI
	public static By objAdUi= By.xpath("//div[@class='timeDuration-Container']");
	
	//Ad Frame
	public static By objAdFrame= By.xpath("//iframe[@allow]");
	
	//CDN
	public static By objCDN = By.xpath("//td[@data-value='CDN']//following-sibling::td");

	//Bowser version
	public static By objChromeVersionFromChrome = By.xpath("//td[@class='version' and @id='version']//span");
	
	//System OS 
	public static By objSystemOSFromChrome = By.xpath("//td[@class='version' and @id='os_type']//span");

	//System OS version
	public static By objSystemOSVersionFromChrome = By.xpath("//td[@class='version' and @id='os_type']//span[@id='os_version']");
	
	//User Agent
	public static By objUserAgentFromChrome = By.xpath("//td[@id='useragent']");
	
	//Browser name
	public static By objBrowserName = By.xpath("//td[@data-value='Browser Name']//following-sibling::td");
	
	//Browser Version
	public static By objBrowserVersion = By.xpath("//td[@data-value='Browser Version']//following-sibling::td");

	//Device Hardware Type
	public static By objDeviceHardwareType = By.xpath("//td[@data-value='Device Hardware Type']//following-sibling::td");

	//Device Operating System
	public static By objDeviceOS = By.xpath("//td[@data-value='Device Operating System']//following-sibling::td");
		
	//Device Operating System Family
	public static By objDeviceOSFamily = By.xpath("//td[@data-value='Device Operating System Family']//following-sibling::td");
	
	//Device Operating System Version
	public static By objDeviceOSVersion = By.xpath("//td[@data-value='Device Operating System Version']//following-sibling::td");
	
	//Player Framework Name
	public static By objPlayerFrameworkName = By.xpath("//td[@data-value='Player Framework Name']//following-sibling::td");

	//Asset Name
	public static By objAssetName = By.xpath("//td[@data-value='Asset Name']//following-sibling::td");

	//Asset Duration
	public static By objAssetDuration = By.xpath("//td[@data-value='Content Length']//following-sibling::td");
	
	//Content Type
	public static By objContentType = By.xpath("//td[@data-value='ContentType']//following-sibling::td");
	
	//device
	public static By objDevice = By.xpath("//td[@data-value='DEVICE']//following-sibling::td");
	
	//Zee5 App Version
	public static By objAppVersion = By.xpath("//td[@data-value='appVersion']//following-sibling::td");
	
	//audio language
	public static By objAudioLanguage = By.xpath("//td[@data-value='audioLanguage']//following-sibling::td");
	
	//category
	public static By objCategory = By.xpath("//td[@data-value='category']//following-sibling::td");
	
	//contentID
	public static By objContentIDC = By.xpath("//td[@data-value='contentID']//following-sibling::td");
	
	//episodeName
	public static By objEpisodeName = By.xpath("//td[@data-value='episodeName']//following-sibling::td");
	
	//episodeNumber
	public static By objEpisodeNumber = By.xpath("//td[@data-value='episodeNumber']//following-sibling::td");
	
	//genre
	public static By objGenreC = By.xpath("//td[@data-value='genre']//following-sibling::td");
	
	//originalLanguage
	public static By objOriginalLang = By.xpath("//td[@data-value='originalLanguage']//following-sibling::td");
	
	//pubDate
	public static By objPubDate = By.xpath("//td[@data-value='pubDate']//following-sibling::td");
	
	//rootID
	public static By objRootID = By.xpath("//td[@data-value='rootID']//following-sibling::td");
	
	//show
	public static By objShow = By.xpath("//td[@data-value='show']//following-sibling::td");
	
	//site
	public static By objSite = By.xpath("//td[@data-value='site']//following-sibling::td");
	
	//userAgent
	public static By objUserAgent = By.xpath("//td[@data-value='userAgent']//following-sibling::td");
	
	//episode number zee5
	public static By objEpisodeNumberZee = By.xpath("//div[@class='metaInfo']//p");
}
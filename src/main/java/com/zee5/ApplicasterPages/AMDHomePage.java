package com.zee5.ApplicasterPages;

import org.openqa.selenium.By;

//-- Dev by Kushal

public class AMDHomePage {

	// ZEE5 Logo
	public static By objZee5Logo = By.xpath("//*[@contentDescription='LOGO']");

	// Subscribe Teaser
	public static By objSubscribeTeaser = By.xpath("//*[@text='SUBSCRIBE']");

	public static By objGetPremium = By.xpath("//*[@id='get_premium_hero_component']");

	public static By objLogout = By.xpath("//*[@resource-id='com.graymatrix.did:id/list_item' and @text='Logout']");

	public static By objLogoutPopUpLogoutButton = By.xpath("//*[@resource-id='com.graymatrix.did:id/logoutButton']");

	// Banner ad
	public static By objBannerAd = By.xpath("//*[@id='adTag' and @text='AD']");

	public static By objEditProfile = By.xpath("//*[@resource-id='com.graymatrix.did:id/txt_edit_profile']");

	// Premium tag on the content cards
	public static By objPremiumTag = By.xpath("(//*[@id='special_image_1'])[1]");

	public static By objContentCard = By.xpath("//*[@id='item_image']");

	public static By objPageTitle(String title) {
		return By.xpath("//*[@id='title' and contains(text(),'" + title + "')]");
	}

	public static By objadTag = By.xpath("//*[@id='adTag']");

	// Added objects by Shree Nidhi
	public static By objMoreMenuOptions(String OptionName) {
		return By.xpath("//*[@resource-id='com.graymatrix.did:id/list_item' and @text='" + OptionName + "']");
	}

	public static By objSubscribeNowInMySubscription = By
			.xpath("//*[@resource-id='com.graymatrix.did:id/btn_subscribe_now']");

	public static By objSubscribeNowInMyTransaction = By.xpath("//*[@resource-id='com.graymatrix.did:id/btn_sub_now']");
	public static By objPackAmount = By.xpath("//*[@resource-id='com.graymatrix.did:id/pack_amount']");
	public static By objCancelRenewal = By.xpath("//*[@resource-id='com.graymatrix.did:id/cancel_renewal']");
	public static By objBrowseAllPack = By.xpath("//*[@resource-id='com.graymatrix.did:id/btn_browse_packs']");
	public static By objMyProfileIcon = By.xpath("//*[@resource-id='com.graymatrix.did:id/iconSmile']");
	public static By objGetPremiumPopUP = By.xpath("//*[@resource-id='com.graymatrix.did:id/popup_title']");
	public static By objGetPremiumPopUPProceedButton = By.xpath("//*[@resource-id='com.graymatrix.did:id/proceed']");

	/**
	 * Sushma
	 */
	// Carousel unit as a 1st unit in the page
	public static By objCarouselUnit = By.xpath(
			"(//*[@resource-id='com.graymatrix.did:id/tabLayout']/following-sibling::*/child::*/child::*/child::*/child::*)[1]");

	public static By objCarouselPlayIconContentCard = By.xpath(
			"//*[@resource-id='com.graymatrix.did:id/playImage']/preceding-sibling::*[@resource-id='com.graymatrix.did:id/item_primary_text']");


	public static By objCloseIconOfFirstContentOfCWTray = By
			.xpath("(//*[@resource-id='com.graymatrix.did:id/item_remove'])[1]");
	public static By objLeftTimeOfFirstContentOfCWTray = By
			.xpath("(//*[@resource-id='com.graymatrix.did:id/time_progress'])[1]");
	public static By objProgressBarOfFirstContentOfCWTray = By
			.xpath("(//*[@resource-id='com.graymatrix.did:id/progress_bar'])[1]");

	public static By objTrendingNowTray = By.xpath("//*[@text='Trending Now']");
	public static By objTrendingOnZee5Tray = By.xpath("//*[@text='Trending on Zee5']");

	public static By objCarouselUnitwithmastHeadAdbanner = By.xpath(
			"(//*[@resource-id='com.graymatrix.did:id/tabLayout']/following-sibling::*/child::*/child::*/child::*/child::*)[2]");

	public static By objCarouselUnitwhenNomastHeadAdbanner = By.xpath(
			"(//*[@resource-id='com.graymatrix.did:id/tabLayout']/following-sibling::*/child::*/child::*/child::*/child::*)[1]");

	public static By objContentTitleOfCWTray(String title) {
		return By.xpath(
				"//*[@text='Continue Watching']/parent::*/parent::*/following-sibling::*/child::*/child::*/child::*/following-sibling::*[@text=\""
						+ title + "\"]");
	}

	public static By objTab1 = By.xpath("(//*[@resource-id='com.graymatrix.did:id/title'])[1]");

	public static By objTab5 = By.xpath("(//*[@resource-id='com.graymatrix.did:id/title'])[5]");

	public static By objSubscribePopUpInConsumptionPage = By
			.xpath("//*[@resource-id='com.graymatrix.did:id/popup_title' and @text='Subscribe']");

	public static By objSubscribePopup = By.xpath("//*[@resource-id='com.graymatrix.did:id/popup_title']");
	public static By objPauseIconOnPlayerScreen = By.xpath("//*[@resource-id='com.graymatrix.did:id/icon_pause']");
	public static By objOpenWithDevicePopUp = By.xpath("//*[@text='Open with']");
	public static By objAdBannerAboveCarousel = By
			.xpath("//*[@resource-id='com.graymatrix.did:id/ad_image']//following::*[@id='indicator']");
	public static By objMaximizeIcon = By.xpath("//*[@resource-id='com.graymatrix.did:id/icon_fullscreen']");

	public static By objKidsContentCard = By.xpath("//*[@id='header_primary_text']//following::*[6]");

	public static By BeforeTVTrayTitle = By
			.xpath("(//*[@id='header_primary_text' and  contains(text(),'Premiere Episodes | Before Zee')])[1]");


	public static By objBottomNavigation(String tabName) {
		return By.xpath("//*[@id='bb_bottom_bar_title' and @text='" + tabName + "']");
	}

	public static By objCWTrayContent = By.xpath(
			"(//*[@text='Continue Watching']/parent::*/parent::*/following-sibling::*/child::*/child::*/child::*/following-sibling::*)[1]");

	public static By objRemoveItem = By.xpath("(//*[@id='item_remove'])[1]");
	
	public static By objSearchinUpcoming = By.xpath("//*[@id='toolbar']//child::*//child::*[1]");
	
	public static By objFirstThumbnailOfTray = By.xpath("(//*[@resource-id='com.graymatrix.did:id/horizontal_list_1_parent'])[1]");
	public static By objFirstViewAllbtn = By.xpath("(//*[@resource-id='com.graymatrix.did:id/header_arrow'])[1]");
	public static By objContent = By.xpath("(//*[@resource-id='com.graymatrix.did:id/item_image'])[2]");
	public static By objGetPremiumButtonOnPremiumContent = By.xpath("(//*[@resource-id='com.graymatrix.did:id/special_image_1'])[1]/following-sibling::*[@text='Get Premium' or @text='GET PREMIUM']");

	// SugarBox Icon
	public static By objSboxIcon = By.xpath("//*[@id='sbox_icon']");
	
	public static By objCarouselContentTitle(String title) {
		return By.xpath("//*[@resource-id='com.graymatrix.did:id/hero_1_cell_parent']/child::*[@resource-id='com.graymatrix.did:id/item_primary_text' and @text='"+title+"']");
	}

	// Top Menu Navigation tabs
	public static By objMoviesTab = By.xpath("//*[@id='title' and @text='Movies'] | //*[@text='Movies']");
	public static By objShowsTab = By.xpath("//*[@id='title' and @text='Shows'] | //*[@text='Shows']");
	public static By objNewsTab = By.xpath("//*[@id='title' and @text='News'] | //*[@text='News']");
	public static By objFreeMoviesTab = By.xpath("//*[@id='title' and @text='Free Movies'] | //*[@text='Club']");
	public static By objPremiumTab = By.xpath("//*[@id='title' and @text='Premium'] | //*[@text='Premium']");
	public static By objKidsTab = By.xpath("//*[@id='title' and @text='Kids'] | //*[@text='Eduauraa']");
	public static By objMusicTab = By.xpath("//*[@id='title' and @text='Music'] | //*[@text='Music']");
	public static By objLiveTvTab = By.xpath("//*[@id='title' and @text='Live TV'] | //*[@text='Live TV']");
	public static By objZee5OriginalsTab = By
			.xpath("//*[@id='title' and @text='ZEE5 Originals'] | //*[@text='ZEE5 Originals']");

	public static By objUpcoming = By
			.xpath("(//*[@text='Upcoming']//parent::*)[1] | (//*[@id='navigationIconView'])[2]");
	
	public static By objMoreMenu = By.xpath("(//*[@text='More']//parent::*)[1] | (//*[@id='navigationIconView'])[5]");
     	
    public static By objHomeTab = By.xpath("//*[@id='title' and @text='Home'] | (//*[@id='title' or @text='Home'])[1]");
    
    public static By objGetPremiumCTAOnCarosel = By.xpath("//*[@resource-id='com.graymatrix.did:id/subscribeButton']");
    public static By objGetClubInConsumptionScreen = By.xpath("//*[@resource-id='com.graymatrix.did:id/subscribeButton']");
    public static By objSearchBtn = By.xpath("//*[@resource-id='com.graymatrix.did:id/home_toolbar_search_icon']");
    public static By objBeforeTVTray = By.xpath("//*[@resource-id='com.graymatrix.did:id/cell_top_container']/child::*[contains(text(),'Before')]");
    public static By objBeforeTVContent = By.xpath("(//*[@resource-id='com.graymatrix.did:id/cell_bottom_container'])[1]");
		
    public static By objHome = By.xpath("//*[@id='navigationTitleTextView' and @text='Home']");
    
    public static By objPlayerScreen = By.xpath("//*[@resource-id='com.graymatrix.did:id/player_root'] | //*[@id='homeTabPageRecyclerView']");
    public static By objSelectedTab = By.xpath("//*[@id='homeTabLayout']//*[@class='android.widget.LinearLayout' and @selected='true']//child::*");

    public static By objTopNav_HomeTab = By.xpath("//*[@resource-id='com.graymatrix.did:id/homeTabLayout']/child::*/child::*/child::*[@text='Home']");

    // Bottom Navigation TEXT Buttons
 	public static By objHomeBtn = By.xpath("(//*[@id='bb_bottom_bar_title'])[1] | (//*[@id='navigationTitleTextView'])[1]");
 	public static By objUpcomingBtn = By.xpath("(//*[@id='bb_bottom_bar_title'])[2] | (//*[@id='navigationTitleTextView'])[2]");
 	public static By objDownloadBtn = By.xpath("(//*[@id='bb_bottom_bar_title'])[3] | (//*[@id='navigationTitleTextView'])[4]");
 	public static By objMoreMenuBtn = By.xpath("(//*[@id='bb_bottom_bar_title'])[5] | (//*[@id='navigationTitleTextView'])[5]");

 // Bottom Navigation ICONS
 	public static By HomeIcon = By.xpath("(//*[@id='bb_bottom_bar_icon'])[1] | (//*[@id='navigationIconView'])[1]");
 	public static By UpcomingIcon = By.xpath("(//*[@id='bb_bottom_bar_icon'])[2] |(//*[@id='navigationIconView'])[2]");
 	public static By DownloadIcon = By.xpath("(//*[@id='bb_bottom_bar_icon'])[3] | (//*[@id='navigationIconView'])[4]");
 	public static By MoreMenuIcon = By.xpath("(//*[@id='bb_bottom_bar_icon'])[5] | (//*[@id='navigationIconView'])[5]");
 	
 	public static By objDownload = By.xpath("(//*[@text='Downloads']//parent::*)[1] | (//*[@id='navigationIconView'])[4]");
 	
 	public static By objBeforeTVViewAllArraowIcon = By.xpath(
			"(//*[@id='header_primary_text' and contains(text(),'Premiere Episodes | Before Zee')]//parent::*[@class='android.view.ViewGroup']//*[@id='header_arrow'])[1] | //*[contains(text(),'Premiere Episodes | Before')]/parent::*//*[@text='a']");

	public static By objViewAllScreen = By.xpath(
			"//*[@id='title' and contains(text(),'Premiere Episodes | Before Zee')] | //*[contains(text(),'Premiere Episodes | Before Zee')]");

	public static By objFirstContentOfBeforeTvTray = By.xpath(
			"(//*[@id='header_primary_text' and  contains(text(),'Premiere Episodes | Before Zee')]//following::*)[4] | (//*[contains(text(),'Premiere Episodes | Before Zee')]//following::*)[4]");

	public static By objTitle = By.xpath(
			"(//*[@id='homeTabLayout']/*/child::*) | //*[@id='collectionToolBar'] | //*[@id='railDialogToolBar']");

	public static By objViewAllBtn(String trayName) {
		return By.xpath("//*[contains(text(),'" + trayName
				+ "')]//following::*[@id='header_arrow'][1] | (//*[@id='cell_top_container']//parent::*[@text='"
				+ trayName + "']//following::*[@text='a'])[1]");
	}
	public static By objLandingScreen = By.xpath("//*[@id='home_toolbar_title']");

	public static By objBackIcon = By.xpath("//*[@id='action_icon'] | //*[@id='collectionToolBarBackButton']");

	public static By objFirstChannelCard = By.xpath("(//*[@id='item_primary_text'])[1] | (//*[@id='cell_center_container']//*[@class='android.widget.ImageView'])[1]");

	public static By objCarouselTitle = By.xpath("//*[@id='item_primary_text'] | (//*[@id='cell_top_container'])[1]/following-sibling::*[@resource-id='com.graymatrix.did:id/cell_center_container']/child::*[@index='0']");

	public static By objLoginButtonOnPlayerscreen = By.xpath("//*[@id='errorViewButton' and @text='Login']");
	public static By objSubscribeIcon = By.xpath("//*[@id='home_subscribe_text_view']");
	
	public static By objCarouselDots = By.xpath("(//*[@resource-id='com.graymatrix.did:id/cell_top_container'])[1]/parent::*/parent::*/parent::*/following-sibling::*");
	public static By objCarouselConetentCard = By.xpath("((//*[@resource-id='com.graymatrix.did:id/cell_top_container'])[1]/child::*)[1]");
	public static By objCarouselTitle1 = By.xpath("(//*[@id='cell_top_container'])[1]/following-sibling::*[@resource-id='com.graymatrix.did:id/cell_center_container']/child::*[@index='0']");
	public static By objCarouselTitle2 = By.xpath("(//*[@id='cell_top_container'])[1]/following-sibling::*[@resource-id='com.graymatrix.did:id/cell_center_container']/child::*[@enabled='true']");
	public static By objCarouselTitle3 = By.xpath("(//*[@id='cell_top_container'])[1]/following-sibling::*[@resource-id='com.graymatrix.did:id/cell_center_container']/child::*[@onScreen='true']");
	public static By objPlayBtn = By.xpath("//*[@resource-id='com.graymatrix.did:id/outlinedButton']");
	public static By objPremiumBtn = By.xpath("//*[@resource-id='com.graymatrix.did:id/subscribeButton']");
	public static By objContentTitle(String title) {
			return By.xpath("(//*[@resource-id='com.graymatrix.did:id/cell_top_container'])[1]/following-sibling::*[@resource-id='com.graymatrix.did:id/cell_center_container']/child::*[@text='"+title+"']");
		}
	public static By objConsumptionScreenTitle = By.xpath("//*[@resource-id='com.graymatrix.did:id/content_title']");
	public static By objWatchTrailerIconOnPlayerscreen = By.xpath("//*[@resource-id='com.graymatrix.did:id/contentWatchTrailer']");
	public static By objTrayTitle(String text) {
			return By.xpath("//*[contains(text(), '"+text+"')]");
		}
	public static By objContinueWatchingTray = By.xpath("//*[@text='Continue Watching']");
	public static By objContinueWatchingTrayContentCard = By.xpath("(//*[@text='Continue Watching']/parent::*/following-sibling::*/child::*/child::*/child::*/child::*/child::*/child::*[@index='0'])[1]");
	public static By objProgressBarOfFirstContentOfCWTray(int i) {
		  return By.xpath("(//*[@text='Continue Watching']/parent::*/following-sibling::*/child::*/child::*/child::*/child::*/child::*/child::*[@index='3'])["+i+"]");
		}
	
	public static By objNoThanksPlayStore = By.xpath("//*[@text='No Thanks' or @text='NO THANKS' or @text='no thanks']");
	public static By objHighlightedTab (String tab) {
		return By.xpath("//*[@resource-id='com.graymatrix.did:id/homeTabLayout']//*[@text='"+tab+"' and @selected='true']");
	}
	
	public static By objRailName(String railName) {
		return By.xpath("(//*[contains(text(),'"+ railName +"')]//following::*[@text='a']//parent::*//child::*[1])[@text='"+ railName +"']");
	}
	
	public static By objGetPremiumCTAOnCarousel = By.xpath("//*[@resource-id='com.graymatrix.did:id/subscribeButton']");

	
	public static By objListingScreen = By.xpath("//*[@resource-id='com.graymatrix.did:id/zee5_collection_framelayout']");
	
	public static By objBottomBarSelectedHomeTab = By.xpath("//*[@resource-id='com.graymatrix.did:id/bottom_navigation_view']/child::*/child::*/child::*[@text='Home' and @selected='true']");

	
	}
package com.zee5.ApplicasterPages;

import org.openqa.selenium.By;

//-- Dev by Kushal

public class AMDHomePage {

			// ZEE5 Logo
			public static By objZee5Logo = By.xpath("//*[@contentDescription='LOGO']");

			// Subscribe Teaser
			public static By objSubscribeTeaser = By.xpath("//*[@text='SUBSCRIBE']");

			// Search Button
			public static By objSearchBtn = By.xpath("//*[@class='android.support.v7.widget.LinearLayoutCompat']//*[@class='android.widget.ImageView']");
			public static By objTitle = By.xpath("//*[@id='title']");
			
			// Bottom Navigation TEXT Buttons
			public static By objHomeBtn = By.xpath("(//*[@id='bb_bottom_bar_title'])[1]");
			public static By objUpcomingBtn = By.xpath("(//*[@id='bb_bottom_bar_title'])[2]");
			public static By objDownloadBtn = By.xpath("(//*[@id='bb_bottom_bar_title'])[3]");
			public static By objMoreMenuBtn = By.xpath("(//*[@id='bb_bottom_bar_title'])[4]");
			
			
			// Bottom Navigation ICONS
			public static By HomeIcon = By.xpath("(//*[@id='bb_bottom_bar_icon'])[1]");
			public static By UpcomingIcon = By.xpath("(//*[@id='bb_bottom_bar_icon'])[2]");
			public static By DownloadIcon = By.xpath("(//*[@id='bb_bottom_bar_icon'])[3]");
			public static By MoreMenuIcon = By.xpath("(//*[@id='bb_bottom_bar_icon'])[4]");
			
			public static By objHome = By.xpath("(//*[@text='Home']//parent::*)[1]");
			public static By objUpcoming = By.xpath("(//*[@text='Upcoming']//parent::*)[1]");
			public static By objDownload = By.xpath("(//*[@text='Downloads']//parent::*)[1]");
			public static By objMoreMenu = By.xpath("(//*[@text='More']//parent::*)[1]");
			
			public static By objLogout = By.xpath("//*[@resource-id='com.graymatrix.did:id/list_item' and @text='Logout']");
			
			public static By objLogoutPopUpLogoutButton = By.xpath("//*[@resource-id='com.graymatrix.did:id/logoutButton']");
			// Top Menu Navigation tabs
			public static By objHomeTab = By.xpath("//*[@id='title' and @text='Home']");
			public static By objMoviesTab = By.xpath("//*[@id='title' and @text='Movies']");
			public static By objShowsTab = By.xpath("//*[@id='title' and @text='Shows']");
			public static By objNewsTab = By.xpath("//*[@id='title' and @text='News']");
			public static By objFreeMoviesTab = By.xpath("//*[@id='title' and @text='Free Movies']");
			public static By objPremiumTab = By.xpath("//*[@id='title' and @text='Premium']");
			public static By objKidsTab = By.xpath("//*[@id='title' and @text='Kids']");
			public static By objMusicTab = By.xpath("//*[@id='title' and @text='Music']");
			public static By objLiveTvTab = By.xpath("//*[@id='title' and @text='Live TV']");
			public static By objZee5OriginalsTab = By.xpath("//*[@id='title' and @text='ZEE5 Originals']");
			
			// Banner ad
			public static By objBannerAd = By.xpath("//*[@id='adTag' and @text='AD']");
			
			public static By objEditProfile = By.xpath("//*[@resource-id='com.graymatrix.did:id/txt_edit_profile']");
			
			//Premium tag on the content cards
			public static By objPremiumTag = By.xpath("(//*[@id='special_image_1'])[1]");

			public static By objContentCard = By.xpath("//*[@id='item_image']");
			public static By objBackIcon = By.xpath("//*[@id='action_icon']");
			
			// Play Button On carousel
			public static By objPlayBtn = By.xpath("//*[@id='playImage']");

			// Premium button
			public static By objGetPremium = By.xpath("//*[@id='getPremiumButton']");
			
			public static By objContentTitle(String title) {
				return By.xpath("//*[@id='item_primary_text'and @text='"+title+"']");	
			}
			
			// Tray Tile
			public static By objTrayTitle(String text) {
				return By.xpath("//*[@id='header_primary_text' and contains(text(),\""+ text +"\")]");
			}
			
			// Select view all button from trayTile
			public static By objViewAllBtn(String trayName) {
				return By.xpath("//*[contains(text(),'"+trayName+"')]//following::*[@id='header_arrow'][1]");
			}
			
			public static By objPageTitle(String title) {
				return By.xpath("//*[@id='title' and contains(text(),'"+ title +"')]");
			}
			public static By objadTag = By.xpath("//*[@id='adTag']");
			
			//Added objects by Shree Nidhi
			public static By objMoreMenuOptions(String OptionName) {
				return By.xpath("//*[@resource-id='com.graymatrix.did:id/list_item' and @text='" + OptionName + "']");
			}

			public static By objSubscribeNowInMySubscription = By
					.xpath("//*[@resource-id='com.graymatrix.did:id/btn_subscribe_now']");

			public static By objSubscribeNowInMyTransaction = By
					.xpath("//*[@resource-id='com.graymatrix.did:id/btn_sub_now']");
			public static By objPackAmount = By.xpath("//*[@resource-id='com.graymatrix.did:id/pack_amount']");
			public static By objCancelRenewal = By.xpath("//*[@resource-id='com.graymatrix.did:id/cancel_renewal']");
			public static By objBrowseAllPack = By.xpath("//*[@resource-id='com.graymatrix.did:id/btn_browse_packs']");
			public static By objMyProfileIcon = By.xpath("//*[@resource-id='com.graymatrix.did:id/iconSmile']");
			public static By objGetPremiumCTAOnCarosel = By.xpath("//*[@resource-id='com.graymatrix.did:id/getPremiumButton']");
			public static By objBeforeTVTray = By
					.xpath("//*[@resource-id='com.graymatrix.did:id/header_primary_text' and contains(text(),'Before TV')]");
			public static By objGetPremiumPopUP = By.xpath("//*[@resource-id='com.graymatrix.did:id/popup_title']");
			public static By objGetPremiumPopUPProceedButton = By.xpath("//*[@resource-id='com.graymatrix.did:id/proceed']");
			public static By objBeforeTVContent = By.xpath("(//*[@resource-id='com.graymatrix.did:id/item_image'])[2]");
			
/**
 * Sushma
 */
			
			//Selected tab
			public static By objSelectedTab = By.xpath("//*[@resource-id='com.graymatrix.did:id/title' and @selected='true']");
			//Carousel title
			public static By objCarouselTitle1 = By.xpath("//*[@resource-id='com.graymatrix.did:id/item_primary_text' and @onScreen='true']");
			public static By objCarouselTitle2 = By.xpath("//*[@resource-id='com.graymatrix.did:id/item_image']//following-sibling::*[@id='item_primary_text']");
			public static By objCarouselTitle3 = By.xpath("//*[@resource-id='com.graymatrix.did:id/pager']//*[@id='item_primary_text']");
			//Carousel dots
			public static By objCarouselDots = By.xpath("//*[@resource-id='com.graymatrix.did:id/indicator']/child::*");
			
			public static By objCarouselConetentCard = By.xpath("//*[@resource-id='com.graymatrix.did:id/hero_1_cell_parent']");
			
	//Consumption screen title
			public static By objConsumptionScreenTitle = By.xpath("//*[@resource-id='com.graymatrix.did:id/item_primary_text']");
			
			
}

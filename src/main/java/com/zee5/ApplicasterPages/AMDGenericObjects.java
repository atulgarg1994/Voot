package com.zee5.ApplicasterPages;

import org.openqa.selenium.By;

//-- Dev by Kushal
public class AMDGenericObjects {

	//Check Screen Title displayed
	public static By objCheckTitle(String title) {
		return By.xpath("//*[@id='screen_title' and @text='"+title+"']");
	}
	
	//Get Screen title across all screen
	public  static By objgetScreenTitle  = By.xpath("//*[@id='screen_title']");
	
	//Verifying page title displayed
	public static By objScreenTitleName(String title) {
		return By.xpath("//*[@id='screen_title' and @text='"+title+"']");
	}
	
	//Back button
	public static By objBackBtn = By.xpath("//*[@id='icon_back']");
	
	//Device Backout button
	public static By objDeviceBackBtn = By.xpath("//*[@resource-id='com.android.systemui:id/back']");
	
	//Text object
	public static By objText(String text) {
		return By.xpath("//*[@text='"+text+"']");
	}
	
	// Tray Tile
	public static By objTrayTitle(String text) {
			return By.xpath("//*[@id='header_primary_text' and contains(text(),\""+ text +"\")]");
	}
				
	// Select view all button from trayTile
	public static By objViewAllBtn(String trayName) {
			return By.xpath("//*[contains(text(),'"+trayName+"')]//following::*[@id='header_arrow'][1]");
	}
	
	public static By objHideKeyboard = By.xpath("//*[@id='hide_btn']");
	

	public static By objCloseInterstitialAd = By.xpath("//*[@contentDescription='Interstitial close button'] | //*[@content-desc='Interstitial close button']");
}

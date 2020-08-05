package com.zee5.ApplicasterPages;

import org.openqa.selenium.By;

public class AMDLiveTVScreen {

	
	public static By objChannelGuide = By.xpath("//*[@resource-id='com.graymatrix.did:id/title' and @text='Channel Guide']");
	
	public static By objTray(String trayName) {
		return By.xpath("//*[@resource-id='com.graymatrix.did:id/header_primary_text' and @text='"+trayName+"']");
	}
	
	public static By objChannelLogo = By.xpath("//*[@resource-id='com.graymatrix.did:id/item_image']");
	
	public static By objSubscribeIcon = By.xpath("//*[@resource-id='com.graymatrix.did:id/subscribeiconlayout']");
	
}

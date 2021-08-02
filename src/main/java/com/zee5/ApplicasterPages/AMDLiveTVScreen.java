package com.zee5.ApplicasterPages;

import org.openqa.selenium.By;

public class AMDLiveTVScreen {

	
	public static By onjLiveTvToggle = By.xpath("(//*[@text='Live TV'])[2]");
	
	public static By objTimeFrame = By.xpath("//*[@id='tvsubTitle']");
	
	public static By objChannelLogo = By.xpath("//*[@resource-id='com.graymatrix.did:id/img_channel']");
	
	public static By objFirstContentCardOfFreeChannelsTray = By.xpath("(//*[@text='FREE Channels']/parent::*/parent::*/following-sibling::*/child::*/child::*/child::*/child::*)[1]");

	public static By objLoadingIcon = By.id("compoiste_progress_bar");
	
	public static By objFirstContentCardUnderFreeChannelsTray = By.xpath("(//*[@text='FREE Channels']//following::*[@id='item_primary_text'])[1]");
	
	public static By objChannelGuide = By.xpath("//*[@class='android.widget.TextView' and @text='Channel Guide']");
	public static By objContentInLiveTV = By.xpath("//*[@id='cell_top_container']");
	public static By objImageIcon = By.xpath("(//*[@id='cell_center_container']//*[@class='android.widget.ImageView'])[1]");
	public static By objFirstContent = By.xpath("(//*[@id='cell_center_container']//*[@class='android.widget.ImageView'])[1]");
	public static By objLiveTV = By.xpath("//*[@id='playerLiveText']");
	public static By objTray(String trayName) {
			return By.xpath("//*[@id='cell_top_container']//*[@text='"+ trayName +"']");
		} 
	
	public static By objSubscribeIcon = By.xpath("//*[@id='home_subscribe_text_view'] | //*[@id='home_toolbar_buy_plan']");
	
	public static By objLiveTVFirstContentCard = By.xpath("(//*[@id='cell_center_container' and (./preceding-sibling::* | ./following-sibling::*)]//*[@class='android.widget.ImageView'])[1]");
}

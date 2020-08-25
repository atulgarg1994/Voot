package com.zee5.ApplicasterPages;

import org.openqa.selenium.By;

public class AMDSettingsScreen {
	
	public static By objSelectVideoQualityLabel = By.xpath("//*[@id='selector_screen_title']");
	public static By objVideoQualityBest = By.xpath("//*[@text='Best']");
	public static By objVideoQualityBetter = By.xpath("//*[@text='Better']");
	public static By objVideoQualityGood = By.xpath("//*[@text='Good']");
	public static By objVideoQualityDatasaver = By.xpath("//*[@text='Datasaver']");
	public static By objVideoQualityAskEachTime = By.xpath("//*[@text='Ask each time']");
	public static By objXButton = By.xpath("//*[@text='D']");
	public static By objTickMark = By.xpath("//*[@id='selectionImageSelector']");
	public static By objDownloadOverWifiToggle = By.xpath("//*[@id='downloadOverWifiSwitch']");
	
	public static By objSettingsScreenTitle = By.xpath("//*[@id='screen_title' and //*[@text='Settings']]");
}

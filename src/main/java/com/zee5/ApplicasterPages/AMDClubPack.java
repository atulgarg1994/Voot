package com.zee5.ApplicasterPages;

import org.openqa.selenium.By;

public class AMDClubPack {

	public static By objupgradeIcon = By.xpath("//*[@resource-id='com.graymatrix.did:id/subscribeiconlayout']");
	public static By objCrownIcon = By.xpath("//*[@text='P']");
	public static By objBuySubscriptionScreen = By.xpath("//*[@resource-id='com.graymatrix.did:id/screen_title']");	
	public static By objUpgradeCTAOnCarousel = By.xpath("//*[@resource-id='com.graymatrix.did:id/get_premium_hero_component']");
	public static By objUpgradeCTABelowPlayer = By.xpath("//*[@class='android.widget.FrameLayout' and ./*[@text='Upgrade']]");
	public static By objYouneedpremiumtextonPlayer = By.xpath("//*[@resource-id='com.graymatrix.did:id/static_premium_text']");
	
	public static By objUpgradepopuptitle = By.xpath("//*[@resource-id='com.graymatrix.did:id/popup_title']");
	public static By objProceedbutton = By.xpath("//*[@resource-id='com.graymatrix.did:id/proceed']");
	public static By objTermsofuseinUpgradepopup= By.xpath("//*[@resource-id='com.graymatrix.did:id/terms_of_use']");
	public static By objprivacypolicyinUpgradePopup = By.xpath("//*[@resource-id='com.graymatrix.did:id/privacy_policy']");
	public static By objPremiumPlanDescinUpgradepopup = By.xpath("//*[@resource-id='com.graymatrix.did:id/containerForPremiumTypeNote']");
	public static By objClubpackDescinupgradepopup = By.xpath("//*[@resource-id='com.graymatrix.did:id/containerForClubTypeNote']");
	public static By objplan1 = By.xpath("(//*[@resource-id='com.graymatrix.did:id/txt_packDescription'])[1]");
	public static By objplan2 = By.xpath("(//*[@resource-id='com.graymatrix.did:id/txt_packDescription'])[2]");	
}

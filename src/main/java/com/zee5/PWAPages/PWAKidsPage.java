package com.zee5.PWAPages;

import org.openqa.selenium.By;

public class PWAKidsPage {
	
	public static By objPlayButton = By.xpath("//*[contains(@class,'slick-active')]//span[text()='Play']");
	
	public static By objGoToEduauraa = By.xpath("//button//*[text()='Go to Eduauraa']");
	
	public static By objExitZee5Continue = By.xpath("//button//*[text()='Continue']");
	
	public static By objFirstContentOfEduauraa = By.xpath("(.//*[@class='viewAllWrap']//child::*//*[@class='clickWrapper'])[1]");
	
	public static By objExpanderIconInEduauraaPlayback = By.xpath("(.//*[contains(@class,'Collapsible__trigger is-')])[1]"); 
	
	public static By objTermAndCondition = By.xpath(".//*[@href='https://www.zee5.com/termsofuse']");
	
	public static By objPrivacyPolicy = By.xpath(".//*[@href='https://www.zee5.com/privacypolicy']");
	
	public static By objWatchButton= By.xpath("//*[contains(@class,'slick-active')]//span[text()='Watch']");

}

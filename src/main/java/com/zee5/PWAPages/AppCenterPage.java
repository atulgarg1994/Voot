package com.zee5.PWAPages;

import org.openqa.selenium.By;

public class AppCenterPage {

	
	public static By objMicrosoft = By.xpath(".//*[@alt='Microsoft']");
	
	public static By objEmail = By.xpath(".//input[@type='email']");
	
	public static By objPassword = By.xpath(".//input[@type='password']");
	
	public static By objSignIn = By.xpath(".//input[@type='submit']");
	
	public static By objMoreInformationRequiredPopUp = By.xpath(".//*[@id='SsprProofupPage_MainHeader']");
	
	public static By objCancelBtn = By.xpath(".//*[@id='CancelLinkButton']");
	
	public static By objNoBtn = By.xpath(".//*[@id='idBtn_Back']");
	
	public static By objZee5AndroidHeader = By.xpath(".//*[@class='_7K7Xjw2Px']");
	
	public static By objExpandIcon = By.xpath("(.//*[@class='_1FqZrtOgx _6N07j8WWx _2CPSTw5ex _2tt1fylgx _6UYCKwXNx _1oz0dxenx _7mS0f4yVx'])[2]//parent::*//following-sibling::*[@class='_6lPyHfJGx']//*[@alt='Expand More']");
	
	public static By objDownloadBtn = By.xpath("(.//*[@class='_1FqZrtOgx _6N07j8WWx _2CPSTw5ex _2tt1fylgx _6UYCKwXNx _1oz0dxenx _7mS0f4yVx'])[2]//parent::*//following-sibling::*[@class='_6lPyHfJGx']//button");
	
	public static By objDownloadLatestReleaseBtn = By.xpath(".//*[text()='Download']");
	
}

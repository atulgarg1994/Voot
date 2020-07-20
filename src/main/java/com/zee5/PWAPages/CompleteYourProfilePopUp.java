package com.zee5.PWAPages;

import org.openqa.selenium.By;

public class CompleteYourProfilePopUp {
	
	public static By objCompleteYourProfileTxt = By.xpath("//div[.='Complete profile']");

	public static By objFirstName = By.xpath("//input[@name='firstName']");
	
	public static By objLastName = By.xpath("//input[@name='lastName']");
	
	public static By objDay = By.xpath("(//div[@class='inputItem selectWrapper'])[1]");
	
	public static By objMonth = By.xpath("(//div[@class='inputItem selectWrapper'])[2]");
	
	public static By objYear = By.xpath("(//div[@class='inputItem selectWrapper'])[3]");
	
	public static By objGenderMale = By.xpath("(//label[@for='male'])//child::*[3][.='Male']");
	
	public static By objGenderFemale = By.xpath("(//label[@for='female'])//child::*[3][.='Female']");
	
	public static By objMobileNo = By.xpath("(//input[@name='mobile'])");
	
	public static By objOTP = By.xpath("//button[@type='button']//span[.='Send OTP']");
	
	public static By objCloseBtn = By.xpath(" //div[@class='manCloseIcon']");
	
	public static By objDateSelector = By.xpath("(//span[@role='option'])[3]");
}

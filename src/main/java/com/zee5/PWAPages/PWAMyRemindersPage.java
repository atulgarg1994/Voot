package com.zee5.PWAPages;

import org.openqa.selenium.By;

public class PWAMyRemindersPage {
	
	public static By objMyReminderHeader = By.xpath(".//h1[@class='pageTitle']");
	public static By objTotalContentsInReminder = By.xpath("(//h3[contains(@class,'cardTitle')]//span)");
	public static By objDateTime = By.xpath("//div[@class='dateTime']");
	public static By objNoReminderMessage = By.xpath("//div[@class='textArea']");
	
	

}

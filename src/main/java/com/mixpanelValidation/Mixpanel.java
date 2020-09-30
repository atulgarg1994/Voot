package com.mixpanelValidation;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.EncoderConfig;
import com.jayway.restassured.response.Response;

public class Mixpanel {

	/**
	 * Global variables
	 */
	static String sheet = "Skip Login_1";
	static String fileName = "Mixpanel_3";
	static String xlpath = System.getProperty("user.dir") + "\\" + fileName + ".xlsx";

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
//		creatExcel();
//		fetchEvent("1cb23b7026466d01c474222e021ffc33", "Skip Login");
//		validation();
//		Instant instant = Instant.ofEpochSecond("1601475542");
//		java.util.Date time = new java.util.Date((long)1601475542*1000);
//		System.out.println("Time : "+time);
	}

	/**
	 * Function to fetch logs from mixpanel dash board using rest assured API
	 * 
	 * @param distinct_id
	 * @param eventName
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	public static void fetchEvent(String distinct_id, String eventName)
			throws JsonParseException, JsonMappingException, IOException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		String currentDate = dtf.format(now); // Get current date in formate yyyy-MM-dd
//		currentDate = "2020-09-28";
		Response request = RestAssured.given().auth().preemptive().basic("58baafb02e6e8ce03d9e8adb9d3534a6", "")
				.config(RestAssured.config().encoderConfig(EncoderConfig.encoderConfig()))
				.contentType("application/x-www-form-urlencoded; charset=UTF-8")
				.formParam("from_date", currentDate )
				.formParam("to_date", currentDate )
				.formParam("event", "[\"" + eventName + "\"]")
				.formParam("where", "properties[\"$distinct_id\"]==\"" + distinct_id + "\"")
				.post("https://data.mixpanel.com/api/2.0/export/");
		request.print();
		sheet = eventName.trim();
		if (request != null) {
//			String response = request.asString();
//			String s[] = response.split("\n");
//			parseResponse(s[s.length - 1]);
		}
	}
}

package com.mixpanelValidation;

import java.io.File;
//import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.EncoderConfig;
import com.jayway.restassured.response.Response;

public class Mixpanel {

	/**
	 * Global variables
	 */
	static String sheet = "Sheet1";
	static String fileName = "Mixpanel";
	static String xlpath = System.getProperty("user.dir") + "\\" + fileName + ".xlsx";
	
	public static void main(String[] args) {
		fetchEvent("5d94e150a85711e9a4028141f97a2ff1","Video View");
	}

	/**
	 * Function to fetch logs from mixpanel dash board using rest assured API
	 * 
	 * @param distinct_id
	 * @param eventName
	 */
	public static void fetchEvent(String distinct_id, String eventName) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		String currentDate = dtf.format(now); // Get current date in formate yyyy-MM-dd

		Response request = RestAssured.given().auth().preemptive().basic("58baafb02e6e8ce03d9e8adb9d3534a6", "")
				.config(RestAssured.config().encoderConfig(EncoderConfig.encoderConfig()))
				.contentType("application/x-www-form-urlencoded; charset=UTF-8").formParam("from_date", currentDate)
				.formParam("to_date", currentDate).formParam("event", "[\"" + eventName + "\"]")
				.formParam("where", "properties[\"$distinct_id\"]==\"" + distinct_id + "\"")
				.post("https://data.mixpanel.com/api/2.0/export/");
//		request.print();

		if (request != null) {
			String response = request.asString();
			String s[] = response.split("\n");
			System.out.println(s[s.length-1]);
			parseResponse(s[s.length-1]);
		}
	}

	/**
	 * Parse the response and split the response
	 * 
	 * @param reponse
	 */
	public static void parseResponse(String reponse) {
		
		String commaSplit[] = reponse.replace("$", "").replace("{", "").replace("}", "").replace(":", "=").replace("\"", "").replaceFirst("[.,](?=[^\\[]*\\])", "-").replace("properties=", "")
				.split(",");
//		creatExcel(); // Create an excel file
		for (int i = 0; i < commaSplit.length; i++) {
			if (i != 0) {
				write(i, commaSplit); // Write key value into excel
//				System.out.println(commaSplit[i]);
			}
		}
	}

	/**
	 * Function to create excel file of format .xlsx Function to create sheet
	 */
	public static void creatExcel() {
		try {
			File file = new File(System.getProperty("user.dir") + "\\" + fileName + ".xlsx");
			if (!file.exists()) {
				XSSFWorkbook workbook = new XSSFWorkbook();
				workbook.createSheet(sheet); // Create sheet
				FileOutputStream fos = new FileOutputStream(
						new File(System.getProperty("user.dir") + "\\" + fileName + ".xlsx"));
				workbook.write(fos);
				workbook.close();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Function to write values into excel
	 * @param i
	 * @param parameter
	 */
	public static void write(int i, String parameter[]) {
		try {
//			XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(xlpath));
//			FileOutputStream output = new FileOutputStream(xlpath);
//			XSSFSheet myExcelSheet = myExcelBook.getSheet(sheet);
//			XSSFRow row = myExcelSheet.createRow(i);
//			if (row == null) {
//				row = myExcelSheet.createRow(i); // create row if not created
//			}
			System.out.println(parameter[i]);
			if(parameter[i].contains("https")) {
				Pattern p = Pattern.compile("\\b((?:https?|ftp|file)=//[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|])");
				Matcher m = p.matcher(parameter[i]);
				m.find();
				System.out.println("Pattren : "+m.group(0));
			}
			String keyValue[] = parameter[i].split("="); // Split individual parameter into key value
			System.out.println(keyValue[0]+"   "+keyValue[1]);
//			row.createCell(0).setCellValue(keyValue[0]); // write parameter key into excel into first column
//			row.createCell(1).setCellValue(keyValue[1]); // write parameter value into excel second column
//			myExcelBook.write(output);
//			myExcelBook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

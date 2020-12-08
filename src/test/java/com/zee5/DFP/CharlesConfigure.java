package com.zee5.DFP;

import java.io.IOException;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CharlesConfigure {

	static InetAddress localhost;
	static String PortNumber = "9999";
	public static String charlesName = "";
	public static boolean charles = false;

	public static void main(String[] args) throws IOException, InterruptedException {
		openCharles();
		saveCharles("ChlsXMLFile");
//		System.out.println(System.getProperty("user.dir") + "\\DifferenceBtwTemplateAndUIPlayedContent.chlsx");
	}

	public static void openCharles() throws IOException, InterruptedException {
		try {
			System.out.println("Open Charles");
			Runtime.getRuntime().exec("Charles.exe -config C:\\Users\\IGS0026\\Documents\\CharlesSettingsConfig.xml");
			Thread.sleep(20000);
			localhost = InetAddress.getLocalHost();
			String ipAddress = localhost.getHostAddress().trim();
			System.out.println(ipAddress);
			Thread.sleep(10000);
			Runtime.getRuntime().exec(
					"curl -v -x http://" + ipAddress + ":" + PortNumber + " http://control.charles/session/clear");
			Thread.sleep(2000);
			Runtime.getRuntime().exec(
					"curl -v -x http://" + ipAddress + ":" + PortNumber + " http://control.charles/recording/start");
			charles = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void saveCharles(String fileName) {
		try {
			DateFormat date = new SimpleDateFormat("ddmmyyHHMMss");
			Date date2 = new Date();
			String date1 = date.format(date2);
			charlesName = fileName + date1 + ".xml";
			String charleslogsName = fileName + date1 + ".chls";
			String filePathxml = "./" + charlesName;
			String filePathlogs = "./" + charleslogsName;
			String ipAddress = localhost.getHostAddress().trim();
			Runtime.getRuntime().exec(
					"curl -v -x http://" + ipAddress + ":" + PortNumber + " http://control.charles/recording/stop");
			Thread.sleep(2000);
			Runtime.getRuntime().exec("curl -o " + filePathxml + " -x http://" + ipAddress + ":" + PortNumber
					+ " http://control.charles/session/export-xml");
			Thread.sleep(10000);
			Runtime.getRuntime().exec("curl -o " + filePathlogs + " -x http://" + ipAddress + ":" + PortNumber
					+ " http://control.charles/session/download");
			Thread.sleep(10000);
			Runtime.getRuntime().exec("taskkill /F /IM Charles.exe");
		} catch (Exception e) {

		}
	}

}
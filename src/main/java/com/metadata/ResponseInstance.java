package com.metadata;

import static com.jayway.restassured.RestAssured.given;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
import org.testng.Reporter;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class ResponseInstance {

	protected static Response resp = null;

	public static Response getResponse() {
		resp = given().urlEncodingEnabled(false).when().get(
				"https://gwapi.zee5.com/content/collection/0-8-homepage?limit=20&page=1&item_limit=20&desc=no&version=6&translation=en&languages=en,kn&country=IN");
		return resp;
	}

	public static Response getResponse(String URL) {
		resp = given().urlEncodingEnabled(false).when().get(URL);
		return resp;
	}

	public static void traysTitle() {
		int numberOfTrays = getResponse().jsonPath().getList("buckets").size();
		for (int i = 1; i < numberOfTrays; i++) {
			System.out.println(getResponse().jsonPath().getString("buckets[" + i + "].title"));
		}
	}

	public static ArrayList<String> traysIndiviualTags(String NameOfTheTray) {
		ArrayList<String> Arraytags = new ArrayList<String>();
		int numberOfTrays = getResponse().jsonPath().getList("buckets").size();
		for (int i = 1; i < numberOfTrays; i++) {
			String TrayName = getResponse().jsonPath().getString("buckets[" + i + "].title");
			int numberOfitmesTrays = getResponse().jsonPath().getList("buckets[" + i + "].items").size();
			if (TrayName.equals(NameOfTheTray)) {
				for (int j = 0; j < numberOfitmesTrays; j++) {
					Arraytags.add(getResponse().jsonPath().getString("buckets[" + i + "].items[" + j + "].title"));
				}
				break;
			}
			if (Arraytags.size() > 0) {
				break;
			}
		}
		return Arraytags;
	}

	public static ArrayList<String> ContentOfViewAll() {
		ArrayList<String> contentFromViewAll = new ArrayList<String>();
		for (int i = 1; i <= 3; i++) {
			String page1 = "https://gwapi.zee5.com/content/collection/0-8-2074?page=" + i
					+ "&limit=20&desc=no&country=IN&languages=en,kn&translation=en&version=6";
			resp = given().urlEncodingEnabled(false).when().get(page1);
			int sizeOfAnItem = resp.jsonPath().getList("buckets[0].items").size();
			if (sizeOfAnItem > 0) {
				for (int j = 0; j < sizeOfAnItem; j++) {
					contentFromViewAll.add(resp.jsonPath().getString("buckets[0].items[" + j + "].title"));
					System.out.println(contentFromViewAll);
				}
			}
		}
		return contentFromViewAll;
	}

	public static ArrayList<String> getCollectionContent(String CollectionName) {

		ArrayList<String> contentList = new ArrayList<String>();
		int sizeOfAnCollection = 0;
		int NumberOfCollection = resp.jsonPath().getList("buckets[0].items").size();
		for (int i = 0; i < NumberOfCollection; i++) {
			if (resp.jsonPath().getString("").equals(CollectionName)) {
				sizeOfAnCollection = resp.jsonPath().getList("buckets[0].items").size();
				for (int j = 0; j < sizeOfAnCollection; j++) {
					contentList.add(resp.jsonPath().getString(""));
				}
			}
			if (sizeOfAnCollection > 0) {
				break;
			}
		}
		return contentList;
	}

//	BASAVARAJ
	public static Response getRECOResponse(String URL, String username, String password) {
		Response respp = null;
		String Uri = URL;
		respp = given()
				.headers("X-ACCESS-TOKEN", getXAccessToken(), "Authorization", getBearerToken(username, password))
				.when().get(Uri);
		System.out.println(respp.getBody());
		return respp;
	}

	/**
	 * Function to return X-ACCESS TOKEN
	 * 
	 * @param page
	 * @return
	 */
	public static String getXAccessToken() {
		Response resp = null;
		String xAccessToken="";
		String url = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("url");
		resp = given().urlEncodingEnabled(false).when().get(url);
		String respString = resp.getBody().asString();
		respString=respString.replace("\"gwapiPlatformToken\":\"\"", "");
		respString=respString.split("\"gwapiPlatformToken\":\"")[1];
		xAccessToken=respString.split("\"")[0];
		return xAccessToken;
		
	}

	/**
	 * Function to return Bearer token
	 * 
	 * @param email, password
	 * @return bearer token
	 */
	public static String getBearerToken(String email, String password) {
		JSONObject requestParams = new JSONObject();
		requestParams.put("email", email);
		requestParams.put("password", password);
		RequestSpecification req = RestAssured.given();
		req.header("Content-Type", "application/json");
		req.config(com.jayway.restassured.RestAssured.config().encoderConfig(com.jayway.restassured.config.EncoderConfig
				.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)));
		req.body(requestParams.toString());
		Response resp = req.post("https://userapi.zee5.com/v2/user/loginemail");
		String accesstoken = resp.jsonPath().getString("access_token");
		String tokentype = resp.jsonPath().getString("token_type");
		String bearerToken = tokentype + " " + accesstoken;
		return bearerToken;
	}

	/**
	 * Get Recommendation data for the tab
	 * 
	 * @param tab
	 * @return reco response
	 */
	public static Response getRecoDataFromTab(String userType, String tab, String contLang) {
		Response respReco = null;
		if (tab.equalsIgnoreCase("shows")) {
			tab = "tvshows";
		} else if (tab.equalsIgnoreCase("premium")) {
			tab = "premiumcontents";
		} else if (tab.equalsIgnoreCase("home")) {
			tab = "homepage";
		} else if (tab.equalsIgnoreCase("kids")) {
			tab = "3673";
		} else if (tab.equalsIgnoreCase("videos")) {
			tab = "5011";
		} else if (tab.equalsIgnoreCase("movies")) {
			tab = "movies";
		} else if (tab.equalsIgnoreCase("music")) {
			tab = "2707";
		} else if (tab.equalsIgnoreCase("zeeoriginals")) {
			tab = "zeeoriginals";
		} else if (tab.equalsIgnoreCase("news")) {
			tab = "626";
		}
		Response regionResponse=given().urlEncodingEnabled(false).when().get("https://xtra.zee5.com/country");
		String region=regionResponse.getBody().jsonPath().getString("state_code");
		String Uri = "https://gwapi.zee5.com/content/reco?country=IN&translation=en&languages=" + contLang+ "&version=6&collection_id=0-8-" + tab + "&region="+region;
		System.out.println("Hitting api:\n" + Uri);
		String xAccessToken = getXAccessToken();
		if (userType.equalsIgnoreCase("Guest")) {
			//Get Guest Token
			JSONObject requestParams = new JSONObject();
			requestParams.put("aid", "91955485578"); 
			requestParams.put("apikey", "6BAE650FFC9A3CAA61CE54D");			 
			requestParams.put("DekeyVal", "Z5G211");
			requestParams.put("UserAgent", "pwaweb");
			RequestSpecification request = RestAssured.given();
			request.header("Content-Type","application/json");
			request.config(com.jayway.restassured.RestAssured.config().encoderConfig(com.jayway.restassured.config.EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)));
			request.body(requestParams.toString());
			Response response = request.post("https://whapi-prod-node.zee5.com/fetchGuestToken");
			String guestToken=response.jsonPath().get("guest_user").toString();
			respReco = given().headers("x-access-token", xAccessToken).header("x-z5-guest-token", guestToken).when().get(Uri);
		} else if (userType.equalsIgnoreCase("SubscribedUser")) {
			String email = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("SubscribedUserName");
			String password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("SubscribedPassword");
			String bearerToken = getBearerToken(email, password);
			respReco = given().headers("x-access-token", xAccessToken).header("authorization", bearerToken).when().get(Uri);
		} else if (userType.equalsIgnoreCase("NonSubscribedUser")) {
			String email = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("NonsubscribedUserName");
			String password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("NonsubscribedPassword");
			String bearerToken = getBearerToken(email, password);
			respReco = given().headers("x-access-token", xAccessToken).header("authorization", bearerToken).when()
					.get(Uri);
		} else {
			System.out.println("Incorrect user type passed to method");
		}
		respReco.body().print();
		return respReco;
	}

	/**
	 * Get Recommendation data for the content
	 * 
	 * @param tab
	 * @return reco response
	 */
	public static Response getRecoTraysInDetailsPage(String userType, String contentID) {
		Response respReco = null;
		String Uri = "https://gwapi.zee5.com/content/reco?asset_id=" + contentID
				+ "&country=IN&translation=en&languages=en,kn&version=6&region=KA";
		System.out.println("Hitting content api:\n" + Uri);
		String xAccessToken = getXAccessToken();
		if (userType.equalsIgnoreCase("Guest")) {
			respReco = given().headers("x-access-token", xAccessToken).header("x-z5-guest-token", "12345").when()
					.get(Uri);
		} else if (userType.equalsIgnoreCase("SubscribedUser")) {
			String email = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("SubscribedUserName");
			String password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("SubscribedPassword");
			String bearerToken = getBearerToken(email, password);
			respReco = given().headers("x-access-token", xAccessToken).header("authorization", bearerToken).when()
					.get(Uri);
		} else if (userType.equalsIgnoreCase("NonSubscribedUser")) {
			String email = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("NonsubscribedUserName");
			String password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("NonsubscribedPassword");
			String bearerToken = getBearerToken(email, password);
			respReco = given().headers("x-access-token", xAccessToken).header("authorization", bearerToken).when()
					.get(Uri);
		} else {
			System.out.println("Incorrect user type passed to method");
		}
		respReco.body().print();
		return respReco;
	}

	/**
	 * Function to tray list on carousel for different pages
	 * 
	 * @param page
	 * @return
	 */
	public static List<String> traysTitleCarousel(String page) {
		Response responseCarouselTitle = getResponseForPages(page);
		List<String> titleOnCarouselList = new LinkedList<String>();
		int numberOfCarouselSlides = responseCarouselTitle.jsonPath().getList("buckets[0].items").size();
		System.out.println("api size : " + numberOfCarouselSlides);
		for (int i = 0; i < numberOfCarouselSlides; i++) {
			String title = responseCarouselTitle.jsonPath().getString("buckets[0].items[" + i + "].title");
			titleOnCarouselList.add(title);
		}
		return titleOnCarouselList;
	}

	/**
	 * Function to return response for different pages
	 * 
	 * @param page
	 * @return
	 */
	public static Response getResponseForPages(String page) {
		Response respCarousel = null;
		if (page.equals("news")) {
			page = "626";
		} else if (page.equals("music")) {
			page = "2707";
		} else if (page.equals("home")) {
			page = "homepage";
		}
		String Uri = "https://gwapi.zee5.com/content/collection/0-8-" + page
				+ "?page=1&limit=5&item_limit=20&country=IN&translation=en&languages=en,kn&version=6";
		respCarousel = given().urlEncodingEnabled(false).when().get(Uri);
		return respCarousel;
	}
	
	/**
	 * Method to get content details passing content ID
	 * 
	 */
	public static Response getContentDetails(String contentID) {
		Response respContentDetails = null;
		String Uri = "https://gwapi.zee5.com/content/details/"+contentID+"?translation=en&country=IN";	
		respContentDetails = given().when().get(Uri);
		System.out.println("Content Details API Response: "+respContentDetails.getBody().asString());
		return respContentDetails;
	}
	
	/**
	 * Function to return response for different pages
	 * 
	 * @param page
	 * @return
	 */
	public static Response getResponseForPages(String page, String contLang) {
		Response respCarousel = null;
		String Uri = "";
		if (page.equals("news")) {
			page = "626";
		} else if (page.equals("music")) {
			page = "2707";
		} else if (page.equals("home")) {
			page = "homepage";
		} else if(page.equals("kids")) {
			page = "3673";
		}else if(page.equals("freemovies")) {
			page = "5011";
		}else if(page.equals("play")) {
			page = "4603";
		}else if(page.equals("zeeoriginals")) {
			page = "zeeoriginals";
		}
		
		if(page.equals("stories")) {
			Uri = "https://zeetv.zee5.com/wp-json/api/v1/featured-stories";
		}else {
			Uri = "https://gwapi.zee5.com/content/collection/0-8-" + page+ "?page=1&limit=5&item_limit=20&country=IN&translation=en&languages="+contLang+"&version=6";
		}
		
		respCarousel = given().headers("X-ACCESS-TOKEN", getXAccessToken()).when().get(Uri);
		System.out.println("Response status : "+respCarousel.statusCode());
	//	System.out.println("Response Body : "+respCarousel.getBody().asString());
		return respCarousel;
	}

	/**
	 * Function to tray list on carousel for different pages
	 * 
	 * @param page
	 * @return
	 */
	public static List<String> traysTitleCarousel(String page, String contLang) {
		Response responseCarouselTitle = getResponseForPages(page, contLang);
		List<String> titleOnCarouselList = new LinkedList<String>();
		int numberOfCarouselSlides =0;
		String title = "";
		if(page.equals("stories")) {
			numberOfCarouselSlides = responseCarouselTitle.jsonPath().getList("posts").size();
		}else {
			numberOfCarouselSlides = responseCarouselTitle.jsonPath().getList("buckets[0].items").size();
		}
		System.out.println("api size : " + numberOfCarouselSlides);
		if(numberOfCarouselSlides>7) numberOfCarouselSlides=7;
		for (int i = 0; i < numberOfCarouselSlides; i++) {  //Only 7 tray visible on UI
			if(page.equals("stories")) {
				title = responseCarouselTitle.jsonPath().getString("posts[" + i + "].title");
			}else {
				title = responseCarouselTitle.jsonPath().getString("buckets[0].items[" + i + "].title");
			}
			titleOnCarouselList.add(title);
		}
		return titleOnCarouselList;
	}
	
	
	public static Response getResponseForPages2(String page, String contLang,int q) {
		Response respCarousel = null;
		String Uri = "";
		if (page.equals("news")) {
			page = "626";
		} else if (page.equals("music")) {
			page = "2707";
		} else if (page.equals("home")) {
			page = "homepage";
		} else if(page.equals("kids")) {
			page = "3673";
		}else if(page.equals("freemovies")) {
			page = "5011";
		}else if(page.equals("play")) {
			page = "4603";
		}
		
		if(page.equals("stories")) {
			Uri = "https://zeetv.zee5.com/wp-json/api/v1/featured-stories";
		}else {
			Uri = "https://gwapi.zee5.com/content/collection/0-8-" + page+ "?page="+q+"&limit=5&item_limit=20&country=IN&translation=en&languages="+contLang+"&version=6";
		}
		
		respCarousel = given().headers("X-ACCESS-TOKEN", getXAccessToken()).when().get(Uri);
		System.out.println("Response status : "+respCarousel.statusCode());
		return respCarousel;
	}

	
	
}

package com.training.api.authenticate;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.web.client.RestTemplate;

public class Authenticator {
	public static String data_api = "http://localhost:8081/account/customer";
	RestTemplate rest = new RestTemplate();
	
	public static boolean checkUser(String username) throws IOException {
		//Get(data_api);
		if( (username != null && username.length() > 0) &&
			( username.equalsIgnoreCase("john") 
		    || username.equalsIgnoreCase("susan"))) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkPassword(String username, String password) throws IOException {
		if(checkUser(username)) {
			if(username.equalsIgnoreCase("john") && password.equals("pass")) {
				return true;
			}
			if(username.equalsIgnoreCase("susan") && password.equals("pass")) {
				return true;
			}			
		}else {
			return false;
		}
		return false;
	}
	

		// HTTP GET request
		public static void Get(String url) throws IOException {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			//add request header
			// con.setRequestProperty("User-Agent", USER_AGENT);

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			//print result
			System.out.println(response.toString());

		}
	
}

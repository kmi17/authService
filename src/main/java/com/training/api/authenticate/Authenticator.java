package com.training.api.authenticate;
import java.io.IOException;
import org.springframework.web.client.RestTemplate;

public class Authenticator {
	public static String data_api = "http://localhost:8081/account/auth/customers";
	static Customer cus = new Customer();
	public static boolean checkUser(Customer cus) throws IOException {
		if( (cus != null)) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean checkPassword(String username, String password) throws IOException {
		cus = getUser(data_api + "/" + username + "/" + password);
		System.out.println(cus);
		if(checkUser(cus)) {
			if(username.equalsIgnoreCase(cus.getName()) && password.equals(cus.getPassword())) {
				return true;
			}		
		}else {
			return false;
		}
		return false;
	}
		// HTTP GET request
		public static Customer getUser(String url) {
			System.out.println(url);
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.getForObject(url, Customer.class);
		}
	
}

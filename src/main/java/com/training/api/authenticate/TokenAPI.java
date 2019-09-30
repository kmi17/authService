 package com.training.api.authenticate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class TokenAPI {
	JWTUtil jwtUtil = new JWTMockUtil();
	// JWTUtil jwtUtil = new JWTHelper();
	
	@PostMapping(consumes = "application/json")
	public String getToken(@RequestBody TokenRequestData tokenRequestData) {
		
		String username = tokenRequestData.getUsername();
		String password = tokenRequestData.getPassword();
		String scopes = tokenRequestData.getScopes();
		System.out.println(scopes);
		if (username != null && username.length() > 0 
				&& password != null && password.length() > 0 
				&& Authenticator.checkPassword(username, password)) {
			Token token = jwtUtil.createToken(scopes);
			ResponseEntity<?> response = ResponseEntity.ok(token);
			return "hi you are authorized";			
		}
		// bad request
		return "not authorized";//(ResponseEntity<?>) ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		
	}
	
	
}

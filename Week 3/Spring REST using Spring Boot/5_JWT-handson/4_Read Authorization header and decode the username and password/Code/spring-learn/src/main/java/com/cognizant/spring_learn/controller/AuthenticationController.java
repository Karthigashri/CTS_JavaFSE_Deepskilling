package com.cognizant.spring_learn.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Base64;
import java.nio.charset.StandardCharsets;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

	@GetMapping("/authenticate")
	public Map<String, String> authenticate(
	        @RequestHeader("Authorization") String authHeader) {

	    System.out.println("START authenticate()");

	    System.out.println("Authorization Header : " + authHeader);

	    String user = getUser(authHeader);

	    System.out.println("Authenticated User : " + user);

	    Map<String, String> map = new HashMap<>();

	    map.put("token", "");

	    System.out.println("END authenticate()");

	    return map;
	}
	
        private String getUser(String authHeader) {

            System.out.println("START getUser()");

            // Remove "Basic "
            String encodedCredentials = authHeader.substring(6);

            System.out.println("Encoded Credentials : " + encodedCredentials);

            // Decode-Base64
            byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);

            String credentials = new String(decodedBytes, StandardCharsets.UTF_8);

            System.out.println("Decoded Credentials : " + credentials);

            // Extract-username
            String user = credentials.substring(0, credentials.indexOf(":"));

            System.out.println("User : " + user);

            System.out.println("END getUser()");

            return user;
        }
    }

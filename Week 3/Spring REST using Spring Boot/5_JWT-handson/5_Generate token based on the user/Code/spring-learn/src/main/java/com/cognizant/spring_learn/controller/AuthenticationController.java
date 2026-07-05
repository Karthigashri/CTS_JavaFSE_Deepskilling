package com.cognizant.spring_learn.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Base64;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
import java.nio.charset.StandardCharsets;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
	private static final String SECRET =
	        "mysecretkeymysecretkeymysecretkey12345";

	private final SecretKey key =
	        Keys.hmacShaKeyFor(SECRET.getBytes());

	@GetMapping("/authenticate")
	public Map<String, String> authenticate(
	        @RequestHeader("Authorization") String authHeader) {

	    System.out.println("START authenticate()");

	    System.out.println("Authorization Header : " + authHeader);

	    String user = getUser(authHeader);

	    String token = generateJwt(user);

	    Map<String, String> map = new HashMap<>();

	    map.put("token", token);

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
        private String generateJwt(String user) {

            System.out.println("START generateJwt()");

            String token = Jwts.builder()
                    .subject(user)
                    .issuedAt(new Date())
                    .expiration(new Date(System.currentTimeMillis() + 1200000))
                    .signWith(key)
                    .compact();

            System.out.println("Generated Token : " + token);

            System.out.println("END generateJwt()");

            return token;
        }
    }

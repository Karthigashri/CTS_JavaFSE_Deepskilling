package com.cognizant.jwt_demo.security;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.jwt_demo.config.JwtConfig;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenProvider {

    @Autowired
    JwtConfig config;

    public String createToken(String username) {

        Key key = Keys.hmacShaKeyFor(
                config.getSecret().getBytes(StandardCharsets.UTF_8));

        return Jwts.builder()

                .subject(username)

                .issuedAt(new Date())

                .expiration(new Date(System.currentTimeMillis()+3600000))

                .signWith(key)

                .compact();

    }

}
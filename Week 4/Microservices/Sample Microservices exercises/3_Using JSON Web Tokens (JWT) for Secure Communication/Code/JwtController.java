package com.cognizant.jwt_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.jwt_demo.security.JwtTokenProvider;

@RestController
public class JwtController {

    @Autowired
    JwtTokenProvider provider;

    @GetMapping("/token")
    public String token() {

        return provider.createToken("admin");

    }

}
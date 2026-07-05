package com.cognizant.spring_learn.security;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    public JwtAuthorizationFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        System.out.println("START JwtAuthorizationFilter");

        String header = request.getHeader("Authorization");

        System.out.println("Authorization Header : " + header);

        if (header == null || !header.startsWith("Bearer ")) {

            filterChain.doFilter(request, response);
            return;
        }

        String token = header.replace("Bearer ", "");

        if (jwtUtil.validateToken(token)) {

            String user = jwtUtil.extractUser(token);

            System.out.println("Authenticated User : " + user);

            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(
                            user,
                            null,
                            new ArrayList<>());

            SecurityContextHolder.getContext()
                    .setAuthentication(authentication);

        } else {

            SecurityContextHolder.clearContext();
        }

        filterChain.doFilter(request, response);

        System.out.println("END JwtAuthorizationFilter");
    }
}
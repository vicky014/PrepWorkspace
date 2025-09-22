package com.springsec.test.configuration;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.springsec.test.service.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter{

	@Autowired
	private JwtService jwtService;
	
	@Autowired
	ApplicationContext context;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authHeader = request.getHeader("Authorization");
		String token = null;
		String userName = null;
		
		if(authHeader != null && authHeader.startsWith("Bearer ")) { //checking the token pattern here
			token = authHeader.substring(7);
			
			//extracting username from token to validate it from DB via Username password Authenticator
			userName = jwtService.extractUserName(token); 
		}
		
		//checking if not already authenticated then only validate username
		if(userName !=null && SecurityContextHolder.getContext().getAuthentication() == null) { 
			
			//getting loadByUserName via context to avoid cycle redundancy which may occur with Autowiring
			UserDetails userDetails = context.getBean(MyUserDetailsService.class).loadUserByUsername(userName);
			if(jwtService.validateToken(token, userDetails)) {
				//right now it knows about the user by does not know the data inside it
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				//now authToken knows about the data in request as well
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				//we are adding token in the authentication loop
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}
		//from here the Jwt token filter is done and the authentication for UserPassWrod Authentication filter continues
		filterChain.doFilter(request, response); 
	}

}

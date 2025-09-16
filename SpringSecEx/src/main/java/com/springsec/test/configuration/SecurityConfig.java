package com.springsec.test.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity //this tells Spring that don't use default Spring security but use this
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
    	http.csrf(csrf -> csrf.disable()); //disabling it for STATLESS REST APi where we dont want to manage session ID's
    	http.authorizeHttpRequests(req -> req.anyRequest().authenticated());
//    	http.formLogin(Customizer.withDefaults());
    	http.httpBasic(Customizer.withDefaults());//to enable rest calls
    	http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
    	/*in browser post this config whenever we login a new request is generated 
    	and again a login screen is shown to overcome this we have to disable the 
    	form login and then a alert login popup will be shown and post every refresh 
    	we get a new session id and we have to manage it*/
    	return http.build();
	}
}

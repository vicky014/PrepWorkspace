package com.springsec.test.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity //this tells Spring that don't use default Spring security but use this
public class SecurityConfig {

	@Autowired
	private UserDetailsService userDetailsService;
	
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
    	return http
    		.csrf(csrf -> csrf.disable()) //disabling it for STATLESS REST APi where we dont want to manage session ID's
    		.authorizeHttpRequests(req -> req.anyRequest().authenticated())
    		.formLogin(Customizer.withDefaults())
    		.httpBasic(Customizer.withDefaults())//to enable rest calls
    		.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).build();
		
    	/*in browser post this config whenever we login a new request is generated 
    	and again a login screen is shown to overcome this we have to disable the 
    	form login and then a alert login popup will be shown and post every refresh 
    	we get a new session id and we have to manage it*/
    	
	}
    
    @SuppressWarnings("deprecation")
	@Bean
    AuthenticationProvider authenticationProvider() {
    	DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    	provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
    	provider.setUserDetailsService(userDetailsService);
    	
    	return provider;
    	
    }
    
//    @Bean
//    UserDetailsService userDetailsService(){
//    	
//    	return new InMemoryUserDetailsManager();
//    }
}

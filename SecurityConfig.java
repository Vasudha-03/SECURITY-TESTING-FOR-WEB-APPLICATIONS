package org.jsp.springBoot.Config;

import org.jsp.springBoot.Entity.User;
import org.jsp.springBoot.Repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//        http
//            .csrf(csrf -> csrf.disable())
//            .authorizeHttpRequests(auth -> auth
////            	.requestMatchers("/auth/register").permitAll()                
//            	.requestMatchers("/auth/**").permitAll()   // 🔥 allow register
////                .requestMatchers("/doctor/**").hasRole("DOCTOR")
////                .requestMatchers("/patient/**").hasRole("PATIENT")
//                .anyRequest().authenticated()
//            )
//            .httpBasic(Customizer.withDefaults());
//
//        return http.build();
//    }
//
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

	        http
	            .csrf(csrf -> csrf.disable())
	            .authorizeHttpRequests(auth -> auth
	                .requestMatchers("/auth/**").permitAll() // allow register/login
	                .anyRequest().permitAll() // allow everything (temporary)
	            );

	        return http.build();
	    }
}
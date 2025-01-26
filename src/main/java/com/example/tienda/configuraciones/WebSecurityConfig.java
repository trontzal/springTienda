package com.example.tienda.configuraciones;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	// Autenticacion
	@Bean
	UserDetailsService userDetailsService(){
		UserDetails gon =
				User
					.withDefaultPasswordEncoder()
					.username("gon")
					.password("1234")
					.roles("ADMIN")
				.build();
		
		UserDetails pepe = 
				User
					.withDefaultPasswordEncoder()
					.username("user")
					.password("user")
					.roles("USER")
				.build();
				
		return new InMemoryUserDetailsManager(gon, pepe);
	}
	
	// Autorizacion
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeHttpRequests(
					(requests) -> requests
						.requestMatchers("/admin").hasRole("ADMIN")
						.requestMatchers(HttpMethod.POST, "/admin").hasRole("ADMIN")
						.anyRequest().authenticated()
				)
				.formLogin((form) -> form
						.permitAll()
				);
		return http.build();
	}
}

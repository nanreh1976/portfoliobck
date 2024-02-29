package com.example.portfolioapi;

import com.example.portfolioapi.security.JWTAuthorizationFilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SpringBootApplication
public class PortfolioapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioapiApplication.class, args);
	}

    @Bean
    SecurityFilterChain webSecurityConfigSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests(requests -> requests
                        .antMatchers(HttpMethod.GET, "/**").permitAll()
                        .antMatchers(HttpMethod.POST, "/api/login").permitAll()
                        .antMatchers(HttpMethod.POST, "/**").authenticated()
                        .antMatchers(HttpMethod.PUT, "/**").authenticated()
                        .antMatchers(HttpMethod.DELETE, "/**").authenticated());
        return http.build();
        //.anyRequest().authenticated();
    }

}

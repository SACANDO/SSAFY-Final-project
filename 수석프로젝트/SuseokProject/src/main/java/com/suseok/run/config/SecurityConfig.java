//package com.suseok.run.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests(authorizeRequests ->
//                authorizeRequests
//                    .requestMatchers("/", "/login/**", "/oauth2/**").permitAll()
//                    .anyRequest().authenticated()
//            )
//            .oauth2Login(oauth2Login ->
//                oauth2Login
//                    .defaultSuccessUrl("/home", true)
//                    .failureUrl("/login?error=true")
//            );
//
//        return http.build();
//    }
//}

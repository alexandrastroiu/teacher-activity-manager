package com.example.activity_manager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                // CSRF: keep enabled for UI forms, ignore for /api/** (Postman)
                .csrf(csrf -> csrf.ignoringRequestMatchers("/api/**"))

                .authorizeHttpRequests(auth -> auth
                        // static
                        .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()

                        // login page + post endpoint
                        .requestMatchers("/login").permitAll()

                        // keep API open for postman
                        .requestMatchers("/api/**").permitAll()

                        // UI restricted to teachers
                        .requestMatchers("/ui/**").hasRole("TEACHER")

                        .anyRequest().authenticated()
                )

                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")     // POST here
                        .defaultSuccessUrl("/ui/dashboard", true)
                        .failureUrl("/login?error")
                        .permitAll()
                )

                .logout(logout -> logout
                        .logoutUrl("/logout")             // POST /logout
                        .logoutSuccessUrl("/login?logout")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                );

        return http.build();
    }
}

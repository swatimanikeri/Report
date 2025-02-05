package com.project.configurations;





import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class SecurityConfig  {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF for simplicity
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/home", "/css/**", "/js/**", "/images/**","/about").permitAll() // Allow access to home page without login
               .requestMatchers("/AdminLogin/**").hasRole("ADMIN") // Restrict access to admin pages
                .anyRequest().authenticated() // All other requests require authentication
            )
            .formLogin (login -> login
            	
//                .loginPage("/login") // Custom admin login page
              .defaultSuccessUrl("/about", true) // Redirect to admin dashboard after login
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/admin/logout")
                .logoutSuccessUrl("/home") // Redirect to home page after logout
            );
           // .formLogin(Customizer.withDefaults());

        return http.build();
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

	 
            
}
